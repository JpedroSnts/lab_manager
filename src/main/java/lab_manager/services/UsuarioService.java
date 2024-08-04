package lab_manager.services;

import lab_manager.entites.usuario.TipoUsuario;
import lab_manager.entites.usuario.Usuario;
import lab_manager.exceptions.usuario.PasswordsNotMatch;
import lab_manager.exceptions.usuario.UserNotFoundException;
import lab_manager.util.PasswordEncoder;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UsuarioService {
    private EntityManager em;

    public UsuarioService(EntityManager em) {
        this.em = em;
    }

    public boolean verificaSeExiste(long codigo) {
        String hql = "select u.codigo from Usuario u where u.codigo = :codigo";
        Long codReturn = em.createQuery(hql, Long.class)
        .setParameter("codigo", codigo)
        .getSingleResult();
        return codReturn != null;
    }

    public Usuario adicionar(Usuario usuario) {
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.clear();
        Usuario usuarioAdicionado = em.find(Usuario.class, usuario.getCodigo());
        usuarioAdicionado.setSenha(null);
        return usuarioAdicionado;
    }

    public Usuario login(long codigo, String senha) {
        if (!verificaSeExiste(codigo)) {
            throw new UserNotFoundException("Email ou senha inválido!");
        }
        String hql = "select u from Usuario u where u.codigo = :codigo and u.senha = :senha";
        try {
            Usuario usuarioLogado = em.createQuery(hql, Usuario.class)
                    .setParameter("codigo", codigo)
                    .setParameter("senha", PasswordEncoder.MD5(senha))
                    .getSingleResult();
            usuarioLogado.setSenha(null);
            return usuarioLogado;
        } catch (Exception e) {
            throw new UserNotFoundException("Email ou senha inválido!");
        }
    }

    public Usuario alterarSenha(long codigo, String senha, String novaSenha, String confirmacaoSenha) {
        Usuario usuarioLogado = login(codigo, senha);
        if (!novaSenha.equals(confirmacaoSenha)) {
            throw new PasswordsNotMatch("Senhas não coincidem!");
        }
        usuarioLogado.setSenha(PasswordEncoder.MD5(novaSenha));
        em.getTransaction().begin();
        em.persist(usuarioLogado);
        em.getTransaction().commit();
        em.clear();
        usuarioLogado.setSenha(null);
        return usuarioLogado;
    }

    /**
     * @param filtro Nome ou RM(código)
     * @return Dados mímnimos do usuário (RM e nome)
     * */
    public List<Usuario> buscarDadosMinimos(String filtro) {
        String hql = "select u.codigo, u.nome from Usuario u " +
                     "where cast(u.codigo as string) like :filtro " +
                     "or u.nome like :filtro";
        return em.createQuery(hql, Object[].class)
                .setParameter("filtro", filtro + "%")
                .getResultList().stream().map(
                        objects -> new Usuario((Long) objects[0], (String) objects[1], null, null, null, null)
                ).toList();
    }

    /**
     * @param filtro Nome ou RM(código)
     * @param tipo tipo do usuário
     * @return Dados mímnimos do usuário (RM e nome)
     * */
    public List<Usuario> buscarDadosMinimos(String filtro, TipoUsuario tipo) {
        TypedQuery<Object[]> query = null;
        String hql = "select u.codigo, u.nome from Usuario u " +
                "where u.tipoUsuario.codigo = :tipo ";
        query = em.createQuery(hql, Object[].class)
                .setParameter("tipo", tipo.getCodigo());
        if (!filtro.isEmpty()) {
            hql += "and (cast(u.codigo as string) like :filtro or " +
            "u.nome like :filtro)";
            query = em.createQuery(hql, Object[].class)
                    .setParameter("filtro", filtro + "%")
                    .setParameter("tipo", tipo.getCodigo());
        }
        return query.getResultList().stream().map(
                        objects -> new Usuario((Long) objects[0], (String) objects[1], null, null, null, null)
                ).toList();
    }

    public void alterarImagem(Usuario usuario, String img) {
        usuario = em.find(Usuario.class, usuario.getCodigo());
        usuario.setImagem(img);
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.clear();
    }
}
