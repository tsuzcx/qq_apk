import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView;

class apxa
  extends apsy
{
  apxa(apwy paramapwy) {}
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString)
  {
    if (this.this$0.c == null) {
      return;
    }
    synchronized (this.this$0.c)
    {
      if ((apwy.a(this.this$0) == null) || (this.this$0.c == null)) {
        return;
      }
    }
    apwy.a(this.this$0).asn = NetConnInfoCenter.getServerTimeMillis();
    apwy.a(this.this$0).dXO = 2;
    if (apwy.a(this.this$0).Cc > 0L)
    {
      if (apwy.a(this.this$0).asn > apwy.a(this.this$0).Cc + 3000L) {
        return;
      }
      this.this$0.uiHandler.removeCallbacks(apwy.a(this.this$0));
      this.this$0.lV(2000L);
    }
    if (!TextUtils.isEmpty(paramString)) {
      if (paramInt1 <= 0) {
        break label224;
      }
    }
    label224:
    for (paramInt1 = apwy.a(this.this$0).dgo;; paramInt1 = apwy.a(this.this$0).dgp)
    {
      ((TroopGiftToAllSurfaceView)this.this$0.c).aL(paramString, paramInt1, aqcx.dip2px(apwy.a(this.this$0), 16.0F));
      ((TroopGiftToAllSurfaceView)this.this$0.c).ecC();
      return;
    }
  }
  
  public void onError(int paramInt, String paramString)
  {
    if (this.this$0.c == null) {
      return;
    }
    synchronized (this.this$0.c)
    {
      if ((apwy.a(this.this$0) == null) || (this.this$0.c == null)) {
        return;
      }
    }
    if (paramInt == 20005)
    {
      apwy.a(this.this$0).dXO = 3;
      paramString = (apsz)((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(113);
      if (this.this$0.asi > 3) {
        paramString.b("OidbSvc.0x7f7", 2039, this.this$0.asi, apwy.a(this.this$0).frienduin, apwy.a(this.this$0).bagId, 3000L, apwy.a(this.this$0));
      }
    }
    String str1;
    String str2;
    label299:
    do
    {
      for (;;)
      {
        return;
        paramString.b("OidbSvc.0x6b5", 1717, this.this$0.asi, apwy.a(this.this$0).frienduin, apwy.a(this.this$0).bagId, 3000L, apwy.a(this.this$0));
      }
      if (paramInt != -1) {
        break label497;
      }
      str1 = apwy.a(this.this$0).getResources().getString(2131699971);
      str2 = acbn.dQ[aqiw.getSystemNetwork(apwy.a(this.this$0))];
      if (this.this$0.asi < 4) {
        break;
      }
      acie.i("cartoon", "timeout", apwy.a(this.this$0).frienduin, aptj.b(apwy.a(this.this$0)) + str2, "", "");
      break label546;
      if (!(this.this$0.c instanceof TroopGiftToAllSurfaceView)) {
        break label549;
      }
      ((TroopGiftToAllSurfaceView)this.this$0.c).aL(paramString, apwy.a(this.this$0).dgp, aqcx.dip2px(apwy.a(this.this$0), 16.0F));
      apwy.a(this.this$0).dXO = 2;
    } while (apwy.a(this.this$0).Cc <= 0L);
    if (apwy.a(this.this$0).asn > apwy.a(this.this$0).Cc + 3000L)
    {
      return;
      if (apwy.a(this.this$0) == null) {
        break label551;
      }
    }
    label546:
    label549:
    label551:
    for (paramString = "0";; paramString = "1")
    {
      anot.a(null, "dc00899", "Grp_flower", "", "forall", "timeout", 0, 0, "" + apwy.a(this.this$0).frienduin, "" + aptj.b(apwy.a(this.this$0)), paramString, str2);
      break label546;
      label497:
      paramString = apwy.a(this.this$0).getResources().getString(2131699970);
      break label299;
      this.this$0.uiHandler.removeCallbacks(apwy.a(this.this$0));
      this.this$0.lV(2000L);
      break;
      paramString = str1;
      break label299;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apxa
 * JD-Core Version:    0.7.0.1
 */