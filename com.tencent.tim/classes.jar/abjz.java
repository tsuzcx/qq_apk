import com.tencent.mobileqq.apollo.data.CmGamePushItem;
import java.util.Comparator;

class abjz
  implements Comparator<CmGamePushItem>
{
  abjz(abjy paramabjy) {}
  
  public int a(CmGamePushItem paramCmGamePushItem1, CmGamePushItem paramCmGamePushItem2)
  {
    if (paramCmGamePushItem1.start_ts == paramCmGamePushItem2.start_ts) {
      return paramCmGamePushItem2.send_time - paramCmGamePushItem1.send_time;
    }
    return paramCmGamePushItem2.start_ts - paramCmGamePushItem1.start_ts;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abjz
 * JD-Core Version:    0.7.0.1
 */