import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView;

class apxb
  implements anyq.a
{
  apxb(apwy paramapwy) {}
  
  public void a(anyu paramanyu)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.this$0.asi >= 4)
    {
      acie.i("cartoon", "clk_inter", apwy.a(this.this$0).frienduin, aptj.b(apwy.a(this.this$0)) + "", "", "");
      paramanyu = apwy.a(this.this$0);
      if ((paramanyu != null) && (aqiw.getSystemNetwork(paramanyu) == 0))
      {
        ((TroopGiftToAllSurfaceView)this.this$0.c).ecC();
        paramanyu = paramanyu.getString(2131699827);
        ((TroopGiftToAllSurfaceView)this.this$0.c).aL(paramanyu, apwy.a(this.this$0).dgp, aqcx.dip2px(apwy.a(this.this$0), 16.0F));
      }
    }
    else
    {
      if (apwy.a(this.this$0) != null) {}
      for (paramanyu = "0";; paramanyu = "1")
      {
        anot.a(null, "dc00899", "Grp_flower", "", "forall", "Clk_grab", 0, 0, "" + apwy.a(this.this$0).frienduin, "" + aptj.b(apwy.a(this.this$0)), paramanyu, "" + jlk.a(localAppInterface, localAppInterface.getCurrentAccountUin(), apwy.a(this.this$0).frienduin));
        break;
      }
    }
    ((TroopGiftToAllSurfaceView)this.this$0.c).ecC();
    paramanyu = (apsz)localAppInterface.getManager(113);
    apwy.a(this.this$0).asm = NetConnInfoCenter.getServerTimeMillis();
    if (this.this$0.asi > 3)
    {
      paramanyu.b("OidbSvc.0x7f7", 2039, this.this$0.asi, apwy.a(this.this$0).frienduin, apwy.a(this.this$0).bagId, 3000L, apwy.a(this.this$0));
      return;
    }
    paramanyu.b("OidbSvc.0x6b5", 1717, this.this$0.asi, apwy.a(this.this$0).frienduin, apwy.a(this.this$0).bagId, 3000L, apwy.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apxb
 * JD-Core Version:    0.7.0.1
 */