import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;

public class aawo
  extends BroadcastReceiver
{
  public aawo(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((aqiw.isNetSupport(this.this$0.mContext)) && (this.this$0.bAB) && (this.this$0.isResume()))
    {
      if (this.this$0.mHandler.hasMessages(0)) {
        this.this$0.mHandler.removeMessages(0);
      }
      this.this$0.mHandler.sendEmptyMessage(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aawo
 * JD-Core Version:    0.7.0.1
 */