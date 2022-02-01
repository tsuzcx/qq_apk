import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uyc
  implements View.OnClickListener
{
  uyc(uyb paramuyb) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    uyb.a(this.a, (zam.a)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uyc
 * JD-Core Version:    0.7.0.1
 */