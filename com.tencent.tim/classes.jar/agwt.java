import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agwt
  implements View.OnClickListener
{
  agwt(agws paramagws) {}
  
  public void onClick(View paramView)
  {
    int i = ahbr.hP(this.a.a.getFileType());
    anot.a(null, "dc00898", "", "", "0X800A689", "0X800A689", 0, 0, i + "", "", "", "");
    this.a.a.iD();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agwt
 * JD-Core Version:    0.7.0.1
 */