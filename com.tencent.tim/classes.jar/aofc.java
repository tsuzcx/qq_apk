import android.text.format.Time;
import com.tencent.mobileqq.testassister.ShareAppLogHelper;
import java.io.File;
import java.io.FilenameFilter;

public class aofc
  implements FilenameFilter
{
  public aofc(ShareAppLogHelper paramShareAppLogHelper) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    if (!paramString.endsWith(".log")) {}
    do
    {
      return false;
      paramFile = ShareAppLogHelper.a(this.this$0, paramString);
    } while ((paramFile == null) || (paramFile.toMillis(false) < ShareAppLogHelper.a(this.this$0).toMillis(false)) || (paramFile.toMillis(false) > ShareAppLogHelper.b(this.this$0).toMillis(false)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aofc
 * JD-Core Version:    0.7.0.1
 */