import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class jwp
  implements View.OnClickListener
{
  public jwp(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    if ((this.val$dialog != null) && (this.val$dialog.isShowing()) && (this.val$dialog.getWindow() != null)) {
      this.val$dialog.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jwp
 * JD-Core Version:    0.7.0.1
 */