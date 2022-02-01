package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

final class Pinyin4jAppletDemo$3
  implements ActionListener
{
  private final Pinyin4jAppletDemo this$0;
  
  Pinyin4jAppletDemo$3(Pinyin4jAppletDemo paramPinyin4jAppletDemo)
  {
    this.this$0 = paramPinyin4jAppletDemo;
  }
  
  public void actionPerformed(ActionEvent paramActionEvent)
  {
    if (this.this$0.toneTypes[2] == (String)Pinyin4jAppletDemo.access$100(this.this$0).getSelectedItem())
    {
      Pinyin4jAppletDemo.access$200(this.this$0).setSelectedIndex(2);
      Pinyin4jAppletDemo.access$200(this.this$0).setEnabled(false);
      return;
    }
    Pinyin4jAppletDemo.access$200(this.this$0).setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     demo.Pinyin4jAppletDemo.3
 * JD-Core Version:    0.7.0.1
 */