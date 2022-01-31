import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.data.CircleBuddy;
import java.util.Comparator;

public class feg
  implements Comparator
{
  public feg(CircleManager paramCircleManager) {}
  
  public int a(CircleBuddy paramCircleBuddy1, CircleBuddy paramCircleBuddy2)
  {
    return paramCircleBuddy2.randomCloseness - paramCircleBuddy1.randomCloseness;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     feg
 * JD-Core Version:    0.7.0.1
 */