import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class oec
{
  private static oec a;
  public static int beA = 800;
  public static int beB = 700;
  
  public static String a(AbsStructMsg paramAbsStructMsg)
  {
    if (((paramAbsStructMsg instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)paramAbsStructMsg).mIsPAVideoStructMsg))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShareStructLongMessageManager", 2, "is video struct msg");
      }
      return null;
    }
    if (!TextUtils.isEmpty(paramAbsStructMsg.mMsgUrl)) {
      return paramAbsStructMsg.mMsgUrl;
    }
    if (xtj.hR(paramAbsStructMsg.mMsgActionData))
    {
      paramAbsStructMsg = xtj.j(paramAbsStructMsg.mMsgActionData);
      if ((paramAbsStructMsg != null) && (paramAbsStructMsg.length > 2)) {
        return paramAbsStructMsg[1];
      }
    }
    return null;
  }
  
  public static oec a()
  {
    if (a == null) {
      a = new oec();
    }
    return a;
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, akyf paramakyf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareStructLongMessageManager", 2, "[sendLongTextMsg]data.length = " + paramArrayOfByte.length);
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
  
  public static boolean b(AbsStructMsg paramAbsStructMsg)
  {
    boolean bool;
    if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
    {
      if ("micro_app".equals(paramAbsStructMsg.mMsg_A_ActionData)) {
        return true;
      }
      if (((StructMsgForGeneralShare)paramAbsStructMsg).needSendLongMsgWhenFailed) {
        return true;
      }
      if (((StructMsgForGeneralShare)paramAbsStructMsg).mIsPAVideoStructMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShareStructLongMessageManager", 2, "matches!");
        }
        return true;
      }
      if (((StructMsgForGeneralShare)paramAbsStructMsg).mMsgServiceID == 118)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShareStructLongMessageManager", 2, "tribe matches!");
        }
        return true;
      }
      if (((StructMsgForGeneralShare)paramAbsStructMsg).mMsgServiceID == 35)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShareStructLongMessageManager", 2, "MULTI_MSG matches!");
        }
        return true;
      }
      if (((StructMsgForGeneralShare)paramAbsStructMsg).mMsgServiceID == 83)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShareStructLongMessageManager", 2, "gallery matches!");
        }
        return true;
      }
      if (((StructMsgForGeneralShare)paramAbsStructMsg).mMsgServiceID == 123)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShareStructLongMessageManager", 2, "confess general share msg matches!");
        }
        return true;
      }
      if ((((StructMsgForGeneralShare)paramAbsStructMsg).mMsgServiceID == 151) || (((StructMsgForGeneralShare)paramAbsStructMsg).mMsgServiceID == 156))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShareStructLongMessageManager", 2, "STRUCT_TYPE_NEW_SUBSCRIBE_ACCOUNT_NEWS share msg matches!");
        }
        return true;
      }
      if (!TextUtils.isEmpty(paramAbsStructMsg.mMsgUrl))
      {
        String str = paramAbsStructMsg.mMsgUrl;
        try
        {
          Uri localUri = Uri.parse(str);
          if (aqrv.a().rD(localUri.getHost())) {
            return true;
          }
          bool = avcb.te(localUri.getHost());
          if (bool) {
            return true;
          }
        }
        catch (Exception localException)
        {
          QLog.e("ShareStructLongMessageManager", 1, "shouldShareStructLongMessage vip url exception, url = " + str, localException);
        }
      }
    }
    if (!TextUtils.isEmpty(paramAbsStructMsg.mMsgUrl))
    {
      if (Pattern.compile("http://.*.mp.qq.com.*").matcher(paramAbsStructMsg.mMsgUrl).matches())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShareStructLongMessageManager", 2, "matches!");
        }
        return true;
      }
      if (Pattern.compile("https://.*.mp.qq.com.*").matcher(paramAbsStructMsg.mMsgUrl).matches())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShareStructLongMessageManager", 2, "matches!");
        }
        return true;
      }
    }
    try
    {
      bool = obt.eu(new URL(paramAbsStructMsg.mMsgUrl).getHost());
      if (!bool) {
        break label407;
      }
      return true;
    }
    catch (Exception paramAbsStructMsg) {}
    if (!TextUtils.isEmpty(paramAbsStructMsg.mMsgActionData)) {
      return c(paramAbsStructMsg);
    }
    label407:
    return false;
  }
  
  public static boolean c(AbsStructMsg paramAbsStructMsg)
  {
    if (xtj.hR(paramAbsStructMsg.mMsgActionData))
    {
      paramAbsStructMsg = xtj.j(paramAbsStructMsg.mMsgActionData);
      if ((paramAbsStructMsg != null) && (paramAbsStructMsg.length > 2))
      {
        paramAbsStructMsg = paramAbsStructMsg[1];
        if (!TextUtils.isEmpty(paramAbsStructMsg))
        {
          if (Pattern.compile("http://.*.mp.qq.com.*").matcher(paramAbsStructMsg).matches()) {
            if (QLog.isColorLevel()) {
              QLog.d("ShareStructLongMessageManager", 2, "matches!");
            }
          }
          do
          {
            return true;
            if (!Pattern.compile("https://.*.mp.qq.com.*").matcher(paramAbsStructMsg).matches()) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("ShareStructLongMessageManager", 2, "matches!");
          return true;
        }
      }
    }
    return false;
  }
  
  public static String dX(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShareStructLongMessageManager", 2, "url is empty");
      }
      return null;
    }
    try
    {
      paramString = Uri.parse(paramString).getQueryParameter("article_id");
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private static String n(byte[] paramArrayOfByte)
  {
    String str1 = "";
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str3 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      String str2 = str3;
      if (str3.length() == 1) {
        str2 = "0" + str3;
      }
      str1 = str1 + " " + str2;
      i += 1;
    }
    return str1;
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, achq paramachq, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareStructLongMessageManager", 2, "step2: sendShareStructLongMessage saveMessage end and pack ShareStructLongMessage start currenttime:" + System.currentTimeMillis());
    }
    if (!(paramMessageRecord instanceof MessageForStructing)) {
      QLog.d("ShareStructLongMessageManager", 2, "is not MessageForStructing");
    }
    do
    {
      return;
      byte[] arrayOfByte = ((MessageForStructing)paramMessageRecord).structingMsg.getXmlBytes();
      if (QLog.isColorLevel()) {
        QLog.d("ShareStructLongMessageManager", 2, "buff is " + arrayOfByte);
      }
      String str = n(arrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("ShareStructLongMessageManager", 2, "buffer is " + str);
      }
      if (arrayOfByte == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShareStructLongMessageManager", 2, "step2: sendShareStructLongMessage pack failed! packData is null.............................");
        }
        paramMessageRecord.extraflag = 32768;
        paramQQAppInterface.a().e(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
        paramachq = paramMessageRecord.frienduin;
        int i = paramMessageRecord.istroop;
        long l = paramMessageRecord.uniseq;
        ((MessageHandler)paramQQAppInterface.getBusinessHandler(0)).notifyUI(MessageHandler.gz(paramMessageRecord.istroop), false, new Object[] { paramachq, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
        return;
      }
      paramBoolean = a(paramQQAppInterface, arrayOfByte, paramQQAppInterface.getCurrentAccountUin(), paramMessageRecord.frienduin, paramMessageRecord.selfuin, paramMessageRecord.istroop, paramMessageRecord.uniseq + 1L, 1035, new oed(this, paramMessageRecord, paramQQAppInterface, paramachq, paramBoolean));
      if (!paramBoolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShareStructLongMessageManager", 2, "sendShareStructLongMessage successful, uploadShareStructLongMessagePkg start!");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("ShareStructLongMessageManager", 2, "sendShareStructLongMessage failed! isSuccess:" + paramBoolean);
    }
    b(paramQQAppInterface, paramMessageRecord);
  }
  
  public void b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramMessageRecord.extraflag = 32768;
    paramQQAppInterface.a().e(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    String str = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    long l = paramMessageRecord.uniseq;
    ((MessageHandler)paramQQAppInterface.getBusinessHandler(0)).notifyUI(MessageHandler.gz(paramMessageRecord.istroop), false, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oec
 * JD-Core Version:    0.7.0.1
 */