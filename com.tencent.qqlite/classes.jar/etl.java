import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;

public final class etl
  implements Runnable
{
  public void run()
  {
    FileUtils.a(BaseApplicationImpl.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     etl
 * JD-Core Version:    0.7.0.1
 */