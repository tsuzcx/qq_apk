import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class afhh
  implements View.OnClickListener
{
  afhh(afhf paramafhf, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    if ((!((Activity)this.this$0.mContext).isFinishing()) && (this.an.isShowing())) {
      this.an.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afhh
 * JD-Core Version:    0.7.0.1
 */