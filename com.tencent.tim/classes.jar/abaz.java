import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class abaz
  implements View.OnClickListener
{
  public abaz(QQSpecialFriendSettingActivity paramQQSpecialFriendSettingActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (QQToast.MK() == 0)
    {
      localObject = new acsz(this.a, this.a.app, QQSpecialFriendSettingActivity.a(this.a));
      ((acsz)localObject).setOnDismissListener(new abba(this, (acsz)localObject));
      ((acsz)localObject).show();
      anot.a(null, "dc00898", "", "", "0X8009ACB", "0X8009ACB", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialFriendSettingActivity", 2, "finish all setings");
      }
      if (aqiw.isNetworkAvailable(this.a))
      {
        boolean bool1 = QQSpecialFriendSettingActivity.a(this.a).isChecked();
        boolean bool2 = QQSpecialFriendSettingActivity.b(this.a).isChecked();
        localObject = QQSpecialFriendSettingActivity.a(this.a);
        String str = QQSpecialFriendSettingActivity.a(this.a);
        int i = QQSpecialFriendSettingActivity.a(this.a);
        ((FriendListHandler)localObject).a(str, new int[] { 2, 3 }, new boolean[] { bool1, bool2 }, new String[] { String.valueOf(i), null });
        localObject = this.a.mHandler.obtainMessage(8193);
        ((Message)localObject).obj = this.a.getString(2131701719);
        this.a.mHandler.sendMessage((Message)localObject);
        if ((bool1) && (bool2)) {}
        for (localObject = "0";; localObject = "1")
        {
          anot.a(null, "CliOper", "", "", "0X80050E2", "0X80050E2", 0, 0, (String)localObject, "", "", "");
          break;
        }
      }
      localObject = this.a.mHandler.obtainMessage(8195);
      ((Message)localObject).arg1 = 0;
      ((Message)localObject).arg2 = 2131693404;
      this.a.mHandler.sendMessage((Message)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abaz
 * JD-Core Version:    0.7.0.1
 */