import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.widget.MenuPopupDialog;

class bhs
  implements View.OnClickListener
{
  bhs(bhr parambhr) {}
  
  @SuppressLint({"NewApi"})
  public void onClick(View paramView)
  {
    if (RegisterQQNumberActivity.a(this.a.a) != null) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bhs
 * JD-Core Version:    0.7.0.1
 */