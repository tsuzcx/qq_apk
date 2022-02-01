import android.os.Bundle;
import android.os.Looper;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.service.MobileQQServiceBase.1;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseActionListener;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;

public abstract class amzq
  implements acbn
{
  public static HashMap<String, UniPacket> mZ = new HashMap();
  public static volatile int seq;
  private volatile boolean cEA;
  private DecimalFormat decimalFormat = new DecimalFormat("0.00");
  private ConcurrentHashMap<String, swr> gX;
  
  public static boolean oQ(String paramString)
  {
    return ("OnlinePush.PbPushGroupMsg".equalsIgnoreCase(paramString)) || ("OnlinePush.PbPushDisMsg".equalsIgnoreCase(paramString)) || ("OnlinePush.PbC2CMsgSync".equalsIgnoreCase(paramString)) || ("NearFieldTranFileSvr.NotifyList".equalsIgnoreCase(paramString)) || ("NearFieldDiscussSvr.NotifyList".equalsIgnoreCase(paramString)) || ("OnlinePush.PbPushC2CMsg".equalsIgnoreCase(paramString)) || ("ImStatus.ReqPushStatus".equalsIgnoreCase(paramString)) || ("OnlinePush.PbPushBindUinGroupMsg".equalsIgnoreCase(paramString));
  }
  
  public UniPacket a(ToServiceMsg paramToServiceMsg)
  {
    if ("StreamSvr.UploadStreamMsg".equalsIgnoreCase(paramToServiceMsg.getServiceCmd()))
    {
      String str = paramToServiceMsg.extraData.getString("filepath");
      UniPacket localUniPacket = (UniPacket)mZ.get(str);
      Object localObject;
      if (localUniPacket == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MobileQQServiceBase", 2, "no saved packet, new one " + str);
        }
        localObject = new amzu(true);
        mZ.clear();
        mZ.put(str, localObject);
      }
      for (;;)
      {
        paramToServiceMsg = Short.valueOf(paramToServiceMsg.extraData.getShort("PackSeq"));
        int i = anqo.b(str);
        if (paramToServiceMsg.shortValue() <= i)
        {
          mZ.remove(str);
          if (QLog.isColorLevel()) {
            QLog.d("MobileQQServiceBase", 2, "last stream, remove " + i + ", " + paramToServiceMsg);
          }
        }
        return localObject;
        localObject = localUniPacket;
        if (QLog.isColorLevel())
        {
          QLog.d("MobileQQServiceBase", 2, "got last packet, reuse it " + str);
          localObject = localUniPacket;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MobileQQServiceBase", 2, "not stream ptt");
    }
    return new UniPacket(true);
  }
  
  public swr a(String paramString)
  {
    if (!this.cEA) {}
    int i;
    try
    {
      if (!this.cEA) {
        aTq();
      }
      i = paramString.indexOf('.');
      if (i <= 1) {
        return null;
      }
    }
    finally {}
    paramString = paramString.substring(0, i);
    return (swr)this.gX.get(paramString);
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, aefh paramaefh, Class<? extends MSFServlet> paramClass)
  {
    paramToServiceMsg = new MobileQQServiceBase.1(this, paramToServiceMsg, paramaefh, paramClass);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.post(paramToServiceMsg, 10, null, false);
      return;
    }
    paramToServiceMsg.run();
  }
  
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Exception paramException)
  {
    if (paramToServiceMsg == null) {
      return;
    }
    AppInterface localAppInterface = getAppInterface();
    float f = (float)(System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey")) / 1000.0F;
    label104:
    Object localObject;
    accg localaccg;
    boolean bool;
    label170:
    int i;
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MobileQQServiceBase", 2, "[RES]cmd=" + paramFromServiceMsg.getServiceCmd() + " app seq:" + paramFromServiceMsg.getAppSeq() + " during " + this.decimalFormat.format(f) + "sec.");
      }
      localObject = null;
      localaccg = null;
      bool = paramToServiceMsg.extraData.getBoolean("req_pb_protocol_flag", false);
      if (QLog.isDevelopLevel()) {
        QLog.d("MobileQQServiceBase", 4, "bPbResp:" + bool);
      }
      if (bool) {
        break label698;
      }
      bool = oQ(paramFromServiceMsg.getServiceCmd());
      paramException = (IBaseActionListener)paramToServiceMsg.getAttribute("listener");
      if (paramException != null) {
        paramToServiceMsg.actionListener = paramException;
      }
      if (!bool) {
        localObject = a(paramFromServiceMsg.getServiceCmd());
      }
      paramException = localaccg;
      if (paramBoolean)
      {
        if (!bool) {
          break label567;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MobileQQServiceBase", 2, "PB cmd: recv cmd: " + paramFromServiceMsg.getServiceCmd());
        }
        paramException = localaccg;
        if (paramFromServiceMsg.getWupBuffer() != null)
        {
          i = paramFromServiceMsg.getWupBuffer().length - 4;
          paramException = new byte[i];
          aqoj.copyData(paramException, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
          paramFromServiceMsg.putWupBuffer(paramException);
          paramException = paramFromServiceMsg.getWupBuffer();
        }
      }
    }
    label567:
    label698:
    label701:
    for (;;)
    {
      for (;;)
      {
        i(paramFromServiceMsg);
        if ((!bool) && (localObject == null)) {
          break;
        }
        localObject = (int[])acct.ad().get(paramFromServiceMsg.getServiceCmd());
        if ((localObject == null) || (localObject.length <= 0)) {
          break;
        }
        int j = localObject.length;
        i = 0;
        label358:
        if (i >= j) {
          break;
        }
        localaccg = (accg)localAppInterface.getBusinessHandler(localObject[i]);
        if (localaccg != null) {}
        try
        {
          localaccg.onReceive(paramToServiceMsg, paramFromServiceMsg, paramException);
          i += 1;
          break label358;
          if (paramException != null)
          {
            localObject = new ByteArrayOutputStream();
            paramException.printStackTrace(new PrintStream((OutputStream)localObject));
            paramException = new String(((ByteArrayOutputStream)localObject).toByteArray());
            if (!QLog.isColorLevel()) {
              break label104;
            }
            QLog.d("MobileQQServiceBase", 2, "[NOT SEND]cmd=" + paramFromServiceMsg.getServiceCmd() + ", " + paramException);
            break label104;
          }
          if (!QLog.isColorLevel()) {
            break label104;
          }
          QLog.w("MobileQQServiceBase", 2, "[RES]cmd=" + paramFromServiceMsg.getServiceCmd() + ",CODE=" + paramFromServiceMsg.getResultCode() + " during " + this.decimalFormat.format(f) + "sec.");
          break label104;
          if (localObject != null) {}
          try
          {
            ((swr)localObject).h(paramToServiceMsg, paramFromServiceMsg);
            paramException = ((swr)localObject).a(paramToServiceMsg, paramFromServiceMsg);
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            paramException = localaccg;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MobileQQServiceBase", 2, "bpc null");
          }
          paramException = null;
          break label701;
          if (QLog.isColorLevel())
          {
            QLog.d("MobileQQServiceBase", 2, "", localException1);
            paramException = localaccg;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localException2.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.w("MobileQQServiceBase", 2, localaccg.getClass().getSimpleName() + " onReceive error,", localException2);
            }
          }
        }
      }
      break label170;
    }
  }
  
  protected boolean a(swr paramswr)
  {
    int i = 0;
    String[] arrayOfString = paramswr.y();
    if ((arrayOfString == null) || (arrayOfString.length == 0)) {
      return false;
    }
    while (i < arrayOfString.length)
    {
      this.gX.put(arrayOfString[i], paramswr);
      i += 1;
    }
    return true;
  }
  
  protected void aTq()
  {
    try
    {
      if (this.gX == null) {
        this.gX = new ConcurrentHashMap();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, aefh paramaefh, Class<? extends MSFServlet> paramClass)
  {
    int j = 0;
    int i = 0;
    int k = 0;
    Object localObject2 = null;
    boolean bool = paramToServiceMsg.extraData.getBoolean("req_pb_protocol_flag", false);
    AppInterface localAppInterface = getAppInterface();
    if (bool)
    {
      if ("tim_qdisk_svr.req".equals(paramToServiceMsg.getServiceCmd()))
      {
        i = 1;
        j = k;
        localObject1 = localObject2;
      }
      while (i != 0)
      {
        paramToServiceMsg.actionListener = paramaefh;
        paramaefh = new NewIntent(localAppInterface.getApplication(), paramClass);
        paramaefh.putExtra(ToServiceMsg.class.getSimpleName(), paramToServiceMsg);
        localAppInterface.startServlet(paramaefh);
        long l = System.currentTimeMillis();
        paramToServiceMsg.extraData.putLong("sendtimekey", l);
        label117:
        return;
        localObject1 = localObject2;
        j = k;
        if (paramToServiceMsg.getWupBuffer() != null)
        {
          l = paramToServiceMsg.getWupBuffer().length;
          localObject1 = new byte[(int)l + 4];
          aqoj.DWord2Byte((byte[])localObject1, 0, 4L + l);
          aqoj.b((byte[])localObject1, 4, paramToServiceMsg.getWupBuffer(), (int)l);
          paramToServiceMsg.putWupBuffer((byte[])localObject1);
          int m = 1;
          localObject1 = localObject2;
          i = m;
          j = k;
          if (QLog.isColorLevel())
          {
            QLog.d("MobileQQServiceBase", 2, "PB cmd: req cmd: " + paramToServiceMsg.getServiceCmd());
            localObject1 = localObject2;
            i = m;
            j = k;
          }
        }
      }
    }
    Object localObject1 = a(paramToServiceMsg.getServiceCmd());
    if (localObject1 != null)
    {
      localObject2 = a(paramToServiceMsg);
      ((UniPacket)localObject2).setEncodeName("utf-8");
      i = seq;
      seq = i + 1;
      ((UniPacket)localObject2).setRequestId(i);
      if (((swr)localObject1).yg())
      {
        localObject2 = ((swr)localObject1).a(paramToServiceMsg);
        if (localObject2 == null) {
          break label700;
        }
        paramToServiceMsg.putWupBuffer((byte[])localObject2);
      }
    }
    label700:
    for (i = 1;; i = 0)
    {
      k = 1;
      j = i;
      i = k;
      for (;;)
      {
        k = i;
        i = j;
        j = k;
        break;
        if (((swr)localObject1).a(paramToServiceMsg, (UniPacket)localObject2))
        {
          paramToServiceMsg.putWupBuffer(((UniPacket)localObject2).encode());
          j = 1;
          i = 0;
          continue;
          if ("RegPrxySvc.infoSync".equals(paramToServiceMsg.getServiceCmd()))
          {
            QLog.i("MobileQQServiceBase", 1, "infoSync error! lookupCoder is null!");
            localObject2 = (MessageHandler)localAppInterface.getBusinessHandler(0);
            if (localObject2 != null)
            {
              ((MessageHandler)localObject2).notifyUI(4004, false, null);
              QLog.i("jensenweng", 1, "notifyUI failed!");
            }
            localObject2 = new HashMap();
            ((HashMap)localObject2).put("param_uin", localAppInterface.getCurrentAccountUin());
            if ((this.gX != null) && (this.gX.keySet().size() > 0)) {
              ((HashMap)localObject2).put("param_coderMap", this.gX.keySet().toString());
            }
            anpc.a(BaseApplication.getContext()).collectPerformance(null, "prxyLookupCoderNull", true, 0L, 0L, (HashMap)localObject2, null);
          }
          j = k;
          break;
          if ((!bool) && ((localObject1 == null) || (j != 0))) {
            break label117;
          }
          paramaefh = new FromServiceMsg(localAppInterface.getCurrentAccountUin(), paramToServiceMsg.getServiceCmd());
          paramClass = (int[])acct.ad().get(paramToServiceMsg.getServiceCmd());
          if ((paramClass == null) || (paramClass.length <= 0)) {
            break label117;
          }
          j = paramClass.length;
          i = 0;
          label592:
          if (i < j)
          {
            localObject1 = (accg)localAppInterface.getBusinessHandler(paramClass[i]);
            if ((localObject1 != null) && (!bool)) {
              break label632;
            }
          }
          for (;;)
          {
            i += 1;
            break label592;
            break;
            try
            {
              label632:
              ((accg)localObject1).onReceive(paramToServiceMsg, paramaefh, null);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
            if (QLog.isColorLevel()) {
              QLog.w("MobileQQServiceBase", 2, localObject1.getClass().getSimpleName() + " onReceive error,", localException);
            }
          }
        }
        i = 0;
      }
    }
  }
  
  protected void dOJ()
  {
    try
    {
      this.cEA = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void dOK()
  {
    if (this.gX != null)
    {
      Iterator localIterator = this.gX.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (swr)this.gX.get(localObject);
        if (localObject != null)
        {
          try
          {
            ((swr)localObject).destroy();
          }
          catch (Exception localException) {}
          if (QLog.isColorLevel()) {
            QLog.d("MobileQQServiceBase", 2, "bpc destory error " + localException, localException);
          }
        }
      }
      this.gX.clear();
    }
    this.cEA = false;
  }
  
  public void destroy()
  {
    dOK();
  }
  
  public abstract AppInterface getAppInterface();
  
  protected void i(FromServiceMsg paramFromServiceMsg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     amzq
 * JD-Core Version:    0.7.0.1
 */