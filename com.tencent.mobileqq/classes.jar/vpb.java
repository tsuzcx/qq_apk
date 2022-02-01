import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vpb
  implements View.OnClickListener
{
  vpb(vow paramvow) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.callOnClick();
    }
    vba localvba = vow.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder().append("tvTime getFeedCommentInfo is");
    if (localvba != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QCircleReplyMessagePresenter", 1, bool);
      if (localvba != null) {
        vow.a(this.a, localvba, 2);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vpb
 * JD-Core Version:    0.7.0.1
 */