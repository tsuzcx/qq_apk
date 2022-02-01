import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class jvk
  implements View.OnClickListener
{
  jvk(juk paramjuk, jzs.a parama) {}
  
  public void onClick(View paramView)
  {
    juk.a(this.b);
    juk.a(this.b, this.a.title);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jvk
 * JD-Core Version:    0.7.0.1
 */