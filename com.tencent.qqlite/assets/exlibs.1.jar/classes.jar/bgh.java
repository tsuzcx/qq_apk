import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.widget.QQToast;

public class bgh
  extends SecSvcObserver
{
  public bgh(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    boolean bool = true;
    if (this.a.isFinishing()) {}
    do
    {
      return;
      if (paramBoolean)
      {
        paramString = this.a;
        if (paramInt == 1) {}
        for (paramBoolean = bool;; paramBoolean = false)
        {
          paramString.a(paramBoolean);
          return;
        }
      }
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    } while (!this.a.isResume());
    paramString = this.a.getString(2131364230);
    QQToast.a(this.a.getApplicationContext(), paramString, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bgh
 * JD-Core Version:    0.7.0.1
 */