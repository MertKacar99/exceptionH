package com.merkacar.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private  MessageType type;
    private String ofStatic;
    public String prepareErrorMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append(type.getCode() +"- " + type.getMessage() );
        if (ofStatic != null) {
            builder.append(" - ");
            builder.append(ofStatic);
        }
        return builder.toString();
    }
}
