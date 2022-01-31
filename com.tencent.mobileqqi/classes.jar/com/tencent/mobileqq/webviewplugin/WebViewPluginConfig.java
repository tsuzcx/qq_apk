package com.tencent.mobileqq.webviewplugin;

import com.tencent.biz.coupon.CouponInterface;
import com.tencent.biz.eqq.EqqWebviewPlugin;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.biz.troop.TroopMemberApiPlugin;
import com.tencent.biz.webviewplugin.AccountReleasePlugin;
import com.tencent.biz.webviewplugin.AdWebviewPlugin;
import com.tencent.biz.webviewplugin.GetKeyPlugin;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.biz.webviewplugin.OpenAppDetailPlugin;
import com.tencent.biz.webviewplugin.OpenCenterPlugin;
import com.tencent.biz.webviewplugin.QZoneTihSettingWebPlugin;
import com.tencent.biz.webviewplugin.QzonePlugin;
import com.tencent.biz.webviewplugin.ReportPlugin;
import com.tencent.biz.webviewplugin.SSOWebviewPlugin;
import com.tencent.biz.webviewplugin.SosoPlugin;
import com.tencent.biz.webviewplugin.TroopMemberLevelJSAPI;
import com.tencent.mobileqq.antiphing.AntiphingHandler;
import com.tencent.mobileqq.horn.HornJsPlugin;
import com.tencent.mobileqq.jsp.DataApiPlugin;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.jsp.QQApiPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.maproam.RoamMapJsPlugin;
import com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin;
import com.tencent.mobileqq.mybusiness.MyBusinessWebViewPlugin;
import com.tencent.mobileqq.redtouch.RedTouchWebviewHandler;
import com.tencent.mobileqq.remind.RemindJavascriptInterface;
import com.tencent.mobileqq.troop.browser.TroopWebviewPlugin;
import com.tencent.mobileqq.troop.browser.VipTroopUpgradePlugin;
import com.tencent.mobileqq.troop.data.TroopCreateJSHandlerPlugin;
import com.tencent.mobileqq.troop.jsp.TroopAssistantFeedsJsHandler;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.AvatarPendantSubPageUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.AvatarPendantUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.BubbleJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ChatFontJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ChatFontUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.DevLockJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQPluginJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.SetPwdJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.SuitUIPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

