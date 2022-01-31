import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class zto
  implements DialogInterface.OnCancelListener, begw, begy
{
  begr jdField_a_of_type_Begr;
  zrt jdField_a_of_type_Zrt;
  
  public zto(begr parambegr, zrt paramzrt)
  {
    this.jdField_a_of_type_Begr = parambegr;
    this.jdField_a_of_type_Zrt = paramzrt;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Begr.dismiss();
    paramView = new JSONObject();
    try
    {
      paramView.put("cancel", false);
      paramView.put("tapIndex", paramInt);
      zva.a(this.jdField_a_of_type_Zrt, paramView);
      return;
    }
    catch (JSONException paramView)
    {
      String str = paramView.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, paramView);
      }
      zrt localzrt = this.jdField_a_of_type_Zrt;
      paramView = str;
      if (str == null) {
        paramView = "";
      }
      zva.a(localzrt, -2, paramView);
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("cancel", true);
      paramDialogInterface.put("tapIndex", -1);
      zva.a(this.jdField_a_of_type_Zrt, paramDialogInterface);
      return;
    }
    catch (JSONException paramDialogInterface)
    {
      String str = paramDialogInterface.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, paramDialogInterface);
      }
      zrt localzrt = this.jdField_a_of_type_Zrt;
      paramDialogInterface = str;
      if (str == null) {
        paramDialogInterface = "";
      }
      zva.a(localzrt, -2, paramDialogInterface);
    }
  }
  
  public void onDismiss()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cancel", true);
      localJSONObject.put("tapIndex", -1);
      zva.a(this.jdField_a_of_type_Zrt, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      String str = localJSONException.getMessage();
      if (QLog.isColorLevel()) {
        QLog.w("DoraemonOpenAPI.widget", 2, str, localJSONException);
      }
      zrt localzrt = this.jdField_a_of_type_Zrt;
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      zva.a(localzrt, -2, (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zto
 * JD-Core Version:    0.7.0.1
 */