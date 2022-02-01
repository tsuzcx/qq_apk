import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public final class aibt
  implements PluginManagerUpdater
{
  private final File aA;
  
  public aibt(String paramString)
  {
    this.aA = new File("/data/local/tmp/" + paramString + "PluginManager.apk");
  }
  
  public File getLatest()
  {
    if (this.aA.exists()) {
      return this.aA;
    }
    return null;
  }
  
  public Future<Boolean> isAvailable(File paramFile)
  {
    return acmo.a(16).submit(new aibv(this, paramFile));
  }
  
  public Future<File> update()
  {
    return acmo.a(16).submit(new aibu(this));
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aibt
 * JD-Core Version:    0.7.0.1
 */