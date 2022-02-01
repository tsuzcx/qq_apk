import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;

public class fwm
  implements Runnable
{
  public fwm(UniformDownloadMgr paramUniformDownloadMgr) {}
  
  public void run()
  {
    UniformDownloadMgr.b(this.a, null);
    UniformDownloadMgr.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fwm
 * JD-Core Version:    0.7.0.1
 */