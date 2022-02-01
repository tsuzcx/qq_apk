import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;
import cooperation.groupvideo.GVideoPluginInstallerActivity;

public class avfe
  extends Handler
{
  public avfe(GVideoPluginInstallerActivity paramGVideoPluginInstallerActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        GVideoPluginInstallerActivity.a(this.this$0);
        return;
      }
    } while ((!(paramMessage.obj instanceof String)) || (this.this$0.mTextView == null));
    this.this$0.mTextView.setText((String)paramMessage.obj);
    return;
    GVideoPluginInstallerActivity.b(this.this$0);
    return;
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avfe
 * JD-Core Version:    0.7.0.1
 */