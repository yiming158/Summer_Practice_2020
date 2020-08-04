import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public abstract class IdealWeight extends WindowAdapter implements ActionListener{
    Frame f;
private static Dialog d;
    IdealWeight(){
        f=new Frame("Ideal Weight calculator");
        f.setBackground(Color.lightGray);
        f.setSize(350,280);
        f.addWindowListener(this);
        f.setLayout(null);
        f.setVisible(true);

        d=new Dialog(f,"Ideal Weight calculator",true);
        d.setLayout(new FlowLayout());
        Label Gender=new Label("Gender");
        Gender.setBounds(50,100,100,25);
        Gender.setBackground(Color.pink);
        f.add(Gender);
        Choice gender=new Choice();
        gender.setBackground(Color.white);
        gender.setBounds(150,100,75,25);
        f.add(gender);
        gender.add("Female");
        gender.add("Male");
        Button result=new Button("Show Result");
        result.setBounds(50,200,100,25);
        result.setBackground(Color.pink);
        f.add(result);
        TextField resultOutPut=new TextField();
        resultOutPut.setBounds(150,200,100,25);
        f.add(resultOutPut);

        Label weight=new Label("weight");
        Label kg=new Label("kg");
        Label height=new Label("height");
        Label cm=new Label("cm");
        height.setBackground(Color.pink);
        TextField tWeight,tHeight;
        tWeight=new TextField();
        tHeight=new TextField();

        tHeight.setBounds(150,150,100,25);
        f.add(tHeight);
        f.add(kg);
        f.add(height);
        f.add(cm);
        kg.setBounds(250,200,50,25);
        height.setBounds(50,150,100,25);
        cm.setBounds(250,150,50,25);
        result.addActionListener ( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                float percentage;
                String g=gender.getItem(gender.getSelectedIndex());
                if(g=="Male"){
                    percentage=0.1f;
                }else{
                    percentage=0.15f;
                }

                /*Men: Ideal Body Weight (kg) = [Height (cm) - 100] - ([Height (cm) - 100] x 10%)

Women: Ideal Body Weight (kg) = [Height (cm) - 100] + ([Height (cm) - 100] x 15%)*/
                float f_height=Float.parseFloat(tHeight.getText());
                float f_result=(f_height-100)-(f_height-100)*percentage;
                String s_result=Float.toString(f_result);
                resultOutPut.setText(s_result);

            }
        });


    }
    public void windowClosing(WindowEvent e) {
        f.dispose();
    }

    public static void main(String[] args) {
        new IdealWeight() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {



            }
        };

    }
}
