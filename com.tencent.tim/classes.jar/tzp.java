import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class tzp
  implements View.OnClickListener
{
  tzp(tzm paramtzm, tzl paramtzl, tze paramtze, JSONObject paramJSONObject, tzd paramtzd) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Tzm.bF();
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "reject " + this.jdField_a_of_type_Tzl.key);
    tzm.a(this.jdField_a_of_type_Tzm, this.jdField_a_of_type_Tzl, 1);
    tzm.b(this.jdField_a_of_type_Tzm, 4, this.jdField_a_of_type_Tze, this.aQ, this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tzp
 * JD-Core Version:    0.7.0.1
 */