import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class amqf
  extends amqg
{
  public static final String TAG = "Q.uniteSearch." + amqf.class.getSimpleName();
  public String cbz;
  public CharSequence description;
  public int imageType;
  public CharSequence summary;
  public CharSequence title;
  
  public amqf(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public amqf(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public void PS(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.imageUrl = paramString.optString("leftImageURL");
      this.imageType = paramString.optInt("leftImageType", 1);
      this.imageType = jg(this.imageType);
      this.cbz = amxk.g(paramString.optString("leftImageTagText"));
      this.title = amxk.g(paramString.optString("firstLineText"));
      this.summary = amxk.g(paramString.optString("secondLineText"));
      this.description = amxk.a(paramString.optJSONArray("thirdLineText"));
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public int jg(int paramInt)
  {
    int i = paramInt;
    switch (paramInt)
    {
    default: 
      i = 1;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amqf
 * JD-Core Version:    0.7.0.1
 */