import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.protocol.GetArkTailReq;
import com.tencent.mobileqq.gamecenter.protocol.ReportTypeReq;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.observer.BusinessObserver;

public class ahto
{
  private static volatile ahto a;
  private Map<MessageRecord, Long> li = new HashMap();
  
  public static ahto a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ahto();
      }
      return a;
    }
    finally {}
  }
  
  public void a(long paramLong, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    Object localObject = (Long)this.li.get(paramMessageRecord);
    if (localObject == null) {}
    for (long l1 = 0L;; l1 = ((Long)localObject).longValue())
    {
      long l2 = NetConnInfoCenter.getServerTimeMillis();
      if (l2 - Long.valueOf(l1).longValue() <= 30000L) {
        break;
      }
      this.li.put(paramMessageRecord, Long.valueOf(l2));
      localObject = aagd.getQQAppInterface();
      if (localObject == null) {
        break;
      }
      GetArkTailReq localGetArkTailReq = new GetArkTailReq();
      localGetArkTailReq.appid = (paramLong + "");
      localGetArkTailReq.tt = 1;
      localGetArkTailReq.scene_id = 1;
      localGetArkTailReq.qq_version = aqgz.getQQVersion();
      zyb.a(localGetArkTailReq, new ahtq(this, paramMessageRecord, new WeakReference(localObject)));
      return;
    }
  }
  
  public void a(long paramLong, BusinessObserver paramBusinessObserver)
  {
    GetArkTailReq localGetArkTailReq = new GetArkTailReq();
    localGetArkTailReq.appid = (paramLong + "");
    localGetArkTailReq.tt = 1;
    localGetArkTailReq.scene_id = 3;
    localGetArkTailReq.qq_version = aqgz.getQQVersion();
    zyb.a(localGetArkTailReq, paramBusinessObserver);
  }
  
  public void ao(String paramString, int paramInt1, int paramInt2)
  {
    ReportTypeReq localReportTypeReq = new ReportTypeReq();
    localReportTypeReq.appid = paramString;
    localReportTypeReq.type = paramInt1;
    localReportTypeReq.sub_type = paramInt2;
    localReportTypeReq.tt = 1;
    zyb.a(localReportTypeReq, new ahtp(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahto
 * JD-Core Version:    0.7.0.1
 */