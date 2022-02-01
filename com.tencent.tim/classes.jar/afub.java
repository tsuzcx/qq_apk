import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class afub
{
  public int cUs;
  public int tagId;
  public String tagName = "";
  
  public afub() {}
  
  public afub(int paramInt1, String paramString, int paramInt2)
  {
    this.tagId = paramInt1;
    this.tagName = paramString;
    this.cUs = paramInt2;
  }
  
  public static String r(ArrayList<afub> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    for (;;)
    {
      if (i < paramArrayList.size())
      {
        afub localafub = (afub)paramArrayList.get(i);
        JSONObject localJSONObject;
        if (localafub != null) {
          localJSONObject = new JSONObject();
        }
        try
        {
          localJSONObject.put("tagId", localafub.tagId);
          localJSONObject.put("tagName", localafub.tagName);
          localJSONObject.put("isHotTag", localafub.cUs);
          localJSONArray.put(localJSONObject);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("TagInfo CLASS", 2, "convertToJson error" + localException.toString());
          }
        }
      }
    }
    return localJSONArray.toString();
  }
  
  public boolean akn()
  {
    return this.cUs == 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{tagId: ").append(this.tagId).append("}");
    localStringBuilder.append("{tagName: ").append(this.tagName).append("}");
    localStringBuilder.append("{isHotTag: ").append(this.cUs).append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afub
 * JD-Core Version:    0.7.0.1
 */