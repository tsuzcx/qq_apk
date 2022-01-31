package cooperation.qzone;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import ibr;

public class CrashNotificationActivity
  extends Activity
{
  private Dialog a = null;
  
  private Dialog a()
  {
    AlertDialog localAlertDialog = new AlertDialog.Builder(this).create();
    localAlertDialog.show();
    Object localObject = localAlertDialog.getWindow();
    ((Window)localObject).setContentView(2130903294);
    Button localButton1 = (Button)((Window)localObject).findViewById(2131231994);
    Button localButton2 = (Button)((Window)localObject).findViewById(2131231993);
    localObject = (TextView)((Window)localObject).findViewById(2131231988);
    if ((localButton1 == null) || (localObject == null)) {
      return null;
    }
    ((TextView)localObject).setText(getString(2131562388) + "6.0.2" + getString(2131562560));
    localObject = new ibr(this);
    localButton1.setOnClickListener((View.OnClickListener)localObject);
    localButton2.setOnClickListener((View.OnClickListener)localObject);
    return localAlertDialog;
  }
  
  private void b()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
    this.a = null;
    try
    {
      this.a = a();
      if (this.a != null)
      {
        this.a.setCancelable(false);
        this.a.show();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a();
      }
    }
  }
  
  public void a()
  {
    finish();
  }
  
  public void finish()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
    this.a = null;
    super.finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903293);
    b();
  }
  
  public void onUserLeaveHint()
  {
    super.onUserLeaveHint();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qzone.CrashNotificationActivity
 * JD-Core Version:    0.7.0.1
 */