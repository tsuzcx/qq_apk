import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import java.lang.ref.WeakReference;

public class sno
  implements DialogInterface.OnClickListener
{
  public sno(TroopGiftPanel paramTroopGiftPanel, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.this$0.a != null) && (this.this$0.a.a != null) && (!TextUtils.isEmpty(this.this$0.a.a.jumpUrl)))
    {
      this.this$0.bzA();
      if (this.this$0.byr == 2) {
        anot.a(null, "dc00899", "Grp_flower", "", "C2C", "Clk_topay", 0, 0, "", "", "", "");
      }
    }
    else
    {
      return;
    }
    if (this.this$0.byr == 6)
    {
      anot.a(null, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_topay", 0, 0, "", "", "", "");
      return;
    }
    if (this.this$0.byr == 7)
    {
      anot.a(null, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_topay", 0, 0, "", "", "", "");
      return;
    }
    if (this.this$0.asi >= 4)
    {
      acie.i("gift_store", "pay_tip", this.this$0.nD(), this.this$0.um() + "", "", "");
      return;
    }
    anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_topay", this.lM, 0, this.this$0.nD(), "", this.this$0.aFe, "" + jlk.a((AppInterface)this.this$0.n.get(), ((AppInterface)this.this$0.n.get()).getCurrentAccountUin(), this.this$0.nD()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sno
 * JD-Core Version:    0.7.0.1
 */