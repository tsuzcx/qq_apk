import com.tencent.biz.qqcircle.widgets.QCircleFollowTagView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import feedcloud.FeedCloudMeta.StTagInfo;
import qqcircle.QQCircleWrite.DoFollowTagRsp;

public class pft
  implements rxc.a<QQCircleWrite.DoFollowTagRsp>
{
  public pft(QCircleFollowTagView paramQCircleFollowTagView, int paramInt, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QQCircleWrite.DoFollowTagRsp paramDoFollowTagRsp)
  {
    boolean bool = true;
    if ((paramBoolean) && (paramLong == 0L))
    {
      this.a.vt(this.bio);
      if (QCircleFollowTagView.a(this.a) != null)
      {
        QCircleFollowTagView.h(this.a.getContext(), QCircleFollowTagView.a(this.a).tagId.get(), this.bio);
        paramString = pbz.a();
        paramDoFollowTagRsp = QCircleFollowTagView.a(this.a).tagId.get();
        if (this.bio != 1) {
          break label101;
        }
      }
      label101:
      for (paramBoolean = bool;; paramBoolean = false)
      {
        paramString.as(paramDoFollowTagRsp, paramBoolean);
        return;
      }
    }
    paramString = this.a.getContext();
    if (this.tT) {}
    for (int i = 2131700109;; i = 2131700184)
    {
      QQToast.a(paramString, i, 0).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pft
 * JD-Core Version:    0.7.0.1
 */