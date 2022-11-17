package swing.main;


import swing.PanelSlide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarCustom extends JPanel {

    private int month;
    private int year;
    private int day;

    private JButton cmdBack;
    private JButton cmdNext;
    private JLayeredPane jLayeredPane1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JLabel lbDate;
    private JLabel lbWeather;
    private JLabel lbWishers;
    private JLabel lbOtchuwalna;
    private JLabel lbRain;
    private JLabel lbWiatr;
    private JLabel lbAtmosf;
    private JLabel lbChmury;
    private JLabel lbWilgotnosc;
    private JLabel lbSnow;
    private JLabel lbMonthYear;
    private JLabel lbTime;
    private JLabel lbType;
    private PanelSlide slide;

    public CalendarCustom() {
        initComponents();
        thisMonth();
        slide.show(new PanelDate(5, 2022), PanelSlide.AnimateType.TO_RIGHT);
        showMonthYear();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.err.println(e);
                    }
                    Date date = new Date();
                    SimpleDateFormat timeformat = new SimpleDateFormat("h:mm:ss aa");
                    SimpleDateFormat dataformat = new SimpleDateFormat("EEEE, dd/MM-yyyy");
                    String time = timeformat.format(date);
                    lbTime.setText(time.split(" ")[0]);
                    lbType.setText(time.split(" ")[1]);
                    lbDate.setText(dataformat.format(date));
                }
            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        slide = new PanelSlide();
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        lbTime = new JLabel();
        lbType = new JLabel();
        lbDate = new JLabel();
        lbWeather = new JLabel();
        lbWishers = new JLabel();
        lbAtmosf = new JLabel();
        lbChmury = new JLabel();
        lbOtchuwalna = new JLabel();
        lbRain = new JLabel();
        lbSnow = new JLabel();
        lbWiatr = new JLabel();
        lbWilgotnosc = new JLabel();
        jLayeredPane1 = new JLayeredPane();
        cmdBack = new JButton();
        lbMonthYear = new JLabel();
        cmdNext = new JButton();


        setBackground(new Color(255, 255, 255));

        slide.setBackground(new Color(255, 255, 255));

        GroupLayout slideLayout = new GroupLayout(slide);
        slide.setLayout(slideLayout);
        slideLayout.setHorizontalGroup(
                slideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        slideLayout.setVerticalGroup(
                slideLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 321, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new Color(0, 0, 204));
        jPanel2.setBackground(new Color(0, 0, 204));



        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 6, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 391, Short.MAX_VALUE)
        );

        lbTime.setFont(new Font("sansserif", 1, 48)); // NOI18N
        lbTime.setForeground(new Color(201, 201, 201));
        lbTime.setHorizontalAlignment(SwingConstants.RIGHT);
        lbTime.setText("9:32:00");

        lbType.setFont(new Font("sansserif", 1, 25)); // NOI18N
        lbType.setForeground(new Color(201, 201, 201));
        lbType.setText("PM");

        lbDate.setFont(new Font("sansserif", 0, 18)); // NOI18N
        lbDate.setForeground(new Color(201, 201, 201));
        lbDate.setHorizontalAlignment(SwingConstants.CENTER);
        lbDate.setText("Sunday, 30/05/2022");

        lbWishers.setFont(new Font("sansserif", 0, 16)); // NOI18N
        lbWishers.setForeground(new Color(201, 201, 201));
        lbWishers.setHorizontalAlignment(SwingConstants.CENTER);
        try {
            lbWishers.setText(new StringBuilder().append("").append(Parser.textsWish()).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        lbWeather.setFont(new Font("sansserif", 0, 18)); // NOI18N
        lbWeather.setForeground(new Color(201, 201, 201));
        lbWeather.setHorizontalAlignment(SwingConstants.LEFT);
        try {
            lbWeather.setText("Pogoda teraz "+"\n"+Parser.textWeather());
        } catch (IOException e) {
            e.printStackTrace();
        }

        lbOtchuwalna.setFont(new Font("sansserif", 0, 14)); // NOI18N
        lbOtchuwalna.setForeground(new Color(201, 201, 201));
        lbOtchuwalna.setHorizontalAlignment(SwingConstants.LEFT);
        try {
            lbOtchuwalna.setText(Parser.odczuwalna());
        } catch (IOException e) {
            e.printStackTrace();
        }

        lbRain.setFont(new Font("sansserif", 0, 14)); // NOI18N
        lbRain.setForeground(new Color(201, 201, 201));
        lbRain.setHorizontalAlignment(SwingConstants.LEFT);
        try {
            lbRain.setText(Parser.rain());
        } catch (IOException e) {
            e.printStackTrace();
        }

        lbWiatr.setFont(new Font("sansserif", 0, 14)); // NOI18N
        lbWiatr.setForeground(new Color(201, 201, 201));
        lbWiatr.setHorizontalAlignment(SwingConstants.LEFT);
        try {
            lbWiatr.setText(Parser.wiatr());
        } catch (IOException e) {
            e.printStackTrace();
        }


        lbAtmosf.setFont(new Font("sansserif", 0, 14)); // NOI18N
        lbAtmosf.setForeground(new Color(201, 201, 201));
        lbAtmosf.setHorizontalAlignment(SwingConstants.LEFT);
        try {
            lbAtmosf.setText(Parser.atmosf());
        } catch (IOException e) {
            e.printStackTrace();
        }

        lbChmury.setFont(new Font("sansserif", 0, 14)); // NOI18N
        lbChmury.setForeground(new Color(201, 201, 201));
        lbChmury.setHorizontalAlignment(SwingConstants.LEFT);
        try {
            lbChmury.setText(Parser.chmury());
        } catch (IOException e) {
            e.printStackTrace();
        }


        lbWilgotnosc.setFont(new Font("sansserif", 0, 14)); // NOI18N
        lbWilgotnosc.setForeground(new Color(201, 201, 201));
        lbWilgotnosc.setHorizontalAlignment(SwingConstants.LEFT);
        try {
            lbWilgotnosc.setText(Parser.wilgotnosc());
        } catch (IOException e) {
            e.printStackTrace();
        }

        lbSnow.setFont(new Font("sansserif", 0, 14)); // NOI18N
        lbSnow.setForeground(new Color(201, 201, 201));
        lbSnow.setHorizontalAlignment(SwingConstants.LEFT);
        try {
            lbSnow.setText(Parser.snow());
        } catch (IOException e) {
            e.printStackTrace();
        }


        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lbTime, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbType, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lbDate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbWishers, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbWeather, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbOtchuwalna, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbRain, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbWiatr, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbAtmosf, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbChmury, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbWilgotnosc, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbSnow, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                )
                                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbTime, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbType))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbDate)
                                .addComponent(lbWishers)
                                .addComponent(lbWeather)
                                .addComponent(lbOtchuwalna)
                                .addComponent(lbRain)
                                .addComponent(lbWiatr)
                                .addComponent(lbAtmosf)
                                .addComponent(lbChmury)
                                .addComponent(lbWilgotnosc)
                                .addComponent(lbSnow)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );


        cmdBack.setIcon(new ImageIcon("F:\\StudiesProject\\Java\\CalendarVol2\\src\\main\\java\\icon\\left.png")); // NOI18N
        cmdBack.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cmdBack.setContentAreaFilled(false);
        cmdBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmdBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cmdBackActionPerformed(evt);
            }
        });

        lbMonthYear.setFont(new Font("sansserif", 1, 30)); // NOI18N
        lbMonthYear.setForeground(new Color(97, 49, 237));
        lbMonthYear.setHorizontalAlignment(SwingConstants.CENTER);
        lbMonthYear.setText("Month - Year");

        cmdNext.setIcon(new ImageIcon("F:\\StudiesProject\\Java\\CalendarVol2\\src\\main\\java\\icon\\right.png"));// NOI18N
        cmdNext.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cmdNext.setContentAreaFilled(false);
        cmdNext.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmdNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cmdNextActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(cmdBack, JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lbMonthYear, JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(cmdNext, JLayeredPane.DEFAULT_LAYER);

        GroupLayout jLayeredPane1Layout = new GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
                jLayeredPane1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cmdBack, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbMonthYear, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdNext, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
                jLayeredPane1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jLayeredPane1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(cmdBack, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbMonthYear, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cmdNext, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(slide, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLayeredPane1))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLayeredPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(slide, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }

    private void cmdNextActionPerformed(java.awt.event.ActionEvent evt) {
        if (month == 12) {
            month = 1;
            year++;
        } else {
            month++;
        }
        slide.show(new PanelDate(month, year), PanelSlide.AnimateType.TO_LEFT);
        showMonthYear();
    }

    private void cmdBackActionPerformed(java.awt.event.ActionEvent evt) {
        if (month == 1) {
            month = 12;
            year--;
        } else {
            month--;
        }
        slide.show(new PanelDate(month, year), PanelSlide.AnimateType.TO_RIGHT);
        showMonthYear();
    }

    private void thisMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());   //  today
        month = calendar.get(Calendar.MONTH) + 1;
        year = calendar.get(Calendar.YEAR);
        day = calendar.get(Calendar.DATE);
    }


    private void showMonthYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DATE, day);
        SimpleDateFormat datef = new SimpleDateFormat(" MMMM yyyy");
        lbMonthYear.setText(datef.format(calendar.getTime()));
    }

}


