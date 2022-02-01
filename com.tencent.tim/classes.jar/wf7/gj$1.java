package wf7;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

final class gj$1
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return Pattern.matches("cpu[0-9]", paramFile.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.gj.1
 * JD-Core Version:    0.7.0.1
 */