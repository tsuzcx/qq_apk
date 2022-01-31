import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

class wns
  implements wop
{
  wns(wni paramwni) {}
  
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
                        wis.a(wni.a(this.a), paramView);
                        return;
                      } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
                      paramView = (CertifiedAccountMeta.StComment)paramObject;
                      QLog.d(wni.a(), 1, "click comment, feedId: " + wni.a(this.a).id + " commentId: " + paramView.id);
                      wni.a(this.a, paramView, null);
                      return;
                    } while ((paramObject == null) || (!(paramObject instanceof Object[])));
                    paramObject = (Object[])paramObject;
                  } while ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof CertifiedAccountMeta.StComment)) || (!(paramObject[1] instanceof CertifiedAccountMeta.StReply)));
                  paramView = (CertifiedAccountMeta.StComment)paramObject[0];
                  paramObject = (CertifiedAccountMeta.StReply)paramObject[1];
                  QLog.d(wni.a(), 1, "click reply, feedId: " + wni.a(this.a).id + " commentId: " + paramView.id + " replyId: " + paramObject.id);
                  wni.a(this.a, paramView, paramObject);
                  return;
                } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
                paramView = (CertifiedAccountMeta.StComment)paramObject;
                wni.a(this.a).b(paramView);
                return;
              } while ((paramObject == null) || (!(paramObject instanceof Object[])));
              paramView = (Object[])paramObject;
            } while ((paramView.length <= 1) || (paramView[0] == null));
            paramObject = (CertifiedAccountMeta.StComment)paramView[0];
            paramInt1 = wni.a(this.a).a(paramObject);
          } while ((paramInt1 < 0) || (paramView[1] == null));
          int i = ((Integer)paramView[1]).intValue();
          this.a.a.setSelectionFromTop(paramInt2, i * (paramInt1 * -1));
          return;
        } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
        paramView = (CertifiedAccountMeta.StComment)paramObject;
        wni.a(this.a, wni.a(this.a).a(wni.a(this.a), paramView));
        wni.c(this.a, true);
        return;
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramView = (Object[])paramObject;
    } while ((paramView.length <= 1) || (paramView[0] == null) || (paramView[1] == null));
    paramObject = (CertifiedAccountMeta.StComment)paramView[0];
    wni.a(this.a).a(wni.a(this.a), paramObject, (CertifiedAccountMeta.StReply)paramView[1]);
    wni.c(this.a, true);
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
        wni.a(this.a, new wmc(wni.a(this.a), false, true));
        wni.a(this.a).a(wni.b(this.a).getString(2131691303), 0, new wnt(this, paramView));
        if (wni.a(this.a, paramView.postUser)) {
          wni.a(this.a).a(wni.d(this.a).getString(2131691501), 1, new wnu(this, paramView));
        }
        for (;;)
        {
          wni.a(this.a).a(wni.f(this.a).getString(2131690596));
          wni.a(this.a).show();
          return;
          wni.a(this.a).a(wni.e(this.a).getString(2131718744), 6, new wnv(this, paramView));
        }
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramObject = (Object[])paramObject;
    } while ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof CertifiedAccountMeta.StComment)) || (!(paramObject[1] instanceof CertifiedAccountMeta.StReply)));
    paramView = (CertifiedAccountMeta.StComment)paramObject[0];
    paramObject = (CertifiedAccountMeta.StReply)paramObject[1];
    wni.a(this.a, new wmc(wni.g(this.a), false, true));
    wni.a(this.a).a(wni.h(this.a).getString(2131691303), 0, new wnw(this, paramObject));
    if (wni.a(this.a, paramObject.postUser)) {
      wni.a(this.a).a(wni.j(this.a).getString(2131691501), 1, new wnx(this, paramView, paramObject));
    }
    for (;;)
    {
      wni.a(this.a).a(wni.l(this.a).getString(2131690596));
      wni.a(this.a).show();
      return;
      wni.a(this.a).a(wni.k(this.a).getString(2131718744), 6, new wny(this, paramView, paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wns
 * JD-Core Version:    0.7.0.1
 */