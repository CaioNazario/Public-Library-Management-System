package com.example.library_api.model; // (mesmo pacote das outras entidades)

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "emprestimos")
public class Loan { // "Loan" = Empréstimo

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Muitos Empréstimos podem ser de UM Usuário
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Muitos Empréstimos podem ser do MESMO Livro
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(name = "data_emprestimo", nullable = false)
    private LocalDate loanDate;

    @Column(name = "data_devolucao", nullable = false)
    private LocalDate dueDate; // "Due date" = Data limite de devolução

    @Column(name = "devolvido", nullable = false)
    private boolean returned; // (false = emprestado, true = devolvido)

    // Getters e Setters (Lombok ou manual)
    // ...
}