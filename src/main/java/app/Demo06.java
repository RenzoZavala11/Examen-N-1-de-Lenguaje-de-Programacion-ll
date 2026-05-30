package app;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Solicitud;

public class Demo06 {

	public static void main(String[] args) {
		// Establecemos conexión con la base de datos
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlconexion");

		// Implementamos un manager
		EntityManager manager = factory.createEntityManager();

		// Iniciamos proceso
		try {
			String jpql = "select s from Solicitud s";
			
			List<Solicitud> lstSolicitud = manager.createQuery(jpql, Solicitud.class).getResultList();
			
			StringBuilder sb = new StringBuilder();
			sb.append("LISTADO DE SOLICITUDES:\n");
						
			for (Solicitud solicitud : lstSolicitud) {	
				
				sb.append("Nro Solicitud.......: " + solicitud.getNroSolicitud() + "\n");
				sb.append("Fecha Registro......: " + solicitud.getFechaReg() + "\n");
				sb.append("Actividad...........: " + solicitud.getActividad().getDescripcion() + "\n");
				sb.append("Fecha Inicio........: " + solicitud.getActividad().getFechaInicio() + "\n");
				sb.append("Nro Vacantes........: " + solicitud.getActividad().getNroVacantes() + "\n");
				sb.append("Categoria...........: " + solicitud.getActividad().getCategoria().getDescripcion() + "\n");
				sb.append("Archivo Adjunto.....: " + solicitud.getArchivoAdjunto() + "\n");
				sb.append("Estado..............: " + solicitud.getEstado() + "\n");
				sb.append("---------------------------------\n\n");
			}
			
			System.out.println(sb);

		} catch (Exception e) {
			System.out.println("Hubo un error en la transacción");
			e.printStackTrace();
		} finally {
			manager.close();
			factory.close();
		}
	}

}
