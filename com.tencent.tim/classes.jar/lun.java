import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService.1;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService.2;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class lun
{
  private static lun b;
  private ConcurrentHashMap<Integer, WeakReference<lir>> bq = new ConcurrentHashMap();
  private DecimalFormat decimalFormat = new DecimalFormat("0.00");
  private int mSeq;
  
  public static lun a()
  {
    if (b == null) {
      b = new lun();
    }
    return b;
  }
  
  private void aC(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = (Integer)paramToServiceMsg.getAttributes().get("seq");
    if (localObject == null) {}
    do
    {
      do
      {
        return;
        localObject = (WeakReference)this.bq.get(localObject);
      } while (localObject == null);
      localObject = (lir)((WeakReference)localObject).get();
    } while (localObject == null);
    ((lir)localObject).onReceive(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private boolean j(ToServiceMsg paramToServiceMsg)
  {
    int i;
    int k;
    if (paramToServiceMsg.getAttribute(lir.afi) != null)
    {
      i = ((Integer)paramToServiceMsg.getAttribute(lir.afi)).intValue();
      if (i == 2)
      {
        k = 1;
        QLog.d("ReadInJoyMSFService", 1, new Object[] { "is68bRetryReq = ", Boolean.valueOf(k), ", retryTimes = ", Integer.valueOf(i) });
      }
    }
    for (;;)
    {
      int n = k;
      int j;
      if (paramToServiceMsg.getAttribute("retryIndex") != null)
      {
        j = ((Integer)paramToServiceMsg.getAttribute("retryIndex")).intValue();
        if (j <= 0) {
          break label162;
        }
      }
      label162:
      for (i = 1;; i = 0)
      {
        n = k | i;
        QLog.d("ReadInJoyMSFService", 1, new Object[] { "is68bRetryReq = ", Boolean.valueOf(n), ", fastResendRetryIndex = ", Integer.valueOf(j) });
        if (n != 0) {
          QLog.d("ReadInJoyMSFService", 1, " isRetryRequest | 68b Retry");
        }
        return n;
        m = 0;
        break;
      }
      int m = 0;
    }
  }
  
  public final void a(ToServiceMsg paramToServiceMsg, lir paramlir)
  {
    if ((paramToServiceMsg == null) || (paramlir == null)) {
      return;
    }
    paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    paramlir = new WeakReference(paramlir);
    kxm.o().post(new ReadInJoyMSFService.1(this, paramToServiceMsg, paramlir));
    g(paramToServiceMsg);
  }
  
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Exception paramException)
  {
    Object localObject = null;
    if (paramToServiceMsg == null) {
      return;
    }
    float f = (float)(System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey")) / 1000.0F;
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyMSFService", 2, "[RES]cmd=" + paramFromServiceMsg.getServiceCmd() + " app seq:" + paramFromServiceMsg.getAppSeq() + " during " + this.decimalFormat.format(f) + "sec.");
      }
      boolean bool = paramToServiceMsg.extraData.getBoolean("req_pb_protocol_flag", false);
      if (QLog.isDevelopLevel()) {
        QLog.d("ReadInJoy", 4, "bPbResp:" + bool);
      }
      paramException = localObject;
      if (paramBoolean)
      {
        if (!bool) {
          break label477;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyMSFService", 2, "PB cmd: recv cmd: " + paramFromServiceMsg.getServiceCmd());
        }
        paramException = localObject;
        if (paramFromServiceMsg.getWupBuffer() != null)
        {
          int i = paramFromServiceMsg.getWupBuffer().length - 4;
          paramException = new byte[i];
          aqoj.copyData(paramException, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
          paramFromServiceMsg.putWupBuffer(paramException);
          paramException = paramFromServiceMsg.getWupBuffer();
        }
      }
    }
    for (;;)
    {
      aC(paramToServiceMsg, paramFromServiceMsg, paramException);
      return;
      if (paramFromServiceMsg.getResultCode() == 2008)
      {
        paramFromServiceMsg = BaseActivity.sTopActivity;
        paramToServiceMsg = paramFromServiceMsg;
        if (paramFromServiceMsg == null) {
          paramToServiceMsg = kxm.getAppRuntime().getApplication();
        }
        paramFromServiceMsg = new Intent(paramToServiceMsg, NotificationActivity.class);
        paramFromServiceMsg.setFlags(872415232);
        paramFromServiceMsg.putExtra("type", 2);
        paramToServiceMsg.startActivity(paramFromServiceMsg);
        return;
      }
      if (paramException != null)
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        paramException.printStackTrace(new PrintStream(localByteArrayOutputStream));
        paramException = new String(localByteArrayOutputStream.toByteArray());
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadInJoyMSFService", 2, "[NOT SEND]cmd=" + paramFromServiceMsg.getServiceCmd() + ", " + paramException);
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("ReadInJoyMSFService", 2, "[RES]cmd=" + paramFromServiceMsg.getServiceCmd() + ",CODE=" + paramFromServiceMsg.getResultCode() + " during " + this.decimalFormat.format(f) + "sec.");
      break;
      label477:
      if (0 != 0) {}
      try
      {
        throw new NullPointerException();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        paramException = localObject;
      }
      paramException = localObject;
      if (QLog.isColorLevel())
      {
        QLog.d("ReadInJoyMSFService", 2, "bpc null");
        paramException = localObject;
        continue;
        if (QLog.isColorLevel())
        {
          QLog.d("ReadInJoyMSFService", 2, "", localException);
          paramException = localObject;
        }
      }
    }
  }
  
  public void aEL()
  {
    this.mSeq = 0;
    this.bq.clear();
  }
  
  public void g(ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = new ReadInJoyMSFService.2(this, paramToServiceMsg);
    kxm.o().post(paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lun
 * JD-Core Version:    0.7.0.1
 */