import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2.23;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr;

public class aaqa
  implements DialogInterface.OnClickListener
{
  public aaqa(FlowCameraActivity2.23 param23) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.this$0.getIntent();
    paramDialogInterface.putExtra("flow_back", 0);
    this.a.this$0.setResult(1001, paramDialogInterface);
    paramDialogInterface = null;
    if (this.a.this$0.bwR) {
      paramDialogInterface = this.a.this$0.c.b;
    }
    this.a.this$0.c.a.a(this.a.this$0.mPreviewWidth, this.a.this$0.mPreviewHeight, this.a.this$0.bwX, this.a.this$0.bwR, paramDialogInterface);
    this.a.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaqa
 * JD-Core Version:    0.7.0.1
 */