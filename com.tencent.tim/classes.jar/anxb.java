import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public final class anxb
  implements anxe
{
  private final File aA;
  
  public anxb(String paramString)
  {
    this.aA = new File(String.format("/data/local/tmp/%sPluginManager.apk", new Object[] { paramString }));
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
    return acmo.a(16).submit(new anxd(this, paramFile));
  }
  
  public boolean isAvailable()
  {
    return this.aA.exists();
  }
  
  public Future<File> update()
  {
    return acmo.a(16).submit(new anxc(this));
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anxb
 * JD-Core Version:    0.7.0.1
 */