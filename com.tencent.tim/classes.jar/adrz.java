import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class adrz
  implements View.OnClickListener
{
  adrz(adrw paramadrw) {}
  
  public void onClick(View paramView)
  {
    ubu.a(adrw.a(this.a), -3, "user canceled");
    adrw.a(this.a).reset();
    adrw.a(this.a).dismiss();
    adrw.a(this.a, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adrz
 * JD-Core Version:    0.7.0.1
 */