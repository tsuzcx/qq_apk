import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class vvm
  implements PluginManagerUpdater
{
  private File jdField_a_of_type_JavaIoFile;
  private vvp jdField_a_of_type_Vvp;
  
  vvm(vvp paramvvp)
  {
    if (paramvvp != null)
    {
      this.jdField_a_of_type_Vvp = paramvvp;
      this.jdField_a_of_type_JavaIoFile = new File(this.jdField_a_of_type_Vvp.b());
    }
  }
  
  public vvp a()
  {
    return this.jdField_a_of_type_Vvp;
  }
  
  public File getLatest()
  {
    return this.jdField_a_of_type_JavaIoFile;
  }
  
  public Future<Boolean> isAvailable(File paramFile)
  {
    return ThreadManagerExecutor.getExecutorService(16).submit(new vvo(this, paramFile));
  }
  
  public Future<File> update()
  {
    return ThreadManagerExecutor.getExecutorService(16).submit(new vvn(this));
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvm
 * JD-Core Version:    0.7.0.1
 */