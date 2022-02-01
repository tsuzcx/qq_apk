import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class avgn
{
  private static final SimpleDateFormat G = new SimpleDateFormat("yyyyMMdd");
  private static final String[] iM = { "qlink_plugin.apk" };
  private static final String[] iN = { "qqreaderplugin.apk", "comic_plugin.apk", "Photoplus.apk" };
  private static final String[] iO = { "qqhotspot_plugin.apk" };
  private static final String[] iP = new String[0];
  private static final String[] iQ = { "qqreaderplugin.apk", "comic_plugin.apk" };
  private QQAppInterface app;
  private avfw b;
  private OnPluginInstallListener c = new avgo(this);
  private Context context;
  
  public avgn(Context paramContext, avfw paramavfw, QQAppInterface paramQQAppInterface)
  {
    this.context = paramContext;
    this.b = paramavfw;
    this.app = paramQQAppInterface;
    ezS();
  }
  
  private void aX(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PluginPreInstaller", 4, "installPlugin plugin = " + paramString + ", totalTimes = " + paramInt1 + ", todayTimes = " + paramInt2);
    }
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
    Object localObject = new Date();
    localObject = G.format((Date)localObject);
    localEditor.putInt("total_retried_times_" + paramString, paramInt1 + 1);
    localEditor.putInt("today_retried_times_" + paramString, paramInt2 + 1);
    localEditor.putString("last_retry_day_" + paramString, (String)localObject);
    localEditor.commit();
    this.b.a(paramString, this.c, true);
  }
  
  private void ezS()
  {
    if (!PreferenceManager.getDefaultSharedPreferences(this.context).getString("plugin_pre_install_qq_version", "").equals(aqgz.getQQVersion()))
    {
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
      Iterator localIterator = hz().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localEditor.remove("total_retried_times_" + str);
      }
      localEditor.commit();
    }
  }
  
  private int fU(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(this.context).getInt("total_retried_times_" + paramString, 0);
  }
  
  private int fV(String paramString)
  {
    int i = 0;
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
    Date localDate = new Date();
    if (G.format(localDate).equals(localSharedPreferences.getString("last_retry_day_" + paramString, ""))) {
      i = localSharedPreferences.getInt("today_retried_times_" + paramString, 0);
    }
    return i;
  }
  
  private List<String> hz()
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = iM;
    int k = arrayOfString.length;
    int i = 0;
    while (i < k)
    {
      localArrayList.add(arrayOfString[i]);
      i += 1;
    }
    if (aqiw.isWifiEnabled(this.context))
    {
      arrayOfString = iN;
      k = arrayOfString.length;
      i = 0;
      if (i < k)
      {
        String str = arrayOfString[i];
        if ((str.equals("Photoplus.apk")) && (VersionUtils.isIceScreamSandwich())) {}
        for (;;)
        {
          i += 1;
          break;
          localArrayList.add(str);
        }
      }
    }
    if ((aqgz.aCG()) || (aqhq.getAvailableInnernalMemorySize() <= 1.048576E+008F))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreInstaller", 2, "plugins " + Arrays.toString(iQ) + "filtered in low end phone");
      }
      arrayOfString = iQ;
      k = arrayOfString.length;
      i = j;
      while (i < k)
      {
        localArrayList.remove(arrayOfString[i]);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public void ezT()
  {
    for (;;)
    {
      int i;
      try
      {
        if (AppNetConnInfo.isWifiConn())
        {
          if (QLog.isColorLevel()) {
            QLog.e("PluginPreInstaller", 2, "preinstall start,wifi_reinstall_only.");
          }
          String[] arrayOfString = iP;
          int j = arrayOfString.length;
          i = 0;
          if (i < j)
          {
            String str = arrayOfString[i];
            try
            {
              if (!this.b.isPlugininstalled(str))
              {
                aX(str, fU(str), fV(str));
              }
              else if ("QQWifiPlugin.apk".equals(str))
              {
                Intent localIntent = new Intent("com.tencent.mobileqq.cooperation.plugin." + str);
                localIntent.putExtra("plugin", str);
                this.context.sendBroadcast(localIntent);
              }
            }
            catch (Exception localException)
            {
              if (!QLog.isColorLevel()) {
                break label192;
              }
            }
            QLog.e("PluginPreInstaller", 2, "preinstall plugin : " + str + " failed.", localException);
          }
        }
      }
      finally {}
      return;
      label192:
      i += 1;
    }
  }
  
  public void start()
  {
    try
    {
      Iterator localIterator = hz().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          if (this.b.isPlugininstalled(str)) {
            continue;
          }
          int i = fU(str);
          if (i >= 10) {
            continue;
          }
          int j = fV(str);
          if (j >= 2) {
            continue;
          }
          aX(str, i, j);
        }
        catch (Exception localException) {}
        if (QLog.isColorLevel()) {
          QLog.e("PluginPreInstaller", 2, "preinstall plugin : " + str + " failed.", localException);
        }
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avgn
 * JD-Core Version:    0.7.0.1
 */