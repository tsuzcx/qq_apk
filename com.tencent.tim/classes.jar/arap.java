import android.text.TextUtils;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.biz.webviewplugin.GamePartyPlugin;
import com.tencent.biz.webviewplugin.NewerGuidePlugin;
import com.tencent.biz.webviewplugin.PayJsPlugin;
import com.tencent.biz.webviewplugin.WeizhengquanJsPlugin;
import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.mobileqq.apollo.game.ApolloGamePlugin;
import com.tencent.mobileqq.confess.ConfessPlugin;
import com.tencent.mobileqq.jsp.AECameraPlugin;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.jsp.WebRecordApiPlugin;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebViewJsPlugin;
import com.tencent.mobileqq.nearby.NearbyJsInterface;
import com.tencent.mobileqq.redtouch.RedTouchWebviewHandler;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.AvatarPendantUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.BubbleJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.BubbleUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.BuscardJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ChatBackgroundJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ChatBackgroundUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ChatFontJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ChatFontUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ColorRingUIPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ColorScreenJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.DailySignInWebviewPlugin;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.EmojiSubHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.FunnyPicJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.HealthUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.IndividualRedPacketJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.vaswebviewplugin.KingCardJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.LocalDataJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.PraiseJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ProfileDiyJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QLBQJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQAioBackgroundPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQCardJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQLevelJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQReaderJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.RegLiangHaoJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.SignJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.StarJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.SuitUIPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VipClubJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VipComicJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VipFunCallJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VipFunctionJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.WadlWebViewJsPlugin;
import com.tencent.mobileqq.webview.sonic.SonicJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import java.util.HashMap;

public class arap
{
  public static final HashMap<String, Integer> sPluginNameSpaceHashMap = new HashMap();
  
