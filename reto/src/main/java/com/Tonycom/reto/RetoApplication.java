package com.Tonycom.reto;

import com.Tonycom.reto.Repositories.ProyectoRepository;
import com.Tonycom.reto.Repositories.TareaRepository;
import com.Tonycom.reto.Entities.Proyecto;
import com.Tonycom.reto.Entities.Tarea;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class RetoApplication {

	public static void main(String[] args) {

		ApplicationContext spring = SpringApplication.run(RetoApplication.class, args);
		ProyectoRepository proyectoRepository = spring.getBean (ProyectoRepository.class);


		Proyecto proyecto1 = new Proyecto("Cocinar", "preparar plato", LocalDate.of(2025, 03, 12),false);
		Proyecto proyecto2 = new Proyecto("EjercicioClase", "resolver reto de clase", LocalDate.of(2025, 05, 20), true);

		TareaRepository tareaRepository = spring.getBean(TareaRepository.class);

		Tarea tarea1 = new Tarea("Comprar comida", "ir al mercado y comprar", false, proyecto1);
		Tarea tarea2 = new Tarea("Leer ejercicio", "Comprender los requisitos del reto", false, proyecto2);
		Tarea tarea3 = new Tarea("Cortar Verduras", "limpiar y cortar verduras", false, proyecto1);
		Tarea tarea4 = new Tarea("Crear entidades", "escribir codigo para crear una entidad",false, proyecto2);
		Tarea tarea5 = new Tarea("Poner al fuego", "freir y aderezar verduras", true, proyecto1);

		proyectoRepository.saveAll(List.of(proyecto1, proyecto2));
		tareaRepository.saveAll(List.of(tarea1, tarea2, tarea3, tarea4, tarea5));

        String nombreProyectoBuscado = "Cocinar";
		Proyecto proyectoEncontrado = proyectoRepository.findByNombre(nombreProyectoBuscado);
		if (proyectoEncontrado != null){
			System.out.println("Proyecto encontrado por nombre: " + proyectoEncontrado.getNombre());
		}else {
			System.out.println("No se ha encontrado el proyecto con el nombre: " + nombreProyectoBuscado);
		}



		LocalDate fechaInicio = proyecto1.getFechaInicio();
		List<Proyecto> proyectosEncontrados = proyectoRepository.findByFechaInicio(fechaInicio);
		if (proyectosEncontrados.isEmpty()){
			System.out.println("No se han encontrado proyectos con la fecha de inicio: " + proyectosEncontrados);
		}else {
			System.out.println("Los proyectos encontrados por fecha" + fechaInicio + " son: ");
		for (Proyecto proyectos : proyectosEncontrados) {

			System.out.println(proyectosEncontrados);
		}

		}
		List<Proyecto> proyectosActivos = proyectoRepository.findByActivoTrue();
		if (proyectosActivos.isEmpty()){
			System.out.println("No se han encontrado proyectos activos");
		}
		System.out.println("Estos son los proyectos activos: ");
		for (Proyecto proyectos : proyectosActivos) {
			System.out.println(proyectos.getNombre());
		}

		String tareaBuscada = "Cortar Verduras";
			List<Tarea> tareasTitulo = tareaRepository.findByTitulo(tareaBuscada);
			if (tareasTitulo.isEmpty()){
				System.out.println("No se ha encontrado la tarea buscada");
			}else {
				System.out.println("La tarea encontrada es la siguiente: " + tareasTitulo);
			}


		List<Tarea> tareasNoCompletadas = tareaRepository.findByCompletadaFalse();
		if (tareasNoCompletadas.isEmpty()){
			System.out.println("No se han encontrado tareas no completadas");
		}else{
		System.out.println("Las tareas no completadas son: ");
		for (Tarea tareas : tareasNoCompletadas) {
			System.out.println(tareas.getTitulo());
		}
		}

		Proyecto proyecto = proyecto1;
		List<Tarea> tareasPorProyecto = tareaRepository.findByProyecto(proyecto);
		if (tareasPorProyecto.isEmpty()){
			System.out.println("No se han encontrado tareas en este proyecto");
		}else{

			System.out.println("Las tareas pertenecientes al proyecto1 son: ");
		for (Tarea tareas : tareasPorProyecto) {
			System.out.println(tareas.getTitulo());
		}
		}




	}


}
