import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.biz.qqstory.takevideo.DanceMachineUploadVideoFragment;
import com.tencent.mobileqq.app.BaseActivity;

public class wth
  implements DialogInterface.OnKeyListener
{
  public wth(DanceMachineUploadVideoFragment paramDanceMachineUploadVideoFragment) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 84) {
      return true;
    }
    if (paramInt == 4)
    {
      this.a.a();
      this.a.a();
      paramDialogInterface = this.a.a;
      paramKeyEvent = this.a.a;
      paramDialogInterface.setResult(0);
      this.a.a.finish();
      DanceMachineUploadVideoFragment.a(this.a, false);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wth
 * JD-Core Version:    0.7.0.1
 */