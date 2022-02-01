import android.view.View;
import com.tencent.mobileqq.richstatus.comment.widget.CommentsView;
import com.tencent.mobileqq.richstatus.comment.widget.CommentsView.c;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class amhx
  extends amht
{
  public amhx(CommentsView paramCommentsView, int paramInt, String paramString)
  {
    super(paramInt);
  }
  
  public void onClick(View paramView)
  {
    if (CommentsView.a(this.a) != null) {
      CommentsView.a(this.a).PC(this.val$uin);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amhx
 * JD-Core Version:    0.7.0.1
 */