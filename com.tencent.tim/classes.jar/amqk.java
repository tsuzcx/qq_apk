import android.view.View;
import com.tencent.TMG.utils.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class amqk
  extends amqg
{
  public static final String TAG = amqk.class.getSimpleName();
  protected final String ITEM_LIST = "itemList";
  public CharSequence au;
  protected final String cbM = "showType";
  protected final String cbN = "moreText";
  protected final String cbO = "moreUrl";
  public int dDy;
  public String moreUrl;
  public int showType;
  public ArrayList<amql> zA;
  
  public amqk(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public amqk(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public void PS(String paramString)
  {
    for (;;)
    {
      int i;
      JSONObject localJSONObject;
      int j;
      try
      {
        paramString = new JSONObject(paramString);
        this.showType = paramString.optInt("showType");
        this.au = paramString.optString("moreText");
        this.moreUrl = paramString.optString("moreUrl");
        JSONArray localJSONArray = paramString.optJSONArray("itemList");
        if (this.zA == null)
        {
          this.zA = new ArrayList();
          break label273;
          if (i < localJSONArray.length())
          {
            localJSONObject = localJSONArray.optJSONObject(i);
            paramString = null;
            j = localJSONObject.optInt("type");
          }
        }
        else
        {
          switch (j)
          {
          case 1: 
            if (paramString == null) {
              break label281;
            }
            this.zA.add(paramString);
            break label281;
            this.zA.clear();
          }
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 0, "layout 13 parse layout error :" + paramString.toString());
        }
      }
      return;
      if ((T() instanceof DynamicSearch.ResultItem))
      {
        paramString = new amqn(this.keyword, this.ajO, this.FZ, this.from, localJSONObject, j, (DynamicSearch.ResultItem)T());
      }
      else if ((T() instanceof UnifySearchCommon.ResultItem))
      {
        paramString = new amqn(this.keyword, this.ajO, this.FZ, this.from, localJSONObject, j, (UnifySearchCommon.ResultItem)T());
        continue;
        label273:
        i = 0;
        continue;
        continue;
        label281:
        i += 1;
      }
    }
  }
  
  public void cR(View paramView) {}
  
  public int pE()
  {
    return 2;
  }
  
  public int pF()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amqk
 * JD-Core Version:    0.7.0.1
 */