package moai.patch.exception;

import java.io.File;
import java.io.FilenameFilter;

final class MoaiExceptionHandler$1
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString != null) && (!paramString.equals("")) && (paramString.startsWith("moai.crash."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.exception.MoaiExceptionHandler.1
 * JD-Core Version:    0.7.0.1
 */