import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import com.tencent.mobileqq.activity.QuickLoginActivity;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class bgj
  implements AdapterView.OnItemClickListener
{
  public bgj(QuickLoginActivity paramQuickLoginActivity) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (String)((HashMap)this.a.a.get(paramInt)).get("qq");
    libsafeedit.getLoginLegal((String)((HashMap)this.a.a.get(paramInt)).get("password"));
    paramView = libsafeedit.byteSafeEditTextToMD5(Boolean.valueOf(true));
    this.a.getAppRuntime().login(paramAdapterView, paramView, QuickLoginActivity.a(this.a));
    Toast.makeText(this.a.getApplicationContext(), "logining...", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bgj
 * JD-Core Version:    0.7.0.1
 */