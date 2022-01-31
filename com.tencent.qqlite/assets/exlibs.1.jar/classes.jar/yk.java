import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class yk
  implements View.OnClickListener
{
  public yk(AuthDevActivity paramAuthDevActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.b();
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.begin to CloseDevLock");
    }
    if (!AuthDevActivity.b(this.a)) {
      if ((AuthDevActivity.a(this.a) == null) || (!AuthDevActivity.a(this.a).isShowing())) {
        AuthDevActivity.b(this.a);
      }
    }
    int i;
    do
    {
      return;
      AuthDevActivity.b(this.a);
      AuthDevActivity.a(this.a, false);
      paramView = this.a.app.a();
      i = EquipmentLockImpl.a().b(this.a.app, paramView, AuthDevActivity.a(this.a));
    } while (i == 0);
    AuthDevActivity.c(this.a);
    AuthDevActivity.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.CloseDevLock fail ret =" + i);
    }
    QQToast.a(this.a.getApplicationContext(), this.a.getString(2131364225), 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     yk
 * JD-Core Version:    0.7.0.1
 */