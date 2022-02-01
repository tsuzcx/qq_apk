import android.content.Intent;
import com.tencent.biz.pubaccount.weishi_new.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;

public class umz
{
  public static umw a(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt, Intent paramIntent)
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
          return new una(paramWSRedDotPushMsg);
          i = 0;
        }
        else if (i == 5)
        {
          return new umx(paramWSRedDotPushMsg);
        }
      }
      if (i == 2) {
        return new unb(paramWSRedDotPushMsg, paramInt, paramIntent);
      }
      if (i == 3) {
        return new unc(paramWSRedDotPushMsg, paramInt, paramIntent);
      }
      if (i == 4) {
        return new umy(paramWSRedDotPushMsg, paramInt);
      }
      if (paramInt == 2) {
        return new una(paramWSRedDotPushMsg);
      }
    } while (paramInt != 6);
    return new unb(paramWSRedDotPushMsg, paramInt, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     umz
 * JD-Core Version:    0.7.0.1
 */