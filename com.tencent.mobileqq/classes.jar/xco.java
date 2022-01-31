import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.troopgift.TroopGiftPanel;

public class xco
  implements DialogInterface.OnClickListener
{
  public xco(TroopGiftPanel paramTroopGiftPanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (paramInt == 1)
    {
      bbrk.a(this.a.a, "mvip.n.a.qlw_forsvip", "CJCLUBT", 3, false, true);
      axqy.b(null, "dc00899", "grp_lbs", "", "qq_gift", "svip_sure_click", 0, 0, "", "", "", "");
    }
    while (paramInt != 0) {
      return;
    }
    axqy.b(null, "dc00899", "grp_lbs", "", "qq_gift", "svip_cancel_click", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xco
 * JD-Core Version:    0.7.0.1
 */