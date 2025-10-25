package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ProductsResponse {
    private List<Product> products;
    private int total;
    private int skip;
    private int limit;
}
