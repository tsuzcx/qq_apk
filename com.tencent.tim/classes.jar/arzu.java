import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class arzu
  implements View.OnClickListener
{
  arzu(arzs paramarzs, DialogInterface.OnClickListener paramOnClickListener, int paramInt, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (this.val$pl != null) {
      this.val$pl.onClick(this.this$0, this.els);
    }
    if (this.cTm) {
      this.this$0.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arzu
 * JD-Core Version:    0.7.0.1
 */