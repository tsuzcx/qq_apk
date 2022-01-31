import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class vws
{
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface != null) && (a(paramString)))
    {
      vwq localvwq = (vwq)paramQQAppInterface.getManager(208);
      String str = a(paramString);
      paramString = localvwq.a(paramString);
      if (paramString != null) {
        return paramQQAppInterface.a().d(str, 1, paramString.longValue());
      }
    }
    return null;
  }
  
  public static String a(Intent paramIntent, @NonNull String paramString1, String paramString2)
  {
    int j = 78;
    int i = 8;
    int k = 0;
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)))
    {
      paramString1 = paramString1.replace("$GCODE$", paramString2);
      if (paramIntent != null) {
        break label121;
      }
      label36:
      if (paramIntent != null) {
        break label133;
      }
      label40:
      if (paramIntent != null) {
        break label146;
      }
    }
    for (;;)
    {
      paramIntent = new StringBuilder(paramString1);
      paramIntent.append("&troopStoryMemoriesFrom=").append(i).append("&playVideoFrom=").append(j).append("&lastOpenFrom=").append(k);
      return paramIntent.toString();
      QLog.e("TroopStoryUtil", 1, new Object[] { "configTroopStoryProfileFromAIO empty. troopUin=", "", ", url=", paramString1 });
      break;
      label121:
      i = paramIntent.getIntExtra("extra_share_group_from", 8);
      break label36;
      label133:
      j = paramIntent.getIntExtra("extra_play_video_from", 78);
      break label40;
      label146:
      k = paramIntent.getIntExtra("extra_last_open_from", 0);
    }
  }
  
  public static String a(MessageForShortVideo paramMessageForShortVideo)
  {
    return ("gs_" + paramMessageForShortVideo.frienduin + '_' + paramMessageForShortVideo.getMd5() + '_' + bdhv.d(paramMessageForShortVideo.uuid) + "-700").toLowerCase();
  }
  
  public static String a(String paramString)
  {
    if (a(paramString))
    {
      paramString = paramString.split("_");
      if (paramString.length > 2) {
        return paramString[1];
      }
    }
    return null;
  }
  
  public static void a(MessageForTroopStory paramMessageForTroopStory, Bundle paramBundle)
  {
    paramBundle.putInt("forward_type", 32);
    paramBundle.putLong("key_uid", paramMessageForTroopStory.uid);
    paramBundle.putString("key_union_id", paramMessageForTroopStory.unionId);
    paramBundle.putString("key_md5", paramMessageForTroopStory.md5);
    paramBundle.putString("key_thumb_url", paramMessageForTroopStory.thumbUrl);
    paramBundle.putString("key_doodle_url", paramMessageForTroopStory.doodleUrl);
    paramBundle.putInt("key_video_width", paramMessageForTroopStory.videoWidth);
    paramBundle.putInt("key_video_height", paramMessageForTroopStory.videoHeight);
    paramBundle.putString("key_source_name", paramMessageForTroopStory.sourceName);
    paramBundle.putString("key_source_action_type", paramMessageForTroopStory.sourceActionType);
    paramBundle.putString("key_source_action_data", paramMessageForTroopStory.sourceActionData);
    paramBundle.putString("key_compatible_text", paramMessageForTroopStory.compatibleText);
    paramBundle.putInt("key_ctr_version", paramMessageForTroopStory.ctrVersion);
  }
  
  public static boolean a(int paramInt, MessageRecord paramMessageRecord)
  {
    return (ssw.i()) && (paramInt == 1) && ((paramMessageRecord instanceof MessageForShortVideo)) && (((MessageForShortVideo)paramMessageRecord).busiType == 1);
  }
  
  public static boolean a(String paramString)
  {
    return (paramString != null) && (paramString.startsWith("gs_"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vws
 * JD-Core Version:    0.7.0.1
 */