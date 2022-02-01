import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.biz.qqcircle.widgets.QCircleFeedCommentWidget;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

public class pfe
  implements ouy.a
{
  public pfe(QCircleFeedCommentWidget paramQCircleFeedCommentWidget, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment) {}
  
  public void onClick(int paramInt)
  {
    if (this.a.getContext() == null) {
      QLog.e("QCircleFeedCommentWidge", 1, "onSticky mContext is null");
    }
    Object localObject;
    do
    {
      do
      {
        return;
        if (paramInt == ouy.b.bgp)
        {
          if (QCircleFeedCommentWidget.a(this.a).a(this.k, this.f))
          {
            localObject = this.a.getContext().getString(2131700168);
            aqha.a(this.a.getContext(), 230, (String)localObject, null, 2131721058, 2131691042, new pff(this), new pfg(this)).show();
            return;
          }
          QCircleFeedCommentWidget.a(this.a).b(this.k, this.f);
          return;
        }
        if (paramInt == ouy.b.bgq)
        {
          localObject = this.a.getContext().getString(2131700070);
          aqha.a(this.a.getContext(), 230, (String)localObject, null, 2131721058, 2131691042, new pfh(this), new pfi(this)).show();
          return;
        }
        if (paramInt != ouy.b.bgr) {
          break;
        }
        localObject = (ClipboardManager)this.a.getContext().getSystemService("clipboard");
      } while (localObject == null);
      ClipData localClipData = ClipData.newPlainText("", this.f.content.get());
      alkw.a((ClipboardManager)localObject, localClipData);
      ((ClipboardManager)localObject).setPrimaryClip(localClipData);
      return;
    } while (paramInt != ouy.b.bgt);
    if (ovd.a((FeedCloudMeta.StUser)this.f.postUser.get())) {}
    for (paramInt = 0;; paramInt = 2)
    {
      localObject = this.a.getContext().getString(2131700074);
      aqha.a(this.a.getContext(), 230, (String)localObject, null, 2131721058, 2131691042, new pfj(this, paramInt), new pfk(this)).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pfe
 * JD-Core Version:    0.7.0.1
 */