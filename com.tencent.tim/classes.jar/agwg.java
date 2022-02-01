import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agwg
  implements View.OnClickListener
{
  agwg(agwc paramagwc) {}
  
  public void onClick(View paramView)
  {
    int i = ahbr.hP(this.b.a.getFileType());
    anot.a(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, i + "", "", "", "");
    agss localagss = this.b.a.a();
    if (localagss != null) {
      localagss.iE();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agwg
 * JD-Core Version:    0.7.0.1
 */