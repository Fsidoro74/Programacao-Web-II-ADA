package org.example;

// Importa a anotação do Jackson
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Esta anotação diz ao Jackson para não falhar se o JSON tiver campos
// que não listamos aqui (como "gia", "ddd", "siafi", etc.)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Endereco {

    // Os nomes das variáveis TEM QUE SER IGUAIS aos campos do JSON
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade; // "localidade" é o nome do campo para "cidade" no ViaCEP
    private String uf; // "uf" é o nome do campo para "estado"

    // --- Getters e Setters ---
    // O Jackson precisa deles para "preencher" os campos

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    // --- toString() ---
    // Este método é opcional, mas ajuda a imprimir o objeto de forma legível no console
    @Override
    public String toString() {
        return "Endereco {" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }
}
