package com.Tonycom.reto.Entities;

import jakarta.persistence.*;

@Entity
@Table (name = "Tareas")
public class Tarea {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    private String descripcion;
    private Boolean completada;
    @ManyToOne
    @JoinColumn (name = "proyecto_id")
    private Proyecto proyecto;

    public Tarea() {
    }

    public Tarea(String titulo, String descripcion, Boolean completada, Proyecto proyecto) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completada = completada;
        this.proyecto = proyecto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getCompletada() {
        return completada;
    }

    public void setCompletada(Boolean completada) {
        this.completada = completada;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", completada=" + completada +
                ", proyecto=" + proyecto +
                '}';
    }
}
