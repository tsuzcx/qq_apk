import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class actc
  implements View.OnClickListener
{
  actc(acsz paramacsz) {}
  
  public void onClick(View paramView)
  {
    anot.a(null, "dc00898", "", "", "0X8009ACD", "0X8009ACD", 0, 0, "", "", "", "");
    this.b.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     actc
 * JD-Core Version:    0.7.0.1
 */