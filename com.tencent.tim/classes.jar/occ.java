import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class occ
  implements View.OnClickListener
{
  occ(obw paramobw, int paramInt1, int paramInt2, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.this$0.dx(this.val$count, this.bei);
    this.this$0.apC = this.val$callback;
    this.this$0.G.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     occ
 * JD-Core Version:    0.7.0.1
 */