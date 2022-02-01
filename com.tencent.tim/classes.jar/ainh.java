import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class ainh
{
  public static String CACHE_PATH = new File(BaseApplicationImpl.getApplication().getFilesDir(), "ListenTogether_v828").getAbsolutePath();
  
  static
  {
    if (aqfo.isExistSDCard())
    {
      CACHE_PATH = new File(acbn.SDCARD_PATH, "ListenTogether_v828").getAbsolutePath();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ainh
 * JD-Core Version:    0.7.0.1
 */