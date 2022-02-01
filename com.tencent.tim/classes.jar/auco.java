import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class auco
  implements View.OnClickListener
{
  auco(aucj paramaucj) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.a() != null) {
      this.a.a.a().iE();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auco
 * JD-Core Version:    0.7.0.1
 */