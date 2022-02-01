import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.utils.Singleton;
import cooperation.weiyun.channel.pb.WeiyunPB.MsgHead;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public final class awps
{
  private static Singleton<awps, Void> sInstance = new awpt();
  private long aBu = 1L;
  private ConcurrentHashMap<Integer, awps.a> kh = new ConcurrentHashMap();
  private AtomicInteger mSeq = new AtomicInteger(0);
  
  public static awps a()
  {
    return (awps)sInstance.get(null);
  }
  
  private void c(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      QLog.e("WySender", 1, "sendRequestInner : seq[" + paramInt + "], cmd is empty");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WySender", 1, "sendRequestInner : seq[" + paramInt + "], cmd[" + paramString + "]");
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String[] arrayOfString;
    if (paramString.contains(".")) {
      arrayOfString = paramString.split("\\.");
    }
    for (int i = Integer.parseInt(arrayOfString[(arrayOfString.length - 1)]);; i = Integer.parseInt(paramString))
    {
      paramArrayOfByte = new awpp(i, paramArrayOfByte);
      paramString = new ToServiceMsg("mobileqq.service", localAppRuntime.getAccount(), paramString);
      paramString.setTimeout(Math.min(60000L, (30000.0D * Math.pow(this.aBu, 0.15D))));
      paramString.setEnableFastResend(true);
      paramString.putWupBuffer(awpq.a(paramArrayOfByte));
      paramString.extraData.putInt("sequence", paramInt);
      paramString.extraData.putLong("sendtimekey", System.currentTimeMillis());
      paramArrayOfByte = new NewIntent(localAppRuntime.getApplication(), awpu.class);
      paramArrayOfByte.putExtra(ToServiceMsg.class.getSimpleName(), paramString);
      localAppRuntime.startServlet(paramArrayOfByte);
      return;
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, awps.a parama)
  {
    int i = this.mSeq.incrementAndGet();
    if (parama != null) {
      this.kh.put(Integer.valueOf(i), parama);
    }
    c(i, paramString, paramArrayOfByte);
  }
  
  void aK(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = null;
    int k = paramToServiceMsg.extraData.getInt("sequence");
    int i;
    label40:
    awpp localawpp;
    if (paramFromServiceMsg.isSuccess())
    {
      i = 0;
      if (i != 1002) {
        break label150;
      }
      this.aBu += 1L;
      if (i != 0) {
        break label158;
      }
      localawpp = awpq.a(paramFromServiceMsg.getWupBuffer());
      label53:
      paramFromServiceMsg = paramFromServiceMsg.getBusinessFailMsg();
      paramToServiceMsg = paramFromServiceMsg;
      if (i == 1002) {
        paramToServiceMsg = "(1002)" + paramFromServiceMsg;
      }
      if (i != 0) {
        break label207;
      }
      if (localawpp != null) {
        break label164;
      }
      i = 1810023;
    }
    label150:
    label158:
    label164:
    label198:
    label207:
    for (;;)
    {
      label101:
      awps.a locala = (awps.a)this.kh.remove(Integer.valueOf(k));
      if (locala != null) {
        if (localawpp != null) {
          break label198;
        }
      }
      for (paramFromServiceMsg = localObject;; paramFromServiceMsg = localawpp.getData())
      {
        locala.b(i, paramToServiceMsg, paramFromServiceMsg);
        return;
        i = paramFromServiceMsg.getResultCode();
        break;
        this.aBu = 1L;
        break label40;
        localawpp = null;
        break label53;
        paramFromServiceMsg = localawpp.a();
        int j = paramFromServiceMsg.retcode.get();
        if (j == 0) {
          break label207;
        }
        paramToServiceMsg = paramFromServiceMsg.retmsg.get();
        i = j;
        break label101;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void b(int paramInt, String paramString, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awps
 * JD-Core Version:    0.7.0.1
 */