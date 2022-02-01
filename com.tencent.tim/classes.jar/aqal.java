import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqal
  implements View.OnClickListener
{
  aqal(aqai paramaqai, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    arwt.i("NewUpgradeDialog", arud.b(10010, aqai.access$000(), 2, 200));
    arub.a().postReport(17, arud.b(10010, aqai.access$000(), 2, 200));
    if (aqai.access$000() == 2) {
      anot.a(null, "dc00898", "", "", "0X8008F80", "0X8008F80", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.W != null) {
        this.W.onClick(this.this$0, 0);
      }
      if (this.cTm)
      {
        aryy.a().b(aqai.a(this.this$0));
        this.this$0.dismiss();
      }
      aqai.a(this.this$0, true);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      anot.a(null, "dc00898", "", "", "0X8008F83", "0X8008F83", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqal
 * JD-Core Version:    0.7.0.1
 */