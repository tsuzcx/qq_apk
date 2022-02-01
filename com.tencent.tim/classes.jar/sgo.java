import java.io.File;
import java.util.Comparator;

final class sgo
  implements Comparator<File>
{
  public int compare(File paramFile1, File paramFile2)
  {
    return paramFile1.getName().compareToIgnoreCase(paramFile2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sgo
 * JD-Core Version:    0.7.0.1
 */