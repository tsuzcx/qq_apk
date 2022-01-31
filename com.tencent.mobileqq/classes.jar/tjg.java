import android.content.Intent;
import com.tencent.biz.pubaccount.weishi_new.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;

public class tjg
{
  public static tjd a(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt, Intent paramIntent)
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
          return new tjh(paramWSRedDotPushMsg);
          i = 0;
        }
        else if (i == 5)
        {
          return new tje(paramWSRedDotPushMsg);
        }
      }
      if (i == 2) {
        return new tji(paramWSRedDotPushMsg, paramInt, paramIntent);
      }
      if (i == 3) {
        return new tjj(paramWSRedDotPushMsg, paramInt, paramIntent);
      }
      if (i == 4) {
        return new tjf(paramWSRedDotPushMsg, paramInt);
      }
      if (paramInt == 2) {
        return new tjh(paramWSRedDotPushMsg);
      }
    } while (paramInt != 6);
    return new tji(paramWSRedDotPushMsg, paramInt, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tjg
 * JD-Core Version:    0.7.0.1
 */