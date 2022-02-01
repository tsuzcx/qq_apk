import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

class zgc
  implements zgz
{
  zgc(zfs paramzfs) {}
  
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
                        zbh.a(zfs.a(this.a), paramView);
                        return;
                      } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
                      paramView = (CertifiedAccountMeta.StComment)paramObject;
                      QLog.d(zfs.a(), 1, "click comment, feedId: " + zfs.a(this.a).id + " commentId: " + paramView.id);
                      zfs.a(this.a, paramView, null);
                      return;
                    } while ((paramObject == null) || (!(paramObject instanceof Object[])));
                    paramObject = (Object[])paramObject;
                  } while ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof CertifiedAccountMeta.StComment)) || (!(paramObject[1] instanceof CertifiedAccountMeta.StReply)));
                  paramView = (CertifiedAccountMeta.StComment)paramObject[0];
                  paramObject = (CertifiedAccountMeta.StReply)paramObject[1];
                  QLog.d(zfs.a(), 1, "click reply, feedId: " + zfs.a(this.a).id + " commentId: " + paramView.id + " replyId: " + paramObject.id);
                  zfs.a(this.a, paramView, paramObject);
                  return;
                } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
                paramView = (CertifiedAccountMeta.StComment)paramObject;
                zfs.a(this.a).b(paramView);
                return;
              } while ((paramObject == null) || (!(paramObject instanceof Object[])));
              paramView = (Object[])paramObject;
            } while ((paramView.length <= 1) || (paramView[0] == null));
            paramObject = (CertifiedAccountMeta.StComment)paramView[0];
            paramInt1 = zfs.a(this.a).a(paramObject);
          } while ((paramInt1 < 0) || (paramView[1] == null));
          int i = ((Integer)paramView[1]).intValue();
          this.a.a.setSelectionFromTop(paramInt2, i * (paramInt1 * -1));
          return;
        } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
        paramView = (CertifiedAccountMeta.StComment)paramObject;
        zfs.a(this.a, zfs.a(this.a).a(zfs.a(this.a), paramView));
        zfs.c(this.a, true);
        return;
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramView = (Object[])paramObject;
    } while ((paramView.length <= 1) || (paramView[0] == null) || (paramView[1] == null));
    paramObject = (CertifiedAccountMeta.StComment)paramView[0];
    zfs.a(this.a).a(zfs.a(this.a), paramObject, (CertifiedAccountMeta.StReply)paramView[1]);
    zfs.c(this.a, true);
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
        zfs.a(this.a, new zeq(zfs.a(this.a), false, true));
        zfs.a(this.a).a(zfs.b(this.a).getString(2131691176), 0, new zgd(this, paramView));
        if (zfs.a(this.a, paramView.postUser)) {
          zfs.a(this.a).a(zfs.d(this.a).getString(2131691360), 1, new zge(this, paramView));
        }
        for (;;)
        {
          zfs.a(this.a).a(zfs.f(this.a).getString(2131690620));
          zfs.a(this.a).show();
          return;
          zfs.a(this.a).a(zfs.e(this.a).getString(2131717685), 6, new zgf(this, paramView));
        }
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramObject = (Object[])paramObject;
    } while ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof CertifiedAccountMeta.StComment)) || (!(paramObject[1] instanceof CertifiedAccountMeta.StReply)));
    paramView = (CertifiedAccountMeta.StComment)paramObject[0];
    paramObject = (CertifiedAccountMeta.StReply)paramObject[1];
    zfs.a(this.a, new zeq(zfs.g(this.a), false, true));
    zfs.a(this.a).a(zfs.h(this.a).getString(2131691176), 0, new zgg(this, paramObject));
    if (zfs.a(this.a, paramObject.postUser)) {
      zfs.a(this.a).a(zfs.j(this.a).getString(2131691360), 1, new zgh(this, paramView, paramObject));
    }
    for (;;)
    {
      zfs.a(this.a).a(zfs.l(this.a).getString(2131690620));
      zfs.a(this.a).show();
      return;
      zfs.a(this.a).a(zfs.k(this.a).getString(2131717685), 6, new zgi(this, paramView, paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zgc
 * JD-Core Version:    0.7.0.1
 */