import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agwe
  implements View.OnClickListener
{
  agwe(agwc paramagwc) {}
  
  public void onClick(View paramView)
  {
    int i = this.b.a.bK();
    if ((i == 2) || (i == 3))
    {
      i = ahbr.hP(this.b.a.getFileType());
      anot.a(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, i + "", "", "", "");
      if (this.b.a.a() != null) {
        this.b.a.a().iE();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((i == 1) && (this.b.a.a() != null)) {
        this.b.a.a().djp();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agwe
 * JD-Core Version:    0.7.0.1
 */