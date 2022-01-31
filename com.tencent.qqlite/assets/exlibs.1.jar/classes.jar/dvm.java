import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase;

class dvm
  implements Runnable
{
  dvm(dvl paramdvl) {}
  
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
 * Qualified Name:     dvm
 * JD-Core Version:    0.7.0.1
 */