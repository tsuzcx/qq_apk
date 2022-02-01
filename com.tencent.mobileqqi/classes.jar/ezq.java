import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.data.CircleGroup;
import java.util.Comparator;

public class ezq
  implements Comparator
{
  public ezq(CircleManager paramCircleManager) {}
  
  public int a(CircleGroup paramCircleGroup1, CircleGroup paramCircleGroup2)
  {
    return paramCircleGroup1.showIndex - paramCircleGroup2.showIndex;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ezq
 * JD-Core Version:    0.7.0.1
 */