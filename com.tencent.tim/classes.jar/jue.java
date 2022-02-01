import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.widget.FrameLayout;

public class jue
{
  public jue.a a;
  public boolean abN = true;
  Activity mActivity;
  Context mContext;
  BroadcastReceiver mReceiver = new juf(this);
  
  public jue(Activity paramActivity, jue.a parama)
  {
    this.mContext = paramActivity.getApplicationContext();
    this.mActivity = paramActivity;
    this.a = parama;
    paramActivity = new IntentFilter();
    paramActivity.addAction("android.intent.action.SCREEN_OFF");
    paramActivity.addAction("tencent.av.v2q.StartVideoChat");
    this.mContext.registerReceiver(this.mReceiver, paramActivity);
  }
  
  public void a(jzs paramjzs, FrameLayout paramFrameLayout) {}
  
  public void azQ() {}
  
  public void azR() {}
  
  public void ly(boolean paramBoolean) {}
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jue
 * JD-Core Version:    0.7.0.1
 */