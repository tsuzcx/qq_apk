import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class ajpc
{
  public static HashSet bl = new HashSet();
  
  public static ajpb a(AppInterface paramAppInterface)
  {
    ajpb localajpb = new ajpb();
    String str = "nearby_face_score_config_" + paramAppInterface.getCurrentAccountUin();
    paramAppInterface = paramAppInterface.getApplication().getApplicationContext().getSharedPreferences(str, 4);
    localajpb.isShowCard = paramAppInterface.getBoolean("isShowCard", false);
    localajpb.cpC = paramAppInterface.getBoolean("isShowList", false);
    localajpb.expireTime = paramAppInterface.getLong("expireTime", 0L);
    localajpb.bRU = paramAppInterface.getString("entranceJumpUrl", "");
    localajpb.bRV = paramAppInterface.getString("entranceJumpUrlForHost", "");
    localajpb.bRW = paramAppInterface.getString("entranceJumpUrlForGuest", "");
    if (QLog.isColorLevel()) {
      QLog.e("Q..troop.faceScore", 2, "FaceScoreUtils.getConfig config.expireTime=" + localajpb.isShowCard + "  config.isShowList=" + localajpb.cpC + "  config.expireTime=" + localajpb.expireTime + "  config.entranceJumpUrl=" + localajpb.bRU + "  config.entranceJumpUrlForHost=" + localajpb.bRV + "  config.entranceJumpUrlForGuest=" + localajpb.bRW);
    }
    return localajpb;
  }
  
  public static String a(int paramInt, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= paramInt)) {
      return "";
    }
    return paramVarArgs[paramInt];
  }
  
  public static void a(AppInterface paramAppInterface, ajpb paramajpb)
  {
    try
    {
      String str = "nearby_face_score_config_" + paramAppInterface.getCurrentAccountUin();
      paramAppInterface.getApplication().getApplicationContext().getSharedPreferences(str, 4).edit().putBoolean("isShowCard", paramajpb.isShowCard).putBoolean("isShowList", paramajpb.cpC).putLong("expireTime", paramajpb.expireTime).putString("entranceJumpUrl", paramajpb.bRU).putString("entranceJumpUrlForHost", paramajpb.bRV).putString("entranceJumpUrlForGuest", paramajpb.bRW).commit();
      if (QLog.isColorLevel()) {
        QLog.e("Q..troop.faceScore", 2, "FaceScoreUtils.saveConfig config.expireTime=" + paramajpb.isShowCard + "  config.isShowList=" + paramajpb.cpC + "  config.expireTime=" + paramajpb.expireTime + "  config.entranceJumpUrl=" + paramajpb.bRU + "  config.entranceJumpUrlForHost=" + paramajpb.bRV + "  config.entranceJumpUrlForGuest=" + paramajpb.bRW);
      }
      return;
    }
    finally
    {
      paramAppInterface = finally;
      throw paramAppInterface;
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q..troop.faceScore", 2, "setFaceScoreFlag, msg = " + paramMessageRecord + "  key=" + paramString + " flag=" + paramBoolean);
    }
    if (paramMessageRecord == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramMessageRecord.extStr))
        {
          localJSONObject = new JSONObject();
          localJSONObject.put(paramString, paramBoolean);
          paramMessageRecord.extStr = localJSONObject.toString();
          paramMessageRecord.extLong |= 0x1;
          return;
        }
      }
      catch (JSONException paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
        return;
      }
      JSONObject localJSONObject = new JSONObject(paramMessageRecord.extStr);
      localJSONObject.put(paramString, paramBoolean);
      paramMessageRecord.extStr = localJSONObject.toString();
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord, String paramString)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q..troop.faceScore", 2, "getFaceScoreFlag, msg = " + paramMessageRecord + "  key=" + paramString);
    }
    if (paramMessageRecord == null) {
      return false;
    }
    if ((paramMessageRecord.extStr != null) && ((paramMessageRecord.extLong & 0x1) == 1) && (paramMessageRecord.extStr.contains(paramString)) && (paramMessageRecord.getExtInfoFromExtStr(paramString).equals("true"))) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q..troop.faceScore.FaceScoreUtils", 2, "isFaceScoreGrayTips, ret=" + bool + ", mr=" + paramMessageRecord);
      }
      return bool;
      bool = false;
    }
  }
  
  public static void b(String paramString1, String paramString2, String... paramVarArgs)
  {
    anot.a(null, "dc00899", "grp_lbs", paramString2, "face_score", paramString1, 0, 0, a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs));
  }
  
  public static boolean e(AppInterface paramAppInterface, String paramString)
  {
    String str = "nearby_face_score_config_" + paramAppInterface.getCurrentAccountUin();
    boolean bool = paramAppInterface.getApplication().getApplicationContext().getSharedPreferences(str, 4).getBoolean("has_insert_face_score_msg_" + paramString, false);
    if (QLog.isColorLevel()) {
      QLog.e("Q..troop.faceScore", 2, "FaceScoreUtils.getHasInsertMsgFlag uin=" + paramString + "  flag=" + bool);
    }
    return bool;
  }
  
  public static void h(AppInterface paramAppInterface, String paramString)
  {
    String str = "nearby_face_score_config_" + paramAppInterface.getCurrentAccountUin();
    paramAppInterface = paramAppInterface.getApplication().getApplicationContext().getSharedPreferences(str, 4);
    str = "has_insert_face_score_msg_" + paramString;
    paramAppInterface.edit().putBoolean(str, true).commit();
    if (QLog.isColorLevel()) {
      QLog.e("Q..troop.faceScore", 2, "FaceScoreUtils.setHasInsertMsgFlag uin=" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajpc
 * JD-Core Version:    0.7.0.1
 */