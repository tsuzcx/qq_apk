import com.tencent.mobileqq.startup.step.UpdateSecureFileStrategy;
import java.io.File;
import java.io.FileFilter;
import mqq.app.SecurityFileFrameworkManagerImpl;

public class annp
  implements FileFilter
{
  public annp(UpdateSecureFileStrategy paramUpdateSecureFileStrategy) {}
  
  public boolean accept(File paramFile)
  {
    if ((paramFile.isDirectory()) && (paramFile.getName().startsWith("NoRename#")))
    {
      paramFile = paramFile.getName().replaceAll("NoRename#", "");
      return (paramFile.length() == 9) && (paramFile.charAt(0) == SecurityFileFrameworkManagerImpl.generateVerifyChar(paramFile.substring(1)));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     annp
 * JD-Core Version:    0.7.0.1
 */