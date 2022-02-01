import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ssb
  implements View.OnClickListener
{
  ssb(ssa paramssa, int paramInt, VsMusicItemInfo paramVsMusicItemInfo) {}
  
  public void onClick(View paramView)
  {
    if (ssa.a(this.b) != null) {
      ssa.a(this.b).a(this.val$position, this.c);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ssb
 * JD-Core Version:    0.7.0.1
 */