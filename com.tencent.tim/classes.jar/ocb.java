import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ocb
  implements View.OnClickListener
{
  ocb(obw paramobw, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.this$0.bdz();
    this.this$0.apC = this.val$callback;
    this.this$0.G.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ocb
 * JD-Core Version:    0.7.0.1
 */