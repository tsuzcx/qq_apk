import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;

public class aefn
  implements DialogInterface.OnDismissListener
{
  public aefn(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "onDismiss|pickerType : " + this.this$0.pickerType);
    }
    if (this.this$0.pickerType == 0)
    {
      this.this$0.av.setRightTextColor(2);
      this.this$0.b.gS(this.this$0.mAgeSelectIndex1, this.this$0.mAgeSelectIndex2);
      paramDialogInterface = this.this$0.b.B(this.this$0.mAgeSelectIndex1, this.this$0.mAgeSelectIndex2);
      if (AppSetting.enableTalkBack)
      {
        this.this$0.av.setContentDescription(acfp.m(2131704252) + paramDialogInterface);
        aqcl.speak(this.this$0.av, acfp.m(2131704255) + paramDialogInterface);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearchFriendActivity", 2, "onDismiss|mCurAgeIndex1 : " + this.this$0.mCurAgeIndex1 + ", mCurAgeIndex2 : " + this.this$0.mCurAgeIndex2 + ", mAgeSelectIndex1 : " + this.this$0.mAgeSelectIndex1 + ", mAgeSelectIndex2 : " + this.this$0.mAgeSelectIndex2);
      }
      anot.a(this.this$0.app, "CliOper", "", "", "0X8004243", "0X8004243", 0, 0, this.this$0.mAgeSelectIndex1 + "", this.this$0.mAgeSelectIndex2 + "", "", "");
    }
    for (;;)
    {
      this.this$0.d = null;
      if (ConditionSearchFriendActivity.a(this.this$0) > 0)
      {
        this.this$0.By.scrollBy(0, -ConditionSearchFriendActivity.a(this.this$0));
        ConditionSearchFriendActivity.b(this.this$0, 0);
      }
      return;
      if (this.this$0.pickerType == 3)
      {
        this.this$0.az.setRightTextColor(2);
        this.this$0.b.IM(this.this$0.cMu);
        if (AppSetting.enableTalkBack)
        {
          this.this$0.az.setContentDescription(acfp.m(2131704254) + accv.dT[this.this$0.cMu]);
          aqcl.speak(this.this$0.az, acfp.m(2131704265) + accv.dT[this.this$0.cMu]);
        }
        anot.a(this.this$0.app, "CliOper", "", "", "0X8006F0B", "0X8006F0B", 0, 0, this.this$0.cMu + "", "", "", "");
      }
      else
      {
        this.this$0.GO = null;
        paramDialogInterface = ConditionSearchFriendActivity.a(this.this$0);
        String[] arrayOfString = new String[4];
        arrayOfString[0] = this.this$0.mLocationCountyCode;
        arrayOfString[1] = this.this$0.mLocationCodeArray[0];
        arrayOfString[2] = this.this$0.mLocationCodeArray[1];
        arrayOfString[3] = this.this$0.mLocationCodeArray[2];
        if (this.this$0.pickerType == 1)
        {
          this.this$0.aw.setRightTextColor(2);
          this.this$0.b.bZ(0, paramDialogInterface);
          this.this$0.b.H(arrayOfString);
          if (AppSetting.enableTalkBack)
          {
            this.this$0.aw.setContentDescription(acfp.m(2131704251) + paramDialogInterface);
            aqcl.speak(this.this$0.aw, acfp.m(2131704250) + paramDialogInterface);
          }
        }
        else if (this.this$0.pickerType == 2)
        {
          this.this$0.ax.setRightTextColor(2);
          this.this$0.b.bZ(1, paramDialogInterface);
          this.this$0.b.I(arrayOfString);
          if (AppSetting.enableTalkBack)
          {
            this.this$0.ax.setContentDescription(acfp.m(2131704261) + paramDialogInterface);
            aqcl.speak(this.this$0.ax, acfp.m(2131704262) + paramDialogInterface);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aefn
 * JD-Core Version:    0.7.0.1
 */