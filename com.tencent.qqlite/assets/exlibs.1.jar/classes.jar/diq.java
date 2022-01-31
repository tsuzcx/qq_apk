import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;

class diq
  implements FMDialogUtil.FMDialogInterface
{
  diq(dip paramdip) {}
  
  public void a()
  {
    UniformDownloadActivity.a(this.a.a);
    this.a.a.finish();
    this.a.a.overridePendingTransition(0, 0);
  }
  
  public void b()
  {
    this.a.a.finish();
    this.a.a.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     diq
 * JD-Core Version:    0.7.0.1
 */