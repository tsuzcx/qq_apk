import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.qphone.base.util.QLog;

class dgo
  implements Runnable
{
  dgo(dgn paramdgn) {}
  
  public void run()
  {
    try
    {
      this.a.a.a.loadUrl("javascript:add_more_page()");
      return;
    }
    catch (Exception localException)
    {
      QLog.e("<FileAssistant>FilePreviewActivity", 1, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dgo
 * JD-Core Version:    0.7.0.1
 */