import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vdf
  implements View.OnClickListener
{
  vdf(vda paramvda) {}
  
  public void onClick(View paramView)
  {
    if (vda.a(this.a))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    vda.a(this.a, true);
    vda.a(this.a).setImageResource(2130843956);
    vda.a(this.a, (AnimationDrawable)vda.a(this.a).getDrawable());
    vda.a(this.a).start();
    if (vda.b(this.a)) {
      vda.c(this.a);
    }
    for (;;)
    {
      vtq.a("", 19, 5);
      break;
      vda.a(this.a).postDelayed(vda.a(this.a), 5000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdf
 * JD-Core Version:    0.7.0.1
 */