import android.app.Activity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;

class ahkk
  implements swh.a
{
  ahkk(ahki paramahki) {}
  
  public void onBackPressed(boolean paramBoolean)
  {
    if (ForwardRecentActivity.class.isInstance(this.this$0.mActivity)) {
      if (!this.this$0.mActivity.isFinishing())
      {
        if (!paramBoolean) {
          break label75;
        }
        this.this$0.P(0, "", "");
      }
    }
    for (;;)
    {
      if (this.this$0.chk) {
        ahki.a(this.this$0.mActivity, true, "shareToQQ", this.this$0.mShareAppId);
      }
      return;
      label75:
      this.this$0.P(-1, arxo.cCT, arxo.cCT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahkk
 * JD-Core Version:    0.7.0.1
 */