package mqq.app;

import java.io.File;
import java.io.FileFilter;

final class SecurityFileFrameworkManagerImpl$1
  implements FileFilter
{
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
 * Qualified Name:     mqq.app.SecurityFileFrameworkManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */