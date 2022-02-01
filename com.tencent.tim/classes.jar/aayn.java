import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aayn
  implements View.OnClickListener
{
  aayn(aaym paramaaym) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    aaym.a(this.a, (zam.a)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aayn
 * JD-Core Version:    0.7.0.1
 */