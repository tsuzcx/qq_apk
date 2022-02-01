import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zmu
  implements View.OnClickListener
{
  zmu(zmq paramzmq) {}
  
  public void onClick(View paramView)
  {
    zmq.a(this.a).setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zmu
 * JD-Core Version:    0.7.0.1
 */