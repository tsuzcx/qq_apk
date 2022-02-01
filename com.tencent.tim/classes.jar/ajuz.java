import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajuz
  implements View.OnClickListener
{
  ajuz(ajuy paramajuy) {}
  
  public void onClick(View paramView)
  {
    if (ajuy.a(this.a) != null) {
      ajuy.a(this.a).km(ajuy.a(this.a));
    }
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajuz
 * JD-Core Version:    0.7.0.1
 */