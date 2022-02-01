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

public class ubr
{
  public static int a;
  private static ubr a;
  public static int b;
  
  static
  {
    jdField_a_of_type_Int = 800;
    jdField_b_of_type_Int = 700;
  }
  
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
    if (aics.b(paramAbsStructMsg.mMsgActionData))
    {
      paramAbsStructMsg = aics.b(paramAbsStructMsg.mMsgActionData);
      if ((paramAbsStructMsg != null) && (paramAbsStructMsg.length > 2)) {
        return paramAbsStructMsg[1];
      }
    }
    return null;
  }
  
  public static String a(String paramString)
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
  
  private static String a(byte[] paramArrayOfByte)
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
  
  public static ubr a()
  {
    if (jdField_a_of_type_Ubr == null) {
      jdField_a_of_type_Ubr = new ubr();
    }
    return jdField_a_of_type_Ubr;
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, azrg paramazrg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareStructLongMessageManager", 2, "[sendLongTextMsg]data.length = " + paramArrayOfByte.length);
    }
    beyg localbeyg = new beyg();
    localbeyg.jdField_a_of_type_Boolean = true;
    localbeyg.jdField_b_of_type_Int = 131078;
    localbeyg.h = 1;
    localbeyg.jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
    localbeyg.jdField_b_of_type_JavaLangString = paramString1;
    localbeyg.c = paramString2;
    localbeyg.d = paramString3;
    localbeyg.jdField_a_of_type_Int = paramInt1;
    localbeyg.jdField_a_of_type_Long = paramLong;
    localbeyg.e = paramInt2;
    localbeyg.jdField_a_of_type_Azrg = paramazrg;
    localbeyg.r = a();
    paramQQAppInterface.a().a(localbeyg);
    return true;
  }
  
  public static boolean a(AbsStructMsg paramAbsStructMsg)
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
          if (biav.a().a(localUri.getHost())) {
            return true;
          }
          bool = bmaa.c(localUri.getHost());
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
      bool = tyi.b(new URL(paramAbsStructMsg.mMsgUrl).getHost());
      if (!bool) {
        break label407;
      }
      return true;
    }
    catch (Exception paramAbsStructMsg) {}
    if (!TextUtils.isEmpty(paramAbsStructMsg.mMsgActionData)) {
      return b(paramAbsStructMsg);
    }
    label407:
    return false;
  }
  
  public static boolean b(AbsStructMsg paramAbsStructMsg)
  {
    if (aics.b(paramAbsStructMsg.mMsgActionData))
    {
      paramAbsStructMsg = aics.b(paramAbsStructMsg.mMsgActionData);
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
  
  public int a()
  {
    return 3;
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramMessageRecord.extraflag = 32768;
    paramQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    String str = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    long l = paramMessageRecord.uniseq;
    ((MessageHandler)paramQQAppInterface.a(0)).notifyUI(MessageHandler.a(paramMessageRecord.istroop), false, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, aocj paramaocj, boolean paramBoolean)
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
      String str = a(arrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("ShareStructLongMessageManager", 2, "buffer is " + str);
      }
      if (arrayOfByte == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShareStructLongMessageManager", 2, "step2: sendShareStructLongMessage pack failed! packData is null.............................");
        }
        paramMessageRecord.extraflag = 32768;
        paramQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
        paramaocj = paramMessageRecord.frienduin;
        int i = paramMessageRecord.istroop;
        long l = paramMessageRecord.uniseq;
        ((MessageHandler)paramQQAppInterface.a(0)).notifyUI(MessageHandler.a(paramMessageRecord.istroop), false, new Object[] { paramaocj, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
        return;
      }
      paramBoolean = a(paramQQAppInterface, arrayOfByte, paramQQAppInterface.getCurrentAccountUin(), paramMessageRecord.frienduin, paramMessageRecord.selfuin, paramMessageRecord.istroop, paramMessageRecord.uniseq + 1L, 1035, new ubs(this, paramMessageRecord, paramQQAppInterface, paramaocj, paramBoolean));
      if (!paramBoolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShareStructLongMessageManager", 2, "sendShareStructLongMessage successful, uploadShareStructLongMessagePkg start!");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("ShareStructLongMessageManager", 2, "sendShareStructLongMessage failed! isSuccess:" + paramBoolean);
    }
    a(paramQQAppInterface, paramMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ubr
 * JD-Core Version:    0.7.0.1
 */