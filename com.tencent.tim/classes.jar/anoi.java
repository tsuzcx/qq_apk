import com.tencent.mobileqq.statistics.LocalCrashCollector;
import java.io.File;
import java.util.Comparator;

public class anoi
  implements Comparator<File>
{
  public anoi(LocalCrashCollector paramLocalCrashCollector) {}
  
  public int compare(File paramFile1, File paramFile2)
  {
    long l = paramFile1.lastModified() - paramFile2.lastModified();
    if (l > 0L) {
      return -1;
    }
    if (l < 0L) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anoi
 * JD-Core Version:    0.7.0.1
 */