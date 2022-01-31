package cooperation.qlink;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.OfflineFileMessageProcessor;
import com.tencent.mobileqq.filemanager.data.FMTransC2CMsgInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.qphone.base.util.QLog;
import ifi;

public class QQServiceForQlink
{
  private static final String jdField_a_of_type_JavaLangString = "QQServiceForQlink";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public QQServiceForQlink(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public static long a()
  {
    int i = MobileQQService.c;
    MobileQQService.c = i + 1;
    return (short)(int)((int)(i & 0xFFFFFFFF) & 0xFFFF);
  }
  
  public static long b()
  {
    return MessageUtils.a(MessageUtils.a());
  }
  
  public void a()
  {
    QLog.i("QQServiceForQlink", 1, "[QLINK] QQ - PluginCommunicationHandler.getInstance.RegisterQlink");
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler == null)
    {
      QLog.e("QQServiceForQlink", 1, "[QLINK] QQ - PluginCommunicationHandler.getInstance failed");
      return;
    }
    localPluginCommunicationHandler.register(new ifi(this, "qlink.notify"));
  }
  
  public void a(long paramLong)
  {
    this.a.a().a(true, (int)paramLong);
  }
  
  public boolean a(String paramString, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2)
  {
    FMTransC2CMsgInfo localFMTransC2CMsgInfo = new FMTransC2CMsgInfo();
    localFMTransC2CMsgInfo.subCmd = 8;
    localFMTransC2CMsgInfo.sessionId = paramInt2;
    localFMTransC2CMsgInfo.busiType = paramInt1;
    localFMTransC2CMsgInfo.msgSeq = FileManagerUtil.a();
    localFMTransC2CMsgInfo.msgUid = FileManagerUtil.b();
    if (((FriendManager)this.a.getManager(8)).b(paramString))
    {
      QLog.i("QQServiceForQlink", 1, "[QLINK] QQ - send0x211C2CQlinkMsg to frirend:" + paramString + " transC2CMsgInfo:" + localFMTransC2CMsgInfo.toString());
      return this.a.a().a().a(paramString, 529, paramArrayOfByte1, localFMTransC2CMsgInfo);
    }
    QLog.i("QQServiceForQlink", 1, "[QLINK] QQ - send0x211C2CQlinkMsg to temp frirend:" + paramString + " transC2CMsgInfo:" + localFMTransC2CMsgInfo.toString());
    return this.a.a().a().a(paramString, 529, paramArrayOfByte2, 1, 124, paramArrayOfByte1, localFMTransC2CMsgInfo);
  }
  
  public void b(long paramLong)
  {
    this.a.a().a(false, (int)paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qlink.QQServiceForQlink
 * JD-Core Version:    0.7.0.1
 */