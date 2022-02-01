import android.os.Handler;
import android.os.Message;
import com.tencent.biz.subscribe.comment.EmoView;

public class zgn
  extends Handler
{
  public zgn(EmoView paramEmoView) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i;
    if (paramMessage.what == 0)
    {
      i = EmoView.a(this.a) + 1;
      if ((i <= 4) && (EmoView.a(this.a)[EmoView.a(this.a)] == 0)) {}
    }
    else
    {
      return;
    }
    EmoView.a(this.a, i);
    EmoView.a(this.a)[EmoView.a(this.a)] = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zgn
 * JD-Core Version:    0.7.0.1
 */