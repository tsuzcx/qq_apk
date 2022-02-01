import com.tencent.TMG.utils.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class amqu
  extends amqg
{
  public static final String TAG = amqu.class.getSimpleName();
  public String cbV;
  public String cbW;
  public String cbc;
  public String jumpUrl;
  public String moreText;
  
  public amqu(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public amqu(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public void PS(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.cbc = paramString.optString("leftIcon");
      this.cbV = paramString.optString("firstTitle");
      this.cbW = paramString.optString("secondTitle");
      this.moreText = paramString.optString("moreText");
      this.jumpUrl = paramString.optString("jumpUrl");
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(TAG, 0, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amqu
 * JD-Core Version:    0.7.0.1
 */