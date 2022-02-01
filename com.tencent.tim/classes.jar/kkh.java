import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class kkh
  implements View.OnClickListener
{
  kkh(kkg paramkkg) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.isUserClick = false;
    }
    kkg.a(this.a);
    kkg.a(this.a, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kkh
 * JD-Core Version:    0.7.0.1
 */