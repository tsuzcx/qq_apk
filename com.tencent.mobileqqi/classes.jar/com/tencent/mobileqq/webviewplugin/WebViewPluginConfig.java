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
  public static WebViewPluginConfig.PluginInfo[] a = { new WebViewPluginConfig.PluginInfo(QzonePlugin.class, "QQ????????????", "1.0"), new WebViewPluginConfig.PluginInfo(QQApiPlugin.class, "QQApi?????????", "1.0"), new WebViewPluginConfig.PluginInfo(PublicAccountJavascriptInterface.class, "??????????????????JS API", "1.0"), new WebViewPluginConfig.PluginInfo(AntiphingHandler.class, "???????????????", "1.0"), new WebViewPluginConfig.PluginInfo(CouponInterface.class, "QQ?????????JS API", "1.0"), new WebViewPluginConfig.PluginInfo(UiApiPlugin.class, "mqq.ui.* / mqq.media.* API", "1.0"), new WebViewPluginConfig.PluginInfo(RemindJavascriptInterface.class, "??????JS API", "1.0"), new WebViewPluginConfig.PluginInfo(TroopNoticeJsHandler.class, "?????????", "1.0"), new WebViewPluginConfig.PluginInfo(TroopAssistantFeedsJsHandler.class, "?????????", "1.0"), new WebViewPluginConfig.PluginInfo(AdWebviewPlugin.class, "????????????", "1.0"), new WebViewPluginConfig.PluginInfo(EqqWebviewPlugin.class, "??????QQ??????", "1.0"), new WebViewPluginConfig.PluginInfo(TroopCreateJSHandlerPlugin.class, "???????????????JS API", "1.0"), new WebViewPluginConfig.PluginInfo(TroopMemberApiPlugin.class, "???????????????JS API", "1.0"), new WebViewPluginConfig.PluginInfo(DataApiPlugin.class, "mqq.data.* API", "1.0"), new WebViewPluginConfig.PluginInfo(SensorAPIJavaScript.class, "????????? API", "1.0"), new WebViewPluginConfig.PluginInfo(WebViewJumpPlugin.class, "url???????????????", "1.0"), new WebViewPluginConfig.PluginInfo(OfflinePlugin.class, "????????????", "1.0"), new WebViewPluginConfig.PluginInfo(OpenAppDetailPlugin.class, "????????????", "1.0"), new WebViewPluginConfig.PluginInfo(TroopMemberLevelJSAPI.class, "???????????????", "1.0"), new WebViewPluginConfig.PluginInfo(OpenCenterPlugin.class, "??????API", "1.0"), new WebViewPluginConfig.PluginInfo(SosoPlugin.class, "????????????", "1.0"), new WebViewPluginConfig.PluginInfo(ReportPlugin.class, "??????", "1.0"), new WebViewPluginConfig.PluginInfo(GetKeyPlugin.class, "????????????key", "1.0"), new WebViewPluginConfig.PluginInfo(TroopWebviewPlugin.class, "troop api", "1.0"), new WebViewPluginConfig.PluginInfo(VasWebReport.class, "????????????JS", "1.0"), new WebViewPluginConfig.PluginInfo(ThemeAndBubbleCommonJsPlugin.class, "??????,????????????", "1.0"), new WebViewPluginConfig.PluginInfo(BubbleJsPlugin.class, "??????JS", "1.0"), new WebViewPluginConfig.PluginInfo(ThemeJsPlugin.class, "??????JS", "1.0"), new WebViewPluginConfig.PluginInfo(EmojiJsPlugin.class, "??????JS", "1.0"), new WebViewPluginConfig.PluginInfo(AvatarPendantJsPlugin.class, "????????????JS", "1.0"), new WebViewPluginConfig.PluginInfo(AvatarPendantUiPlugin.class, "????????????UI", "1.0"), new WebViewPluginConfig.PluginInfo(AvatarPendantSubPageUiPlugin.class, "?????????????????????UI", "1.0"), new WebViewPluginConfig.PluginInfo(RedTouchWebviewHandler.class, "??????", "1.0"), new WebViewPluginConfig.PluginInfo(MusicGeneWebViewPlugin.class, "????????????", "1.0"), new WebViewPluginConfig.PluginInfo(VasCommonJsPlugin.class, "vas????????????", "1.0"), new WebViewPluginConfig.PluginInfo(RoamMapJsPlugin.class, "????????????", "1.0"), new WebViewPluginConfig.PluginInfo(ChatFontJsPlugin.class, "????????????JS", "1.0"), new WebViewPluginConfig.PluginInfo(ChatFontUiPlugin.class, "????????????UI", "1.0"), new WebViewPluginConfig.PluginInfo(SuitUIPlugin.class, "????????????UI", "1.0"), new WebViewPluginConfig.PluginInfo(QQPluginJsPlugin.class, "???Q????????????", "1.0"), new WebViewPluginConfig.PluginInfo(EventApiPlugin.class, "mqq.event.* API", "1.0"), new WebViewPluginConfig.PluginInfo(MyBusinessWebViewPlugin.class, "???Q????????????", "1.0"), new WebViewPluginConfig.PluginInfo(HornJsPlugin.class, "??????????????????", "1.0"), new WebViewPluginConfig.PluginInfo(VipTroopUpgradePlugin.class, "???????????????", "1.0"), new WebViewPluginConfig.PluginInfo(DevLockJsPlugin.class, "?????????/JS", "1.0"), new WebViewPluginConfig.PluginInfo(SetPwdJsPlugin.class, "????????????/JS", "1.0"), new WebViewPluginConfig.PluginInfo(QzoneWebMusicJsPlugin.class, "Qzone????????????", "1.0"), new WebViewPluginConfig.PluginInfo(QZoneTihSettingWebPlugin.class, "Qzone??????????????????", "1.0"), new WebViewPluginConfig.PluginInfo(AccountReleasePlugin.class, "QQ?????????", "1.0"), new WebViewPluginConfig.PluginInfo(SSOWebviewPlugin.class, "sso??????", "1.0") };
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.WebViewPluginConfig
 * JD-Core Version:    0.7.0.1
 */