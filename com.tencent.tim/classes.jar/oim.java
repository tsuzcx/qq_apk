import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;

final class oim
  implements DialogInterface.OnClickListener
{
  oim(Activity paramActivity, String paramString, WSDownloadParams paramWSDownloadParams, int paramInt1, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (rpw.isWeishiInstalled(this.val$activity))
    {
      opb.a(this.val$activity, "biz_src_jc_gzh_weishi", this.wT, this.b.mScene, this.b.mLinkStrategyType, this.b.mEventId);
      ond.a(114, this.val$pageType, this.bfc, null);
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      ong.X(112, 1, 0);
      return;
      if (this.b.mStReportItem == null) {
        this.b.mStReportItem = ond.getInitialReportItem();
      }
      this.b.mStReportItem.downloadscene = oir.e(this.b.mScene, this.b.mLinkStrategyType, this.b.mEventId);
      this.b.mStReportItem.comment_loctaion = this.bfc;
      oir.c(this.val$activity, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oim
 * JD-Core Version:    0.7.0.1
 */