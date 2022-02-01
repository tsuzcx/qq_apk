import android.os.Handler;
import android.os.Message;
import android.widget.RelativeLayout;
import com.tencent.open.agent.DeviceFriendListOpenFrame;
import com.tencent.open.agent.DeviceFriendListOpenFrame.a;

public class arqo
  extends Handler
{
  public arqo(DeviceFriendListOpenFrame paramDeviceFriendListOpenFrame) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.this$0.gW.setPadding(0, 0, 40, 0);
      return;
    case 2: 
      this.this$0.gW.setPadding(0, 0, 0, 0);
      return;
    }
    this.this$0.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arqo
 * JD-Core Version:    0.7.0.1
 */