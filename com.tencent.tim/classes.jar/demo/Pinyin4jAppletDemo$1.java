package demo;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

final class Pinyin4jAppletDemo$1
  extends WindowAdapter
{
  private final Pinyin4jAppletDemo val$appletDemo;
  
  Pinyin4jAppletDemo$1(Pinyin4jAppletDemo paramPinyin4jAppletDemo)
  {
    this.val$appletDemo = paramPinyin4jAppletDemo;
  }
  
  public void windowClosing(WindowEvent paramWindowEvent)
  {
    this.val$appletDemo.stop();
    this.val$appletDemo.destroy();
    System.exit(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     demo.Pinyin4jAppletDemo.1
 * JD-Core Version:    0.7.0.1
 */