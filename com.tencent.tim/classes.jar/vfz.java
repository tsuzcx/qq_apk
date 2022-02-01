import com.tencent.mobileqq.activity.LikeSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class vfz
  extends ajqz
{
  public vfz(LikeSettingActivity paramLikeSettingActivity) {}
  
  public void aM(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LikeSettingActivity", 2, "onGetNotifyOnLikeSwitch.isSuccess=" + paramBoolean1 + ",open=" + paramBoolean2);
    }
    if (paramBoolean1) {
      LikeSettingActivity.a(this.this$0, this.this$0.D.a(), paramBoolean2);
    }
  }
  
  public void aN(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LikeSettingActivity", 2, "onSetNotifyOnLikeSwitch.isSuccess=" + paramBoolean1 + ",open=" + paramBoolean2);
    }
    if (!paramBoolean1)
    {
      QQToast.a(this.this$0, 1, 2131719890, 0).show(this.this$0.getTitleBarHeight());
      paramBoolean1 = ((ajpg)this.this$0.app.getManager(161)).aro();
      LikeSettingActivity.a(this.this$0, this.this$0.D.a(), paramBoolean1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vfz
 * JD-Core Version:    0.7.0.1
 */