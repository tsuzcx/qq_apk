import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class amtw
  implements View.OnClickListener
{
  amtw(amtn paramamtn, Context paramContext, amqv paramamqv) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    amxk.g(localQQAppInterface, this.val$context, this.b.a.url);
    amkl.a locala;
    JSONObject localJSONObject;
    if (amkl.mT.containsKey(this.b))
    {
      locala = (amkl.a)amkl.mT.get(this.b);
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", amub.zn());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", locala.index);
      localJSONObject.put("get_src", "web");
      amub.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(locala.ajO + "").obj2(locala.caE).ver1(locala.key).ver2(amub.eZ(this.b.from)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + amkl.ajN));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "e = " + localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amtw
 * JD-Core Version:    0.7.0.1
 */