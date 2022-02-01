import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class juw
  implements View.OnClickListener
{
  juw(juk paramjuk, String paramString, jzs.a parama) {}
  
  public void onClick(View paramView)
  {
    juk.c(this.b, this.val$url);
    juk.a(this.b, this.a.title);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     juw
 * JD-Core Version:    0.7.0.1
 */