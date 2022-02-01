import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akoh
  implements View.OnClickListener
{
  akoh(akog paramakog) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && ((paramView.getTag() instanceof akog.a)))
    {
      akog.a locala = (akog.a)paramView.getTag();
      this.a.a.a(locala);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akoh
 * JD-Core Version:    0.7.0.1
 */