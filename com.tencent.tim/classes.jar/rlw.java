import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class rlw
  implements View.OnClickListener
{
  rlw(rlv paramrlv, rlv.a parama) {}
  
  public void onClick(View paramView)
  {
    if (rlv.a(this.this$0) != null) {
      rlv.a(this.this$0).a((SlideItemInfo)this.a.ir.getTag());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rlw
 * JD-Core Version:    0.7.0.1
 */