/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdraft;

import java.util.Scanner;
import static appdraft.MentorsList.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultListModel;

/**
 *
 * @author saman
 */
public class DisplayEvents extends javax.swing.JPanel {

    /**
     * Creates new form DisplayEvents
     */
    
    
    public ArrayList<String> events;
    public SQLDatabase database;
    private AppDraftGUI frameInstance;
    public String[] eventsInfo;
    
    public DisplayEvents(AppDraftGUI frameInstance) {
        initComponents();
        database = SQLDatabase.getInstance();
        this.frameInstance = frameInstance;
    }
    
    /*public void test(){
        for (int i = 0; i < this.events.size(); i++) {
            System.out.println(this.events.get(i));
        }
    }*/
    
    //sets arraylist as all the events the mentor selected has inputted 
    //(passes SQLDatabase method getEArrayList(int id))
    public void setEArrayList(ArrayList<String> y){
        this.events = y;
    }
    
    //converts events arraylist to eventsInfo array
    public void convertEArray(){
        this.eventsInfo = new String[this.events.size()];
        for (int i = 0; i < this.events.size(); i++) {
            this.eventsInfo[i] = this.events.get(i);
        }
    }
    
    //displays events of current mentor in the JList
    public void populateEList (int currentID){
        setEArrayList(database.getEventsList(currentID));
        convertEArray();
        DefaultListModel dlm = new DefaultListModel();
        for (int i = 0; i < this.eventsInfo.length; i++) {
            dlm.addElement(this.eventsInfo[i]);
        }
        eventsList.setModel(dlm);   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mentorLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        eventsList = new javax.swing.JList<>();
        backBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(170, 212, 212));

        mentorLbl.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        mentorLbl.setText("Events: ");

        eventsList.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        eventsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(eventsList);

        backBtn.setBackground(new java.awt.Color(255, 255, 255));
        backBtn.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        backBtn.setText("Back");
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(214, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mentorLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backBtn)
                        .addGap(77, 77, 77))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mentorLbl)
                    .addComponent(backBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseClicked
        ((AppDraftGUI) this.getRootPane().getParent()).showPanel(2);
        Arrays.fill(this.eventsInfo, null);
        this.events.clear();
        
    }//GEN-LAST:event_backBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JList<String> eventsList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mentorLbl;
    // End of variables declaration//GEN-END:variables
}