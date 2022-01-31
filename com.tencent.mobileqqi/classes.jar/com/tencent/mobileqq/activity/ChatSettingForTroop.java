package com.tencent.mobileqq.activity;

import KQQ.BatchResponse;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.view.MenuItemCompat;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import cjm;
import cjn;
import cjo;
import cjp;
import cjq;
import cjr;
import cjs;
import cjt;
import cju;
import cjw;
import cjx;
import cjy;
import cjz;
import cka;
import ckb;
import ckc;
import ckd;
import cke;
import ckf;
import ckg;
import ckh;
import com.qq.jce.wup.UniPacket;
import com.tencent.biz.common.report.BnrReport;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.webviewplugin.ReportPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.troop.activity.NearbyTroopsLocationActivity;
import com.tencent.mobileqq.troop.activity.TroopAdminList;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;
import com.tencent.mobileqq.troop.browser.TroopQQBrowserHelper;
import com.tencent.mobileqq.troop.data.TroopFileObserver;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.mobileqq.troop.widget.AvatarWallView;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.troop.TroopProxyActivity;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.util.WeakReference;
import oicq.wlogin_sdk.tools.MD5;
import qz_groupphoto.GetLastPicRsp;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class ChatSettingForTroop
  extends IphoneTitleBarActivity
  implements View.OnClickListener, View.OnLongClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final int A = 14;
  public static final int B = 15;
  public static final int C = 16;
  public static final int D = 1;
  public static final int E = 2;
  protected static final int H = 0;
  protected static final int I = 1;
  protected static final int J = 2;
  protected static final int K = 3;
  protected static final int L = 4;
  protected static final int M = 5;
  protected static final int N = 6;
  protected static final int O = 7;
  protected static final int P = 8;
  protected static final int Q = 9;
  protected static final int R = 10;
  protected static final int S = 11;
  protected static final int T = 12;
  protected static final int U = 13;
  protected static final int V = 14;
  protected static final int W = 15;
  protected static final int X = 16;
  protected static final int Y = 17;
  protected static final int Z = 18;
  public static final int a = 1;
  public static final String a = "Q.chatopttroop";
  protected static final int aA = 9;
  protected static final int aB = 10;
  public static final int aC = 11;
  protected static final int aD = 12;
  protected static final int aE = 13;
  public static final int aF = 14;
  protected static final int aG = 12;
  private static final int aI = 0;
  protected static final int aa = 19;
  protected static final int ab = 20;
  protected static final int ac = 21;
  protected static final int ad = 22;
  protected static final int ae = 22;
  protected static final int af = 23;
  protected static final int ag = 24;
  protected static final int ah = 25;
  protected static final int ai = 26;
  protected static final int aj = 27;
  protected static final int ak = 28;
  protected static final int al = 29;
  protected static final int am = 1101111755;
  public static final int ap = 6;
  protected static final int ar = 1;
  protected static final int as = 1;
  protected static final int at = 2;
  protected static final int au = 3;
  protected static final int av = 4;
  protected static final int aw = 5;
  protected static final int ax = 6;
  protected static final int ay = 7;
  protected static final int az = 8;
  public static final int b = 2;
  public static final String b = "http://xiaoqu.qq.com/cgi-bin/bar/jump?action=qun&from=card&gid=%s";
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 8;
  private static final String jdField_h_of_type_JavaLangString = "_troop_community.nb";
  public static final int i = 9;
  public static final int j = 0;
  public static final int k = 1;
  public static final int l = 2;
  public static final int m = 3;
  public static final int n = 1;
  public static final int o = 2;
  public static final int p = 3;
  public static final int q = 4;
  public static final int r = 5;
  public static final int s = 6;
  public static final int t = 7;
  public static final int u = 8;
  public static final int v = 9;
  public static final int w = 10;
  public static final int x = 11;
  public static final int y = 12;
  public static final int z = 13;
  protected final int F = 1;
  protected final int G = 4;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  public Drawable a;
  public Handler a;
  protected DisplayMetrics a;
  protected View a;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected LinearLayout a;
  public TextView a;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new cjt(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new cjr(this);
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new cjp(this);
  public TroopInfo a;
  public TroopFileObserver a;
  private TroopFileManager jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager;
  public AvatarWallAdapter a;
  protected AvatarWallView a;
  public TroopInfoData a;
  private TroopShareUtility jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public QQProgressNotifier a;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  public ArrayList a;
  private HashMap jdField_a_of_type_JavaUtilHashMap = null;
  public List a;
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new cjm(this);
  protected boolean a;
  public View[] a;
  private final int aJ = 103;
  public int an;
  public int ao = 1;
  protected int aq;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  public View b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TroopObserver jdField_b_of_type_ComTencentMobileqqAppTroopObserver = new cjq(this);
  List jdField_b_of_type_JavaUtilList;
  public boolean b;
  ImageView c;
  protected String c;
  protected List c;
  public boolean c;
  ImageView d;
  public final String d;
  protected boolean d;
  ImageView e;
  protected String e;
  protected boolean e;
  ImageView jdField_f_of_type_AndroidWidgetImageView;
  private String jdField_f_of_type_JavaLangString;
  protected boolean f;
  private String jdField_g_of_type_JavaLangString;
  private boolean jdField_g_of_type_Boolean = false;
  private boolean jdField_h_of_type_Boolean;
  
  public ChatSettingForTroop()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = "http://app.qun.qq.com/mobileapp/index.html?_bid=136";
    this.jdField_d_of_type_JavaLangString = "http://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3";
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new cjo(this);
    this.h = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileObserver = new cjx(this);
  }
  
  private void C()
  {
    Intent localIntent = new Intent(this, ChatHistory.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    startActivityForResult(localIntent, 7);
  }
  
  private void D()
  {
    Intent localIntent = new Intent(this, ChatBackgroundSettingActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("bg_replace_entrance", 62);
    startActivityForResult(localIntent, 8);
  }
  
  private void E()
  {
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "data_page", "Clk_set", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
    String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_f_of_type_JavaLangString;
    if (TextUtils.isEmpty(str)) {
      str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString;
    }
    for (;;)
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
      localActionSheet.a(getString(2131561519, new Object[] { str }));
      int i1 = DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      localActionSheet.b(getString(2131561533, new Object[] { StringUtil.a(BaseApplication.getContext(), i1) }));
      localActionSheet.a(getString(2131560651), false);
      localActionSheet.a(getString(2131560652), false);
      localActionSheet.a(getString(2131560653), false);
      localActionSheet.a(getString(2131560654), false);
      i1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      switch (i1)
      {
      }
      for (;;)
      {
        localActionSheet.d(2131561746);
        localActionSheet.a(new ckf(this, i1, localActionSheet));
        localActionSheet.show();
        return;
        localActionSheet.e(0);
        continue;
        localActionSheet.e(1);
        continue;
        localActionSheet.e(2);
        continue;
        localActionSheet.e(3);
      }
    }
  }
  
  private void F()
  {
    if ((this.ao == 2) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean)) {
      return;
    }
    boolean bool;
    QZoneHelper.UserInfo localUserInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i != 0)
    {
      bool = true;
      if (bool)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i = 0;
        DBUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "troop_photo_new", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_h_of_type_Int <= 0) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        }
      }
      localUserInfo = QZoneHelper.UserInfo.a();
      localUserInfo.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localUserInfo.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e();
      localUserInfo.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_h_of_type_Int <= 0) {
        break label186;
      }
      QZoneHelper.a(this, localUserInfo, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_f_of_type_JavaLangString, bool, 9);
    }
    for (;;)
    {
      a("Grp_Admin_data", "Clk_album", "");
      BnrReport.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, 66);
      return;
      bool = false;
      break;
      label186:
      QZoneHelper.b(this, localUserInfo, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_f_of_type_JavaLangString, bool, 9);
    }
  }
  
  private void G()
  {
    switch (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int)
    {
    case 8: 
    default: 
      return;
    case 3: 
      localIntent = new Intent();
      localIntent.putExtra("isNeedFinish", true);
      setResult(-1, localIntent);
      finish();
      return;
    }
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_f_of_type_JavaLangString);
    startActivity(localIntent);
  }
  
  private void H()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short != 3)
    {
      Intent localIntent = new Intent(a(), AddFriendLogicActivity.class);
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("name", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_f_of_type_JavaLangString);
      localIntent.putExtra("group_option", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short);
      localIntent.putExtra("type", 1);
      localIntent.putExtra("param_last_activity_name", a_());
      localIntent.putExtra("stat_option", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a());
      localIntent.putExtra("join_group_question", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.r);
      localIntent.putExtra("join_group_answer", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.s);
      if (this.aq == 1) {
        localIntent.putExtra("jump_from", "d2g");
      }
      if ((this.aq == 1) || (this.aq == 2)) {
        localIntent.putExtra("stat_option", 116);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_JavaLangString))
      {
        localIntent.putExtra("param_return_addr", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_JavaLangString);
        startActivity(localIntent);
        return;
      }
      startActivityForResult(localIntent, 11);
      return;
    }
    b(2131563078, 1);
  }
  
  private void I()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(2131562772, 5);
    if (this.ao == 1) {
      localActionSheet.a(2131562706, 3);
    }
    localActionSheet.d(2131561746);
    localActionSheet.a(new cjz(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short = 1;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_n_of_type_JavaLangString = getString(2131561648);
      return;
    case 2: 
    case 4: 
    case 5: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short = 2;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_n_of_type_JavaLangString = getString(2131562788);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short = 3;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_n_of_type_JavaLangString = getString(2131561965);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean1, int paramInt4, boolean paramBoolean2)
  {
    if (this.ao == 2) {
      return;
    }
    Intent localIntent = new Intent(this, EditActivity.class);
    localIntent.putExtra("title", paramInt3);
    localIntent.putExtra("limit", paramInt2);
    localIntent.putExtra("current", paramString);
    localIntent.putExtra("canPostNull", paramBoolean1);
    localIntent.putExtra("multiLine", paramBoolean2);
    localIntent.putExtra("support_emotion", paramInt4);
    startActivityForResult(localIntent, paramInt1);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_l_of_type_Int != 0) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_l_of_type_Int = 0;
        DBUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "troop_notification_new", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_l_of_type_Int);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_j_of_type_Int <= 0) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
        }
      }
      a(paramInt1, paramInt2, paramInt3, paramString, paramBoolean1, 0, paramBoolean2);
      return;
    }
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt1, int paramInt2)
  {
    if (paramActivity != null) {}
    try
    {
      Intent localIntent = new Intent(paramActivity, ChatSettingForTroop.class);
      localIntent.putExtras(paramBundle);
      localIntent.putExtra("vistor_type", paramInt1);
      paramActivity.startActivityForResult(localIntent, paramInt2);
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.chatopttroop", 2, paramActivity.toString());
    }
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean, ArrayList paramArrayList)
  {
    Intent localIntent = new Intent(paramActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_groupcode", paramString);
    localIntent.putExtra("param_type", 1);
    localIntent.putExtra("param_subtype", 1);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_is_troop_admin", paramBoolean);
    localIntent.putExtra("param_uins_selected_default", paramArrayList);
    localIntent.putExtra("param_title", paramActivity.getString(2131560616));
    if (!paramBoolean) {
      localIntent.putExtra("param_max", 10);
    }
    paramActivity.startActivityForResult(localIntent, 1);
  }
  
  public static void a(Context paramContext, Bundle paramBundle, int paramInt)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = new Intent(paramContext, ChatSettingForTroop.class);
      localIntent.putExtras(paramBundle);
      localIntent.putExtra("vistor_type", paramInt);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.chatopttroop", 2, paramContext.toString());
    }
  }
  
  private void a(Intent paramIntent)
  {
    int i2 = 0;
    if (paramIntent == null) {}
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        return;
        boolean bool1 = paramIntent.getBooleanExtra("nickboolean", false);
        boolean bool2 = paramIntent.getBooleanExtra("sexboolean", false);
        boolean bool3 = paramIntent.getBooleanExtra("phoneboolean", false);
        boolean bool4 = paramIntent.getBooleanExtra("mailboolean", false);
        boolean bool5 = paramIntent.getBooleanExtra("remarkboolean", false);
        if (bool1) {
          i2 = 1;
        }
        int i1 = i2;
        if (bool2) {
          i1 = i2 | 0x2;
        }
        i2 = i1;
        if (bool3) {
          i2 = i1 | 0x4;
        }
        i1 = i2;
        if (bool4) {
          i1 = i2 | 0x8;
        }
        i2 = i1;
        if (bool5) {
          i2 = i1 | 0x10;
        }
      } while (i2 == 0);
      if (!NetworkUtil.e(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131562449, 1500);
        return;
      }
      this.an |= 0x1;
      localObject1 = paramIntent.getStringExtra("nick");
      localObject2 = paramIntent.getStringExtra("phone");
      byte b1 = paramIntent.getByteExtra("sex", (byte)-1);
      String str1 = paramIntent.getStringExtra("mail");
      String str2 = paramIntent.getStringExtra("remark");
      paramIntent = new TroopMemberCardInfo();
      paramIntent.email = str1;
      paramIntent.memberuin = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      paramIntent.memo = str2;
      paramIntent.name = ((String)localObject1);
      paramIntent.sex = b1;
      paramIntent.tel = ((String)localObject2);
      paramIntent.troopuin = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString;
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(paramIntent);
      paramIntent = new ArrayList();
      paramIntent.add(Integer.valueOf(i2));
      localObject2 = (TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(19);
    } while (localObject2 == null);
    ((TroopHandler)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, (ArrayList)localObject1, paramIntent);
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null)
    {
      localObject = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (localObject != null) {
        break label56;
      }
    }
    label56:
    for (Object localObject = null;; localObject = ((FriendManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && ((paramInt & 0x1) > 0)) {
        a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cGroupOption);
      }
      return;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = new Intent(a(), TroopDisbandActivity.class);
      ((Intent)localObject1).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_f_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("leftViewText", 2131561804);
      startActivityForResult((Intent)localObject1, 6);
      localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!paramBoolean) {
        break label305;
      }
    }
    label305:
    for (Object localObject1 = "1";; localObject1 = "0")
    {
      ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", "Grp", "Clk_quit_grp", 0, 0, (String)localObject1, "", "", "");
      return;
      localObject2 = getString(2131562707);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_f_of_type_JavaLangString == null) {}
      for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString;; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_f_of_type_JavaLangString + "(" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString + ")")
      {
        localObject1 = String.format(getString(2131561971), new Object[] { localObject1 });
        localObject1 = DialogUtil.a(this, 230).setTitle((String)localObject2).setMessage((String)localObject1);
        ((QQCustomDialog)localObject1).setPositiveButton(getString(2131562701), new ckd(this, (QQCustomDialog)localObject1));
        ((QQCustomDialog)localObject1).setPositiveButtonContentDescription(getString(2131558431));
        ((QQCustomDialog)localObject1).setNegativeButton(getString(2131561746), new cke(this, (QQCustomDialog)localObject1));
        ((QQCustomDialog)localObject1).setNegativeButtonContentDescription(getString(2131558432));
        ((QQCustomDialog)localObject1).show();
        break;
      }
    }
  }
  
  private void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "saveTroopInfo| nModifyFlag = " + paramInt);
    }
    if ((paramInt & 0x3F) > 0) {}
    try
    {
      TroopHandler localTroopHandler = (TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(19);
      if (localTroopHandler != null)
      {
        localTroopHandler.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Short, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_m_of_type_JavaLangString, paramInt);
        if (this.jdField_a_of_type_JavaUtilList == null) {
          this.jdField_a_of_type_JavaUtilList = new ArrayList();
        }
        this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(paramInt));
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.chatopttroop", 2, localException.toString());
    }
  }
  
  private void c(String paramString)
  {
    ((BizTroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(21)).e(paramString);
  }
  
  private void c(boolean paramBoolean)
  {
    int i1 = 0;
    if (paramBoolean) {}
    for (Object localObject = "Clk_setcommgrp";; localObject = "Clk_uncommgrp")
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_data", (String)localObject, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
      if (NetworkUtil.a(this) != 0) {
        break;
      }
      QQToast.a(this, 2131560394, 0).b(d());
      o();
      return;
    }
    localObject = (BizTroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(21);
    String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_JavaLangString;
    if (paramBoolean) {}
    for (;;)
    {
      ((BizTroopHandler)localObject).a(str, i1);
      return;
      i1 = 1;
    }
  }
  
  protected long a(String paramString)
  {
    try
    {
      long l1 = Long.valueOf(paramString).longValue();
      return l1;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  protected void a()
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = (LayoutInflater)getSystemService("layout_inflater");
    label2695:
    label2824:
    label3082:
    for (;;)
    {
      Object localObject3;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      try
      {
        localObject1 = View.inflate(this, 2130904027, null);
        localObject3 = (XListView)((View)localObject1).findViewById(2131231313);
        this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)((View)localObject1).findViewById(2131234606));
        ((XListView)localObject3).setVerticalScrollBarEnabled(false);
        ((XListView)localObject3).setDivider(null);
        this.jdField_a_of_type_ArrayOfAndroidViewView = new View[22];
        this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
        localObject4 = new AbsListView.LayoutParams(-1, -2);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject4);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
        ((XListView)localObject3).setAdapter(new XSimpleListAdapter(this.jdField_a_of_type_AndroidWidgetLinearLayout));
        ((XListView)localObject3).setBackgroundResource(2130837729);
        if (this.ao == 2) {
          ((XListView)localObject3).setPadding(((XListView)localObject3).getPaddingLeft(), 0, ((XListView)localObject3).getPaddingLeft(), 0);
        }
        setContentView((View)localObject1);
        setTitle(getString(2131562236));
        h(2131561690);
        int i1 = this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels;
        int i2 = (i1 - getResources().getDimensionPixelSize(2131427553)) / 4;
        localObject1 = View.inflate(this, 2130903361, null);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView = ((AvatarWallView)((View)localObject1).findViewById(2131230904));
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView.setColumnWidth(i2);
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e()) && (this.ao == 1))
        {
          bool = true;
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter = new AvatarWallAdapter(new WeakReference(this), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean, this.jdField_a_of_type_AndroidOsHandler, bool, "Grp_Admin_data");
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(i2);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).setVisibility(8);
          localObject1 = View.inflate(this, 2130903363, null);
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131230976));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          if (!bool) {
            ((View)localObject1).setVisibility(8);
          }
          ((View)localObject1).setVisibility(8);
          this.jdField_b_of_type_AndroidViewView = ((View)localObject1);
          localObject1 = View.inflate(this, 2130903454, null);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          this.jdField_a_of_type_ArrayOfAndroidViewView[15] = localObject1;
          localObject5 = (ImageView)((View)localObject1).findViewById(2131232313);
          localObject6 = (TextView)((View)localObject1).findViewById(2131232315);
          Object localObject7 = (TextView)((View)localObject1).findViewById(2131232640);
          ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131232642);
          localObject3 = ((View)localObject1).findViewById(2131232643);
          localObject4 = ((View)localObject1).findViewById(2131232644);
          Object localObject8 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(4, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, (byte)3);
          localObject8 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a((String)localObject8);
          if (localObject8 != null)
          {
            ((ImageView)localObject5).setImageBitmap((Bitmap)localObject8);
            this.jdField_g_of_type_Boolean = true;
          }
          ((ImageView)localObject5).setTag(Integer.valueOf(29));
          ((ImageView)localObject5).setOnClickListener(this);
          ((TextView)localObject7).setTag(Integer.valueOf(6));
          ((TextView)localObject7).setOnLongClickListener(this);
          ((TextView)localObject6).setTag(Integer.valueOf(6));
          ((TextView)localObject6).setOnLongClickListener(this);
          ((TextView)localObject6).setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_f_of_type_JavaLangString);
          ((TextView)localObject7).setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
          localImageView.setTag(Integer.valueOf(6));
          localImageView.setOnClickListener(this);
          localImageView.setVisibility(8);
          localObject5 = TroopInfoActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
          ((View)localObject4).setTag(Integer.valueOf(17));
          ((View)localObject4).setOnClickListener(this);
          localObject6 = (TextView)((View)localObject4).findViewById(2131230941);
          localObject7 = getResources().getDrawable(2130838522);
          ((Drawable)localObject7).setBounds(0, 0, ((Drawable)localObject7).getMinimumWidth(), ((Drawable)localObject7).getMinimumHeight());
          ((TextView)localObject6).setCompoundDrawables((Drawable)localObject7, null, null, null);
          ((TextView)localObject6).setCompoundDrawablePadding(10);
          if (!TextUtils.isEmpty((CharSequence)localObject5)) {
            break label2695;
          }
          ((View)localObject4).setVisibility(8);
          ((View)localObject4).setVisibility(8);
          ((View)localObject3).setTag(Integer.valueOf(14));
          ((View)localObject3).setOnClickListener(this);
          localObject4 = (TextView)((View)localObject3).findViewById(2131230941);
          localObject5 = getResources().getDrawable(2130838518);
          ((Drawable)localObject5).setBounds(0, 0, ((Drawable)localObject5).getMinimumWidth(), ((Drawable)localObject5).getMinimumHeight());
          ((TextView)localObject4).setCompoundDrawables((Drawable)localObject5, null, null, null);
          ((TextView)localObject4).setCompoundDrawablePadding(10);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString)) {
            break label2711;
          }
          ((View)localObject3).setVisibility(8);
          ((View)localObject3).setVisibility(8);
          ((View)localObject1).setBackgroundResource(2130837879);
          u();
          i1 = (i1 - getResources().getDimensionPixelSize(2131427553) - PublicAccountUtil.a(this, 1.0F) * 3) / 4;
          localObject3 = View.inflate(this, 2130903220, null);
          ((View)localObject3).setBackgroundResource(2130837877);
          this.jdField_a_of_type_ArrayOfAndroidViewView[16] = localObject3;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject3);
          if (this.ao == 2) {
            ((View)localObject3).setVisibility(8);
          }
          localObject1 = new LinearLayout.LayoutParams(i1, PublicAccountUtil.a(this, 65.0F));
          ((LinearLayout.LayoutParams)localObject1).gravity = 17;
          ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
          localObject3 = (LinearLayout)((View)localObject3).findViewById(2131231666);
          localObject4 = View.inflate(this, 2130903455, null);
          ((View)localObject4).setFocusable(true);
          ((View)localObject4).setClickable(true);
          ((LinearLayout)localObject3).setGravity(16);
          localObject5 = (TextView)((View)localObject4).findViewById(2131231000);
          localObject6 = (ImageView)((View)localObject4).findViewById(2131230940);
          ((TextView)localObject5).setText(2131560677);
          ((ImageView)localObject6).setImageResource(2130838519);
          ((View)localObject4).setTag(Integer.valueOf(0));
          ((View)localObject4).setOnClickListener(this);
          localObject4 = new LinearLayout.LayoutParams(PublicAccountUtil.a(this, 1.0F), PublicAccountUtil.a(this, 25.0F));
          ((LinearLayout.LayoutParams)localObject1).gravity = 16;
          View.inflate(this, 2130903457, null);
          localObject5 = View.inflate(this, 2130903455, null);
          ((View)localObject5).setFocusable(true);
          ((View)localObject5).setClickable(true);
          localObject6 = (TextView)((View)localObject5).findViewById(2131231000);
          localObject7 = (ImageView)((View)localObject5).findViewById(2131230940);
          ((TextView)localObject6).setText(2131562109);
          ((ImageView)localObject7).setImageResource(2130838514);
          ((View)localObject5).setTag(Integer.valueOf(2));
          ((View)localObject5).setOnClickListener(this);
          this.jdField_a_of_type_ArrayOfAndroidViewView[2] = localObject5;
          ((LinearLayout)localObject3).addView((View)localObject5, (ViewGroup.LayoutParams)localObject1);
          ((LinearLayout)localObject3).addView(View.inflate(this, 2130903457, null), (ViewGroup.LayoutParams)localObject4);
          localObject5 = View.inflate(this, 2130903455, null);
          ((View)localObject5).setFocusable(true);
          ((View)localObject5).setClickable(true);
          localObject6 = (TextView)((View)localObject5).findViewById(2131231000);
          localObject7 = (ImageView)((View)localObject5).findViewById(2131230940);
          ((TextView)localObject6).setText(2131561636);
          ((ImageView)localObject7).setImageResource(2130838521);
          ((View)localObject5).setTag(Integer.valueOf(1));
          ((View)localObject5).setOnClickListener(this);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
          {
            i1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_h_of_type_Int;
            if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i == 0) {
              break label2732;
            }
            bool = true;
            a((View)localObject5, i1, bool);
          }
          this.jdField_a_of_type_ArrayOfAndroidViewView[1] = localObject5;
          ((LinearLayout)localObject3).addView((View)localObject5, (ViewGroup.LayoutParams)localObject1);
          localObject5 = View.inflate(this, 2130903457, null);
          ((LinearLayout)localObject3).addView((View)localObject5, (ViewGroup.LayoutParams)localObject4);
          ((View)localObject5).setVisibility(8);
          localObject4 = View.inflate(this, 2130903455, null);
          ((View)localObject4).setFocusable(true);
          ((View)localObject4).setClickable(true);
          localObject5 = (TextView)((View)localObject4).findViewById(2131231000);
          localObject6 = (ImageView)((View)localObject4).findViewById(2131230940);
          ((TextView)localObject5).setText(2131562243);
          ((ImageView)localObject6).setImageResource(2130838512);
          ((View)localObject4).setTag(Integer.valueOf(3));
          ((View)localObject4).setOnClickListener(this);
          this.jdField_a_of_type_ArrayOfAndroidViewView[3] = localObject4;
          ((LinearLayout)localObject3).addView((View)localObject4, (ViewGroup.LayoutParams)localObject1);
          ((View)localObject4).setVisibility(8);
          if (this.ao == 1)
          {
            localObject1 = View.inflate(this, 2130903640, null);
            this.jdField_a_of_type_ArrayOfAndroidViewView[4] = localObject1;
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            a(4, 2, (View)localObject1, getString(2131562441), "", true, 0, false);
            ((View)localObject1).setVisibility(8);
          }
          localObject1 = View.inflate(this, 2130903646, null);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          if (this.ao != 1) {
            break label2834;
          }
          localObject1 = View.inflate(this, 2130903638, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[9] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_g_of_type_JavaLangString)) {
            break label2738;
          }
          a(9, 1, (View)localObject1, getString(2131562426), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e(), true);
          localObject1 = View.inflate(this, 2130903643, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[5] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e()) {
            break label2765;
          }
          a(5, 2, (View)localObject1, getString(2131562359), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_h_of_type_JavaLangString, true);
          a((View)localObject1);
          localObject1 = View.inflate(this, 2130903642, null);
          a(8, 3, (FormSimpleItem)((View)localObject1).findViewById(2131233219), getString(2131562345), "", true);
          localObject3 = (TextView)((View)localObject1).findViewById(2131233220);
          ((TextView)localObject3).setText(2131560678);
          this.jdField_a_of_type_ArrayOfAndroidViewView[8] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e()) {
            break label2791;
          }
          ((View)localObject1).setVisibility(0);
          ((TextView)localObject3).setVisibility(8);
          localObject1 = View.inflate(this, 2130903646, null);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = new FormSimpleItem(this);
          a(10, 1, (FormSimpleItem)localObject1, getString(2131562521), "", true);
          this.jdField_a_of_type_ArrayOfAndroidViewView[10] = localObject1;
          ((FormSimpleItem)localObject1).setBottomText(getString(2131562184));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = new FormSimpleItem(this);
          a(23, 2, (FormSimpleItem)localObject1, getString(2131561696), "", true);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = new FormSimpleItem(this);
          a(24, 2, (FormSimpleItem)localObject1, getString(2131563175), "", true);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = new FormSwitchItem(this, null);
          ((FormSwitchItem)localObject1).setBgType(3);
          ((FormSwitchItem)localObject1).setText(getResources().getString(2131562884));
          this.jdField_a_of_type_ArrayOfAndroidViewView[13] = localObject1;
          localObject3 = ((FormSwitchItem)localObject1).a();
          ((Switch)localObject3).setTag(Integer.valueOf(13));
          bool = ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).h(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
          ((Switch)localObject3).setOnCheckedChangeListener(null);
          ((Switch)localObject3).setChecked(bool);
          ((Switch)localObject3).setOnCheckedChangeListener(this);
          ((Switch)localObject3).setContentDescription(getString(2131560395));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = View.inflate(this, 2130903646, null);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = new FormSimpleItem(this);
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_m_of_type_JavaLangString)) {
            break label2801;
          }
          a(20, 1, (FormSimpleItem)localObject1, getString(2131562907), "", true);
          this.jdField_a_of_type_ArrayOfAndroidViewView[20] = localObject1;
          ((FormSimpleItem)localObject1).setBottomText(getString(2131561890));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = View.inflate(this, 2130903641, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[18] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_m_of_type_JavaLangString)) {
            break label2824;
          }
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_m_of_type_JavaLangString;
          b(18, 3, (View)localObject1, getString(2131562235), (CharSequence)localObject3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e());
          localObject1 = View.inflate(this, 2130903646, null);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          if (QLog.isColorLevel()) {
            QLog.i("Q.chatopttroop", 2, "initUI: time = " + (System.currentTimeMillis() - l1));
          }
          this.p.setVisibility(0);
          this.p.setImageResource(2130838009);
          this.p.setContentDescription(getString(2131560650));
          this.p.setOnClickListener(new cjy(this));
          this.p.setVisibility(8);
          localObject1 = View.inflate(this, 2130903646, null);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject3 = View.inflate(this, 2130903637, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[11] = localObject3;
          ((View)localObject3).setTag(Integer.valueOf(11));
          ((View)localObject3).setOnClickListener(this);
          ((Button)localObject3).setText(2131561952);
          localObject1 = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject1).rightMargin = ((int)(26.0F * this.jdField_c_of_type_Float));
          ((LinearLayout.LayoutParams)localObject1).leftMargin = ((int)(26.0F * this.jdField_c_of_type_Float));
          ((LinearLayout.LayoutParams)localObject1).gravity = 17;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
          localObject3 = View.inflate(this, 2130903637, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[12] = localObject3;
          ((View)localObject3).setTag(Integer.valueOf(12));
          ((View)localObject3).setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
          localObject3 = View.inflate(this, 2130903646, null);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject3);
          a(false, false);
          if (this.ao == 2)
          {
            localObject3 = View.inflate(this, 2130903646, null);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject3);
            localObject3 = View.inflate(this, 2130903637, null);
            ((View)localObject3).setOnClickListener(this);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
            if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean) {
              break label3082;
            }
            ((View)localObject3).setTag(Integer.valueOf(27));
            ((Button)localObject3).setText(2131561794);
            localObject1 = View.inflate(this, 2130903646, null);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          }
          a(false);
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        finish();
        localOutOfMemoryError.printStackTrace();
        return;
      }
      boolean bool = false;
      continue;
      ((View)localObject4).setVisibility(0);
      ((TextView)localObject6).setText((CharSequence)localObject5);
      continue;
      label2711:
      ((View)localObject3).setVisibility(0);
      ((TextView)localObject4).setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString);
      continue;
      label2732:
      bool = false;
      continue;
      label2738:
      a(9, 1, localOutOfMemoryError, getString(2131562426), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_g_of_type_JavaLangString, true);
      continue;
      label2765:
      a(5, 3, localOutOfMemoryError, getString(2131562359), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_h_of_type_JavaLangString, true);
      continue;
      label2791:
      localOutOfMemoryError.setVisibility(8);
      continue;
      label2801:
      a(20, 0, localOutOfMemoryError, getString(2131562907), "", true);
      continue;
      localOutOfMemoryError.setVisibility(8);
      continue;
      label2834:
      if (this.ao == 2)
      {
        Object localObject2 = View.inflate(this, 2130903643, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[19] = localObject2;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
        a(19, 1, (View)localObject2, getString(2131562198), getString(2131561643), true);
        a((View)localObject2);
        localObject3 = View.inflate(this, 2130903644, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[21] = localObject3;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject3);
        localObject2 = "";
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_h_of_type_JavaLangString != null) {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_h_of_type_JavaLangString;
        }
        a(21, 3, (View)localObject3, getString(2131562359), (CharSequence)localObject2, false);
        f();
        localObject2 = View.inflate(this, 2130903646, null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
        localObject2 = View.inflate(this, 2130903641, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[18] = localObject2;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_m_of_type_JavaLangString))
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_m_of_type_JavaLangString;
          b(18, 0, (View)localObject2, getString(2131562235), (CharSequence)localObject3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e());
        }
        else
        {
          ((View)localObject2).setVisibility(8);
          continue;
          ((View)localObject3).setTag(Integer.valueOf(28));
          ((Button)localObject3).setText(2131562262);
        }
      }
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[21];
    if (localObject == null) {}
    String str;
    do
    {
      return;
      str = String.format(getString(2131561528), new Object[] { Integer.valueOf(paramInt1) });
      localObject = (TextView)((View)localObject).findViewById(2131231506);
    } while (localObject == null);
    ((TextView)localObject).setText(str);
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramView, paramString, paramBoolean);
    paramString = (TextView)paramView.findViewById(2131231506);
    paramString.setEditableFactory(QQTextBuilder.a);
    if (paramCharSequence == null) {}
    for (paramView = "";; paramView = new QQText(paramCharSequence, 3))
    {
      paramString.setText(paramView);
      return;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, CharSequence paramCharSequence, boolean paramBoolean1, int paramInt3, boolean paramBoolean2)
  {
    a(paramInt1, paramInt2, paramView, paramString, paramBoolean1);
    a(paramView, paramInt3, paramBoolean2);
    paramString = (TextView)paramView.findViewById(2131231506);
    paramString.setEditableFactory(QQTextBuilder.a);
    if (paramCharSequence == null) {}
    for (paramView = "";; paramView = new QQText(paramCharSequence, 11))
    {
      paramString.setText(paramView);
      return;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this);
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      TextView localTextView = (TextView)paramView.findViewById(2131230941);
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      localTextView.setText(str);
      a(paramInt1, paramView, paramBoolean);
      return;
      paramView.setTag(null);
      paramView.setOnClickListener(null);
      break;
      paramView.setBackgroundResource(2130837875);
      continue;
      paramView.setBackgroundResource(2130837880);
      continue;
      paramView.setBackgroundResource(2130837879);
      continue;
      paramView.setBackgroundResource(2130837877);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, FormSimpleItem paramFormSimpleItem, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramFormSimpleItem.setTag(Integer.valueOf(paramInt1));
      paramFormSimpleItem.setOnClickListener(this);
      paramFormSimpleItem.a(true);
      paramFormSimpleItem.setBgType(paramInt2);
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      paramFormSimpleItem.setLeftText(str);
      paramFormSimpleItem.setLeftTextColor(0);
      paramFormSimpleItem.b().setEditableFactory(QQTextBuilder.a);
      if (paramCharSequence != null) {
        break label98;
      }
    }
    label98:
    for (paramString = "";; paramString = new QQText(paramCharSequence, 3))
    {
      paramFormSimpleItem.setRightText(paramString);
      return;
      paramFormSimpleItem.setTag(null);
      paramFormSimpleItem.setOnClickListener(null);
      paramFormSimpleItem.a(false);
      break;
    }
  }
  
  protected void a(int paramInt, Intent paramIntent)
  {
    if (paramInt != -1) {}
    do
    {
      do
      {
        return;
      } while (paramIntent == null);
      if (paramIntent.getBooleanExtra("isNeedFinish", false))
      {
        finish();
        return;
      }
    } while (paramIntent.getExtras() == null);
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString = paramIntent.getStringExtra("location");
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int = paramIntent.getIntExtra("lat", 0);
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int = paramIntent.getIntExtra("lon", 0);
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_f_of_type_JavaLangString = paramIntent.getStringExtra("name");
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long = paramIntent.getLongExtra("class", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_m_of_type_JavaLangString = paramIntent.getStringExtra("intro");
    k();
  }
  
  protected void a(int paramInt, View paramView, boolean paramBoolean)
  {
    int i1 = 0;
    if (paramView == null) {
      return;
    }
    boolean bool = paramBoolean;
    if (this.ao == 2)
    {
      bool = paramBoolean;
      if (18 == paramInt) {
        bool = false;
      }
    }
    paramView = paramView.findViewById(2131232620);
    if (bool) {}
    for (paramInt = i1;; paramInt = 8)
    {
      paramView.setVisibility(paramInt);
      paramView.setVisibility(8);
      return;
    }
  }
  
  public void a(int paramInt, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "updateDefaultItemView(), tag = " + paramInt + ", info = " + paramCharSequence + ", bShowArrow = " + paramBoolean);
    }
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ArrayOfAndroidViewView.length)) {}
    for (View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt];; localView = null)
    {
      TextView localTextView;
      if (localView != null)
      {
        localTextView = (TextView)localView.findViewById(2131231506);
        if (paramInt != 18) {
          break label163;
        }
        if (!TextUtils.isEmpty(paramCharSequence)) {
          break label139;
        }
        localView.setVisibility(8);
        if (!paramBoolean) {
          break label199;
        }
        localView.setTag(Integer.valueOf(paramInt));
        localView.setOnClickListener(this);
      }
      for (;;)
      {
        a(paramInt, localView, paramBoolean);
        return;
        label139:
        localView.setVisibility(0);
        localTextView.setText(new QQText(paramCharSequence, 11));
        break;
        label163:
        localView.setVisibility(0);
        if (paramCharSequence == null) {}
        for (paramCharSequence = "";; paramCharSequence = new QQText(paramCharSequence, 3))
        {
          localTextView.setText(paramCharSequence);
          break;
        }
        label199:
        localView.setTag(null);
        localView.setOnClickListener(null);
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      int i2 = this.jdField_b_of_type_JavaUtilList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ImageView localImageView = (ImageView)this.jdField_b_of_type_JavaUtilList.get(i1);
        String str = (String)localImageView.getTag();
        try
        {
          long l1 = Long.valueOf(str).longValue();
          if (l1 == paramLong)
          {
            localImageView.setBackgroundDrawable(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(Long.toString(paramLong)));
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          i1 += 1;
        }
      }
    }
  }
  
  /* Error */
  public void a(BatchResponse paramBatchResponse)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: getfield 1389	KQQ/BatchResponse:result	I
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: new 1391	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   15: dup
    //   16: invokespecial 1392	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   19: astore 10
    //   21: aload 10
    //   23: aload_1
    //   24: getfield 1396	KQQ/BatchResponse:buffer	[B
    //   27: checkcast 1397	[B
    //   30: invokevirtual 1401	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   33: pop
    //   34: aload_1
    //   35: getfield 1404	KQQ/BatchResponse:seq	I
    //   38: ifne +199 -> 237
    //   41: aload 10
    //   43: ifnull +194 -> 237
    //   46: aload 10
    //   48: getfield 1408	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   51: invokevirtual 1413	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   54: ifeq +183 -> 237
    //   57: aload 10
    //   59: getfield 1408	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   62: invokevirtual 1416	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   65: invokevirtual 1422	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   68: astore 9
    //   70: new 1424	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   73: dup
    //   74: invokespecial 1425	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   77: astore 8
    //   79: aload 8
    //   81: aload 9
    //   83: invokevirtual 1426	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   86: pop
    //   87: aconst_null
    //   88: astore 9
    //   90: aload 8
    //   92: getfield 1430	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   95: invokevirtual 1435	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   98: astore 11
    //   100: aload 11
    //   102: ifnonnull +57 -> 159
    //   105: iconst_0
    //   106: istore_2
    //   107: goto +1438 -> 1545
    //   110: aload 9
    //   112: ifnonnull +125 -> 237
    //   115: iload_3
    //   116: iload_2
    //   117: if_icmpge +120 -> 237
    //   120: aload 11
    //   122: iload_3
    //   123: invokeinterface 1367 2 0
    //   128: checkcast 1437	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   131: astore 12
    //   133: aload 12
    //   135: ifnonnull +35 -> 170
    //   138: aload 9
    //   140: astore 8
    //   142: iload_3
    //   143: iconst_1
    //   144: iadd
    //   145: istore_3
    //   146: aload 8
    //   148: astore 9
    //   150: goto -40 -> 110
    //   153: astore_1
    //   154: aload_1
    //   155: invokevirtual 1438	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   158: return
    //   159: aload 11
    //   161: invokeinterface 1363 1 0
    //   166: istore_2
    //   167: goto +1378 -> 1545
    //   170: aload 12
    //   172: getfield 1442	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   175: invokevirtual 1446	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   178: istore 4
    //   180: iload 4
    //   182: bipush 72
    //   184: if_icmpne +419 -> 603
    //   187: iload_3
    //   188: ifne +415 -> 603
    //   191: aload_0
    //   192: getfield 185	com/tencent/mobileqq/activity/ChatSettingForTroop:ao	I
    //   195: iconst_1
    //   196: if_icmpne +377 -> 573
    //   199: aload_0
    //   200: ldc_w 1447
    //   203: iconst_1
    //   204: invokestatic 866	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   207: invokevirtual 1449	com/tencent/mobileqq/widget/QQToast:a	()V
    //   210: aload 9
    //   212: astore 8
    //   214: goto -72 -> 142
    //   217: astore 8
    //   219: invokestatic 574	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   222: ifeq +15 -> 237
    //   225: ldc_w 1451
    //   228: iconst_2
    //   229: aload 8
    //   231: invokevirtual 577	java/lang/Exception:toString	()Ljava/lang/String;
    //   234: invokestatic 580	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: aload_1
    //   238: getfield 1404	KQQ/BatchResponse:seq	I
    //   241: iconst_1
    //   242: if_icmpne +81 -> 323
    //   245: aload 10
    //   247: ifnull +76 -> 323
    //   250: aload 10
    //   252: getfield 1408	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   255: invokevirtual 1413	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   258: ifeq +65 -> 323
    //   261: aload 10
    //   263: getfield 1408	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   266: invokevirtual 1416	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   269: invokevirtual 1422	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   272: astore 8
    //   274: new 1453	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody
    //   277: dup
    //   278: invokespecial 1454	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:<init>	()V
    //   281: astore 9
    //   283: aload 9
    //   285: aload 8
    //   287: invokevirtual 1455	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   290: pop
    //   291: aload 9
    //   293: getfield 1458	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   296: ifnull +27 -> 323
    //   299: aload_0
    //   300: aload 9
    //   302: getfield 1458	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   305: invokevirtual 1435	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   308: invokevirtual 1461	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Ljava/util/List;)V
    //   311: aload_0
    //   312: aload 9
    //   314: getfield 1458	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   317: invokevirtual 1435	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   320: putfield 1463	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   323: aload_1
    //   324: getfield 1404	KQQ/BatchResponse:seq	I
    //   327: iconst_2
    //   328: if_icmpne -317 -> 11
    //   331: aload 10
    //   333: ifnull -322 -> 11
    //   336: aload 10
    //   338: getfield 1408	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   341: invokevirtual 1413	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   344: ifeq -333 -> 11
    //   347: aload 10
    //   349: getfield 1408	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   352: invokevirtual 1416	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   355: invokevirtual 1422	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   358: astore_1
    //   359: new 1465	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody
    //   362: dup
    //   363: invokespecial 1466	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:<init>	()V
    //   366: astore 8
    //   368: aload 8
    //   370: aload_1
    //   371: invokevirtual 1467	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   374: pop
    //   375: aload 8
    //   377: getfield 1470	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   380: invokevirtual 1435	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   383: astore_1
    //   384: aload 8
    //   386: getfield 1473	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_member_level_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   389: invokevirtual 1435	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   392: astore 9
    //   394: aload 8
    //   396: getfield 1476	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   399: invokevirtual 1446	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   402: istore_2
    //   403: aload_0
    //   404: getfield 280	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   407: invokevirtual 1479	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   410: lstore 6
    //   412: iload_2
    //   413: ifeq -402 -> 11
    //   416: aload_1
    //   417: ifnull -406 -> 11
    //   420: aload_1
    //   421: invokeinterface 1363 1 0
    //   426: ifle -415 -> 11
    //   429: aload 9
    //   431: ifnull -420 -> 11
    //   434: aload 9
    //   436: invokeinterface 1363 1 0
    //   441: ifle -430 -> 11
    //   444: aload 9
    //   446: invokeinterface 1363 1 0
    //   451: istore_3
    //   452: iconst_0
    //   453: istore_2
    //   454: iload_2
    //   455: iload_3
    //   456: if_icmpge -445 -> 11
    //   459: aload 9
    //   461: iload_2
    //   462: invokeinterface 1367 2 0
    //   467: checkcast 1481	tencent/im/oidb/cmd0x787/oidb_0x787$MemberLevelInfo
    //   470: astore 8
    //   472: aload 8
    //   474: ifnull +1058 -> 1532
    //   477: lload 6
    //   479: aload 8
    //   481: getfield 1485	tencent/im/oidb/cmd0x787/oidb_0x787$MemberLevelInfo:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   484: invokevirtual 1489	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   487: lcmp
    //   488: ifne +1044 -> 1532
    //   491: aload 8
    //   493: getfield 1492	tencent/im/oidb/cmd0x787/oidb_0x787$MemberLevelInfo:uint32_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   496: invokevirtual 1446	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   499: istore_3
    //   500: aload_1
    //   501: invokeinterface 1363 1 0
    //   506: istore 4
    //   508: iconst_0
    //   509: istore_2
    //   510: iload_2
    //   511: iload 4
    //   513: if_icmpge -502 -> 11
    //   516: aload_1
    //   517: iload_2
    //   518: invokeinterface 1367 2 0
    //   523: checkcast 1494	tencent/im/oidb/cmd0x787/oidb_0x787$LevelName
    //   526: astore 8
    //   528: aload 8
    //   530: getfield 1495	tencent/im/oidb/cmd0x787/oidb_0x787$LevelName:uint32_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   533: invokevirtual 1446	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   536: iload_3
    //   537: if_icmpne +29 -> 566
    //   540: aload 8
    //   542: getfield 1498	tencent/im/oidb/cmd0x787/oidb_0x787$LevelName:str_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   545: invokevirtual 1413	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   548: ifeq +18 -> 566
    //   551: aload_0
    //   552: aload 8
    //   554: getfield 1498	tencent/im/oidb/cmd0x787/oidb_0x787$LevelName:str_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   557: invokevirtual 1416	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   560: invokevirtual 1501	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   563: invokevirtual 1503	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Ljava/lang/String;)V
    //   566: iload_2
    //   567: iconst_1
    //   568: iadd
    //   569: istore_2
    //   570: goto -60 -> 510
    //   573: aload 9
    //   575: astore 8
    //   577: aload_0
    //   578: getfield 185	com/tencent/mobileqq/activity/ChatSettingForTroop:ao	I
    //   581: iconst_2
    //   582: if_icmpne -440 -> 142
    //   585: aload_0
    //   586: ldc_w 1504
    //   589: iconst_1
    //   590: invokestatic 866	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   593: invokevirtual 1449	com/tencent/mobileqq/widget/QQToast:a	()V
    //   596: aload 9
    //   598: astore 8
    //   600: goto -458 -> 142
    //   603: aload 9
    //   605: astore 8
    //   607: iload 4
    //   609: ifne -467 -> 142
    //   612: aload 9
    //   614: astore 8
    //   616: aload 12
    //   618: getfield 1508	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   621: invokevirtual 1511	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   624: ifeq -482 -> 142
    //   627: aload 12
    //   629: getfield 1508	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   632: invokevirtual 1514	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   635: checkcast 1510	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   638: astore 9
    //   640: aload 9
    //   642: astore 8
    //   644: aload 9
    //   646: ifnull -504 -> 142
    //   649: aload_0
    //   650: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   653: ifnull +597 -> 1250
    //   656: aload_0
    //   657: getfield 928	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   660: bipush 15
    //   662: aaload
    //   663: astore 12
    //   665: aload 9
    //   667: getfield 1517	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   670: invokevirtual 1413	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   673: ifeq +42 -> 715
    //   676: aload_0
    //   677: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   680: aload 9
    //   682: getfield 1517	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   685: invokevirtual 1416	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   688: invokevirtual 1501	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   691: putfield 297	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   694: aload 12
    //   696: ldc_w 1040
    //   699: invokevirtual 912	android/view/View:findViewById	(I)Landroid/view/View;
    //   702: checkcast 1031	android/widget/TextView
    //   705: aload_0
    //   706: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   709: getfield 297	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   712: invokevirtual 1069	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   715: aload_0
    //   716: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   719: aload 9
    //   721: getfield 1520	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_grade	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   724: invokevirtual 1446	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   727: putfield 1522	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_Int	I
    //   730: aload_0
    //   731: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   734: aload 9
    //   736: getfield 1525	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:rpt_tag_record	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   739: invokevirtual 1435	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   742: invokestatic 1529	com/tencent/mobileqq/data/TroopInfo:setTags	(Ljava/util/List;)Ljava/lang/String;
    //   745: invokestatic 1533	com/tencent/mobileqq/data/TroopInfo:getTags	(Ljava/lang/String;)Ljava/util/List;
    //   748: putfield 1534	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   751: aload_0
    //   752: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   755: aload 9
    //   757: getfield 1537	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_active_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   760: invokevirtual 1446	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   763: putfield 1539	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_n_of_type_Int	I
    //   766: aload_0
    //   767: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   770: aload 9
    //   772: getfield 1542	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flag_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   775: invokevirtual 1446	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   778: i2l
    //   779: putfield 1544	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_b_of_type_Long	J
    //   782: aload_0
    //   783: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   786: aload 9
    //   788: getfield 1547	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_certification_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   791: invokevirtual 1446	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   794: i2l
    //   795: putfield 1549	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_Long	J
    //   798: aload_0
    //   799: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   802: aload 9
    //   804: getfield 1552	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_class_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   807: invokevirtual 1446	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   810: i2l
    //   811: putfield 833	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Long	J
    //   814: aload_0
    //   815: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   818: aload 9
    //   820: getfield 1555	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   823: invokevirtual 1446	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   826: putfield 1557	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_Int	I
    //   829: aload_0
    //   830: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   833: aload 9
    //   835: getfield 1560	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_type_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   838: invokevirtual 1446	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   841: putfield 1562	com/tencent/mobileqq/troopinfo/TroopInfoData:q	I
    //   844: aload_0
    //   845: invokevirtual 1564	com/tencent/mobileqq/activity/ChatSettingForTroop:w	()V
    //   848: aload 9
    //   850: getfield 1567	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_class_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   853: invokevirtual 1413	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   856: ifeq +42 -> 898
    //   859: aload_0
    //   860: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   863: aload 9
    //   865: getfield 1567	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_class_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   868: invokevirtual 1416	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   871: invokevirtual 1501	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   874: putfield 1569	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   877: aload_0
    //   878: getfield 726	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   881: ifnull +17 -> 898
    //   884: aload_0
    //   885: getfield 726	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   888: aload_0
    //   889: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   892: getfield 1569	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   895: putfield 1572	com/tencent/mobileqq/data/TroopInfo:mGroupClassExtText	Ljava/lang/String;
    //   898: aload_0
    //   899: aload_0
    //   900: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   903: invokestatic 1075	com/tencent/mobileqq/activity/TroopInfoActivity:a	(Landroid/content/Context;Lcom/tencent/mobileqq/troopinfo/TroopInfoData;)Ljava/lang/String;
    //   906: astore 8
    //   908: aload 12
    //   910: ldc_w 1044
    //   913: invokevirtual 912	android/view/View:findViewById	(I)Landroid/view/View;
    //   916: astore 12
    //   918: aload 8
    //   920: invokestatic 303	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   923: ifeq +488 -> 1411
    //   926: aload 12
    //   928: bipush 8
    //   930: invokevirtual 1027	android/view/View:setVisibility	(I)V
    //   933: aload 12
    //   935: bipush 8
    //   937: invokevirtual 1027	android/view/View:setVisibility	(I)V
    //   940: aload 9
    //   942: getfield 1576	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:group_geo_info	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo;
    //   945: invokevirtual 1579	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   948: checkcast 1578	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo
    //   951: astore 8
    //   953: aload 8
    //   955: getfield 1582	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo:bytes_geocontent	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   958: invokevirtual 1416	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   961: invokevirtual 1501	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   964: astore 12
    //   966: aload 8
    //   968: getfield 1586	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo:int64_latitude	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   971: invokevirtual 1589	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   974: l2i
    //   975: istore 4
    //   977: aload 8
    //   979: getfield 1592	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo:int64_longitude	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   982: invokevirtual 1589	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   985: l2i
    //   986: istore 5
    //   988: aload 12
    //   990: invokestatic 303	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   993: ifne +12 -> 1005
    //   996: aload_0
    //   997: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1000: aload 12
    //   1002: putfield 1104	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   1005: iload 4
    //   1007: ifeq +12 -> 1019
    //   1010: aload_0
    //   1011: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1014: iload 4
    //   1016: putfield 1329	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_d_of_type_Int	I
    //   1019: iload 5
    //   1021: ifeq +12 -> 1033
    //   1024: aload_0
    //   1025: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1028: iload 5
    //   1030: putfield 1333	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_e_of_type_Int	I
    //   1033: aload_0
    //   1034: invokevirtual 1343	com/tencent/mobileqq/activity/ChatSettingForTroop:k	()V
    //   1037: aload 9
    //   1039: getfield 1595	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_finger_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1042: invokevirtual 1413	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1045: ifeq +391 -> 1436
    //   1048: aload_0
    //   1049: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1052: aload 9
    //   1054: getfield 1595	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_finger_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1057: invokevirtual 1416	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1060: invokevirtual 1501	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1063: putfield 1597	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1066: aload 9
    //   1068: getfield 1600	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_rich_finger_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1071: invokevirtual 1413	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1074: ifeq +375 -> 1449
    //   1077: aload_0
    //   1078: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1081: aload 9
    //   1083: getfield 1600	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_rich_finger_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1086: invokevirtual 1416	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1089: invokevirtual 1501	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1092: putfield 839	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   1095: aload_0
    //   1096: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1099: getfield 839	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   1102: invokestatic 303	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1105: ifeq +357 -> 1462
    //   1108: aload_0
    //   1109: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1112: aload_0
    //   1113: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1116: getfield 1597	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1119: putfield 839	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   1122: aload_0
    //   1123: getfield 928	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   1126: bipush 18
    //   1128: aaload
    //   1129: astore 8
    //   1131: aload 8
    //   1133: ifnull +52 -> 1185
    //   1136: aload_0
    //   1137: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1140: getfield 839	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   1143: invokestatic 303	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1146: ifne +353 -> 1499
    //   1149: aload 8
    //   1151: iconst_0
    //   1152: invokevirtual 1027	android/view/View:setVisibility	(I)V
    //   1155: aload_0
    //   1156: bipush 18
    //   1158: iconst_0
    //   1159: aload 8
    //   1161: aload_0
    //   1162: ldc_w 1231
    //   1165: invokevirtual 346	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   1168: aload_0
    //   1169: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1172: getfield 839	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   1175: aload_0
    //   1176: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1179: invokevirtual 1004	com/tencent/mobileqq/troopinfo/TroopInfoData:e	()Z
    //   1182: invokevirtual 1233	com/tencent/mobileqq/activity/ChatSettingForTroop:b	(IILandroid/view/View;Ljava/lang/String;Ljava/lang/CharSequence;Z)V
    //   1185: aload_0
    //   1186: invokevirtual 1602	com/tencent/mobileqq/activity/ChatSettingForTroop:e	()V
    //   1189: aload 9
    //   1191: getfield 1542	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flag_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1194: invokevirtual 1603	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1197: ifeq +18 -> 1215
    //   1200: aload_0
    //   1201: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1204: aload 9
    //   1206: getfield 1542	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flag_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1209: invokevirtual 1446	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1212: putfield 1605	com/tencent/mobileqq/troopinfo/TroopInfoData:o	I
    //   1215: aload_0
    //   1216: getfield 726	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1219: ifnull +31 -> 1250
    //   1222: aload_0
    //   1223: getfield 726	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1226: aload_0
    //   1227: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1230: getfield 1597	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1233: putfield 1608	com/tencent/mobileqq/data/TroopInfo:fingertroopmemo	Ljava/lang/String;
    //   1236: aload_0
    //   1237: getfield 726	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1240: aload_0
    //   1241: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1244: getfield 839	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   1247: putfield 1611	com/tencent/mobileqq/data/TroopInfo:mRichFingerMemo	Ljava/lang/String;
    //   1250: aload 9
    //   1252: getfield 1614	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_max_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1255: invokevirtual 1603	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1258: ifeq +93 -> 1351
    //   1261: aload 9
    //   1263: getfield 1614	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_max_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1266: invokevirtual 1446	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1269: ifle +82 -> 1351
    //   1272: aload 9
    //   1274: getfield 1555	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1277: invokevirtual 1603	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1280: ifeq +71 -> 1351
    //   1283: aload 9
    //   1285: getfield 1555	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1288: invokevirtual 1446	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1291: ifle +60 -> 1351
    //   1294: aload_0
    //   1295: getfield 726	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1298: ifnull +33 -> 1331
    //   1301: aload_0
    //   1302: getfield 726	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1305: aload 9
    //   1307: getfield 1614	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_max_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1310: invokevirtual 1446	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1313: putfield 1617	com/tencent/mobileqq/data/TroopInfo:wMemberMax	I
    //   1316: aload_0
    //   1317: getfield 726	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1320: aload 9
    //   1322: getfield 1555	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1325: invokevirtual 1446	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1328: putfield 1620	com/tencent/mobileqq/data/TroopInfo:wMemberNum	I
    //   1331: aload_0
    //   1332: aload 9
    //   1334: getfield 1555	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1337: invokevirtual 1446	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1340: aload 9
    //   1342: getfield 1614	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_max_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1345: invokevirtual 1446	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1348: invokevirtual 1621	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(II)V
    //   1351: aload_0
    //   1352: invokevirtual 1108	com/tencent/mobileqq/activity/ChatSettingForTroop:u	()V
    //   1355: aload 9
    //   1357: astore 8
    //   1359: aload 9
    //   1361: getfield 1624	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint64_group_owner	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1364: invokevirtual 1625	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   1367: ifeq -1225 -> 142
    //   1370: aload_0
    //   1371: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1374: new 808	java/lang/StringBuilder
    //   1377: dup
    //   1378: invokespecial 809	java/lang/StringBuilder:<init>	()V
    //   1381: ldc_w 286
    //   1384: invokevirtual 813	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1387: aload 9
    //   1389: getfield 1624	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint64_group_owner	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1392: invokevirtual 1489	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1395: invokevirtual 1238	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1398: invokevirtual 818	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1401: putfield 1627	com/tencent/mobileqq/troopinfo/TroopInfoData:p	Ljava/lang/String;
    //   1404: aload 9
    //   1406: astore 8
    //   1408: goto -1266 -> 142
    //   1411: aload 12
    //   1413: iconst_0
    //   1414: invokevirtual 1027	android/view/View:setVisibility	(I)V
    //   1417: aload 12
    //   1419: ldc_w 1078
    //   1422: invokevirtual 912	android/view/View:findViewById	(I)Landroid/view/View;
    //   1425: checkcast 1031	android/widget/TextView
    //   1428: aload 8
    //   1430: invokevirtual 1069	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1433: goto -500 -> 933
    //   1436: aload_0
    //   1437: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1440: ldc_w 286
    //   1443: putfield 1597	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1446: goto -380 -> 1066
    //   1449: aload_0
    //   1450: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1453: ldc_w 286
    //   1456: putfield 839	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   1459: goto -364 -> 1095
    //   1462: aload_0
    //   1463: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1466: aload_0
    //   1467: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1470: getfield 839	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   1473: invokestatic 1631	com/tencent/biz/common/util/HttpUtil:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1476: putfield 839	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   1479: aload_0
    //   1480: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1483: aload_0
    //   1484: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1487: getfield 839	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   1490: invokestatic 1633	com/tencent/biz/common/util/HttpUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1493: putfield 839	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   1496: goto -374 -> 1122
    //   1499: aload 8
    //   1501: bipush 8
    //   1503: invokevirtual 1027	android/view/View:setVisibility	(I)V
    //   1506: goto -321 -> 1185
    //   1509: astore 8
    //   1511: invokestatic 574	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1514: ifeq -1191 -> 323
    //   1517: ldc_w 1451
    //   1520: iconst_2
    //   1521: aload 8
    //   1523: invokevirtual 577	java/lang/Exception:toString	()Ljava/lang/String;
    //   1526: invokestatic 580	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1529: goto -1206 -> 323
    //   1532: iload_2
    //   1533: iconst_1
    //   1534: iadd
    //   1535: istore_2
    //   1536: goto -1082 -> 454
    //   1539: astore_1
    //   1540: aload_1
    //   1541: invokevirtual 1381	java/lang/Exception:printStackTrace	()V
    //   1544: return
    //   1545: iconst_0
    //   1546: istore_3
    //   1547: goto -1437 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1550	0	this	ChatSettingForTroop
    //   0	1550	1	paramBatchResponse	BatchResponse
    //   106	1430	2	i1	int
    //   115	1432	3	i2	int
    //   178	837	4	i3	int
    //   986	43	5	i4	int
    //   410	68	6	l1	long
    //   77	136	8	localObject1	Object
    //   217	13	8	localException1	Exception
    //   272	1228	8	localObject2	Object
    //   1509	13	8	localException2	Exception
    //   68	1337	9	localObject3	Object
    //   19	329	10	localOIDBSSOPkg	tencent.im.oidb.oidb_sso.OIDBSSOPkg
    //   98	62	11	localList	List
    //   131	1287	12	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   21	34	153	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   70	87	217	java/lang/Exception
    //   90	100	217	java/lang/Exception
    //   120	133	217	java/lang/Exception
    //   159	167	217	java/lang/Exception
    //   170	180	217	java/lang/Exception
    //   191	210	217	java/lang/Exception
    //   577	596	217	java/lang/Exception
    //   616	640	217	java/lang/Exception
    //   649	715	217	java/lang/Exception
    //   715	898	217	java/lang/Exception
    //   898	933	217	java/lang/Exception
    //   933	1005	217	java/lang/Exception
    //   1010	1019	217	java/lang/Exception
    //   1024	1033	217	java/lang/Exception
    //   1033	1066	217	java/lang/Exception
    //   1066	1095	217	java/lang/Exception
    //   1095	1122	217	java/lang/Exception
    //   1122	1131	217	java/lang/Exception
    //   1136	1185	217	java/lang/Exception
    //   1185	1215	217	java/lang/Exception
    //   1215	1250	217	java/lang/Exception
    //   1250	1331	217	java/lang/Exception
    //   1331	1351	217	java/lang/Exception
    //   1351	1355	217	java/lang/Exception
    //   1359	1404	217	java/lang/Exception
    //   1411	1433	217	java/lang/Exception
    //   1436	1446	217	java/lang/Exception
    //   1449	1459	217	java/lang/Exception
    //   1462	1496	217	java/lang/Exception
    //   1499	1506	217	java/lang/Exception
    //   274	323	1509	java/lang/Exception
    //   359	412	1539	java/lang/Exception
    //   420	429	1539	java/lang/Exception
    //   434	452	1539	java/lang/Exception
    //   459	472	1539	java/lang/Exception
    //   477	508	1539	java/lang/Exception
    //   516	566	1539	java/lang/Exception
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131232428));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131232429));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131232430));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131232431));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131232432));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131233222));
    this.jdField_b_of_type_JavaUtilList = new ArrayList(6);
    this.jdField_b_of_type_JavaUtilList.add(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_b_of_type_JavaUtilList.add(this.jdField_b_of_type_AndroidWidgetImageView);
    this.jdField_b_of_type_JavaUtilList.add(this.jdField_c_of_type_AndroidWidgetImageView);
    this.jdField_b_of_type_JavaUtilList.add(this.jdField_d_of_type_AndroidWidgetImageView);
    this.jdField_b_of_type_JavaUtilList.add(this.jdField_e_of_type_AndroidWidgetImageView);
    this.jdField_b_of_type_JavaUtilList.add(this.jdField_f_of_type_AndroidWidgetImageView);
  }
  
  public void a(View paramView, int paramInt)
  {
    View localView = paramView.findViewById(2131232645);
    paramView = (TextView)paramView.findViewById(2131232646);
    if ((this.ao == 2) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean))
    {
      localView.setVisibility(8);
      if (paramInt > 99)
      {
        paramView.setVisibility(0);
        paramView.setText("99+");
      }
    }
    else
    {
      return;
    }
    if (paramInt > 0)
    {
      paramView.setVisibility(0);
      paramView.setText(paramInt + "");
      return;
    }
    paramView.setText("");
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    TextView localTextView = (TextView)paramView.findViewById(2131232645);
    if (paramInt > 0)
    {
      localTextView.setVisibility(0);
      paramView = Integer.toString(paramInt);
      if (paramInt > 99) {
        paramView = "99+";
      }
      localTextView.setText(paramView);
      localTextView.setBackgroundResource(2130838523);
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      return;
    }
    if (paramBoolean)
    {
      localTextView.setVisibility(0);
      localTextView.setText("");
      localTextView.setBackgroundResource(0);
      localTextView.setCompoundDrawablesWithIntrinsicBounds(2130840208, 0, 0, 0);
      return;
    }
    localTextView.setVisibility(4);
    localTextView.setText("");
    localTextView.setBackgroundResource(0);
    localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
  
  public void a(View paramView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramView = (LinearLayout)paramView.findViewById(2131231118);
    } while (paramView == null);
    paramView.setVisibility(0);
  }
  
  protected void a(View paramView, List paramList)
  {
    if ((paramView == null) || (paramList == null)) {}
    LinearLayout localLinearLayout;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "updateTroopPhoto|urls: " + paramList);
      }
      localLinearLayout = (LinearLayout)paramView.findViewById(2131231118);
    } while ((localLinearLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null));
    Object localObject1 = null;
    String str1 = MD5.toMD5(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    int i2 = paramList.size();
    int i1 = getResources().getDimensionPixelOffset(2131427521);
    int i3 = getResources().getDimensionPixelOffset(2131427522);
    int i4 = getResources().getDimensionPixelOffset(2131427525);
    i3 = (this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels - i1 - i3 - 4 * i4 - Utils.a(this, 10.0F) * 2) / 4;
    i1 = 0;
    URLImageView localURLImageView;
    if (i1 < 4)
    {
      localURLImageView = (URLImageView)localLinearLayout.findViewById(2131233225 + i1);
      if (localURLImageView == null) {}
      for (;;)
      {
        i1 += 1;
        break;
        String str2;
        if (i1 >= i2)
        {
          localURLImageView.setVisibility(4);
        }
        else
        {
          localObject2 = (String)paramList.get(i1);
          str2 = str1 + "_" + MD5.toMD5((String)localObject2);
          str2 = AppConstants.bg + str2;
          if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(getResources().getColor(2131361847));
          }
        }
        try
        {
          localObject2 = URLDrawable.getDrawable(new URL("troop_photo_qzone", (String)localObject2, str2), this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
          localObject1 = localObject2;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.chatopttroop", 2, localMalformedURLException.toString());
            }
            continue;
            if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {
              localURLImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
            }
          }
        }
        if (localObject1 == null) {
          break label399;
        }
        localURLImageView.setImageDrawable(localObject1);
        Object localObject2 = localURLImageView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).height = i3;
        ((ViewGroup.LayoutParams)localObject2).width = i3;
        localURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localURLImageView.setVisibility(0);
      }
    }
    label399:
    if (i2 > 0) {}
    for (i1 = 0;; i1 = 8)
    {
      localLinearLayout.setVisibility(i1);
      if ((this.ao != 2) || (i2 <= 0) || ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.h()) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean))) {
        break;
      }
      paramView.setVisibility(0);
      return;
    }
  }
  
  protected void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[9];
      } while ((localObject == null) || (TextUtils.isEmpty(paramString)));
      localObject = (TextView)((View)localObject).findViewById(2131233216);
    } while (localObject == null);
    ((TextView)localObject).setText(paramString);
    if (!((TextView)localObject).isShown()) {
      ((TextView)localObject).setVisibility(0);
    }
    ((TextView)localObject).setVisibility(8);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    new cju(this, paramString1, paramString2).start();
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", paramString1, paramString2, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, paramString3, "", "");
  }
  
  protected void a(List paramList)
  {
    if (paramList == null) {
      return;
    }
    int i1 = getResources().getDimensionPixelOffset(2131427521);
    int i3 = getResources().getDimensionPixelOffset(2131427522);
    int i2 = getResources().getDimensionPixelOffset(2131427527);
    i3 = this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels - i1 - i3 - Utils.a(this, 10.0F) * 2;
    int i4 = getResources().getDimensionPixelOffset(2131427526);
    i1 = (int)Math.floor((i3 - i2 * 6) / i4);
    if (i1 > 6) {
      i1 = 6;
    }
    for (;;)
    {
      i4 += (i3 - i1 * i2 - i1 * i4) / i1;
      if (paramList != null)
      {
        i2 = paramList.size();
        i3 = 0;
        label132:
        if (i3 >= i1 - 1) {
          break label288;
        }
        localImageView = (ImageView)this.jdField_b_of_type_JavaUtilList.get(i3);
        if (i3 >= i2) {
          break label279;
        }
        localObject = (oidb_0x899.memberlist)paramList.get(i3);
        if ((localObject != null) && (((oidb_0x899.memberlist)localObject).uint64_member_uin.has())) {
          break label205;
        }
      }
      label205:
      long l1;
      for (;;)
      {
        i3 += 1;
        break label132;
        i2 = 0;
        break;
        l1 = ((oidb_0x899.memberlist)localObject).uint64_member_uin.get();
        localImageView.setVisibility(0);
        localImageView.setBackgroundDrawable(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(Long.toString(l1)));
        localImageView.setTag(Long.toString(l1));
        localObject = localImageView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = i4;
        ((ViewGroup.LayoutParams)localObject).width = i4;
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        continue;
        label279:
        localImageView.setVisibility(4);
      }
      label288:
      ImageView localImageView = (ImageView)this.jdField_b_of_type_JavaUtilList.get(i1 - 1);
      Object localObject = localImageView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = i4;
      ((ViewGroup.LayoutParams)localObject).width = i4;
      localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localImageView.setVisibility(0);
      if (this.ao == 1)
      {
        localImageView.setBackgroundResource(2130838508);
        localImageView.setOnClickListener(new ckc(this));
        label368:
        if (i2 <= 0) {
          break label510;
        }
        paramList = null;
        if (this.ao != 1) {
          break label512;
        }
        paramList = this.jdField_a_of_type_ArrayOfAndroidViewView[5];
      }
      for (;;)
      {
        if (paramList == null) {
          break label529;
        }
        paramList = (LinearLayout)paramList.findViewById(2131233221);
        if (paramList == null) {
          break;
        }
        paramList.setVisibility(0);
        return;
        if (i1 - 1 < paramList.size())
        {
          paramList = (oidb_0x899.memberlist)paramList.get(i1 - 1);
          if ((paramList != null) && (paramList.uint64_member_uin.has()))
          {
            l1 = paramList.uint64_member_uin.get();
            localImageView.setBackgroundDrawable(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(Long.toString(l1)));
            localImageView.setTag(Long.toString(l1));
            break label368;
          }
          localImageView.setVisibility(8);
          break label368;
        }
        localImageView.setVisibility(8);
        break label368;
        label510:
        break;
        label512:
        if (this.ao == 2) {
          paramList = this.jdField_a_of_type_ArrayOfAndroidViewView[19];
        }
      }
      label529:
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "mTroopInfoData is null!");
      }
    }
    while (this.ao != 1) {
      return;
    }
    View localView1 = this.jdField_a_of_type_ArrayOfAndroidViewView[16];
    View localView2 = this.jdField_a_of_type_ArrayOfAndroidViewView[4];
    if (localView2 != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a())
      {
        localView2.setVisibility(0);
        localView2.setBackgroundResource(2130837877);
        label78:
        localView2.setVisibility(8);
      }
    }
    for (;;)
    {
      if (i1 != 0) {
        localView1.setBackgroundResource(2130837879);
      }
      for (;;)
      {
        localView1 = this.jdField_a_of_type_ArrayOfAndroidViewView[8];
        if (localView1 == null) {
          break;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e()) {
          break label174;
        }
        if ((!localView1.isShown()) || (localView1.getVisibility() == 8)) {
          localView1.setVisibility(0);
        }
        this.jdField_a_of_type_ArrayOfAndroidViewView[5].setBackgroundResource(2130837879);
        return;
        localView2.setVisibility(8);
        i1 = 0;
        break label78;
        localView1.setBackgroundResource(2130837877);
      }
      label174:
      if ((localView1.isShown()) || (localView1.getVisibility() == 0)) {
        localView1.setVisibility(8);
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[5].setBackgroundResource(2130837877);
      return;
      i1 = 0;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ArrayOfAndroidViewView[11].setVisibility(0);
      this.jdField_a_of_type_ArrayOfAndroidViewView[12].setVisibility(8);
      return;
    }
    if (paramBoolean2)
    {
      this.jdField_a_of_type_ArrayOfAndroidViewView[11].setVisibility(8);
      this.jdField_a_of_type_ArrayOfAndroidViewView[12].setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ArrayOfAndroidViewView[11].setVisibility(8);
    this.jdField_a_of_type_ArrayOfAndroidViewView[12].setVisibility(8);
  }
  
  protected boolean a(View paramView)
  {
    if (paramView == null) {}
    while (paramView.getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  protected void b()
  {
    Object localObject = ((FriendsManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString));
    ArrayList localArrayList = new ArrayList();
    if (localObject != null)
    {
      localObject = ((TroopInfo)localObject).mTroopPicList;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          AvatarWallAdapter.AvatarInfo localAvatarInfo = new AvatarWallAdapter.AvatarInfo();
          if (str != null)
          {
            localAvatarInfo.jdField_b_of_type_JavaLangString = str;
            if (localAvatarInfo.jdField_b_of_type_JavaLangString == "-5") {}
            for (localAvatarInfo.jdField_c_of_type_JavaLangString = "SYSTEM_PHOTO";; localAvatarInfo.jdField_c_of_type_JavaLangString = "AVATAR_URL_STR")
            {
              localArrayList.add(localAvatarInfo);
              break;
            }
          }
        }
      }
    }
    if (localArrayList.size() == 0)
    {
      localObject = new AvatarWallAdapter.AvatarInfo();
      ((AvatarWallAdapter.AvatarInfo)localObject).jdField_b_of_type_JavaLangString = "-5";
      ((AvatarWallAdapter.AvatarInfo)localObject).jdField_c_of_type_JavaLangString = "SYSTEM_PHOTO";
      localArrayList.add(localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(localArrayList, 23, 0);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, d(), 0, paramInt2);
  }
  
  protected void b(int paramInt1, int paramInt2, View paramView, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramView, paramString, paramBoolean);
    paramView = (TextView)paramView.findViewById(2131231506);
    paramView.setEditableFactory(QQTextBuilder.a);
    paramView.setMovementMethod(LinkMovementMethod.getInstance());
    if (TextUtils.isEmpty(paramCharSequence)) {
      paramView.setVisibility(8);
    }
    for (;;)
    {
      paramView.setFocusable(false);
      return;
      paramView.setVisibility(0);
      paramView.setText(new QQText(paramCharSequence, 11));
    }
  }
  
  protected void b(int paramInt, Intent paramIntent)
  {
    if (paramInt != -1) {
      return;
    }
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    startActivity(localIntent);
  }
  
  public void b(BatchResponse paramBatchResponse)
  {
    UniPacket localUniPacket;
    if (paramBatchResponse.seq == 3)
    {
      localUniPacket = new UniPacket(true);
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.setServantName("GroupPhoto");
      localUniPacket.setFuncName("GetLastPicReq");
    }
    try
    {
      localUniPacket.decode((byte[])paramBatchResponse.buffer);
      paramBatchResponse = (GetLastPicRsp)localUniPacket.getByClass("GetLastPicRsp", new GetLastPicRsp());
      if (paramBatchResponse != null)
      {
        if ((paramBatchResponse.vec_picurl != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)) {
          this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.updateQZonePhotoUrls(paramBatchResponse.vec_picurl);
        }
        paramBatchResponse = (String)paramBatchResponse.exend.get("total_pic");
        if (TextUtils.isEmpty(paramBatchResponse)) {}
      }
    }
    catch (Throwable paramBatchResponse)
    {
      try
      {
        i1 = Integer.valueOf(paramBatchResponse).intValue();
        if (i1 > 0)
        {
          a(this.jdField_a_of_type_ArrayOfAndroidViewView[1], i1);
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
            this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mQZonePhotoNum = i1;
          }
        }
        return;
        paramBatchResponse = paramBatchResponse;
        paramBatchResponse.printStackTrace();
      }
      catch (NumberFormatException paramBatchResponse)
      {
        for (;;)
        {
          paramBatchResponse.printStackTrace();
          int i1 = 0;
        }
      }
    }
  }
  
  protected void b(View paramView, int paramInt, boolean paramBoolean)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131232645);
    paramView = (TextView)paramView.findViewById(2131232646);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && ((this.ao != 2) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean)))
    {
      paramView.setVisibility(8);
      if (paramBoolean) {
        localImageView.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    localImageView.setVisibility(8);
  }
  
  public void b(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return;
    }
    ((BizTroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(21)).d(paramString);
  }
  
  protected String c()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_JavaLangString)) {
      return getString(2131562502);
    }
    return "";
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "init(), isInitialized = " + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    }
    new ckb(this).start();
    if (this.l != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837854);
      this.l.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      this.l.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131427555));
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
    d();
  }
  
  protected void c(int paramInt, Intent paramIntent)
  {
    if (paramInt != -1) {}
    do
    {
      return;
      paramIntent = paramIntent.getStringExtra("result");
    } while (Utils.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_JavaLangString));
    if (NetworkUtil.e(a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_JavaLangString = paramIntent;
      c(16);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, getString(2131562452), 1000);
  }
  
  /* Error */
  protected boolean c()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: invokestatic 574	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +12 -> 17
    //   8: ldc 57
    //   10: iconst_2
    //   11: ldc_w 1943
    //   14: invokestatic 580	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: getfield 280	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   21: ifnonnull +5 -> 26
    //   24: iconst_0
    //   25: ireturn
    //   26: aload_0
    //   27: iconst_0
    //   28: putfield 179	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_Boolean	Z
    //   31: aload_0
    //   32: iconst_0
    //   33: putfield 177	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Boolean	Z
    //   36: aload_0
    //   37: invokevirtual 1947	com/tencent/mobileqq/activity/ChatSettingForTroop:getIntent	()Landroid/content/Intent;
    //   40: invokevirtual 1319	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   43: astore 4
    //   45: aload_0
    //   46: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   49: aload 4
    //   51: ldc_w 269
    //   54: invokevirtual 1949	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   57: putfield 258	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   60: aload_0
    //   61: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   64: aload 4
    //   66: ldc_w 459
    //   69: invokevirtual 1949	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   72: putfield 747	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   75: aload_0
    //   76: aload 4
    //   78: ldc_w 566
    //   81: iconst_1
    //   82: invokevirtual 1952	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   85: putfield 185	com/tencent/mobileqq/activity/ChatSettingForTroop:ao	I
    //   88: aload_0
    //   89: aload 4
    //   91: ldc_w 1954
    //   94: invokevirtual 1956	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   97: putfield 488	com/tencent/mobileqq/activity/ChatSettingForTroop:aq	I
    //   100: aload_0
    //   101: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   104: getfield 258	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   107: invokestatic 831	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   110: lstore_2
    //   111: lload_2
    //   112: lconst_0
    //   113: lcmp
    //   114: ifle -90 -> 24
    //   117: aload_0
    //   118: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   121: aload 4
    //   123: ldc_w 1958
    //   126: invokevirtual 1956	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   129: putfield 429	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Int	I
    //   132: aload_0
    //   133: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   136: aload 4
    //   138: ldc_w 1960
    //   141: invokevirtual 1956	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   144: putfield 1962	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_b_of_type_Int	I
    //   147: aload_0
    //   148: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   151: aload 4
    //   153: ldc_w 495
    //   156: invokevirtual 1949	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   159: putfield 493	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   162: aload_0
    //   163: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   166: aload 4
    //   168: ldc_w 1964
    //   171: invokevirtual 1967	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   174: putfield 375	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Boolean	Z
    //   177: aload_0
    //   178: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   181: aload 4
    //   183: ldc_w 1969
    //   186: invokevirtual 1973	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   189: putfield 835	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_b_of_type_Short	S
    //   192: aload_0
    //   193: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   196: aload 4
    //   198: ldc_w 1975
    //   201: invokevirtual 1949	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   204: putfield 297	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   207: aload_0
    //   208: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   211: aload 4
    //   213: ldc_w 1977
    //   216: invokevirtual 1949	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   219: putfield 1627	com/tencent/mobileqq/troopinfo/TroopInfoData:p	Ljava/lang/String;
    //   222: aload_0
    //   223: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   226: aload 4
    //   228: ldc_w 1979
    //   231: invokevirtual 1982	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   234: putfield 833	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Long	J
    //   237: aload_0
    //   238: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   241: aload 4
    //   243: ldc_w 1984
    //   246: invokevirtual 1949	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   249: putfield 1104	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   252: aload_0
    //   253: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   256: aload 4
    //   258: ldc_w 1986
    //   261: invokevirtual 1949	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   264: putfield 839	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   267: aload_0
    //   268: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   271: aload 4
    //   273: ldc_w 1988
    //   276: invokevirtual 1992	android/os/Bundle:getByte	(Ljava/lang/String;)B
    //   279: i2s
    //   280: putfield 452	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Short	S
    //   283: aload_0
    //   284: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   287: aload_0
    //   288: aload_0
    //   289: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   292: getfield 258	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   295: invokestatic 1997	com/tencent/mobileqq/util/TroopSystemMsgUtil:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   298: putfield 482	com/tencent/mobileqq/troopinfo/TroopInfoData:r	Ljava/lang/String;
    //   301: aload_0
    //   302: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   305: aload 4
    //   307: ldc_w 1999
    //   310: invokevirtual 1956	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   313: invokestatic 2001	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   316: putfield 1175	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   319: aload_0
    //   320: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   323: aload 4
    //   325: ldc_w 2003
    //   328: invokevirtual 1956	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   331: putfield 1522	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_Int	I
    //   334: aload_0
    //   335: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   338: aload_0
    //   339: aload_0
    //   340: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   343: getfield 258	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   346: invokestatic 2005	com/tencent/mobileqq/util/TroopSystemMsgUtil:c	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   349: putfield 486	com/tencent/mobileqq/troopinfo/TroopInfoData:s	Ljava/lang/String;
    //   352: aload_0
    //   353: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   356: aload 4
    //   358: ldc_w 2007
    //   361: invokevirtual 1982	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   364: putfield 1544	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_b_of_type_Long	J
    //   367: aload_0
    //   368: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   371: aload 4
    //   373: ldc_w 2009
    //   376: invokevirtual 1982	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   379: putfield 1549	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_Long	J
    //   382: aload_0
    //   383: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   386: aload 4
    //   388: ldc_w 2011
    //   391: invokevirtual 1949	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   394: invokestatic 1533	com/tencent/mobileqq/data/TroopInfo:getTags	(Ljava/lang/String;)Ljava/util/List;
    //   397: putfield 1534	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   400: aload_0
    //   401: getfield 280	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   404: bipush 8
    //   406: invokevirtual 730	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   409: checkcast 732	com/tencent/mobileqq/model/FriendManager
    //   412: astore 4
    //   414: aload 4
    //   416: ifnull +58 -> 474
    //   419: aload 4
    //   421: aload_0
    //   422: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   425: getfield 258	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   428: invokeinterface 742 2 0
    //   433: astore 4
    //   435: aload 4
    //   437: ifnull +37 -> 474
    //   440: aload_0
    //   441: aload 4
    //   443: putfield 726	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   446: aload_0
    //   447: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   450: iconst_1
    //   451: putfield 375	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Boolean	Z
    //   454: aload_0
    //   455: getfield 175	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   458: aload 4
    //   460: aload_0
    //   461: invokevirtual 986	com/tencent/mobileqq/activity/ChatSettingForTroop:getResources	()Landroid/content/res/Resources;
    //   464: aload_0
    //   465: getfield 280	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   468: invokevirtual 380	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   471: invokevirtual 2014	com/tencent/mobileqq/troopinfo/TroopInfoData:a	(Lcom/tencent/mobileqq/data/TroopInfo;Landroid/content/res/Resources;Ljava/lang/String;)V
    //   474: iconst_1
    //   475: ireturn
    //   476: astore 4
    //   478: invokestatic 574	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   481: ifeq +14 -> 495
    //   484: ldc 57
    //   486: iconst_2
    //   487: aload 4
    //   489: invokevirtual 577	java/lang/Exception:toString	()Ljava/lang/String;
    //   492: invokestatic 580	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   495: aload_0
    //   496: getfield 280	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   499: bipush 69
    //   501: invokestatic 425	com/tencent/biz/common/report/BnrReport:a	(Lcom/tencent/common/app/AppInterface;I)V
    //   504: iload_1
    //   505: ireturn
    //   506: astore 4
    //   508: iconst_1
    //   509: istore_1
    //   510: goto -32 -> 478
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	513	0	this	ChatSettingForTroop
    //   1	509	1	bool	boolean
    //   110	2	2	l1	long
    //   43	416	4	localObject	Object
    //   476	12	4	localException1	Exception
    //   506	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   26	111	476	java/lang/Exception
    //   117	414	506	java/lang/Exception
    //   419	435	506	java/lang/Exception
    //   440	474	506	java/lang/Exception
  }
  
  protected void d()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(19);
    if (localTroopHandler != null)
    {
      if (this.ao == 1) {
        localTroopHandler.a(a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString), true);
      }
    }
    else {
      return;
    }
    localTroopHandler.a(a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString), false);
  }
  
  protected void d(int paramInt, Intent paramIntent)
  {
    if (paramInt != -1) {
      return;
    }
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    localIntent.setFlags(67108864);
    startActivity(localIntent);
    finish();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent);
    }
    Object localObject;
    switch (paramInt1)
    {
    case 11: 
    default: 
    case 5: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          return;
          a(paramInt2, paramIntent);
        } while (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e());
        ((TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).g(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
        return;
        b(paramInt2, paramIntent);
        return;
        if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getExtras().getBoolean("isNeedFinish")))
        {
          paramIntent = new Intent();
          paramIntent.putExtra("isNeedFinish", true);
          setResult(-1, paramIntent);
          finish();
          return;
        }
        localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[9];
      } while (localObject == null);
      paramIntent = DBUtils.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (paramIntent == null) {
        break;
      }
    }
    for (paramIntent = paramIntent.troopnick;; paramIntent = null)
    {
      localObject = (TextView)((View)localObject).findViewById(2131231506);
      if ((!TextUtils.isEmpty(paramIntent)) && (!((TextView)localObject).getText().equals(paramIntent)))
      {
        ((TextView)localObject).setText(new QQText(paramIntent, 3));
        return;
      }
      if ((!TextUtils.isEmpty(paramIntent)) || (((TextView)localObject).getText().equals(paramIntent))) {
        break;
      }
      ((TextView)localObject).setText(new QQText(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e(), 3));
      return;
      c(paramInt2, paramIntent);
      return;
      d(paramInt2, paramIntent);
      return;
      e(paramInt2, paramIntent);
      return;
      if (paramInt2 != -1) {
        break;
      }
      setResult(-1);
      this.h = true;
      return;
      f(paramInt2, paramIntent);
      return;
      g(paramInt2, paramIntent);
      return;
      h(paramInt2, paramIntent);
      if (paramInt2 != -1) {
        break;
      }
      d();
      return;
      if ((-1 != paramInt2) || (paramIntent == null)) {
        break;
      }
      paramIntent = paramIntent.getStringExtra("result");
      if (TextUtils.equals(paramIntent, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_m_of_type_JavaLangString)) {
        break;
      }
      if (NetworkUtil.e(BaseApplication.getContext()))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_m_of_type_JavaLangString = paramIntent;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_m_of_type_JavaLangString)) {}
        for (paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_m_of_type_JavaLangString;; paramIntent = getResources().getString(2131562503))
        {
          a(18, paramIntent, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e());
          c(32);
          return;
        }
      }
      b(2131562452, 1);
      return;
      ((TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).g(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      return;
      i(paramInt2, paramIntent);
      return;
      if ((paramInt2 != -1) || (AvatarWallAdapter.jdField_a_of_type_AndroidNetUri == null)) {
        break;
      }
      paramIntent = ImageUtil.c(this, AvatarWallAdapter.jdField_a_of_type_AndroidNetUri);
      paramInt1 = ProfileCardUtil.a(this);
      PhotoUtils.a(new Intent(), this, ChatSettingForTroop.class.getName(), paramInt1, paramInt1, 640, 640, paramIntent, ProfileCardUtil.b());
      return;
      if ((paramIntent == null) || (paramIntent.getExtras() == null) || (paramInt2 != -1)) {
        break;
      }
      paramIntent = paramIntent.getExtras();
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString = paramIntent.getString("location");
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int = paramIntent.getInt("lat", 0);
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int = paramIntent.getInt("lon", 0);
      k();
      return;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    long l1 = 0L;
    if (QLog.isColorLevel()) {
      l1 = System.currentTimeMillis();
    }
    if (!c())
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "onCreate, illegal param, troopuin = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      }
      finish();
      return false;
    }
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
    a();
    this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility = new TroopShareUtility(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "onCreate(), time = " + (System.currentTimeMillis() - l1));
    }
    QzonePluginProxyActivity.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    if (this.ao == 1) {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e()) {
        a("Grp_Admin_data", "Clk_data", "0");
      }
    }
    for (;;)
    {
      BnrReport.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, 65);
      return true;
      a("Grp_Admin_data", "Clk_data", "1");
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean) {
        a("Grp_Visdata", "Clk_data", "0");
      } else {
        a("Grp_Visdata", "Clk_data", "1");
      }
    }
  }
  
  public void doOnDestroy()
  {
    this.jdField_c_of_type_Boolean = true;
    if (QLog.isColorLevel()) {}
    for (long l1 = System.currentTimeMillis();; l1 = 0L)
    {
      try
      {
        this.jdField_b_of_type_Boolean = true;
        b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
        b(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
        b(this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver);
        b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileObserver);
        }
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          int i1 = 1;
          while (i1 < 12)
          {
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(i1);
            i1 += 1;
          }
        }
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
          break label148;
        }
      }
      finally {}
      if (((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).isRunning()) {
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      }
      label148:
      this.jdField_a_of_type_AndroidOsHandler = null;
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager = null;
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileObserver = null;
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = null;
      this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = null;
      this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver = null;
      this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = null;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility.f();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility = null;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = null;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = null;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.c();
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter = null;
      }
      this.jdField_a_of_type_AndroidWidgetImageView = null;
      this.jdField_b_of_type_AndroidWidgetImageView = null;
      this.jdField_c_of_type_AndroidWidgetImageView = null;
      this.jdField_d_of_type_AndroidWidgetImageView = null;
      this.jdField_e_of_type_AndroidWidgetImageView = null;
      this.jdField_f_of_type_AndroidWidgetImageView = null;
      this.jdField_b_of_type_JavaUtilList = null;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = null;
      if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(null);
      }
      GroupCatalogTool.a(this).a();
      super.doOnDestroy();
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "onDestroy(), time = " + (System.currentTimeMillis() - l1));
      }
      return;
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (paramIntent == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramIntent;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter != null)
    {
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext())
      {
        str = (String)paramIntent.next();
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.b(str);
      }
    }
    this.jdField_f_of_type_Boolean = true;
    paramIntent = (AccountManager)getAppRuntime().getManager(0);
    String str = TroopBarUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    if (str == null) {
      paramIntent.updateSKey(this.jdField_a_of_type_MqqObserverAccountObserver);
    }
    for (;;)
    {
      a("Grp_Admin_data", "upload_head", "");
      return;
      TroopUtils.a(str, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_e_of_type_Boolean) {
      this.jdField_e_of_type_Boolean = false;
    }
    try
    {
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_JavaLangString);
      TroopNotificationHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, 0, l2, l1, 0L, "", 0, "OidbSvc.0x852_48", (short)23, false);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (!this.jdField_d_of_type_Boolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.chatopttroop", 4, "doOnStart add observer");
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      a(this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver);
      a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      this.jdField_d_of_type_Boolean = true;
    }
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_f_of_type_Boolean = false;
      return;
    }
    TroopAvatarManger.jdField_a_of_type_Int = 0;
    b();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_d_of_type_Boolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.chatopttroop", 4, "doOnStop remove observer");
      }
      b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      b(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      b(this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver);
      this.jdField_d_of_type_Boolean = false;
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  protected void e()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[15];
    if ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {
      return;
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_m_of_type_Int;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i()) {}
    TextView localTextView = (TextView)((View)localObject).findViewById(2131232640);
    localObject = (ImageView)((View)localObject).findViewById(2131232642);
    localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    ((ImageView)localObject).setVisibility(8);
  }
  
  protected void e(int paramInt, Intent paramIntent)
  {
    if (paramInt != -1) {}
    boolean bool;
    do
    {
      do
      {
        return;
      } while (paramIntent == null);
      bool = paramIntent.getBooleanExtra("isNeedFinish", false);
      String str = paramIntent.getStringExtra("fin_tip_msg");
      paramIntent = paramIntent.getStringExtra("uin");
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.", 2, "ChatSettingActivity|onActivityResult|REQUEST_FOR_TROOP_DISBAND|isNeedFinish = " + bool + ", strTip = " + str);
      }
      if (!TextUtils.isEmpty(paramIntent))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(paramIntent, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
        a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean);
      }
      if ((!TextUtils.isEmpty(str)) && (bool))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(5, str, 1000);
        return;
      }
      if (!TextUtils.isEmpty(str))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(1, str, 1000);
        return;
      }
    } while (!bool);
    paramIntent = new Intent();
    paramIntent.putExtra("isNeedFinish", true);
    setResult(-1, paramIntent);
    finish();
  }
  
  public void f()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
      return;
    }
    if ((this.ao == 2) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)) {
      a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberMax);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter != null)) {
      if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e()) || (this.ao != 1)) {
        break label95;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(bool);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a();
      u();
      return;
      label95:
      bool = false;
    }
  }
  
  protected void f(int paramInt, Intent paramIntent)
  {
    if (paramInt != -1) {
      return;
    }
    paramIntent = new Intent(this, ChatActivity.class);
    paramIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    paramIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_f_of_type_JavaLangString);
    paramIntent.putExtra("uintype", 1);
    paramIntent.putExtra("isNeedUpdate", this.h);
    paramIntent.setFlags(67108864);
    startActivity(paramIntent);
    finish();
  }
  
  public void g()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f()) {
      return;
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    if (localSharedPreferences.getLong("key_last_update_member_list_time" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, 0L) == 0L)
    {
      TroopHandler localTroopHandler = (TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(19);
      if (localTroopHandler != null) {
        localTroopHandler.a(true, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_JavaLangString);
      }
      localSharedPreferences.edit().putLong("key_last_update_member_list_time" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, System.currentTimeMillis()).commit();
    }
    ThreadManager.a(new ckg(this));
  }
  
  protected void g(int paramInt, Intent paramIntent)
  {
    if ((paramInt == -1) && (paramIntent != null))
    {
      boolean bool = paramIntent.getBooleanExtra("ken_qun_photo_data_has_changed", true);
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "resultForRequestQzonePhoto|needRereshed = " + bool);
      }
      if (bool) {
        l();
      }
    }
    new cjs(this).start();
  }
  
  protected void h()
  {
    Intent localIntent = new Intent(this, TroopMemberCardActivity.class);
    localIntent.putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("troopCode", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("memberUin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localIntent.putExtra("fromFlag", 2);
    startActivityForResult(localIntent, 2);
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_head", 2, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "", "");
  }
  
  protected void h(int paramInt, Intent paramIntent)
  {
    TextView localTextView = null;
    if ((paramIntent != null) && (paramIntent.getExtras() != null)) {
      if (paramIntent.getExtras().getBoolean("isNeedFinish"))
      {
        paramIntent = new Intent();
        paramIntent.putExtra("isNeedFinish", true);
        setResult(-1, paramIntent);
        finish();
      }
    }
    label262:
    do
    {
      return;
      if (paramIntent.getExtras().getBoolean("finish_chat_setting"))
      {
        finish();
        return;
      }
      paramIntent = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (paramIntent == null) {}
      for (paramIntent = null;; paramIntent = paramIntent.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString))
      {
        if ((paramIntent != null) && (paramIntent.wMemberNum != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Int))
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(paramIntent.Administrator, paramIntent.wMemberNum, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), getResources());
          a(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_h_of_type_JavaLangString, true);
        }
        View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[9];
        if (localView == null) {
          break;
        }
        TroopMemberInfo localTroopMemberInfo = DBUtils.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
        paramIntent = localTextView;
        if (localTroopMemberInfo != null) {
          paramIntent = localTroopMemberInfo.troopnick;
        }
        localTextView = (TextView)localView.findViewById(2131231506);
        if ((TextUtils.isEmpty(paramIntent)) || (localTextView.getText().equals(paramIntent))) {
          break label262;
        }
        localTextView.setText(new QQText(paramIntent, 3));
        return;
      }
    } while ((!TextUtils.isEmpty(paramIntent)) || (localTextView.getText().equals(paramIntent)));
    localTextView.setText(new QQText(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e(), 3));
  }
  
  protected void i()
  {
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_grpinfo_mberlist", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
    Intent localIntent = new Intent(this, TroopMemberListActivity.class);
    localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("FROM_ACTIVITY", "CHAT_SETTING_FOR_TROOP");
    startActivity(localIntent);
  }
  
  protected void i(int paramInt, Intent paramIntent)
  {
    if (paramInt == -1)
    {
      ArrayList localArrayList1 = paramIntent.getStringArrayListExtra("del_list");
      if (localArrayList1 != null)
      {
        ArrayList localArrayList2 = new ArrayList();
        Iterator localIterator = localArrayList1.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if ((str != null) && (AvatarTroopUtil.b(str))) {
            localArrayList2.add(Integer.valueOf(Integer.parseInt(str)));
          }
        }
        if (localArrayList2.size() > 0)
        {
          a("Grp_Admin_data", "del_head", "");
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, 2, localArrayList2);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(localArrayList1);
      }
      paramInt = paramIntent.getIntExtra("default_avator_index", -1);
      if (paramInt != -1)
      {
        if ((paramInt > 0) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.getCount())) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.c(paramInt);
        }
        QQToast.a(this, getString(2131562538), 1).b(d());
      }
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 7) {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_nearby", "", "nearbygrp_data", "Clk_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int != 0))
    {
      localIntent = new Intent(this, NearbyTroopsLocationActivity.class);
      localIntent.putExtra("lat", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int);
      localIntent.putExtra("lon", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int);
      localIntent.putExtra("location_name", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString);
      localIntent.putExtra("from", 11);
      localIntent.putExtra("mode", 1);
      startActivity(localIntent);
      a("Grp", "Clk_grp_map", "0");
    }
    while (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e())
    {
      Intent localIntent;
      return;
    }
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_data", "add_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
    TroopLocationModifyActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString, 16);
  }
  
  public void k()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[15];
    if ((localView == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {
      return;
    }
    localView = localView.findViewById(2131232643);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString)) {
      localView.setVisibility(8);
    }
    for (;;)
    {
      localView.setVisibility(8);
      return;
      localView.setVisibility(0);
      ((TextView)localView.findViewById(2131230941)).setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString);
    }
  }
  
  public void l()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(19);
    if (localTroopHandler == null) {}
    do
    {
      return;
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
          this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
          break;
        }
        localTroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, (byte)1, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwTimeStamp, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a());
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.i("Q.chatopttroop", 2, localException.toString());
    return;
    localException.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, (byte)1, 0L, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a());
  }
  
  protected void m()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[4];
    if (localObject != null) {
      a((View)localObject, 0, false);
    }
    new cjw(this).start();
    localObject = new Intent();
    ((Intent)localObject).putExtra("troopuin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    if ((this.jdField_f_of_type_JavaLangString != null) && (!"".equals(this.jdField_f_of_type_JavaLangString.trim())))
    {
      ((Intent)localObject).putExtra("request_params", this.jdField_f_of_type_JavaLangString);
      ((Intent)localObject).putExtra("from", "3");
    }
    TroopQQBrowserHelper.a(this, (Intent)localObject, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
  }
  
  protected void n()
  {
    if ((this.ao == 2) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_Int != 0) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_Int = 0;
        DBUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "troop_file_new", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_Int);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_j_of_type_Int <= 0) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
        }
      }
      Object localObject = new Intent();
      ((Intent)localObject).putExtra(TroopProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      TroopProxyActivity.a(this, (Intent)localObject, 103);
      localObject = (QQAppInterface)getAppRuntime();
      if (localObject == null) {
        break;
      }
      a("Grp", "Clk_grpinfo_files", "0");
      if (QLog.isDevelopLevel()) {
        QLog.d("Clk_grpinfo_files", 4, "troopUin :" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      }
      BnrReport.a((AppInterface)localObject, 67);
      return;
    }
  }
  
  public void o()
  {
    boolean bool = ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).h(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    Object localObject = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[13];
    if (localObject != null)
    {
      localObject = ((FormSwitchItem)localObject).a();
      ((Switch)localObject).setOnCheckedChangeListener(null);
      ((Switch)localObject).setChecked(bool);
      ((Switch)localObject).setOnCheckedChangeListener(this);
      ((Switch)localObject).setContentDescription(getString(2131560395));
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 103) {}
    try
    {
      if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager != null)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.a(3, 0, 1);
      }
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    finally {}
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = paramCompoundButton.getTag();
    if (!(paramCompoundButton instanceof Integer)) {
      return;
    }
    switch (((Integer)paramCompoundButton).intValue())
    {
    default: 
      return;
    }
    c(paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null)
    {
      paramView = null;
      if ((paramView instanceof Integer)) {
        switch (((Integer)paramView).intValue())
        {
        }
      }
    }
    label1666:
    label1701:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramView = paramView.getTag();
            break;
            if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean)
            {
              QQToast.a(this, 2131560676, 1).b(d());
              return;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Boolean) {
              i1 = 0;
            }
            for (;;)
            {
              paramView = String.format("http://en.qq.com/qqiGroupAnnounceRedirect.php?_wv=1027&_bid=148&qqqi=qqqi&gc=%s&role=%d&actionIcon=1&sid=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, Integer.valueOf(i1), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getSid() });
              localIntent = new Intent(this, QQBrowserActivity.class);
              localIntent.putExtra("url", paramView);
              localIntent.putExtra("webStyle", "noBottomBar");
              startActivity(localIntent);
              this.jdField_e_of_type_Boolean = true;
              ReportController.a(null, "P_CliOper", "Grp_bulletin", "", "Grp_data", "Clk_grpbulletin", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
              ThreadManager.b(new ckh(this));
              a("Grp_Admin_data", "Clk_notice", "");
              return;
              if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Boolean) {
                i1 = 1;
              } else {
                i1 = 2;
              }
            }
            h();
            return;
            i();
            a("Grp_Admin_data", "Clk_mber", "");
            return;
            g();
            return;
            if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean)
            {
              QQToast.a(this, 2131560676, 1).b(d());
              return;
            }
            F();
            return;
            if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean)
            {
              QQToast.a(this, 2131560676, 1).b(d());
              return;
            }
            n();
            return;
            paramView = new Intent(this, QQBrowserActivity.class);
            paramView.putExtra("url", String.format("http://xiaoqu.qq.com/cgi-bin/bar/jump?action=qun&from=card&gid=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString }));
            paramView.putExtra("webStyle", "noBottomBar");
            startActivity(paramView);
            a("Grp_data", "Clk_tribe", "");
            return;
            m();
            a("Grp_Admin_data", "Clk_forum", "");
            return;
          } while (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_n_of_type_Int > this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Int) {
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_n_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Int;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Long & 0x800000) != 8388608L) {}
          for (i1 = 0;; i1 = 1)
          {
            paramView = new Intent(this, PublicAccountBrowser.class);
            paramView.putExtra("hide_operation_bar", true);
            paramView.putExtra("hideRightButton", true);
            paramView.putExtra("isScreenOrientationPortrait", true);
            paramView.putExtra("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
            paramView.putExtra("url", "http://qinfo.clt.qq.com/group_level/qlevel.html?_bid=151&groupuin=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString + "&role=1&group_level=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_m_of_type_Int + "&group_mem_num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Int + "&group_active_num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_n_of_type_Int + "&show_level=" + i1);
            startActivity(paramView);
            ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_rank", "", "Grp_data", "Clk_grprank", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
            BnrReport.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, 72);
            return;
          }
          b(this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver);
          paramView = TroopInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, 3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString);
          TroopInfoActivity.a(a(), paramView, 5);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e()) {
            a("Grp_moredata", "Clk_moredata", "0");
          }
          for (;;)
          {
            BnrReport.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, 68);
            return;
            a("Grp_moredata", "Clk_moredata", "1");
          }
          E();
          return;
          D();
          return;
          C();
          return;
          b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Boolean);
          return;
          G();
        } while (this.aq != 2);
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_discuss", "", "discuss_AIO", "Clk_grpaio", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
        return;
        p();
        return;
        paramView = new Intent(this, TroopManageActivity.class);
        paramView.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
        paramView.putExtra("forward_location", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString);
        paramView.putExtra("forward_latitude", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int);
        paramView.putExtra("forward_longitude", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int);
        startActivityForResult(paramView, 10);
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_manage", "", "manage_grp", "Clk_managegrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 7) {
          ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
        }
        while (!NetworkUtil.e(this))
        {
          b(2131562451, 0);
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 10) {
            ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp", 1, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
          } else if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 11) {
            ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp", 2, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
          } else if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 12) {
            ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
          }
        }
        paramView = (TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(19);
        if (paramView != null) {}
        try
        {
          long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
          q();
          paramView.a(l1, 8388736);
          a("Grp_recommend", "viewinfor_joingrp", "0");
          return;
        }
        catch (Exception paramView)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.chatopttroop", 2, paramView.toString());
            }
          }
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_JavaUtilList;
        localIntent = new Intent(this, TroopTagViewActivity.class);
        localIntent.putExtra("troopuin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
        localIntent.putExtra("isAdmin", false);
        paramView = Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long);
        localObject2 = GroupCatalogTool.a(this).a(this, paramView);
        int i1 = 0;
        if ((localObject2 != null) && (!TextUtils.isEmpty(((GroupCatalogBean)localObject2).jdField_a_of_type_JavaLangString)))
        {
          paramView = "";
          if ((!getResources().getString(2131559044).equals(((GroupCatalogBean)localObject2).jdField_a_of_type_JavaLangString)) && (((GroupCatalogBean)localObject2).jdField_a_of_type_Int != 1)) {
            break label1666;
          }
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_j_of_type_JavaLangString)) {
            paramView = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_j_of_type_JavaLangString;
          }
        }
        for (i1 = 1;; i1 = 1)
        {
          if (i1 != 0) {
            localIntent.putExtra("subclass", paramView);
          }
          if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
            break label1701;
          }
          paramView = new StringBuffer();
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            paramView.append((String)localObject2 + "\n");
          }
          paramView = ((GroupCatalogBean)localObject2).jdField_a_of_type_JavaLangString;
        }
        paramView.deleteCharAt(paramView.length() - 1);
        localIntent.putExtra("tags", paramView.toString());
        localIntent.putExtra("act_type", 1);
        localIntent.putExtra("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e()) {
          startActivityForResult(localIntent, 13);
        }
        for (;;)
        {
          a("Grp_Visdata", "nonmber_Clk_tag", "");
          BnrReport.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, 71);
          return;
          startActivity(localIntent);
        }
      } while (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e());
      a(12, 900, 2131562235, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_m_of_type_JavaLangString, true, 1, true);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean)
      {
        a("Grp_Admin_data", "Clk_brief", "0");
        return;
      }
      a("Grp_Admin_data", "Clk_brief", "1");
      return;
      s();
      return;
      j();
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
      a("Grp_Admin_data", "Clk_share", "");
      return;
      paramView = (AvatarWallAdapter.AvatarInfo)this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.getItem(0);
    } while (paramView == null);
    Intent localIntent = new Intent();
    localIntent.setClass(this, TroopAvatarWallPreviewActivity.class);
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("index", 0);
    Object localObject2 = new ArrayList();
    if (((paramView.jdField_c_of_type_JavaLangString == "AVATAR_URL_STR") || (paramView.jdField_c_of_type_JavaLangString == "SYSTEM_PHOTO")) && (paramView.jdField_a_of_type_JavaLangString == null)) {
      ((ArrayList)localObject2).add(paramView.jdField_b_of_type_JavaLangString);
    }
    for (;;)
    {
      ((Bundle)localObject1).putBoolean("IS_EDIT", false);
      ((Bundle)localObject1).putStringArrayList("seqNum", (ArrayList)localObject2);
      ((Bundle)localObject1).putString("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      ((Bundle)localObject1).putBoolean("troop_info_is_member", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean);
      localIntent.putExtras((Bundle)localObject1);
      startActivityForResult(localIntent, 14);
      return;
      ((ArrayList)localObject2).add(paramView.jdField_a_of_type_JavaLangString);
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    MenuItemCompat.setShowAsAction(paramMenu.add(0, 0, 0, getString(2131562772)), 0);
    if (this.ao == 1) {
      MenuItemCompat.setShowAsAction(paramMenu.add(0, 1, 0, getString(2131562706)), 0);
    }
    return true;
  }
  
  public boolean onLongClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof Integer)) {
      switch (((Integer)localObject).intValue())
      {
      }
    }
    for (;;)
    {
      return false;
      localObject = new QQCustomMenu();
      ((QQCustomMenu)localObject).a(2131234877, getString(2131561879));
      this.jdField_a_of_type_AndroidAppDialog = BubbleContextMenu.a(paramView, (QQCustomMenu)localObject, new cjn(this), null);
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool1 = super.onOptionsItemSelected(paramMenuItem);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (isFinishing());
          bool1 = bool2;
        } while (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null);
        bool1 = bool2;
      } while (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null);
      ReportPlugin.a(this, 301, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      return true;
      bool1 = bool2;
    } while (this.ao != 1);
    b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Boolean);
    return true;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    return true;
  }
  
  protected void p()
  {
    Intent localIntent = new Intent(this, PublicAccountBrowser.class);
    localIntent.putExtra("url", "http://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3&gc=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    super.startActivity(localIntent);
  }
  
  public void q()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(a(), d());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131562645);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.chatopttroop", 2, localException.toString());
    }
  }
  
  public void r()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.chatopttroop", 2, localException.toString());
    }
  }
  
  protected void s()
  {
    if (this.jdField_c_of_type_JavaUtilList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i2 = this.jdField_c_of_type_JavaUtilList.size();
    int i1 = 0;
    if (i1 < i2)
    {
      localObject = (oidb_0x899.memberlist)this.jdField_c_of_type_JavaUtilList.get(i1);
      if ((localObject == null) || (!((oidb_0x899.memberlist)localObject).uint64_member_uin.has())) {}
      for (;;)
      {
        i1 += 1;
        break;
        localArrayList.add(String.valueOf(((oidb_0x899.memberlist)localObject).uint64_member_uin.get()));
      }
    }
    Object localObject = new Intent(this, TroopAdminList.class);
    ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p);
    ((Intent)localObject).putStringArrayListExtra("troop_info_memo", localArrayList);
    startActivity((Intent)localObject);
  }
  
  public void t()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.chatopttroop", 4, "updateTroopInfoToDB");
      }
      ((FriendsManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo);
    }
  }
  
  protected void u()
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[15];
    if ((localObject1 == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {}
    for (;;)
    {
      return;
      TextView localTextView = (TextView)((View)localObject1).findViewById(2131232315);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_f_of_type_JavaLangString;
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = " ";
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Long & 0x800) != 0L)
      {
        localObject1 = null;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Long == 2L) {
          localObject1 = getResources().getDrawable(2130838179);
        }
        while (localObject1 != null)
        {
          int i1 = Util.a(this, 7.0F);
          ((Drawable)localObject1).setBounds(i1, 0, Util.a(this, 15.0F) + i1, Util.a(this, 15.0F));
          SpannableString localSpannableString = new SpannableString((String)localObject2 + "1");
          localSpannableString.setSpan(new ImageSpan((Drawable)localObject1, 1), ((String)localObject2).length(), ((String)localObject2).length() + 1, 17);
          localTextView.setText(localSpannableString);
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Long == 1L) {
            localObject1 = getResources().getDrawable(2130838355);
          }
        }
      }
    }
  }
  
  public void v()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    ImageView localImageView;
    Object localObject4;
    label267:
    Object localObject3;
    do
    {
      do
      {
        return;
        localImageView = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[15].findViewById(2131232313);
        localObject1 = (AvatarWallAdapter.AvatarInfo)this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.getItem(0);
      } while (localObject1 == null);
      if (((((AvatarWallAdapter.AvatarInfo)localObject1).jdField_c_of_type_JavaLangString == "AVATAR_URL_STR") || (((AvatarWallAdapter.AvatarInfo)localObject1).jdField_c_of_type_JavaLangString == "SYSTEM_PHOTO")) && (((AvatarWallAdapter.AvatarInfo)localObject1).jdField_a_of_type_JavaLangString == null)) {}
      for (Object localObject1 = ((AvatarWallAdapter.AvatarInfo)localObject1).jdField_b_of_type_JavaLangString;; localObject2 = localOutOfMemoryError1.jdField_a_of_type_JavaLangString)
      {
        if ((localObject1 == null) || (!((String)localObject1).equals("-5"))) {
          break label267;
        }
        localObject4 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        Setting localSetting = (Setting)((EntityManager)localObject4).a(Setting.class, "troop_" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
        ((EntityManager)localObject4).a();
        if ((localSetting != null) && (localSetting.bHeadType != 0)) {
          break;
        }
        try
        {
          localObject1 = ImageUtil.a(getResources().getDrawable(2130838406));
          localObject4 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a((Bitmap)localObject1, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
          ((Bitmap)localObject1).recycle();
          localImageView.setImageBitmap((Bitmap)localObject4);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          return;
        }
      }
      for (Object localObject2 = AvatarTroopUtil.a((String)localObject2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, 0);; localObject3 = AvatarTroopUtil.a(localOutOfMemoryError2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, 1))
      {
        localObject2 = URLDrawable.getDrawable(AvatarTroopUtil.a((String)localObject2));
        if (((URLDrawable)localObject2).getStatus() != 1) {
          break;
        }
        try
        {
          localObject2 = ImageUtil.a((Drawable)localObject2);
          localObject4 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a((Bitmap)localObject2, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
          ((Bitmap)localObject2).recycle();
          localImageView.setImageBitmap((Bitmap)localObject4);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          return;
        }
      }
      ((URLDrawable)localObject3).setURLDrawableListener(new cka(this, localImageView));
    } while (((URLDrawable)localObject3).getStatus() != 1);
    try
    {
      localObject3 = ImageUtil.a((Drawable)localObject3);
      localObject4 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a((Bitmap)localObject3, ((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight());
      ((Bitmap)localObject3).recycle();
      localImageView.setImageBitmap((Bitmap)localObject4);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError3) {}
  }
  
  public void w()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    while (this.jdField_a_of_type_ArrayOfAndroidViewView[15] == null) {
      return;
    }
    TextView localTextView = (TextView)findViewById(2131232641);
    localTextView.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.q == 1)
    {
      localTextView.setText(2131560399);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.q == 0)
    {
      localTextView.setText(2131560400);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.q == 2)
    {
      localTextView.setText(2131560401);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.q == 3)
    {
      localTextView.setText(2131560401);
      return;
    }
    localTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop
 * JD-Core Version:    0.7.0.1
 */