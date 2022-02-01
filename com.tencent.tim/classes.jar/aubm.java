import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aubm
  implements View.OnClickListener
{
  aubm(aubi paramaubi) {}
  
  public void onClick(View paramView)
  {
    atyz localatyz = this.b.a.a();
    if (localatyz != null) {
      localatyz.iE();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aubm
 * JD-Core Version:    0.7.0.1
 */