import com.tencent.mobileqq.startup.step.UpdatePluginVersion;
import java.io.File;
import java.io.FilenameFilter;

public class eei
  implements FilenameFilter
{
  public eei(UpdatePluginVersion paramUpdatePluginVersion, String paramString) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.equals(this.jdField_a_of_type_JavaLangString + ".cfg");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eei
 * JD-Core Version:    0.7.0.1
 */