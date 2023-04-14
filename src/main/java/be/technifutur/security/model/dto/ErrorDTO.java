package be.technifutur.security.model.dto;

import lombok.Getter;
import org.springframework.http.HttpMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class ErrorDTO {

    private final List<Error> errors;
    private final String URI;
    private final HttpMethod method;

    private ErrorDTO(List<Error> errors, String uri, HttpMethod method) {
        this.errors = errors;
        this.URI = uri;
        this.method = method;
    }

    @Getter
    public static class Error {

        private final String message;
        private final String name;

        private Error(String message, String name){
            this.message = message;
            this.name = name;
        }

        public static Error from(String message, String name){
            return new Error(message, name);
        }

    }

    public static Builder builder(String URI, HttpMethod method){
        return new Builder(URI, method);
    }

    public static class Builder {

        private final List<Error> errors = new ArrayList<>();
        private final String URI;
        private final HttpMethod method;

        Builder(String URI, HttpMethod method){
            this.URI = URI;
            this.method = method;
        }

        public Builder add(Error error){
            errors.add(error);
            return this;
        }

        public ErrorDTO build(){
            return new ErrorDTO(Collections.unmodifiableList(errors), URI, method);
        }

    }

}
