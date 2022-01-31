import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

class wai
  implements wbf
{
  wai(vzz paramvzz) {}
  
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
                        paramView = ((CertifiedAccountMeta.StUser)paramView.get()).id.get();
                        vvy.a(vzz.a(this.a), paramView);
                        return;
                      } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
                      paramView = (CertifiedAccountMeta.StComment)paramObject;
                      QLog.d(vzz.a(), 1, "click comment, feedId: " + vzz.a(this.a).id + " commentId: " + paramView.id);
                      vzz.a(this.a, paramView, null);
                      return;
                    } while ((paramObject == null) || (!(paramObject instanceof Object[])));
                    paramObject = (Object[])paramObject;
                  } while ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof CertifiedAccountMeta.StComment)) || (!(paramObject[1] instanceof CertifiedAccountMeta.StReply)));
                  paramView = (CertifiedAccountMeta.StComment)paramObject[0];
                  paramObject = (CertifiedAccountMeta.StReply)paramObject[1];
                  QLog.d(vzz.a(), 1, "click reply, feedId: " + vzz.a(this.a).id + " commentId: " + paramView.id + " replyId: " + paramObject.id);
                  vzz.a(this.a, paramView, paramObject);
                  return;
                } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
                paramView = (CertifiedAccountMeta.StComment)paramObject;
                vzz.a(this.a).a(paramView);
                return;
              } while ((paramObject == null) || (!(paramObject instanceof Object[])));
              paramView = (Object[])paramObject;
            } while ((paramView.length <= 1) || (paramView[0] == null));
            paramObject = (CertifiedAccountMeta.StComment)paramView[0];
            paramInt1 = vzz.a(this.a).a(paramObject);
          } while ((paramInt1 < 0) || (paramView[1] == null));
          int i = ((Integer)paramView[1]).intValue();
          this.a.a.setSelectionFromTop(paramInt2, i * (paramInt1 * -1));
          return;
        } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
        paramView = (CertifiedAccountMeta.StComment)paramObject;
        vzz.a(this.a, vzz.a(this.a).a(vzz.a(this.a), paramView));
        vzz.b(this.a, true);
        return;
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramView = (Object[])paramObject;
    } while ((paramView.length <= 1) || (paramView[0] == null) || (paramView[1] == null));
    paramObject = (CertifiedAccountMeta.StComment)paramView[0];
    vzz.a(this.a).a(vzz.a(this.a), paramObject, (CertifiedAccountMeta.StReply)paramView[1]);
    vzz.b(this.a, true);
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
        vzz.a(this.a, new vyw(vzz.a(this.a), false, true));
        vzz.a(this.a).a(vzz.b(this.a).getString(2131625727), 0, new waj(this, paramView));
        if (vzz.a(this.a, paramView.postUser)) {
          vzz.a(this.a).a(vzz.d(this.a).getString(2131625925), 1, new wak(this, paramView));
        }
        for (;;)
        {
          vzz.a(this.a).a(vzz.f(this.a).getString(2131625035));
          vzz.a(this.a).show();
          return;
          vzz.a(this.a).a(vzz.e(this.a).getString(2131652908), 6, new wal(this, paramView));
        }
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramObject = (Object[])paramObject;
    } while ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof CertifiedAccountMeta.StComment)) || (!(paramObject[1] instanceof CertifiedAccountMeta.StReply)));
    paramView = (CertifiedAccountMeta.StComment)paramObject[0];
    paramObject = (CertifiedAccountMeta.StReply)paramObject[1];
    vzz.a(this.a, new vyw(vzz.g(this.a), false, true));
    vzz.a(this.a).a(vzz.h(this.a).getString(2131625727), 0, new wam(this, paramObject));
    if (vzz.a(this.a, paramObject.postUser)) {
      vzz.a(this.a).a(vzz.j(this.a).getString(2131625925), 1, new wan(this, paramView, paramObject));
    }
    for (;;)
    {
      vzz.a(this.a).a(vzz.l(this.a).getString(2131625035));
      vzz.a(this.a).show();
      return;
      vzz.a(this.a).a(vzz.k(this.a).getString(2131652908), 6, new wao(this, paramView, paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wai
 * JD-Core Version:    0.7.0.1
 */