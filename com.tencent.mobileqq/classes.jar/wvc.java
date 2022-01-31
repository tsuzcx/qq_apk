import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

class wvc
  extends sgy
{
  private final wvb jdField_a_of_type_Wvb;
  
  public wvc(wux paramwux, wvb paramwvb)
  {
    this.jdField_a_of_type_Wvb = paramwvb;
  }
  
  protected boolean a(Integer paramInteger)
  {
    if ((wux.a(this.jdField_a_of_type_Wux) == null) || (this.jdField_a_of_type_Wux.a == null)) {
      return false;
    }
    if (this.jdField_a_of_type_Wvb != null) {
      this.jdField_a_of_type_Wvb.a(paramInteger.intValue());
    }
    switch (paramInteger.intValue())
    {
    }
    for (;;)
    {
      if ((paramInteger.intValue() != 20) && (paramInteger.intValue() != 25) && (wux.a(this.jdField_a_of_type_Wux) != null)) {
        wux.a(this.jdField_a_of_type_Wux, wux.a(this.jdField_a_of_type_Wux).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, paramInteger.intValue() - 1, wux.a(this.jdField_a_of_type_Wux).jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      }
      return super.a(paramInteger);
      wux.a(this.jdField_a_of_type_Wux);
      continue;
      wux.b(this.jdField_a_of_type_Wux);
      continue;
      wux.a(this.jdField_a_of_type_Wux, paramInteger.intValue());
      continue;
      wux.c(this.jdField_a_of_type_Wux);
      continue;
      wux.d(this.jdField_a_of_type_Wux);
      continue;
      wux.d(this.jdField_a_of_type_Wux);
      continue;
      wux.e(this.jdField_a_of_type_Wux);
      continue;
      if ((wux.a(this.jdField_a_of_type_Wux) != null) && (wux.a(this.jdField_a_of_type_Wux).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
      {
        xhb.a(wux.a(this.jdField_a_of_type_Wux).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_shop", 0, 0, new String[0]);
        wis.a(wim.a(wux.a(this.jdField_a_of_type_Wux).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
        continue;
        if ((wux.a(this.jdField_a_of_type_Wux) != null) && (wux.a(this.jdField_a_of_type_Wux).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
        {
          wis.a(wux.a(this.jdField_a_of_type_Wux).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.yzOrderPage.get());
          xhb.b(wux.a(this.jdField_a_of_type_Wux).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_shoplist", 0, 0, new String[0]);
          continue;
          if ((wux.a(this.jdField_a_of_type_Wux) != null) && (wux.a(this.jdField_a_of_type_Wux).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
          {
            wis.a(QzoneConfig.getInstance().getConfig("qqsubscribe", "showFansGroupConfigEntranceUrl", "https://h5.qzone.qq.com/subscription/fansqun/{uin}?_proxy=1&_wv=3").replace("{uin}", wux.a(this.jdField_a_of_type_Wux).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
            xhb.a(wux.a(this.jdField_a_of_type_Wux).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_fan", 0, 0, new String[0]);
            continue;
            wux.a(this.jdField_a_of_type_Wux).a(wux.a(this.jdField_a_of_type_Wux));
            if ((wux.a(this.jdField_a_of_type_Wux) != null) && (wux.a(this.jdField_a_of_type_Wux).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
            {
              xhb.a(wux.a(this.jdField_a_of_type_Wux).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_pic", 0, 0, new String[] { null, null, wux.a(this.jdField_a_of_type_Wux).f(), wux.a(this.jdField_a_of_type_Wux).c() });
              continue;
              wis.a("https://h5.qzone.qq.com/subscription/syncFeeds/{uin}?_proxy=1&_wv=3".replace("{uin}", wux.a(this.jdField_a_of_type_Wux).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
              xhb.b(wux.a(this.jdField_a_of_type_Wux).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "sync_qzone", 0, 0, new String[0]);
              continue;
              Intent localIntent = new Intent();
              localIntent.putExtra("postUin", wux.a(this.jdField_a_of_type_Wux).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get());
              localIntent.putExtra("has_shop", true);
              localIntent.putExtra("is_edit", true);
              localIntent.putExtra("feed", wux.a(this.jdField_a_of_type_Wux).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.toByteArray());
              bgyp.a(this.jdField_a_of_type_Wux.a, localIntent, 3);
              continue;
              if (wux.a(this.jdField_a_of_type_Wux) != null) {
                if (wux.a(this.jdField_a_of_type_Wux).b())
                {
                  QLog.d("SubscribeShareHelper", 2, "mColorNoteController ：add colorNote");
                  wux.a(this.jdField_a_of_type_Wux).e();
                }
                else
                {
                  wux.a(this.jdField_a_of_type_Wux).i();
                  continue;
                  if ((wux.a(this.jdField_a_of_type_Wux) != null) && (wux.a(this.jdField_a_of_type_Wux).c()))
                  {
                    bcql.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690856), 5000).a();
                    wux.a(this.jdField_a_of_type_Wux).f();
                    QLog.d("SubscribeShareHelper", 2, "mColorNoteController ： delete colorNote");
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wvc
 * JD-Core Version:    0.7.0.1
 */