import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aubk
  implements View.OnClickListener
{
  aubk(aubi paramaubi) {}
  
  public void onClick(View paramView)
  {
    int i = this.b.a.bK();
    if ((i == 2) || (i == 3)) {
      if (this.b.a.a() != null) {
        this.b.a.a().iE();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((i == 1) && (this.b.a.a() != null)) {
        this.b.a.a().djp();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aubk
 * JD-Core Version:    0.7.0.1
 */