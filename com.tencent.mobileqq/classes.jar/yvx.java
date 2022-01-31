import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.data.ApolloActionData;
import java.util.Comparator;

public class yvx
  implements Comparator
{
  public yvx(ApolloDaoManager paramApolloDaoManager) {}
  
  public int a(ApolloActionData paramApolloActionData1, ApolloActionData paramApolloActionData2)
  {
    if (paramApolloActionData2.obtainedTime == paramApolloActionData1.obtainedTime) {
      return 0;
    }
    if (paramApolloActionData2.obtainedTime > paramApolloActionData1.obtainedTime) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yvx
 * JD-Core Version:    0.7.0.1
 */