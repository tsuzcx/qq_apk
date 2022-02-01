import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatHistory;

public class umx
  extends Handler
{
  public umx(ChatHistory paramChatHistory) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      if ((this.this$0.z != null) && (this.this$0.z.isShowing()) && (!this.this$0.isFinishing())) {
        this.this$0.z.dismiss();
      }
      this.this$0.z = new arhz(this.this$0, this.this$0.getTitleBarHeight());
      this.this$0.z.setCancelable(false);
      this.this$0.z.setMessage(2131692532);
      if (!this.this$0.isFinishing()) {
        this.this$0.z.show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     umx
 * JD-Core Version:    0.7.0.1
 */