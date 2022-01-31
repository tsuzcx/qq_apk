import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

class ych
  implements yde
{
  ych(ybx paramybx) {}
  
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
                        xxk.a(ybx.a(this.a), paramView);
                        return;
                      } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
                      paramView = (CertifiedAccountMeta.StComment)paramObject;
                      QLog.d(ybx.a(), 1, "click comment, feedId: " + ybx.a(this.a).id + " commentId: " + paramView.id);
                      ybx.a(this.a, paramView, null);
                      return;
                    } while ((paramObject == null) || (!(paramObject instanceof Object[])));
                    paramObject = (Object[])paramObject;
                  } while ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof CertifiedAccountMeta.StComment)) || (!(paramObject[1] instanceof CertifiedAccountMeta.StReply)));
                  paramView = (CertifiedAccountMeta.StComment)paramObject[0];
                  paramObject = (CertifiedAccountMeta.StReply)paramObject[1];
                  QLog.d(ybx.a(), 1, "click reply, feedId: " + ybx.a(this.a).id + " commentId: " + paramView.id + " replyId: " + paramObject.id);
                  ybx.a(this.a, paramView, paramObject);
                  return;
                } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
                paramView = (CertifiedAccountMeta.StComment)paramObject;
                ybx.a(this.a).b(paramView);
                return;
              } while ((paramObject == null) || (!(paramObject instanceof Object[])));
              paramView = (Object[])paramObject;
            } while ((paramView.length <= 1) || (paramView[0] == null));
            paramObject = (CertifiedAccountMeta.StComment)paramView[0];
            paramInt1 = ybx.a(this.a).a(paramObject);
          } while ((paramInt1 < 0) || (paramView[1] == null));
          int i = ((Integer)paramView[1]).intValue();
          this.a.a.setSelectionFromTop(paramInt2, i * (paramInt1 * -1));
          return;
        } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
        paramView = (CertifiedAccountMeta.StComment)paramObject;
        ybx.a(this.a, ybx.a(this.a).a(ybx.a(this.a), paramView));
        ybx.c(this.a, true);
        return;
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramView = (Object[])paramObject;
    } while ((paramView.length <= 1) || (paramView[0] == null) || (paramView[1] == null));
    paramObject = (CertifiedAccountMeta.StComment)paramView[0];
    ybx.a(this.a).a(ybx.a(this.a), paramObject, (CertifiedAccountMeta.StReply)paramView[1]);
    ybx.c(this.a, true);
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
        ybx.a(this.a, new yav(ybx.a(this.a), false, true));
        ybx.a(this.a).a(ybx.b(this.a).getString(2131691356), 0, new yci(this, paramView));
        if (ybx.a(this.a, paramView.postUser)) {
          ybx.a(this.a).a(ybx.d(this.a).getString(2131691555), 1, new ycj(this, paramView));
        }
        for (;;)
        {
          ybx.a(this.a).a(ybx.f(this.a).getString(2131690648));
          ybx.a(this.a).show();
          return;
          ybx.a(this.a).a(ybx.e(this.a).getString(2131719217), 6, new yck(this, paramView));
        }
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramObject = (Object[])paramObject;
    } while ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof CertifiedAccountMeta.StComment)) || (!(paramObject[1] instanceof CertifiedAccountMeta.StReply)));
    paramView = (CertifiedAccountMeta.StComment)paramObject[0];
    paramObject = (CertifiedAccountMeta.StReply)paramObject[1];
    ybx.a(this.a, new yav(ybx.g(this.a), false, true));
    ybx.a(this.a).a(ybx.h(this.a).getString(2131691356), 0, new ycl(this, paramObject));
    if (ybx.a(this.a, paramObject.postUser)) {
      ybx.a(this.a).a(ybx.j(this.a).getString(2131691555), 1, new ycm(this, paramView, paramObject));
    }
    for (;;)
    {
      ybx.a(this.a).a(ybx.l(this.a).getString(2131690648));
      ybx.a(this.a).show();
      return;
      ybx.a(this.a).a(ybx.k(this.a).getString(2131719217), 6, new ycn(this, paramView, paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ych
 * JD-Core Version:    0.7.0.1
 */