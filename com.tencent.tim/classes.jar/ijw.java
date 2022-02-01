import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.beacon.event.UserAction;
import java.util.HashMap;
import java.util.Map;

public class ijw
{
  static int AO = 0;
  static String Nq = "";
  static String Nr = "";
  static String Ns = "";
  static long lt;
  
  public static void G(String paramString, int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 3))
    {
      c(paramString, 10L, paramInt);
      return;
    }
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(Nq)) && (!paramString.equals(Nq)))
    {
      long l = System.currentTimeMillis();
      c(Nq, (l - lt) / 1000L, AO);
    }
    Nq = paramString;
    AO = paramInt;
    lt = System.currentTimeMillis();
  }
  
  public static void Z(int paramInt, String paramString)
  {
    iR(paramString);
    if (!TextUtils.isEmpty(Nr)) {
      reportClickEvent("0X8008025", Nr);
    }
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, String paramString)
  {
    if ((paramVideoAppInterface != null) && (paramString != null))
    {
      iR(paramString);
      paramVideoAppInterface = (ikt)paramVideoAppInterface.a(5);
      boolean bool = paramVideoAppInterface.d(3, "normal");
      if ((paramVideoAppInterface.d(3, "interact")) || (bool)) {
        reportClickEvent("0X8008026", null);
      }
    }
    else
    {
      return;
    }
    reportClickEvent("0X8008027", null);
  }
  
  public static void aa(int paramInt, String paramString)
  {
    igd.aJ("MagicDataReport", "WL_DEBUG reportChangeFace fromType = " + paramInt + ", id = " + paramString);
    if ((TextUtils.isEmpty(Ns)) || (Ns.equals("0")))
    {
      VideoController localVideoController = VideoController.a();
      Ns = localVideoController.getChatRoomId(localVideoController.b().peerUin) + "";
    }
    if (paramInt == 5)
    {
      c("dc00898", "0X800984E", paramInt, paramString);
      return;
    }
    c("dc00898", "0X80088B3", paramInt, paramString);
  }
  
  public static void c(String paramString, long paramLong, int paramInt)
  {
    igd.aJ("MagicDataReport", "DOUBLE SCREEN DataReport onStateReport: |" + paramString + "|" + paramLong);
    HashMap localHashMap = new HashMap();
    localHashMap.put("activeName", paramString);
    localHashMap.put("duration", String.valueOf(paramLong));
    UserAction.onUserAction("actAVFunChatFace", true, -1L, -1L, localHashMap, true);
    try
    {
      UserAction.flushObjectsToDB(true);
      int i = 0;
      switch (paramInt)
      {
      default: 
        paramInt = i;
        if (paramInt != 0) {
          aa(paramInt, paramString);
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        igd.aL("MagicDataReport", localException.getMessage());
        continue;
        paramInt = 3;
        continue;
        paramInt = 4;
        continue;
        paramInt = 5;
      }
    }
  }
  
  public static void c(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    igd.aJ("MagicDataReport", "reportClickEvent key = " + paramString2 + ", fromType = " + paramInt + ", value = " + paramString3 + ", mRoomId = " + Ns);
    anot.a(null, paramString1, "", "", paramString2, paramString2, paramInt, 0, "", "", Ns, paramString3);
  }
  
  public static void iL(String paramString)
  {
    iR(paramString);
    reportClickEvent("0X8008021", null);
  }
  
  public static void iM(String paramString)
  {
    iR(paramString);
    reportClickEvent("0X800812F", null);
  }
  
  public static void iN(String paramString)
  {
    iR(paramString);
    reportClickEvent("0X8008130", null);
  }
  
  public static void iO(String paramString)
  {
    iR(paramString);
    reportClickEvent("0X800984D", null);
  }
  
  public static void iP(String paramString)
  {
    iR(paramString);
    reportClickEvent("0X8008131", null);
  }
  
  public static void iQ(String paramString)
  {
    iR(paramString);
    reportClickEvent("0X8008022", null);
  }
  
  static void iR(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("0"))) {
      Ns = paramString;
    }
  }
  
  public static void m(String paramString1, int paramInt, String paramString2)
  {
    iR(paramString2);
    Nr = paramString1;
  }
  
  public static void reportClickEvent(String paramString1, String paramString2)
  {
    c("CliOper", paramString1, 0, paramString2);
  }
  
  public static void stop(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 3) && (!TextUtils.isEmpty(Nq)))
    {
      long l = System.currentTimeMillis();
      c(Nq, (l - lt) / 1000L, AO);
      Nq = "";
      AO = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ijw
 * JD-Core Version:    0.7.0.1
 */