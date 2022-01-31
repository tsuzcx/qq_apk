import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.emoticonview.EmotionPreviewLayout;

public class fth
  extends Handler
{
  public fth(EmotionPreviewLayout paramEmotionPreviewLayout) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    EmotionPreviewLayout.a(this.a);
    this.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fth
 * JD-Core Version:    0.7.0.1
 */