import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.mobileqq.pb.PBStringField;

class sis
  extends ode.a
{
  sis(sio paramsio) {}
  
  protected boolean c(Integer paramInteger)
  {
    if ((sio.a(this.this$0) == null) || (sio.a(this.this$0) == null)) {
      return false;
    }
    switch (paramInteger.intValue())
    {
    }
    for (;;)
    {
      return super.c(paramInteger);
      sio.a(this.this$0);
      if ((sio.a(this.this$0) != null) && (sio.a(this.this$0).a() != null))
      {
        sqn.b(sio.a(this.this$0).a().poster.id.get(), "auth_pic_share", "clk_friends", 0, 0, new String[] { null, null, sio.a(this.this$0).nt(), sio.a(this.this$0).getShareTitle() });
        continue;
        sio.b(this.this$0);
        if ((sio.a(this.this$0) != null) && (sio.a(this.this$0).a() != null))
        {
          sqn.b(sio.a(this.this$0).a().poster.id.get(), "auth_pic_share", "clk_qzone", 0, 0, new String[] { null, null, sio.a(this.this$0).nt(), sio.a(this.this$0).getShareTitle() });
          continue;
          sio.a(this.this$0, 0);
          if ((sio.a(this.this$0) != null) && (sio.a(this.this$0).a() != null))
          {
            sqn.b(sio.a(this.this$0).a().poster.id.get(), "auth_pic_share", "clk_wechat", 0, 0, new String[] { null, null, sio.a(this.this$0).nt(), sio.a(this.this$0).getShareTitle() });
            continue;
            sio.a(this.this$0, 1);
            if ((sio.a(this.this$0) != null) && (sio.a(this.this$0).a() != null))
            {
              sqn.b(sio.a(this.this$0).a().poster.id.get(), "auth_pic_share", "clk_moments", 0, 0, new String[] { null, null, sio.a(this.this$0).nt(), sio.a(this.this$0).getShareTitle() });
              continue;
              sio.c(this.this$0);
              if ((sio.a(this.this$0) != null) && (sio.a(this.this$0).a() != null)) {
                sqn.b(sio.a(this.this$0).a().poster.id.get(), "auth_pic_share", "clk_save_local", 0, 0, new String[] { null, null, sio.a(this.this$0).nt(), sio.a(this.this$0).getShareTitle() });
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sis
 * JD-Core Version:    0.7.0.1
 */