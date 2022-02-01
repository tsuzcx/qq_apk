import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

class yad
  extends BroadcastReceiver
{
  yad(xzp paramxzp) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.this$0.mGameRoomAVController != null) {
      this.this$0.mGameRoomAVController.reset(paramContext);
    }
    this.this$0.mActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     yad
 * JD-Core Version:    0.7.0.1
 */