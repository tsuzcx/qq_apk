import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class amqe
  extends amqg
{
  public ampz a;
  public String cby;
  public int dDw;
  public List<ampz> imageList;
  public CharSequence title;
  public int totalCount;
  
  public amqe(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public amqe(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public void PS(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.title = amxk.g(paramString.optString("firstLineText"));
      this.cby = paramString.optString("firstLineTextPostfix");
      Object localObject1 = paramString.optJSONObject("leftImage");
      if (localObject1 != null) {
        this.a = new ampz(((JSONObject)localObject1).optString("url"), ((JSONObject)localObject1).optInt("type"));
      }
      this.dDw = paramString.optInt("allHeight");
      localObject1 = paramString.optJSONArray("imageList");
      if (localObject1 != null)
      {
        this.imageList = new ArrayList(((JSONArray)localObject1).length());
        int i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
          localObject2 = new ampz(((JSONObject)localObject2).optString("url"), ((JSONObject)localObject2).optInt("type"));
          this.imageList.add(localObject2);
          i += 1;
        }
      }
      this.totalCount = paramString.optInt("imageTotalCount");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean isDataValid()
  {
    boolean bool = true;
    if ((this.imageList == null) || (this.imageList.size() == 0)) {
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amqe
 * JD-Core Version:    0.7.0.1
 */