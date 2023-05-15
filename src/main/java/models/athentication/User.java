package models.athentication;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private String id;
    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
    private String role;
    private String description;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;
    private boolean isActive;
}
