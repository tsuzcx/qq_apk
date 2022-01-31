import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr;

class xvg
  implements DialogInterface.OnClickListener
{
  xvg(xvf paramxvf) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.a.getIntent();
    paramDialogInterface.putExtra("flow_back", 0);
    this.a.a.setResult(1001, paramDialogInterface);
    paramDialogInterface = null;
    if (this.a.a.g) {
      paramDialogInterface = this.a.a.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
    }
    this.a.a.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.a.a.d, this.a.a.e, this.a.a.n, this.a.a.g, paramDialogInterface);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xvg
 * JD-Core Version:    0.7.0.1
 */