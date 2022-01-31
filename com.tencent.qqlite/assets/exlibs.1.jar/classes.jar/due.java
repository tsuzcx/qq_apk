import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase;

class due
  implements Runnable
{
  due(dud paramdud) {}
  
  public void run()
  {
    if (PreviewingOfflineFileViewBase.a(this.a.a) >= 90)
    {
      PreviewingOfflineFileViewBase.a(this.a.a);
      PreviewingOfflineFileViewBase.f(this.a.a);
      return;
    }
    PreviewingOfflineFileViewBase.b(this.a.a);
    PreviewingOfflineFileViewBase.g(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     due
 * JD-Core Version:    0.7.0.1
 */