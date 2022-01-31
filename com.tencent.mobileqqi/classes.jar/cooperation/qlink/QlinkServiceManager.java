package cooperation.qlink;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class QlinkServiceManager
  implements QlAndQQInterface.QQ2Ql
{
  private static final String jdField_a_of_type_JavaLangString = "QlinkServiceManager";
  private QlinkServiceProxy jdField_a_of_type_CooperationQlinkQlinkServiceProxy;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  
  public QlinkServiceManager(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_CooperationQlinkQlinkServiceProxy = new QlinkServiceProxy(paramAppRuntime);
  }
  
  private int a(String paramString, Bundle paramBundle)
  {
    try
    {
      int i = a(paramString, paramBundle, null, 0L);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  private int a(String paramString, Bundle paramBundle, Handler paramHandler, long paramLong)
  {
    paramHandler = new SendMsg(paramString);
    paramString = paramBundle;
    if (paramBundle == null) {
      paramString = new Bundle();
    }
    if ((paramString != null) && (paramString.size() > 0)) {
      paramHandler.a.putAll(paramString);
    }
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    paramHandler.a(i);
    if (paramLong > 0L) {
      paramHandler.a(paramLong);
    }
    try
    {
      this.jdField_a_of_type_CooperationQlinkQlinkServiceProxy.a(paramHandler);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      throw new RuntimeException("sendMsg is fail", paramString);
    }
  }
  
  public boolean a(long paramLong)
  {
    boolean bool = true;
    Bundle localBundle = new Bundle();
    localBundle.putLong("param.sessionid", paramLong);
    int i = a("cmd.discardsendmsg", localBundle);
    QLog.d("QlinkServiceManager", 1, "[QLINK]-QQ QQ2QlDiscardSendMsgOnWaitToolong:" + i);
    if (i == -1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean a(long paramLong1, int paramInt, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    boolean bool = true;
    long l = MessageCache.a();
    Bundle localBundle = new Bundle();
    localBundle.putLong("FROMUIN", paramLong1);
    localBundle.putInt("MSGSEQ", paramInt);
    localBundle.putLong("MSGUID", paramLong2);
    localBundle.putLong("MSGTIME", paramLong3);
    localBundle.putLong("RECVMSGTIME", l);
    if (paramArrayOfByte1 != null) {
      localBundle.putByteArray("C2CTMPMSGHEAD", paramArrayOfByte1);
    }
    localBundle.putByteArray("MSGBODY", paramArrayOfByte2);
    paramInt = a("cmd.onpushmsg", localBundle);
    QLog.d("QlinkServiceManager", 1, "[QLINK] QQ - onPushMsgReceived:" + paramInt);
    if (paramInt == -1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean a(long paramLong, QLAndQQStructDef.QQ2QlMsgRecord paramQQ2QlMsgRecord)
  {
    boolean bool = true;
    int i = a("cmd.sendmsgrecord", RequestSender.a(paramLong, paramQQ2QlMsgRecord));
    QLog.d("QlinkServiceManager", 1, "[QLINK]-QQ QQ2QlSendMsgRecord:" + i);
    if (i == -1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean a(long paramLong, boolean paramBoolean, QLAndQQStructDef.QQ2QlNeedDataOfMsg paramQQ2QlNeedDataOfMsg)
  {
    boolean bool = true;
    int i = a("cmd.isnewmsg", RequestSender.a(paramLong, paramBoolean, paramQQ2QlNeedDataOfMsg));
    QLog.d("QlinkServiceManager", 1, "[QLINK]-QQ QQ2QlIsNewMsg:" + i);
    paramBoolean = bool;
    if (i == -1) {
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  public boolean a(String paramString1, long paramLong, String paramString2)
  {
    boolean bool = true;
    int i = a("cmd.canceltans", RequestSender.a(paramString1, paramLong, paramString2));
    QLog.d("QlinkServiceManager", 1, "[QLINK]-QQ QQ2QlCancelTrans:" + i);
    if (i == -1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean a(String paramString, QLAndQQStructDef.QQ2QlRecvFileInfo paramQQ2QlRecvFileInfo)
  {
    boolean bool = true;
    int i = a("cmd.recvfilemsg", RequestSender.a(paramString, paramQQ2QlRecvFileInfo));
    QLog.d("QlinkServiceManager", 1, "[QLINK]-QQ QQ2QlRecvFileMessage:" + i);
    if (i == -1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean a(String paramString, QLAndQQStructDef.QQ2QlSendFileInfo paramQQ2QlSendFileInfo)
  {
    boolean bool = true;
    int i = a("cmd.sendfilemsg", RequestSender.a(paramString, paramQQ2QlSendFileInfo));
    QLog.d("QlinkServiceManager", 1, "[QLINK]-QQ QQ2QlSendFileMsg:" + i);
    if (i == -1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean a(String paramString, QLAndQQStructDef.QQ2QlSendFileInfos paramQQ2QlSendFileInfos)
  {
    boolean bool = true;
    int i = a("cmd.sendfilemsgs", RequestSender.a(paramString, paramQQ2QlSendFileInfos));
    QLog.d("QlinkServiceManager", 1, "[QLINK]-QQ QQ2QlSendFileMsgs:" + i);
    if (i == -1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    boolean bool = true;
    int i = a("cmd.sendcontacthead", RequestSender.a(paramString1, paramString2));
    QLog.d("QlinkServiceManager", 1, "[QLINK]-QQ QQ2QlSetContactHeadOf:" + i);
    if (i == -1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    int i = a("cmd.recvunrecvfilemsg", RequestSender.a(paramString, paramBoolean));
    QLog.d("QlinkServiceManager", 1, "[QLINK]-QQ QQ2QlRecvUnrecvFileMessage:" + i);
    paramBoolean = bool;
    if (i == -1) {
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  public boolean a(boolean paramBoolean, int paramInt)
  {
    boolean bool = true;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("Result", paramBoolean);
    localBundle.putInt("Cookie", paramInt);
    paramInt = a("cmd.sendfilemsgsrsp", localBundle);
    QLog.d("QlinkServiceManager", 1, "[QLINK] QQ - onPushNotifyListReceived:" + paramInt);
    paramBoolean = bool;
    if (paramInt == -1) {
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    boolean bool = true;
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("NotifyList", paramArrayOfByte);
    int i = a("cmd.onpushnotifylistmsg", localBundle);
    QLog.d("QlinkServiceManager", 1, "[QLINK] QQ - onPushNotifyListReceived:" + i);
    if (i == -1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean c()
  {
    boolean bool = true;
    int i = a("cmd.exitfilebrowser", new Bundle());
    QLog.d("QlinkServiceManager", 1, "[QLINK]-QQ QQ2QlExitQlinkLocalFileBrowser:" + i);
    if (i == -1) {
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qlink.QlinkServiceManager
 * JD-Core Version:    0.7.0.1
 */