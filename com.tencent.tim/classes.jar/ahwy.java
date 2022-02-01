import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.haoliyou.orion.XorCipherException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class ahwy
{
  public final ahwy.a a = new ahwy.a();
  
  public static ahwy a()
  {
    return ahwy.b.b();
  }
  
  public boolean aoe()
  {
    return this.a.d.aop();
  }
  
  public boolean aof()
  {
    return this.a.c.aop();
  }
  
  public boolean aog()
  {
    return this.a.a.aop();
  }
  
  public boolean aoh()
  {
    return this.a.ciL;
  }
  
  public boolean aoi()
  {
    return this.a.ciM;
  }
  
  public boolean aoj()
  {
    return this.a.e.aop();
  }
  
  public boolean aok()
  {
    return this.a.g.aop();
  }
  
  public boolean aol()
  {
    return this.a.f.aop();
  }
  
  public boolean aom()
  {
    return this.a.h.aop();
  }
  
  public boolean aon()
  {
    return this.a.i.aop();
  }
  
  public boolean aoo()
  {
    return this.a.j.aop();
  }
  
  public String wK()
  {
    return this.a.bLV;
  }
  
  public String wL()
  {
    return this.a.bLW;
  }
  
  public static class a
  {
    ahxa a = ahxa.k;
    ahxa b = ahxa.k;
    String bLV = "";
    String bLW = "";
    ahxa c = ahxa.k;
    boolean ciL = false;
    boolean ciM = false;
    boolean ciN = false;
    private final Context context = BaseApplicationImpl.context;
    ahxa d = ahxa.k;
    ahxa e = ahxa.k;
    ahxa f = ahxa.k;
    ahxa g = ahxa.k;
    ahxa h = ahxa.k;
    ahxa i = ahxa.k;
    ahxa j = ahxa.k;
    
    a()
    {
      try
      {
        dqE();
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    
    private void Pv(int paramInt)
    {
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
      String str = "_" + getCurrentUin();
      localSharedPreferences.edit().putInt("KEY_WO_KAO_VERSION" + str, paramInt).apply();
    }
    
    private ahxa a(JSONObject paramJSONObject)
    {
      boolean bool = true;
      if (paramJSONObject == null) {
        return ahxa.k;
      }
      if (paramJSONObject.optInt("need_block") == 1) {}
      for (;;)
      {
        String str = paramJSONObject.optString("start_time");
        paramJSONObject = paramJSONObject.optString("end_time");
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        try
        {
          paramJSONObject = new ahxa(bool, localSimpleDateFormat.parse(str), localSimpleDateFormat.parse(paramJSONObject));
          return paramJSONObject;
        }
        catch (ParseException paramJSONObject)
        {
          paramJSONObject.printStackTrace();
          return ahxa.k;
        }
        catch (Throwable paramJSONObject)
        {
          for (;;)
          {
            paramJSONObject.printStackTrace();
          }
        }
        bool = false;
      }
    }
    
    private void dqD()
    {
      this.a = ahxa.k;
      this.b = ahxa.k;
      this.c = ahxa.k;
      this.d = ahxa.k;
      this.e = ahxa.k;
      this.f = ahxa.k;
      this.g = ahxa.k;
      this.h = ahxa.k;
      this.i = ahxa.k;
      this.j = ahxa.k;
      this.ciL = false;
      this.ciM = false;
      this.ciN = false;
      this.bLV = "";
      this.bLW = "";
    }
    
    private String getCurrentUin()
    {
      Object localObject = BaseApplicationImpl.getApplication();
      if (localObject == null) {
        localObject = "";
      }
      String str;
      do
      {
        return localObject;
        localObject = ((BaseApplicationImpl)localObject).getRuntime();
        if (localObject == null) {
          return "";
        }
        str = ((AppRuntime)localObject).getAccount();
        localObject = str;
      } while (str != null);
      return "";
    }
    
    public int Fq()
    {
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
      String str = "_" + getCurrentUin();
      return localSharedPreferences.getInt("KEY_WO_KAO_VERSION" + str, 0);
    }
    
    void KN(String paramString)
    {
      Object localObject = "";
      try
      {
        paramString = ahwx.encrypt(paramString);
        localObject = this.context.getSharedPreferences("SP_WO_KAO", 4);
        String str = "_" + getCurrentUin();
        ((SharedPreferences)localObject).edit().putString("KEY_WO_KAO_CONFIG" + str, paramString).apply();
        return;
      }
      catch (XorCipherException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = (String)localObject;
        }
      }
    }
    
    public void a(ConfigurationService.Config paramConfig)
    {
      int k = paramConfig.version.get();
      int m = Fq();
      Pv(k);
      if (m != k)
      {
        paramConfig = aevk.a(paramConfig, m, paramConfig.type.get());
        bj(paramConfig);
        KN(paramConfig);
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.i("Zhuoxu", 2, "handleConfig: invoked. save version, ignored. version: " + m);
    }
    
    void bj(String paramString)
    {
      boolean bool2 = true;
      if (TextUtils.isEmpty(paramString)) {
        dqD();
      }
      for (;;)
      {
        return;
        try
        {
          paramString = new JSONObject(paramString);
          this.a = a(paramString.optJSONObject("webview_menu"));
          this.b = a(paramString.optJSONObject("webview_launch_app"));
          this.c = a(paramString.optJSONObject("scan_qrcode"));
          this.d = a(paramString.optJSONObject("save_image"));
          this.e = a(paramString.optJSONObject("imageUpload_scan"));
          this.g = a(paramString.optJSONObject("assetInfo_upload"));
          this.f = a(paramString.optJSONObject("image_probe"));
          this.h = a(paramString.optJSONObject("send_fileqrcode_switch"));
          this.i = a(paramString.optJSONObject("file_exif_info"));
          this.j = a(paramString.optJSONObject("file_app_scan"));
          if (paramString.optInt("need_report_system_share_info_new") == 1)
          {
            bool1 = true;
            this.ciL = bool1;
            if (paramString.optInt("need_xxxxx_else_xxx_installed") != 1) {
              break label295;
            }
            bool1 = true;
            this.ciM = bool1;
            if (paramString.optInt("need_xxxxx_plugin_xxxxx") != 1) {
              break label300;
            }
            bool1 = bool2;
            this.ciN = bool1;
            this.bLV = paramString.optString("package1");
            this.bLW = paramString.optString("package2");
            paramString = paramString.optJSONObject("webview_launch_xxx_xxxxxyyyy");
            JefsClass.getInstance().b(this.b.aop(), paramString);
          }
        }
        catch (JSONException paramString)
        {
          boolean bool1;
          while (QLog.isColorLevel())
          {
            QLog.e("Zhuoxu", 2, "parseConfig: failed. ", paramString);
            return;
            bool1 = false;
            continue;
            label295:
            bool1 = false;
            continue;
            label300:
            bool1 = false;
          }
        }
        catch (Throwable paramString) {}
      }
    }
    
    void dqE()
    {
      long l = System.currentTimeMillis();
      Object localObject = this.context.getSharedPreferences("SP_WO_KAO", 4);
      String str = "_" + getCurrentUin();
      str = ((SharedPreferences)localObject).getString("KEY_WO_KAO_CONFIG" + str, "");
      localObject = "";
      try
      {
        str = ahwx.decrypt(str);
        localObject = str;
      }
      catch (XorCipherException localXorCipherException)
      {
        for (;;)
        {
          localXorCipherException.printStackTrace();
        }
      }
      bj((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("Zhuoxu", 2, "loadConfigFromSp: invoked.  cost ms: " + (System.currentTimeMillis() - l));
      }
    }
  }
  
  static class b
  {
    private static final ahwy a = new ahwy(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahwy
 * JD-Core Version:    0.7.0.1
 */