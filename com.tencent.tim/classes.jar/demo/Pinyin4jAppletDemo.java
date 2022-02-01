package demo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Pinyin4jAppletDemo
  extends JApplet
{
  private static final Dimension APP_SIZE = new Dimension(600, 400);
  private static String appName = "pinyin4j-2.0.0 applet demo";
  private static final long serialVersionUID = -1934962385592030162L;
  private JPanel buttonPanel = null;
  String[] caseTypes = { "LOWERCASE", "UPPERCASE" };
  private JComboBox caseTypesComboBox = null;
  private JLabel charLabel = null;
  private JTextField charTextField = null;
  private JButton convertButton = null;
  private JPanel formattedCharPanel = null;
  private JTextArea formattedOutputField = null;
  private JPanel jContentPane = null;
  private JTabbedPane jTabbedPane = null;
  private JPanel optionPanel = null;
  private JLabel toneLabel = null;
  String[] toneTypes = { "WITH_TONE_NUMBER", "WITHOUT_TONE", "WITH_TONE_MARK" };
  private JComboBox toneTypesComboBox = null;
  private JPanel unformattedCharPanel = null;
  private JLabel unformattedGwoyeuRomatzyhLabel = null;
  private JPanel unformattedGwoyeuRomatzyhPanel = null;
  private JScrollPane unformattedGwoyeuRomatzyhScrollPane = null;
  private JTextArea unformattedGwoyeuRomatzyhTextArea = null;
  private JLabel unformattedHanyuPinyinLabel = null;
  private JPanel unformattedHanyuPinyinPanel = null;
  private JScrollPane unformattedHanyuPinyinScrollPane = null;
  private JTextArea unformattedHanyuPinyinTextArea = null;
  private JLabel unformattedMPS2PinyinLabel = null;
  private JPanel unformattedMPS2PinyinPanel = null;
  private JScrollPane unformattedMPS2PinyinScrollPane = null;
  private JTextArea unformattedMPS2PinyinTextArea = null;
  private JLabel unformattedTongyongPinyinLabel = null;
  private JPanel unformattedTongyongPinyinPanel = null;
  private JScrollPane unformattedTongyongPinyinScrollPane = null;
  private JTextArea unformattedTongyongPinyinTextArea = null;
  private JLabel unformattedWadePinyinLabel = null;
  private JPanel unformattedWadePinyinPanel = null;
  private JScrollPane unformattedWadePinyinScrollPane = null;
  private JTextArea unformattedWadePinyinTextArea = null;
  private JLabel unformattedYalePinyinLabel = null;
  private JPanel unformattedYalePinyinPanel = null;
  private JScrollPane unformattedYalePinyinScrollPane = null;
  private JTextArea unformattedYalePinyinTextArea = null;
  String[] vCharTypes = { "WITH_U_AND_COLON", "WITH_V", "WITH_U_UNICODE" };
  private JComboBox vCharTypesComboBox = null;
  
  public Pinyin4jAppletDemo()
  {
    init();
  }
  
  private JPanel getButtonPanel()
  {
    if (this.buttonPanel == null)
    {
      this.buttonPanel = new JPanel();
      this.buttonPanel.add(getConvertButton(), null);
    }
    return this.buttonPanel;
  }
  
  private JComboBox getCaseTypesComboBox()
  {
    if (this.caseTypesComboBox == null) {
      this.caseTypesComboBox = new JComboBox(this.caseTypes);
    }
    return this.caseTypesComboBox;
  }
  
  private JTextField getCharTextField()
  {
    if (this.charTextField == null)
    {
      this.charTextField = new JTextField();
      this.charTextField.setFont(new Font("Dialog", 0, 12));
      this.charTextField.setText("和");
      this.charTextField.setPreferredSize(new Dimension(26, 20));
    }
    return this.charTextField;
  }
  
  private String getChineseCharText()
  {
    return this.charTextField.getText();
  }
  
  private JButton getConvertButton()
  {
    if (this.convertButton == null)
    {
      this.convertButton = new JButton();
      this.convertButton.setText("Convert to Pinyin");
      this.convertButton.addActionListener(new Pinyin4jAppletDemo.2(this));
    }
    return this.convertButton;
  }
  
  private JPanel getFormattedCharPanel()
  {
    if (this.formattedCharPanel == null)
    {
      this.formattedCharPanel = new JPanel();
      this.formattedCharPanel.setLayout(new BorderLayout());
      this.formattedCharPanel.add(getFormattedOutputField(), "Center");
    }
    return this.formattedCharPanel;
  }
  
  private JTextArea getFormattedOutputField()
  {
    if (this.formattedOutputField == null)
    {
      this.formattedOutputField = new JTextArea();
      this.formattedOutputField.setEditable(false);
    }
    return this.formattedOutputField;
  }
  
  private JPanel getJContentPane()
  {
    if (this.jContentPane == null)
    {
      this.jContentPane = new JPanel();
      this.jContentPane.setLayout(new BorderLayout());
      this.jContentPane.add(getJTabbedPane(), "Center");
      this.jContentPane.add(getOptionPanel(), "North");
      this.jContentPane.add(getButtonPanel(), "South");
    }
    return this.jContentPane;
  }
  
  private JTabbedPane getJTabbedPane()
  {
    if (this.jTabbedPane == null)
    {
      this.jTabbedPane = new JTabbedPane();
      this.jTabbedPane.addTab("Unformatted Chinese Romanization Systems", null, getUnformattedCharPanel(), null);
      this.jTabbedPane.addTab("Formatted Hanyu Pinyin", null, getFormattedCharPanel(), null);
    }
    return this.jTabbedPane;
  }
  
  private JPanel getOptionPanel()
  {
    if (this.optionPanel == null)
    {
      this.charLabel = new JLabel();
      this.charLabel.setText("Input Chinese:");
      this.toneLabel = new JLabel();
      this.toneLabel.setText(" Format:");
      this.optionPanel = new JPanel();
      this.optionPanel.setPreferredSize(new Dimension(640, 34));
      this.optionPanel.add(this.charLabel, null);
      this.optionPanel.add(getCharTextField(), null);
      this.optionPanel.add(this.toneLabel, null);
      this.optionPanel.add(getToneTypesComboBox(), null);
      this.optionPanel.add(getVCharTypesComboBox(), null);
      this.optionPanel.add(getCaseTypesComboBox(), null);
    }
    return this.optionPanel;
  }
  
  private JComboBox getToneTypesComboBox()
  {
    if (this.toneTypesComboBox == null)
    {
      this.toneTypesComboBox = new JComboBox(this.toneTypes);
      this.toneTypesComboBox.addActionListener(new Pinyin4jAppletDemo.3(this));
    }
    return this.toneTypesComboBox;
  }
  
  private JPanel getUnformattedCharPanel()
  {
    if (this.unformattedCharPanel == null)
    {
      this.unformattedHanyuPinyinLabel = new JLabel();
      this.unformattedHanyuPinyinLabel.setText("Hanyu Pinyin");
      GridLayout localGridLayout = new GridLayout();
      localGridLayout.setRows(2);
      localGridLayout.setHgap(1);
      localGridLayout.setVgap(1);
      localGridLayout.setColumns(3);
      this.unformattedCharPanel = new JPanel();
      this.unformattedCharPanel.setLayout(localGridLayout);
      this.unformattedCharPanel.add(getUnformattedHanyuPinyinPanel(), null);
      this.unformattedCharPanel.add(getUnformattedTongyongPinyinPanel(), null);
      this.unformattedCharPanel.add(getUnformattedWadePinyinPanel(), null);
      this.unformattedCharPanel.add(getUnformattedMPS2PinyinPanel(), null);
      this.unformattedCharPanel.add(getUnformattedYalePinyinPanel(), null);
      this.unformattedCharPanel.add(getUnformattedGwoyeuRomatzyhPanel(), null);
    }
    return this.unformattedCharPanel;
  }
  
  private JPanel getUnformattedGwoyeuRomatzyhPanel()
  {
    if (this.unformattedGwoyeuRomatzyhPanel == null)
    {
      this.unformattedGwoyeuRomatzyhLabel = new JLabel();
      this.unformattedGwoyeuRomatzyhLabel.setText("Gwoyeu Romatzyh");
      this.unformattedGwoyeuRomatzyhPanel = new JPanel();
      this.unformattedGwoyeuRomatzyhPanel.setLayout(new BorderLayout());
      this.unformattedGwoyeuRomatzyhPanel.add(this.unformattedGwoyeuRomatzyhLabel, "North");
      this.unformattedGwoyeuRomatzyhPanel.add(getUnformattedGwoyeuRomatzyhScrollPane(), "Center");
    }
    return this.unformattedGwoyeuRomatzyhPanel;
  }
  
  private JScrollPane getUnformattedGwoyeuRomatzyhScrollPane()
  {
    if (this.unformattedGwoyeuRomatzyhScrollPane == null)
    {
      this.unformattedGwoyeuRomatzyhScrollPane = new JScrollPane();
      this.unformattedGwoyeuRomatzyhScrollPane.setViewportView(getUnformattedGwoyeuRomatzyhTextArea());
    }
    return this.unformattedGwoyeuRomatzyhScrollPane;
  }
  
  private JTextArea getUnformattedGwoyeuRomatzyhTextArea()
  {
    if (this.unformattedGwoyeuRomatzyhTextArea == null)
    {
      this.unformattedGwoyeuRomatzyhTextArea = new JTextArea();
      this.unformattedGwoyeuRomatzyhTextArea.setEditable(false);
      this.unformattedGwoyeuRomatzyhTextArea.setLineWrap(true);
    }
    return this.unformattedGwoyeuRomatzyhTextArea;
  }
  
  private JPanel getUnformattedHanyuPinyinPanel()
  {
    if (this.unformattedHanyuPinyinPanel == null)
    {
      this.unformattedHanyuPinyinPanel = new JPanel();
      this.unformattedHanyuPinyinPanel.setLayout(new BorderLayout());
      this.unformattedHanyuPinyinPanel.add(this.unformattedHanyuPinyinLabel, "North");
      this.unformattedHanyuPinyinPanel.add(getUnformattedHanyuPinyinScrollPane(), "Center");
    }
    return this.unformattedHanyuPinyinPanel;
  }
  
  private JScrollPane getUnformattedHanyuPinyinScrollPane()
  {
    if (this.unformattedHanyuPinyinScrollPane == null)
    {
      this.unformattedHanyuPinyinScrollPane = new JScrollPane();
      this.unformattedHanyuPinyinScrollPane.setViewportView(getUnformattedHanyuPinyinTextArea());
    }
    return this.unformattedHanyuPinyinScrollPane;
  }
  
  private JTextArea getUnformattedHanyuPinyinTextArea()
  {
    if (this.unformattedHanyuPinyinTextArea == null)
    {
      this.unformattedHanyuPinyinTextArea = new JTextArea();
      this.unformattedHanyuPinyinTextArea.setEditable(false);
      this.unformattedHanyuPinyinTextArea.setLineWrap(true);
    }
    return this.unformattedHanyuPinyinTextArea;
  }
  
  private JPanel getUnformattedMPS2PinyinPanel()
  {
    if (this.unformattedMPS2PinyinPanel == null)
    {
      this.unformattedMPS2PinyinLabel = new JLabel();
      this.unformattedMPS2PinyinLabel.setText("MPSII Pinyin");
      this.unformattedMPS2PinyinPanel = new JPanel();
      this.unformattedMPS2PinyinPanel.setLayout(new BorderLayout());
      this.unformattedMPS2PinyinPanel.add(this.unformattedMPS2PinyinLabel, "North");
      this.unformattedMPS2PinyinPanel.add(getUnformattedMPS2PinyinScrollPane(), "Center");
    }
    return this.unformattedMPS2PinyinPanel;
  }
  
  private JScrollPane getUnformattedMPS2PinyinScrollPane()
  {
    if (this.unformattedMPS2PinyinScrollPane == null)
    {
      this.unformattedMPS2PinyinScrollPane = new JScrollPane();
      this.unformattedMPS2PinyinScrollPane.setViewportView(getUnformattedMPS2PinyinTextArea());
    }
    return this.unformattedMPS2PinyinScrollPane;
  }
  
  private JTextArea getUnformattedMPS2PinyinTextArea()
  {
    if (this.unformattedMPS2PinyinTextArea == null)
    {
      this.unformattedMPS2PinyinTextArea = new JTextArea();
      this.unformattedMPS2PinyinTextArea.setEditable(false);
      this.unformattedMPS2PinyinTextArea.setLineWrap(true);
    }
    return this.unformattedMPS2PinyinTextArea;
  }
  
  private JPanel getUnformattedTongyongPinyinPanel()
  {
    if (this.unformattedTongyongPinyinPanel == null)
    {
      this.unformattedTongyongPinyinLabel = new JLabel();
      this.unformattedTongyongPinyinLabel.setText("Tongyong Pinyin");
      this.unformattedTongyongPinyinPanel = new JPanel();
      this.unformattedTongyongPinyinPanel.setLayout(new BorderLayout());
      this.unformattedTongyongPinyinPanel.add(this.unformattedTongyongPinyinLabel, "North");
      this.unformattedTongyongPinyinPanel.add(getUnformattedTongyongPinyinScrollPane(), "Center");
    }
    return this.unformattedTongyongPinyinPanel;
  }
  
  private JScrollPane getUnformattedTongyongPinyinScrollPane()
  {
    if (this.unformattedTongyongPinyinScrollPane == null)
    {
      this.unformattedTongyongPinyinScrollPane = new JScrollPane();
      this.unformattedTongyongPinyinScrollPane.setViewportView(getUnformattedTongyongPinyinTextArea());
    }
    return this.unformattedTongyongPinyinScrollPane;
  }
  
  private JTextArea getUnformattedTongyongPinyinTextArea()
  {
    if (this.unformattedTongyongPinyinTextArea == null)
    {
      this.unformattedTongyongPinyinTextArea = new JTextArea();
      this.unformattedTongyongPinyinTextArea.setEditable(false);
      this.unformattedTongyongPinyinTextArea.setLineWrap(true);
    }
    return this.unformattedTongyongPinyinTextArea;
  }
  
  private JPanel getUnformattedWadePinyinPanel()
  {
    if (this.unformattedWadePinyinPanel == null)
    {
      this.unformattedWadePinyinLabel = new JLabel();
      this.unformattedWadePinyinLabel.setText("Wade-Giles  Pinyin");
      this.unformattedWadePinyinPanel = new JPanel();
      this.unformattedWadePinyinPanel.setLayout(new BorderLayout());
      this.unformattedWadePinyinPanel.add(this.unformattedWadePinyinLabel, "North");
      this.unformattedWadePinyinPanel.add(getUnformattedWadePinyinScrollPane(), "Center");
    }
    return this.unformattedWadePinyinPanel;
  }
  
  private JScrollPane getUnformattedWadePinyinScrollPane()
  {
    if (this.unformattedWadePinyinScrollPane == null)
    {
      this.unformattedWadePinyinScrollPane = new JScrollPane();
      this.unformattedWadePinyinScrollPane.setViewportView(getUnformattedWadePinyinTextArea());
    }
    return this.unformattedWadePinyinScrollPane;
  }
  
  private JTextArea getUnformattedWadePinyinTextArea()
  {
    if (this.unformattedWadePinyinTextArea == null)
    {
      this.unformattedWadePinyinTextArea = new JTextArea();
      this.unformattedWadePinyinTextArea.setEditable(false);
      this.unformattedWadePinyinTextArea.setLineWrap(true);
    }
    return this.unformattedWadePinyinTextArea;
  }
  
  private JPanel getUnformattedYalePinyinPanel()
  {
    if (this.unformattedYalePinyinPanel == null)
    {
      this.unformattedYalePinyinLabel = new JLabel();
      this.unformattedYalePinyinLabel.setText("Yale Pinyin");
      this.unformattedYalePinyinPanel = new JPanel();
      this.unformattedYalePinyinPanel.setLayout(new BorderLayout());
      this.unformattedYalePinyinPanel.add(this.unformattedYalePinyinLabel, "North");
      this.unformattedYalePinyinPanel.add(getUnformattedYalePinyinScrollPane(), "Center");
    }
    return this.unformattedYalePinyinPanel;
  }
  
  private JScrollPane getUnformattedYalePinyinScrollPane()
  {
    if (this.unformattedYalePinyinScrollPane == null)
    {
      this.unformattedYalePinyinScrollPane = new JScrollPane();
      this.unformattedYalePinyinScrollPane.setViewportView(getUnformattedYalePinyinTextArea());
    }
    return this.unformattedYalePinyinScrollPane;
  }
  
  private JTextArea getUnformattedYalePinyinTextArea()
  {
    if (this.unformattedYalePinyinTextArea == null)
    {
      this.unformattedYalePinyinTextArea = new JTextArea();
      this.unformattedYalePinyinTextArea.setEditable(false);
      this.unformattedYalePinyinTextArea.setLineWrap(true);
    }
    return this.unformattedYalePinyinTextArea;
  }
  
  private JComboBox getVCharTypesComboBox()
  {
    if (this.vCharTypesComboBox == null) {
      this.vCharTypesComboBox = new JComboBox(this.vCharTypes);
    }
    return this.vCharTypesComboBox;
  }
  
  public static void main(String[] paramArrayOfString)
  {
    paramArrayOfString = new Pinyin4jAppletDemo();
    System.runFinalizersOnExit(true);
    JFrame localJFrame = new JFrame(appName);
    localJFrame.addWindowListener(new Pinyin4jAppletDemo.1(paramArrayOfString));
    localJFrame.add("Center", paramArrayOfString);
    paramArrayOfString.init();
    paramArrayOfString.start();
    localJFrame.setSize(APP_SIZE);
    localJFrame.pack();
    localJFrame.setVisible(true);
  }
  
  public void init()
  {
    setSize(APP_SIZE);
    setContentPane(getJContentPane());
    setName(appName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     demo.Pinyin4jAppletDemo
 * JD-Core Version:    0.7.0.1
 */