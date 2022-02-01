import android.content.Intent;
import com.tencent.biz.pubaccount.weishi_new.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;

public class vjg
{
  public static vjd a(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt, Intent paramIntent)
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
          return new vjh(paramWSRedDotPushMsg);
          i = 0;
        }
        else if (i == 5)
        {
          return new vje(paramWSRedDotPushMsg);
        }
      }
      if (i == 2) {
        return new vji(paramWSRedDotPushMsg, paramInt, paramIntent);
      }
      if (i == 3) {
        return new vjj(paramWSRedDotPushMsg, paramInt, paramIntent);
      }
      if (i == 4) {
        return new vjf(paramWSRedDotPushMsg, paramInt);
      }
      if (paramInt == 2) {
        return new vjh(paramWSRedDotPushMsg);
      }
    } while (paramInt != 6);
    return new vji(paramWSRedDotPushMsg, paramInt, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjg
 * JD-Core Version:    0.7.0.1
 */