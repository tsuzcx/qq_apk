import android.util.Log;
import com.tencent.av.common.ErrorInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;

public class ijl
  extends accg
{
  static Object at = new Object();
  static volatile HashMap<Long, ijl.b> cC;
  static volatile long ls = 1L;
  
  static
  {
    cC = new HashMap();
  }
  
  public ijl(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static int a(common.ErrorInfo paramErrorInfo)
  {
    if ((paramErrorInfo.has()) && (paramErrorInfo.uint32_errcode.has())) {
      return paramErrorInfo.uint32_errcode.get();
    }
    return -99;
  }
  
  private static ijl.a a(ijl.b paramb)
  {
    paramb = paramb.getClass().getGenericSuperclass();
    Object localObject;
    String str;
    if (paramb != null) {
      if ((paramb instanceof ParameterizedType))
      {
        localObject = ((ParameterizedType)paramb).getActualTypeArguments();
        if (localObject != null) {
          if (localObject.length == 2)
          {
            paramb = (Class)localObject[0];
            localObject = (Class)localObject[1];
            str = "reqType[" + paramb + "]rspType[" + localObject + "]";
          }
        }
      }
    }
    while (((paramb == null) || (localObject == null)) && (AudioHelper.isDev()))
    {
      throw new IllegalArgumentException("QAVMessageHandler get getClassInfo失败, " + str);
      str = "ActualTypeArguments长度为" + localObject.length;
      localObject = null;
      paramb = null;
      continue;
      localObject = null;
      str = "getActualTypeArguments为空";
      paramb = null;
      continue;
      str = "type[" + paramb.getClass().getName() + "]";
      localObject = null;
      paramb = null;
      continue;
      str = "genericInterfaces为空";
      localObject = null;
      paramb = null;
    }
    ijl.a locala = new ijl.a(null);
    locala.log = str;
    locala.i = paramb;
    locala.j = ((Class)localObject);
    return locala;
  }
  
  static ijl.b a(long paramLong)
  {
    synchronized (at)
    {
      ijl.b localb = (ijl.b)cC.get(Long.valueOf(paramLong));
      cC.remove(Long.valueOf(paramLong));
      return localb;
    }
  }
  
  public static String a(common.ErrorInfo paramErrorInfo)
  {
    if ((paramErrorInfo.has()) && (paramErrorInfo.bytes_errmsg.has())) {
      return paramErrorInfo.bytes_errmsg.get().toStringUtf8();
    }
    return "";
  }
  
  public static void a(long paramLong, AppInterface paramAppInterface, String paramString, MessageMicro paramMessageMicro, ijl.b paramb)
  {
    ijl localijl = (ijl)paramAppInterface.getBusinessHandler(52);
    paramAppInterface = new ToServiceMsg("", paramAppInterface.getCurrentAccountUin(), paramString);
    jlc.a(paramAppInterface.getAttributes(), paramLong);
    long l = bA();
    paramAppInterface.getAttributes().put("msgSeq_for_callback", Long.valueOf(l));
    a(l, paramb);
    paramAppInterface.putWupBuffer(paramMessageMicro.toByteArray());
    localijl.sendPbReq(paramAppInterface);
    if (QLog.isDevelopLevel()) {
      QLog.w("QAVMessageHandler", 1, "sendMsg, msgListener[" + paramb + "], msgSeq_for_callback[" + l + "], seq[" + paramLong + "]");
    }
  }
  
  static void a(long paramLong, ijl.b paramb)
  {
    synchronized (at)
    {
      cC.put(Long.valueOf(paramLong), paramb);
      return;
    }
  }
  
  static long bA()
  {
    try
    {
      ls += 1L;
      long l = ls;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected Class<? extends acci> observerClass()
  {
    return achq.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    long l2 = jlc.a(paramToServiceMsg.getAttributes());
    long l1 = 0L;
    Object localObject = paramToServiceMsg.getAttribute("msgSeq_for_callback");
    if ((localObject instanceof Integer)) {
      l1 = ((Integer)localObject).intValue();
    }
    for (;;)
    {
      localObject = a(l1);
      if (QLog.isColorLevel()) {
        QLog.w("QAVMessageHandler", 1, "onReceive, cmd[" + str + "], req_cmd[" + paramToServiceMsg.getServiceCmd() + "], isSuccess[" + paramFromServiceMsg.isSuccess() + "], RequestSsoSeq[" + paramToServiceMsg.getRequestSsoSeq() + "], ResultCode[" + paramFromServiceMsg.getResultCode() + "], RequestSsoSeq[" + paramFromServiceMsg.getRequestSsoSeq() + "], msgSeq_for_callback[" + l1 + "], msgListener[" + localObject + "], seq[" + l2 + "]");
      }
      if (localObject == null) {
        break;
      }
      ((ijl.b)localObject).a(l2, paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
      if ((localObject instanceof Long)) {
        l1 = ((Long)localObject).longValue();
      }
    }
    QLog.w("QAVMessageHandler", 1, "onReceive, 没有MsgListener， cmd[" + str + "], seq[" + l2 + "]");
  }
  
  static class a
  {
    Class<?> i;
    Class<?> j;
    String log;
    
    void o(String paramString, long paramLong)
    {
      if ((this.j == null) || (this.i == null)) {
        Log.d(paramString, "check ClassInfo, seq[" + paramLong + "], " + this.log);
      }
    }
  }
  
  public static abstract class b<T1 extends MessageMicro, T2 extends MessageMicro>
  {
    protected final void a(long paramLong, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
    {
      Object localObject = ijl.b(this);
      ((ijl.a)localObject).o("QAVMessageHandler", paramLong);
      if ((((ijl.a)localObject).i != null) && (((ijl.a)localObject).j != null)) {}
      try
      {
        MessageMicro localMessageMicro = (MessageMicro)((ijl.a)localObject).i.newInstance();
        localObject = (MessageMicro)((ijl.a)localObject).j.newInstance();
        paramToServiceMsg = paramToServiceMsg.getWupBuffer();
        if ((paramToServiceMsg != null) && (paramToServiceMsg.length > 4)) {
          localMessageMicro.mergeFrom(paramToServiceMsg, 4, paramToServiceMsg.length - 4);
        }
        ((MessageMicro)localObject).mergeFrom(paramFromServiceMsg.getWupBuffer());
        a(paramLong, paramFromServiceMsg.isSuccess(), localMessageMicro, (MessageMicro)localObject, paramObject);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.w("QAVMessageHandler", 1, "onSendMsgRsp, Exception, seq[" + paramLong + "]", paramToServiceMsg);
      }
    }
    
    public abstract void a(long paramLong, boolean paramBoolean, T1 paramT1, T2 paramT2, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ijl
 * JD-Core Version:    0.7.0.1
 */