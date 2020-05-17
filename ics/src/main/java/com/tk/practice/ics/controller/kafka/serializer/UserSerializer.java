package com.tk.practice.ics.controller.kafka.serializer;

import com.google.gson.Gson;
import com.tk.practice.ics.domain.User;
import org.apache.kafka.common.serialization.Serializer;

public class UserSerializer implements Serializer<User> {

    private static final Gson GSON = new Gson();

    @Override
    public byte[] serialize(final String s, final User user) {
        return GSON.toJson(user).getBytes();
    }

}
