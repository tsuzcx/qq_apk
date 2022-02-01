import java.io.File;
import java.io.FileFilter;

class avue
  implements FileFilter
{
  avue(avua paramavua) {}
  
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".ftf");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avue
 * JD-Core Version:    0.7.0.1
 */