import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class amqm
  extends amqg
{
  public static final String TAG = amqm.class.getSimpleName();
  protected final String ITEM_LIST = "itemList";
  public ArrayList<amql> zA;
  
  public amqm(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public amqm(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public void PS(String paramString)
  {
    JSONArray localJSONArray;
    try
    {
      localJSONArray = new JSONObject(paramString).getJSONArray("itemList");
      if (this.zA == null) {
        this.zA = new ArrayList();
      } else {
        this.zA.clear();
      }
    }
    catch (JSONException paramString)
    {
      if (!QLog.isColorLevel()) {
        break label281;
      }
    }
    QLog.e(TAG, 2, "parseLayoutExtensions, e = " + paramString);
    return;
    int i = 0;
    for (;;)
    {
      JSONObject localJSONObject;
      int j;
      try
      {
        if ((i >= localJSONArray.length()) || (i >= 5)) {
          break label281;
        }
        localJSONObject = localJSONArray.getJSONObject(i);
        paramString = null;
        j = localJSONObject.optInt("type");
        switch (j)
        {
        case 1: 
          if (paramString == null) {
            break label285;
          }
          this.zA.add(paramString);
        }
      }
      catch (JSONException paramString)
      {
        if (!QLog.isColorLevel()) {
          break label281;
        }
      }
      if ((T() instanceof DynamicSearch.ResultItem))
      {
        paramString = new amqn(this.keyword, this.ajO, this.FZ, this.from, localJSONObject, j, (DynamicSearch.ResultItem)T());
        continue;
        QLog.e(TAG, 2, "parseLayoutExtensions, e = " + paramString);
      }
      else if ((T() instanceof UnifySearchCommon.ResultItem))
      {
        paramString = new amqn(this.keyword, this.ajO, this.FZ, this.from, localJSONObject, j, (UnifySearchCommon.ResultItem)T());
        continue;
        if (localJSONArray != null) {
          break;
        }
        label281:
        return;
        continue;
        label285:
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
 * Qualified Name:     amqm
 * JD-Core Version:    0.7.0.1
 */