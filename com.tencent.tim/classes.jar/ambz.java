import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;

public class ambz
{
  private Map<String, int[]> cQ;
  private AppInterface mApp;
  
  public ambz(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
    this.cQ = new ConcurrentHashMap();
    c("TransInfoCreate.CreateSession", new int[] { 0 });
    c("TransInfo.JoinSession", new int[] { 0 });
    c("TransInfo.ExitSession", new int[] { 0 });
    c("TransInfo.ChangeSession", new int[] { 0 });
    c("TransInfo.RawData", new int[] { 0 });
  }
  
  public void a(ToServiceMsg paramToServiceMsg, aefh paramaefh, Class<? extends MSFServlet> paramClass)
  {
    if (paramToServiceMsg.getWupBuffer() != null)
    {
      long l = paramToServiceMsg.getWupBuffer().length;
      byte[] arrayOfByte = new byte[(int)l + 4];
      aqoj.DWord2Byte(arrayOfByte, 0, 4L + l);
      aqoj.b(arrayOfByte, 4, paramToServiceMsg.getWupBuffer(), (int)l);
      paramToServiceMsg.putWupBuffer(arrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("PeakMsfServletProxy", 2, "PB cmd: req cmd: " + paramToServiceMsg.getServiceCmd());
      }
      paramToServiceMsg.actionListener = paramaefh;
      paramaefh = new NewIntent(this.mApp.getApplication(), paramClass);
      paramaefh.putExtra(ToServiceMsg.class.getSimpleName(), paramToServiceMsg);
      this.mApp.startServlet(paramaefh);
      l = System.currentTimeMillis();
      paramToServiceMsg.extraData.putLong("sendtimekey", l);
    }
  }
  
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Exception paramException)
  {
    AppInterface localAppInterface = getAppInterface();
    float f = (float)(System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey")) / 1000.0F;
    Object localObject;
    int i;
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PeakMsfServletProxy", 2, "[RES]cmd=" + paramFromServiceMsg.getServiceCmd() + " app seq:" + paramFromServiceMsg.getAppSeq() + "sec." + f);
      }
      boolean bool = paramToServiceMsg.extraData.getBoolean("req_pb_protocol_flag", false);
      if ((!paramBoolean) || (!bool)) {
        break label501;
      }
      localObject = paramFromServiceMsg.getServiceCmd();
      if (QLog.isColorLevel()) {
        QLog.d("PeakMsfServletProxy", 2, "PB cmd: recv cmd: " + (String)localObject);
      }
      if (paramFromServiceMsg.getWupBuffer() == null) {
        break label502;
      }
      i = paramFromServiceMsg.getWupBuffer().length - 4;
      paramException = new byte[i];
      aqoj.copyData(paramException, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
      paramFromServiceMsg.putWupBuffer(paramException);
    }
    label226:
    label501:
    label502:
    for (paramException = paramFromServiceMsg.getWupBuffer();; paramException = null)
    {
      for (;;)
      {
        int[] arrayOfInt = (int[])this.cQ.get(localObject);
        if ((arrayOfInt != null) && (arrayOfInt.length > 0))
        {
          int j = arrayOfInt.length;
          i = 0;
          if (i >= j) {
            break label501;
          }
          localObject = (accg)localAppInterface.getBusinessHandler(arrayOfInt[i]);
          if (localObject != null) {}
          try
          {
            ((accg)localObject).onReceive(paramToServiceMsg, paramFromServiceMsg, paramException);
            i += 1;
            break label226;
            if (paramException != null)
            {
              localObject = new ByteArrayOutputStream();
              paramException.printStackTrace(new PrintStream((OutputStream)localObject));
              paramException = new String(((ByteArrayOutputStream)localObject).toByteArray());
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("PeakMsfServletProxy", 2, "[NOT SEND]cmd=" + paramFromServiceMsg.getServiceCmd() + ", " + paramException);
              break;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.w("PeakMsfServletProxy", 2, "[RES]cmd=" + paramFromServiceMsg.getServiceCmd() + ",CODE=" + paramFromServiceMsg.getResultCode() + "sec." + f);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
              if (QLog.isColorLevel()) {
                QLog.w("PeakMsfServletProxy", 2, localObject.getClass().getSimpleName() + " onReceive error,", localException);
              }
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.w("PeakMsfServletProxy", 2, " handlerIds no map " + (String)localObject);
      }
      return;
    }
  }
  
  protected boolean c(String paramString, int[] paramArrayOfInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.cQ.put(paramString, paramArrayOfInt);
      return true;
    }
    return false;
  }
  
  public AppInterface getAppInterface()
  {
    return this.mApp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ambz
 * JD-Core Version:    0.7.0.1
 */