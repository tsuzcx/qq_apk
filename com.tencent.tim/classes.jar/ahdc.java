import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahdc
  implements View.OnClickListener
{
  ahdc(ahdb paramahdb) {}
  
  public void onClick(View paramView)
  {
    if (!this.this$0.cgf)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    int i = 4;
    if (ahdb.a(this.this$0) == 1)
    {
      i = 2;
      label33:
      if (!ahdb.a(this.this$0).equals(acbn.bkw)) {
        break label142;
      }
      i = 3;
    }
    label142:
    for (;;)
    {
      long l = agmz.fN();
      anot.a(null, "dc00898", "", "", "0X800AA92", "0X800AA92", i, 0, "" + l, "0", "", "");
      if (ahdb.a(this.this$0) == 1)
      {
        ahdb.a(this.this$0);
        break;
        if (ahdb.a(this.this$0) != 0) {
          break label33;
        }
        i = 1;
        break label33;
      }
      ahdb.b(this.this$0);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahdc
 * JD-Core Version:    0.7.0.1
 */