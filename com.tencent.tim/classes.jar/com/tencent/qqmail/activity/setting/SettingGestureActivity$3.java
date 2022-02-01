package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.ui.QMGesture;
import com.tencent.qqmail.utilities.ui.QMGesture.OnRollingListener;
import com.tencent.qqmail.utilities.ui.QMTips;

class SettingGestureActivity$3
  implements QMGesture.OnRollingListener
{
  private int localGesturePasswordVerifyTimes = 0;
  
  SettingGestureActivity$3(SettingGestureActivity paramSettingGestureActivity) {}
  
  private void toastFailAndFinish()
  {
    this.this$0.getTips().setCallback(new SettingGestureActivity.3.1(this));
    this.this$0.getTips().showError(2131719863);
  }
  
  public void onBegin() {}
  
  public void onFinish(String paramString, boolean paramBoolean)
  {
    if ((SettingGestureActivity.access$100(this.this$0) == 0) || (SettingGestureActivity.access$100(this.this$0) == 3)) {
      if (!paramBoolean)
      {
        SettingGestureActivity.access$202(this.this$0, paramString);
        SettingGestureActivity.access$102(this.this$0, 1);
        SettingGestureActivity.access$300(this.this$0, paramString);
      }
    }
    do
    {
      return;
      SettingGestureActivity.access$400(this.this$0).setPswFail(true, paramString);
      SettingGestureActivity.access$400(this.this$0).postInvalidate();
      SettingGestureActivity.access$500(this.this$0);
      SettingGestureActivity.access$600(this.this$0);
      return;
      if (SettingGestureActivity.access$100(this.this$0) == 1)
      {
        SettingGestureActivity.access$700(this.this$0, paramString);
        return;
      }
      if (SettingGestureActivity.access$100(this.this$0) == 2)
      {
        SettingGestureActivity.access$800(this.this$0, paramString, QMSettingManager.sharedInstance().getTryGestureTimes(), new SettingGestureActivity.3.2(this));
        return;
      }
      if (SettingGestureActivity.access$100(this.this$0) == 4)
      {
        SettingGestureActivity.access$800(this.this$0, paramString, this.localGesturePasswordVerifyTimes, new SettingGestureActivity.3.3(this));
        return;
      }
      if (SettingGestureActivity.access$100(this.this$0) == 5)
      {
        SettingGestureActivity.access$800(this.this$0, paramString, this.localGesturePasswordVerifyTimes, new SettingGestureActivity.3.4(this));
        return;
      }
    } while (SettingGestureActivity.access$100(this.this$0) != 6);
    SettingGestureActivity.access$800(this.this$0, paramString, this.localGesturePasswordVerifyTimes, new SettingGestureActivity.3.5(this));
  }
  
  public void onItemCheck(int paramInt, String paramString) {}
  
  public void onReset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingGestureActivity.3
 * JD-Core Version:    0.7.0.1
 */