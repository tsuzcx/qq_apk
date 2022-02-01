import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.QWalletHelper;

class antx
  implements View.OnClickListener
{
  antx(antu paramantu, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    QWalletHelper.gotoQWalletHome((Activity)this.val$context);
    zyd.l("public.tailplace.click", "", "", "2", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     antx
 * JD-Core Version:    0.7.0.1
 */