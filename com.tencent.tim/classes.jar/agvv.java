import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agvv
  implements View.OnClickListener
{
  agvv(agvt paramagvt) {}
  
  public void onClick(View paramView)
  {
    int i = ahbr.hP(this.a.a.getFileType());
    anot.a(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, i + "", "", "", "");
    agss localagss = this.a.a.a();
    if (localagss != null) {
      localagss.iE();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agvv
 * JD-Core Version:    0.7.0.1
 */