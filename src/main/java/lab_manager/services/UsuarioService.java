package lab_manager.services;

import lab_manager.entites.usuario.TipoUsuario;
import lab_manager.entites.usuario.Usuario;
import lab_manager.exceptions.usuario.PasswordsNotMatch;
import lab_manager.exceptions.usuario.UserNotFoundException;
import lab_manager.util.PasswordEncoder;

import javax.persistence.EntityManager;
import java.util.List;

public class UsuarioService {
    private EntityManager em;

    public UsuarioService(EntityManager em) {
        this.em = em;
    }

    public boolean verificaSeExiste(long codigo) {
        String hql = "select u.codigo from Usuario u where u.codigo = :codigo";
        Usuario usuario = em.createQuery(hql, Usuario.class)
        .setParameter("codigo", codigo)
        .getSingleResult();
        return usuario != null;
    }

    public Usuario adicionar(Usuario usuario) {
        em.persist(usuario);
        Usuario usuarioAdicionado = em.find(Usuario.class, usuario.getCodigo());
        usuarioAdicionado.setSenha(null);
        return usuarioAdicionado;
    }

    public Usuario login(long codigo, String senha) {
        if (!verificaSeExiste(codigo)) {
            throw new UserNotFoundException("Email ou senha inválido!");
        }
        String hql = "select u.codigo from Usuario u where u.codigo = :codigo and u.senha = :senha";
        Usuario usuarioLogado = em.createQuery(hql, Usuario.class)
                .setParameter("codigo", codigo)
                .setParameter("senha", PasswordEncoder.MD5(senha))
                .getSingleResult();

        if (usuarioLogado == null) {
            throw new UserNotFoundException("Email ou senha inválido!");
        }

        usuarioLogado.setSenha(null);
        return usuarioLogado;
    }

    public Usuario alterarSenha(long codigo, String senha, String novaSenha, String confirmacaoSenha) {
        Usuario usuarioLogado = login(codigo, senha);
        if (!novaSenha.equals(confirmacaoSenha)) {
            throw new PasswordsNotMatch("Senhas não coincidem!");
        }
        usuarioLogado.setSenha(PasswordEncoder.MD5(novaSenha));
        em.persist(usuarioLogado);
        usuarioLogado.setSenha(null);
        return usuarioLogado;
    }

    /**
     * @param filtro Nome ou RM(código)
     * @return Dados mímnimos do usuário (RM e nome)
     * */
    public List<Usuario> buscarDadosMinimos(String filtro) {
        String hql = "select u.codigo, u.nome from Usuario u " +
                "where cast(u.codigo as string) like :filtro% or " +
                "u.nome like :filtro%";
        return em.createQuery(hql, Usuario.class)
                .setParameter("filtro", filtro)
                .getResultList();
    }

    /**
     * @param filtro Nome ou RM(código)
     * @param tipo tipo do usuário
     * @return Dados mímnimos do usuário (RM e nome)
     * */
    public List<Usuario> buscarDadosMinimos(String filtro, TipoUsuario tipo) {
        String hql = "select u.codigo, u.nome from Usuario u " +
                "where u.tipoUsuario.codigo = :tipo ";
        if (!filtro.isEmpty()) {
            hql += "and (cast(u.codigo as string) like :filtro% or " +
            "u.nome like :filtro%)";
        }
        return em.createQuery(hql, Usuario.class)
                .setParameter("filtro", filtro)
                .setParameter("tipo", tipo.getCodigo())
                .getResultList();
    }

    public void alterarImagem(Usuario usuario, String img) {
        usuario.setImagem(img);
        em.persist(usuario);
    }
}
