import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.etrump.mixlayout.FontManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.IndividuationABTestManager;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

public class uzg
  implements FileManagerUtil.TipsClickedInterface
{
  public uzg(GrayTipsItemBuilder paramGrayTipsItemBuilder, int paramInt1, int paramInt2, String paramString, int paramInt3) {}
  
  public void a(View paramView)
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      QLog.e("GrayTipsItemBuilder", 1, "handle renewal gray tips click, action not support yet, action=" + this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      MsgProxyUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4020);
      return;
      paramView = (IndividuationABTestManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(176);
      if (paramView.jdField_a_of_type_Int == 0) {}
      for (;;)
      {
        VasWebviewUtil.openIndividuationIndex(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext);
        VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_personality", "", 1, 0, 0, "", "", "");
        break;
        if (!TextUtils.isEmpty(paramView.jdField_a_of_type_JavaLangString)) {}
      }
      EmojiHomeUiPlugin.openEmojiHomePage((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 10, false, "");
      VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_emoji", "", 1, 0, 0, "", "", "");
      continue;
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramView.putExtra("individuation_url_type", 40306);
      VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, IndividuationUrlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, "bubble", "mvip.gongneng.android.bubble.index_dynamic_tab"), 64L, paramView, false, -1);
      VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_bubble", "", 1, 0, 0, "", "", "");
      continue;
      if (!BaseApplicationImpl.IS_SUPPORT_THEME) {
        Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext.getString(2131434090), 0).show();
      }
      for (;;)
      {
        VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_theme", "", 1, 0, 0, "", "", "");
        break;
        if (Utils.a())
        {
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
          paramView.putExtra("individuation_url_type", 40306);
          VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, IndividuationUrlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, "theme", "mvip.gongneng.android.theme.index_dynamic_tab"), 32L, paramView, true, -1);
        }
        else
        {
          Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext.getString(2131434770), 0).show();
        }
      }
      if (!Utils.a()) {
        Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext.getString(2131434770), 0).show();
      }
      for (;;)
      {
        VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_widget", "", 1, 0, 0, "", "", "");
        break;
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        paramView.putExtra("individuation_url_type", 40100);
        paramView.putExtra("vasUsePreWebview", true);
        paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
        paramView.putExtra("hide_left_button", false);
        paramView.putExtra("show_right_close_button", false);
        paramView.putExtra("url", IndividuationUrlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, "pendant", ""));
        paramView.putExtra("business", 512L);
        VasWebviewUtil.insertVasWbPluginToIntent(512L, paramView);
        paramView.putExtra("isShowAd", false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      }
      if (!((FontManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41)).c())
      {
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, ChatTextSizeSettingActivity.class);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      }
      for (;;)
      {
        VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_font", "", 1, 0, 0, "", "", "");
        break;
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        paramView.putExtra("hide_left_button", false);
        paramView.putExtra("show_right_close_button", false);
        paramView.putExtra("individuation_url_type", 40100);
        paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
        VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, IndividuationUrlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, "font", ""), 4096L, paramView, false, -1);
      }
      paramView = new Intent();
      paramView.putExtra("vasUsePreWebview", true);
      paramView.putExtra("bg_replace_entrance", 8);
      paramView.putExtra("hide_left_button", false);
      paramView.putExtra("show_right_close_button", false);
      paramView.putExtra("individuation_url_type", 40306);
      VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, IndividuationUrlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, "background", ""), 33554432L, paramView, false, -1);
      VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_background", "", 1, 0, 0, "", "", "");
      continue;
      ProfileCardUtil.a((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "inside.myIndividuation", 1, 2, 1, "", false, false, "");
      VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_card", "", 1, 0, 0, "", "", "");
      continue;
      paramView = IndividualRedPacketManager.a(2, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      Object localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("individuation_url_type", 40100);
      VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, paramView, 134217728L, (Intent)localObject, true, -1);
      VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_redbag", "", 1, 0, 0, "", "", "");
      continue;
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramView.putExtra("individuation_url_type", 40302);
      VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, IndividuationUrlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, "bubbleDetailDialog", String.valueOf(this.b), "mvip.gongneng.android.bubble.index_dynamic_tab"), 64L, paramView, false, -1);
      VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_detail", "", 1, 0, 0, "", "", "");
      continue;
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramView.putExtra("individuation_url_type", 40302);
      VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, IndividuationUrlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, "fontDetailDialog", String.valueOf(this.b), "mvip.gexinghua.mobile.font.client_tab_store"), 4096L, paramView, false, -1);
      VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_detail", "", 1, 0, 0, "", "", "");
      continue;
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramView.putExtra("hide_left_button", false);
      paramView.putExtra("show_right_close_button", false);
      paramView.putExtra("url", IndividuationUrlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, "pendantDetailDialog", String.valueOf(this.b), "mvip.gexinghua.mobile.faceaddon.client_tab_store"));
      paramView.putExtra("business", 512L);
      paramView.putExtra("individuation_url_type", 40100);
      VasWebviewUtil.insertVasWbPluginToIntent(512L, paramView);
      paramView.putExtra("isShowAd", false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_detail", "", 1, 0, 0, "", "", "");
      continue;
      paramView = new Intent();
      paramView.putExtra("individuation_url_type", 40100);
      localObject = IndividuationUrlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, "backgroundDetail", String.valueOf(this.b), "");
      VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, (String)localObject, 33554432L, paramView, false, -1);
      VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_detail", "", 1, 0, 0, "", "", "");
      continue;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
        paramView.putExtra("isShowAd", false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      }
      else
      {
        QLog.e("GrayTipsItemBuilder", 1, "MSG_TYPE_RENEWAL_TAIL_TIP, onClick, url null");
        continue;
        VasH5PayUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, "mvip.gexinghua.android.aio_pay", "LTMCLUB", 3, false, false);
        VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "aio_pay", "aio_payclk", "", 1, 0, 0, "", String.valueOf(this.c), "");
        continue;
        VasH5PayUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, "mvip.gexinghua.android.aio_pay", "CJCLUBT", 3, false, false);
        VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "aio_pay", "aio_payclk", "", 1, 0, 0, "", String.valueOf(this.c), "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uzg
 * JD-Core Version:    0.7.0.1
 */