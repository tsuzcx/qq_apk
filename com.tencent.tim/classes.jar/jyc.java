import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.smtt.export.external.interfaces.JsResult;

class jyc
  implements DialogInterface.OnCancelListener
{
  jyc(jxx paramjxx, JsResult paramJsResult, Context paramContext) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesJsResult.cancel();
    if (this.jdField_a_of_type_Jxx.aEu > 2) {
      ((Activity)this.val$context).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jyc
 * JD-Core Version:    0.7.0.1
 */