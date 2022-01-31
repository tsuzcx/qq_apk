package com.tencent.mobileqq.utils;

import NearbyGroup.GroupInfo;
import QQWalletPay.ReqCheckChangePwdAuth;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.dataline.activities.LiteActivity;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.qrcode.activity.QRJumpActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.LebaHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletAuthHandler;
import com.tencent.mobileqq.app.QWalletAuthObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.mobileqq.troop.data.NearbyOpenTroop;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.AgentActivity;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavReport;
import cooperation.qqfav.QfavUtil;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.troop.TroopProxyActivity;
import etn;
import eto;
import etp;
import etq;
import etr;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class JumpAction
{
  public static final String A = "web";
  public static final String B = "url";
  public static final String C = "bid";
  public static final String D = "sourceUrl";
  public static final String E = "puzzle_verify_code";
  public static final String F = "PUZZLEVERIFYCODE";
  public static final String G = "VERIFYCODE";
  public static final String H = "DEVLOCK_CODE";
  public static final String I = "chat";
  public static final String J = "pay";
  public static final String K = "openqqdataline";
  public static final String L = "dating";
  public static final String M = "detail";
  public static final String N = "dating_id";
  public static final String O = "bind_group";
  public static final String P = "show_nearby_fri";
  public static final String Q = "show_location";
  public static final String R = "select_location";
  public static final String S = "open";
  public static final String T = "modify_pass";
  public static final String U = "show_pslcard";
  public static final String V = "show_groupcard";
  public static final String W = "photo";
  public static final String X = "url";
  public static final String Y = "to_fri";
  public static final String Z = "to_qqfav";
  public static final int a = 3;
  public static final String a = "im";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "com.tencent.qqlite" };
  public static final String aA = "app_info";
  public static final String aB = "viewtype";
  public static final String aC = "plugin_start_time";
  public static final String aD = "is_from_leba";
  public static final String aE = "has_red_dot";
  public static final String aF = "chat_type";
  public static final String aG = "uin";
  public static final String aH = "attach_content";
  public static final String aI = "group_info";
  public static final String aJ = "discuss_info";
  public static final String aK = "sigt";
  public static final String aL = "sig";
  public static final String aM = "kfnick";
  public static final String aN = "params";
  public static final String aO = "url";
  public static final String aP = "picture";
  public static final String aQ = "title";
  public static final String aR = "summary";
  public static final String aS = "gid";
  public static final String aT = "brief";
  public static final String aU = "source";
  public static final String aV = "puin";
  public static final String aW = "price";
  public static final String aX = "prunit";
  public static final String aY = "layout";
  public static final String aZ = "icon";
  public static final String aa = "to_troopbar";
  public static final String ab = "add_friend";
  public static final String ac = "writemood";
  public static final String ad = "open_homepage";
  public static final String ae = "qr";
  public static final String af = "ft";
  public static final String ag = "nearby";
  public static final String ah = "create";
  public static final String ai = "emoji";
  public static final String aj = "emoji_detail";
  public static final String ak = "emoji_author";
  public static final String al = "bubble";
  public static final String am = "theme";
  public static final String an = "font";
  public static final String ao = "open";
  public static final String ap = "qlogin";
  public static final String aq = "groupalbum";
  public static final String ar = "sharealbum";
  public static final String as = "request";
  public static final String at = "request";
  public static final String au = "to_qqdataline";
  public static final String av = "version";
  public static final String aw = "channel_id";
  public static final String ax = "src_type";
  public static final String ay = "callback_type";
  public static final String az = "callback_name";
  public static int b = 0;
  public static final String b = "lbs";
  public static final String bA = "image_url";
  public static final String bB = "app_name";
  public static final String bC = "open_id";
  public static final String bD = "share_uin";
  public static final String bE = "jfrom";
  public static final String bF = "audioUrl";
  public static final String bG = "req_type";
  public static final String bH = "game_union_id";
  public static final String bI = "game_zone_id";
  public static final String bJ = "signature";
  public static final String bK = "back_title";
  public static final String bL = "card_type";
  public static final String bM = "wSourceSubID";
  public static final String bN = "wpa";
  public static final String bO = "url_app_info";
  public static final String bP = "k_requestcode";
  public static final String bQ = "fromSencondhandCommunity";
  public static final String bR = "from3rdApp";
  public static final String bS = "showFirstStructMsg";
  public static final String bT = "pakage_from_h5";
  public static final String bU = "creategroup";
  public static final String bV = "initgrouptype";
  public static final String bW = "DEFAULT";
  public static final String bX = "0";
  public static final String bY = "1";
  public static final String bZ = "2";
  public static final String ba = "srcaction";
  public static final String bb = "a_actionData";
  public static final String bc = "i_actionData";
  public static final String bd = "action";
  public static final String be = "appid";
  public static final String bf = "thirdAppDisplayName";
  public static final String bg = "paramencrypted_type";
  public static final String bh = "lon";
  public static final String bi = "lat";
  public static final String bj = "title";
  public static final String bk = "summary";
  public static final String bl = "bus_type";
  public static final String bm = "url_prefix";
  public static final String bn = "style";
  public static final String bo = "plg_auth";
  public static final String bp = "plg_nld";
  public static final String bq = "plg_dev";
  public static final String br = "plg_usr";
  public static final String bs = "plg_vkey";
  public static final String bt = "file_type";
  public static final String bu = "file_data";
  public static final String bv = "title";
  public static final String bw = "description";
  public static final String bx = "previewimagedata";
  public static final String by = "url";
  public static final String bz = "share_id";
  private static final int jdField_c_of_type_Int = 0;
  public static final String c = "card";
  private static final String cA = "packageName";
  private static final String cB = "signareMode";
  private static final String cC = "appid";
  private static final String cD = "timeStamp";
  private static final String cE = "resetWordMode";
  private static final String cF = "offerid";
  private static final String cG = "uin";
  private static final String cH = "txt";
  private static final String cK = "4eY#X@~g.+U)2%$<";
  private static final String cL = "Hf7K(s*js12LiskW";
  private static final String cO = "JumpAction";
  private static final String cP = "com.qqreader.QRBridgeActivity";
  public static final String ca = "troopType";
  public static final String cb = "fromH5";
  public static final String cc = "aioorprofile";
  public static final String cl = "wpaCount";
  public static final String cm = "webview";
  public static final String cn = "from_leba";
  public static final String co = "config_res_plugin_item_name";
  public static final String cp = "source_scheme";
  private static final String cq = "share_qq_ext_str";
  private static final String cr = "cflag";
  private static final String cs = "open_id";
  private static final String ct = "fopen_id";
  private static final String cu = "app_id";
  private static final String cv = "friend_label";
  private static final String cw = "add_msg";
  private static final String cx = "app_name";
  private static final String cy = "troopbar_id";
  private static final String cz = "troopbar_name";
  private static final int jdField_d_of_type_Int = 1;
  public static final String d = "upload";
  public static final String e = "forward";
  public static final String f = "share";
  public static final String g = "qzone";
  public static final String h = "mqq";
  public static final String i = "app";
  public static final String j = "qm";
  public static final String k = "gamesdk";
  public static final String l = "qqdataline";
  public static final String m = "wallet";
  public static final String n = "gav";
  public static final String o = "videochat";
  public static final String p = "tenpay";
  public static final String q = "dc";
  public static final String r = "group";
  public static final String s = "shop";
  public static final String t = "ptlogin";
  public static final String u = "readingcenter";
  public static final String v = "healthcenter";
  public static final String w = "crmivr";
  public static final String x = "audiochat";
  public static final String y = "imchat";
  public static final String z = "tribe_native";
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private final Context jdField_a_of_type_AndroidContentContext;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QWalletAuthObserver jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver;
  private etq jdField_a_of_type_Etq = new etq(this, this);
  private etr jdField_a_of_type_Etr;
  private final HashMap jdField_a_of_type_JavaUtilHashMap;
  private Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  public boolean a;
  private boolean b;
  private boolean jdField_c_of_type_Boolean;
  private String cI;
  private String cJ;
  private String cM;
  private String cN;
  public String cd;
  public String ce;
  public String cf;
  public String cg;
  public String ch;
  public String ci;
  public String cj;
  public String ck;
  private boolean jdField_d_of_type_Boolean;
  
  static
  {
    jdField_b_of_type_Int = 1;
  }
  
  public JumpAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.c = false;
    this.d = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private boolean A()
  {
    Object localObject = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("fopen_id"));
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("friend_label"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("add_msg"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    try
    {
      l1 = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_id")).longValue();
      if (l1 <= 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "gotoMakeFriend appid = " + l1);
        }
        return false;
      }
    }
    catch (Exception localException)
    {
      long l1;
      for (;;)
      {
        l1 = 0L;
      }
      AddFriendLogicActivity.b = (String)localObject;
      localObject = AddFriendLogicActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, 3, str1, "" + l1, 3016, 0, str2, str3, null, "", str4);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    }
    return true;
  }
  
  private boolean B()
  {
    Object localObject;
    String str2;
    QZoneHelper.UserInfo localUserInfo;
    String str1;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity))
    {
      localObject = (ChatActivity)this.jdField_a_of_type_AndroidContentContext;
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("page_id");
      if (str2 != null)
      {
        localUserInfo = QZoneHelper.UserInfo.a();
        localUserInfo.a = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localUserInfo.b = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
        localUserInfo.c = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("url");
        SessionInfo localSessionInfo = ((ChatActivity)localObject).a().a();
        if ((localSessionInfo != null) && (!TextUtils.isEmpty(localSessionInfo.a))) {
          ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(17)).b(localSessionInfo.a, true);
        }
        if (!str2.equalsIgnoreCase("11")) {
          break label163;
        }
        QZoneHelper.b((Activity)this.jdField_a_of_type_AndroidContentContext, localUserInfo, str1, "mqqChat.QzoneCard", -1);
      }
    }
    for (;;)
    {
      return false;
      label163:
      if (str2.equalsIgnoreCase("12"))
      {
        localObject = ((ChatActivity)localObject).a().a();
        str2 = b(str1);
        QZoneHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, localUserInfo, (String)localObject, str2, str1, "mqqChat.QzoneCard", -1);
      }
    }
  }
  
  private boolean C()
  {
    String str1;
    String str2;
    String str3;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("i");
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("n");
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
      if (!TextUtils.isEmpty(str1)) {}
    }
    else
    {
      return false;
    }
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.a = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localUserInfo.b = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    QZoneHelper.b((Activity)this.jdField_a_of_type_AndroidContentContext, localUserInfo, str1, str2, str3, "", -1);
    return true;
  }
  
  private boolean D()
  {
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("file_type");
    Object localObject10 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    Object localObject6 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    Object localObject8 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    c((String)this.jdField_a_of_type_JavaUtilHashMap.get("previewimagedata"));
    Object localObject11 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    Object localObject7 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
    String str7 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
    for (;;)
    {
      Object localObject3;
      try
      {
        i1 = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"))).intValue();
      }
      catch (Exception localException2)
      {
        try
        {
          l1 = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).longValue();
          localObject9 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          i2 = (int)l1;
          if (TextUtils.isEmpty((CharSequence)localObject7))
          {
            localObject1 = "";
            if (!TextUtils.isEmpty(this.cJ)) {
              continue;
            }
            localObject4 = "";
            QfavReport.a((AppRuntime)localObject9, "User_SdkShare", i2, 0, 0, 0, (String)localObject1, (String)localObject4);
            localObject9 = new Bundle();
            ((Bundle)localObject9).putString("title", (String)localObject6);
            ((Bundle)localObject9).putString("desc", (String)localObject8);
            ((Bundle)localObject9).putString("image_url", (String)localObject10);
            ((Bundle)localObject9).putString("detail_url", (String)localObject11);
            ((Bundle)localObject9).putLong("req_share_id", l1);
            ((Bundle)localObject9).putString("pkg_name", this.cJ);
            ((Bundle)localObject9).putString("image_url_remote", str3);
            ((Bundle)localObject9).putString("app_name", (String)localObject7);
            ((Bundle)localObject9).putString("open_id", str4);
            ((Bundle)localObject9).putString("share_uin", str5);
            ((Bundle)localObject9).putString("jfrom", str6);
            ((Bundle)localObject9).putString("share_qq_ext_str", str7);
            ((Bundle)localObject9).putInt("cflag", i1);
            ((Bundle)localObject9).putInt("forward_type", 11);
            i3 = 1;
          }
        }
        catch (Exception localException2)
        {
          try
          {
            int i1;
            long l1;
            i2 = Integer.valueOf(str2).intValue();
            ((Bundle)localObject9).putInt("req_type", i2);
            if (2 == i2)
            {
              ((Bundle)localObject9).putString("audio_url", str1);
              if ((TextUtils.isEmpty((CharSequence)localObject6)) && (TextUtils.isEmpty((CharSequence)localObject8)))
              {
                if (!TextUtils.isEmpty((CharSequence)localObject7)) {
                  ((Bundle)localObject9).putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131362754), new Object[] { localObject7 }));
                }
              }
              else
              {
                com.tencent.mobileqq.app.PhoneContactManagerImp.c = true;
                localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
                ((Intent)localObject1).putExtra("toUin", AppConstants.ac);
                ((Intent)localObject1).putExtra("uinType", 0);
                if (1 != i1) {
                  break label1677;
                }
                ((Intent)localObject1).putExtra("qqfav_extra_from_system_share", true);
                ((Intent)localObject1).putExtras((Bundle)localObject9);
                this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
                return true;
                localException1 = localException1;
                if (QLog.isColorLevel()) {
                  QLog.e("qqfav", 2, "gotoQfavShareMsg|parse extflags exp: extflag=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"));
                }
                i1 = 0;
                continue;
                localException2 = localException2;
                if (QLog.isColorLevel()) {
                  QLog.e("qqfav", 2, "gotoQfavShareMsg|parse appid exp: appid=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id"));
                }
                l1 = 0L;
                continue;
                Object localObject2 = localObject7;
                continue;
                localObject4 = this.cJ;
              }
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            Object localObject9;
            Object localObject4;
            int i3;
            int i2 = i3;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("qqfav", 2, "gotoQfavShareMsg|parse reqtype exp: reqType=" + str2);
            i2 = i3;
            continue;
            ((Bundle)localObject9).putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131362755));
            continue;
            if (6 == i2)
            {
              ((Bundle)localObject9).putInt("forward_type", -1);
              localObject3 = "";
              if (!TextUtils.isEmpty((CharSequence)localObject6)) {
                localObject3 = localObject6;
              }
              localObject4 = localObject3;
              if (!TextUtils.isEmpty((CharSequence)localObject8))
              {
                if (TextUtils.isEmpty((CharSequence)localObject3)) {
                  localObject4 = localObject8;
                }
              }
              else
              {
                ((Bundle)localObject9).putString("forward_text", (String)localObject4);
                ((Bundle)localObject9).putString("qqfav_extra_richmedia_title", (String)localObject6);
                ((Bundle)localObject9).putString("qqfav_extra_mixed_msg", (String)localObject8);
                continue;
              }
              localObject4 = (String)localObject3 + "\n" + (String)localObject8;
              continue;
            }
            if (5 == i2)
            {
              ((Bundle)localObject9).putBoolean("qqfav_extra_pic_share", true);
              ((Bundle)localObject9).putBoolean("qqfav_extra_only_pic", TextUtils.isEmpty((CharSequence)localObject8));
              ((Bundle)localObject9).putString("qqfav_extra_richmedia_title", (String)localObject6);
              ((Bundle)localObject9).putString("qqfav_extra_mixed_msg", (String)localObject8);
              ((Bundle)localObject9).putString("desc", "");
              localObject7 = localObject6;
              if (TextUtils.isEmpty((CharSequence)localObject6))
              {
                localObject7 = localObject6;
                if (!TextUtils.isEmpty((CharSequence)localObject8))
                {
                  localObject7 = ((String)localObject8).replace("\024", "");
                  ((Bundle)localObject9).putString("title", (String)localObject7);
                }
              }
              localObject4 = null;
              localObject3 = null;
              localObject11 = new ArrayList();
              Object localObject5;
              if (!TextUtils.isEmpty((CharSequence)localObject10))
              {
                localObject10 = ((String)localObject10).split(";");
                i2 = 0;
                localObject6 = null;
                localObject8 = localObject6;
                localObject4 = localObject3;
                if (i2 < localObject10.length)
                {
                  localObject8 = "";
                  try
                  {
                    localObject4 = URLDecoder.decode(localObject10[i2], "UTF-8");
                    if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                      if ((((String)localObject4).startsWith("/")) && (new File((String)localObject4).exists()))
                      {
                        ((ArrayList)localObject11).add(localObject4);
                        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                          continue;
                        }
                        i2 += 1;
                        localObject3 = localObject4;
                      }
                    }
                  }
                  catch (UnsupportedEncodingException localUnsupportedEncodingException)
                  {
                    localObject5 = localObject8;
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.e("qqfav", 2, "gotoQfavShareMsg|decode exp. imageUrls[i]=" + localObject10[i2]);
                    localObject5 = localObject8;
                    continue;
                    if (localObject5.startsWith("http"))
                    {
                      ((ArrayList)localObject11).add(localObject5);
                      if (TextUtils.isEmpty((CharSequence)localObject6))
                      {
                        localObject6 = localObject5;
                        localObject5 = localObject3;
                        continue;
                        if (QLog.isColorLevel()) {
                          QLog.e("qqfav", 2, "gotoQfavShareMsg|file path invalid. path=" + localObject5);
                        }
                      }
                    }
                    localObject5 = localObject3;
                    continue;
                  }
                }
              }
              else
              {
                localObject8 = null;
              }
              if (((ArrayList)localObject11).isEmpty())
              {
                QfavUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131362748, 1);
                if (QLog.isColorLevel()) {
                  QLog.e("qqfav", 2, "gotoQfavShareMsg|image type.no image path");
                }
                return false;
              }
              ((Bundle)localObject9).putString("image_url", localObject5);
              ((Bundle)localObject9).putString("image_url_remote", (String)localObject8);
              ((Bundle)localObject9).putStringArrayList("qqfav_extra_multi_pic_path_list", (ArrayList)localObject11);
              if (1 == ((ArrayList)localObject11).size())
              {
                if (TextUtils.isEmpty((CharSequence)localObject7))
                {
                  ((Bundle)localObject9).putInt("req_type", 5);
                  if ((!TextUtils.isEmpty(localObject5)) || (TextUtils.isEmpty((CharSequence)localObject8))) {
                    continue;
                  }
                  ((Bundle)localObject9).putString("image_url", (String)localObject8);
                  continue;
                }
                ((Bundle)localObject9).putInt("req_type", 1);
                continue;
              }
              if (TextUtils.isEmpty((CharSequence)localObject7)) {
                ((Bundle)localObject9).putString("title", ((ArrayList)localObject11).size() + this.jdField_a_of_type_AndroidContentContext.getString(2131362716));
              }
              ((Bundle)localObject9).putBoolean("qqfav_extra_multi_pic", true);
              ((Bundle)localObject9).putInt("req_type", 1);
              continue;
            }
            if (1 == i2)
            {
              if ((TextUtils.isEmpty((CharSequence)localObject6)) && (TextUtils.isEmpty((CharSequence)localObject8)))
              {
                if (!TextUtils.isEmpty((CharSequence)localObject7)) {
                  ((Bundle)localObject9).putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131362754), new Object[] { localObject7 }));
                }
              }
              else
              {
                if ((!TextUtils.isEmpty((CharSequence)localObject11)) || (!QLog.isColorLevel())) {
                  continue;
                }
                QLog.i("qqfav", 2, "gotoQfavShareMsg|link type. no detail url");
                continue;
              }
              ((Bundle)localObject9).putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131362755));
              continue;
            }
            QfavUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131362748, 1);
            if (QLog.isColorLevel()) {
              QLog.e("qqfav", 2, "gotoQfavShareMsg|unknown reqType. reqType=" + i2);
            }
            return false;
          }
        }
      }
      label1677:
      ((Intent)localObject3).putExtra("qqfav_extra_from_sdk_share", true);
    }
  }
  
  private boolean E()
  {
    return true;
  }
  
  private boolean F()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    localObject = new Intent("com.tencent.sc.intent.tabactivity");
    ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    return true;
  }
  
  private boolean G()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, JoinDiscussionActivity.class);
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sig");
    localIntent.putExtra("sig", str);
    if (TextUtils.isEmpty(str)) {
      localIntent.putExtra("innerSig", (String)this.jdField_a_of_type_JavaUtilHashMap.get("k"));
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean H()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AgentActivity.class);
    Bundle localBundle = new Bundle();
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("p");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("schemacallback");
    localBundle.putString("retPath", str1);
    localBundle.putString("schemacallback", str2);
    localIntent.putExtra("key_params", localBundle);
    localIntent.putExtra("key_action", "action_ptlogin_login");
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean I()
  {
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131364507, 0).a();
    return false;
  }
  
  private boolean J()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoIVRVideoChat");
    }
    if ((!CrmUtils.jdField_a_of_type_Boolean) && (QLog.isDevelopLevel())) {
      QLog.d("JumpAction", 4, "Don't support sharp");
    }
    return false;
  }
  
  private boolean K()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoIVRIMChat");
    }
    if ((!CrmUtils.jdField_a_of_type_Boolean) && (QLog.isDevelopLevel())) {
      QLog.d("JumpAction", 4, "Don't support sharp");
    }
    return false;
  }
  
  private boolean L()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoVideoChat");
    }
    return false;
  }
  
  private boolean M()
  {
    boolean bool2 = true;
    Intent localIntent;
    Object localObject5;
    int i1;
    Object localObject4;
    Object localObject6;
    Object localObject7;
    int i2;
    for (;;)
    {
      try
      {
        localIntent = new Intent("android.intent.action.MAIN");
        a(localIntent);
        Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap.entrySet();
        localObject5 = "";
        if (!TextUtils.isEmpty(a("from_leba")))
        {
          localIntent.putExtra("plugin_start_time", System.currentTimeMillis());
          localIntent.putExtra("is_from_leba", true);
          localIntent.putExtra("has_red_dot", this.d);
        }
        Iterator localIterator = ((Set)localObject1).iterator();
        i1 = 0;
        localObject4 = null;
        localObject1 = null;
        if (localIterator.hasNext())
        {
          localObject6 = (Map.Entry)localIterator.next();
          localObject7 = (String)((Map.Entry)localObject6).getKey();
          localObject6 = (String)((Map.Entry)localObject6).getValue();
          if ((localObject7 == null) || (localObject6 == null)) {
            continue;
          }
          if ("pkg".equals(localObject7))
          {
            localObject1 = localObject5;
            localObject5 = localObject6;
            break label1385;
          }
          if ("cmp".equals(localObject7))
          {
            localObject7 = localObject1;
            localObject1 = localObject5;
            localObject4 = localObject6;
            localObject5 = localObject7;
            break label1385;
          }
          if ("plg_account".equals(localObject7))
          {
            if (!"1".equals(localObject6)) {
              break label1400;
            }
            localIntent.putExtra("account", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
            localObject6 = localObject1;
            localObject1 = localObject5;
            localObject5 = localObject6;
            break label1385;
          }
          if ("plg_nickname".equals(localObject7))
          {
            if (!"1".equals(localObject6)) {
              break label1400;
            }
            localObject7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
            localObject6 = localObject7;
            if (StringUtil.b((String)localObject7)) {
              localObject6 = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
            }
            localIntent.putExtra("nickname", (String)localObject6);
            localObject6 = localObject1;
            localObject1 = localObject5;
            localObject5 = localObject6;
            break label1385;
          }
          if ("plg_sid".equals(localObject7))
          {
            if (!"1".equals(localObject6)) {
              break label1400;
            }
            localIntent.putExtra("sid", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
            localObject6 = localObject1;
            localObject1 = localObject5;
            localObject5 = localObject6;
            break label1385;
          }
          if ("plg_vkey".equals(localObject7))
          {
            if (!"1".equals(localObject6)) {
              break label1400;
            }
            localIntent.putExtra("vkey", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d());
            localObject6 = localObject1;
            localObject1 = localObject5;
            localObject5 = localObject6;
            break label1385;
          }
          if ("plg_launchtime".equals(localObject7))
          {
            if (!"1".equals(localObject6)) {
              break label1400;
            }
            localIntent.putExtra("launch_time", System.currentTimeMillis());
            localObject6 = localObject1;
            localObject1 = localObject5;
            localObject5 = localObject6;
            break label1385;
          }
          if ("plg_newflag".equals(localObject7))
          {
            if (!"1".equals(localObject6)) {
              break label1400;
            }
            localIntent.putExtra("newflag", this.c);
            if (!QLog.isColorLevel()) {
              break label1400;
            }
            QLog.d("Jumpaction", 2, "handleAppForward.newflag=" + this.c);
            localObject6 = localObject1;
            localObject1 = localObject5;
            localObject5 = localObject6;
            break label1385;
          }
          if ("plg_type".equals(localObject7))
          {
            if (!"1".equals(localObject6)) {
              break label1400;
            }
            localObject6 = localObject5;
            i1 = 1;
            localObject5 = localObject1;
            localObject1 = localObject6;
            break label1385;
          }
          if ("apk".equals(localObject7))
          {
            localObject5 = localObject1;
            localObject1 = localObject6;
            break label1385;
          }
          localIntent.putExtra((String)localObject7, (String)localObject6);
          break label1400;
        }
        if ((localObject1 == null) || (localObject4 == null) || ("".equals(localObject1)) || ("".equals(localObject4))) {
          break label1415;
        }
        if ((this.jdField_a_of_type_Boolean) && (JumpFilterHelper.a().a(this.jdField_a_of_type_AndroidContentContext, (String)localObject1, (String)localObject4))) {
          return false;
        }
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label1380;
        }
        localObject6 = jdField_a_of_type_ArrayOfJavaLangString;
        int i3 = localObject6.length;
        i2 = 0;
        if (i2 >= i3) {
          break label1380;
        }
        if (((String)localObject1).equals(localObject6[i2]))
        {
          i2 = 1;
          label757:
          if (i2 == 0)
          {
            localIntent.putExtra("vkey", (String)null);
            localIntent.putExtra("sid", (String)null);
            localIntent.putExtra("nickname", (String)null);
            localIntent.putExtra("account", (String)null);
          }
          if (((String)localObject4).startsWith("com.qzone")) {
            localIntent.putExtra("refer", "mqqActiveTab");
          }
          if (i1 != 0) {
            break label1338;
          }
          if (!((String)localObject4).endsWith("OpenTroopInfoActivity")) {
            break;
          }
          TroopProxyActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, null, 0);
          return true;
        }
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        localActivityNotFoundException.printStackTrace();
        return false;
      }
      i2 += 1;
    }
    if (((String)localObject4).endsWith("NearbyTroopsActivity"))
    {
      localObject4 = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyTroopsActivity.class);
      ((Intent)localObject4).putExtra("from", 15);
      ((Intent)localObject4).putExtra("mode", 0);
      localObject5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tab_index");
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(886);
      if (localObject2 == null) {
        break label1374;
      }
      localObject2 = ((ResourcePluginInfo)localObject2).strResName;
      label973:
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((Intent)localObject4).putExtra("config_res_plugin_item_name", (String)localObject2);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject5)) {
        ((Intent)localObject4).putExtra("TAB_INDEX", Integer.valueOf((String)localObject5).intValue());
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject4);
      if (!this.d) {
        break label1421;
      }
    }
    label1338:
    label1374:
    Object localObject3;
    label1415:
    label1421:
    for (Object localObject2 = "0";; localObject3 = "1")
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_nearby", "", "nearbygrp_entry", "Clk_nearbygrp", 0, 0, "", "", "", (String)localObject2);
      return true;
      boolean bool1 = ((String)localObject4).endsWith("PoiMapActivity");
      if (bool1) {
        try
        {
          ((ChatActivity)this.jdField_a_of_type_AndroidContentContext).a().Z();
          localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          localObject7 = localIntent.getStringExtra("lat");
          localObject6 = localIntent.getStringExtra("lon");
          localObject5 = localIntent.getStringExtra("loc");
          if ((localObject7 != null) && (localObject6 != null))
          {
            localObject7 = Double.valueOf((String)localObject7);
            localObject6 = Double.valueOf((String)localObject6);
            localIntent.putExtra("url", "http://maps.google.com/maps?q=" + localObject7 + "," + localObject6 + "&iwloc=A&hl=zh-CN (" + (String)localObject5 + ")");
          }
          localIntent.setClassName((String)localObject2, (String)localObject4);
          ((ChatActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 18);
          return true;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return true;
        }
      }
      if (((String)localObject4).endsWith("NearbyTroopsActivity")) {
        localIntent.putExtra("from", 15);
      }
      localIntent.setClassName(localException, (String)localObject4);
      localIntent.addCategory("android.intent.category.LAUNCHER");
      localIntent.addFlags(268435456);
      localIntent.putExtra("source_scheme", this.cd);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
      bool1 = bool2;
      if (i1 == 1)
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty((CharSequence)localObject5))
        {
          bool1 = a(localIntent, (String)localObject4, (String)localObject5);
          return bool1;
          localObject3 = null;
          break label973;
          label1380:
          i2 = 0;
          break label757;
          for (;;)
          {
            label1385:
            localObject6 = localObject5;
            localObject5 = localObject3;
            localObject3 = localObject6;
            break;
            label1400:
            localObject6 = localObject3;
            localObject3 = localObject5;
            localObject5 = localObject6;
          }
          bool1 = false;
        }
      }
      return bool1;
    }
  }
  
  private boolean N()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492C", "0X800492C", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.e("qqdataline", 2, "shareFromMigSdk|report send from sdk:0X800492C.");
    }
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("file_type");
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    Object localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    Object localObject4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    c((String)this.jdField_a_of_type_JavaUtilHashMap.get("previewimagedata"));
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    localObject1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    Object localObject5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    Object localObject6 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
    String str7 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
    int i2 = 0;
    try
    {
      i1 = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"))).intValue();
      l2 = 0L;
    }
    catch (Exception localException2)
    {
      try
      {
        l1 = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).longValue();
        localBundle = new Bundle();
        localBundle.putString("title", (String)localObject2);
        localBundle.putString("desc", (String)localObject4);
        localBundle.putString("image_url", str1);
        localBundle.putString("detail_url", str2);
        localBundle.putLong("req_share_id", l1);
        localBundle.putString("pkg_name", this.cJ);
        localBundle.putString("image_url_remote", str3);
        localBundle.putString("app_name", (String)localObject1);
        localBundle.putString("open_id", str4);
        localBundle.putString("share_uin", str5);
        localBundle.putString("jfrom", str6);
        localBundle.putString("share_qq_ext_str", str7);
        localBundle.putInt("cflag", i1);
        localBundle.putInt("forward_type", 11);
        i2 = 1;
      }
      catch (Exception localException2)
      {
        label1178:
        label1188:
        try
        {
          long l2;
          do
          {
            for (;;)
            {
              Bundle localBundle;
              i1 = Integer.valueOf((String)localObject6).intValue();
              localBundle.putInt("req_type", i1);
              if (2 != i1) {
                break label812;
              }
              localBundle.putString("audio_url", (String)localObject5);
              if ((TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.isEmpty((CharSequence)localObject4)))
              {
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  break;
                }
                localBundle.putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131362754), new Object[] { localObject1 }));
              }
              com.tencent.mobileqq.app.PhoneContactManagerImp.c = true;
              localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, LiteActivity.class);
              localBundle.putBoolean("MigSdkShareNotDone", true);
              ((Intent)localObject1).putExtras(localBundle);
              ((Intent)localObject1).addFlags(268435456);
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
              return true;
              localException1 = localException1;
              i1 = i2;
              if (QLog.isColorLevel())
              {
                QLog.e("qqfav", 2, "gotoQfavShareMsg|parse extflags exp: extflag=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"));
                i1 = i2;
              }
            }
            localException2 = localException2;
            l1 = l2;
          } while (!QLog.isColorLevel());
          QLog.e("qqfav", 2, "gotoQfavShareMsg|parse appid exp: appid=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id"));
          long l1 = l2;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          int i1;
          label812:
          label890:
          do
          {
            for (;;)
            {
              i1 = i2;
              if (QLog.isColorLevel())
              {
                QLog.e("qqfav", 2, "gotoQfavShareMsg|parse reqtype exp: reqType=" + (String)localObject6);
                i1 = i2;
                continue;
                localException2.putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131362755));
                continue;
                if (6 == i1)
                {
                  localObject1 = "";
                  if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                    localObject1 = localObject2;
                  }
                  localObject2 = localObject1;
                  if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                      break label890;
                    }
                  }
                  for (localObject2 = localObject4;; localObject2 = (String)localObject1 + "\n" + (String)localObject4)
                  {
                    localException2.putString("forward_text", (String)localObject2);
                    localException2.putInt("forward_type", -1);
                    localException2.putBoolean("isFromShare", true);
                    break;
                  }
                }
                if (5 != i1) {
                  break;
                }
                localObject2 = null;
                localObject1 = null;
                localObject6 = new ArrayList();
                Object localObject3;
                if (!TextUtils.isEmpty(str1))
                {
                  String[] arrayOfString = str1.split(";");
                  i1 = 0;
                  localObject4 = null;
                  for (;;)
                  {
                    localObject5 = localObject4;
                    localObject2 = localObject1;
                    if (i1 >= arrayOfString.length) {
                      break label1188;
                    }
                    localObject5 = "";
                    try
                    {
                      localObject2 = URLDecoder.decode(arrayOfString[i1], "UTF-8");
                      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                        if ((((String)localObject2).startsWith("/")) && (new File((String)localObject2).exists()))
                        {
                          ((ArrayList)localObject6).add(localObject2);
                          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                            break label1178;
                          }
                          i1 += 1;
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
                          QLog.e("qqfav", 2, "gotoQfavShareMsg|decode exp. imageUrls[i]=" + arrayOfString[i1]);
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
                localObject5 = null;
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
                  if (FileManagerUtil.a((String)localObject1) == 0)
                  {
                    localException2.putInt("req_type", 5);
                  }
                  else
                  {
                    localException2.putString("forward_text", "已选择" + FileManagerUtil.a((String)localObject1) + "。");
                    localException2.putBoolean("qdshare_file", true);
                    localException2.putBoolean("isFromShare", true);
                    localException2.putInt("forward_type", -1);
                    localException2.putInt("req_type", 6);
                  }
                }
                else if (FileManagerUtil.a(localObject3) == 0)
                {
                  localException2.putString("title", ((ArrayList)localObject6).size() + this.jdField_a_of_type_AndroidContentContext.getString(2131362716));
                  localException2.putString("qqfav_extra_multi_pic_path_list", str1);
                  localException2.putBoolean("qqfav_extra_multi_pic", true);
                  localException2.putInt("req_type", 1);
                }
                else
                {
                  localException2.putString("forward_text", "已选择" + FileManagerUtil.a(localObject3) + "等" + ((ArrayList)localObject6).size() + "个文件。");
                  localException2.putString("qqfav_extra_multi_pic_path_list", str1);
                  localException2.putBoolean("qdshare_file", true);
                  localException2.putBoolean("isFromShare", true);
                  localException2.putInt("forward_type", -1);
                  localException2.putInt("req_type", 6);
                }
              }
            }
          } while (1 == i1);
        }
      }
    }
    return false;
  }
  
  private boolean O()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Jumpaction", 2, " source:" + this.cd + "  serverName:" + this.ce + "  hostName:" + this.cf);
    }
    return true;
  }
  
  private String a(byte[] paramArrayOfByte, Cryptor paramCryptor)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("plg_nld=1");
    localStringBuffer.append("&");
    localStringBuffer.append("DEVICEINFO=");
    paramArrayOfByte = "2|" + HexUtil.bytes2HexStr(paramArrayOfByte);
    localStringBuffer.append(HexUtil.bytes2HexStr(paramCryptor.encrypt((paramArrayOfByte + "|" + b()).getBytes(), "4eY#X@~g.+U)2%$<".getBytes())));
    return localStringBuffer.toString();
  }
  
  private void a(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.setData(Uri.parse("midas://open_modify_status?status=" + paramInt));
    if (this.jdField_a_of_type_AndroidContentContext.getPackageManager().queryIntentActivities(localIntent, 0).size() > 0) {
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
    ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).finish();
  }
  
  private void a(Intent paramIntent)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(this.cN)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "wrapper Intent failed intent is null or redTouchInfo is Empty");
      }
      return;
    }
    paramIntent.putExtra("redTouch", this.cN);
  }
  
  private void a(Intent paramIntent, String paramString)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "wpaParamsParse---Start");
    }
    int i1;
    if (this.jdField_a_of_type_JavaUtilHashMap.get("paramencrypted_type") == null)
    {
      i1 = 0;
      paramIntent.putExtra("from3rdApp", true);
      if (i1 != 1) {
        break label241;
      }
    }
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "params must be decrypted");
        }
        paramString = Base64Util.a(new Cryptor().decrypt(HexUtil.hexStr2Bytes(paramString), "Hf7K(s*js12LiskW".getBytes()), 0);
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
          paramString = ChatActivityUtils.a(paramString);
          paramIntent.putExtra("stuctmsg_bytes", paramString);
          if ((paramString != null) && (i1 == 1)) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"), "0X8004B50", "0X8004B50", 0, 0, "", "", "", "");
          }
        }
        return;
      }
      catch (JSONException paramIntent)
      {
        label241:
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.e("JumpAction", 4, "wpaParamsParse---JSONException");
        return;
      }
      i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("paramencrypted_type"));
      break;
      paramIntent.putExtra("fromSencondhandCommunity", true);
      paramString = new JSONObject(paramString);
      paramIntent.putExtra("gid", paramString.getString("gid"));
      continue;
      label293:
      paramString = null;
    }
  }
  
  private boolean a(Intent paramIntent, String paramString1, String paramString2)
  {
    paramIntent.putExtra("pluginsdk_selfuin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    paramIntent.putExtra("load_from_third_app", true);
    paramIntent.putExtra("param_plugin_gesturelock", true);
    paramIntent.putExtra("current_qr_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    paramIntent.putExtra("clsUploader", "com.tencent.mobileqq.statistics.PluginStatisticsCollector");
    a(paramIntent);
    paramIntent.setClassName(this.jdField_a_of_type_AndroidContentContext, paramString1);
    try
    {
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramIntent);
      return true;
    }
    catch (Exception paramIntent) {}
    return true;
  }
  
  private String b()
  {
    String str1 = Build.VERSION.RELEASE;
    String str2 = Build.MODEL;
    Object localObject1 = (TelephonyManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("phone");
    String str3 = ((TelephonyManager)localObject1).getDeviceId();
    localObject1 = ((TelephonyManager)localObject1).getSubscriberId();
    Object localObject2 = ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindowManager().getDefaultDisplay();
    int i1 = ((Display)localObject2).getHeight();
    int i2 = ((Display)localObject2).getWidth();
    localObject2 = i2 + "*" + i1;
    i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    return str1 + "|" + str2 + "|" + str3 + "|" + (String)localObject2 + "|" + (String)localObject1 + "|" + i1 + "|";
  }
  
  private String b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("i="))) {
      return null;
    }
    int i3 = paramString.indexOf("i=");
    int i2 = paramString.substring(i3).indexOf('&');
    int i1 = i2;
    if (i2 <= 0) {
      i1 = paramString.length() - i3;
    }
    return paramString.substring("i=".length() + i3, i1 + i3);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131364501, 2131364500, 2131364502, 2131364503, new eto(this), new etp(this));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private String c()
  {
    return "mqqapi://" + this.ce + "/" + this.cf + "?src_type=" + this.ci;
  }
  
  private String c(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || (paramString.length() == 0)) {
      return null;
    }
    try
    {
      paramString = new String(Base64Util.a(paramString, 0));
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private void c()
  {
    Object localObject;
    String str1;
    label54:
    String str2;
    label81:
    String str3;
    label109:
    String str4;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("packageName"))
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("packageName");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("signareMode")) {
        break label331;
      }
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("signareMode");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("appid")) {
        break label338;
      }
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("timeStamp")) {
        break label345;
      }
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("timeStamp");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("resetWordMode")) {
        break label353;
      }
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("resetWordMode");
      label137:
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("offerid")) {
        break label361;
      }
    }
    label331:
    label338:
    label345:
    label353:
    label361:
    for (String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("offerid");; str5 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "packageName : " + (String)localObject + " signatureMode :" + str1 + " appid : " + str2 + " timestamp : " + str3 + " resetWordMode : " + str4 + " offerId : " + str5);
      }
      localObject = new ReqCheckChangePwdAuth((String)localObject, str1, str2, str3, str4, str5);
      ((QWalletAuthHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(36)).a((ReqCheckChangePwdAuth)localObject);
      this.jdField_a_of_type_Etr = new etr(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver = new QWalletAuthObserver(this.jdField_a_of_type_Etr);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver);
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
  
  private void d()
  {
    com.tencent.mobileqq.app.PhoneContactManagerImp.c = true;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("userId", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      localJSONObject.put("viewTag", "pswManage");
      if (!PayBridgeActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, localJSONObject.toString(), 5, "")) {}
      for (int i1 = 1;; i1 = 0)
      {
        a(i1);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      a(1);
    }
  }
  
  private boolean d()
  {
    return true;
  }
  
  private void e()
  {
    try
    {
      if ("head".equals(this.cf))
      {
        if (this.jdField_a_of_type_Etq == null) {
          this.jdField_a_of_type_Etq = new etq(this, this);
        }
        if (this.jdField_a_of_type_JavaUtilHashtable == null) {
          this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Etq);
        long l1 = System.currentTimeMillis();
        String[] arrayOfString = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin")).split(",");
        FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
        int i1 = 0;
        while (i1 < arrayOfString.length)
        {
          String str = arrayOfString[i1];
          localFriendListHandler.b(str);
          this.jdField_a_of_type_JavaUtilHashtable.put(str, Long.valueOf(l1));
          i1 += 1;
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
  
  private void e(String paramString)
  {
    if ("app".equals(this.ci)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_app", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if ("web".equals(this.ci))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_website", 0, 0, "", "", "", "");
        return;
      }
    } while (!"scan".equals(this.ci));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_scan", 0, 0, "", "", "", "");
  }
  
  private boolean e()
  {
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("uin")) {}
    for (String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"); !str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()); str = "")
    {
      b();
      return false;
    }
    c();
    return false;
  }
  
  private boolean f()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, LiteActivity.class);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("leftBackText", "消息");
    ((Bundle)localObject).putBoolean("isBack2Root", true);
    localIntent.addFlags(268435456);
    localIntent.addFlags(67108864);
    localIntent.putExtras((Bundle)localObject);
    localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("txt");
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      localIntent.putExtra("JumpAction.Text", c((String)localObject));
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean g()
  {
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
      return false;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131364506, 0).a();
    return true;
  }
  
  private boolean h()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("attach_content"));
    Object localObject5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("chat_type");
    Object localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sigt");
    Object localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sig");
    Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("params");
    if ((localObject2 != null) && (QLog.isDevelopLevel())) {
      QLog.d("JumpAction", 4, (String)localObject2 + "");
    }
    Object localObject1 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    int i1;
    if ("c2c".equals(localObject5))
    {
      if ((str1 == null) || (str1.length() < 5)) {
        return false;
      }
      if (((FriendManager)localObject1).b(str1))
      {
        i1 = 0;
        localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
      }
    }
    for (;;)
    {
      localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
      ((Intent)localObject3).putExtra("uin", str1);
      ((Intent)localObject3).putExtra("uintype", i1);
      if (localObject1 != null) {
        ((Intent)localObject3).putExtra("uinname", (String)localObject1);
      }
      if (str2 != null) {
        ((Intent)localObject3).putExtra("input_text", str2);
      }
      if ((localObject2 == null) || ("".equals(localObject2))) {
        break label1374;
      }
      if ((str1 != null) && (!"".equals(str1))) {
        break label1110;
      }
      return false;
      return false;
      if ("discuss".equals(localObject5))
      {
        if ((str1 == null) || (str1.length() < 6)) {
          return false;
        }
        i1 = 3000;
        localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("discuss_info");
      }
      else if ("group".equals(localObject5))
      {
        if ((str1 == null) || (str1.length() < 6)) {
          return false;
        }
        localObject1 = ((FriendManager)localObject1).a(str1);
        if (localObject1 != null)
        {
          i1 = 1;
          localObject1 = ((TroopInfo)localObject1).troopname;
        }
        else
        {
          return false;
        }
      }
      else
      {
        if ("opengroup".equals(localObject5))
        {
          if ((str1 == null) || (str1.length() < 6)) {
            return false;
          }
          localObject1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("group_info"));
          for (;;)
          {
            try
            {
              localObject4 = new JSONObject((String)localObject1);
              localObject1 = ((JSONObject)localObject4).optString("troopName");
              str2 = ((JSONObject)localObject4).optString("location");
              localObject2 = ((JSONObject)localObject4).optString("intro");
              localObject3 = ((JSONObject)localObject4).optString("groupCode");
              i1 = 0;
              i3 = 0;
            }
            catch (JSONException localJSONException)
            {
              int i3;
              int i2;
              int i4;
              String str3;
              continue;
            }
            try
            {
              i2 = Integer.parseInt(((JSONObject)localObject4).optString("memberCnt"));
              i1 = i2;
              i4 = Integer.parseInt(((JSONObject)localObject4).optString("distance"));
              i1 = i4;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              i2 = i1;
              i1 = i3;
            }
          }
          localObject4 = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
          new NearbyOpenTroop(str1, (String)localObject1, (Activity)localObject4, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((BaseActivity)localObject4).getTitleBarHeight()).a(true, new GroupInfo(Long.parseLong(str1), (String)localObject1, str2, i2, (String)localObject2, 0, false, i1, i2, 0L, 0, 0, 0L, 0L, 0L, false, 0L), (String)localObject3);
          return true;
        }
        if (!"robot".equals(localObject5)) {
          break;
        }
        if ((str1 == null) || ("".equals(str1))) {
          return false;
        }
        localObject1 = ((FriendManager)localObject1).a(str1);
        i1 = 1001;
      }
    }
    if ("wpa".equals(localObject5))
    {
      if (((FriendManager)localObject1).b(str1))
      {
        localObject1 = ((FriendManager)localObject1).a(str1);
        i1 = 0;
      }
      for (;;)
      {
        e(str1);
        break;
        i1 = 1005;
        localObject1 = null;
      }
    }
    if ("crm".equals(localObject5))
    {
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
      if (((FriendManager)localObject1).b(str1))
      {
        localObject1 = ((FriendManager)localObject1).a(str1);
        i1 = 0;
      }
      for (;;)
      {
        if (BmqqSegmentUtil.b(this.jdField_a_of_type_AndroidContentContext, str1))
        {
          ((Intent)localObject2).putExtra("isBack2Root", true);
          if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey("kfnick")) && (!TextUtils.isEmpty(str1))) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str1, (String)this.jdField_a_of_type_JavaUtilHashMap.get("kfnick"));
          }
          localObject5 = new HashMap();
          ((HashMap)localObject5).put("a_actionData", this.jdField_a_of_type_JavaUtilHashMap.toString());
          ((HashMap)localObject5).put("uin", str1);
          ((HashMap)localObject5).put("uin_type", String.valueOf(i1));
          StatisticCollector.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSwitchToCrmExt", true, -1L, -1L, (HashMap)localObject5, "", true);
        }
        ((Intent)localObject2).putExtra("uin", str1);
        ((Intent)localObject2).putExtra("uintype", i1);
        if (localObject1 != null) {
          ((Intent)localObject2).putExtra("uinname", (String)localObject1);
        }
        if (str2 != null) {
          ((Intent)localObject2).putExtra("input_text", str2);
        }
        if ((localNumberFormatException != null) && (str1 != null))
        {
          localObject1 = HexUtil.hexStr2Bytes(localNumberFormatException);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(str1, (byte[])localObject1);
        }
        if (localObject3 != null) {
          ((Intent)localObject2).putExtra("sigt", HexUtil.hexStr2Bytes((String)localObject3));
        }
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "", "", "Bqq_Crm", "Bqq_wpaaio_create", 0, 0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), str1, "", "");
        return true;
        if (BmqqSegmentUtil.b(this.jdField_a_of_type_AndroidContentContext, str1))
        {
          localObject1 = null;
          i1 = 1025;
        }
        else
        {
          ((Intent)localObject2).putExtra("chat_subType", 1);
          localObject1 = null;
          i1 = 1024;
        }
      }
    }
    return false;
    label1110:
    localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_type");
    str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("thirdAppDisplayName"));
    str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
    if ((localObject1 != null) && (!"".equals(localObject1))) {
      ((Intent)localObject3).putExtra("callback_type", (String)localObject1);
    }
    if ((str2 != null) && (!"".equals(str2))) {
      ((Intent)localObject3).putExtra("thirdAppDisplayName", str2);
    }
    if ((str3 != null) && (!"".equals(str3))) {
      ((Intent)localObject3).putExtra("appid", str3);
    }
    a((Intent)localObject3, (String)localObject2);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str1, "0X8004B4B", "0X8004B4B", 0, 0, "", "", "", "");
    if ("webview".equals(this.cI))
    {
      ((Intent)localObject3).putExtra("from", this.cI);
      if (jdField_b_of_type_Int > 3)
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, "对话框打开数已达到上限", 1).a();
        return true;
      }
      jdField_b_of_type_Int += 1;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str1, "0X8004B5A", "0X8004B5A", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      label1374:
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
      return true;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str1, "0X8004B58", "0X8004B58", 0, 0, "", "", "", "");
    }
  }
  
  private boolean i()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((str == null) || (str.length() < 6)) {
      return false;
    }
    Object localObject = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (localObject == null) {
      return false;
    }
    localObject = ((FriendManager)localObject).a(str);
    if (localObject != null)
    {
      localObject = ((TroopInfo)localObject).troopname;
      Intent localIntent = new Intent();
      localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
      localIntent.putExtra("uin", str);
      localIntent.putExtra("uintype", 1);
      if (localObject != null) {
        localIntent.putExtra("uinname", (String)localObject);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
    }
    return t();
  }
  
  private boolean j()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("lon");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("lat");
    if ((str1 != null) && (str2 != null)) {}
    for (;;)
    {
      try
      {
        i2 = Integer.parseInt(str1.trim());
        int i1 = Integer.parseInt(str2.trim());
        str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
        if (str1 == null)
        {
          this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyActivity.class).putExtra("lat", i1).putExtra("lon", i2).putExtra("filter", 0));
          return true;
        }
        this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyActivity.class).putExtra("lat", i1).putExtra("lon", i2).putExtra("title", str1).putExtra("filter", 0));
        continue;
        i1 = 0;
      }
      catch (Exception localException)
      {
        return false;
      }
      int i2 = 0;
    }
  }
  
  private boolean k()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("lon");
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("lat");
    if ((localObject != null) && (str != null)) {}
    for (;;)
    {
      try
      {
        i2 = Integer.parseInt(((String)localObject).trim());
        i2 = i1;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        try
        {
          i1 = Integer.parseInt(str.trim());
          localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyTroopsActivity.class);
          ((Intent)localObject).putExtra("lat", i1);
          ((Intent)localObject).putExtra("lon", i2);
          ((Intent)localObject).putExtra("from", 4);
          ((Intent)localObject).putExtra("mode", 0);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
          return true;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          for (;;)
          {
            i1 = i2;
          }
        }
        localNumberFormatException1 = localNumberFormatException1;
        i1 = 0;
      }
      int i1 = 0;
      continue;
      i1 = 0;
      int i2 = 0;
    }
  }
  
  private boolean l()
  {
    if ((String)this.jdField_a_of_type_JavaUtilHashMap.get("back_title") == null) {}
    TroopCreateLogic localTroopCreateLogic = (TroopCreateLogic)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(29);
    if (localTroopCreateLogic != null) {
      localTroopCreateLogic.a((Activity)this.jdField_a_of_type_AndroidContentContext, 0);
    }
    return true;
  }
  
  private boolean m()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, TroopActivity.class);
    localIntent.putExtra("fromH5", true);
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("initgrouptype");
    if (("1".equals(str)) || ("0".equals(str)) || ("2".equals(str))) {
      localIntent.putExtra("troopType", str);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
      localIntent.putExtra("troopType", "DEFAULT");
    }
  }
  
  private boolean n()
  {
    EmojiHomeUiPlugin.openEmojiHomePage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 7, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
    return true;
  }
  
  private boolean o()
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.putExtra("account", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    localIntent.putExtra("nickname", (String)localObject);
    localObject = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      if ((!str.equals("version")) && (!str.equals("src_type"))) {
        localIntent.putExtra(str, (String)this.jdField_a_of_type_JavaUtilHashMap.get(str));
      }
    }
    return a(localIntent, "com.qqreader.QRBridgeActivity", "qqreaderplugin.apk");
  }
  
  /* Error */
  private boolean p()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 603	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4: ldc_w 342
    //   7: invokevirtual 610	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 569	java/lang/String
    //   13: astore 6
    //   15: aload_0
    //   16: getfield 603	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   19: ldc_w 345
    //   22: invokevirtual 610	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast 569	java/lang/String
    //   28: astore 7
    //   30: aload 6
    //   32: ifnull +139 -> 171
    //   35: aload 7
    //   37: ifnull +134 -> 171
    //   40: aload 6
    //   42: invokevirtual 1727	java/lang/String:trim	()Ljava/lang/String;
    //   45: invokestatic 1376	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   48: i2d
    //   49: ldc2_w 1753
    //   52: ddiv
    //   53: dstore_1
    //   54: aload 7
    //   56: invokevirtual 1727	java/lang/String:trim	()Ljava/lang/String;
    //   59: invokestatic 1376	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   62: istore 5
    //   64: iload 5
    //   66: i2d
    //   67: ldc2_w 1753
    //   70: ddiv
    //   71: dstore_3
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 603	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   77: ldc 135
    //   79: invokevirtual 610	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   82: checkcast 569	java/lang/String
    //   85: invokespecial 613	com/tencent/mobileqq/utils/JumpAction:c	(Ljava/lang/String;)Ljava/lang/String;
    //   88: pop
    //   89: new 630	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 631	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 1166
    //   99: invokevirtual 637	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: dload_3
    //   103: invokevirtual 1757	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   106: ldc_w 1171
    //   109: invokevirtual 637	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: dload_1
    //   113: invokevirtual 1757	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   116: ldc_w 1759
    //   119: invokevirtual 637	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 644	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore 6
    //   127: new 802	android/content/Intent
    //   130: dup
    //   131: ldc_w 1290
    //   134: aload 6
    //   136: invokestatic 1303	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   139: invokespecial 1762	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   142: astore 7
    //   144: aload 7
    //   146: ldc_w 1764
    //   149: ldc_w 1766
    //   152: invokevirtual 1178	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   155: pop
    //   156: aload_0
    //   157: getfield 596	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   160: aload 7
    //   162: invokevirtual 664	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   165: iconst_1
    //   166: ireturn
    //   167: astore 6
    //   169: iconst_0
    //   170: ireturn
    //   171: iconst_0
    //   172: ireturn
    //   173: astore 7
    //   175: aload_0
    //   176: getfield 596	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   179: new 802	android/content/Intent
    //   182: dup
    //   183: ldc_w 1290
    //   186: aload 6
    //   188: invokestatic 1303	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   191: invokespecial 1762	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   194: invokevirtual 664	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   197: goto -32 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	JumpAction
    //   53	60	1	d1	double
    //   71	32	3	d2	double
    //   62	3	5	i1	int
    //   13	122	6	str	String
    //   167	20	6	localException	Exception
    //   28	133	7	localObject	Object
    //   173	1	7	localActivityNotFoundException	ActivityNotFoundException
    // Exception table:
    //   from	to	target	type
    //   40	64	167	java/lang/Exception
    //   156	165	173	android/content/ActivityNotFoundException
  }
  
  private boolean q()
  {
    if ("webview".equals(this.cI))
    {
      c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
      this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).putExtra("action", "select_location").putExtra("doCallBack", true).putExtra("src_type", this.ci).putExtra("callback_type", this.cj).putExtra("callback_name", this.ck));
    }
    return true;
  }
  
  private boolean r()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("card_type");
    if ((str != null) && ("group".equals(str))) {
      return t();
    }
    return s();
  }
  
  private boolean s()
  {
    boolean bool = false;
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("wpa");
    if ((localObject == null) || ("".equals(localObject)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(localObject))) {
      localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    }
    for (;;)
    {
      ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject);
      bool = true;
      do
      {
        return bool;
      } while (((String)localObject).length() < 5);
      Friends localFriends = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c((String)localObject);
      if ((localFriends != null) && (localFriends.isFriend()))
      {
        localObject = new ProfileActivity.AllInOne((String)localObject, 1);
        ((ProfileActivity.AllInOne)localObject).h = localFriends.name;
        ((ProfileActivity.AllInOne)localObject).i = localFriends.remark;
      }
      else
      {
        if (this.jdField_b_of_type_Boolean)
        {
          localObject = new ProfileActivity.AllInOne((String)localObject, 3);
          if ("1".equals(str)) {}
          for (int i1 = 1;; i1 = 0)
          {
            ((ProfileActivity.AllInOne)localObject).d = i1;
            break;
          }
        }
        localObject = new ProfileActivity.AllInOne((String)localObject, 19);
      }
    }
  }
  
  private boolean t()
  {
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("wSourceSubID");
    if ((str2 == null) || ("".equals(str2)) || (str2.length() < 5)) {
      return false;
    }
    Object localObject1;
    if ("QRJumpActivity".equalsIgnoreCase((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from"))) {
      localObject1 = TroopInfoActivity.a(str2, 14);
    }
    for (;;)
    {
      if ("d2g".equals(this.jdField_a_of_type_JavaUtilHashMap.get("jump_from")))
      {
        localObject1 = TroopInfoActivity.a(str2, 16);
        ((Bundle)localObject1).putInt("D2GType", 2);
      }
      Object localObject3 = localObject1;
      localObject1 = localObject3;
      if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from_group_search"))) {}
      try
      {
        localObject1 = TroopInfoActivity.a(str2, Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from_group_search")));
        if ("h5".equalsIgnoreCase((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from"))) {
          localObject1 = TroopInfoActivity.a(str2, 22);
        }
      }
      catch (Exception localException)
      {
        try
        {
          ((Bundle)localObject1).putInt("troop_info_from_ex", Integer.parseInt(str1));
          ChatSettingForTroop.a(this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject1, 2);
          return true;
          localObject1 = TroopInfoActivity.a(str2, 5);
          continue;
          localException = localException;
          localException.printStackTrace();
          Object localObject2 = localObject3;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("JumpAction", 2, "cast source sub id from web error, sourceSubId = " + str1);
            }
          }
        }
      }
    }
  }
  
  private boolean u()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QRJumpActivity.class);
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("url");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.cd;
    }
    localIntent.putExtra("url", str1);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean v()
  {
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131364506, 0).a();
    return true;
  }
  
  private boolean w()
  {
    if ("webview".equals(this.cI))
    {
      String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("bus_type");
      this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).putExtra("action", "photo").putExtra("doCallBack", true).putExtra("src_type", this.ci).putExtra("callback_type", this.cj).putExtra("callback_name", this.ck));
    }
    return true;
  }
  
  private boolean x()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, BindGroupActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localIntent.putExtra("vkey", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d());
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    label146:
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (!str2.equals("src_type")) {}
      for (String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get(str2));; str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(str2))
      {
        if (TextUtils.isEmpty(str1)) {
          break label146;
        }
        localBundle.putString(str2, str1);
        break;
      }
    }
    localIntent.putExtra("key_params", localBundle);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean y()
  {
    System.currentTimeMillis();
    Object localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
    if ((localObject2 == null) || ((!((String)localObject2).startsWith("http://")) && (!((String)localObject2).startsWith("https://"))) || ((!Util.c((String)localObject2).equalsIgnoreCase("qq.com")) && (!Util.c((String)localObject2).equalsIgnoreCase("myun.tenpay.com")) && (!Util.c((String)localObject2).equalsIgnoreCase("tenpay.com")) && (!Util.c((String)localObject2).equalsIgnoreCase("wanggou.com")))) {
      return false;
    }
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("style");
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_auth");
    localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_nld");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_dev");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_usr");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_vkey");
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append((String)localObject2);
    if (localStringBuffer.indexOf("?") < 0)
    {
      localStringBuffer.append("?");
      localObject2 = new Cryptor();
      if (!"1".equals(str2)) {
        break label1341;
      }
      localStringBuffer.append("plg_auth=1");
      localStringBuffer.append("&");
      localStringBuffer.append("sid=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
      localStringBuffer.append("&");
    }
    label1196:
    label1203:
    label1341:
    for (int i1 = 1;; i1 = 0)
    {
      if ("1".equals(str3))
      {
        localStringBuffer.append("plg_dev=1");
        localStringBuffer.append("&");
        localStringBuffer.append("MOBINFO=");
        localStringBuffer.append(HexUtil.bytes2HexStr(((Cryptor)localObject2).encrypt(b().getBytes(), "4eY#X@~g.+U)2%$<".getBytes())));
        localStringBuffer.append("&");
        i1 = 1;
      }
      if ("1".equals(str4))
      {
        localStringBuffer.append("plg_usr=1");
        localStringBuffer.append("&");
        localStringBuffer.append("USER=");
        localStringBuffer.append(HexUtil.bytes2HexStr(((Cryptor)localObject2).encrypt("黑".getBytes(), "4eY#X@~g.+U)2%$<".getBytes())));
        localStringBuffer.append("&");
        i1 = 1;
      }
      int i2 = i1;
      if ("1".equals(str5))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d();
        i2 = i1;
        if (localObject2 != null)
        {
          localStringBuffer.append("plg_vkey=1").append("&mqqvkey=").append((String)localObject2).append("&");
          i2 = 1;
        }
      }
      if ((this.cM != null) && (this.cM.length() > 0)) {
        localStringBuffer.append(this.cM + "&");
      }
      if ("1".equals(localObject1))
      {
        localStringBuffer.append("plg_nld=1");
        localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class).putExtra("url", localStringBuffer.toString());
        if ((str1 != null) && (!str1.equals(""))) {
          ((Intent)localObject1).putExtra("title", str1);
        }
        ((Intent)localObject1).putExtra("reportNldFormPlugin", true);
        ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
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
      if (i2 != 0) {
        localStringBuffer.deleteCharAt(localStringBuffer.lastIndexOf("&"));
      }
      if ((this.cJ == null) || (!this.cJ.trim().equalsIgnoreCase("com.tx.android.txnews.new")))
      {
        if ((this.cJ != null) && (this.cJ.trim().equalsIgnoreCase("com.qq.yijianfankui")))
        {
          localStringBuffer.append("&version=3.3.0.544");
          localStringBuffer.append("&appid=" + AppSetting.a);
          localStringBuffer.append("&QUA=" + QUA.a());
          localStringBuffer.append("&adtag=544");
          if (localStringBuffer.indexOf("sid=") < 0) {
            localStringBuffer.append("&sid=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
          }
          localObject1 = Build.MODEL;
          if (localObject1 == null) {
            break label1196;
          }
          localObject1 = ((String)localObject1).replaceAll(" ", "_");
          localObject2 = Build.MANUFACTURER;
          if (localObject2 == null) {
            break label1203;
          }
        }
        for (localObject2 = ((String)localObject2).replaceAll(" ", "_");; localObject2 = "")
        {
          localStringBuffer.append("&model=").append((String)localObject1).append("&manufacture=").append((String)localObject2).append("&cpunum=").append(DeviceInfoUtil.b()).append("&cpurate=").append(DeviceInfoUtil.a()).append("&mem=").append(DeviceInfoUtil.c() / 1024L / 1024L).append("&w=").append(DeviceInfoUtil.f()).append("&h=").append(DeviceInfoUtil.g());
          localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class).putExtra("url", localStringBuffer.toString());
          ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          if ((str1 != null) && (!str1.equals(""))) {
            ((Intent)localObject1).putExtra("title", str1);
          }
          ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          ((Intent)localObject1).putExtra("vkey", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d());
          ((Intent)localObject1).putExtra("is_from_leba", true);
          ((Intent)localObject1).putExtra("has_red_dot", this.d);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
          return true;
          localObject1 = "";
          break;
        }
      }
      localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserDelegationActivity.class).putExtra("url", localStringBuffer.toString());
      ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if ((str1 != null) && (!str1.equals(""))) {
        ((Intent)localObject1).putExtra("title", str1);
      }
      ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      ((Intent)localObject1).putExtra("vkey", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d());
      ((Intent)localObject1).putExtra("param_force_internal_browser", false);
      ((Intent)localObject1).putExtra("key_isReadModeEnabled", true);
      ((Intent)localObject1).putExtra("injectrecommend", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
      return true;
    }
  }
  
  private boolean z()
  {
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("file_type");
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    c((String)this.jdField_a_of_type_JavaUtilHashMap.get("previewimagedata"));
    String str6 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    String str7 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    String str8 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
    String str9 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str10 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
    String str11 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
    String str12 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
    String str13 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
    int i1;
    long l1;
    Intent localIntent;
    try
    {
      i1 = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"))).intValue();
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          l1 = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).longValue();
          Bundle localBundle = new Bundle();
          localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
          if (l1 > 0L) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "gotoShareMsg appid = " + l1);
          }
          return false;
          localException1 = localException1;
          i1 = 0;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          l1 = 0L;
        }
        if ("news".equals(str2)) {
          break label400;
        }
      }
    }
    label400:
    int i3;
    if ("audio".equals(str2))
    {
      localException2.putString("title", str4);
      localException2.putString("desc", str5);
      localException2.putString("image_url", str3);
      localException2.putString("detail_url", str6);
      localException2.putInt("forward_type", 11);
      localException2.putLong("req_share_id", l1);
      localException2.putString("pkg_name", this.cJ);
      localException2.putString("image_url_remote", str7);
      localException2.putString("app_name", str8);
      localException2.putString("open_id", str9);
      localException2.putString("share_uin", str11);
      localException2.putString("jfrom", str12);
      localException2.putString("share_qq_ext_str", str13);
      localException2.putInt("cflag", i1);
      localException2.putInt("emoInputType", 2);
      i3 = 1;
    }
    try
    {
      i2 = Integer.valueOf(str10).intValue();
      if (i2 == 2) {
        localException2.putString("audio_url", str1);
      }
      localException2.putInt("req_type", i2);
      localException2.putBoolean("k_dataline", false);
      localException2.putBoolean("k_favorites", true);
      localException2.putBoolean("k_cancel_button", true);
      if (((i1 & 0x2) == 0) && (!"com.qzone".equals(this.cJ)))
      {
        bool = true;
        localException2.putBoolean("k_qzone", bool);
        if ((!bool) || ((i1 & 0x1) == 0)) {
          break label716;
        }
        bool = true;
        localException2.putBoolean("k_send", bool);
        localIntent.putExtras(localException2);
        com.tencent.mobileqq.app.PhoneContactManagerImp.c = true;
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        return true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        boolean bool;
        int i2 = i3;
        if (QLog.isColorLevel())
        {
          QLog.d("QQShare", 2, "NumberFormatException req_type = 1");
          i2 = i3;
          continue;
          bool = false;
          continue;
          label716:
          bool = false;
        }
      }
    }
  }
  
  public String a()
  {
    return this.ce;
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(String paramString)
  {
    this.cI = paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("Jumpaction", 2, "setNewFlag.newflag=" + this.c);
    }
  }
  
  public boolean a()
  {
    new etn(this).start();
    return b();
  }
  
  public void b(String paramString)
  {
    this.cJ = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    this.cg = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("version"));
    this.ch = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("channel_id"));
    this.ci = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type"));
    this.cj = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_type"));
    this.ck = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_name"));
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("viewtype");
    boolean bool1;
    if (("wallet".equals(this.ce)) && ("open".equals(this.cf)) && ("0".equals(localObject)) && (!TextUtils.isEmpty(this.ci))) {
      bool1 = g();
    }
    do
    {
      do
      {
        do
        {
          String str;
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
                    return bool1;
                    if ((this.ce.equals("im")) && (this.cf.equals("chat"))) {
                      return h();
                    }
                    if ((this.ce.equals("im")) && (this.cf.equals("aioorprofile"))) {
                      return i();
                    }
                    if ((this.ce.equals("lbs")) && (this.cf.equals("show_nearby_fri"))) {
                      return j();
                    }
                    if ((this.ce.equals("lbs")) && (this.cf.equals("show_location"))) {
                      return p();
                    }
                    if ((this.ce.equals("lbs")) && (this.cf.equals("select_location"))) {
                      return q();
                    }
                    if ((this.ce.equals("card")) && (this.cf.equals("show_pslcard"))) {
                      return r();
                    }
                    if ((this.ce.equals("upload")) && (this.cf.equals("photo"))) {
                      return w();
                    }
                    if ((this.ce.equals("forward")) && (this.cf.equals("url"))) {
                      return y();
                    }
                    if ((this.ce.equals("gamesdk")) && (this.cf.equals("bind_group"))) {
                      return x();
                    }
                    if ((this.ce.equals("share")) && (this.cf.equals("to_fri"))) {
                      return z();
                    }
                    if ((this.ce.equals("share")) && (this.cf.equals("to_qqdataline"))) {
                      return N();
                    }
                    if ((this.ce.equals("gamesdk")) && (this.cf.equals("add_friend"))) {
                      return A();
                    }
                    if ((this.ce.equals("share")) && (this.cf.equals("to_qqfav"))) {
                      return D();
                    }
                    if ((this.ce.equals("qzone")) && (this.cf.equals("writemood"))) {
                      return E();
                    }
                    if ((this.ce.equals("qzone")) && (this.cf.equals("open_homepage"))) {
                      return F();
                    }
                    if ((this.ce.equals("qzone")) && (this.cf.equals("groupalbum"))) {
                      return B();
                    }
                    if ((this.ce.equals("qzone")) && (this.cf.equals("sharealbum"))) {
                      return C();
                    }
                    if (this.ce.equals("mqq"))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("JumpAction", 2, "handleMQQService");
                      }
                      e();
                      return false;
                    }
                    if (this.ce.endsWith("app"))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("JumpAction", 2, "handleAppForward");
                      }
                      return M();
                    }
                    if ((this.ce.equals("qm")) && (this.cf.equals("qr"))) {
                      return u();
                    }
                    if ((this.ce.equals("tenpay")) && (this.cf.equals("pay"))) {
                      return v();
                    }
                    if ((this.ce.equals("dc")) && (this.cf.equals("ft"))) {
                      return G();
                    }
                    if ((this.ce.equals("group")) && (this.cf.equals("nearby"))) {
                      return k();
                    }
                    if ((this.ce.equals("group")) && (this.cf.equals("create"))) {
                      return l();
                    }
                    if ((this.ce.equals("group")) && (this.cf.equals("creategroup"))) {
                      return m();
                    }
                    if ((this.ce.equals("shop")) && (this.cf.equals("emoji")))
                    {
                      EmojiHomeUiPlugin.openEmojiHomePage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 7, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
                      return true;
                    }
                    if ((this.ce.equals("shop")) && (this.cf.equals("emoji_detail")))
                    {
                      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 4, a("detailid"), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
                      return true;
                    }
                    if ((this.ce.equals("shop")) && (this.cf.equals("emoji_author")))
                    {
                      EmojiHomeUiPlugin.openEmojiAuthorPage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 5, a("authorid"), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
                      return true;
                    }
                    if ((this.ce.equals("shop")) && (this.cf.equals("bubble")))
                    {
                      VasWebviewUtil.a(this.jdField_a_of_type_AndroidContentContext, "http://imgcache.qq.com/club/themes/mobile/bubble/html/index.html?uin=[uin]&client=[client]&version=[version]&sid=[sid]&platformId=[platformId]&device=[device]&system=[system]&updateTime=[updateTime]&updateFlag=[updateFlag]&updateId=[updateId]&adTag=mvip.gongneng.android.bubble.index_dynamic_tab&_bid=122&_wv=1027", 64L, null, false, -1);
                      return true;
                    }
                    if ((!this.ce.equals("shop")) || (!this.cf.equals("theme"))) {
                      break;
                    }
                    bool1 = bool2;
                  } while (!BaseApplicationImpl.jdField_a_of_type_Boolean);
                  bool1 = bool2;
                } while (!Utils.e());
                VasWebviewUtil.a(this.jdField_a_of_type_AndroidContentContext, "http://imgcache.qq.com/club/themes/mobile/theme/html/index.html?uin=[uin]&client=[client]&version=[version]&sid=[sid]&platformId=[platformId]&device=[device]&system=[system]&density=[density]&updateId=[updateId]&adTag=mvip.gongneng.android.theme.index_dynamic_tab&updateFlag=[updateFlag]&_bid=123&_wv=1027", 32L, null, false, -1);
                return true;
                if ((this.ce.equals("shop")) && (this.cf.equals("font")))
                {
                  QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131364510, 0).a();
                  return false;
                }
                if ((this.ce.equals("readingcenter")) && (this.cf.equals("open"))) {
                  return o();
                }
                if ((!this.ce.equals("healthcenter")) || (!this.cf.equals("open"))) {
                  break;
                }
                str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
                bool1 = bool2;
              } while (str == null);
              if (str.startsWith("http://")) {
                break;
              }
              bool1 = bool2;
            } while (!str.startsWith("https://"));
            if ((Util.c(str).equalsIgnoreCase("qq.com")) || (Util.c(str).equalsIgnoreCase("myun.tenpay.com")) || (Util.c(str).equalsIgnoreCase("tenpay.com"))) {
              break;
            }
            bool1 = bool2;
          } while (!Util.c(str).equalsIgnoreCase("wanggou.com"));
          localObject = str;
          if (str.indexOf("?") <= 0) {
            localObject = str + "?";
          }
          localObject = new StringBuilder((String)localObject);
          ((StringBuilder)localObject).append("&client=androidQQ").append("&uin=").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).append("&version=").append("3.3.0.544").append("&system=").append(Build.VERSION.RELEASE).append("&device=").append(Build.DEVICE).append("&density=").append(ThemeUtil.getThemeDensity(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext())).append("&platformId=2").append("&_lv=0").append("&adtag=mvip.gongneng.anroid.health.nativet");
          VasWebviewUtil.a(this.jdField_a_of_type_AndroidContentContext, ((StringBuilder)localObject).toString(), 65536L, null, false, -1);
          return true;
          if ((this.ce.equals("ptlogin")) && (this.cf.equals("qlogin"))) {
            return H();
          }
          if ((this.ce.equals("gav")) && (this.cf.equals("request"))) {
            return I();
          }
          if ((this.ce.equals("videochat")) && (this.cf.equals("request"))) {
            return L();
          }
          if ((this.ce.equals("crmivr")) && (this.cf.equals("audiochat"))) {
            return J();
          }
          if ((this.ce.equals("crmivr")) && (this.cf.equals("imchat"))) {
            return K();
          }
          if ((this.ce.equals("qqdataline")) && (this.cf.equals("openqqdataline"))) {
            return f();
          }
          if ((this.ce.equals("wallet")) && (this.cf.equals("modify_pass"))) {
            return e();
          }
          if (!this.ce.equals("dating")) {
            break;
          }
          bool1 = bool2;
        } while (this.cf.equals("detail"));
        bool1 = bool2;
      } while (!this.ce.equals("share"));
      bool1 = bool2;
    } while (!this.cf.equals("to_troopbar"));
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131364508, 0).a();
    return false;
  }
  
  public void c(String paramString)
  {
    this.cM = paramString;
  }
  
  public boolean c()
  {
    if ((this.ce.equals("im")) && (this.cf.equals("aioorprofile"))) {}
    while ((this.ce.equals("group")) && (this.cf.equals("creategroup"))) {
      return true;
    }
    return false;
  }
  
  public void d(String paramString)
  {
    this.cN = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction
 * JD-Core Version:    0.7.0.1
 */