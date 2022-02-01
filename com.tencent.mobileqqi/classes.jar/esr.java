import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundActivity;
import com.tencent.mobileqq.utils.VipUtils;

public class esr
  implements DialogInterface.OnClickListener
{
  public esr(QvipSpecialSoundActivity paramQvipSpecialSoundActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    VipUtils.b(this.a, 3, "mvip.gongneng.mobileqq.tiexintixing.ringandroid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     esr
 * JD-Core Version:    0.7.0.1
 */