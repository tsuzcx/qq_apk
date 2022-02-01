import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aels
{
  private aels.a a;
  private String mContent;
  
  public aels()
  {
    this.mContent = "";
    this.a = new aels.a();
  }
  
  public aels(String paramString, aels.a parama)
  {
    this.mContent = paramString;
    this.a = parama;
  }
  
  public aels.a a()
  {
    return this.a;
  }
  
  public String getContent()
  {
    return this.mContent;
  }
  
  public static class a
    implements aehx<String>
  {
    public boolean enable;
    
    public void lR(String paramString)
    {
      boolean bool = false;
      if (TextUtils.isEmpty(paramString)) {
        QLog.e("OpenSdkSwitchConfig", 1, "OpenVirtual.config content is empty");
      }
      for (;;)
      {
        return;
        QLog.i("OpenSdkSwitchConfig", 1, "OpenVirtual.switch.config.parse=" + paramString);
        try
        {
          if (new JSONObject(paramString).optInt("enable", 0) == 1) {
            bool = true;
          }
          this.enable = bool;
          if (QLog.isColorLevel())
          {
            QLog.e("OpenSdkSwitchConfig", 2, new Object[] { "OpenVirtual.switch.config.parse=", toString() });
            return;
          }
        }
        catch (JSONException paramString)
        {
          QLog.e("OpenSdkSwitchConfig", 1, "OpenVirtual.config.getException.", paramString);
        }
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("OpenSdkSwitchConfig={");
      localStringBuilder.append("enable:").append(this.enable);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aels
 * JD-Core Version:    0.7.0.1
 */