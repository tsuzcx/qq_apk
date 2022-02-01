import android.annotation.SuppressLint;
import android.content.Intent;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import java.io.File;

class asxl
  implements IActivityResultListener
{
  asxl(asxf paramasxf, File paramFile, boolean paramBoolean) {}
  
  @SuppressLint({"NewApi"})
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 2) {
      return false;
    }
    if (paramInt2 != -1)
    {
      this.val$videoFile.deleteOnExit();
      asxf.a(this.this$0, asxf.a(this.this$0), "chooseVideo", null);
      AppLoaderFactory.g().getActivityResultManager().removeActivityResultListener(this);
      return true;
    }
    asxf.a(this.this$0, this.val$videoFile, this.val$compress);
    AppLoaderFactory.g().getActivityResultManager().removeActivityResultListener(this);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asxl
 * JD-Core Version:    0.7.0.1
 */