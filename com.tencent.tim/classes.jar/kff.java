import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class kff
  implements View.OnClickListener
{
  kff(kfa paramkfa) {}
  
  public void onClick(View paramView)
  {
    QLog.i("DailyHeaderViewController", 1, "[onClick] clickToGrantPermission");
    BaseActivity localBaseActivity = (BaseActivity)paramView.getContext();
    if (Build.VERSION.SDK_INT >= 23) {
      if (localBaseActivity.shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION")) {
        kfa.a(this.this$0, true);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localBaseActivity.requestPermissions(new kfg(this, localBaseActivity), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      continue;
      kfa.a(this.this$0, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kff
 * JD-Core Version:    0.7.0.1
 */