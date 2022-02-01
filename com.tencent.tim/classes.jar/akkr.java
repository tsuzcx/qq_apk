import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akkr
  implements View.OnClickListener
{
  akkr(akkq paramakkq) {}
  
  public void onClick(View paramView)
  {
    if (((paramView.getTag() instanceof akkq.a)) && (this.a.b != null))
    {
      akkq.a locala = (akkq.a)paramView.getTag();
      this.a.b.a(this.a, paramView, locala);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akkr
 * JD-Core Version:    0.7.0.1
 */