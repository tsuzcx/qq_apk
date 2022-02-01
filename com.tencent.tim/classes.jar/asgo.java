import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;

class asgo
  implements FilenameFilter
{
  asgo(asgn paramasgn) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.endsWith(".so"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asgo
 * JD-Core Version:    0.7.0.1
 */