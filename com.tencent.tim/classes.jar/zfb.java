import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;

public class zfb
  extends Handler
{
  public zfb(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      if ((this.this$0.z != null) && (this.this$0.z.isShowing())) {
        this.this$0.z.dismiss();
      }
      this.this$0.z = new arhz(this.this$0.getActivity(), this.this$0.getActivity().getTitleBarHeight());
      this.this$0.z.setCancelable(false);
      this.this$0.z.setMessage(2131692532);
      this.this$0.z.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zfb
 * JD-Core Version:    0.7.0.1
 */