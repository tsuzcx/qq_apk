import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;

class dgi
  implements View.OnClickListener
{
  dgi(dgh paramdgh) {}
  
  @SuppressLint({"NewApi"})
  public void onClick(View paramView)
  {
    if ((RegisterQQNumberActivity.a(this.a.a) != null) && (RegisterQQNumberActivity.a(this.a.a).isShowing())) {
      RegisterQQNumberActivity.a(this.a.a).dismiss();
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      ((android.text.ClipboardManager)this.a.a.getSystemService("clipboard")).setText(RegisterQQNumberActivity.a(this.a.a) + "");
      return;
    }
    ((android.content.ClipboardManager)this.a.a.getSystemService("clipboard")).setText(RegisterQQNumberActivity.a(this.a.a) + "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dgi
 * JD-Core Version:    0.7.0.1
 */