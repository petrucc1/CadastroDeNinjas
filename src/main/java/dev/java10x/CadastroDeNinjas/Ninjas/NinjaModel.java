package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

// JPA - Java Persistence API
// Entity transforma uma classe em uma entidade do BD.
@Entity
@Table(name = "tb_cadastro_de_ninjas")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "missoes") // Evita loop infinito na hora de imprimir o objeto
public class NinjaModel {
    // Attributes
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    private int idade;

    @Column(name = "ranking")
    private String ranking;

    @ManyToOne // Um ninja só pode ter uma missão
    @JoinColumn(name ="missoes_id") // Foreign Key - Chave Estrangeira - Traz dados de outra tabela
    private MissoesModel missoes;


}
