import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

class xdn
  implements ahav.d
{
  xdn(xci paramxci, int paramInt1, int paramInt2, String paramString, int paramInt3) {}
  
  public void onClick(View paramView)
  {
    switch (this.val$action)
    {
    default: 
      QLog.e("GrayTipsItemBuilder", 1, "handle renewal gray tips click, action not support yet, action=" + this.val$action);
    }
    for (;;)
    {
      top.b(this.this$0.app, this.this$0.sessionInfo.aTl, this.this$0.sessionInfo.cZ, -4020);
      do
      {
        return;
        paramView = (aqqh)this.this$0.app.getManager(177);
        if (paramView.ebG == 0) {}
        for (;;)
        {
          VasWebviewUtil.openIndividuationIndex(this.this$0.mContext);
          VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_personality", "", 1, 0, 0, "", "", "");
          break;
          if (!TextUtils.isEmpty(paramView.jumpUrl)) {}
        }
        EmojiHomeUiPlugin.openEmojiHomePage((Activity)this.this$0.mContext, this.this$0.app.getAccount(), 10, false, "");
        VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_emoji", "", 1, 0, 0, "", "", "");
        break;
        paramView = new Intent(this.this$0.mContext, QQBrowserActivity.class);
        paramView.putExtra("individuation_url_type", 40306);
        VasWebviewUtil.openQQBrowserWithoutAD(this.this$0.mContext, aqqj.o(this.this$0.mContext, "bubble", "mvip.gongneng.android.bubble.index_dynamic_tab"), 64L, paramView, false, -1);
        VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_bubble", "", 1, 0, 0, "", "", "");
        break;
        if (!BaseApplicationImpl.IS_SUPPORT_THEME) {
          Toast.makeText(this.this$0.mContext.getApplicationContext(), this.this$0.mContext.getString(2131721032), 0).show();
        }
        for (;;)
        {
          VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_theme", "", 1, 0, 0, "", "", "");
          break;
          if (aqft.cC())
          {
            paramView = new Intent(this.this$0.mContext, QQBrowserActivity.class);
            paramView.putExtra("individuation_url_type", 40306);
            VasWebviewUtil.openQQBrowserWithoutAD(this.this$0.mContext, aqqj.o(this.this$0.mContext, "theme", "mvip.gongneng.android.theme.index_dynamic_tab"), 32L, paramView, true, -1);
          }
          else
          {
            Toast.makeText(this.this$0.mContext.getApplicationContext(), this.this$0.mContext.getString(2131719242), 0).show();
          }
        }
        if (!aqft.cC()) {
          Toast.makeText(this.this$0.mContext.getApplicationContext(), this.this$0.mContext.getString(2131719242), 0).show();
        }
        for (;;)
        {
          VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_widget", "", 1, 0, 0, "", "", "");
          break;
          paramView = new Intent(this.this$0.mContext, QQBrowserActivity.class);
          paramView.putExtra("individuation_url_type", 40100);
          paramView.putExtra("vasUsePreWebview", true);
          paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
          paramView.putExtra("hide_left_button", false);
          paramView.putExtra("show_right_close_button", false);
          paramView.putExtra("url", aqqj.o(this.this$0.mContext, "pendant", ""));
          paramView.putExtra("business", 512L);
          VasWebviewUtil.insertVasWbPluginToIntent(512L, paramView);
          paramView.putExtra("isShowAd", false);
          this.this$0.mContext.startActivity(paramView);
        }
        if (!((ku)this.this$0.app.getManager(42)).aB())
        {
          paramView = new Intent(this.this$0.mContext, ChatTextSizeSettingActivity.class);
          this.this$0.mContext.startActivity(paramView);
        }
        for (;;)
        {
          VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_font", "", 1, 0, 0, "", "", "");
          break;
          paramView = new Intent(this.this$0.mContext, QQBrowserActivity.class);
          paramView.putExtra("hide_left_button", false);
          paramView.putExtra("show_right_close_button", false);
          paramView.putExtra("individuation_url_type", 40100);
          paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
          VasWebviewUtil.openQQBrowserWithoutAD(this.this$0.mContext, aqqj.o(this.this$0.mContext, "font", ""), 4096L, paramView, false, -1);
        }
        paramView = new Intent();
        paramView.putExtra("vasUsePreWebview", true);
        paramView.putExtra("bg_replace_entrance", 8);
        paramView.putExtra("hide_left_button", false);
        paramView.putExtra("show_right_close_button", false);
        paramView.putExtra("individuation_url_type", 40306);
        VasWebviewUtil.openQQBrowserWithoutAD(this.this$0.mContext, aqqj.o(this.this$0.mContext, "background", ""), 33554432L, paramView, false, -1);
        VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_background", "", 1, 0, 0, "", "", "");
        break;
        aqep.a((Activity)this.this$0.mContext, this.this$0.app.getCurrentAccountUin(), "inside.myIndividuation", 1, 2, 1, "", false, false, "");
        VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_card", "", 1, 0, 0, "", "", "");
        break;
        paramView = acgn.a(2, this.this$0.app);
      } while (TextUtils.isEmpty(paramView));
      Object localObject = new Intent(this.this$0.mContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("individuation_url_type", 40100);
      VasWebviewUtil.openQQBrowserWithoutAD(this.this$0.mContext, paramView, 134217728L, (Intent)localObject, true, -1);
      VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_redbag", "", 1, 0, 0, "", "", "");
      continue;
      paramView = new Intent(this.this$0.mContext, QQBrowserActivity.class);
      paramView.putExtra("individuation_url_type", 40302);
      VasWebviewUtil.openQQBrowserWithoutAD(this.this$0.mContext, aqqj.e(this.this$0.mContext, "bubbleDetailDialog", String.valueOf(this.aOu), "mvip.gongneng.android.bubble.index_dynamic_tab"), 64L, paramView, false, -1);
      VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_detail", "", 1, 0, 0, "", "", "");
      continue;
      paramView = new Intent(this.this$0.mContext, QQBrowserActivity.class);
      paramView.putExtra("individuation_url_type", 40302);
      VasWebviewUtil.openQQBrowserWithoutAD(this.this$0.mContext, aqqj.e(this.this$0.mContext, "fontDetailDialog", String.valueOf(this.aOu), "mvip.gexinghua.mobile.font.client_tab_store"), 4096L, paramView, false, -1);
      VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_detail", "", 1, 0, 0, "", "", "");
      continue;
      paramView = new Intent(this.this$0.mContext, QQBrowserActivity.class);
      paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramView.putExtra("hide_left_button", false);
      paramView.putExtra("show_right_close_button", false);
      paramView.putExtra("url", aqqj.e(this.this$0.mContext, "pendantDetailDialog", String.valueOf(this.aOu), "mvip.gexinghua.mobile.faceaddon.client_tab_store"));
      paramView.putExtra("business", 512L);
      paramView.putExtra("individuation_url_type", 40100);
      VasWebviewUtil.insertVasWbPluginToIntent(512L, paramView);
      paramView.putExtra("isShowAd", false);
      this.this$0.mContext.startActivity(paramView);
      VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_detail", "", 1, 0, 0, "", "", "");
      continue;
      paramView = new Intent();
      paramView.putExtra("individuation_url_type", 40100);
      localObject = aqqj.e(this.this$0.mContext, "backgroundDetail", String.valueOf(this.aOu), "");
      VasWebviewUtil.openQQBrowserWithoutAD(this.this$0.mContext, (String)localObject, 33554432L, paramView, false, -1);
      VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_detail", "", 1, 0, 0, "", "", "");
      continue;
      if (!TextUtils.isEmpty(this.aUR))
      {
        paramView = new Intent(this.this$0.mContext, QQBrowserActivity.class);
        paramView.putExtra("url", this.aUR);
        paramView.putExtra("isShowAd", false);
        this.this$0.mContext.startActivity(paramView);
      }
      else
      {
        QLog.e("GrayTipsItemBuilder", 1, "MSG_TYPE_RENEWAL_TAIL_TIP, onClick, url null");
        continue;
        aqrf.a(this.this$0.mContext, "mvip.gexinghua.android.aio_pay", "LTMCLUB", 3, false, false);
        VasWebviewUtil.reportCommercialDrainage(this.this$0.sessionInfo.aTl, "aio_pay", "aio_payclk", "", 1, 0, 0, "", String.valueOf(this.bTd), "");
        continue;
        aqrf.a(this.this$0.mContext, "mvip.gexinghua.android.aio_pay", "CJCLUBT", 3, false, false);
        VasWebviewUtil.reportCommercialDrainage(this.this$0.sessionInfo.aTl, "aio_pay", "aio_payclk", "", 1, 0, 0, "", String.valueOf(this.bTd), "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xdn
 * JD-Core Version:    0.7.0.1
 */