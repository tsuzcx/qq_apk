import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akqi
  implements View.OnClickListener
{
  akqi(akqe paramakqe, akqe.f paramf) {}
  
  public void onClick(View paramView)
  {
    akqe.a(this.c).removeMessages(101);
    akqe.a(this.c).obtainMessage(101).sendToTarget();
    this.a.a.dCS();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akqi
 * JD-Core Version:    0.7.0.1
 */