import com.tencent.mobileqq.app.soso.SosoInterface;
import java.util.ArrayList;

public final class zte
  implements Runnable
{
  public void run()
  {
    if (SosoInterface.a().size() == 0) {
      SosoInterface.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zte
 * JD-Core Version:    0.7.0.1
 */