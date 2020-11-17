package org.generation.blogPessoal.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.generation.blogPessoal.model.UserLogin;
import org.generation.blogPessoal.model.Usuario;
import org.generation.blogPessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository  repository;
	public Usuario Cadastrarusuario (Usuario usuario) {
		BCryptPasswordEncoder encorder =new BCryptPasswordEncoder();
		
		String senhaEncoder = encorder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);
		return repository.save(usuario);
	}
		public Optional <UserLogin> Logar (Optional<UserLogin> user){
			BCryptPasswordEncoder encorder =new BCryptPasswordEncoder();
			Optional<Usuario> usuario = repository.FindByUsuario(user.get().getUsuario());
			
			if (usuario.isPresent()) {
				if(encorder.matches(user.get().getSenha(),usuario.get().getSenha())) {
					String auth = user.get().getUsuario() +":" + user.get ().getSenha();
					byte[]	encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-AsCII")));		
					String authHeader ="Basic " + new String (encodedAuth);
					
					user.get().setToken (authHeader);
					user.get ().setNome(usuario.get().getNome());
					
					return user;
					
					
			}
		}
			return null;
}
}