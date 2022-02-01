import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class shm
  implements View.OnClickListener
{
  shm(shk.c paramc, String paramString, ausj paramausj) {}
  
  public void onClick(View paramView)
  {
    this.a.g(false, this.val$uin, true);
    this.J.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     shm
 * JD-Core Version:    0.7.0.1
 */