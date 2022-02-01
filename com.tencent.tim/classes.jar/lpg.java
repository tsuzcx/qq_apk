import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class lpg
  implements View.OnAttachStateChangeListener
{
  lpg(lot paramlot, lie paramlie, VideoView paramVideoView, lot.a parama, BroadcastReceiver paramBroadcastReceiver) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    ndi localndi = this.b.b();
    lph locallph = new lph(this);
    localndi.b(locallph);
    paramView.setTag(2131376751, locallph);
    paramView = new IntentFilter();
    paramView.addAction("android.media.VOLUME_CHANGED_ACTION");
    BaseApplicationImpl.getApplication().getBaseContext().registerReceiver(this.al, paramView);
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    this.jdField_a_of_type_Lot$a.set(false);
    ndi localndi = this.b.b();
    paramView = (ndc)paramView.getTag(2131376751);
    if (paramView != null) {
      localndi.c(paramView);
    }
    try
    {
      BaseApplicationImpl.getApplication().getBaseContext().unregisterReceiver(this.al);
      return;
    }
    catch (Exception paramView)
    {
      QLog.e("PgcShortContentProteusItem", 2, QLog.getStackTraceString(paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lpg
 * JD-Core Version:    0.7.0.1
 */