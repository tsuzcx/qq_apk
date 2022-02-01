import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import mqq.app.NewIntent;

public class yih
  implements yjf
{
  private static HashMap<String, Boolean> gY = new HashMap();
  private static HashMap<String, Integer> gZ = new HashMap();
  private yjh a;
  private QQAppInterface app;
  private Activity mActivity;
  private SessionInfo sessionInfo;
  
  public static String[] a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    paramQQAppInterface = BaseApplication.getContext().getSharedPreferences("free_call", 0);
    long l = Long.parseLong(paramQQAppInterface.getString(hI(paramString), "-1"));
    if (Math.abs(paramLong - l) >= 86400000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReduFriendServlet", 2, "currTime is:" + paramLong + ",pullHotFriendTimeLong is:" + l + ",need to pull hot friend");
      }
      return null;
    }
    return paramQQAppInterface.getString(hJ(paramString), "").split("\\|");
  }
  
  public static String hH(String paramString)
  {
    return "voice_shown_hot_friend_tip_bar_" + paramString;
  }
  
  public static String hI(String paramString)
  {
    return "free_call_pull_hot_friend_time_" + paramString;
  }
  
  public static String hJ(String paramString)
  {
    return "free_call_hot_friend_" + paramString;
  }
  
  public static void s(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str1 = paramQQAppInterface.getCurrentAccountUin();
    String str2 = str1 + "_" + paramString;
    if (QLog.isColorLevel()) {
      QLog.d("ReduFriendServlet", 2, "afterShowHotFriendTip() is called,mapKey is:" + str2);
    }
    Object localObject = BaseApplication.getContext().getSharedPreferences("free_call", 0);
    String str3 = hH(str1);
    boolean bool = ((SharedPreferences)localObject).getBoolean(str3, false);
    if (bool) {
      if (QLog.isColorLevel()) {
        QLog.d("ReduFriendServlet", 2, "shownHotFriendTip is:" + bool + ",not need to save value");
      }
    }
    do
    {
      return;
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean(str3, true);
      long l = anaz.gQ();
      ((SharedPreferences.Editor)localObject).putString("voice_hot_friend_tip_show_time" + str1, String.valueOf(l * 1000L));
      ((SharedPreferences.Editor)localObject).commit();
      gY.put(str2, Boolean.TRUE);
      t(paramQQAppInterface, paramString);
    } while (!QLog.isColorLevel());
    QLog.d("ReduFriendServlet", 2, "shownHotFriendTip is:" + bool + ",need to save value");
  }
  
  public static void t(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = paramQQAppInterface + "_" + paramString;
    if (QLog.isColorLevel()) {
      QLog.d("ReduFriendServlet", 2, "incrementHotFriendEnterAIOTimes() is called,mapKey is:" + paramQQAppInterface);
    }
    if (gY.get(paramQQAppInterface) != null)
    {
      paramString = (Integer)gZ.get(paramQQAppInterface);
      if (paramString == null)
      {
        gZ.put(paramQQAppInterface, Integer.valueOf(1));
        if (QLog.isColorLevel()) {
          QLog.d("ReduFriendServlet", 2, "shownHotFriendTip flag exist,beforeTimes is:" + paramString);
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        gZ.put(paramQQAppInterface, Integer.valueOf(paramString.intValue() + 1));
      }
    }
    QLog.d("ReduFriendServlet", 2, "shownHotFriendTip flag does not exist,not increment time");
  }
  
  public static void u(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReduFriendServlet", 2, "removeShownHotFriendTipFlag() is called");
    }
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = paramQQAppInterface + "_" + paramString;
    gY.remove(paramQQAppInterface);
  }
  
  public int[] E()
  {
    return new int[] { 2000 };
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.mActivity).inflate(2131561202, null);
    paramVarArgs.findViewById(2131374820).setOnClickListener(new yii(this));
    return paramVarArgs;
  }
  
  public int b(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    Object localObject3 = paramQQAppInterface.getCurrentAccountUin();
    Object localObject4 = (String)localObject3 + "_" + paramString;
    if (QLog.isColorLevel()) {
      QLog.d("FriendHotTipsBar", 2, "shouldShowHotFriendVoiceCallBar() ==> ,mapKey is:" + (String)localObject4);
    }
    Object localObject2 = "";
    localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (gY.get(localObject4) == null) {
          continue;
        }
        localObject1 = localObject2;
        localObject3 = (Integer)gZ.get(localObject4);
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if (((Integer)localObject3).intValue() > 3) {
            continue;
          }
        }
        localObject1 = localObject2;
        localObject3 = ((acff)paramQQAppInterface.getManager(51)).e(paramString);
        if (localObject3 == null) {
          continue;
        }
        localObject1 = localObject2;
        if ((((Friends)localObject3).abilityBits & 1L) == 0L) {
          continue;
        }
        localObject1 = localObject2;
        i = ((Friends)localObject3).getNetWorkType();
        if (i != 2) {
          continue;
        }
        j = 2;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "");
          i = j;
        }
      }
      finally
      {
        try
        {
          int j;
          Object localObject5;
          long l;
          int k;
          int m;
          int n;
          int i1;
          anot.a(paramQQAppInterface, "CliOper", "", "", "Free_call", "Free_call_tips", 0, 0, "", "", "", "");
          int i = 1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "can show hot friend voice call bar");
          return 1;
        }
        finally
        {
          localObject1 = "can show hot friend voice call bar";
        }
        paramQQAppInterface = finally;
      }
      return i;
      i = 1;
      if (QLog.isColorLevel())
      {
        QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "find true flag from memory");
        return 1;
        localObject1 = localObject2;
        u(paramQQAppInterface, paramString);
        i = 2;
        if (QLog.isColorLevel())
        {
          QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "find true flag from memory but friend abilityBits does not contain support voice flag");
          return 2;
          localObject1 = localObject2;
          u(paramQQAppInterface, paramString);
          localObject1 = localObject2;
          paramQQAppInterface = "find true flag from memory but enterAIOTimes is too large,enterAIOTimes is:" + localObject3 + ",MAX_ENTER_TIMES is:" + 3;
          i = 2;
          if (QLog.isColorLevel())
          {
            QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + paramQQAppInterface);
            return 2;
            localObject1 = localObject2;
            localObject4 = BaseApplication.getContext().getSharedPreferences("free_call", 0);
            localObject1 = localObject2;
            if (((SharedPreferences)localObject4).getBoolean(hH((String)localObject3), false))
            {
              i = 2;
              if (QLog.isColorLevel())
              {
                QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "has shown hot friend tip");
                return 2;
              }
            }
            else
            {
              localObject1 = localObject2;
              localObject5 = ((SharedPreferences)localObject4).getString("voice_remark_tip_show_time" + (String)localObject3, "");
              localObject1 = localObject2;
              l = anaz.gQ() * 1000L;
              localObject1 = localObject2;
              localObject4 = new Time();
              localObject1 = localObject2;
              if (QLog.isColorLevel())
              {
                localObject1 = localObject2;
                QLog.d("FriendHotTipsBar", 2, "multiRemarkTipShowTime is:" + (String)localObject5 + ",currTimeMillis is:" + l);
              }
              if (localObject5 != null)
              {
                localObject1 = localObject2;
                if (((String)localObject5).length() > 0)
                {
                  localObject1 = localObject2;
                  localObject5 = ((String)localObject5).split("\\|");
                  localObject1 = localObject2;
                  ((Time)localObject4).set(l);
                  localObject1 = localObject2;
                  i = ((Time)localObject4).year;
                  localObject1 = localObject2;
                  j = ((Time)localObject4).month;
                  localObject1 = localObject2;
                  k = ((Time)localObject4).monthDay;
                  localObject1 = localObject2;
                  ((Time)localObject4).set(Long.parseLong(localObject5[(localObject5.length - 1)]));
                  localObject1 = localObject2;
                  m = ((Time)localObject4).year;
                  localObject1 = localObject2;
                  n = ((Time)localObject4).month;
                  localObject1 = localObject2;
                  i1 = ((Time)localObject4).monthDay;
                  if ((i == m) && (j == n) && (k == i1))
                  {
                    i = 2;
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "has shown remark tip this day");
                    return 2;
                  }
                }
              }
              localObject1 = localObject2;
              if (!aqiw.isWifiConnected(BaseApplication.getContext()))
              {
                localObject1 = localObject2;
                if (!aqiw.is3Gor4G(BaseApplication.getContext()))
                {
                  i = 2;
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "my network is not wifi or 3g or 4g");
                  return 2;
                }
              }
              localObject1 = localObject2;
              localObject4 = a(paramQQAppInterface, (String)localObject3, anaz.gQ());
              if (localObject4 == null)
              {
                paramString = "there is no hot friend,need to pull";
                if (paramBoolean)
                {
                  localObject1 = paramString;
                  localObject2 = new NewIntent(paramQQAppInterface.getApp(), anez.class);
                  localObject1 = paramString;
                  ((NewIntent)localObject2).putExtra("k_uin", (String)localObject3);
                  localObject1 = paramString;
                  paramQQAppInterface.startServlet((NewIntent)localObject2);
                  i = 3;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "there is no hot friend,need to pull");
                    return 3;
                  }
                }
                else
                {
                  i = 2;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "there is no hot friend,need to pull");
                    return 2;
                  }
                }
              }
              else
              {
                localObject1 = localObject2;
                localObject3 = new HashMap();
                i = 0;
                localObject1 = localObject2;
                if (i < localObject4.length)
                {
                  localObject1 = localObject2;
                  ((HashMap)localObject3).put(localObject4[i], localObject4[i]);
                  i += 1;
                }
                else
                {
                  localObject1 = localObject2;
                  if (((HashMap)localObject3).get(paramString) != null)
                  {
                    localObject1 = localObject2;
                    localObject3 = ((acff)paramQQAppInterface.getManager(51)).e(paramString);
                    if (localObject3 == null)
                    {
                      localObject1 = localObject2;
                      paramQQAppInterface = "can not find friend,friendUin is:" + paramString;
                      i = 2;
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + paramQQAppInterface);
                      return 2;
                    }
                  }
                  else
                  {
                    localObject1 = localObject2;
                    paramQQAppInterface = "friend does not exist in hot friend,friendUin is:" + paramString + ",hotFriend is:" + Arrays.toString((Object[])localObject4);
                    i = 2;
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + paramQQAppInterface);
                    return 2;
                  }
                  localObject1 = localObject2;
                  if ((((Friends)localObject3).abilityBits & 1L) == 0L)
                  {
                    localObject1 = localObject2;
                    paramQQAppInterface = "friend abilityBits does not contain support voice flag,f.abilityBits is:" + ((Friends)localObject3).abilityBits;
                    i = 2;
                    if (QLog.isColorLevel())
                    {
                      QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + paramQQAppInterface);
                      return 2;
                    }
                  }
                  else
                  {
                    localObject1 = localObject2;
                    i = ((Friends)localObject3).getNetWorkType();
                    if (i == 2)
                    {
                      i = 2;
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "");
                      return 2;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + (String)localObject1);
    }
    throw paramQQAppInterface;
  }
  
  public void check()
  {
    if (this.sessionInfo.cZ != 0) {
      if (QLog.isColorLevel()) {
        QLog.d("FriendHotTipsBar", 2, "curType != Friend");
      }
    }
    aeve localaeve;
    do
    {
      do
      {
        return;
        localaeve = aeve.a(this.app);
        if (!localaeve.aR(this.sessionInfo.cZ, 1)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("FriendHotTipsBar", 2, "hasNetTipShow today");
      return;
    } while ((b(this.app, this.sessionInfo.aTl, true) != 1) || (!this.a.a(this, new Object[0])));
    s(this.app, this.sessionInfo.aTl);
    localaeve.f(this.app, this.sessionInfo.cZ, 1);
  }
  
  public int getType()
  {
    return 5;
  }
  
  public void h(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendHotTipsBar", 2, "onAIOEvent() : TYPE_ON_SHOW =====>");
    }
    check();
  }
  
  public int wM()
  {
    return 40;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yih
 * JD-Core Version:    0.7.0.1
 */