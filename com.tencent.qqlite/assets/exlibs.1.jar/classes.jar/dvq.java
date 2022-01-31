import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.mobileqq.filemanager.widget.FileWebView.TitilebarEventInterface;

public class dvq
  extends Handler
{
  public dvq(FileWebView paramFileWebView) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a.getContentHeight() * this.a.getScale() - (this.a.getView().getHeight() + this.a.getWebScrollY()) < 2.5D) && (this.a.a != null) && (this.a.b == true))
    {
      this.a.b = false;
      this.a.a.b();
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dvq
 * JD-Core Version:    0.7.0.1
 */