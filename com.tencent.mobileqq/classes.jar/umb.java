import android.content.Intent;
import com.tencent.biz.pubaccount.weishi_new.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;

public class umb
{
  public static uly a(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt, Intent paramIntent)
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
          return new umc(paramWSRedDotPushMsg);
          i = 0;
        }
        else if (i == 5)
        {
          return new ulz(paramWSRedDotPushMsg);
        }
      }
      if (i == 2) {
        return new umd(paramWSRedDotPushMsg, paramInt, paramIntent);
      }
      if (i == 3) {
        return new ume(paramWSRedDotPushMsg, paramInt, paramIntent);
      }
      if (i == 4) {
        return new uma(paramWSRedDotPushMsg, paramInt);
      }
      if (paramInt == 2) {
        return new umc(paramWSRedDotPushMsg);
      }
    } while (paramInt != 6);
    return new umd(paramWSRedDotPushMsg, paramInt, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     umb
 * JD-Core Version:    0.7.0.1
 */