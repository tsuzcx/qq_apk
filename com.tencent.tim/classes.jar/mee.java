import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class mee
  implements View.OnClickListener
{
  mee(med parammed, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onClick(View paramView)
  {
    String str = String.format("https://viola.qq.com/js/redpackIndex.js?_rij_violaUrl=1&hideNav=1&statusColor=1&statusBarStyle=1&v_nav_immer=1&v_tid=6&v_bundleName=redpackIndex&v_bid=3740&redpack_type=%d&plat_source=%d&jump_source=%d", new Object[] { Integer.valueOf(this.aQC), Integer.valueOf(this.aQD), Integer.valueOf(this.aQE) });
    kxm.aJ(paramView.getContext(), str);
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mee
 * JD-Core Version:    0.7.0.1
 */