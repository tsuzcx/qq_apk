import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class amqp
  extends amqg
{
  public static final String TAG = amqp.class.getSimpleName();
  public List<amqd> Ge;
  public String cbQ;
  public String cbc;
  public String jumpUrl;
  public String summary;
  public String title;
  
  public amqp(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public amqp(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public void PS(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.cbc = paramString.optString("leftIconUrl");
      this.title = paramString.optString("title");
      this.summary = paramString.optString("summary");
      this.cbQ = paramString.optString("rightIconUrl");
      this.jumpUrl = paramString.optString("jumpUrl");
      paramString = paramString.optJSONArray("pageInfo");
      if (paramString != null)
      {
        this.Ge = new ArrayList(paramString.length());
        int i = 0;
        while (i < paramString.length())
        {
          Object localObject = paramString.optJSONObject(i);
          localObject = new amqd(((JSONObject)localObject).optString("leftIconUrl"), ((JSONObject)localObject).optString("wording"));
          this.Ge.add(localObject);
          i += 1;
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, QLog.getStackTraceString(paramString));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amqp
 * JD-Core Version:    0.7.0.1
 */