  static
  {
    sPluginNameSpaceHashMap.put("qbizApi", Integer.valueOf(3));
    sPluginNameSpaceHashMap.put("coupon", Integer.valueOf(1));
    sPluginNameSpaceHashMap.put("eqq", Integer.valueOf(2));
    sPluginNameSpaceHashMap.put("lebaPlugin", Integer.valueOf(4));
    sPluginNameSpaceHashMap.put("PublicAccountJs", Integer.valueOf(6));
    sPluginNameSpaceHashMap.put("publicAccountNew", Integer.valueOf(7));
    sPluginNameSpaceHashMap.put("TroopMemberApiPlugin", Integer.valueOf(8));
    sPluginNameSpaceHashMap.put("gameTeam", Integer.valueOf(10));
    sPluginNameSpaceHashMap.put("redEnvelope", Integer.valueOf(12));
    sPluginNameSpaceHashMap.put("hotchat", Integer.valueOf(13));
    sPluginNameSpaceHashMap.put("NearbyTroopsPlugin", Integer.valueOf(14));
    sPluginNameSpaceHashMap.put("newerguide", Integer.valueOf(15));
    sPluginNameSpaceHashMap.put("offline", Integer.valueOf(16));
    sPluginNameSpaceHashMap.put("openToAppDetail", Integer.valueOf(17));
    sPluginNameSpaceHashMap.put(suf.class.getSimpleName(), Integer.valueOf(20));
    sPluginNameSpaceHashMap.put("mail", Integer.valueOf(21));
    sPluginNameSpaceHashMap.put(suw.PLUGIN_NAMESPACE, Integer.valueOf(22));
    sPluginNameSpaceHashMap.put("qztodayinhistory", Integer.valueOf(23));
    sPluginNameSpaceHashMap.put("QzoneData", Integer.valueOf(24));
    sPluginNameSpaceHashMap.put(svc.PLUGIN_NAMESPACE, Integer.valueOf(25));
    sPluginNameSpaceHashMap.put("share", Integer.valueOf(26));
    sPluginNameSpaceHashMap.put("UrlSaveVerifyV2", Integer.valueOf(171));
    sPluginNameSpaceHashMap.put("troop_member_level_JS_API", Integer.valueOf(30));
    sPluginNameSpaceHashMap.put("URL_CHECK", Integer.valueOf(31));
    sPluginNameSpaceHashMap.put("WebSo", Integer.valueOf(32));
    sPluginNameSpaceHashMap.put("QQConnect", Integer.valueOf(33));
    sPluginNameSpaceHashMap.put("GCApi", Integer.valueOf(34));
    sPluginNameSpaceHashMap.put("specialRing", Integer.valueOf(35));
    sPluginNameSpaceHashMap.put("InputClickEvent", Integer.valueOf(36));
    sPluginNameSpaceHashMap.put("data", Integer.valueOf(38));
    sPluginNameSpaceHashMap.put("x5", Integer.valueOf(166));
    sPluginNameSpaceHashMap.put("device", Integer.valueOf(39));
    sPluginNameSpaceHashMap.put("event", Integer.valueOf(40));
    sPluginNameSpaceHashMap.put("media", Integer.valueOf(41));
    sPluginNameSpaceHashMap.put("QQApi", Integer.valueOf(42));
    sPluginNameSpaceHashMap.put("sms", Integer.valueOf(43));
    sPluginNameSpaceHashMap.put("troopApi", Integer.valueOf(44));
    sPluginNameSpaceHashMap.put("ui", Integer.valueOf(45));
    sPluginNameSpaceHashMap.put("docx", Integer.valueOf(134));
    sPluginNameSpaceHashMap.put("webRecord", Integer.valueOf(46));
    sPluginNameSpaceHashMap.put("qqmusic", Integer.valueOf(47));
    sPluginNameSpaceHashMap.put("odapp", Integer.valueOf(49));
    sPluginNameSpaceHashMap.put("huayang", Integer.valueOf(128));
    sPluginNameSpaceHashMap.put("card", Integer.valueOf(50));
    sPluginNameSpaceHashMap.put("usersummary", Integer.valueOf(131));
    sPluginNameSpaceHashMap.put("signIn", Integer.valueOf(138));
    sPluginNameSpaceHashMap.put("RealName", Integer.valueOf(95));
    sPluginNameSpaceHashMap.put("newLogin", Integer.valueOf(174));
    sPluginNameSpaceHashMap.put("redpoint", Integer.valueOf(52));
    sPluginNameSpaceHashMap.put("REMIND", Integer.valueOf(53));
    sPluginNameSpaceHashMap.put("calendar", Integer.valueOf(53));
    sPluginNameSpaceHashMap.put("ptv", Integer.valueOf(54));
    sPluginNameSpaceHashMap.put("troopAssistantFeeds", Integer.valueOf(57));
    sPluginNameSpaceHashMap.put("troopNotice", Integer.valueOf(58));
    sPluginNameSpaceHashMap.put("healthSport", Integer.valueOf(59));
    sPluginNameSpaceHashMap.put("healthkit", Integer.valueOf(60));
    sPluginNameSpaceHashMap.put("healthpathtrace", Integer.valueOf(127));
    sPluginNameSpaceHashMap.put("apollo", Integer.valueOf(61));
    sPluginNameSpaceHashMap.put("faceAddon", Integer.valueOf(62));
    sPluginNameSpaceHashMap.put("bubble", Integer.valueOf(64));
    sPluginNameSpaceHashMap.put("colorScreen", Integer.valueOf(154));
    sPluginNameSpaceHashMap.put("face", Integer.valueOf(159));
    sPluginNameSpaceHashMap.put("praise", Integer.valueOf(141));
    sPluginNameSpaceHashMap.put("diycard", Integer.valueOf(148));
    sPluginNameSpaceHashMap.put("chatBg", Integer.valueOf(66));
    sPluginNameSpaceHashMap.put("font", Integer.valueOf(68));
    sPluginNameSpaceHashMap.put("colorRing", Integer.valueOf(70));
    sPluginNameSpaceHashMap.put("emoji", Integer.valueOf(73));
    sPluginNameSpaceHashMap.put("qutu", Integer.valueOf(77));
    sPluginNameSpaceHashMap.put("individualRedPacket", Integer.valueOf(79));
    sPluginNameSpaceHashMap.put("individuation", Integer.valueOf(80));
    sPluginNameSpaceHashMap.put("msgRoam", Integer.valueOf(82));
    sPluginNameSpaceHashMap.put("SetPwdJsInterface", Integer.valueOf(83));
    sPluginNameSpaceHashMap.put("EquipLockManager", Integer.valueOf(83));
    sPluginNameSpaceHashMap.put("CAPTCHA", Integer.valueOf(83));
    sPluginNameSpaceHashMap.put("qqcard", Integer.valueOf(85));
    sPluginNameSpaceHashMap.put("qw_bluetooth", Integer.valueOf(156));
    sPluginNameSpaceHashMap.put("qw_charge", Integer.valueOf(88));
    sPluginNameSpaceHashMap.put("qw.pay", Integer.valueOf(89));
    sPluginNameSpaceHashMap.put("qw_pay", Integer.valueOf(186));
    sPluginNameSpaceHashMap.put("qw_mix", Integer.valueOf(188));
    sPluginNameSpaceHashMap.put("starclub", Integer.valueOf(90));
    sPluginNameSpaceHashMap.put("common", Integer.valueOf(92));
    sPluginNameSpaceHashMap.put("theme", Integer.valueOf(93));
    sPluginNameSpaceHashMap.put("qw_debug", Integer.valueOf(96));
    sPluginNameSpaceHashMap.put("qw_data", Integer.valueOf(96));
    sPluginNameSpaceHashMap.put("friendData", Integer.valueOf(96));
    sPluginNameSpaceHashMap.put("debug", Integer.valueOf(97));
    sPluginNameSpaceHashMap.put("ppreloader", Integer.valueOf(100));
    sPluginNameSpaceHashMap.put("funCall", Integer.valueOf(101));
    sPluginNameSpaceHashMap.put("QQVIPFunction", Integer.valueOf(102));
    sPluginNameSpaceHashMap.put("video", Integer.valueOf(103));
    sPluginNameSpaceHashMap.put("gift", Integer.valueOf(104));
    sPluginNameSpaceHashMap.put(ardn.PLUGIN_NAMESPACE, Integer.valueOf(106));
    sPluginNameSpaceHashMap.put("comicFavor", Integer.valueOf(108));
    sPluginNameSpaceHashMap.put("QzMusic", Integer.valueOf(111));
    sPluginNameSpaceHashMap.put("Qzone", Integer.valueOf(112));
    sPluginNameSpaceHashMap.put("qzDynamicAlbum", Integer.valueOf(112));
    sPluginNameSpaceHashMap.put("QZImagePicker", Integer.valueOf(112));
    sPluginNameSpaceHashMap.put("checkin", Integer.valueOf(112));
    sPluginNameSpaceHashMap.put("qzlive", Integer.valueOf(112));
    sPluginNameSpaceHashMap.put("qqexplive", Integer.valueOf(112));
    sPluginNameSpaceHashMap.put("qzui", Integer.valueOf(112));
    sPluginNameSpaceHashMap.put("QzoneUpload", Integer.valueOf(112));
    sPluginNameSpaceHashMap.put("QzoneAudio", Integer.valueOf(112));
    sPluginNameSpaceHashMap.put(awgz.PKG_NAME, Integer.valueOf(113));
    sPluginNameSpaceHashMap.put("QzMoodSelectPicture", Integer.valueOf(114));
    sPluginNameSpaceHashMap.put("QzCover", Integer.valueOf(115));
    sPluginNameSpaceHashMap.put("qzcardstorre", Integer.valueOf(116));
    sPluginNameSpaceHashMap.put("QzAvatar", Integer.valueOf(116));
    sPluginNameSpaceHashMap.put("QzFloat", Integer.valueOf(116));
    sPluginNameSpaceHashMap.put("story", Integer.valueOf(121));
    sPluginNameSpaceHashMap.put("homework", Integer.valueOf(117));
    sPluginNameSpaceHashMap.put("publicAccount", Integer.valueOf(5));
    sPluginNameSpaceHashMap.put("pay", Integer.valueOf(19));
    sPluginNameSpaceHashMap.put("qw", Integer.valueOf(157));
    sPluginNameSpaceHashMap.put(String.valueOf(2L), Integer.valueOf(72));
    sPluginNameSpaceHashMap.put(String.valueOf(8L), Integer.valueOf(75));
    sPluginNameSpaceHashMap.put(String.valueOf(512L), Integer.valueOf(63));
    sPluginNameSpaceHashMap.put(String.valueOf(4096L), Integer.valueOf(69));
    sPluginNameSpaceHashMap.put(String.valueOf(1048576L), Integer.valueOf(81));
    sPluginNameSpaceHashMap.put(String.valueOf(65536L), Integer.valueOf(78));
    sPluginNameSpaceHashMap.put(String.valueOf(262144L), Integer.valueOf(91));
    sPluginNameSpaceHashMap.put(String.valueOf(33554432L), Integer.valueOf(67));
    sPluginNameSpaceHashMap.put(String.valueOf(64L), Integer.valueOf(65));
    sPluginNameSpaceHashMap.put(String.valueOf(32L), Integer.valueOf(94));
    sPluginNameSpaceHashMap.put(String.valueOf(4L), Integer.valueOf(74));
    sPluginNameSpaceHashMap.put(String.valueOf(4194304L), Integer.valueOf(71));
    sPluginNameSpaceHashMap.put("Troop", Integer.valueOf(55));
    sPluginNameSpaceHashMap.put("deviceapp", Integer.valueOf(118));
    sPluginNameSpaceHashMap.put("qqreader", Integer.valueOf(119));
    sPluginNameSpaceHashMap.put("sso", Integer.valueOf(29));
    sPluginNameSpaceHashMap.put("nfc", Integer.valueOf(120));
    sPluginNameSpaceHashMap.put("gdtReportPlugin", Integer.valueOf(122));
    sPluginNameSpaceHashMap.put("pubAccountPreload", Integer.valueOf(125));
    sPluginNameSpaceHashMap.put("medalwall", Integer.valueOf(124));
    sPluginNameSpaceHashMap.put("pubAccountUI", Integer.valueOf(129));
    sPluginNameSpaceHashMap.put("nearby", Integer.valueOf(126));
    sPluginNameSpaceHashMap.put("sensor", Integer.valueOf(150));
    sPluginNameSpaceHashMap.put("arcard", Integer.valueOf(164));
    sPluginNameSpaceHashMap.put("sonic", Integer.valueOf(132));
    sPluginNameSpaceHashMap.put("SwiftHttp", Integer.valueOf(132));
    sPluginNameSpaceHashMap.put("Weiyun", Integer.valueOf(135));
    sPluginNameSpaceHashMap.put("JD_REPORT", Integer.valueOf(133));
    sPluginNameSpaceHashMap.put("readinjoy", Integer.valueOf(136));
    sPluginNameSpaceHashMap.put("babyQ", Integer.valueOf(137));
    sPluginNameSpaceHashMap.put("historyhead", Integer.valueOf(139));
    sPluginNameSpaceHashMap.put("wadl_download", Integer.valueOf(140));
    sPluginNameSpaceHashMap.put("comic", Integer.valueOf(142));
    sPluginNameSpaceHashMap.put("campus_circle", Integer.valueOf(143));
    sPluginNameSpaceHashMap.put("groupVideo", Integer.valueOf(144));
    sPluginNameSpaceHashMap.put("qq_gdt_ad", Integer.valueOf(145));
    sPluginNameSpaceHashMap.put("qq_imax_ad", Integer.valueOf(176));
    sPluginNameSpaceHashMap.put("SocialWeekly", Integer.valueOf(146));
    sPluginNameSpaceHashMap.put("msgForward", Integer.valueOf(147));
    sPluginNameSpaceHashMap.put("profileJS", Integer.valueOf(149));
    sPluginNameSpaceHashMap.put("nowlive", Integer.valueOf(152));
    sPluginNameSpaceHashMap.put("sign", Integer.valueOf(151));
    sPluginNameSpaceHashMap.put("localData", Integer.valueOf(153));
    sPluginNameSpaceHashMap.put("qidian", Integer.valueOf(155));
    sPluginNameSpaceHashMap.put("allpeoplevote", Integer.valueOf(158));
    sPluginNameSpaceHashMap.put("ftssearch", Integer.valueOf(160));
    sPluginNameSpaceHashMap.put("MixSearchWeb", Integer.valueOf(169));
    sPluginNameSpaceHashMap.put("qlbq", Integer.valueOf(161));
    sPluginNameSpaceHashMap.put("sayHonest", Integer.valueOf(162));
    sPluginNameSpaceHashMap.put("readInJoyWebRender", Integer.valueOf(163));
    sPluginNameSpaceHashMap.put("apolloGame", Integer.valueOf(167));
    sPluginNameSpaceHashMap.put("GdtWebReportPlugin", Integer.valueOf(170));
    sPluginNameSpaceHashMap.put("bless", Integer.valueOf(172));
    sPluginNameSpaceHashMap.put("haomaReg", Integer.valueOf(173));
    sPluginNameSpaceHashMap.put("extendFriend", Integer.valueOf(175));
    sPluginNameSpaceHashMap.put("identification", Integer.valueOf(177));
    sPluginNameSpaceHashMap.put("location", Integer.valueOf(179));
    sPluginNameSpaceHashMap.put("accountRelease", Integer.valueOf(180));
    sPluginNameSpaceHashMap.put("miniApp", Integer.valueOf(181));
    sPluginNameSpaceHashMap.put("Gdt", Integer.valueOf(182));
    sPluginNameSpaceHashMap.put("ReadinjoyAdJs", Integer.valueOf(183));
    sPluginNameSpaceHashMap.put("profie_edit", Integer.valueOf(184));
    sPluginNameSpaceHashMap.put("jubao", Integer.valueOf(185));
    sPluginNameSpaceHashMap.put("emoticon", Integer.valueOf(190));
    sPluginNameSpaceHashMap.put("addContact_SecCheck", Integer.valueOf(187));
    sPluginNameSpaceHashMap.put("robotsummary", Integer.valueOf(191));
    sPluginNameSpaceHashMap.put("gflivesdk", Integer.valueOf(192));
    sPluginNameSpaceHashMap.put("qsubscribe", Integer.valueOf(189));
    sPluginNameSpaceHashMap.put("userVerify", Integer.valueOf(385));
    sPluginNameSpaceHashMap.put("friendApi", Integer.valueOf(193));
    sPluginNameSpaceHashMap.put("kingCard", Integer.valueOf(194));
    sPluginNameSpaceHashMap.put("vipclub", Integer.valueOf(200));
    sPluginNameSpaceHashMap.put("emojiEggSetting", Integer.valueOf(195));
    sPluginNameSpaceHashMap.put("interactionScore", Integer.valueOf(195));
    sPluginNameSpaceHashMap.put("listenTogether", Integer.valueOf(196));
    sPluginNameSpaceHashMap.put("floatingWindow", Integer.valueOf(197));
    sPluginNameSpaceHashMap.put("connect", Integer.valueOf(203));
    sPluginNameSpaceHashMap.put("push", Integer.valueOf(204));
    sPluginNameSpaceHashMap.put("faceUnblockCamera", Integer.valueOf(199));
    sPluginNameSpaceHashMap.put("levelicon", Integer.valueOf(201));
    sPluginNameSpaceHashMap.put("background", Integer.valueOf(202));
    sPluginNameSpaceHashMap.put("aioShareMusic", Integer.valueOf(208));
    sPluginNameSpaceHashMap.put(ahvj.PLUGIN_NAMESPACE, Integer.valueOf(205));
    sPluginNameSpaceHashMap.put("together_business", Integer.valueOf(206));
    sPluginNameSpaceHashMap.put("JSRoot", Integer.valueOf(207));
    sPluginNameSpaceHashMap.put("JSToast", Integer.valueOf(207));
    sPluginNameSpaceHashMap.put("JSBookDir", Integer.valueOf(207));
    sPluginNameSpaceHashMap.put("JSPublicAccount", Integer.valueOf(207));
    sPluginNameSpaceHashMap.put("JSTopRightButton", Integer.valueOf(207));
    sPluginNameSpaceHashMap.put("JSTittlebarAction", Integer.valueOf(207));
    sPluginNameSpaceHashMap.put("JSPay", Integer.valueOf(207));
    sPluginNameSpaceHashMap.put("JSPublicAccountUtil", Integer.valueOf(207));
    sPluginNameSpaceHashMap.put("JSRedTouch", Integer.valueOf(207));
    sPluginNameSpaceHashMap.put("JSBookDetailForQQ", Integer.valueOf(207));
    sPluginNameSpaceHashMap.put("JSbookshelf", Integer.valueOf(207));
    sPluginNameSpaceHashMap.put("JSContent", Integer.valueOf(207));
    sPluginNameSpaceHashMap.put("readonline", Integer.valueOf(207));
    sPluginNameSpaceHashMap.put("JSPopupList", Integer.valueOf(207));
    sPluginNameSpaceHashMap.put("JSTypeface", Integer.valueOf(207));
    sPluginNameSpaceHashMap.put("aecamera", Integer.valueOf(209));
    sPluginNameSpaceHashMap.put("historicalSig", Integer.valueOf(210));
    sPluginNameSpaceHashMap.put("login", Integer.valueOf(215));
    sPluginNameSpaceHashMap.put("studyroom", Integer.valueOf(216));
    sPluginNameSpaceHashMap.put("groupInteractionIcon", Integer.valueOf(214));
    sPluginNameSpaceHashMap.put("kdSearchResult", Integer.valueOf(212));
    sPluginNameSpaceHashMap.put("GroupAppPanel", Integer.valueOf(213));
    sPluginNameSpaceHashMap.put("qcircle", Integer.valueOf(217));
    sPluginNameSpaceHashMap.put("weather", Integer.valueOf(219));
    sPluginNameSpaceHashMap.put("deviceProtect", Integer.valueOf(218));
    sPluginNameSpaceHashMap.put(MiniGamePublicAccountWebViewJsPlugin.PLUGIN_NAMESPACE, Integer.valueOf(221));
    sPluginNameSpaceHashMap.put("accounts", Integer.valueOf(222));
  }
  
