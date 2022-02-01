import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;

public class omt
  extends omr<WSRedDotPushMsg, WSPushStrategyInfo>
{
  private int mScene;
  
  public omt(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt)
  {
    super(paramWSRedDotPushMsg);
    this.mScene = paramInt;
  }
  
  public boolean a(Context paramContext, WSPushStrategyInfo paramWSPushStrategyInfo)
  {
    int i = 2;
    boolean bool1 = true;
    if (paramWSPushStrategyInfo == null) {
      return false;
    }
    boolean bool2 = TextUtils.isEmpty(paramWSPushStrategyInfo.mScheme);
    if (!bool2)
    {
      ogj.aM(paramContext, paramWSPushStrategyInfo.mScheme);
      paramContext = opn.a();
      if (paramContext != null) {
        paramContext.aI(null);
      }
      opn.bfZ();
    }
    if (this.mScene == 2) {
      if (bool2)
      {
        i = 2;
        if (this.a != null) {
          break label93;
        }
        paramContext = "";
        label74:
        ong.m(i, 1, paramContext);
        label80:
        if (bool2) {
          break label133;
        }
      }
    }
    for (;;)
    {
      return bool1;
      i = 1;
      break;
      label93:
      paramContext = ((WSRedDotPushMsg)this.a).mFeedIds;
      break label74;
      if (this.mScene != 6) {
        break label80;
      }
      if (bool2) {}
      for (;;)
      {
        ong.uP(i);
        break;
        i = 1;
      }
      label133:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     omt
 * JD-Core Version:    0.7.0.1
 */