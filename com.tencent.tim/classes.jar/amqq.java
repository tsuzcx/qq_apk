import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;

public class amqq
  extends amqg
{
  public static final String TAG = amqp.class.getSimpleName();
  public List<amqz> Ge;
  public boolean cEa;
  public String cbR;
  public String cbc;
  public String jumpUrl;
  public String summary;
  public String title;
  
  public amqq(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  private List<amqz> h(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        Object localObject = paramJSONArray.optJSONObject(i);
        localObject = new amqz(((JSONObject)localObject).optString("word"), ((JSONObject)localObject).optString("url"));
        if (((amqz)localObject).isValid()) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public void PS(String paramString)
  {
    this.cDT = false;
    try
    {
      paramString = new JSONObject(paramString);
      this.cbc = paramString.optString("leftIconUrl");
      this.title = paramString.optString("title");
      this.summary = paramString.optString("summary");
      this.cEa = paramString.optBoolean("isShowArrow");
      this.jumpUrl = paramString.optString("jumpUrl");
      this.cbR = paramString.optString("subItemLeftIconUrl");
      paramString = paramString.optJSONArray("itemList");
      if (paramString != null) {
        this.Ge = h(paramString);
      }
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(TAG, 2, QLog.getStackTraceString(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amqq
 * JD-Core Version:    0.7.0.1
 */