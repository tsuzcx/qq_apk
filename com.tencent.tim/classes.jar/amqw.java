import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class amqw
  extends amqg
{
  public boolean cDV;
  public boolean cDW;
  public double cS;
  public double cT;
  public CharSequence description;
  public String iconUrl;
  public List<ampz> imageList;
  public int imageType;
  public CharSequence summary;
  public CharSequence title;
  public int totalCount;
  
  public amqw(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public amqw(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public void PS(String paramString)
  {
    boolean bool2 = true;
    try
    {
      paramString = new JSONObject(paramString);
      this.imageUrl = paramString.optString("leftImageURL");
      this.imageType = paramString.optInt("leftImageType", 1);
      this.imageType = jg(this.imageType);
      this.title = amxk.g(paramString.optString("headText"));
      this.iconUrl = paramString.optString("headLineIconURL");
      this.summary = amxk.g(paramString.optString("descLineText"));
      this.description = amxk.g(paramString.optString("firstLineText"));
      JSONArray localJSONArray = paramString.optJSONArray("imageList");
      if (localJSONArray != null)
      {
        this.imageList = new ArrayList(localJSONArray.length());
        int i = 0;
        while (i < localJSONArray.length())
        {
          Object localObject = localJSONArray.optJSONObject(i);
          localObject = new ampz(((JSONObject)localObject).optString("url"), ((JSONObject)localObject).optInt("type"));
          this.imageList.add(localObject);
          i += 1;
        }
      }
      this.cS = paramString.optDouble("imageAspectRatio", 1.0D);
      this.cT = paramString.optDouble("singleImageScale", 1.0D);
      this.totalCount = paramString.optInt("imageTotalCount");
      if (paramString.optInt("topNeedHigherMargin", 0) == 1)
      {
        bool1 = true;
        this.cDV = bool1;
        if (paramString.optInt("needCornerRadius", 0) != 1) {
          break label259;
        }
      }
      label259:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.cDW = bool1;
        return;
        bool1 = false;
        break;
      }
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
 * Qualified Name:     amqw
 * JD-Core Version:    0.7.0.1
 */