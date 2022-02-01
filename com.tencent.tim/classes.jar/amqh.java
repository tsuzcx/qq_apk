import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class amqh
  extends amqg
{
  public static final String TAG = "Q.uniteSearch." + amqh.class.getSimpleName();
  public CharSequence as;
  public CharSequence at;
  public String cbE;
  public String cbF;
  public String cbG;
  public int dDx;
  public float zt;
  public float zu;
  
  public amqh(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public amqh(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public void PS(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.dDx = paramString.optInt("bannerImageType");
      this.cbE = paramString.optString("bannerImageUrl");
      this.zt = ((float)paramString.optDouble("bannerImageWidth"));
      this.zu = ((float)paramString.optDouble("bannerImageHeight"));
      this.cbF = paramString.optString("topLeftTagText");
      this.cbG = paramString.optString("topLeftTagColor");
      this.as = paramString.optString("firstLineText");
      this.at = paramString.optString("secondLineText");
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(TAG, 2, QLog.getStackTraceString(paramString));
    }
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
 * Qualified Name:     amqh
 * JD-Core Version:    0.7.0.1
 */