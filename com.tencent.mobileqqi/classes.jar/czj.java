import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class czj
  implements DialogInterface.OnClickListener
{
  czj(czi paramczi) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.a.a.a.isFinishing())
    {
      paramDialogInterface.dismiss();
      this.a.a.a.showDialog(1);
    }
    if (!NetworkUtil.e(this.a.a.a))
    {
      QQToast.a(this.a.a.a, 0, this.a.a.a.getResources().getString(2131562488), 0).b(this.a.a.a.d());
      return;
    }
    if (this.a.a.a.a == null)
    {
      this.a.a.a.a = new czk(this);
      this.a.a.a.b.registObserver(this.a.a.a.a);
    }
    PermisionPrivacyActivity.c(this.a.a.a).c();
    PermisionPrivacyActivity.a(this.a.a.a, 2131562875, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     czj
 * JD-Core Version:    0.7.0.1
 */