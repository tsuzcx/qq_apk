import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class axdx
  implements View.OnClickListener
{
  axdx(axdw paramaxdw, axdw.a parama, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (axdw.a(this.b) != this.a.getLayoutPosition()) {
      axim.a().acO(this.cTW);
    }
    if (axdw.a(this.b) == -1)
    {
      axdw.a(this.b).bG(this.cTW, ((axdl.a)axdl.colorList.get(0)).textColor, ((axdl.a)axdl.colorList.get(0)).cTQ);
      axdw.a(this.b).cU(true, false);
    }
    for (;;)
    {
      this.b.clearSelection();
      axdw.a(this.b, this.a.getLayoutPosition());
      ((axdk)axdw.a(this.b).get(axdw.a(this.b) - 1)).setSelected(true);
      this.a.setSelected(true);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      axdw.a(this.b).acq(this.cTW);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axdx
 * JD-Core Version:    0.7.0.1
 */