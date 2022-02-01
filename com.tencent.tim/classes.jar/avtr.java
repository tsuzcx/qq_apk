import NS_QZONE_MQMSG.BottomContentItem;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class avtr
{
  public String content;
  public String url;
  
  public avtr() {}
  
  public avtr(String paramString1, String paramString2)
  {
    this.content = paramString1;
    this.url = paramString2;
  }
  
  public static avtr a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    avtr localavtr = new avtr();
    localavtr.content = paramJSONObject.optString("content");
    localavtr.url = paramJSONObject.optString("url");
    return localavtr;
  }
  
  public static ArrayList<avtr> ar(ArrayList<BottomContentItem> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      BottomContentItem localBottomContentItem = (BottomContentItem)paramArrayList.next();
      if (localBottomContentItem != null)
      {
        avtr localavtr = new avtr();
        localavtr.content = localBottomContentItem.content;
        localavtr.url = localBottomContentItem.url;
        localArrayList.add(localavtr);
      }
    }
    return localArrayList;
  }
  
  public JSONObject convertToJSON()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("content", this.content);
      localJSONObject.put("url", this.url);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QZLog.e("BottomItem", "convert json error", localJSONException);
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avtr
 * JD-Core Version:    0.7.0.1
 */