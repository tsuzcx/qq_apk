import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class amql
  extends amqg
  implements View.OnClickListener
{
  public static final String TAG = amql.class.getSimpleName();
  public JSONObject bH;
  public String cbP;
  public String cbr;
  public int type;
  
  protected amql(String paramString, long paramLong, List<String> paramList, int paramInt1, JSONObject paramJSONObject, int paramInt2, UnifySearchCommon.ResultItem paramResultItem)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt1);
    this.bH = paramJSONObject;
    this.type = paramInt2;
    bx(paramJSONObject);
  }
  
  protected amql(String paramString, long paramLong, List<String> paramList, int paramInt1, JSONObject paramJSONObject, int paramInt2, DynamicSearch.ResultItem paramResultItem)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt1);
    this.bH = paramJSONObject;
    this.type = paramInt2;
    bx(paramJSONObject);
  }
  
  public void a(amyk paramamyk) {}
  
  public void bx(JSONObject paramJSONObject) {}
  
  public void cR(View paramView)
  {
    amkl.a locala;
    JSONObject localJSONObject;
    if (amkl.mT.containsKey(this))
    {
      locala = (amkl.a)amkl.mT.get(this);
      paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", amub.zn());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", locala.index);
      localJSONObject.put("get_src", "web");
      localJSONObject.put("extra_info", this.cbP);
      localJSONObject.put("tepl", this.cbB);
      amub.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(this.ajO + "").obj2(this.cbr).ver1(this.keyword).ver2(amub.eZ(this.from)).ver7(localJSONObject.toString()).session_id(paramView.getCurrentAccountUin() + amkl.ajN));
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e(TAG, 2, "e = " + localJSONException);
      }
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
  
  public void onClick(View paramView)
  {
    cR(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amql
 * JD-Core Version:    0.7.0.1
 */