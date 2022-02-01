package moai.log;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FileHandler$1
  implements FilenameFilter
{
  FileHandler$1(FileHandler paramFileHandler, Pattern paramPattern, String paramString1, String paramString2) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (this.val$pattern.pattern().equals(paramString)) || ((this.val$pattern.matcher(paramString).matches()) && ((this.val$beginString == null) || (paramString.compareTo(this.val$beginString) >= 0)) && ((this.val$endString == null) || (paramString.compareTo(this.val$endString) < 0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.log.FileHandler.1
 * JD-Core Version:    0.7.0.1
 */