import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class tzq
  implements DialogInterface.OnCancelListener
{
  tzq(tzm paramtzm, tzl paramtzl, tze paramtze, JSONObject paramJSONObject, tzd paramtzd) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Tzm.bF();
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "cancel " + this.jdField_a_of_type_Tzl.key);
    tzm.c(this.jdField_a_of_type_Tzm, 4, this.jdField_a_of_type_Tze, this.aQ, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tzq
 * JD-Core Version:    0.7.0.1
 */