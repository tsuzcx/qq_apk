import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.data.ApolloActionData;
import java.util.Comparator;

public class yss
  implements Comparator
{
  public yss(ApolloDaoManager paramApolloDaoManager) {}
  
  public int a(ApolloActionData paramApolloActionData1, ApolloActionData paramApolloActionData2)
  {
    if (paramApolloActionData2.version == paramApolloActionData1.version) {
      return 0;
    }
    if (paramApolloActionData2.version > paramApolloActionData1.version) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yss
 * JD-Core Version:    0.7.0.1
 */