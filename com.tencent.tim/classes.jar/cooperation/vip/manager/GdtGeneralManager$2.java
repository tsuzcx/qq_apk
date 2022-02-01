package cooperation.vip.manager;

import awmc;
import awme;
import cooperation.qzone.util.QZLog;

public class GdtGeneralManager$2
  implements Runnable
{
  public GdtGeneralManager$2(awmc paramawmc, long paramLong, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("GdtGeneralManager", "getGdtInfoRequest uin= " + this.val$uin + "adv_type = " + this.eBM + "busineestype =" + this.eBN);
    }
    awmc.a(this.this$0, this.this$0.b());
    awme.a(this.val$uin, this.eBM, this.val$attachInfo, this.eBN, awmc.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.vip.manager.GdtGeneralManager.2
 * JD-Core Version:    0.7.0.1
 */