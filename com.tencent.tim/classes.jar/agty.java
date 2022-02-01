import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agty
  implements View.OnClickListener
{
  agty(agts paramagts, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.a.e != null)
    {
      if (this.nS != 1) {
        break label86;
      }
      anot.a(null, "dc00898", "", "", "0X800A745", "0X800A745", ahbr.hQ(this.a.getFileType()), 0, "", "", "", "");
      if (this.a.e.bO()) {
        this.a.e.is();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label86:
      if (this.nS == 2) {
        this.a.e.hV();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agty
 * JD-Core Version:    0.7.0.1
 */