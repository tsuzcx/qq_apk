import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aetb
{
  private aetb.a a;
  private String mContent;
  
  public aetb()
  {
    this.mContent = "";
    this.a = new aetb.a();
  }
  
  public aetb(String paramString, aetb.a parama)
  {
    this.mContent = paramString;
    this.a = parama;
  }
  
  public aetb.a a()
  {
    return this.a;
  }
  
  public boolean isEmpty()
  {
    return (this.a == null) || (this.a.jQ == null) || (this.a.jQ.size() <= 0);
  }
  
  public static class a
    implements aehx<String>
  {
    private String bAZ = "place_holder";
    private String bBa = "data";
    private String bBb = "topic_id";
    private String bBc = "topic_name";
    public ArrayList<aetb.b> jQ = new ArrayList();
    public String recommendTitle = "";
    
    public void lR(String paramString)
    {
      this.jQ.clear();
      if (TextUtils.isEmpty(paramString))
      {
        QLog.e("SigTopicConfig", 1, "SigTopic config content is empty");
        return;
      }
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramString);
          paramString = localJSONObject.optJSONArray(this.bBa);
          this.recommendTitle = localJSONObject.optString(this.bAZ, acfp.m(2131714592));
          if (paramString == null) {
            break;
          }
          i = 0;
          if (i >= paramString.length()) {
            break;
          }
          localJSONObject = paramString.getJSONObject(i);
          localb = new aetb.b();
          localb.topicId = localJSONObject.optInt(this.bBb);
          localb.topicName = localJSONObject.optString(this.bBc);
          if (!TextUtils.isEmpty(localb.topicName)) {
            break label193;
          }
          if (!QLog.isColorLevel()) {
            break label198;
          }
          QLog.e("SigTopicConfig", 2, new Object[] { "SigTopic config parse has invalid item,index=", Integer.valueOf(i) });
        }
        catch (JSONException paramString)
        {
          int i;
          aetb.b localb;
          QLog.e("SigTopicConfig", 1, "SigTopic config parse exception", paramString);
          return;
        }
        if (j != 0) {
          this.jQ.add(localb);
        }
        i += 1;
        continue;
        label193:
        int j = 1;
        continue;
        label198:
        j = 0;
      }
    }
    
    public String toString()
    {
      if (this.jQ.size() > 0) {
        return "recommend title is " + this.recommendTitle + ", " + this.jQ.toString();
      }
      return "";
    }
  }
  
  public static class b
  {
    public int topicId;
    public String topicName;
    
    @NotNull
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("{");
      localStringBuilder.append("topicId: ").append(this.topicId).append(",topicName: ").append(this.topicName).append("}");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aetb
 * JD-Core Version:    0.7.0.1
 */