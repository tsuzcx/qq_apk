import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper.1;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public final class aqqj
{
  private static Map<String, String> aH;
  private static final String cvA;
  private static final String cvB;
  private static final String cvC;
  private static final String cvD;
  private static final String cvE;
  private static final String cvF;
  private static final String cvG;
  private static final String cvH;
  private static final String cvI;
  private static final String cvJ;
  private static final String cvK;
  private static final String cvL;
  private static final String cvM;
  private static final String cvN;
  private static final String cvO;
  private static final String cvP;
  private static final String cvQ;
  private static final String cvR;
  private static final String cvS;
  private static final String cvg;
  private static final String cvh;
  private static final String cvi;
  private static final String cvj;
  private static final String cvk;
  private static final String cvl;
  private static final String cvm;
  private static final String cvn;
  private static final String cvo;
  private static final String cvp;
  private static final String cvq;
  private static final String cvr;
  private static final String cvs;
  private static final String cvt;
  private static final String cvu;
  private static final String cvv;
  private static final String cvw;
  private static final String cvx;
  private static final String cvy;
  private static final String cvz;
  private static AtomicBoolean dy = new AtomicBoolean(false);
  private static Map<String, String> oj;
  private static Map<String, String> ok;
  public static HashMap<String, aqqj.a> pe;
  
  static
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("uin=[uin]").append("&client=androidQQ").append("&version=").append("3.4.4.3058").append("&platformId=2").append("&device=").append(Build.DEVICE).append("&system=").append(Build.VERSION.RELEASE).append("&density=[density]");
    cvO = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/sonic/theme");
    ((StringBuilder)localObject).append("?").append(cvO).append("&_wv=16782337").append("&asyncMode=3");
    cvg = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/theme/detail");
    ((StringBuilder)localObject).append("?").append(cvO).append("&_wv=16782337").append("&id=[id]");
    cvh = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/sonic/bubble");
    ((StringBuilder)localObject).append("?").append(cvO).append("&_wv=16778243&_wwv=64&_nav_txtclr=ffffff&_nav_titleclr=ffffff").append("&asyncMode=3");
    cvi = ((StringBuilder)localObject).toString();
    cvj = "https://zb.vip.qq.com/collection/aio?_wv=1027&id=[id]&_preload=1&type=bubble";
    localObject = new StringBuilder("https://zb.vip.qq.com/bubble");
    ((StringBuilder)localObject).append("?").append(cvO).append("&_wv=1027").append("&asyncMode=3");
    cvk = "&show_type=dialog&id=[id]";
    localObject = new StringBuilder("https://zb.vip.qq.com/sonic/emoji");
    ((StringBuilder)localObject).append("?").append(cvO).append("&_wv=16778243").append("&asyncMode=3");
    cvl = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://gxh.vip.qq.com/club/themes/mobile/bq/html/detail.html");
    ((StringBuilder)localObject).append("?").append(cvO).append("&_wv=16778241").append("&_bid=102").append("&type=view").append("&id=[id]").append("&_lv=0");
    cvm = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://imgcache.qq.com/club/themes/mobile/bq/html/author.html");
    ((StringBuilder)localObject).append("?").append(cvO).append("&_wv=3").append("&_bid=102").append("&type=view").append("&id=[id]");
    cvn = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/sonic/widget");
    ((StringBuilder)localObject).append("?").append(cvO).append("&_wv=3").append("&asyncMode=3");
    cvo = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("https://zb.vip.qq.com/sonic/widget/home?").append(cvO).append("&adtag=index.h5&_wv=16778243&sharefri=[sharefri]");
    cvp = ((StringBuilder)localObject).toString();
    ((StringBuilder)localObject).setLength(0);
    ((StringBuilder)localObject).append("https://zb.vip.qq.com/widget/diyEditor?_wv=16778243&sharefri=[sharefri]");
    cvq = ((StringBuilder)localObject).toString();
    cvN = "https://club.vip.qq.com/groupkeywords/group?_wv=7&_wwv=4&_wvx=10&_proxy=1&groupid=[groupid]";
    cvx = "https://zb.vip.qq.com/v2/mall/face?_wv=5123&_nav_titleclr=000000&_nav_txtclr=000000";
    cvs = "https://zb.vip.qq.com/widget/mine?_wv=16782339&_wvx=3";
    cvr = "https://zb.vip.qq.com/collection/aio?_wv=1027&id=[id]&_preload=1&type=widget";
    cvt = "https://gxh.vip.qq.com/xydata/font/item/[id]/180x150.png";
    cvv = "https://gxh.vip.qq.com/xydata/bubble/item/[id]/250x300_0.png";
    cvu = "https://zb.vip.qq.com/face/category?_wv=16778243&_wvx=3&id=14";
    localObject = new StringBuilder("https://imgcache.qq.com/club/themes/mobile/head_pendant/html/index.html");
    ((StringBuilder)localObject).append("?").append(cvO).append("&_bid=160").append("&_wv=3").append("&asyncMode=1");
    cvw = "&show_type=dialog&id=[id]";
    localObject = new StringBuilder("https://zb.vip.qq.com/sonic/font");
    ((StringBuilder)localObject).append("?").append(cvO).append("&_wv=16778243").append("&asyncMode=3");
    cvy = ((StringBuilder)localObject).toString();
    cvz = "&show_type=dialog&id=[id]";
    localObject = new StringBuilder("https://imgcache.qq.com/club/themes/mobile/font/index.html");
    ((StringBuilder)localObject).append("?").append(cvO).append("&_bid=182").append("&_wv=1027").append("&asyncMode=1");
    cvA = "&show_type=dialog&id=[id]";
    localObject = new StringBuilder("https://gxh.vip.qq.com/club/themes/mobile/suit/index.html");
    ((StringBuilder)localObject).append("?").append(cvO).append("&_bid=239").append("&_wv=5123");
    cvB = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://gxh.vip.qq.com/club/themes/mobile/suit/detail.html");
    ((StringBuilder)localObject).append("?").append(cvO).append("&_wv=5123").append("&_bid=239").append("&suitid=[id]").append("&suittitle=[title]");
    cvC = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/sonic/funcall");
    ((StringBuilder)localObject).append("?").append(cvO).append("&asyncMode=3").append("&_wv=16778243");
    cvD = ((StringBuilder)localObject).toString();
    cvE = "&id=[id]";
    localObject = new StringBuilder("https://zb.vip.qq.com/redpack/index");
    ((StringBuilder)localObject).append("?").append(cvO).append("&_wv=16778243&_wwv=64&_nav_txtclr=ffffff&_nav_titleclr=ffffff&from=[from]");
    cvF = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/sonic/chatbg");
    ((StringBuilder)localObject).append("?").append(cvO).append("&asyncMode=3").append("&_wv=1027");
    cvG = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/chatbg/preview");
    ((StringBuilder)localObject).append("?").append(cvO).append("&_wv=16782337").append("&bgId=[id]");
    cvH = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/sonic/funcall");
    ((StringBuilder)localObject).append("?").append(cvO).append("&asyncMode=3").append("&_wv=16778243");
    cvI = ((StringBuilder)localObject).toString();
    cvJ = "&id=[id]";
    localObject = new StringBuilder("https://zb.vip.qq.com/sonic/card");
    ((StringBuilder)localObject).append("?").append(cvO).append("&_wv=16782337").append("&asyncMode=3");
    cvK = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://gxh.vip.qq.com/club/themes/mobile/card/html/detail.html");
    ((StringBuilder)localObject).append("?").append(cvO).append("&cardItemId=[id]").append("&_wv=16782337");
    cvL = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://gxh.vip.qq.com/club/themes/mobile/bq/html/category.html?");
    ((StringBuilder)localObject).append("adtag=vip.gongneng.mobile.biaoqing.index").append("&_bid=102&_lv=0").append("&key=012").append("&name=%E5%B0%8F%E8%A1%A8%E6%83%85").append("&src=category_list&_wv=1027");
    cvP = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/like");
    ((StringBuilder)localObject).append("?").append("_wv=16778243");
    cvQ = ((StringBuilder)localObject).toString();
    cvM = "https://zb.vip.qq.com/card/setting?_wv=16778243";
    localObject = new StringBuilder("https://imgcache.qq.com/club/themes/mobile/my_dress/index.html");
    ((StringBuilder)localObject).append("?uin=[uin]").append("&client=androidQQ").append("&version=").append("3.4.4.3058").append("&platformId=2").append("&device=").append(Build.DEVICE).append("&system=").append(Build.VERSION.RELEASE).append("&density=[density]").append("&_bid=182").append("&_wv=3");
    cvR = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://imgcache.qq.com/club/themes/mobile/search/html/index.html");
    ((StringBuilder)localObject).append("?uin=[uin]").append("&client=androidQQ").append("&version=").append("3.4.4.3058").append("&platformId=2").append("&device=").append(Build.DEVICE).append("&system=").append(Build.VERSION.RELEASE).append("&density=[density]").append("&adtag=mvip.gxh.android.search").append("&_bid=2229").append("&_wv=1027");
    cvS = ((StringBuilder)localObject).toString();
    aH = new HashMap();
    oj = new HashMap();
    ok = new HashMap();
    ok.put("bubble", cvi);
    ok.put("theme", cvg);
    ok.put("pendant", cvo);
    ok.put("FriendToPendant", cvp);
    ok.put("FriendToDIYPendant", cvq);
    ok.put("faceEntryUrl", cvx);
    ok.put("myPendantUrl", cvs);
    ok.put("emoji", cvl);
    ok.put("font", cvy);
    ok.put("suit", cvB);
    ok.put("background", cvG);
    ok.put("ring", cvD);
    ok.put("hongbao", cvF);
    ok.put("card", cvK);
    ok.put("call", cvI);
    ok.put("praise", cvQ);
    ok.put("bubbleDetail", cvj);
    ok.put("bubbleDetailDialog", cvk);
    ok.put("themeDetail", cvh);
    ok.put("pendantDetail", cvr);
    ok.put("pendantDetailDialog", cvw);
    ok.put("emojiDetail", cvm);
    ok.put("emojiAuthorDetail", cvn);
    ok.put("fontDetail", cvz);
    ok.put("fontDetailDialog", cvA);
    ok.put("suitDetail", cvC);
    ok.put("backgroundDetail", cvH);
    ok.put("ringDetail", cvE);
    ok.put("cardDetail", cvL);
    ok.put("callDetail", cvJ);
    ok.put("personalIndex", "https://zb.vip.qq.com/v2/home?_wv=5123&_proxy=1&_wwv=128&_proxy=1&ADTAG=mobileqq.drawer");
    ok.put("cardWord", "https://imgcache.qq.com/club/mobile/profile/template/summary_card_word.json");
    ok.put("fontAioImg", "https://imgcache.qq.com/qqshow/admindata/comdata/vipfont_[id]/aio.png");
    ok.put("linkPendantSet", "https://gxh.vip.qq.com/club/themes/mobile/act/diy_tpl/widgetLink[id]/html/index.html?_wv=1025");
    ok.put("rarePendantActivity", "https://imgcache.qq.com/club/themes/mobile/act/2014/actTpl/html/home.html?app=gjjbzh&type=1&_wv=1025");
    ok.put("signatureTemplate", "https://imgcache.qq.com/qqshow/admindata/comdata/vipList_signature_data/xydata.v2.json");
    ok.put("magicPlus", "https://zb.vip.qq.com/emoji/category?key=011");
    ok.put("rareCard", "https://imgcache.qq.com/club/client/card/rel/active.html?_bid=238&bgId=%1$s&ADTAG=inside.myCardBackground&_wv=5123");
    ok.put("emoticonKeyword", "https://imgcache.qq.com/club/item/parcel/json/keywordList.json");
    ok.put("colorringAudio", "https://imgcache.qq.com/qqshow/admindata/comdata/vipRing_item_[id]/[id]_2.mp3");
    ok.put("colorringCover", "https://imgcache.qq.com/qqshow/admindata/comdata/vipRing_item_[id]/preview.jpg");
    ok.put("colorringConfig", "https://imgcache.qq.com/qqshow/admindata/comdata/vipRing_item_[id]/config.json");
    ok.put("myFont", "https://zb.vip.qq.com/font/myFont?_wv=16777219&_wwv=321&_wvx=3");
    ok.put("myIndividuation", cvR);
    ok.put("individuationSearch", cvS);
    ok.put("funnyPic", "https://imgcache.qq.com/club/themes/mobile/qutu/html/index.html?_wv=3&_bid=2196");
    ok.put("funCallMine", "https://imgcache.qq.com/club/themes/mobile/funcall/html/mine.html?_wv=5123&_bid=2382");
    ok.put("smallEmojiList", cvP);
    ok.put("diyPic", "https://gxh.vip.qq.com/club/themes/mobile/bq/html/category.html?_bid=102&_lv=0&key=014&name=DIY%E8%A1%A8%E6%83%85&src=category_list&_wv=1027");
    ok.put("aioEmojiStickerDetail", "https://gxh.vip.qq.com/club/themes/mobile/emoji/html/sticker.html?_wv=1027");
    ok.put("gameHonourAddHonour", cvM);
    ok.put("gameIconSetupH5Url", "https://mq.vip.qq.com/m/sgame/duanwei");
    ok.put("bubblePreview", cvv);
    ok.put("fontPreview", cvt);
    ok.put("vasClassProfileStoryUrl", cvu);
    ok.put("vipRoamChatBanner", "https://imgcache.qq.com/club/client/msgRoam/rel/html/index_v2.html?_wv=5123&ADTAG=xiaolantiao");
    ok.put("vipRoamChatCell", "https://imgcache.qq.com/club/client/msgRoam/rel/html/index_v2.html?_wv=5123");
    ok.put("vipPersonalCardCustom", "https://h5.vip.qq.com/p/mc/cardv2/other?_wv=1031&_wvx=10");
    ok.put("vipPersonalCardMaster", "https://club.vip.qq.com/card?_wvx=3&_nav_anim=true&_nav_alpha=0");
    ok.put("vipGameCenter", "");
    ok.put("vipPersonalCardMyGame", "https://gamecenter.qq.com/gamecenter/index/recent_play.html");
    ok.put("vipUpGroupLimit", "https://imgcache.qq.com/club/client/group/release/index.html?_bid=199&pvsrc=troopManage&_wv=5127");
    ok.put("troopEnterEffect", "https://zb.vip.qq.com/group/single?_wv=16777219");
    ok.put("specialCareRingUrl", "https://zb.vip.qq.com/v2/subMall?locationtype=[lType]&uid=[uid]");
    ok.put("signatureEntrance", "https://zb.vip.qq.com/v2/signList?_wvx=2&_wvxBclr=0xffffff&_wwv=4");
    ok.put("signatureDIYEntrance", "https://zb.vip.qq.com/sign_v2/diy");
    ok.put("groupkeywords", cvN);
    ok.put("NameplateClickDefault", "https://m.vip.qq.com/freedom/freedom_svipicon.html?_nav_alpha=0");
    ok.put("NameplateClickSvip", "https://h5.vip.qq.com/p/mc/cardv2/other?_wv=1031");
    ok.put("kuoliePersonalCardMaster", "https://club.vip.qq.com/card?_wvx=3&_nav_anim=true&_nav_alpha=0");
    pe = new HashMap();
    localObject = new aqqj.a("2034", "1027");
    pe.put("theme", localObject);
    pe.put("themeDetail", localObject);
    localObject = new aqqj.a("122", "1027");
    pe.put("bubble", localObject);
    pe.put("bubbleDetail", localObject);
    localObject = new aqqj.a("102", "1027");
    pe.put("emoji", localObject);
    localObject = new aqqj.a("102", "16778241");
    pe.put("emojiDetail", localObject);
    localObject = new aqqj.a("102", "3");
    pe.put("emojiAuthorDetail", localObject);
    pe.put("magicPlus", localObject);
    localObject = new aqqj.a("160", "3");
    pe.put("pendant", localObject);
    pe.put("pendantDetail", localObject);
    localObject = new aqqj.a("182", "1027");
    pe.put("font", localObject);
    pe.put("fontDetail", localObject);
    localObject = new aqqj.a("239", "5123");
    pe.put("suit", localObject);
    pe.put("suitDetail", localObject);
    localObject = new aqqj.a("293", "1027");
    pe.put("ring", localObject);
    pe.put("ringDetail", localObject);
    localObject = new aqqj.a("", "16778247");
    pe.put("hongbao", localObject);
    localObject = new aqqj.a("310", "1027");
    pe.put("background", localObject);
    pe.put("backgroundDetail", localObject);
    localObject = new aqqj.a("313", "5123");
    pe.put("call", localObject);
    pe.put("callDetail", localObject);
    localObject = new aqqj.a("238", "5123");
    pe.put("card", localObject);
    pe.put("cardDetail", localObject);
    localObject = new aqqj.a("2229", "1027");
    pe.put("individuationSearch", localObject);
    localObject = new aqqj.a("182", "3");
    pe.put("myIndividuation", localObject);
  }
  
  /* Error */
  public static String a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 589	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aload_1
    //   8: areturn
    //   9: aload_1
    //   10: astore_3
    //   11: aload_1
    //   12: ldc_w 591
    //   15: ldc_w 593
    //   18: invokevirtual 599	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   21: astore_1
    //   22: aload_1
    //   23: astore_3
    //   24: aload_1
    //   25: ldc_w 601
    //   28: ldc 83
    //   30: invokevirtual 599	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   33: astore_1
    //   34: aload_1
    //   35: astore_3
    //   36: aload_1
    //   37: ldc_w 603
    //   40: ldc_w 605
    //   43: invokevirtual 599	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   46: astore_1
    //   47: aload_1
    //   48: astore_3
    //   49: aload_1
    //   50: ldc_w 607
    //   53: getstatic 92	android/os/Build:DEVICE	Ljava/lang/String;
    //   56: ldc_w 609
    //   59: invokestatic 615	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   62: invokevirtual 599	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   65: astore_1
    //   66: aload_1
    //   67: astore_3
    //   68: aload_1
    //   69: ldc_w 617
    //   72: getstatic 99	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   75: ldc_w 609
    //   78: invokestatic 615	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   81: invokevirtual 599	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   84: astore_1
    //   85: aload_0
    //   86: astore 4
    //   88: aload_0
    //   89: ifnonnull +11 -> 100
    //   92: getstatic 623	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   95: invokevirtual 627	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   98: astore 4
    //   100: aload 4
    //   102: ifnull +36 -> 138
    //   105: aload_1
    //   106: ldc_w 629
    //   109: aload 4
    //   111: invokevirtual 634	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   114: invokevirtual 599	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   117: astore_0
    //   118: aload_0
    //   119: astore_3
    //   120: aload_0
    //   121: ldc_w 636
    //   124: aload 4
    //   126: invokevirtual 640	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   129: invokestatic 646	com/tencent/mobileqq/theme/ThemeUtil:getThemeDensity	(Landroid/content/Context;)Ljava/lang/String;
    //   132: invokevirtual 599	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   135: astore_1
    //   136: aload_1
    //   137: areturn
    //   138: ldc_w 648
    //   141: iconst_1
    //   142: ldc_w 650
    //   145: iconst_2
    //   146: anewarray 4	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: aload_1
    //   152: aastore
    //   153: dup
    //   154: iconst_1
    //   155: aload_2
    //   156: aastore
    //   157: invokestatic 654	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   160: invokestatic 660	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: goto -27 -> 136
    //   166: astore_0
    //   167: ldc_w 648
    //   170: iconst_1
    //   171: ldc_w 662
    //   174: iconst_3
    //   175: anewarray 4	java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: aload_1
    //   181: aastore
    //   182: dup
    //   183: iconst_1
    //   184: aload_2
    //   185: aastore
    //   186: dup
    //   187: iconst_2
    //   188: aload_0
    //   189: invokestatic 668	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   192: aastore
    //   193: invokestatic 654	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   196: invokestatic 660	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: goto -63 -> 136
    //   202: astore_0
    //   203: aload_3
    //   204: astore_1
    //   205: goto -38 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramAppRuntime	AppRuntime
    //   0	208	1	paramString1	String
    //   0	208	2	paramString2	String
    //   10	194	3	localObject	Object
    //   86	39	4	localAppRuntime	AppRuntime
    // Exception table:
    //   from	to	target	type
    //   92	100	166	java/lang/Exception
    //   105	118	166	java/lang/Exception
    //   138	163	166	java/lang/Exception
    //   11	22	202	java/lang/Exception
    //   24	34	202	java/lang/Exception
    //   36	47	202	java/lang/Exception
    //   49	66	202	java/lang/Exception
    //   68	85	202	java/lang/Exception
    //   120	136	202	java/lang/Exception
  }
  
  public static Map<String, String> aB()
  {
    return aH;
  }
  
  public static boolean bW(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int m = Math.min(paramString1.length, paramString2.length);
    int k = 0;
    label44:
    if (k < m) {
      if (k >= paramString1.length) {
        break label144;
      }
    }
    for (;;)
    {
      try
      {
        i = Integer.parseInt(paramString1[k]);
        if (k >= paramString2.length) {
          break label139;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          j = Integer.parseInt(paramString2[k]);
          if (k == m - 1) {
            break label125;
          }
          if (j > i)
          {
            return true;
            localException1 = localException1;
            i = 0;
          }
        }
        catch (Exception localException2)
        {
          j = 0;
          continue;
        }
      }
      if (j < i) {
        break;
      }
      label125:
      do
      {
        k += 1;
        break label44;
        break;
        if (j >= i) {
          return true;
        }
      } while (j >= i);
      return false;
      label139:
      int j = 0;
      continue;
      label144:
      int i = 0;
    }
  }
  
  public static String e(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return f(paramContext, getUrl(paramString1), paramString2, paramString3);
  }
  
  private static String f(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      paramContext = null;
    }
    do
    {
      return paramContext;
      if (QLog.isColorLevel()) {
        QLog.i("IndividuationUrlHelper", 2, "decodeMarketDetailUrl:" + paramString1 + ", id=" + paramString2);
      }
      paramString1 = p(paramContext, paramString1, paramString3);
      paramContext = paramString1;
    } while (TextUtils.isEmpty(paramString1));
    return paramString1.replace("[id]", paramString2);
  }
  
  public static String getUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject1;
    if (aH.containsKey(paramString))
    {
      localObject1 = (String)aH.get(paramString);
      localObject2 = localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("IndividuationUrlHelper", 2, "getUrl, from config, id=" + paramString + ", url=" + (String)localObject1);
      }
    }
    for (Object localObject2 = localObject1;; localObject2 = null)
    {
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        if (!dy.get())
        {
          if (QLog.isColorLevel()) {
            QLog.d("IndividuationUrlHelper", 2, "getUrl start parseJson");
          }
          if (Looper.myLooper() != Looper.getMainLooper()) {
            break label278;
          }
          ThreadManager.post(new IndividuationUrlHelper.1(), 5, null, true);
        }
      }
      for (;;)
      {
        localObject2 = (String)oj.get(paramString);
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("IndividuationUrlHelper", 2, "getUrl, from default, id=" + paramString + ", url=" + (String)localObject2);
          localObject1 = localObject2;
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = a(BaseApplicationImpl.sApplication.getRuntime(), (String)ok.get(paramString), paramString);
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("IndividuationUrlHelper", 2, "getUrl, from raw default, id=" + paramString + ", url=" + (String)localObject1);
            localObject2 = localObject1;
          }
        }
        return localObject2;
        label278:
        k(BaseApplicationImpl.sApplication.getRuntime());
      }
    }
  }
  
  public static void k(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {}
    long l1;
    Object localObject2;
    String str1;
    for (;;)
    {
      try
      {
        QLog.e("IndividuationUrlHelper", 1, "parseJson, app null");
        return;
      }
      finally {}
      if (dy.compareAndSet(false, true))
      {
        l1 = System.currentTimeMillis();
        aH.clear();
        oj.clear();
        localObject1 = ok.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          str1 = (String)((Map.Entry)localObject2).getKey();
          localObject2 = a(paramAppRuntime, (String)((Map.Entry)localObject2).getValue(), str1);
          oj.put(str1, localObject2);
        }
      }
    }
    Object localObject1 = VasQuickUpdateManager.getFileFromLocal(paramAppRuntime, 1000L, "vipData_individuation_url.android.json", paramAppRuntime.getApplication().getFilesDir() + File.separator + "vipData_individuation_url.android.json", true, null);
    if (localObject1 != null)
    {
      boolean bool = ((File)localObject1).exists();
      if (!bool) {}
    }
    for (;;)
    {
      int i;
      label351:
      int k;
      label360:
      int m;
      label465:
      int i1;
      try
      {
        localObject1 = aqhq.readFileContent((File)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = new JSONArray((String)localObject1);
          if ((localObject1 == null) || (((JSONArray)localObject1).length() < 1)) {
            QLog.e("IndividuationUrlHelper", 1, "parseJson, no IndividuationAddress element");
          }
        }
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("IndividuationUrlHelper", 1, "parseJson, exception=" + MsfSdkUtils.getStackTraceString(paramAppRuntime));
        dy.set(false);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("IndividuationUrlHelper", 2, "parseJson, duration=" + (System.currentTimeMillis() - l1));
        break;
        i = VipUtils.a(paramAppRuntime, null);
        if ((i & 0x4) != 0)
        {
          i = 4;
          int n = ((JSONArray)localObject1).length();
          k = 0;
          if (k >= n) {
            continue;
          }
          try
          {
            localObject2 = ((JSONArray)localObject1).getJSONObject(k);
            str1 = ((JSONObject)localObject2).optString("business");
            str2 = ((JSONObject)localObject2).optString("url");
            if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
            {
              QLog.e("IndividuationUrlHelper", 1, "parseJson, config error, no business or url, config=" + localObject2);
              break label887;
            }
            if (!((JSONObject)localObject2).has("userType")) {
              continue;
            }
            m = ((JSONObject)localObject2).getInt("userType");
          }
          catch (Exception localException)
          {
            String str2;
            String str3;
            long l2;
            long l3;
            long l4;
            QLog.e("IndividuationUrlHelper", 1, "parseJson, exception", localException);
            break label887;
          }
          if (j != 0)
          {
            m = 1;
            j = m;
            if (((JSONObject)localObject2).has("minVersion"))
            {
              str3 = ((JSONObject)localObject2).getString("minVersion");
              j = m;
              if (!TextUtils.isEmpty(str3))
              {
                j = m;
                if (!bW(str3, "3.4.4")) {
                  j = 0;
                }
              }
            }
            m = j;
            if (j != 0)
            {
              m = j;
              if (((JSONObject)localObject2).has("maxVersion"))
              {
                str3 = ((JSONObject)localObject2).getString("maxVersion");
                m = j;
                if (!TextUtils.isEmpty(str3))
                {
                  m = j;
                  if (!bW("3.4.4", str3)) {
                    m = 0;
                  }
                }
              }
            }
            if (m != 0)
            {
              str3 = paramAppRuntime.getAccount();
              j = ((JSONObject)localObject2).optInt("startIndex");
              m = ((JSONObject)localObject2).optInt("endIndex");
              if (j >= m)
              {
                i1 = str3.length();
                if ((i1 >= j) && (i1 >= m))
                {
                  l2 = Long.parseLong(str3.substring(i1 - j, i1 - m + 1));
                  l3 = ((JSONObject)localObject2).optLong("min");
                  l4 = ((JSONObject)localObject2).optLong("max");
                  if ((l2 < l3) || (l2 > l4)) {
                    break label887;
                  }
                  localObject2 = a(paramAppRuntime, str2, str1);
                  aH.put(str1, localObject2);
                  break label887;
                }
              }
            }
          }
        }
      }
      catch (OutOfMemoryError paramAppRuntime)
      {
        QLog.e("IndividuationUrlHelper", 1, "parseJson, oom=" + MsfSdkUtils.getStackTraceString(paramAppRuntime));
        continue;
        m = -1;
      }
      label887:
      do
      {
        j = 0;
        break label465;
        QLog.e("IndividuationUrlHelper", 1, "parseJson, index config error, uin length=" + i1 + ", config=" + localObject2);
        break label887;
        QLog.e("IndividuationUrlHelper", 1, "parseJson, startIndex < endIndex, element=" + localObject2);
        break label887;
        QLog.e("IndividuationUrlHelper", 1, "parseJson, jsonStr null");
        break;
        QLog.e("IndividuationUrlHelper", 1, "parseJson, no json file");
        break;
        do
        {
          i = 1;
          break;
          k += 1;
          break label360;
        } while ((i & 0x2) == 0);
        i = 2;
        break label351;
        j = 1;
        if (m == -1) {
          break label465;
        }
      } while ((i & m) != i);
      int j = 1;
    }
  }
  
  public static String o(Context paramContext, String paramString1, String paramString2)
  {
    return p(paramContext, getUrl(paramString1), paramString2);
  }
  
  private static String p(Context paramContext, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IndividuationUrlHelper", 2, "decodeMarketUrl:" + paramString1);
    }
    if (TextUtils.isEmpty(paramString1)) {
      paramContext = null;
    }
    do
    {
      return paramContext;
      paramContext = paramString1;
    } while (TextUtils.isEmpty(paramString2));
    return paramString1 + "&adtag=" + paramString2;
  }
  
  public static class a
  {
    public String bid;
    public String cvT;
    
    public a(String paramString1, String paramString2)
    {
      this.bid = paramString1;
      this.cvT = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqqj
 * JD-Core Version:    0.7.0.1
 */