  public static WebViewPlugin a(int paramInt)
  {
    switch (paramInt)
    {
    case 9: 
    case 11: 
    case 16: 
    case 18: 
    case 20: 
    case 22: 
    case 25: 
    case 27: 
    case 28: 
    case 36: 
    case 37: 
    case 40: 
    case 48: 
    case 51: 
    case 76: 
    case 84: 
    case 86: 
    case 87: 
    case 97: 
    case 98: 
    case 99: 
    case 105: 
    case 107: 
    case 109: 
    case 110: 
    case 118: 
    case 123: 
    case 130: 
    case 165: 
    case 168: 
    case 171: 
    case 178: 
    case 198: 
    case 211: 
    case 220: 
    case 223: 
    case 224: 
    case 225: 
    case 226: 
    case 227: 
    case 228: 
    case 229: 
    case 230: 
    case 231: 
    case 232: 
    case 233: 
    case 234: 
    case 235: 
    case 236: 
    case 237: 
    case 238: 
    case 239: 
    case 240: 
    case 241: 
    case 242: 
    case 243: 
    case 244: 
    case 245: 
    case 246: 
    case 247: 
    case 248: 
    case 249: 
    case 250: 
    case 251: 
    case 252: 
    case 253: 
    case 254: 
    case 255: 
    case 256: 
    case 257: 
    case 258: 
    case 259: 
    case 260: 
    case 261: 
    case 262: 
    case 263: 
    case 264: 
    case 265: 
    case 266: 
    case 267: 
    case 268: 
    case 269: 
    case 270: 
    case 271: 
    case 272: 
    case 273: 
    case 274: 
    case 275: 
    case 276: 
    case 277: 
    case 278: 
    case 279: 
    case 280: 
    case 281: 
    case 282: 
    case 283: 
    case 284: 
    case 285: 
    case 286: 
    case 287: 
    case 288: 
    case 289: 
    case 290: 
    case 291: 
    case 292: 
    case 293: 
    case 294: 
    case 295: 
    case 296: 
    case 297: 
    case 298: 
    case 299: 
    case 300: 
    case 301: 
    case 302: 
    case 303: 
    case 304: 
    case 305: 
    case 306: 
    case 307: 
    case 308: 
    case 309: 
    case 310: 
    case 311: 
    case 312: 
    case 313: 
    case 314: 
    case 315: 
    case 316: 
    case 317: 
    case 318: 
    case 319: 
    case 320: 
    case 321: 
    case 322: 
    case 323: 
    case 324: 
    case 325: 
    case 326: 
    case 327: 
    case 328: 
    case 329: 
    case 330: 
    case 331: 
    case 332: 
    case 333: 
    case 334: 
    case 335: 
    case 336: 
    case 337: 
    case 338: 
    case 339: 
    case 340: 
    case 341: 
    case 342: 
    case 343: 
    case 344: 
    case 345: 
    case 346: 
    case 347: 
    case 348: 
    case 349: 
    case 350: 
    case 351: 
    case 352: 
    case 353: 
    case 354: 
    case 355: 
    case 356: 
    case 357: 
    case 358: 
    case 359: 
    case 360: 
    case 361: 
    case 362: 
    case 363: 
    case 364: 
    case 365: 
    case 366: 
    case 367: 
    case 368: 
    case 369: 
    case 370: 
    case 371: 
    case 372: 
    case 373: 
    case 374: 
    case 375: 
    case 376: 
    case 377: 
    case 378: 
    case 379: 
    case 380: 
    case 381: 
    case 382: 
    case 383: 
    case 384: 
    default: 
      return null;
    case 61: 
      return new ApolloJsPlugin();
    case 170: 
      return new tnf();
    case 62: 
      return new AvatarPendantJsPlugin();
    case 63: 
      return new AvatarPendantUiPlugin();
    case 64: 
      return new BubbleJsPlugin();
    case 154: 
      return new ColorScreenJsPlugin();
    case 159: 
      return new aqsh();
    case 65: 
      return new BubbleUiPlugin();
    case 141: 
      return new PraiseJsPlugin();
    case 66: 
      return new ChatBackgroundJsPlugin();
    case 67: 
      return new ChatBackgroundUiPlugin();
    case 68: 
      return new ChatFontJsPlugin();
    case 69: 
      return new ChatFontUiPlugin();
    case 70: 
      return new ColorRingJsPlugin();
    case 71: 
      return new ColorRingUIPlugin();
    case 1: 
      return new jqq();
    case 38: 
      return new aiiu();
    case 166: 
      return new ailw();
    case 121: 
      return new aijz();
    case 39: 
      return new aiiw();
    case 72: 
      return new EmojiHomeUiPlugin();
    case 73: 
      return new EmojiJsPlugin();
    case 74: 
      return new EmojiSubHomeUiPlugin();
    case 75: 
      return new aquh();
    case 2: 
      return new jqw();
    case 77: 
      return new FunnyPicJsPlugin();
    case 34: 
      return new GameCenterAPIJavaScript();
    case 10: 
      return new GamePartyPlugin();
    case 12: 
      return new ssv();
    case 59: 
      return new HealthBusinessPlugin();
    case 60: 
      return new aqtm();
    case 127: 
      return new aqtl();
    case 78: 
      return new HealthUiPlugin();
    case 13: 
      return new ssx();
    case 79: 
      return new IndividualRedPacketJsPlugin();
    case 80: 
      return new IndividuationPlugin();
    case 81: 
      return new aqui();
    case 4: 
      return new jrz();
    case 83: 
      return new MQPSecJsPlugin();
    case 41: 
      return new MediaApiPlugin();
    case 82: 
      return new MessageRoamJsPlugin();
    case 47: 
      return new ajmu();
    case 135: 
      return new awpj();
    case 14: 
      return new sth();
    case 15: 
      return new NewerGuidePlugin();
    case 49: 
      return new aigr();
    case 128: 
      return new aidi();
    case 95: 
      return new alsp();
    case 174: 
      return new yoe();
    case 17: 
      return new sue();
    case 19: 
      return new PayJsPlugin();
    case 157: 
      return new WeizhengquanJsPlugin();
    case 50: 
      return new alcu();
    case 131: 
      return new aldc();
    case 191: 
      return new svr();
    case 138: 
      return new DailySignInWebviewPlugin();
    case 21: 
      return new sug();
    case 7: 
      return new obw();
    case 5: 
      return new PublicAccountJavascriptInterface();
    case 6: 
      return new kbw();
    case 42: 
      return new aiju();
    case 85: 
      return new QQCardJsPlugin();
    case 33: 
      return new taq();
    case 156: 
      return new QWalletBluetoothJsPlugin();
    case 88: 
      return new QWalletCommonJsPlugin();
    case 89: 
      return new QWalletPayJsPlugin();
    case 188: 
      return new QWalletMixJsPlugin();
    case 186: 
      return new aquj();
    case 115: 
      return new awhe();
    case 113: 
      return new awgz();
    case 116: 
      return new awhn();
    case 23: 
      return new suv();
    case 112: 
      return new awff();
    case 114: 
      return new awhc();
    case 111: 
      return new QzoneWebMusicJsPlugin();
    case 24: 
      return new sux();
    case 52: 
      return new RedTouchWebviewHandler();
    case 53: 
      return new alvc();
    case 29: 
      return new svd();
    case 3: 
      return new SensorAPIJavaScript();
    case 26: 
      return new svn();
    case 54: 
      return new ankv();
    case 43: 
      return new aikc();
    case 90: 
      return new StarJsPlugin();
    case 91: 
      return new SuitUIPlugin();
    case 92: 
      return new ThemeAndBubbleCommonJsPlugin();
    case 93: 
      return new ThemeJsPlugin();
    case 94: 
      return new ThemeUiPlugin();
    case 44: 
      return new aikg();
    case 57: 
      return new apmi();
    case 117: 
      return new TroopHWJsPlugin();
    case 8: 
      return new skl();
    case 30: 
      return new svq();
    case 58: 
      return new apmj();
    case 55: 
      return new aoye();
    case 45: 
      return new UiApiPlugin();
    case 134: 
      return new aiiy();
    case 31: 
      return new svs();
    case 96: 
      return new VasCommonJsPlugin();
    case 108: 
      return new avdf();
    case 100: 
      return new VipComicJsPlugin();
    case 101: 
      return new VipFunCallJsPlugin();
    case 102: 
      return new VipFunctionJsPlugin();
    case 104: 
      return new aqxl();
    case 35: 
      return new abcb();
    case 56: 
      return new aoyj();
    case 103: 
      return new aqur();
    case 46: 
      return new WebRecordApiPlugin();
    case 32: 
      return new svv();
    case 106: 
      return new ardn();
    case 119: 
      return new QQReaderJsPlugin();
    case 120: 
      return new BuscardJsPlugin();
    case 122: 
      return new awee();
    case 124: 
      return new aijm();
    case 125: 
      return new sum();
    case 129: 
      return new sun();
    case 126: 
      return new NearbyJsInterface();
    case 150: 
      return new ssr();
    case 164: 
      return new ssq();
    case 132: 
      return new SonicJsPlugin();
    case 133: 
      return new sst();
    case 136: 
      return new ljr();
    case 137: 
      return new acbp();
    case 139: 
      return new albd();
    case 140: 
      return new WadlWebViewJsPlugin();
    case 142: 
      return new avdn();
    case 143: 
      return new aeak();
    case 144: 
      return new aico();
    case 145: 
      return new tjs();
    case 176: 
      return new aibf();
    case 146: 
      return new ardl();
    case 147: 
      return new ajhi();
    case 149: 
      return new albe();
    case 148: 
      return new ProfileDiyJsPlugin();
    case 152: 
      return new aifh();
    case 151: 
      return new SignJsPlugin();
    case 153: 
      return new LocalDataJsPlugin();
    case 155: 
      return new asid();
    case 158: 
      return new arei();
    case 160: 
      return new ails();
    case 169: 
      return new aijr();
    case 161: 
      return new QLBQJsPlugin();
    case 162: 
      return new ConfessPlugin();
    case 163: 
      return new svb();
    case 167: 
      return new ApolloGamePlugin();
    case 172: 
      return new ylj();
    case 173: 
      return new RegLiangHaoJsPlugin();
    case 175: 
      return new afsx();
    case 177: 
      return new aijf();
    case 179: 
      return new ste();
    case 180: 
      return new sss();
    case 181: 
      return new MiniAppPlugin();
    case 182: 
      return new aike();
    case 183: 
      return new kml();
    case 184: 
      return new alcy();
    case 185: 
      return new ailx();
    case 190: 
      return new afrk();
    case 189: 
      return new rzb();
    case 187: 
      return new ymv();
    case 192: 
      return new aijj();
    case 385: 
      return new svh();
    case 193: 
      return new aije();
    case 194: 
      return new KingCardJsPlugin();
    case 200: 
      return new VipClubJsPlugin();
    case 195: 
      return new aiid();
    case 196: 
      return new ainw();
    case 197: 
      return new arla();
    case 203: 
      return new aiis();
    case 204: 
      return new aijs();
    case 199: 
      return new zef();
    case 201: 
      return new QQLevelJsPlugin();
    case 202: 
      return new QQAioBackgroundPlugin();
    case 210: 
      return new amfl();
    case 208: 
      return new igc();
    case 206: 
      return new aihh();
    case 205: 
      return new ahvj();
    case 207: 
      return new avna();
    case 209: 
      return new AECameraPlugin();
    case 214: 
      return new aplz();
    case 212: 
      return new aiji();
    case 213: 
      return new apmh();
    case 215: 
      return new aijl();
    case 216: 
      return new aikd();
    case 217: 
      return new ouv();
    case 219: 
      return new abdk();
    case 218: 
      return new aiix();
    case 221: 
      return new MiniGamePublicAccountWebViewJsPlugin();
    }
    return new aiir();
  }
  
  public static WebViewPlugin c(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (sPluginNameSpaceHashMap.containsKey(paramString))) {
      return a(((Integer)sPluginNameSpaceHashMap.get(paramString)).intValue());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arap
 * JD-Core Version:    0.7.0.1
 */