package dev.SpringCache.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class CustomerDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "customer_id")
    private Long id;

    @JsonProperty(value = "customer_name")
    private String customerName;

}
