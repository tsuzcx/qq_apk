import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hiboom.FontBubble;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class ahyf
{
  private static AtomicInteger bq = new AtomicInteger();
  public FontBubble b;
  public int seq = bq.getAndIncrement();
  
  public ahyf(FontBubble paramFontBubble)
  {
    this.b = paramFontBubble;
  }
  
  public void cY(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.e("FontBubbleManager", 1, "setFontBubble: " + this.b.fontId + "," + this.b.bubbleId);
    }
    ((acle)paramQQAppInterface.getBusinessHandler(13)).aI(this.b.fontId, this.b.bubbleId, this.seq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahyf
 * JD-Core Version:    0.7.0.1
 */