import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput;
import com.tencent.qphone.base.util.BaseApplication;

public class dpo
  implements DialogInterface.OnClickListener
{
  public dpo(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = TroopInfoActivity.a(this.a).getInputValue();
    if ((paramDialogInterface != null) && (!paramDialogInterface.equals("")) && (!paramDialogInterface.equals(this.a.c)))
    {
      if (!NetworkUtil.e(BaseApplication.getContext())) {
        break label80;
      }
      if (!paramDialogInterface.equals(this.a.a.f))
      {
        this.a.p();
        this.a.b(paramDialogInterface);
      }
    }
    return;
    label80:
    this.a.a(2131562452, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dpo
 * JD-Core Version:    0.7.0.1
 */