import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.globalsearch.FavoriteSearchActivity;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class avju
  implements ampw
{
  public static final String TAG = avju.class.getSimpleName();
  public static final String cLs = acfp.m(2131707063);
  private List<ampx> Bu;
  private String keyword;
  
  public avju(List<ampx> paramList, String paramString)
  {
    this.Bu = paramList;
    this.keyword = paramString;
  }
  
  public int Ex()
  {
    return 0;
  }
  
  public List<ampx> eX()
  {
    return this.Bu;
  }
  
  public void gJ(View paramView)
  {
    Object localObject;
    QQAppInterface localQQAppInterface;
    JSONObject localJSONObject;
    if (((paramView.getContext() instanceof UniteSearchActivity)) && (amkl.mT.containsKey(this)))
    {
      localObject = (amkl.a)amkl.mT.get(this);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", amub.zn());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", ((amkl.a)localObject).index);
      localJSONObject.put("get_src", "native");
      amub.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(((amkl.a)localObject).ajO + "").obj2(((amkl.a)localObject).caE).ver1(((amkl.a)localObject).key).ver2(amub.eZ(UniteSearchActivity.dCK)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + amkl.ajN));
      localObject = (BaseActivity)paramView.getContext();
      FavoriteSearchActivity.launch((Context)localObject, this.keyword);
      avja.a((Activity)localObject, ((BaseActivity)localObject).getAppRuntime().getAccount(), 0L);
      amxk.a(this.keyword, 60, 0, paramView);
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
  
  public String getGroupName()
  {
    return acfp.m(2131707069);
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avju
 * JD-Core Version:    0.7.0.1
 */