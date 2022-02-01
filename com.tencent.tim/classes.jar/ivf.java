import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.lang.ref.WeakReference;

final class ivf
  implements ivc.b.a
{
  ivf(String paramString1, QQAppInterface paramQQAppInterface, String paramString2, int paramInt, long paramLong, WeakReference paramWeakReference) {}
  
  public void C(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 2) {
      jjk.b.g(paramInt1, paramInt2, this.atT, this.val$groupUin);
    }
    ivc.a(this.kQ, (Context)this.bA.get());
  }
  
  public void D(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 2) {
      jjk.b.g(paramInt1, paramInt2, this.atT, this.val$groupUin);
    }
  }
  
  public Bitmap a(long paramLong)
  {
    return this.val$app.a(this.val$groupUin, (byte)1, false, false);
  }
  
  public TroopInfoData a()
  {
    TroopInfoData localTroopInfoData = new TroopInfoData();
    localTroopInfoData.troopUin = this.val$groupUin;
    localTroopInfoData.updateForTroopInfo(((TroopManager)this.val$app.getManager(52)).c(this.val$groupUin), this.val$app.getCurrentAccountUin());
    return localTroopInfoData;
  }
  
  public String aR(int paramInt)
  {
    return "0X800A3E4";
  }
  
  public String d(long paramLong, int paramInt)
  {
    return this.val$url;
  }
  
  public String getDesc()
  {
    return ivc.a(this.val$app, this.val$groupUin);
  }
  
  public String hh()
  {
    return ivc.dw(this.val$groupUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ivf
 * JD-Core Version:    0.7.0.1
 */