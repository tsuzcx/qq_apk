import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.emoticonview.EmotionPreviewLayout;

public class dew
  extends Handler
{
  public dew(EmotionPreviewLayout paramEmotionPreviewLayout) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 10000: 
      this.a.setVisibility(8);
      return;
    case 10001: 
      this.a.a(true);
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dew
 * JD-Core Version:    0.7.0.1
 */