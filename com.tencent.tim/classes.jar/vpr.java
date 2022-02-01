import MQQ.PrivExtV2Rsp;
import MQQ.VipUserInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.QQSettingMe.29.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class vpr
  extends acnz
{
  public vpr(QQSettingMe paramQQSettingMe) {}
  
  protected void av(boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (paramInt >= 0) && (this.this$0.app != null))
    {
      Object localObject = this.this$0.app.getPreferences();
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putInt("key_selfvip_growthvalue", paramInt).commit();
      }
      localObject = this.this$0.app.getCurrentAccountUin();
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "updateLevelAndVip from mVipInfoObserver");
      }
      this.this$0.we((String)localObject);
    }
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1) {
      if (paramBoolean)
      {
        paramObject = ((PrivExtV2Rsp)paramObject).vipInfo;
        if ((paramObject != null) && (paramObject.bUpdate == 1))
        {
          paramObject = paramObject.sUri;
          if (paramObject != null)
          {
            QQSettingMe.b(this.this$0, paramObject);
            if (QLog.isColorLevel()) {
              QLog.d("QQSettingRedesign", 2, "vip url = " + paramObject);
            }
            paramObject = this.this$0.app.getApplication().getSharedPreferences(this.this$0.app.getCurrentAccountUin(), 4).edit().putString("VIPCenter_url_key", paramObject);
            if (Build.VERSION.SDK_INT >= 9) {
              break label170;
            }
            paramObject.commit();
          }
        }
        paramObject = this.this$0.app.getCurrentAccountUin();
        this.this$0.we(paramObject);
        this.this$0.bO.post(new QQSettingMe.29.1(this));
      }
    }
    label170:
    do
    {
      return;
      paramObject.apply();
      break;
      if (paramInt == 4)
      {
        this.this$0.bO.sendEmptyMessage(2);
        return;
      }
    } while (paramInt != 5);
    this.this$0.bO.sendMessage(this.this$0.bO.obtainMessage(3, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vpr
 * JD-Core Version:    0.7.0.1
 */