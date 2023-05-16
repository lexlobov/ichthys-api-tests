package models.athentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private Boolean isActive;
}
