import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqam
  implements View.OnClickListener
{
  aqam(aqai paramaqai) {}
  
  public void onClick(View paramView)
  {
    switch (aqai.a(this.this$0))
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      arwt.d("NewUpgradeDialog", "onclick right btn  state = STATE_INIT");
      aqai.a(this.this$0);
      continue;
      aqai.b(this.this$0);
      arwt.d("NewUpgradeDialog", "onclick right btn  state = STATE_COMPLETE");
      continue;
      arwt.d("NewUpgradeDialog", "onclick right btn  state = STATE_CANCEL");
      continue;
      aqai.c(this.this$0);
      arwt.d("NewUpgradeDialog", "onclick right btn  state = STATE_PAUSE");
      continue;
      this.this$0.ecS();
      arwt.d("NewUpgradeDialog", "onclick right btn  state = STATE_DOWNLOADING");
      continue;
      arwt.d("NewUpgradeDialog", "onclick right btn  state = STATE_WAIT");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqam
 * JD-Core Version:    0.7.0.1
 */