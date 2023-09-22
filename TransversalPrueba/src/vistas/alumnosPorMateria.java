package vistas;

import Entidades.Alumno;
import Entidades.Materia;
import accesoADatos.AlumnoData;
import accesoADatos.InscripcionData;
import accesoADatos.MateriaData;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class alumnosPorMateria extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };
    private MateriaData materiaData = new MateriaData();
    private AlumnoData alumnoData = new AlumnoData();
    private InscripcionData inscripcionData = new InscripcionData();

    public alumnosPorMateria() {
        initComponents();
        List<Materia> materias = materiaData.ListarMateria();
        for (Materia materia : materias) {
            jcbMaterias.addItem(materia);
        }
        cargarTabla(WIDTH);
        armarCabecera();
        cargarCombo();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbMaterias = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAlumnoPorMateria = new javax.swing.JTable();
        jbSalir = new javax.swing.JButton();

        jLabel1.setText("Listado de Alumnos por Materia");

        jLabel2.setText("Seleccione una materia");

        jcbMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMateriasActionPerformed(evt);
            }
        });

        jtAlumnoPorMateria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtAlumnoPorMateria);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel1)
                .addContainerGap(260, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2)
                        .addGap(58, 58, 58)
                        .addComponent(jcbMaterias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(115, 115, 115))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jbSalir)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMateriasActionPerformed
         
        
          cargarAlumnosInscritosEnMateriaSeleccionada();
//        cargarCombo(); 
//        cargarTabla(WIDTH);

    }//GEN-LAST:event_jcbMateriasActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
      dispose();
    }//GEN-LAST:event_jbSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Materia> jcbMaterias;
    private javax.swing.JTable jtAlumnoPorMateria;
    // End of variables declaration//GEN-END:variables
  
        private void armarCabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("DNI");
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");
        jtAlumnoPorMateria.setModel(modelo);
    }

   private void cargarCombo() {
       
    try {
        Materia selectedMateria = (Materia) jcbMaterias.getSelectedItem();
        System.out.println("Método cargarCombo() llamado"); // Agrega esta línea
    
        if (selectedMateria != null) {
            int idMateria = selectedMateria.getIDmateria(); // Obtén el ID de la materia seleccionada
            cargarTabla(idMateria); // Carga la tabla con el ID de la materia
            
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una materia válida.");
        }
    } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Error al cargar la lista de alumnos por materia: " + e.getMessage());
    
        JOptionPane.showMessageDialog(null, "Error al cargar la lista de alumnos por materia: " + e.getMessage());
    }
}

 private void cargarTabla(int idMateria) {
    DefaultTableModel modelo = (DefaultTableModel) jtAlumnoPorMateria.getModel();
    modelo.setRowCount(0);

    try {
        List<Alumno> alumnosPorMateria = inscripcionData.obtenerAlumnosPorMateria(idMateria);

        for (Alumno alumno : alumnosPorMateria) {
            modelo.addRow(new Object[]{
                alumno.getIDalumno(),
                alumno.getDNI(),
                alumno.getApellido(),
                alumno.getNombre()
            });
        }

        modelo.fireTableDataChanged(); // Forzar la actualización de la vista de la tabla
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al cargar la tabla de alumnos por materia: " + e.getMessage());
    }
     }
private void cargarAlumnosInscritosEnMateriaSeleccionada() {
    DefaultTableModel modelo = (DefaultTableModel) jtAlumnoPorMateria.getModel();
    modelo.setRowCount(0);

    try {
        // busco la materia seleccionada en el JComboBox
        Materia selectedMateria = (Materia) jcbMaterias.getSelectedItem();

        if (selectedMateria != null) {
            // encuentro el ID de la materia seleccionada
            int idMateria = selectedMateria.getIDmateria();

            // Llamo a un método para obtener la lista de alumnos inscritos en la materia
            List<Alumno> alumnosInscritos = inscripcionData.obtenerAlumnosPorMateria(idMateria);

            // Lleno la tabla con los datos de los alumnos inscritos
            for (Alumno alumno : alumnosInscritos) {
                modelo.addRow(new Object[]{
                    alumno.getIDalumno(),
                    alumno.getDNI(),
                    alumno.getApellido(),
                    alumno.getNombre()
                });
            }

            modelo.fireTableDataChanged(); // Fuerzo la actualización de la vista de la tabla
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una materia válida.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al cargar la lista de alumnos por materia: " + e.getMessage());
    }
}

 }
