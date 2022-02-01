import java.io.File;
import java.io.FileFilter;

class wik
  implements FileFilter
{
  wik(wii paramwii) {}
  
  public boolean accept(File paramFile)
  {
    return paramFile.getName().startsWith(wii.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wik
 * JD-Core Version:    0.7.0.1
 */