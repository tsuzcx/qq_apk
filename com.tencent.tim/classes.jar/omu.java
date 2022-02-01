import android.content.Intent;
import com.tencent.biz.pubaccount.weishi_new.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;

public class omu
{
  public static omr a(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt, Intent paramIntent)
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
          return new omv(paramWSRedDotPushMsg);
          i = 0;
        }
        else if (i == 5)
        {
          return new oms(paramWSRedDotPushMsg);
        }
      }
      if (i == 2) {
        return new omw(paramWSRedDotPushMsg, paramInt, paramIntent);
      }
      if (i == 3) {
        return new omx(paramWSRedDotPushMsg, paramInt, paramIntent);
      }
      if (i == 4) {
        return new omt(paramWSRedDotPushMsg, paramInt);
      }
      if (paramInt == 2) {
        return new omv(paramWSRedDotPushMsg);
      }
    } while (paramInt != 6);
    return new omw(paramWSRedDotPushMsg, paramInt, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     omu
 * JD-Core Version:    0.7.0.1
 */