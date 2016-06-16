package com.upwork.sample.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.upwork.sample.Bug;
import com.upwork.sample.Bug.DIRECTION;

/**
 * Swing frame ui.
 * 
 * @author Dali Freire - dalifreire@gmail.com
 * @since 1.0
 */
public class Frame extends JFrame {

    private static final long serialVersionUID = 8003686107522955069L;

    private JPanel contentPane;
    private final JPanel panelBugs;
    private final int xOrigin = 435;
    private final int yOrigin = 18;

    private final ImageIcon bugRightImage = new ImageIcon(new ImageIcon(Frame.class.getResource("/images/bug.png"))
        .getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));
    private final ImageIcon bugLeftImage = new ImageIcon(new ImageIcon(Frame.class.getResource("/images/bug.png"))
        .getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));

    private final JComboBox<String> comboBoxBugs = new JComboBox<String>();
    private final JButton btnNewBug = new JButton("+");
    private final JButton btnRemoveBug = new JButton("-");
    private final JButton btnMoveToLeft = new JButton("<<");
    private final JButton btnTurnAround = new JButton("<>");
    private final JButton btnMoveToRight = new JButton(">>");

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Frame frame = new Frame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Frame() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 780, 250);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblBug = new JLabel("Bug:");
        lblBug.setHorizontalAlignment(SwingConstants.RIGHT);
        lblBug.setLabelFor(comboBoxBugs);
        lblBug.setBounds(10, 177, 32, 23);
        contentPane.add(lblBug);

        comboBoxBugs.setToolTipText("Select the bug");
        comboBoxBugs.setBounds(44, 177, 195, 23);
        contentPane.add(comboBoxBugs);

        btnNewBug.setToolTipText("New bug");
        btnNewBug.setBounds(243, 176, 41, 23);
        btnNewBug.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });
        contentPane.add(btnNewBug);

        btnRemoveBug.setToolTipText("Remove the selected bug");
        btnRemoveBug.setBounds(284, 176, 41, 23);
        btnRemoveBug.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });
        contentPane.add(btnRemoveBug);

        btnMoveToLeft.setToolTipText("Move to left");
        btnMoveToLeft.setBounds(381, 176, 49, 23);
        btnMoveToLeft.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });
        contentPane.add(btnMoveToLeft);

        btnTurnAround.setToolTipText("Turn around");
        btnTurnAround.setBounds(435, 176, 49, 23);
        btnTurnAround.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });
        contentPane.add(btnTurnAround);

        btnMoveToRight.setToolTipText("Move to right");
        btnMoveToRight.setBounds(488, 176, 49, 23);
        btnMoveToRight.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });
        contentPane.add(btnMoveToRight);

        panelBugs = new JPanel() {
            private static final long serialVersionUID = 1940793301596803278L;
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.draw(new Line2D.Float(0, 50, 754, 50));
            }
        };
        panelBugs.setBounds(10, 43, 754, 100);
        contentPane.add(panelBugs);
    }

    public void repaintBugs(final List<Bug> bugs) {

        String selectedBug = (String) this.comboBoxBugs.getSelectedItem();
        
        this.panelBugs.removeAll();
        this.comboBoxBugs.removeAllItems();
        for (Bug bug : bugs) {

            final JLabel b = new JLabel();
            b.setToolTipText(bug.getId());
            b.setBounds(xOrigin + (bug.getLocation()*64), yOrigin, 64, 64);
            b.setIcon(bug.getDirection() == DIRECTION.RIGHT ? bugRightImage : bugLeftImage);
            b.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
                public void mouseExited(MouseEvent e) {
                    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                }
            });
            
            this.panelBugs.add(b);
            this.comboBoxBugs.addItem(bug.getId());
        }
        if (selectedBug != null) {
            this.comboBoxBugs.setSelectedItem(selectedBug);
        }
        this.panelBugs.repaint();
        this.contentPane.repaint();
        this.repaint();
    }

    public JComboBox<String> getComboBoxBugs() {
        return this.comboBoxBugs;
    }

    public JButton getBtnNewBug() {
        return this.btnNewBug;
    }

    public JButton getBtnRemoveBug() {
        return this.btnRemoveBug;
    }

    public JButton getBtnMoveToLeft() {
        return this.btnMoveToLeft;
    }

    public JButton getBtnTurnAround() {
        return this.btnTurnAround;
    }

    public JButton getBtnMoveToRight() {
        return this.btnMoveToRight;
    }
}
