import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akqj
  implements View.OnClickListener
{
  akqj(akqe paramakqe, akqe.f paramf) {}
  
  public void onClick(View paramView)
  {
    akqe.a(this.c).removeMessages(101);
    akqe.a(this.c).obtainMessage(101).sendToTarget();
    this.a.a.dCT();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akqj
 * JD-Core Version:    0.7.0.1
 */