package org.iesvdm.mapstruct;

import java.util.List;

import org.iesvdm.DTO.ClienteDTOMS;
import org.iesvdm.DTO.ComercialDTOMS;
import org.iesvdm.modelo.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")

public interface ClienteMapper {

	@Mapping(target="comercialesAsociados", source="comercialesAsociadosIN")
	@Mapping(target="pedidosTrimestre", source="pedidosTrimestreIN")
	@Mapping(target="pedidosSemestre", source="pedidosSemestreIN")
	@Mapping(target="pedidosYear", source="pedidosYearIN")
	@Mapping(target="pedidosLustro", source="pedidosLustroIN")
	
	public ClienteDTOMS ClienteAClienteDTOMS(Cliente cliente, 
			List<ComercialDTOMS> comercialesAsociadosIN, 
			int pedidosTrimestreIN,
			int pedidosSemestreIN,
			int pedidosYearIN,
			int pedidosLustroIN);


}
