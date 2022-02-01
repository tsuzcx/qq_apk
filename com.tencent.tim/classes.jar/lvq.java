import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.pts.nativemodule.IPTSLoadFeeds;
import com.tencent.qphone.base.util.QLog;

public class lvq
  implements IPTSLoadFeeds
{
  private final String TAG = "PTSLoadFeedsModule";
  private lur.a a = new lvr(this);
  
  public lvq()
  {
    lur.a().a(this.a);
  }
  
  public void loadFeeds(long paramLong1, long paramLong2, int paramInt, long paramLong3)
  {
    lcd locallcd = (lcd)((QQAppInterface)kxm.getAppRuntime()).getManager(163);
    QLog.i("PTSLoadFeedsModule", 1, "[loadFeeds], channelID = " + paramLong1 + ", limitCount = " + paramInt);
    if (locallcd != null) {
      locallcd.b().a((int)paramLong1, paramInt, 9223372036854775807L, true, paramLong3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lvq
 * JD-Core Version:    0.7.0.1
 */