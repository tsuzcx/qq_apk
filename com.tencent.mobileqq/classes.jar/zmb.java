import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

class zmb
  implements ShareActionSheet.OnItemClickListener
{
  private final zma jdField_a_of_type_Zma;
  
  public zmb(zlv paramzlv, zma paramzma)
  {
    this.jdField_a_of_type_Zma = paramzma;
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    this.jdField_a_of_type_Zlv.b();
    if ((zlv.a(this.jdField_a_of_type_Zlv) == null) || (this.jdField_a_of_type_Zlv.a == null)) {}
    for (;;)
    {
      return;
      int i = paramActionSheetItem.action;
      if (this.jdField_a_of_type_Zma != null) {
        this.jdField_a_of_type_Zma.a(i);
      }
      switch (i)
      {
      }
      while ((i != 11) && (i != 40) && (zlv.a(this.jdField_a_of_type_Zlv) != null))
      {
        zlv.a(this.jdField_a_of_type_Zlv, zlv.a(this.jdField_a_of_type_Zlv).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, i - 1, zlv.a(this.jdField_a_of_type_Zlv).jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
        return;
        zlv.a(this.jdField_a_of_type_Zlv);
        continue;
        zlv.b(this.jdField_a_of_type_Zlv);
        continue;
        zlv.a(this.jdField_a_of_type_Zlv, i);
        continue;
        zlv.c(this.jdField_a_of_type_Zlv);
        continue;
        zlv.d(this.jdField_a_of_type_Zlv);
        continue;
        zlv.e(this.jdField_a_of_type_Zlv);
        continue;
        if ((zlv.a(this.jdField_a_of_type_Zlv) != null) && (zlv.a(this.jdField_a_of_type_Zlv).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
        {
          zxp.a(zlv.a(this.jdField_a_of_type_Zlv).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_shop", 0, 0, new String[0]);
          zbh.a(zbb.a(zlv.a(this.jdField_a_of_type_Zlv).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
          continue;
          if ((zlv.a(this.jdField_a_of_type_Zlv) != null) && (zlv.a(this.jdField_a_of_type_Zlv).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
          {
            zbh.a(zlv.a(this.jdField_a_of_type_Zlv).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.yzOrderPage.get());
            zxp.b(zlv.a(this.jdField_a_of_type_Zlv).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_shoplist", 0, 0, new String[0]);
            continue;
            if ((zlv.a(this.jdField_a_of_type_Zlv) != null) && (zlv.a(this.jdField_a_of_type_Zlv).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
            {
              zbh.a(QzoneConfig.getInstance().getConfig("qqsubscribe", "showFansGroupConfigEntranceUrl", "https://h5.qzone.qq.com/subscription/fansqun/{uin}?_proxy=1&_wv=3").replace("{uin}", zlv.a(this.jdField_a_of_type_Zlv).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
              zxp.a(zlv.a(this.jdField_a_of_type_Zlv).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_fan", 0, 0, new String[0]);
              continue;
              zlv.a(this.jdField_a_of_type_Zlv).a(zlv.a(this.jdField_a_of_type_Zlv));
              if ((zlv.a(this.jdField_a_of_type_Zlv) != null) && (zlv.a(this.jdField_a_of_type_Zlv).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
              {
                zxp.a(zlv.a(this.jdField_a_of_type_Zlv).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "clk_pic", 0, 0, new String[] { null, null, zlv.a(this.jdField_a_of_type_Zlv).f(), zlv.a(this.jdField_a_of_type_Zlv).c() });
                continue;
                zbh.a("https://h5.qzone.qq.com/subscription/syncFeeds/{uin}?_proxy=1&_wv=3".replace("{uin}", zlv.a(this.jdField_a_of_type_Zlv).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()));
                zxp.b(zlv.a(this.jdField_a_of_type_Zlv).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "sync_qzone", 0, 0, new String[0]);
                continue;
                if (zlv.a(this.jdField_a_of_type_Zlv) != null) {
                  if (zlv.a(this.jdField_a_of_type_Zlv).b())
                  {
                    QLog.d("SubscribeShareHelper", 2, "mColorNoteController ：add colorNote");
                    zlv.a(this.jdField_a_of_type_Zlv).e();
                  }
                  else
                  {
                    zlv.a(this.jdField_a_of_type_Zlv).i();
                    continue;
                    if ((zlv.a(this.jdField_a_of_type_Zlv) != null) && (zlv.a(this.jdField_a_of_type_Zlv).c()))
                    {
                      QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690790), 5000).a();
                      zlv.a(this.jdField_a_of_type_Zlv).f();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zmb
 * JD-Core Version:    0.7.0.1
 */