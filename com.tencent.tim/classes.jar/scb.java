import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class scb
  implements View.OnClickListener
{
  public scb(CommentBottomBar paramCommentBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (!aqiw.isNetworkAvailable(this.b.getContext())) {
      QQToast.a(this.b.getContext(), acfp.m(2131696276), 0).show();
    }
    this.b.Hx();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     scb
 * JD-Core Version:    0.7.0.1
 */