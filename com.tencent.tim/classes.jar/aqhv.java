import QQWalletPay.ReqCheckChangePwdAuth;
import QQWalletPay.RespCheckChangePwdAuth;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import com.dataline.activities.LiteActivity;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.av.VideoController;
import com.tencent.av.ui.ConferenceFlyTicketActivity;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.util.ProfileParams.CurLoginUsr;
import com.tencent.biz.pubaccount.util.ProfileParams.a;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.playvideo.entrance.DiscoverBannerPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qrcode.activity.QRJumpActivity;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.DeviceScanner;
import com.tencent.device.bind.DevicePluginDownloadActivity;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.c;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.InterestSwitchEditActivity;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.activity.RecommendFriendActivity;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.activity.RegisterChooseLoginActivity;
import com.tencent.mobileqq.activity.RegisterPersonalInfoActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.activity.RegisterSendUpSms;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;
import com.tencent.mobileqq.activity.SearchMightKnowFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TranslucentTRansferFragment;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.activateFriend.QQNotifySettingFragment;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.qwallet.WXMiniProgramHelper;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.ar.ARScanAR;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.dating.NearbyTransitActivity;
import com.tencent.mobileqq.extendfriend.ExtendFriendPublicFragmentActivity;
import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil;
import com.tencent.mobileqq.nearby.gameroom.GameRoomTransActivity;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.nearby.now.SmallVideoFragment;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.JumpAction.1;
import com.tencent.mobileqq.utils.JumpAction.11;
import com.tencent.mobileqq.utils.JumpAction.12;
import com.tencent.mobileqq.utils.JumpAction.14;
import com.tencent.mobileqq.utils.JumpAction.16;
import com.tencent.mobileqq.utils.JumpAction.2;
import com.tencent.mobileqq.utils.JumpAction.20;
import com.tencent.mobileqq.utils.JumpAction.4;
import com.tencent.mobileqq.utils.JumpAction.5;
import com.tencent.mobileqq.utils.JumpAction.6;
import com.tencent.mobileqq.utils.JumpAction.7;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.AgentActivity;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.open.agent.BindTroopPreVerificationFragment;
import com.tencent.open.agent.JoinTroopPreVerificationFragment;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qidian.QidianWebViewFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import common.config.service.QzoneConfig;
import cooperation.comic.VipComicJumpActivity;
import cooperation.hce.HcePluginInstallActivity;
import cooperation.plugin.PluginInfo;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.a;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.troop.NearbyVideoChatProxyActivity;
import cooperation.troop.TroopBaseProxyActivity;
import cooperation.troop.TroopManageProxyActivity;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aqhv
{
  public static String ctn;
  public static String cto;
  public static int dZn = 1;
  private static final String[] hS = { "com.tencent.mobileqq" };
  public static String mAppId;
  public static String mOpenId;
  public aqhv.a a;
  private aqhv.b a;
  public arhz a;
  public String aIG;
  private Dialog al;
  public final QQAppInterface app;
  public HashMap<String, String> attrs;
  private ackf jdField_b_of_type_Ackf;
  ashx jdField_b_of_type_Ashx = new aqhw(this);
  public BusinessInfoCheckUpdate.AppInfo c;
  public boolean cUa;
  public boolean cUb;
  public boolean cUc;
  public boolean cUd;
  public boolean cUe = true;
  private boolean cUf;
  public boolean cUg;
  public boolean cUh;
  public boolean cUi;
  public Context context;
  public String cti;
  public String ctj;
  public String ctk;
  public String ctl = "";
  public String ctm = "";
  protected Handler dJ;
  public boolean dw;
  public ChatActivityUtils.c e = new aqib(this);
  public String feedTime = "";
  public String from;
  private AppInterface mAppInterface;
  public String pkgName;
  public String pkgSig;
  public String source;
  public Hashtable<String, Long> y = new Hashtable();
  
  public aqhv(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_Aqhv$a = new aqhv.a(this);
    this.context = paramContext;
    this.app = paramQQAppInterface;
    this.attrs = new HashMap();
  }
  
  private Intent C()
  {
    Intent localIntent = new Intent(this.context, SplashActivity.class);
    localIntent.putExtra("thridparty_prepare_mini_app", true);
    localIntent.addFlags(67108864);
    localIntent.addFlags(268435456);
    localIntent.putExtra("fragment_id", 1);
    return localIntent;
  }
  
  private String Ca()
  {
    return "mqqapi://" + this.cti + "/" + this.ctj + "?src_type=" + (String)this.attrs.get("src_type");
  }
  
  private String Cb()
  {
    String str1 = Build.VERSION.RELEASE;
    String str2 = Build.MODEL;
    String str3 = auri.getIMEI("0db4c4");
    String str4 = auri.ru("0db4c4");
    Object localObject = ((Activity)this.context).getWindowManager().getDefaultDisplay();
    int i = ((Display)localObject).getHeight();
    int j = ((Display)localObject).getWidth();
    localObject = j + "*" + i;
    i = this.app.getAppid();
    return str1 + "|" + str2 + "|" + str3 + "|" + (String)localObject + "|" + str4 + "|" + i + "|";
  }
  
  private boolean I(String paramString, boolean paramBoolean)
  {
    String str2 = toBase64Decode((String)this.attrs.get("title"));
    String str3 = toBase64Decode((String)this.attrs.get("description"));
    String str4 = toBase64Decode((String)this.attrs.get("url"));
    String str5 = toBase64Decode((String)this.attrs.get("app_name"));
    Object localObject1 = toBase64Decode((String)this.attrs.get("image_url"));
    String str6 = toBase64Decode((String)this.attrs.get("audioUrl"));
    String str1 = toBase64Decode((String)this.attrs.get("open_id"));
    String str7 = toBase64Decode((String)this.attrs.get("share_uin"));
    String str8 = (String)this.attrs.get("jfrom");
    Object localObject2 = toBase64Decode((String)this.attrs.get("req_type"));
    String str9 = toBase64Decode((String)this.attrs.get("share_qq_ext_str"));
    String str10 = toBase64Decode((String)this.attrs.get("mini_program_appid"));
    String str11 = toBase64Decode((String)this.attrs.get("mini_program_path"));
    if (this.attrs.get("mini_program_type") != null) {}
    for (int i = Integer.valueOf(toBase64Decode((String)this.attrs.get("mini_program_type"))).intValue();; i = 3)
    {
      int k = 0;
      long l;
      int m;
      try
      {
        l = Long.valueOf((String)this.attrs.get("share_id")).longValue();
        if (l <= 0L) {
          return false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          l = 0L;
        }
        m = 1;
      }
      try
      {
        j = Integer.valueOf(toBase64Decode((String)this.attrs.get("cflag"))).intValue();
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        try
        {
          for (;;)
          {
            k = Integer.valueOf((String)localObject2).intValue();
            if (localObject1 != null) {
              break label1061;
            }
            localObject1 = toBase64Decode((String)this.attrs.get("file_data"));
            localObject2 = new ArrayList();
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break;
            }
            localObject1 = ((String)localObject1).split(";");
            m = 0;
            while (m < localObject1.length)
            {
              ((ArrayList)localObject2).add(URLDecoder.decode(localObject1[m]));
              m += 1;
            }
            localNumberFormatException2 = localNumberFormatException2;
            j = k;
            if (QLog.isColorLevel())
            {
              QLog.d("QzoneShare", 2, "NumberFormatException extFlags = 0");
              j = k;
            }
          }
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          label1061:
          for (;;)
          {
            int j;
            k = m;
            if (QLog.isColorLevel())
            {
              QLog.d("QzoneShare", 2, "NumberFormatException req_type = 1");
              k = m;
              continue;
              if ((localNumberFormatException1 != null) && (localNumberFormatException1.size() > 0)) {}
              for (localObject1 = (String)localNumberFormatException1.get(0);; localObject1 = "")
              {
                Bundle localBundle = new Bundle();
                localBundle.putString("title", str2);
                localBundle.putString("desc", str3);
                localBundle.putString("app_name", str5);
                localBundle.putLong("req_share_id", l);
                localBundle.putString("detail_url", str4);
                localBundle.putStringArrayList("image_url", localNumberFormatException1);
                localBundle.putString("pkg_name", this.pkgName);
                localBundle.putString("open_id", str1);
                localBundle.putString("share_uin", str7);
                localBundle.putString("jfrom", str8);
                localBundle.putString("share_qq_ext_str", str9);
                localBundle.putInt("cflag", j);
                localBundle.putString("share_action", paramString);
                localBundle.putInt("iUrlInfoFrm", 4);
                localBundle.putBoolean("thirdPartShare", true);
                if ((!TextUtils.isEmpty(str10)) && (!TextUtils.isEmpty(str11)))
                {
                  localBundle.putBoolean("is_share_mini_app_msg", true);
                  localBundle.putString("share_mini_app_id", str10);
                  localBundle.putString("share_mini_app_path", str11);
                  localBundle.putInt("share_mini_ver_type", i);
                  localBundle.putString("share_mini_image_url", (String)localObject1);
                }
                if (k == 2) {
                  localBundle.putString("audio_url", str6);
                }
                localBundle.putInt("req_type", k);
                com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.boN = true;
                paramString = new aqia(this);
                localBundle.putBoolean("key_require_storage_permission", paramBoolean);
                if ((k == 5) && ((j & 0x1) != 0)) {
                  avqq.a(this.app, this.context, localBundle, paramString, 23);
                }
                for (;;)
                {
                  if (k == 1) {
                    paramString = "1";
                  }
                  try
                  {
                    for (;;)
                    {
                      arts.a().a(this.app.getAccount(), str1, String.valueOf(l), "11", "12", "0", paramString, "0", "0", false, true);
                      label846:
                      paramString = new QZoneClickReport.a();
                      paramString.actionType = "1";
                      paramString.cMI = "0";
                      paramString.tabletype = 4;
                      paramString.sourceType = "5";
                      paramString.sourceFrom = "thirdApp";
                      paramString.sourceTo = "activefeed";
                      QZoneClickReport.startReportImediately(this.app.getAccount(), paramString);
                      paramString = new HashMap();
                      paramString.put("source_type", "5");
                      paramString.put("source_from", "thirdApp");
                      paramString.put("source_to", "activefeed");
                      anpc.a(BaseApplicationImpl.getContext()).collectPerformance(this.app.getAccount(), "actQZSourceDataReport", true, 0L, 0L, paramString, null);
                      if ((!this.cUe) && ((this.context instanceof JumpActivity))) {
                        ((JumpActivity)this.context).finish();
                      }
                      return true;
                      avqq.a(this.app, this.context, localBundle, paramString);
                      break;
                      if (k == 2) {
                        paramString = "3";
                      } else if (k == 5) {
                        paramString = "2";
                      } else {
                        paramString = "4";
                      }
                    }
                  }
                  catch (Exception paramString)
                  {
                    break label846;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void Kl(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.setData(Uri.parse("midas://open_modify_status?status=" + paramInt));
    if (this.context.getPackageManager().queryIntentActivities(localIntent, 0).size() > 0) {
      this.context.startActivity(localIntent);
    }
    ((BaseActivity)this.context).finish();
  }
  
  private int LW()
  {
    if (!TextUtils.isEmpty((CharSequence)this.attrs.get("env"))) {
      return Integer.valueOf((String)this.attrs.get("env")).intValue();
    }
    return 0;
  }
  
  private void UG(String paramString)
  {
    String str = (String)this.attrs.get("src_type");
    if ("app".equals(str)) {
      anot.a(this.app, "CliOper", "", paramString, "WPA", "OpenAIO_app", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if ("web".equals(str))
      {
        anot.a(this.app, "CliOper", "", paramString, "WPA", "OpenAIO_website", 0, 0, "", "", "", "");
        return;
      }
    } while (!"scan".equals(str));
    anot.a(this.app, "CliOper", "", paramString, "WPA", "OpenAIO_scan", 0, 0, "", "", "", "");
  }
  
  private void UI(String paramString)
  {
    if ((paramString.equals(GameCenterActivity.class.getName())) || (paramString.equals(PublicAccountBrowser.class.getName())) || (paramString.equals(CouponActivity.class.getName()))) {
      QWalletHelper.preloadQWallet(this.app);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, Intent paramIntent)
  {
    paramIntent.putExtra("url", paramString1);
    paramIntent.setClassName(paramString2, paramString3);
    paramIntent.addCategory("android.intent.category.LAUNCHER");
    paramIntent.addFlags(268435456);
    paramIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    this.context.startActivity(paramIntent);
  }
  
  public static boolean a(Context paramContext, String paramString, Long paramLong)
  {
    paramContext = aeiy.b(250).a();
    if ((paramContext != null) && (paramContext.a() != null))
    {
      paramContext = paramContext.a().jT;
      if ((paramContext != null) && (!paramContext.isEmpty()))
      {
        if ((paramContext.containsKey(paramLong.toString())) && (paramContext.containsValue(paramString))) {
          return (!TextUtils.isEmpty(paramLong.toString())) && (((String)paramContext.get(paramLong.toString())).equals(paramString));
        }
        return false;
      }
      ArkAppCenter.r("JumpAction", "getArkShareConfig,ark_ai_keyword_sdk_share_app_info is empty");
      return false;
    }
    ArkAppCenter.r("JumpAction", String.format("getArkShareConfig, confBean.getConfig is null", new Object[0]));
    return false;
  }
  
  /* Error */
  private boolean a(Intent paramIntent, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_1
    //   4: ldc_w 682
    //   7: invokevirtual 686	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   10: ifne +14 -> 24
    //   13: aload_1
    //   14: ldc_w 682
    //   17: invokestatic 631	java/lang/System:currentTimeMillis	()J
    //   20: invokevirtual 634	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   23: pop
    //   24: ldc_w 688
    //   27: aload_0
    //   28: getfield 690	aqhv:from	Ljava/lang/String;
    //   31: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   34: ifeq +467 -> 501
    //   37: iconst_1
    //   38: istore 8
    //   40: aload_1
    //   41: ldc_w 692
    //   44: iload 8
    //   46: invokevirtual 137	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   49: pop
    //   50: aload_0
    //   51: getfield 694	aqhv:c	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   54: ifnull +346 -> 400
    //   57: aload_0
    //   58: getfield 696	aqhv:dw	Z
    //   61: ifeq +339 -> 400
    //   64: aload_0
    //   65: getfield 694	aqhv:c	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   68: getfield 702	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:uiAppId	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   71: invokevirtual 706	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   74: sipush 769
    //   77: if_icmpne +323 -> 400
    //   80: aload_0
    //   81: getfield 694	aqhv:c	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   84: getfield 709	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:push_red_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   87: invokevirtual 706	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   90: istore 6
    //   92: aload_0
    //   93: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   96: ldc_w 711
    //   99: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   102: checkcast 72	java/lang/String
    //   105: invokestatic 715	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   108: istore 4
    //   110: aload_0
    //   111: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   114: invokevirtual 718	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   117: ldc_w 720
    //   120: iconst_0
    //   121: invokevirtual 726	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   124: astore 9
    //   126: aload 9
    //   128: new 152	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   135: ldc_w 728
    //   138: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_0
    //   142: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   145: invokevirtual 731	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   148: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: iconst_0
    //   155: invokeinterface 737 3 0
    //   160: istore 7
    //   162: aload 9
    //   164: invokeinterface 741 1 0
    //   169: new 152	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 728
    //   179: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_0
    //   183: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   186: invokevirtual 731	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   189: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: iconst_0
    //   196: invokeinterface 746 3 0
    //   201: invokeinterface 749 1 0
    //   206: pop
    //   207: aload_0
    //   208: getfield 694	aqhv:c	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   211: getfield 753	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   214: invokevirtual 758	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   217: ifeq +310 -> 527
    //   220: new 760	org/json/JSONObject
    //   223: dup
    //   224: aload_0
    //   225: getfield 694	aqhv:c	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   228: getfield 753	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   231: invokevirtual 762	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   234: invokespecial 764	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   237: astore 9
    //   239: aload_0
    //   240: getfield 694	aqhv:c	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   243: getfield 768	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   246: invokevirtual 771	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   249: ifeq +278 -> 527
    //   252: aload_0
    //   253: getfield 694	aqhv:c	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   256: getfield 768	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   259: invokevirtual 772	com/tencent/mobileqq/pb/PBRepeatField:isEmpty	()Z
    //   262: ifne +265 -> 527
    //   265: ldc_w 422
    //   268: aload 9
    //   270: ldc_w 774
    //   273: invokevirtual 778	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   276: aload_0
    //   277: getfield 694	aqhv:c	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   280: getfield 768	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   283: iconst_0
    //   284: invokevirtual 779	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   287: checkcast 72	java/lang/String
    //   290: invokevirtual 778	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   293: ldc_w 781
    //   296: invokevirtual 784	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   299: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   302: istore 8
    //   304: iload 8
    //   306: ifeq +221 -> 527
    //   309: aload_1
    //   310: ldc_w 786
    //   313: iload 5
    //   315: invokevirtual 148	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   318: pop
    //   319: aload_1
    //   320: ldc_w 788
    //   323: iload 6
    //   325: invokevirtual 148	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   328: pop
    //   329: aload_1
    //   330: ldc_w 790
    //   333: iload 7
    //   335: invokevirtual 148	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   338: pop
    //   339: aload_1
    //   340: ldc_w 792
    //   343: iload 4
    //   345: invokevirtual 148	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   348: pop
    //   349: aload_0
    //   350: getfield 694	aqhv:c	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   353: getfield 768	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   356: invokevirtual 771	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   359: ifeq +41 -> 400
    //   362: aload_0
    //   363: getfield 694	aqhv:c	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   366: getfield 768	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   369: invokevirtual 772	com/tencent/mobileqq/pb/PBRepeatField:isEmpty	()Z
    //   372: ifne +28 -> 400
    //   375: aload_1
    //   376: ldc_w 794
    //   379: new 293	java/util/ArrayList
    //   382: dup
    //   383: aload_0
    //   384: getfield 694	aqhv:c	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   387: getfield 768	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   390: invokevirtual 797	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   393: invokespecial 800	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   396: invokevirtual 804	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   399: pop
    //   400: aload_1
    //   401: ldc_w 806
    //   404: aload_0
    //   405: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   408: invokevirtual 731	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   411: invokevirtual 619	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   414: pop
    //   415: aload_1
    //   416: ldc_w 808
    //   419: iconst_1
    //   420: invokevirtual 137	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   423: pop
    //   424: aload_1
    //   425: ldc_w 810
    //   428: iconst_1
    //   429: invokevirtual 137	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   432: pop
    //   433: aload_1
    //   434: ldc_w 812
    //   437: aload_0
    //   438: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   441: invokevirtual 731	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   444: invokevirtual 619	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   447: pop
    //   448: aload_1
    //   449: ldc_w 814
    //   452: ldc_w 816
    //   455: invokevirtual 619	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   458: pop
    //   459: aload_0
    //   460: aload_1
    //   461: invokespecial 819	aqhv:dO	(Landroid/content/Intent;)V
    //   464: aload_1
    //   465: aload_0
    //   466: getfield 115	aqhv:context	Landroid/content/Context;
    //   469: aload_2
    //   470: invokevirtual 822	android/content/Intent:setClassName	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    //   473: pop
    //   474: aload_0
    //   475: getfield 115	aqhv:context	Landroid/content/Context;
    //   478: aload_1
    //   479: invokevirtual 544	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   482: ldc_w 824
    //   485: aload_3
    //   486: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   489: ifne +44 -> 533
    //   492: aload_0
    //   493: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   496: invokestatic 595	cooperation/qwallet/plugin/QWalletHelper:preloadQWallet	(Lcom/tencent/common/app/AppInterface;)V
    //   499: iconst_1
    //   500: ireturn
    //   501: iconst_0
    //   502: istore 8
    //   504: goto -464 -> 40
    //   507: astore 9
    //   509: aload 9
    //   511: invokevirtual 827	java/lang/Exception:printStackTrace	()V
    //   514: iconst_0
    //   515: istore 4
    //   517: goto -407 -> 110
    //   520: astore 9
    //   522: aload 9
    //   524: invokevirtual 827	java/lang/Exception:printStackTrace	()V
    //   527: iconst_1
    //   528: istore 5
    //   530: goto -221 -> 309
    //   533: new 829	com/tencent/mobileqq/utils/JumpAction$24
    //   536: dup
    //   537: aload_0
    //   538: invokespecial 830	com/tencent/mobileqq/utils/JumpAction$24:<init>	(Laqhv;)V
    //   541: iconst_5
    //   542: aconst_null
    //   543: iconst_1
    //   544: invokestatic 836	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   547: iconst_1
    //   548: ireturn
    //   549: astore_1
    //   550: iconst_1
    //   551: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	552	0	this	aqhv
    //   0	552	1	paramIntent	Intent
    //   0	552	2	paramString1	String
    //   0	552	3	paramString2	String
    //   108	408	4	i	int
    //   1	528	5	j	int
    //   90	234	6	k	int
    //   160	174	7	m	int
    //   38	465	8	bool	boolean
    //   124	145	9	localObject	Object
    //   507	3	9	localException1	Exception
    //   520	3	9	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   92	110	507	java/lang/Exception
    //   220	304	520	java/lang/Exception
    //   474	499	549	java/lang/Exception
    //   533	547	549	java/lang/Exception
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap)
  {
    paramQQAppInterface = (String)paramHashMap.get("uin");
    String str1 = (String)paramHashMap.get("usertype");
    String str2 = (String)paramHashMap.get("unionid");
    paramHashMap = (String)paramHashMap.get("fromId");
    if ((TextUtils.isEmpty(str1)) || ((TextUtils.isEmpty(paramQQAppInterface)) && (TextUtils.isEmpty(str2))) || (TextUtils.isEmpty(paramHashMap))) {
      return false;
    }
    try
    {
      if (!TextUtils.isEmpty(str2)) {
        ppf.f(paramActivity, Integer.valueOf(paramHashMap).intValue(), str2);
      } else {
        ppf.b(paramActivity, Integer.valueOf(paramHashMap).intValue(), Long.valueOf(paramQQAppInterface).longValue());
      }
    }
    catch (Exception paramQQAppInterface)
    {
      return false;
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap, String paramString)
  {
    String str5 = (String)paramHashMap.get("videoOwnerUin");
    String str6 = (String)paramHashMap.get("unionid");
    String str4 = (String)paramHashMap.get("fromId");
    String str2 = (String)paramHashMap.get("videoId");
    String str1 = (String)paramHashMap.get("type");
    str1 = (String)paramHashMap.get("videoList");
    int i = c(paramHashMap);
    str1 = (String)paramHashMap.get("feedid");
    int k = b(paramHashMap, "ptype", 0);
    int j;
    if ("0".equals(paramHashMap.get("identify")))
    {
      j = 0;
      if (str2 != null) {
        break label799;
      }
      str2 = (String)paramHashMap.get("videoid");
    }
    label799:
    for (;;)
    {
      String str3 = str4;
      if (str4 == null) {
        str3 = (String)paramHashMap.get("fromid");
      }
      if ((!TextUtils.isEmpty(paramString)) && (k == 0)) {
        k = 7;
      }
      for (;;)
      {
        switch (k)
        {
        default: 
          paramQQAppInterface = str1;
          if (str1 == null) {
            paramQQAppInterface = "JUMP_ACTION_EMPTY_FEED_ID";
          }
          j = i;
          if (i == 0) {
            j = 7;
          }
          qgg.c(paramActivity, str2, paramQQAppInterface, j);
          return true;
          j = 1;
          break;
        case 1: 
          if ("17".equals(str3)) {
            rar.a("mystory", "clk_obj", 0, 0, new String[] { "", "", "", str2 });
          }
          paramQQAppInterface = str1;
          if (str1 == null) {
            paramQQAppInterface = "JUMP_ACTION_EMPTY_FEED_ID";
          }
          j = i;
          if (i == 0) {
            j = 7;
          }
          qgg.c(paramActivity, str2, paramQQAppInterface, j);
          return true;
        case 2: 
          if ("17".equals(str3)) {
            rar.a("mystory", "clk_obj_myday", 0, 0, new String[] { "", "", "", str2 });
          }
          paramQQAppInterface = (String)paramHashMap.get("et");
          paramQQAppInterface = (String)paramHashMap.get("time_zone");
          if (!TextUtils.isEmpty(paramQQAppInterface)) {
            Integer.valueOf(paramQQAppInterface).intValue();
          }
          if (!TextUtils.isEmpty(str6)) {
            qgg.a(paramActivity, str6, str1, 1, 109, 1, null);
          }
          for (;;)
          {
            return true;
            if (TextUtils.isEmpty(str5)) {
              break;
            }
            qgg.a(paramActivity, str5, str1, 1, 109, 1, null);
          }
          return false;
        case 3: 
          j = i;
          if (i == 0) {
            j = 30;
          }
          qgg.b(paramActivity, str2, str1, j);
          return true;
        case 4: 
          paramQQAppInterface = (String)paramHashMap.get("collection_id");
          paramHashMap = (String)paramHashMap.get("time_zone");
          k = -1;
          if (!TextUtils.isEmpty(paramHashMap)) {
            k = Integer.valueOf(paramHashMap).intValue();
          }
          if (!TextUtils.isEmpty(str6)) {
            qgg.a(paramActivity, str6, VideoCollectionEntry.getCollectionKey(1, paramQQAppInterface, str6), k, i, str1, j, null);
          }
          for (;;)
          {
            return true;
            if (TextUtils.isEmpty(str5)) {
              break;
            }
            qgg.a(paramActivity, str5, VideoCollectionEntry.getCollectionKey(1, paramQQAppInterface, str5), k, i, str1, j, null);
          }
          return false;
        case 7: 
          j = i;
          if (i == 0) {
            j = 19;
          }
          qgg.c(paramActivity, str2, str1, j);
          return true;
        case 6: 
          j = i;
          if (i == 0) {
            j = 57;
          }
          qgg.c(paramActivity, str2, str1, j);
          return true;
        case 5: 
          qgg.a(paramActivity, str6, str1, j, i, 0, null);
          return true;
        case 8: 
          j = i;
          if (i == 0) {
            j = 90;
          }
          qgg.c(paramActivity, str2, str1, j);
          return true;
        case 9: 
          b(paramHashMap, "time_zone", -1);
          j = i;
          if (i == 0) {
            j = 96;
          }
          qgg.j(paramActivity, str1, j);
          return true;
        case 10: 
          paramQQAppInterface = (String)paramHashMap.get("bannerID");
          if (!TextUtils.isEmpty(paramQQAppInterface)) {
            qgg.a(paramActivity, new OpenPlayerBuilder(new DiscoverBannerPlayInfo(paramQQAppInterface), 102).b());
          }
          return true;
        case 0: 
          return b(paramQQAppInterface, paramActivity, paramHashMap, paramString);
        }
      }
    }
  }
  
  private boolean a(Runnable paramRunnable, String paramString1, String paramString2, String paramString3)
  {
    this.cUe = false;
    ThreadManagerV2.executeOnSubThread(new JumpAction.7(this, paramString1, System.currentTimeMillis(), paramString2, paramString3, paramRunnable));
    return true;
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("PayInvokerId", 13);
    localBundle.putString("viewParam", paramString1);
    if (paramString2 != null) {
      localBundle.putString("entry", paramString2);
    }
    if (paramLong != 0L) {
      localBundle.putLong("vacreport_key_seq", paramLong);
    }
    if (paramBundle != null) {
      localBundle.putBundle("extra_pay_data", paramBundle);
    }
    VACDReportUtil.b(paramLong, null, "loadPluginStart", null, 0, null);
    QWalletPayBridge.launchForeground((Activity)this.context, this.app, localBundle);
    return true;
  }
  
  private boolean aCQ()
  {
    try
    {
      i = Integer.parseInt(this.ctj);
      switch (i)
      {
      default: 
        return true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("JumpAction", 1, "handleQfavHelperAction error:" + localNumberFormatException.getMessage());
        int i = -1;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("selfSet_leftViewText", BaseApplicationImpl.getApplication().getApplicationContext().getString(2131691039));
      return avja.a((Activity)this.context, this.app.getAccount(), localIntent, -1, false);
    }
  }
  
  private boolean aCR()
  {
    String str = toBase64Decode((String)this.attrs.get("url"));
    if ((TextUtils.isEmpty((CharSequence)this.attrs.get("appid"))) || (TextUtils.isEmpty((CharSequence)this.attrs.get("openid"))))
    {
      QLog.e("JumpAction", 1, "identification with illegal params");
      return true;
    }
    anot.a(this.app, "dc00898", "", "", "0X80097E8", "0X80097E8", 0, 0, "", "", (String)this.attrs.get("appid"), "");
    aiao.aoH();
    Intent localIntent = new Intent(this.context, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    this.context.startActivity(localIntent);
    return true;
  }
  
  private boolean aCS()
  {
    if ((this.attrs != null) && (this.attrs.containsKey("mini_appid")) && (!this.attrs.containsKey("fakeUrl"))) {}
    for (int i = 1; i != 0; i = 0) {
      return com.tencent.mobileqq.microapp.sdk.MiniAppLauncher.launchMiniAppByScheme(this.context, this.attrs);
    }
    return com.tencent.mobileqq.mini.sdk.MiniAppLauncher.launchMiniAppByScheme(this.context, this.attrs, 2016, null, null);
  }
  
  private boolean aCT()
  {
    String str2 = null;
    if (this.attrs.containsKey("app")) {}
    for (String str1 = (String)this.attrs.get("app");; str1 = null)
    {
      if (this.attrs.containsKey("type")) {
        str2 = (String)this.attrs.get("type");
      }
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        ((aagv)this.app.getManager(315)).u(this.context, str1, str2);
      }
      return true;
    }
  }
  
  private boolean aCU()
  {
    String str1;
    if (this.attrs.containsKey("entry")) {
      str1 = (String)this.attrs.get("entry");
    }
    for (;;)
    {
      String str2;
      label56:
      long l2;
      long l1;
      if (this.attrs.containsKey("seq"))
      {
        str2 = (String)this.attrs.get("seq");
        l2 = 0L;
        l1 = l2;
        if (TextUtils.isEmpty(str2)) {}
      }
      try
      {
        l1 = Long.valueOf(str2).longValue();
      }
      catch (Exception localException1)
      {
        try
        {
          VACDReportUtil.b(l1, "", "jumpParse", null, 0, null);
          for (;;)
          {
            label89:
            str2 = (String)this.attrs.get("view");
            if (("1".equals(str2)) || ("2".equals(str2)) || ("3".equals(str2)) || ("4".equals(str2)) || ("5".equals(str2)) || ("6".equals(str2)) || ("7".equals(str2)) || ("9".equals(str2)) || ("10".equals(str2)) || ("11".equals(str2)))
            {
              Bundle localBundle = new Bundle();
              if (this.attrs.containsKey("tokenid")) {
                localBundle.putString("tokenid", (String)this.attrs.get("tokenid"));
              }
              if (this.attrs.containsKey("data")) {
                localBundle.putString("data", (String)this.attrs.get("data"));
              }
              return a(str2, str1, l1, localBundle);
              str1 = null;
              break;
              str2 = null;
              break label56;
            }
            if ("8".equals(str2)) {
              return e(str2, str1, l1);
            }
            return false;
            localException1 = localException1;
            l1 = l2;
          }
        }
        catch (Exception localException2)
        {
          break label89;
        }
      }
    }
  }
  
  private boolean aCV()
  {
    if (this.ctj.equals("emoji")) {
      EmojiHomeUiPlugin.openEmojiHomePage((Activity)this.context, this.app.getAccount(), 7);
    }
    do
    {
      return true;
      if (this.ctj.equals("emoji_detail"))
      {
        EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.context, this.app.getAccount(), 4, getAttribute("detailid"));
        return true;
      }
      if (this.ctj.equals("emoji_author"))
      {
        EmojiHomeUiPlugin.openEmojiAuthorPage((Activity)this.context, this.app.getAccount(), 5, getAttribute("authorid"));
        return true;
      }
      if (this.ctj.equals("bubble"))
      {
        VasWebviewUtil.openQQBrowserWithoutAD(this.context, aqqj.o(this.context, "bubble", "mvip.gongneng.android.bubble.index_dynamic_tab"), 64L, null, false, -1);
        return true;
      }
      if (this.ctj.equals("theme"))
      {
        if ((!BaseApplicationImpl.IS_SUPPORT_THEME) || (!aqft.cC())) {
          break label632;
        }
        VasWebviewUtil.openQQBrowserWithoutAD(this.context, aqqj.o(this.context, "theme", "mvip.gongneng.android.theme.index_dynamic_tab"), 32L, null, false, -1);
        return true;
      }
      if (this.ctj.equals("font"))
      {
        if ((!((ku)this.app.getManager(42)).aB()) || (!aqft.cC())) {
          break label632;
        }
        VasWebviewUtil.openQQBrowserWithoutAD(this.context, aqqj.o(this.context, "font", ""), 4096L, null, false, -1);
        return true;
      }
      if (!this.ctj.equals("pendant")) {
        break;
      }
    } while (!aqft.cC());
    aqgm.m(this.app, this.context);
    return true;
    if (this.ctj.equals("individuation"))
    {
      VasWebviewUtil.openIndividuationIndex(this.context);
      return true;
    }
    Intent localIntent;
    Object localObject1;
    int i;
    int j;
    if (this.ctj.equals("apollo_store"))
    {
      localIntent = new Intent();
      localObject1 = this.source.split("\\?");
      if (localObject1.length < 2) {
        break label634;
      }
      localIntent.putExtra("extra_key_url_append", localObject1[1]);
      if (localObject1[1] == null) {
        break label634;
      }
      if (localObject1[1].contains("tab=game_center"))
      {
        i = 0;
        j = 1;
        localObject1 = null;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, new Object[] { "apollo_store url:", localObject1 });
      }
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = abxi.bju;
      }
      if (j != 0) {
        ApolloUtil.dF(this.context);
      }
      for (;;)
      {
        if (this.app == null) {
          break label630;
        }
        localObject1 = (abhh)this.app.getManager(153);
        VipUtils.a(this.app, "cmshow", "Apollo", "action_clk", ((abhh)localObject1).cd(this.app.getCurrentUin()), 0, new String[] { "0" });
        return true;
        if (localObject1[1].contains("tab=other_url&url="))
        {
          localObject1 = URLDecoder.decode(localObject1[1].substring(localObject1[1].indexOf("tab=other_url&url=") + "tab=other_url&url=".length()));
          j = 0;
          i = 1;
          break;
        }
        localObject2 = new HashMap();
        qdy.g(localObject1[1], (HashMap)localObject2);
        localObject1 = abhh.s((String)((HashMap)localObject2).get("tab"), true);
        j = 0;
        i = 0;
        break;
        if (i != 0) {
          ApolloUtil.bp(this.context, (String)localObject2);
        } else {
          ApolloUtil.a(this.context, localIntent, null, (String)localObject2, null);
        }
      }
      label630:
      break;
      label632:
      return false;
      label634:
      i = 0;
      j = 0;
      localObject1 = null;
    }
  }
  
  private boolean aCW()
  {
    if (QLog.isColorLevel()) {
      QLog.i("JumpAction", 2, "enter jiankang");
    }
    ThreadManager.post(new JumpAction.2(this), 5, null, true);
    if ((Build.VERSION.SDK_INT >= 19) && (((SensorManager)this.context.getSystemService("sensor")).getDefaultSensor(19) != null) && (this.app != null)) {
      ((aqtz)this.app.getManager(260)).VI("jump action");
    }
    Object localObject2 = toBase64Decode((String)this.attrs.get("url_prefix"));
    if ((localObject2 == null) || ((!((String)localObject2).startsWith("http://")) && (!((String)localObject2).startsWith("https://"))) || ((!jqo.dV((String)localObject2).equalsIgnoreCase("qq.com")) && (!jqo.dV((String)localObject2).equalsIgnoreCase("myun.tenpay.com")) && (!jqo.dV((String)localObject2).equalsIgnoreCase("tenpay.com")) && (!jqo.dV((String)localObject2).equalsIgnoreCase("wanggou.com")))) {
      return false;
    }
    Object localObject1 = localObject2;
    if (((String)localObject2).indexOf("?") <= 0) {
      localObject1 = (String)localObject2 + "?";
    }
    localObject2 = new StringBuilder((String)localObject1);
    StringBuilder localStringBuilder = ((StringBuilder)localObject2).append("&client=androidQQ").append("&uin=").append(this.app.getCurrentAccountUin()).append("&version=").append("3.4.4.3058").append("&system=").append(Build.VERSION.RELEASE).append("&device=").append(Build.DEVICE).append("&density=").append(ThemeUtil.getThemeDensity(this.app.getApplication().getApplicationContext())).append("&platformId=2").append("&_lv=0").append("&hasRedDot=");
    if (this.dw) {}
    for (localObject1 = "1";; localObject1 = "0")
    {
      localStringBuilder.append((String)localObject1).append("&adtag=mvip.gongneng.anroid.health.nativet");
      localObject1 = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0);
      ((StringBuilder)localObject2).append("&lati=").append(((SharedPreferences)localObject1).getFloat("search_lbs_latitude", 0.0F));
      ((StringBuilder)localObject2).append("&logi=").append(((SharedPreferences)localObject1).getFloat("search_lbs_logitude", 0.0F));
      int i = aqiw.getSystemNetwork(this.app.getApp().getApplicationContext());
      ((StringBuilder)localObject2).append("&netType=" + i);
      localObject1 = aqgz.getDeviceModel();
      ((StringBuilder)localObject2).append("&model=" + (String)localObject1);
      localObject1 = new Intent(this.context, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", ((StringBuilder)localObject2).toString());
      ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
      this.context.startActivity((Intent)localObject1);
      return true;
    }
  }
  
  private boolean aCX()
  {
    boolean bool = false;
    String str1 = (String)this.attrs.get("bid");
    String str2 = (String)this.attrs.get("sourceUrl");
    Object localObject;
    if (this.ctj.equals("web")) {
      localObject = (String)this.attrs.get("url");
    }
    try
    {
      localObject = URLDecoder.decode((String)localObject);
      localObject = new Intent(this.context, PublicAccountBrowser.class).putExtra("url", (String)localObject);
      ((Intent)localObject).putExtra("uin", this.app.getCurrentAccountUin());
      ((Intent)localObject).putExtra("hide_operation_bar", true);
      ((Intent)localObject).putExtra("hideRightButton", true);
      this.context.startActivity((Intent)localObject);
      if ((str1 != null) && (str2 != null)) {
        anot.b(this.app, "P_CliOper", "Grp_tribe", "", "url", "visit", 0, 1, 0, str1, jqo.filterKeyForLog(str2, new String[0]), "", "");
      }
      bool = true;
    }
    catch (Exception localException)
    {
      while (!QLog.isDevelopLevel()) {}
      QLog.e("JumpAction", 4, "URLDecoder.decode error");
    }
    return bool;
    return false;
  }
  
  private boolean aCY()
  {
    if (this.ctj.equals("open")) {
      return aEC();
    }
    if (this.ctj.equals("report")) {
      return aED();
    }
    if (this.ctj.equals("reportrealtime")) {
      return aEE();
    }
    Object localObject1;
    int i;
    Object localObject2;
    if (this.ctj.equals("apenalbum"))
    {
      localObject1 = (String)this.attrs.get("articleid");
      i = Integer.parseInt((String)this.attrs.get("uin_type"));
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new Intent(this.context, PublicAccountImageCollectionMainActivity.class);
        ((Intent)localObject2).putExtra("source_for_report", i);
        oub.a((Activity)this.context, (Intent)localObject2, (String)localObject1);
      }
    }
    for (;;)
    {
      return false;
      if (this.ctj.equals("multivideo")) {
        return aEF();
      }
      if (this.ctj.equals("openatlas"))
      {
        if (this.attrs.containsKey("rowkey")) {}
        for (localObject1 = (String)this.attrs.get("rowkey"); TextUtils.isEmpty((CharSequence)localObject1); localObject1 = "")
        {
          if (QLog.isColorLevel()) {
            QLog.e("JumpAction", 2, "rowKey is Empty");
          }
          return false;
        }
        label264:
        String str1;
        label292:
        String str2;
        label320:
        String str3;
        label348:
        label376:
        String str4;
        label404:
        String str5;
        label432:
        label460:
        String str6;
        if (this.attrs.containsKey("picindex"))
        {
          localObject2 = (String)this.attrs.get("picindex");
          if (!this.attrs.containsKey("source")) {
            break label628;
          }
          str1 = (String)this.attrs.get("source");
          if (!this.attrs.containsKey("enteranimationstyle")) {
            break label636;
          }
          str2 = (String)this.attrs.get("enteranimationstyle");
          if (!this.attrs.containsKey("hideTopic")) {
            break label644;
          }
          str3 = (String)this.attrs.get("hideTopic");
          if (!this.attrs.containsKey("commentId")) {
            break label647;
          }
          str3 = (String)this.attrs.get("commentId");
          if (!this.attrs.containsKey("subCommentId")) {
            break label654;
          }
          str4 = (String)this.attrs.get("subCommentId");
          if (!this.attrs.containsKey("albumStyle")) {
            break label661;
          }
          str5 = (String)this.attrs.get("albumStyle");
          if (!this.attrs.containsKey("jumpCommentType")) {
            break label664;
          }
          str5 = (String)this.attrs.get("jumpCommentType");
          if (!this.attrs.containsKey("isAwesome")) {
            break label671;
          }
          str6 = (String)this.attrs.get("isAwesome");
        }
        for (;;)
        {
          for (;;)
          {
            int j;
            label644:
            label647:
            label654:
            label661:
            label664:
            label671:
            try
            {
              Integer.valueOf((String)localObject2).intValue();
              i = Integer.valueOf(str1).intValue();
            }
            catch (Exception localException1)
            {
              label628:
              label636:
              i = 0;
            }
            try
            {
              Integer.valueOf(str2).intValue();
              j = i;
              if (!Boolean.valueOf(awit.I(kxm.getAppRuntime())).booleanValue()) {
                break label705;
              }
              localObject1 = "https://viola.qq.com/js/kd_pic_detail.js?_rij_violaUrl=1&v_tid=15&v_bid=3811&v_bundleName=kd_pic_detail&hideNav=1&v_nav_immer=1&v_minVersion=8.0.8&v_from_native=1&rowkey=" + (String)localObject1 + "&album_source=" + j + "&isAwesome=" + str6 + "&commentId=" + str3 + "&subCommentId=" + str4 + "&jumpCommentType=" + str5;
              ntp.b(this.context, null, (String)localObject1, null);
            }
            catch (Exception localException2)
            {
              label682:
              break label682;
            }
          }
          localObject2 = "0";
          break label264;
          str1 = "0";
          break label292;
          str2 = "0";
          break label320;
          break label348;
          str3 = "";
          break label376;
          str4 = "";
          break label404;
          break label432;
          str5 = "";
          break label460;
          str6 = "";
          continue;
          j = i;
          if (QLog.isColorLevel())
          {
            QLog.e("JumpAction", 2, "Parameter error");
            j = i;
          }
        }
        label705:
        if (QLog.isColorLevel()) {
          QLog.e("JumpAction", 2, "jumpToGallery failed: atlas has undercarriage");
        }
      }
      else
      {
        if (this.ctj.equals("selfpage"))
        {
          kgw.p(this.context, false);
          return true;
        }
        if ("showugceditor".equals(this.ctj))
        {
          edQ();
        }
        else if ("openarticle".equals(this.ctj))
        {
          localObject1 = kgw.c(this.context, this.attrs);
          if ((this.context instanceof FastWebActivity)) {
            ((FastWebActivity)this.context).aT((Intent)localObject1);
          } else {
            this.context.startActivity((Intent)localObject1);
          }
        }
      }
    }
  }
  
  private boolean aCZ()
  {
    Object localObject1;
    Object localObject2;
    if ("opendetail".equals(this.ctj))
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putLong("key_launch_time", System.currentTimeMillis());
      localObject2 = (String)this.attrs.get("uin");
      if ((localObject2 == null) || ("".equals(localObject2)) || (((String)localObject2).length() < 5)) {
        return false;
      }
    }
    try
    {
      ((Bundle)localObject1).putLong("key_current_feeduin", Long.valueOf((String)localObject2).longValue());
      ((Bundle)localObject1).putString("key_current_feed_cellid", (String)this.attrs.get("cellid"));
      ((Bundle)localObject1).putInt("key_request_from", 3);
      ((Bundle)localObject1).putInt("key_weishi_entrance_type", 19);
      ((Bundle)localObject1).putInt("key_request_business_type", 8);
      dt((Bundle)localObject1);
      for (;;)
      {
        return true;
        if (!"takevideo".equals(this.ctj)) {
          continue;
        }
        localObject2 = (String)this.attrs.get("widgetid");
        String str1 = (String)this.attrs.get("from");
        String str2 = (String)this.attrs.get("activity_id");
        String str3 = (String)this.attrs.get("shareto");
        localObject1 = (String)this.attrs.get("cmode");
        String str4 = (String)this.attrs.get("widgetinfo");
        Bundle localBundle = new Bundle();
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localBundle.putString("KEY_CURRENT_SELECT_ID", (String)localObject2);
        }
        localBundle = aywz.e(localBundle, str4);
        axiy.i("JumpAction", "【widgetid】:" + (String)localObject2 + "【" + "from" + "】:" + str1 + "【" + "activity_id" + "】:" + str2 + "【" + "shareto" + "】:" + str3 + "【" + "cmode" + "】:" + (String)localObject1 + "【" + "widgetinfo" + "】:" + str4);
        try
        {
          i = axcg.a(str1).getId();
          d(localBundle, i);
          if (axcg.oe(i)) {
            localObject1 = "cameraAndPlay";
          }
        }
        catch (Exception localException1)
        {
          try
          {
            int i;
            localBundle.putInt("VIDEO_STORY_FROM_TYPE", i);
            localObject2 = localObject1;
            label447:
            if (TextUtils.isEmpty(str2)) {}
          }
          catch (Exception localException5)
          {
            label465:
            label484:
            label503:
            break label503;
          }
          try
          {
            localBundle.putString("VIDEO_STORY_ACTIVITY_ID", str2);
            if (TextUtils.isEmpty((CharSequence)localObject2)) {}
          }
          catch (Exception localException1)
          {
            try
            {
              localBundle.putInt("AECAMERA_MODE", axcg.gm((String)localObject2));
              axcj.b((Activity)this.context, 120, localBundle);
              continue;
              localException4 = localException4;
              localObject2 = localObject1;
              if (!QLog.isColorLevel()) {
                break label447;
              }
              QLog.e("JumpAction", 2, "Invalid VIDEO_STORY_FROM_TYPE format: " + localException4.getMessage());
              localObject2 = localObject1;
              break label447;
              localException1 = localException1;
              if (!QLog.isColorLevel()) {
                break label465;
              }
              QLog.e("JumpAction", 2, "Invalid VIDEO_STORY_ACTIVITY_ID format: " + localException1.getMessage());
            }
            catch (Exception localException2)
            {
              if (!QLog.isColorLevel()) {
                break label484;
              }
              QLog.e("JumpAction", 2, "Invalid AECAMERA_MODE format: " + localException2.getMessage());
              break label484;
            }
          }
        }
      }
    }
    catch (Exception localException3)
    {
      for (;;) {}
    }
  }
  
  private boolean aDA()
  {
    String str2 = (String)this.attrs.get("uin");
    String str5 = toBase64Decode((String)this.attrs.get("attach_content"));
    Object localObject3 = (String)this.attrs.get("chat_type");
    String str8 = (String)this.attrs.get("open_type");
    Object localObject1 = (String)this.attrs.get("sigt");
    Object localObject4 = (String)this.attrs.get("sig");
    String str9 = toBase64Decode((String)this.attrs.get("open_id"));
    String str10 = toBase64Decode((String)this.attrs.get("app_id"));
    String str11 = toBase64Decode((String)this.attrs.get("app_pkg_name"));
    String str6 = (String)this.attrs.get("reply_content");
    String str7 = (String)this.attrs.get("reply_time");
    if (QLog.isColorLevel()) {
      QLog.i("JumpAction", 2, String.format("gotoChat [uin,type,replyContent,replyTime]=[%s,%s,%s,%s]", new Object[] { str2, localObject3, str6, str7 }));
    }
    String str3 = (String)this.attrs.get("panel");
    String str4 = (String)this.attrs.get("params");
    if ((str4 != null) && (QLog.isDevelopLevel())) {
      QLog.d("JumpAction", 4, str4 + "");
    }
    localObject1 = null;
    Object localObject2 = null;
    if (this.app != null)
    {
      localObject1 = (acff)this.app.getManager(51);
      localObject2 = (TroopManager)this.app.getManager(52);
    }
    boolean bool1;
    int i;
    if ("c2c".equals(localObject3))
    {
      if ((str2 == null) || (str2.length() < 5))
      {
        bool1 = false;
        return bool1;
      }
      if (((acff)localObject1).isFriend(str2))
      {
        localObject3 = aqgv.s(this.app, str2);
        if ("chat".equals(str8))
        {
          localObject1 = new Intent(this.context, ChatActivity.class);
          ((Intent)localObject1).putExtra("uin", str2);
          ((Intent)localObject1).putExtra("uintype", 0);
          if (localObject3 != null) {
            ((Intent)localObject1).putExtra("uinname", (String)localObject3);
          }
          if (!TextUtils.isEmpty(str6))
          {
            ((Intent)localObject1).putExtra("key_aio_reply_content", str6);
            ((Intent)localObject1).putExtra("key_aio_reply_time", str7);
          }
          ((Intent)localObject1).addFlags(67108864);
          this.context.startActivity((Intent)localObject1);
          anot.a(this.app, "dc00898", "", "", "0X8007191", "0X8007191", 0, 0, "", "", "", "");
          return true;
        }
      }
      else
      {
        return false;
      }
    }
    else if ("discuss".equals(localObject3))
    {
      if ((str2 == null) || (str2.length() < 6)) {
        return false;
      }
      localObject3 = (String)this.attrs.get("discuss_info");
      localObject2 = null;
      i = 3000;
      localObject1 = null;
    }
    for (;;)
    {
      localObject4 = wja.a(new Intent(this.context, SplashActivity.class), new int[] { 2 });
      ((Intent)localObject4).putExtra("uin", str2);
      ((Intent)localObject4).putExtra("uintype", i);
      if (localObject3 != null) {
        ((Intent)localObject4).putExtra("uinname", (String)localObject3);
      }
      if (str5 != null) {
        ((Intent)localObject4).putExtra("input_text", str5);
      }
      if (!TextUtils.isEmpty(str6))
      {
        ((Intent)localObject4).putExtra("key_aio_reply_content", str6);
        ((Intent)localObject4).putExtra("key_aio_reply_time", str7);
      }
      if ((localObject2 != null) && (localObject2.length > 0)) {
        ((Intent)localObject4).putExtra((String)localObject1, (byte[])localObject2);
      }
      if ((str4 != null) && (!"".equals(str4))) {
        if ((str2 == null) || ("".equals(str2)))
        {
          return false;
          if ("group".equals(localObject3))
          {
            if ((str2 == null) || (str2.length() < 6)) {
              return false;
            }
            localObject1 = ((TroopManager)localObject2).b(str2);
            if (localObject1 != null)
            {
              i = 1;
              localObject3 = ((TroopInfo)localObject1).getTroopName();
              localObject2 = null;
              localObject1 = null;
              continue;
            }
            return false;
          }
          if ("robot".equals(localObject3))
          {
            if ((str2 == null) || ("".equals(str2))) {
              return false;
            }
            localObject3 = aqgv.o(this.app, str2);
            i = 1001;
            localObject2 = null;
            localObject1 = null;
            continue;
          }
          if ("wpa".equals(localObject3))
          {
            if ((str2 == null) || (str2.length() < 5) || (str2.equals(this.app.getCurrentAccountUin()))) {
              return false;
            }
            if (((acff)localObject1).isFriend(str2)) {
              i = 0;
            }
            for (localObject1 = aqgv.o(this.app, str2);; localObject1 = null)
            {
              UG(str2);
              localObject2 = null;
              localObject3 = localObject1;
              localObject1 = null;
              break;
              i = 1005;
            }
          }
          if ("crm".equals(localObject3))
          {
            boolean bool2 = aDE();
            bool1 = bool2;
            if (!bool2) {
              bool1 = aDB();
            }
            bool2 = bool1;
            if (!bool1) {
              bool2 = aDC();
            }
            bool1 = bool2;
            if (bool2) {
              break;
            }
            return aDD();
          }
          if (("lbs".equals(localObject3)) || ("date".equals(localObject3)))
          {
            if ((str2 == null) || (str2.length() < 5) || (str2.equals(this.app.getCurrentAccountUin()))) {
              return false;
            }
            if (((acff)localObject1).isFriend(str2))
            {
              i = 0;
              localObject3 = aqgv.o(this.app, str2);
              localObject1 = null;
            }
          }
        }
      }
      for (;;)
      {
        if ((localObject1 != null) && (localObject4 != null))
        {
          localObject2 = aqhs.hexStr2Bytes((String)localObject4);
          break;
          if ("lbs".equals(localObject3))
          {
            i = 1001;
            localObject3 = aqgv.G(this.app, str2);
            localObject1 = "rich_accost_sig";
          }
          else
          {
            i = 1010;
            localObject3 = aqgv.G(this.app, str2);
            localObject1 = "rich_date_sig";
            continue;
            if ("public_account".equals(localObject3))
            {
              if ((str2 == null) || (str2.length() < 6)) {
                return false;
              }
              localObject1 = ocp.getNickName(this.app, str2);
              kbp.a(this.app, "P_CliOper", "Pb_account_lifeservice", str2, "0X800589E", "0X800589E", 0, 0, str2, "", "", "", false);
              localObject2 = new Intent(this.context, ChatActivity.class);
              ((Intent)localObject2).putExtra("uin", str2);
              ((Intent)localObject2).putExtra("uintype", 1008);
              if (localObject1 != null) {
                ((Intent)localObject2).putExtra("uinname", (String)localObject1);
              }
              if (("2747277822".equals(str2)) && (ahty.anY())) {
                ahua.er(this.context);
              }
              for (;;)
              {
                return true;
                this.context.startActivity((Intent)localObject2);
              }
            }
            if ("qd_account".equals(localObject3))
            {
              if ((str2 == null) || (str2.length() < 6)) {
                return false;
              }
              localObject1 = wja.a(new Intent(this.context, SplashActivity.class), new int[] { 2 });
              ((Intent)localObject1).putExtra("uin", str2);
              ((Intent)localObject1).putExtra("uintype", 1008);
              localObject2 = (String)this.attrs.get("key");
              localObject3 = (String)this.attrs.get("kfuin");
              str2 = (String)this.attrs.get("assign_type");
              str3 = (String)this.attrs.get("assign_key");
              str4 = (String)this.attrs.get("ext");
              str5 = (String)this.attrs.get("rkey");
              if (QLog.isColorLevel()) {
                QLog.d("JumpAction", 2, "QD_ACCOUNT_TYPE " + (String)localObject3 + " " + str2 + " " + str3 + " " + str4 + " " + str5);
              }
              if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject3))) {
                return false;
              }
              ((Intent)localObject1).putExtra("qd_wpa_key", (String)localObject2);
              ((Intent)localObject1).putExtra("qd_kfuin", (String)localObject3);
              if (!TextUtils.isEmpty(str2)) {
                ((Intent)localObject1).putExtra("assign_type", str2);
              }
              if (!TextUtils.isEmpty(str3)) {
                ((Intent)localObject1).putExtra("assign_key", str3);
              }
              if (!TextUtils.isEmpty(str4)) {
                ((Intent)localObject1).putExtra("assign_ext", str4);
              }
              if (!TextUtils.isEmpty(str5)) {
                ((Intent)localObject1).putExtra("rkey", str5);
              }
              this.context.startActivity((Intent)localObject1);
              return true;
            }
            if (("thirdparty2c".equals(localObject3)) || ("audio_chat".equals(localObject3)) || ("video_chat".equals(localObject3)))
            {
              if (!aqiw.isNetSupport(this.context))
              {
                QQToast.a(this.context, 1, 2131701785, 1).show();
                localObject1 = new Intent(this.context, SplashActivity.class);
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).addFlags(268435456);
                this.context.startActivity((Intent)localObject1);
                return true;
              }
              if (!TextUtils.isEmpty(str9))
              {
                this.dJ = new Handler();
                this.dJ.postDelayed(new JumpAction.14(this), 20000L);
                try
                {
                  if ("thirdparty2c".equals(localObject3)) {
                    i = 18;
                  }
                  for (;;)
                  {
                    ahlw.Kj("KEY_STAGE_2_GO_TO_CHAT_D55");
                    this.app.a().a(true, str9, false, 0L, Long.valueOf(str10).longValue(), 1, i, str11, false, 0L, new aqhy(this, str9, str10, (String)localObject3));
                    return false;
                    if ("audio_chat".equals(localObject3))
                    {
                      i = 19;
                    }
                    else
                    {
                      bool1 = "video_chat".equals(localObject3);
                      if (bool1) {
                        i = 19;
                      } else {
                        i = 10000;
                      }
                    }
                  }
                  return true;
                }
                catch (Exception localException)
                {
                  return true;
                }
              }
            }
            return false;
            str1 = (String)this.attrs.get("callback_type");
            localObject2 = toBase64Decode((String)this.attrs.get("thirdAppDisplayName"));
            localObject3 = (String)this.attrs.get("appid");
            if ((str1 != null) && (!"".equals(str1))) {
              ((Intent)localObject4).putExtra("callback_type", str1);
            }
            if ((localObject2 != null) && (!"".equals(localObject2))) {
              ((Intent)localObject4).putExtra("thirdAppDisplayName", (String)localObject2);
            }
            if ((localObject3 != null) && (!"".equals(localObject3))) {
              ((Intent)localObject4).putExtra("appid", (String)localObject3);
            }
            t((Intent)localObject4, str4);
            anot.a(this.app, "CliOper", "", str2, "0X8004B4B", "0X8004B4B", 0, 0, "", "", "", "");
            if ("webview".equals(this.from))
            {
              ((Intent)localObject4).putExtra("from", this.from);
              if (dZn > 3)
              {
                QQToast.a(this.context, acfp.m(2131707538), 1).show();
                return true;
              }
              dZn += 1;
              anot.a(this.app, "CliOper", "", str2, "0X8004B5A", "0X8004B5A", 0, 0, "", "", "", "");
            }
            for (;;)
            {
              if (str3 != null) {
                ((Intent)localObject4).putExtra("panel", str3);
              }
              this.context.startActivity((Intent)localObject4);
              return true;
              anot.a(this.app, "CliOper", "", str2, "0X8004B58", "0X8004B58", 0, 0, "", "", "", "");
            }
          }
        }
      }
      localObject2 = null;
      continue;
      i = 0;
      localObject2 = null;
      String str1 = null;
    }
  }
  
  private boolean aDB()
  {
    String str1 = (String)this.attrs.get("wpaType");
    String str2 = (String)this.attrs.get("assignId");
    String str3 = (String)this.attrs.get("QidianSigT");
    String str4 = (String)this.attrs.get("QidianKfUin");
    Object localObject = (String)this.attrs.get("rkey");
    String str5 = (String)this.attrs.get("shouldReturnToRoot");
    Intent localIntent;
    String str6;
    String str7;
    boolean bool1;
    if ((str1 != null) && (str2 != null) && (str3 != null) && (str4 != null))
    {
      try
      {
        if (!str1.equals("2")) {
          break label532;
        }
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "handleQidianExtWPA wpaType = 2");
        }
        localIntent = new Intent();
        if ((TextUtils.isEmpty(str5)) || (str5.equals("NO"))) {
          localIntent.setComponent(new ComponentName(this.context, ChatActivity.class));
        }
        for (;;)
        {
          localIntent.addFlags(67108864);
          str6 = (String)this.attrs.get("sigt");
          str7 = (String)this.attrs.get("uin");
          if (str7 == null) {
            break label396;
          }
          if (str7.length() < 5) {
            break label573;
          }
          if (!str7.equals(this.app.getCurrentAccountUin())) {
            break;
          }
          return false;
          localIntent.setComponent(new ComponentName(this.context, SplashActivity.class));
          localIntent.putExtra("open_chatfragment", true);
        }
        bool2 = bool1;
      }
      catch (Exception localException1)
      {
        bool1 = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, localException1.getMessage());
      }
    }
    for (boolean bool2 = bool1;; bool2 = false)
    {
      return bool2;
      if (str6 != null) {
        localIntent.putExtra("sigt", aqhs.hexStr2Bytes(str6));
      }
      if (((acff)this.app.getManager(51)).isFriend(str7))
      {
        localIntent.putExtra("uintype", 0);
        localIntent.putExtra("uinname", aqgv.o(this.app, str7));
        label376:
        localIntent.putExtra("uin", str7);
        this.context.startActivity(localIntent);
      }
      for (;;)
      {
        for (;;)
        {
          label396:
          ((ashy)this.app.getBusinessHandler(85)).b(str4, localException1, str3, str2, (String)localObject, str5, this.jdField_b_of_type_Ashx.eme);
          try
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("wpaType: ").append(localException1).append("assignId: ").append(str2).append("qidianSigt: ").append(str3).append("qidianUin: ").append(str4);
              QLog.d("JumpAction", 2, ((StringBuilder)localObject).toString());
            }
            bool2 = true;
          }
          catch (Exception localException2)
          {
            label532:
            bool1 = true;
          }
        }
        localIntent.putExtra("uintype", 1025);
        localIntent.putExtra("from_wpa_for_crm", true);
        break label376;
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "handleQidianExtWPA wpaType != 2");
        }
        this.app.addObserver(this.jdField_b_of_type_Ashx);
      }
      break;
    }
    label573:
    return false;
  }
  
  private boolean aDC()
  {
    String str1 = (String)this.attrs.get("uin");
    String str2 = (String)this.attrs.get("sigt");
    String str3 = (String)this.attrs.get("wpaType");
    String str4 = (String)this.attrs.get("assignId");
    String str5 = (String)this.attrs.get("QidianKfUin");
    String str6 = (String)this.attrs.get("shouldReturnToRoot");
    if ((str1 != null) && (str2 != null) && (str3 != null) && (str4 != null) && (str5 != null)) {
      for (;;)
      {
        try
        {
          this.app.addObserver(this.jdField_b_of_type_Ashx);
          ((ashy)this.app.getBusinessHandler(85)).n(str5, str2, str1, str3, str4, str6);
          bool3 = true;
          bool1 = true;
          boolean bool2 = bool1;
          bool2 = bool1;
        }
        catch (Exception localException1)
        {
          try
          {
            if (QLog.isColorLevel())
            {
              QLog.d("JumpAction", 2, "handleQidianCorpWPA");
              bool2 = bool1;
            }
            return bool2;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              boolean bool3;
              boolean bool1 = bool3;
            }
          }
          localException1 = localException1;
          bool1 = false;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("JumpAction", 2, localException1.getMessage());
          return bool1;
        }
      }
    }
    return false;
  }
  
  private boolean aDD()
  {
    String str1 = (String)this.attrs.get("uin");
    if ((str1 == null) || (str1.length() < 5) || (str1.equals(this.app.getCurrentAccountUin()))) {
      return false;
    }
    Object localObject = toBase64Decode((String)this.attrs.get("attach_content"));
    String str2 = (String)this.attrs.get("sigt");
    String str3 = (String)this.attrs.get("sig");
    String str4 = (String)this.attrs.get("shouldReturnToRoot");
    Intent localIntent = new Intent();
    int i;
    if ((TextUtils.isEmpty(str4)) || (str4.equals("NO")))
    {
      localIntent.setComponent(new ComponentName(this.context, ChatActivity.class));
      localIntent.addFlags(67108864);
      i = jqs.b(this.app, str1);
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "handleLegacyCrmWPA " + i);
      }
      localIntent.putExtra("from_wpa_for_crm", true);
      localIntent.putExtra("uin", str1);
      localIntent.putExtra("uintype", i);
      if (i != 0) {
        break label402;
      }
      str4 = aqgv.o(this.app, str1);
      if (str4 != null) {
        localIntent.putExtra("uinname", str4);
      }
    }
    for (;;)
    {
      if (localObject != null) {
        localIntent.putExtra("input_text", (String)localObject);
      }
      if ((str3 != null) && (str1 != null))
      {
        localObject = aqhs.hexStr2Bytes(str3);
        this.app.a().n(str1, (byte[])localObject);
      }
      if (str2 != null) {
        localIntent.putExtra("sigt", aqhs.hexStr2Bytes(str2));
      }
      this.context.startActivity(localIntent);
      anot.a(this.app, "P_CliOper", "Bqq_Crm", "", "Bqq_Crm", "Bqq_wpaaio_create", 0, 0, this.app.getCurrentAccountUin(), str1, "", "");
      return true;
      localIntent.setComponent(new ComponentName(this.context, SplashActivity.class));
      localIntent.putExtra("open_chatfragment", true);
      break;
      label402:
      if (i == 1024) {
        localIntent.putExtra("chat_subType", 1);
      }
    }
  }
  
  private boolean aDE()
  {
    String str1 = (String)this.attrs.get("request");
    if ((str1 == null) || (!str1.equals("videochat"))) {
      return false;
    }
    str1 = (String)this.attrs.get("uin");
    String str2 = (String)this.attrs.get("sigt");
    String str3 = (String)this.attrs.get("nickname");
    String str4 = (String)this.attrs.get("request_type");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str4)))
    {
      Intent localIntent = new Intent("com.tencent.mobileqq.qidian.openactionsheet");
      Bundle localBundle = new Bundle();
      localBundle.putString("request_type", str4);
      localBundle.putString("nickname", str3);
      localBundle.putString("uin", str1);
      localBundle.putString("sigt", str2);
      localIntent.putExtras(localBundle);
      this.context.sendBroadcast(localIntent, "com.tencent.tim.msg.permission.pushnotify");
      return true;
    }
    return false;
  }
  
  private boolean aDF()
  {
    String str = (String)this.attrs.get("uin");
    if ((str == null) || (str.length() < 6)) {
      return false;
    }
    Object localObject = (TroopManager)this.app.getManager(52);
    if (localObject == null) {
      return false;
    }
    localObject = ((TroopManager)localObject).b(str);
    if (localObject != null)
    {
      localObject = ((TroopInfo)localObject).getTroopName();
      Intent localIntent = new Intent();
      localIntent.setClass(this.context, SplashActivity.class);
      localIntent = wja.a(localIntent, new int[] { 2 });
      localIntent.putExtra("uin", str);
      localIntent.putExtra("uintype", 1);
      if (localObject != null) {
        localIntent.putExtra("uinname", (String)localObject);
      }
      this.context.startActivity(localIntent);
      return true;
    }
    return aDX();
  }
  
  private boolean aDG()
  {
    if (QLog.isColorLevel()) {
      ajrk.m("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    }
    String str = (String)this.attrs.get("lon");
    Object localObject = (String)this.attrs.get("lat");
    if ((str != null) && (localObject != null)) {}
    for (;;)
    {
      try
      {
        j = Integer.parseInt(str.trim());
        i = Integer.parseInt(((String)localObject).trim());
        str = toBase64Decode((String)this.attrs.get("title"));
        localObject = new Intent(this.context, NearbyActivity.class);
        ((Intent)localObject).putExtra("ENTER_TIME", System.currentTimeMillis());
        ((Intent)localObject).putExtra("lat", i);
        ((Intent)localObject).putExtra("lon", j);
        ((Intent)localObject).putExtra("filter", 0);
        if (str != null) {
          ((Intent)localObject).putExtra("title", str);
        }
        this.context.startActivity((Intent)localObject);
        return true;
      }
      catch (Exception localException)
      {
        return false;
      }
      int i = 0;
      int j = 0;
    }
  }
  
  private boolean aDH()
  {
    aozz.b(this.context, this.app);
    return true;
  }
  
  private boolean aDI()
  {
    if ((String)this.attrs.get("back_title") == null) {
      acfp.m(2131707554);
    }
    apbc localapbc = (apbc)this.app.getManager(32);
    if (localapbc != null) {
      localapbc.d((BaseActivity)this.context, 0);
    }
    return true;
  }
  
  private boolean aDJ()
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.putExtra("account", this.app.getCurrentAccountUin());
    String str = this.app.getCurrentNickname();
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = aqgv.n(this.app, this.app.getCurrentAccountUin());
    }
    localIntent.putExtra("nickname", (String)localObject);
    localObject = this.attrs.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      if ((!str.equals("version")) && (!str.equals("src_type"))) {
        localIntent.putExtra(str, (String)this.attrs.get(str));
      }
    }
    return a(localIntent, "cooperation.qqreader.QRBridgeActivity", "qqreaderplugin.apk");
  }
  
  /* Error */
  private boolean aDK()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   4: ldc_w 1976
    //   7: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 72	java/lang/String
    //   13: astore 6
    //   15: aload_0
    //   16: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   19: ldc_w 1978
    //   22: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast 72	java/lang/String
    //   28: astore 7
    //   30: aload 6
    //   32: ifnull +138 -> 170
    //   35: aload 7
    //   37: ifnull +133 -> 170
    //   40: aload 6
    //   42: invokevirtual 1981	java/lang/String:trim	()Ljava/lang/String;
    //   45: invokestatic 715	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   48: i2d
    //   49: ldc2_w 2041
    //   52: ddiv
    //   53: dstore_1
    //   54: aload 7
    //   56: invokevirtual 1981	java/lang/String:trim	()Ljava/lang/String;
    //   59: invokestatic 715	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   62: istore 5
    //   64: iload 5
    //   66: i2d
    //   67: ldc2_w 2041
    //   70: ddiv
    //   71: dstore_3
    //   72: aload_0
    //   73: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   76: ldc 238
    //   78: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   81: checkcast 72	java/lang/String
    //   84: invokestatic 241	aqhv:toBase64Decode	(Ljava/lang/String;)Ljava/lang/String;
    //   87: pop
    //   88: new 152	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   95: ldc_w 2044
    //   98: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: dload_3
    //   102: invokevirtual 2047	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   105: ldc_w 2049
    //   108: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: dload_1
    //   112: invokevirtual 2047	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   115: ldc_w 2051
    //   118: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: astore 6
    //   126: new 126	android/content/Intent
    //   129: dup
    //   130: ldc_w 504
    //   133: aload 6
    //   135: invokestatic 521	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   138: invokespecial 2054	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   141: astore 7
    //   143: aload 7
    //   145: ldc_w 2056
    //   148: ldc_w 2058
    //   151: invokevirtual 622	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   154: pop
    //   155: aload_0
    //   156: getfield 115	aqhv:context	Landroid/content/Context;
    //   159: aload 7
    //   161: invokevirtual 544	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   164: iconst_1
    //   165: ireturn
    //   166: astore 6
    //   168: iconst_0
    //   169: ireturn
    //   170: iconst_0
    //   171: ireturn
    //   172: astore 7
    //   174: aload_0
    //   175: getfield 115	aqhv:context	Landroid/content/Context;
    //   178: new 126	android/content/Intent
    //   181: dup
    //   182: ldc_w 504
    //   185: aload 6
    //   187: invokestatic 521	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   190: invokespecial 2054	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   193: invokevirtual 544	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   196: goto -32 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	aqhv
    //   53	59	1	d1	double
    //   71	31	3	d2	double
    //   62	3	5	i	int
    //   13	121	6	str	String
    //   166	20	6	localException	Exception
    //   28	132	7	localObject	Object
    //   172	1	7	localActivityNotFoundException	android.content.ActivityNotFoundException
    // Exception table:
    //   from	to	target	type
    //   40	64	166	java/lang/Exception
    //   155	164	172	android/content/ActivityNotFoundException
  }
  
  private boolean aDL()
  {
    if ("webview".equals(this.from))
    {
      toBase64Decode((String)this.attrs.get("title"));
      this.context.startActivity(new Intent(this.context, JumpActivity.class).putExtra("action", "select_location").putExtra("doCallBack", true).putExtra("src_type", (String)this.attrs.get("src_type")).putExtra("callback_type", (String)this.attrs.get("callback_type")).putExtra("callback_name", (String)this.attrs.get("callback_name")));
    }
    return true;
  }
  
  private boolean aDM()
  {
    String str1 = (String)this.attrs.get("card_type");
    if (QSecFramework.a().c(1003).booleanValue())
    {
      String str2 = (String)this.attrs.get("uin");
      arnv.a().n(5, str1, 0, str2);
      arnv.a().report();
    }
    if ((str1 != null) && ("group".equals(str1)))
    {
      kj(10010, LW());
      return aDX();
    }
    if ("groupsearchsetting".equalsIgnoreCase(str1)) {
      return aDV();
    }
    if ("groupmanager".equalsIgnoreCase(str1)) {
      return aDW();
    }
    if ("public_account".equals(str1))
    {
      kj(10003, LW());
      return aDQ();
    }
    if ("troopmember".equals(str1)) {
      return aDY();
    }
    if ("crm".equals(str1)) {
      return aDR();
    }
    if ("nearby".equals(str1)) {
      return aDN();
    }
    if ("allpeoplevote".equals(str1)) {
      return aDS();
    }
    if ("troopmemberfromhb".equals(str1)) {
      return aDZ();
    }
    kj(10002, LW());
    return aDT();
  }
  
  /* Error */
  private boolean aDN()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   4: ldc_w 2135
    //   7: invokevirtual 661	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   10: ifeq +329 -> 339
    //   13: aload_0
    //   14: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   17: ldc_w 2135
    //   20: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 72	java/lang/String
    //   26: astore 12
    //   28: aload_0
    //   29: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   32: ldc_w 2137
    //   35: invokevirtual 661	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   38: ifeq +308 -> 346
    //   41: aload_0
    //   42: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   45: ldc_w 2137
    //   48: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   51: checkcast 72	java/lang/String
    //   54: astore 11
    //   56: lconst_0
    //   57: lstore 5
    //   59: aload_0
    //   60: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   63: ldc_w 2139
    //   66: invokevirtual 661	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   69: ifeq +1257 -> 1326
    //   72: ldc_w 405
    //   75: aload_0
    //   76: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   79: ldc_w 2139
    //   82: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   85: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   88: ifeq +1238 -> 1326
    //   91: iconst_1
    //   92: istore 9
    //   94: lload 5
    //   96: lstore 7
    //   98: aload_0
    //   99: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   102: ldc_w 2141
    //   105: invokevirtual 661	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   108: ifeq +24 -> 132
    //   111: aload_0
    //   112: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   115: ldc_w 2141
    //   118: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   121: checkcast 72	java/lang/String
    //   124: invokestatic 283	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   127: invokevirtual 287	java/lang/Long:longValue	()J
    //   130: lstore 7
    //   132: aload_0
    //   133: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   136: ldc_w 2143
    //   139: invokevirtual 661	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   142: ifeq +242 -> 384
    //   145: aload_0
    //   146: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   149: ldc_w 2143
    //   152: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   155: checkcast 72	java/lang/String
    //   158: invokestatic 273	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   161: invokevirtual 276	java/lang/Integer:intValue	()I
    //   164: istore_1
    //   165: aload_0
    //   166: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   169: ldc_w 2145
    //   172: invokevirtual 661	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   175: ifeq +214 -> 389
    //   178: aload_0
    //   179: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   182: ldc_w 2145
    //   185: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   188: checkcast 72	java/lang/String
    //   191: astore 13
    //   193: aload 13
    //   195: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   198: istore 10
    //   200: iload 10
    //   202: ifeq +194 -> 396
    //   205: lconst_0
    //   206: lstore 5
    //   208: aload_0
    //   209: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   212: ldc_w 1548
    //   215: invokevirtual 661	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   218: ifeq +199 -> 417
    //   221: aload_0
    //   222: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   225: ldc_w 1548
    //   228: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   231: checkcast 72	java/lang/String
    //   234: astore 13
    //   236: aload 13
    //   238: invokestatic 715	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   241: istore_2
    //   242: aload_0
    //   243: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   246: ldc_w 2147
    //   249: invokevirtual 661	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   252: ifeq +179 -> 431
    //   255: aload_0
    //   256: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   259: ldc_w 2147
    //   262: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   265: checkcast 72	java/lang/String
    //   268: astore 13
    //   270: aload 13
    //   272: invokestatic 273	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   275: invokevirtual 276	java/lang/Integer:intValue	()I
    //   278: istore_3
    //   279: aload_0
    //   280: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   283: ldc_w 2149
    //   286: invokevirtual 661	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   289: ifeq +156 -> 445
    //   292: aload_0
    //   293: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   296: ldc_w 2149
    //   299: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   302: checkcast 72	java/lang/String
    //   305: astore 13
    //   307: aload 13
    //   309: invokestatic 273	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   312: invokevirtual 276	java/lang/Integer:intValue	()I
    //   315: istore 4
    //   317: iload_3
    //   318: iconst_1
    //   319: if_icmpeq +142 -> 461
    //   322: iload_3
    //   323: iconst_2
    //   324: if_icmpeq +137 -> 461
    //   327: iload_3
    //   328: iconst_3
    //   329: if_icmpeq +132 -> 461
    //   332: iload_3
    //   333: iconst_4
    //   334: if_icmpeq +127 -> 461
    //   337: iconst_0
    //   338: ireturn
    //   339: ldc 83
    //   341: astore 12
    //   343: goto -315 -> 28
    //   346: ldc 83
    //   348: astore 11
    //   350: goto -294 -> 56
    //   353: astore 13
    //   355: ldc_w 666
    //   358: iconst_1
    //   359: ldc_w 2151
    //   362: invokestatic 1253	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   365: lload 5
    //   367: lstore 7
    //   369: goto -237 -> 132
    //   372: astore 13
    //   374: ldc_w 666
    //   377: iconst_1
    //   378: ldc_w 2153
    //   381: invokestatic 1253	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   384: iconst_0
    //   385: istore_1
    //   386: goto -221 -> 165
    //   389: ldc 83
    //   391: astore 13
    //   393: goto -200 -> 193
    //   396: aload 13
    //   398: invokestatic 283	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   401: invokevirtual 287	java/lang/Long:longValue	()J
    //   404: lstore 5
    //   406: goto -198 -> 208
    //   409: astore 13
    //   411: lconst_0
    //   412: lstore 5
    //   414: goto -206 -> 208
    //   417: ldc 83
    //   419: astore 13
    //   421: goto -185 -> 236
    //   424: astore 13
    //   426: iconst_0
    //   427: istore_2
    //   428: goto -186 -> 242
    //   431: ldc 83
    //   433: astore 13
    //   435: goto -165 -> 270
    //   438: astore 13
    //   440: iconst_m1
    //   441: istore_3
    //   442: goto -163 -> 279
    //   445: ldc_w 422
    //   448: astore 13
    //   450: goto -143 -> 307
    //   453: astore 13
    //   455: iconst_0
    //   456: istore 4
    //   458: goto -141 -> 317
    //   461: new 126	android/content/Intent
    //   464: dup
    //   465: aload_0
    //   466: getfield 115	aqhv:context	Landroid/content/Context;
    //   469: ldc_w 2155
    //   472: invokespecial 131	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   475: astore 15
    //   477: aload 15
    //   479: ldc_w 2157
    //   482: iload 4
    //   484: invokevirtual 148	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   487: pop
    //   488: aload 15
    //   490: ldc_w 2159
    //   493: iload 9
    //   495: invokevirtual 137	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   498: pop
    //   499: aload 15
    //   501: ldc_w 2141
    //   504: lload 7
    //   506: invokevirtual 634	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   509: pop
    //   510: aload 15
    //   512: ldc_w 2161
    //   515: iload_1
    //   516: invokevirtual 148	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   519: pop
    //   520: iload_3
    //   521: tableswitch	default:+31 -> 552, 1:+33->554, 2:+33->554, 3:+431->952, 4:+685->1206
    //   553: ireturn
    //   554: aload_0
    //   555: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   558: ifnull +107 -> 665
    //   561: aload_0
    //   562: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   565: invokevirtual 413	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   568: astore 11
    //   570: aload 12
    //   572: ldc_w 2163
    //   575: invokestatic 2167	aqft:equalsWithNullCheck	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   578: ifeq +355 -> 933
    //   581: aload_0
    //   582: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   585: ldc_w 2169
    //   588: invokevirtual 661	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   591: ifeq +93 -> 684
    //   594: aload_0
    //   595: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   598: ldc_w 2169
    //   601: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   604: checkcast 72	java/lang/String
    //   607: astore 13
    //   609: aload_0
    //   610: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   613: ldc_w 2171
    //   616: invokevirtual 661	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   619: ifeq +72 -> 691
    //   622: aload_0
    //   623: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   626: ldc_w 2171
    //   629: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   632: checkcast 72	java/lang/String
    //   635: astore 14
    //   637: aload 13
    //   639: aload 11
    //   641: invokestatic 2167	aqft:equalsWithNullCheck	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   644: ifne +54 -> 698
    //   647: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   650: ifeq +13 -> 663
    //   653: ldc_w 666
    //   656: iconst_2
    //   657: ldc_w 2173
    //   660: invokestatic 1253	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   663: iconst_1
    //   664: ireturn
    //   665: aload_0
    //   666: getfield 2175	aqhv:mAppInterface	Lcom/tencent/common/app/AppInterface;
    //   669: ifnull +650 -> 1319
    //   672: aload_0
    //   673: getfield 2175	aqhv:mAppInterface	Lcom/tencent/common/app/AppInterface;
    //   676: invokevirtual 2178	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   679: astore 11
    //   681: goto -111 -> 570
    //   684: ldc 83
    //   686: astore 13
    //   688: goto -79 -> 609
    //   691: ldc 83
    //   693: astore 14
    //   695: goto -58 -> 637
    //   698: aload 15
    //   700: ldc_w 2171
    //   703: aload 14
    //   705: invokevirtual 619	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   708: pop
    //   709: aload 15
    //   711: ldc_w 2180
    //   714: iconst_m1
    //   715: invokevirtual 148	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   718: pop
    //   719: aload 15
    //   721: ldc 138
    //   723: invokevirtual 142	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   726: pop
    //   727: new 2182	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   730: dup
    //   731: aload 11
    //   733: iconst_0
    //   734: invokespecial 2184	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   737: astore 11
    //   739: iload_2
    //   740: iconst_1
    //   741: if_icmpne +29 -> 770
    //   744: aload 15
    //   746: ldc_w 2180
    //   749: bipush 12
    //   751: invokevirtual 148	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   754: pop
    //   755: aload 11
    //   757: bipush 86
    //   759: putfield 2187	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:pa	I
    //   762: aload 15
    //   764: ldc 143
    //   766: invokevirtual 142	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   769: pop
    //   770: iload_2
    //   771: iconst_2
    //   772: if_icmpne +18 -> 790
    //   775: aload 11
    //   777: bipush 87
    //   779: putfield 2187	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:pa	I
    //   782: aload 15
    //   784: ldc 143
    //   786: invokevirtual 142	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   789: pop
    //   790: iload_2
    //   791: iconst_3
    //   792: if_icmpne +18 -> 810
    //   795: aload 11
    //   797: bipush 88
    //   799: putfield 2187	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:pa	I
    //   802: aload 15
    //   804: ldc 143
    //   806: invokevirtual 142	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   809: pop
    //   810: iload_2
    //   811: bipush 7
    //   813: if_icmplt +28 -> 841
    //   816: aload 15
    //   818: ldc_w 2180
    //   821: iload_2
    //   822: invokevirtual 148	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   825: pop
    //   826: aload 11
    //   828: bipush 86
    //   830: putfield 2187	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:pa	I
    //   833: aload 15
    //   835: ldc 143
    //   837: invokevirtual 142	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   840: pop
    //   841: aload 15
    //   843: ldc_w 2189
    //   846: iload_3
    //   847: invokevirtual 148	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   850: pop
    //   851: aload 15
    //   853: ldc_w 2191
    //   856: aload 11
    //   858: invokevirtual 2194	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   861: pop
    //   862: aload 12
    //   864: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   867: ifne +79 -> 946
    //   870: aload 12
    //   872: ldc_w 2196
    //   875: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   878: ifeq +68 -> 946
    //   881: iconst_1
    //   882: istore 9
    //   884: aload 15
    //   886: ldc_w 2198
    //   889: iload 9
    //   891: invokevirtual 137	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   894: pop
    //   895: sipush 10002
    //   898: iload_2
    //   899: if_icmpne +11 -> 910
    //   902: aload 15
    //   904: ldc 143
    //   906: invokevirtual 142	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   909: pop
    //   910: aload 15
    //   912: ldc_w 2200
    //   915: lload 5
    //   917: invokevirtual 634	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   920: pop
    //   921: aload_0
    //   922: getfield 115	aqhv:context	Landroid/content/Context;
    //   925: aload 15
    //   927: invokevirtual 544	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   930: goto -378 -> 552
    //   933: aload 15
    //   935: ldc_w 2202
    //   938: iconst_1
    //   939: invokevirtual 137	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   942: pop
    //   943: goto -216 -> 727
    //   946: iconst_0
    //   947: istore 9
    //   949: goto -65 -> 884
    //   952: aload_0
    //   953: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   956: ldc_w 847
    //   959: invokevirtual 661	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   962: ifeq +42 -> 1004
    //   965: aload_0
    //   966: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   969: ldc_w 847
    //   972: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   975: checkcast 72	java/lang/String
    //   978: astore 12
    //   980: lload 5
    //   982: lconst_0
    //   983: lcmp
    //   984: ifne +27 -> 1011
    //   987: aload 12
    //   989: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   992: ifeq +19 -> 1011
    //   995: lload 7
    //   997: lconst_0
    //   998: lcmp
    //   999: ifne +12 -> 1011
    //   1002: iconst_0
    //   1003: ireturn
    //   1004: ldc 83
    //   1006: astore 12
    //   1008: goto -28 -> 980
    //   1011: aload 15
    //   1013: ldc_w 2189
    //   1016: iconst_3
    //   1017: invokevirtual 148	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1020: pop
    //   1021: aload 15
    //   1023: ldc_w 2200
    //   1026: lload 5
    //   1028: invokevirtual 634	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1031: pop
    //   1032: sipush 10002
    //   1035: iload_2
    //   1036: if_icmpne +11 -> 1047
    //   1039: aload 15
    //   1041: ldc 143
    //   1043: invokevirtual 142	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1046: pop
    //   1047: aload 15
    //   1049: ldc_w 2202
    //   1052: iconst_1
    //   1053: invokevirtual 137	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1056: pop
    //   1057: aload 15
    //   1059: ldc_w 2204
    //   1062: aload 11
    //   1064: invokevirtual 619	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1067: pop
    //   1068: new 2182	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   1071: dup
    //   1072: aload 12
    //   1074: bipush 19
    //   1076: invokespecial 2184	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   1079: astore 11
    //   1081: iload_2
    //   1082: iconst_1
    //   1083: if_icmpne +29 -> 1112
    //   1086: aload 15
    //   1088: ldc_w 2180
    //   1091: bipush 12
    //   1093: invokevirtual 148	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1096: pop
    //   1097: aload 11
    //   1099: bipush 86
    //   1101: putfield 2187	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:pa	I
    //   1104: aload 15
    //   1106: ldc 143
    //   1108: invokevirtual 142	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1111: pop
    //   1112: iload_2
    //   1113: iconst_2
    //   1114: if_icmpne +18 -> 1132
    //   1117: aload 11
    //   1119: bipush 87
    //   1121: putfield 2187	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:pa	I
    //   1124: aload 15
    //   1126: ldc 143
    //   1128: invokevirtual 142	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1131: pop
    //   1132: iload_2
    //   1133: iconst_3
    //   1134: if_icmpne +18 -> 1152
    //   1137: aload 11
    //   1139: bipush 88
    //   1141: putfield 2187	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:pa	I
    //   1144: aload 15
    //   1146: ldc 143
    //   1148: invokevirtual 142	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1151: pop
    //   1152: iload_2
    //   1153: bipush 7
    //   1155: if_icmplt +28 -> 1183
    //   1158: aload 15
    //   1160: ldc_w 2180
    //   1163: iload_2
    //   1164: invokevirtual 148	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1167: pop
    //   1168: aload 11
    //   1170: bipush 86
    //   1172: putfield 2187	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:pa	I
    //   1175: aload 15
    //   1177: ldc 143
    //   1179: invokevirtual 142	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1182: pop
    //   1183: aload 15
    //   1185: ldc_w 2191
    //   1188: aload 11
    //   1190: invokevirtual 2194	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   1193: pop
    //   1194: aload_0
    //   1195: getfield 115	aqhv:context	Landroid/content/Context;
    //   1198: aload 15
    //   1200: invokevirtual 544	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1203: goto -651 -> 552
    //   1206: ldc 83
    //   1208: astore 11
    //   1210: aload_0
    //   1211: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1214: ifnull +86 -> 1300
    //   1217: aload_0
    //   1218: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1221: invokevirtual 413	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   1224: astore 11
    //   1226: new 2182	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   1229: dup
    //   1230: aload 11
    //   1232: iconst_0
    //   1233: invokespecial 2184	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   1236: astore 11
    //   1238: aload 15
    //   1240: ldc_w 2202
    //   1243: iconst_1
    //   1244: invokevirtual 137	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1247: pop
    //   1248: aload 15
    //   1250: ldc_w 2189
    //   1253: iload_3
    //   1254: invokevirtual 148	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1257: pop
    //   1258: aload 15
    //   1260: ldc_w 2191
    //   1263: aload 11
    //   1265: invokevirtual 2194	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   1268: pop
    //   1269: aload 15
    //   1271: ldc 143
    //   1273: invokevirtual 142	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1276: pop
    //   1277: aload 15
    //   1279: ldc_w 2200
    //   1282: lload 5
    //   1284: invokevirtual 634	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1287: pop
    //   1288: aload_0
    //   1289: getfield 115	aqhv:context	Landroid/content/Context;
    //   1292: aload 15
    //   1294: invokevirtual 544	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1297: goto -745 -> 552
    //   1300: aload_0
    //   1301: getfield 2175	aqhv:mAppInterface	Lcom/tencent/common/app/AppInterface;
    //   1304: ifnull -78 -> 1226
    //   1307: aload_0
    //   1308: getfield 2175	aqhv:mAppInterface	Lcom/tencent/common/app/AppInterface;
    //   1311: invokevirtual 2178	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1314: astore 11
    //   1316: goto -90 -> 1226
    //   1319: ldc 83
    //   1321: astore 11
    //   1323: goto -753 -> 570
    //   1326: iconst_0
    //   1327: istore 9
    //   1329: goto -1235 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1332	0	this	aqhv
    //   164	352	1	i	int
    //   241	923	2	j	int
    //   278	976	3	k	int
    //   315	168	4	m	int
    //   57	1226	5	l1	long
    //   96	900	7	l2	long
    //   92	1236	9	bool1	boolean
    //   198	3	10	bool2	boolean
    //   54	1268	11	localObject	Object
    //   26	1047	12	str1	String
    //   191	117	13	str2	String
    //   353	1	13	localException1	Exception
    //   372	1	13	localException2	Exception
    //   391	6	13	str3	String
    //   409	1	13	localException3	Exception
    //   419	1	13	str4	String
    //   424	1	13	localException4	Exception
    //   433	1	13	str5	String
    //   438	1	13	localException5	Exception
    //   448	1	13	str6	String
    //   453	1	13	localException6	Exception
    //   607	80	13	str7	String
    //   635	69	14	str8	String
    //   475	818	15	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   111	132	353	java/lang/Exception
    //   145	165	372	java/lang/Exception
    //   165	193	409	java/lang/Exception
    //   193	200	409	java/lang/Exception
    //   396	406	409	java/lang/Exception
    //   208	236	424	java/lang/Exception
    //   236	242	424	java/lang/Exception
    //   242	270	438	java/lang/Exception
    //   270	279	438	java/lang/Exception
    //   279	307	453	java/lang/Exception
    //   307	317	453	java/lang/Exception
  }
  
  private boolean aDQ()
  {
    Object localObject1 = (String)this.attrs.get("uin");
    Object localObject2 = (String)this.attrs.get("account_flag");
    int i = -1;
    try
    {
      int j = Integer.parseInt((String)localObject2);
      i = j;
    }
    catch (Exception localException)
    {
      label39:
      break label39;
    }
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoShowPublicAccountCard uin: " + (String)localObject1 + " | accountFlag: " + i + " | current uin: " + this.app.getCurrentAccountUin());
    }
    if ((localObject1 == null) || ("".equals(localObject1)) || (this.app.getCurrentAccountUin().equals(localObject1))) {
      return false;
    }
    if (((String)localObject1).length() < 5) {
      return false;
    }
    if (aDO())
    {
      if ((this.context instanceof Activity))
      {
        localObject1 = new ProfileParams.a();
        ((ProfileParams.a)localObject1).a(new ProfileParams.CurLoginUsr((String)this.attrs.get("open_id"), (String)this.attrs.get("share_uin"))).d((String)this.attrs.get("app_name")).c((String)this.attrs.get("share_id")).a((String)this.attrs.get("uin")).a(i).b((String)this.attrs.get("src_type"));
        ocp.a((Activity)this.context, this.app, ((ProfileParams.a)localObject1).a());
        return false;
      }
    }
    else
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("source", 117);
      ocp.a((Intent)localObject2, this.app, this.context, (String)localObject1, i);
      PublicAccountHandler.a(this.app, (String)localObject1, "Pb_account_lifeservice", "mp_msg_sys_5", "addpage_hot");
    }
    return true;
  }
  
  private boolean aDR()
  {
    String str = (String)this.attrs.get("uin");
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoShowCrmCard uin: " + str + " | current uin: " + this.app.getCurrentAccountUin());
    }
    if ((str == null) || ("".equals(str)) || (this.app.getCurrentAccountUin().equals(str))) {
      return false;
    }
    if (str.length() < 5) {
      return false;
    }
    ocp.a(null, this.app, this.context, str, -7);
    return true;
  }
  
  private boolean aDS()
  {
    try
    {
      str1 = (String)this.attrs.get("uin");
      long l = Long.parseLong(str1);
      if (l < 10000L)
      {
        if (!QLog.isColorLevel()) {
          break label302;
        }
        QLog.i("JumpAction", 2, String.format(Locale.getDefault(), "gotoAllPeopleVoteCard invalid uin uin: %d", new Object[] { Long.valueOf(l) }));
        return false;
      }
      str2 = (String)this.attrs.get("name");
      str3 = (String)this.attrs.get("source");
      localFriends = ((acff)this.app.getManager(51)).e(str1);
      if (!aqft.equalsWithNullCheck(str1, this.app.getCurrentAccountUin())) {
        break label236;
      }
      localAllInOne1 = new ProfileActivity.AllInOne(str1, 0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        String str2;
        String str3;
        Friends localFriends;
        ProfileActivity.AllInOne localAllInOne1;
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("JumpAction", 2, String.format(Locale.getDefault(), "gotoAllPeopleVoteCard exception : %s", new Object[] { localException.toString() }));
        return false;
        label236:
        ProfileActivity.AllInOne localAllInOne2;
        if ((localFriends != null) && (localFriends.isFriend()))
        {
          localAllInOne2 = new ProfileActivity.AllInOne(str1, 1);
          localAllInOne2.nickname = localFriends.name;
          localAllInOne2.remark = localFriends.remark;
        }
        else
        {
          localAllInOne2 = new ProfileActivity.AllInOne(str1, 95);
          localAllInOne2.nickname = str2;
        }
      }
    }
    ProfileActivity.b(this.context, localAllInOne1);
    if (QLog.isDevelopLevel())
    {
      QLog.i("JumpAction", 4, String.format(Locale.getDefault(), "gotoAllPeopleVoteCard uin: %s  name: %s source: %s", new Object[] { aqft.pl(str1), aqft.pl(str2), str3 }));
      return false;
    }
    label302:
    return false;
  }
  
  private boolean aDT()
  {
    Object localObject1 = (String)this.attrs.get("uin");
    if (Boolean.parseBoolean((String)this.attrs.get("jump_add_friend"))) {
      return ru((String)localObject1);
    }
    Object localObject2 = (String)this.attrs.get("wpa");
    Object localObject3 = (String)this.attrs.get("src_type");
    boolean bool1 = "1".equals(this.attrs.get("track_back"));
    boolean bool2 = "1".equals(this.attrs.get("singleTop"));
    boolean bool3 = "1".equals(this.attrs.get("group_video_open"));
    if ("internal_phone".equals(localObject3))
    {
      anot.a(this.app, "CliOper", "", "", "0X8007014", "0X8007014", 0, 0, "", "", "", "");
      localObject1 = new ProfileActivity.AllInOne((String)localObject1, 53);
      ((ProfileActivity.AllInOne)localObject1).contactName = URLDecoder.decode((String)this.attrs.get("nickname"));
      ((ProfileActivity.AllInOne)localObject1).bJa = 105;
      localObject2 = new Bundle();
      localObject3 = (String)this.attrs.get("from_type");
      if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!isNumeric((String)localObject3))) {
        break label720;
      }
    }
    label720:
    for (int i = Integer.valueOf((String)localObject3).intValue();; i = 0)
    {
      if ((i > 0) && (this.attrs.containsKey("msg_uniseq")))
      {
        localObject3 = (String)this.attrs.get("msg_uniseq");
        if ((i == 100) && (aqft.rj((String)localObject3)))
        {
          ((Bundle)localObject2).putBoolean("from_babyq", true);
          anot.a(this.app, "dc00898", "", "", "0X8007241", "0X8007241", 0, 0, "", "", "", "");
        }
      }
      if (this.attrs.containsKey("colorScreen")) {
        ((ProfileActivity.AllInOne)localObject1).bIY = Integer.parseInt((String)this.attrs.get("colorScreen"));
      }
      ((Bundle)localObject2).putBoolean("key_need_track_back", bool1);
      ((Bundle)localObject2).putBoolean("single_top", bool2);
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, String.format("gotoShowPSLCard [%d %b %b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      ProfileActivity.a(this.context, (ProfileActivity.AllInOne)localObject1, (Bundle)localObject2);
      return true;
      if ((localObject1 == null) || ("".equals(localObject1)) || (this.app.getCurrentAccountUin().equals(localObject1)))
      {
        localObject1 = new ProfileActivity.AllInOne(this.app.getCurrentAccountUin(), 0);
        break;
      }
      if (((String)localObject1).length() < 5) {
        return false;
      }
      localObject3 = ((acff)this.app.getManager(51)).e((String)localObject1);
      if ((localObject3 != null) && (((Friends)localObject3).isFriend()))
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 1);
        ((ProfileActivity.AllInOne)localObject1).nickname = ((Friends)localObject3).name;
        ((ProfileActivity.AllInOne)localObject1).remark = ((Friends)localObject3).remark;
        break;
      }
      if (this.cUb)
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 3);
        if ("1".equals(localObject2)) {}
        for (i = 1;; i = 0)
        {
          ((ProfileActivity.AllInOne)localObject1).bIW = i;
          ((ProfileActivity.AllInOne)localObject1).subSourceId = 11;
          break;
        }
      }
      if (bool3)
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 116);
        break;
      }
      localObject1 = new ProfileActivity.AllInOne((String)localObject1, 78);
      localObject2 = (String)this.attrs.get("referee");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("flc_recommend_uin", (String)localObject2);
        ((ProfileActivity.AllInOne)localObject1).data.putBundle("flc_extra_param", (Bundle)localObject3);
      }
      break;
    }
  }
  
  private boolean aDU()
  {
    boolean bool = false;
    int j = 0;
    String str = (String)this.attrs.get("uin");
    int i = j;
    if (str != null)
    {
      i = j;
      if (!"".equals(str))
      {
        if (!this.app.getCurrentAccountUin().equals(str)) {
          break label180;
        }
        i = j;
      }
    }
    for (;;)
    {
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(str, i);
      Intent localIntent = new Intent(this.context, PersonalityLabelGalleryActivity.class);
      localIntent.putExtra("personality_label_allinone", localAllInOne);
      localIntent.putExtra("fromType", 1);
      localIntent.putExtra("uin", str);
      if (!(this.context instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      this.context.startActivity(localIntent);
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoShowPersonalityLabel. uin:" + str);
      }
      bool = true;
      label180:
      do
      {
        return bool;
      } while (str.length() < 5);
      if (((acff)this.app.getManager(51)).isFriend(str)) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  private boolean aDV()
  {
    String str = (String)this.attrs.get("uin");
    if ((str == null) || ("".equals(str)) || (str.length() < 5)) {
      return false;
    }
    Object localObject1;
    if ((this.context instanceof Activity))
    {
      localObject1 = (TroopManager)this.app.getManager(52);
      if (localObject1 == null) {
        break label272;
      }
      localObject1 = ((TroopManager)localObject1).b(str);
      if ((localObject1 == null) || (!((TroopInfo)localObject1).isAdmin())) {
        break label272;
      }
    }
    label272:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("JumpAction", 2, "gotoGroupSearchSetting not admin " + str);
        }
        return false;
      }
      Object localObject2 = TroopInfoActivity.c(str, 3);
      localObject1 = new Intent();
      ((Intent)localObject1).putExtras((Bundle)localObject2);
      localObject2 = new awjk(this.app);
      PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
      if (localPluginCommunicationHandler != null) {
        localPluginCommunicationHandler.register((RemoteCommand)localObject2);
      }
      localObject2 = TroopBaseProxyActivity.a((Activity)this.context);
      TroopManageProxyActivity.a("troop_manage_plugin.apk", PluginInfo.cKH, TroopManageProxyActivity.class, (Activity)this.context, (Intent)localObject1, (Dialog)localObject2, "com.tencent.mobileqq.activity.TroopSearchWayActivity", this.app.getCurrentAccountUin(), -1);
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoGroupSearchSetting " + str);
      }
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoGroupSearchSetting context not activity");
      }
      return false;
    }
  }
  
  private boolean aDW()
  {
    String str = (String)this.attrs.get("uin");
    if ((str == null) || ("".equals(str)) || (str.length() < 5)) {
      return false;
    }
    Object localObject1;
    if ((this.context instanceof Activity))
    {
      localObject1 = (TroopManager)this.app.getManager(52);
      if (localObject1 == null) {
        break label309;
      }
      localObject1 = ((TroopManager)localObject1).b(str);
      if ((localObject1 == null) || (!((TroopInfo)localObject1).isAdmin())) {
        break label309;
      }
    }
    label309:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("JumpAction", 2, "gotoGroupManager not admin " + str);
        }
        return false;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("uin", this.app.getCurrentAccountUin());
      ((Intent)localObject1).putExtra("troop_uin", str);
      ((Intent)localObject1).putExtra("key_is_update_before_805", apuh.ai(this.context, "8.0.5"));
      ((Intent)localObject1).putExtra("key_is_need_update_Group_info", true);
      Object localObject2 = new awjk(this.app);
      PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
      if (localPluginCommunicationHandler != null) {
        localPluginCommunicationHandler.register((RemoteCommand)localObject2);
      }
      localObject2 = TroopBaseProxyActivity.a((Activity)this.context);
      TroopManageProxyActivity.a("troop_manage_plugin.apk", PluginInfo.cKH, TroopManageProxyActivity.class, (Activity)this.context, (Intent)localObject1, (Dialog)localObject2, "com.tencent.mobileqq.activity.TroopManageActivity", this.app.getCurrentAccountUin(), -1);
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoGroupManager " + str);
      }
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoGroupManager context not activity");
      }
      return false;
    }
  }
  
  private boolean aDX()
  {
    boolean bool2 = false;
    String str2 = (String)this.attrs.get("uin");
    str1 = (String)this.attrs.get("wSourceSubID");
    if (this.attrs.containsKey("isPrivate")) {}
    do
    {
      do
      {
        do
        {
          try
          {
            if (Integer.valueOf((String)this.attrs.get("isPrivate")).intValue() == 1)
            {
              this.app.addObserver(this.jdField_b_of_type_Ashx);
              ((ashy)this.app.getBusinessHandler(85)).XW(str2);
              bool1 = true;
              return bool1;
            }
          }
          catch (Exception localException1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("JumpAction", 2, new Object[] { "gotoShowGroupCard throw Exception ", localException1.toString() });
            }
          }
          bool1 = bool2;
        } while (str2 == null);
        bool1 = bool2;
      } while ("".equals(str2));
      boolean bool1 = bool2;
    } while (str2.length() < 5);
    Object localObject1;
    if ("QRJumpActivity".equalsIgnoreCase((String)this.attrs.get("jump_from"))) {
      localObject1 = TroopInfoActivity.c(str2, 14);
    }
    for (;;)
    {
      if ("d2g".equals(this.attrs.get("jump_from")))
      {
        localObject1 = TroopInfoActivity.c(str2, 16);
        ((Bundle)localObject1).putInt("D2GType", 2);
      }
      Object localObject3 = localObject1;
      localObject1 = localObject3;
      if (!TextUtils.isEmpty((CharSequence)this.attrs.get("jump_from_group_search"))) {}
      try
      {
        localObject1 = TroopInfoActivity.c(str2, Integer.parseInt((String)this.attrs.get("jump_from_group_search")));
        if ("h5".equalsIgnoreCase((String)this.attrs.get("jump_from"))) {
          localObject1 = TroopInfoActivity.c(str2, 22);
        }
        try
        {
          j = Integer.parseInt(str1);
          i = j;
          if (j == 43) {
            i = 10002;
          }
          localObject3 = (String)this.attrs.get("sourceext");
          str2 = (String)this.attrs.get("isexactsearch");
          if ((localObject3 == null) || (str2 == null) || (((String)localObject3).isEmpty()) || (str2.isEmpty())) {
            break label1032;
          }
          k = Integer.parseInt((String)localObject3);
          if (Integer.parseInt(str2) != 1) {
            break label758;
          }
          j = 1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            int j;
            int i;
            int k;
            Object localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("JumpAction", 2, "cast source sub id from web error, sourceSubId = " + str1);
              continue;
              if (i == 37)
              {
                ((Bundle)localObject2).putInt("troop_info_from", 30);
              }
              else if (i == 10008)
              {
                ((Bundle)localObject2).putInt("troop_info_from", 102);
              }
              else if (i == 10013)
              {
                ((Bundle)localObject2).putInt("troop_info_from", 106);
              }
              else if ((i >= 30006) && (i <= 30020))
              {
                ((Bundle)localObject2).putInt("troop_info_from", i);
                continue;
                switch (k)
                {
                }
              }
            }
          }
        }
        ((Bundle)localObject1).putInt("troop_info_from_ex", i);
        if (i == 33)
        {
          ((Bundle)localObject1).putInt("troop_info_from", 24);
          if ((this.attrs.containsKey("from_type")) && (!TextUtils.isEmpty((CharSequence)this.attrs.get("from_type"))) && (Integer.parseInt((String)this.attrs.get("from_type")) == 100))
          {
            ((Bundle)localObject1).putBoolean("from_babyq", true);
            anot.a(this.app, "dc00898", "", "", "0X8007245", "0X8007245", 0, 0, "", "", "", "");
          }
          ((Bundle)localObject1).putString("authKey", (String)this.attrs.get("authKey"));
          ((Bundle)localObject1).putString("authSig", (String)this.attrs.get("authSig"));
          if (QLog.isColorLevel()) {
            QLog.i("JumpAction", 2, String.format("gotoShowGroupCard troop_authSig=%s", new Object[] { this.attrs.get("authSig") }));
          }
          if (this.attrs.containsKey("appid")) {
            ((Bundle)localObject1).putString("appid", (String)this.attrs.get("appid"));
          }
          if (this.attrs.containsKey("openid")) {
            ((Bundle)localObject1).putString("openid", (String)this.attrs.get("openid"));
          }
          apuh.a(this.context, (Bundle)localObject1, 2);
          return true;
          localObject1 = TroopInfoActivity.c(str2, 5);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
          localObject2 = localObject3;
          continue;
          if ("groupprofile".equalsIgnoreCase((String)this.attrs.get("jump_from")))
          {
            localObject2 = TroopInfoActivity.c(str2, 22);
            ((Bundle)localObject2).putBoolean("troop_info_from_troopsetting", true);
          }
          continue;
          label758:
          j = 0;
          break label996;
          if (j != 0)
          {
            i = 30004;
          }
          else
          {
            i = 30006;
            continue;
            if (j != 0)
            {
              i = 30004;
            }
            else
            {
              i = 30008;
              continue;
              if (j != 0)
              {
                i = 30010;
              }
              else
              {
                i = 30012;
                continue;
                if (j != 0)
                {
                  i = 30014;
                }
                else
                {
                  i = 30016;
                  continue;
                  if (j != 0)
                  {
                    i = 30018;
                  }
                  else
                  {
                    i = 30020;
                    continue;
                    if (i != 43) {
                      break;
                    }
                    ((Bundle)localObject2).putInt("troop_info_from", 27);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  /* Error */
  private boolean aDY()
  {
    // Byte code:
    //   0: ldc 83
    //   2: astore 14
    //   4: ldc 83
    //   6: astore 19
    //   8: ldc 83
    //   10: astore 17
    //   12: ldc 83
    //   14: astore 10
    //   16: ldc 83
    //   18: astore 18
    //   20: aload_0
    //   21: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   24: ldc 169
    //   26: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   29: checkcast 72	java/lang/String
    //   32: astore_3
    //   33: aload_0
    //   34: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   37: ldc_w 2507
    //   40: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: checkcast 72	java/lang/String
    //   46: astore_1
    //   47: aload_0
    //   48: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   51: ldc_w 847
    //   54: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   57: checkcast 72	java/lang/String
    //   60: astore_2
    //   61: aload_0
    //   62: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   65: ldc_w 2509
    //   68: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   71: checkcast 72	java/lang/String
    //   74: astore 4
    //   76: aload 18
    //   78: astore 12
    //   80: aload 10
    //   82: astore 7
    //   84: aload 17
    //   86: astore 5
    //   88: aload 19
    //   90: astore 15
    //   92: aload 14
    //   94: astore 11
    //   96: aload 18
    //   98: astore 13
    //   100: aload 10
    //   102: astore 8
    //   104: aload 17
    //   106: astore 6
    //   108: aload 19
    //   110: astore 16
    //   112: aload_0
    //   113: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   116: ldc_w 2511
    //   119: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   122: checkcast 72	java/lang/String
    //   125: ldc_w 2513
    //   128: invokestatic 2516	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   131: astore 9
    //   133: aload 18
    //   135: astore 12
    //   137: aload 10
    //   139: astore 7
    //   141: aload 17
    //   143: astore 5
    //   145: aload 19
    //   147: astore 15
    //   149: aload 9
    //   151: astore 11
    //   153: aload 18
    //   155: astore 13
    //   157: aload 10
    //   159: astore 8
    //   161: aload 17
    //   163: astore 6
    //   165: aload 19
    //   167: astore 16
    //   169: aload 9
    //   171: astore 14
    //   173: aload_0
    //   174: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   177: ldc_w 2518
    //   180: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   183: checkcast 72	java/lang/String
    //   186: ldc_w 2513
    //   189: invokestatic 2516	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   192: astore 19
    //   194: aload 18
    //   196: astore 12
    //   198: aload 10
    //   200: astore 7
    //   202: aload 17
    //   204: astore 5
    //   206: aload 19
    //   208: astore 15
    //   210: aload 9
    //   212: astore 11
    //   214: aload 18
    //   216: astore 13
    //   218: aload 10
    //   220: astore 8
    //   222: aload 17
    //   224: astore 6
    //   226: aload 19
    //   228: astore 16
    //   230: aload 9
    //   232: astore 14
    //   234: aload_0
    //   235: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   238: ldc_w 2520
    //   241: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   244: checkcast 72	java/lang/String
    //   247: ldc_w 2513
    //   250: invokestatic 2516	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   253: astore 17
    //   255: aload 18
    //   257: astore 12
    //   259: aload 10
    //   261: astore 7
    //   263: aload 17
    //   265: astore 5
    //   267: aload 19
    //   269: astore 15
    //   271: aload 9
    //   273: astore 11
    //   275: aload 18
    //   277: astore 13
    //   279: aload 10
    //   281: astore 8
    //   283: aload 17
    //   285: astore 6
    //   287: aload 19
    //   289: astore 16
    //   291: aload 9
    //   293: astore 14
    //   295: aload_0
    //   296: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   299: ldc_w 2522
    //   302: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   305: checkcast 72	java/lang/String
    //   308: ldc_w 2513
    //   311: invokestatic 2516	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   314: astore 10
    //   316: aload 18
    //   318: astore 12
    //   320: aload 10
    //   322: astore 7
    //   324: aload 17
    //   326: astore 5
    //   328: aload 19
    //   330: astore 15
    //   332: aload 9
    //   334: astore 11
    //   336: aload 18
    //   338: astore 13
    //   340: aload 10
    //   342: astore 8
    //   344: aload 17
    //   346: astore 6
    //   348: aload 19
    //   350: astore 16
    //   352: aload 9
    //   354: astore 14
    //   356: aload_0
    //   357: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   360: ldc_w 2524
    //   363: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   366: checkcast 72	java/lang/String
    //   369: ldc_w 2513
    //   372: invokestatic 2516	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   375: astore 18
    //   377: aload 18
    //   379: astore 12
    //   381: aload 10
    //   383: astore 7
    //   385: aload 17
    //   387: astore 5
    //   389: aload 19
    //   391: astore 15
    //   393: aload 9
    //   395: astore 11
    //   397: aload 18
    //   399: astore 13
    //   401: aload 10
    //   403: astore 8
    //   405: aload 17
    //   407: astore 6
    //   409: aload 19
    //   411: astore 16
    //   413: aload 9
    //   415: astore 14
    //   417: aload_0
    //   418: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   421: ldc_w 2526
    //   424: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   427: checkcast 72	java/lang/String
    //   430: ldc_w 2513
    //   433: invokestatic 2516	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   436: astore 20
    //   438: aload_1
    //   439: astore 7
    //   441: aload 20
    //   443: astore_1
    //   444: aload 17
    //   446: astore 8
    //   448: aload_2
    //   449: astore 6
    //   451: aload 18
    //   453: astore_2
    //   454: aload 10
    //   456: astore 5
    //   458: aload 9
    //   460: astore 11
    //   462: aload 19
    //   464: astore 9
    //   466: aload_3
    //   467: astore 10
    //   469: aload 6
    //   471: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   474: ifne +11 -> 485
    //   477: aload 7
    //   479: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   482: ifeq +129 -> 611
    //   485: iconst_0
    //   486: ireturn
    //   487: astore 9
    //   489: ldc 83
    //   491: astore 10
    //   493: ldc 83
    //   495: astore_1
    //   496: ldc 83
    //   498: astore_3
    //   499: ldc 83
    //   501: astore 6
    //   503: ldc 83
    //   505: astore 5
    //   507: ldc 83
    //   509: astore 4
    //   511: ldc 83
    //   513: astore 8
    //   515: ldc 83
    //   517: astore 7
    //   519: ldc 83
    //   521: astore_2
    //   522: aload 9
    //   524: invokevirtual 2527	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   527: aload 8
    //   529: astore 9
    //   531: aload 5
    //   533: astore 8
    //   535: aload_2
    //   536: astore 5
    //   538: aload_1
    //   539: astore_2
    //   540: ldc 83
    //   542: astore_1
    //   543: aload_3
    //   544: astore 11
    //   546: goto -77 -> 469
    //   549: astore 9
    //   551: ldc 83
    //   553: astore 10
    //   555: ldc 83
    //   557: astore_1
    //   558: ldc 83
    //   560: astore_3
    //   561: ldc 83
    //   563: astore 6
    //   565: ldc 83
    //   567: astore 5
    //   569: ldc 83
    //   571: astore 4
    //   573: ldc 83
    //   575: astore 8
    //   577: ldc 83
    //   579: astore 7
    //   581: ldc 83
    //   583: astore_2
    //   584: aload 9
    //   586: invokevirtual 2528	java/lang/NullPointerException:printStackTrace	()V
    //   589: aload 8
    //   591: astore 9
    //   593: aload 5
    //   595: astore 8
    //   597: aload_2
    //   598: astore 5
    //   600: aload_1
    //   601: astore_2
    //   602: ldc 83
    //   604: astore_1
    //   605: aload_3
    //   606: astore 11
    //   608: goto -139 -> 469
    //   611: aload_0
    //   612: getfield 115	aqhv:context	Landroid/content/Context;
    //   615: ifnull +171 -> 786
    //   618: new 126	android/content/Intent
    //   621: dup
    //   622: aload_0
    //   623: getfield 115	aqhv:context	Landroid/content/Context;
    //   626: ldc_w 2530
    //   629: invokespecial 131	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   632: astore_3
    //   633: aload_3
    //   634: ldc_w 2532
    //   637: aload 7
    //   639: invokevirtual 619	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   642: pop
    //   643: aload_3
    //   644: ldc_w 2534
    //   647: new 152	java/lang/StringBuilder
    //   650: dup
    //   651: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   654: ldc 83
    //   656: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: aload 6
    //   661: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   667: invokevirtual 619	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   670: pop
    //   671: ldc_w 571
    //   674: aload 10
    //   676: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   679: ifeq +139 -> 818
    //   682: aload_3
    //   683: ldc_w 2536
    //   686: iconst_0
    //   687: invokevirtual 148	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   690: pop
    //   691: new 339	android/os/Bundle
    //   694: dup
    //   695: invokespecial 340	android/os/Bundle:<init>	()V
    //   698: astore 6
    //   700: aload 6
    //   702: ldc_w 2507
    //   705: aload 4
    //   707: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   710: aload 6
    //   712: ldc_w 2511
    //   715: aload 11
    //   717: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   720: aload 6
    //   722: ldc_w 2518
    //   725: aload 9
    //   727: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   730: aload 6
    //   732: ldc_w 2520
    //   735: aload 8
    //   737: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   740: aload 6
    //   742: ldc_w 2522
    //   745: aload 5
    //   747: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   750: aload 6
    //   752: ldc_w 2524
    //   755: aload_2
    //   756: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   759: aload 6
    //   761: ldc_w 2526
    //   764: aload_1
    //   765: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   768: aload_3
    //   769: ldc_w 1636
    //   772: aload 6
    //   774: invokevirtual 2539	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    //   777: pop
    //   778: aload_0
    //   779: getfield 115	aqhv:context	Landroid/content/Context;
    //   782: aload_3
    //   783: invokevirtual 544	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   786: aload_0
    //   787: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   790: ldc_w 560
    //   793: ldc 83
    //   795: ldc 83
    //   797: ldc_w 2541
    //   800: ldc_w 2541
    //   803: iconst_0
    //   804: iconst_0
    //   805: ldc 83
    //   807: ldc 83
    //   809: ldc 83
    //   811: ldc 83
    //   813: invokestatic 569	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   816: iconst_1
    //   817: ireturn
    //   818: aload_3
    //   819: ldc_w 2536
    //   822: bipush 6
    //   824: invokevirtual 148	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   827: pop
    //   828: goto -137 -> 691
    //   831: astore 9
    //   833: ldc 83
    //   835: astore_1
    //   836: ldc 83
    //   838: astore 4
    //   840: ldc 83
    //   842: astore 6
    //   844: ldc 83
    //   846: astore 5
    //   848: ldc 83
    //   850: astore 11
    //   852: ldc 83
    //   854: astore 8
    //   856: ldc 83
    //   858: astore 7
    //   860: ldc 83
    //   862: astore_2
    //   863: aload_3
    //   864: astore 10
    //   866: aload 4
    //   868: astore_3
    //   869: aload 11
    //   871: astore 4
    //   873: goto -289 -> 584
    //   876: astore 9
    //   878: ldc 83
    //   880: astore_2
    //   881: ldc 83
    //   883: astore 4
    //   885: ldc 83
    //   887: astore 8
    //   889: aload_1
    //   890: astore 7
    //   892: ldc 83
    //   894: astore_1
    //   895: ldc 83
    //   897: astore 11
    //   899: ldc 83
    //   901: astore 5
    //   903: ldc 83
    //   905: astore 6
    //   907: aload_3
    //   908: astore 10
    //   910: aload 11
    //   912: astore_3
    //   913: goto -329 -> 584
    //   916: astore 9
    //   918: ldc 83
    //   920: astore 5
    //   922: aload_2
    //   923: astore 6
    //   925: ldc 83
    //   927: astore_2
    //   928: ldc 83
    //   930: astore 4
    //   932: ldc 83
    //   934: astore 8
    //   936: aload_1
    //   937: astore 7
    //   939: ldc 83
    //   941: astore_1
    //   942: ldc 83
    //   944: astore 11
    //   946: aload_3
    //   947: astore 10
    //   949: aload 11
    //   951: astore_3
    //   952: goto -368 -> 584
    //   955: astore 10
    //   957: aload 15
    //   959: astore 8
    //   961: aload_1
    //   962: astore 9
    //   964: aload 12
    //   966: astore_1
    //   967: aload 11
    //   969: astore 6
    //   971: aload 10
    //   973: astore 11
    //   975: aload_2
    //   976: astore 12
    //   978: aload 7
    //   980: astore_2
    //   981: aload_3
    //   982: astore 10
    //   984: aload 6
    //   986: astore_3
    //   987: aload 12
    //   989: astore 6
    //   991: aload 9
    //   993: astore 7
    //   995: aload 11
    //   997: astore 9
    //   999: goto -415 -> 584
    //   1002: astore 9
    //   1004: ldc 83
    //   1006: astore_1
    //   1007: ldc 83
    //   1009: astore 4
    //   1011: ldc 83
    //   1013: astore 6
    //   1015: ldc 83
    //   1017: astore 5
    //   1019: ldc 83
    //   1021: astore 11
    //   1023: ldc 83
    //   1025: astore 8
    //   1027: ldc 83
    //   1029: astore 7
    //   1031: ldc 83
    //   1033: astore_2
    //   1034: aload_3
    //   1035: astore 10
    //   1037: aload 4
    //   1039: astore_3
    //   1040: aload 11
    //   1042: astore 4
    //   1044: goto -522 -> 522
    //   1047: astore 9
    //   1049: ldc 83
    //   1051: astore_2
    //   1052: ldc 83
    //   1054: astore 4
    //   1056: ldc 83
    //   1058: astore 8
    //   1060: aload_1
    //   1061: astore 7
    //   1063: ldc 83
    //   1065: astore_1
    //   1066: ldc 83
    //   1068: astore 11
    //   1070: ldc 83
    //   1072: astore 5
    //   1074: ldc 83
    //   1076: astore 6
    //   1078: aload_3
    //   1079: astore 10
    //   1081: aload 11
    //   1083: astore_3
    //   1084: goto -562 -> 522
    //   1087: astore 9
    //   1089: ldc 83
    //   1091: astore 5
    //   1093: aload_2
    //   1094: astore 6
    //   1096: ldc 83
    //   1098: astore_2
    //   1099: ldc 83
    //   1101: astore 4
    //   1103: ldc 83
    //   1105: astore 8
    //   1107: aload_1
    //   1108: astore 7
    //   1110: ldc 83
    //   1112: astore_1
    //   1113: ldc 83
    //   1115: astore 11
    //   1117: aload_3
    //   1118: astore 10
    //   1120: aload 11
    //   1122: astore_3
    //   1123: goto -601 -> 522
    //   1126: astore 9
    //   1128: aload_1
    //   1129: astore 7
    //   1131: aload 13
    //   1133: astore_1
    //   1134: aload_2
    //   1135: astore 11
    //   1137: aload 8
    //   1139: astore_2
    //   1140: aload 6
    //   1142: astore 5
    //   1144: aload_3
    //   1145: astore 10
    //   1147: aload 16
    //   1149: astore 8
    //   1151: aload 14
    //   1153: astore_3
    //   1154: aload 11
    //   1156: astore 6
    //   1158: goto -636 -> 522
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1161	0	this	aqhv
    //   46	1088	1	localObject1	Object
    //   60	1080	2	localObject2	Object
    //   32	1122	3	localObject3	Object
    //   74	1028	4	localObject4	Object
    //   86	1057	5	localObject5	Object
    //   106	1051	6	localObject6	Object
    //   82	1048	7	localObject7	Object
    //   102	1048	8	localObject8	Object
    //   131	334	9	str1	String
    //   487	36	9	localUnsupportedEncodingException1	UnsupportedEncodingException
    //   529	1	9	localObject9	Object
    //   549	36	9	localNullPointerException1	java.lang.NullPointerException
    //   591	135	9	localObject10	Object
    //   831	1	9	localNullPointerException2	java.lang.NullPointerException
    //   876	1	9	localNullPointerException3	java.lang.NullPointerException
    //   916	1	9	localNullPointerException4	java.lang.NullPointerException
    //   962	36	9	localObject11	Object
    //   1002	1	9	localUnsupportedEncodingException2	UnsupportedEncodingException
    //   1047	1	9	localUnsupportedEncodingException3	UnsupportedEncodingException
    //   1087	1	9	localUnsupportedEncodingException4	UnsupportedEncodingException
    //   1126	1	9	localUnsupportedEncodingException5	UnsupportedEncodingException
    //   14	934	10	localObject12	Object
    //   955	17	10	localNullPointerException5	java.lang.NullPointerException
    //   982	164	10	localObject13	Object
    //   94	1061	11	localObject14	Object
    //   78	910	12	localObject15	Object
    //   98	1034	13	str2	String
    //   2	1150	14	localObject16	Object
    //   90	868	15	str3	String
    //   110	1038	16	str4	String
    //   10	435	17	str5	String
    //   18	434	18	str6	String
    //   6	457	19	str7	String
    //   436	6	20	str8	String
    // Exception table:
    //   from	to	target	type
    //   20	33	487	java/io/UnsupportedEncodingException
    //   20	33	549	java/lang/NullPointerException
    //   33	47	831	java/lang/NullPointerException
    //   47	61	876	java/lang/NullPointerException
    //   61	76	916	java/lang/NullPointerException
    //   112	133	955	java/lang/NullPointerException
    //   173	194	955	java/lang/NullPointerException
    //   234	255	955	java/lang/NullPointerException
    //   295	316	955	java/lang/NullPointerException
    //   356	377	955	java/lang/NullPointerException
    //   417	438	955	java/lang/NullPointerException
    //   33	47	1002	java/io/UnsupportedEncodingException
    //   47	61	1047	java/io/UnsupportedEncodingException
    //   61	76	1087	java/io/UnsupportedEncodingException
    //   112	133	1126	java/io/UnsupportedEncodingException
    //   173	194	1126	java/io/UnsupportedEncodingException
    //   234	255	1126	java/io/UnsupportedEncodingException
    //   295	316	1126	java/io/UnsupportedEncodingException
    //   356	377	1126	java/io/UnsupportedEncodingException
    //   417	438	1126	java/io/UnsupportedEncodingException
  }
  
  private boolean aDZ()
  {
    String str1 = (String)this.attrs.get("troopuin");
    String str2 = (String)this.attrs.get("uin");
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
      return false;
    }
    aldj.a(this.app, this.context, str1, str2, 9, -1);
    return true;
  }
  
  private boolean aDa()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.context, SplashActivity.class);
    localIntent.setFlags(67108864);
    localIntent.putExtra("tab_index", MainFragment.bIk);
    localIntent.putExtra("fragment_id", 1);
    String str = (String)this.attrs.get("from");
    localIntent.putExtra("from", str);
    this.context.startActivity(localIntent);
    if ("10003".equals(str)) {
      anot.a(this.app, "dc01440", "", "", "0X80077F6", "0X80077F6", 0, 0, "", "", "", "");
    }
    do
    {
      return true;
      if ("10004".equals(str))
      {
        anot.a(this.app, "dc01440", "", "", "0X80077F7", "0X80077F7", 0, 0, "", "", "", "");
        return true;
      }
    } while (!"10009".equals(str));
    QLog.i("JumpAction", 1, "jumpaction from gotoConversaton e = ");
    return true;
  }
  
  private boolean aDb()
  {
    j = 0;
    if (this.ctj == null) {}
    do
    {
      return true;
      int i = MainFragment.bIj;
      Object localObject;
      if (this.ctj.equals("open_conversation"))
      {
        i = MainFragment.bIk;
        localObject = (String)this.attrs.get("third_open_conversation_sceneid");
      }
      try
      {
        long l = Long.parseLong((String)localObject);
        anot.a(this.app, "dc00898", "", "", "0X800A5AF", "0X800A5AF", 0, 0, l + "", "", "", "");
        j = 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("JumpAction", 1, "sceneid must be a numeric string");
          j = 1;
        }
      }
    } while (j == 0);
    localObject = new Intent();
    ((Intent)localObject).setClass(this.context, SplashActivity.class);
    ((Intent)localObject).setFlags(67108864);
    ((Intent)localObject).putExtra("tab_index", i);
    ((Intent)localObject).putExtra("fragment_id", j);
    this.context.startActivity((Intent)localObject);
    return true;
  }
  
  private boolean aDc()
  {
    j = 0;
    if (this.ctj == null) {}
    do
    {
      return true;
      int i = MainFragment.bIj;
      Object localObject;
      if (this.ctj.equals("forward_msg_list"))
      {
        i = MainFragment.bIk;
        localObject = (String)this.attrs.get("third_open_conversation_sceneid");
      }
      try
      {
        long l = Long.parseLong((String)localObject);
        anot.a(this.app, "dc00898", "", "", "0X800A5AF", "0X800A5AF", 0, 0, l + "", "", "", "");
        j = 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("JumpAction", 1, "sceneid must be a numeric string");
          j = 1;
        }
      }
    } while (j == 0);
    localObject = new Intent();
    ((Intent)localObject).setClass(this.context, SplashActivity.class);
    ((Intent)localObject).setFlags(67108864);
    ((Intent)localObject).putExtra("tab_index", i);
    ((Intent)localObject).putExtra("fragment_id", j);
    this.context.startActivity((Intent)localObject);
    return true;
  }
  
  private boolean aDd()
  {
    long l4 = System.currentTimeMillis();
    boolean bool2 = adaq.a().adl();
    adas localadas = (adas)this.app.getManager(220);
    Object localObject1;
    if (localadas != null)
    {
      localObject1 = localadas.a();
      QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity device support is config info is " + localObject1);
      if (!localadas.ado()) {}
    }
    label135:
    label801:
    label1200:
    for (boolean bool1 = true;; bool1 = false)
    {
      String str;
      if (this.attrs.containsKey("from")) {
        str = (String)this.attrs.get("from");
      }
      label586:
      label849:
      for (;;)
      {
        Object localObject2;
        if (this.attrs.containsKey("args"))
        {
          localObject1 = (String)this.attrs.get("args");
          if (!this.attrs.containsKey("disablecloud")) {
            break label513;
          }
          localObject2 = (String)this.attrs.get("disablecloud");
        }
        label620:
        label877:
        try
        {
          for (;;)
          {
            i = Integer.parseInt((String)localObject2);
            if ((i == 1) || (i == 0)) {
              break label1398;
            }
            i = 1;
            QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity device support is " + bool2 + ",effectinfo is " + bool1 + ",from url is " + str + ",args is" + (String)localObject1 + ",cloudSwitch is " + i);
            if ((!bool2) || (!bool1)) {
              break label1200;
            }
            localIntent = new Intent();
            localIntent.setClass(this.context, ScannerActivity.class);
            localIntent.putExtra("from", "web-ar");
            localIntent.addFlags(67108864);
            localIntent.addFlags(268435456);
            localIntent.addFlags(65536);
            localIntent.addFlags(536870912);
            localIntent.putExtra("click_time", System.currentTimeMillis());
            localIntent.putExtra("web_url_switch", i);
            localIntent.putExtra("jump_from_web", true);
            if (!QLog.isDevelopLevel()) {
              break label620;
            }
            localObject2 = this.attrs.entrySet().iterator();
            for (localObject1 = "";; localObject1 = (String)localObject1 + (String)((Map.Entry)localObject4).getKey() + "[" + ((String)((Map.Entry)localObject4).getValue()).substring(0, 20) + "]\n")
            {
              if (!((Iterator)localObject2).hasNext()) {
                break label586;
              }
              localObject4 = (Map.Entry)((Iterator)localObject2).next();
              if ((((Map.Entry)localObject4).getValue() == null) || (((String)((Map.Entry)localObject4).getValue()).length() <= 20)) {
                break;
              }
            }
            str = "";
            break;
            localObject1 = "";
            break label135;
            localObject2 = "0";
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          label755:
          label1398:
          for (;;)
          {
            Intent localIntent;
            int i = 0;
            continue;
            localObject1 = (String)localObject1 + (String)((Map.Entry)localObject4).getKey() + "[" + (String)((Map.Entry)localObject4).getValue() + "]\n";
            continue;
            QLog.w("JumpAction", 1, "gotoScannerActivity, \n" + (String)localObject1 + "]");
            Object localObject4 = new Bundle();
            localObject1 = (String)this.attrs.get("PromotionType");
            long l2 = 1L;
            long l1 = l2;
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
            try
            {
              l1 = Long.valueOf((String)localObject1).longValue();
              long l3 = 0L;
              localObject1 = (String)this.attrs.get("RecoglizeMask");
              l2 = l3;
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
              try
              {
                l2 = Long.valueOf((String)localObject1).longValue();
                Object localObject3;
                if (!this.attrs.containsKey("H5Source"))
                {
                  localObject1 = "";
                  bool1 = true;
                  if (!this.attrs.containsKey("enableQR")) {
                    break label1147;
                  }
                  localObject3 = (String)this.attrs.get("enableQR");
                }
                label1147:
                try
                {
                  l3 = Long.valueOf((String)localObject3).longValue();
                  if (l3 != 0L) {
                    break label1155;
                  }
                  bool1 = true;
                }
                catch (Exception localException3)
                {
                  label1019:
                  break label775;
                }
                ((Bundle)localObject4).putLong("PromotionType", l1);
                ((Bundle)localObject4).putLong("RecoglizeMask", l2);
                if (i != 0)
                {
                  bool2 = true;
                  ((Bundle)localObject4).putBoolean("disablecloud", bool2);
                  ((Bundle)localObject4).putString("H5Source", (String)localObject1);
                  if (!this.attrs.containsKey("version")) {
                    break label1167;
                  }
                  localObject1 = (String)this.attrs.get("version");
                  ((Bundle)localObject4).putString("version", (String)localObject1);
                  ((Bundle)localObject4).putBoolean("enableQR", bool1);
                  if (l1 == 0L) {
                    break label1175;
                  }
                  i = 1;
                  if ((i != 0) && (this.attrs.containsKey("PromotionDescription"))) {
                    ((Bundle)localObject4).putString("PromotionDescription", (String)this.attrs.get("PromotionDescription"));
                  }
                  ((Bundle)localObject4).putBoolean("is_from_h5_entry", true);
                  localIntent.putExtra("web_invoke_params", (Bundle)localObject4);
                  AudioHelper.I("JumpAction", (Bundle)localObject4);
                  QLog.w("JumpAction", 1, "PromotionInfo test , \n" + ((Bundle)localObject4).toString() + "]");
                  if (localadas != null)
                  {
                    if ((localadas.a() != null) && (!TextUtils.isEmpty(localadas.a().bso))) {
                      break label1180;
                    }
                    localIntent.putExtra("icon_text", "QQ-AR");
                    if ((localadas.a() != null) && (localadas.a().bsm != null)) {
                      localIntent.putExtra("icon_url", localadas.a().bsm);
                    }
                  }
                  this.context.startActivity(localIntent);
                  anot.a(this.app, "dc01440", "", "", "0X8007BB9", "0X8007BB9", 0, 0, "0", str, "", "");
                }
                for (;;)
                {
                  QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity cost time is " + (System.currentTimeMillis() - l4));
                  return true;
                  localObject1 = (String)this.attrs.get("H5Source");
                  break;
                  localObject3 = "0";
                  break label755;
                  bool1 = false;
                  break label775;
                  bool2 = false;
                  break label801;
                  localObject1 = "0";
                  break label849;
                  i = 0;
                  break label877;
                  localIntent.putExtra("icon_text", localadas.a().bso);
                  break label1019;
                  localObject3 = new StringBuilder("https://ti.qq.com/ar/help/error.html?_wv=3");
                  ((StringBuilder)localObject3).append("&from=");
                  ((StringBuilder)localObject3).append(str);
                  ((StringBuilder)localObject3).append("&args=");
                  new StringBuffer();
                  ((StringBuilder)localObject3).append(xci.hu((String)localObject1));
                  QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity QQBrowserActivity cost time is " + ((StringBuilder)localObject3).toString());
                  localObject1 = new Intent(this.context, QQBrowserActivity.class);
                  ((Intent)localObject1).putExtra("uin", this.app.getCurrentUin());
                  ((Intent)localObject1).putExtra("url", ((StringBuilder)localObject3).toString());
                  this.context.startActivity((Intent)localObject1);
                  anot.a(this.app, "dc01440", "", "", "0X8007BB9", "0X8007BB9", 0, 0, "1", str, "", "");
                }
              }
              catch (Exception localException1)
              {
                for (;;)
                {
                  l2 = l3;
                }
              }
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                l1 = l2;
              }
            }
          }
        }
      }
    }
  }
  
  private boolean aDe()
  {
    for (;;)
    {
      try
      {
        if (!this.attrs.containsKey("kSrouce")) {
          continue;
        }
        localObject = (String)this.attrs.get("from");
        i = Integer.parseInt((String)localObject);
      }
      catch (Exception localException)
      {
        Object localObject;
        QLog.i("JumpAction", 1, "gotoBindNumberActivity from value format wrong");
        int i = 22;
        continue;
      }
      localObject = new Intent(this.context, BindNumberActivity.class);
      ((Intent)localObject).putExtra("kSrouce", i);
      this.context.startActivity((Intent)localObject);
      return true;
      localObject = "22";
    }
  }
  
  private boolean aDf()
  {
    if (!this.attrs.containsKey("interest_type")) {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "ChooseInterestTagActivity->type = null");
      }
    }
    do
    {
      for (;;)
      {
        return false;
        Object localObject = (String)this.attrs.get("interest_type");
        String str;
        if (this.attrs.containsKey("from"))
        {
          str = (String)this.attrs.get("from");
          if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "ChooseInterestTagActivity->type = " + (String)localObject);
          }
        }
        try
        {
          i = Integer.valueOf((String)localObject).intValue();
          if ("interesttag_selector".equals(this.ctj))
          {
            try
            {
              localObject = new Intent(this.context, ChooseInterestTagActivity.class);
              ((Intent)localObject).putExtra("is_from_judge", true);
              ((Intent)localObject).putExtra("interest_tag_type", i);
              ((Intent)localObject).putExtra("from_where", "web_to_choose_tag");
              if ("10002".equals(str)) {
                ((Intent)localObject).addFlags(268435456);
              }
              this.context.startActivity((Intent)localObject);
              return true;
            }
            catch (Exception localException1) {}
            str = "";
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            int i = 0;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("JumpAction", 2, "", localException1);
    return false;
  }
  
  private boolean aDh()
  {
    for (;;)
    {
      try
      {
        if (this.attrs.containsKey("groupCode"))
        {
          String str1 = (String)this.attrs.get("groupCode");
          if (this.attrs.containsKey("groupMemberUin"))
          {
            str3 = (String)this.attrs.get("groupMemberUin");
            Intent localIntent = new Intent();
            localIntent.putExtra("troop_uin", str1);
            localIntent.putExtra("member_uin", str3);
            PublicFragmentActivity.start(this.context, localIntent, TroopMemberHistoryFragment.class);
            return true;
          }
          String str3 = "";
          continue;
        }
        String str2 = "";
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("JumpAction", 2, localException.toString());
        }
        return false;
      }
    }
  }
  
  private boolean aDi()
  {
    HotChatManager.w(this.context, false);
    return true;
  }
  
  private boolean aDj()
  {
    if (this.attrs.containsKey("hotnamecode")) {}
    for (String str = (String)this.attrs.get("hotnamecode"); TextUtils.isEmpty(str); str = "")
    {
      QQToast.a(BaseApplicationImpl.getContext(), acfp.m(2131707543), 1).show();
      return false;
    }
    NearbyTransitActivity.a(this.context, str, 1, this.attrs);
    return true;
  }
  
  /* Error */
  private boolean aDk()
  {
    // Byte code:
    //   0: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +19 -> 22
    //   6: ldc_w 666
    //   9: iconst_1
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: ldc_w 2785
    //   18: aastore
    //   19: invokestatic 1974	ajrk:m	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: aload_0
    //   23: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   26: ldc_w 2787
    //   29: invokevirtual 661	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   32: ifeq +221 -> 253
    //   35: aload_0
    //   36: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   39: ldc_w 2787
    //   42: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: checkcast 72	java/lang/String
    //   48: invokestatic 2309	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   51: istore_2
    //   52: aload_0
    //   53: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   56: ldc_w 1548
    //   59: invokevirtual 661	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   62: ifeq +186 -> 248
    //   65: aload_0
    //   66: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   69: ldc_w 1548
    //   72: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   75: checkcast 72	java/lang/String
    //   78: invokestatic 715	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   81: istore_1
    //   82: new 126	android/content/Intent
    //   85: dup
    //   86: aload_0
    //   87: getfield 115	aqhv:context	Landroid/content/Context;
    //   90: ldc 128
    //   92: invokespecial 131	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   95: astore_3
    //   96: aload_3
    //   97: ldc 145
    //   99: iconst_1
    //   100: invokevirtual 148	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   103: pop
    //   104: aload_3
    //   105: ldc_w 2552
    //   108: getstatic 2557	com/tencent/mobileqq/activity/MainFragment:bIk	I
    //   111: invokevirtual 148	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   114: pop
    //   115: aload_3
    //   116: ldc 138
    //   118: invokevirtual 2550	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   121: pop
    //   122: aload_0
    //   123: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   126: ldc_w 1548
    //   129: invokevirtual 661	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   132: ifeq +12 -> 144
    //   135: aload_3
    //   136: ldc_w 1548
    //   139: iload_1
    //   140: invokevirtual 148	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   143: pop
    //   144: aload_0
    //   145: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   148: ldc_w 2787
    //   151: invokevirtual 661	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   154: ifeq +12 -> 166
    //   157: aload_3
    //   158: ldc_w 2787
    //   161: iload_2
    //   162: invokevirtual 137	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   165: pop
    //   166: aload_0
    //   167: getfield 115	aqhv:context	Landroid/content/Context;
    //   170: instanceof 128
    //   173: ifeq +41 -> 214
    //   176: aload_0
    //   177: getfield 115	aqhv:context	Landroid/content/Context;
    //   180: checkcast 128	com/tencent/mobileqq/activity/SplashActivity
    //   183: astore 4
    //   185: aload_3
    //   186: ldc_w 2789
    //   189: iconst_1
    //   190: invokevirtual 137	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   193: pop
    //   194: aload 4
    //   196: aload_3
    //   197: invokevirtual 2792	com/tencent/mobileqq/activity/SplashActivity:ch	(Landroid/content/Intent;)V
    //   200: iconst_1
    //   201: ireturn
    //   202: astore_3
    //   203: iconst_0
    //   204: istore_2
    //   205: aload_3
    //   206: invokevirtual 827	java/lang/Exception:printStackTrace	()V
    //   209: iconst_0
    //   210: istore_1
    //   211: goto -129 -> 82
    //   214: aload_0
    //   215: getfield 115	aqhv:context	Landroid/content/Context;
    //   218: aload_3
    //   219: invokevirtual 544	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   222: aload_0
    //   223: getfield 115	aqhv:context	Landroid/content/Context;
    //   226: instanceof 200
    //   229: ifeq -29 -> 200
    //   232: aload_0
    //   233: getfield 115	aqhv:context	Landroid/content/Context;
    //   236: checkcast 200	android/app/Activity
    //   239: invokevirtual 2793	android/app/Activity:finish	()V
    //   242: iconst_1
    //   243: ireturn
    //   244: astore_3
    //   245: goto -40 -> 205
    //   248: iconst_0
    //   249: istore_1
    //   250: goto -168 -> 82
    //   253: iconst_0
    //   254: istore_2
    //   255: goto -203 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	aqhv
    //   81	169	1	i	int
    //   51	204	2	bool	boolean
    //   95	102	3	localIntent	Intent
    //   202	17	3	localException1	Exception
    //   244	1	3	localException2	Exception
    //   183	12	4	localSplashActivity	SplashActivity
    // Exception table:
    //   from	to	target	type
    //   22	52	202	java/lang/Exception
    //   52	82	244	java/lang/Exception
  }
  
  private boolean aDl()
  {
    return true;
  }
  
  private boolean aDm()
  {
    return true;
  }
  
  private boolean aDn()
  {
    return true;
  }
  
  private boolean aDo()
  {
    Intent localIntent2 = ((Activity)this.context).getIntent();
    String str = localIntent2.getStringExtra("uin");
    Intent localIntent1;
    long l2;
    long l1;
    if (aqft.rj(str))
    {
      localIntent1 = new Intent();
      localIntent1.putExtra("uin", str);
      localIntent1.putExtra("uintype", localIntent2.getIntExtra("uintype", -1));
      l2 = 0L;
      l1 = l2;
    }
    try
    {
      if (!TextUtils.isEmpty(getAttribute("msg_uniseq"))) {
        l1 = Long.valueOf(getAttribute("msg_uniseq")).longValue();
      }
      str = this.app.b().e(str, "chatimg", l1);
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "gotoSetAvator path:" + str + "msg uniseq:" + l1);
      }
      int i = Math.min(482, aqep.v((Activity)this.context));
      localIntent1.putExtra("Business_Origin", 100);
      localIntent1.putExtra("open_chatfragment", true);
      localIntent1.putExtra("open_chat_from_avator", true);
      PhotoUtils.a(localIntent1, (Activity)this.context, SplashActivity.class.getName(), i, i, 1080, 1080, str, aqep.BR());
      anot.a(this.app, "dc00898", "", "", "0X800723E", "0X800723E", 0, 0, "", "", "", "");
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.i("JumpAction", 1, "NumberFormatException uniseq:" + getAttribute("msg_uniseq"));
        l1 = l2;
      }
    }
  }
  
  private boolean aDp()
  {
    String str1 = toBase64Decode((String)this.attrs.get("app_name"));
    String str2 = (String)this.attrs.get("share_id");
    String str3 = toBase64Decode((String)this.attrs.get("open_id"));
    String str4 = toBase64Decode((String)this.attrs.get("set_uri_list"));
    String str5 = toBase64Decode((String)this.attrs.get("sdk_version"));
    ArrayList localArrayList = ((Activity)this.context).getIntent().getParcelableArrayListExtra("android.intent.extra.STREAM");
    Intent localIntent = new Intent(this.context, FavEmosmManageActivity.class);
    localIntent.addFlags(335544320);
    localIntent.putExtra("key_from_sdk_set_emotion", true);
    localIntent.putParcelableArrayListExtra("key_from_sdk_set_emotion_uri", localArrayList);
    localIntent.putExtra("pkg_name", this.pkgName);
    if (!TextUtils.isEmpty(str1)) {
      localIntent.putExtra("key_from_sdk_set_emotion_appname", str1);
    }
    if (!TextUtils.isEmpty(str2)) {
      localIntent.putExtra("key_from_sdk_set_emotion_share_id", str2);
    }
    if (!TextUtils.isEmpty(str3)) {
      localIntent.putExtra("key_from_sdk_set_emotion_open_id", str3);
    }
    if (!TextUtils.isEmpty(str4)) {
      localIntent.putExtra("key_from_sdk_set_emotion_uri_list", str4);
    }
    if (!TextUtils.isEmpty(str5)) {
      localIntent.putExtra("sdk_version", str5);
    }
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoSDKSetEmotion:sdk appName=" + str1 + " shareId=" + str2 + ", openId =" + str3 + ", setPathList =" + str4);
    }
    this.context.startActivity(localIntent);
    return true;
  }
  
  private boolean aDq()
  {
    String str1 = toBase64Decode((String)this.attrs.get("set_uri"));
    QLog.d("JumpAction", 1, new Object[] { "-->gotoSDKSetAvator setUri=", str1 });
    if (!TextUtils.isEmpty(str1)) {
      return a(new JumpAction.5(this), str1, "set_uri", "set_path");
    }
    str1 = toBase64Decode((String)this.attrs.get("app_name"));
    String str2 = (String)this.attrs.get("share_id");
    String str3 = toBase64Decode((String)this.attrs.get("open_id"));
    String str4 = toBase64Decode((String)this.attrs.get("set_path"));
    String str5 = toBase64Decode((String)this.attrs.get("sdk_version"));
    ((Activity)this.context).getIntent().getIntExtra("key_request_code", 0);
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.app.getCurrentAccountUin(), 0);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_from_sdk_set_avatar", true);
    localBundle.putString("key_from_sdk_set_avatar_path", str4);
    localBundle.putString("pkg_name", this.pkgName);
    if (!TextUtils.isEmpty(str1)) {
      localBundle.putString("key_from_sdk_set_avatar_appname", str1);
    }
    if (!TextUtils.isEmpty(str2)) {
      localBundle.putString("key_from_sdk_set_avatar_share_id", str2);
    }
    if (!TextUtils.isEmpty(str3)) {
      localBundle.putString("key_from_sdk_set_avatar_open_id", str3);
    }
    if (!TextUtils.isEmpty(str5)) {
      localBundle.putString("sdk_version", str5);
    }
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoSDKSetAvator:sdk appName=" + str1 + " shareId=" + str2 + ", openId =" + str3 + ", setPath =" + str4 + ", sdkVersion =" + str5);
    }
    ProfileActivity.b(this.context, localAllInOne, localBundle);
    return true;
  }
  
  private boolean aDr()
  {
    String str1 = toBase64Decode((String)this.attrs.get("video_uri"));
    QLog.d("JumpAction", 1, new Object[] { "-->gotoSDKSetDynamicAvatar videoUri=", str1 });
    if (!TextUtils.isEmpty(str1)) {
      return a(new JumpAction.6(this), str1, "video_uri", "video_path");
    }
    str1 = toBase64Decode((String)this.attrs.get("app_name"));
    String str2 = (String)this.attrs.get("share_id");
    String str3 = toBase64Decode((String)this.attrs.get("open_id"));
    String str4 = toBase64Decode((String)this.attrs.get("video_path"));
    String str5 = toBase64Decode((String)this.attrs.get("sdk_version"));
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, new Object[] { "[gotoSDKSetDynamicAvatar] appName=", str1 });
    }
    anot.a(this.app, "dc00898", "", "", "0X8009DF9", "0X8009DF9", 0, 0, str2, "", "", "");
    Intent localIntent = new Intent(this.context, SelectCoverActivity.class);
    localIntent.putExtra("param_source", 3);
    localIntent.putExtra("param_from_newer_guide", false);
    localIntent.putExtra("key_video_file_path", str4);
    localIntent.putExtra("pkg_name", this.pkgName);
    localIntent.putExtra("app_name", str1);
    localIntent.putExtra("share_id", str2);
    localIntent.putExtra("open_id", str3);
    localIntent.putExtra("sdk_version", str5);
    localIntent.addFlags(335544320);
    this.context.startActivity(localIntent);
    return true;
  }
  
  private boolean aDs()
  {
    Intent localIntent = new Intent(this.context, RecommendFriendActivity.class);
    localIntent.putExtra("EntranceId", 7);
    localIntent.putExtra("from_babyq", true);
    this.context.startActivity(localIntent);
    anot.a(this.app, "dc00898", "", "", "0X8007243", "0X8007243", 0, 0, "", "", "", "");
    return true;
  }
  
  private boolean aDt()
  {
    Intent localIntent = new Intent();
    PublicFragmentActivity.start(this.context, localIntent, SearchMightKnowFragment.class);
    return true;
  }
  
  private boolean aDu()
  {
    Intent localIntent = new Intent();
    String str = (String)this.attrs.get("from_type");
    if ((!TextUtils.isEmpty(str)) && (isNumeric(str))) {}
    for (int i = Integer.valueOf(str).intValue();; i = 0)
    {
      localIntent.putExtra("jumpFromType", i);
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoShowNewFriends " + i);
      }
      NewFriendActivity.g(this.context, localIntent, 9);
      return true;
    }
  }
  
  private boolean aDv()
  {
    Object localObject = (String)this.attrs.get("from_type");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (isNumeric((String)localObject))) {}
    for (int i = Integer.valueOf((String)localObject).intValue();; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoShowContactsTab " + i);
      }
      localObject = new Intent(this.context, SplashActivity.class);
      ((Intent)localObject).setFlags(67108864);
      ((Intent)localObject).putExtra("jumpFromType", i);
      ((Intent)localObject).putExtra("tab_index", MainFragment.bIm);
      ((Intent)localObject).putExtra("fragment_id", 1);
      this.context.startActivity((Intent)localObject);
      return true;
    }
  }
  
  private boolean aDw()
  {
    Intent localIntent = new Intent(this.context, ContactBindedActivity.class);
    localIntent.putExtra("from_babyq", true);
    this.context.startActivity(localIntent);
    return true;
  }
  
  private boolean aDx()
  {
    Intent localIntent = new Intent(this.context, LiteActivity.class);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("leftBackText", acfp.m(2131707555));
    ((Bundle)localObject).putBoolean("isBack2Root", true);
    localIntent.addFlags(268435456);
    localIntent.addFlags(67108864);
    localIntent.putExtras((Bundle)localObject);
    localObject = (String)this.attrs.get("txt");
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      localIntent.putExtra("JumpAction.Text", toBase64Decode((String)localObject));
    }
    this.context.startActivity(localIntent);
    return true;
  }
  
  private boolean aDy()
  {
    try
    {
      String str = (String)this.attrs.get("openid");
      int i = Integer.parseInt((String)this.attrs.get("appid"));
      if (str == null) {
        return false;
      }
      Intent localIntent = new Intent(this.context, SplashActivity.class);
      localIntent.setFlags(335544320);
      localIntent.putExtra("tab_index", MainFragment.bIk);
      localIntent.putExtra("openid", str);
      localIntent.putExtra("appid", i);
      localIntent.putExtra("source", this.source);
      this.context.startActivity(localIntent);
      return true;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "Receive error appid number format");
      }
    }
    return false;
  }
  
  private boolean aDz()
  {
    Object localObject = (String)this.attrs.get("app_type");
    String str2 = (String)this.attrs.get("mini_app_id");
    String str3 = (String)this.attrs.get("src_id");
    String str4 = toBase64Decode((String)this.attrs.get("app_id"));
    String str5 = toBase64Decode((String)this.attrs.get("mini_app_path"));
    String str6 = toBase64Decode((String)this.attrs.get("mini_app_type"));
    String str7 = toBase64Decode((String)this.attrs.get("app_name"));
    String str1 = toBase64Decode((String)this.attrs.get("open_id"));
    anot.a(this.app, "dc01160", "", "", "0X800A519", "0X800A519", 0, 0, "", "", str4, str2);
    if (TextUtils.isEmpty(this.pkgName))
    {
      anot.a(this.app, "dc01160", "", "", "0X800A51B", "0X800A51B", 0, 0, "", "", str4, str2);
      QLog.e("JumpAction", 1, "connectMiniApp fail: packageName is empty");
      return true;
    }
    if ("mini_program_or_game".equals(localObject))
    {
      if (!aqiw.isNetSupport(this.context))
      {
        QQToast.a(this.context, 1, 2131701798, 1).show();
        localObject = new Intent(this.context, SplashActivity.class);
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).addFlags(268435456);
        this.context.startActivity((Intent)localObject);
        return true;
      }
      this.dJ = new Handler();
      this.dJ.postDelayed(new JumpAction.11(this), 20000L);
      this.dJ.postDelayed(new JumpAction.12(this), 500L);
      try
      {
        this.cUh = true;
        boolean bool;
        MessageHandler localMessageHandler;
        if (!TextUtils.isEmpty(str1))
        {
          bool = true;
          ahlw.Kj("KEY_STAGE_2_CONNECT_MINI_D55");
          localMessageHandler = this.app.a();
          if (str1 != null) {
            break label437;
          }
        }
        label437:
        for (localObject = "";; localObject = str1)
        {
          localMessageHandler.a(bool, (String)localObject, true, Long.valueOf(str2).longValue(), Long.valueOf(str4).longValue(), 1, Integer.valueOf(str3).intValue(), this.pkgName, false, 0L, new aqhx(this, str4, str2, str5, str6, str1, str7));
          return false;
          bool = false;
          break;
        }
        return true;
      }
      catch (Exception localException)
      {
        if (this.cUh)
        {
          this.cUh = false;
          hideProgressDialog();
        }
        QLog.e("JumpAction", 1, "checkAppSignAndOpenidDiff exception: " + localException.getMessage());
        return true;
      }
    }
  }
  
  private boolean aEK()
  {
    if (((this.context instanceof JumpActivity)) && ((((JumpActivity)this.context).getIntent().getFlags() & 0x100000) != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, String.format("gotoRegisterByInvite bLaunchFromRecent=%b", new Object[] { Boolean.valueOf(bool) }));
      }
      String str;
      Intent localIntent;
      if (this.attrs.containsKey("code"))
      {
        str = (String)this.attrs.get("code");
        Object localObject = f();
        localIntent = new Intent(this.context, (Class)localObject);
        if (RegisterPhoneNumActivity.class != localObject) {
          break label283;
        }
        localIntent.putExtra("key_report_extra_from", 5);
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localIntent.putExtra("invite_code", (String)localObject);
      }
      label283:
      for (int i = 1;; i = 0)
      {
        if ((this.app != null) && (this.app.isLogin()) && (i != 0) && (!bool))
        {
          localIntent.putExtra("action", 4097);
          PublicFragmentActivity.b.start(this.context, localIntent, PublicTransFragmentActivity.class, TranslucentTRansferFragment.class);
          anot.a(this.app, "dc00898", "", "", "0X80096FF", "0X80096FF", 0, 0, "", "", "", "");
          return true;
          str = "";
          break;
        }
        this.context.startActivity(localIntent);
        anot.a(this.app, "dc00898", "", "", "0X80096FE", "0X80096FE", 0, 0, "", "", "", "");
        return true;
      }
    }
  }
  
  private boolean aEL()
  {
    String str1 = (String)this.attrs.get("troopUin");
    String str2 = (String)this.attrs.get("evilUin");
    String str3 = (String)this.attrs.get("selfUin");
    String str4 = (String)this.attrs.get("scene");
    int j = 20008;
    int i = j;
    if (str4 != null) {}
    try
    {
      i = Integer.parseInt(str4);
      stj.a((BaseActivity)this.context, str2, str1, str3, i, null);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  private boolean aEM()
  {
    String str = (String)this.attrs.get("uin");
    if (aqmr.isEmpty(str)) {
      str = "0";
    }
    for (;;)
    {
      ajpp localajpp = (ajpp)((BaseActivity)this.context).getAppInterface().getManager(204);
      long l = Long.parseLong(str);
      localajpp.a(l, new aqid(this, l));
      return true;
    }
  }
  
  private boolean aEN()
  {
    ((anwh)this.app.getManager(362)).d(this.context, this.attrs);
    return true;
  }
  
  private boolean aEP()
  {
    aihv localaihv = (aihv)this.app.getManager(338);
    if ((this.context instanceof Activity))
    {
      localObject1 = ((Activity)this.context).getIntent();
      if (localObject1 == null) {}
    }
    for (Object localObject1 = ((Intent)localObject1).getDataString();; localObject1 = "")
    {
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = this.source;
      }
      for (;;)
      {
        NewTogetherRoomMessageData localNewTogetherRoomMessageData = new NewTogetherRoomMessageData();
        if (this.attrs.containsKey("room_type"))
        {
          str1 = (String)this.attrs.get("room_type");
          localNewTogetherRoomMessageData.ddo = Integer.parseInt(str1);
          if (!this.attrs.containsKey("group_uin")) {
            break label313;
          }
          str1 = (String)this.attrs.get("group_uin");
          label128:
          localNewTogetherRoomMessageData.QD = str1;
          if (!this.attrs.containsKey("group_owner_uin")) {
            break label320;
          }
        }
        label313:
        label320:
        for (String str1 = (String)this.attrs.get("group_owner_uin");; str1 = "0")
        {
          localNewTogetherRoomMessageData.bNH = str1;
          localNewTogetherRoomMessageData.wV = ((String)localObject1);
          localNewTogetherRoomMessageData.aif = ((String)this.attrs.get("cover_url"));
          Object localObject2 = Uri.parse((String)localObject1);
          localObject1 = ((Uri)localObject2).getQueryParameter("roomid");
          str1 = ((Uri)localObject2).getQueryParameter("room_show_number");
          String str2 = ((Uri)localObject2).getQueryParameter("fromid");
          localObject2 = ((Uri)localObject2).getQueryParameter("room_group_code");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localNewTogetherRoomMessageData.abz = Integer.parseInt((String)localObject1);
          }
          if (!TextUtils.isEmpty(str1)) {
            localNewTogetherRoomMessageData.ddp = Integer.parseInt(str1);
          }
          if (!TextUtils.isEmpty(str2)) {
            localNewTogetherRoomMessageData.bNJ = str2;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            localNewTogetherRoomMessageData.bNI = ((String)localObject2);
          }
          localaihv.e(localNewTogetherRoomMessageData);
          return true;
          str1 = "0";
          break;
          str1 = "0";
          break label128;
        }
      }
    }
  }
  
  private boolean aEa()
  {
    if ("webview".equals(this.from))
    {
      String str = (String)this.attrs.get("bus_type");
      this.context.startActivity(new Intent(this.context, JumpActivity.class).putExtra("action", "photo").putExtra("doCallBack", true).putExtra("src_type", (String)this.attrs.get("src_type")).putExtra("callback_type", (String)this.attrs.get("callback_type")).putExtra("callback_name", (String)this.attrs.get("callback_name")));
    }
    return true;
  }
  
  private boolean aEb()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.attrs.keySet().iterator();
    label109:
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (!str2.equals("src_type")) {}
      for (String str1 = toBase64Decode((String)this.attrs.get(str2));; str1 = (String)this.attrs.get(str2))
      {
        if (TextUtils.isEmpty(str1)) {
          break label109;
        }
        localBundle.putString(str2, str1);
        break;
      }
    }
    localBundle.putString("pkg_name", this.pkgName);
    localBundle.putString("pkg_sig", this.pkgSig);
    localBundle.putInt("action", 3);
    localIntent.putExtra("key_params", localBundle);
    PublicFragmentActivity.b.start(this.context, localIntent, PublicTransFragmentActivity.class, JoinTroopPreVerificationFragment.class);
    return true;
  }
  
  private boolean aEc()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.attrs.keySet().iterator();
    label109:
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (!str2.equals("src_type")) {}
      for (String str1 = toBase64Decode((String)this.attrs.get(str2));; str1 = (String)this.attrs.get(str2))
      {
        if (TextUtils.isEmpty(str1)) {
          break label109;
        }
        localBundle.putString(str2, str1);
        break;
      }
    }
    localBundle.putString("pkg_name", this.pkgName);
    localBundle.putString("pkg_sig", this.pkgSig);
    localBundle.putInt("action", 1);
    localIntent.putExtra("key_params", localBundle);
    PublicFragmentActivity.b.start(this.context, localIntent, PublicTransFragmentActivity.class, BindTroopPreVerificationFragment.class);
    return true;
  }
  
  private boolean aEd()
  {
    Intent localIntent = new Intent(this.context, BindGroupActivity.class);
    localIntent.putExtra("uin", this.app.getCurrentAccountUin());
    localIntent.putExtra("skey", ((TicketManager)this.app.getManager(2)).getSkey(this.app.getCurrentAccountUin()));
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.attrs.keySet().iterator();
    label162:
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (!str2.equals("src_type")) {}
      for (String str1 = toBase64Decode((String)this.attrs.get(str2));; str1 = (String)this.attrs.get(str2))
      {
        if (TextUtils.isEmpty(str1)) {
          break label162;
        }
        localBundle.putString(str2, str1);
        break;
      }
    }
    localBundle.putString("pkg_name", this.pkgName);
    localIntent.putExtra("key_params", localBundle);
    this.context.startActivity(localIntent);
    return true;
  }
  
  private boolean aEe()
  {
    System.currentTimeMillis();
    Object localObject3 = toBase64Decode((String)this.attrs.get("url_prefix"));
    if ((localObject3 == null) || ((!((String)localObject3).startsWith("http://")) && (!((String)localObject3).startsWith("https://"))) || ((!jqo.dV((String)localObject3).equalsIgnoreCase("qq.com")) && (!jqo.dV((String)localObject3).equalsIgnoreCase("myun.tenpay.com")) && (!jqo.dV((String)localObject3).equalsIgnoreCase("tenpay.com")) && (!jqo.dV((String)localObject3).equalsIgnoreCase("wanggou.com")) && (!jqo.dV((String)localObject3).equalsIgnoreCase("tencent.com")) && (!jqo.dV((String)localObject3).equalsIgnoreCase("jd.com")) && (!jqo.dV((String)localObject3).equalsIgnoreCase("qcloud.com")) && (!jqo.dV((String)localObject3).equalsIgnoreCase("webank.com")) && (!jqo.dV((String)localObject3).equalsIgnoreCase("qqumall.com")))) {
      return false;
    }
    if ((((String)localObject3).startsWith("https://jiazhang.qq.com/wap/com/")) || (((String)localObject3).startsWith("https://test.jiazhang.qq.com/wap/com/")))
    {
      if ((!this.attrs.containsKey("openid")) || (TextUtils.isEmpty((CharSequence)this.attrs.get("openid"))) || (!this.attrs.containsKey("appid")) || (TextUtils.isEmpty((CharSequence)this.attrs.get("appid"))))
      {
        QLog.e("JumpAction", 1, "empty params");
        return false;
      }
      anot.a(this.app, "dc00898", "", "", "0X80097E8", "0X80097E8", 0, 0, "", "", (String)this.attrs.get("appid"), "");
    }
    Object localObject1 = (String)this.attrs.get("style");
    String str1 = toBase64Decode((String)this.attrs.get("title"));
    String str2 = (String)this.attrs.get("plg_auth");
    localObject1 = (String)this.attrs.get("plg_nld");
    String str3 = (String)this.attrs.get("plg_dev");
    String str4 = (String)this.attrs.get("plg_usr");
    String str5 = (String)this.attrs.get("plg_vkey");
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append((String)localObject3);
    if (localStringBuffer.indexOf("?") < 0)
    {
      localStringBuffer.append("?");
      localObject3 = new Cryptor();
      if (!"1".equals(str2)) {
        break label2267;
      }
      localStringBuffer.append("plg_auth=1");
      localStringBuffer.append("&");
    }
    label2125:
    label2267:
    for (int i = 1;; i = 0)
    {
      if ("1".equals(str3))
      {
        localStringBuffer.append("plg_dev=1");
        localStringBuffer.append("&");
        localStringBuffer.append("MOBINFO=");
        localStringBuffer.append(aqhs.bytes2HexStr(((Cryptor)localObject3).encrypt(Cb().getBytes(), "4eY#X@~g.+U)2%$<".getBytes())));
        localStringBuffer.append("&");
        i = 1;
      }
      if ("1".equals(str4))
      {
        localStringBuffer.append("plg_usr=1");
        localStringBuffer.append("&");
        localStringBuffer.append("USER=");
        localStringBuffer.append(aqhs.bytes2HexStr(((Cryptor)localObject3).encrypt(acfp.m(2131707553).getBytes(), "4eY#X@~g.+U)2%$<".getBytes())));
        localStringBuffer.append("&");
        i = 1;
      }
      int j = i;
      if ("1".equals(str5))
      {
        localObject3 = this.app.rK();
        j = i;
        if (localObject3 != null)
        {
          localStringBuffer.append("plg_vkey=1").append("&mqqvkey=").append((String)localObject3).append("&");
          j = 1;
        }
      }
      if ((this.ctk != null) && (this.ctk.length() > 0)) {
        localStringBuffer.append(this.ctk + "&");
      }
      str2 = getAttribute("download_sourceid");
      if ("1".equals(localObject1))
      {
        localStringBuffer.append("plg_nld=1");
        localObject1 = new Intent(this.context, QQBrowserActivity.class).putExtra("url", localStringBuffer.toString());
        ((Intent)localObject1).putExtra("key_isReadModeEnabled", true);
        if ((str1 != null) && (!str1.equals(""))) {
          ((Intent)localObject1).putExtra("title", str1);
        }
        ((Intent)localObject1).putExtra("reportNldFormPlugin", true);
        ((Intent)localObject1).putExtra("uin", this.app.getCurrentAccountUin());
        this.context.startActivity((Intent)localObject1);
        return true;
        if (localStringBuffer.indexOf("?") >= localStringBuffer.length() - 1) {
          break;
        }
        if (localStringBuffer.indexOf("&") < 0)
        {
          localStringBuffer.append("&");
          break;
        }
        if (localStringBuffer.lastIndexOf("&") >= localStringBuffer.length() - 1) {
          break;
        }
        localStringBuffer.append("&");
        break;
      }
      if (j != 0) {
        localStringBuffer.deleteCharAt(localStringBuffer.lastIndexOf("&"));
      }
      localObject1 = localStringBuffer.toString();
      if (((String)localObject1).startsWith("http://story.now.qq.com/mobile/transfer_q.html"))
      {
        localObject1 = aurr.getArguments(((String)localObject1).substring(((String)localObject1).indexOf("?") + 1));
        if (!TextUtils.isEmpty((String)((Map)localObject1).get("storysharefrom")))
        {
          this.attrs.putAll((Map)localObject1);
          if (this.attrs.get("type") == null) {
            this.ctj = "opencontent";
          }
          for (;;)
          {
            return acv();
            switch (Integer.parseInt((String)this.attrs.get("type")))
            {
            default: 
              return true;
            case 0: 
              this.ctj = "opencontent";
              break;
            case 1: 
              this.ctj = "openVideo";
              break;
            case 2: 
              this.ctj = "opentopic";
            }
          }
        }
      }
      else if (((String)localObject1).startsWith("http://story.now.qq.com/mobile/transfer_q2.html"))
      {
        localObject1 = aurr.getArguments(((String)localObject1).substring(((String)localObject1).indexOf("?") + 1));
        this.attrs.putAll((Map)localObject1);
        localObject1 = (String)((Map)localObject1).get("contentType");
        if ((localObject1 == null) || (((String)localObject1).equals("0")))
        {
          if (this.attrs.get("actionnamekey") != null) {}
          for (i = Integer.parseInt((String)this.attrs.get("actionnamekey"));; i = Integer.parseInt((String)this.attrs.get("type"))) {
            switch (i)
            {
            default: 
              return true;
            }
          }
          this.ctj = "opencontent";
          for (;;)
          {
            return acv();
            this.ctj = "openVideo";
            continue;
            this.ctj = "opentopic";
            continue;
            this.ctj = "infoCard";
          }
        }
      }
      else
      {
        if (((String)localObject1).contains("lbs.qidian.qq.com/authorize/voiceShow"))
        {
          localObject3 = localStringBuffer.toString();
          localObject1 = localObject3;
          if (((String)localObject3).endsWith("&")) {
            localObject1 = ((String)localObject3).substring(0, ((String)localObject3).length() - 1);
          }
          localObject3 = new Intent(this.context, QQBrowserActivity.class);
          ((Intent)localObject3).putExtra("url", (String)localObject1);
          ((Intent)localObject3).putExtra("fragment_class", QidianWebViewFragment.class.getCanonicalName());
          ((Intent)localObject3).putExtra("key_isReadModeEnabled", true);
          ((Intent)localObject3).putExtra("uin", this.app.getCurrentAccountUin());
          if ((str1 != null) && (!str1.equals(""))) {
            ((Intent)localObject3).putExtra("title", str1);
          }
          ((Intent)localObject3).putExtra("uin", this.app.getCurrentAccountUin());
          ((Intent)localObject3).putExtra("plugin_start_time", System.nanoTime());
          ((Intent)localObject3).putExtra("click_start_time", System.currentTimeMillis());
          ((Intent)localObject3).putExtra("startOpenPageTime", System.currentTimeMillis());
          try
          {
            ((Intent)localObject3).putExtra("leba_resid", Long.parseLong(getAttribute("leba_resid")));
            ((Intent)localObject3).putExtra("has_red_dot", this.dw);
            ((Intent)localObject3).putExtra("is_from_leba", true);
            this.context.startActivity((Intent)localObject3);
            return true;
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              localException1.printStackTrace();
            }
          }
        }
        if ((this.context instanceof Activity))
        {
          localObject3 = new Bundle();
          ((Bundle)localObject3).putString("uin", this.app.getCurrentAccountUin());
          if (ajcw.b((Activity)this.context, localException1, (Bundle)localObject3)) {
            return true;
          }
        }
      }
      Object localObject2;
      if ((this.pkgName == null) || (!this.pkgName.trim().equalsIgnoreCase("com.tx.android.txnews.new"))) {
        if ((this.pkgName != null) && (this.pkgName.trim().equalsIgnoreCase("com.qq.yijianfankui")))
        {
          localStringBuffer.append("&version=3.4.4.3058");
          localStringBuffer.append("&appid=" + AppSetting.getAppId());
          localStringBuffer.append("&QUA=" + avpq.getQUA3());
          localStringBuffer.append("&adtag=3058");
          localObject2 = Build.MODEL;
          if (localObject2 != null)
          {
            localObject2 = ((String)localObject2).replaceAll(" ", "_");
            i = anpc.Kk();
            localObject3 = localObject2;
            if (i > 0) {
              localObject3 = (String)localObject2 + "_qzpatch" + i;
            }
            localObject2 = Build.MANUFACTURER;
            if (localObject2 == null) {
              break label2125;
            }
            localObject2 = ((String)localObject2).replaceAll(" ", "_");
            localStringBuffer.append("&model=").append((String)localObject3).append("&manufacture=").append((String)localObject2).append("&cpunum=").append(aqgz.getCpuNumber()).append("&cpurate=").append(aqgz.getCpuFrequency()).append("&mem=").append(aqgz.getSystemTotalMemory() / 1024L / 1024L).append("&w=").append(aqgz.hI()).append("&h=").append(aqgz.hJ());
          }
        }
        else
        {
          localObject3 = localStringBuffer.toString();
          localObject2 = localObject3;
          if (((String)localObject3).endsWith("&")) {
            localObject2 = ((String)localObject3).substring(0, ((String)localObject3).length() - 1);
          }
          localObject2 = new Intent(this.context, QQBrowserActivity.class).putExtra("url", (String)localObject2);
          ((Intent)localObject2).putExtra("key_isReadModeEnabled", true);
          ((Intent)localObject2).putExtra("uin", this.app.getCurrentAccountUin());
          if ((str1 != null) && (!str1.equals(""))) {
            ((Intent)localObject2).putExtra("title", str1);
          }
          ((Intent)localObject2).putExtra("uin", this.app.getCurrentAccountUin());
          ((Intent)localObject2).putExtra("plugin_start_time", System.nanoTime());
          ((Intent)localObject2).putExtra("click_start_time", System.currentTimeMillis());
          ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
        }
      }
      for (;;)
      {
        try
        {
          ((Intent)localObject2).putExtra("leba_resid", Long.parseLong(getAttribute("leba_resid")));
          ((Intent)localObject2).putExtra("has_red_dot", this.dw);
          ((Intent)localObject2).putExtra("is_from_leba", true);
          if (!TextUtils.isEmpty(str2)) {
            ((Intent)localObject2).putExtra("big_brother_source_key", str2);
          }
          this.context.startActivity((Intent)localObject2);
          return true;
          localObject2 = "";
          break;
          localObject2 = "";
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          continue;
        }
        localObject2 = new Intent(this.context, QQBrowserDelegationActivity.class).putExtra("url", localStringBuffer.toString());
        ((Intent)localObject2).putExtra("key_isReadModeEnabled", true);
        ((Intent)localObject2).putExtra("uin", this.app.getCurrentAccountUin());
        if ((str1 != null) && (!str1.equals(""))) {
          ((Intent)localObject2).putExtra("title", str1);
        }
        ((Intent)localObject2).putExtra("uin", this.app.getCurrentAccountUin());
        ((Intent)localObject2).putExtra("param_force_internal_browser", false);
        ((Intent)localObject2).putExtra("key_isReadModeEnabled", true);
        ((Intent)localObject2).putExtra("injectrecommend", true);
        this.context.startActivity((Intent)localObject2);
      }
    }
  }
  
  private boolean aEf()
  {
    ahlw.init();
    ahlw.Kj("KEY_STAGE_1_TOTAL");
    String str1 = (String)this.attrs.get("file_type");
    Object localObject = toBase64Decode((String)this.attrs.get("file_data"));
    String str2 = toBase64Decode((String)this.attrs.get("req_type"));
    String str3 = toBase64Decode((String)this.attrs.get("file_uri"));
    String str4 = toBase64Decode((String)this.attrs.get("third_sd"));
    long l = ForwardUtils.parseLong((String)this.attrs.get("share_id"));
    int i = ForwardUtils.parseInt(toBase64Decode((String)this.attrs.get("cflag")));
    boolean bool = ForwardUtils.aL(this.context);
    QLog.d("JumpAction", 1, new Object[] { "gotoShareMsgCheck appID:", Long.valueOf(l), ",file_type:", str1, ",reqType=", str2, ",third_sd=", str4, ",qq_sd=", Boolean.valueOf(bool), ",file_data=", localObject, ",file_uri=", str3 });
    if (i == 1)
    {
      rv("shareToQQ");
      return true;
    }
    if (l <= 0L)
    {
      QLog.d("JumpAction", 1, new Object[] { "gotoShareMsgCheck appid = ", Long.valueOf(l) });
      return false;
    }
    localObject = new HashMap(4);
    ((HashMap)localObject).put("KEY_SHARE_TYPE", str2);
    ((HashMap)localObject).put("KEY_FILE_TYPE", str1);
    ((HashMap)localObject).put("KEY_THIRD_SD", str4);
    ((HashMap)localObject).put("KEY_QQ_SD", String.valueOf(bool));
    if (!TextUtils.isEmpty(str3))
    {
      this.cUe = false;
      ThreadManagerV2.executeOnSubThread(new JumpAction.16(this, str3, System.currentTimeMillis(), (HashMap)localObject));
      return false;
    }
    ahlw.a("KEY_STAGE_1_SAVE_IMAGE", 0L, (HashMap)localObject, false);
    return aEg();
  }
  
  private boolean aEg()
  {
    String str3 = (String)this.attrs.get("file_type");
    String str4 = toBase64Decode((String)this.attrs.get("file_data"));
    String str5 = toBase64Decode((String)this.attrs.get("title"));
    String str6 = toBase64Decode((String)this.attrs.get("description"));
    String str7 = toBase64Decode((String)this.attrs.get("url"));
    String str8 = toBase64Decode((String)this.attrs.get("image_url"));
    String str9 = toBase64Decode((String)this.attrs.get("share_to_qq_ark_info"));
    String str10 = (String)this.attrs.get("chSrc");
    if (!TextUtils.isEmpty(this.pkgName)) {}
    label794:
    label1335:
    label1341:
    label1362:
    for (String str2 = toBase64Decode((String)this.attrs.get("app_name"));; str2 = null)
    {
      String str11 = toBase64Decode((String)this.attrs.get("audioUrl"));
      String str12 = toBase64Decode((String)this.attrs.get("open_id"));
      String str1 = toBase64Decode((String)this.attrs.get("req_type"));
      int j;
      String str13;
      String str14;
      String str15;
      int k;
      try
      {
        j = Integer.valueOf(str1).intValue();
        str13 = toBase64Decode((String)this.attrs.get("share_uin"));
        str14 = (String)this.attrs.get("jfrom");
        str15 = toBase64Decode((String)this.attrs.get("share_qq_ext_str"));
        k = ForwardUtils.parseInt(toBase64Decode((String)this.attrs.get("cflag")));
        if (k == 1)
        {
          rv("shareToQQ");
          return true;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.d("QQShare", 1, "NumberFormatException req_type = 1");
          j = 148;
        }
      }
      Object localObject1;
      long l;
      Object localObject2;
      Intent localIntent;
      Bundle localBundle;
      int i;
      if (j == 1)
      {
        localObject1 = "1";
        l = ForwardUtils.parseLong((String)this.attrs.get("share_id"));
        arts.a().a(this.app.getAccount(), str12, String.valueOf(l), "102", "80", "0", (String)localObject1, "0", "0", false, true);
        localObject2 = null;
        localIntent = null;
        localBundle = new Bundle();
        localBundle.putBoolean("is_ark_display_share", false);
        i = 0;
        if (!TextUtils.isEmpty(str9)) {
          localObject1 = localObject2;
        }
      }
      else
      {
        try
        {
          Object localObject3 = new JSONObject(str9);
          localObject1 = localObject2;
          String str16 = ((JSONObject)localObject3).optString("app");
          localObject1 = localObject2;
          String str17 = ((JSONObject)localObject3).optString("view");
          localObject1 = localObject2;
          String str18 = ((JSONObject)localObject3).optString("meta");
          localObject1 = localObject2;
          localObject3 = ((JSONObject)localObject3).optString("config");
          localObject1 = localObject2;
          if (TextUtils.isEmpty(str16)) {
            break label794;
          }
          localObject1 = localObject2;
          if (TextUtils.isEmpty(str17)) {
            break label794;
          }
          localObject1 = localObject2;
          if (TextUtils.isEmpty(str18)) {
            break label794;
          }
          localObject1 = localObject2;
          if (!a(this.context, str16, Long.valueOf(l))) {
            break label723;
          }
          localObject1 = localObject2;
          localBundle.putBoolean("is_ark_display_share", true);
          localObject1 = localObject2;
          localIntent = ArkFullScreenAppActivity.a(this.context, str17, str16, str18, (String)localObject3, String.valueOf(l), this.context.getResources().getDisplayMetrics().scaledDensity);
          localObject1 = localIntent;
          ArkAppCenter.r("JumpAction", "gotoShareArkMsg, ark appInfo is parse success");
          localObject1 = localIntent;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            label624:
            ArkAppCenter.r("JumpAction", String.format("gotoShareArkMsg, parse json failed, err=%s", new Object[] { localJSONException.getMessage() }));
            i = 1;
            continue;
            i = 1;
            localObject1 = localObject2;
            ArkAppCenter.r("JumpAction", "gotoShareArkMsg, appName or appView or appMeta is empty");
            localObject1 = localJSONException;
          }
        }
        if (i == 0) {
          break label1371;
        }
        localObject1 = new Intent();
        localBundle.putBoolean("is_ark_display_share", true);
        localBundle.putBoolean("forward_ark_from_sdk", true);
      }
      label723:
      label1364:
      label1371:
      for (;;)
      {
        if (l <= 0L)
        {
          QLog.d("StructMsg", 1, new Object[] { "gotoShareMsg appid = ", Long.valueOf(l) });
          return false;
          if (j == 5)
          {
            localObject1 = "2";
            break;
          }
          if (j == 2)
          {
            localObject1 = "3";
            break;
          }
          localObject1 = "4";
          break;
          i = 1;
          localObject1 = localObject2;
          ArkAppCenter.r("JumpAction", "gotoShareArkMsg, appInfo is not exist in white list and appID is " + l);
          localObject1 = localIntent;
          break label624;
          ArkAppCenter.r("JumpAction", "gotoShareArkMsg, appInfo is empty");
          localObject1 = null;
          i = 1;
          break label624;
        }
        if (("news".equals(str3)) || ("audio".equals(str3)))
        {
          localBundle.putString("title", str5);
          localBundle.putString("desc", str6);
          localBundle.putString("image_url", str4);
          localBundle.putString("detail_url", str7);
          localBundle.putString("chSrc", str10);
          localBundle.putInt("forward_type", 11);
          localBundle.putLong("req_share_id", l);
          localBundle.putString("pkg_name", this.pkgName);
          localBundle.putString("image_url_remote", str8);
          localBundle.putString("app_name", str2);
          localBundle.putString("open_id", str12);
          localBundle.putString("shareArkInfo", str9);
          localBundle.putString("chSrc", str10);
          if (str5 == null) {
            if (TextUtils.isEmpty(str2)) {
              break label1364;
            }
          }
        }
        for (;;)
        {
          localBundle.putString("brief_key", this.context.getString(2131698632, new Object[] { str2 }));
          localBundle.putString("share_uin", str13);
          localBundle.putString("jfrom", str14);
          localBundle.putString("share_qq_ext_str", str15);
          localBundle.putInt("cflag", k);
          localBundle.putInt("emoInputType", 2);
          if ((j == 5) && (ahlj.anP()))
          {
            localBundle.putBoolean("is_ark_display_share", true);
            localBundle.putBoolean("forward_ark_from_sdk", true);
          }
          if (j == 2) {
            localBundle.putString("audio_url", str11);
          }
          localBundle.putInt("req_type", j);
          localBundle.putBoolean("k_dataline", false);
          localBundle.putBoolean("k_favorites", true);
          localBundle.putBoolean("k_cancel_button", true);
          if (((k & 0x2) == 0) && (!"com.qzone".equals(this.pkgName)))
          {
            bool = true;
            localBundle.putBoolean("k_qzone", bool);
            if ((!bool) || ((k & 0x1) == 0)) {
              break label1335;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            localBundle.putBoolean("k_send", bool);
            localBundle.putInt("iUrlInfoFrm", 4);
            bool = aell.ahh();
            localBundle.putBoolean("enable_d55", bool);
            if (bool) {
              ((ahlc)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(350)).a().g(str12, l, this.pkgName);
            }
            if (localObject1 == null) {
              break label1362;
            }
            if (!MiniProgramOpenSdkUtil.isSharingMiniProgram(this.attrs)) {
              break label1341;
            }
            MiniProgramOpenSdkUtil.forwardShareWithTryCatch(this.context, this.attrs, localBundle, (Intent)localObject1);
            return true;
            localBundle.putString("brief_key", this.context.getString(2131698632, new Object[] { str5 }));
            break;
            bool = false;
            break label1172;
          }
          ((Intent)localObject1).putExtras(localBundle);
          com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.boN = true;
          ahgq.P(this.context, (Intent)localObject1);
          return true;
          str2 = "";
        }
      }
    }
  }
  
  private boolean aEh()
  {
    Object localObject = toBase64Decode((String)this.attrs.get("open_id"));
    String str1 = toBase64Decode((String)this.attrs.get("fopen_id"));
    String str2 = toBase64Decode((String)this.attrs.get("friend_label"));
    String str3 = toBase64Decode((String)this.attrs.get("add_msg"));
    String str4 = toBase64Decode((String)this.attrs.get("app_name"));
    String str5 = toBase64Decode((String)this.attrs.get("is_from_game"));
    long l;
    try
    {
      l = Long.valueOf((String)this.attrs.get("app_id")).longValue();
      if (l <= 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "gotoMakeFriend appid = " + l);
        }
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l = 0L;
      }
      AddFriendLogicActivity.aKF = (String)localObject;
      if (!"true".equals(str5)) {}
    }
    for (localObject = AddFriendLogicActivity.a((Activity)this.context, 3, str1, "" + l, 3090, 0, str2, str3, null, "", str4);; localObject = AddFriendLogicActivity.a((Activity)this.context, 3, str1, "" + l, 3016, 0, str2, str3, null, "", str4))
    {
      this.context.startActivity((Intent)localObject);
      return true;
    }
  }
  
  private boolean aEj()
  {
    Object localObject1 = (String)this.attrs.get("file_type");
    Object localObject9 = toBase64Decode((String)this.attrs.get("file_data"));
    Object localObject5 = toBase64Decode((String)this.attrs.get("title"));
    Object localObject7 = toBase64Decode((String)this.attrs.get("description"));
    toBase64Decode((String)this.attrs.get("previewimagedata"));
    Object localObject10 = toBase64Decode((String)this.attrs.get("url"));
    String str2 = toBase64Decode((String)this.attrs.get("image_url"));
    if (!TextUtils.isEmpty(this.pkgName)) {}
    for (localObject1 = toBase64Decode((String)this.attrs.get("app_name"));; localObject1 = null)
    {
      String str3 = toBase64Decode((String)this.attrs.get("audioUrl"));
      String str5 = toBase64Decode((String)this.attrs.get("open_id"));
      String str4 = toBase64Decode((String)this.attrs.get("req_type"));
      String str6 = toBase64Decode((String)this.attrs.get("share_uin"));
      String str7 = (String)this.attrs.get("jfrom");
      String str8 = toBase64Decode((String)this.attrs.get("share_qq_ext_str"));
      for (;;)
      {
        try
        {
          i = Integer.valueOf(toBase64Decode((String)this.attrs.get("cflag"))).intValue();
        }
        catch (Exception localException2)
        {
          try
          {
            l = Long.valueOf((String)this.attrs.get("share_id")).longValue();
            localObject8 = this.app;
            j = (int)l;
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              String str1 = "";
              if (!TextUtils.isEmpty(this.pkgName)) {
                continue;
              }
              localObject6 = "";
              avjg.a((AppRuntime)localObject8, "User_SdkShare", j, 0, 0, 0, str1, (String)localObject6);
              localObject8 = new Bundle();
              ((Bundle)localObject8).putString("title", (String)localObject5);
              ((Bundle)localObject8).putString("desc", (String)localObject7);
              ((Bundle)localObject8).putString("image_url", (String)localObject9);
              ((Bundle)localObject8).putString("detail_url", (String)localObject10);
              ((Bundle)localObject8).putLong("req_share_id", l);
              ((Bundle)localObject8).putString("pkg_name", this.pkgName);
              ((Bundle)localObject8).putString("image_url_remote", str2);
              ((Bundle)localObject8).putString("app_name", (String)localObject1);
              ((Bundle)localObject8).putString("open_id", str5);
              ((Bundle)localObject8).putString("share_uin", str6);
              ((Bundle)localObject8).putString("jfrom", str7);
              ((Bundle)localObject8).putString("share_qq_ext_str", str8);
              ((Bundle)localObject8).putInt("cflag", i);
              ((Bundle)localObject8).putInt("forward_type", 11);
              k = 1;
            }
          }
          catch (Exception localException2)
          {
            try
            {
              int i;
              long l;
              j = Integer.valueOf(str4).intValue();
              ((Bundle)localObject8).putInt("req_type", j);
              if (2 == j)
              {
                ((Bundle)localObject8).putString("audio_url", str3);
                if ((TextUtils.isEmpty((CharSequence)localObject5)) && (TextUtils.isEmpty((CharSequence)localObject7)))
                {
                  if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                    ((Bundle)localObject8).putString("title", String.format(this.context.getString(2131700276), new Object[] { localObject1 }));
                  }
                }
                else
                {
                  com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.boN = true;
                  localObject1 = new Intent(this.context, DirectForwardActivity.class);
                  ((Intent)localObject1).putExtra("toUin", acbn.bkI);
                  ((Intent)localObject1).putExtra("uinType", 0);
                  if (1 != i) {
                    break label1670;
                  }
                  ((Intent)localObject1).putExtra("qqfav_extra_from_system_share", true);
                  ((Intent)localObject1).putExtras((Bundle)localObject8);
                  ahgq.a(this.context, (Intent)localObject1, DirectForwardActivity.class);
                  return true;
                  localException1 = localException1;
                  if (QLog.isColorLevel()) {
                    QLog.e("qqfav", 2, "gotoQfavShareMsg|parse extflags exp: extflag=" + (String)this.attrs.get("cflag"));
                  }
                  i = 0;
                  continue;
                  localException2 = localException2;
                  if (QLog.isColorLevel()) {
                    QLog.e("qqfav", 2, "gotoQfavShareMsg|parse appid exp: appid=" + (String)this.attrs.get("share_id"));
                  }
                  l = 0L;
                  continue;
                  Object localObject2 = localObject1;
                  continue;
                  localObject6 = this.pkgName;
                }
              }
            }
            catch (NumberFormatException localNumberFormatException)
            {
              Object localObject8;
              Object localObject6;
              int k;
              int j = k;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("qqfav", 2, "gotoQfavShareMsg|parse reqtype exp: reqType=" + str4);
              j = k;
              continue;
              ((Bundle)localObject8).putString("title", this.context.getString(2131700277));
              continue;
              Object localObject3;
              if (6 == j)
              {
                ((Bundle)localObject8).putBoolean("key_sdk_share_pure_text", true);
                localObject1 = "";
                if (!TextUtils.isEmpty((CharSequence)localObject5)) {
                  localObject1 = localObject5;
                }
                localObject3 = localObject1;
                if (!TextUtils.isEmpty((CharSequence)localObject7))
                {
                  if (TextUtils.isEmpty((CharSequence)localObject1)) {
                    localObject3 = localObject7;
                  }
                }
                else
                {
                  ((Bundle)localObject8).putString("forward_text", (String)localObject3);
                  ((Bundle)localObject8).putString("qqfav_extra_richmedia_title", (String)localObject5);
                  ((Bundle)localObject8).putString("qqfav_extra_mixed_msg", (String)localObject7);
                  continue;
                }
                localObject3 = (String)localObject1 + "\n" + (String)localObject7;
                continue;
              }
              if (5 == j)
              {
                ((Bundle)localObject8).putBoolean("qqfav_extra_pic_share", true);
                ((Bundle)localObject8).putBoolean("qqfav_extra_only_pic", TextUtils.isEmpty((CharSequence)localObject7));
                ((Bundle)localObject8).putString("qqfav_extra_richmedia_title", (String)localObject5);
                ((Bundle)localObject8).putString("qqfav_extra_mixed_msg", (String)localObject7);
                ((Bundle)localObject8).putString("desc", "");
                localObject6 = localObject5;
                if (TextUtils.isEmpty((CharSequence)localObject5))
                {
                  localObject6 = localObject5;
                  if (!TextUtils.isEmpty((CharSequence)localObject7))
                  {
                    localObject6 = ((String)localObject7).replace("\024", "");
                    ((Bundle)localObject8).putString("title", (String)localObject6);
                  }
                }
                localObject3 = null;
                localObject1 = null;
                localObject10 = new ArrayList();
                Object localObject4;
                if (!TextUtils.isEmpty((CharSequence)localObject9))
                {
                  localObject9 = ((String)localObject9).split(";");
                  j = 0;
                  localObject5 = null;
                  localObject7 = localObject5;
                  localObject3 = localObject1;
                  if (j < localObject9.length)
                  {
                    localObject7 = "";
                    try
                    {
                      localObject3 = URLDecoder.decode(localObject9[j], "UTF-8");
                      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                        if ((((String)localObject3).startsWith("/")) && (new File((String)localObject3).exists()))
                        {
                          ((ArrayList)localObject10).add(localObject3);
                          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                            continue;
                          }
                          j += 1;
                          localObject1 = localObject3;
                        }
                      }
                    }
                    catch (UnsupportedEncodingException localUnsupportedEncodingException)
                    {
                      localObject4 = localObject7;
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.e("qqfav", 2, "gotoQfavShareMsg|decode exp. imageUrls[i]=" + localObject9[j]);
                      localObject4 = localObject7;
                      continue;
                      if (localObject4.startsWith("http"))
                      {
                        ((ArrayList)localObject10).add(localObject4);
                        if (TextUtils.isEmpty((CharSequence)localObject5))
                        {
                          localObject5 = localObject4;
                          localObject4 = localObject1;
                          continue;
                          if (QLog.isColorLevel()) {
                            QLog.e("qqfav", 2, "gotoQfavShareMsg|file path invalid. path=" + localObject4);
                          }
                        }
                      }
                      localObject4 = localObject1;
                      continue;
                    }
                  }
                }
                else
                {
                  localObject7 = null;
                }
                if (((ArrayList)localObject10).isEmpty())
                {
                  avjj.z(this.context, 2131700274, 1);
                  if (QLog.isColorLevel()) {
                    QLog.e("qqfav", 2, "gotoQfavShareMsg|image type.no image path");
                  }
                  return false;
                }
                ((Bundle)localObject8).putString("image_url", localObject4);
                ((Bundle)localObject8).putString("image_url_remote", (String)localObject7);
                ((Bundle)localObject8).putStringArrayList("qqfav_extra_multi_pic_path_list", (ArrayList)localObject10);
                if (1 == ((ArrayList)localObject10).size())
                {
                  if (TextUtils.isEmpty((CharSequence)localObject6))
                  {
                    ((Bundle)localObject8).putInt("req_type", 5);
                    if ((!TextUtils.isEmpty(localObject4)) || (TextUtils.isEmpty((CharSequence)localObject7))) {
                      continue;
                    }
                    ((Bundle)localObject8).putString("image_url", (String)localObject7);
                    continue;
                  }
                  ((Bundle)localObject8).putInt("req_type", 1);
                  continue;
                }
                if (TextUtils.isEmpty((CharSequence)localObject6)) {
                  ((Bundle)localObject8).putString("title", ((ArrayList)localObject10).size() + this.context.getString(2131696504));
                }
                ((Bundle)localObject8).putBoolean("qqfav_extra_multi_pic", true);
                ((Bundle)localObject8).putInt("req_type", 1);
                continue;
              }
              if (1 == j)
              {
                if ((TextUtils.isEmpty((CharSequence)localObject5)) && (TextUtils.isEmpty((CharSequence)localObject7)))
                {
                  if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                    ((Bundle)localObject8).putString("title", String.format(this.context.getString(2131700276), new Object[] { localObject1 }));
                  }
                }
                else
                {
                  if ((!TextUtils.isEmpty((CharSequence)localObject10)) || (!QLog.isColorLevel())) {
                    continue;
                  }
                  QLog.i("qqfav", 2, "gotoQfavShareMsg|link type. no detail url");
                  continue;
                }
                ((Bundle)localObject8).putString("title", this.context.getString(2131700277));
                continue;
              }
              avjj.z(this.context, 2131700274, 1);
              if (QLog.isColorLevel()) {
                QLog.e("qqfav", 2, "gotoQfavShareMsg|unknown reqType. reqType=" + j);
              }
              return false;
            }
          }
        }
        label1670:
        ((Intent)localObject1).putExtra("qqfav_extra_from_sdk_share", true);
      }
    }
  }
  
  private boolean aEk()
  {
    Intent localIntent = new Intent(this.context, JoinDiscussionActivity.class);
    String str = (String)this.attrs.get("sig");
    localIntent.putExtra("sig", str);
    if (TextUtils.isEmpty(str)) {
      localIntent.putExtra("innerSig", (String)this.attrs.get("k"));
    }
    this.context.startActivity(localIntent);
    return true;
  }
  
  private boolean aEl()
  {
    Intent localIntent = new Intent(this.context, AgentActivity.class);
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.attrs.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localBundle.putString(str, (String)this.attrs.get(str));
    }
    localIntent.putExtra("key_params", localBundle);
    localIntent.putExtra("key_action", "action_ptlogin_login");
    this.context.startActivity(localIntent);
    return true;
  }
  
  private boolean aEm()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoMultiVoiceChat");
    }
    String str1 = (String)this.attrs.get("src_type");
    String str2 = (String)this.attrs.get("version");
    String str3 = (String)this.attrs.get("chat_type");
    Object localObject = (String)this.attrs.get("relation_id");
    String str4 = (String)this.attrs.get("request_type");
    String str5 = (String)this.attrs.get("actid");
    String str6 = (String)this.attrs.get("mp_ext_params");
    HashMap localHashMap = new HashMap();
    if ((str4 != null) && (str4.equals("video"))) {
      localHashMap.put("isVideo", "true");
    }
    if (str6 != null)
    {
      localHashMap.put("mp_ext_params", str6);
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "gotoMultiVoiceChat mp_ext_params : " + str6);
      }
    }
    if ((str5 != null) && (str4 != null))
    {
      localHashMap.put("actid", str5);
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "gotoMultiVoiceChat actId : " + str5);
      }
    }
    if ((str1 != null) && (str1.equals("web")) && (str2 != null) && (str2.equals("1")) && (localObject != null) && (str3 != null))
    {
      if (str3.equals("discussgroup")) {
        if (((String)localObject).equals("0"))
        {
          localObject = new Intent(this.context, SelectMemberActivity.class);
          ((Intent)localObject).putExtra("param_type", 3000);
          ((Intent)localObject).putExtra("param_subtype", 0);
          ((Intent)localObject).putExtra("param_from", 1003);
          ((Intent)localObject).putExtra("param_title", this.context.getString(2131692293));
          ((Intent)localObject).putExtra("param_done_button_wording", this.context.getString(2131692643));
          ((Intent)localObject).putExtra("param_done_button_highlight_wording", this.context.getString(2131692644));
          ((Intent)localObject).putExtra("param_max", 99);
          ((Intent)localObject).setFlags(603979776);
          ((BaseActivity)this.context).startActivityForResult((Intent)localObject, 1);
        }
      }
      do
      {
        return true;
        return ChatActivityUtils.a(this.app, (BaseActivity)this.context, 3000, (String)localObject, true, true, this.e, localHashMap);
        if (str3.equals("single"))
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("forward_type", 13);
          ((Intent)localObject).putExtra("fromWebXman", true);
          ahgq.f((BaseActivity)this.context, (Intent)localObject, 2);
          return true;
        }
        if (!str3.equals("group")) {
          break;
        }
      } while (((String)localObject).equals("0"));
      str1 = (String)this.attrs.get("jump_from");
      if ((!"gvideo".equals(str1)) && (!"gvideo_h5".equals(str1))) {
        break label623;
      }
    }
    label623:
    for (boolean bool = false;; bool = true)
    {
      return ChatActivityUtils.a(this.app, (BaseActivity)this.context, 1, (String)localObject, true, bool, this.e, this.attrs);
      return false;
    }
  }
  
  private boolean aEn()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoVideoChat");
    }
    Object localObject2 = (String)this.attrs.get("request_type");
    if ((localObject2 != null) && ("forward_to_tab".equals(localObject2)))
    {
      localObject1 = new Intent(this.context, SplashActivity.class);
      ((Intent)localObject1).putExtra("tab_index", MainFragment.bIk);
      ((Intent)localObject1).putExtra("conversation_index", 1);
      ((Intent)localObject1).setFlags(335544320);
      this.context.startActivity((Intent)localObject1);
      return true;
    }
    Object localObject3 = (String)this.attrs.get("src_type");
    String str3 = (String)this.attrs.get("version");
    String str2 = (String)this.attrs.get("uinType");
    Object localObject1 = (String)this.attrs.get("uin");
    Object localObject5 = (String)this.attrs.get("phone");
    String str1 = (String)this.attrs.get("extraUin");
    String str4 = (String)this.attrs.get("actid");
    String str5 = (String)this.attrs.get("mp_ext_params");
    if ((str4 != null) && (localObject2 != null) && (((String)localObject2).equals("audio")) && (QLog.isColorLevel())) {
      QLog.d("JumpAction", 2, "gotoVideoChat actId : " + str4);
    }
    if ((str5 != null) && (QLog.isColorLevel())) {
      QLog.d("JumpAction", 2, "gotoVideoChat mp_ext_params : " + str5);
    }
    for (;;)
    {
      try
      {
        i = Integer.parseInt(str3);
        if ((localObject3 == null) || (!((String)localObject3).equals("web")) || (i <= 0)) {}
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int i;
        int j;
        try
        {
          i = Integer.valueOf(str2).intValue();
          i = VideoController.a(i, false, 1);
          if ((localObject2 == null) || (!((String)localObject2).equals("audio"))) {
            break label764;
          }
          bool1 = true;
          if (i == 1006)
          {
            localObject2 = localObject5;
            if (!((String)localObject5).startsWith("+")) {
              localObject2 = "+" + (String)localObject5;
            }
            localObject3 = ((ajdo)this.app.getManager(11)).c((String)localObject2);
            if (localObject3 != null)
            {
              localObject3 = ((PhoneContact)localObject3).name;
              localObject5 = localObject1;
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                localObject5 = localObject2;
              }
              bool2 = true;
              localObject1 = localObject3;
              localObject3 = localObject2;
              localObject2 = localObject5;
              return ChatActivityUtils.a(this.app, this.context, i, (String)localObject2, (String)localObject1, (String)localObject3, bool1, str1, bool2, true, this.e, "from_internal", this.attrs);
              localNumberFormatException = localNumberFormatException;
              i = 0;
            }
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "gotoVideoChat", localException);
          }
          i = 0;
          continue;
          localObject4 = localObject2;
          continue;
          if (i == 1011)
          {
            localObject4 = (String)this.attrs.get("nickName");
            if (!TextUtils.isEmpty((CharSequence)localObject4))
            {
              localObject2 = localObject4;
              if (!((String)localObject1).equals(localObject4)) {}
            }
            else
            {
              localObject2 = this.context.getResources().getString(2131697961);
            }
            bool1 = true;
            bool2 = false;
            localObject4 = localObject2;
            localObject2 = localObject1;
            localObject1 = localObject4;
            localObject4 = localObject5;
            continue;
          }
          j = aqgv.jZ(i);
          if (j != -1) {
            continue;
          }
        }
        localObject4 = aqgv.e(this.app, (String)localObject1, i);
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject2 = localObject4;
          if (!((String)localObject1).equals(localObject4)) {}
        }
        else
        {
          localObject2 = aqgv.b(this.app, (String)localObject1, true);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label742;
        }
        bool2 = true;
        localObject2 = localObject1;
        localObject4 = localObject5;
        continue;
        localObject4 = aqgv.a(this.app, (String)localObject1, str1, j, 0);
        continue;
      }
      return false;
      label742:
      boolean bool2 = true;
      Object localObject4 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject4;
      localObject4 = localObject5;
      continue;
      label764:
      boolean bool1 = false;
    }
  }
  
  private boolean aEo()
  {
    boolean bool3 = false;
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoRandomVideoChat");
    }
    String str1 = (String)this.attrs.get("chat_type");
    str1 = (String)this.attrs.get("src_type");
    String str2 = (String)this.attrs.get("request_type");
    String str3 = (String)this.attrs.get("version");
    String str4 = toBase64Decode((String)this.attrs.get("session_name"));
    this.attrs.put("session_name", str4);
    boolean bool1;
    if ((str2 != null) && (str2.equals("audio"))) {
      bool1 = true;
    }
    try
    {
      for (;;)
      {
        i = Integer.parseInt(str3);
        boolean bool2 = bool3;
        if (str1 != null)
        {
          bool2 = bool3;
          if (str1.equals("web"))
          {
            bool2 = bool3;
            if (i > 0) {
              bool2 = ChatActivityUtils.a(this.app, this.context, 1011, null, null, null, bool1, null, false, true, this.e, "from_internal", this.attrs);
            }
          }
        }
        return bool2;
        bool1 = false;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int i = 0;
      }
    }
  }
  
  private boolean aEp()
  {
    if (this.ctj.equals("jump"))
    {
      String str = (String)this.attrs.get("options");
      Intent localIntent = new Intent(this.context, VipComicJumpActivity.class);
      localIntent.putExtra("options", str);
      this.context.startActivity(localIntent);
      return true;
    }
    return false;
  }
  
  /* Error */
  private boolean aEq()
  {
    // Byte code:
    //   0: new 126	android/content/Intent
    //   3: dup
    //   4: ldc_w 2005
    //   7: invokespecial 1946	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   10: astore 14
    //   12: aload_0
    //   13: aload 14
    //   15: invokespecial 819	aqhv:dO	(Landroid/content/Intent;)V
    //   18: aconst_null
    //   19: astore 9
    //   21: aconst_null
    //   22: astore 8
    //   24: aconst_null
    //   25: astore 10
    //   27: aload_0
    //   28: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   31: invokevirtual 2643	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   34: astore 12
    //   36: iconst_0
    //   37: istore_1
    //   38: ldc 83
    //   40: astore 11
    //   42: aload_0
    //   43: ldc_w 3260
    //   46: invokevirtual 1105	aqhv:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   49: astore 13
    //   51: aload 13
    //   53: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifne +14 -> 70
    //   59: aload 14
    //   61: ldc_w 3408
    //   64: aload 13
    //   66: invokevirtual 619	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   69: pop
    //   70: aload_0
    //   71: ldc_w 3864
    //   74: invokevirtual 1105	aqhv:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   77: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   80: ifne +62 -> 142
    //   83: aload 14
    //   85: ldc_w 3323
    //   88: invokestatic 3326	java/lang/System:nanoTime	()J
    //   91: invokevirtual 634	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   94: pop
    //   95: aload 14
    //   97: ldc_w 682
    //   100: invokestatic 631	java/lang/System:currentTimeMillis	()J
    //   103: invokevirtual 634	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   106: pop
    //   107: aload 14
    //   109: ldc_w 626
    //   112: invokestatic 631	java/lang/System:currentTimeMillis	()J
    //   115: invokevirtual 634	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   118: pop
    //   119: aload 14
    //   121: ldc_w 3332
    //   124: iconst_1
    //   125: invokevirtual 137	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   128: pop
    //   129: aload 14
    //   131: ldc_w 3330
    //   134: aload_0
    //   135: getfield 696	aqhv:dw	Z
    //   138: invokevirtual 137	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   141: pop
    //   142: aload 12
    //   144: invokeinterface 2022 1 0
    //   149: astore 15
    //   151: aload 15
    //   153: invokeinterface 2027 1 0
    //   158: ifeq +630 -> 788
    //   161: aload 15
    //   163: invokeinterface 2031 1 0
    //   168: checkcast 2645	java/util/Map$Entry
    //   171: astore 12
    //   173: aload 12
    //   175: invokeinterface 2651 1 0
    //   180: checkcast 72	java/lang/String
    //   183: astore 13
    //   185: aload 12
    //   187: invokeinterface 2648 1 0
    //   192: checkcast 72	java/lang/String
    //   195: astore 12
    //   197: aload 13
    //   199: ifnull -48 -> 151
    //   202: aload 12
    //   204: ifnull -53 -> 151
    //   207: ldc_w 3866
    //   210: aload 13
    //   212: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   215: ifeq +26 -> 241
    //   218: aload 8
    //   220: astore 13
    //   222: aload 11
    //   224: astore 8
    //   226: aload 10
    //   228: astore 9
    //   230: aload 13
    //   232: astore 10
    //   234: aload 12
    //   236: astore 11
    //   238: goto +2753 -> 2991
    //   241: ldc_w 3868
    //   244: aload 13
    //   246: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   249: ifeq +22 -> 271
    //   252: aload 11
    //   254: astore 8
    //   256: aload 9
    //   258: astore 11
    //   260: aload 10
    //   262: astore 9
    //   264: aload 12
    //   266: astore 10
    //   268: goto +2723 -> 2991
    //   271: ldc_w 3870
    //   274: aload 13
    //   276: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   279: ifeq +57 -> 336
    //   282: ldc_w 405
    //   285: aload 12
    //   287: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   290: ifeq +2728 -> 3018
    //   293: aload 14
    //   295: ldc_w 2007
    //   298: aload_0
    //   299: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   302: invokevirtual 731	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   305: invokevirtual 619	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   308: pop
    //   309: aload 8
    //   311: astore 12
    //   313: aload 9
    //   315: astore 13
    //   317: aload 11
    //   319: astore 8
    //   321: aload 10
    //   323: astore 9
    //   325: aload 12
    //   327: astore 10
    //   329: aload 13
    //   331: astore 11
    //   333: goto +2658 -> 2991
    //   336: ldc_w 3872
    //   339: aload 13
    //   341: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   344: ifeq +89 -> 433
    //   347: ldc_w 405
    //   350: aload 12
    //   352: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   355: ifeq +2663 -> 3018
    //   358: aload_0
    //   359: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   362: invokevirtual 2010	com/tencent/mobileqq/app/QQAppInterface:getCurrentNickname	()Ljava/lang/String;
    //   365: astore 13
    //   367: aload 13
    //   369: astore 12
    //   371: aload 13
    //   373: invokestatic 3079	aqmr:isEmpty	(Ljava/lang/String;)Z
    //   376: ifeq +19 -> 395
    //   379: aload_0
    //   380: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   383: aload_0
    //   384: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   387: invokevirtual 731	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   390: invokestatic 2012	aqgv:n	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   393: astore 12
    //   395: aload 14
    //   397: ldc_w 1941
    //   400: aload 12
    //   402: invokevirtual 619	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   405: pop
    //   406: aload 8
    //   408: astore 12
    //   410: aload 9
    //   412: astore 13
    //   414: aload 11
    //   416: astore 8
    //   418: aload 10
    //   420: astore 9
    //   422: aload 12
    //   424: astore 10
    //   426: aload 13
    //   428: astore 11
    //   430: goto +2561 -> 2991
    //   433: ldc_w 3213
    //   436: aload 13
    //   438: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   441: ifeq +57 -> 498
    //   444: ldc_w 405
    //   447: aload 12
    //   449: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   452: ifeq +2566 -> 3018
    //   455: aload 14
    //   457: ldc_w 3874
    //   460: aload_0
    //   461: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   464: invokevirtual 3252	com/tencent/mobileqq/app/QQAppInterface:rK	()Ljava/lang/String;
    //   467: invokevirtual 619	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   470: pop
    //   471: aload 8
    //   473: astore 12
    //   475: aload 9
    //   477: astore 13
    //   479: aload 11
    //   481: astore 8
    //   483: aload 10
    //   485: astore 9
    //   487: aload 12
    //   489: astore 10
    //   491: aload 13
    //   493: astore 11
    //   495: goto +2496 -> 2991
    //   498: ldc_w 3876
    //   501: aload 13
    //   503: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   506: ifeq +53 -> 559
    //   509: ldc_w 405
    //   512: aload 12
    //   514: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   517: ifeq +2501 -> 3018
    //   520: aload 14
    //   522: ldc_w 3878
    //   525: invokestatic 631	java/lang/System:currentTimeMillis	()J
    //   528: invokevirtual 634	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   531: pop
    //   532: aload 8
    //   534: astore 12
    //   536: aload 9
    //   538: astore 13
    //   540: aload 11
    //   542: astore 8
    //   544: aload 10
    //   546: astore 9
    //   548: aload 12
    //   550: astore 10
    //   552: aload 13
    //   554: astore 11
    //   556: goto +2435 -> 2991
    //   559: ldc_w 3880
    //   562: aload 13
    //   564: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   567: ifeq +90 -> 657
    //   570: ldc_w 405
    //   573: aload 12
    //   575: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   578: ifeq +2440 -> 3018
    //   581: aload 14
    //   583: ldc_w 3882
    //   586: aload_0
    //   587: getfield 3884	aqhv:cUc	Z
    //   590: invokevirtual 137	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   593: pop
    //   594: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   597: ifeq +2421 -> 3018
    //   600: ldc_w 3886
    //   603: iconst_2
    //   604: new 152	java/lang/StringBuilder
    //   607: dup
    //   608: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   611: ldc_w 3888
    //   614: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: aload_0
    //   618: getfield 3884	aqhv:cUc	Z
    //   621: invokevirtual 2620	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   624: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   630: aload 8
    //   632: astore 12
    //   634: aload 9
    //   636: astore 13
    //   638: aload 11
    //   640: astore 8
    //   642: aload 10
    //   644: astore 9
    //   646: aload 12
    //   648: astore 10
    //   650: aload 13
    //   652: astore 11
    //   654: goto +2337 -> 2991
    //   657: ldc_w 3890
    //   660: aload 13
    //   662: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   665: ifeq +39 -> 704
    //   668: ldc_w 405
    //   671: aload 12
    //   673: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   676: ifeq +2342 -> 3018
    //   679: iconst_1
    //   680: istore_1
    //   681: aload 8
    //   683: astore 12
    //   685: aload 11
    //   687: astore 8
    //   689: aload 9
    //   691: astore 11
    //   693: aload 10
    //   695: astore 9
    //   697: aload 12
    //   699: astore 10
    //   701: goto +2290 -> 2991
    //   704: ldc_w 3892
    //   707: aload 13
    //   709: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   712: ifeq +30 -> 742
    //   715: aload 8
    //   717: astore 11
    //   719: aload 9
    //   721: astore 13
    //   723: aload 12
    //   725: astore 8
    //   727: aload 10
    //   729: astore 9
    //   731: aload 11
    //   733: astore 10
    //   735: aload 13
    //   737: astore 11
    //   739: goto +2252 -> 2991
    //   742: ldc 169
    //   744: aload 13
    //   746: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   749: ifeq +26 -> 775
    //   752: aload 9
    //   754: astore 13
    //   756: aload 8
    //   758: astore 10
    //   760: aload 11
    //   762: astore 8
    //   764: aload 12
    //   766: astore 9
    //   768: aload 13
    //   770: astore 11
    //   772: goto +2219 -> 2991
    //   775: aload 14
    //   777: aload 13
    //   779: aload 12
    //   781: invokevirtual 619	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   784: pop
    //   785: goto +2233 -> 3018
    //   788: aload 9
    //   790: ifnull +2255 -> 3045
    //   793: aload 8
    //   795: ifnull +2250 -> 3045
    //   798: ldc 83
    //   800: aload 9
    //   802: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   805: ifne +2240 -> 3045
    //   808: ldc 83
    //   810: aload 8
    //   812: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   815: ifeq +6 -> 821
    //   818: goto +2227 -> 3045
    //   821: aload_0
    //   822: getfield 3894	aqhv:cUa	Z
    //   825: ifeq +22 -> 847
    //   828: invokestatic 3899	aqii:a	()Laqii;
    //   831: aload_0
    //   832: getfield 115	aqhv:context	Landroid/content/Context;
    //   835: aload 9
    //   837: aload 8
    //   839: invokevirtual 3903	aqii:q	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   842: ifeq +5 -> 847
    //   845: iconst_0
    //   846: ireturn
    //   847: iconst_0
    //   848: istore 4
    //   850: iload 4
    //   852: istore_3
    //   853: aload 9
    //   855: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   858: ifne +38 -> 896
    //   861: getstatic 76	aqhv:hS	[Ljava/lang/String;
    //   864: astore 12
    //   866: aload 12
    //   868: arraylength
    //   869: istore 5
    //   871: iconst_0
    //   872: istore_2
    //   873: iload 4
    //   875: istore_3
    //   876: iload_2
    //   877: iload 5
    //   879: if_icmpge +17 -> 896
    //   882: aload 9
    //   884: aload 12
    //   886: iload_2
    //   887: aaload
    //   888: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   891: ifeq +234 -> 1125
    //   894: iconst_1
    //   895: istore_3
    //   896: iload_3
    //   897: ifne +55 -> 952
    //   900: aload 14
    //   902: ldc_w 3874
    //   905: aconst_null
    //   906: checkcast 72	java/lang/String
    //   909: invokevirtual 619	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   912: pop
    //   913: aload 14
    //   915: ldc_w 3905
    //   918: aconst_null
    //   919: checkcast 72	java/lang/String
    //   922: invokevirtual 619	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   925: pop
    //   926: aload 14
    //   928: ldc_w 1941
    //   931: aconst_null
    //   932: checkcast 72	java/lang/String
    //   935: invokevirtual 619	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   938: pop
    //   939: aload 14
    //   941: ldc_w 2007
    //   944: aconst_null
    //   945: checkcast 72	java/lang/String
    //   948: invokevirtual 619	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   951: pop
    //   952: aload 8
    //   954: ldc_w 3572
    //   957: invokevirtual 1285	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   960: ifeq +112 -> 1072
    //   963: aload 14
    //   965: ldc_w 3907
    //   968: ldc_w 3909
    //   971: invokevirtual 619	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   974: pop
    //   975: aload_0
    //   976: getfield 85	aqhv:ctl	Ljava/lang/String;
    //   979: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   982: ifne +16 -> 998
    //   985: aload 14
    //   987: ldc_w 3911
    //   990: aload_0
    //   991: getfield 85	aqhv:ctl	Ljava/lang/String;
    //   994: invokevirtual 619	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   997: pop
    //   998: aload_0
    //   999: getfield 87	aqhv:feedTime	Ljava/lang/String;
    //   1002: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1005: ifne +16 -> 1021
    //   1008: aload 14
    //   1010: ldc_w 3913
    //   1013: aload_0
    //   1014: getfield 87	aqhv:feedTime	Ljava/lang/String;
    //   1017: invokevirtual 619	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1020: pop
    //   1021: aload_0
    //   1022: getfield 89	aqhv:ctm	Ljava/lang/String;
    //   1025: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1028: ifne +16 -> 1044
    //   1031: aload 14
    //   1033: ldc_w 3915
    //   1036: aload_0
    //   1037: getfield 89	aqhv:ctm	Ljava/lang/String;
    //   1040: invokevirtual 619	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1043: pop
    //   1044: aload 14
    //   1046: ldc_w 3917
    //   1049: aload_0
    //   1050: getfield 3919	aqhv:cUd	Z
    //   1053: invokevirtual 137	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1056: pop
    //   1057: aload 14
    //   1059: aload 8
    //   1061: invokestatic 3925	cooperation/qzone/report/lp/QZoneLoginReportHelper:needAddLoginFromLebaTab	(Landroid/content/Intent;Ljava/lang/String;)Z
    //   1064: ifeq +8 -> 1072
    //   1067: aload 14
    //   1069: invokestatic 3928	cooperation/qzone/report/lp/QZoneLoginReportHelper:setLoginFromLebaTab	(Landroid/content/Intent;)V
    //   1072: iload_1
    //   1073: ifne +1874 -> 2947
    //   1076: aload 8
    //   1078: ldc_w 3572
    //   1081: invokevirtual 1285	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1084: ifeq +103 -> 1187
    //   1087: aload 14
    //   1089: aload 8
    //   1091: invokestatic 3933	cooperation/qzone/QzonePluginProxyActivity:x	(Landroid/content/Intent;Ljava/lang/String;)V
    //   1094: aload 14
    //   1096: ldc_w 2634
    //   1099: invokevirtual 142	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1102: pop
    //   1103: aload_0
    //   1104: getfield 115	aqhv:context	Landroid/content/Context;
    //   1107: checkcast 200	android/app/Activity
    //   1110: aload_0
    //   1111: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1114: invokevirtual 731	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1117: aload 14
    //   1119: iconst_m1
    //   1120: invokestatic 3936	cooperation/qzone/QzonePluginProxyActivity:a	(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;I)V
    //   1123: iconst_1
    //   1124: ireturn
    //   1125: iload_2
    //   1126: iconst_1
    //   1127: iadd
    //   1128: istore_2
    //   1129: goto -256 -> 873
    //   1132: astore 8
    //   1134: new 126	android/content/Intent
    //   1137: dup
    //   1138: aload_0
    //   1139: getfield 115	aqhv:context	Landroid/content/Context;
    //   1142: ldc_w 3938
    //   1145: invokespecial 131	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1148: astore 8
    //   1150: aload 8
    //   1152: ldc 143
    //   1154: invokevirtual 142	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1157: pop
    //   1158: aload 8
    //   1160: aload 14
    //   1162: invokevirtual 3941	android/content/Intent:putExtras	(Landroid/content/Intent;)Landroid/content/Intent;
    //   1165: pop
    //   1166: aload_0
    //   1167: getfield 115	aqhv:context	Landroid/content/Context;
    //   1170: aload 8
    //   1172: invokevirtual 544	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1175: goto -52 -> 1123
    //   1178: astore 8
    //   1180: aload 8
    //   1182: invokevirtual 3942	android/content/ActivityNotFoundException:printStackTrace	()V
    //   1185: iconst_0
    //   1186: ireturn
    //   1187: aload 8
    //   1189: ldc_w 3944
    //   1192: invokevirtual 3314	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1195: ifeq +60 -> 1255
    //   1198: aload_0
    //   1199: getfield 115	aqhv:context	Landroid/content/Context;
    //   1202: aload_0
    //   1203: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1206: invokestatic 1993	aozz:b	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)V
    //   1209: aload_0
    //   1210: getfield 696	aqhv:dw	Z
    //   1213: ifeq +1834 -> 3047
    //   1216: ldc_w 422
    //   1219: astore 8
    //   1221: aload_0
    //   1222: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1225: ldc_w 1385
    //   1228: ldc_w 3946
    //   1231: ldc 83
    //   1233: ldc_w 3948
    //   1236: ldc_w 3950
    //   1239: iconst_0
    //   1240: iconst_0
    //   1241: ldc 83
    //   1243: ldc 83
    //   1245: ldc 83
    //   1247: aload 8
    //   1249: invokestatic 569	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1252: goto -129 -> 1123
    //   1255: aload 8
    //   1257: ldc_w 3952
    //   1260: invokevirtual 3314	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1263: istore 6
    //   1265: iload 6
    //   1267: ifeq +233 -> 1500
    //   1270: aload_0
    //   1271: getfield 115	aqhv:context	Landroid/content/Context;
    //   1274: checkcast 3954	android/support/v4/app/FragmentActivity
    //   1277: invokevirtual 3958	android/support/v4/app/FragmentActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   1280: astore 9
    //   1282: aload 9
    //   1284: ifnull -161 -> 1123
    //   1287: aload 9
    //   1289: invokevirtual 3963	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   1292: ifnull -169 -> 1123
    //   1295: aload 9
    //   1297: invokevirtual 3963	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   1300: invokevirtual 3968	com/tencent/mobileqq/activity/BaseChatPie:bIs	()V
    //   1303: aload 9
    //   1305: invokevirtual 3963	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   1308: getfield 3972	com/tencent/mobileqq/activity/BaseChatPie:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   1311: getfield 3977	com/tencent/mobileqq/activity/aio/SessionInfo:cZ	I
    //   1314: istore_1
    //   1315: aload 14
    //   1317: ldc_w 847
    //   1320: aload_0
    //   1321: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1324: invokevirtual 731	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1327: invokevirtual 619	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1330: pop
    //   1331: aload 14
    //   1333: ldc_w 3979
    //   1336: iload_1
    //   1337: invokevirtual 148	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1340: pop
    //   1341: aload 14
    //   1343: ldc_w 1978
    //   1346: invokevirtual 2803	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1349: astore 11
    //   1351: aload 14
    //   1353: ldc_w 1976
    //   1356: invokevirtual 2803	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1359: astore 10
    //   1361: aload 14
    //   1363: ldc_w 3981
    //   1366: invokevirtual 2803	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1369: astore 9
    //   1371: aload 11
    //   1373: ifnull +79 -> 1452
    //   1376: aload 10
    //   1378: ifnull +74 -> 1452
    //   1381: aload 11
    //   1383: invokestatic 3986	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   1386: astore 11
    //   1388: aload 10
    //   1390: invokestatic 3986	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   1393: astore 10
    //   1395: aload 14
    //   1397: ldc 245
    //   1399: new 152	java/lang/StringBuilder
    //   1402: dup
    //   1403: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1406: ldc_w 3988
    //   1409: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1412: aload 11
    //   1414: invokevirtual 2608	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1417: ldc_w 2049
    //   1420: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1423: aload 10
    //   1425: invokevirtual 2608	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1428: ldc_w 3990
    //   1431: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1434: aload 9
    //   1436: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1439: ldc_w 3992
    //   1442: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1445: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1448: invokevirtual 619	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1451: pop
    //   1452: aload 14
    //   1454: aload_0
    //   1455: getfield 115	aqhv:context	Landroid/content/Context;
    //   1458: invokevirtual 3995	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1461: aload 8
    //   1463: invokevirtual 622	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1466: pop
    //   1467: aload_0
    //   1468: getfield 115	aqhv:context	Landroid/content/Context;
    //   1471: checkcast 546	com/tencent/mobileqq/app/BaseActivity
    //   1474: aload 14
    //   1476: bipush 18
    //   1478: invokevirtual 3781	com/tencent/mobileqq/app/BaseActivity:startActivityForResult	(Landroid/content/Intent;I)V
    //   1481: ldc_w 3997
    //   1484: invokestatic 4001	swb:report	(Ljava/lang/String;)V
    //   1487: goto -364 -> 1123
    //   1490: astore 8
    //   1492: aload 8
    //   1494: invokevirtual 827	java/lang/Exception:printStackTrace	()V
    //   1497: goto -374 -> 1123
    //   1500: aload 8
    //   1502: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1505: ifne +287 -> 1792
    //   1508: aload 9
    //   1510: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1513: ifne +279 -> 1792
    //   1516: aload 8
    //   1518: ldc_w 4003
    //   1521: invokevirtual 1297	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1524: ifeq +268 -> 1792
    //   1527: aload 9
    //   1529: ldc 74
    //   1531: invokevirtual 1297	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1534: ifeq +258 -> 1792
    //   1537: new 2712	java/lang/StringBuffer
    //   1540: dup
    //   1541: invokespecial 2713	java/lang/StringBuffer:<init>	()V
    //   1544: astore 12
    //   1546: aload_0
    //   1547: getfield 694	aqhv:c	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1550: ifnull +230 -> 1780
    //   1553: aload_0
    //   1554: getfield 694	aqhv:c	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1557: getfield 4005	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1560: invokevirtual 706	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1563: ifle +217 -> 1780
    //   1566: aload_0
    //   1567: getfield 3884	aqhv:cUc	Z
    //   1570: ifeq +210 -> 1780
    //   1573: aload 12
    //   1575: ldc_w 4007
    //   1578: invokevirtual 3216	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1581: pop
    //   1582: aload_0
    //   1583: getfield 694	aqhv:c	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1586: getfield 4005	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1589: invokevirtual 4008	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1592: ifeq +38 -> 1630
    //   1595: aload 12
    //   1597: new 152	java/lang/StringBuilder
    //   1600: dup
    //   1601: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1604: ldc_w 4010
    //   1607: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1610: aload_0
    //   1611: getfield 694	aqhv:c	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1614: getfield 4005	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1617: invokevirtual 706	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1620: invokevirtual 222	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1623: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1626: invokevirtual 3216	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1629: pop
    //   1630: aload_0
    //   1631: getfield 694	aqhv:c	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1634: getfield 753	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1637: invokevirtual 758	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   1640: istore 6
    //   1642: iload 6
    //   1644: ifeq +48 -> 1692
    //   1647: aload_0
    //   1648: getfield 694	aqhv:c	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1651: getfield 753	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1654: invokevirtual 762	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1657: ldc_w 3690
    //   1660: invokestatic 4015	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1663: astore 10
    //   1665: aload 12
    //   1667: new 152	java/lang/StringBuilder
    //   1670: dup
    //   1671: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1674: ldc_w 4017
    //   1677: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1680: aload 10
    //   1682: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1685: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1688: invokevirtual 3216	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1691: pop
    //   1692: aload_0
    //   1693: ldc 245
    //   1695: invokevirtual 1105	aqhv:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   1698: astore 11
    //   1700: aload 11
    //   1702: astore 10
    //   1704: aload 11
    //   1706: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1709: ifne +27 -> 1736
    //   1712: aload 11
    //   1714: astore 10
    //   1716: aload 11
    //   1718: invokestatic 4022	rwt:isUrl	(Ljava/lang/String;)Z
    //   1721: ifeq +15 -> 1736
    //   1724: aload 11
    //   1726: aload 12
    //   1728: invokevirtual 3263	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1731: invokestatic 4026	jpa:r	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1734: astore 10
    //   1736: aload_0
    //   1737: aload 10
    //   1739: aload 9
    //   1741: aload 8
    //   1743: aload 14
    //   1745: invokespecial 4028	aqhv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   1748: aload_0
    //   1749: aload 8
    //   1751: invokespecial 4030	aqhv:UI	(Ljava/lang/String;)V
    //   1754: goto -631 -> 1123
    //   1757: astore 10
    //   1759: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1762: ifeq +1293 -> 3055
    //   1765: ldc_w 666
    //   1768: iconst_2
    //   1769: aload 10
    //   1771: invokevirtual 4031	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   1774: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1777: goto +1278 -> 3055
    //   1780: aload 12
    //   1782: ldc_w 4033
    //   1785: invokevirtual 3216	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1788: pop
    //   1789: goto -97 -> 1692
    //   1792: aload 8
    //   1794: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1797: ifne +452 -> 2249
    //   1800: aload 9
    //   1802: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1805: ifne +444 -> 2249
    //   1808: aload 8
    //   1810: ldc_w 4035
    //   1813: invokevirtual 1297	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1816: ifeq +433 -> 2249
    //   1819: aload 9
    //   1821: ldc 74
    //   1823: invokevirtual 1297	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1826: ifeq +423 -> 2249
    //   1829: aload_0
    //   1830: ldc 245
    //   1832: invokevirtual 1105	aqhv:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   1835: astore 10
    //   1837: aload 10
    //   1839: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1842: ifeq +382 -> 2224
    //   1845: ldc_w 4037
    //   1848: astore 10
    //   1850: new 152	java/lang/StringBuilder
    //   1853: dup
    //   1854: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1857: ldc_w 4039
    //   1860: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1863: invokestatic 631	java/lang/System:currentTimeMillis	()J
    //   1866: invokevirtual 2584	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1869: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1872: astore 12
    //   1874: aload 12
    //   1876: astore 11
    //   1878: aload_0
    //   1879: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1882: ifnull +51 -> 1933
    //   1885: aload 12
    //   1887: astore 11
    //   1889: invokestatic 4044	jml:a	()Ljml;
    //   1892: aload 10
    //   1894: invokevirtual 4047	jml:cY	(Ljava/lang/String;)Z
    //   1897: ifeq +36 -> 1933
    //   1900: new 152	java/lang/StringBuilder
    //   1903: dup
    //   1904: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1907: aload 12
    //   1909: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1912: ldc_w 1310
    //   1915: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1918: aload_0
    //   1919: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1922: invokevirtual 731	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1925: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1928: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1931: astore 11
    //   1933: aload 11
    //   1935: astore 12
    //   1937: aload_0
    //   1938: getfield 4049	aqhv:aIG	Ljava/lang/String;
    //   1941: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1944: ifne +33 -> 1977
    //   1947: new 152	java/lang/StringBuilder
    //   1950: dup
    //   1951: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1954: aload 11
    //   1956: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1959: ldc_w 3224
    //   1962: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1965: aload_0
    //   1966: getfield 4049	aqhv:aIG	Ljava/lang/String;
    //   1969: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1972: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1975: astore 12
    //   1977: aload 12
    //   1979: astore 11
    //   1981: aload 10
    //   1983: ldc_w 1305
    //   1986: invokevirtual 1222	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1989: ifge +26 -> 2015
    //   1992: new 152	java/lang/StringBuilder
    //   1995: dup
    //   1996: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1999: aload 12
    //   2001: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2004: ldc_w 4051
    //   2007: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2010: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2013: astore 11
    //   2015: aload 10
    //   2017: aload 11
    //   2019: invokestatic 4026	jpa:r	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2022: astore 10
    //   2024: aload_0
    //   2025: ldc_w 3864
    //   2028: invokevirtual 1105	aqhv:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   2031: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2034: ifne +954 -> 2988
    //   2037: aload_0
    //   2038: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2041: ifnull +947 -> 2988
    //   2044: aload_0
    //   2045: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2048: bipush 12
    //   2050: invokevirtual 1058	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2053: checkcast 4053	anec
    //   2056: astore 11
    //   2058: iconst_0
    //   2059: istore_1
    //   2060: aload_0
    //   2061: getfield 696	aqhv:dw	Z
    //   2064: ifeq +12 -> 2076
    //   2067: aload_0
    //   2068: getfield 694	aqhv:c	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   2071: iconst_1
    //   2072: invokestatic 4058	ahrx:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;Z)I
    //   2075: istore_1
    //   2076: aload 11
    //   2078: invokevirtual 4061	anec:a	()Lahrx;
    //   2081: iload_1
    //   2082: invokevirtual 4064	ahrx:a	(I)Lcom/tencent/mobileqq/gamecenter/data/PadFaceAd;
    //   2085: astore 11
    //   2087: aload 11
    //   2089: ifnull +899 -> 2988
    //   2092: ldc_w 666
    //   2095: iconst_2
    //   2096: iconst_2
    //   2097: anewarray 4	java/lang/Object
    //   2100: dup
    //   2101: iconst_0
    //   2102: ldc_w 4066
    //   2105: aastore
    //   2106: dup
    //   2107: iconst_1
    //   2108: aload 11
    //   2110: aastore
    //   2111: invokestatic 1188	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   2114: aload 10
    //   2116: ldc_w 4068
    //   2119: invokestatic 4026	jpa:r	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2122: astore 10
    //   2124: aload 11
    //   2126: aload 14
    //   2128: invokestatic 4071	ahrx:a	(Lcom/tencent/mobileqq/gamecenter/data/PadFaceAd;Landroid/content/Intent;)Landroid/content/Intent;
    //   2131: pop
    //   2132: aload_0
    //   2133: aload 10
    //   2135: aload 9
    //   2137: aload 8
    //   2139: aload 14
    //   2141: invokespecial 4028	aqhv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   2144: aload_0
    //   2145: aload 8
    //   2147: invokespecial 4030	aqhv:UI	(Ljava/lang/String;)V
    //   2150: aload_0
    //   2151: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2154: ifnull +37 -> 2191
    //   2157: aload_0
    //   2158: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2161: ldc_w 4073
    //   2164: invokevirtual 4077	com/tencent/mobileqq/app/QQAppInterface:getHandler	(Ljava/lang/Class;)Lmqq/os/MqqHandler;
    //   2167: astore 8
    //   2169: aload 8
    //   2171: ifnull +20 -> 2191
    //   2174: aload 8
    //   2176: aload 8
    //   2178: ldc_w 4078
    //   2181: invokevirtual 4084	mqq/os/MqqHandler:obtainMessage	(I)Landroid/os/Message;
    //   2184: ldc2_w 4085
    //   2187: invokevirtual 4090	mqq/os/MqqHandler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   2190: pop
    //   2191: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2194: ifeq +13 -> 2207
    //   2197: ldc_w 666
    //   2200: iconst_2
    //   2201: ldc_w 4092
    //   2204: invokestatic 1253	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2207: new 4094	com/tencent/mobileqq/utils/JumpAction$23
    //   2210: dup
    //   2211: aload_0
    //   2212: invokespecial 4095	com/tencent/mobileqq/utils/JumpAction$23:<init>	(Laqhv;)V
    //   2215: iconst_5
    //   2216: aconst_null
    //   2217: iconst_1
    //   2218: invokestatic 836	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   2221: goto -1098 -> 1123
    //   2224: aload 10
    //   2226: invokestatic 311	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   2229: astore 10
    //   2231: goto -381 -> 1850
    //   2234: astore 10
    //   2236: aload 10
    //   2238: invokevirtual 827	java/lang/Exception:printStackTrace	()V
    //   2241: ldc_w 4037
    //   2244: astore 10
    //   2246: goto -396 -> 1850
    //   2249: aload 8
    //   2251: ldc_w 4097
    //   2254: invokevirtual 3314	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2257: ifeq +170 -> 2427
    //   2260: aload_0
    //   2261: ldc_w 1548
    //   2264: invokevirtual 1105	aqhv:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   2267: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2270: ifne +52 -> 2322
    //   2273: aload 14
    //   2275: ldc_w 4099
    //   2278: iconst_4
    //   2279: invokevirtual 148	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2282: pop
    //   2283: aload 14
    //   2285: ldc_w 4101
    //   2288: aload 14
    //   2290: ldc_w 4101
    //   2293: iconst_1
    //   2294: invokevirtual 2806	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2297: iconst_4
    //   2298: ior
    //   2299: invokevirtual 148	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2302: pop
    //   2303: aload_0
    //   2304: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2307: aload_0
    //   2308: getfield 115	aqhv:context	Landroid/content/Context;
    //   2311: checkcast 200	android/app/Activity
    //   2314: aload 14
    //   2316: invokestatic 4104	awit:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;Landroid/content/Intent;)V
    //   2319: goto -1196 -> 1123
    //   2322: aload_0
    //   2323: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2326: ldc_w 560
    //   2329: ldc 83
    //   2331: ldc 83
    //   2333: ldc_w 4106
    //   2336: ldc_w 4106
    //   2339: iconst_0
    //   2340: iconst_0
    //   2341: ldc 83
    //   2343: ldc 83
    //   2345: ldc 83
    //   2347: ldc 83
    //   2349: iconst_0
    //   2350: invokestatic 1743	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2353: invokestatic 4111	mzj:a	()Lmzj;
    //   2356: invokestatic 4111	mzj:a	()Lmzj;
    //   2359: invokevirtual 4114	mzj:Fb	()Z
    //   2362: ldc_w 4115
    //   2365: iconst_1
    //   2366: invokevirtual 4118	mzj:g	(ZLjava/lang/String;I)V
    //   2369: aload 14
    //   2371: ldc_w 4099
    //   2374: iconst_1
    //   2375: invokevirtual 148	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2378: pop
    //   2379: aload 14
    //   2381: ldc_w 4120
    //   2384: invokestatic 631	java/lang/System:currentTimeMillis	()J
    //   2387: invokevirtual 634	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   2390: pop
    //   2391: aload_0
    //   2392: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2395: bipush 96
    //   2397: invokevirtual 1058	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2400: checkcast 4122	com/tencent/mobileqq/app/readinjoy/ReadInJoyManager
    //   2403: aload 14
    //   2405: invokevirtual 4125	com/tencent/mobileqq/app/readinjoy/ReadInJoyManager:dl	(Landroid/content/Intent;)V
    //   2408: aload_0
    //   2409: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2412: aload_0
    //   2413: getfield 115	aqhv:context	Landroid/content/Context;
    //   2416: checkcast 200	android/app/Activity
    //   2419: aload 14
    //   2421: invokestatic 4104	awit:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;Landroid/content/Intent;)V
    //   2424: goto -1301 -> 1123
    //   2427: aload 8
    //   2429: ldc_w 3944
    //   2432: invokevirtual 3314	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2435: ifeq +14 -> 2449
    //   2438: aload 14
    //   2440: ldc_w 1548
    //   2443: bipush 15
    //   2445: invokevirtual 148	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2448: pop
    //   2449: aload 8
    //   2451: ldc_w 4127
    //   2454: invokevirtual 3314	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2457: ifeq +16 -> 2473
    //   2460: aload 14
    //   2462: ldc_w 4129
    //   2465: aload_0
    //   2466: getfield 1174	aqhv:source	Ljava/lang/String;
    //   2469: invokevirtual 619	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2472: pop
    //   2473: aload 8
    //   2475: getstatic 4132	cooperation/comic/VipComicJumpActivity:NAME	Ljava/lang/String;
    //   2478: invokevirtual 3314	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2481: ifeq +39 -> 2520
    //   2484: aload 14
    //   2486: invokestatic 4135	cooperation/comic/VipComicJumpActivity:a	(Landroid/content/Intent;)Lcooperation/comic/VipComicJumpActivity$b;
    //   2489: astore 11
    //   2491: aload_0
    //   2492: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2495: aload_0
    //   2496: getfield 115	aqhv:context	Landroid/content/Context;
    //   2499: checkcast 200	android/app/Activity
    //   2502: aload 11
    //   2504: invokestatic 4138	cooperation/comic/VipComicJumpActivity:a	(Lcom/tencent/common/app/AppInterface;Landroid/app/Activity;Lcooperation/comic/VipComicJumpActivity$b;)Z
    //   2507: ifeq +13 -> 2520
    //   2510: aload_0
    //   2511: getfield 117	aqhv:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2514: iconst_1
    //   2515: invokestatic 4141	cooperation/comic/VipComicJumpActivity:d	(Lcom/tencent/common/app/AppInterface;Z)V
    //   2518: iconst_1
    //   2519: ireturn
    //   2520: aload 9
    //   2522: ifnull -1399 -> 1123
    //   2525: aload 9
    //   2527: invokestatic 474	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2530: invokevirtual 4142	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   2533: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2536: istore 6
    //   2538: iload 6
    //   2540: ifeq +368 -> 2908
    //   2543: iconst_0
    //   2544: istore 6
    //   2546: ldc_w 4144
    //   2549: invokestatic 474	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2552: invokevirtual 4148	com/tencent/qphone/base/util/BaseApplication:getClassLoader	()Ljava/lang/ClassLoader;
    //   2555: aload 8
    //   2557: invokevirtual 4154	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   2560: invokevirtual 4158	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   2563: istore 7
    //   2565: iload 7
    //   2567: istore 6
    //   2569: iload 6
    //   2571: ifeq +5 -> 2576
    //   2574: iconst_0
    //   2575: ireturn
    //   2576: aload 14
    //   2578: ldc_w 4160
    //   2581: invokevirtual 2803	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2584: astore 11
    //   2586: aload 11
    //   2588: ifnull +395 -> 2983
    //   2591: aload 11
    //   2593: invokestatic 715	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2596: istore_1
    //   2597: aload 8
    //   2599: ldc_w 4162
    //   2602: invokevirtual 1297	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2605: ifeq +187 -> 2792
    //   2608: ldc_w 4164
    //   2611: astore 8
    //   2613: ldc_w 4166
    //   2616: aload 8
    //   2618: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2621: ifeq +203 -> 2824
    //   2624: aload 14
    //   2626: ldc_w 4168
    //   2629: invokevirtual 2803	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2632: astore 12
    //   2634: aload 8
    //   2636: astore 11
    //   2638: aload 12
    //   2640: ifnull +38 -> 2678
    //   2643: aload 8
    //   2645: astore 11
    //   2647: aload 12
    //   2649: invokestatic 715	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2652: iconst_2
    //   2653: if_icmpne +25 -> 2678
    //   2656: iload_1
    //   2657: invokestatic 4173	asgx:mS	(I)Z
    //   2660: ifeq +408 -> 3068
    //   2663: ldc_w 4175
    //   2666: astore 11
    //   2668: aload 14
    //   2670: ldc_w 4160
    //   2673: iload_1
    //   2674: invokevirtual 148	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2677: pop
    //   2678: aload 10
    //   2680: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2683: ifne +128 -> 2811
    //   2686: aload 10
    //   2688: invokevirtual 4178	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2691: ldc_w 555
    //   2694: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2697: ifeq +114 -> 2811
    //   2700: aload 14
    //   2702: ldc_w 1446
    //   2705: bipush 117
    //   2707: invokevirtual 148	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2710: pop
    //   2711: aload 14
    //   2713: ldc 138
    //   2715: invokevirtual 142	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2718: pop
    //   2719: aload 11
    //   2721: astore 8
    //   2723: ldc_w 4180
    //   2726: aload 8
    //   2728: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2731: ifeq +149 -> 2880
    //   2734: aload 14
    //   2736: ldc 245
    //   2738: invokevirtual 2803	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2741: astore 10
    //   2743: aload 10
    //   2745: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2748: ifne +132 -> 2880
    //   2751: aload 10
    //   2753: ldc_w 3700
    //   2756: invokevirtual 1285	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2759: ifne +121 -> 2880
    //   2762: ldc_w 666
    //   2765: iconst_1
    //   2766: new 152	java/lang/StringBuilder
    //   2769: dup
    //   2770: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   2773: ldc_w 4182
    //   2776: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2779: aload 10
    //   2781: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2784: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2787: invokestatic 1000	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2790: iconst_0
    //   2791: ireturn
    //   2792: aload 8
    //   2794: ldc_w 4184
    //   2797: invokevirtual 1297	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2800: ifeq +180 -> 2980
    //   2803: ldc_w 4166
    //   2806: astore 8
    //   2808: goto -195 -> 2613
    //   2811: aload 14
    //   2813: ldc_w 1446
    //   2816: iconst_2
    //   2817: invokevirtual 148	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2820: pop
    //   2821: goto -110 -> 2711
    //   2824: ldc_w 4164
    //   2827: aload 8
    //   2829: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2832: ifeq +28 -> 2860
    //   2835: iload_1
    //   2836: invokestatic 4173	asgx:mS	(I)Z
    //   2839: ifeq -116 -> 2723
    //   2842: ldc_w 4175
    //   2845: astore 8
    //   2847: aload 14
    //   2849: ldc_w 4160
    //   2852: iload_1
    //   2853: invokevirtual 148	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2856: pop
    //   2857: goto -134 -> 2723
    //   2860: aload 14
    //   2862: ldc_w 624
    //   2865: invokevirtual 513	android/content/Intent:addCategory	(Ljava/lang/String;)Landroid/content/Intent;
    //   2868: pop
    //   2869: aload 14
    //   2871: ldc 143
    //   2873: invokevirtual 142	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2876: pop
    //   2877: goto -154 -> 2723
    //   2880: aload 14
    //   2882: aload 9
    //   2884: aload 8
    //   2886: invokevirtual 622	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2889: pop
    //   2890: aload_0
    //   2891: getfield 115	aqhv:context	Landroid/content/Context;
    //   2894: aload 14
    //   2896: invokevirtual 544	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   2899: aload_0
    //   2900: aload 8
    //   2902: invokespecial 4030	aqhv:UI	(Ljava/lang/String;)V
    //   2905: goto -1782 -> 1123
    //   2908: aload 14
    //   2910: aload 9
    //   2912: aload 8
    //   2914: invokevirtual 622	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2917: pop
    //   2918: aload 14
    //   2920: ldc_w 624
    //   2923: invokevirtual 513	android/content/Intent:addCategory	(Ljava/lang/String;)Landroid/content/Intent;
    //   2926: pop
    //   2927: aload 14
    //   2929: ldc 143
    //   2931: invokevirtual 142	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2934: pop
    //   2935: aload_0
    //   2936: getfield 115	aqhv:context	Landroid/content/Context;
    //   2939: aload 14
    //   2941: invokevirtual 544	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   2944: goto -1821 -> 1123
    //   2947: iload_1
    //   2948: iconst_1
    //   2949: if_icmpne -1826 -> 1123
    //   2952: aload 11
    //   2954: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2957: ifne -1834 -> 1123
    //   2960: aload_0
    //   2961: aload 14
    //   2963: aload 8
    //   2965: aload 11
    //   2967: invokespecial 2037	aqhv:a	(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)Z
    //   2970: istore 6
    //   2972: iload 6
    //   2974: ireturn
    //   2975: astore 11
    //   2977: goto -408 -> 2569
    //   2980: goto -367 -> 2613
    //   2983: iconst_0
    //   2984: istore_1
    //   2985: goto -388 -> 2597
    //   2988: goto -856 -> 2132
    //   2991: aload 10
    //   2993: astore 12
    //   2995: aload 11
    //   2997: astore 13
    //   2999: aload 8
    //   3001: astore 11
    //   3003: aload 9
    //   3005: astore 10
    //   3007: aload 12
    //   3009: astore 8
    //   3011: aload 13
    //   3013: astore 9
    //   3015: goto -2864 -> 151
    //   3018: aload 8
    //   3020: astore 12
    //   3022: aload 9
    //   3024: astore 13
    //   3026: aload 11
    //   3028: astore 8
    //   3030: aload 10
    //   3032: astore 9
    //   3034: aload 12
    //   3036: astore 10
    //   3038: aload 13
    //   3040: astore 11
    //   3042: goto -51 -> 2991
    //   3045: iconst_0
    //   3046: ireturn
    //   3047: ldc_w 405
    //   3050: astore 8
    //   3052: goto -1831 -> 1221
    //   3055: aconst_null
    //   3056: astore 10
    //   3058: goto -1393 -> 1665
    //   3061: astore 11
    //   3063: iconst_0
    //   3064: istore_1
    //   3065: goto -468 -> 2597
    //   3068: ldc_w 4164
    //   3071: astore 11
    //   3073: goto -395 -> 2678
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3076	0	this	aqhv
    //   37	3028	1	i	int
    //   872	257	2	j	int
    //   852	45	3	k	int
    //   848	26	4	m	int
    //   869	11	5	n	int
    //   1263	1710	6	bool1	boolean
    //   2563	3	7	bool2	boolean
    //   22	1068	8	localObject1	Object
    //   1132	1	8	localException1	Exception
    //   1148	23	8	localIntent1	Intent
    //   1178	10	8	localActivityNotFoundException	android.content.ActivityNotFoundException
    //   1219	243	8	str1	String
    //   1490	656	8	localException2	Exception
    //   2167	884	8	localObject2	Object
    //   19	3014	9	localObject3	Object
    //   25	1713	10	localObject4	Object
    //   1757	13	10	localUnsupportedEncodingException	UnsupportedEncodingException
    //   1835	395	10	str2	String
    //   2234	3	10	localException3	Exception
    //   2244	813	10	localObject5	Object
    //   40	2926	11	localObject6	Object
    //   2975	21	11	localException4	Exception
    //   3001	40	11	localObject7	Object
    //   3061	1	11	localException5	Exception
    //   3071	1	11	str3	String
    //   34	3001	12	localObject8	Object
    //   49	2990	13	localObject9	Object
    //   10	2952	14	localIntent2	Intent
    //   149	13	15	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   1103	1123	1132	java/lang/Exception
    //   0	18	1178	android/content/ActivityNotFoundException
    //   27	36	1178	android/content/ActivityNotFoundException
    //   42	70	1178	android/content/ActivityNotFoundException
    //   70	142	1178	android/content/ActivityNotFoundException
    //   142	151	1178	android/content/ActivityNotFoundException
    //   151	197	1178	android/content/ActivityNotFoundException
    //   207	218	1178	android/content/ActivityNotFoundException
    //   241	252	1178	android/content/ActivityNotFoundException
    //   271	309	1178	android/content/ActivityNotFoundException
    //   336	367	1178	android/content/ActivityNotFoundException
    //   371	395	1178	android/content/ActivityNotFoundException
    //   395	406	1178	android/content/ActivityNotFoundException
    //   433	471	1178	android/content/ActivityNotFoundException
    //   498	532	1178	android/content/ActivityNotFoundException
    //   559	630	1178	android/content/ActivityNotFoundException
    //   657	679	1178	android/content/ActivityNotFoundException
    //   704	715	1178	android/content/ActivityNotFoundException
    //   742	752	1178	android/content/ActivityNotFoundException
    //   775	785	1178	android/content/ActivityNotFoundException
    //   798	818	1178	android/content/ActivityNotFoundException
    //   821	845	1178	android/content/ActivityNotFoundException
    //   853	871	1178	android/content/ActivityNotFoundException
    //   882	894	1178	android/content/ActivityNotFoundException
    //   900	952	1178	android/content/ActivityNotFoundException
    //   952	998	1178	android/content/ActivityNotFoundException
    //   998	1021	1178	android/content/ActivityNotFoundException
    //   1021	1044	1178	android/content/ActivityNotFoundException
    //   1044	1072	1178	android/content/ActivityNotFoundException
    //   1076	1103	1178	android/content/ActivityNotFoundException
    //   1103	1123	1178	android/content/ActivityNotFoundException
    //   1134	1175	1178	android/content/ActivityNotFoundException
    //   1187	1216	1178	android/content/ActivityNotFoundException
    //   1221	1252	1178	android/content/ActivityNotFoundException
    //   1255	1265	1178	android/content/ActivityNotFoundException
    //   1270	1282	1178	android/content/ActivityNotFoundException
    //   1287	1371	1178	android/content/ActivityNotFoundException
    //   1381	1452	1178	android/content/ActivityNotFoundException
    //   1452	1487	1178	android/content/ActivityNotFoundException
    //   1492	1497	1178	android/content/ActivityNotFoundException
    //   1500	1630	1178	android/content/ActivityNotFoundException
    //   1630	1642	1178	android/content/ActivityNotFoundException
    //   1647	1665	1178	android/content/ActivityNotFoundException
    //   1665	1692	1178	android/content/ActivityNotFoundException
    //   1692	1700	1178	android/content/ActivityNotFoundException
    //   1704	1712	1178	android/content/ActivityNotFoundException
    //   1716	1736	1178	android/content/ActivityNotFoundException
    //   1736	1754	1178	android/content/ActivityNotFoundException
    //   1759	1777	1178	android/content/ActivityNotFoundException
    //   1780	1789	1178	android/content/ActivityNotFoundException
    //   1792	1845	1178	android/content/ActivityNotFoundException
    //   1850	1874	1178	android/content/ActivityNotFoundException
    //   1878	1885	1178	android/content/ActivityNotFoundException
    //   1889	1933	1178	android/content/ActivityNotFoundException
    //   1937	1977	1178	android/content/ActivityNotFoundException
    //   1981	2015	1178	android/content/ActivityNotFoundException
    //   2015	2058	1178	android/content/ActivityNotFoundException
    //   2060	2076	1178	android/content/ActivityNotFoundException
    //   2076	2087	1178	android/content/ActivityNotFoundException
    //   2092	2132	1178	android/content/ActivityNotFoundException
    //   2132	2169	1178	android/content/ActivityNotFoundException
    //   2174	2191	1178	android/content/ActivityNotFoundException
    //   2191	2207	1178	android/content/ActivityNotFoundException
    //   2207	2221	1178	android/content/ActivityNotFoundException
    //   2224	2231	1178	android/content/ActivityNotFoundException
    //   2236	2241	1178	android/content/ActivityNotFoundException
    //   2249	2319	1178	android/content/ActivityNotFoundException
    //   2322	2424	1178	android/content/ActivityNotFoundException
    //   2427	2449	1178	android/content/ActivityNotFoundException
    //   2449	2473	1178	android/content/ActivityNotFoundException
    //   2473	2518	1178	android/content/ActivityNotFoundException
    //   2525	2538	1178	android/content/ActivityNotFoundException
    //   2546	2565	1178	android/content/ActivityNotFoundException
    //   2576	2586	1178	android/content/ActivityNotFoundException
    //   2591	2597	1178	android/content/ActivityNotFoundException
    //   2597	2608	1178	android/content/ActivityNotFoundException
    //   2613	2634	1178	android/content/ActivityNotFoundException
    //   2647	2663	1178	android/content/ActivityNotFoundException
    //   2668	2678	1178	android/content/ActivityNotFoundException
    //   2678	2711	1178	android/content/ActivityNotFoundException
    //   2711	2719	1178	android/content/ActivityNotFoundException
    //   2723	2790	1178	android/content/ActivityNotFoundException
    //   2792	2803	1178	android/content/ActivityNotFoundException
    //   2811	2821	1178	android/content/ActivityNotFoundException
    //   2824	2835	1178	android/content/ActivityNotFoundException
    //   2835	2842	1178	android/content/ActivityNotFoundException
    //   2847	2857	1178	android/content/ActivityNotFoundException
    //   2860	2877	1178	android/content/ActivityNotFoundException
    //   2880	2905	1178	android/content/ActivityNotFoundException
    //   2908	2944	1178	android/content/ActivityNotFoundException
    //   2952	2972	1178	android/content/ActivityNotFoundException
    //   1270	1282	1490	java/lang/Exception
    //   1287	1371	1490	java/lang/Exception
    //   1381	1452	1490	java/lang/Exception
    //   1452	1487	1490	java/lang/Exception
    //   1647	1665	1757	java/io/UnsupportedEncodingException
    //   2224	2231	2234	java/lang/Exception
    //   2546	2565	2975	java/lang/Exception
    //   2591	2597	3061	java/lang/Exception
  }
  
  private boolean aEr()
  {
    anot.a(this.app, "CliOper", "", "", "0X800492C", "0X800492C", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.e("qqdataline", 2, "shareFromMigSdk|report send from sdk:0X800492C.");
    }
    Object localObject1 = (String)this.attrs.get("file_type");
    String str2 = toBase64Decode((String)this.attrs.get("file_data"));
    Object localObject2 = toBase64Decode((String)this.attrs.get("title"));
    Object localObject4 = toBase64Decode((String)this.attrs.get("description"));
    toBase64Decode((String)this.attrs.get("previewimagedata"));
    String str1 = toBase64Decode((String)this.attrs.get("url"));
    Object localObject6 = toBase64Decode((String)this.attrs.get("image_url"));
    if (!TextUtils.isEmpty(this.pkgName)) {}
    for (localObject1 = toBase64Decode((String)this.attrs.get("app_name"));; localObject1 = null)
    {
      Object localObject7 = toBase64Decode((String)this.attrs.get("audioUrl"));
      String str4 = toBase64Decode((String)this.attrs.get("open_id"));
      String str3 = toBase64Decode((String)this.attrs.get("req_type"));
      String str5 = toBase64Decode((String)this.attrs.get("share_uin"));
      String str6 = (String)this.attrs.get("jfrom");
      String str7 = toBase64Decode((String)this.attrs.get("share_qq_ext_str"));
      int j = 0;
      try
      {
        i = Integer.valueOf(toBase64Decode((String)this.attrs.get("cflag"))).intValue();
        l2 = 0L;
      }
      catch (Exception localException2)
      {
        try
        {
          l1 = Long.valueOf((String)this.attrs.get("share_id")).longValue();
          localBundle = new Bundle();
          localBundle.putString("title", (String)localObject2);
          localBundle.putString("desc", (String)localObject4);
          localBundle.putString("image_url", str2);
          localBundle.putString("detail_url", str1);
          localBundle.putLong("req_share_id", l1);
          localBundle.putString("pkg_name", this.pkgName);
          localBundle.putString("image_url_remote", (String)localObject6);
          localBundle.putString("app_name", (String)localObject1);
          localBundle.putString("open_id", str4);
          localBundle.putString("share_uin", str5);
          localBundle.putString("jfrom", str6);
          localBundle.putString("share_qq_ext_str", str7);
          localBundle.putInt("cflag", i);
          localBundle.putInt("forward_type", 11);
          j = 1;
        }
        catch (Exception localException2)
        {
          try
          {
            long l2;
            do
            {
              for (;;)
              {
                Bundle localBundle;
                i = Integer.valueOf(str3).intValue();
                localBundle.putInt("req_type", i);
                if (2 != i) {
                  break label802;
                }
                localBundle.putString("audio_url", (String)localObject7);
                if ((TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.isEmpty((CharSequence)localObject4)))
                {
                  if (TextUtils.isEmpty((CharSequence)localObject1)) {
                    break;
                  }
                  localBundle.putString("title", String.format(this.context.getString(2131700276), new Object[] { localObject1 }));
                }
                com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.boN = true;
                localObject1 = new Intent(this.context, LiteActivity.class);
                localBundle.putBoolean("MigSdkShareNotDone", true);
                ((Intent)localObject1).putExtras(localBundle);
                ((Intent)localObject1).addFlags(268435456);
                this.context.startActivity((Intent)localObject1);
                return true;
                localException1 = localException1;
                i = j;
                if (QLog.isColorLevel())
                {
                  QLog.e("qqfav", 2, "gotoQfavShareMsg|parse extflags exp: extflag=" + (String)this.attrs.get("cflag"));
                  i = j;
                }
              }
              localException2 = localException2;
              l1 = l2;
            } while (!QLog.isColorLevel());
            QLog.e("qqfav", 2, "gotoQfavShareMsg|parse appid exp: appid=" + (String)this.attrs.get("share_id"));
            l1 = l2;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            int i;
            label802:
            label879:
            do
            {
              for (;;)
              {
                long l1;
                i = j;
                if (QLog.isColorLevel())
                {
                  QLog.e("qqfav", 2, "gotoQfavShareMsg|parse reqtype exp: reqType=" + str3);
                  i = j;
                  continue;
                  localException2.putString("title", this.context.getString(2131700277));
                  continue;
                  if (6 == i)
                  {
                    localObject1 = "";
                    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                      localObject1 = localObject2;
                    }
                    localObject2 = localObject1;
                    if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                        break label879;
                      }
                    }
                    for (localObject2 = localObject4;; localObject2 = (String)localObject1 + "\n" + (String)localObject4)
                    {
                      localException2.putString("forward_text", (String)localObject2);
                      localException2.putBoolean("isFromShare", true);
                      localException2.putBoolean("key_sdk_share_pure_text", true);
                      break;
                    }
                  }
                  if (5 != i) {
                    break;
                  }
                  localObject2 = null;
                  localObject1 = null;
                  localObject6 = new ArrayList();
                  Object localObject3;
                  if (!TextUtils.isEmpty(str2))
                  {
                    localObject7 = str2.split(";");
                    i = 0;
                    localObject4 = null;
                    for (;;)
                    {
                      localObject5 = localObject4;
                      localObject2 = localObject1;
                      if (i >= localObject7.length) {
                        break label1175;
                      }
                      localObject5 = "";
                      try
                      {
                        localObject2 = URLDecoder.decode(localObject7[i], "UTF-8");
                        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                          if ((((String)localObject2).startsWith("/")) && (new File((String)localObject2).exists()))
                          {
                            ((ArrayList)localObject6).add(localObject2);
                            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                              break label1165;
                            }
                            i += 1;
                            localObject1 = localObject2;
                          }
                        }
                      }
                      catch (UnsupportedEncodingException localUnsupportedEncodingException)
                      {
                        for (;;)
                        {
                          localObject3 = localObject5;
                          if (QLog.isColorLevel())
                          {
                            QLog.e("qqfav", 2, "gotoQfavShareMsg|decode exp. imageUrls[i]=" + localObject7[i]);
                            localObject3 = localObject5;
                            continue;
                            if (localObject3.startsWith("http"))
                            {
                              ((ArrayList)localObject6).add(localObject3);
                              if (TextUtils.isEmpty((CharSequence)localObject4))
                              {
                                localObject4 = localObject3;
                                localObject3 = localObject1;
                                continue;
                                if (QLog.isColorLevel()) {
                                  QLog.e("qqfav", 2, "gotoQfavShareMsg|file path invalid. path=" + localObject3);
                                }
                              }
                            }
                            localObject3 = localObject1;
                          }
                        }
                      }
                    }
                  }
                  Object localObject5 = null;
                  localException2.putString("image_url", localObject3);
                  localException2.putString("image_url_remote", (String)localObject5);
                  localException2.putString("title", null);
                  localException2.putString("desc", null);
                  if (1 == ((ArrayList)localObject6).size())
                  {
                    localObject1 = localObject3;
                    if (TextUtils.isEmpty(localObject3))
                    {
                      localObject1 = localObject3;
                      if (!TextUtils.isEmpty((CharSequence)localObject5))
                      {
                        localException2.putString("image_url", (String)localObject5);
                        localObject1 = localObject5;
                      }
                    }
                    if (ahav.getFileType((String)localObject1) == 0)
                    {
                      localException2.putInt("req_type", 5);
                    }
                    else
                    {
                      localException2.putString("forward_text", acfp.m(2131707544) + ahav.getFileName((String)localObject1) + acfp.m(2131707545) + ahbj.g(ahbj.getFileSize((String)localObject1)) + "。");
                      localException2.putBoolean("qdshare_file", true);
                      localException2.putBoolean("isFromShare", true);
                      localException2.putBoolean("key_sdk_share_pure_text", true);
                      localException2.putInt("req_type", 6);
                    }
                  }
                  else if (ahav.getFileType(localObject3) == 0)
                  {
                    localException2.putString("title", ((ArrayList)localObject6).size() + this.context.getString(2131696504));
                    localException2.putString("qqfav_extra_multi_pic_path_list", str2);
                    localException2.putBoolean("qqfav_extra_multi_pic", true);
                    localException2.putInt("req_type", 1);
                  }
                  else
                  {
                    localObject1 = ((ArrayList)localObject6).iterator();
                    for (l1 = 0L; ((Iterator)localObject1).hasNext(); l1 = ahbj.getFileSize((String)((Iterator)localObject1).next()) + l1) {}
                    localException2.putString("forward_text", acfp.m(2131707551) + ahav.getFileName(localObject3) + acfp.m(2131707539) + ((ArrayList)localObject6).size() + acfp.m(2131707552) + ahbj.g(l1));
                    localException2.putString("qqfav_extra_multi_pic_path_list", str2);
                    localException2.putBoolean("qdshare_file", true);
                    localException2.putBoolean("isFromShare", true);
                    localException2.putBoolean("key_sdk_share_pure_text", true);
                    localException2.putInt("req_type", 6);
                  }
                }
              }
            } while (1 == i);
            label1165:
            label1175:
            return false;
          }
        }
      }
    }
  }
  
  private boolean aEs()
  {
    avhc.c(this.context, 9, null);
    return true;
  }
  
  private boolean aEt()
  {
    return true;
  }
  
  private boolean aEu()
  {
    String str3 = toBase64Decode((String)this.attrs.get("title"));
    String str4 = toBase64Decode((String)this.attrs.get("description"));
    if (!TextUtils.isEmpty(this.pkgName)) {}
    Object localObject2;
    for (Object localObject1 = toBase64Decode((String)this.attrs.get("app_name"));; localObject2 = null)
    {
      Object localObject3 = (String)this.attrs.get("share_id");
      String str1 = toBase64Decode((String)this.attrs.get("file_data"));
      try
      {
        str1 = URLDecoder.decode(str1, "UTF-8");
        str5 = toBase64Decode((String)this.attrs.get("troopbar_id"));
      }
      catch (Exception localException3)
      {
        try
        {
          l = Long.parseLong((String)localObject3);
          localObject3 = new JSONObject();
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              String str5;
              ((JSONObject)localObject3).put("share_from_app", true);
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("share_img_list", str1);
              localJSONObject.put("share_title", str3);
              localJSONObject.put("share_content", str4);
              localJSONObject.put("share_app_name", localObject1);
              localJSONObject.put("share_app_id", l);
              ((JSONObject)localObject3).put("share_info", localJSONObject);
              ((JSONObject)localObject3).put("bid", str5);
              localObject1 = new Intent(this.context, TroopBarPublishActivity.class);
              ((Intent)localObject1).addFlags(268435456);
              ((Intent)localObject1).putExtra("options", ((JSONObject)localObject3).toString());
              ((Intent)localObject1).putExtra("pkg_name", this.pkgName);
              com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.boN = true;
              this.context.startActivity((Intent)localObject1);
              return true;
              localException2 = localException2;
              String str2 = "";
            }
            localException3 = localException3;
            long l = 0L;
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("JumpAction", 2, "gotoTroopBarShareMsg Exception:" + localException1.toString());
              }
            }
          }
        }
      }
    }
  }
  
  private boolean aEv()
  {
    String str = toBase64Decode((String)this.attrs.get("url_prefix"));
    if (TextUtils.isEmpty(str)) {
      str = this.source;
    }
    for (;;)
    {
      tar.a().zh(1);
      tar.a().aIF = "";
      tar.a().bAQ = 0;
      tar.a().a(BaseApplicationImpl.getApplication().getRuntime(), "Usr_Entrance", 2);
      if ((this.context instanceof Activity)) {
        DeviceScanner.openDeviceQCodeUrl((Activity)this.context, null, str);
      }
      return true;
    }
  }
  
  private boolean aEx()
  {
    Object localObject2 = toBase64Decode((String)this.attrs.get("url_prefix"));
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.source;
    }
    for (;;)
    {
      try
      {
        localObject1 = aurr.getArgumentsFromURL((String)localObject1);
        if (((Map)localObject1).get("public_device") != null)
        {
          i = 1;
          localObject2 = aurr.getArguments((String)((Map)localObject1).get("args"));
          localObject1 = (String)((Map)localObject2).get("sn");
          localObject2 = (String)((Map)localObject2).get("pid");
          if ((i != 0) && ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2))))
          {
            arxa.a().showToast(this.context.getString(2131721679));
            return true;
          }
          Intent localIntent = new Intent(this.context, DevicePluginDownloadActivity.class);
          localIntent.putExtra("DevicePID", (String)localObject2);
          localIntent.putExtra("DeviceSN", (String)localObject1);
          localIntent.putExtra("DeviceToken", "");
          localIntent.putExtra("public_device", i);
          localIntent.putExtra("from", "share");
          this.context.startActivity(localIntent);
          return true;
        }
      }
      catch (Exception localException)
      {
        return false;
      }
      int i = 0;
    }
  }
  
  private boolean aEy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.send_hong_bao", 2, "JumpAction.gotoSendHongBao(). hong_bao_id=" + (String)this.attrs.get("hb_id") + ", send_uin=" + (String)this.attrs.get("send_uin") + ", hong_bao_type=" + (String)this.attrs.get("hb_type") + ", hong_bao_summary=" + (String)this.attrs.get("hb_summary"));
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("hb_id", (String)this.attrs.get("hb_id"));
    localIntent.putExtra("send_uin", (String)this.attrs.get("send_uin"));
    localIntent.putExtra("hb_type", (String)this.attrs.get("hb_type"));
    localIntent.putExtra("forward_text", (String)this.attrs.get("hb_summary"));
    localIntent.putExtra("forward_type", 17);
    ahgq.P(this.context, localIntent);
    return true;
  }
  
  private boolean acA()
  {
    if (!TextUtils.isEmpty(jE((String)this.attrs.get("parter_api")))) {
      rar.a("content_flow", "use_api", 0, 0, new String[] { "", (String)this.attrs.get("parter_api") });
    }
    if ((this.context instanceof Activity))
    {
      Activity localActivity = (Activity)this.context;
      if ("1".equals((String)this.attrs.get("to_new_version"))) {}
      return true;
    }
    return false;
  }
  
  private boolean acB()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Jumpaction", 2, " source:" + this.source + "  serverName:" + this.cti + "  hostName:" + this.ctj);
    }
    Object localObject1;
    if (this.ctj.equals("index"))
    {
      localObject1 = new Intent(this.context, QZoneAppListActivity.class);
      ((Intent)localObject1).putExtra("goto_type", 1);
      this.context.startActivity((Intent)localObject1);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return true;
              if (!this.ctj.equals("detail")) {
                break;
              }
            } while (TextUtils.isEmpty(this.source));
            localObject1 = arug.Dj() + File.separator + "qapp_center_detail.htm";
            if (new File((String)localObject1).exists()) {}
            for (localObject1 = "file:///" + (String)localObject1;; localObject1 = arug.Dp() + File.separator + "qapp_center_detail.htm")
            {
              localObject2 = new Intent(this.context, QZoneAppListActivity.class);
              localObject3 = new Bundle();
              localObject4 = Uri.parse(this.source).getQueryParameter("param");
              ((Bundle)localObject3).putString("APP_URL", (String)localObject1);
              ((Bundle)localObject3).putString("APP_PARAMS", "&" + (String)localObject4);
              ((Bundle)localObject3).putInt("goto_type", 2);
              ((Intent)localObject2).putExtras((Bundle)localObject3);
              ((Intent)localObject2).putExtra("adapter_action", "action_app_detail");
              this.context.startActivity((Intent)localObject2);
              return true;
            }
            if (!this.ctj.equals("webview")) {
              break;
            }
          } while (TextUtils.isEmpty(this.source));
          localObject1 = new Intent(this.context, QZoneAppListActivity.class);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("APP_URL", Uri.parse(this.source).getQueryParameter("url"));
          ((Bundle)localObject2).putInt("goto_type", 3);
          ((Intent)localObject1).putExtras((Bundle)localObject2);
          this.context.startActivity((Intent)localObject1);
          return true;
        } while ((!this.ctj.equals("local")) || (TextUtils.isEmpty(this.source)));
        localObject2 = Uri.parse(this.source);
        localObject1 = ((Uri)localObject2).getQueryParameter("title");
        localObject3 = arug.getFileUrl(((Uri)localObject2).getQueryParameter("url"));
      } while (localObject3.length <= 1);
      localObject2 = localObject3[0];
    } while ((!((String)localObject2).startsWith("file://")) || ((!((String)localObject2).contains(arug.Dj())) && (!((String)localObject2).contains("android_asset/Page/system/"))));
    Object localObject3 = localObject3[1];
    Object localObject4 = new Intent(this.context, QZoneAppListActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("APP_URL", (String)localObject2);
    Object localObject2 = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      ((ArrayList)localObject2).add(localObject1);
    }
    localBundle.putStringArrayList("titleName", (ArrayList)localObject2);
    if ((localObject3 != null) && (((String)localObject3).length() > 0)) {
      localBundle.putString("APP_PARAMS", (String)localObject3);
    }
    localBundle.putInt("goto_type", 4);
    ((Intent)localObject4).putExtras(localBundle);
    this.context.startActivity((Intent)localObject4);
    return true;
  }
  
  private boolean acC()
  {
    if (!TextUtils.isEmpty((CharSequence)this.attrs.get("appid"))) {
      mAppId = (String)this.attrs.get("appid");
    }
    if (!TextUtils.isEmpty((CharSequence)this.attrs.get("openid"))) {
      mOpenId = (String)this.attrs.get("openid");
    }
    if (!TextUtils.isEmpty((CharSequence)this.attrs.get("openkey"))) {
      cto = (String)this.attrs.get("openkey");
    }
    if ("true".equals(this.attrs.get("is_from_game"))) {
      return acD();
    }
    return acE();
  }
  
  private boolean acD()
  {
    Object localObject = (String)this.attrs.get("uin");
    if ((localObject == null) || ("".equals(localObject)) || (((String)localObject).length() < 5)) {
      return false;
    }
    localObject = TroopInfoActivity.c((String)localObject, 14);
    if (this.attrs.containsKey("appid")) {
      ((Bundle)localObject).putString("appid", (String)this.attrs.get("appid"));
    }
    if (this.attrs.containsKey("openid")) {
      ((Bundle)localObject).putString("openid", toBase64Decode(mOpenId));
    }
    if (this.attrs.containsKey("openkey")) {
      ((Bundle)localObject).putString("openkey", (String)this.attrs.get("openkey"));
    }
    if (this.attrs.containsKey("is_from_game")) {
      ((Bundle)localObject).putString("is_from_game", (String)this.attrs.get("is_from_game"));
    }
    if (this.attrs.containsKey("guild_id")) {
      ((Bundle)localObject).putString("guild_id", (String)this.attrs.get("guild_id"));
    }
    if (this.attrs.containsKey("zone_id")) {
      ((Bundle)localObject).putString("zone_id", (String)this.attrs.get("zone_id"));
    }
    if (this.attrs.containsKey("role_id")) {
      ((Bundle)localObject).putString("role_id", (String)this.attrs.get("role_id"));
    }
    if (this.attrs.containsKey("gc")) {
      ((Bundle)localObject).putString("gc", (String)this.attrs.get("gc"));
    }
    apuh.a(this.context, (Bundle)localObject, 2);
    return true;
  }
  
  private boolean acE()
  {
    Intent localIntent = new Intent(this.context, QRJumpActivity.class);
    String str = (String)this.attrs.get("url");
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.source;
    }
    localIntent.putExtra("url", (String)localObject);
    localObject = (String)this.attrs.get("attr_original_url");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localIntent.putExtra("attr_original_url", (String)localObject);
    }
    if ((this.context instanceof Activity))
    {
      localObject = ((Activity)this.context).getIntent();
      if ((localObject != null) && (((Intent)localObject).hasExtra("fromQrcode"))) {
        localIntent.putExtra("fromQrcode", ((Intent)localObject).getBooleanExtra("fromQrcode", false));
      }
    }
    this.context.startActivity(localIntent);
    return true;
  }
  
  private boolean acF()
  {
    if (!(this.context instanceof BaseActivity)) {
      return false;
    }
    if (this.attrs.containsKey("uin")) {}
    for (String str = (String)this.attrs.get("uin"); !str.equals(this.app.getCurrentAccountUin()); str = "")
    {
      cOE();
      return false;
    }
    cOF();
    return false;
  }
  
  private boolean acG()
  {
    Intent localIntent = new Intent(this.context, HcePluginInstallActivity.class);
    this.context.startActivity(localIntent);
    return true;
  }
  
  private boolean acH()
  {
    if (!(this.context instanceof BaseActivity)) {
      return false;
    }
    QWalletHelper.launchQWalletAct((BaseActivity)this.context, this.app, true, false);
    return true;
  }
  
  private boolean acI()
  {
    WXMiniProgramHelper.a().X(this.attrs);
    return true;
  }
  
  private boolean acQ()
  {
    return true;
  }
  
  private boolean acS()
  {
    try
    {
      Intent localIntent = new Intent(this.context, QQBrowserActivity.class);
      if (TextUtils.isEmpty(aetq.a().tV())) {}
      for (String str = "https://docs.qq.com/desktop/m/index.html?_from=1";; str = aetq.a().tV())
      {
        this.context.startActivity(localIntent.putExtra("url", str));
        break;
      }
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean acT()
  {
    String str = (String)this.attrs.get("groupcode");
    if ((str == null) || ("".equals(str)) || (str.length() < 5)) {
      return false;
    }
    Object localObject1;
    if ((this.context instanceof Activity))
    {
      localObject1 = (TroopManager)this.app.getManager(52);
      if (localObject1 == null) {
        break label318;
      }
      localObject1 = ((TroopManager)localObject1).b(str);
      if ((localObject1 == null) || (!((TroopInfo)localObject1).isAdmin())) {
        break label318;
      }
    }
    label318:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("JumpAction", 2, "gotoGroupManager not admin " + str);
        }
        return false;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("uin", this.app.getCurrentAccountUin());
      ((Intent)localObject1).putExtra("troop_uin", str);
      ((Intent)localObject1).putExtra("key_is_update_before_805", apuh.ai(this.context, "8.0.5"));
      ((Intent)localObject1).putExtra("troop_manage_from_jump_action", true);
      ((Intent)localObject1).putExtra("key_is_need_update_Group_info", true);
      Object localObject2 = new awjk(this.app);
      PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
      if (localPluginCommunicationHandler != null) {
        localPluginCommunicationHandler.register((RemoteCommand)localObject2);
      }
      localObject2 = TroopBaseProxyActivity.a((Activity)this.context);
      TroopManageProxyActivity.a("troop_manage_plugin.apk", PluginInfo.cKH, TroopManageProxyActivity.class, (Activity)this.context, (Intent)localObject1, (Dialog)localObject2, "com.tencent.mobileqq.activity.TroopManageActivity", this.app.getCurrentAccountUin(), -1);
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoGroupManager " + str);
      }
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoGroupManager context not activity");
      }
      return false;
    }
  }
  
  private boolean acU()
  {
    i = 0;
    Object localObject = (String)this.attrs.get("guin");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (!TroopInfo.isTroopMember(this.app, (String)localObject)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("JumpAction", 2, new Object[] { "illegal goToTroopProfileApp jumpAction. troopUin=", localObject });
      }
      return false;
    }
    String str = (String)this.attrs.get("type");
    if ("group_file".equals(str)) {
      apuh.b(this.app, (Activity)this.context, (String)localObject);
    }
    for (;;)
    {
      return true;
      if ("group_album".equals(str)) {
        str = (String)this.attrs.get("gname");
      }
      try
      {
        j = Integer.parseInt((String)this.attrs.get("unreadnum"));
        i = j;
      }
      catch (NumberFormatException localNumberFormatException4)
      {
        int j;
        label156:
        break label156;
      }
      apuh.a(this.app, (Activity)this.context, (String)localObject, str, i);
      continue;
      if ("group_story".equals(str)) {
        for (;;)
        {
          for (;;)
          {
            int k;
            int m;
            try
            {
              if (this.attrs.containsKey("troopStoryMemoriesFrom")) {
                i = Integer.parseInt((String)this.attrs.get("troopStoryMemoriesFrom"));
              }
            }
            catch (NumberFormatException localNumberFormatException1)
            {
              i = 0;
              j = 0;
            }
            try
            {
              k = Integer.parseInt((String)this.attrs.get("playVideoFrom"));
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              for (;;)
              {
                label306:
                Bundle localBundle;
                k = 0;
                j = i;
                i = k;
              }
            }
            try
            {
              m = Integer.parseInt((String)this.attrs.get("lastOpenFrom"));
              j = i;
              localObject = QQStoryShareGroupProfileActivity.a(this.context, 1, null, (String)localObject, j, k);
              ((Intent)localObject).putExtra("extra_last_open_from", m);
              this.context.startActivity((Intent)localObject);
            }
            catch (NumberFormatException localNumberFormatException3)
            {
              j = i;
              i = k;
              break label306;
            }
          }
          i = 8;
          continue;
          m = 0;
          k = i;
        }
      }
      if (!"bulk_send_message".equals(localNumberFormatException1)) {
        break;
      }
      localObject = (String)this.attrs.get("gc");
      localBundle = new Bundle();
      localBundle.putString("extra.GROUP_UIN", (String)localObject);
      localBundle.putString("selfSet_leftViewText", acfp.m(2131707537));
      BulkSendMessageFragment.p((Activity)this.context, localBundle);
    }
  }
  
  private boolean ach()
  {
    int i = 0;
    if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getApplication()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131696273, 1).show();
      return false;
    }
    if (this.attrs.containsKey("params")) {
      str1 = (String)this.attrs.get("params");
    }
    try
    {
      String str2;
      long[] arrayOfLong;
      for (;;)
      {
        localObject = new JSONObject(new String(aqgo.decode(str1, 0)));
        str2 = ((JSONObject)localObject).optString("keyword");
        JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("groupmask");
        arrayOfLong = new long[localJSONArray.length()];
        while (i < localJSONArray.length())
        {
          arrayOfLong[i] = localJSONArray.optLong(i);
          i += 1;
        }
        str1 = "";
      }
      Object localObject = ((JSONObject)localObject).optString("groupname");
      ActiveEntitySearchActivity.a(this.context, str2, (String)localObject, arrayOfLong);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("JumpActionQ.uniteSearch.", 2, "参数解析成json错误.  params=" + str1);
      }
    }
    return true;
  }
  
  private boolean aci()
  {
    if (QLog.isColorLevel()) {
      ajrk.m("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    }
    Intent localIntent = new Intent(this.context, NearbyActivity.class);
    localIntent.putExtra("TAB_TYPE", 1);
    String str2;
    if (this.attrs.containsKey("src_type")) {
      str2 = (String)this.attrs.get("src_type");
    }
    for (;;)
    {
      String str4;
      label105:
      String str5;
      label133:
      String str1;
      if (this.attrs.containsKey("web_url"))
      {
        str4 = (String)this.attrs.get("web_url");
        if (!this.attrs.containsKey("from")) {
          break label754;
        }
        str5 = (String)this.attrs.get("from");
        if (!this.attrs.containsKey("from_type")) {
          break label761;
        }
        str1 = (String)this.attrs.get("from_type");
        label161:
        localIntent.putExtra("ENTER_TIME", System.currentTimeMillis());
        localIntent.putExtra("fromWhere", str2);
        localIntent.putExtra("webUrl", str4);
        localIntent.putExtra("fromType", str1);
        localIntent.putExtra("FROM_WHERE", 1);
        if (!this.attrs.containsKey("neighbor_list_source")) {}
      }
      try
      {
        i = Integer.parseInt((String)this.attrs.get("neighbor_list_source"));
        localIntent.putExtra("neighbor_list_source", i);
        if ("10002".equals(str5))
        {
          localIntent.putExtra("abp_flag", true);
          localIntent.addFlags(268435456);
        }
        if (this.attrs.containsKey("filter"))
        {
          str2 = (String)this.attrs.get("filter");
          if ("1".equals(str2))
          {
            if (!this.attrs.containsKey("filter_gender")) {
              break label787;
            }
            str4 = (String)this.attrs.get("filter_gender");
            if (!this.attrs.containsKey("filter_time")) {
              break label794;
            }
            str5 = (String)this.attrs.get("filter_time");
            if (!this.attrs.containsKey("filter_age")) {
              break label801;
            }
            str6 = (String)this.attrs.get("filter_age");
            if (!this.attrs.containsKey("filter_xingzuo")) {
              break label808;
            }
            str7 = (String)this.attrs.get("filter_xingzuo");
            if (!this.attrs.containsKey("filter_interest")) {
              break label815;
            }
            str8 = (String)this.attrs.get("filter_interest");
            if (!this.attrs.containsKey("filter_career")) {
              break label822;
            }
            str9 = (String)this.attrs.get("filter_career");
            if (!this.attrs.containsKey("filter_location")) {
              break label829;
            }
            str10 = (String)this.attrs.get("filter_location");
          }
        }
      }
      catch (Exception localException6)
      {
        try
        {
          i = Integer.valueOf(str4).intValue();
        }
        catch (Exception localException6)
        {
          try
          {
            j = Integer.valueOf(str5).intValue();
          }
          catch (Exception localException6)
          {
            try
            {
              k = Integer.valueOf(str6).intValue();
            }
            catch (Exception localException6)
            {
              try
              {
                m = Integer.valueOf(str7).intValue();
              }
              catch (Exception localException6)
              {
                try
                {
                  n = Integer.valueOf(str9).intValue();
                }
                catch (Exception localException6)
                {
                  try
                  {
                    for (;;)
                    {
                      i1 = Integer.valueOf(str8).intValue();
                      localIntent.putExtra("filter", str2);
                      localIntent.putExtra("filterGender", i);
                      localIntent.putExtra("filter_time", j);
                      localIntent.putExtra("filter_age", k);
                      localIntent.putExtra("filter_xingzuo", m);
                      localIntent.putExtra("filter_interest", i1);
                      localIntent.putExtra("filter_career", n);
                      localIntent.putExtra("filter_location", str10);
                      localIntent.addFlags(67108864);
                      if (!(this.context instanceof Activity)) {
                        localIntent.addFlags(268435456);
                      }
                      this.context.startActivity(localIntent);
                      if ("100".equals(str1)) {
                        anot.a(this.app, "dc00898", "", "", "0X8007244", "0X8007244", 0, 0, "", "", "", "");
                      }
                      return true;
                      str2 = "";
                      break;
                      str4 = "";
                      break label105;
                      label754:
                      str5 = "";
                      break label133;
                      label761:
                      str1 = "";
                      break label161;
                      localException1 = localException1;
                      localException1.printStackTrace();
                      int i = 0;
                      continue;
                      String str3 = "";
                      continue;
                      label787:
                      str4 = "";
                      continue;
                      label794:
                      str5 = "";
                      continue;
                      label801:
                      String str6 = "";
                      continue;
                      label808:
                      String str7 = "";
                      continue;
                      label815:
                      String str8 = "";
                      continue;
                      label822:
                      String str9 = "";
                      continue;
                      label829:
                      String str10 = "";
                      continue;
                      localException2 = localException2;
                      i = 0;
                      continue;
                      localException3 = localException3;
                      int j = 3;
                      continue;
                      localException4 = localException4;
                      int k = 0;
                      continue;
                      localException5 = localException5;
                      int m = 0;
                      continue;
                      localException6 = localException6;
                      int n = 0;
                    }
                  }
                  catch (Exception localException7)
                  {
                    for (;;)
                    {
                      int i1 = 0;
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
  
  private boolean acj()
  {
    String str1 = (String)this.attrs.get("roomcode");
    String str2 = (String)this.attrs.get("fromid");
    String str3 = (String)this.attrs.get("isgroupcode");
    String str4 = (String)this.attrs.get("backtype");
    String str5 = (String)this.attrs.get("open_type");
    String str6 = (String)this.attrs.get("extra");
    aicu localaicu = (aicu)this.app.getManager(236);
    try
    {
      i = Integer.parseInt(str3);
      QLog.i("JumpAction", 1, "[goToGroupVideoPlugin], roomId:" + str1 + ",fromId:" + str2 + " isGroupCode:" + str3);
      localaicu.a(this.context, str1, this.app.getCurrentUin(), i, "download", str2, str4, str5, str6);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 1;
      }
    }
  }
  
  private boolean acl()
  {
    Object localObject = (String)this.attrs.get("fromid");
    localObject = (aicu)this.app.getManager(236);
    QLog.i("JumpAction", 1, "[goToPreLoadGroupVideoPlugin]");
    ((aicu)localObject).b(null, 10L);
    return true;
  }
  
  private boolean acm()
  {
    Object localObject1 = new StringBuilder((String)this.attrs.get("url"));
    ((StringBuilder)localObject1).append("?a=1");
    Object localObject2 = this.attrs.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str1 = (String)((Iterator)localObject2).next();
      if (!"url".equals(str1))
      {
        try
        {
          String str2 = URLEncoder.encode((String)this.attrs.get(str1), "UTF-8");
          ((StringBuilder)localObject1).append("&");
          ((StringBuilder)localObject1).append(str1);
          ((StringBuilder)localObject1).append("=");
          ((StringBuilder)localObject1).append(str2);
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
        if (QLog.isColorLevel()) {
          QLog.e("JumpAction", 1, localUnsupportedEncodingException, new Object[0]);
        }
      }
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    if (QLog.isDevelopLevel()) {
      QLog.e("JumpAction", 4, "gotoHuayang url==" + (String)localObject1);
    }
    localObject2 = this.context;
    Intent localIntent = new Intent((Context)localObject2, QQBrowserActivity.class);
    localIntent.setFlags(536870912);
    localIntent.putExtra("url", (String)localObject1);
    ((Context)localObject2).startActivity(localIntent);
    return true;
  }
  
  private boolean acn()
  {
    arhz localarhz = new arhz(this.context, 0, 2131558750, 17);
    localarhz.setMessage(this.context.getString(2131690520));
    localarhz.getWindow().setDimAmount(0.0F);
    localarhz.show();
    localarhz.setCanceledOnTouchOutside(true);
    String str1 = (String)this.attrs.get("app");
    if ((TextUtils.isEmpty(str1)) && (QLog.isColorLevel())) {
      QLog.e("JumpAction", 2, "Ark mqqapi://ligthapp/open goToLightAppOpen jumpAction. appName=null");
    }
    String str2 = (String)this.attrs.get("meta");
    String str3 = (String)this.attrs.get("view");
    ArkAppCenter localArkAppCenter = (ArkAppCenter)this.app.getManager(121);
    ArkAppMgr.getInstance().getAppPathByName(str1, str3, "0.0.0.1", "", new aqie(this, localarhz, str3, str2, str1));
    return true;
  }
  
  private boolean aco()
  {
    Object localObject = toBase64Decode((String)this.attrs.get("friendUin"));
    localObject = AddFriendLogicActivity.a((Activity)this.context, 1, (String)localObject, "", 3001, 11, "", "", null, "", "");
    this.context.startActivity((Intent)localObject);
    return true;
  }
  
  private boolean acr()
  {
    int j = 0;
    if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getApplication()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131696273, 1).show();
      return false;
    }
    Object localObject = (String)this.attrs.get("invitorId");
    int i = 10;
    for (;;)
    {
      try
      {
        k = Integer.parseInt((String)this.attrs.get("roomNum"));
        i = k;
      }
      catch (Exception localException3)
      {
        int k;
        long l1;
        long l2;
        label111:
        continue;
      }
      try
      {
        k = Integer.parseInt((String)this.attrs.get("zoneId"));
        j = k;
      }
      catch (Exception localException2) {}
    }
    l1 = -1L;
    try
    {
      l2 = Long.parseLong((String)this.attrs.get("gc"));
      l1 = l2;
    }
    catch (Exception localException1)
    {
      break label111;
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new Intent(this.context, GameRoomTransActivity.class);
      ((Intent)localObject).putExtra("roomNum", i);
      ((Intent)localObject).putExtra("action", 3);
      ((Intent)localObject).putExtra("zoneId", j);
      ((Intent)localObject).putExtra("gc", l1);
      this.context.startActivity((Intent)localObject);
    }
    for (;;)
    {
      return true;
      Intent localIntent = new Intent(this.context, GameRoomTransActivity.class);
      localIntent.putExtra("inviteId", (String)localObject);
      localIntent.putExtra("roomNum", i);
      localIntent.putExtra("zoneId", j);
      localIntent.putExtra("action", 2);
      this.context.startActivity(localIntent);
    }
  }
  
  private boolean acs()
  {
    if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getApplication()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131696273, 1).show();
      return false;
    }
    int i = 10;
    for (;;)
    {
      try
      {
        j = Integer.parseInt((String)this.attrs.get("roomNum"));
        i = j;
      }
      catch (Exception localException2)
      {
        int j;
        Intent localIntent;
        continue;
      }
      try
      {
        j = Integer.parseInt((String)this.attrs.get("zoneId"));
        localIntent = new Intent(this.context, GameRoomTransActivity.class);
        localIntent.putExtra("roomNum", i);
        localIntent.putExtra("zoneId", j);
        localIntent.putExtra("action", 1);
        this.context.startActivity(localIntent);
        return true;
      }
      catch (Exception localException1)
      {
        j = 0;
      }
    }
  }
  
  private boolean act()
  {
    Object localObject = (String)this.attrs.get("appid");
    anot.a(this.app, "CliOper", "", "", "0X80077DE", "0X80077DE", 0, 0, (String)localObject, "", "", "");
    localObject = f();
    Intent localIntent = new Intent(this.context, (Class)localObject);
    if (RegisterPhoneNumActivity.class == localObject) {
      localIntent.putExtra("key_report_extra_from", 5);
    }
    this.context.startActivity(localIntent);
    return true;
  }
  
  private boolean acv()
  {
    boolean bool = ((Boolean)((psr)psx.a(10)).c("key_share_encrypt_flag", Boolean.valueOf(false))).booleanValue();
    String str = (String)this.attrs.get("token");
    if (!TextUtils.isEmpty(str)) {
      qdy.a(this.context, str, new aqif(this), null);
    }
    for (;;)
    {
      return true;
      if (TextUtils.equals(this.ctj, "publish"))
      {
        acw();
      }
      else
      {
        if (bool)
        {
          this.ctj = "open";
          qdy.u(this.attrs);
        }
        acw();
      }
    }
  }
  
  private boolean acw()
  {
    if ((QzoneConfig.getInstance().getConfig("qqstoryvideo", "jump_hyws_scheme_enable", 0) == 0) && (BaseApplicationImpl.getContext() != null))
    {
      ThreadManager.getUIHandler().post(new JumpAction.4(this));
      return false;
    }
    if ((((puz)this.app.getManager(252)).aBT) && (!"open".equals(this.ctj)) && (!"openTag".equals(this.ctj)) && (!"openSquare".equals(this.ctj)) && (!"publish".equals(this.ctj))) {
      return acy();
    }
    String str2 = (String)this.attrs.get("one_page");
    String str1 = str2;
    if (String.valueOf(2).equals(str2))
    {
      puz localpuz = (puz)this.app.getManager(252);
      str1 = str2;
      if (localpuz != null)
      {
        str1 = str2;
        if (!localpuz.aBT)
        {
          str1 = String.valueOf(0);
          this.attrs.put("one_page", str1);
        }
      }
    }
    if ("0".equals(str1)) {
      return acx();
    }
    if ("open".equals(this.ctj)) {
      return acx();
    }
    return acy();
  }
  
  private boolean acx()
  {
    Intent localIntent;
    if (this.app.a().abu)
    {
      ram.d("JumpAction", "startStoryMainActivity, isNowTabShow==true");
      localIntent = new Intent(this.app.getApp(), SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("tab_index", MainFragment.bIp);
      localIntent.putExtra("open_now_tab_fragment", true);
      localIntent.putExtra("extra_from_share", true);
      localIntent.setFlags(335544320);
      localIntent = f(localIntent);
      if ((localIntent != null) && ((this.context instanceof Activity)))
      {
        this.context.startActivity(localIntent);
        return true;
      }
      if (!(this.context instanceof Activity)) {
        ram.e("JumpAction", "Error: context is not instanceof Activity, context is: " + String.valueOf(this.context));
      }
      if (localIntent == null) {
        ram.e("JumpAction", "Error: jumpIntent is null");
      }
      return false;
    }
    ram.d("JumpAction", "startStoryMainActivity, isNowTabShow==false");
    if (((this.context instanceof JumpActivity)) && (!BaseApplicationImpl.appMainActivityHasLanuch))
    {
      localIntent = new Intent(this.app.getApp(), SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("tab_index", MainFragment.bIk);
      localIntent.setFlags(335544320);
      localIntent.putExtra("jump_to_story", true);
    }
    for (;;)
    {
      localIntent = f(localIntent);
      if ((localIntent == null) || ((!(this.context instanceof Activity)) && (!(this.context instanceof BaseApplicationImpl)))) {
        break;
      }
      this.context.startActivity(localIntent);
      return true;
      localIntent = v();
    }
  }
  
  private boolean acy()
  {
    if ("open".equals(this.ctj))
    {
      localObject = new Intent(this.context, QQStoryMainActivity.class);
      ((Activity)this.context).startActivityForResult((Intent)localObject, 8855);
      return true;
    }
    if ("openVideo".equalsIgnoreCase(this.ctj))
    {
      if ((this.context instanceof Activity)) {
        return a(this.app, (Activity)this.context, this.attrs, null);
      }
      return false;
    }
    if ("opencontent".equals(this.ctj)) {
      return b(this.attrs, false);
    }
    if ("opendiscovery".equals(this.ctj)) {
      return acA();
    }
    if ("opentopic".equals(this.ctj)) {
      return acz();
    }
    if ("infoCard".equals(this.ctj)) {
      return a(this.app, (Activity)this.context, this.attrs);
    }
    if ("sharegroupcard".equals(this.ctj)) {
      return b(this.app, (Activity)this.context, this.attrs);
    }
    Object localObject = new qqr((Activity)this.context, new aqic(this));
    Intent localIntent = f(new Intent());
    if (localIntent != null)
    {
      int i = localIntent.getIntExtra("action", 0);
      localIntent.putExtra("action", 0);
      return ((qqr)localObject).b(i, localIntent);
    }
    return false;
  }
  
  private boolean acz()
  {
    Object localObject = (String)this.attrs.get("topicid");
    localObject = (String)this.attrs.get("topicname");
    jE((String)this.attrs.get("sharefromtype"));
    if ((this.context instanceof Activity))
    {
      localObject = (Activity)this.context;
      return true;
    }
    return false;
  }
  
  public static int b(Map<String, String> paramMap, String paramString, int paramInt)
  {
    paramMap = (String)paramMap.get(paramString);
    int i = paramInt;
    if (paramMap != null) {}
    try
    {
      i = Integer.parseInt(paramMap);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      do
      {
        i = paramInt;
      } while (!QLog.isColorLevel());
      QLog.e("JumpAction", 2, "getIntAttribute, NumberFormatException, key:" + paramString + " strVal:" + paramMap);
    }
    return paramInt;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap)
  {
    String str = (String)paramHashMap.get("unionid");
    paramQQAppInterface = (String)paramHashMap.get("fromuid");
    int i = -1;
    try
    {
      int j = Integer.valueOf((String)paramHashMap.get("fromId")).intValue();
      i = j;
    }
    catch (NumberFormatException paramHashMap)
    {
      for (;;)
      {
        QLog.e("JumpAction", 2, "gotoStoryShareGroupCard from id is error:" + paramHashMap);
      }
    }
    paramHashMap = QQStoryShareGroupProfileActivity.a(paramActivity, 2, str, null, i, 0);
    paramHashMap.putExtra("extra_share_from_user_uid", paramQQAppInterface);
    paramActivity.startActivity(paramHashMap);
    return true;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap, String paramString)
  {
    String str3 = (String)paramHashMap.get("videoOwnerUin");
    String str4 = (String)paramHashMap.get("unionid");
    String str1 = (String)paramHashMap.get("fromId");
    paramQQAppInterface = (String)paramHashMap.get("videoId");
    String str5 = (String)paramHashMap.get("type");
    String str2 = (String)paramHashMap.get("videoList");
    int i = c(paramHashMap);
    str2 = (String)paramHashMap.get("feedid");
    b(paramHashMap, "ptype", 0);
    label130:
    int j;
    label149:
    int m;
    label168:
    int k;
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = (String)paramHashMap.get("videoid");
      if (str1 == null)
      {
        str1 = (String)paramHashMap.get("fromid");
        if ((str5 == null) || (!str5.equals("mylist"))) {
          break label707;
        }
        j = 1;
        if ((str5 == null) || (!str5.equals("myonedaylist"))) {
          break label713;
        }
        m = 1;
        if (!"0".equals(paramHashMap.get("identify"))) {
          break label719;
        }
        k = 0;
        try
        {
          label187:
          if ("17".equals(str1))
          {
            if (j == 0) {
              break label285;
            }
            rar.a("mystory", "clk_obj_myday", 0, 0, new String[] { "", "", "", paramQQAppInterface });
          }
          for (;;)
          {
            if (m == 0) {
              break label468;
            }
            paramString = (String)paramHashMap.get("collection_id");
            if (!TextUtils.isEmpty(paramString)) {
              break;
            }
            j = i;
            if (i == 0) {
              j = 30;
            }
            qgg.b(paramActivity, paramQQAppInterface, str2, j);
            break label705;
            label285:
            rar.a("mystory", "clk_obj", 0, 0, new String[] { "", "", "", paramQQAppInterface });
          }
          paramQQAppInterface = (String)paramHashMap.get("time_zone");
        }
        catch (NumberFormatException paramQQAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "gotoStoryPlayVideoPage, NumberFormatException, videoOwnerUin:" + str3 + ",e:" + QLog.getStackTraceString(paramQQAppInterface));
          }
          return false;
        }
        j = -1;
        if (!TextUtils.isEmpty(paramQQAppInterface)) {
          j = Integer.valueOf(paramQQAppInterface).intValue();
        }
        if (!TextUtils.isEmpty(str4))
        {
          qgg.a(paramActivity, str4, VideoCollectionEntry.getCollectionKey(1, paramString, str4), j, i, str2, k, null);
          break label705;
        }
        if (TextUtils.isEmpty(str3)) {
          break label725;
        }
        qgg.a(paramActivity, str3, VideoCollectionEntry.getCollectionKey(1, paramString, str3), j, i, str2, k, null);
        break label705;
        label468:
        if ("17".equals(str1))
        {
          if (j != 0)
          {
            paramQQAppInterface = (String)paramHashMap.get("et");
            paramQQAppInterface = (String)paramHashMap.get("time_zone");
            if (!TextUtils.isEmpty(paramQQAppInterface)) {
              Integer.valueOf(paramQQAppInterface).intValue();
            }
            if (!TextUtils.isEmpty(str4))
            {
              qgg.a(paramActivity, str4, str2, k, i, 0, null);
              break label727;
            }
            if (TextUtils.isEmpty(str3)) {
              break label729;
            }
            qgg.a(paramActivity, str3, str2, k, i, 0, null);
            break label727;
          }
          if ((!TextUtils.isEmpty(str5)) && (str5.equals(String.valueOf(1))))
          {
            j = i;
            if (i == 0) {
              j = 57;
            }
            qgg.c(paramActivity, paramQQAppInterface, str2, j);
            break label727;
          }
          if (!"onedaylist".equals(str5)) {
            break label731;
          }
          qgg.a(paramActivity, str4, str2, k, i, 0, null);
          break label727;
          qgg.c(paramActivity, paramQQAppInterface, str2, j);
          break label727;
        }
        label644:
        if (TextUtils.isEmpty(paramString)) {
          break label747;
        }
        j = i;
        if (i == 0) {
          j = 19;
        }
        qgg.c(paramActivity, paramQQAppInterface, str2, j);
        break label727;
      }
    }
    for (;;)
    {
      qgg.c(paramActivity, paramQQAppInterface, paramHashMap, j);
      break label727;
      break label130;
      break;
      label705:
      return true;
      label707:
      j = 0;
      break label149;
      label713:
      m = 0;
      break label168;
      label719:
      k = 1;
      break label187;
      label725:
      return false;
      label727:
      return true;
      label729:
      return false;
      label731:
      j = i;
      if (i != 0) {
        break label644;
      }
      j = 17;
      break label644;
      label747:
      paramHashMap = str2;
      if (str2 == null) {
        paramHashMap = "JUMP_ACTION_EMPTY_FEED_ID";
      }
      j = i;
      if (i == 0) {
        j = 7;
      }
    }
  }
  
  private boolean b(Map<String, String> paramMap, boolean paramBoolean)
  {
    String str1 = (String)paramMap.get("userid");
    String str2 = (String)paramMap.get("usertype");
    String str3 = (String)paramMap.get("unionid");
    String str4 = (String)paramMap.get("storyid");
    String str5 = (String)paramMap.get("showinfocard");
    c(paramMap);
    if (((str5 == null) || (!str5.equals("0"))) || (TextUtils.isEmpty(str4)))
    {
      if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3))) {
        return false;
      }
      try
      {
        int i = Integer.parseInt(str2);
        if (i == 1)
        {
          if (TextUtils.isEmpty(str1)) {
            return false;
          }
          ppf.f(this.context, 23, str3);
        }
        for (;;)
        {
          return true;
          if (i != 5) {}
        }
        return true;
      }
      catch (NumberFormatException paramMap)
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "gotoStoryPlayVideoPage, NumberFormatException, userId:" + str1 + ", userType:" + str2);
        }
        return false;
      }
    }
  }
  
  private boolean by(boolean paramBoolean)
  {
    Object localObject1 = new Bundle();
    long l;
    int j;
    try
    {
      l = Long.valueOf((String)this.attrs.get("share_id")).longValue();
      if (l <= 0L) {
        return false;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        l = 0L;
      }
      str = toBase64Decode((String)this.attrs.get("open_id"));
      localObject2 = toBase64Decode((String)this.attrs.get("share_uin"));
      localObject3 = toBase64Decode((String)this.attrs.get("share_qzone_ext_str"));
      ((Bundle)localObject1).putString("open_id", str);
      ((Bundle)localObject1).putString("share_uin", (String)localObject2);
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ((Bundle)localObject1).putString("share_ext_string", (String)localObject3);
      }
      j = Integer.valueOf(toBase64Decode((String)this.attrs.get("req_type"))).intValue();
      if (j != 3) {
        break label617;
      }
    }
    String str = toBase64Decode((String)this.attrs.get("description"));
    Object localObject3 = toBase64Decode((String)this.attrs.get("image_url"));
    Object localObject2 = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject3 = ((String)localObject3).split(";");
      int i = 0;
      while (i < localObject3.length)
      {
        ((ArrayList)localObject2).add(URLDecoder.decode(localObject3[i]));
        i += 1;
      }
    }
    ((Bundle)localObject1).putStringArrayList("images", (ArrayList)localObject2);
    ((Bundle)localObject1).putString("summary", str);
    for (str = "7";; str = "") {
      for (;;)
      {
        ((Bundle)localObject1).putString("app_name", toBase64Decode((String)this.attrs.get("app_name")));
        if (!TextUtils.isEmpty(this.pkgName)) {
          ((Bundle)localObject1).putString("hulian_appid", String.valueOf(l));
        }
        ((Bundle)localObject1).putInt("req_type", j);
        ((Bundle)localObject1).putLong("req_share_id", l);
        ((Bundle)localObject1).putString("pkg_name", this.pkgName);
        ((Bundle)localObject1).putBoolean("key_need_save_draft", false);
        ((Bundle)localObject1).putBoolean("key_require_storage_permission", paramBoolean);
        com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.boN = true;
        localObject2 = new aqhz(this);
        avqq.a(this.app, this.context, (Bundle)localObject1, (DialogInterface.OnDismissListener)localObject2);
        localObject2 = new QZoneClickReport.a();
        ((QZoneClickReport.a)localObject2).actionType = "1";
        ((QZoneClickReport.a)localObject2).cMI = "0";
        ((QZoneClickReport.a)localObject2).tabletype = 4;
        ((QZoneClickReport.a)localObject2).sourceType = "5";
        ((QZoneClickReport.a)localObject2).sourceFrom = "thirdApp";
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("source_type", "5");
        ((HashMap)localObject3).put("source_from", "thirdApp");
        localObject1 = ((Bundle)localObject1).getStringArrayList("images");
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 9))
        {
          ((QZoneClickReport.a)localObject2).sourceTo = "QZoneUploadPhotosActivity";
          ((HashMap)localObject3).put("source_to", "QZoneUploadPhotosActivity");
          QZoneClickReport.startReportImediately(this.app.getAccount(), (QZoneClickReport.a)localObject2);
          anpc.a(BaseApplicationImpl.getContext()).collectPerformance(this.app.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject3, null);
          arts.a().a(this.app.getAccount(), "", l + "", "11", "12", "0", str, "", "4", false);
          return true;
          label617:
          if (j == 4) {
            str = toBase64Decode((String)this.attrs.get("videoPath"));
          }
        }
        else
        {
          try
          {
            ((Bundle)localObject1).putLong("file_send_duration", Long.valueOf(toBase64Decode((String)this.attrs.get("videoDuration"))).longValue());
            try
            {
              label670:
              ((Bundle)localObject1).putLong("PhotoConst.VIDEO_SIZE", Long.valueOf(toBase64Decode((String)this.attrs.get("videoSize"))).longValue());
              label700:
              localObject2 = toBase64Decode((String)this.attrs.get("description"));
              ((Bundle)localObject1).putBoolean("PhotoConst.IS_VIDEO_SELECTED", true);
              ((Bundle)localObject1).putInt("PhotoConst.VIDEO_TYPE", 1);
              ((Bundle)localObject1).putString("file_send_path", str);
              ((Bundle)localObject1).putBoolean("need_process", false);
              ((Bundle)localObject1).putString("defaultText", (String)localObject2);
              str = "8";
              continue;
              ((QZoneClickReport.a)localObject2).sourceTo = "QZonePublishMoodActivity";
              ((HashMap)localObject3).put("source_to", "QZonePublishMoodActivity");
            }
            catch (Exception localException2)
            {
              break label700;
            }
          }
          catch (Exception localException3)
          {
            break label670;
          }
        }
      }
    }
  }
  
  public static int c(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("sharefromtype");
    if (paramMap != null) {}
    try
    {
      int i = Integer.parseInt(paramMap);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (!QLog.isColorLevel()) {
        break label60;
      }
      QLog.e("JumpAction", 2, "makeStoryContentPageIntent, NumberFormatException, shareFromStr:" + paramMap);
    }
    return 0;
    label60:
    return 0;
  }
  
  private void cOE()
  {
    this.al = aqha.a(this.context, 2131694214, this.context.getString(2131694198), 2131694200, 2131694199, new aqig(this), new aqih(this));
    this.al.show();
  }
  
  private void cOF()
  {
    Object localObject;
    String str1;
    label54:
    String str2;
    label81:
    String str3;
    label109:
    String str4;
    if (this.attrs.containsKey("packageName"))
    {
      localObject = (String)this.attrs.get("packageName");
      if (!this.attrs.containsKey("signareMode")) {
        break label330;
      }
      str1 = (String)this.attrs.get("signareMode");
      if (!this.attrs.containsKey("appid")) {
        break label336;
      }
      str2 = (String)this.attrs.get("appid");
      if (!this.attrs.containsKey("timeStamp")) {
        break label342;
      }
      str3 = (String)this.attrs.get("timeStamp");
      if (!this.attrs.containsKey("resetWordMode")) {
        break label349;
      }
      str4 = (String)this.attrs.get("resetWordMode");
      label137:
      if (!this.attrs.containsKey("offerid")) {
        break label356;
      }
    }
    label330:
    label336:
    label342:
    label349:
    label356:
    for (String str5 = (String)this.attrs.get("offerid");; str5 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "packageName : " + (String)localObject + " signatureMode :" + str1 + " appid : " + str2 + " timestamp : " + str3 + " resetWordMode : " + str4 + " offerId : " + str5);
      }
      localObject = new ReqCheckChangePwdAuth((String)localObject, str1, str2, str3, str4, str5);
      ((acke)this.app.getBusinessHandler(42)).a((ReqCheckChangePwdAuth)localObject);
      this.jdField_a_of_type_Aqhv$b = new aqhv.b(null);
      this.jdField_b_of_type_Ackf = new ackf(this.jdField_a_of_type_Aqhv$b);
      this.app.addObserver(this.jdField_b_of_type_Ackf);
      return;
      localObject = "";
      break;
      str1 = "";
      break label54;
      str2 = "";
      break label81;
      str3 = "";
      break label109;
      str4 = "";
      break label137;
    }
  }
  
  private void cOG()
  {
    com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.boN = true;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("userId", this.app.getCurrentAccountUin());
      localJSONObject.put("viewTag", "pswManage");
      if (!PayBridgeActivity.tenpay((Activity)this.context, localJSONObject.toString(), 5, "")) {}
      for (int i = 1;; i = 0)
      {
        Kl(i);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Kl(1);
    }
  }
  
  private void cOH()
  {
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("fromTranslucent", 1);
    try
    {
      long l1 = Long.parseLong(getAttribute("uin"));
      int i = Integer.parseInt(getAttribute("appid"));
      Object localObject2 = getAttribute("cellid");
      Object localObject3 = getAttribute("subid");
      long l2 = Long.parseLong(getAttribute("time"));
      ((Bundle)localObject1).putLong("targetuin", Long.valueOf(l1).longValue());
      ((Bundle)localObject1).putInt("appid", i);
      ((Bundle)localObject1).putString("cellid", (String)localObject2);
      ((Bundle)localObject1).putString("subid", (String)localObject3);
      ((Bundle)localObject1).putLong("feedtime", l2);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      QzonePluginProxyActivity.x((Intent)localObject2, "com.qzone.detail.ui.activity.StickyNoteDetailActivity");
      if ((this.context instanceof BaseActivity))
      {
        localObject3 = (BaseActivity)this.context;
        localObject1 = null;
        if (((BaseActivity)localObject3).app != null) {
          localObject1 = ((BaseActivity)localObject3).app.getCurrentUin();
        }
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          QLog.e("JumpAction", 1, "action_open_sticky_note_feed_detail  error! get currentUin failed! " + ((BaseActivity)localObject3).app);
          return;
        }
        QzonePluginProxyActivity.a((Activity)localObject3, (String)localObject1, (Intent)localObject2, 7, true);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("JumpAction", 1, "action_open_sticky_note_feed_detail  error!", localThrowable);
    }
  }
  
  private void cOI()
  {
    String str = getAttribute("buddyuin");
    if (!str.isEmpty())
    {
      long l = Long.parseLong(str);
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "grayTip,openTroopWithCommonFriendsFragment:" + l);
      }
      TroopWithCommonFriendsFragment.zo(str);
      TroopWithCommonFriendsFragment.ac(this.context, 1);
      anot.a(null, "dc00898", "", "", "0X800AD20", "0X800AD20", 0, 0, "0", "0", "", "");
    }
  }
  
  private void d(Bundle paramBundle, int paramInt)
  {
    HashSet localHashSet1 = new HashSet();
    localHashSet1.add(Integer.valueOf(axcg.a.getId()));
    localHashSet1.add(Integer.valueOf(axcg.n.getId()));
    localHashSet1.add(Integer.valueOf(axcg.t.getId()));
    localHashSet1.add(Integer.valueOf(axcg.w.getId()));
    localHashSet1.add(Integer.valueOf(axcg.b.getId()));
    localHashSet1.add(Integer.valueOf(axcg.u.getId()));
    localHashSet1.add(Integer.valueOf(axcg.c.getId()));
    HashSet localHashSet2 = new HashSet();
    localHashSet2.add(Integer.valueOf(axcg.g.getId()));
    localHashSet2.add(Integer.valueOf(axcg.q.getId()));
    localHashSet2.add(Integer.valueOf(axcg.r.getId()));
    localHashSet2.add(Integer.valueOf(axcg.o.getId()));
    localHashSet2.add(Integer.valueOf(axcg.s.getId()));
    localHashSet2.add(Integer.valueOf(axcg.v.getId()));
    if (localHashSet1.contains(Integer.valueOf(paramInt)))
    {
      paramBundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", 1);
      return;
    }
    if (localHashSet2.contains(Integer.valueOf(paramInt)))
    {
      paramBundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", 2);
      return;
    }
    paramBundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", 1);
  }
  
  private void dO(Intent paramIntent)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(this.aIG)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "wrapper Intent failed intent is null or redTouchInfo is Empty");
      }
      return;
    }
    paramIntent.putExtra("redTouch", this.aIG);
  }
  
  @Deprecated
  public static void dt(Bundle paramBundle)
  {
    long l1 = paramBundle.getLong("key_launch_time");
    if (l1 > 0L)
    {
      long l2 = System.currentTimeMillis();
      QLog.d("plugin_tag", 1, "call jumpToVideoStoryLayer timedelay=" + (l2 - l1));
    }
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QzoneVerticalVideoDownloadActivity.class);
    localIntent.putExtra("key_plugin_id", "qzone_vertical_video_plugin.apk");
    localIntent.setFlags(268435456);
    localIntent.putExtras(paramBundle);
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  public static void du(Bundle paramBundle)
  {
    long l1 = paramBundle.getLong("key_launch_time");
    if (l1 > 0L)
    {
      long l2 = System.currentTimeMillis();
      QLog.d("plugin_tag", 1, "call jumpToQZoneVideoLayer timedelay=" + (l2 - l1));
    }
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QzoneVerticalVideoDownloadActivity.class);
    localIntent.putExtra("key_plugin_id", "qzone_vertical_video_plugin.apk");
    localIntent.setFlags(268435456);
    localIntent.putExtras(paramBundle);
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  private void dv(Bundle paramBundle)
  {
    Intent localIntent = new Intent(this.context, SplashActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("thridparty_pull_main", true);
    localIntent.addFlags(67108864);
    localIntent.addFlags(268435456);
    this.context.startActivity(localIntent);
  }
  
  private boolean e(String paramString1, String paramString2, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("PayInvokerId", 13);
    localBundle.putString("viewParam", paramString1);
    if (paramString2 != null) {
      localBundle.putString("entry", paramString2);
    }
    paramString1 = new Intent(this.context, JumpActivity.class);
    paramString1.putExtra("srvBundle", localBundle);
    if (paramLong != 0L) {
      paramString1.putExtra("vacreport_key_seq", paramLong);
    }
    paramString1.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=10&entry=" + paramString2 + "&seq=" + paramLong));
    this.context.startActivity(paramString1);
    return true;
  }
  
  private void edL()
  {
    String str1 = getAttribute("payurl");
    if (!TextUtils.isEmpty(str1))
    {
      String str2 = new String(Base64.decode(str1, 0));
      if (!TextUtils.isEmpty(str2))
      {
        QLog.e("JumpAction", 1, "payurl is call to launch");
        aqrf.cU(this.context, str2);
        return;
      }
      QLog.e("JumpAction", 1, "payurl cant not decode to base64 =" + str1);
      return;
    }
    QLog.e("JumpAction", 1, "payurl is null");
  }
  
  private void edM()
  {
    if (this.attrs.containsKey("params")) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(URLDecoder.decode((String)this.attrs.get("params")));
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "urlParamObj: " + localJSONObject);
      }
      if (localJSONObject.optInt("view_type", 0) == 0)
      {
        localJSONObject = localJSONObject.optJSONObject("params");
        if (localJSONObject != null) {
          ReminderListFragment.launch(this.context, localJSONObject.optString("notice_time"));
        }
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("JumpAction", 2, "JumpAction parse url throw an exception: " + localException);
    }
  }
  
  private void edN()
  {
    if ((this.attrs.containsKey("scheme")) && (this.attrs.containsKey("msgid")) && (this.attrs.containsKey("busiid")))
    {
      String str2 = (String)this.attrs.get("msgid");
      String str3 = (String)this.attrs.get("busiid");
      String str4 = (String)this.attrs.get("scheme");
      String str1 = "";
      if (this.attrs.containsKey("domain")) {
        str1 = (String)this.attrs.get("domain");
      }
      QQNotifySettingFragment.b(this.context, str2, str3, str4, str1);
    }
  }
  
  private void edO()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne((String)this.attrs.get("uin"), 111);
    if ("1".equals(this.attrs.get("source"))) {
      localAllInOne.bJa = 118;
    }
    for (;;)
    {
      ProfileActivity.b(this.context, localAllInOne);
      return;
      if ("2".equals(this.attrs.get("source"))) {
        localAllInOne.bJa = 121;
      }
    }
  }
  
  private void edP()
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QzoneVerticalVideoDownloadActivity.class);
    localIntent.putExtra("key_plugin_id", "qzone_weishi_feeds_plugin.apk");
    localIntent.setFlags(268435456);
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  private void edQ()
  {
    Intent localIntent = new Intent(this.context, ReadInJoyDeliverUGCActivity.class);
    localObject2 = "";
    Object localObject4 = "";
    str = "";
    localObject1 = localObject2;
    localObject3 = localObject2;
    try
    {
      if (this.attrs.containsKey("topicid"))
      {
        localObject1 = localObject2;
        localObject3 = localObject2;
        if (this.attrs.get("topicid") != null)
        {
          localObject3 = localObject2;
          localObject1 = (String)this.attrs.get("topicid");
        }
      }
      localObject2 = localObject4;
      localObject3 = localObject1;
      if (this.attrs.containsKey("topicname"))
      {
        localObject2 = localObject4;
        localObject3 = localObject1;
        if (this.attrs.get("topicname") != null)
        {
          localObject3 = localObject1;
          localObject2 = new String(aqgo.decode((String)this.attrs.get("topicname"), 0));
        }
      }
      localObject3 = str;
      localObject4 = str;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        label265:
        str = "";
        localObject2 = "";
        localObject1 = localObject3;
        localObject3 = str;
        localException1.printStackTrace();
        i = 0;
      }
    }
    try
    {
      if (this.attrs.containsKey("cookie"))
      {
        localObject3 = str;
        localObject4 = str;
        if (this.attrs.get("cookie") != null)
        {
          localObject4 = str;
          localObject3 = (String)this.attrs.get("cookie");
        }
      }
      localObject4 = localObject3;
      if (!this.attrs.containsKey("adtag")) {
        break label375;
      }
      localObject4 = localObject3;
      if (this.attrs.get("adtag") == null) {
        break label375;
      }
      localObject4 = localObject3;
      i = Integer.valueOf((String)this.attrs.get("adtag")).intValue();
    }
    catch (Exception localException2)
    {
      localObject3 = localException1;
      Object localObject5 = localException2;
      break label352;
      i = 0;
      break label265;
    }
    localIntent.putExtra("arg_topic_id", (String)localObject1);
    localIntent.putExtra("support_topic", true);
    localIntent.putExtra("support_linkify", true);
    localIntent.putExtra("arg_topic_name", (String)localObject2);
    localIntent.putExtra("arg_ad_tag", i);
    localIntent.putExtra("arg_ugc_edit_cookie", (String)localObject3);
    this.context.startActivity(localIntent);
  }
  
  private void edR()
  {
    if ((this.context != null) && ((this.context instanceof JumpActivity))) {
      ((JumpActivity)this.context).finish();
    }
  }
  
  private void edS()
  {
    try
    {
      if ("head".equals(this.ctj))
      {
        if (this.jdField_a_of_type_Aqhv$a == null) {
          this.jdField_a_of_type_Aqhv$a = new aqhv.a(this);
        }
        if (this.y == null) {
          this.y = new Hashtable();
        }
        this.app.addObserver(this.jdField_a_of_type_Aqhv$a);
        long l = System.currentTimeMillis();
        String[] arrayOfString = ((String)this.attrs.get("uin")).split(",");
        FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(1);
        int i = 0;
        while (i < arrayOfString.length)
        {
          String str = arrayOfString[i];
          localFriendListHandler.DH(str);
          this.y.put(str, Long.valueOf(l));
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("JumpAction", 2, "handleMQQService error " + localException.toString());
      }
    }
  }
  
  private Intent f(Intent paramIntent)
  {
    if (!TextUtils.isEmpty((String)this.attrs.get("parter_api"))) {}
    for (boolean bool = true;; bool = false)
    {
      ram.b("JumpAction", "makeStoryJumpActivity() action=%s isFromApi=%s", this.ctj, Boolean.valueOf(bool));
      ram.b("JumpAction", "makeStoryJumpActivity() attr=%s", String.valueOf(this.attrs));
      if (!"open".equals(this.ctj)) {
        break;
      }
      paramIntent.putExtra("redid", (String)this.attrs.get("redid"));
      paramIntent.putExtra("lebaVersion", (String)this.attrs.get("lebaVersion"));
      if (bool) {
        rar.a("basic", "use_api", 0, 0, new String[] { "1", (String)this.attrs.get("parter_api") });
      }
      return paramIntent;
    }
    String str1;
    if (("openVideo".equals(this.ctj)) || ("openvideo".equals(this.ctj)))
    {
      if (bool)
      {
        str1 = "userId=" + (String)this.attrs.get("videoOwnerUin") + "&vid=" + (String)this.attrs.get("videoId");
        rar.a("basic", "use_api", 0, 0, new String[] { "6", (String)this.attrs.get("parter_api"), "", str1 });
      }
      return g(paramIntent);
    }
    String str2;
    String str4;
    String str5;
    if ("opencontent".equals(this.ctj))
    {
      if (bool)
      {
        str1 = (String)this.attrs.get("userid");
        str2 = (String)this.attrs.get("usertype");
        str4 = (String)this.attrs.get("storyid");
        str5 = (String)this.attrs.get("unionid");
        if (!TextUtils.isEmpty(str4)) {
          break label473;
        }
      }
      label473:
      for (str1 = "unionId=" + str5 + "&userId=" + str1 + "&userType=" + str2;; str1 = "storyId=" + str4)
      {
        rar.a("basic", "use_api", 0, 0, new String[] { "4", (String)this.attrs.get("parter_api"), "", str1 });
        return j(paramIntent);
      }
    }
    if ("opentopic".equals(this.ctj))
    {
      if (bool)
      {
        str1 = "topicId=" + (String)this.attrs.get("topicid");
        rar.a("basic", "use_api", 0, 0, new String[] { "5", (String)this.attrs.get("parter_api"), "", str1 });
      }
      return h(paramIntent);
    }
    if ("opendiscovery".equals(this.ctj))
    {
      if (bool) {
        rar.a("content_flow", "use_api", 0, 0, new String[] { "", (String)this.attrs.get("parter_api") });
      }
      return i(paramIntent);
    }
    if ("publish".equals(this.ctj))
    {
      if (bool) {
        rar.a("basic", "use_api", 0, 0, new String[] { "2", (String)this.attrs.get("parter_api") });
      }
      paramIntent.putExtra("story_default_label", (String)this.attrs.get("default_label"));
      str1 = (String)this.attrs.get("from_type");
      str2 = (String)this.attrs.get("capture_mode");
      str4 = (String)this.attrs.get("tab_id");
      str5 = (String)this.attrs.get("category_id");
      String str6 = (String)this.attrs.get("item_id");
      String str7 = (String)this.attrs.get("album_id");
      String str8 = (String)this.attrs.get("one_page");
      String str9 = (String)this.attrs.get("dispatch_event");
      paramIntent.putExtra("cameraDirection", 2);
      paramIntent.putExtra("story_game_id", str4);
      paramIntent.putExtra("story_capture_album_id", str7);
      if (!TextUtils.isEmpty(str9)) {
        paramIntent.putExtra("web_dispatch_event", str9);
      }
      try
      {
        if (!TextUtils.isEmpty(str8)) {
          paramIntent.putExtra("key_finish_jump_to_page", Integer.valueOf(str8));
        }
        if (!TextUtils.isEmpty(str2)) {
          paramIntent.putExtra("capture_intent_mode", Integer.valueOf(str2));
        }
        if (!TextUtils.isEmpty(str4)) {
          paramIntent.putExtra("firsttab", Integer.valueOf(str4));
        }
        if (!TextUtils.isEmpty(str5)) {
          paramIntent.putExtra("secondtab", Integer.valueOf(str5));
        }
        paramIntent.putExtra("itemid", str6);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.e("Q.qqstory.publish.JumpAction", 2, "start story publish, NumberFormatException, attrs=" + this.attrs.toString() + "\n" + localNumberFormatException);
        }
      }
      paramIntent.putExtra("from_type", str1);
      paramIntent.putExtra("action", 1);
      return paramIntent;
    }
    String str3;
    if ("infoCard".equals(this.ctj))
    {
      str1 = (String)this.attrs.get("uin");
      str3 = (String)this.attrs.get("usertype");
      str4 = (String)this.attrs.get("fromId");
      str5 = (String)this.attrs.get("unionid");
      if ((TextUtils.isEmpty(str3)) || ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str5))) || (TextUtils.isEmpty(str4))) {
        return null;
      }
      try
      {
        paramIntent.putExtra("union_id", str5);
        paramIntent.putExtra("qq_number", Long.valueOf(str1));
        paramIntent.putExtra("source", Integer.valueOf(str4));
        paramIntent.putExtra("action", 11);
        return paramIntent;
      }
      catch (NumberFormatException paramIntent)
      {
        return null;
      }
    }
    if ("sharegroupcard".equals(this.ctj))
    {
      str1 = (String)this.attrs.get("unionid");
      str3 = (String)this.attrs.get("fromId");
      str4 = (String)this.attrs.get("fromuid");
      try
      {
        paramIntent.putExtra("union_id", str1);
        paramIntent.putExtra("extra_share_from_uid", str4);
        paramIntent.putExtra("source", Integer.valueOf(str3));
        paramIntent.putExtra("action", 13);
        return paramIntent;
      }
      catch (NumberFormatException paramIntent)
      {
        return null;
      }
    }
    if ("openTag".equals(this.ctj))
    {
      str1 = (String)this.attrs.get("tag_id");
      str3 = (String)this.attrs.get("tag_type");
      paramIntent.putExtra("action", 14);
      paramIntent.putExtra("tag_id", str1);
      paramIntent.putExtra("tag_type", str3);
      return paramIntent;
    }
    if ("openSquare".equals(this.ctj))
    {
      paramIntent.putExtra("action", 15);
      return paramIntent;
    }
    return null;
  }
  
  private Class f()
  {
    int i = BaseApplicationImpl.getApplication().appActivities.size() - 1;
    while (i >= 0)
    {
      Object localObject = (WeakReference)BaseApplicationImpl.getApplication().appActivities.get(i);
      if (localObject != null) {
        localObject = (AppActivity)((WeakReference)localObject).get();
      }
      while (localObject != null)
      {
        localObject = ((Activity)localObject).getLocalClassName();
        if ("activity.RegisterPersonalInfoActivity".equals(localObject))
        {
          return RegisterPersonalInfoActivity.class;
          localObject = null;
        }
        else
        {
          if ("activity.RegisterChooseLoginActivity".equals(localObject)) {
            return RegisterChooseLoginActivity.class;
          }
          if ("activity.RegisterVerifyCodeActivity".equals(localObject)) {
            return RegisterVerifyCodeActivity.class;
          }
          if ("activity.RegisterByNicknameAndPwdActivity".equals(localObject)) {
            return RegisterByNicknameAndPwdActivity.class;
          }
          if ("activity.RegisterSendUpSms".equals(localObject)) {
            return RegisterSendUpSms.class;
          }
          if ("activity.RegisterPhoneNumActivity".equals(localObject)) {
            return RegisterPhoneNumActivity.class;
          }
        }
      }
      i -= 1;
    }
    return RegisterPhoneNumActivity.class;
  }
  
  public static boolean isNumeric(String paramString)
  {
    return Pattern.compile("[0-9]+").matcher(paramString).matches();
  }
  
  public static String jE(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      int i = Integer.valueOf(paramString).intValue();
      switch (i)
      {
      default: 
        return paramString;
      case 21: 
        return "2";
      case 20: 
        return "3";
      case 15: 
        return "4";
      case 3001: 
        return "5";
      case 22: 
        return "6";
      }
      return "7";
    }
    catch (NumberFormatException localNumberFormatException) {}
    return paramString;
  }
  
  private boolean kK(String paramString)
  {
    int k = 0;
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return true;
      paramString = paramString.split("\\?");
    } while ((paramString == null) || (paramString.length < 2));
    long l1 = 0L;
    paramString = paramString[1];
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(URLDecoder.decode(paramString.substring(paramString.indexOf('=') + 1), "UTF-8"));
        int i = ((JSONObject)localObject).optInt("gameId");
        j = k;
        long l2;
        paramString.printStackTrace();
      }
      catch (Exception paramString)
      {
        try
        {
          l2 = ((JSONObject)localObject).optLong("roomId");
          l1 = l2;
          j = k;
          paramString = ((JSONObject)localObject).optString("gameName");
          l1 = l2;
          j = k;
          k = ((JSONObject)localObject).optInt("gameMode");
          l1 = l2;
          j = k;
          localObject = ((JSONObject)localObject).optString("extendInfo");
          l1 = l2;
          j = k;
          ApolloGameUtil.a(this.app, i, l2, k, (String)localObject, 204, paramString);
          j = k;
          l1 = l2;
          QLog.i("JumpAction", 1, "[gotoCmShowGame], gameId:" + i + ",roomId:" + l1 + ",gameMode:" + j);
          return true;
        }
        catch (Exception paramString)
        {
          break label223;
        }
        paramString = paramString;
        i = 0;
      }
      label223:
      QLog.w("JumpAction", 1, "[gotoCmShowGame], errInfo->" + paramString.getMessage());
    }
  }
  
  private void kj(int paramInt1, int paramInt2)
  {
    String str1;
    if (this.attrs.containsKey("qidian")) {
      str1 = (String)this.attrs.get("qidian");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str1)) {}
      try
      {
        i = Integer.valueOf(str1).intValue();
        if (i == 1)
        {
          if (this.attrs.containsKey("jsondata"))
          {
            str1 = (String)this.attrs.get("jsondata");
            ((ashy)this.app.getBusinessHandler(85)).aT(str1, paramInt1, paramInt2);
          }
        }
        else
        {
          return;
          str1 = "";
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i = 0;
          continue;
          String str2 = "";
        }
      }
    }
  }
  
  public static String replaceUrlParam(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3))) {
      return paramString1;
    }
    try
    {
      String str = URLEncoder.encode(paramString3, "UTF-8");
      paramString3 = str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    if (paramString1.contains(paramString2)) {
      return paramString1.replace(paramString2, paramString3);
    }
    return paramString1.replace(paramString2.toUpperCase(), paramString3);
  }
  
  private boolean ru(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || (this.app.getCurrentAccountUin().equals(paramString))) {
      return false;
    }
    if (paramString.length() < 5) {
      return false;
    }
    String str4 = (String)this.attrs.get("visitid");
    if (TextUtils.isEmpty(str4)) {
      return false;
    }
    Object localObject;
    String str1;
    label119:
    String str2;
    label159:
    String str3;
    if (this.attrs.get("kfuin") != null)
    {
      localObject = (String)this.attrs.get("kfuin");
      if (this.attrs.get("extuin") == null) {
        break label342;
      }
      str1 = (String)this.attrs.get("extuin");
      if (this.attrs.get("name") == null) {
        break label349;
      }
      str2 = toBase64Decode(((String)this.attrs.get("name")).replace(" ", "+"));
      ashy localashy = (ashy)this.app.getBusinessHandler(85);
      boolean bool = false;
      if (this.attrs.get("cspecialflag") == null) {
        break label356;
      }
      str3 = (String)this.attrs.get("cspecialflag");
      label203:
      if (!TextUtils.isEmpty(str3)) {
        bool = asgx.mS(Integer.valueOf(str3).intValue());
      }
      localashy.a(str4, this.app.getCurrentAccountUin(), (String)localObject, str1, paramString, bool);
      localObject = (acff)this.app.getManager(51);
      if ((localObject == null) || (!((acff)localObject).isFriend(paramString)) || (paramString.equals(this.app.getCurrentAccountUin()))) {
        break label363;
      }
      localObject = new alcn();
      ((alcn)localObject).e = new ProfileActivity.AllInOne(paramString, 1);
      ((alcn)localObject).gh = new String[7];
      ((alcn)localObject).gh[4] = str2;
      FriendProfileCardActivity.b(this.app, (BaseActivity)this.context, (alcn)localObject);
    }
    for (;;)
    {
      return true;
      localObject = "";
      break;
      label342:
      str1 = "";
      break label119;
      label349:
      str2 = "";
      break label159;
      label356:
      str3 = "";
      break label203;
      label363:
      paramString = AddFriendLogicActivity.a((BaseActivity)this.context, 1, paramString, null, 3999, 0, str2, null, null, this.context.getString(2131691039), null);
      paramString.putExtra("webImVisitId", str4);
      paramString.putExtra("webim_qd_ext", true);
      if (BaseActivity.sTopActivity == null) {
        paramString.putExtra("need_jumpto_splash", true);
      }
      this.context.startActivity(paramString);
    }
  }
  
  private boolean rv(String paramString)
  {
    String str = toBase64Decode((String)this.attrs.get("image_uri"));
    if (!TextUtils.isEmpty(str))
    {
      this.cUe = false;
      ThreadManagerV2.executeOnSubThread(new JumpAction.20(this, str, paramString));
      return false;
    }
    return I(paramString, true);
  }
  
  private void t(Intent paramIntent, String paramString)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "wpaParamsParse---Start");
    }
    int i;
    if (this.attrs.get("paramencrypted_type") == null)
    {
      i = 0;
      paramIntent.putExtra("from3rdApp", true);
      if (i != 1) {
        break label239;
      }
    }
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "params must be decrypted");
        }
        paramString = aqgo.decode(new Cryptor().decrypt(aqhs.hexStr2Bytes(paramString), "Hf7K(s*js12LiskW".getBytes()), 0);
        if (paramString == null) {
          break label293;
        }
        paramString = new JSONObject(new String(paramString));
        boolean bool1 = bool2;
        if (paramString.has("layout"))
        {
          bool1 = bool2;
          if (paramString.getString("layout") != null) {
            bool1 = true;
          }
        }
        paramIntent.putExtra("showFirstStructMsg", bool1);
        if (paramString != null)
        {
          paramString = ChatActivityUtils.b(paramString);
          paramIntent.putExtra("stuctmsg_bytes", paramString);
          if ((paramString != null) && (i == 1)) {
            anot.a(this.app, "CliOper", "", (String)this.attrs.get("uin"), "0X8004B50", "0X8004B50", 0, 0, "", "", "", "");
          }
        }
        return;
      }
      catch (JSONException paramIntent)
      {
        label239:
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.e("JumpAction", 4, "wpaParamsParse---JSONException");
        return;
      }
      i = Integer.parseInt((String)this.attrs.get("paramencrypted_type"));
      break;
      paramIntent.putExtra("fromSencondhandCommunity", true);
      paramString = new JSONObject(paramString);
      paramIntent.putExtra("gid", paramString.getString("gid"));
      continue;
      label293:
      paramString = null;
    }
  }
  
  public static String toBase64Decode(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || (paramString.length() == 0)) {
      return null;
    }
    try
    {
      paramString = new String(aqgo.decode(paramString, 0));
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private Intent v()
  {
    ((pso)psx.a(18)).IH();
    Intent localIntent = new Intent(this.context, QQStoryMainActivity.class);
    localIntent.setFlags(67108864);
    return localIntent;
  }
  
  public void K(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap != null) {
      this.attrs.putAll(paramHashMap);
    }
  }
  
  public void SC(boolean paramBoolean)
  {
    this.cUc = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("Jumpaction", 2, "setNewFlag.newflag=" + this.cUc);
    }
  }
  
  public void SD(boolean paramBoolean)
  {
    this.dw = paramBoolean;
  }
  
  public void UH(String paramString)
  {
    this.pkgSig = paramString;
  }
  
  public void UJ(String paramString)
  {
    this.aIG = paramString;
  }
  
  public boolean aCO()
  {
    return this.cUf;
  }
  
  public boolean aCP()
  {
    new JumpAction.1(this).start();
    return ace();
  }
  
  public boolean aDO()
  {
    return (this.cti.equals("card")) && (this.ctj.equals("show_pslcard")) && ("public_account".equals(this.attrs.get("card_type"))) && ("app".equals(this.attrs.get("src_type"))) && (!TextUtils.isEmpty((CharSequence)this.attrs.get("share_id")));
  }
  
  public boolean aDP()
  {
    return (this.cti.equals("share")) && (this.ctj.equals("to_fri"));
  }
  
  public boolean aDg()
  {
    if ((this.cti.equals("im")) && (this.ctj.equals("aioorprofile"))) {}
    while (((this.cti.equals("group")) && (this.ctj.equals("creategroup"))) || ((this.cti.equals("qstory")) && (this.ctj.equals("publish")))) {
      return true;
    }
    return false;
  }
  
  public boolean aEA()
  {
    String str = (String)this.attrs.get("id");
    if (str == null) {
      return false;
    }
    try
    {
      l = Long.parseLong(str);
      if (l == -1L) {
        return false;
      }
    }
    catch (Exception localException)
    {
      long l;
      for (;;)
      {
        l = -1L;
      }
      Intent localIntent = new Intent(this.context, LebaSearchPluginManagerActivity.class);
      localIntent.putExtra("id", l);
      this.context.startActivity(localIntent);
    }
    return true;
  }
  
  public boolean aEB()
  {
    Object localObject = (String)this.attrs.get("account_type");
    if ((localObject != null) && ("public_account".equals(localObject)))
    {
      int i = ocp.getAccountType(Integer.parseInt((String)this.attrs.get("account_flag")));
      if ((i == -3) || (i == -4)) {
        ((PublicAccountHandler)this.app.getBusinessHandler(11)).m((String)this.attrs.get("uin"), 0L, 1);
      }
    }
    do
    {
      do
      {
        return true;
      } while ((localObject == null) || (!"crm".equals(localObject)));
      localObject = (aceb)this.app.getBusinessHandler(21);
    } while (localObject == null);
    ((aceb)localObject).hq(SystemClock.uptimeMillis());
    return true;
  }
  
  public boolean aEC()
  {
    String str3 = (String)this.attrs.get("channelid");
    Object localObject1 = (String)this.attrs.get("channelname");
    String str1 = (String)this.attrs.get("type");
    String str5 = (String)this.attrs.get("target");
    int j;
    int i;
    if ("1".equals(str5))
    {
      localObject1 = (String)this.attrs.get("from");
      if ("qzone".equals(localObject1)) {
        kbp.a(this.app, "CliOper", "", "", "0X80067C6", "0X80067C6", 0, 0, "", "1", this.app.getCurrentAccountUin(), "", false);
      }
      if ("webview".equals(this.from)) {
        skj.a().h((String)localObject1, this.attrs);
      }
      for (;;)
      {
        return true;
        j = 12;
        i = j;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          i = j;
          if (TextUtils.isDigitsOnly((CharSequence)localObject1)) {
            i = Integer.valueOf((String)localObject1).intValue();
          }
        }
        if (awit.aME())
        {
          try
          {
            localObject1 = kgw.a(this.context, i);
            if (i == 16)
            {
              ((Intent)localObject1).putExtra("redpackid", (String)this.attrs.get("redpackid"));
              ((Intent)localObject1).putExtra("redpack_type", 3);
              ((Intent)localObject1).putExtra("plat_source", aurg.t((String)this.attrs.get("plat_source")));
            }
            this.context.startActivity((Intent)localObject1);
          }
          catch (Exception localException1) {}
          if (QLog.isColorLevel()) {
            QLog.e("JumpAction", 1, "jump activity error1 ", localException1);
          }
        }
        else if (i == 16)
        {
          i = aurg.t((String)this.attrs.get("plat_source"));
          RIJRedPacketManager.a().a(BaseActivity.sTopActivity, (String)this.attrs.get("redpackid"), 3, i, false, null);
        }
        else if (awit.cA(this.app))
        {
          kgw.b(this.app, this.context, 2, 0);
        }
        else
        {
          kgw.a(this.context, null, -1L, 2);
        }
      }
    }
    int k;
    Object localObject2;
    if ("2".equals(str5))
    {
      if (str3 == null) {
        return false;
      }
      try
      {
        j = Integer.parseInt(str3);
      }
      catch (Exception localException8)
      {
        try
        {
          for (;;)
          {
            k = Integer.parseInt(str1);
            if (j != -1) {
              break;
            }
            return false;
            localException8 = localException8;
            if (QLog.isDevelopLevel()) {
              QLog.e("JumpAction", 4, "gotoReadInJoy channelId error");
            }
            j = -1;
          }
        }
        catch (Exception localException5)
        {
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              QLog.e("JumpAction", 4, "gotoReadInJoy channelType error");
            }
            k = 0;
          }
        }
      }
      if (!TextUtils.isEmpty(localException1)) {
        break label1555;
      }
      localObject2 = this.context.getString(2131701894);
    }
    label1555:
    for (;;)
    {
      for (;;)
      {
        String str4;
        for (;;)
        {
          for (;;)
          {
            boolean bool = "1".equalsIgnoreCase((String)this.attrs.get("ispush"));
            if ((!bool) && (j == 70))
            {
              if ("webview".equals(this.from)) {
                skj.a().bzt();
              }
              for (;;)
              {
                return true;
                KandianSubscribeManager.e(this.context, 3, 4);
              }
            }
            if (k == 3)
            {
              if (j == 56)
              {
                if (awit.Vs())
                {
                  kgw.a(this.context, j, (String)localObject2, k, 4);
                  break;
                }
                kgw.b(this.app, this.context, 4, 1);
                break;
              }
              kgw.b(this.context, j, (String)localObject2, k, 4);
              break;
            }
            String str2 = (String)this.attrs.get("changeChannelOrder");
            i = 0;
            str4 = (String)this.attrs.get("moveChannelFromSource");
            try
            {
              m = Integer.valueOf(str2).intValue();
              i = m;
              int n = Integer.valueOf(str4).intValue();
              i = n;
            }
            catch (Exception localException6)
            {
              int m;
              for (;;)
              {
                if (QLog.isDevelopLevel()) {
                  QLog.e("JumpAction", 4, "gotoReadInJoy channelOrder error," + localException6.toString());
                }
                m = i;
                i = 0;
              }
              Bundle localBundle = new Bundle();
              localBundle.putInt("key_native_channel_id", j);
              localBundle.putInt("key_native_channel_change_order", m);
              localBundle.putString("key_native_channel_name", (String)localObject2);
              localBundle.putInt("key_native_channel_type", k);
              localBundle.putBoolean("key_native_channel_is_push", bool);
              localBundle.putInt("key_channel_source_from", i);
              localBundle.putString("key_channel_jump_scheme", this.source);
              QIPCClientHelper.getInstance().callServer("ReadInJoyIPCModule", "action_native_channel_jump", localBundle, null);
            }
            ReadInJoyBaseFragment.cn(j, 3);
            if ((this.attrs.containsKey("v_url")) || (this.attrs.containsKey("v_url_base64")))
            {
              localObject2 = new Bundle();
              ((Bundle)localObject2).putString("key_viola_fragment_jump_url", this.source);
              ((Bundle)localObject2).putInt("key_native_channel_change_order", m);
              ((Bundle)localObject2).putInt("key_native_channel_id", j);
              QIPCClientHelper.getInstance().callServer("ReadInJoyIPCModule", "action_viola_fragment_jump", (Bundle)localObject2, null);
              break;
            }
            break;
            if (!"2001".equals(str5)) {
              break label1044;
            }
            i = Integer.valueOf((String)this.attrs.get("from")).intValue();
            if (!awit.aMG()) {
              break label1003;
            }
            try
            {
              localObject2 = kgw.a(this.context, i);
              this.context.startActivity((Intent)localObject2);
            }
            catch (Exception localException2) {}
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("JumpAction", 1, "jump activity error1 ", localException2);
          break;
          label1003:
          if (awit.cA(this.app))
          {
            kgw.b(this.app, this.context, i, 0);
            break;
          }
          kgw.a(this.context, null, -1L, i);
          break;
          label1044:
          Object localObject3;
          if ("3".equals(str5))
          {
            localObject3 = kgw.b(this.context, this.attrs);
            if ((this.context instanceof FastWebActivity))
            {
              ((FastWebActivity)this.context).aT((Intent)localObject3);
              break;
            }
            this.context.startActivity((Intent)localObject3);
            break;
          }
          if ("4".equals(str5))
          {
            localObject3 = this.context;
            if (BaseActivity.sTopActivity != null) {
              localObject3 = BaseActivity.sTopActivity;
            }
            kgw.a((Context)localObject3, this.attrs);
            break;
          }
          if ("5".equals(str5))
          {
            kgw.b(this.context, this.attrs);
            break;
          }
          if (!"6".equals(str5)) {
            break label1276;
          }
          if (!this.attrs.containsKey("v_url_base64")) {
            break;
          }
          try
          {
            localObject3 = toBase64Decode((String)this.attrs.get("v_url_base64"));
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              break;
            }
            ntp.b(this.context, "", (String)localObject3, null);
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
            QLog.w("JumpAction", 1, "[gotoReadInJoyFromSourceTarget] openViolaPage, v_url error->" + localException3.getMessage());
          }
        }
        break;
        label1276:
        if ("7".equals(str5))
        {
          kgw.c(this.context, this.attrs);
          break;
        }
        if ("8".equals(str5))
        {
          if ("webview".equals(this.from))
          {
            skj.a().tn(this.from);
            break;
          }
          KandianDailyManager.bV(this.context);
          break;
        }
        if ("9".equals(str5))
        {
          awix.f(this.context, this.attrs);
          break;
        }
        if (str4 == null) {
          return false;
        }
        try
        {
          i = Integer.parseInt(str4);
          if (i == -1) {
            return false;
          }
        }
        catch (Exception localException7)
        {
          Object localObject4;
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              QLog.e("JumpAction", 4, "gotoReadInJoy channelId error");
            }
            i = -1;
            continue;
            localObject4 = localException3;
            if (TextUtils.isEmpty(localException3)) {
              localObject4 = this.context.getString(2131701894);
            }
            if (!awit.Vs()) {
              break label1492;
            }
            try
            {
              Intent localIntent1 = kgw.a(this.context, 12);
              this.context.startActivity(localIntent1);
            }
            catch (Exception localException4) {}
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("JumpAction", 1, "jump activity error1 ", localException4);
          break;
          label1492:
          Intent localIntent2 = new Intent("android.intent.action.MAIN");
          localIntent2.putExtra("channel_id", i);
          localIntent2.putExtra("channel_name", (String)localObject4);
          localIntent2.putExtra("readinjoy_launch_source", 7);
          awit.b(this.app, (Activity)this.context, localIntent2);
        }
      }
      break;
    }
  }
  
  public boolean aED()
  {
    int k = 0;
    String str1;
    if (this.attrs.containsKey("sub_action"))
    {
      str1 = (String)this.attrs.get("sub_action");
      if (!this.attrs.containsKey("action_name")) {
        break label134;
      }
    }
    label134:
    for (String str2 = (String)this.attrs.get("action_name");; str2 = "")
    {
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        break label141;
      }
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "subAction[" + str1 + "] or actionName[" + str2 + "] null");
      }
      return true;
      str1 = "";
      break;
    }
    label141:
    String str3;
    label169:
    String str4;
    label197:
    String str5;
    if (this.attrs.containsKey("tag"))
    {
      str3 = (String)this.attrs.get("tag");
      if (!this.attrs.containsKey("main_action")) {
        break label578;
      }
      str4 = (String)this.attrs.get("main_action");
      if (!this.attrs.containsKey("to_uin")) {
        break label585;
      }
      str5 = (String)this.attrs.get("to_uin");
      label225:
      if ((!this.attrs.containsKey("from_type")) || (TextUtils.isEmpty((CharSequence)this.attrs.get("from_type")))) {
        break label634;
      }
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "webReportT get from_type: " + (String)this.attrs.get("from_type"));
      }
    }
    for (;;)
    {
      try
      {
        i = Integer.parseInt((String)this.attrs.get("from_type"));
        j = k;
        if (this.attrs.containsKey("result"))
        {
          j = k;
          if (!TextUtils.isEmpty((CharSequence)this.attrs.get("result"))) {
            if (QLog.isColorLevel()) {
              QLog.d("JumpAction", 2, "webReportT get result: " + (String)this.attrs.get("result"));
            }
          }
        }
      }
      catch (Exception localException1)
      {
        try
        {
          j = Integer.parseInt((String)this.attrs.get("result"));
          if (this.attrs.containsKey("r2"))
          {
            String str6 = (String)this.attrs.get("r2");
            if (!this.attrs.containsKey("r3")) {
              continue;
            }
            str8 = (String)this.attrs.get("r3");
            if (!this.attrs.containsKey("r4")) {
              continue;
            }
            str9 = (String)this.attrs.get("r4");
            if (!this.attrs.containsKey("r5")) {
              continue;
            }
            str10 = (String)this.attrs.get("r5");
            anot.a(null, str3, str4, str5, str1, str2, i, j, str6, str8, str9, str10);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("JumpAction", 2, "webReportT ");
            return true;
            str3 = "";
            break label169;
            label578:
            str4 = "";
            break label197;
            label585:
            str5 = "";
            break label225;
            localException1 = localException1;
            i = 0;
            continue;
          }
          String str7 = "";
          continue;
          String str8 = "";
          continue;
          String str9 = "";
          continue;
          String str10 = "";
          continue;
        }
        catch (Exception localException2)
        {
          int j = k;
          continue;
        }
      }
      label634:
      int i = 0;
    }
  }
  
  public boolean aEE()
  {
    if ((this.attrs.containsKey("source")) && (!TextUtils.isEmpty((CharSequence)this.attrs.get("source"))) && (this.attrs.containsKey("source_article_id")) && (!TextUtils.isEmpty((CharSequence)this.attrs.get("source_article_id"))) && (this.attrs.containsKey("operation")) && (!TextUtils.isEmpty((CharSequence)this.attrs.get("operation"))) && (this.attrs.containsKey("op_source")) && (!TextUtils.isEmpty((CharSequence)this.attrs.get("op_source")))) {}
    try
    {
      int i = Integer.parseInt((String)this.attrs.get("source"));
      long l = Integer.parseInt((String)this.attrs.get("source_article_id"));
      int j = Integer.parseInt((String)this.attrs.get("operation"));
      int k = Integer.parseInt((String)this.attrs.get("op_source"));
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "webReportArticleRealTime get source[ " + (String)this.attrs.get("source") + "] source_article_id[" + (String)this.attrs.get("source_article_id") + "] operation[" + (String)this.attrs.get("operation") + "] op_source[" + (String)this.attrs.get("op_source") + "]");
      }
      awit.a(this.app, i, l, j, k);
    }
    catch (Exception localException)
    {
      label327:
      break label327;
    }
    return true;
  }
  
  /* Error */
  public boolean aEF()
  {
    // Byte code:
    //   0: new 339	android/os/Bundle
    //   3: dup
    //   4: invokespecial 340	android/os/Bundle:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: ldc_w 5739
    //   14: aload_0
    //   15: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   18: ldc 238
    //   20: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 72	java/lang/String
    //   26: invokestatic 241	aqhv:toBase64Decode	(Ljava/lang/String;)Ljava/lang/String;
    //   29: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload 5
    //   34: ldc_w 5741
    //   37: aload_0
    //   38: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   41: ldc_w 4895
    //   44: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   47: checkcast 72	java/lang/String
    //   50: invokestatic 241	aqhv:toBase64Decode	(Ljava/lang/String;)Ljava/lang/String;
    //   53: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload 5
    //   58: ldc_w 5743
    //   61: aload_0
    //   62: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   65: ldc_w 5745
    //   68: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   71: checkcast 72	java/lang/String
    //   74: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: aload 5
    //   79: ldc_w 5747
    //   82: aload_0
    //   83: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   86: ldc_w 5749
    //   89: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   92: checkcast 72	java/lang/String
    //   95: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload 5
    //   100: ldc_w 5751
    //   103: aload_0
    //   104: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   107: ldc_w 5753
    //   110: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   113: checkcast 72	java/lang/String
    //   116: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: aload 5
    //   121: ldc_w 5755
    //   124: aload_0
    //   125: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   128: ldc_w 5757
    //   131: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   134: checkcast 72	java/lang/String
    //   137: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: aload 5
    //   142: ldc_w 5759
    //   145: aload_0
    //   146: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   149: ldc_w 5761
    //   152: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   155: checkcast 72	java/lang/String
    //   158: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload 5
    //   163: ldc_w 5763
    //   166: iconst_0
    //   167: invokevirtual 376	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   170: aload 5
    //   172: ldc_w 5765
    //   175: ldc_w 405
    //   178: aload_0
    //   179: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   182: ldc_w 5767
    //   185: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   188: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   191: invokevirtual 376	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   194: aload 5
    //   196: ldc_w 5769
    //   199: aload_0
    //   200: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   203: ldc_w 5771
    //   206: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   209: checkcast 72	java/lang/String
    //   212: invokestatic 241	aqhv:toBase64Decode	(Ljava/lang/String;)Ljava/lang/String;
    //   215: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: aload_0
    //   219: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   222: ldc_w 5773
    //   225: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   228: checkcast 552	java/lang/CharSequence
    //   231: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   234: ifne +40 -> 274
    //   237: aload 5
    //   239: ldc_w 5775
    //   242: new 5777	java/math/BigInteger
    //   245: dup
    //   246: aload_0
    //   247: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   250: ldc_w 5773
    //   253: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   256: checkcast 72	java/lang/String
    //   259: invokespecial 5778	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   262: invokevirtual 5779	java/math/BigInteger:longValue	()J
    //   265: invokestatic 1969	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   268: invokevirtual 287	java/lang/Long:longValue	()J
    //   271: invokevirtual 352	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   274: aload_0
    //   275: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   278: ldc_w 5781
    //   281: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   284: checkcast 552	java/lang/CharSequence
    //   287: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   290: ifne +30 -> 320
    //   293: aload 5
    //   295: ldc_w 5783
    //   298: aload_0
    //   299: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   302: ldc_w 5781
    //   305: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   308: checkcast 72	java/lang/String
    //   311: invokestatic 273	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   314: invokevirtual 276	java/lang/Integer:intValue	()I
    //   317: invokevirtual 366	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   320: aload_0
    //   321: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   324: ldc_w 5785
    //   327: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   330: checkcast 552	java/lang/CharSequence
    //   333: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   336: ifne +24 -> 360
    //   339: aload 5
    //   341: ldc_w 5787
    //   344: aload_0
    //   345: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   348: ldc_w 5785
    //   351: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   354: checkcast 72	java/lang/String
    //   357: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   360: aload_0
    //   361: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   364: ldc_w 5789
    //   367: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   370: checkcast 72	java/lang/String
    //   373: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   376: ifne +1429 -> 1805
    //   379: aload 5
    //   381: ldc_w 5791
    //   384: aload_0
    //   385: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   388: ldc_w 5789
    //   391: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   394: checkcast 72	java/lang/String
    //   397: invokestatic 273	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   400: invokevirtual 276	java/lang/Integer:intValue	()I
    //   403: invokevirtual 366	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   406: aload_0
    //   407: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   410: ldc_w 5793
    //   413: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   416: checkcast 72	java/lang/String
    //   419: astore 4
    //   421: aload 4
    //   423: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   426: ifne +19 -> 445
    //   429: aload 5
    //   431: ldc_w 5795
    //   434: aload 4
    //   436: invokestatic 273	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   439: invokevirtual 276	java/lang/Integer:intValue	()I
    //   442: invokevirtual 366	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   445: aload 5
    //   447: ldc_w 5797
    //   450: aload_0
    //   451: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   454: ldc_w 5799
    //   457: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   460: checkcast 72	java/lang/String
    //   463: invokestatic 241	aqhv:toBase64Decode	(Ljava/lang/String;)Ljava/lang/String;
    //   466: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   469: aload 5
    //   471: ldc_w 5801
    //   474: aload_0
    //   475: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   478: ldc_w 5803
    //   481: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   484: checkcast 72	java/lang/String
    //   487: invokestatic 241	aqhv:toBase64Decode	(Ljava/lang/String;)Ljava/lang/String;
    //   490: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   493: aload_0
    //   494: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   497: ldc_w 5805
    //   500: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   503: checkcast 72	java/lang/String
    //   506: astore 4
    //   508: aload 4
    //   510: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   513: ifne +19 -> 532
    //   516: aload 5
    //   518: ldc_w 5805
    //   521: aload 4
    //   523: invokestatic 273	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   526: invokevirtual 276	java/lang/Integer:intValue	()I
    //   529: invokevirtual 366	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   532: aload_0
    //   533: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   536: ldc_w 5807
    //   539: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   542: checkcast 72	java/lang/String
    //   545: astore 4
    //   547: aload 4
    //   549: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   552: ifne +19 -> 571
    //   555: aload 5
    //   557: ldc_w 5807
    //   560: aload 4
    //   562: invokestatic 273	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   565: invokevirtual 276	java/lang/Integer:intValue	()I
    //   568: invokevirtual 366	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   571: aload_0
    //   572: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   575: ldc_w 5809
    //   578: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   581: checkcast 72	java/lang/String
    //   584: astore 4
    //   586: aload 4
    //   588: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   591: ifne +19 -> 610
    //   594: aload 5
    //   596: ldc_w 5809
    //   599: aload 4
    //   601: invokestatic 273	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   604: invokevirtual 276	java/lang/Integer:intValue	()I
    //   607: invokevirtual 366	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   610: aload_0
    //   611: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   614: ldc_w 5811
    //   617: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   620: checkcast 72	java/lang/String
    //   623: astore 4
    //   625: aload 4
    //   627: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   630: ifne +19 -> 649
    //   633: aload 5
    //   635: ldc_w 5811
    //   638: aload 4
    //   640: invokestatic 273	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   643: invokevirtual 276	java/lang/Integer:intValue	()I
    //   646: invokevirtual 366	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   649: aload_0
    //   650: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   653: ldc_w 1452
    //   656: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   659: checkcast 72	java/lang/String
    //   662: astore 4
    //   664: aload 4
    //   666: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   669: ifne +116 -> 785
    //   672: aload_0
    //   673: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   676: ldc_w 1454
    //   679: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   682: checkcast 72	java/lang/String
    //   685: astore 6
    //   687: aload_0
    //   688: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   691: ldc_w 1458
    //   694: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   697: checkcast 72	java/lang/String
    //   700: astore 7
    //   702: aload_0
    //   703: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   706: ldc_w 1460
    //   709: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   712: checkcast 72	java/lang/String
    //   715: astore 8
    //   717: new 5813	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData
    //   720: dup
    //   721: invokespecial 5814	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:<init>	()V
    //   724: astore 9
    //   726: aload 9
    //   728: aload 4
    //   730: putfield 5817	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:acb	Ljava/lang/String;
    //   733: aload 9
    //   735: aload 6
    //   737: putfield 5820	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:acd	Ljava/lang/String;
    //   740: aload 9
    //   742: ldc_w 422
    //   745: aload 7
    //   747: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   750: putfield 5823	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:ahK	Z
    //   753: aload 9
    //   755: ldc_w 405
    //   758: aload 8
    //   760: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   763: putfield 5826	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:ahJ	Z
    //   766: aload 5
    //   768: ldc_w 5828
    //   771: iconst_1
    //   772: invokevirtual 376	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   775: aload 5
    //   777: ldc_w 5830
    //   780: aload 9
    //   782: invokevirtual 5834	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   785: aload 5
    //   787: ldc_w 5836
    //   790: aload_0
    //   791: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   794: ldc_w 5561
    //   797: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   800: checkcast 72	java/lang/String
    //   803: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   806: aload 5
    //   808: ldc_w 5838
    //   811: aload_0
    //   812: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   815: ldc_w 5840
    //   818: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   821: checkcast 72	java/lang/String
    //   824: invokestatic 715	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   827: invokevirtual 366	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   830: ldc_w 405
    //   833: aload_0
    //   834: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   837: ldc_w 5842
    //   840: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   843: invokevirtual 558	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   846: ifeq +1087 -> 1933
    //   849: iconst_1
    //   850: istore_1
    //   851: aload 5
    //   853: ldc_w 5844
    //   856: iload_1
    //   857: invokevirtual 366	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   860: iload_1
    //   861: ifne +799 -> 1660
    //   864: aload_0
    //   865: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   868: ldc_w 5767
    //   871: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   874: checkcast 72	java/lang/String
    //   877: invokestatic 273	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   880: invokevirtual 276	java/lang/Integer:intValue	()I
    //   883: istore_2
    //   884: aload 5
    //   886: ldc_w 5846
    //   889: iload_2
    //   890: invokevirtual 366	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   893: aload_0
    //   894: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   897: ldc_w 5848
    //   900: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   903: checkcast 72	java/lang/String
    //   906: invokestatic 283	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   909: invokevirtual 287	java/lang/Long:longValue	()J
    //   912: iconst_1
    //   913: invokestatic 5853	kxl:c	(JZ)Ljava/lang/String;
    //   916: astore 4
    //   918: aload 5
    //   920: ldc_w 5855
    //   923: aload 4
    //   925: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   928: aload 5
    //   930: ldc_w 5857
    //   933: aload_0
    //   934: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   937: ldc_w 5859
    //   940: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   943: checkcast 72	java/lang/String
    //   946: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   949: aload 5
    //   951: ldc_w 5861
    //   954: aload_0
    //   955: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   958: ldc_w 5863
    //   961: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   964: checkcast 72	java/lang/String
    //   967: invokestatic 241	aqhv:toBase64Decode	(Ljava/lang/String;)Ljava/lang/String;
    //   970: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   973: aload 5
    //   975: ldc_w 5865
    //   978: aload_0
    //   979: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   982: ldc_w 5867
    //   985: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   988: checkcast 72	java/lang/String
    //   991: invokestatic 241	aqhv:toBase64Decode	(Ljava/lang/String;)Ljava/lang/String;
    //   994: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   997: aload 5
    //   999: ldc_w 5869
    //   1002: aload_0
    //   1003: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1006: ldc_w 5871
    //   1009: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1012: checkcast 72	java/lang/String
    //   1015: invokestatic 241	aqhv:toBase64Decode	(Ljava/lang/String;)Ljava/lang/String;
    //   1018: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1021: aload_0
    //   1022: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1025: ldc_w 5873
    //   1028: invokevirtual 661	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1031: ifeq +46 -> 1077
    //   1034: aload_0
    //   1035: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1038: ldc_w 5873
    //   1041: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1044: checkcast 552	java/lang/CharSequence
    //   1047: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1050: ifne +27 -> 1077
    //   1053: aload 5
    //   1055: ldc_w 5875
    //   1058: aload_0
    //   1059: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1062: ldc_w 5873
    //   1065: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1068: checkcast 72	java/lang/String
    //   1071: invokestatic 241	aqhv:toBase64Decode	(Ljava/lang/String;)Ljava/lang/String;
    //   1074: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1077: aload_0
    //   1078: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1081: ldc_w 5757
    //   1084: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1087: checkcast 72	java/lang/String
    //   1090: invokestatic 5880	kxv:a	(Ljava/lang/String;)Lkxz;
    //   1093: astore 4
    //   1095: aload 4
    //   1097: ifnull +29 -> 1126
    //   1100: aload 5
    //   1102: ldc_w 5882
    //   1105: aload 4
    //   1107: getfield 5886	kxz:url	Ljava/lang/String;
    //   1110: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1113: aload 5
    //   1115: ldc_w 5888
    //   1118: aload 4
    //   1120: getfield 5890	kxz:time	J
    //   1123: invokevirtual 352	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1126: new 339	android/os/Bundle
    //   1129: dup
    //   1130: invokespecial 340	android/os/Bundle:<init>	()V
    //   1133: astore 4
    //   1135: aload 4
    //   1137: ldc_w 5892
    //   1140: aload_0
    //   1141: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1144: ldc_w 5757
    //   1147: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1150: checkcast 72	java/lang/String
    //   1153: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1156: aload 4
    //   1158: ldc_w 5894
    //   1161: aload_0
    //   1162: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1165: ldc_w 5757
    //   1168: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1171: checkcast 72	java/lang/String
    //   1174: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1177: aload 4
    //   1179: ldc_w 5896
    //   1182: aload_0
    //   1183: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1186: ldc_w 5745
    //   1189: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1192: checkcast 72	java/lang/String
    //   1195: invokestatic 273	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1198: invokevirtual 276	java/lang/Integer:intValue	()I
    //   1201: invokevirtual 366	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1204: aload 4
    //   1206: ldc_w 5898
    //   1209: aload_0
    //   1210: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1213: ldc_w 5749
    //   1216: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1219: checkcast 72	java/lang/String
    //   1222: invokestatic 273	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1225: invokevirtual 276	java/lang/Integer:intValue	()I
    //   1228: invokevirtual 366	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1231: aload 4
    //   1233: ldc_w 5900
    //   1236: aload_0
    //   1237: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1240: ldc_w 5753
    //   1243: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1246: checkcast 72	java/lang/String
    //   1249: invokestatic 273	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1252: invokevirtual 276	java/lang/Integer:intValue	()I
    //   1255: invokevirtual 366	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1258: aload 4
    //   1260: ldc_w 5902
    //   1263: aload_0
    //   1264: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1267: ldc_w 5745
    //   1270: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1273: checkcast 72	java/lang/String
    //   1276: invokestatic 273	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1279: invokevirtual 276	java/lang/Integer:intValue	()I
    //   1282: invokevirtual 366	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1285: aload_0
    //   1286: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1289: ldc_w 5767
    //   1292: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1295: checkcast 72	java/lang/String
    //   1298: invokestatic 273	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1301: invokevirtual 276	java/lang/Integer:intValue	()I
    //   1304: iconst_1
    //   1305: if_icmpne +817 -> 2122
    //   1308: aload 4
    //   1310: ldc_w 5904
    //   1313: aload_0
    //   1314: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1317: ldc_w 5859
    //   1320: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1323: checkcast 72	java/lang/String
    //   1326: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1329: aload 4
    //   1331: ldc_w 5906
    //   1334: aload_0
    //   1335: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1338: ldc_w 5863
    //   1341: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1344: checkcast 72	java/lang/String
    //   1347: invokestatic 241	aqhv:toBase64Decode	(Ljava/lang/String;)Ljava/lang/String;
    //   1350: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1353: aload 4
    //   1355: ldc_w 5908
    //   1358: aload_0
    //   1359: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1362: ldc_w 5859
    //   1365: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1368: checkcast 72	java/lang/String
    //   1371: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1374: aload 4
    //   1376: ldc_w 5910
    //   1379: aload_0
    //   1380: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1383: ldc_w 5767
    //   1386: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1389: checkcast 72	java/lang/String
    //   1392: invokestatic 273	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1395: invokevirtual 276	java/lang/Integer:intValue	()I
    //   1398: invokevirtual 366	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1401: aload 4
    //   1403: ldc_w 5912
    //   1406: aload_0
    //   1407: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1410: ldc_w 5761
    //   1413: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1416: checkcast 72	java/lang/String
    //   1419: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1422: aload 4
    //   1424: ldc_w 5914
    //   1427: iconst_5
    //   1428: invokevirtual 366	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1431: aload 4
    //   1433: ldc_w 5916
    //   1436: iconst_0
    //   1437: invokevirtual 376	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   1440: aload 4
    //   1442: ldc_w 3549
    //   1445: aload_0
    //   1446: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1449: ldc_w 5803
    //   1452: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1455: checkcast 72	java/lang/String
    //   1458: invokestatic 241	aqhv:toBase64Decode	(Ljava/lang/String;)Ljava/lang/String;
    //   1461: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1464: aload 4
    //   1466: ldc_w 354
    //   1469: aload_0
    //   1470: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1473: ldc_w 5799
    //   1476: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1479: checkcast 72	java/lang/String
    //   1482: invokestatic 241	aqhv:toBase64Decode	(Ljava/lang/String;)Ljava/lang/String;
    //   1485: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1488: aload 4
    //   1490: ldc_w 5771
    //   1493: aload_0
    //   1494: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1497: ldc_w 5757
    //   1500: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1503: checkcast 72	java/lang/String
    //   1506: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1509: aload 4
    //   1511: ldc 238
    //   1513: aload_0
    //   1514: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1517: ldc 238
    //   1519: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1522: checkcast 72	java/lang/String
    //   1525: invokestatic 241	aqhv:toBase64Decode	(Ljava/lang/String;)Ljava/lang/String;
    //   1528: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1531: aload 4
    //   1533: ldc_w 5918
    //   1536: aload_0
    //   1537: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1540: ldc_w 5848
    //   1543: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1546: checkcast 72	java/lang/String
    //   1549: invokestatic 283	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   1552: invokevirtual 287	java/lang/Long:longValue	()J
    //   1555: invokestatic 5921	kxl:ap	(J)Ljava/lang/String;
    //   1558: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1561: aload 4
    //   1563: ldc_w 3553
    //   1566: aload_0
    //   1567: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1570: ldc 238
    //   1572: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1575: checkcast 72	java/lang/String
    //   1578: invokestatic 241	aqhv:toBase64Decode	(Ljava/lang/String;)Ljava/lang/String;
    //   1581: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1584: aload 4
    //   1586: ldc_w 259
    //   1589: sipush 140
    //   1592: invokevirtual 366	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1595: aload 5
    //   1597: ldc_w 5923
    //   1600: aload 4
    //   1602: invokestatic 5928	anre:a	(Landroid/os/Bundle;)Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1605: checkcast 5930	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   1608: invokevirtual 5931	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:getBytes	()[B
    //   1611: invokevirtual 5934	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   1614: iload_2
    //   1615: bipush 6
    //   1617: if_icmpne +43 -> 1660
    //   1620: aload_0
    //   1621: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1624: ldc_w 5936
    //   1627: invokevirtual 661	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1630: ifeq +30 -> 1660
    //   1633: aload 5
    //   1635: ldc_w 5938
    //   1638: aload_0
    //   1639: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1642: ldc_w 5936
    //   1645: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1648: checkcast 72	java/lang/String
    //   1651: invokestatic 241	aqhv:toBase64Decode	(Ljava/lang/String;)Ljava/lang/String;
    //   1654: invokestatic 5941	kxm:a	(Ljava/lang/String;)Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;
    //   1657: invokevirtual 5834	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   1660: aload 5
    //   1662: ldc_w 5943
    //   1665: iconst_5
    //   1666: invokevirtual 366	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1669: iload_1
    //   1670: iconst_1
    //   1671: if_icmpne +573 -> 2244
    //   1674: aload 5
    //   1676: ldc_w 5791
    //   1679: iconst_m1
    //   1680: invokevirtual 5944	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   1683: invokestatic 5948	kzc:dw	(I)Z
    //   1686: istore_3
    //   1687: iload_3
    //   1688: ifeq +621 -> 2309
    //   1691: new 126	android/content/Intent
    //   1694: dup
    //   1695: invokespecial 502	android/content/Intent:<init>	()V
    //   1698: astore 4
    //   1700: aload 4
    //   1702: aload 5
    //   1704: invokevirtual 1950	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   1707: pop
    //   1708: aload_0
    //   1709: getfield 115	aqhv:context	Landroid/content/Context;
    //   1712: aload 4
    //   1714: invokestatic 5952	com/tencent/biz/pubaccount/readinjoy/video/multivideo/MultiVideoFragment:s	(Landroid/content/Context;Landroid/content/Intent;)V
    //   1717: iconst_1
    //   1718: ireturn
    //   1719: astore 4
    //   1721: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1724: ifeq -1404 -> 320
    //   1727: ldc_w 666
    //   1730: iconst_2
    //   1731: new 152	java/lang/StringBuilder
    //   1734: dup
    //   1735: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1738: ldc_w 5954
    //   1741: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1744: aload_0
    //   1745: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1748: ldc_w 5773
    //   1751: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1754: checkcast 72	java/lang/String
    //   1757: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1760: ldc_w 5956
    //   1763: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1766: aload_0
    //   1767: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1770: ldc_w 5781
    //   1773: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1776: checkcast 72	java/lang/String
    //   1779: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1782: ldc_w 5958
    //   1785: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1788: aload 4
    //   1790: invokevirtual 1607	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1793: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1796: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1799: invokestatic 1000	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1802: goto -1482 -> 320
    //   1805: aload 5
    //   1807: ldc_w 5791
    //   1810: bipush 100
    //   1812: invokevirtual 366	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1815: goto -1409 -> 406
    //   1818: astore 4
    //   1820: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1823: ifeq -106 -> 1717
    //   1826: ldc_w 666
    //   1829: iconst_2
    //   1830: new 152	java/lang/StringBuilder
    //   1833: dup
    //   1834: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1837: ldc_w 5960
    //   1840: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1843: aload_0
    //   1844: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1847: ldc_w 5799
    //   1850: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1853: checkcast 72	java/lang/String
    //   1856: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1859: ldc_w 5962
    //   1862: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1865: aload_0
    //   1866: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   1869: ldc_w 5799
    //   1872: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1875: checkcast 72	java/lang/String
    //   1878: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1881: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1884: invokestatic 1000	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1887: iconst_1
    //   1888: ireturn
    //   1889: astore 4
    //   1891: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1894: ifeq -1245 -> 649
    //   1897: ldc_w 666
    //   1900: iconst_2
    //   1901: ldc_w 5964
    //   1904: invokestatic 1000	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1907: goto -1258 -> 649
    //   1910: astore 4
    //   1912: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1915: ifeq -1085 -> 830
    //   1918: ldc_w 666
    //   1921: iconst_2
    //   1922: ldc_w 5966
    //   1925: aload 4
    //   1927: invokestatic 5037	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1930: goto -1100 -> 830
    //   1933: iconst_0
    //   1934: istore_1
    //   1935: goto -1084 -> 851
    //   1938: astore 4
    //   1940: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1943: ifeq +410 -> 2353
    //   1946: ldc_w 666
    //   1949: iconst_2
    //   1950: new 152	java/lang/StringBuilder
    //   1953: dup
    //   1954: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1957: ldc_w 5968
    //   1960: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1963: aload 4
    //   1965: invokevirtual 1607	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1968: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1971: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1974: invokestatic 1000	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1977: goto +376 -> 2353
    //   1980: astore 4
    //   1982: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1985: ifeq -268 -> 1717
    //   1988: ldc_w 666
    //   1991: iconst_2
    //   1992: new 152	java/lang/StringBuilder
    //   1995: dup
    //   1996: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1999: ldc_w 5970
    //   2002: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2005: aload_0
    //   2006: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   2009: ldc_w 5871
    //   2012: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2015: checkcast 72	java/lang/String
    //   2018: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2021: ldc_w 5972
    //   2024: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2027: aload_0
    //   2028: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   2031: ldc_w 5873
    //   2034: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2037: checkcast 72	java/lang/String
    //   2040: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2043: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2046: invokestatic 1000	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2049: iconst_1
    //   2050: ireturn
    //   2051: astore 4
    //   2053: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2056: ifeq -339 -> 1717
    //   2059: ldc_w 666
    //   2062: iconst_2
    //   2063: new 152	java/lang/StringBuilder
    //   2066: dup
    //   2067: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   2070: ldc_w 5974
    //   2073: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2076: aload_0
    //   2077: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   2080: ldc_w 5767
    //   2083: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2086: checkcast 72	java/lang/String
    //   2089: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2092: ldc_w 5976
    //   2095: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2098: aload_0
    //   2099: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   2102: ldc_w 5848
    //   2105: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2108: checkcast 72	java/lang/String
    //   2111: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2114: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2117: invokestatic 1000	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2120: iconst_1
    //   2121: ireturn
    //   2122: aload_0
    //   2123: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   2126: ldc_w 5978
    //   2129: invokevirtual 661	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2132: ifeq +43 -> 2175
    //   2135: aload_0
    //   2136: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   2139: ldc_w 5978
    //   2142: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2145: checkcast 552	java/lang/CharSequence
    //   2148: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2151: ifne +24 -> 2175
    //   2154: aload 4
    //   2156: ldc_w 5904
    //   2159: aload_0
    //   2160: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   2163: ldc_w 5978
    //   2166: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2169: checkcast 72	java/lang/String
    //   2172: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2175: aload 4
    //   2177: ldc_w 5906
    //   2180: aload_0
    //   2181: getfield 122	aqhv:attrs	Ljava/util/HashMap;
    //   2184: ldc_w 5867
    //   2187: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2190: checkcast 72	java/lang/String
    //   2193: invokestatic 241	aqhv:toBase64Decode	(Ljava/lang/String;)Ljava/lang/String;
    //   2196: invokevirtual 344	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2199: goto -825 -> 1374
    //   2202: astore 6
    //   2204: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2207: ifeq -646 -> 1561
    //   2210: ldc_w 666
    //   2213: iconst_2
    //   2214: new 152	java/lang/StringBuilder
    //   2217: dup
    //   2218: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   2221: ldc_w 5980
    //   2224: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2227: aload 6
    //   2229: invokevirtual 1607	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2232: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2235: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2238: invokestatic 1000	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2241: goto -680 -> 1561
    //   2244: aload 5
    //   2246: ldc_w 5791
    //   2249: iconst_m1
    //   2250: invokevirtual 5944	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   2253: aload 5
    //   2255: ldc_w 5747
    //   2258: invokevirtual 5981	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2261: invokestatic 273	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2264: invokevirtual 276	java/lang/Integer:intValue	()I
    //   2267: aload 5
    //   2269: ldc_w 5751
    //   2272: invokevirtual 5981	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2275: invokestatic 273	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2278: invokevirtual 276	java/lang/Integer:intValue	()I
    //   2281: aload 5
    //   2283: ldc_w 5743
    //   2286: invokevirtual 5981	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2289: invokestatic 273	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2292: invokevirtual 276	java/lang/Integer:intValue	()I
    //   2295: invokestatic 5984	kzc:b	(IIII)Z
    //   2298: istore_3
    //   2299: goto -612 -> 1687
    //   2302: astore 4
    //   2304: iconst_0
    //   2305: istore_3
    //   2306: goto -619 -> 1687
    //   2309: new 126	android/content/Intent
    //   2312: dup
    //   2313: aload_0
    //   2314: getfield 115	aqhv:context	Landroid/content/Context;
    //   2317: ldc_w 5986
    //   2320: invokespecial 131	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   2323: astore 4
    //   2325: aload 4
    //   2327: ldc_w 2634
    //   2330: invokevirtual 142	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2333: pop
    //   2334: aload 4
    //   2336: aload 5
    //   2338: invokevirtual 1950	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   2341: pop
    //   2342: aload_0
    //   2343: getfield 115	aqhv:context	Landroid/content/Context;
    //   2346: aload 4
    //   2348: invokevirtual 544	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   2351: iconst_1
    //   2352: ireturn
    //   2353: aconst_null
    //   2354: astore 4
    //   2356: goto -1438 -> 918
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2359	0	this	aqhv
    //   850	1085	1	i	int
    //   883	735	2	j	int
    //   1686	620	3	bool	boolean
    //   419	1294	4	localObject	Object
    //   1719	70	4	localException1	Exception
    //   1818	1	4	localException2	Exception
    //   1889	1	4	localException3	Exception
    //   1910	16	4	localException4	Exception
    //   1938	26	4	localException5	Exception
    //   1980	1	4	localException6	Exception
    //   2051	125	4	localException7	Exception
    //   2302	1	4	localException8	Exception
    //   2323	32	4	localIntent	Intent
    //   7	2330	5	localBundle	Bundle
    //   685	51	6	str1	String
    //   2202	26	6	localException9	Exception
    //   700	46	7	str2	String
    //   715	44	8	str3	String
    //   724	57	9	localAnchorData	com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData
    // Exception table:
    //   from	to	target	type
    //   218	274	1719	java/lang/Exception
    //   274	320	1719	java/lang/Exception
    //   445	493	1818	java/lang/Exception
    //   493	532	1889	java/lang/Exception
    //   532	571	1889	java/lang/Exception
    //   571	610	1889	java/lang/Exception
    //   610	649	1889	java/lang/Exception
    //   806	830	1910	java/lang/Exception
    //   893	918	1938	java/lang/Exception
    //   997	1077	1980	java/lang/Exception
    //   864	893	2051	java/lang/Exception
    //   918	997	2051	java/lang/Exception
    //   1077	1095	2051	java/lang/Exception
    //   1100	1126	2051	java/lang/Exception
    //   1126	1374	2051	java/lang/Exception
    //   1374	1531	2051	java/lang/Exception
    //   1561	1614	2051	java/lang/Exception
    //   1620	1660	2051	java/lang/Exception
    //   1940	1977	2051	java/lang/Exception
    //   1982	2049	2051	java/lang/Exception
    //   2122	2175	2051	java/lang/Exception
    //   2175	2199	2051	java/lang/Exception
    //   2204	2241	2051	java/lang/Exception
    //   1531	1561	2202	java/lang/Exception
    //   1674	1687	2302	java/lang/Exception
    //   2244	2299	2302	java/lang/Exception
  }
  
  public boolean aEG()
  {
    Intent localIntent = new Intent(this.context, GeneralSettingActivity.class);
    localIntent.addFlags(603979776);
    this.context.startActivity(localIntent);
    return true;
  }
  
  public boolean aEH()
  {
    String str1 = (String)this.attrs.get("nickname");
    String str2 = (String)this.attrs.get("openid");
    Intent localIntent = new Intent((Activity)this.context, ApolloGuestsStateActivity.class);
    localIntent.putExtra("extra_guest_nick", str1);
    localIntent.putExtra("extra_guest_uin", str2);
    ((Activity)this.context).startActivity(localIntent);
    return true;
  }
  
  public boolean aEI()
  {
    Intent localIntent = new Intent(this.context, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://nearby.qq.com/nearby-visitor/index.html?_proxy=1&_wwv=128");
    this.context.startActivity(localIntent);
    return true;
  }
  
  public boolean aEJ()
  {
    Intent localIntent = new Intent(this.context, ConferenceFlyTicketActivity.class);
    String str1 = (String)this.attrs.get("confid");
    String str2 = (String)this.attrs.get("subject");
    String str3 = (String)this.attrs.get("confidshort");
    String str4 = (String)this.attrs.get("ticket");
    String str5 = (String)this.attrs.get("discid");
    String str6 = (String)this.attrs.get("confphone");
    String str7 = (String)this.attrs.get("businesstype");
    String str8 = (String)this.attrs.get("stask");
    String str9 = (String)this.attrs.get("user");
    String str10 = (String)this.attrs.get("ticket_f");
    localIntent.putExtra("confid", str1);
    localIntent.putExtra("subject", str2);
    localIntent.putExtra("ticket", str4);
    localIntent.putExtra("confidshort", str3);
    localIntent.putExtra("discid", str5);
    localIntent.putExtra("confphone", str6);
    localIntent.putExtra("businesstype", str7);
    localIntent.putExtra("user", str9);
    localIntent.putExtra("stask", str8);
    localIntent.putExtra("ticket_f", str10);
    AudioHelper.rw("start_ConferenceFlyTicketActivity");
    this.context.startActivity(localIntent);
    return true;
  }
  
  protected boolean aEO()
  {
    String str1 = (String)this.attrs.get("groupcode");
    Object localObject = ((TroopManager)this.app.getManager(52)).b(str1);
    if (localObject != null)
    {
      String str2 = this.app.getCurrentAccountUin();
      if ((((TroopInfo)localObject).isTroopOwner(str2)) || (((TroopInfo)localObject).isTroopAdmin(str2))) {}
      for (boolean bool = true; (!((TroopInfo)localObject).mMemberInvitingFlag) && (!bool); bool = false)
      {
        QLog.e("JumpAction", 1, "cannot invite join group");
        return true;
      }
      localObject = new Intent(this.context, SelectMemberActivity.class);
      ((Intent)localObject).putExtra("param_groupcode", str1);
      ((Intent)localObject).putExtra("param_type", 1);
      ((Intent)localObject).putExtra("param_subtype", 1);
      ((Intent)localObject).putExtra("param_done_button_wording", this.context.getString(2131699515));
      ((Intent)localObject).putExtra("param_title", this.context.getString(2131698293));
      ((Intent)localObject).putExtra("param_is_troop_admin", bool);
      ((Intent)localObject).putExtra("param_donot_need_contacts", true);
      ((Intent)localObject).putExtra("param_max", 100);
      this.context.startActivity((Intent)localObject);
      return true;
    }
    QLog.e("JumpAction", 1, "troopInfo not found");
    return true;
  }
  
  public boolean aEi()
  {
    if (this.app == null) {
      return false;
    }
    String str = replaceUrlParam(replaceUrlParam(replaceUrlParam(replaceUrlParam(replaceUrlParam(replaceUrlParam(QzoneConfig.getInstance().getConfig("H5Url", "PersonalQzoneVisitor", "https://h5.qzone.qq.com/visitor/qzone/personal?uin={uin}&qua={qua}&clicktime={clicktime}&_bid=329&_wv=3&_proxy=true"), "{hostUin}", this.app.getCurrentAccountUin()), "{clicktime}", String.valueOf(System.currentTimeMillis())), "{from}", "androidQQ"), "{qua}", avpq.getQUA3()), "{uin}", this.app.getCurrentAccountUin()), "{UIN}", this.app.getCurrentAccountUin());
    Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    localIntent.putExtra("fromQZone", true);
    localIntent.putExtra("injectrecommend", true);
    localIntent.putExtra("articalChannelId", 5);
    if (arap.sPluginNameSpaceHashMap.containsKey("Qzone")) {
      localIntent.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    localIntent.setData(Uri.parse(str));
    localIntent.addFlags(268435456);
    localIntent.putExtra("needSkey", "true");
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("uin", this.app.getCurrentAccountUin());
    this.context.startActivity(localIntent);
    return true;
  }
  
  public boolean aEw()
  {
    Object localObject = getAttribute("param_meta_data");
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localBundle.putString("param_meta_data", (String)localObject);
    }
    String str = toBase64Decode((String)this.attrs.get("url_prefix"));
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.source;
    }
    tas.a(this.app, this.context, null, (String)localObject, localBundle);
    return true;
  }
  
  public boolean aEz()
  {
    if (QLog.isColorLevel()) {
      QLog.i("JumpAction", 2, "gotoSendBless");
    }
    ylm localylm = (ylm)this.app.getManager(138);
    if (localylm.TT()) {
      localylm.dq(this.context);
    }
    for (;;)
    {
      return true;
      QQToast.a(this.context, 0, acfp.m(2131707548), 0).show();
    }
  }
  
  public boolean acL()
  {
    if (this.app == null) {
      return false;
    }
    Object localObject = (aneo)this.app.getManager(10);
    if ((localObject != null) && ((((aneo)localObject).jn(2) > 0) || (((aneo)localObject).jn(1) > 0))) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("newflag", bool);
      ((Intent)localObject).putExtra("refer", "schemeActiveFeeds");
      QzonePluginProxyActivity.x((Intent)localObject, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
      ((Intent)localObject).addFlags(805306368);
      String str = Uri.parse(this.source).getQueryParameter("push_trans_channel");
      avpw.a((Activity)this.context, this.app.getCurrentAccountUin(), (Intent)localObject, str, -1);
      LpReportInfo_dc02880.report(this.source);
      return true;
    }
  }
  
  public boolean acR()
  {
    SmallVideoFragment.launch(this.context, this.source);
    return true;
  }
  
  public boolean acd()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.context, AssistantSettingActivity.class);
    this.context.startActivity(localIntent);
    return true;
  }
  
  public boolean ace()
  {
    boolean bool2 = false;
    label732:
    Object localObject1;
    Object localObject2;
    try
    {
      if ("com.qqfav".equals(this.cti)) {
        return aCQ();
      }
      if (("urlopen".equals(this.cti)) && ("pay".equals(this.ctj))) {
        edL();
      }
      if (("qqidentifier".equals(this.cti)) && ("web".equals(this.ctj))) {
        return aCR();
      }
      if ("qsubscribe".equals(this.cti))
      {
        rzd.b((Activity)this.context, this.ctj, this.attrs);
        return true;
      }
      if ("qcircle".equals(this.cti))
      {
        oux.a((Activity)this.context, this.ctj, this.attrs);
        return true;
      }
      if ("videostory".equals(this.cti)) {
        return aCZ();
      }
      if ((this.cti.equals("manage_troop")) && (this.ctj.equals("main_page"))) {
        return acT();
      }
      if (("microapp".equals(this.cti)) && ("open".equals(this.ctj))) {
        return aCS();
      }
      if (("miniapp".equals(this.cti)) && ("open".equals(this.ctj))) {
        return com.tencent.mobileqq.mini.sdk.MiniAppLauncher.startMiniApp(this.context, this.source, 2016, null);
      }
      if (("miniapp".equals(this.cti)) && ("notifyclose".equals(this.ctj))) {
        return aCT();
      }
      if (("wallet".equals(this.cti)) && ("open".equals(this.ctj)) && ("0".equals(this.attrs.get("viewtype"))) && (!TextUtils.isEmpty((CharSequence)this.attrs.get("src_type"))) && ((this.attrs.get("view") == null) || ("0".equals(this.attrs.get("view"))))) {
        return acH();
      }
      if (("wallet".equals(this.cti)) && ("open".equals(this.ctj)) && ("0".equals(this.attrs.get("viewtype"))) && (!TextUtils.isEmpty((CharSequence)this.attrs.get("src_type")))) {
        return aCU();
      }
      if (("buscard".equals(this.cti)) && ("open".equals(this.ctj)) && (this.attrs.containsKey("from_type")) && (!aqmr.isEmpty((String)this.attrs.get("from_type"))) && ("2".equals(this.attrs.get("from_type")))) {
        return acG();
      }
      if (("wxminiapp".equals(this.cti)) && ("launch".equals(this.ctj)) && (this.attrs.containsKey("user_name")) && (!aqmr.isEmpty((String)this.attrs.get("user_name")))) {
        return acI();
      }
      if ("qqnotify".equals(this.cti))
      {
        if (!"open".equals(this.ctj)) {
          break label732;
        }
        edM();
      }
      for (;;)
      {
        if (("qqnotify".equals(this.cti)) && ("birth".equals(this.ctj)))
        {
          Intent localIntent = new Intent(this.context, ActivateFriendActivity.class);
          localIntent.putExtra("af_key_from", 2);
          this.context.startActivity(localIntent);
        }
        if (!this.cti.equals("ftssearch")) {
          break label942;
        }
        if (!this.ctj.equals("tab")) {
          break;
        }
        return ach();
        if ("subscribe".equals(this.ctj)) {
          edN();
        }
      }
      if (!this.ctj.equals("openmixweb")) {
        break label942;
      }
    }
    catch (Exception localException)
    {
      QLog.e("JumpAction", 1, "doAction error:" + localException.getMessage());
      localObject1 = new HashMap(1);
      if (this.source == null) {
        this.source = "";
      }
      if (this.cti == null) {
        this.cti = "";
      }
      if (this.ctj == null) {
        this.ctj = "";
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("JumpAction").append("source:").append(this.source).append("server_name:").append(this.cti).append("action_name:").append(this.ctj);
      ((HashMap)localObject1).put("keyJumpParserUtilDoActionErrorInfo", ((StringBuilder)localObject2).toString());
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance("", "keyJumpParserUtil", true, 0L, 0L, (HashMap)localObject1, "", false);
      return false;
    }
    return acg();
    label942:
    if ((this.cti.equals("wpa")) && (this.ctj.equals("openid_to_uin"))) {
      return aDy();
    }
    if ((this.cti.equals("im")) && (this.ctj.equals("chat"))) {
      return aDA();
    }
    if ((this.cti.equals("wsgzh")) && (this.ctj.equals("waterfall")))
    {
      ogj.c(this.context, "from_search_rzh_ws", 2, false);
      return true;
    }
    if ((this.cti.equals("wsgzh")) && (this.ctj.equals("miniapp_player")) && ("openPlayer".equals(this.attrs.get("action")))) {
      return okj.a().a(this.context, this.attrs);
    }
    if ((this.cti.equals("asyncmsg")) && (this.ctj.equals("open_async_detail"))) {
      return aEt();
    }
    if ((this.cti.equals("connect_miniapp")) && (this.ctj.equals("launch"))) {
      return aDz();
    }
    if ((this.cti.equals("im")) && (this.ctj.equals("aioorprofile"))) {
      return aDF();
    }
    if (this.cti.equals("qapp")) {
      return acB();
    }
    if ((this.cti.equals("lbs")) && (this.ctj.equals("show_nearby_fri"))) {
      return aDG();
    }
    if ((this.cti.equals("lbs")) && (this.ctj.equals("show_location"))) {
      return aDK();
    }
    if ((this.cti.equals("lbs")) && (this.ctj.equals("select_location"))) {
      return aDL();
    }
    if (("card".equals(this.cti)) && ("show_pslcard".equals(this.ctj))) {
      return aDM();
    }
    if ((this.cti.equals("personal_tag")) && (this.ctj.equals("tag_list"))) {
      return aDU();
    }
    if ((this.cti.equals("upload")) && (this.ctj.equals("photo"))) {
      return aEa();
    }
    if ((this.cti.equals("forward")) && (this.ctj.equals("url"))) {
      return aEe();
    }
    if ((this.cti.equals("forward")) && (this.ctj.equals("invite_register"))) {
      return aEK();
    }
    if ((this.cti.equals("gamesdk")) && (this.ctj.equals("bind_group"))) {
      return aEd();
    }
    if ((this.cti.equals("opensdk")) && (this.ctj.equals("join_group"))) {
      return aEb();
    }
    if ((this.cti.equals("opensdk")) && (this.ctj.equals("bind_group"))) {
      return aEc();
    }
    if ((this.cti.equals("share")) && (this.ctj.equals("to_fri"))) {
      return aEf();
    }
    if ((this.cti.equals("share")) && (this.ctj.equals("to_qqdataline"))) {
      return aEr();
    }
    if ((this.cti.equals("gamesdk")) && (this.ctj.equals("add_friend")))
    {
      if (!TextUtils.isEmpty((CharSequence)this.attrs.get("is_from_game"))) {
        ctn = toBase64Decode((String)this.attrs.get("is_from_game"));
      }
      return aEh();
    }
    if ((this.cti.equals("share")) && (this.ctj.equals("to_qqfav"))) {
      return aEj();
    }
    if ((this.cti.equals("share")) && (this.ctj.equals("to_qzone"))) {
      return augc.cD(this.context);
    }
    if (this.cti.equals("qzone")) {
      return augc.cD(this.context);
    }
    if (this.cti.equals("mqq"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "handleMQQService");
      }
      edS();
    }
    boolean bool1;
    while ((this.cti.equals("schedule")) && (this.ctj.equals("showDetail")))
    {
      return acQ();
      if ((this.cti.equals("groupopenapp")) && (this.ctj.equals("openapp"))) {
        return acU();
      }
      if ((this.cti.equals("lightapp")) && (this.ctj.equals("open"))) {
        return acn();
      }
      if (this.cti.endsWith("app"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "handleAppForward");
        }
        return aEq();
      }
      if ((this.cti.equals("qm")) && (this.ctj.equals("qr"))) {
        return acC();
      }
      if ((this.cti.equals("dc")) && (this.ctj.equals("ft"))) {
        return aEk();
      }
      if ("group".equals(this.cti))
      {
        if (this.ctj.equals("nearby")) {
          return aDH();
        }
        if (this.ctj.equals("create")) {
          return aDI();
        }
        if (this.ctj.equals("report")) {
          return aEL();
        }
      }
      else
      {
        if (this.cti.equals("shop")) {
          return aCV();
        }
        if ((this.cti.equals("cmshow")) && (this.ctj.equals("game_invite")))
        {
          QLog.i("JumpAction", 1, "[cmshow.game_invite], source:" + this.source);
          return kK(this.source);
        }
        if (("profile".equals(this.cti)) && ("avatar_edit".equals(this.ctj))) {
          return aDo();
        }
        if (("profile".equals(this.cti)) && ("sdk_avatar_edit".equals(this.ctj))) {
          return aDq();
        }
        if (("profile".equals(this.cti)) && ("sdk_dynamic_avatar_edit".equals(this.ctj))) {
          return aDr();
        }
        if (("profile".equals(this.cti)) && ("sdk_face_collection".equals(this.ctj))) {
          return aDp();
        }
        if (("profile".equals(this.cti)) && ("more_info_edit".equals(this.ctj)))
        {
          localObject1 = new Intent(this.context, FriendProfileMoreInfoActivity.class);
          this.context.startActivity((Intent)localObject1);
        }
        else if (("userprofile".equals(this.cti)) && ("friend_profile_card".equals(this.ctj)))
        {
          edO();
        }
        else
        {
          if (("contact".equals(this.cti)) && ("might_know".equals(this.ctj))) {
            return aDs();
          }
          if (("contact".equals(this.cti)) && ("search_might_know".equals(this.ctj))) {
            return aDt();
          }
          if (("contact".equals(this.cti)) && ("new_friends".equals(this.ctj))) {
            return aDu();
          }
          if (("contact".equals(this.cti)) && ("contacts_tab".equals(this.ctj))) {
            return aDv();
          }
          if (("contact".equals(this.cti)) && ("phone_recommend".equals(this.ctj))) {
            return aDw();
          }
          if (((this.cti.equals("readingcenter")) || (this.cti.equals("qqreader"))) && (this.ctj.equals("open"))) {
            return aDJ();
          }
          if ((this.cti.equals("healthcenter")) && (this.ctj.equals("open"))) {
            return aCW();
          }
          if ((this.cti.equals("ptlogin")) && (this.ctj.equals("qlogin"))) {
            return aEl();
          }
          if ((this.cti.equals("gav")) && (this.ctj.equals("request"))) {
            return aEm();
          }
          if (("videochat".equals(this.cti)) && ("request".equals(this.ctj))) {
            return aEn();
          }
          if (("randomavchat".equals(this.cti)) && ("request".equals(this.ctj))) {
            return aEo();
          }
          if (this.cti.equals("tribe")) {
            return aCX();
          }
          if ((this.cti.equals("qqdataline")) && (this.ctj.equals("openqqdataline"))) {
            return aDx();
          }
          if ((this.cti.equals("wallet")) && (this.ctj.equals("modify_pass"))) {
            return acF();
          }
          if (this.cti.equals("dating"))
          {
            if (this.ctj.equals("detail")) {
              return aDn();
            }
            if (this.ctj.equals("publish")) {
              return aDm();
            }
            if (this.ctj.equals("feed")) {
              return aDl();
            }
          }
          else if (this.cti.equals("nearby_entry"))
          {
            if (this.ctj.equals("nearby_feed")) {
              return aci();
            }
            if (this.ctj.equals("nearby_profile")) {
              return aDN();
            }
            if (this.ctj.equals("hotchat_list")) {
              return aDi();
            }
            if (this.ctj.equals("hotchat_room")) {
              return aDj();
            }
            if (this.ctj.equals("visitor_list")) {
              return aEI();
            }
          }
          else if (this.cti.equals("nearby"))
          {
            if (this.ctj.equals("reportFriend")) {
              return aEM();
            }
          }
          else if (this.cti.equals("hotchat"))
          {
            if (this.ctj.equals("newyear_scene")) {
              return aDk();
            }
          }
          else
          {
            bool1 = bool2;
            if (this.cti.equals("freshnews_entry")) {
              break label4988;
            }
            if ((this.cti.equals("qlink")) && (this.ctj.equals("openqlink"))) {
              return aEs();
            }
            if ((this.cti.equals("share")) && (this.ctj.equals("to_troopbar"))) {
              return aEu();
            }
            if ((this.cti.equals("qqconnect")) && (this.ctj.equals("url"))) {
              return aEv();
            }
            if ((this.cti.equals("publicdevice")) && (this.ctj.equals("url"))) {
              return aEx();
            }
            if ((this.cti.equals("openLightApp")) && (this.ctj.equals("url"))) {
              return aEw();
            }
            if (("tenpay".equals(this.cti)) && ("sendHongBao".equals(this.ctj))) {
              return aEy();
            }
            if (("massbless".endsWith(this.cti)) && ("mainpage".equals(this.ctj))) {
              return aEz();
            }
            if (this.cti.equals("interesttag")) {
              return aDf();
            }
            if (this.cti.equals("qqcomic")) {
              return aEp();
            }
            if (("leba_plugin".equals(this.cti)) && ("set".equals(this.ctj))) {
              return aEA();
            }
            if (this.cti.equals("pa_relationship")) {
              return aEB();
            }
            if (this.cti.equals("od")) {
              return acp();
            }
            if (this.cti.equals("odAddFriend")) {
              return aco();
            }
            if ("huayang".equals(this.cti)) {
              return acm();
            }
            if ("qboss".equals(this.cti)) {
              return aljn.b(this.context, this.attrs);
            }
            if (this.cti.equals("readinjoy")) {
              return aCY();
            }
            if ((this.cti.equals("cmshow")) && (this.ctj.equals("apollo_action")))
            {
              if (abhh.aV(this.context)) {
                return aEH();
              }
            }
            else
            {
              if ((this.cti.equals("cmshow")) && (this.ctj.equals("open_game"))) {
                return h(this.attrs);
              }
              if ("favorites".equals(this.cti))
              {
                if ("forward_favorites".equals(this.ctj))
                {
                  localObject1 = new Intent();
                  ((Intent)localObject1).putExtra("selfSet_leftViewText", BaseApplicationImpl.getApplication().getApplicationContext().getString(2131691039));
                  return avja.a((Activity)this.context, this.app.getAccount(), (Intent)localObject1, -1, false);
                }
              }
              else if ("hongbao_share".equals(this.cti))
              {
                if ("hongbao_brush".equals(this.ctj)) {
                  return aDa();
                }
              }
              else if ("general_ar".equals(this.cti))
              {
                if ("gotoScannerTorchActivity".equals(this.ctj)) {
                  return aDd();
                }
              }
              else
              {
                if ("mqqavshare://".equals(this.cti))
                {
                  this.cUi = true;
                  return ivc.a(this);
                }
                if ("setting".equals(this.cti))
                {
                  if ("general".equals(this.ctj)) {
                    return aEG();
                  }
                }
                else if ("assistant_setting".equals(this.cti))
                {
                  if ("ASSISTANT_SETTING".equals(this.ctj)) {
                    return acd();
                  }
                }
                else if ((this.cti.equals("conf")) || (this.cti.equals("confpstn")) || (this.cti.equals("confhr")))
                {
                  if (this.ctj.equals("ft")) {
                    return aEJ();
                  }
                }
                else if ("teamwork".equals(this.cti))
                {
                  if ("opendoclist".equals(this.ctj)) {
                    return acS();
                  }
                }
                else
                {
                  if ("qstory".equals(this.cti))
                  {
                    if ("openNow".equals(this.ctj)) {
                      return acu();
                    }
                    return acv();
                  }
                  if ("now".equals(this.cti))
                  {
                    if ("openroom".equals(this.ctj)) {
                      return acu();
                    }
                    if ("playmedia".equals(this.ctj)) {
                      return acR();
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    if ((this.cti.equals("contact")) && (this.ctj.equals("add"))) {
      return acf();
    }
    if ((this.cti.equals("profile")) && (this.ctj.equals("setting"))) {
      return acq();
    }
    if (this.cti.equals("qqreg")) {
      return act();
    }
    if ((this.cti.equals("troop_member_card")) && (this.ctj.equals("open_member_recent_chat_view"))) {
      return aDh();
    }
    if (this.cti.equals("qwerewolf"))
    {
      if (this.ctj.equals("openInvitationRoom")) {
        return acr();
      }
      bool1 = bool2;
      if (this.ctj.equals("enterGameRoom")) {
        return acs();
      }
    }
    else if (this.cti.equals("groupvideo"))
    {
      if (this.ctj.equals("openroom")) {
        return acj();
      }
      bool1 = bool2;
      if (this.ctj.equals("preload")) {
        return acl();
      }
    }
    else if (this.cti.equals("studyroom"))
    {
      bool1 = bool2;
      if (this.ctj.equals("enter")) {
        return aEN();
      }
    }
    else if (this.cti.equals("invite_join_group"))
    {
      bool1 = bool2;
      if (this.ctj.equals("open")) {
        return aEO();
      }
    }
    else
    {
      if (("troop_homework".equals(this.cti)) && ("publish".equals(this.ctj))) {
        return kL(getAttribute("gc"));
      }
      if ((this.cti.equals("nearby_videochat")) && (this.ctj.equals("open_plugin")))
      {
        if ((this.context instanceof Activity))
        {
          localObject1 = (apre)this.app.getManager(224);
          NearbyVideoChatProxyActivity.a(this.app, (Activity)this.context, null, ((apre)localObject1).By(), null, 123987);
          return true;
        }
        QLog.i("JumpAction", 1, "openNearbyVideoChatActivity, context is not a activity");
        return false;
      }
      if ("weishitab".equals(this.cti))
      {
        bool1 = bool2;
        if ("open".equals(this.ctj))
        {
          edP();
          return false;
        }
      }
      else
      {
        if ("page_router".equals(this.cti))
        {
          aDb();
          return true;
        }
        if ("msg_list".equals(this.cti))
        {
          aDc();
          return true;
        }
        if ("watchtogether".equals(this.cti))
        {
          bool1 = bool2;
          if (this.ctj.equals("openroom")) {
            return aEP();
          }
        }
        else
        {
          if ("share_group".equals(this.cti))
          {
            if (!this.ctj.equals("open")) {
              break label4990;
            }
            localObject1 = (String)this.attrs.get("groupcode");
            if (localObject1 == null) {
              break label4990;
            }
            apuh.l(this.app, this.context, (String)localObject1);
            break label4990;
          }
          if ("edit_group".equals(this.cti))
          {
            if (!this.ctj.equals("open")) {
              break label4992;
            }
            localObject1 = (String)this.attrs.get("groupcode");
            if (localObject1 == null) {
              break label4992;
            }
            apuh.m(this.app, this.context, (String)localObject1);
            break label4992;
          }
          if ("weishiforqassistant".equals(this.cti))
          {
            ogj.c(this.context, "from_audio_assistant", 1, true);
            return true;
          }
          if ("nearbyforqassistant".equals(this.cti))
          {
            localObject1 = new Intent(this.context, NearbyGuideActivity.class);
            ((Intent)localObject1).putExtra("ENTER_TIME", System.currentTimeMillis());
            ((Intent)localObject1).putExtra("IS_HAS_REDTOUCH", false);
            ((Intent)localObject1).putExtra("FROM_WHERE", 1);
            ((Intent)localObject1).putExtra("RANK_BANNER_PUSH", "");
            this.context.startActivity((Intent)localObject1);
            return true;
          }
          if ("qechatforqassistant".equals(this.cti))
          {
            ExtendFriendPublicFragmentActivity.ek(this.context);
            return true;
          }
          if ("searchforqassistant".equals(this.cti))
          {
            localObject1 = getAttribute("searchkey");
            UniteSearchActivity.v(this.context, (String)localObject1, 10004);
            return true;
          }
          if ("settingsforqassistant".equals(this.cti))
          {
            localObject1 = new Intent(this.context, QQSettingSettingActivity.class);
            this.context.startActivity((Intent)localObject1);
            return true;
          }
          if ("confiessmsgforqassistant".equals(this.cti))
          {
            aegp localaegp = ((aegs)this.app.getManager(269)).b();
            localObject2 = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
            localObject1 = localObject2;
            if (localaegp != null)
            {
              localObject1 = localObject2;
              if (!TextUtils.isEmpty(localaegp.bwV)) {
                localObject1 = localaegp.bwV;
              }
            }
            localObject2 = new Intent(this.context, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("uin", this.app.getCurrentAccountUin());
            ((Intent)localObject2).putExtra("url", (String)localObject1);
            this.context.startActivity((Intent)localObject2);
            return true;
          }
          if ("scanforqassistant".equals(this.cti))
          {
            if (!(this.context instanceof BaseActivity)) {
              break label4994;
            }
            aakj.a((BaseActivity)this.context, 0L, 0L, 0);
            break label4994;
          }
          if ("bind_number".equals(this.cti))
          {
            bool1 = bool2;
            if ("bind".equals(this.ctj))
            {
              aDe();
              return true;
            }
          }
          else if ("stickynote".equals(this.cti))
          {
            bool1 = bool2;
            if ("feeddetail".equals(this.ctj))
            {
              cOH();
              return true;
            }
          }
          else
          {
            bool1 = bool2;
            if ("commonBuddyGroup".equals(this.cti))
            {
              bool1 = bool2;
              if ("open".equals(this.ctj))
              {
                cOI();
                bool1 = true;
              }
            }
          }
        }
      }
    }
    label4988:
    return bool1;
    label4990:
    return true;
    label4992:
    return true;
    label4994:
    return true;
  }
  
  public boolean acf()
  {
    Intent localIntent = new Intent(this.context, AddContactsActivity.class);
    localIntent.setFlags(67108864);
    int j = Integer.parseInt((String)this.attrs.get("des_type"));
    int i = j;
    if (j != 0)
    {
      i = j;
      if (j != 1)
      {
        i = j;
        if (j != 2) {
          i = 0;
        }
      }
    }
    localIntent.putExtra("tab_index_key", i);
    this.context.startActivity(localIntent);
    return true;
  }
  
  public boolean acg()
  {
    Intent localIntent = new Intent(this.context, QQBrowserActivity.class);
    if (this.attrs.containsKey("url")) {
      this.attrs.remove("url");
    }
    Object localObject = this.attrs.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localIntent.putExtra((String)localEntry.getKey(), Uri.decode((String)localEntry.getValue()));
    }
    if (this.attrs.containsKey("weburl")) {}
    for (localObject = Uri.decode((String)this.attrs.get("weburl")); (((String)localObject).startsWith("https://sou.qq.com/")) || (((String)localObject).startsWith("https://sou.html5.qq.com/")); localObject = "")
    {
      localIntent.putExtra("url", (String)localObject);
      localIntent.putExtra("fragment_class", "com.tencent.mobileqq.search.activity.MixSearchWebFragment");
      this.context.startActivity(localIntent);
      if (((this.context instanceof Activity)) && (!"1".equals(this.attrs.get("openanimtype")))) {
        ((Activity)this.context).overridePendingTransition(0, 0);
      }
      return true;
    }
    return false;
  }
  
  public boolean acp()
  {
    String str = (String)this.attrs.get("roomid");
    Object localObject6 = (String)this.attrs.get("fromid");
    Object localObject3 = "";
    Object localObject1 = localObject3;
    if (!TextUtils.isEmpty((CharSequence)this.attrs.get("vasname"))) {}
    try
    {
      localObject1 = URLDecoder.decode((String)this.attrs.get("vasname"), "utf-8");
      localObject5 = "";
      localObject3 = localObject5;
      if (TextUtils.isEmpty((CharSequence)this.attrs.get("userdata"))) {}
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      try
      {
        localObject3 = URLDecoder.decode((String)this.attrs.get("vasname"), "utf-8");
        long l1 = 0L;
        try
        {
          long l2 = Long.parseLong(str);
          l1 = l2;
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          for (;;)
          {
            int i;
            localNumberFormatException1.printStackTrace();
          }
        }
        i = 0;
        try
        {
          int j = Integer.parseInt((String)localObject6);
          i = j;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          for (;;)
          {
            Object localObject2;
            Object localObject4;
            localNumberFormatException2.printStackTrace();
          }
        }
        localObject5 = this.app;
        localObject6 = this.app;
        ((aigu)((QQAppInterface)localObject5).getManager(108)).a(this.context, l1, "launcher", (String)localObject1, (String)localObject3, i);
        return true;
        localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
        localUnsupportedEncodingException1.printStackTrace();
        localObject2 = localObject3;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        for (;;)
        {
          Object localObject5;
          localUnsupportedEncodingException2.printStackTrace();
          localObject4 = localObject5;
        }
      }
    }
  }
  
  public boolean acq()
  {
    Intent localIntent = new Intent(this.context, InterestSwitchEditActivity.class);
    localIntent.setFlags(67108864);
    this.context.startActivity(localIntent);
    return true;
  }
  
  public boolean acu()
  {
    Object localObject1;
    String str2;
    if ((this.context instanceof Activity))
    {
      localObject1 = ((Activity)this.context).getIntent();
      if (localObject1 != null)
      {
        str2 = ((Intent)localObject1).getStringExtra("big_brother_source_key");
        localObject1 = ((Intent)localObject1).getDataString();
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = this.source;
      }
      for (;;)
      {
        if (this.attrs.containsKey("roomid")) {}
        for (String str3 = (String)this.attrs.get("roomid");; str3 = "0")
        {
          if (this.attrs.containsKey("fromid")) {}
          for (String str4 = (String)this.attrs.get("fromid");; str4 = "")
          {
            if (this.attrs.containsKey("roomtype")) {}
            for (String str5 = (String)this.attrs.get("roomtype");; str5 = "")
            {
              if (this.attrs.containsKey("list_name")) {}
              for (String str6 = (String)this.attrs.get("list_name");; str6 = "")
              {
                if (this.attrs.containsKey("first_jump_mode")) {}
                for (String str7 = (String)this.attrs.get("first_jump_mode");; str7 = "h5")
                {
                  if (this.attrs.containsKey("need_record")) {}
                  for (String str8 = (String)this.attrs.get("need_record");; str8 = "1")
                  {
                    if (this.attrs.containsKey("is_record")) {}
                    for (String str9 = (String)this.attrs.get("is_record");; str9 = "0")
                    {
                      if (this.attrs.containsKey("enter_record_if_finish")) {}
                      for (String str10 = (String)this.attrs.get("enter_record_if_finish");; str10 = "1")
                      {
                        if (this.attrs.containsKey("nowapp_ext")) {}
                        for (String str11 = (String)this.attrs.get("nowapp_ext");; str11 = "")
                        {
                          if (this.attrs.containsKey("nowplugin_ext")) {}
                          for (String str12 = (String)this.attrs.get("nowplugin_ext");; str12 = "")
                          {
                            if (this.attrs.containsKey("h5_ext")) {}
                            for (String str13 = (String)this.attrs.get("h5_ext");; str13 = "")
                            {
                              if (this.attrs.containsKey("shakespearetime")) {}
                              for (String str14 = (String)this.attrs.get("shakespearetime");; str14 = "")
                              {
                                if (this.attrs.containsKey("msgurl")) {}
                                for (String str15 = toBase64Decode((String)this.attrs.get("msgurl"));; str15 = "")
                                {
                                  if (this.attrs.containsKey("hostloading_percent")) {}
                                  for (String str16 = (String)this.attrs.get("hostloading_percent");; str16 = "0")
                                  {
                                    String str17 = (String)this.attrs.get("coverurl");
                                    String str18 = (String)this.attrs.get("extras");
                                    Object localObject2 = (String)this.attrs.get("bid");
                                    localObject2 = (String)this.attrs.get("first");
                                    localObject2 = new Bundle();
                                    ((Bundle)localObject2).putString("coverurl", str17);
                                    ((Bundle)localObject2).putString("roomid", str3);
                                    ((Bundle)localObject2).putString("roomtype", str5);
                                    ((Bundle)localObject2).putString("extras_from_js", str18);
                                    ((Bundle)localObject2).putBoolean("can_use_h5_first", true);
                                    ((Bundle)localObject2).putString("first_jump_mode", str7);
                                    ((Bundle)localObject2).putString("is_record", str9);
                                    ((Bundle)localObject2).putString("enter_record_if_finish", str10);
                                    ((Bundle)localObject2).putString("nowapp_ext", str11);
                                    ((Bundle)localObject2).putString("nowplugin_ext", str12);
                                    ((Bundle)localObject2).putString("h5_ext", str13);
                                    ((Bundle)localObject2).putString("shakespearetime", str14);
                                    ((Bundle)localObject2).putString("fromid", str4);
                                    ((Bundle)localObject2).putString("url", str15);
                                    ((Bundle)localObject2).putString("listname", str6);
                                    ((Bundle)localObject2).putString("mqqScheme", (String)localObject1);
                                    if (!TextUtils.isEmpty(str2)) {
                                      ((Bundle)localObject2).putString("big_brother_source_key", str2);
                                    }
                                    boolean bool2 = true;
                                    boolean bool1 = bool2;
                                    if (!TextUtils.isEmpty(str8))
                                    {
                                      bool1 = bool2;
                                      if ("0".equals(str8)) {
                                        bool1 = false;
                                      }
                                    }
                                    ((Bundle)localObject2).putBoolean("need_record", bool1);
                                    if (this.attrs.containsKey("topic")) {
                                      ((Bundle)localObject2).putString("topic", (String)this.attrs.get("topic"));
                                    }
                                    if (this.attrs.containsKey("story_ext")) {
                                      ((Bundle)localObject2).putString("story_ext", (String)this.attrs.get("story_ext"));
                                    }
                                    if (this.attrs.containsKey("startsrc")) {
                                      ((Bundle)localObject2).putString("startsrc", (String)this.attrs.get("startsrc"));
                                    }
                                    if (this.attrs.containsKey("hostloading_percent")) {
                                      ((Bundle)localObject2).putInt("hostloading_percent", Integer.valueOf(str16).intValue());
                                    }
                                    if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getApplication()))
                                    {
                                      QQToast.a(BaseApplicationImpl.getApplication(), 1, "无网络连接请稍后再试", 1).show();
                                      return false;
                                    }
                                    try
                                    {
                                      ((aifl)this.app.getManager(306)).cL((Bundle)localObject2);
                                      QLog.i("JumpAction", 1, "enter now plugin use shadow");
                                      return true;
                                    }
                                    catch (Exception localException)
                                    {
                                      if (QLog.isColorLevel()) {
                                        QLog.e("JumpAction", 2, localException.toString());
                                      }
                                      return false;
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
              }
            }
          }
        }
      }
      String str1 = "";
      str2 = null;
    }
  }
  
  public void am(int paramInt)
  {
    if (this.jdField_a_of_type_Arhz == null) {
      this.jdField_a_of_type_Arhz = new arhz(this.context, this.context.getResources().getDimensionPixelSize(2131299627));
    }
    this.jdField_a_of_type_Arhz.setMessage(paramInt);
    if ((!((JumpActivity)this.context).isFinishing()) && (!this.jdField_a_of_type_Arhz.isShowing())) {
      this.jdField_a_of_type_Arhz.show();
    }
  }
  
  public void cs(Activity paramActivity)
  {
    if ((this.cti.equals("card")) && (this.ctj.equals("show_pslcard")) && (QSecFramework.a().c(1003).booleanValue())) {
      arnv.a().j(paramActivity, null);
    }
  }
  
  public void edJ()
  {
    this.cUf = true;
  }
  
  public void edK()
  {
    this.cUb = true;
  }
  
  public void fj(String paramString1, String paramString2)
  {
    this.attrs.put(paramString1, paramString2);
  }
  
  public Intent g(Intent paramIntent)
  {
    paramIntent.putExtra("action", 5);
    paramIntent.putExtra("extra_jump_attrs", this.attrs);
    return paramIntent;
  }
  
  public void gY(String paramString)
  {
    this.ctk = paramString;
  }
  
  public QQAppInterface getApp()
  {
    return this.app;
  }
  
  public String getAttribute(String paramString)
  {
    return (String)this.attrs.get(paramString);
  }
  
  public String getServerName()
  {
    return this.cti;
  }
  
  public Intent h(Intent paramIntent)
  {
    paramIntent.putExtra("action", 4);
    String str2 = (String)this.attrs.get("topicname");
    String str3 = (String)this.attrs.get("topicid");
    String str4 = (String)this.attrs.get("storysharefrom");
    String str1 = str2;
    try
    {
      if (TextUtils.equals(str4, "qzone")) {
        str1 = URLDecoder.decode(str2, "utf-8");
      }
      paramIntent.putExtra("extra_topic_id", Long.parseLong(str3));
      paramIntent.putExtra("extra_topic_name", str1);
      paramIntent.putExtra("extra_partner_api", (String)this.attrs.get("parter_api"));
      paramIntent.putExtra("extra_share_from_type", c(this.attrs));
      return paramIntent;
    }
    catch (Exception paramIntent) {}
    return null;
  }
  
  public boolean h(Map<String, String> paramMap)
  {
    if (paramMap == null)
    {
      QLog.e("JumpAction", 1, "[gotoApolloGame] attrs null");
      return false;
    }
    Object localObject = (String)paramMap.get("gameid");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = (String)paramMap.get("gameId");
    }
    for (;;)
    {
      String str = (String)paramMap.get("gamename");
      if (TextUtils.isEmpty(str)) {
        str = (String)paramMap.get("gameName");
      }
      for (;;)
      {
        QLog.d("JumpAction", 1, new Object[] { "[gotoApolloGame] game id=", localObject });
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          try
          {
            int k = Integer.parseInt((String)localObject);
            int j = 221;
            int i = j;
            if (paramMap.containsKey("src")) {
              localObject = (String)paramMap.get("src");
            }
            try
            {
              i = Integer.parseInt((String)localObject);
              QLog.d("JumpAction", 1, new Object[] { "[gotoApolloGame] src=", Integer.valueOf(i) });
              CmGameStartChecker.StartCheckParam localStartCheckParam = new CmGameStartChecker.StartCheckParam(k, true, "launch", 0L, 9, 8, 0, 0, "", i, str);
              str = (String)paramMap.get("gameParam");
              localObject = str;
              if (TextUtils.isEmpty(str)) {
                localObject = (String)paramMap.get("gameparam");
              }
              if (!TextUtils.isEmpty((CharSequence)localObject))
              {
                localStartCheckParam.extendJson = ((String)localObject);
                QLog.d("JumpAction", 1, new Object[] { "[gotoApolloGame] gameParam=", localObject });
              }
              ApolloGameUtil.a(this.context, localStartCheckParam);
              return true;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                QLog.e("JumpAction", 1, "open apollo game, parse src failed, e=", localException);
                i = j;
              }
            }
            QLog.e("JumpAction", 1, "open apollo game failed, no game id");
          }
          catch (Exception paramMap)
          {
            QLog.e("JumpAction", 1, "open apollo game, parse game id failed, e=", paramMap);
            return false;
          }
        }
        return false;
      }
    }
  }
  
  public void hideProgressDialog()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.isShowing())) {
      this.jdField_a_of_type_Arhz.dismiss();
    }
  }
  
  public Intent i(Intent paramIntent)
  {
    paramIntent.putExtra("action", 12);
    try
    {
      paramIntent.putExtra("extra_partner_api", (String)this.attrs.get("parter_api"));
      paramIntent.putExtra("extra_share_from_type", c(this.attrs));
      paramIntent.putExtra("to_new_version", (String)this.attrs.get("to_new_version"));
      return paramIntent;
    }
    catch (Exception paramIntent) {}
    return null;
  }
  
  public Intent j(Intent paramIntent)
  {
    String str1 = (String)this.attrs.get("userid");
    String str2 = (String)this.attrs.get("usertype");
    String str3 = (String)this.attrs.get("unionid");
    String str4 = (String)this.attrs.get("storyid");
    String str5 = (String)this.attrs.get("showinfocard");
    int i = c(this.attrs);
    if ((str5 != null) && (str5.equals("0"))) {}
    for (boolean bool = false;; bool = true)
    {
      if (TextUtils.isEmpty(str4))
      {
        if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3))) {
          return null;
        }
        int j;
        try
        {
          j = Integer.parseInt(str2);
          if (j == 1)
          {
            if (TextUtils.isEmpty(str1)) {
              return null;
            }
            paramIntent.putExtra("action", 7);
            paramIntent.putExtra("EXTRA_USER_UIN", str1);
            paramIntent.putExtra("EXTRA_USER_UNION_ID", str3);
            paramIntent.putExtra("extra_is_show_info_card", bool);
            paramIntent.putExtra("extra_share_from_type", i);
            paramIntent.putExtra("extra_partner_api", (String)this.attrs.get("parter_api"));
            return paramIntent;
          }
        }
        catch (NumberFormatException paramIntent)
        {
          if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "makeStoryPlayVideoPageIntent, NumberFormatException, userId:" + str1 + ", userType:" + str2);
          }
          return null;
        }
        if (j == 5)
        {
          paramIntent.putExtra("action", 4);
          paramIntent.putExtra("extra_topic_id", Long.parseLong(str1));
          paramIntent.putExtra("extra_topic_name", (String)this.attrs.get("topicname"));
          str3 = (String)this.attrs.get("topiccolor");
          if (!TextUtils.isEmpty(str3)) {
            paramIntent.putExtra("extra_topic_color", Integer.parseInt(str3));
          }
          paramIntent.putExtra("extra_partner_api", (String)this.attrs.get("parter_api"));
          paramIntent.putExtra("extra_share_from_type", i);
          return paramIntent;
        }
        paramIntent.putExtra("action", 6);
        paramIntent.putExtra("user_type", Integer.parseInt(str2));
        paramIntent.putExtra("user_unionid", str3);
        paramIntent.putExtra("come_from", i);
        paramIntent.putExtra("showTitleBar", false);
        paramIntent.putExtra("showInfoCard", bool);
        return paramIntent;
      }
      paramIntent.putExtra("action", 6);
      paramIntent.putExtra("story_id", str4);
      paramIntent.putExtra("come_from", i);
      paramIntent.putExtra("showTitleBar", false);
      paramIntent.putExtra("showInfoCard", false);
      return paramIntent;
    }
  }
  
  protected boolean kL(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if ((this.context instanceof Activity))
    {
      PublishHomeWorkFragment.b((Activity)this.context, null, paramString);
      ((Activity)this.context).overridePendingTransition(2130772367, 2130772002);
    }
    return true;
  }
  
  public void setAppInfo(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    this.c = paramAppInfo;
  }
  
  public void setAppInterface(AppInterface paramAppInterface)
  {
    this.mAppInterface = paramAppInterface;
  }
  
  public void setFrom(String paramString)
  {
    this.from = paramString;
  }
  
  public void setPkgName(String paramString)
  {
    this.pkgName = paramString;
  }
  
  public class a
    extends acfd
  {
    private final aqhv b;
    
    public a(aqhv paramaqhv)
    {
      this.b = paramaqhv;
    }
    
    protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
    {
      if ((!paramBoolean) || (aqhv.this.y == null) || (!aqhv.this.y.containsKey(paramString))) {}
      do
      {
        return;
        aqhv.this.y.remove(paramString);
        if (aqhv.this.y.size() == 0) {
          aqhv.this.app.removeObserver(aqhv.this.a);
        }
        Object localObject = Uri.parse(aqhv.a(aqhv.this) + "&uin=" + paramString);
        localObject = new Intent((String)aqhv.this.attrs.get("callback_name"), (Uri)localObject);
        aqhv.this.context.sendBroadcast((Intent)localObject, "com.tencent.tim.msg.permission.pushnotify");
      } while (!QLog.isColorLevel());
      QLog.i("JumpAction", 2, "download head " + paramString + " success. Send broadcast to " + (String)aqhv.this.attrs.get("callback_name"));
    }
  }
  
  class b
    extends Handler
  {
    private b() {}
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what != 1) {
        return;
      }
      if (aqhv.a(aqhv.this) != null)
      {
        aqhv.a(aqhv.this).cLZ();
        aqhv.this.app.removeObserver(aqhv.a(aqhv.this));
      }
      if (paramMessage.arg1 != 1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("JumpAction", 2, "msf return error ");
        }
        aqhv.a(aqhv.this, 1);
        return;
      }
      if ((paramMessage.obj instanceof RespCheckChangePwdAuth))
      {
        paramMessage = (RespCheckChangePwdAuth)paramMessage.obj;
        if (paramMessage.retCode == 0)
        {
          aqhv.c(aqhv.this);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("JumpAction", 2, "server return error, errorCode: " + paramMessage.retCode + " errorMsg: " + paramMessage.retMsg);
        }
      }
      aqhv.a(aqhv.this, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqhv
 * JD-Core Version:    0.7.0.1
 */