import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.Manager;

public class ajkw
  implements Manager
{
  public static boolean cpd = true;
  private static byte[] lock = new byte[0];
  private long acg;
  private QQAppInterface app;
  public boolean cpe;
  public boolean cpf;
  
  public ajkw(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, long paramLong, String paramString2)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("StructLongTextMsg", 2, "requestDownloadLongTextMsg begin! touin:" + paramString1 + ",touinType:" + paramInt + ",uniseq:" + paramLong + ",fileKey:" + paramString2);
    }
    ajlc.a().a(paramQQAppInterface, paramString2, paramQQAppInterface.getCurrentAccountUin(), paramString1, paramString1, paramInt, paramLong, 1035, new ajkz(paramQQAppInterface, paramString1, paramInt, paramLong, l));
  }
  
  public static boolean bc(QQAppInterface paramQQAppInterface)
  {
    ajkw localajkw = (ajkw)paramQQAppInterface.getManager(166);
    if (!localajkw.cpe)
    {
      String str = paramQQAppInterface.getAccount();
      paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
      if (paramQQAppInterface.contains(str + "_" + "long_text_msg_config_version")) {
        localajkw.cpf = paramQQAppInterface.getBoolean(str + "_" + "long_text_msg_switch", cpd);
      }
    }
    localajkw.cpe = true;
    return localajkw.cpf;
  }
  
  public static void i(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramMessageRecord.extraflag = 32768;
    paramQQAppInterface.a().e(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    String str = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    long l = paramMessageRecord.uniseq;
    ((MessageHandler)paramQQAppInterface.getBusinessHandler(0)).notifyUI(MessageHandler.gz(paramMessageRecord.istroop), false, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = false;
    if (paramInt2 == 0) {
      bool = true;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_resultCode", String.valueOf(paramInt2));
    localHashMap.put("param_uin", paramQQAppInterface.getCurrentAccountUin());
    localHashMap.put("param_isTroop", String.valueOf(paramInt1));
    switch (paramInt3)
    {
    default: 
      return;
    case 1: 
      anpc.a(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "ltextAutoPullResult", bool, 0L, 0L, localHashMap, "");
      return;
    }
    anpc.a(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "ltextManualPullResult", bool, 0L, 0L, localHashMap, "");
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean, akyf paramakyf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructLongTextMsg", 4, " sendLongTextMsg start");
    }
    if (paramMessageRecord == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "step1: sendLongTextMsg saveMessage start currenttime:" + System.currentTimeMillis());
      }
      if ((paramMessageRecord instanceof ChatMessage)) {
        ((ChatMessage)paramMessageRecord).mPendantAnimatable = true;
      }
      if ((!paramBoolean) || (TextUtils.isEmpty(paramMessageRecord.extStr)))
      {
        paramMessageRecord.saveExtInfoToExtStr("long_text_recv_state", "0");
        paramQQAppInterface.b().z(paramMessageRecord);
        if (QLog.isColorLevel()) {
          QLog.d("StructLongTextMsg", 2, "saveLongTextMsg reSend:" + paramBoolean + ",extStr:" + paramMessageRecord.extStr);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "step2: sendLongTextMsg saveMessage end and pack longTextMsg start currenttime:" + System.currentTimeMillis());
      }
      byte[] arrayOfByte = paramQQAppInterface.a().b().a(paramMessageRecord);
      if (arrayOfByte == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructLongTextMsg", 2, "step2: sendLongTextMsg pack failed! packData is null.............................");
        }
        paramMessageRecord.extraflag = 32768;
        paramQQAppInterface.a().e(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
        paramakyf = paramMessageRecord.frienduin;
        int i = paramMessageRecord.istroop;
        long l = paramMessageRecord.uniseq;
        ((MessageHandler)paramQQAppInterface.getBusinessHandler(0)).notifyUI(MessageHandler.gz(paramMessageRecord.istroop), false, new Object[] { paramakyf, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
        return;
      }
      this.acg = System.currentTimeMillis();
      paramBoolean = b(paramQQAppInterface, arrayOfByte, paramQQAppInterface.getCurrentAccountUin(), paramMessageRecord.frienduin, paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, 1035, paramakyf);
      if (!paramBoolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("StructLongTextMsg", 2, "sendLongTextMsg successful, uploadLongTextMsgPkg start!");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("StructLongTextMsg", 2, "sendLongTextMsg failed! isSuccess:" + paramBoolean);
    }
    i(paramQQAppInterface, paramMessageRecord);
  }
  
  public void a(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2)
  {
    try
    {
      MessageRecord localMessageRecord = this.app.a(paramInt1).a(paramString, paramInt1, paramLong1);
      if (localMessageRecord != null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_istroop", String.valueOf(localMessageRecord.istroop));
        localHashMap.put("param_msgtype", String.valueOf(localMessageRecord.msgtype));
        localHashMap.put("param_replycode", String.valueOf(paramInt2));
        localHashMap.put("param_cost", String.valueOf(paramLong2));
        localHashMap.put("param_isAnonymous", String.valueOf(jof.a(localMessageRecord)));
        if (localMessageRecord.msgtype == -1051) {
          anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "ltextNewSendResult", true, 0L, 0L, localHashMap, "");
        }
        while (QLog.isColorLevel())
        {
          QLog.d("StructLongTextMsg", 2, "reportSendLongMsg  peerUin:" + paramString + " istroop=" + localMessageRecord.istroop + " issend=" + localMessageRecord.issend + " msgType=" + localMessageRecord.msgtype + " longMsgCount=" + localMessageRecord.longMsgCount + " longMsgId=" + localMessageRecord.longMsgId + " longMsgIndex=" + localMessageRecord.longMsgIndex + " replyCost=" + paramInt2 + " cost=" + paramLong2);
          return;
          if ((!localMessageRecord.isLongMsg()) || (this.app.a().aR(localMessageRecord))) {
            break;
          }
          localHashMap.put("param_longMsgCount", String.valueOf(localMessageRecord.longMsgCount));
          localHashMap.put("param_longMsgId", String.valueOf(localMessageRecord.longMsgId));
          localHashMap.put("param_longMsgIndex", String.valueOf(localMessageRecord.longMsgIndex));
          anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "ltextOldSendResult", true, 0L, 0L, localHashMap, "");
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("StructLongTextMsg", 1, "longmsg send report error!", paramString);
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if ((paramMessageRecord instanceof MessageForReplyText))
    {
      a(paramQQAppInterface, paramMessageRecord, paramBoolean, new ajkx(this, paramQQAppInterface, paramMessageRecord, paramBoolean));
      return;
    }
    a(paramQQAppInterface, paramMessageRecord, paramBoolean, new ajky(this, paramQQAppInterface, paramMessageRecord, paramBoolean));
  }
  
  public boolean b(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, akyf paramakyf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructLongTextMsg", 2, "[sendLongTextMsg]data.length = " + paramArrayOfByte.length);
    }
    aool localaool = new aool();
    localaool.cNy = true;
    localaool.mFileType = 131078;
    localaool.dPD = 1;
    localaool.fT = paramArrayOfByte;
    localaool.mSelfUin = paramString1;
    localaool.mPeerUin = paramString2;
    localaool.cmn = paramString3;
    localaool.mUinType = paramInt1;
    localaool.mUniseq = paramLong;
    localaool.mBusiType = paramInt2;
    localaool.b = paramakyf;
    paramQQAppInterface.a().a(localaool);
    return true;
  }
  
  public void j(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructLongTextMsg", 2, "reportReceiveLongMsg  istroop=" + paramMessageRecord.istroop + " issend=" + paramMessageRecord.issend + " msgType=" + paramMessageRecord.msgtype + " longMsgCount=" + paramMessageRecord.longMsgCount + " longMsgId=" + paramMessageRecord.longMsgId + " longMsgIndex=" + paramMessageRecord.longMsgIndex);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_istroop", String.valueOf(paramMessageRecord.istroop));
    localHashMap.put("param_issend", String.valueOf(paramMessageRecord.issend));
    localHashMap.put("param_msgtype", String.valueOf(paramMessageRecord.msgtype));
    localHashMap.put("param_isAnonymous", String.valueOf(jof.a(paramMessageRecord)));
    if (paramMessageRecord.msgtype == -1051) {
      anpc.a(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "ltextNewReceiveResult", true, 0L, 0L, localHashMap, "");
    }
    while (!paramMessageRecord.isLongMsg()) {
      return;
    }
    localHashMap.put("param_longMsgCount", String.valueOf(paramMessageRecord.longMsgCount));
    localHashMap.put("param_longMsgId", String.valueOf(paramMessageRecord.longMsgId));
    localHashMap.put("param_longMsgIndex", String.valueOf(paramMessageRecord.longMsgIndex));
    anpc.a(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "ltextOldReceiveResult", true, 0L, 0L, localHashMap, "");
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajkw
 * JD-Core Version:    0.7.0.1
 */