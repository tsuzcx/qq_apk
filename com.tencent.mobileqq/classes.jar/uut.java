import android.content.Intent;
import com.tencent.biz.pubaccount.weishi_new.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;

public class uut
{
  public static uuq a(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt, Intent paramIntent)
  {
    if (paramWSRedDotPushMsg == null) {}
    do
    {
      return null;
      int i;
      if (paramWSRedDotPushMsg.mStrategyInfo != null) {
        i = paramWSRedDotPushMsg.mStrategyInfo.getType();
      }
      while (paramInt == 2) {
        if (i == 1)
        {
          return new uuu(paramWSRedDotPushMsg);
          i = 0;
        }
        else if (i == 5)
        {
          return new uur(paramWSRedDotPushMsg);
        }
      }
      if (i == 2) {
        return new uuv(paramWSRedDotPushMsg, paramInt, paramIntent);
      }
      if (i == 3) {
        return new uuw(paramWSRedDotPushMsg, paramInt, paramIntent);
      }
      if (i == 4) {
        return new uus(paramWSRedDotPushMsg, paramInt);
      }
      if (paramInt == 2) {
        return new uuu(paramWSRedDotPushMsg);
      }
    } while (paramInt != 6);
    return new uuv(paramWSRedDotPushMsg, paramInt, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uut
 * JD-Core Version:    0.7.0.1
 */