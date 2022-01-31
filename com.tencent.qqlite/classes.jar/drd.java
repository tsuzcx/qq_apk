import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;

public class drd
  implements Runnable
{
  public drd(UniformDownloadMgr paramUniformDownloadMgr) {}
  
  public void run()
  {
    UniformDownloadMgr.b(this.a, null);
    UniformDownloadMgr.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     drd
 * JD-Core Version:    0.7.0.1
 */