import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class zsf
  implements View.OnClickListener
{
  zsf(zsd paramzsd, zsc paramzsc, zru paramzru, JSONObject paramJSONObject, zrt paramzrt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Zsd.d();
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "accept " + this.jdField_a_of_type_Zsc.a);
    zsd.a(this.jdField_a_of_type_Zsd, this.jdField_a_of_type_Zsc, 2);
    zsd.a(this.jdField_a_of_type_Zsd, 0, this.jdField_a_of_type_Zru, this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Zrt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zsf
 * JD-Core Version:    0.7.0.1
 */