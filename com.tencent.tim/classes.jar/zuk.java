import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

class zuk
  implements View.OnClickListener
{
  zuk(zug paramzug) {}
  
  public void onClick(View paramView)
  {
    ((NewPhotoPreviewActivity)this.this$0.mActivity).sendBtn.setClickable(false);
    if (((NewPhotoPreviewActivity)this.this$0.mActivity).getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false)) {
      if (ahav.amK()) {
        ahal.a(this.this$0.mActivity, 2131693826, 2131693832, new zul(this));
      }
    }
    for (;;)
    {
      LpReportInfo_pf00064.allReport(603, 1);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.submit();
      continue;
      this.this$0.submit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zuk
 * JD-Core Version:    0.7.0.1
 */