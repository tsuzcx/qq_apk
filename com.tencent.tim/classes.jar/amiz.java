import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.qphone.base.util.QLog;

public class amiz
  implements Comparable<amiz>
{
  public MessageForScribble c;
  public int priority = 200;
  
  amiz(MessageForScribble paramMessageForScribble, int paramInt)
  {
    this.c = paramMessageForScribble;
    if (paramInt >= 200)
    {
      this.priority = paramInt;
      return;
    }
    QLog.e("ScribbleDownloadInfo", 1, "err priority");
  }
  
  public int a(amiz paramamiz)
  {
    if (this.priority < paramamiz.priority) {
      return -1;
    }
    if (this.priority > paramamiz.priority) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amiz
 * JD-Core Version:    0.7.0.1
 */