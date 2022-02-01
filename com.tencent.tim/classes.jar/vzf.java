import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vzf
  implements View.OnClickListener
{
  public vzf(TroopInfoActivity paramTroopInfoActivity, Dialog paramDialog, long paramLong1, int paramInt, long paramLong2, long paramLong3, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((this.val$dialog != null) && (this.val$dialog.isShowing()) && (this.val$dialog.getWindow() != null)) {
      this.val$dialog.dismiss();
    }
    this.this$0.finish();
    this.this$0.d.a(this.Hg, this.this$0.a.troopName, this.this$0.a.dwGroupClassExt, this.this$0.a.troopTags, this.bLB, this.Hh, this.Hi, this.this$0.a.mPoiId, this.aQx, this.this$0.a.mRichFingerMemo);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vzf
 * JD-Core Version:    0.7.0.1
 */