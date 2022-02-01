import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vbp
  implements View.OnClickListener
{
  vbp(vbk paramvbk) {}
  
  public void onClick(View paramView)
  {
    if (vbk.a(this.a))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    vbk.a(this.a, true);
    vbk.a(this.a).setImageResource(2130843939);
    vbk.a(this.a, (AnimationDrawable)vbk.a(this.a).getDrawable());
    vbk.a(this.a).start();
    if (vbk.b(this.a)) {
      vbk.c(this.a);
    }
    for (;;)
    {
      vrf.a("", 19, 5);
      break;
      vbk.a(this.a).postDelayed(vbk.a(this.a), 5000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbp
 * JD-Core Version:    0.7.0.1
 */