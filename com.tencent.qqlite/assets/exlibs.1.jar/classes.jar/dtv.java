import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PhotoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;

class dtv
  extends FMObserver
{
  dtv(dtu paramdtu) {}
  
  protected void a(ThumbnailInfo paramThumbnailInfo)
  {
    IFileViewerAdapter localIFileViewerAdapter;
    if ((paramThumbnailInfo.a instanceof IFileViewerAdapter))
    {
      localIFileViewerAdapter = (IFileViewerAdapter)paramThumbnailInfo.a;
      if ((paramThumbnailInfo.b != null) && (paramThumbnailInfo.b.length() >= 1)) {}
    }
    else
    {
      return;
    }
    this.a.a.a(localIFileViewerAdapter, paramThumbnailInfo.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dtv
 * JD-Core Version:    0.7.0.1
 */