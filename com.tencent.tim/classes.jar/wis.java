import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOOpenWebMonitor.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.URLEncoder;
import java.util.HashMap;

public class wis
{
  private static String aSk = "";
  private static int bNB;
  private static ArrayMap<String, Long> c;
  private static HashMap<String, String> gH;
  private static int state = -1;
  
  public static void a(Intent paramIntent, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      break label4;
    }
    label4:
    while (SystemClock.uptimeMillis() % 10L != 1L) {
      return;
    }
    int j = anqx.jv(paramMessageRecord.istroop);
    if (wgv.bcj) {}
    for (int i = 1;; i = 2)
    {
      b(paramIntent, j, i);
      paramIntent = paramMessageRecord.frienduin;
      long l = paramMessageRecord.msgUid;
      i = paramMessageRecord.istroop;
      if (TextUtils.isEmpty(paramIntent)) {
        break;
      }
      ThreadManager.post(new AIOOpenWebMonitor.1(paramQQAppInterface, i, paramIntent, l), 2, null, false);
      return;
    }
  }
  
  public static void a(Intent paramIntent, String paramString1, String paramString2)
  {
    if (paramIntent == null) {}
    long l;
    do
    {
      do
      {
        return;
      } while ((state != 1) || (!paramIntent.getBooleanExtra("aio_open_web", false)));
      l = SystemClock.uptimeMillis();
      if (paramString1 != null)
      {
        paramIntent = (Long)c.remove(paramString1);
        if (paramIntent != null) {
          gH.put(paramString1, l - paramIntent.longValue() + "");
        }
      }
    } while (paramString2 == null);
    c.put(paramString2, Long.valueOf(l));
  }
  
  public static void b(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramIntent.putExtra("aio_open_web", true);
    paramIntent.putExtra("from_aio_opt", paramInt2);
    paramIntent.putExtra("from_aio", paramInt1);
    paramIntent.putExtra("from_aio_time", SystemClock.uptimeMillis());
  }
  
  public static void b(Intent paramIntent, String paramString1, String paramString2)
  {
    if (paramIntent == null) {}
    while ((state != 1) || (!paramIntent.getBooleanExtra("aio_open_web", false))) {
      return;
    }
    gH.put(paramString1, paramString2);
  }
  
  public static void bYp()
  {
    if (Build.VERSION.SDK_INT > 10)
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("web_process_preload_file", 4);
      int i = localSharedPreferences.getInt("aio_preload_qweb_cout", 0);
      localSharedPreferences.edit().putInt("aio_preload_qweb_cout", i + 1).commit();
    }
  }
  
  public static void cj(Intent paramIntent)
  {
    int i = 1;
    bNB += 1;
    if (paramIntent == null) {
      break label14;
    }
    label14:
    while (!paramIntent.getBooleanExtra("aio_open_web", false)) {
      return;
    }
    long l = paramIntent.getLongExtra("from_aio_time", -1L);
    label62:
    label89:
    int j;
    label105:
    String str;
    if ((gH == null) || (gH.size() > 25))
    {
      gH = new HashMap();
      if ((c != null) && (c.size() <= 25)) {
        break label437;
      }
      c = new ArrayMap();
      if ((bNB != 1) || (WebProcessReceiver.edH != 1)) {
        break label446;
      }
      j = 1;
      state = 1;
      gH.put("from", paramIntent.getIntExtra("from_aio", 1) + "");
      gH.put("use_optimization", paramIntent.getIntExtra("from_aio_opt", 2) + "");
      HashMap localHashMap = gH;
      if (bNB != 1) {
        break label451;
      }
      str = "1";
      label193:
      localHashMap.put("first_open", str);
      gH.put("network_type", jqc.getNetWorkType() + "");
      localHashMap = gH;
      if (WebProcessReceiver.edH != 1) {
        break label458;
      }
      str = "1";
      label249:
      localHashMap.put("has_pp", str);
      if (WebProcessReceiver.edH != 1) {
        break label465;
      }
    }
    for (;;)
    {
      gH.put("ps_state", i + "");
      b(paramIntent, "click_to_activity", SystemClock.uptimeMillis() - l + "");
      gH.put("open_finished", "2");
      c.put("web_finish", Long.valueOf(l));
      a(paramIntent, "click_to_activity", "activity_to_webview");
      paramIntent.removeExtra("from_aio");
      paramIntent.removeExtra("from_aio_time");
      paramIntent.removeExtra("from_aio_opt");
      if ((Build.VERSION.SDK_INT <= 10) || (j == 0)) {
        break;
      }
      paramIntent = BaseApplicationImpl.getApplication().getSharedPreferences("web_process_preload_file", 4);
      i = paramIntent.getInt("aio_hit_count", 0);
      paramIntent.edit().putInt("aio_hit_count", i + 1).commit();
      return;
      gH.clear();
      break label62;
      label437:
      c.clear();
      break label89;
      label446:
      j = 0;
      break label105;
      label451:
      str = "2";
      break label193;
      label458:
      str = "2";
      break label249;
      label465:
      if ((arbz.aeo) || (bNB > 1)) {
        i = 2;
      } else {
        i = 3;
      }
    }
  }
  
  public static void ck(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
      } while ((state != 1) || (!paramIntent.getBooleanExtra("aio_open_web", false)));
      a(paramIntent, "wb_c", null);
      a(paramIntent, "web_finish", null);
    } while (state != 1);
    state = 2;
    gH.put("open_finished", "1");
  }
  
  public static void cl(Intent paramIntent)
  {
    if (paramIntent == null) {}
    String str;
    do
    {
      do
      {
        return;
      } while ((!paramIntent.getBooleanExtra("aio_open_web", false)) || (gH == null));
      str = (String)gH.get("open_finished");
    } while ((str == null) || (!str.equals("2")));
    a(paramIntent, "web_finish", null);
  }
  
  public static void cm(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
      } while (!paramIntent.getBooleanExtra("aio_open_web", false));
      paramIntent.removeExtra("aio_open_web");
    } while ((gH == null) || (TextUtils.isEmpty((CharSequence)gH.get("from"))));
    String str = (String)gH.get("safe_check");
    paramIntent = (String)gH.get("short_link");
    try
    {
      l1 = Long.parseLong(str);
    }
    catch (Exception localException)
    {
      try
      {
        for (;;)
        {
          l2 = Long.parseLong(paramIntent);
          if (l1 != 0L) {
            break;
          }
          gH.put("has_safecheck", "2");
          if (l2 != 0L) {
            break label250;
          }
          gH.put("has_short_link", "2");
          anpc.a(BaseApplication.getContext()).collectPerformance(null, "AIOWeb", false, 0L, 0L, gH, "", false);
          state = -1;
          if (Build.VERSION.SDK_INT > 10)
          {
            paramIntent = BaseApplicationImpl.getApplication().getSharedPreferences("web_process_preload_file", 4);
            l1 = paramIntent.getLong("aio_preload_qweb_last", 0L);
            l2 = System.currentTimeMillis();
            if (l1 != 0L) {
              break label265;
            }
            paramIntent.edit().putLong("aio_preload_qweb_last", l2).commit();
          }
          gH.clear();
          c.clear();
          return;
          localException = localException;
          l1 = 0L;
        }
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          long l1;
          long l2 = 0L;
          continue;
          gH.put("has_safecheck", "1");
          continue;
          label250:
          gH.put("has_short_link", "1");
          continue;
          label265:
          if (l2 - l1 > 86400000L)
          {
            int i = paramIntent.getInt("aio_preload_qweb_cout", 0);
            int j = paramIntent.getInt("aio_hit_count", 0);
            HashMap localHashMap = new HashMap();
            localHashMap.put("hit_count", j + "");
            localHashMap.put("preload_count", i + "");
            anpc.a(BaseApplication.getContext()).collectPerformance(null, "AIOWebPreloadhit", false, 0L, 0L, localHashMap, "", false);
            paramIntent.edit().putInt("aio_preload_qweb_cout", 0).putLong("aio_preload_qweb_last", l2).putInt("aio_hit_count", 0).commit();
          }
        }
      }
    }
  }
  
  private static void k(Intent paramIntent, String paramString)
  {
    if ((paramIntent == null) || (paramString == null)) {}
    while ((!paramString.contains(URLEncoder.encode("/cgi-bin/httpconn?htcmd=0x6ff0080"))) && (!paramString.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
      return;
    }
    aSk = paramString;
    a(paramIntent, null, "safe_check");
  }
  
  private static void l(Intent paramIntent, String paramString)
  {
    if ((paramIntent == null) || (paramString == null)) {
      return;
    }
    if ((aSk != null) && (aSk.contains(URLEncoder.encode(paramString)))) {
      a(paramIntent, "safe_check", null);
    }
    aSk = "";
  }
  
  private static void m(Intent paramIntent, String paramString)
  {
    if (paramString == null) {}
    while (!wgv.hy(paramString)) {
      return;
    }
    a(paramIntent, null, "short_link");
  }
  
  private static void n(Intent paramIntent, String paramString)
  {
    if (paramString == null) {}
    while ((!paramString.startsWith("http:")) && (!paramString.startsWith("https:"))) {
      return;
    }
    a(paramIntent, "short_link", null);
  }
  
  public static void o(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {}
    while ((state != 1) || (!paramIntent.getBooleanExtra("aio_open_web", false)) || ((!paramString.startsWith("http:")) && (!paramString.startsWith("https:")))) {
      return;
    }
    a(paramIntent, "activity_to_webview", null);
    k(paramIntent, paramString);
    m(paramIntent, paramString);
    a(paramIntent, null, "wb_c");
  }
  
  public static void p(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {}
    while ((state != 1) || (!paramIntent.getBooleanExtra("aio_open_web", false))) {
      return;
    }
    l(paramIntent, paramString);
    n(paramIntent, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wis
 * JD-Core Version:    0.7.0.1
 */