public class WebViewPluginConfig
{
  public static WebViewPluginConfig.PluginInfo[] a = { new WebViewPluginConfig.PluginInfo(QzonePlugin.class, "QQ空间插件", "1.0"), new WebViewPluginConfig.PluginInfo(QQApiPlugin.class, "QQApi插件包", "1.0"), new WebViewPluginConfig.PluginInfo(PublicAccountJavascriptInterface.class, "生活服务帐号JS API", "1.0"), new WebViewPluginConfig.PluginInfo(AntiphingHandler.class, "防钓鱼插件", "1.0"), new WebViewPluginConfig.PluginInfo(CouponInterface.class, "QQ优惠券JS API", "1.0"), new WebViewPluginConfig.PluginInfo(UiApiPlugin.class, "mqq.ui.* / mqq.media.* API", "1.0"), new WebViewPluginConfig.PluginInfo(RemindJavascriptInterface.class, "提醒JS API", "1.0"), new WebViewPluginConfig.PluginInfo(TroopNoticeJsHandler.class, "群公告", "1.0"), new WebViewPluginConfig.PluginInfo(TroopAssistantFeedsJsHandler.class, "群动态", "1.0"), new WebViewPluginConfig.PluginInfo(AdWebviewPlugin.class, "广告插件", "1.0"), new WebViewPluginConfig.PluginInfo(EqqWebviewPlugin.class, "企业QQ插件", "1.0"), new WebViewPluginConfig.PluginInfo(TroopCreateJSHandlerPlugin.class, "创建群相关JS API", "1.0"), new WebViewPluginConfig.PluginInfo(TroopMemberApiPlugin.class, "群成员相关JS API", "1.0"), new WebViewPluginConfig.PluginInfo(DataApiPlugin.class, "mqq.data.* API", "1.0"), new WebViewPluginConfig.PluginInfo(SensorAPIJavaScript.class, "一起玩 API", "1.0"), new WebViewPluginConfig.PluginInfo(WebViewJumpPlugin.class, "url跳转的处理", "1.0"), new WebViewPluginConfig.PluginInfo(OfflinePlugin.class, "离线插件", "1.0"), new WebViewPluginConfig.PluginInfo(OpenAppDetailPlugin.class, "应用详情", "1.0"), new WebViewPluginConfig.PluginInfo(TroopMemberLevelJSAPI.class, "群成员等级", "1.0"), new WebViewPluginConfig.PluginInfo(OpenCenterPlugin.class, "开平API", "1.0"), new WebViewPluginConfig.PluginInfo(SosoPlugin.class, "安全检查", "1.0"), new WebViewPluginConfig.PluginInfo(ReportPlugin.class, "举报", "1.0"), new WebViewPluginConfig.PluginInfo(GetKeyPlugin.class, "拉取各种key", "1.0"), new WebViewPluginConfig.PluginInfo(TroopWebviewPlugin.class, "troop api", "1.0"), new WebViewPluginConfig.PluginInfo(VasWebReport.class, "数据上报JS", "1.0"), new WebViewPluginConfig.PluginInfo(ThemeAndBubbleCommonJsPlugin.class, "主题,气泡公共", "1.0"), new WebViewPluginConfig.PluginInfo(BubbleJsPlugin.class, "气泡JS", "1.0"), new WebViewPluginConfig.PluginInfo(ThemeJsPlugin.class, "主题JS", "1.0"), new WebViewPluginConfig.PluginInfo(EmojiJsPlugin.class, "表情JS", "1.0"), new WebViewPluginConfig.PluginInfo(AvatarPendantJsPlugin.class, "挂件商城JS", "1.0"), new WebViewPluginConfig.PluginInfo(AvatarPendantUiPlugin.class, "挂件商城UI", "1.0"), new WebViewPluginConfig.PluginInfo(AvatarPendantSubPageUiPlugin.class, "挂件商城子页面UI", "1.0"), new WebViewPluginConfig.PluginInfo(RedTouchWebviewHandler.class, "红点", "1.0"), new WebViewPluginConfig.PluginInfo(MusicGeneWebViewPlugin.class, "音乐基因", "1.0"), new WebViewPluginConfig.PluginInfo(VasCommonJsPlugin.class, "vas通用接口", "1.0"), new WebViewPluginConfig.PluginInfo(RoamMapJsPlugin.class, "随机漫游", "1.0"), new WebViewPluginConfig.PluginInfo(ChatFontJsPlugin.class, "字体商城JS", "1.0"), new WebViewPluginConfig.PluginInfo(ChatFontUiPlugin.class, "字体商城UI", "1.0"), new WebViewPluginConfig.PluginInfo(SuitUIPlugin.class, "个性套装UI", "1.0"), new WebViewPluginConfig.PluginInfo(QQPluginJsPlugin.class, "手Q插件相关", "1.0"), new WebViewPluginConfig.PluginInfo(EventApiPlugin.class, "mqq.event.* API", "1.0"), new WebViewPluginConfig.PluginInfo(MyBusinessWebViewPlugin.class, "手Q插件相关", "1.0"), new WebViewPluginConfig.PluginInfo(HornJsPlugin.class, "置顶喇叭相关", "1.0"), new WebViewPluginConfig.PluginInfo(VipTroopUpgradePlugin.class, "群升级相关", "1.0"), new WebViewPluginConfig.PluginInfo(DevLockJsPlugin.class, "设备锁/JS", "1.0"), new WebViewPluginConfig.PluginInfo(SetPwdJsPlugin.class, "修改密码/JS", "1.0"), new WebViewPluginConfig.PluginInfo(QzoneWebMusicJsPlugin.class, "Qzone背景音乐", "1.0"), new WebViewPluginConfig.PluginInfo(QZoneTihSettingWebPlugin.class, "Qzone那年今日设置", "1.0"), new WebViewPluginConfig.PluginInfo(AccountReleasePlugin.class, "QQ号注销", "1.0"), new WebViewPluginConfig.PluginInfo(SSOWebviewPlugin.class, "sso通道", "1.0") };
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.WebViewPluginConfig
 * JD-Core Version:    0.7.0.1
 */