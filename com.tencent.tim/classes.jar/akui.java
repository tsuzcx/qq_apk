import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.location.ui.LocationMapWidget;
import com.tencent.mobileqq.onlinestatus.location.OnlineStatusLocationFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akui
  implements View.OnClickListener
{
  public akui(OnlineStatusLocationFragment paramOnlineStatusLocationFragment) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusLocationFragment", 2, "myBtn onClick: invoked. set my btn black");
    }
    this.this$0.AX.setClickable(false);
    this.this$0.AX.setImageDrawable(this.this$0.getActivity().getResources().getDrawable(2130841358));
    OnlineStatusLocationFragment.a(this.this$0).Lv(true);
    OnlineStatusLocationFragment.a(this.this$0, OnlineStatusLocationFragment.a(this.this$0).c());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akui
 * JD-Core Version:    0.7.0.1
 */