package com.korit.servletstudy.login;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletContext;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users;

    public UserRepository(ServletContext context) {
        String realPath = context.getRealPath("/WEF-INF/users.jason");
        try(FileReader fileReader = new FileReader(realPath)) {

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            ObjectMapper objectMapper = new ObjectMapper();
            this.users = objectMapper.readValue(stringBuilder.toString(), List.class);

        } catch (IOException e) {

        }

    }

    public User save() {
        return null;
    }

    public User findById(int id) {
        return null;
    }

    public User findByUsername(String username) {
        return null;
    }

    public List<User> findByAll() {
        return List.of();
    }
}
