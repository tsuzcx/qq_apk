import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

class wge
  extends ruj
{
  private final wgd jdField_a_of_type_Wgd;
  
  public wge(wfz paramwfz, wgd paramwgd)
  {
    this.jdField_a_of_type_Wgd = paramwgd;
  }
  
  protected boolean a(Integer paramInteger)
  {
    if ((wfz.a(this.jdField_a_of_type_Wfz) == null) || (this.jdField_a_of_type_Wfz.a == null)) {
      return false;
    }
    if (this.jdField_a_of_type_Wgd != null) {
      this.jdField_a_of_type_Wgd.a(paramInteger.intValue());
    }
    switch (paramInteger.intValue())
    {
    }
    for (;;)
    {
      if ((paramInteger.intValue() != 20) && (paramInteger.intValue() != 25) && (wfz.a(this.jdField_a_of_type_Wfz) != null)) {
        wfz.a(this.jdField_a_of_type_Wfz, wfz.a(this.jdField_a_of_type_Wfz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, paramInteger.intValue() - 1, wfz.a(this.jdField_a_of_type_Wfz).jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      }
      return super.a(paramInteger);
      wfz.a(this.jdField_a_of_type_Wfz);
      continue;
      wfz.b(this.jdField_a_of_type_Wfz);
      continue;
      wfz.a(this.jdField_a_of_type_Wfz, paramInteger.intValue());
      continue;
      wfz.c(this.jdField_a_of_type_Wfz);
      continue;
      wfz.d(this.jdField_a_of_type_Wfz);
      continue;
      wfz.d(this.jdField_a_of_type_Wfz);
      continue;
      wfz.e(this.jdField_a_of_type_Wfz);
      continue;
      if ((wfz.a(this.jdField_a_of_type_Wfz) != null) && (wfz.a(this.jdField_a_of_type_Wfz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
      {
        wye.a(wfz.a(this.jdField_a_of_type_Wfz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_shop", 0, 0, new String[0]);
        vvy.a(vvs.a(wfz.a(this.jdField_a_of_type_Wfz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
        continue;
        if ((wfz.a(this.jdField_a_of_type_Wfz) != null) && (wfz.a(this.jdField_a_of_type_Wfz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
        {
          vvy.a(wfz.a(this.jdField_a_of_type_Wfz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.yzOrderPage.get());
          wye.b(wfz.a(this.jdField_a_of_type_Wfz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_shoplist", 0, 0, new String[0]);
          continue;
          if ((wfz.a(this.jdField_a_of_type_Wfz) != null) && (wfz.a(this.jdField_a_of_type_Wfz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
          {
            vvy.a(QzoneConfig.getInstance().getConfig("qqsubscribe", "showFansGroupConfigEntranceUrl", "https://h5.qzone.qq.com/subscription/fansqun/{uin}?_proxy=1&_wv=3").replace("{uin}", wfz.a(this.jdField_a_of_type_Wfz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
            wye.a(wfz.a(this.jdField_a_of_type_Wfz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_fan", 0, 0, new String[0]);
            continue;
            if (wfz.a(this.jdField_a_of_type_Wfz) == null) {
              wfz.a(this.jdField_a_of_type_Wfz, new wfw(this.jdField_a_of_type_Wfz.a));
            }
            wfz.a(this.jdField_a_of_type_Wfz).a(wfz.a(this.jdField_a_of_type_Wfz));
            if ((wfz.a(this.jdField_a_of_type_Wfz) != null) && (wfz.a(this.jdField_a_of_type_Wfz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
            {
              wye.a(wfz.a(this.jdField_a_of_type_Wfz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_pic", 0, 0, new String[] { null, null, wfz.a(this.jdField_a_of_type_Wfz).f(), wfz.a(this.jdField_a_of_type_Wfz).c() });
              continue;
              vvy.a("https://h5.qzone.qq.com/subscription/syncFeeds/{uin}?_proxy=1&_wv=3".replace("{uin}", wfz.a(this.jdField_a_of_type_Wfz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
              wye.b(wfz.a(this.jdField_a_of_type_Wfz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "sync_qzone", 0, 0, new String[0]);
              continue;
              Intent localIntent = new Intent();
              localIntent.putExtra("postUin", wfz.a(this.jdField_a_of_type_Wfz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get());
              localIntent.putExtra("has_shop", true);
              localIntent.putExtra("is_edit", true);
              localIntent.putExtra("feed", wfz.a(this.jdField_a_of_type_Wfz).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.toByteArray());
              bfpr.a(this.jdField_a_of_type_Wfz.a, localIntent, 3);
              continue;
              if (wfz.a(this.jdField_a_of_type_Wfz) != null) {
                if (wfz.a(this.jdField_a_of_type_Wfz).b())
                {
                  QLog.d("SubscribeShareHelper", 2, "mColorNoteController ：add colorNote");
                  wfz.a(this.jdField_a_of_type_Wfz).e();
                }
                else
                {
                  wfz.a(this.jdField_a_of_type_Wfz).i();
                  continue;
                  if ((wfz.a(this.jdField_a_of_type_Wfz) != null) && (wfz.a(this.jdField_a_of_type_Wfz).c()))
                  {
                    bbmy.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131625293), 5000).a();
                    wfz.a(this.jdField_a_of_type_Wfz).f();
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
 * Qualified Name:     wge
 * JD-Core Version:    0.7.0.1
 */