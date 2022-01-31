import cooperation.plugin.PluginInstaller;
import java.io.File;
import java.io.FilenameFilter;

public class iez
  implements FilenameFilter
{
  public iez(PluginInstaller paramPluginInstaller, String paramString) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     iez
 * JD-Core Version:    0.7.0.1
 */