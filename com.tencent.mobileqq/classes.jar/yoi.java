import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

class yoi
  extends syt
{
  private final yoh jdField_a_of_type_Yoh;
  
  public yoi(yod paramyod, yoh paramyoh)
  {
    this.jdField_a_of_type_Yoh = paramyoh;
  }
  
  protected boolean a(Integer paramInteger)
  {
    if ((yod.a(this.jdField_a_of_type_Yod) == null) || (this.jdField_a_of_type_Yod.a == null)) {
      return false;
    }
    if (this.jdField_a_of_type_Yoh != null) {
      this.jdField_a_of_type_Yoh.a(paramInteger.intValue());
    }
    switch (paramInteger.intValue())
    {
    }
    for (;;)
    {
      if ((paramInteger.intValue() != 20) && (paramInteger.intValue() != 25) && (yod.a(this.jdField_a_of_type_Yod) != null)) {
        yod.a(this.jdField_a_of_type_Yod, yod.a(this.jdField_a_of_type_Yod).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, paramInteger.intValue() - 1, yod.a(this.jdField_a_of_type_Yod).jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      }
      return super.a(paramInteger);
      yod.a(this.jdField_a_of_type_Yod);
      continue;
      yod.b(this.jdField_a_of_type_Yod);
      continue;
      yod.a(this.jdField_a_of_type_Yod, paramInteger.intValue());
      continue;
      yod.c(this.jdField_a_of_type_Yod);
      continue;
      yod.d(this.jdField_a_of_type_Yod);
      continue;
      yod.d(this.jdField_a_of_type_Yod);
      continue;
      yod.e(this.jdField_a_of_type_Yod);
      continue;
      if ((yod.a(this.jdField_a_of_type_Yod) != null) && (yod.a(this.jdField_a_of_type_Yod).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
      {
        zaj.a(yod.a(this.jdField_a_of_type_Yod).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_shop", 0, 0, new String[0]);
        ybt.a(ybn.a(yod.a(this.jdField_a_of_type_Yod).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
        continue;
        if ((yod.a(this.jdField_a_of_type_Yod) != null) && (yod.a(this.jdField_a_of_type_Yod).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
        {
          ybt.a(yod.a(this.jdField_a_of_type_Yod).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.yzOrderPage.get());
          zaj.b(yod.a(this.jdField_a_of_type_Yod).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_shoplist", 0, 0, new String[0]);
          continue;
          if ((yod.a(this.jdField_a_of_type_Yod) != null) && (yod.a(this.jdField_a_of_type_Yod).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
          {
            ybt.a(QzoneConfig.getInstance().getConfig("qqsubscribe", "showFansGroupConfigEntranceUrl", "https://h5.qzone.qq.com/subscription/fansqun/{uin}?_proxy=1&_wv=3").replace("{uin}", yod.a(this.jdField_a_of_type_Yod).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
            zaj.a(yod.a(this.jdField_a_of_type_Yod).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_fan", 0, 0, new String[0]);
            continue;
            yod.a(this.jdField_a_of_type_Yod).a(yod.a(this.jdField_a_of_type_Yod));
            if ((yod.a(this.jdField_a_of_type_Yod) != null) && (yod.a(this.jdField_a_of_type_Yod).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
            {
              zaj.a(yod.a(this.jdField_a_of_type_Yod).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_pic", 0, 0, new String[] { null, null, yod.a(this.jdField_a_of_type_Yod).f(), yod.a(this.jdField_a_of_type_Yod).c() });
              continue;
              ybt.a("https://h5.qzone.qq.com/subscription/syncFeeds/{uin}?_proxy=1&_wv=3".replace("{uin}", yod.a(this.jdField_a_of_type_Yod).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
              zaj.b(yod.a(this.jdField_a_of_type_Yod).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "sync_qzone", 0, 0, new String[0]);
              continue;
              Intent localIntent = new Intent();
              localIntent.putExtra("postUin", yod.a(this.jdField_a_of_type_Yod).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get());
              localIntent.putExtra("has_shop", true);
              localIntent.putExtra("is_edit", true);
              localIntent.putExtra("feed", yod.a(this.jdField_a_of_type_Yod).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.toByteArray());
              bjdt.a(this.jdField_a_of_type_Yod.a, localIntent, 3);
              continue;
              if (yod.a(this.jdField_a_of_type_Yod) != null) {
                if (yod.a(this.jdField_a_of_type_Yod).b())
                {
                  QLog.d("SubscribeShareHelper", 2, "mColorNoteController ：add colorNote");
                  yod.a(this.jdField_a_of_type_Yod).e();
                }
                else
                {
                  yod.a(this.jdField_a_of_type_Yod).i();
                  continue;
                  if ((yod.a(this.jdField_a_of_type_Yod) != null) && (yod.a(this.jdField_a_of_type_Yod).c()))
                  {
                    QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690909), 5000).a();
                    yod.a(this.jdField_a_of_type_Yod).f();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yoi
 * JD-Core Version:    0.7.0.1
 */