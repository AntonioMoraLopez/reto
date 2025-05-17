package com.Tonycom.reto.Repositories;

import com.Tonycom.reto.Entities.Proyecto;
import com.Tonycom.reto.Entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TareaRepository extends JpaRepository<Tarea, Long> {


  List<Tarea> findByTitulo(String titulo);

  List<Tarea> findByCompletadaFalse();


  @Query("select t from Tarea t where t.proyecto = ?1")
  List<Tarea> findByProyecto(Proyecto proyecto);


}