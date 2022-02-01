import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class arzv
  implements View.OnClickListener
{
  arzv(arzs paramarzs, DialogInterface.OnClickListener paramOnClickListener, int paramInt, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (this.val$nl != null) {
      this.val$nl.onClick(this.this$0, this.els);
    }
    if (this.cTm) {
      this.this$0.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arzv
 * JD-Core Version:    0.7.0.1
 */