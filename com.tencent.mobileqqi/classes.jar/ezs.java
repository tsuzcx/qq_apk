import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.data.CircleBuddy;
import java.util.Comparator;

public class ezs
  implements Comparator
{
  public ezs(CircleManager paramCircleManager) {}
  
  public int a(CircleBuddy paramCircleBuddy1, CircleBuddy paramCircleBuddy2)
  {
    return paramCircleBuddy2.randomCloseness - paramCircleBuddy1.randomCloseness;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ezs
 * JD-Core Version:    0.7.0.1
 */