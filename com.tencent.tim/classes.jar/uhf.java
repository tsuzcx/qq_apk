import android.view.View;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class uhf
  implements ausj.a
{
  public uhf(AuthDevActivity paramAuthDevActivity, String paramString, ArrayList paramArrayList, int paramInt, boolean paramBoolean, long paramLong) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((AuthDevActivity.b(this.this$0) != null) && (AuthDevActivity.b(this.this$0).isShowing()) && (!this.this$0.isFinishing()))
      {
        AuthDevActivity.b(this.this$0).dismiss();
        AuthDevActivity.b(this.this$0).cancel();
        AuthDevActivity.b(this.this$0, null);
      }
      return;
      if (!aqiw.isNetSupport(this.this$0))
      {
        QQToast.a(this.this$0, this.this$0.getString(2131693404), 0).show(this.this$0.getTitleBarHeight());
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "OnClick.begin to delAuthDev");
        }
        anot.a(this.this$0.app, "CliOper", "", "", "My_eq_lock", "My_eq_lock_delete", 0, 0, "", "", "", "");
        if (afsf.a().a(this.this$0.app, this.val$name, this.val$list, this.val$i, this.aRK, this.Y)) {
          AuthDevActivity.b(this.this$0);
        } else if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "OnClick.delAuthDev fail");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uhf
 * JD-Core Version:    0.7.0.1
 */