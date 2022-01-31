import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

class wnv
  implements wos
{
  wnv(wnl paramwnl) {}
  
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
                        wiv.a(wnl.a(this.a), paramView);
                        return;
                      } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
                      paramView = (CertifiedAccountMeta.StComment)paramObject;
                      QLog.d(wnl.a(), 1, "click comment, feedId: " + wnl.a(this.a).id + " commentId: " + paramView.id);
                      wnl.a(this.a, paramView, null);
                      return;
                    } while ((paramObject == null) || (!(paramObject instanceof Object[])));
                    paramObject = (Object[])paramObject;
                  } while ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof CertifiedAccountMeta.StComment)) || (!(paramObject[1] instanceof CertifiedAccountMeta.StReply)));
                  paramView = (CertifiedAccountMeta.StComment)paramObject[0];
                  paramObject = (CertifiedAccountMeta.StReply)paramObject[1];
                  QLog.d(wnl.a(), 1, "click reply, feedId: " + wnl.a(this.a).id + " commentId: " + paramView.id + " replyId: " + paramObject.id);
                  wnl.a(this.a, paramView, paramObject);
                  return;
                } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
                paramView = (CertifiedAccountMeta.StComment)paramObject;
                wnl.a(this.a).b(paramView);
                return;
              } while ((paramObject == null) || (!(paramObject instanceof Object[])));
              paramView = (Object[])paramObject;
            } while ((paramView.length <= 1) || (paramView[0] == null));
            paramObject = (CertifiedAccountMeta.StComment)paramView[0];
            paramInt1 = wnl.a(this.a).a(paramObject);
          } while ((paramInt1 < 0) || (paramView[1] == null));
          int i = ((Integer)paramView[1]).intValue();
          this.a.a.setSelectionFromTop(paramInt2, i * (paramInt1 * -1));
          return;
        } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
        paramView = (CertifiedAccountMeta.StComment)paramObject;
        wnl.a(this.a, wnl.a(this.a).a(wnl.a(this.a), paramView));
        wnl.c(this.a, true);
        return;
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramView = (Object[])paramObject;
    } while ((paramView.length <= 1) || (paramView[0] == null) || (paramView[1] == null));
    paramObject = (CertifiedAccountMeta.StComment)paramView[0];
    wnl.a(this.a).a(wnl.a(this.a), paramObject, (CertifiedAccountMeta.StReply)paramView[1]);
    wnl.c(this.a, true);
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
        wnl.a(this.a, new wmf(wnl.a(this.a), false, true));
        wnl.a(this.a).a(wnl.b(this.a).getString(2131691303), 0, new wnw(this, paramView));
        if (wnl.a(this.a, paramView.postUser)) {
          wnl.a(this.a).a(wnl.d(this.a).getString(2131691501), 1, new wnx(this, paramView));
        }
        for (;;)
        {
          wnl.a(this.a).a(wnl.f(this.a).getString(2131690596));
          wnl.a(this.a).show();
          return;
          wnl.a(this.a).a(wnl.e(this.a).getString(2131718733), 6, new wny(this, paramView));
        }
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramObject = (Object[])paramObject;
    } while ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof CertifiedAccountMeta.StComment)) || (!(paramObject[1] instanceof CertifiedAccountMeta.StReply)));
    paramView = (CertifiedAccountMeta.StComment)paramObject[0];
    paramObject = (CertifiedAccountMeta.StReply)paramObject[1];
    wnl.a(this.a, new wmf(wnl.g(this.a), false, true));
    wnl.a(this.a).a(wnl.h(this.a).getString(2131691303), 0, new wnz(this, paramObject));
    if (wnl.a(this.a, paramObject.postUser)) {
      wnl.a(this.a).a(wnl.j(this.a).getString(2131691501), 1, new woa(this, paramView, paramObject));
    }
    for (;;)
    {
      wnl.a(this.a).a(wnl.l(this.a).getString(2131690596));
      wnl.a(this.a).show();
      return;
      wnl.a(this.a).a(wnl.k(this.a).getString(2131718733), 6, new wob(this, paramView, paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wnv
 * JD-Core Version:    0.7.0.1
 */