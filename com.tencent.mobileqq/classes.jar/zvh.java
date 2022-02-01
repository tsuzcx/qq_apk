import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

class zvh
  implements zwe
{
  zvh(zux paramzux) {}
  
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
                        zqm.a(zux.a(this.a), paramView);
                        return;
                      } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
                      paramView = (CertifiedAccountMeta.StComment)paramObject;
                      QLog.d(zux.a(), 1, "click comment, feedId: " + zux.a(this.a).id + " commentId: " + paramView.id);
                      zux.a(this.a, paramView, null);
                      return;
                    } while ((paramObject == null) || (!(paramObject instanceof Object[])));
                    paramObject = (Object[])paramObject;
                  } while ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof CertifiedAccountMeta.StComment)) || (!(paramObject[1] instanceof CertifiedAccountMeta.StReply)));
                  paramView = (CertifiedAccountMeta.StComment)paramObject[0];
                  paramObject = (CertifiedAccountMeta.StReply)paramObject[1];
                  QLog.d(zux.a(), 1, "click reply, feedId: " + zux.a(this.a).id + " commentId: " + paramView.id + " replyId: " + paramObject.id);
                  zux.a(this.a, paramView, paramObject);
                  return;
                } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
                paramView = (CertifiedAccountMeta.StComment)paramObject;
                zux.a(this.a).b(paramView);
                return;
              } while ((paramObject == null) || (!(paramObject instanceof Object[])));
              paramView = (Object[])paramObject;
            } while ((paramView.length <= 1) || (paramView[0] == null));
            paramObject = (CertifiedAccountMeta.StComment)paramView[0];
            paramInt1 = zux.a(this.a).a(paramObject);
          } while ((paramInt1 < 0) || (paramView[1] == null));
          int i = ((Integer)paramView[1]).intValue();
          this.a.a.setSelectionFromTop(paramInt2, i * (paramInt1 * -1));
          return;
        } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
        paramView = (CertifiedAccountMeta.StComment)paramObject;
        zux.a(this.a, zux.a(this.a).a(zux.a(this.a), paramView));
        zux.c(this.a, true);
        return;
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramView = (Object[])paramObject;
    } while ((paramView.length <= 1) || (paramView[0] == null) || (paramView[1] == null));
    paramObject = (CertifiedAccountMeta.StComment)paramView[0];
    zux.a(this.a).a(zux.a(this.a), paramObject, (CertifiedAccountMeta.StReply)paramView[1]);
    zux.c(this.a, true);
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
        zux.a(this.a, new ztv(zux.a(this.a), false, true));
        zux.a(this.a).a(zux.b(this.a).getString(2131691261), 0, new zvi(this, paramView));
        if (zux.a(this.a, paramView.postUser)) {
          zux.a(this.a).a(zux.d(this.a).getString(2131691445), 1, new zvj(this, paramView));
        }
        for (;;)
        {
          zux.a(this.a).a(zux.f(this.a).getString(2131690697));
          zux.a(this.a).show();
          return;
          zux.a(this.a).a(zux.e(this.a).getString(2131718056), 6, new zvk(this, paramView));
        }
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramObject = (Object[])paramObject;
    } while ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof CertifiedAccountMeta.StComment)) || (!(paramObject[1] instanceof CertifiedAccountMeta.StReply)));
    paramView = (CertifiedAccountMeta.StComment)paramObject[0];
    paramObject = (CertifiedAccountMeta.StReply)paramObject[1];
    zux.a(this.a, new ztv(zux.g(this.a), false, true));
    zux.a(this.a).a(zux.h(this.a).getString(2131691261), 0, new zvl(this, paramObject));
    if (zux.a(this.a, paramObject.postUser)) {
      zux.a(this.a).a(zux.j(this.a).getString(2131691445), 1, new zvm(this, paramView, paramObject));
    }
    for (;;)
    {
      zux.a(this.a).a(zux.l(this.a).getString(2131690697));
      zux.a(this.a).show();
      return;
      zux.a(this.a).a(zux.k(this.a).getString(2131718056), 6, new zvn(this, paramView, paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zvh
 * JD-Core Version:    0.7.0.1
 */