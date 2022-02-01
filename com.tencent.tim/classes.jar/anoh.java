import com.tencent.mobileqq.statistics.LocalCrashCollector;
import java.io.File;
import java.io.FilenameFilter;

public class anoh
  implements FilenameFilter
{
  public anoh(LocalCrashCollector paramLocalCrashCollector) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return !paramString.contains("CrashInfoSummary.txt");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anoh
 * JD-Core Version:    0.7.0.1
 */