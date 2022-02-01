import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aelq
{
  private aelq.a a;
  private String mContent;
  
  public aelq()
  {
    this.mContent = "";
    this.a = new aelq.a();
  }
  
  public aelq(String paramString, aelq.a parama)
  {
    this.mContent = paramString;
    this.a = parama;
  }
  
  public aelq.a a()
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
    public ArrayList<aelq.b> list = new ArrayList();
    
    public void lR(String paramString)
    {
      this.list.clear();
      if (TextUtils.isEmpty(paramString))
      {
        QLog.e("OpenSdkRandomConfig", 1, "OpenVirtual.config content is empty");
        return;
      }
      for (;;)
      {
        int i;
        try
        {
          paramString = new JSONObject(paramString).optJSONArray("random_list");
          if (paramString != null)
          {
            i = 0;
            if (i < paramString.length())
            {
              JSONObject localJSONObject = paramString.getJSONObject(i);
              aelq.b localb = new aelq.b();
              localb.nickName = localJSONObject.optString("nick", "");
              localb.bzw = localJSONObject.optString("headid", "");
              localb.bzx = localJSONObject.optString("url", "");
              if ((!TextUtils.isEmpty(localb.nickName)) && (!TextUtils.isEmpty(localb.bzw)) && (!TextUtils.isEmpty(localb.bzx))) {
                break label230;
              }
              if (!QLog.isColorLevel()) {
                break label235;
              }
              QLog.e("OpenSdkRandomConfig", 2, new Object[] { "OpenVirtual.random.config.parse.find invalid,index=", Integer.valueOf(i) });
              break label235;
              if (j == 0) {
                break label240;
              }
              this.list.add(localb);
              break label240;
            }
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("OpenSdkRandomConfig", 2, new Object[] { "OpenVirtual.random.config.parse=", toString() });
          return;
        }
        catch (JSONException paramString)
        {
          QLog.e("OpenSdkRandomConfig", 1, "OpenVirtual.config.getException.", paramString);
          return;
        }
        label230:
        int j = 1;
        continue;
        label235:
        j = 0;
        continue;
        label240:
        i += 1;
      }
    }
    
    public String toString()
    {
      if (this.list.size() > 0) {
        return this.list.toString();
      }
      return "";
    }
  }
  
  public static class b
  {
    public String bzw;
    public String bzx;
    public String nickName;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("{");
      localStringBuilder.append("nickName:").append(this.nickName).append(",headID:").append(this.bzw).append(",headURL:").append(this.bzx).append("}");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aelq
 * JD-Core Version:    0.7.0.1
 */