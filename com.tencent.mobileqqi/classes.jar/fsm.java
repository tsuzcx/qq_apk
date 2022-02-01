import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;

class fsm
  implements FMDialogUtil.FMDialogInterface
{
  fsm(fsl paramfsl) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fsm
 * JD-Core Version:    0.7.0.1
 */