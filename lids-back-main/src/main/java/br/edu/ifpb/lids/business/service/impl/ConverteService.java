package br.edu.ifpb.lids.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.edu.ifpb.lids.model.entity.Colaborador;
import br.edu.ifpb.lids.model.entity.Coordenador;
import br.edu.ifpb.lids.presentation.dto.ColaboradorDto;
import br.edu.ifpb.lids.presentation.dto.CoordenadorDto;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConverteService {

   
    private final ModelMapper modelMapper;
    
    public ColaboradorDto colaboradorToDto (Colaborador colaborador) {
        ColaboradorDto dto = modelMapper.map(colaborador, ColaboradorDto.class);
        return dto;
    }

    public Colaborador dtoToColaborador (ColaboradorDto dto) {
        Colaborador colaborador = modelMapper.map(dto, Colaborador.class);
        return colaborador;
    }

        public CoordenadorDto coordenadorToDto (Coordenador coordenador) {
        CoordenadorDto dto =  modelMapper.map(coordenador, CoordenadorDto.class);
        return dto;
    }

    public Coordenador dtoToCoordenador (CoordenadorDto dto) {
        Coordenador coordenador = modelMapper.map(dto, Coordenador.class);
        return coordenador;
    }

    public List<ColaboradorDto> colaboradorToDto(List<Colaborador> entities) {
		List<ColaboradorDto> dtos = new ArrayList<>();
		
		for (Colaborador dto : entities) {
			ColaboradorDto entity = colaboradorToDto(dto);
			dtos.add(entity);
		}
		return dtos;
	}

     public List<CoordenadorDto> coordenadorToDto(List<Coordenador> entities) {
		List<CoordenadorDto> dtos = new ArrayList<>();
		
		for (Coordenador dto : entities) {
			CoordenadorDto entity = coordenadorToDto(dto);
			dtos.add(entity);
		}
		return dtos;
	}

    // public UserDto userToDto(SystemUser entity) {
    //      UserDto dto = modelMapper.map(entity, UserDto.class);
    //      return dto;
    // }

    //  public SystemUser dtoToUser(UserDto dto) {
    //     SystemUser entity = modelMapper.map(dto, SystemUser.class);
    //      return entity;
    // }

    // public UserDto converterToDTO(SystemUser user) {
	// 	UserDto dto = new UserDto(user);
	// 	return dto;
    // }

    // public static List<UserDto> converterToDTO(List<SystemUser> users) {
	// 	List<UserDto> dtos = new ArrayList<>();
	// 	for(SystemUser user: users) {
	// 		UserDto dto = new UserDto(user);
	// 		dtos.add(dto);
	// 	}
	// 	return dtos;
	// }


    // public SystemUser converterToUser(UserDto dto) {
	// 	SystemUser user = new SystemUser();
	// 	user.setId(dto.getId());
	// 	user.setUsername(dto.getName());
	// 	user.setEmail(dto.getEmail());
	// 	user.setSenha(dto.getPassword());
	// 	return user;
	// }
}