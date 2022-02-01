import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.b;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import org.json.JSONObject;

public class aaft
  extends Observable
{
  private static aaft.c jdField_a_of_type_Aaft$c;
  private static volatile aaft jdField_a_of_type_Aaft;
  private List<String> vj = new ArrayList();
  
  public static aaft a()
  {
    if (jdField_a_of_type_Aaft == null) {}
    try
    {
      if (jdField_a_of_type_Aaft == null) {
        jdField_a_of_type_Aaft = new aaft();
      }
      return jdField_a_of_type_Aaft;
    }
    finally {}
  }
  
  private void callbackMuteStatus(String paramString)
  {
    try
    {
      if (((AudioManager)BaseApplicationImpl.getApplication().getApplicationContext().getSystemService("audio")).getRingerMode() != 2) {}
      for (boolean bool = true;; bool = false)
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("is_muted", bool);
        if (QLog.isColorLevel()) {
          QLog.i("ArkPubicEventWrap", 2, "ad_query_mute: " + localJSONObject1.toString());
        }
        ark.arkNotify(paramString, "ad_query_mute_callback", localJSONObject1.toString(), "json");
        return;
      }
      JSONObject localJSONObject2;
      return;
    }
    catch (Throwable localThrowable)
    {
      try
      {
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("is_muted", false);
        ark.arkNotify(paramString, "ad_query_mute_callback", localJSONObject2.toString(), "json");
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private void cub()
  {
    for (;;)
    {
      try
      {
        Iterator localIterator;
        if (((AudioManager)BaseApplicationImpl.getApplication().getApplicationContext().getSystemService("audio")).getRingerMode() != 2)
        {
          bool = true;
          JSONObject localJSONObject1 = new JSONObject();
          localJSONObject1.put("is_muted", bool);
          if (QLog.isColorLevel()) {
            QLog.i("ArkPubicEventWrap", 2, "ad_query_mute: " + localJSONObject1.toString());
          }
          localIterator = this.vj.iterator();
          if (localIterator.hasNext())
          {
            ark.arkNotify((String)localIterator.next(), "ad_query_mute_callback", localJSONObject1.toString(), "json");
            continue;
          }
        }
        JSONObject localJSONObject2;
        boolean bool = false;
      }
      catch (Throwable localThrowable)
      {
        try
        {
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("is_muted", false);
          localIterator = this.vj.iterator();
          if (localIterator.hasNext()) {
            ark.arkNotify((String)localIterator.next(), "ad_query_mute_callback", localJSONObject2.toString(), "json");
          } else {
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void Ai(String paramString)
  {
    ArkAppNotifyCenter.setNotify(paramString, new WeakReference(new aaft.b()));
  }
  
  public void Aj(String paramString)
  {
    ArkAppNotifyCenter.setNotify(paramString, null);
  }
  
  public void D(String... paramVarArgs)
  {
    if (paramVarArgs.length > 0)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        String str = paramVarArgs[i];
        this.vj.remove(str);
        i += 1;
      }
    }
    if (jdField_a_of_type_Aaft$c != null)
    {
      BaseApplicationImpl.getApplication().getBaseContext().unregisterReceiver(jdField_a_of_type_Aaft$c);
      jdField_a_of_type_Aaft$c = null;
    }
  }
  
  public void hE(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.vj.addAll(paramList);
      if (jdField_a_of_type_Aaft$c == null) {
        jdField_a_of_type_Aaft$c = new aaft.c(null);
      }
      paramList = new IntentFilter();
      paramList.addAction("android.media.VOLUME_CHANGED_ACTION");
      paramList.addAction("android.intent.action.HEADSET_PLUG");
      paramList.addAction("android.media.AUDIO_BECOMING_NOISY");
      paramList.addAction("android.media.RINGER_MODE_CHANGED");
      BaseApplicationImpl.getApplication().getBaseContext().registerReceiver(jdField_a_of_type_Aaft$c, paramList);
    }
  }
  
  public void hF(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.vj.removeAll(paramList);
      if (jdField_a_of_type_Aaft$c != null)
      {
        BaseApplicationImpl.getApplication().getBaseContext().unregisterReceiver(jdField_a_of_type_Aaft$c);
        jdField_a_of_type_Aaft$c = null;
      }
    }
  }
  
  public class a
  {
    public String appName;
    public String eventName;
    public String param;
    
    public a(String paramString1, String paramString2, String paramString3)
    {
      this.appName = paramString1;
      this.eventName = paramString2;
      this.param = paramString3;
    }
  }
  
  public class b
    implements ArkAppNotifyCenter.b
  {
    public b() {}
    
    public boolean notify(String paramString1, String paramString2, String paramString3)
    {
      if ("ad_query_mute".equals(paramString2)) {
        aaft.a(aaft.this, paramString1);
      }
      do
      {
        do
        {
          return true;
          if (!"event_query_package".equals(paramString2)) {
            break;
          }
        } while (TextUtils.isEmpty(paramString3));
        for (;;)
        {
          try
          {
            paramString2 = new JSONObject(paramString3).optString("packageName");
            paramString2 = aqiz.O(BaseApplicationImpl.getContext(), paramString2);
            paramString3 = new JSONObject();
            if ("0".equals(paramString2))
            {
              paramString3.put("errCode", 0);
              paramString3.put("isInstall", false);
              ark.arkNotify(paramString1, "event_query_package_callback", paramString3.toString(), "json");
              return true;
            }
          }
          catch (Throwable paramString2)
          {
            paramString2.printStackTrace();
            ark.arkNotify(paramString1, "event_query_package_callback", "", "json");
            return true;
          }
          paramString3.put("errCode", 0);
          paramString3.put("isInstall", true);
          paramString3.put("version", paramString2);
        }
        if (!"event_fullscreen_play".equals(paramString2)) {
          break;
        }
      } while (TextUtils.isEmpty(paramString3));
      try
      {
        paramString1 = new JSONObject(paramString3);
        paramString1.optString("videoUrl");
        paramString1.optString("playRate");
        paramString1.optString("totalRate");
        return true;
      }
      catch (Throwable paramString1)
      {
        paramString1.printStackTrace();
        return true;
      }
      aaft.this.notifyObservers(new aaft.a(aaft.this, paramString1, paramString2, paramString3));
      return true;
    }
  }
  
  static class c
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ArkPubicEventWrap", 2, "--VolumeReceiver---" + paramIntent.getAction());
      }
      aaft.a(aaft.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaft
 * JD-Core Version:    0.7.0.1
 */