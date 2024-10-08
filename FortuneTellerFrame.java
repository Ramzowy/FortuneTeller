import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    JPanel mainPnL, titlePnl, displayPnl, controlPnl;
    JButton fortuneBtn, quitBtn;
    JLabel titleLbl;

    ImageIcon icon;

    JTextArea fortuneTA;

    JScrollPane scroller;

    Random gen = new Random();
    ArrayList<String> fortunes = new ArrayList<>();




    public FortuneTellerFrame (String title) throws HeadlessException
    {
        setTitle("Fortune teller");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPnL = new JPanel();
        mainPnL.setLayout(new BorderLayout());
        add(mainPnL);
        fortunes.add("The sun may set, but it will rise again tomorrow. Your troubles will pass.");
        fortunes.add("A river starts small, but it grows mighty. Your small efforts will lead to great success.");
        fortunes.add("Patience is the key to a fruitful harvest. Good things come to those who wait.");
        fortunes.add("Even the tallest mountain began as a grain of sand. Keep climbing, success is near.");
        fortunes.add("A warm smile will open doors even the strongest hands cannot.");
        fortunes.add("Like the baobab tree, your roots are deep, and your wisdom will grow.");
        fortunes.add("The journey is long, but each step brings you closer to your dreams.");
        fortunes.add("With kindness in your heart, the world will always smile back at you.");
        fortunes.add("Just as rain nourishes the earth, hard times will nourish your strength.");
        fortunes.add("A lion’s strength is in its pride; lean on those who love you.");
        fortunes.add("The ocean is vast, but the shore is always within reach. You will find your way.");
        fortunes.add("Happiness is like a butterfly; when you stop chasing, it will land on you.");
        createTitlePanel();
        createDisplayPanel();
        createControlPanel();
        setWindowSizeAndPosition();
        setVisible(true);
    }

    private void createTitlePanel()
    {
        titlePnl = new JPanel();
        icon = new ImageIcon("src/PennyDark.jpg");
        titleLbl = new JLabel("Fortune Teller",icon,JLabel.CENTER);
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        titleLbl.setFont(new Font(Font.SANS_SERIF, Font.ITALIC,18));

        titlePnl.add(titleLbl);
        mainPnL.add(titlePnl, BorderLayout.NORTH);
    }

    private void createDisplayPanel(){

         displayPnl = new JPanel();
         fortuneTA = new JTextArea(10,45);
         scroller = new JScrollPane(fortuneTA);
         fortuneTA.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,14));
         displayPnl.add(scroller);
         mainPnL.add(displayPnl,BorderLayout.CENTER);
    }

    private void createControlPanel(){


        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1,2));
        fortuneBtn = new JButton("Get my Fortune");
        quitBtn = new JButton("Quit");
        fortuneBtn.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,12));
        quitBtn.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,12));
        fortuneBtn.addActionListener((ActionEvent ae) -> readFortune());
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        controlPnl.add(fortuneBtn);
        controlPnl.add(quitBtn);

        mainPnL.add(controlPnl,BorderLayout.SOUTH);

    }

    private void readFortune() {

        int previousIndex = 0;
        if (fortunes.isEmpty()) {
            fortuneTA.setText("No more fortunes available.");
            return;
        }

        int randomIndex;
        do {
            randomIndex = gen.nextInt(fortunes.size());
        } while (randomIndex == previousIndex);

        String fortune = fortunes.get(randomIndex);
        fortuneTA.append(fortune + "\n");
        previousIndex = randomIndex;
    }

    private void setWindowSizeAndPosition() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();  // Get the screen size
        Dimension screenSize = toolkit.getScreenSize();

        // Set the size of the JFrame to ¾ of the screen dimensions
        int width = (int) (screenSize.width * 0.75);
        int height = (int) (screenSize.height * 0.75);
        setSize(width, height);

        // Center the window on the screen
        setLocationRelativeTo(null);
    }






}
