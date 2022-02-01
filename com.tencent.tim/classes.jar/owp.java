import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class owp
  implements View.OnClickListener
{
  owp(owk paramowk) {}
  
  public void onClick(View paramView)
  {
    if (owk.a(this.this$0))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    owk.a(this.this$0, true);
    owk.a(this.this$0).setImageResource(2130844827);
    owk.a(this.this$0, (AnimationDrawable)owk.a(this.this$0).getDrawable());
    owk.a(this.this$0).start();
    if (owk.b(this.this$0)) {
      owk.c(this.this$0);
    }
    for (;;)
    {
      pco.h("", 19, 5L);
      break;
      owk.a(this.this$0).postDelayed(owk.a(this.this$0), 5000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     owp
 * JD-Core Version:    0.7.0.1
 */