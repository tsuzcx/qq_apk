import com.tencent.beacon.event.UserAction;
import java.util.HashMap;
import java.util.Map;

public class jfq
{
  static String RQ = "0";
  static String RR = "actAVFunChatVoiceChange";
  public static String TAG = "VoiceChangeDataReport";
  static boolean YU;
  static boolean YV;
  static boolean YW;
  static int ayC;
  static int ayD;
  static int ayE;
  static boolean hasAudio;
  static long start;
  
  public static void A(int paramInt, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("typeid", paramInt + "");
    localHashMap.put("duration", paramLong + "");
    UserAction.onUserAction(RR, true, -1L, -1L, localHashMap, true);
    igd.aH(TAG, String.format("reportVoiceChange voiceType = %s, duration = %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
  }
  
  public static void a(iiv paramiiv, int paramInt)
  {
    igd.aH(TAG, String.format("updateReportData sessionType = %d, voiceType = %d", new Object[] { Integer.valueOf(paramiiv.amI), Integer.valueOf(paramInt) }));
    long l = System.currentTimeMillis();
    if (ayC != 0) {
      A(ayC, (l - start) / 1000L);
    }
    ayC = paramInt;
    start = l;
    if ((paramiiv.amI == 1) || (paramiiv.amI == 3))
    {
      if (ayC != 0) {
        ayD = ayC;
      }
      hasAudio = true;
    }
    while ((paramiiv.amI != 2) && (paramiiv.amI != 4)) {
      return;
    }
    if (ayC != 0) {
      ayE = ayC;
    }
    YU = true;
  }
  
  public static void aj(int paramInt, String paramString)
  {
    igd.aH(TAG, String.format("onConnected sessionType = %s, roomid = %s", new Object[] { Integer.valueOf(paramInt), paramString }));
    YW = true;
    RQ = paramString;
    if ((paramInt == 1) || (paramInt == 3))
    {
      if (ayC != 0) {
        ayD = ayC;
      }
      hasAudio = true;
    }
    while ((paramInt != 2) && (paramInt != 4)) {
      return;
    }
    if (ayC != 0) {
      ayE = ayC;
    }
    YU = true;
  }
  
  public static void f(iiv paramiiv)
  {
    if ((!YV) || (!YW)) {
      return;
    }
    if ((paramiiv.amI == 1) || (paramiiv.amI == 2)) {
      if (hasAudio)
      {
        if (ayD == 0) {
          reportClickEvent("0X8007DC3", "");
        }
      }
      else if (YU)
      {
        if (ayE != 0) {
          break label115;
        }
        reportClickEvent("0X8007DC5", "");
      }
    }
    for (;;)
    {
      a(paramiiv, 0);
      YV = false;
      YW = false;
      RQ = "0";
      return;
      reportClickEvent("0X8007DC2", ayD + "");
      break;
      label115:
      reportClickEvent("0X8007DC4", ayE + "");
      continue;
      if ((paramiiv.amI == 3) || (paramiiv.amI == 4)) {
        if (paramiiv.anb == 1)
        {
          if (hasAudio)
          {
            if (ayD != 0) {
              break label209;
            }
            reportClickEvent("0X8007E67", "");
          }
          for (;;)
          {
            if (!YU) {
              break label236;
            }
            if (ayE != 0) {
              break label238;
            }
            reportClickEvent("0X8007E69", "");
            break;
            label209:
            reportClickEvent("0X8007E68", ayD + "");
          }
          label236:
          continue;
          label238:
          reportClickEvent("0X8007E6A", ayE + "");
        }
        else if (paramiiv.anb == 10)
        {
          if (hasAudio)
          {
            if (ayD != 0) {
              break label317;
            }
            reportClickEvent("0X8007E63", "");
          }
          for (;;)
          {
            if (!YU) {
              break label344;
            }
            if (ayE != 0) {
              break label346;
            }
            reportClickEvent("0X8007E65", "");
            break;
            label317:
            reportClickEvent("0X8007E64", ayD + "");
          }
          label344:
          continue;
          label346:
          reportClickEvent("0X8007E66", ayE + "");
        }
      }
    }
  }
  
  public static void reportClickEvent(String paramString1, String paramString2)
  {
    igd.aH(TAG, String.format("reportClickEvent key = %s, type = %s, roomid = %s", new Object[] { paramString1, paramString2, RQ }));
    anot.a(null, "dc00898", "", "", paramString1, paramString1, 0, 0, paramString2, "", RQ, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jfq
 * JD-Core Version:    0.7.0.1
 */