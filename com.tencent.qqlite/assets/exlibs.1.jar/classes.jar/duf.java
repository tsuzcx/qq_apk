import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase.IControllProxyInterface;
import com.tencent.mobileqq.filemanager.widget.FileWebView;

class duf
  implements Runnable
{
  duf(dud paramdud) {}
  
  public void run()
  {
    if (PreviewingOfflineFileViewBase.a(this.a.a) == null) {}
    while (PreviewingOfflineFileViewBase.a(this.a.a)) {
      return;
    }
    PreviewingOfflineFileViewBase.a(this.a.a, true);
    String str = this.a.a.a().d();
    PreviewingOfflineFileViewBase.a(this.a.a).loadUrl(str);
    PreviewingOfflineFileViewBase.a(this.a.a).loadUrl("javascript:add_more_page()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     duf
 * JD-Core Version:    0.7.0.1
 */