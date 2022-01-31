import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareActivity;
import com.tencent.mobileqq.utils.VipUtils;

public class esf
  implements DialogInterface.OnClickListener
{
  public esf(QvipSpecialCareActivity paramQvipSpecialCareActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    VipUtils.b(this.a, 3, "mvip.gongneng.mobileqq.tiexintixing.numberandroid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     esf
 * JD-Core Version:    0.7.0.1
 */