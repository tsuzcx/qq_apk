import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

class amma
  implements View.OnClickListener
{
  amma(amly paramamly, ViewGroup paramViewGroup) {}
  
  public void onClick(View paramView)
  {
    amxk.g((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.val$parent.getContext(), this.a.a.moreUrl);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("project", amub.zn());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("get_src", "web");
      amub.a(localQQAppInterface, new ReportModelDC02528().module("all_result").action("clk_more").obj1(this.a.ajO + "").ver1(UniteSearchActivity.caM).ver2(amub.eZ(this.a.fromType)).ver3("right").ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + amkl.ajN));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e(amly.TAG, 2, "e = " + localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amma
 * JD-Core Version:    0.7.0.1
 */