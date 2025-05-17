package com.Tonycom.reto.Repositories;

import com.Tonycom.reto.Entities.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

    @Query("select p from Proyecto p where p.activo = true")
    List<Proyecto> findByActivoTrue();

    Proyecto findByNombre(String nombre);


    List<Proyecto> findByFechaInicio(LocalDate fechaInicio);




}