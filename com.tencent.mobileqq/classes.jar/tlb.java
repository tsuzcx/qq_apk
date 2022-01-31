import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QzoneTiantaiTranslucentBrowserActivity;
import cooperation.qzone.util.QZLog;

public class tlb
  extends BroadcastReceiver
{
  public tlb(QzoneTiantaiTranslucentBrowserActivity paramQzoneTiantaiTranslucentBrowserActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      QZLog.i("QzoneTiantaiTranslucentBrowserActivity", "收到广播，视频播放完毕");
      QzoneTiantaiTranslucentBrowserActivity.a(this.a, true);
      QzoneTiantaiTranslucentBrowserActivity.a(this.a);
      return;
    }
    catch (Exception paramContext)
    {
      QZLog.e("QzoneTiantaiTranslucentBrowserActivity", "onReceive error", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tlb
 * JD-Core Version:    0.7.0.1
 */