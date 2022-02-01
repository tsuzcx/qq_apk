import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity.d;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.widget.RandomCoverView;

final class aurb
  extends VasQuickUpdateManager.CallBacker
{
  aurb(BaseActivity paramBaseActivity, Card paramCard, RandomCoverView paramRandomCoverView, FrameHelperActivity.d paramd, boolean paramBoolean) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    aura.a(this.val$activity, paramVasQuickUpdateManager.app, this.c, this.a, this.b, this.djG);
    paramVasQuickUpdateManager.removeCallBacker(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aurb
 * JD-Core Version:    0.7.0.1
 */