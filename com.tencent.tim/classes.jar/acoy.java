import com.tencent.mobileqq.app.automator.step.CleanCache;
import java.io.File;
import java.util.Comparator;

public class acoy
  implements Comparator<File>
{
  public acoy(CleanCache paramCleanCache) {}
  
  public int compare(File paramFile1, File paramFile2)
  {
    if (paramFile2.lastModified() - paramFile1.lastModified() > 0L) {
      return 1;
    }
    if (paramFile2.lastModified() - paramFile1.lastModified() < 0L) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acoy
 * JD-Core Version:    0.7.0.1
 */