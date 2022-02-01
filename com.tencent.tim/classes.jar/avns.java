import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.Future;

public class avns
  implements PluginManagerUpdater
{
  private aibq b;
  private File be;
  
  public avns(aibq paramaibq, File paramFile)
  {
    this.b = paramaibq;
    this.be = paramFile;
  }
  
  public File getLatest()
  {
    return this.be;
  }
  
  public Future isAvailable(File paramFile)
  {
    return this.b.isAvailable(paramFile);
  }
  
  public Future update()
  {
    return this.b.update();
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avns
 * JD-Core Version:    0.7.0.1
 */