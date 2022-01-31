import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;

public class ys
  extends SecSvcObserver
{
  public ys(AuthDevActivity paramAuthDevActivity) {}
  
  protected void a(int paramInt, Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramBundle == null) {
      return;
    }
    paramInt = paramBundle.getInt("cmd", 1);
    int i = paramBundle.getInt("opt", 2);
    int j = paramBundle.getInt("ret", -1);
    paramBundle = (String)paramBundle.get("wording");
    FormSwitchItem localFormSwitchItem;
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      if (j == 0)
      {
        AuthDevActivity.a(this.a).setVisibility(0);
        AuthDevActivity.a(this.a).setOnCheckedChangeListener(null);
        localFormSwitchItem = AuthDevActivity.a(this.a);
        if (i == 1) {}
        for (;;)
        {
          localFormSwitchItem.setChecked(bool1);
          AuthDevActivity.a(this.a).setOnCheckedChangeListener(AuthDevActivity.a(this.a));
          AuthDevActivity.b(this.a).setVisibility(0);
          AuthDevActivity.b(this.a).setText(paramBundle);
          return;
          bool1 = false;
        }
      }
      AuthDevActivity.a(this.a).setVisibility(8);
      AuthDevActivity.b(this.a).setVisibility(8);
      return;
    }
    if (j == 0)
    {
      AuthDevActivity.a(this.a).setOnCheckedChangeListener(null);
      localFormSwitchItem = AuthDevActivity.a(this.a);
      if (i == 1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        localFormSwitchItem.setChecked(bool1);
        AuthDevActivity.a(this.a).setOnCheckedChangeListener(AuthDevActivity.a(this.a));
        AuthDevActivity.b(this.a).setText(paramBundle);
        return;
      }
    }
    AuthDevActivity.a(this.a).setVisibility(8);
    AuthDevActivity.b(this.a).setVisibility(8);
    QQToast.a(this.a, paramBundle, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ys
 * JD-Core Version:    0.7.0.1
 */