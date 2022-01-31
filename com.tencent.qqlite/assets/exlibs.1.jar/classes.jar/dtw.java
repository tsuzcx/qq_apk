import android.view.View;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase.IControllProxyInterface;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.TipsClickedInterface;

public class dtw
  implements FileManagerUtil.TipsClickedInterface
{
  public dtw(PreviewingOfflineFileViewBase paramPreviewingOfflineFileViewBase) {}
  
  public void a(View paramView)
  {
    this.a.a().b();
    PreviewingOfflineFileViewBase.a(this.a).a(false);
    PreviewingOfflineFileViewBase.b(this.a).b(true);
    PreviewingOfflineFileViewBase.a(this.a);
    PreviewingOfflineFileViewBase.b(this.a);
    PreviewingOfflineFileViewBase.c(this.a).c(false);
    if (PreviewingOfflineFileViewBase.a(this.a) != null) {
      PreviewingOfflineFileViewBase.b(this.a).c();
    }
    PreviewingOfflineFileViewBase.c(this.a).b(0);
    PreviewingOfflineFileViewBase.a(this.a, false, 9037L, "User Click Cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dtw
 * JD-Core Version:    0.7.0.1
 */