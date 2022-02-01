import android.view.View;
import com.tencent.mobileqq.richstatus.comment.widget.LikesView;
import com.tencent.mobileqq.richstatus.comment.widget.LikesView.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class amhz
  extends amht
{
  public amhz(LikesView paramLikesView, int paramInt, String paramString)
  {
    super(paramInt);
  }
  
  public void onClick(View paramView)
  {
    if (LikesView.a(this.a) != null) {
      LikesView.a(this.a).onClick(this.val$uin);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amhz
 * JD-Core Version:    0.7.0.1
 */