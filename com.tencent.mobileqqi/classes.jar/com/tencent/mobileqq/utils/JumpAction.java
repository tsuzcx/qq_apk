package com.tencent.mobileqq.utils;

import NearbyGroup.GroupInfo;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.qrcode.activity.QRJumpActivity;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatForEnterpriseActivity;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.NearPeopleActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPageActivity;
import com.tencent.mobileqq.troop.data.NearbyOpenTroop;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.open.agent.AgentActivity;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.TranslucentActivity;
import cooperation.troop.TroopProxyActivity;
import hge;
import hgf;
import hgg;
import hgh;
import hgi;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class JumpAction
{
  public static final String A = "pay";
  public static final String B = "show_nearby_fri";
  public static final String C = "show_location";
  public static final String D = "select_location";
  public static final String E = "open";
  public static final String F = "to_publish_queue";
  public static final String G = "show_pslcard";
  public static final String H = "show_groupcard";
  public static final String I = "photo";
  public static final String J = "url";
  public static final String K = "to_fri";
  public static final String L = "to_qzone";
  public static final String M = "writemood";
  public static final String N = "open_homepage";
  public static final String O = "qr";
  public static final String P = "ft";
  public static final String Q = "nearby";
  public static final String R = "create";
  public static final String S = "emoji";
  public static final String T = "emoji_detail";
  public static final String U = "emoji_author";
  public static final String V = "bubble";
  public static final String W = "theme";
  public static final String X = "font";
  public static final String Y = "pendant";
  public static final String Z = "open";
  public static final String a = "im";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "com.tencent.mobileqq" };
  public static final String aA = "lon";
  public static final String aB = "lat";
  public static final String aC = "title";
  public static final String aD = "summary";
  public static final String aE = "bus_type";
  public static final String aF = "url_prefix";
  public static final String aG = "style";
  public static final String aH = "plg_auth";
  public static final String aI = "plg_nld";
  public static final String aJ = "plg_dev";
  public static final String aK = "plg_usr";
  public static final String aL = "plg_vkey";
  public static final String aM = "file_type";
  public static final String aN = "file_data";
  public static final String aO = "title";
  public static final String aP = "description";
  public static final String aQ = "previewimagedata";
  public static final String aR = "url";
  public static final String aS = "share_id";
  public static final String aT = "image_url";
  public static final String aU = "app_name";
  public static final String aV = "open_id";
  public static final String aW = "share_uin";
  public static final String aX = "jfrom";
  public static final String aY = "audioUrl";
  public static final String aZ = "req_type";
  public static final String aa = "qlogin";
  public static final String ab = "groupalbum";
  public static final String ac = "request";
  public static final String ad = "request";
  public static final String ae = "version";
  public static final String af = "channel_id";
  public static final String ag = "src_type";
  public static final String ah = "callback_type";
  public static final String ai = "callback_name";
  public static final String aj = "app_info";
  public static final String ak = "viewtype";
  public static final String al = "chat_type";
  public static final String am = "uin";
  public static final String an = "attach_content";
  public static final String ao = "group_info";
  public static final String ap = "discuss_info";
  public static final String aq = "sigt";
  public static final String ar = "params";
  public static final String as = "url";
  public static final String at = "picture";
  public static final String au = "title";
  public static final String av = "summary";
  public static final String aw = "gid";
  public static final String ax = "brief";
  public static final String ay = "source";
  public static final String az = "puin";
  public static final String b = "lbs";
  public static final String ba = "back_title";
  public static final String bb = "card_type";
  public static final String bc = "wpa";
  public static final String bd = "k_requestcode";
  public static final String be = "fromSecHandCom";
  public static final String bn = "webview";
  private static final String bo = "share_qq_ext_str";
  private static final String bp = "cflag";
  private static final String bs = "4eY#X@~g.+U)2%$<";
  private static final String bv = "JumpAction";
  private static final String bw = "com.qqreader.QRBridgeActivity";
  public static final String c = "card";
  public static final String d = "upload";
  public static final String e = "forward";
  public static final String f = "share";
  public static final String g = "qzone";
  public static final String h = "mqq";
  public static final String i = "app";
  public static final String j = "qm";
  public static final String k = "wallet";
  public static final String l = "gav";
  public static final String m = "videochat";
  public static final String n = "tenpay";
  public static final String o = "dc";
  public static final String p = "group";
  public static final String q = "shop";
  public static final String r = "ptlogin";
  public static final String s = "readingcenter";
  public static final String t = "tribe";
  public static final String u = "tribe_native";
  public static final String v = "web";
  public static final String w = "url";
  public static final String x = "bid";
  public static final String y = "sourceUrl";
  public static final String z = "chat";
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private hgi jdField_a_of_type_Hgi = new hgi(this, this);
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_a_of_type_Boolean;
  private boolean b = false;
  public String bf;
  public String bg;
  public String bh;
  public String bi;
  public String bj;
  public String bk;
  public String bl;
  public String bm;
  private String bq;
  private String br;
  private String bt;
  private String bu;
  
  public JumpAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private boolean A()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoMultiVoiceChat");
    }
    Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("chat_type");
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("relation_id");
    if ((localObject2 != null) && (((String)localObject2).equals("web")) && (str1 != null) && (str1.equals("1")) && (localObject1 != null) && (str2 != null) && (str2.equals("discussgroup")))
    {
      if (((String)localObject1).equals("0"))
      {
        localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, SelectMemberActivity.class);
        ((Intent)localObject1).putExtra("param_type", 3000);
        ((Intent)localObject1).putExtra("param_subtype", 0);
        ((Intent)localObject1).putExtra("param_from", 1003);
        ((Intent)localObject1).putExtra("param_title", this.jdField_a_of_type_AndroidContentContext.getString(2131561857));
        ((Intent)localObject1).putExtra("param_done_button_wording", this.jdField_a_of_type_AndroidContentContext.getString(2131562539));
        ((Intent)localObject1).putExtra("param_done_button_highlight_wording", this.jdField_a_of_type_AndroidContentContext.getString(2131562550));
        ((Intent)localObject1).putExtra("param_entrance", 10);
        ((Intent)localObject1).putExtra("param_max", 49);
        ((Intent)localObject1).setFlags(603979776);
        ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject1, 1);
        return true;
      }
      localObject2 = new hgg(this);
      return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, (String)localObject1, true, true, (Handler.Callback)localObject2);
    }
    return false;
  }
  
  private boolean B()
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoVideoChat");
    }
    Object localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("request_type");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uinType");
    Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    Object localObject5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("phone");
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extraUin");
    boolean bool1 = bool2;
    if (localObject3 != null)
    {
      bool1 = bool2;
      if (((String)localObject3).equals("web"))
      {
        bool1 = bool2;
        if (str2 != null)
        {
          bool1 = bool2;
          if (!str2.equals("1")) {}
        }
      }
    }
    try
    {
      i1 = Integer.valueOf(str3).intValue();
      if ((localObject1 != null) && (((String)localObject1).equals("audio")))
      {
        bool1 = true;
        if (i1 == 1006)
        {
          localObject1 = localObject5;
          if (!((String)localObject5).startsWith("+")) {
            localObject1 = "+" + (String)localObject5;
          }
          localObject3 = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).f((String)localObject1);
          if (localObject3 != null)
          {
            localObject3 = ((PhoneContact)localObject3).name;
            localObject5 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject5 = localObject1;
            }
            localObject2 = localObject3;
            localObject3 = localObject1;
            localObject1 = localObject5;
            localObject5 = new hgh(this);
            bool1 = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, i1, (String)localObject1, (String)localObject2, (String)localObject3, bool1, str1, true, true, (Handler.Callback)localObject5, "from_internal");
            return bool1;
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "gotoVideoChat", localException);
        }
        int i1 = 0;
        continue;
        Object localObject4 = localObject1;
        continue;
        int i2 = ContactUtils.b(i1);
        if (i2 == -1) {}
        for (localObject4 = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, i1);; localObject4 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, str1, i2, 0))
        {
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            localObject1 = localObject4;
            if (!((String)localObject2).equals(localObject4)) {}
          }
          else
          {
            localObject1 = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, true);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label464;
          }
          localObject1 = localObject2;
          localObject4 = localObject5;
          break;
        }
        label464:
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
        localObject4 = localObject5;
        continue;
        bool1 = false;
      }
    }
  }
  
  private boolean C()
  {
    boolean bool2 = true;
    Object localObject3 = null;
    Object localObject4;
    Object localObject5;
    for (;;)
    {
      Intent localIntent2;
      int i1;
      Object localObject6;
      try
      {
        localIntent2 = new Intent("android.intent.action.MAIN");
        a(localIntent2);
        Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap.entrySet();
        localObject4 = "";
        Iterator localIterator = ((Set)localObject1).iterator();
        i1 = 0;
        localObject1 = null;
        if (localIterator.hasNext())
        {
          localObject5 = (Map.Entry)localIterator.next();
          localObject6 = (String)((Map.Entry)localObject5).getKey();
          localObject5 = (String)((Map.Entry)localObject5).getValue();
          if ((localObject6 == null) || (localObject5 == null)) {
            continue;
          }
          if ("pkg".equals(localObject6))
          {
            localObject1 = localObject4;
            localObject4 = localObject5;
            break;
          }
          if ("cmp".equals(localObject6))
          {
            localObject6 = localObject1;
            localObject1 = localObject4;
            localObject3 = localObject5;
            localObject4 = localObject6;
            break;
          }
          if ("plg_account".equals(localObject6))
          {
            if (!"1".equals(localObject5)) {
              break label1177;
            }
            localIntent2.putExtra("account", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
            localObject5 = localObject1;
            localObject1 = localObject4;
            localObject4 = localObject5;
            break;
          }
          if ("plg_nickname".equals(localObject6))
          {
            if (!"1".equals(localObject5)) {
              break label1177;
            }
            localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e();
            localObject5 = localObject6;
            if (StringUtil.b((String)localObject6)) {
              localObject5 = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
            }
            localIntent2.putExtra("nickname", (String)localObject5);
            localObject5 = localObject1;
            localObject1 = localObject4;
            localObject4 = localObject5;
            break;
          }
          if ("plg_sid".equals(localObject6))
          {
            if (!"1".equals(localObject5)) {
              break label1177;
            }
            localIntent2.putExtra("sid", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
            localObject5 = localObject1;
            localObject1 = localObject4;
            localObject4 = localObject5;
            break;
          }
          if ("plg_vkey".equals(localObject6))
          {
            if (!"1".equals(localObject5)) {
              break label1177;
            }
            localIntent2.putExtra("vkey", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f());
            localObject5 = localObject1;
            localObject1 = localObject4;
            localObject4 = localObject5;
            break;
          }
          if ("plg_launchtime".equals(localObject6))
          {
            if (!"1".equals(localObject5)) {
              break label1177;
            }
            localIntent2.putExtra("launch_time", System.currentTimeMillis());
            localObject5 = localObject1;
            localObject1 = localObject4;
            localObject4 = localObject5;
            break;
          }
          if ("plg_newflag".equals(localObject6))
          {
            if (!"1".equals(localObject5)) {
              break label1177;
            }
            localIntent2.putExtra("newflag", this.b);
            if (!QLog.isColorLevel()) {
              break label1177;
            }
            QLog.d("Jumpaction", 2, "handleAppForward.newflag=" + this.b);
            localObject5 = localObject1;
            localObject1 = localObject4;
            localObject4 = localObject5;
            break;
          }
          if ("plg_type".equals(localObject6))
          {
            if (!"1".equals(localObject5)) {
              break label1177;
            }
            localObject5 = localObject4;
            i1 = 1;
            localObject4 = localObject1;
            localObject1 = localObject5;
            break;
          }
          if ("apk".equals(localObject6))
          {
            localObject4 = localObject1;
            localObject1 = localObject5;
            break;
          }
          localIntent2.putExtra((String)localObject6, (String)localObject5);
          break label1177;
        }
        if ((localObject1 == null) || (localObject3 == null) || ("".equals(localObject1)) || ("".equals(localObject3))) {
          break label1192;
        }
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label1157;
        }
        localObject5 = jdField_a_of_type_ArrayOfJavaLangString;
        int i3 = localObject5.length;
        i2 = 0;
        if (i2 >= i3) {
          break label1157;
        }
        if (((String)localObject1).equals(localObject5[i2]))
        {
          i2 = 1;
          if (i2 == 0)
          {
            localIntent2.putExtra("vkey", (String)null);
            localIntent2.putExtra("sid", (String)null);
            localIntent2.putExtra("nickname", (String)null);
            localIntent2.putExtra("account", (String)null);
          }
          if (localObject3.startsWith("com.qzone")) {
            localIntent2.putExtra("refer", "mqqActiveTab");
          }
          if (i1 != 0) {
            break label1121;
          }
          if (!localObject3.startsWith("com.qzone")) {
            break label879;
          }
          QzonePluginProxyActivity.a(localIntent2, localObject3);
          localIntent2.addFlags(536870912);
          try
          {
            QZoneHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), localIntent2, -1);
            return true;
          }
          catch (Exception localException1)
          {
            Intent localIntent1 = new Intent(this.jdField_a_of_type_AndroidContentContext, TranslucentActivity.class);
            localIntent1.addFlags(268435456);
            localIntent1.putExtras(localIntent2);
            this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent1);
            return true;
          }
        }
        i2 += 1;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        localActivityNotFoundException.printStackTrace();
        return false;
      }
      continue;
      label879:
      if (localObject3.endsWith("OpenTroopInfoActivity"))
      {
        TroopProxyActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent2, null, 0);
        return true;
      }
      boolean bool3 = localObject3.endsWith("PoiMapActivity");
      bool1 = bool2;
      if (!bool3) {
        break label1195;
      }
      try
      {
        if (((ChatActivity)this.jdField_a_of_type_AndroidContentContext).a == null) {
          ((ChatActivity)this.jdField_a_of_type_AndroidContentContext).a = new QQMapActivityProxy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        }
        localIntent2.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        localObject6 = localIntent2.getStringExtra("lat");
        localObject5 = localIntent2.getStringExtra("lon");
        localObject4 = localIntent2.getStringExtra("loc");
        if ((localObject6 != null) && (localObject5 != null))
        {
          localObject6 = Double.valueOf((String)localObject6);
          localObject5 = Double.valueOf((String)localObject5);
          localIntent2.putExtra("url", "http://maps.google.com/maps?q=" + localObject6 + "," + localObject5 + "&iwloc=A&hl=zh-CN (" + (String)localObject4 + ")");
        }
        localIntent2.setClassName(localActivityNotFoundException, localObject3);
        ((ChatActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent2, 18);
        return true;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        return true;
      }
      label1121:
      bool1 = bool2;
      if (i1 != 1) {
        break label1195;
      }
      bool1 = bool2;
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        break label1195;
      }
      bool1 = a(localIntent2, localObject3, (String)localObject4);
      return bool1;
      label1157:
      int i2 = 0;
    }
    for (;;)
    {
      localObject5 = localObject4;
      localObject4 = localException2;
      Object localObject2 = localObject5;
      break;
      label1177:
      localObject5 = localObject2;
      localObject2 = localObject4;
      localObject4 = localObject5;
    }
    label1192:
    boolean bool1 = false;
    label1195:
    return bool1;
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
  
  private void a(Intent paramIntent)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(this.bu)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "wrapper Intent failed intent is null or redTouchInfo is Empty");
      }
      return;
    }
    paramIntent.putExtra("redTouch", this.bu);
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
    try
    {
      if ("head".equals(this.bh))
      {
        if (this.jdField_a_of_type_Hgi == null) {
          this.jdField_a_of_type_Hgi = new hgi(this, this);
        }
        if (this.jdField_a_of_type_JavaUtilHashtable == null) {
          this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Hgi);
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
  
  private String c()
  {
    return "mqqapi://" + this.bg + "/" + this.bh + "?src_type=" + this.bk;
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
  
  private boolean c()
  {
    return true;
  }
  
  private boolean d()
  {
    Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("attach_content"));
    Object localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("chat_type");
    Object localObject5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sigt");
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    Object localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("params");
    if ((localObject4 != null) && (QLog.isDevelopLevel())) {
      QLog.d("JumpAction", 4, (String)localObject4 + "");
    }
    FriendManager localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    Object localObject1 = null;
    int i1;
    if ("c2c".equals(localObject3))
    {
      if ((localObject2 == null) || (((String)localObject2).length() < 5)) {
        return false;
      }
      if (localFriendManager.b((String)localObject2))
      {
        localObject1 = localFriendManager.a((String)localObject2);
        i1 = 0;
      }
    }
    for (;;)
    {
      localObject5 = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
      ((Intent)localObject5).putExtra("uin", (String)localObject2);
      ((Intent)localObject5).putExtra("uintype", i1);
      if (localObject1 != null) {
        ((Intent)localObject5).putExtra("uinname", (String)localObject1);
      }
      if (str2 != null) {
        ((Intent)localObject5).putExtra("input_text", str2);
      }
      if (localObject4 != null) {}
      try
      {
        localObject2 = new JSONObject((String)localObject4);
        localObject1 = ((JSONObject)localObject2).getString("gid");
        localObject2 = ChatActivityUtils.a((JSONObject)localObject2);
        ((Intent)localObject5).putExtra("fromSecHandCom", true);
        ((Intent)localObject5).putExtra("stuctmsg_bytes", (byte[])localObject2);
        ((Intent)localObject5).putExtra("gid", (String)localObject1);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject5);
        if (("web".equals(str1)) && ("group".equals(localObject3)))
        {
          localObject1 = ((ActivityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("activity")).getRunningAppProcesses();
          if (localObject1 != null)
          {
            localObject1 = ((List)localObject1).iterator();
            for (;;)
            {
              if (((Iterator)localObject1).hasNext())
              {
                localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
                if (((ActivityManager.RunningAppProcessInfo)localObject2).processName.equals("com.tencent.mobileqqi:web"))
                {
                  Process.killProcess(((ActivityManager.RunningAppProcessInfo)localObject2).pid);
                  return true;
                  return false;
                  if ("discuss".equals(localObject3))
                  {
                    if ((localObject2 == null) || (((String)localObject2).length() < 6)) {
                      return false;
                    }
                    i1 = 3000;
                    localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("discuss_info");
                    break;
                  }
                  if ("group".equals(localObject3))
                  {
                    if ((localObject2 == null) || (((String)localObject2).length() < 6)) {
                      return false;
                    }
                    localObject1 = localFriendManager.a((String)localObject2);
                    if (localObject1 != null)
                    {
                      i1 = 1;
                      localObject1 = ((TroopInfo)localObject1).troopname;
                      break;
                    }
                    return false;
                  }
                  if ("opengroup".equals(localObject3))
                  {
                    if ((localObject2 == null) || (((String)localObject2).length() < 6)) {
                      return false;
                    }
                    localObject1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("group_info"));
                    for (;;)
                    {
                      try
                      {
                        localObject4 = new JSONObject((String)localObject1);
                        localObject1 = ((JSONObject)localObject4).optString("troopName");
                        localObject3 = ((JSONObject)localObject4).optString("location");
                        str1 = ((JSONObject)localObject4).optString("intro");
                        str2 = ((JSONObject)localObject4).optString("groupCode");
                        i1 = 0;
                        i3 = 0;
                      }
                      catch (JSONException localJSONException2)
                      {
                        int i3;
                        int i2;
                        int i4;
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
                    new NearbyOpenTroop((String)localObject2, (String)localObject1, (Activity)localObject4, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((BaseActivity)localObject4).d()).a(true, new GroupInfo(Long.parseLong((String)localObject2), (String)localObject1, (String)localObject3, i2, str1, 0, false, i1, i2, 0L, 0, 0, 0L, 0L, 0L, false, 0L), str2);
                    return true;
                  }
                  if ("robot".equals(localObject3))
                  {
                    if ((localObject2 == null) || ("".equals(localObject2))) {
                      return false;
                    }
                    localObject1 = localFriendManager.a((String)localObject2);
                    i1 = 1001;
                    break;
                  }
                  if ("wpa".equals(localObject3))
                  {
                    if (localFriendManager.b((String)localObject2))
                    {
                      localObject1 = localFriendManager.a((String)localObject2);
                      i1 = 0;
                    }
                    for (;;)
                    {
                      e((String)localObject2);
                      break;
                      i1 = 1005;
                      localObject1 = null;
                    }
                  }
                  if ("crm".equals(localObject3))
                  {
                    if (localFriendManager.b((String)localObject2))
                    {
                      i1 = 0;
                      localObject1 = localFriendManager.a((String)localObject2);
                    }
                    for (;;)
                    {
                      localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatForEnterpriseActivity.class);
                      ((Intent)localObject3).putExtra("uin", (String)localObject2);
                      ((Intent)localObject3).putExtra("uintype", i1);
                      if (localObject1 != null) {
                        ((Intent)localObject3).putExtra("uinname", (String)localObject1);
                      }
                      if (str2 != null) {
                        ((Intent)localObject3).putExtra("input_text", str2);
                      }
                      if (localObject5 != null) {
                        ((Intent)localObject3).putExtra("sigt", HexUtil.hexStr2Bytes((String)localObject5));
                      }
                      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
                      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "", "", "Bqq_Crm", "Bqq_wpaaio_create", 0, 0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (String)localObject2, "", "");
                      return true;
                      i1 = 1024;
                    }
                  }
                  return false;
                }
              }
            }
          }
        }
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.e("JumpAction", 4, "gotochat---JSONException");
          }
        }
      }
    }
    return true;
  }
  
  private void e(String paramString)
  {
    if ("app".equals(this.bk)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_app", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if ("web".equals(this.bk))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_website", 0, 0, "", "", "", "");
        return;
      }
    } while (!"scan".equals(this.bk));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_scan", 0, 0, "", "", "", "");
  }
  
  private boolean e()
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
          this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, NearPeopleActivity.class).putExtra("lat", i1).putExtra("lon", i2).putExtra("filter", 0));
          return true;
        }
        this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, NearPeopleActivity.class).putExtra("lat", i1).putExtra("lon", i2).putExtra("title", str1).putExtra("filter", 0));
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
  
  private boolean f()
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
  
  private boolean g()
  {
    if ((String)this.jdField_a_of_type_JavaUtilHashMap.get("back_title") == null) {
      this.jdField_a_of_type_AndroidContentContext.getString(2131559317);
    }
    TroopCreateLogic localTroopCreateLogic = (TroopCreateLogic)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(30);
    if (localTroopCreateLogic != null) {
      localTroopCreateLogic.a((Activity)this.jdField_a_of_type_AndroidContentContext, 0);
    }
    return true;
  }
  
  private boolean h()
  {
    return true;
  }
  
  private boolean i()
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.putExtra("account", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e();
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
  private boolean j()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 388	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4: ldc 88
    //   6: invokevirtual 403	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   9: checkcast 356	java/lang/String
    //   12: astore 6
    //   14: aload_0
    //   15: getfield 388	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   18: ldc 91
    //   20: invokevirtual 403	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 356	java/lang/String
    //   26: astore 7
    //   28: aload 6
    //   30: ifnull +139 -> 169
    //   33: aload 7
    //   35: ifnull +134 -> 169
    //   38: aload 6
    //   40: invokevirtual 1092	java/lang/String:trim	()Ljava/lang/String;
    //   43: invokestatic 1029	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   46: i2d
    //   47: ldc2_w 1114
    //   50: ddiv
    //   51: dstore_1
    //   52: aload 7
    //   54: invokevirtual 1092	java/lang/String:trim	()Ljava/lang/String;
    //   57: invokestatic 1029	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   60: istore 5
    //   62: iload 5
    //   64: i2d
    //   65: ldc2_w 1114
    //   68: ddiv
    //   69: dstore_3
    //   70: aload_0
    //   71: aload_0
    //   72: getfield 388	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   75: ldc 94
    //   77: invokevirtual 403	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   80: checkcast 356	java/lang/String
    //   83: invokespecial 945	com/tencent/mobileqq/utils/JumpAction:c	(Ljava/lang/String;)Ljava/lang/String;
    //   86: pop
    //   87: new 507	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   94: ldc_w 738
    //   97: invokevirtual 512	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: dload_3
    //   101: invokevirtual 1118	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   104: ldc_w 743
    //   107: invokevirtual 512	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: dload_1
    //   111: invokevirtual 1118	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   114: ldc_w 1120
    //   117: invokevirtual 512	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 516	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: astore 6
    //   125: new 417	android/content/Intent
    //   128: dup
    //   129: ldc_w 1122
    //   132: aload 6
    //   134: invokestatic 1128	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   137: invokespecial 1131	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   140: astore 7
    //   142: aload 7
    //   144: ldc_w 1133
    //   147: ldc_w 1135
    //   150: invokevirtual 750	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   153: pop
    //   154: aload_0
    //   155: getfield 381	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   158: aload 7
    //   160: invokevirtual 699	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   163: iconst_1
    //   164: ireturn
    //   165: astore 6
    //   167: iconst_0
    //   168: ireturn
    //   169: iconst_0
    //   170: ireturn
    //   171: astore 7
    //   173: aload_0
    //   174: getfield 381	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   177: new 417	android/content/Intent
    //   180: dup
    //   181: ldc_w 1122
    //   184: aload 6
    //   186: invokestatic 1128	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   189: invokespecial 1131	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   192: invokevirtual 699	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   195: goto -32 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	JumpAction
    //   51	60	1	d1	double
    //   69	32	3	d2	double
    //   60	3	5	i1	int
    //   12	121	6	str	String
    //   165	20	6	localException	Exception
    //   26	133	7	localObject	Object
    //   171	1	7	localActivityNotFoundException	ActivityNotFoundException
    // Exception table:
    //   from	to	target	type
    //   38	62	165	java/lang/Exception
    //   154	163	171	android/content/ActivityNotFoundException
  }
  
  private boolean k()
  {
    if ("webview".equals(this.bq))
    {
      c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
      this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).putExtra("action", "select_location").putExtra("doCallBack", true).putExtra("src_type", this.bk).putExtra("callback_type", this.bl).putExtra("callback_name", this.bm));
    }
    return true;
  }
  
  private boolean l()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("card_type");
    if ((str != null) && ("group".equals(str))) {
      return n();
    }
    return m();
  }
  
  private boolean m()
  {
    boolean bool = false;
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("wpa");
    if ((localObject == null) || ("".equals(localObject)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(localObject))) {
      localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    }
    for (;;)
    {
      ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject);
      bool = true;
      do
      {
        return bool;
      } while (((String)localObject).length() < 5);
      Friends localFriends = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c((String)localObject);
      if ((localFriends != null) && (localFriends.isFriend()))
      {
        localObject = new ProfileActivity.AllInOne((String)localObject, 1);
        ((ProfileActivity.AllInOne)localObject).g = localFriends.name;
        ((ProfileActivity.AllInOne)localObject).h = localFriends.remark;
      }
      else
      {
        if (this.jdField_a_of_type_Boolean)
        {
          localObject = new ProfileActivity.AllInOne((String)localObject, 3);
          if ("1".equals(str)) {}
          for (int i1 = 1;; i1 = 0)
          {
            ((ProfileActivity.AllInOne)localObject).c = i1;
            break;
          }
        }
        localObject = new ProfileActivity.AllInOne((String)localObject, 19);
      }
    }
  }
  
  private boolean n()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((localObject == null) || ("".equals(localObject)) || (((String)localObject).length() < 5)) {
      return false;
    }
    localObject = TroopInfoActivity.a((String)localObject, 5);
    if ("d2g".equals(this.jdField_a_of_type_JavaUtilHashMap.get("jump_from"))) {
      ((Bundle)localObject).putInt("D2GType", 2);
    }
    ChatSettingForTroop.a(this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject, 2);
    return true;
  }
  
  private boolean o()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QRJumpActivity.class);
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("url");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.bf;
    }
    localIntent.putExtra("url", str1);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean p()
  {
    return true;
  }
  
  private boolean q()
  {
    if ("webview".equals(this.bq))
    {
      String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("bus_type");
      this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).putExtra("action", "photo").putExtra("doCallBack", true).putExtra("src_type", this.bk).putExtra("callback_type", this.bl).putExtra("callback_name", this.bm));
    }
    return true;
  }
  
  private boolean r()
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
        break label1315;
      }
      localStringBuffer.append("plg_auth=1");
      localStringBuffer.append("&");
      localStringBuffer.append("sid=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
      localStringBuffer.append("&");
    }
    label1170:
    label1177:
    label1315:
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
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f();
        i2 = i1;
        if (localObject2 != null)
        {
          localStringBuffer.append("plg_vkey=1").append("&mqqvkey=").append((String)localObject2).append("&");
          i2 = 1;
        }
      }
      if ((this.bt != null) && (this.bt.length() > 0)) {
        localStringBuffer.append(this.bt + "&");
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
      if ((this.br == null) || (!this.br.trim().equalsIgnoreCase("com.tx.android.txnews.new")))
      {
        if ((this.br != null) && (this.br.trim().equalsIgnoreCase("com.qq.yijianfankui")))
        {
          localStringBuffer.append("&version=6.0.0.6500");
          localStringBuffer.append("&appid=" + AppSetting.a);
          localStringBuffer.append("&QUA=" + QUA.a());
          localStringBuffer.append("&adtag=6500");
          if (localStringBuffer.indexOf("sid=") < 0) {
            localStringBuffer.append("&sid=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
          }
          localObject1 = Build.MODEL;
          if (localObject1 == null) {
            break label1170;
          }
          localObject1 = ((String)localObject1).replaceAll(" ", "_");
          localObject2 = Build.MANUFACTURER;
          if (localObject2 == null) {
            break label1177;
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
          ((Intent)localObject1).putExtra("vkey", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f());
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
      ((Intent)localObject1).putExtra("vkey", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f());
      ((Intent)localObject1).putExtra("param_force_internal_browser", false);
      ((Intent)localObject1).putExtra("key_isReadModeEnabled", true);
      ((Intent)localObject1).putExtra("injectrecommend", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
      return true;
    }
  }
  
  private boolean s()
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
          break label392;
        }
      }
    }
    label392:
    int i3;
    if ("audio".equals(str2))
    {
      localException2.putString("title", str4);
      localException2.putString("desc", str5);
      localException2.putString("image_url", str3);
      localException2.putString("detail_url", str6);
      localException2.putInt("forward_type", 11);
      localException2.putLong("req_share_id", l1);
      localException2.putString("pkg_name", this.br);
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
      if (((i1 & 0x2) == 0) && (!"com.qzone".equals(this.br)))
      {
        bool = true;
        localException2.putBoolean("k_qzone", bool);
        if ((!bool) || ((i1 & 0x1) == 0)) {
          break label706;
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
          label706:
          bool = false;
        }
      }
    }
  }
  
  private boolean t()
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
        localUserInfo.b = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e();
        localUserInfo.c = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("url");
        if (!str2.equalsIgnoreCase("11")) {
          break label117;
        }
        QZoneHelper.c((Activity)this.jdField_a_of_type_AndroidContentContext, localUserInfo, str1, "mqqChat.QzoneCard", -1);
      }
    }
    for (;;)
    {
      return false;
      label117:
      if (str2.equalsIgnoreCase("12"))
      {
        localObject = ((ChatActivity)localObject).c();
        str2 = b(str1);
        QZoneHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, localUserInfo, (String)localObject, str2, str1, "mqqChat.QzoneCard", -1);
      }
    }
  }
  
  private boolean u()
  {
    Object localObject1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    Object localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str6 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
    String str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
    Object localObject3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
    String str8 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
    int i2 = 0;
    int i3 = 1;
    try
    {
      i1 = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"))).intValue();
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        i2 = Integer.valueOf((String)localObject3).intValue();
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        try
        {
          for (;;)
          {
            l1 = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).longValue();
            localObject3 = new ArrayList();
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break;
            }
            localObject2 = ((String)localObject2).split(";");
            i3 = 0;
            while (i3 < localObject2.length)
            {
              ((ArrayList)localObject3).add(URLDecoder.decode(localObject2[i3]));
              i3 += 1;
            }
            localNumberFormatException3 = localNumberFormatException3;
            i1 = i2;
            if (QLog.isColorLevel())
            {
              QLog.d("QzoneShare", 2, "NumberFormatException extFlags = 0");
              i1 = i2;
              continue;
              localNumberFormatException1 = localNumberFormatException1;
              i2 = i3;
              if (QLog.isColorLevel())
              {
                QLog.d("QzoneShare", 2, "NumberFormatException req_type = 1");
                i2 = i3;
              }
            }
          }
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          int i1;
          long l1;
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QzoneShare", 2, "NumberFormatException appID = 0");
            }
            l1 = 0L;
          }
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("title", (String)localObject1);
          ((Bundle)localObject2).putString("desc", str1);
          ((Bundle)localObject2).putString("app_name", str3);
          ((Bundle)localObject2).putLong("req_share_id", l1);
          ((Bundle)localObject2).putString("detail_url", str2);
          ((Bundle)localObject2).putStringArrayList("image_url", localNumberFormatException2);
          ((Bundle)localObject2).putString("pkg_name", this.br);
          ((Bundle)localObject2).putString("open_id", str5);
          ((Bundle)localObject2).putString("share_uin", str6);
          ((Bundle)localObject2).putString("jfrom", str7);
          ((Bundle)localObject2).putString("share_qq_ext_str", str8);
          ((Bundle)localObject2).putInt("cflag", i1);
          if (i2 == 2) {
            ((Bundle)localObject2).putString("audio_url", str4);
          }
          ((Bundle)localObject2).putInt("req_type", i2);
          com.tencent.mobileqq.app.PhoneContactManagerImp.c = true;
          localObject1 = new hgf(this);
          QZoneShareManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject2, (DialogInterface.OnDismissListener)localObject1);
        }
      }
    }
    return true;
  }
  
  private boolean v()
  {
    return true;
  }
  
  private boolean w()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
      localUserInfo.a = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localUserInfo.b = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e();
      localUserInfo.c = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
      QZoneHelper.b((Activity)this.jdField_a_of_type_AndroidContentContext, localUserInfo, -1);
      return true;
    }
    return false;
  }
  
  private boolean x()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    localObject = new Intent("com.tencent.sc.intent.tabactivity");
    ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    return true;
  }
  
  private boolean y()
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
  
  private boolean z()
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
  
  public String a()
  {
    return this.bg;
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(String paramString)
  {
    this.bq = paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("Jumpaction", 2, "setNewFlag.newflag=" + this.b);
    }
  }
  
  public boolean a()
  {
    new hge(this).start();
    return b();
  }
  
  public void b(String paramString)
  {
    this.br = paramString;
  }
  
  public boolean b()
  {
    this.bi = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("version"));
    this.bj = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("channel_id"));
    this.bk = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type"));
    this.bl = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_type"));
    this.bm = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_name"));
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("viewtype");
    if (("wallet".equals(this.bg)) && ("open".equals(this.bh)) && ("0".equals(str1)) && (!TextUtils.isEmpty(this.bk))) {
      return c();
    }
    if ((this.bg.equals("im")) && (this.bh.equals("chat"))) {
      return d();
    }
    if ((this.bg.equals("lbs")) && (this.bh.equals("show_nearby_fri"))) {
      return e();
    }
    if ((this.bg.equals("lbs")) && (this.bh.equals("show_location"))) {
      return j();
    }
    if ((this.bg.equals("lbs")) && (this.bh.equals("select_location"))) {
      return k();
    }
    if ((this.bg.equals("card")) && (this.bh.equals("show_pslcard"))) {
      return l();
    }
    if ((this.bg.equals("upload")) && (this.bh.equals("photo"))) {
      return q();
    }
    if ((this.bg.equals("forward")) && (this.bh.equals("url"))) {
      return r();
    }
    if ((this.bg.equals("share")) && (this.bh.equals("to_fri"))) {
      return s();
    }
    if ((this.bg.equals("share")) && (this.bh.equals("to_qzone"))) {
      return u();
    }
    if ((this.bg.equals("qzone")) && (this.bh.equals("writemood"))) {
      return v();
    }
    if ((this.bg.equals("qzone")) && (this.bh.equals("to_publish_queue"))) {
      return w();
    }
    if ((this.bg.equals("qzone")) && (this.bh.equals("open_homepage"))) {
      return x();
    }
    if ((this.bg.equals("qzone")) && (this.bh.equals("groupalbum"))) {
      return t();
    }
    if (this.bg.equals("mqq"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "handleMQQService");
      }
      b();
    }
    do
    {
      do
      {
        do
        {
          return false;
          if (this.bg.endsWith("app"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("JumpAction", 2, "handleAppForward");
            }
            return C();
          }
          if ((this.bg.equals("qm")) && (this.bh.equals("qr"))) {
            return o();
          }
          if ((this.bg.equals("tenpay")) && (this.bh.equals("pay"))) {
            return p();
          }
          if ((this.bg.equals("dc")) && (this.bh.equals("ft"))) {
            return y();
          }
          if ((this.bg.equals("group")) && (this.bh.equals("nearby"))) {
            return f();
          }
          if ((this.bg.equals("group")) && (this.bh.equals("create"))) {
            return g();
          }
          if ((this.bg.equals("shop")) && (this.bh.equals("bubble")))
          {
            VasWebviewUtil.a(this.jdField_a_of_type_AndroidContentContext, "http://imgcache.qq.com/club/themes/mobile/bubble/html/index.html?uin=[uin]&client=[client]&version=[version]&sid=[sid]&platformId=[platformId]&device=[device]&system=[system]&updateTime=[updateTime]&updateFlag=[updateFlag]&adTag=mvip.gongneng.android.bubble.index_dynamic_tab&_bid=122&_wv=1027", 64L, null, false, -1);
            return true;
          }
          if ((!this.bg.equals("shop")) || (!this.bh.equals("theme"))) {
            break;
          }
        } while ((!BaseApplicationImpl.jdField_a_of_type_Boolean) || (!Utils.e()));
        VasWebviewUtil.a(this.jdField_a_of_type_AndroidContentContext, "http://imgcache.qq.com/club/themes/mobile/theme/html/index.html?uin=[uin]&client=[client]&version=[version]&sid=[sid]&platformId=[platformId]&device=[device]&system=[system]&density=[density]&adTag=mvip.gongneng.android.theme.index_dynamic_tab&updateFlag=[updateFlag]&_bid=123&_wv=1027", 32L, null, false, -1);
        return true;
        if ((!this.bg.equals("shop")) || (!this.bh.equals("font"))) {
          break;
        }
      } while ((!DeviceProfileManager.a().b(DeviceProfileManager.DpcNames.chat_font.name())) || (!Utils.e()));
      VasWebviewUtil.a(this.jdField_a_of_type_AndroidContentContext, VasWebviewConstants.CHAT_FONT_MARKET_HOME_URL, 4096L, null, false, -1);
      return true;
      if ((this.bg.equals("shop")) && (this.bh.equals("pendant")))
      {
        if (Utils.e()) {
          AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
        }
        return true;
      }
      if ((this.bg.equals("readingcenter")) && (this.bh.equals("open"))) {
        return i();
      }
      if ((this.bg.equals("ptlogin")) && (this.bh.equals("qlogin"))) {
        return z();
      }
      if ((this.bg.equals("gav")) && (this.bh.equals("request"))) {
        return A();
      }
      if ((this.bg.equals("videochat")) && (this.bh.equals("request"))) {
        return B();
      }
    } while (!this.bg.equals("tribe"));
    str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("bid");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sourceUrl");
    Object localObject;
    if (this.bh.equals("tribe_native"))
    {
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, TroopBarPageActivity.class).putExtra("bid", str1);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    }
    for (;;)
    {
      if ((str1 != null) && (str2 != null)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_tribe", "", "url", "visit", 0, 1, 0, str1, Share.a(str2, new String[0]), "", "");
      }
      return true;
      if (this.bh.equals("web"))
      {
        localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("url");
        try
        {
          localObject = URLDecoder.decode((String)localObject);
          localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicAccountBrowser.class).putExtra("url", (String)localObject);
          ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          ((Intent)localObject).putExtra("hide_operation_bar", true);
          ((Intent)localObject).putExtra("hideRightButton", true);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
        }
        catch (Exception localException)
        {
          if (QLog.isDevelopLevel()) {
            QLog.e("JumpAction", 4, "URLDecoder.decode error");
          }
        }
      }
    }
    return false;
  }
  
  public void c(String paramString)
  {
    this.bt = paramString;
  }
  
  public void d(String paramString)
  {
    this.bu = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction
 * JD-Core Version:    0.7.0.1
 */