import android.view.View;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity.8.1;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;

public class ufr
  implements ausj.a
{
  public ufr(ArkFullScreenAppActivity paramArkFullScreenAppActivity, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (ArkFullScreenAppActivity.a(this.this$0) != null)
    {
      adqu.b(this.this$0.app, "FullScreenClickOper", ArkFullScreenAppActivity.a(this.this$0).appName, null, adqu.cJl, 0, 0);
      adqu.a(this.this$0.app, ArkFullScreenAppActivity.a(this.this$0).appName, "FullScreenShareOper", 0, 0, 0L, 0L, 0L, "", "");
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("share click:");
      if (ArkFullScreenAppActivity.a(this.this$0) != null) {
        break label147;
      }
    }
    label147:
    for (paramView = "none";; paramView = ArkFullScreenAppActivity.a(this.this$0).appName)
    {
      QLog.d("ArkFullScreenAppActivity", 2, paramView);
      ArkAppCenter.a().post(ArkFullScreenAppActivity.a(this.this$0).appName, new ArkFullScreenAppActivity.8.1(this));
      this.val$sheet.dismiss();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ufr
 * JD-Core Version:    0.7.0.1
 */