import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.BaseToolbar;
import com.tencent.av.ui.RedbagToolbar;
import com.tencent.av.ui.RedbagToolbar.a;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class jij
{
  public static String Ns;
  public static int aAc;
  public static int mFromType = 0;
  public static long pB;
  
  public static void B(boolean paramBoolean, int paramInt)
  {
    int i = 1;
    int j = cG(paramInt);
    if (QLog.isDevelopLevel()) {
      QLog.w("RedBagReport", 1, "reportClickEvent, key[" + "0X8008978" + "], mRoomId[" + Ns + "], ret[" + paramBoolean + "], disableType[" + paramInt + "], light[" + j + "]");
    }
    if (paramBoolean) {}
    for (;;)
    {
      anot.a(null, "dc00898", "", "", "0X8008978", "0X8008978", j, i, String.valueOf(paramInt), "", Ns, String.valueOf(j));
      return;
      i = 0;
    }
  }
  
  public static void C(boolean paramBoolean, int paramInt)
  {
    String str = "0X8008A99";
    if (!paramBoolean) {
      str = "0X8008A9A";
    }
    anot.a(null, "dc00898", "", "", str, str, mFromType, 0, String.valueOf(paramInt), "", Ns, null);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, BaseToolbar paramBaseToolbar)
  {
    if (paramBaseToolbar != null)
    {
      paramBaseToolbar = new RedbagToolbar.a();
      RedbagToolbar.getRedBagBtnStatus(paramVideoAppInterface, paramBaseToolbar);
    }
    for (int j = paramBaseToolbar.mDisableType;; j = -1)
    {
      int n;
      int k;
      int i;
      if (j != -1)
      {
        n = cG(j);
        if (n != 2) {
          break label243;
        }
        k = 0;
        i = 1;
        if (k >= 32) {
          break label243;
        }
        if ((j & i) != i) {}
      }
      for (;;)
      {
        k = 0;
        int m = 1;
        label65:
        if (k < 32)
        {
          if ((j & m) == m) {
            if ((m & 0x3F) == 0) {
              break label130;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            irm.j(bool, String.valueOf(m));
            m <<= 1;
            k += 1;
            break label65;
            k += 1;
            i <<= 1;
            break;
          }
        }
        label130:
        if (QLog.isDevelopLevel()) {
          QLog.w("RedBagReport", 1, "reportClickEvent, key[" + "0X8008977" + "], statusFixedEntrance[" + j + "], mRoomId[" + Ns + "], light[" + n + "], first[" + i + "]");
        }
        anot.a(null, "dc00898", "", "", "0X8008977", "0X8008977", n, 0, String.valueOf(i), String.valueOf(j), Ns, "");
        return;
        label243:
        i = 0;
      }
    }
  }
  
  public static void awE()
  {
    reportClickEvent("0X8008984", null);
  }
  
  public static void awF()
  {
    reportClickEvent("0X8008985", null);
  }
  
  public static void awG()
  {
    reportClickEvent("0X8008986", null);
  }
  
  public static void awH()
  {
    reportClickEvent("0X8008987", null);
  }
  
  public static void awI()
  {
    reportClickEvent("0X8008988", null);
  }
  
  public static void awJ()
  {
    aAc += 1;
  }
  
  public static void awK()
  {
    aAc = 0;
  }
  
  public static void awL()
  {
    if ((!TextUtils.isEmpty(Ns)) && (aAc > 0))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("count", String.valueOf(aAc));
      localHashMap.put("roomid", Ns);
      UserAction.onUserAction("reportAVRedbagCount", true, -1L, -1L, localHashMap, true);
    }
    if (AudioHelper.isDev()) {
      QLog.w("RedBagReport", 1, "reportRedbagCount, count[" + aAc + "], mRoomId[" + Ns + "]");
    }
  }
  
  public static void awM()
  {
    pB = System.currentTimeMillis();
    if (AudioHelper.isDev()) {
      QLog.w("RedBagReport", 1, "setGameBeginTime, mGameBeginTime[" + pB + "]");
    }
  }
  
  public static void awN()
  {
    reportClickEvent("0X8008A98", null);
  }
  
  public static void awO()
  {
    reportClickEvent("0X8008CF0", null);
  }
  
  public static void awP()
  {
    reportClickEvent("0X8008CF1", null);
  }
  
  public static void awQ()
  {
    reportClickEvent("0X8008A9B", null);
  }
  
  public static void awR()
  {
    reportClickEvent("0X8008CF2", null);
  }
  
  public static void awS()
  {
    reportClickEvent("0X8008CF3", null);
  }
  
  static int cG(int paramInt)
  {
    int i = 1;
    if ((paramInt & 0x3F) != 0) {
      i = 2;
    }
    return i;
  }
  
  public static void d(jil paramjil)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("RedBagReport", 1, "reportClickEvent, key[" + "0X800897F" + "], fromType[" + mFromType + "], mSucAboutGame[" + paramjil.Zw + "], mExceptionType[" + paramjil.aAk + "], mRoomId[" + Ns + "]");
    }
    int i = mFromType;
    int j = paramjil.aAk;
    if (paramjil.Zw) {}
    for (paramjil = "1";; paramjil = "0")
    {
      anot.a(null, "dc00898", "", "", "0X800897F", "0X800897F", i, 0, String.valueOf(j), paramjil, Ns, "");
      return;
    }
  }
  
  public static void e(jil paramjil)
  {
    String str2 = "0X8008982";
    String str1 = str2;
    switch (paramjil.aAj)
    {
    default: 
      str1 = str2;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("RedBagReport", 1, "reportClickEvent, key[" + str1 + "], fromType[" + mFromType + "], getRedbag_ResultCode[" + paramjil.Sp + "], getRedbag_ResultState[" + paramjil.Sq + "], mRoomId[" + Ns + "], hitScore[" + paramjil.aAf + "]");
      }
      anot.a(null, "dc00898", "", "", str1, str1, mFromType, paramjil.aAf, String.valueOf(paramjil.aAk), paramjil.Sp, Ns, paramjil.Sq);
      return;
      str1 = "0X800897E";
      continue;
      str1 = "0X8008983";
      continue;
      str1 = "0X8008981";
      continue;
      str1 = "0X8008980";
    }
  }
  
  public static void ec(long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("RedBagReport", 1, "setCurRoomId, RoomId[" + Ns + "->" + paramLong + "]");
    }
    Ns = String.valueOf(paramLong);
  }
  
  public static void kD(String paramString)
  {
    long l1 = pB;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(Ns))
    {
      bool1 = bool2;
      if (pB > 0L)
      {
        long l2 = System.currentTimeMillis();
        long l3 = pB;
        HashMap localHashMap = new HashMap();
        localHashMap.put("time", String.valueOf(l2 - l3));
        localHashMap.put("redbagId", String.valueOf(paramString));
        localHashMap.put("roomid", Ns);
        bool1 = UserAction.onUserAction("reportAVRedbagGameTime", true, -1L, -1L, localHashMap, true);
        pB = 0L;
      }
    }
    if (AudioHelper.isDev()) {
      QLog.w("RedBagReport", 1, "reportRedbagCount, count[" + aAc + "], mRoomId[" + Ns + "], begin[" + l1 + "], ret[" + bool1 + "]");
    }
  }
  
  public static void nA(int paramInt)
  {
    mFromType = paramInt;
  }
  
  public static void nB(int paramInt)
  {
    String str;
    if (paramInt == 0)
    {
      str = "0X800897B";
      awJ();
    }
    for (;;)
    {
      reportClickEvent(str, null);
      return;
      if (paramInt == 4) {
        str = "0X800897C";
      } else {
        str = "0X800897D";
      }
    }
  }
  
  public static void reportClickEvent(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("RedBagReport", 1, "reportClickEvent, key[" + paramString1 + "], mFromType[" + mFromType + "], value[" + paramString2 + "], mRoomId[" + Ns + "]");
    }
    anot.a(null, "dc00898", "", "", paramString1, paramString1, mFromType, 0, "", "", Ns, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jij
 * JD-Core Version:    0.7.0.1
 */