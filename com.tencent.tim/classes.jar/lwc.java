import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class lwc
{
  public static void bD(String paramString1, String paramString2)
  {
    f("0X800A833", "", "", "", new lwc.a().a("type", paramString2).a("msg", paramString1).build());
  }
  
  public static void bE(String paramString1, String paramString2)
  {
    f("0X800A832", "", "", "", new lwc.a().a("type", paramString2).a("msg", paramString1).build());
  }
  
  public static void f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    QLog.i("PTSReport", 1, "[reportData], actionName = " + paramString1 + ", r2 = " + paramString2 + ", r3 = " + paramString3 + ", r4 = " + paramString4 + ", r5 = " + paramString5);
    kbp.a(null, "", paramString1, paramString1, 0, 0, paramString2, paramString3, paramString4, paramString5, false);
  }
  
  public static class a
  {
    private JSONObject json;
    
    public a()
    {
      this.json = new JSONObject();
      aNM();
    }
    
    public a(String paramString)
    {
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          this.json = new JSONObject(paramString);
          aNM();
          return;
        }
        catch (JSONException paramString)
        {
          QLog.e("PTSReport", 1, "e = " + paramString);
          this.json = new JSONObject();
          aNM();
          return;
        }
      }
      this.json = new JSONObject();
      aNM();
    }
    
    private void aNM()
    {
      for (;;)
      {
        try
        {
          this.json.put("os", "1");
          this.json.put("version", "3.4.4");
          this.json.put("pts_engine_version", lvg.a().jz());
          this.json.put("pts_app_version", lve.a().jy());
          this.json.put("sdk_version", String.valueOf(Build.VERSION.SDK_INT));
          JSONObject localJSONObject = this.json;
          if (!TextUtils.isEmpty(Build.BRAND))
          {
            String str1 = Build.BRAND;
            localJSONObject.put("device_brand", str1);
            localJSONObject = this.json;
            if (!TextUtils.isEmpty(Build.MODEL))
            {
              str1 = Build.MODEL;
              localJSONObject.put("device_model", str1);
              this.json.put("is_debug", "0");
              return;
            }
            str1 = "";
            continue;
          }
          String str2 = "";
        }
        catch (JSONException localJSONException)
        {
          QLog.e("PTSReport", 1, "[initCommonField], e = " + localJSONException);
          return;
        }
      }
    }
    
    public a a(String paramString1, String paramString2)
    {
      try
      {
        this.json.put(paramString1, paramString2);
        return this;
      }
      catch (JSONException paramString1)
      {
        QLog.e("PTSReport", 1, "[addString], e = " + paramString1);
      }
      return this;
    }
    
    public String build()
    {
      return this.json.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lwc
 * JD-Core Version:    0.7.0.1
 */