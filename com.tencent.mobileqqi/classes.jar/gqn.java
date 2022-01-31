import android.text.format.Time;
import com.tencent.mobileqq.testassister.ShareAppLogHelper;
import java.io.File;
import java.io.FilenameFilter;

public class gqn
  implements FilenameFilter
{
  public gqn(ShareAppLogHelper paramShareAppLogHelper) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    if (!paramString.endsWith(".log")) {}
    do
    {
      return false;
      paramFile = ShareAppLogHelper.a(this.a, paramString);
    } while ((paramFile == null) || (paramFile.toMillis(false) < ShareAppLogHelper.a(this.a).toMillis(false)) || (paramFile.toMillis(false) > ShareAppLogHelper.b(this.a).toMillis(false)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gqn
 * JD-Core Version:    0.7.0.1
 */