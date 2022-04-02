import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame{
    public static void main(String[] args) {
        FrameDraw frame = new FrameDraw();
    }
}
class FrameDraw extends JFrame{
    JLabel DECORATE_Right;    JButton [] MainButtons;
    public FrameDraw(){
        setLayout(null);
        setTitle("Editor — Главная страница");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(720, 600);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(66,49,58));
        setVisible(true);

        Color ColorButtons = new Color(108, 45, 44);
        Color TextColor = new Color(241, 220, 201);
        Color TextAreaColor = new Color(87, 64, 76);
        Font ButtonsFont = new Font("Arial black", Font.PLAIN, 14);


        //Добавляем scrollable панельку для главной страницы
        JPanel MainPage = new JPanel();
        MainPage.setLayout(null);
        JScrollPane MainPageScroll = new JScrollPane(MainPage);
        MainPageScroll.setBounds(181, 0,539, 600);
        MainPage.setBackground(new Color(66,49,58));
        MainPageScroll.setVisible(true);
        MainPageScroll.setBorder(null);
        add(MainPageScroll);

        //Добавляем панель для добавления объявлений
        JPanel AddingMes = new JPanel();
        AddingMes.setLayout(null);
        JScrollPane AddingMesScroll = new JScrollPane(AddingMes);
        AddingMesScroll.setBounds(181, 0,539, 600);
        AddingMes.setBackground(new Color(66,49,58));
        AddingMesScroll.setVisible(true);
        AddingMesScroll.setBorder(null);
        add(AddingMes);





        //Настраиваем главные кнопки
        String [] namesButtons = {"Главная страница", "Студенты", "Объявления", "Список", "Добавить"};

        MainButtons = new JButton[5];
        for (int i = 0; i<5; i++){
            MainButtons[i] = new JButton(namesButtons[i]);
            MainButtons[i].setBackground(ColorButtons); MainButtons[i].setFocusPainted(false);
            MainButtons[i].setBounds(0, i*80, 180, 80);
            MainButtons[i].setFont(ButtonsFont); MainButtons[i].setForeground(TextColor);

            if (i > 2) {MainButtons[i].setVisible(false);
                MainButtons[i].setBackground(new Color(154,70, 54));
                MainButtons[i].setLocation(0, (i-1)*80);
            }

            //Listener для кнопок
            MainButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i< 5; i++) {
                        if (MainButtons[i] == e.getSource()){
                            switch (i){
                                case 0:
                                {
                                    AddingMesScroll.setVisible(false);
                                    MainButtons[3].setVisible(false); MainButtons[4].setVisible(false);
                                    MainButtons[2].setLocation(0,160 );
                                    setTitle("Editor — Главная страница");
                                    JTextArea MainPageTextArea[] = new JTextArea[5];
                                    JScrollPane MainPageTextAreaScroll[] = new JScrollPane[5];
                                    //Добавляем TextArea для содержания сообщений в истории сообщений на главной странице
                                    for (int j =0; j<5; j++) {
                                        MainPageTextArea[j] = new JTextArea();
                                        MainPageTextAreaScroll[j] = new JScrollPane(MainPageTextArea[j]);
                                            MainPageTextAreaScroll[j].setBounds(30, 30*(j+1)+j*200, 465, 200);
                                            MainPageTextAreaScroll[j].setBorder(null);
                                            MainPageTextAreaScroll[j].setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                                            MainPageTextArea[j].setBounds(30, 30*(j+1)+j*200, 465, 200);
                                            MainPageTextArea[j].setFont(new Font("Arial black", Font.PLAIN, 13));
                                            MainPageTextArea[j].setBackground(TextAreaColor);
                                            MainPageTextArea[j].setForeground(TextColor);
                                        MainPage.add(MainPageTextAreaScroll[j]);

                                        //Кнопка для активации редактирования TextArea
                                        /*JButton MainPageButtonEditArea = new JButton();
                                            MainPageButtonEditArea.setBackground(TextAreaColor);
                                            Icon iconEdit = new ImageIcon("C:\\Users\\maxim\\IdeaProjects\\untitled7\\src\\main\\java\\Icons\\EditIcon.png");
                                            MainPageButtonEditArea.setIcon(iconEdit); */
                                    }
                                    MainPageScroll.setVisible(true);
                                    break;
                                }

                                //При нажатии на "Студенты"
                                case 1:{

                                    MainButtons[3].setVisible(true);
                                    MainButtons[4].setVisible(true);
                                    MainButtons[2].setLocation(0,320 );
                                    break;
                                }
                                //При нажатии на "Объявления"
                                case 2:
                                {
                                    MainButtons[3].setVisible(false); MainButtons[4].setVisible(false);
                                    MainButtons[2].setLocation(0,160 );
                                    setTitle("Editor – Объявления");
                                    MainPageScroll.setVisible(false);
                                    AddingMesScroll.setVisible(true);

                                    break;
                                }
                                //При нажатии на "Студент"->"Список"
                                case 3:
                                {
                                    setTitle("Editor – Список студентов");
                                    MainPageScroll.setVisible(false);
                                    AddingMesScroll.setVisible(false);

                                    break;
                                }
                                //При нажатии на "Студент"->"Добавить"
                                case 4:
                                {
                                    setTitle("Editor – Добавить студентов");
                                    MainPageScroll.setVisible(false);
                                    AddingMesScroll.setVisible(false);
                                    /*
                                    JPanel[] AddingMes = new JPanel[5];
                                    AddingMes.setLayout(null);
                                    JScrollPane AddingMesScroll = new JScrollPane(AddingMes);
                                    AddingMesScroll.setBounds(181, 0,539, 600);
                                    AddingMes.setBackground(new Color(66,49,58));
                                    AddingMesScroll.setVisible(true);
                                    AddingMesScroll.setBorder(null);
                                    add(AddingMes);
                                    */




                                    break;
                                }
                            }
                        }
                    }
                }
            });

            add(MainButtons[i]);
        }

        /*
        //Декоративная панелька с правой стороны фрейма
        DECORATE_Right = new JLabel(); DECORATE_Right.setOpaque(true);
        DECORATE_Right.setBounds(0, 0, 180, 600);
        DECORATE_Right.setBackground(new Color(188,109,79));
        add(DECORATE_Right);
        */



    }
}