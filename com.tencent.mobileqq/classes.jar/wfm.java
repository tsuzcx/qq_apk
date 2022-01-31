import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

public class wfm
  implements DialogInterface.OnClickListener
{
  public wfm(BlessSelectMemberActivity paramBlessSelectMemberActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.g(this.a.getApplicationContext())) {
      QQToast.a(this.a, 2131437530, 1).a();
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      return;
      this.a.W_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wfm
 * JD-Core Version:    0.7.0.1
 */