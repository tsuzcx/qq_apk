import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;

public class agdk
  implements DialogInterface.OnKeyListener
{
  public agdk(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 4)
    {
      if (this.this$0.e != null)
      {
        this.this$0.e.dismiss();
        this.this$0.e = null;
      }
      this.this$0.finish();
      this.this$0.overridePendingTransition(0, 0);
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agdk
 * JD-Core Version:    0.7.0.1
 */