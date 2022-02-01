import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class vgs
  implements PluginManagerUpdater
{
  private File jdField_a_of_type_JavaIoFile;
  private vgv jdField_a_of_type_Vgv;
  
  vgs(vgv paramvgv)
  {
    if (paramvgv != null)
    {
      this.jdField_a_of_type_Vgv = paramvgv;
      this.jdField_a_of_type_JavaIoFile = new File(this.jdField_a_of_type_Vgv.b());
    }
  }
  
  public vgv a()
  {
    return this.jdField_a_of_type_Vgv;
  }
  
  public File getLatest()
  {
    return this.jdField_a_of_type_JavaIoFile;
  }
  
  public Future<Boolean> isAvailable(File paramFile)
  {
    return ThreadManagerExecutor.getExecutorService(16).submit(new vgu(this, paramFile));
  }
  
  public Future<File> update()
  {
    return ThreadManagerExecutor.getExecutorService(16).submit(new vgt(this));
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgs
 * JD-Core Version:    0.7.0.1
 */