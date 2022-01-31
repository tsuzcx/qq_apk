import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;

class xrk
  implements DialogInterface.OnClickListener
{
  xrk(xrj paramxrj) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.a.getIntent();
    paramDialogInterface.putExtra("flow_back", 0);
    this.a.a.setResult(1001, paramDialogInterface);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xrk
 * JD-Core Version:    0.7.0.1
 */