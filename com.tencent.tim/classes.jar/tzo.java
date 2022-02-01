import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class tzo
  implements View.OnClickListener
{
  tzo(tzm paramtzm, tzl paramtzl, tze paramtze, JSONObject paramJSONObject, tzd paramtzd) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Tzm.bF();
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "accept " + this.jdField_a_of_type_Tzl.key);
    tzm.a(this.jdField_a_of_type_Tzm, this.jdField_a_of_type_Tzl, 2);
    tzm.a(this.jdField_a_of_type_Tzm, 0, this.jdField_a_of_type_Tze, this.aQ, this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tzo
 * JD-Core Version:    0.7.0.1
 */