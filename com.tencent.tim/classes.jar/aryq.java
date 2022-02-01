import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.open.downloadnew.DownloadInfo;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class aryq
{
  public static String DB()
  {
    return arxs.a(aroi.a().getContext(), null).getString("Common_myapp_download_url");
  }
  
  public static String P(int paramInt, String paramString)
  {
    if ("biz_src_zf_games".equals(paramString)) {
      switch (paramInt)
      {
      default: 
        paramString = "Common_GC_InstallYYB_Install_Words";
      }
    }
    for (;;)
    {
      return arxs.a(aroi.a().getContext(), null).getString(paramString);
      paramString = "Common_GC_InstallYYB_Install_Words";
      continue;
      paramString = "Common_GC_InstallYYB_Update_Words";
      continue;
      paramString = "Common_GC_UpdateYYB_Install_Words";
      continue;
      paramString = "Common_GC_UpdateYYB_Update_Words";
      continue;
      if ("biz_src_jc_update".equals(paramString)) {
        switch (paramInt)
        {
        case 2: 
        default: 
          paramString = null;
          break;
        case 1: 
          paramString = "Common_QQUpdate_InstallYYB_Update_Words";
          break;
        case 3: 
          paramString = "Common_QQUpdate_UpdateYYB_Update_Words";
          break;
        }
      } else {
        switch (paramInt)
        {
        default: 
          paramString = "Common_InstallYYB_Install_Words";
          break;
        case 1: 
          paramString = "Common_InstallYYB_Install_Words";
          break;
        case 2: 
          paramString = "Common_InstallYYB_Update_Words";
          break;
        case 3: 
          paramString = "Common_UpdateYYB_Install_Words";
          break;
        case 4: 
          paramString = "Common_UpdateYYB_Update_Words";
        }
      }
    }
  }
  
  public static boolean aHl()
  {
    return true;
  }
  
  public static boolean aHm()
  {
    DownloadInfo localDownloadInfo = aryy.a().c("1101070898");
    Object localObject = "";
    if (localDownloadInfo != null) {
      localObject = localDownloadInfo.filePath;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new File((String)localObject);
      if ((localObject != null) && (((File)localObject).exists())) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean aHn()
  {
    return arxs.a(aroi.a().getContext(), null).getInt("Common_root_autoinstall_flag") <= 0;
  }
  
  public static boolean aHo()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (arxn.fA("com.tencent.android.qqdownloader") > 4001126)
    {
      bool1 = bool2;
      if (arxs.a(aroi.a().getContext(), null).ss("Common_QQ_CARRY_IDENTITY")) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean aHp()
  {
    Object localObject = arxs.a(aroi.a().getContext(), null).getString("Common_Release_Control").trim();
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      do
      {
        return true;
      } while (((String)localObject).equals("-1"));
      if (((String)localObject).equals("-2")) {
        return false;
      }
      localObject = ((String)localObject).split(";");
    } while (localObject == null);
    String str1 = String.valueOf(aroi.a().getUin());
    if (str1 == null) {
      return false;
    }
    int j = localObject.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label115;
      }
      String str2 = localObject[i];
      if ((str2.length() == 2) && (str1.endsWith(str2))) {
        break;
      }
      i += 1;
    }
    label115:
    return false;
  }
  
  public static boolean aHq()
  {
    if (!arxs.a(aroi.a().getContext(), null).ss("Common_Show_Dialog_Flag")) {}
    int i;
    int j;
    do
    {
      boolean bool;
      do
      {
        return false;
        localObject = aroi.a().getContext().getSharedPreferences("share_myAppApi", 0);
        bool = ((SharedPreferences)localObject).getBoolean("SP_Has_shown_Dialog", false);
        if (!arxs.a(aroi.a().getContext(), null).getBoolean("Common_Dialog_Only_Once_Flag")) {
          break;
        }
      } while (bool);
      return true;
      i = arxs.a(aroi.a().getContext(), null).getInt("Common_Max_Count");
      arwt.d("OpenConfig-MyAppApi", " maxCount = " + i);
      if ((i == -1) || (i == 0)) {
        return true;
      }
      j = ((SharedPreferences)localObject).getInt("SP_Show_Dialog_Count", 0);
      Object localObject = ((SharedPreferences)localObject).getString("SP_Show_Dialog_Date", "");
      if (!new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())).equals(localObject)) {
        break;
      }
    } while (j >= i);
    return true;
    return true;
  }
  
  public static boolean aHr()
  {
    return arxs.a(aroi.a().getContext(), null).ss("Common_MyAppDownload_Flag");
  }
  
  public static boolean aHs()
  {
    return arxs.a(aroi.a().getContext(), null).ss("Common_Detail_Page");
  }
  
  public static boolean aHt()
  {
    boolean bool2 = false;
    boolean bool3 = arxs.a(aroi.a().getContext(), null).st("Common_tmast_wake");
    long l1 = arxs.a(aroi.a().getContext(), null).getLong("Common_wake_limite");
    long l2 = arxs.a(aroi.a().getContext(), null).getLong("Common_wake_interval") * 1000L;
    SharedPreferences localSharedPreferences = aroi.a().getContext().getSharedPreferences("share_myAppApi", 0);
    int i = localSharedPreferences.getInt("tmast_wake_times", 0);
    long l3 = localSharedPreferences.getLong("tmast_wake_last_time", 0L);
    boolean bool4 = bt(l3);
    if (!bool4) {
      i = 0;
    }
    arwt.d("TAMST_WAKE", ">>allowTmastWake allowWake = " + bool3 + " wakeLimit = " + l1 + " wakeInterval = " + l2 + " wakeTimes = " + i + " isToday = " + bool4);
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (i < l1) {
        if (System.currentTimeMillis() - l3 <= l2)
        {
          bool1 = bool2;
          if (bool4) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean aHu()
  {
    return arxs.a(aroi.a().getContext(), null).ss("Common_yyb_wifi_download_Switch");
  }
  
  public static boolean bt(long paramLong)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTime(new Date(System.currentTimeMillis()));
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTime(new Date(paramLong));
    return (localCalendar2.get(1) == localCalendar1.get(1)) && (localCalendar2.get(6) - localCalendar1.get(6) == 0);
  }
  
  public static boolean db(long paramLong)
  {
    SharedPreferences localSharedPreferences = aroi.a().getContext().getSharedPreferences("share_myAppApi", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    long l = localSharedPreferences.getLong("SP_Lastest_require_time", paramLong);
    if (paramLong - l >= jdMethod_if())
    {
      localEditor.putLong("SP_Lastest_require_time", paramLong);
      localEditor.commit();
    }
    while (paramLong == l) {
      return true;
    }
    return false;
  }
  
  public static void elZ()
  {
    int i = 1;
    if (!arxs.a(aroi.a().getContext(), null).ss("Common_Show_Dialog_Flag")) {}
    SharedPreferences.Editor localEditor;
    do
    {
      return;
      localObject = aroi.a().getContext().getSharedPreferences("share_myAppApi", 0);
      localEditor = ((SharedPreferences)localObject).edit();
      if (arxs.a(aroi.a().getContext(), null).getBoolean("Common_Dialog_Only_Once_Flag"))
      {
        localEditor.putBoolean("SP_Has_shown_Dialog", true);
        localEditor.commit();
        return;
      }
      j = arxs.a(aroi.a().getContext(), null).getInt("Common_Max_Count");
    } while ((j == -1) || (j == 0));
    int j = ((SharedPreferences)localObject).getInt("SP_Show_Dialog_Count", 0);
    Object localObject = ((SharedPreferences)localObject).getString("SP_Show_Dialog_Date", "");
    String str = new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis()));
    if (str.equals(localObject)) {
      i = j + 1;
    }
    localEditor.putInt("SP_Show_Dialog_Count", i);
    localEditor.putString("SP_Show_Dialog_Date", str);
    localEditor.commit();
  }
  
  public static void ema()
  {
    int i = 0;
    SharedPreferences localSharedPreferences = aroi.a().getContext().getSharedPreferences("share_myAppApi", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    int j = localSharedPreferences.getInt("tmast_wake_times", 0);
    if (!bt(localSharedPreferences.getLong("tmast_wake_last_time", 0L))) {}
    for (;;)
    {
      localEditor.putInt("tmast_wake_times", i + 1);
      localEditor.putLong("tmast_wake_last_time", System.currentTimeMillis());
      return;
      i = j;
    }
  }
  
  public static long ie()
  {
    return arxs.a(aroi.a().getContext(), null).getLong("Common_tips_dialog_interval");
  }
  
  public static long jdMethod_if()
  {
    return arxs.a(aroi.a().getContext(), null).getLong("Common_require_root_interval");
  }
  
  public static void ms(long paramLong)
  {
    SharedPreferences.Editor localEditor = aroi.a().getContext().getSharedPreferences("share_myAppApi", 0).edit();
    localEditor.putLong("SP_Lastest_require_time", paramLong);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aryq
 * JD-Core Version:    0.7.0.1
 */