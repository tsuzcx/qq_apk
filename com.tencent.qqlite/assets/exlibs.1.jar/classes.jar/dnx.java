import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;

public class dnx
  extends FMObserver
{
  public dnx(QfileRecentPicFileTabView paramQfileRecentPicFileTabView) {}
  
  protected void a(ThumbnailInfo paramThumbnailInfo)
  {
    super.a(paramThumbnailInfo);
    if ((paramThumbnailInfo.b != null) && (paramThumbnailInfo.b.length() > 0)) {
      this.a.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dnx
 * JD-Core Version:    0.7.0.1
 */