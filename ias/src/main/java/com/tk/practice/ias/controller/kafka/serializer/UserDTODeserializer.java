package com.tk.practice.ias.controller.kafka.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tk.practice.ias.service.dto.UserDTO;
import org.apache.kafka.common.serialization.Deserializer;

public class UserDTODeserializer implements Deserializer<UserDTO> {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    public UserDTO deserialize(final String s, final byte[] bytes) {
        var content = new String(bytes);
        try {
            return OBJECT_MAPPER.readValue(content, UserDTO.class);
        } catch (final JsonProcessingException e) {
            throw new RuntimeException("An error occurred in deserializing a message", e);
        }
    }

}

