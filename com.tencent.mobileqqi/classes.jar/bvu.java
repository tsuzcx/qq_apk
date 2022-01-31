import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class bvu
  implements View.OnClickListener
{
  public bvu(AuthDevActivity paramAuthDevActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.b();
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.begin to CloseDevLock");
    }
    if (!AuthDevActivity.b(this.a)) {
      if ((AuthDevActivity.a(this.a) == null) || (!AuthDevActivity.a(this.a).isShowing())) {
        AuthDevActivity.a(this.a);
      }
    }
    int i;
    do
    {
      return;
      AuthDevActivity.a(this.a);
      AuthDevActivity.a(this.a, false);
      paramView = this.a.b.a();
      i = EquipmentLockImpl.a().b(this.a.b, paramView, AuthDevActivity.a(this.a));
    } while (i == 0);
    AuthDevActivity.b(this.a);
    AuthDevActivity.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.CloseDevLock fail ret =" + i);
    }
    QQToast.a(this.a.getApplicationContext(), this.a.getString(2131562040), 0).b(this.a.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bvu
 * JD-Core Version:    0.7.0.1
 */