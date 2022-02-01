import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class amqj
  extends amqg
{
  public List<String> Gd;
  public boolean cDV;
  public boolean cDW;
  public double cS;
  public double cT;
  public String cbH;
  public String cbI;
  public String cbJ;
  public String cbK;
  public String cbL;
  public CharSequence description;
  public String iconUrl;
  public List<ampz> imageList;
  public int imageType;
  public CharSequence summary;
  public CharSequence title;
  public int totalCount;
  
  public amqj(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public amqj(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public void PS(String paramString)
  {
    boolean bool2 = true;
    int j = 0;
    for (;;)
    {
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
        int i;
        Object localObject;
        if (localJSONArray != null)
        {
          this.imageList = new ArrayList(localJSONArray.length());
          i = 0;
          if (i < localJSONArray.length())
          {
            localObject = localJSONArray.optJSONObject(i);
            localObject = new ampz(((JSONObject)localObject).optString("url"), ((JSONObject)localObject).optInt("type"));
            this.imageList.add(localObject);
            i += 1;
            continue;
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
            break label394;
          }
          bool1 = bool2;
          this.cDW = bool1;
          localJSONArray = paramString.optJSONArray("dynamicLineImageList");
          if (localJSONArray != null)
          {
            this.Gd = new ArrayList(localJSONArray.length());
            i = j;
            if (i < localJSONArray.length())
            {
              localObject = localJSONArray.optJSONObject(i).optString("url");
              this.Gd.add(localObject);
              i += 1;
              continue;
            }
          }
          this.cbH = paramString.optString("dynamicLineLeftText");
          this.cbI = paramString.optString("dynamicLineZanIconUrl");
          this.cbJ = paramString.optString("dynamicLineZanText");
          this.cbK = paramString.optString("dynamicLineCommentIconUrl");
          this.cbL = paramString.optString("dynamicLineCommentText");
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      boolean bool1 = false;
      continue;
      label394:
      bool1 = false;
    }
  }
  
  public boolean isDataValid()
  {
    return super.isDataValid();
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
 * Qualified Name:     amqj
 * JD-Core Version:    0.7.0.1
 */