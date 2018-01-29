/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageSorter;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author dougthompson
 */
public class CustomActionsDialog extends javax.swing.JDialog {

    /**
     * Creates new form CustomActionsDialog
     */
    public CustomActionsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        parentFrame = (ImageSorterFrame) parent;
        initComponents();
        initMyComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButtonCancel = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonAddCustomAction = new javax.swing.JButton();
        jLabelSaveStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jButtonCancel.setText("Close");
        jButtonCancel.setToolTipText("Close this window and update the form");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jButtonSave.setText("Save");
        jButtonSave.setToolTipText("Save any changes you may have made");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonAddCustomAction.setText("Add Custom Location");
        jButtonAddCustomAction.setToolTipText("Add a new directory to copy files to");
        jButtonAddCustomAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddCustomActionActionPerformed(evt);
            }
        });

        jLabelSaveStatus.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabelSaveStatus.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonAddCustomAction)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 372, Short.MAX_VALUE)
                        .addComponent(jLabelSaveStatus)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancel)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonCancel)
                        .addComponent(jButtonSave)
                        .addComponent(jLabelSaveStatus))
                    .addComponent(jButtonAddCustomAction, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        saveCustomActions(sourceFileName);
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonAddCustomActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddCustomActionActionPerformed
        CustomAction customAction = new CustomAction(true, "", Paths.get(""));
        customActions.add(customAction);
        selectDir(customAction);
        saveCustomActions(sourceFileName);
    }//GEN-LAST:event_jButtonAddCustomActionActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomActionsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomActionsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomActionsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomActionsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CustomActionsDialog dialog = new CustomActionsDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddCustomAction;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLabelSaveStatus;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    ImageSorterFrame parentFrame;
    private String homeDir; // = parentFrame.getHomeDir(); // System.getProperty("user.home");
    private String appName; // = parentFrame.getAppName(); //"ImageSorter";
    private List<CustomAction> customActions = new ArrayList<>();
    private final String sourceFileName = "imageSorterCustomActions.txt";
    
    private void initMyComponents() {
        homeDir = parentFrame.getHomeDir(); // System.getProperty("user.home");
        appName = parentFrame.getAppName(); //"ImageSorter";
        loadCustomActions(sourceFileName);
        initCustomActionComponents();
        showStatusLabel.start();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Init Components">
    private void initCustomActionComponents() {
        //Need to add components to the grid layout based on what has been saved...
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        
        jPanel1.removeAll();
        
        int maxHeight = 300;
        
        if (!customActions.isEmpty()) {
            JLabel enabledLabel = new JLabel("Enabled");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
            jPanel1.add(enabledLabel, gridBagConstraints);

            JLabel nameLabel = new JLabel("Button Name");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
            jPanel1.add(nameLabel, gridBagConstraints);

            JLabel dirLabel = new JLabel("Directory To Copy File To");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 2;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
            jPanel1.add(dirLabel, gridBagConstraints);

            JLabel elipsesLabel = new JLabel("Browse");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 3;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
            jPanel1.add(elipsesLabel, gridBagConstraints);

            JLabel removeLabel = new JLabel("Remove");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 4;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
            jPanel1.add(removeLabel, gridBagConstraints);
        }
        
        int offset = 1;
        for (int i = 0; i < customActions.size(); i ++) {
            CustomAction customAction = customActions.get(i);
            
            JCheckBox checkBoxItem = new JCheckBox();
            checkBoxItem.setSelected(customAction.enabled);
            checkBoxItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    customAction.enabled = checkBoxItem.isSelected();
                }
            });
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = i + offset;
            gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
            jPanel1.add(checkBoxItem, gridBagConstraints);
            
            JTextField nameItem = customAction.nameTextField;
            if (nameItem == null) {
                nameItem = new JTextField();
                nameItem.setText(customAction.name);
                nameItem.setPreferredSize(new java.awt.Dimension(150, 28));
            }
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = i + offset;
            gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
            jPanel1.add(nameItem, gridBagConstraints);
            customAction.nameTextField = nameItem;

            JTextField directoryItem = new JTextField();
            directoryItem.setText(customAction.directory.toString());
            directoryItem.setPreferredSize(new java.awt.Dimension(400, 28));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 2;
            gridBagConstraints.gridy = i + offset;
            gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx = 1.0; 
            jPanel1.add(directoryItem, gridBagConstraints);
            
            JButton browseButton = new JButton();
            browseButton.setText("...");
            browseButton.setPreferredSize(new java.awt.Dimension(40, 29));
            browseButton.addActionListener(new ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    //Here's the code for browsing based on the current directory value
                        //or previous value if it exists...
                    selectDir(customAction);
                }
            });
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 3;
            gridBagConstraints.gridy = i + offset;
            gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
            jPanel1.add(browseButton, gridBagConstraints);
            
            JButton removeButton = new JButton();
            removeButton.setText("X");
            removeButton.setForeground(new Color(255, 0, 0));
            removeButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    //Here's the code for removing this one
                    removeAction(customAction);
                }
            });
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 4;
            gridBagConstraints.gridy = i + offset;
            gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
            jPanel1.add(removeButton, gridBagConstraints);
        }

        jPanel1.revalidate();
        jPanel1.repaint();
        jPanel2.revalidate();
        jPanel2.repaint();
        jScrollPane1.revalidate();
        jScrollPane1.repaint();
        
        pack();
    }
    // </editor-fold>
    
    private void selectDir(CustomAction customAction) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        String selectedDir = customAction.directory.toString();
        if ((selectedDir == null || selectedDir.isEmpty())
                && customActions.size() > 1) {
            //Get the last one in the customActions list before this new one just added
            selectedDir = customActions.get(customActions.size() - 2).directory.toString();
        }
        Path currPath = null;
        if (selectedDir != null) {
            currPath = Paths.get(selectedDir);
        }
        if (currPath != null) {
            chooser.setCurrentDirectory(currPath.toFile());
        }
        int returnValue = chooser.showDialog(this, "Select Dir");
        switch(returnValue) {
            case JFileChooser.CANCEL_OPTION:
                return;
            case JFileChooser.ERROR_OPTION:
                JOptionPane.showMessageDialog(this, "There was an error", "Error Selecting Directory", JOptionPane.OK_OPTION);
                return;
            case JFileChooser.APPROVE_OPTION:
                break;
        }
        File dirItem = chooser.getSelectedFile();
        Path newPath = dirItem.toPath();
        
        if (newPath != null) {
            //Add it to the list and refresh the combo box
            //comboList.add(0, newPath);
            //populateComboBox(comboList, comboBox, 0);
            customAction.directory = newPath;
            if (customAction.name == null || customAction.name.isEmpty()) {
                customAction.name = newPath.getFileName().toString();
            }
        }
        initCustomActionComponents();
    }
    
    private void removeAction(CustomAction customAction) {
        customActions.remove(customAction);
        saveCustomActions(sourceFileName);
        initCustomActionComponents();
    }
    
    public class CustomAction {
        boolean enabled = true;
        String name;
        Path directory;
        JTextField nameTextField;

        public CustomAction(boolean enabled, String name, Path directory) {
            this.enabled = enabled;
            this.name = name;
            this.directory = directory;
        }

        @Override
        public String toString() {
            if (name != null && !name.trim().isEmpty()) {
                return name;
            } else {
                return "Not Named";
            }
        }
        
        
    }
    
    private void saveCustomActions(String fileName) {
        StringBuffer stringToWrite = new StringBuffer("");
        for (CustomAction customAction : customActions) {
            customAction.name = customAction.nameTextField.getText();
            stringToWrite.append(customAction.enabled).append(",").append(customAction.name).append(",").append(customAction.directory.toString()).append("\n");
        }        
        Path fileDest = Paths.get(homeDir, appName, fileName);
        try {
            FileUtilities.writeStringToFile(fileDest, stringToWrite, false);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Problem saving custom actions:  " + ex.getMessage(), 
                    "Issue Saving Custom Actions", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        jLabelSaveStatus.setText("Changes Saved...");
        showStatus = true;
    }        
    
    private int loadCustomActions(String fileName) {
        int selectedIndex = -10;
        try {
            ArrayList<String> directoriesList = FileUtilities.readLinesFromFile(Paths.get(homeDir, appName, fileName));
            customActions.clear();
            for (String pref : directoriesList) {
                String[] customAction = pref.split(",");
                boolean required = true;
                int nameIndex = 0;
                if (customAction.length > 2) {
                    required = Boolean.parseBoolean(customAction[0]);
                    nameIndex = 1;
                }
                customActions.add(new CustomAction(required, customAction[nameIndex], Paths.get(customAction[nameIndex + 1])));
            }
        } catch (Exception ex2) {
            ex2.printStackTrace();
        }        
        return selectedIndex;
    }
    
    public void saveSortedActions() {
        saveCustomActions(sourceFileName);
        initCustomActionComponents();
    }
    
    public List<CustomAction> getCustomActions() {
        return customActions;
    }
    
    private int alpha = 255;
    private int alphaCounter = 0;
    private int increment = -5;
    private boolean showStatus = false;

    Timer showStatusLabel = new Timer(10, new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          if (showStatus) {
              alpha = 0;
              alphaCounter = 0;
              increment = 5;
              showStatus = false;
          }
        alphaCounter += increment;
        if (alphaCounter > 255) {
            alpha = 255;
            if (alphaCounter > 400) {
                increment = -5;
                //alphaCounter = 255;
            }
        } else if (alphaCounter < 0) {
            alpha = 0;
            increment = 0;
        } else {
            alpha = alphaCounter;
        }
        jLabelSaveStatus.setForeground(new Color(0, 102, 0, alpha));
      }
    });
    
}
