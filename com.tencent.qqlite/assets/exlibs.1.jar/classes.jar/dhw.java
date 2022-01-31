import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.qphone.base.util.QLog;

class dhw
  implements Runnable
{
  dhw(dhv paramdhv) {}
  
  public void run()
  {
    this.a.a.a.c = System.currentTimeMillis();
    try
    {
      this.a.a.a.a.loadUrl("javascript:add_more_page()");
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "javascript:add_more_page()");
      return;
    }
    catch (Exception localException)
    {
      QLog.e("<FileAssistant>FilePreviewActivity", 1, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dhw
 * JD-Core Version:    0.7.0.1
 */