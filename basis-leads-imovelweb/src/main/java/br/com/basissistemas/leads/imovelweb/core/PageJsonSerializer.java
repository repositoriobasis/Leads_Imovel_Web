package br.com.basissistemas.leads.imovelweb.core;

import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.data.domain.Page;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@JsonComponent
public class PageJsonSerializer extends JsonSerializer<Page<?>> {

	@Override
	public void serialize(Page<?> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
gen.writeStartObject();
		
		gen.writeObjectField("content", value.getContent());
		gen.writeNumberField("size", value.getSize());
		gen.writeNumberField("total", value.getTotalElements());
		gen.writeNumberField("number", value.getNumber());
		
		gen.writeEndObject();
		
	}

}
