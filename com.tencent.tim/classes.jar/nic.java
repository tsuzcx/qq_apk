import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nic
  implements View.OnClickListener
{
  nic(nib paramnib) {}
  
  public void onClick(View paramView)
  {
    if (nib.a(this.a) != null) {
      nib.a(this.a).onClick(paramView);
    }
    kxm.b localb = new kxm.b();
    localb.i().f().g().c().j().n();
    localb.b("message_reddot_style", kxm.nX());
    kbp.a(null, "", "0X800824B", "0X800824B", 0, 0, "", "", "", localb.build(), false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nic
 * JD-Core Version:    0.7.0.1
 */