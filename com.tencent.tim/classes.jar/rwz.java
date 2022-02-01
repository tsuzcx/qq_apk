import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class rwz
{
  private static final String TAG = rwz.class.getName();
  private static volatile rwy a;
  private static String aDe;
  private static String aDf;
  
  public static rwy a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        if (aDe == null) {
          aDe = BaseApplicationImpl.getApplication().getPackageName();
        }
        if (aDf == null) {
          aDf = BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath();
        }
        a = new rxa(aDe, aDf);
      }
      ram.d(TAG, "init FileCache");
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rwz
 * JD-Core Version:    0.7.0.1
 */