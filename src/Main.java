/**
 * Created by mrchebik on 16.03.15.
 */
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;

public class Main extends JFrame {
    JLabel a, b, c, d;
    JTextArea t4;
    JMenuBar mb;
    JMenu help;
    MaskFormatter f1, f2;
    JFormattedTextField t1, t2, t3;
    String k1, k2, k3, text;
    String str1, str2, str3;
    String strR1 = "", strR2 = "", strR3 = "";
    String OSname = System.getProperty("os.name");
    int OS = 0, OS1 = 0;
    int s, i, m, m1;
    Timer time1 = new Timer(100, e -> str1 = t1.getText());
    Timer time2 = new Timer(100, e -> str2 = t2.getText());
    Timer time3 = new Timer(100, e -> str3 = t3.getText());

    public Main() {
        JButton ba1 = new JButton("Вычислить");
        ba1.addActionListener(e -> {
            try {
                t4.setText(null);
                k1 = null;
                k2 = null;
                k3 = null;
                int a1, b1, c1;
                a1 = Integer.parseInt(strR1);
                if (a1 == 0)
                    JOptionPane.showMessageDialog(null, "Коэффициент A - не может равняться 0!", "Неверный коэффициент", JOptionPane.ERROR_MESSAGE);
                else {
                    b1 = Integer.parseInt(strR2);
                    c1 = Integer.parseInt(strR3);
                    if ((b1 <= 0) && (c1 <= 0))
                        text = a1 + "x² - " + -b1 + "x - " + -c1 + " = 0;\n";
                    if ((b1 <= 0) && (c1 >= 0))
                        text = a1 + "x² - " + -b1 + "x + " + c1 + " = 0;\n";
                    if ((b1 >= 0) && (c1 >= 0))
                        text = a1 + "x² + " + b1 + "x + " + c1 + " = 0;\n";
                    if ((b1 >= 0) && (c1 <= 0))
                        text = a1 + "x² + " + b1 + "x - " + -c1 + " = 0;\n";
                    if (OSname.equals("Linux"))
                        text += ("            D = b² - 4ac;\n");
                    else
                        text += ("                D = b² - 4ac;\n");
                    if (c1 >= 0 && a1 >= 0)
                        text += "D = " + b1 + "² - 4" + " * " + a1 + " * " + c1 + ";\n";
                    else if (c1 >= 0 && a1 <= 0)
                        text += "D = " + b1 + "² - 4" + " * (" + a1 + ") * " + c1 + ";\n";
                    else if (c1 <= 0 && a1 <= 0)
                        text += "D = " + b1 + "² - 4" + " * (" + a1 + ") * (" + c1 + ");\n";
                    else if (c1 <= 0 && a1 >= 0)
                        text += "D = " + b1 + "² - 4" + " * " + a1 + " * (" + c1 + ");\n";
                    s = (int) (Math.pow(b1, 2) - (4 * a1 * c1));
                    m = (int) Math.pow(b1, 2);
                    m1 = (4 * a1 * c1);
                    if (m1 < 0)
                        text += "D = " + m + " + " + -m1 + " = " + s + ";\n";
                    else
                        text += "D = " + m + " - " + m1 + " = " + s + ";\n";
                    int dis = -b1 - ((int) Math.sqrt(s)), displus = -b1 + ((int) Math.sqrt(s)), mis = 2 * a1;
                    if (s < 0)
                        text += "D < 0, корней нет!\n       Ответ: корней нет.";
                    else if (s == 0) {
                        text += "D = 0, один корень!\n                  x = -b/2a;\n";
                        if (a1 < 0)
                            text += "x = " + -b1 + "/(" + "2*(" + a1 + "));\n";
                        else
                            text += "x = " + -b1 + "/(" + "2*" + a1 + ");\n";
                        if (-b1 < 0 && mis < 0)
                            text += "x = -(" + b1 + "/" + -mis + ");  |:";
                        else if (-b1 < 0)
                            text += "x = -(" + b1 + "/" + mis + ");  |:";
                        else if (mis < 0)
                            text += "x = -(" + -b1 + "/" + -mis + ");  |:";
                        else
                            text += "x = " + -b1 + "/" + mis + ";  |:";
                        if (-b1 == mis)
                            text += mis + "\nx = 1;\n       Ответ: 1.";
                        else if (-b1 == -mis)
                            text += mis + "\nx = -1;\n       Ответ: -1.";
                        else
                            for (i = 100; i >= 2; i--) {
                                if (-b1 == 0) {
                                    text += 0 + "\nx = 0;\nОтвет: 0.";
                                    break;
                                }
                                if (((-b1 / i * i) == -b1) && ((mis / i * i) == mis))
                                    if (mis / i != 1) {
                                        if (-b1 / i < 0)
                                            text += i + "\nx = -(" + b1 / i + "/" + mis / i + ");\n      Ответ: " + -b1 / i + "/" + mis / i + ".";
                                        else if (mis / i < 0)
                                            text += i + "\nx = -(" + -b1 / i + "/" + -mis / i + ");\n       Ответ: -(" + -b1 / i + "/" + -mis / i + ").";
                                        else
                                            text += i + "\nx = " + -b1 / i + "/" + mis / i + ";\n       Ответ: " + -b1 / i + "/" + mis / i + ".";
                                        break;
                                    } else {
                                        text += i + "\nx = " + -b1 / i + ";\n       Ответ: " + -b1 / i + ".";
                                        break;
                                    }
                            }
                    } else {
                        text += "D > 0, два корня!\n         x1,2 = (-b ± √D)/2a;\n";
                        if (Math.sqrt(s) != (int) Math.sqrt(s)) {
                            for (int i = 100; i >= 2; i--) {
                                if ((i * i) * (s / (i * i)) == s) {
                                    text += "x1 = (" + -b1 + " - " + "√" + s + ")/" + 2 * a1 + ";\n  x = (" + -b1 + " - " + i + "√" + (s / (i * i)) + ")/" + 2 * a1 + ";\n";
                                    text += "x2 = (" + -b1 + " + " + "√" + s + ")/" + 2 * a1 + ";\n  x = (" + -b1 + " + " + i + "√" + (s / (i * i)) + ")/" + 2 * a1 + ";\n";
                                    text += "       Ответ: (" + -b1 + " - " + i + "√" + (s / (i * i)) + ")/" + 2 * a1 + ";\n" +
                                            "                     (" + -b1 + " + " + i + "√" + (s / (i * i)) + ")/" + 2 * a1 + ".";
                                    break;
                                }
                                if (i == 2) {
                                    text += "x1 = (" + -b1 + " - " + "√" + s + ")/" + 2 * a1 + ";\n";
                                    text += "x2 = (" + -b1 + " + " + "√" + s + ")/" + 2 * a1 + ";\n";
                                    text += "       Ответ: (" + -b1 + " - " + "√" + s + ")/" + 2 * a1 + ";\n" +
                                            "                     (" + -b1 + " + " + "√" + s + ")/" + 2 * a1 + ".\n";
                                }
                            }
                        } else {
                            text += "x1:";
                            if (a1 > 0)
                                text += "x = (" + -b1 + " + " + ((int) Math.sqrt(s)) + ")/2*" + a1 + ";\n";
                            else
                                text += "x = (" + -b1 + " + " + ((int) Math.sqrt(s)) + ")/2*(" + a1 + ");\n";
                            if (mis < 0 && displus < 0)
                                text += "     x = -(" + -displus + "/" + -mis + ");  |:";
                            else if (mis < 0)
                                text += "     x = -(" + displus + "/" + -mis + ");  |:";
                            else if (displus < 0)
                                text += "     x = -(" + -displus + "/" + mis + ");  |:";
                            else if ((displus > 0) && (mis > 0))
                                text += "     x = " + displus + "/" + mis + ";  |:";
                            else if (displus == 0 || mis == 0)
                                text += "     x = " + displus + "/" + mis + ";  |:";
                            for (i = 100; i >= 2; i--) {
                                if (displus == mis || -displus == -mis) {
                                    text += mis + "\n     x = 1\n";
                                    k1 = "1";
                                    break;
                                }
                                if (displus == -mis || -displus == mis) {
                                    text += mis + "\n     x = -1\n";
                                    k1 = "-1";
                                    break;
                                }
                                if (displus == 0) {
                                    text += 0 + "\n     x = 0;\n";
                                    k1 = "0";
                                    break;
                                }
                                if (((displus / i * i) == displus) && ((mis / i * i) == mis)) {
                                    if (mis / i != -1 && mis / i != -1 && -mis / i != 1 && -mis / i != -1) {
                                        if ((((displus / i) > (mis / i)) || (-(displus / i) > (mis / i))) && (((displus / i) / (mis / i)) != 0) && (displus / i - (((displus / i) / (mis / i)) * (mis / i)) != 0)) {
                                            text += i + "\n     x = " + (displus / i) / (mis / i) + "*(" + (displus / i - ((displus / i) / (mis / i) * (mis / i))) + "/" + mis / i + ");\n";
                                            k1 = (displus / i) / (mis / i) + "*(" + (displus / i - (((displus / i) / (mis / i)) * (mis / i))) + "/" + mis / i + ")";
                                            break;
                                        }
                                        if (mis / i < 0 && dis / i < 0) {
                                            text += i + "\n     x = " + -displus / i + "/" + -mis / i + ";\n";
                                            k1 = -displus / i + "/" + -mis / i;
                                            break;
                                        }
                                        if (mis / i < 0) {
                                            text += i + "\n     x = -(" + displus / i + "/" + -mis / i + ");\n";
                                            k1 = "-(" + displus / i + "/" + -mis / i + ")";
                                            break;
                                        }
                                        if (displus / i < 0) {
                                            text += i + "\n     x = -(" + -displus / i + "/" + mis / i + ");\n";
                                            k1 = "-(" + -displus / i + "/" + mis / i + ")";
                                            break;
                                        } else {
                                            text += i + "\n     x = " + displus / i + "/" + mis / i + ";\n";
                                            k1 = displus / i + "/" + mis / i;
                                            break;
                                        }
                                    } else {
                                        if (mis / i < 0 || (mis / i < 0 && displus / i < 0)) {
                                            text += i + "\n     x = " + -displus / i + ";\n";
                                            k2 = -displus / i + "; ";
                                            break;
                                        }
                                        if (mis / i > 0 || (mis / i > 0 && displus / i > 0)) {
                                            text += i + "\n     x = " + displus / i + ";\n";
                                            k2 = displus / i + "; ";
                                            break;
                                        }
                                    }
                                }
                            }
                            text += "x2:";
                            if (a1 > 0)
                                text += "x = (" + -b1 + " - " + ((int) Math.sqrt(s)) + ")/2*" + a1 + ";\n";
                            else
                                text += "x = (" + -b1 + " - " + ((int) Math.sqrt(s)) + ")/2*(" + a1 + ");\n";
                            if (mis < 0 && dis < 0)
                                text += "     x = -(" + -dis + "/" + -mis + ");  |:";
                            else if (mis < 0)
                                text += "     x = -(" + dis + "/" + -mis + ");  |:";
                            else if (dis < 0)
                                text += "     x = -(" + -dis + "/" + mis + ");  |:";
                            else if (dis > 0 && mis > 0)
                                text += "     x = " + dis + "/" + mis + ";  |:";
                            else if (dis == 0 || mis == 0)
                                text += "     x = " + dis + "/" + mis + ";  |:";
                            for (int i = 100; i >= 2; i--) {
                                if (dis == mis || -dis == -mis) {
                                    text += mis + "\n     x = 1;\n";
                                    k3 = "1";
                                    if (k1 != null)
                                        text += "       Ответ: " + k1 + "; " + k3 + ".";
                                    if (k2 != null)
                                        text += "       Ответ: " + k2 + k3 + ".";
                                    break;
                                }
                                if (dis == -mis || -dis == mis) {
                                    text += mis + "\n     x = -1;\n";
                                    k3 = "-1";
                                    if (k1 != null)
                                        text += "       Ответ: " + k1 + "; " + k3 + ".";
                                    if (k2 != null)
                                        text += "       Ответ: " + k2 + k3 + ".";
                                    break;
                                }
                                if (dis == 0) {
                                    text += 0 + "\n     x = 0;\n";
                                    k3 = "0";
                                    if (k1 != null)
                                        text += "       Ответ: " + k1 + "; " + k3 + ".";
                                    if (k2 != null)
                                        text += "       Ответ: " + k2 + k3 + ".";
                                    break;
                                }
                                if (((dis / i * i) == dis) && ((mis / i * i) == mis))
                                    if (mis / i != -1 && mis / i != -1 && -mis / i != 1 && -mis / i != -1) {
                                        if (mis / i < 0 && dis / i < 0) {
                                            text += i + "\n     x = " + -dis / i + "/" + -mis / i + ";\n";
                                            k3 = -dis / i + "/" + -mis / i;
                                        } else if (mis / i < 0) {
                                            text += i + "\n     x = -(" + dis / i + "/" + -mis / i + ");\n";
                                            k3 = "-(" + dis / i + "/" + -mis / i + ")";
                                        } else if (dis / i < 0) {
                                            text += i + "\n     x = -(" + -dis / i + "/" + mis / i + ");\n";
                                            k3 = "-(" + -dis / i + "/" + mis / i + ")";
                                        } else {
                                            text += i + "\n     x = " + dis / i + "/" + mis / i + ";\n";
                                            k3 = dis / i + "/" + mis / i;
                                        }
                                        if ((((dis / i) > (mis / i)) || (-(dis / i) > (mis / i))) && (((dis / i) / (mis / i)) != 0) && (dis / i - (((dis / i) / (mis / i)) * (mis / i)) != 0)) {
                                            text += "     x = " + (dis / i) / (mis / i) + "*(" + -(dis / i - (((dis / i) / (mis / i)) * (mis / i))) + "/" + mis / i + ");\n";
                                            if (k1 != null)
                                                text += "       Ответ: " + k1 + "; " + (dis / i) / (mis / i) + "*(" + -(dis / i - (((dis / i) / (mis / i)) * (mis / i))) + "/" + mis / i + ").";
                                            if (k2 != null)
                                                text += "       Ответ: " + k2 + (dis / i) / (mis / i) + "*(" + (dis / i - (((dis / i) / (mis / i)) * (mis / i))) + "/" + mis / i + ").";
                                            break;
                                        }
                                        if (k1 != null)
                                            text += "       Ответ: " + k1 + "; " + k3 + ".";
                                        if (k2 != null)
                                            text += "       Ответ: " + k2 + k3 + ".";
                                        break;
                                    } else {
                                        if (mis / i < 0 || (mis / i < 0 && dis / i < 0)) {
                                            text += i + "\n     x = " + -dis / i + ";\n";
                                            if (k1 != null)
                                                text += "       Ответ: " + k1 + "; " + -dis / i + ".";
                                            if (k2 != null)
                                                text += "       Ответ: " + k2 + -dis / i + ".";
                                            break;
                                        }
                                        if (mis / i > 0 || (mis / i > 0 && dis / i > 0)) {
                                            text += i + "\n     x = " + dis / i + ";\n";
                                            if (k1 != null)
                                                text += "       Ответ: " + k1 + "; " + dis / i + ".";
                                            if (k2 != null)
                                                text += "       Ответ: " + k2 + dis / i + ".";
                                            break;
                                        }
                                    }
                            }
                        }
                    }
                    t4.append(text);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Вы ввели пустые значения", "Неверный ввод", JOptionPane.ERROR_MESSAGE);
            }
        });
        JButton b2 = new JButton("Очистить");
        b2.addActionListener(e -> {
            t1.setText(null);
            t2.setText(null);
            t3.setText(null);
            t4.setText(null);
        });
        a = new JLabel("A:");
        b = new JLabel("B:");
        c = new JLabel("C:");
        d = new JLabel("Вычисление:");
        mb = new JMenuBar();
        JMenu file = new JMenu("File");
        mb.add(file);
        JMenuItem exit = new JMenuItem("Exit");
        file.add(exit);
        exit.addActionListener(e -> System.exit(0));
        help = new JMenu("Help");
        mb.add(help);
        JMenuItem info = new JMenuItem("About");
        info.addActionListener(e -> JOptionPane.showMessageDialog(null, "Version:     0.9\nDeveloper: MrChebik", "About", JOptionPane.PLAIN_MESSAGE));
        if (OSname.equals("Linux"))
            t4 = new JTextArea(13, 16);
        else
            t4 = new JTextArea(13, 15);
        try {
            f1 = new MaskFormatter("*###");
            f2 = new MaskFormatter("*###");
            f1.setValidCharacters("-1234567890");
            f2.setValidCharacters("-123456789");
            t1 = new JFormattedTextField(f1);
            t1.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    super.focusGained(e);
                    time1.start();
                }

                @Override
                public void focusLost(FocusEvent e) {
                    super.focusLost(e);
                    focusLost1();
                }
            });
            t2 = new JFormattedTextField(f1);
            t2.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    super.focusGained(e);
                    time2.start();
                }

                @Override
                public void focusLost(FocusEvent e) {
                    super.focusLost(e);
                    focusLost2();
                }
            });
            t3 = new JFormattedTextField(f1);
            t3.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    super.focusGained(e);
                    time3.start();
                }

                @Override
                public void focusLost(FocusEvent e) {
                    super.focusLost(e);
                    focusLost3();
                }
            });
            t1.setColumns(3);
            t2.setColumns(3);
            t3.setColumns(3);
        } catch (ParseException e) {
        }
        t1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (e.getKeyText(e.getKeyCode()) == "Enter") {
                    focusLost1();
                    ba1.doClick();
                    time1.start();
                }
            }
        });
        t2.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (e.getKeyText(e.getKeyCode()) == "Enter") {
                    focusLost2();
                    ba1.doClick();
                    time2.start();
                }
            }
        });
        t3.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (e.getKeyText(e.getKeyCode()) == "Enter") {
                    focusLost3();
                    ba1.doClick();
                    time3.start();
                }
            }
        });
        t4.setEditable(false);
        help.add(info);
        add(mb);
        add(a);
        add(t1);
        add(b);
        add(t2);
        add(c);
        add(t3);
        add(d);
        add(new JScrollPane(t4));
        add(ba1);
        add(b2);
        setTitle("Дискриминант");
        if (!OSname.equals("Linux")) {
            OS = 45;
            OS1 = 12;
        }
        setSize(228 - OS+OS1, 340 + OS1);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setJMenuBar(mb);
        setVisible(true);
    }

    public void focusLost1() {
        time1.stop();
        strR1 = "";
        char[] chstr1 = new char[str1.length()];
        str1.getChars(0, str1.length(), chstr1, 0);
        for (int i = 0; i < str1.length(); i++)
            if (chstr1[i] != ' ')
                strR1 += chstr1[i];
        t1.setValue(strR1);
    }

    public void focusLost2() {
        time2.stop();
        strR2 = "";
        char[] chstr2 = new char[str2.length()];
        str2.getChars(0, str2.length(), chstr2, 0);
        for (int i = 0; i < str2.length(); i++)
            if (chstr2[i] != ' ')
                strR2 += chstr2[i];
        t2.setValue(strR2);
    }

    public void focusLost3() {
        time3.stop();
        strR3 = "";
        char[] chstr3 = new char[str3.length()];
        str3.getChars(0, str3.length(), chstr3, 0);
        for (int i = 0; i < str3.length(); i++)
            if (chstr3[i] != ' ')
                strR3 += chstr3[i];
        t3.setValue(strR3);
    }

    public static void main(String args[]) {
        new Main();
    }
}