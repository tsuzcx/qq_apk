import android.view.View;
import android.widget.ListView;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;

class tuu
  implements yde
{
  tuu(tuk paramtuk) {}
  
  public void a(View paramView, int paramInt1, int paramInt2, Object paramObject)
  {
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
          do
          {
            return;
            if ((paramObject instanceof FeedCloudMeta.StUser)) {
              tqs.b(new tqo().a((FeedCloudMeta.StUser)paramObject).a(), null);
            }
            if (tym.a().d(57))
            {
              tyk.a(15, 2, tuk.a(this.a));
              return;
            }
            tyg.a(15, 2, tuk.a(this.a));
            return;
            if ((paramObject instanceof FeedCloudMeta.StUser)) {
              tqs.b(new tqo().a((FeedCloudMeta.StUser)paramObject).a(), null);
            }
            if (tym.a().d(57))
            {
              tyk.a(14, 2, tuk.a(this.a));
              return;
            }
            tyg.a(14, 2, tuk.a(this.a));
            return;
            if ((paramObject instanceof FeedCloudMeta.StComment))
            {
              paramView = (FeedCloudMeta.StComment)paramObject;
              QLog.d(tuk.a(), 1, "click comment, feedId: " + tuk.a(this.a).id + " commentId: " + paramView.id);
              tuk.a(this.a, paramView, null);
            }
            if (tym.a().d(57)) {
              tyk.a(11, 2, tuk.a(this.a));
            }
            for (;;)
            {
              tuk.a(this.a, 11);
              return;
              tyg.a(11, 2, tuk.a(this.a));
            }
            if ((paramObject instanceof FeedCloudMeta.StComment))
            {
              paramView = (FeedCloudMeta.StComment)paramObject;
              QLog.d(tuk.a(), 1, "click comment, feedId: " + tuk.a(this.a).id + " commentId: " + paramView.id);
              tuk.a(this.a, paramView, null);
            }
            if (tym.a().d(57)) {
              tyk.a(13, 2, tuk.a(this.a));
            }
            for (;;)
            {
              tuk.a(this.a, 13);
              return;
              tyg.a(13, 2, tuk.a(this.a));
            }
            if ((paramObject instanceof Object[]))
            {
              paramObject = (Object[])paramObject;
              if ((paramObject.length > 1) && (paramObject[0] != null) && (paramObject[1] != null) && ((paramObject[0] instanceof FeedCloudMeta.StComment)) && ((paramObject[1] instanceof FeedCloudMeta.StReply)))
              {
                paramView = (FeedCloudMeta.StComment)paramObject[0];
                paramObject = (FeedCloudMeta.StReply)paramObject[1];
                QLog.d(tuk.a(), 1, "click reply, feedId: " + tuk.a(this.a).id + " commentId: " + paramView.id + " replyId: " + paramObject.id);
                tuk.a(this.a, paramView, paramObject);
              }
            }
            if (tym.a().d(57)) {
              tyk.a(12, 2, tuk.a(this.a));
            }
            for (;;)
            {
              tuk.a(this.a, 12);
              return;
              tyg.a(12, 2, tuk.a(this.a));
            }
            if ((paramObject instanceof FeedCloudMeta.StComment))
            {
              paramView = (FeedCloudMeta.StComment)paramObject;
              tuk.a(this.a).c(paramView);
            }
            if (tym.a().d(57))
            {
              tyk.a(52, 2, tuk.a(this.a));
              return;
            }
            tyg.a(52, 2, tuk.a(this.a));
            return;
          } while (!(paramObject instanceof Object[]));
          paramView = (Object[])paramObject;
        } while ((paramView.length <= 1) || (paramView[0] == null));
        paramObject = (FeedCloudMeta.StComment)paramView[0];
        paramInt1 = tuk.a(this.a).a(paramObject);
      } while ((paramInt1 < 0) || (paramView[1] == null));
      int i = ((Integer)paramView[1]).intValue();
      this.a.a.setSelectionFromTop(paramInt2, i * (paramInt1 * -1));
      return;
    case 14: 
      if (tym.a().d(57))
      {
        tyk.a(50, 2, tuk.a(this.a));
        return;
      }
      tyg.a(50, 2, tuk.a(this.a));
      return;
    }
    if (tym.a().d(57))
    {
      tyk.a(51, 2, tuk.a(this.a));
      return;
    }
    tyg.a(51, 2, tuk.a(this.a));
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, Object paramObject)
  {
    tuv localtuv = new tuv(this);
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
        tuk.a(this.a, 45);
        paramObject = (FeedCloudMeta.StComment)paramObject;
        tqt.a().a(paramView, tuk.a(this.a), paramObject, new tuw(this, paramObject), localtuv);
        return;
      } while (!(paramObject instanceof Object[]));
      localObject = (Object[])paramObject;
    } while ((localObject.length <= 1) || (localObject[0] == null) || (localObject[1] == null) || (!(localObject[0] instanceof FeedCloudMeta.StComment)) || (!(localObject[1] instanceof FeedCloudMeta.StReply)));
    paramObject = (FeedCloudMeta.StComment)localObject[0];
    Object localObject = (FeedCloudMeta.StReply)localObject[1];
    tqt.a().a(paramView, tuk.a(this.a), (FeedCloudMeta.StReply)localObject, new tvd(this, (FeedCloudMeta.StReply)localObject, paramObject), localtuv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tuu
 * JD-Core Version:    0.7.0.1
 */