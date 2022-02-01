import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aguy
  implements View.OnClickListener
{
  aguy(aguu paramaguu, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.e != null)
    {
      if (this.nS != 1) {
        break label86;
      }
      anot.a(null, "dc00898", "", "", "0X800A745", "0X800A745", ahbr.hQ(this.this$0.getFileType()), 0, "", "", "", "");
      if (this.this$0.e.bO()) {
        this.this$0.e.is();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label86:
      if (this.nS == 2) {
        this.this$0.e.hV();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aguy
 * JD-Core Version:    0.7.0.1
 */