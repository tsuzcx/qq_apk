import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class umq
  implements View.OnClickListener
{
  umq(ump paramump) {}
  
  public void onClick(View paramView)
  {
    uks.a(ump.a(this.a), 1000, null);
    uvp.a((Activity)ump.a(this.a), ump.a(this.a), ump.a(this.a).a(), ump.a(this.a).e(), false, ukr.b(ump.a(this.a)), new ufu());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     umq
 * JD-Core Version:    0.7.0.1
 */