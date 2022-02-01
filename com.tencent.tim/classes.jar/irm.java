import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class irm
{
  public static void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat, int paramInt4, int paramInt5)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AV_rp_dc", 2, "reportEmojiHitResult,emojiID  = " + paramInt1 + ",emojiType = " + paramInt2 + ",hitType = " + paramInt3 + ",missCount1 = " + paramInt4 + ",missCount2 = " + paramInt5 + ",score = " + paramFloat);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("id", String.valueOf(paramInt1));
    localHashMap.put("etype", String.valueOf(paramInt2));
    localHashMap.put("htype", String.valueOf(paramInt3));
    localHashMap.put("score", String.valueOf(paramFloat));
    localHashMap.put("mcount1", String.valueOf(paramInt4));
    localHashMap.put("mcount2", String.valueOf(paramInt5));
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actAVEmojiHit", true, 0L, 0L, localHashMap, "", true);
  }
  
  public static void apN()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AV_rp_dc", 2, "reportNoEntranceByPtuSoFail");
    }
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actAVRPPtuSoFail", true, 0L, 0L, null, "", true);
  }
  
  public static void b(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AV_rp_dc", 2, "reportSendRedPacketResult success = " + paramBoolean + ",errorCode1 = " + paramString1 + ",errorCode2 = " + paramString2);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("errorCode1", paramString1);
    localHashMap.put("errorCode2", paramString2);
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actAVSendRPResult", paramBoolean, 0L, 0L, localHashMap, "", true);
  }
  
  public static void bM(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AV_rp_dc", 2, "reportResDownloadResult  resType = " + paramInt1 + ",success = " + bool);
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("resType", String.valueOf(paramInt1));
      localHashMap.put("downResult", String.valueOf(bool));
      localHashMap.put("errorCode", String.valueOf(paramInt2));
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actResDownResult", bool, 0L, 0L, localHashMap, "", true);
      return;
    }
  }
  
  public static void c(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AV_rp_dc", 2, "reportGrabRedPacketResult success = " + paramBoolean + ",errorCode1 = " + paramString1 + ",errorCode2 = " + paramString2);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("errorCode1", paramString1);
    localHashMap.put("errorCode2", paramString2);
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actAVGrabRPResult", paramBoolean, 0L, 0L, localHashMap, "", true);
  }
  
  public static void iK(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AV_rp_dc", 2, "reportConfigReqResult success = " + paramBoolean);
    }
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actAVConfigReqResult", paramBoolean, 0L, 0L, null, "", true);
  }
  
  public static void j(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AV_rp_dc", 2, "reportRedPacketBtnGrayWhenSessionFinish,isGray  = " + paramBoolean + ",grayType = " + paramString);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("grayType", paramString);
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actAVRPBtnGrayOrNot", paramBoolean, 0L, 0L, localHashMap, "", true);
  }
  
  public static void jw(String paramString)
  {
    boolean bool = BaseApplicationImpl.getApplication().getSharedPreferences("avredpacket_sp", 4).getBoolean("res_exist", false);
    if (QLog.isColorLevel()) {
      QLog.d("AV_rp_dc", 2, "checkAndReportIllegalAVRedPacketRequest exist = " + bool);
    }
    if (bool)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("md5", paramString);
      localHashMap.put("model", Build.MODEL);
      localHashMap.put("version", String.valueOf(Build.VERSION.SDK_INT));
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actIllegalAVRPRequest", true, 0L, 0L, localHashMap, "", true);
    }
  }
  
  public static void k(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AV_rp_dc", 2, "reportClickRedPacketBtnResult success = " + paramBoolean + ",errorCode = " + paramString);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("errorCode", paramString);
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actAVClickRPBtnResult", paramBoolean, 0L, 0L, localHashMap, "", true);
  }
  
  public static void lw(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AV_rp_dc", 2, "reportDetectInvalidExpression,invalidType  = " + paramInt);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("invalidType", String.valueOf(paramInt));
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actAVRPDetectInvalidExp", true, 0L, 0L, localHashMap, "", true);
  }
  
  public static void w(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    int i;
    do
    {
      return;
      i = ((irz)paramQQAppInterface.getManager(254)).lA();
      if (i > 0)
      {
        paramQQAppInterface = new HashMap();
        paramQQAppInterface.put("configVersion", String.valueOf(i));
        anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actConfigExistStatus", true, 0L, 0L, paramQQAppInterface, "", true);
      }
    } while (!QLog.isColorLevel());
    QLog.d("AV_rp_dc", 2, "reportConfigExistStatus localVersion = " + i);
  }
  
  public static void x(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    for (;;)
    {
      return;
      int i = ((irz)paramQQAppInterface.getManager(254)).lA();
      boolean bool;
      if (i > 0)
      {
        bool = BaseApplicationImpl.getApplication().getSharedPreferences("avredpacket_sp", 4).getBoolean("res_exist", false);
        if (bool)
        {
          paramQQAppInterface = new HashMap();
          paramQQAppInterface.put("configVersion", String.valueOf(i));
          anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actResExistStatus", true, 0L, 0L, paramQQAppInterface, "", true);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("AV_rp_dc", 2, "reportResourceExistStaus localVersion = " + i + ",exist = " + bool);
        return;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     irm
 * JD-Core Version:    0.7.0.1
 */