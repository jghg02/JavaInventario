package View;

import Controller.ProductController;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.synth.SynthTextAreaUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Created by jhgonzalez on 7/23/17.
 */
public class FormsView {
    public JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JTabbedPane tabbedPane3;
    private JTabbedPane tabbedPane4;
    private JTextField name;
    private JTextField category;
    private JTextField price;
    private JTextArea description;
    private JButton saveProductButton;
    private JRadioButton radio1;
    private JRadioButton radio;

    public FormsView() {

        saveProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ProductController productController = new ProductController();
                productController.saveProduct(name.getText(),description.getText(),category.getText(),price.getText());

            }
        });


        radio1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radio.setEnabled(false);
            }
        });
    }


}
