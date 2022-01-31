import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class zsh
  implements DialogInterface.OnCancelListener
{
  zsh(zsd paramzsd, zsc paramzsc, zru paramzru, JSONObject paramJSONObject, zrt paramzrt) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Zsd.d();
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "cancel " + this.jdField_a_of_type_Zsc.a);
    zsd.c(this.jdField_a_of_type_Zsd, 4, this.jdField_a_of_type_Zru, this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Zrt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zsh
 * JD-Core Version:    0.7.0.1
 */