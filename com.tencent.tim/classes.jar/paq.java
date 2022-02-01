import android.support.v7.widget.RecyclerView;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;

class paq
  implements ViewTreeObserver.OnPreDrawListener
{
  paq(pao parampao, int paramInt) {}
  
  public boolean onPreDraw()
  {
    pao.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    pao.a(this.a).scrollToPosition(this.val$pos);
    if ((pao.a(this.a) != null) && (pao.a(this.a) != null))
    {
      pao.a(this.a).setCurPicPos(this.val$pos, pao.a(this.a).images.size());
      QCircleContentOperationView.bgR = this.val$pos;
    }
    QLog.d("QCircleContentHorizontalAdapter", 1, "adjustEnterImageShowPos:" + this.val$pos);
    pao.a(this.a, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     paq
 * JD-Core Version:    0.7.0.1
 */