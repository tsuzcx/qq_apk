import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.ReadInJoyMMapKvStorage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class lik
{
  public List<String> eS = new ArrayList();
  public String id = "";
  public List<String> jdField_if = new ArrayList();
  public String key;
  public String name;
  public String value = "";
  
  public static lik a(JSONObject paramJSONObject)
  {
    int j = 0;
    lik locallik = new lik();
    if (paramJSONObject != null)
    {
      locallik.key = paramJSONObject.optString("key");
      locallik.name = paramJSONObject.optString("name");
      locallik.value = paramJSONObject.optString("value");
      locallik.id = paramJSONObject.optString("id");
      Object localObject = paramJSONObject.optJSONArray("valuelist");
      int i;
      if (localObject != null)
      {
        locallik.jdField_if = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          String str = ((JSONArray)localObject).optString(i);
          locallik.jdField_if.add(str);
          i += 1;
        }
      }
      paramJSONObject = paramJSONObject.optJSONArray("idlist");
      if (paramJSONObject != null)
      {
        locallik.eS = new ArrayList();
        i = j;
        while (i < paramJSONObject.length())
        {
          localObject = paramJSONObject.optString(i);
          locallik.eS.add(localObject);
          i += 1;
        }
      }
    }
    return locallik;
  }
  
  private static void a(JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    if (paramJSONArray1 != null)
    {
      int i = 0;
      for (;;)
      {
        if (i < paramJSONArray1.length())
        {
          JSONObject localJSONObject = paramJSONArray1.optJSONObject(i);
          String str1 = localJSONObject.optString("key");
          String str2 = localJSONObject.optString("id");
          if (!TextUtils.isEmpty(str2)) {
            localJSONObject = new JSONObject();
          }
          try
          {
            localJSONObject.put(str1, str2);
            paramJSONArray2.put(localJSONObject);
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
    }
  }
  
  public static String bo(int paramInt)
  {
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray();
        if (awit.ds(paramInt))
        {
          if (-1 == paramInt) {
            break label195;
          }
          localObject1 = (String)awit.f("DAILY_CHILD_FEEDS_REQUEST_CONFIG" + paramInt, "");
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("daily_sub_channel_request_data", localObject1);
            localJSONArray.put(localObject3);
          }
          if (awit.aMW()) {
            localJSONArray.put(awit.ak());
          }
          return localJSONArray.toString();
        }
        Object localObject1 = ReadInJoyMMapKvStorage.getInstance().getValeForKey("KANDIAN_DAILY_SETTING_CONFIG");
        Object localObject3 = (String)awit.f("KANDIAN_DAILY_LCAOL_SETTING_CONFIG", "");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label190;
        }
        localObject1 = new JSONArray((String)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject3 = new JSONArray((String)localObject3);
          a((JSONArray)localObject1, localJSONArray);
          a((JSONArray)localObject3, localJSONArray);
          if (!kys.Bl()) {
            continue;
          }
          localJSONArray.put(lht.a(true));
          continue;
        }
        localObject3 = null;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return "";
      }
      continue;
      label190:
      Object localObject2 = null;
      continue;
      label195:
      localObject2 = null;
    }
  }
  
  public static String ju()
  {
    return bo(-1);
  }
  
  public JSONObject toJSONObject()
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator;
    try
    {
      localJSONObject.put("key", this.key);
      localJSONObject.put("name", this.name);
      localJSONObject.put("id", this.id);
      localJSONObject.put("value", this.value);
      JSONArray localJSONArray1 = new JSONArray();
      if (this.jdField_if != null)
      {
        localIterator = this.jdField_if.iterator();
        while (localIterator.hasNext()) {
          localJSONArray1.put((String)localIterator.next());
        }
      }
      localJSONObject.put("valuelist", localJSONException);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return localJSONObject;
    }
    JSONArray localJSONArray2 = new JSONArray();
    if (this.eS != null)
    {
      localIterator = this.eS.iterator();
      while (localIterator.hasNext()) {
        localJSONArray2.put((String)localIterator.next());
      }
    }
    localJSONObject.put("idlist", localJSONArray2);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lik
 * JD-Core Version:    0.7.0.1
 */