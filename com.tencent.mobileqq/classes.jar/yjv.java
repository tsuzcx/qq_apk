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

class yjv
  extends syt
{
  private final yju jdField_a_of_type_Yju;
  
  public yjv(yjq paramyjq, yju paramyju)
  {
    this.jdField_a_of_type_Yju = paramyju;
  }
  
  protected boolean a(Integer paramInteger)
  {
    if ((yjq.a(this.jdField_a_of_type_Yjq) == null) || (this.jdField_a_of_type_Yjq.a == null)) {
      return false;
    }
    if (this.jdField_a_of_type_Yju != null) {
      this.jdField_a_of_type_Yju.a(paramInteger.intValue());
    }
    switch (paramInteger.intValue())
    {
    }
    for (;;)
    {
      if ((paramInteger.intValue() != 20) && (paramInteger.intValue() != 25) && (yjq.a(this.jdField_a_of_type_Yjq) != null)) {
        yjq.a(this.jdField_a_of_type_Yjq, yjq.a(this.jdField_a_of_type_Yjq).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, paramInteger.intValue() - 1, yjq.a(this.jdField_a_of_type_Yjq).jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      }
      return super.a(paramInteger);
      yjq.a(this.jdField_a_of_type_Yjq);
      continue;
      yjq.b(this.jdField_a_of_type_Yjq);
      continue;
      yjq.a(this.jdField_a_of_type_Yjq, paramInteger.intValue());
      continue;
      yjq.c(this.jdField_a_of_type_Yjq);
      continue;
      yjq.d(this.jdField_a_of_type_Yjq);
      continue;
      yjq.d(this.jdField_a_of_type_Yjq);
      continue;
      yjq.e(this.jdField_a_of_type_Yjq);
      continue;
      if ((yjq.a(this.jdField_a_of_type_Yjq) != null) && (yjq.a(this.jdField_a_of_type_Yjq).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
      {
        yvu.a(yjq.a(this.jdField_a_of_type_Yjq).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_shop", 0, 0, new String[0]);
        xxk.a(xxe.a(yjq.a(this.jdField_a_of_type_Yjq).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
        continue;
        if ((yjq.a(this.jdField_a_of_type_Yjq) != null) && (yjq.a(this.jdField_a_of_type_Yjq).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
        {
          xxk.a(yjq.a(this.jdField_a_of_type_Yjq).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.yzOrderPage.get());
          yvu.b(yjq.a(this.jdField_a_of_type_Yjq).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_shoplist", 0, 0, new String[0]);
          continue;
          if ((yjq.a(this.jdField_a_of_type_Yjq) != null) && (yjq.a(this.jdField_a_of_type_Yjq).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
          {
            xxk.a(QzoneConfig.getInstance().getConfig("qqsubscribe", "showFansGroupConfigEntranceUrl", "https://h5.qzone.qq.com/subscription/fansqun/{uin}?_proxy=1&_wv=3").replace("{uin}", yjq.a(this.jdField_a_of_type_Yjq).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
            yvu.a(yjq.a(this.jdField_a_of_type_Yjq).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_fan", 0, 0, new String[0]);
            continue;
            yjq.a(this.jdField_a_of_type_Yjq).a(yjq.a(this.jdField_a_of_type_Yjq));
            if ((yjq.a(this.jdField_a_of_type_Yjq) != null) && (yjq.a(this.jdField_a_of_type_Yjq).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
            {
              yvu.a(yjq.a(this.jdField_a_of_type_Yjq).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_pic", 0, 0, new String[] { null, null, yjq.a(this.jdField_a_of_type_Yjq).f(), yjq.a(this.jdField_a_of_type_Yjq).c() });
              continue;
              xxk.a("https://h5.qzone.qq.com/subscription/syncFeeds/{uin}?_proxy=1&_wv=3".replace("{uin}", yjq.a(this.jdField_a_of_type_Yjq).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
              yvu.b(yjq.a(this.jdField_a_of_type_Yjq).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "sync_qzone", 0, 0, new String[0]);
              continue;
              Intent localIntent = new Intent();
              localIntent.putExtra("postUin", yjq.a(this.jdField_a_of_type_Yjq).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get());
              localIntent.putExtra("has_shop", true);
              localIntent.putExtra("is_edit", true);
              localIntent.putExtra("feed", yjq.a(this.jdField_a_of_type_Yjq).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.toByteArray());
              bizm.a(this.jdField_a_of_type_Yjq.a, localIntent, 3);
              continue;
              if (yjq.a(this.jdField_a_of_type_Yjq) != null) {
                if (yjq.a(this.jdField_a_of_type_Yjq).b())
                {
                  QLog.d("SubscribeShareHelper", 2, "mColorNoteController ：add colorNote");
                  yjq.a(this.jdField_a_of_type_Yjq).e();
                }
                else
                {
                  yjq.a(this.jdField_a_of_type_Yjq).i();
                  continue;
                  if ((yjq.a(this.jdField_a_of_type_Yjq) != null) && (yjq.a(this.jdField_a_of_type_Yjq).c()))
                  {
                    QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690908), 5000).a();
                    yjq.a(this.jdField_a_of_type_Yjq).f();
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
 * Qualified Name:     yjv
 * JD-Core Version:    0.7.0.1
 */