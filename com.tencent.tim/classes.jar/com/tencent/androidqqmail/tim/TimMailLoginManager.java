package com.tencent.androidqqmail.tim;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import mqq.app.AppRuntime;

public final class TimMailLoginManager
{
  private static final String TAG = "TimMailLoginManager";
  private static final HashMap<String, String> a2Map = new HashMap();
  public static boolean firstLaunchMailProccess = false;
  private static final HashMap<String, String> skeyMap = new HashMap();
  public static Set<String> syncAccountList = new HashSet();
  public static final String syncAccountPwd = "-1";
  
  static
  {
    firstLaunchMailProccess = true;
  }
  
  private static String formatUin(String paramString)
  {
    int i = paramString.indexOf('@');
    String str = paramString;
    if (i >= 0) {
      str = paramString.substring(0, i);
    }
    if (!str.matches("^\\d+$")) {
      throw new IllegalArgumentException("no number uin :" + str);
    }
    return str;
  }
  
  @Nullable
  public static String getA2(String arg0)
  {
    String str2 = formatUin(???);
    synchronized (a2Map)
    {
      String str1 = (String)a2Map.get(str2);
      ??? = str1;
      if (str1 == null)
      {
        String str3 = QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getString("tim_a2_" + str2, null);
        ??? = str1;
        if (str3 != null) {
          ??? = Aes.decode(str3, Aes.getServerKey());
        }
      }
      QMLog.log(4, "TimMailLoginManager", String.format("getA2 uin[%s], a2[%s]", new Object[] { str2, truncateString(???, 10) }));
      return ???;
    }
  }
  
  public static String getSkey(String arg0)
  {
    String str2 = formatUin(???);
    synchronized (skeyMap)
    {
      String str1 = (String)skeyMap.get(str2);
      ??? = str1;
      if (str1 == null)
      {
        String str3 = QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getString("tim_skey_" + str2, null);
        ??? = str1;
        if (str3 != null) {
          ??? = Aes.decode(str3, Aes.getServerKey());
        }
      }
      QMLog.log(4, "TimMailLoginManager", String.format("getSkey uin[%s], a2[%s]", new Object[] { str2, truncateString(???, 5) }));
      return ???;
    }
  }
  
  public static void notifyLoginChange(Context paramContext, boolean paramBoolean, Account paramAccount)
  {
    int i = 2;
    QMLog.log(4, "TimMailLoginManager", "begin notifyLoginChange protocol " + paramAccount.getProtocol());
    if ((paramContext == null) || (paramAccount == null)) {
      return;
    }
    Intent localIntent;
    String str;
    if (paramAccount.getProtocol() == 1)
    {
      i = 1;
      QMLog.log(4, "TimMailLoginManager", "login " + paramBoolean + " notifyLoginChange " + paramAccount.getUin());
      localIntent = new Intent();
      localIntent.setPackage("com.tencent.tim");
      localIntent.setAction("com.tencent.androidqqmail.tim.mail.broadcast");
      if (!paramBoolean) {
        break label195;
      }
      str = "bindmail";
      label119:
      localIntent.putExtra("cmd", str);
      localIntent.putExtra("mailAccountType", i);
      if (i != 1) {
        break label202;
      }
    }
    label195:
    label202:
    for (paramAccount = paramAccount.getUin() + "@qq.com";; paramAccount = paramAccount.getEmail())
    {
      localIntent.putExtra("mailAccount", paramAccount);
      paramContext.sendBroadcast(localIntent);
      return;
      if (paramAccount.getProtocol() == 2) {
        break;
      }
      i = 0;
      break;
      str = "unbindmail";
      break label119;
    }
  }
  
  public static void requestA2AndSkey(@NonNull String paramString1, @Nullable String paramString2, @NonNull GetTicketCallback paramGetTicketCallback)
  {
    AppRuntime localAppRuntime = QMAppInterface.getRuntime();
    String str = localAppRuntime.getAccount();
    if (str == null) {
      throw new IllegalStateException("TIM runtime get non-account");
    }
    if (!str.matches("^\\d+(@.+)?$")) {
      throw new IllegalArgumentException("TIM runtime get invalid account:" + str);
    }
    if ((paramString2 == null) && (!str.equals(paramString1)) && (!(str + "@qq.com").equals(paramString1))) {
      throw new IllegalArgumentException(String.format("TIM account [%s,%s] no pwd", new Object[] { str, paramString1 }));
    }
    Threads.runInBackground(new TimMailLoginManager.1(paramString2, paramString1, str, localAppRuntime, paramGetTicketCallback));
  }
  
  private static void setA2(@NonNull String paramString1, @NonNull String paramString2)
  {
    if ((paramString2 == null) || (paramString2.length() == 0)) {
      throw new IllegalArgumentException("a2 invalid: " + paramString2);
    }
    paramString1 = formatUin(paramString1);
    ??? = Aes.encode(paramString2, Aes.getServerKey());
    QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit().putString("tim_a2_" + paramString1, (String)???).commit();
    synchronized (a2Map)
    {
      a2Map.put(paramString1, paramString2);
      QMLog.log(4, "TimMailLoginManager", String.format("setA2 uin[%s], a2[%s]", new Object[] { paramString1, truncateString(paramString2, 10) }));
      return;
    }
  }
  
  private static void setSkey(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.length() == 0)) {
      throw new IllegalArgumentException("skey invalid: " + paramString2);
    }
    paramString1 = formatUin(paramString1);
    ??? = Aes.encode(paramString2, Aes.getServerKey());
    QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit().putString("tim_skey_" + paramString1, (String)???).commit();
    synchronized (skeyMap)
    {
      skeyMap.put(paramString1, paramString2);
      QMLog.log(4, "TimMailLoginManager", String.format("setSkey uin[%s], a2[%s]", new Object[] { paramString1, truncateString(paramString2, 5) }));
      return;
    }
  }
  
  private static String truncateString(String paramString, int paramInt)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.substring(0, Math.min(paramInt, paramString.length()));
  }
  
  public static abstract interface GetTicketCallback
  {
    public abstract void onError(String paramString, int paramInt1, int paramInt2);
    
    public abstract void onSuccess(@NonNull String paramString1, @NonNull String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.tim.TimMailLoginManager
 * JD-Core Version:    0.7.0.1
 */