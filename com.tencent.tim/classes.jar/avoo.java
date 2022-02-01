import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class avoo
  implements View.OnClickListener
{
  avoo(avom paramavom) {}
  
  public void onClick(View paramView)
  {
    if (avom.a(this.b))
    {
      if (avom.b(this.b)) {
        this.b.dismiss();
      }
      if (avom.b(this.b) != null) {
        avom.b(this.b).onClick(paramView);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avoo
 * JD-Core Version:    0.7.0.1
 */