import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zmv
  implements View.OnClickListener
{
  zmv(zmq paramzmq) {}
  
  public void onClick(View paramView)
  {
    zmq.a(this.a, paramView);
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zmv
 * JD-Core Version:    0.7.0.1
 */