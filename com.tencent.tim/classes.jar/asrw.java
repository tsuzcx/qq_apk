import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.activity.AuthDevUgActivity;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity2;
import com.tencent.qqconnect.wtlogin.Login;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqfav.util.HandlerPlus;

public class asrw
  implements View.OnClickListener
{
  public asrw(Login paramLogin) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.a.hF)
    {
      AuthDevUgActivity.zK(4);
      this.a.doLogin();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject;
      if (paramView == this.a.leftView)
      {
        localObject = (InputMethodManager)this.a.getSystemService("input_method");
        if (localObject != null) {
          ((InputMethodManager)localObject).hideSoftInputFromWindow(this.a.getWindow().getDecorView().getWindowToken(), 0);
        }
        localObject = this.a.b.obtainMessage();
        ((Message)localObject).what = 0;
        this.a.b.sendMessageDelayed((Message)localObject, 100L);
      }
      else if (paramView == this.a.Ar)
      {
        this.a.bG.setText("");
      }
      else if (paramView == this.a.Kj)
      {
        this.a.bH.setText("");
      }
      else if (paramView == this.a.aeu)
      {
        localObject = new Intent(this.a, LoginPhoneNumActivity2.class);
        ((Intent)localObject).putExtra("key_req_src", this.a.bIi);
        this.a.startActivityForResult((Intent)localObject, 10000);
      }
      else if (paramView == this.a.aev)
      {
        this.a.Qq();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asrw
 * JD-Core Version:    0.7.0.1
 */