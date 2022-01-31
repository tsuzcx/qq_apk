import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.OfflineVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;

class duv
  extends FMObserver
{
  duv(duu paramduu) {}
  
  protected void a(ThumbnailInfo paramThumbnailInfo)
  {
    if ((paramThumbnailInfo.a instanceof FileManagerEntity))
    {
      paramThumbnailInfo = (FileManagerEntity)paramThumbnailInfo.a;
      if ((paramThumbnailInfo.Uuid != null) && (paramThumbnailInfo.Uuid.equals(OfflineVideoFileView.a(this.a.a).d()))) {
        this.a.a.e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     duv
 * JD-Core Version:    0.7.0.1
 */