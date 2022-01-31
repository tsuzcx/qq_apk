import android.view.View;
import android.widget.ListView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;

class tvj
  implements yhn
{
  tvj(tuz paramtuz) {}
  
  public void a(View paramView, int paramInt1, int paramInt2, Object paramObject)
  {
    QLog.d("QCircleCommentPanelView", 1, "onClick, pageId: " + tzy.a().a() + "  parentPageId: " + tzy.a().b());
    switch (paramInt1)
    {
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 12: 
    default: 
    case 2: 
    case 1: 
    case 4: 
    case 13: 
    case 7: 
    case 10: 
    case 11: 
      do
      {
        do
        {
          return;
          if ((paramObject instanceof FeedCloudMeta.StUser))
          {
            QLog.d("QCircleCommentPanelView", 1, "onClick nickName, feedId: " + tuz.a(this.a).id + " userId: " + ((FeedCloudMeta.StUser)paramObject).id.get());
            tqs.a(new tqo().a((FeedCloudMeta.StUser)paramObject).a(), null);
          }
          if (tzy.a().d(57))
          {
            tzw.a(15, 2, tuz.a(this.a));
            return;
          }
          tzs.a(15, 2, tuz.a(this.a));
          return;
          if ((paramObject instanceof FeedCloudMeta.StUser))
          {
            QLog.d("QCircleCommentPanelView", 1, "onClick avatar, feedId: " + tuz.a(this.a).id + " userId: " + ((FeedCloudMeta.StUser)paramObject).id.get());
            tqs.a(new tqo().a((FeedCloudMeta.StUser)paramObject).a(), null);
          }
          if (tzy.a().d(57))
          {
            tzw.a(14, 2, tuz.a(this.a));
            return;
          }
          tzs.a(14, 2, tuz.a(this.a));
          return;
          if ((paramObject instanceof FeedCloudMeta.StComment))
          {
            paramView = (FeedCloudMeta.StComment)paramObject;
            QLog.d("QCircleCommentPanelView", 1, "onClick comment, feedId: " + tuz.a(this.a).id + " commentId: " + paramView.id);
            tuz.a(this.a, paramView, null);
          }
          if (tzy.a().d(57)) {
            tzw.a(11, 2, tuz.a(this.a));
          }
          for (;;)
          {
            tuz.a(this.a, 11);
            return;
            tzs.a(11, 2, tuz.a(this.a));
          }
          if ((paramObject instanceof FeedCloudMeta.StComment))
          {
            paramView = (FeedCloudMeta.StComment)paramObject;
            QLog.d("QCircleCommentPanelView", 1, "onClick replyTextButton, feedId: " + tuz.a(this.a).id + " commentId: " + paramView.id);
            tuz.a(this.a, paramView, null);
          }
          if (tzy.a().d(57)) {
            tzw.a(13, 2, tuz.a(this.a));
          }
          for (;;)
          {
            tuz.a(this.a, 13);
            return;
            tzs.a(13, 2, tuz.a(this.a));
          }
          if ((paramObject instanceof Object[]))
          {
            paramObject = (Object[])paramObject;
            if ((paramObject.length > 1) && (paramObject[0] != null) && (paramObject[1] != null) && ((paramObject[0] instanceof FeedCloudMeta.StComment)) && ((paramObject[1] instanceof FeedCloudMeta.StReply)))
            {
              paramView = (FeedCloudMeta.StComment)paramObject[0];
              paramObject = (FeedCloudMeta.StReply)paramObject[1];
              QLog.d("QCircleCommentPanelView", 1, "onClick reply, feedId: " + tuz.a(this.a).id + " commentId: " + paramView.id + " replyId: " + paramObject.id);
              tuz.a(this.a, paramView, paramObject);
            }
          }
          if (tzy.a().d(57)) {
            tzw.a(12, 2, tuz.a(this.a));
          }
          for (;;)
          {
            tuz.a(this.a, 12);
            return;
            tzs.a(12, 2, tuz.a(this.a));
          }
          if ((paramObject instanceof FeedCloudMeta.StComment))
          {
            paramView = (FeedCloudMeta.StComment)paramObject;
            tuz.a(this.a).c(paramView);
            QLog.d("QCircleCommentPanelView", 1, "onClick more reply, feedId: " + tuz.a(this.a).id + " commentId: " + paramView.id);
          }
          if (tzy.a().d(57))
          {
            tzw.a(52, 2, tuz.a(this.a));
            return;
          }
          tzs.a(52, 2, tuz.a(this.a));
          return;
        } while (!(paramObject instanceof Object[]));
        paramView = (Object[])paramObject;
      } while ((paramView.length <= 1) || (paramView[0] == null));
      paramObject = (FeedCloudMeta.StComment)paramView[0];
      paramInt1 = tuz.a(this.a).a(paramObject);
      if ((paramInt1 >= 0) && (paramView[1] != null))
      {
        int i = ((Integer)paramView[1]).intValue();
        this.a.a.setSelectionFromTop(paramInt2, i * (paramInt1 * -1));
      }
      QLog.d("QCircleCommentPanelView", 1, "onClick less reply, feedId: " + tuz.a(this.a).id + " commentId: " + paramObject.id);
      return;
    case 14: 
      if (tzy.a().d(57))
      {
        tzw.a(50, 2, tuz.a(this.a));
        return;
      }
      tzs.a(50, 2, tuz.a(this.a));
      return;
    }
    if (tzy.a().d(57))
    {
      tzw.a(51, 2, tuz.a(this.a));
      return;
    }
    tzs.a(51, 2, tuz.a(this.a));
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, Object paramObject)
  {
    QLog.d("QCircleCommentPanelView", 1, "onLongClick, pageId: " + tzy.a().a() + "  parentPageId: " + tzy.a().b());
    tvk localtvk = new tvk(this);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramObject instanceof FeedCloudMeta.StComment));
        tuz.a(this.a, 45);
        paramObject = (FeedCloudMeta.StComment)paramObject;
        QLog.d("QCircleCommentPanelView", 1, "onLongClick comment, feedId: " + tuz.a(this.a).id + " commentId: " + paramObject.id);
        tqt.a().a(paramView, tuz.a(this.a), paramObject, new tvl(this, paramObject), localtvk);
        return;
      } while (!(paramObject instanceof Object[]));
      localObject = (Object[])paramObject;
    } while ((localObject.length <= 1) || (localObject[0] == null) || (localObject[1] == null) || (!(localObject[0] instanceof FeedCloudMeta.StComment)) || (!(localObject[1] instanceof FeedCloudMeta.StReply)));
    paramObject = (FeedCloudMeta.StComment)localObject[0];
    Object localObject = (FeedCloudMeta.StReply)localObject[1];
    QLog.d("QCircleCommentPanelView", 1, "onLongClick reply, feedId: " + tuz.a(this.a).id + " commentId: " + paramObject.id + " replyId: " + ((FeedCloudMeta.StReply)localObject).id.get());
    tqt.a().a(paramView, tuz.a(this.a), (FeedCloudMeta.StReply)localObject, new tvs(this, (FeedCloudMeta.StReply)localObject, paramObject), localtvk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tvj
 * JD-Core Version:    0.7.0.1
 */