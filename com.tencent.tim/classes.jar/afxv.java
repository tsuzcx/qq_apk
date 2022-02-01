import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport.1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class afxv
{
  private static afxv a;
  private static String bFT;
  private static String bFU;
  private static int cVi = -1;
  private static int cVj = -1;
  private static afua d;
  
  public static int DR()
  {
    return cVi;
  }
  
  public static afxv a()
  {
    if (a == null) {
      a = new afxv();
    }
    return a;
  }
  
  public static String a(afua paramafua)
  {
    afua.a locala = null;
    Object localObject1 = "";
    if (paramafua != null) {
      if ((paramafua.mSchoolInfos == null) || (paramafua.mSchoolInfos.isEmpty())) {
        break label224;
      }
    }
    label224:
    for (localObject1 = (afua.b)paramafua.mSchoolInfos.get(0);; localObject1 = null)
    {
      long l;
      if (localObject1 != null)
      {
        l = ((afua.b)localObject1).authState;
        localObject1 = ((afua.b)localObject1).schoolName;
      }
      for (String str = String.valueOf(l);; str = null)
      {
        Object localObject2 = locala;
        if (paramafua.mLabelInfos != null)
        {
          localObject2 = locala;
          if (!paramafua.mLabelInfos.isEmpty())
          {
            localObject2 = new StringBuilder();
            paramafua = paramafua.mLabelInfos.iterator();
            int i = 1;
            if (paramafua.hasNext())
            {
              locala = (afua.a)paramafua.next();
              if (i != 0)
              {
                ((StringBuilder)localObject2).append(locala.labelName);
                i = 0;
              }
              for (;;)
              {
                break;
                ((StringBuilder)localObject2).append(",");
                ((StringBuilder)localObject2).append(locala.labelName);
              }
            }
            localObject2 = ((StringBuilder)localObject2).toString();
          }
        }
        localObject1 = String.format("%s_%s_%s", new Object[] { str, localObject1, localObject2 });
        return localObject1;
        localObject1 = null;
      }
    }
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, String paramString2, afua paramafua)
  {
    cVi = paramInt1;
    cVj = paramInt2;
    bFT = paramString1;
    bFU = paramString2;
    d = paramafua;
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3)
  {
    ThreadManager.post(new ExtendFriendReport.1(this, paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString3), 5, null, false);
  }
  
  public static void ae(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendReport", 0, String.format("updateRecomTrace strRecomTrace=%s", new Object[] { paramString }));
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramQQAppInterface != null))
    {
      paramQQAppInterface = (afsi)paramQQAppInterface.getManager(264);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.bFe = paramString;
      }
    }
  }
  
  public static void ddN()
  {
    cVi = -1;
    cVj = -1;
    bFT = null;
    bFU = null;
    d = null;
  }
  
  public static void g(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    paramLong = (System.currentTimeMillis() - paramLong) / 1000L;
    afsi.a locala = ((afsi)paramQQAppInterface.getManager(264)).a();
    if ((locala != null) && (locala.cUd <= paramLong)) {
      anot.a(paramQQAppInterface, "dc00898", "", paramString, "0X8009C6E", "0X8009C6E", 2, 0, "", uQ(), t(paramQQAppInterface), uT());
    }
  }
  
  public static String kK(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendReport", 0, String.format("getRecomTrace2 strRecomTrace=%s", new Object[] { paramString }));
    }
    if (!TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return "";
  }
  
  public static String t(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (afsi)paramQQAppInterface.getManager(264);
      if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.bFe))) {}
    }
    for (paramQQAppInterface = paramQQAppInterface.bFe;; paramQQAppInterface = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendReport", 0, String.format("getRecomTrace1 strRecomTrace=%s", new Object[] { paramQQAppInterface }));
      }
      return paramQQAppInterface;
    }
  }
  
  public static String uQ()
  {
    String str = "";
    if (cVj >= 0) {
      str = String.valueOf(cVj + 1);
    }
    return str;
  }
  
  public static String uR()
  {
    String str = "";
    if (!TextUtils.isEmpty(bFT)) {
      str = bFT;
    }
    return str;
  }
  
  public static String uS()
  {
    String str = "";
    if (!TextUtils.isEmpty(bFU)) {
      str = bFU;
    }
    return str;
  }
  
  public static String uT()
  {
    String str2 = "";
    String str1 = str2;
    if (!TextUtils.isEmpty(bFU))
    {
      str1 = str2;
      if (d != null) {
        str1 = String.format("%s_%s", new Object[] { bFU, a(d) });
      }
    }
    return str1;
  }
  
  public void NE(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendReport", 0, String.format("reportEntryDuration duration=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    HashMap localHashMap = new HashMap();
    a("", "extend_friend_entry_duration", true, paramInt, 0L, localHashMap, "");
  }
  
  public void NF(int paramInt)
  {
    String str = "";
    Object localObject = "";
    SosoInterface.SosoLbsInfo localSosoLbsInfo = SosoInterface.c();
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.a != null))
    {
      localObject = localSosoLbsInfo.a;
      if (!TextUtils.isEmpty(((SosoInterface.SosoLocation)localObject).city)) {
        str = ((SosoInterface.SosoLocation)localObject).city;
      }
      localObject = String.format("%s;%s", new Object[] { Double.valueOf(((SosoInterface.SosoLocation)localObject).cd), Double.valueOf(((SosoInterface.SosoLocation)localObject).ce) });
    }
    for (;;)
    {
      anot.a(null, "dc00898", "", "", "0X800A68C", "0X800A68C", paramInt, 0, "", "", str, (String)localObject);
      return;
      str = "";
    }
  }
  
  public void bi(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendReport", 0, String.format("reportPreDownload success=%s result=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    a("", "extend_friend_pre_download", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public void bj(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendReport", 0, String.format("reportResUnzip success=%s result=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    a("", "extend_friend_res_unzip", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public void bk(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendReport", 0, String.format("reportFeedReq success=%s result=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    a("", "extend_friend_feed_req", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public void bl(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendReport", 0, String.format("reportVoiceUploadReq success=%s result=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    a("", "extend_friend_voice_upload_req", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public void c(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    anot.c(null, "dc00898", "", paramString1, "0X800AD9A", "0X800AD9A", paramInt, 0, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void ddM()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendReport", 0, "reportEntry");
    }
    a("", "extend_friend_entry", true, 0L, 0L, new HashMap(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afxv
 * JD-Core Version:    0.7.0.1
 */