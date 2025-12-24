package com.vn32.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
@Data
Lombok automatically generates a bunch of commonly used methods for you:
Getters for all fields
Setters for all non-final fields
toString() method
equals() and hashCode() methods
RequiredArgsConstructor
 */

/*
@Schema
OpenAPI specification annotations. API Documentation
You use it on classes or fields to provide metadata about how they should appear in the generated API docs.
It helps tools like Swagger UI show clear descriptions, examples, and constraints for your models.
 */

@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
//lombok annotation
@Data @AllArgsConstructor @NoArgsConstructor
public class AccountsDto {
    @NotEmpty(message = "AccountNumber can not be a null or empty")
    @Pattern(regexp="(^$|[0-9]{10})",message = "AccountNumber must be 10 digits")
    @Schema(
            description = "Account Number of Eazy Bank account", example = "3454433243"
    )
    private Long accountNumber;

    @NotEmpty(message = "AccountType can not be a null or empty")
    @Schema(
            description = "Account type of Eazy Bank account", example = "Savings"
    )
    private String accountType;

    @NotEmpty(message = "BranchAddress can not be a null or empty")
    @Schema(
            description = "Eazy Bank branch address", example = "123 NewYork"
    )
    private String branchAddress;
}
