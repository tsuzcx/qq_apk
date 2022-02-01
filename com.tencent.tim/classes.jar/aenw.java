import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aenw
{
  private aenw.a[] a = new aenw.a[0];
  
  public static aenw a(String paramString)
  {
    int i = 0;
    aenw localaenw = new aenw();
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("SingTogetherConfigBean", 0, "parse content is empty");
      }
    }
    for (;;)
    {
      return localaenw;
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("array");
        if ((paramString != null) && (paramString.length() > 0))
        {
          localaenw.a = new aenw.a[paramString.length()];
          while (i < paramString.length())
          {
            aenw.a locala = aenw.a.a(paramString.getJSONObject(i));
            localaenw.a[i] = locala;
            i += 1;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("SingTogetherConfigBean", 0, "parse config=" + localaenw);
            return localaenw;
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return localaenw;
  }
  
  public aenw.a a(int paramInt)
  {
    Object localObject;
    if ((this.a == null) || (this.a.length <= 0))
    {
      localObject = null;
      return localObject;
    }
    aenw.a[] arrayOfa = this.a;
    int j = arrayOfa.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label64;
      }
      aenw.a locala = arrayOfa[i];
      localObject = locala;
      if (locala.serviceType == paramInt) {
        break;
      }
      i += 1;
    }
    label64:
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString()).append(" ");
    if ((this.a != null) && (this.a.length > 0))
    {
      aenw.a[] arrayOfa = this.a;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfa[i]).append(" ");
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    public int appId = -1;
    public boolean bVh;
    public boolean bVi;
    public int jumpType;
    public String jumpUrl = "";
    public int serviceType;
    public int version = 1;
    
    public static a a(JSONObject paramJSONObject)
    {
      a locala = new a();
      locala.bVh = paramJSONObject.optBoolean("show_c2c_chat_setting", false);
      locala.bVi = paramJSONObject.optBoolean("show_group_chat_setting", false);
      locala.serviceType = paramJSONObject.optInt("service_type", -1);
      locala.jumpType = paramJSONObject.optInt("jumpType", -1);
      locala.version = paramJSONObject.optInt("version", -1);
      locala.appId = paramJSONObject.optInt("appid", -1);
      locala.jumpUrl = paramJSONObject.optString("jumpUrl", "");
      return locala;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showC2CChatSetting=").append(this.bVh).append(" showGroupChatSetting=").append(this.bVi).append(" serviceType=").append(this.serviceType).append(" jumpType=").append(this.jumpType).append(" version=").append(this.version).append(" appId=").append(this.appId).append(" jumpUrl=").append(this.jumpUrl);
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aenw
 * JD-Core Version:    0.7.0.1
 */