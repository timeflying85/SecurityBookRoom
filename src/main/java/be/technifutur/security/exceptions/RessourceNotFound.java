package be.technifutur.security.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RessourceNotFound extends ResponseStatusException {

    private final Class<?> resourceType;

    public RessourceNotFound(Class<?> resourceType) {
        super(HttpStatus.NOT_FOUND, resourceType.getSimpleName() + " could not be found");
        this.resourceType = resourceType;
    }

    public Class<?> getResourceType() {
        return resourceType;
    }

}
