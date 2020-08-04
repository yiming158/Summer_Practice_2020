import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static java.awt.Color.blue;
import static java.awt.Color.pink;

public class DailyWaterIntakeCalculator extends JFrame implements ItemListener, ActionListener {
    private static JDialog d;
    static JFrame f;
    static JComboBox activity;
    static JLabel weight,activityLevel,age;
    static JButton result;
    static JTextField WEIGHT,AGE,RESULT;

    DailyWaterIntakeCalculator() {
        d = new JDialog(f , "Daily Water Intake Calculator", true);
        d.setLayout( new FlowLayout() );
        f=new JFrame("Daily Water Intake Calculator");
        weight=new JLabel("Weight:");
        weight.setBounds(30,50,100,25);
        f.add(weight);
        WEIGHT=new JTextField(5);
        WEIGHT.setBounds(150,50,100,25);
        f.add(WEIGHT);
        activityLevel=new JLabel("Activity Level:");
        activityLevel.setBounds(30,100,100,25);
        f.add(activityLevel);
        String s1[] = { "Sedentary", "Moderately active", "Active", "Highly active" };
        // create checkbox
        activity= new JComboBox(s1);
        activity.setBounds(150,100,150,25);
        f.add(activity);
        age=new JLabel("Age:");
        age.setBounds(30,150,100,25);
        f.add(age);
        AGE=new JTextField(5);
        AGE.setBounds(150,150,100,25);
        f.add(AGE);
        result=new JButton("Result");
        result.setBounds(30,200,100,25);

        f.add(result);
        RESULT=new JTextField(15);
        RESULT.setBounds(150,200,100,25);
        f.add(RESULT);

        f.setSize(400,300);
        f.setLayout(null);
        f.setVisible(true);
        result.addActionListener ( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                float f_result;
                float addition_water = 0.f;
                float f_weight=Float.parseFloat(WEIGHT.getText());
                float f_age=Float.parseFloat(AGE.getText());
                float addition = 0.f;
                if(f_age<=30)
                    addition=40;
                if(f_age<55&&f_age>30)
                    addition=35;
                if (f_age>=55)
                    addition=30;
                int i=activity.getSelectedIndex();
                if(i==0)
                    addition_water=5.f;
                if(i==1)
                    addition_water=10.f;
                if(i==2)
                    addition_water=20.f;
                if(i==3)
                    addition_water=35.f;

                f_result= (float) ((((f_weight*2.205/2.2)*addition)/28.3+addition_water)/33.8);
                String s_result=Float.toString(f_result);
                RESULT.setText(s_result);
            }
        });
    }
    
    public void itemStateChanged(ItemEvent itemEvent) {
        //float addition_water;
        
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }






    public static void main(String[] args) {
       new DailyWaterIntakeCalculator();



    }


    }


