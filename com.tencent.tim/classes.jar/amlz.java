import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.HorizontalListView.c;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class amlz
  implements HorizontalListView.c
{
  amlz(amly paramamly, HorizontalListView paramHorizontalListView) {}
  
  public void onScroll()
  {
    int i = this.x.getCurrentX();
    long l1 = aqgz.getWidth();
    long l2 = aqcx.dip2px(this.x.getContext(), 13.5F);
    float f = Math.round((float)(i + (l1 - l2)) / this.a.zr);
    i = 0;
    for (;;)
    {
      if ((i < f) && (i < this.a.mDatas.size()))
      {
        amqn localamqn = (amqn)this.a.mDatas.get(i);
        amkl.a locala;
        JSONObject localJSONObject;
        if (amkl.mT.containsKey(localamqn))
        {
          locala = (amkl.a)amkl.mT.get(localamqn);
          if (!locala.acL)
          {
            locala.acL = true;
            localJSONObject = new JSONObject();
          }
        }
        try
        {
          localJSONObject.put("project", amub.zn());
          localJSONObject.put("event_src", "client");
          localJSONObject.put("get_src", "web");
          localJSONObject.put("obj_lct", locala.index);
          localJSONObject.put("extra_info", localamqn.cbP);
          localJSONObject.put("tepl", localamqn.cbB);
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          amub.a(localQQAppInterface, new ReportModelDC02528().module("all_result").action("exp_item").obj1(localamqn.ajO + "").obj2(localamqn.cbr).ver1(locala.key).ver2(amub.eZ(this.a.fromType)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + amkl.ajN));
          i += 1;
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amlz
 * JD-Core Version:    0.7.0.1
 */