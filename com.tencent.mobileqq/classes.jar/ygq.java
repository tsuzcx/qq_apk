import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

class ygq
  implements yhn
{
  ygq(ygg paramygg) {}
  
  public void a(View paramView, int paramInt1, int paramInt2, Object paramObject)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            return;
                          } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StUser)));
                          paramView = (CertifiedAccountMeta.StUser)paramObject;
                        } while (paramView.type.get() != 1);
                        ybt.a(ygg.a(this.a), paramView);
                        return;
                      } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
                      paramView = (CertifiedAccountMeta.StComment)paramObject;
                      QLog.d(ygg.a(), 1, "click comment, feedId: " + ygg.a(this.a).id + " commentId: " + paramView.id);
                      ygg.a(this.a, paramView, null);
                      return;
                    } while ((paramObject == null) || (!(paramObject instanceof Object[])));
                    paramObject = (Object[])paramObject;
                  } while ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof CertifiedAccountMeta.StComment)) || (!(paramObject[1] instanceof CertifiedAccountMeta.StReply)));
                  paramView = (CertifiedAccountMeta.StComment)paramObject[0];
                  paramObject = (CertifiedAccountMeta.StReply)paramObject[1];
                  QLog.d(ygg.a(), 1, "click reply, feedId: " + ygg.a(this.a).id + " commentId: " + paramView.id + " replyId: " + paramObject.id);
                  ygg.a(this.a, paramView, paramObject);
                  return;
                } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
                paramView = (CertifiedAccountMeta.StComment)paramObject;
                ygg.a(this.a).b(paramView);
                return;
              } while ((paramObject == null) || (!(paramObject instanceof Object[])));
              paramView = (Object[])paramObject;
            } while ((paramView.length <= 1) || (paramView[0] == null));
            paramObject = (CertifiedAccountMeta.StComment)paramView[0];
            paramInt1 = ygg.a(this.a).a(paramObject);
          } while ((paramInt1 < 0) || (paramView[1] == null));
          int i = ((Integer)paramView[1]).intValue();
          this.a.a.setSelectionFromTop(paramInt2, i * (paramInt1 * -1));
          return;
        } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
        paramView = (CertifiedAccountMeta.StComment)paramObject;
        ygg.a(this.a, ygg.a(this.a).a(ygg.a(this.a), paramView));
        ygg.c(this.a, true);
        return;
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramView = (Object[])paramObject;
    } while ((paramView.length <= 1) || (paramView[0] == null) || (paramView[1] == null));
    paramObject = (CertifiedAccountMeta.StComment)paramView[0];
    ygg.a(this.a).a(ygg.a(this.a), paramObject, (CertifiedAccountMeta.StReply)paramView[1]);
    ygg.c(this.a, true);
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, Object paramObject)
  {
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
        } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
        paramView = (CertifiedAccountMeta.StComment)paramObject;
        ygg.a(this.a, new yfe(ygg.a(this.a), false, true));
        ygg.a(this.a).a(ygg.b(this.a).getString(2131691357), 0, new ygr(this, paramView));
        if (ygg.a(this.a, paramView.postUser)) {
          ygg.a(this.a).a(ygg.d(this.a).getString(2131691556), 1, new ygs(this, paramView));
        }
        for (;;)
        {
          ygg.a(this.a).a(ygg.f(this.a).getString(2131690648));
          ygg.a(this.a).show();
          return;
          ygg.a(this.a).a(ygg.e(this.a).getString(2131719229), 6, new ygt(this, paramView));
        }
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramObject = (Object[])paramObject;
    } while ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof CertifiedAccountMeta.StComment)) || (!(paramObject[1] instanceof CertifiedAccountMeta.StReply)));
    paramView = (CertifiedAccountMeta.StComment)paramObject[0];
    paramObject = (CertifiedAccountMeta.StReply)paramObject[1];
    ygg.a(this.a, new yfe(ygg.g(this.a), false, true));
    ygg.a(this.a).a(ygg.h(this.a).getString(2131691357), 0, new ygu(this, paramObject));
    if (ygg.a(this.a, paramObject.postUser)) {
      ygg.a(this.a).a(ygg.j(this.a).getString(2131691556), 1, new ygv(this, paramView, paramObject));
    }
    for (;;)
    {
      ygg.a(this.a).a(ygg.l(this.a).getString(2131690648));
      ygg.a(this.a).show();
      return;
      ygg.a(this.a).a(ygg.k(this.a).getString(2131719229), 6, new ygw(this, paramView, paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ygq
 * JD-Core Version:    0.7.0.1
 */