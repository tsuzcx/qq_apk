import com.tencent.mobileqq.activity.voip.VoipHistoryAllType;
import com.tencent.mobileqq.activity.voip.VoipHistoryInterface;
import java.util.Comparator;

public class ewv
  implements Comparator
{
  public ewv(VoipHistoryInterface paramVoipHistoryInterface) {}
  
  public int a(VoipHistoryAllType paramVoipHistoryAllType1, VoipHistoryAllType paramVoipHistoryAllType2)
  {
    if (paramVoipHistoryAllType1.time > paramVoipHistoryAllType2.time) {
      return -1;
    }
    if (paramVoipHistoryAllType1.time < paramVoipHistoryAllType2.time) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ewv
 * JD-Core Version:    0.7.0.1
 */