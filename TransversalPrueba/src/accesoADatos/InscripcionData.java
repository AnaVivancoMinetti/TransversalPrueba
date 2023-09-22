package accesoADatos;

import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class InscripcionData {

    private Connection con = null;
    private MateriaData matData;
    private AlumnoData AluData;

    public InscripcionData(MateriaData matData, AlumnoData AluData) {
        this.matData = matData;
        this.AluData = AluData;
        con = Conexion.getConexion();
    }

    public InscripcionData() {
        con = Conexion.getConexion();
    }

    public void guardarInscripcion(Inscripcion insc) {
        String sql = "INSERT INTO inscripcion (nota, idAlumno, idMateria) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, insc.getNota());
            ps.setInt(2, insc.getAlumno().getIDalumno());
            ps.setInt(3, insc.getMateria().getIDmateria());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                insc.setIDinscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se guardó la inscripción");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR LA INSCRIPCIÓN");
        }
    }

    public List<Inscripcion> obtenerInscripciones() {
        List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();

        try {
            String sql = "SELECT * FROM inscripcion JOIN materia ON (inscripcion.idMateria=materia.idMateria) JOIN alumno ON (inscripcion.idAlumno = alumno.idAlumno)";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Inscripcion insc = new Inscripcion();
                insc.setNota(rs.getInt("nota"));

                Alumno alumno = new Alumno();
                alumno.setIDalumno(rs.getInt("idAlumno"));
                // También puedes cargar el alumno completo desde AlumnoData si lo necesitas
                insc.setAlumno(alumno);

                Materia materia = new Materia();
                materia.setIDmateria(rs.getInt("idMateria"));
                materia.setNombreMat(rs.getString("nombre"));
                materia.setAnio(rs.getInt("anio"));
                insc.setMateria(materia);

                inscripciones.add(insc);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER LA INSCRIPCIÓN");
        }
        return inscripciones;
    }

    public List<Inscripcion> obtenerInscripcionesPorAlumno(int id) {
        List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();

        try {
            String sql = "SELECT * FROM inscripcion JOIN materia ON (inscripcion.idMateria=materia.idMateria) JOIN alumno ON (inscripcion.idAlumno = alumno.idAlumno) WHERE inscripcion.idAlumno = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Inscripcion insc = new Inscripcion();
                insc.setNota(rs.getInt("nota"));

                Alumno alumno = new Alumno();
                alumno.setIDalumno(rs.getInt("idAlumno"));
                // También puedes cargar el alumno completo desde AlumnoData si lo necesitas
                insc.setAlumno(alumno);

                Materia materia = new Materia();
                materia.setIDmateria(rs.getInt("idMateria"));
                materia.setNombreMat(rs.getString("nombre"));
                materia.setAnio(rs.getInt("anio"));
                insc.setMateria(materia);

                inscripciones.add(insc);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL OBTENER LA INSCRIPCIÓN");
        }
        return inscripciones;
    }

    public List<Materia> obtenerMateriaCursada(int id) {
        List<Materia> materias = new ArrayList<Materia>();

        try {
            String sql = "SELECT inscripcion.idMateria, nombre, anio FROM inscripcion, materia WHERE inscripcion.idMateria=materia.idMateria AND inscripcion.idAlumno=?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Materia mate = new Materia();
                mate.setIDmateria(rs.getInt("idMateria"));
                mate.setNombreMat(rs.getString("nombre"));
                mate.setAnio(rs.getInt("anio"));
                materias.add(mate);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL OBTENER LA MATERIA");
        }
        return materias;
    }

    public List<Materia> obtenerMateriaNoCursada(int id) {
    List<Materia> materiasNoCursadas = new ArrayList<Materia>();

    try {
        String sql = "SELECT * FROM materia WHERE idMateria NOT IN (SELECT idMateria FROM inscripcion WHERE idAlumno = ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Materia mate = new Materia();
            mate.setIDmateria(rs.getInt("idMateria"));
            mate.setNombreMat(rs.getString("nombre"));
            mate.setAnio(rs.getInt("anio"));
            materiasNoCursadas.add(mate);
        }
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "ERROR AL OBTENER LAS MATERIAS NO CURSADAS");
    }
    return materiasNoCursadas;
}
    public List<Alumno> obtenerAlumnosPorMateria(int idMateria) {
    List<Alumno> alumnosPorMateria = new ArrayList<Alumno>();

    try {
        String sql = "SELECT alumno.* FROM inscripcion JOIN alumno ON (inscripcion.idAlumno = alumno.idAlumno) WHERE inscripcion.idMateria = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idMateria);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Alumno alumno = new Alumno();
            alumno.setIDalumno(rs.getInt("idAlumno"));
            alumno.setDNI(rs.getInt("dni"));
            alumno.setApellido(rs.getString("apellido"));
            alumno.setNombre(rs.getString("nombre"));
            // Otros campos de Alumno que necesites cargar

            alumnosPorMateria.add(alumno);
        }
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "ERROR AL OBTENER LOS ALUMNOS POR MATERIA");
    }
    return alumnosPorMateria;
}

}
