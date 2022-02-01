import android.text.TextUtils;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class acei
{
  public static void Q(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null) {
      paramMessageRecord.saveExtInfoToExtStr("commen_flash_pic", "true");
    }
  }
  
  public static boolean W(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessageRecord != null) {
      if (paramMessageRecord.msgtype != -2000)
      {
        bool1 = bool2;
        if (paramMessageRecord.msgtype != -2006) {}
      }
      else
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("commen_flash_pic"))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean X(MessageRecord paramMessageRecord)
  {
    try
    {
      boolean bool = Boolean.valueOf(paramMessageRecord.getExtInfoFromExtStr("commen_flash_pic")).booleanValue();
      return bool;
    }
    catch (Exception paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
    }
    return false;
  }
  
  public static boolean a(int paramInt, HotChatManager paramHotChatManager, String paramString)
  {
    return ((paramInt == 0) || (paramInt == 1) || (paramInt == 3000)) && (!paramHotChatManager.kj(paramString));
  }
  
  public static void d(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord.msgtype == -2000) {
      paramMessageRecord.saveExtInfoToExtStr("commen_flash_pic", paramBoolean + "");
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("FlashPicHelper", 4, "setFlashPicFlag,troopUin:" + paramMessageRecord.frienduin + ",isReaded:" + paramBoolean + ",msgType:" + paramMessageRecord.msgtype);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acei
 * JD-Core Version:    0.7.0.1
 */