import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

class amyq
  implements View.OnClickListener
{
  amyq(amyp.a parama) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag(2131379238);
    Object localObject3 = paramView.getTag(2131379239);
    Context localContext;
    Object localObject2;
    if ((localObject1 != null) && ((localObject1 instanceof String)))
    {
      localContext = paramView.getContext();
      localObject1 = (String)localObject1;
      localObject2 = paramView.getTag(2131379208);
      if (!(localObject2 instanceof Integer)) {
        break label511;
      }
    }
    label145:
    label421:
    label511:
    for (int i = ((Integer)localObject2).intValue();; i = 0)
    {
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = amxh.fb(i);
        localObject1 = amxh.k((String)localObject3, 3, (String)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("NetSearchTemplateNewEntranceView", 2, "open Browser append suffix url = " + (String)localObject1);
        }
        if (localObject1 != null) {
          break label145;
        }
        QLog.e("NetSearchTemplateNewEntranceView", 2, "NetSearchSubView click jumpurl is null");
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject1 = amxh.aw((String)localObject1, i);
        break;
        amub.a(null, 0, i, "0X8009D5F", 0, 0, null, null);
        localObject2 = (amqq)paramView.getTag(2131381960);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("project", amub.zn());
          localJSONObject.put("event_src", "client");
          localJSONObject.put("experiment_id", amub.cce);
          if (localObject2 != null)
          {
            QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("all_result").action("clk_relatedsearch_list").obj1(((amqq)localObject2).ajO + "").obj2(((amqq)localObject2).id).ver1(((amqq)localObject2).getKeyword()).ver2(amub.eZ(i));
            if (localObject3 == null)
            {
              localObject2 = "";
              amub.a(null, localReportModelDC02528.ver4((String)localObject2).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + amkl.ajN));
            }
          }
          else
          {
            if ((!((String)localObject1).startsWith("https://")) && (!((String)localObject1).startsWith("http://"))) {
              break label421;
            }
            amxk.E(localContext, (String)localObject3, (String)localObject1);
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QLog.e("NetSearchTemplateNewEntranceView", 2, "e = " + localJSONException);
            continue;
            localObject2 = localObject3.toString();
          }
          if ((localContext instanceof BaseActivity))
          {
            localObject2 = aqik.c(((BaseActivity)localContext).app, localContext, (String)localObject1);
            if (localObject2 != null) {
              ((aqhv)localObject2).ace();
            } else {
              localContext.startActivity(new Intent(localContext, JumpActivity.class).setData(Uri.parse((String)localObject1)));
            }
          }
          else
          {
            localContext.startActivity(new Intent(localContext, JumpActivity.class).setData(Uri.parse((String)localObject1)));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amyq
 * JD-Core Version:    0.7.0.1
 */