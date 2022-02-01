import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.biz.troopgift.TroopGiftPanel.d;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class snh
  implements TroopGiftPanel.d
{
  public snh(TroopGiftPanel paramTroopGiftPanel, long paramLong1, long paramLong2) {}
  
  public void fj(List<apsz.a> paramList)
  {
    this.this$0.a.fh(paramList);
    long l = System.currentTimeMillis();
    QLog.d("TroopGiftPanel.time", 1, "setGiftData, reqTime=" + (l - this.CX) + ", total=" + (l - this.AG));
  }
  
  public void onError(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     snh
 * JD-Core Version:    0.7.0.1
 */