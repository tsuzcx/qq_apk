import android.os.Handler;
import android.os.Message;
import com.tencent.biz.subscribe.comment.EmoView;

public class sdm
  extends Handler
{
  public sdm(EmoView paramEmoView) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i;
    if (paramMessage.what == 0)
    {
      i = EmoView.a(this.this$0) + 1;
      if ((i <= 4) && (EmoView.a(this.this$0)[EmoView.a(this.this$0)] == 0)) {}
    }
    else
    {
      return;
    }
    EmoView.a(this.this$0, i);
    EmoView.a(this.this$0)[EmoView.a(this.this$0)] = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sdm
 * JD-Core Version:    0.7.0.1
 */