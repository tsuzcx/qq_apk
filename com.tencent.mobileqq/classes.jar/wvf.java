import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

class wvf
  extends shb
{
  private final wve jdField_a_of_type_Wve;
  
  public wvf(wva paramwva, wve paramwve)
  {
    this.jdField_a_of_type_Wve = paramwve;
  }
  
  protected boolean a(Integer paramInteger)
  {
    if ((wva.a(this.jdField_a_of_type_Wva) == null) || (this.jdField_a_of_type_Wva.a == null)) {
      return false;
    }
    if (this.jdField_a_of_type_Wve != null) {
      this.jdField_a_of_type_Wve.a(paramInteger.intValue());
    }
    switch (paramInteger.intValue())
    {
    }
    for (;;)
    {
      if ((paramInteger.intValue() != 20) && (paramInteger.intValue() != 25) && (wva.a(this.jdField_a_of_type_Wva) != null)) {
        wva.a(this.jdField_a_of_type_Wva, wva.a(this.jdField_a_of_type_Wva).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, paramInteger.intValue() - 1, wva.a(this.jdField_a_of_type_Wva).jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      }
      return super.a(paramInteger);
      wva.a(this.jdField_a_of_type_Wva);
      continue;
      wva.b(this.jdField_a_of_type_Wva);
      continue;
      wva.a(this.jdField_a_of_type_Wva, paramInteger.intValue());
      continue;
      wva.c(this.jdField_a_of_type_Wva);
      continue;
      wva.d(this.jdField_a_of_type_Wva);
      continue;
      wva.d(this.jdField_a_of_type_Wva);
      continue;
      wva.e(this.jdField_a_of_type_Wva);
      continue;
      if ((wva.a(this.jdField_a_of_type_Wva) != null) && (wva.a(this.jdField_a_of_type_Wva).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
      {
        xhe.a(wva.a(this.jdField_a_of_type_Wva).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_shop", 0, 0, new String[0]);
        wiv.a(wip.a(wva.a(this.jdField_a_of_type_Wva).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
        continue;
        if ((wva.a(this.jdField_a_of_type_Wva) != null) && (wva.a(this.jdField_a_of_type_Wva).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
        {
          wiv.a(wva.a(this.jdField_a_of_type_Wva).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.yzOrderPage.get());
          xhe.b(wva.a(this.jdField_a_of_type_Wva).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_shoplist", 0, 0, new String[0]);
          continue;
          if ((wva.a(this.jdField_a_of_type_Wva) != null) && (wva.a(this.jdField_a_of_type_Wva).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
          {
            wiv.a(QzoneConfig.getInstance().getConfig("qqsubscribe", "showFansGroupConfigEntranceUrl", "https://h5.qzone.qq.com/subscription/fansqun/{uin}?_proxy=1&_wv=3").replace("{uin}", wva.a(this.jdField_a_of_type_Wva).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
            xhe.a(wva.a(this.jdField_a_of_type_Wva).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_fan", 0, 0, new String[0]);
            continue;
            wva.a(this.jdField_a_of_type_Wva).a(wva.a(this.jdField_a_of_type_Wva));
            if ((wva.a(this.jdField_a_of_type_Wva) != null) && (wva.a(this.jdField_a_of_type_Wva).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
            {
              xhe.a(wva.a(this.jdField_a_of_type_Wva).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_pic", 0, 0, new String[] { null, null, wva.a(this.jdField_a_of_type_Wva).f(), wva.a(this.jdField_a_of_type_Wva).c() });
              continue;
              wiv.a("https://h5.qzone.qq.com/subscription/syncFeeds/{uin}?_proxy=1&_wv=3".replace("{uin}", wva.a(this.jdField_a_of_type_Wva).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
              xhe.b(wva.a(this.jdField_a_of_type_Wva).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "sync_qzone", 0, 0, new String[0]);
              continue;
              Intent localIntent = new Intent();
              localIntent.putExtra("postUin", wva.a(this.jdField_a_of_type_Wva).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get());
              localIntent.putExtra("has_shop", true);
              localIntent.putExtra("is_edit", true);
              localIntent.putExtra("feed", wva.a(this.jdField_a_of_type_Wva).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.toByteArray());
              bgxy.a(this.jdField_a_of_type_Wva.a, localIntent, 3);
              continue;
              if (wva.a(this.jdField_a_of_type_Wva) != null) {
                if (wva.a(this.jdField_a_of_type_Wva).b())
                {
                  QLog.d("SubscribeShareHelper", 2, "mColorNoteController ：add colorNote");
                  wva.a(this.jdField_a_of_type_Wva).e();
                }
                else
                {
                  wva.a(this.jdField_a_of_type_Wva).i();
                  continue;
                  if ((wva.a(this.jdField_a_of_type_Wva) != null) && (wva.a(this.jdField_a_of_type_Wva).c()))
                  {
                    bcpw.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690856), 5000).a();
                    wva.a(this.jdField_a_of_type_Wva).f();
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
 * Qualified Name:     wvf
 * JD-Core Version:    0.7.0.1
 */