import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

public class wch
  implements DialogInterface.OnClickListener
{
  public wch(BlessSelectMemberActivity paramBlessSelectMemberActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.g(this.a.getApplicationContext())) {
      QQToast.a(this.a, 2131437513, 1).a();
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      return;
      this.a.U_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wch
 * JD-Core Version:    0.7.0.1
 */