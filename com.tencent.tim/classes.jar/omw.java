import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class omw
  extends omr<WSRedDotPushMsg, WSPushStrategyInfo>
{
  private Intent mNewIntent;
  private int mScene;
  
  public omw(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt, Intent paramIntent)
  {
    super(paramWSRedDotPushMsg);
    this.mScene = paramInt;
    this.mNewIntent = paramIntent;
  }
  
  public boolean a(Context paramContext, WSPushStrategyInfo paramWSPushStrategyInfo)
  {
    boolean bool = false;
    if (this.mScene == 2)
    {
      WSVerticalPageFragment.a(paramContext, "aio_new_msg", "direct", null, 0);
      bool = true;
    }
    while (this.mScene != 6) {
      return bool;
    }
    ogj.a((Activity)paramContext, this.mNewIntent, (WSRedDotPushMsg)this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     omw
 * JD-Core Version:    0.7.0.1
 */