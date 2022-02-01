import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class amqr
  extends amqg
{
  public static final String TAG = amqr.class.getSimpleName();
  public List<amoe> Gf;
  public String cbS;
  public String cbT;
  public String cbU;
  
  public amqr(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public amqr(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public void PS(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.cbS = paramString.optString("askIcon");
      this.cbT = paramString.optString("headLine");
      this.cbU = paramString.optString("answerNumText");
      paramString = paramString.optJSONArray("answers");
      if (paramString != null)
      {
        this.Gf = new ArrayList(paramString.length());
        int i = 0;
        while (i < paramString.length())
        {
          Object localObject2 = paramString.optJSONObject(i);
          Object localObject1 = ((JSONObject)localObject2).optString("leftIcon");
          String str1 = ((JSONObject)localObject2).optString("userNameText");
          String str2 = ((JSONObject)localObject2).optString("praiseText");
          String str3 = ((JSONObject)localObject2).optString("answerText");
          int k = ((JSONObject)localObject2).optInt("imageTotalCount");
          localObject2 = ((JSONObject)localObject2).optJSONArray("imageList");
          ArrayList localArrayList = new ArrayList();
          if (localObject2 != null)
          {
            int j = 0;
            while (j < ((JSONArray)localObject2).length())
            {
              JSONObject localJSONObject = ((JSONArray)localObject2).optJSONObject(j);
              localArrayList.add(new ampz(localJSONObject.optString("url"), localJSONObject.optInt("type")));
              j += 1;
            }
          }
          localObject1 = new amoe((String)localObject1, str1, str2, str3, k, localArrayList);
          this.Gf.add(localObject1);
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
 * Qualified Name:     amqr
 * JD-Core Version:    0.7.0.1
 */