package com.vs.models.request;

import io.reactivex.functions.Consumer;
import lombok.Builder;

@Builder
public class CreatePetStoreUser2_usingLambdasBuilderDesign {
    //using lambdas builder method
    int id;
    String username;
    String firstName;
    String lastName;
    String email;
    String password;
    String phone;
    int userStatus;

    // Private constructor to prevent direct instantiation
    private CreatePetStoreUser2_usingLambdasBuilderDesign() {}

    // Builder class
    public static class Builder {
        private final CreatePetStoreUser2_usingLambdasBuilderDesign user;

        public Builder() {
            user = new CreatePetStoreUser2_usingLambdasBuilderDesign();
        }

        public Builder with(Consumer<Builder> builderFunction) {
            try {
                builderFunction.accept(this);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return this;
        }

        public CreatePetStoreUser2_usingLambdasBuilderDesign build() {
            return user;
        }

        public Builder id(int id) {
            user.id = id;
            return this;
        }

        public Builder username(String username) {
            user.username = username;
            return this;
        }

        public Builder firstName(String firstName) {
            user.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            user.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            user.email = email;
            return this;
        }

        public Builder password(String password) {
            user.password = password;
            return this;
        }

        public Builder phone(String phone) {
            user.phone = phone;
            return this;
        }

        public Builder userStatus(int userStatus) {
            user.userStatus = userStatus;
            return this;
        }
    }
}
