import cooperation.plugin.PluginInstaller;
import java.io.File;
import java.io.FilenameFilter;

public class iae
  implements FilenameFilter
{
  public iae(PluginInstaller paramPluginInstaller, String paramString) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     iae
 * JD-Core Version:    0.7.0.1
 */