import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.biz.qqstory.takevideo.DanceMachineUploadVideoFragment;
import com.tencent.mobileqq.app.BaseActivity;

public class ray
  implements DialogInterface.OnKeyListener
{
  public ray(DanceMachineUploadVideoFragment paramDanceMachineUploadVideoFragment) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 84) {
      return true;
    }
    if (paramInt == 4)
    {
      this.this$0.go();
      this.this$0.KR();
      paramDialogInterface = this.this$0.mActivity;
      paramKeyEvent = this.this$0.mActivity;
      paramDialogInterface.setResult(0);
      this.this$0.mActivity.finish();
      DanceMachineUploadVideoFragment.a(this.this$0, false);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ray
 * JD-Core Version:    0.7.0.1
 */