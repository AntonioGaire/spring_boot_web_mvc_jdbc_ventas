package org.iesvdm.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.iesvdm.modelo.Comercial;
import org.iesvdm.DTO.ComercialDTOMS;

@Mapper(componentModel="spring")
public interface ComercialMapper {
 
	@Mapping(target="pedidosRealizados", source="pedidosRealizadosIn")
	public ComercialDTOMS ComercialAComercialDTOMS(Comercial comercial, int pedidosRealizadosIn);

	public Comercial ComercialDTOMSAComercial(ComercialDTOMS comercial);
}
