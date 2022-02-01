import android.app.Activity;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils.OnShareListener;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;

class aswp
  implements MiniProgramShareUtils.OnShareListener
{
  aswp(aswo paramaswo, InnerShareData paramInnerShareData) {}
  
  public void onShared(boolean paramBoolean1, boolean paramBoolean2)
  {
    InnerShareData localInnerShareData;
    Activity localActivity;
    if (paramBoolean1)
    {
      localInnerShareData = this.val$shareData;
      localActivity = this.val$shareData.fromActivity;
      if (!paramBoolean2) {
        break label35;
      }
    }
    label35:
    for (int i = 0;; i = 1)
    {
      localInnerShareData.notifyShareResult(localActivity, i, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aswp
 * JD-Core Version:    0.7.0.1
 */