import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.data.RecommendContactMsg;
import java.util.Comparator;

public class fem
  implements Comparator
{
  public fem(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public int a(RecommendContactMsg paramRecommendContactMsg1, RecommendContactMsg paramRecommendContactMsg2)
  {
    return paramRecommendContactMsg1.friendStatus - paramRecommendContactMsg2.friendStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fem
 * JD-Core Version:    0.7.0.1
 */