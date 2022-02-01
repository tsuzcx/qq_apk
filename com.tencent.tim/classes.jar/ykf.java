import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgModel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;

public class ykf
{
  public static boolean O(MessageRecord paramMessageRecord)
  {
    boolean bool2 = true;
    if (paramMessageRecord == null) {
      return false;
    }
    boolean bool1;
    if (1 != paramMessageRecord.istroop)
    {
      bool1 = bool2;
      if (3000 != paramMessageRecord.istroop) {}
    }
    else
    {
      if (paramMessageRecord.extraflag != 32772) {
        break label44;
      }
      bool1 = paramMessageRecord.isValid;
    }
    for (;;)
    {
      return bool1;
      label44:
      bool1 = bool2;
      if (paramMessageRecord.msgtype == -2006) {
        bool1 = false;
      }
    }
  }
  
  private static int a(MessageForArkApp paramMessageForArkApp)
  {
    if (paramMessageForArkApp == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return 6;
          localObject = paramMessageForArkApp.ark_app_message;
        } while (localObject == null);
        paramMessageForArkApp = ((ArkAppMessage)localObject).appName;
        localObject = ((ArkAppMessage)localObject).appView;
      } while ((TextUtils.isEmpty(paramMessageForArkApp)) || (TextUtils.isEmpty((CharSequence)localObject)));
      if ("com.tencent.map".equals(paramMessageForArkApp)) {
        return 10;
      }
    } while ((!"com.tencent.miniapp_01".equals(paramMessageForArkApp)) && ((!"com.tencent.structmsg".equals(paramMessageForArkApp)) || (!"news".equals(localObject))));
    return 9;
  }
  
  public static long a(ColorNote paramColorNote)
  {
    long l2 = a(paramColorNote, 0);
    long l1 = l2;
    if (l2 == 0L) {
      l1 = System.currentTimeMillis() + 1000L;
    }
    return l1;
  }
  
  private static long a(ColorNote paramColorNote, int paramInt)
  {
    long l2 = 0L;
    try
    {
      paramColorNote = a(paramColorNote);
      long l1 = l2;
      if (paramColorNote != null)
      {
        l1 = l2;
        if (paramColorNote.length > 0)
        {
          l1 = l2;
          if (paramInt < paramColorNote.length) {
            l1 = Long.valueOf(paramColorNote[paramInt]).longValue();
          }
        }
      }
      return l1;
    }
    catch (Exception paramColorNote)
    {
      QLog.d("UpComingMsgLogic.", 1, "parseMindTimeFromEntity error!", paramColorNote);
    }
    return 0L;
  }
  
  public static UpComingMsgModel a(ColorNote paramColorNote)
  {
    if ((paramColorNote == null) || (paramColorNote.getServiceType() != 17235968)) {
      return new UpComingMsgModel();
    }
    paramColorNote = new String(paramColorNote.getReserve());
    UpComingMsgModel localUpComingMsgModel = new UpComingMsgModel();
    localUpComingMsgModel.parseFromJson(paramColorNote);
    return localUpComingMsgModel;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      if (paramQQAppInterface == null) {
        paramQQAppInterface = "";
      }
    }
    String str;
    do
    {
      do
      {
        do
        {
          return paramQQAppInterface;
          return paramQQAppInterface.getCurrentAccountUin();
          if (paramMessageRecord.msg != null) {}
          for (str = paramMessageRecord.msg;; str = "")
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("UpComingMsgLogic.UpComingMsgUtil", 2, "message type = " + paramMessageRecord.msgtype + ", result = " + str);
            }
            if ((paramMessageRecord.msgtype != -2000) && (paramMessageRecord.msgtype != -5015) && (paramMessageRecord.msgtype != -2007)) {
              break;
            }
            return "[图片]";
          }
          if (paramMessageRecord.msgtype == -1031) {
            return "[语音]";
          }
          if (paramMessageRecord.msgtype == -2002) {
            return j(paramMessageRecord);
          }
          if (paramMessageRecord.msgtype == -2017)
          {
            if ((!(paramMessageRecord instanceof MessageForTroopFile)) || (TextUtils.isEmpty(((MessageForTroopFile)paramMessageRecord).fileName))) {
              break label317;
            }
            return "[文件]" + ((MessageForTroopFile)paramMessageRecord).fileName;
          }
          if (paramMessageRecord.msgtype == -2005) {
            return ahav.b(paramQQAppInterface, paramMessageRecord);
          }
          if (!aqfw.mn(paramMessageRecord.msgtype)) {
            break;
          }
          paramQQAppInterface = "[分享]";
        } while (!(paramMessageRecord instanceof MessageForStructing));
        return "[分享]" + ((MessageForStructing)paramMessageRecord).getSummaryMsg();
        if (paramMessageRecord.msgtype == -2022) {
          return "[视频]";
        }
        paramQQAppInterface = str;
      } while (paramMessageRecord.msgtype != -2011);
      paramQQAppInterface = str;
    } while (!(paramMessageRecord instanceof MessageForStructing));
    return str + ((MessageForStructing)paramMessageRecord).getSummaryMsg();
    label317:
    return "[文件]";
  }
  
  private static String[] a(ColorNote paramColorNote)
  {
    if (paramColorNote != null)
    {
      paramColorNote = paramColorNote.getSubType();
      if (!TextUtils.isEmpty(paramColorNote))
      {
        paramColorNote = paramColorNote.split("_");
        if (paramColorNote.length == 2) {
          return paramColorNote;
        }
      }
    }
    return new String[0];
  }
  
  public static String bc(long paramLong)
  {
    long l = System.currentTimeMillis();
    return paramLong + "_" + l;
  }
  
  public static int e(MessageRecord paramMessageRecord)
  {
    int i = 6;
    if (((paramMessageRecord instanceof MessageForText)) || ((paramMessageRecord instanceof MessageForLongMsg))) {
      if (aofy.pW(paramMessageRecord.msg)) {
        i = 12;
      }
    }
    do
    {
      do
      {
        return i;
        return 1;
        if ((paramMessageRecord instanceof MessageForPic)) {
          return 2;
        }
        if ((paramMessageRecord instanceof MessageForArkApp)) {
          return a((MessageForArkApp)paramMessageRecord);
        }
        if ((paramMessageRecord instanceof MessageForPtt)) {
          return 3;
        }
        if ((paramMessageRecord instanceof MessageForMixedMsg)) {
          return 4;
        }
        if (((paramMessageRecord instanceof MessageForFile)) || ((paramMessageRecord instanceof MessageForTroopFile)) || ((paramMessageRecord instanceof MessageForDeviceFile))) {
          return f(paramMessageRecord);
        }
        if (!(paramMessageRecord instanceof MessageForStructing)) {
          break;
        }
      } while (!e((MessageForStructing)paramMessageRecord));
      return 11;
    } while (acsq.ad(paramMessageRecord));
    return 7;
  }
  
  private static boolean e(MessageForStructing paramMessageForStructing)
  {
    if (paramMessageForStructing == null) {}
    while ((paramMessageForStructing.structingMsg == null) || (!"viewMultiMsg".equals(paramMessageForStructing.structingMsg.mMsgAction))) {
      return false;
    }
    return true;
  }
  
  private static int f(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForFile))
    {
      if (ahav.getFileType(((MessageForFile)paramMessageRecord).fileName) != 0) {}
    }
    else {
      do
      {
        return 2;
        if (!(paramMessageRecord instanceof MessageForDeviceFile)) {
          break;
        }
      } while (2 == ((MessageForDeviceFile)paramMessageRecord).nFileMsgType);
    }
    while ((!(paramMessageRecord instanceof MessageForTroopFile)) || (ahav.getFileType(((MessageForTroopFile)paramMessageRecord).fileName) != 0)) {
      return 5;
    }
    return 2;
  }
  
  public static boolean gI(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 1000) || (paramInt == 3000) || (paramInt == 1004) || (paramInt == 1006);
  }
  
  private static String j(MessageRecord paramMessageRecord)
  {
    if (((paramMessageRecord instanceof MessageForPtt)) && (((MessageForPtt)paramMessageRecord).hasSttTxt())) {}
    for (paramMessageRecord = ((MessageForPtt)paramMessageRecord).sttText;; paramMessageRecord = "")
    {
      Object localObject = paramMessageRecord;
      if (TextUtils.isEmpty(paramMessageRecord)) {
        localObject = "[语音]";
      }
      return localObject;
    }
  }
  
  public static void j(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity != null)
    {
      Intent localIntent = paramBaseActivity.getIntent();
      if ((localIntent != null) && (localIntent.getBooleanExtra("flag_open_up_coming_list", false)))
      {
        localIntent.removeExtra("flag_open_up_coming_list");
        aeee.z(paramBaseActivity, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ykf
 * JD-Core Version:    0.7.0.1
 */