package com.tencent.mobileqq.activity;

import aeu;
import aev;
import aew;
import aex;
import aey;
import aez;
import afa;
import afb;
import afc;
import afd;
import afe;
import aff;
import afg;
import afi;
import afj;
import afk;
import afl;
import afm;
import afo;
import afp;
import afq;
import afr;
import afs;
import aft;
import afu;
import afv;
import afw;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.WindowManager.BadTokenException;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.biz.common.report.BnrReport;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profile.view.ReboundHorizontalScrollView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.activity.NearbyTroopsLocationActivity;
import com.tencent.mobileqq.troop.activity.TroopAdminList;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;
import com.tencent.mobileqq.troop.browser.TroopQQBrowserHelper;
import com.tencent.mobileqq.troop.data.TroopFileObserver;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.mobileqq.troop.widget.AvatarWallView;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.MenuPopupDialog;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import cooperation.qzone.QZoneHelper;
import cooperation.troop.TroopProxyActivity;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.AccountManager;
import mqq.manager.WtloginManager;
import mqq.observer.AccountObserver;
import mqq.util.WeakReference;
import oicq.wlogin_sdk.request.Ticket;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class ChatSettingForTroop
  extends IphoneTitleBarActivity
  implements View.OnClickListener, View.OnLongClickListener
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
  protected static final int aA = 10;
  public static final int aB = 11;
  protected static final int aC = 12;
  protected static final int aD = 13;
  public static final int aE = 14;
  public static final int aF = 15;
  protected static final int aG = 12;
  private static final int aH = 0;
  protected static final int aa = 19;
  protected static final int ab = 19;
  protected static final int ac = 20;
  protected static final int ad = 21;
  protected static final int ae = 22;
  protected static final int af = 23;
  protected static final int ag = 24;
  protected static final int ah = 25;
  protected static final int ai = 26;
  protected static final int aj = 1101111755;
  public static final int am = 6;
  protected static final int aq = 1;
  protected static final int ar = 1;
  protected static final int as = 2;
  protected static final int at = 3;
  protected static final int au = 4;
  protected static final int av = 5;
  protected static final int aw = 6;
  protected static final int ax = 7;
  protected static final int ay = 8;
  protected static final int az = 9;
  public static final int b = 1;
  public static final String b = "http://xiaoqu.qq.com/cgi-bin/bar/jump?action=qun&from=card&gid=%s";
  public static final int c = 2;
  public static final String c = "http://qqweb.qq.com/m/qunactivity/index.html?_wv=3&_bid=244&groupuin=%1$s&sid=%2$s&entersource=%3$d";
  public static final int d = 3;
  public static final String d = "http://qqweb.qq.com/cgi-bin/qqactivity/get_activity_group_card_list";
  public static final int e = 4;
  public static final String e = "http://qqweb.qq.com/cgi-bin/qqactivity/unset_red_point";
  public static final int f = 5;
  public static final String f = "selection";
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 8;
  static String jdField_i_of_type_JavaLangString = "http://qun.qzone.qq.com/group#!/";
  public static final int j = 9;
  public static final int k = 0;
  public static final int l = 1;
  public static final int m = 2;
  private static final String m = "_troop_community.nb";
  public static final int n = 3;
  public static final int o = 1;
  public static final int p = 2;
  public static final int q = 3;
  public static final int r = 4;
  public static final int s = 5;
  public static final int t = 6;
  public static final int u = 7;
  public static final int v = 8;
  public static final int w = 9;
  public static final int x = 10;
  public static final int y = 11;
  public static final int z = 12;
  protected final int F = 1;
  protected final int G = 4;
  public Drawable a;
  public Handler a;
  protected DisplayMetrics a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new afo(this);
  protected View a;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
  protected LinearLayout a;
  public TextView a;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new afe(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new afc(this);
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new afa(this);
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
  private MenuPopupDialog jdField_a_of_type_ComTencentWidgetMenuPopupDialog;
  public XListView a;
  public ArrayList a;
  private HashMap jdField_a_of_type_JavaUtilHashMap = null;
  public LinkedHashMap a;
  public List a;
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new aff(this);
  protected boolean a;
  public View[] a;
  private final int aI = 103;
  public int ak;
  public int al = 1;
  protected int an;
  public int ao;
  public int ap = -1;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  public View b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  LinearLayout.LayoutParams jdField_b_of_type_AndroidWidgetLinearLayout$LayoutParams;
  TroopObserver jdField_b_of_type_ComTencentMobileqqAppTroopObserver = new afb(this);
  List jdField_b_of_type_JavaUtilList;
  public boolean b;
  ImageView c;
  protected List c;
  public boolean c;
  ImageView d;
  protected boolean d;
  ImageView e;
  protected boolean e;
  ImageView f;
  protected boolean f;
  protected String g;
  private boolean g;
  public final String h;
  private boolean h;
  private boolean jdField_i_of_type_Boolean = false;
  protected String j;
  private String k;
  private String l;
  
  public ChatSettingForTroop()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_g_of_type_JavaLangString = "http://app.qun.qq.com/mobileapp/index.html?_bid=136";
    this.jdField_h_of_type_JavaLangString = "http://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3";
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new aez(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileObserver = new afj(this);
  }
  
  private void A()
  {
    if ((this.al == 2) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i != 0) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i = 0;
        DBUtils.a(this.app.a(), "troop_photo_new", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_h_of_type_Int <= 0) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        }
      }
      Intent localIntent = new Intent(this, QQBrowserActivity.class).putExtra("url", jdField_i_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString + "/photo");
      localIntent.putExtra("webStyle", "noBottomBar");
      startActivity(localIntent);
      return;
    }
  }
  
  private void B()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 3)
    {
      localIntent = new Intent();
      localIntent.putExtra("isNeedFinish", true);
      setResult(-1, localIntent);
      finish();
      return;
    }
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f);
    startActivity(localIntent);
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short != 3)
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a();
      if ((this.an == 1) || (this.an == 2)) {
        i1 = 116;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_JavaLangString))
      {
        startActivity(AddFriendLogicActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short, i1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.s, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_JavaLangString, a_()));
        return;
      }
      startActivityForResult(AddFriendLogicActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short, i1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.s, null, a_()), 11);
      return;
    }
    b(2131363365, 1);
  }
  
  private void D()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(2131363586, 5);
    if (this.al == 1) {
      localActionSheet.a(2131363424, 3);
    }
    localActionSheet.d(2131362790);
    localActionSheet.a(new afk(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private void E()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(1L));
    localArrayList.add(Long.valueOf(2L));
    localArrayList.add(Long.valueOf(1101484419L));
    Object localObject = (TroopInfoManager)this.app.getManager(33);
    if (localObject != null) {
      localArrayList.addAll(((TroopInfoManager)localObject).a());
    }
    localObject = (TroopHandler)this.app.a(17);
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)) {
      ((TroopHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, localArrayList);
    }
  }
  
  private void F()
  {
    View localView1 = this.jdField_a_of_type_ArrayOfAndroidViewView[13];
    LinearLayout localLinearLayout = (LinearLayout)localView1.findViewById(2131297094);
    Object localObject1 = (TroopInfoManager)this.app.getManager(33);
    if (localObject1 != null)
    {
      localObject1 = ((TroopInfoManager)localObject1).a();
      if (((List)localObject1).size() > 0)
      {
        Object localObject2 = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131296453);
        int i1 = ((ImageView)localObject2).getHeight();
        int i2 = ((ImageView)localObject2).getWidth();
        localObject1 = ((List)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (TroopAppInfo)((Iterator)localObject1).next();
          localLinearLayout.addView(View.inflate(this, 2130903375, null), this.jdField_b_of_type_AndroidWidgetLinearLayout$LayoutParams);
          View localView2 = View.inflate(this, 2130903373, null);
          localView2.setFocusable(true);
          localView2.setClickable(true);
          Object localObject3 = (TextView)localView2.findViewById(2131296455);
          ImageView localImageView = (ImageView)localView2.findViewById(2131296453);
          ((TextView)localObject3).setText(((TroopAppInfo)localObject2).appName);
          localObject3 = localImageView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject3).height = i1;
          ((ViewGroup.LayoutParams)localObject3).width = i2;
          localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          localObject3 = URLDrawable.getDrawable(((TroopAppInfo)localObject2).appIcon + "_48.png");
          ((URLDrawable)localObject3).setURLDrawableListener(new afl(this, localImageView, (URLDrawable)localObject3));
          localImageView.setImageDrawable((Drawable)localObject3);
          localView2.setTag(Long.valueOf(((TroopAppInfo)localObject2).appId));
          localView2.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localLinearLayout.addView(localView2, this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
          if (DBUtils.a(this.app.a(), ((TroopAppInfo)localObject2).appId + "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString) > 0) {}
          for (boolean bool = true;; bool = false)
          {
            a(localView2, 0, bool);
            this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(((TroopAppInfo)localObject2).appId), localView2);
            if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) {
              ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "Exp_data_appEntry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "" + ((TroopAppInfo)localObject2).appId);
            }
            localView2.setContentDescription(((TroopAppInfo)localObject2).appName);
            break;
          }
        }
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new afm(this, localView1), 300L);
        localView1.setContentDescription(getString(2131362574));
      }
    }
  }
  
  public static String a(AppInterface paramAppInterface)
  {
    WtloginManager localWtloginManager = (WtloginManager)paramAppInterface.getManager(1);
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramAppInterface.getAccount())) || (localWtloginManager == null)) {
      return null;
    }
    paramAppInterface = localWtloginManager.GetLocalTicket(paramAppInterface.getAccount(), 16L, 4096);
    if (paramAppInterface != null)
    {
      long l1 = System.currentTimeMillis() / 1000L;
      if ((l1 > paramAppInterface._create_time) && (l1 < paramAppInterface._expire_time - 600L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, "local skey available");
        }
        return new String(paramAppInterface._sig);
      }
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new aeu(this, paramInt), 0L);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean1, int paramInt4, boolean paramBoolean2)
  {
    if (this.al == 2) {
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
    localIntent.putExtra("param_title", paramActivity.getString(2131362501));
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
      if (!NetworkUtil.e(this.app.getApplication().getApplicationContext()))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131363515, 1500);
        return;
      }
      this.ak |= 0x1;
      localObject1 = paramIntent.getStringExtra("nick");
      localObject2 = paramIntent.getStringExtra("phone");
      byte b1 = paramIntent.getByteExtra("sex", (byte)-1);
      String str1 = paramIntent.getStringExtra("mail");
      String str2 = paramIntent.getStringExtra("remark");
      paramIntent = new TroopMemberCardInfo();
      paramIntent.email = str1;
      paramIntent.memberuin = this.app.a();
      paramIntent.memo = str2;
      paramIntent.name = ((String)localObject1);
      paramIntent.sex = b1;
      paramIntent.tel = ((String)localObject2);
      paramIntent.troopuin = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString;
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(paramIntent);
      paramIntent = new ArrayList();
      paramIntent.add(Integer.valueOf(i2));
      localObject2 = (TroopHandler)this.app.a(17);
    } while (localObject2 == null);
    ((TroopHandler)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, (ArrayList)localObject1, paramIntent);
  }
  
  private void b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short = 1;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_n_of_type_JavaLangString = getString(2131363087);
      return;
    case 2: 
    case 4: 
    case 5: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short = 2;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_n_of_type_JavaLangString = getString(2131363088);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short = 3;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_n_of_type_JavaLangString = getString(2131363089);
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = new Intent(getActivity(), TroopDisbandActivity.class);
      ((Intent)localObject1).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f);
      ((Intent)localObject1).putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("leftViewText", 2131363671);
      startActivityForResult((Intent)localObject1, 6);
      localObject2 = this.app;
      if (!paramBoolean) {
        break label305;
      }
    }
    label305:
    for (Object localObject1 = "1";; localObject1 = "0")
    {
      ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", "Grp", "Clk_quit_grp", 0, 0, (String)localObject1, "", "", "");
      return;
      localObject2 = getString(2131363425);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f == null) {}
      for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString;; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f + "(" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString + ")")
      {
        localObject1 = String.format(getString(2131363421), new Object[] { localObject1 });
        localObject1 = DialogUtil.a(this, 230).setTitle((String)localObject2).setMessage((CharSequence)localObject1);
        ((QQCustomDialog)localObject1).setPositiveButton(getString(2131363039), new afu(this, (QQCustomDialog)localObject1));
        ((QQCustomDialog)localObject1).setPositiveButtonContentDescription(getString(2131361813));
        ((QQCustomDialog)localObject1).setNegativeButton(getString(2131362790), new afv(this, (QQCustomDialog)localObject1));
        ((QQCustomDialog)localObject1).setNegativeButtonContentDescription(getString(2131361814));
        ((QQCustomDialog)localObject1).show();
        break;
      }
    }
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null)
    {
      localObject = (FriendManager)this.app.getManager(8);
      if (localObject != null) {
        break label56;
      }
    }
    label56:
    for (Object localObject = null;; localObject = ((FriendManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && ((paramInt & 0x1) > 0)) {
        b(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cGroupOption);
      }
      return;
    }
  }
  
  private void e(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "saveTroopInfo| nModifyFlag = " + paramInt);
    }
    if ((paramInt & 0x3F) > 0) {}
    try
    {
      TroopHandler localTroopHandler = (TroopHandler)this.app.a(17);
      if (localTroopHandler != null)
      {
        localTroopHandler.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Short, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m, paramInt);
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
  
  private void x()
  {
    Intent localIntent = new Intent(this, ChatHistory.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    startActivityForResult(localIntent, 7);
  }
  
  private void y()
  {
    Intent localIntent = new Intent(this, ChatBackgroundSettingActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("bg_replace_entrance", 62);
    startActivityForResult(localIntent, 8);
  }
  
  private void z()
  {
    ReportController.b(this.app, "P_CliOper", "Grp_msg", "", "data_page", "Clk_set", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
    String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f;
    if (TextUtils.isEmpty(str)) {
      str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString;
    }
    for (;;)
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null, 2131624119);
      localActionSheet.a(getString(2131363867, new Object[] { str }));
      int i1 = DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.app);
      localActionSheet.b(getString(2131363868, new Object[] { StringUtil.a(BaseApplication.getContext(), i1) }));
      localActionSheet.a(getString(2131362536), false);
      localActionSheet.a(getString(2131362537), false);
      localActionSheet.a(getString(2131362538), false);
      i1 = this.app.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      switch (i1)
      {
      }
      for (;;)
      {
        localActionSheet.d(2131362790);
        localActionSheet.a(new afw(this, i1, localActionSheet));
        localActionSheet.show();
        return;
        localActionSheet.e(0);
        continue;
        localActionSheet.e(1);
        continue;
        localActionSheet.e(2);
      }
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
  
  protected Drawable a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
      return getResources().getDrawable(2130838380);
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_n_of_type_Int;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i()) {
      i1 = 0;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString;
    switch (i1)
    {
    default: 
      return getResources().getDrawable(2130838380);
    case 0: 
      return getResources().getDrawable(2130838380);
    case 1: 
      return getResources().getDrawable(2130838381);
    case 2: 
      return getResources().getDrawable(2130838382);
    case 3: 
      return getResources().getDrawable(2130838383);
    case 4: 
      return getResources().getDrawable(2130838384);
    }
    return getResources().getDrawable(2130838385);
  }
  
  @SuppressLint({"NewApi"})
  protected void a()
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = (LayoutInflater)getSystemService("layout_inflater");
    label2852:
    label3498:
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject3 = View.inflate(this, 2130903689, null);
        this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)((View)localObject3).findViewById(2131296783));
        this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)((View)localObject3).findViewById(2131298916));
        this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
        this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
        this.jdField_a_of_type_ArrayOfAndroidViewView = new View[19];
        this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
        localObject1 = new AbsListView.LayoutParams(-1, -2);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
        localObject1 = new XSimpleListAdapter(this.jdField_a_of_type_AndroidWidgetLinearLayout);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter((ListAdapter)localObject1);
        this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130837633);
        if (this.al == 2)
        {
          i1 = this.jdField_a_of_type_ComTencentWidgetXListView.getPaddingLeft();
          i2 = this.jdField_a_of_type_ComTencentWidgetXListView.getPaddingLeft();
          int i3 = getResources().getDimensionPixelOffset(2131493003);
          this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(i1, 0, i2, i3);
        }
        setContentView((View)localObject3);
        setTitle(getString(2131363669));
        setLeftViewName(2131363832);
        int i1 = this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels;
        int i2 = (i1 - getResources().getDimensionPixelSize(2131493046)) / 4;
        Object localObject6;
        TextView localTextView;
        ImageView localImageView;
        Object localObject7;
        boolean bool = false;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          localObject1 = View.inflate(this, 2130903296, null);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView = ((AvatarWallView)((View)localObject1).findViewById(2131296994));
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView.setColumnWidth(i2);
          if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e()) || (this.al != 1)) {
            break label2881;
          }
          bool = true;
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter = new AvatarWallAdapter(new WeakReference(this), this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean, this.jdField_a_of_type_AndroidOsHandler, bool, "Grp_Admin_data");
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView.setNumColumns(4);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(i2);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = new ImageView(this);
          ((ImageView)localObject1).setBackgroundResource(2130837995);
          localObject4 = new LinearLayout.LayoutParams(-1, 2);
          ((LinearLayout.LayoutParams)localObject4).setMargins((int)this.jdField_c_of_type_Float * 14, 0, (int)this.jdField_c_of_type_Float * 14, 0);
          ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = View.inflate(this, 2130903298, null);
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131296993));
          this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(true);
          this.jdField_a_of_type_AndroidWidgetTextView.setFocusableInTouchMode(true);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          if (bool) {
            break label2887;
          }
          ((View)localObject1).setVisibility(8);
          this.jdField_b_of_type_AndroidViewView = ((View)localObject1);
          localObject1 = View.inflate(this, 2130903372, null);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          this.jdField_a_of_type_ArrayOfAndroidViewView[12] = localObject1;
          localObject5 = (ImageView)((View)localObject1).findViewById(2131297604);
          localObject6 = (TextView)((View)localObject1).findViewById(2131297606);
          localTextView = (TextView)((View)localObject1).findViewById(2131297877);
          localImageView = (ImageView)((View)localObject1).findViewById(2131297879);
          localObject4 = ((View)localObject1).findViewById(2131297880);
          localObject7 = this.app.a(4, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, (byte)3, 0);
          localObject7 = this.app.a((String)localObject7);
          if (localObject7 != null)
          {
            ((ImageView)localObject5).setImageBitmap((Bitmap)localObject7);
            this.jdField_g_of_type_Boolean = true;
          }
          ((ImageView)localObject5).setTag(Integer.valueOf(26));
          ((ImageView)localObject5).setOnClickListener(this);
          ((ImageView)localObject5).setContentDescription(super.getString(2131362647));
          localTextView.setTag(Integer.valueOf(4));
          localTextView.setOnLongClickListener(this);
          ((TextView)localObject6).setTag(Integer.valueOf(4));
          ((TextView)localObject6).setOnLongClickListener(this);
          ((TextView)localObject6).setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f);
          localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
          localImageView.setImageDrawable(a());
          localImageView.setTag(Integer.valueOf(4));
          localImageView.setOnClickListener(this);
          localImageView.setContentDescription(String.format(getResources().getString(2131363036), new Object[] { Integer.valueOf(0) }));
          ((View)localObject4).setTag(Integer.valueOf(11));
          ((View)localObject4).setOnClickListener(this);
          localObject5 = (TextView)((View)localObject4).findViewById(2131296936);
          localObject6 = getResources().getDrawable(2130838424);
          ((Drawable)localObject6).setBounds(0, 0, ((Drawable)localObject6).getMinimumWidth(), ((Drawable)localObject6).getMinimumHeight());
          ((TextView)localObject5).setCompoundDrawables((Drawable)localObject6, null, null, null);
          ((TextView)localObject5).setCompoundDrawablePadding(10);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString)) {
            break label2958;
          }
          ((View)localObject4).setVisibility(8);
          ((View)localObject1).setBackgroundResource(2130837758);
          localObject1 = new ImageView(this);
          ((ImageView)localObject1).setBackgroundResource(2130837995);
          localObject4 = new LinearLayout.LayoutParams(-1, 2);
          ((LinearLayout.LayoutParams)localObject4).setMargins((int)this.jdField_c_of_type_Float * 14, 0, (int)this.jdField_c_of_type_Float * 14, 0);
          ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          t();
          this.ao = ((i1 - getResources().getDimensionPixelSize(2131493046) - PublicAccountUtil.a(this, 1.0F) * 3) / 4);
          localObject1 = View.inflate(this, 2130903188, null);
          ((View)localObject1).setBackgroundResource(2130837758);
          this.jdField_a_of_type_ArrayOfAndroidViewView[13] = localObject1;
          localObject4 = (ReboundHorizontalScrollView)((View)localObject1).findViewById(2131297093);
          if (Build.VERSION.SDK_INT >= 9) {
            ((ReboundHorizontalScrollView)localObject4).setOverScrollMode(2);
          }
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(this.ao, PublicAccountUtil.a(this, 65.0F));
          this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.gravity = 17;
          this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.weight = 1.0F;
          localObject1 = (LinearLayout)((View)localObject1).findViewById(2131297094);
          localObject4 = View.inflate(this, 2130903373, null);
          ((View)localObject4).setFocusable(true);
          ((View)localObject4).setClickable(true);
          ((LinearLayout)localObject1).setGravity(16);
          localObject5 = (TextView)((View)localObject4).findViewById(2131296455);
          localObject6 = (ImageView)((View)localObject4).findViewById(2131296453);
          ((TextView)localObject5).setText(2131362572);
          ((ImageView)localObject6).setImageResource(2130838425);
          ((View)localObject4).setTag(Integer.valueOf(0));
          ((View)localObject4).setOnClickListener(this);
          this.jdField_a_of_type_ArrayOfAndroidViewView[0] = localObject4;
          ((LinearLayout)localObject1).addView((View)localObject4, this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
          this.jdField_b_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(PublicAccountUtil.a(this, 1.0F), PublicAccountUtil.a(this, 25.0F));
          this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.gravity = 16;
          ((LinearLayout)localObject1).addView(View.inflate(this, 2130903375, null), this.jdField_b_of_type_AndroidWidgetLinearLayout$LayoutParams);
          localObject4 = View.inflate(this, 2130903373, null);
          ((View)localObject4).setFocusable(true);
          ((View)localObject4).setClickable(true);
          localObject5 = (TextView)((View)localObject4).findViewById(2131296455);
          localObject6 = (ImageView)((View)localObject4).findViewById(2131296453);
          ((TextView)localObject5).setText(2131362967);
          ((ImageView)localObject6).setImageResource(2130838418);
          ((View)localObject4).setTag(Integer.valueOf(1));
          ((View)localObject4).setOnClickListener(this);
          this.jdField_a_of_type_ArrayOfAndroidViewView[1] = localObject4;
          ((LinearLayout)localObject1).addView((View)localObject4, this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
          localObject1 = new ImageView(this);
          ((ImageView)localObject1).setBackgroundResource(2130837995);
          localObject4 = new LinearLayout.LayoutParams(-1, 2);
          ((LinearLayout.LayoutParams)localObject4).setMargins((int)this.jdField_c_of_type_Float * 14, 0, (int)this.jdField_c_of_type_Float * 14, 0);
          ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          if (this.al == 1)
          {
            localObject1 = View.inflate(this, 2130903569, null);
            this.jdField_a_of_type_ArrayOfAndroidViewView[2] = localObject1;
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            a(2, 2, (View)localObject1, getString(2131363034), "", true, 0, false);
            localObject1 = new ImageView(this);
            ((ImageView)localObject1).setBackgroundResource(2130837995);
            localObject4 = new LinearLayout.LayoutParams(-1, 2);
            ((LinearLayout.LayoutParams)localObject4).setMargins((int)this.jdField_c_of_type_Float * 14, 0, (int)this.jdField_c_of_type_Float * 14, 0);
            ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          }
          if (this.al != 1) {
            break label3052;
          }
          localObject1 = View.inflate(this, 2130903566, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[7] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_g_of_type_JavaLangString)) {
            break label2979;
          }
          a(7, 2, (View)localObject1, getString(2131363081), this.app.c(), true);
          localObject1 = new ImageView(this);
          ((ImageView)localObject1).setBackgroundResource(2130837995);
          localObject4 = new LinearLayout.LayoutParams(-1, 2);
          ((LinearLayout.LayoutParams)localObject4).setMargins((int)this.jdField_c_of_type_Float * 14, 0, (int)this.jdField_c_of_type_Float * 14, 0);
          ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = View.inflate(this, 2130903573, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[3] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject4 = new ImageView(this);
          ((ImageView)localObject4).setBackgroundResource(2130837995);
          localObject5 = new LinearLayout.LayoutParams(-1, 2);
          ((LinearLayout.LayoutParams)localObject5).setMargins((int)this.jdField_c_of_type_Float * 14, 0, (int)this.jdField_c_of_type_Float * 14, 0);
          ((ImageView)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject4);
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e()) {
            break label3006;
          }
          a(3, 2, (View)localObject1, getString(2131362839), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_h_of_type_JavaLangString, true);
          a((View)localObject1);
          localObject1 = View.inflate(this, 2130903571, null);
          a(6, 2, (FormSimpleItem)((View)localObject1).findViewById(2131298569), getString(2131363102), "", true);
          this.jdField_a_of_type_ArrayOfAndroidViewView[6] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e()) {
            break label3032;
          }
          ((View)localObject1).setVisibility(0);
          localObject1 = new ImageView(this);
          ((ImageView)localObject1).setBackgroundResource(2130837995);
          localObject4 = new LinearLayout.LayoutParams(-1, 2);
          ((LinearLayout.LayoutParams)localObject4).setMargins((int)this.jdField_c_of_type_Float * 14, 0, (int)this.jdField_c_of_type_Float * 14, 0);
          ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = new FormSimpleItem(this);
          a(17, 2, (FormSimpleItem)localObject1, getString(2131363689), "", true);
          this.jdField_a_of_type_ArrayOfAndroidViewView[17] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = new ImageView(this);
          ((ImageView)localObject1).setBackgroundResource(2130837995);
          localObject4 = new LinearLayout.LayoutParams(-1, 2);
          ((LinearLayout.LayoutParams)localObject4).setMargins((int)this.jdField_c_of_type_Float * 14, 0, (int)this.jdField_c_of_type_Float * 14, 0);
          ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = new FormSimpleItem(this);
          a(21, 2, (FormSimpleItem)localObject1, getString(2131363080), "", true);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = new ImageView(this);
          ((ImageView)localObject1).setBackgroundResource(2130837995);
          localObject4 = new LinearLayout.LayoutParams(-1, 2);
          ((LinearLayout.LayoutParams)localObject4).setMargins((int)this.jdField_c_of_type_Float * 14, 0, (int)this.jdField_c_of_type_Float * 14, 0);
          ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = new FormSimpleItem(this);
          a(20, 2, (FormSimpleItem)localObject1, getString(2131363539), "", true);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = new ImageView(this);
          ((ImageView)localObject1).setBackgroundResource(2130837995);
          localObject4 = new LinearLayout.LayoutParams(-1, 2);
          ((LinearLayout.LayoutParams)localObject4).setMargins((int)this.jdField_c_of_type_Float * 14, 0, (int)this.jdField_c_of_type_Float * 14, 0);
          ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = View.inflate(this, 2130903571, null);
          a(8, 2, (FormSimpleItem)((View)localObject1).findViewById(2131298569), getString(2131363076), "", true);
          this.jdField_a_of_type_ArrayOfAndroidViewView[8] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = View.inflate(this, 2130903575, null);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = View.inflate(this, 2130903570, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[15] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m)) {
            break label3042;
          }
          localObject4 = new ImageView(this);
          ((ImageView)localObject4).setBackgroundResource(2130837995);
          localObject5 = new LinearLayout.LayoutParams(-1, 2);
          ((LinearLayout.LayoutParams)localObject5).setMargins((int)this.jdField_c_of_type_Float * 14, 0, (int)this.jdField_c_of_type_Float * 14, 0);
          ((ImageView)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject4);
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m;
          b(15, 0, (View)localObject1, getString(2131363029), (CharSequence)localObject4, false);
          localObject1 = new ImageView(this);
          ((ImageView)localObject1).setBackgroundResource(2130837995);
          localObject4 = new LinearLayout.LayoutParams(-1, 2);
          ((LinearLayout.LayoutParams)localObject4).setMargins((int)this.jdField_c_of_type_Float * 14, 0, (int)this.jdField_c_of_type_Float * 14, 0);
          ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = View.inflate(this, 2130903575, null);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          if (QLog.isColorLevel()) {
            QLog.i("Q.chatopttroop", 2, "initUI: time = " + (System.currentTimeMillis() - l1));
          }
          this.p.setVisibility(0);
          this.p.setImageResource(2130838044);
          this.p.setContentDescription(getString(2131362535));
          this.p.setOnClickListener(new afq(this));
          this.jdField_a_of_type_AndroidViewView = ((View)localObject3).findViewById(2131297534);
          if (this.al == 2)
          {
            localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298563);
            localObject3 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298564);
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
            if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean) {
              break label3498;
            }
            ((ImageView)localObject1).setImageResource(2130838304);
            ((TextView)localObject3).setText(2131363893);
            this.jdField_a_of_type_AndroidViewView.setTag(Integer.valueOf(24));
            this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
          }
          a(false);
          this.jdField_a_of_type_ComTencentWidgetXListView.getViewTreeObserver().addOnGlobalLayoutListener(new afr(this));
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          if (!QLog.isColorLevel()) {
            break label2852;
          }
          QLog.d("Q.chatopttroop", 2, localOutOfMemoryError2.getMessage());
          finish();
          return;
        }
        catch (InflateException localInflateException)
        {
          if (!QLog.isColorLevel()) {
            break label2876;
          }
          QLog.d("Q.chatopttroop", 2, localInflateException.getMessage());
          finish();
          return;
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        finish();
        localOutOfMemoryError1.printStackTrace();
        return;
      }
      label2876:
      label2881:
      continue;
      label2887:
      Object localObject4 = new ImageView(this);
      ((ImageView)localObject4).setBackgroundResource(2130837995);
      Object localObject5 = new LinearLayout.LayoutParams(-1, 2);
      ((LinearLayout.LayoutParams)localObject5).setMargins((int)this.jdField_c_of_type_Float * 14, 0, (int)this.jdField_c_of_type_Float * 14, 0);
      ((ImageView)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject4);
      continue;
      ((View)localObject4).setVisibility(0);
      ((TextView)localObject5).setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString);
      continue;
      a(7, 2, localInflateException, getString(2131363081), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_g_of_type_JavaLangString, true);
      continue;
      label3006:
      a(3, 2, localInflateException, getString(2131362839), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_h_of_type_JavaLangString, true);
      continue;
      label3032:
      localInflateException.setVisibility(8);
      continue;
      label3042:
      localInflateException.setVisibility(8);
      continue;
      label3052:
      if (this.al == 2)
      {
        Object localObject2 = View.inflate(this, 2130903573, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[16] = localObject2;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
        a(16, 1, (View)localObject2, getString(2131362867), getString(2131362869), true);
        a((View)localObject2);
        localObject2 = new ImageView(this);
        ((ImageView)localObject2).setBackgroundResource(2130837995);
        localObject4 = new LinearLayout.LayoutParams(-1, 2);
        ((LinearLayout.LayoutParams)localObject4).setMargins((int)this.jdField_c_of_type_Float * 14, 0, (int)this.jdField_c_of_type_Float * 14, 0);
        ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
        localObject4 = View.inflate(this, 2130903574, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[18] = localObject4;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject4);
        localObject2 = new ImageView(this);
        ((ImageView)localObject2).setBackgroundResource(2130837995);
        localObject5 = new LinearLayout.LayoutParams(-1, 2);
        ((LinearLayout.LayoutParams)localObject5).setMargins((int)this.jdField_c_of_type_Float * 14, 0, (int)this.jdField_c_of_type_Float * 14, 0);
        ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject5);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
        localObject2 = "";
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_h_of_type_JavaLangString != null) {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_h_of_type_JavaLangString;
        }
        a(18, 3, (View)localObject4, getString(2131362839), (CharSequence)localObject2, true);
        f();
        localObject2 = View.inflate(this, 2130903575, null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
        localObject2 = View.inflate(this, 2130903570, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[15] = localObject2;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m))
        {
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m;
          b(15, 0, (View)localObject2, getString(2131363029), (CharSequence)localObject4, false);
          localObject2 = new ImageView(this);
          ((ImageView)localObject2).setBackgroundResource(2130837995);
          localObject4 = new LinearLayout.LayoutParams(-1, 2);
          ((LinearLayout.LayoutParams)localObject4).setMargins((int)this.jdField_c_of_type_Float * 14, 0, (int)this.jdField_c_of_type_Float * 14, 0);
          ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
        }
        else
        {
          ((View)localObject2).setVisibility(8);
          continue;
          if (this.an == 2) {
            ReportController.b(this.app, "P_CliOper", "Grp_discuss", "", "discuss_AIO", "Clk_objgrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
          }
          ((ImageView)localObject2).setImageResource(2130838244);
          ((TextView)localObject3).setText(2131362803);
          this.jdField_a_of_type_AndroidViewView.setTag(Integer.valueOf(25));
          this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        }
      }
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[18];
    if (localObject == null) {}
    String str;
    do
    {
      return;
      str = String.format(getString(2131363646), new Object[] { Integer.valueOf(paramInt1) });
      localObject = (TextView)((View)localObject).findViewById(2131296957);
    } while (localObject == null);
    ((TextView)localObject).setText(str);
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramView, paramString, paramBoolean);
    paramString = (TextView)paramView.findViewById(2131296957);
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
    paramString = (TextView)paramView.findViewById(2131296957);
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
    }
    for (;;)
    {
      paramView.setBackgroundResource(2130837758);
      TextView localTextView = (TextView)paramView.findViewById(2131296936);
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      localTextView.setText(str);
      a(paramInt1, paramView, paramBoolean);
      return;
      paramView.setTag(null);
      paramView.setOnClickListener(null);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, FormSimpleItem paramFormSimpleItem, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramFormSimpleItem.setTag(Integer.valueOf(paramInt1));
      paramFormSimpleItem.setOnClickListener(this);
      paramFormSimpleItem.setBgType(paramInt2);
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      paramFormSimpleItem.setLeftText(str);
      paramFormSimpleItem.setLeftTextColor(0);
      paramFormSimpleItem.b().setEditableFactory(QQTextBuilder.a);
      if (paramCharSequence != null) {
        break label88;
      }
    }
    label88:
    for (paramString = "";; paramString = new QQText(paramCharSequence, 3))
    {
      paramFormSimpleItem.setRightText(paramString);
      return;
      paramFormSimpleItem.setTag(null);
      paramFormSimpleItem.setOnClickListener(null);
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
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f = paramIntent.getStringExtra("name");
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long = paramIntent.getLongExtra("class", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m = paramIntent.getStringExtra("intro");
    k();
  }
  
  protected void a(int paramInt, View paramView, boolean paramBoolean)
  {
    int i1 = 0;
    if (paramView == null) {
      return;
    }
    boolean bool = paramBoolean;
    if (this.al == 2)
    {
      bool = paramBoolean;
      if (15 == paramInt) {
        bool = false;
      }
    }
    paramView = paramView.findViewById(2131297748);
    if (bool) {}
    for (paramInt = i1;; paramInt = 8)
    {
      paramView.setVisibility(paramInt);
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
        localTextView = (TextView)localView.findViewById(2131296957);
        if (paramInt != 15) {
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
            localImageView.setBackgroundDrawable(this.app.b(Long.toString(paramLong)));
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
  public void a(KQQ.BatchResponse paramBatchResponse)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: getfield 1527	KQQ/BatchResponse:result	I
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: new 1529	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   15: dup
    //   16: invokespecial 1530	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   19: astore 10
    //   21: aload 10
    //   23: aload_1
    //   24: getfield 1533	KQQ/BatchResponse:buffer	[B
    //   27: checkcast 1534	[B
    //   30: invokevirtual 1538	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   33: pop
    //   34: aload_1
    //   35: getfield 1541	KQQ/BatchResponse:seq	I
    //   38: ifne +200 -> 238
    //   41: aload 10
    //   43: ifnull +195 -> 238
    //   46: aload 10
    //   48: getfield 1545	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   51: invokevirtual 1550	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   54: ifeq +184 -> 238
    //   57: aload 10
    //   59: getfield 1545	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   62: invokevirtual 1553	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   65: invokevirtual 1559	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   68: astore 9
    //   70: new 1561	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   73: dup
    //   74: invokespecial 1562	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   77: astore 8
    //   79: aload 8
    //   81: aload 9
    //   83: invokevirtual 1563	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   86: pop
    //   87: aconst_null
    //   88: astore 9
    //   90: aload 8
    //   92: getfield 1567	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   95: invokevirtual 1571	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   98: astore 11
    //   100: aload 11
    //   102: ifnonnull +57 -> 159
    //   105: iconst_0
    //   106: istore_2
    //   107: goto +1378 -> 1485
    //   110: aload 9
    //   112: ifnonnull +126 -> 238
    //   115: iload_3
    //   116: iload_2
    //   117: if_icmpge +121 -> 238
    //   120: aload 11
    //   122: iload_3
    //   123: invokeinterface 1506 2 0
    //   128: checkcast 1573	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
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
    //   155: invokevirtual 1574	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   158: return
    //   159: aload 11
    //   161: invokeinterface 483 1 0
    //   166: istore_2
    //   167: goto +1318 -> 1485
    //   170: aload 12
    //   172: getfield 1578	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   175: invokevirtual 1582	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   178: istore 4
    //   180: iload 4
    //   182: bipush 72
    //   184: if_icmpne +421 -> 605
    //   187: iload_3
    //   188: ifne +417 -> 605
    //   191: aload_0
    //   192: getfield 203	com/tencent/mobileqq/activity/ChatSettingForTroop:al	I
    //   195: iconst_1
    //   196: if_icmpne +378 -> 574
    //   199: aload_0
    //   200: ldc_w 1583
    //   203: iconst_1
    //   204: invokestatic 1588	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   207: invokevirtual 1591	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   210: pop
    //   211: aload 9
    //   213: astore 8
    //   215: goto -73 -> 142
    //   218: astore 8
    //   220: invokestatic 684	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +15 -> 238
    //   226: ldc_w 1593
    //   229: iconst_2
    //   230: aload 8
    //   232: invokevirtual 737	java/lang/Exception:toString	()Ljava/lang/String;
    //   235: invokestatic 739	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   238: aload_1
    //   239: getfield 1541	KQQ/BatchResponse:seq	I
    //   242: iconst_1
    //   243: if_icmpne +81 -> 324
    //   246: aload 10
    //   248: ifnull +76 -> 324
    //   251: aload 10
    //   253: getfield 1545	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   256: invokevirtual 1550	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   259: ifeq +65 -> 324
    //   262: aload 10
    //   264: getfield 1545	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   267: invokevirtual 1553	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   270: invokevirtual 1559	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   273: astore 8
    //   275: new 1595	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody
    //   278: dup
    //   279: invokespecial 1596	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:<init>	()V
    //   282: astore 9
    //   284: aload 9
    //   286: aload 8
    //   288: invokevirtual 1597	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   291: pop
    //   292: aload 9
    //   294: getfield 1600	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   297: ifnull +27 -> 324
    //   300: aload_0
    //   301: aload 9
    //   303: getfield 1600	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   306: invokevirtual 1571	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   309: invokevirtual 1603	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Ljava/util/List;)V
    //   312: aload_0
    //   313: aload 9
    //   315: getfield 1600	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   318: invokevirtual 1571	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   321: putfield 1605	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   324: aload_1
    //   325: getfield 1541	KQQ/BatchResponse:seq	I
    //   328: iconst_2
    //   329: if_icmpne -318 -> 11
    //   332: aload 10
    //   334: ifnull -323 -> 11
    //   337: aload 10
    //   339: getfield 1545	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   342: invokevirtual 1550	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   345: ifeq -334 -> 11
    //   348: aload 10
    //   350: getfield 1545	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   353: invokevirtual 1553	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   356: invokevirtual 1559	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   359: astore_1
    //   360: new 1607	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody
    //   363: dup
    //   364: invokespecial 1608	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:<init>	()V
    //   367: astore 8
    //   369: aload 8
    //   371: aload_1
    //   372: invokevirtual 1609	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   375: pop
    //   376: aload 8
    //   378: getfield 1612	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   381: invokevirtual 1571	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   384: astore_1
    //   385: aload 8
    //   387: getfield 1615	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_member_level_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   390: invokevirtual 1571	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   393: astore 9
    //   395: aload 8
    //   397: getfield 1618	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   400: invokevirtual 1582	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   403: istore_2
    //   404: aload_0
    //   405: getfield 281	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   408: invokevirtual 1621	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   411: lstore 6
    //   413: iload_2
    //   414: ifeq -403 -> 11
    //   417: aload_1
    //   418: ifnull -407 -> 11
    //   421: aload_1
    //   422: invokeinterface 483 1 0
    //   427: ifle -416 -> 11
    //   430: aload 9
    //   432: ifnull -421 -> 11
    //   435: aload 9
    //   437: invokeinterface 483 1 0
    //   442: ifle -431 -> 11
    //   445: aload 9
    //   447: invokeinterface 483 1 0
    //   452: istore_3
    //   453: iconst_0
    //   454: istore_2
    //   455: iload_2
    //   456: iload_3
    //   457: if_icmpge -446 -> 11
    //   460: aload 9
    //   462: iload_2
    //   463: invokeinterface 1506 2 0
    //   468: checkcast 1623	tencent/im/oidb/cmd0x787/oidb_0x787$MemberLevelInfo
    //   471: astore 8
    //   473: aload 8
    //   475: ifnull +997 -> 1472
    //   478: lload 6
    //   480: aload 8
    //   482: getfield 1627	tencent/im/oidb/cmd0x787/oidb_0x787$MemberLevelInfo:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   485: invokevirtual 1631	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   488: lcmp
    //   489: ifne +983 -> 1472
    //   492: aload 8
    //   494: getfield 1634	tencent/im/oidb/cmd0x787/oidb_0x787$MemberLevelInfo:uint32_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   497: invokevirtual 1582	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   500: istore_3
    //   501: aload_1
    //   502: invokeinterface 483 1 0
    //   507: istore 4
    //   509: iconst_0
    //   510: istore_2
    //   511: iload_2
    //   512: iload 4
    //   514: if_icmpge -503 -> 11
    //   517: aload_1
    //   518: iload_2
    //   519: invokeinterface 1506 2 0
    //   524: checkcast 1636	tencent/im/oidb/cmd0x787/oidb_0x787$LevelName
    //   527: astore 8
    //   529: aload 8
    //   531: getfield 1637	tencent/im/oidb/cmd0x787/oidb_0x787$LevelName:uint32_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   534: invokevirtual 1582	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   537: iload_3
    //   538: if_icmpne +29 -> 567
    //   541: aload 8
    //   543: getfield 1640	tencent/im/oidb/cmd0x787/oidb_0x787$LevelName:str_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   546: invokevirtual 1550	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   549: ifeq +18 -> 567
    //   552: aload_0
    //   553: aload 8
    //   555: getfield 1640	tencent/im/oidb/cmd0x787/oidb_0x787$LevelName:str_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   558: invokevirtual 1553	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   561: invokevirtual 1643	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   564: invokevirtual 1645	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Ljava/lang/String;)V
    //   567: iload_2
    //   568: iconst_1
    //   569: iadd
    //   570: istore_2
    //   571: goto -60 -> 511
    //   574: aload 9
    //   576: astore 8
    //   578: aload_0
    //   579: getfield 203	com/tencent/mobileqq/activity/ChatSettingForTroop:al	I
    //   582: iconst_2
    //   583: if_icmpne -441 -> 142
    //   586: aload_0
    //   587: ldc_w 1646
    //   590: iconst_1
    //   591: invokestatic 1588	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   594: invokevirtual 1591	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   597: pop
    //   598: aload 9
    //   600: astore 8
    //   602: goto -460 -> 142
    //   605: aload 9
    //   607: astore 8
    //   609: iload 4
    //   611: ifne -469 -> 142
    //   614: aload 9
    //   616: astore 8
    //   618: aload 12
    //   620: getfield 1650	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   623: invokevirtual 1653	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   626: ifeq -484 -> 142
    //   629: aload 12
    //   631: getfield 1650	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   634: invokevirtual 1656	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   637: checkcast 1652	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   640: astore 9
    //   642: aload 9
    //   644: astore 8
    //   646: aload 9
    //   648: ifnull -506 -> 142
    //   651: aload_0
    //   652: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   655: ifnull +537 -> 1192
    //   658: aload_0
    //   659: getfield 468	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   662: bipush 12
    //   664: aaload
    //   665: astore 8
    //   667: aload 9
    //   669: getfield 1659	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   672: invokevirtual 1550	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   675: ifeq +42 -> 717
    //   678: aload_0
    //   679: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   682: aload 9
    //   684: getfield 1659	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   687: invokevirtual 1553	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   690: invokevirtual 1643	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   693: putfield 364	com/tencent/mobileqq/troopinfo/TroopInfoData:f	Ljava/lang/String;
    //   696: aload 8
    //   698: ldc_w 1237
    //   701: invokevirtual 475	android/view/View:findViewById	(I)Landroid/view/View;
    //   704: checkcast 529	android/widget/TextView
    //   707: aload_0
    //   708: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   711: getfield 364	com/tencent/mobileqq/troopinfo/TroopInfoData:f	Ljava/lang/String;
    //   714: invokevirtual 536	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   717: aload_0
    //   718: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   721: aload 9
    //   723: getfield 1662	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_grade	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   726: invokevirtual 1582	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   729: putfield 1078	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_n_of_type_Int	I
    //   732: aload_0
    //   733: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   736: aload 9
    //   738: getfield 1665	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_active_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   741: invokevirtual 1582	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   744: putfield 1667	com/tencent/mobileqq/troopinfo/TroopInfoData:o	I
    //   747: aload_0
    //   748: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   751: aload 9
    //   753: getfield 1670	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flag_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   756: invokevirtual 1582	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   759: i2l
    //   760: putfield 1672	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_b_of_type_Long	J
    //   763: aload_0
    //   764: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   767: aload 9
    //   769: getfield 1675	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_certification_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   772: invokevirtual 1582	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   775: i2l
    //   776: putfield 1677	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_Long	J
    //   779: aload_0
    //   780: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   783: aload 9
    //   785: getfield 1680	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_class_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   788: invokevirtual 1582	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   791: i2l
    //   792: putfield 991	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Long	J
    //   795: aload_0
    //   796: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   799: aload 9
    //   801: getfield 1683	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   804: invokevirtual 1582	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   807: putfield 1685	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_Int	I
    //   810: aload_0
    //   811: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   814: aload 9
    //   816: getfield 1688	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_type_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   819: invokevirtual 1582	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   822: putfield 1690	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_r_of_type_Int	I
    //   825: aload_0
    //   826: invokevirtual 1692	com/tencent/mobileqq/activity/ChatSettingForTroop:v	()V
    //   829: aload 9
    //   831: getfield 1695	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_class_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   834: invokevirtual 1550	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   837: ifeq +42 -> 879
    //   840: aload_0
    //   841: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   844: aload 9
    //   846: getfield 1695	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_class_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   849: invokevirtual 1553	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   852: invokevirtual 1643	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   855: putfield 1697	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   858: aload_0
    //   859: getfield 964	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   862: ifnull +17 -> 879
    //   865: aload_0
    //   866: getfield 964	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   869: aload_0
    //   870: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   873: getfield 1697	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   876: putfield 1700	com/tencent/mobileqq/data/TroopInfo:mGroupClassExtText	Ljava/lang/String;
    //   879: aload_0
    //   880: aload_0
    //   881: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   884: invokestatic 1705	com/tencent/mobileqq/activity/TroopInfoActivity:a	(Landroid/content/Context;Lcom/tencent/mobileqq/troopinfo/TroopInfoData;)Ljava/lang/String;
    //   887: pop
    //   888: aload 9
    //   890: getfield 1709	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:group_geo_info	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo;
    //   893: invokevirtual 1712	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   896: checkcast 1711	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo
    //   899: astore 8
    //   901: aload 8
    //   903: getfield 1715	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo:bytes_geocontent	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   906: invokevirtual 1553	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   909: invokevirtual 1643	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   912: astore 12
    //   914: aload 8
    //   916: getfield 1719	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo:int64_latitude	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   919: invokevirtual 1722	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   922: l2i
    //   923: istore 4
    //   925: aload 8
    //   927: getfield 1725	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo:int64_longitude	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   930: invokevirtual 1722	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   933: l2i
    //   934: istore 5
    //   936: aload 12
    //   938: invokestatic 379	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   941: ifne +12 -> 953
    //   944: aload_0
    //   945: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   948: aload 12
    //   950: putfield 1285	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   953: iload 4
    //   955: ifeq +12 -> 967
    //   958: aload_0
    //   959: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   962: iload 4
    //   964: putfield 1470	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_d_of_type_Int	I
    //   967: iload 5
    //   969: ifeq +12 -> 981
    //   972: aload_0
    //   973: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   976: iload 5
    //   978: putfield 1474	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_e_of_type_Int	I
    //   981: aload_0
    //   982: invokevirtual 1485	com/tencent/mobileqq/activity/ChatSettingForTroop:k	()V
    //   985: aload 9
    //   987: getfield 1728	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_finger_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   990: invokevirtual 1550	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   993: ifeq +383 -> 1376
    //   996: aload_0
    //   997: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1000: aload 9
    //   1002: getfield 1728	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_finger_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1005: invokevirtual 1553	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1008: invokevirtual 1643	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1011: putfield 1729	com/tencent/mobileqq/troopinfo/TroopInfoData:l	Ljava/lang/String;
    //   1014: aload 9
    //   1016: getfield 1732	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_rich_finger_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1019: invokevirtual 1550	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1022: ifeq +367 -> 1389
    //   1025: aload_0
    //   1026: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1029: aload 9
    //   1031: getfield 1732	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_rich_finger_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1034: invokevirtual 1553	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1037: invokevirtual 1643	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1040: putfield 997	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   1043: aload_0
    //   1044: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1047: getfield 997	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   1050: invokestatic 379	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1053: ifeq +349 -> 1402
    //   1056: aload_0
    //   1057: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1060: aload_0
    //   1061: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1064: getfield 1729	com/tencent/mobileqq/troopinfo/TroopInfoData:l	Ljava/lang/String;
    //   1067: putfield 997	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   1070: aload_0
    //   1071: getfield 468	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   1074: bipush 15
    //   1076: aaload
    //   1077: astore 8
    //   1079: aload 8
    //   1081: ifnull +46 -> 1127
    //   1084: aload_0
    //   1085: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1088: getfield 997	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   1091: invokestatic 379	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1094: ifne +345 -> 1439
    //   1097: aload 8
    //   1099: iconst_0
    //   1100: invokevirtual 1232	android/view/View:setVisibility	(I)V
    //   1103: aload_0
    //   1104: bipush 15
    //   1106: iconst_0
    //   1107: aload 8
    //   1109: aload_0
    //   1110: ldc_w 1362
    //   1113: invokevirtual 636	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   1116: aload_0
    //   1117: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1120: getfield 997	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   1123: iconst_0
    //   1124: invokevirtual 1364	com/tencent/mobileqq/activity/ChatSettingForTroop:b	(IILandroid/view/View;Ljava/lang/String;Ljava/lang/CharSequence;Z)V
    //   1127: aload_0
    //   1128: invokevirtual 1734	com/tencent/mobileqq/activity/ChatSettingForTroop:e	()V
    //   1131: aload 9
    //   1133: getfield 1670	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flag_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1136: invokevirtual 1735	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1139: ifeq +18 -> 1157
    //   1142: aload_0
    //   1143: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1146: aload 9
    //   1148: getfield 1670	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flag_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1151: invokevirtual 1582	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1154: putfield 1737	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_p_of_type_Int	I
    //   1157: aload_0
    //   1158: getfield 964	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1161: ifnull +31 -> 1192
    //   1164: aload_0
    //   1165: getfield 964	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1168: aload_0
    //   1169: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1172: getfield 1729	com/tencent/mobileqq/troopinfo/TroopInfoData:l	Ljava/lang/String;
    //   1175: putfield 1740	com/tencent/mobileqq/data/TroopInfo:fingertroopmemo	Ljava/lang/String;
    //   1178: aload_0
    //   1179: getfield 964	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1182: aload_0
    //   1183: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1186: getfield 997	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   1189: putfield 1743	com/tencent/mobileqq/data/TroopInfo:mRichFingerMemo	Ljava/lang/String;
    //   1192: aload 9
    //   1194: getfield 1746	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_max_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1197: invokevirtual 1735	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1200: ifeq +93 -> 1293
    //   1203: aload 9
    //   1205: getfield 1746	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_max_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1208: invokevirtual 1582	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1211: ifle +82 -> 1293
    //   1214: aload 9
    //   1216: getfield 1683	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1219: invokevirtual 1735	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1222: ifeq +71 -> 1293
    //   1225: aload 9
    //   1227: getfield 1683	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1230: invokevirtual 1582	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1233: ifle +60 -> 1293
    //   1236: aload_0
    //   1237: getfield 964	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1240: ifnull +33 -> 1273
    //   1243: aload_0
    //   1244: getfield 964	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1247: aload 9
    //   1249: getfield 1746	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_max_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1252: invokevirtual 1582	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1255: putfield 1749	com/tencent/mobileqq/data/TroopInfo:wMemberMax	I
    //   1258: aload_0
    //   1259: getfield 964	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1262: aload 9
    //   1264: getfield 1683	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1267: invokevirtual 1582	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1270: putfield 1752	com/tencent/mobileqq/data/TroopInfo:wMemberNum	I
    //   1273: aload_0
    //   1274: aload 9
    //   1276: getfield 1683	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1279: invokevirtual 1582	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1282: aload 9
    //   1284: getfield 1746	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_max_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1287: invokevirtual 1582	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1290: invokevirtual 1753	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(II)V
    //   1293: aload_0
    //   1294: getfield 964	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1297: ifnull +19 -> 1316
    //   1300: aload_0
    //   1301: getfield 964	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1304: aload 9
    //   1306: getfield 1670	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flag_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1309: invokevirtual 1582	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1312: i2l
    //   1313: putfield 1756	com/tencent/mobileqq/data/TroopInfo:dwGroupFlagExt	J
    //   1316: aload_0
    //   1317: invokevirtual 1289	com/tencent/mobileqq/activity/ChatSettingForTroop:t	()V
    //   1320: aload 9
    //   1322: astore 8
    //   1324: aload 9
    //   1326: getfield 1759	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint64_group_owner	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1329: invokevirtual 1760	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   1332: ifeq -1190 -> 142
    //   1335: aload_0
    //   1336: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1339: new 314	java/lang/StringBuilder
    //   1342: dup
    //   1343: invokespecial 315	java/lang/StringBuilder:<init>	()V
    //   1346: ldc_w 594
    //   1349: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1352: aload 9
    //   1354: getfield 1759	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint64_group_owner	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1357: invokevirtual 1631	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1360: invokevirtual 592	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1363: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1366: putfield 1762	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_p_of_type_JavaLangString	Ljava/lang/String;
    //   1369: aload 9
    //   1371: astore 8
    //   1373: goto -1231 -> 142
    //   1376: aload_0
    //   1377: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1380: ldc_w 594
    //   1383: putfield 1729	com/tencent/mobileqq/troopinfo/TroopInfoData:l	Ljava/lang/String;
    //   1386: goto -372 -> 1014
    //   1389: aload_0
    //   1390: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1393: ldc_w 594
    //   1396: putfield 997	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   1399: goto -356 -> 1043
    //   1402: aload_0
    //   1403: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1406: aload_0
    //   1407: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1410: getfield 997	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   1413: invokestatic 1766	com/tencent/biz/common/util/HttpUtil:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1416: putfield 997	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   1419: aload_0
    //   1420: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1423: aload_0
    //   1424: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1427: getfield 997	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   1430: invokestatic 1768	com/tencent/biz/common/util/HttpUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1433: putfield 997	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   1436: goto -366 -> 1070
    //   1439: aload 8
    //   1441: bipush 8
    //   1443: invokevirtual 1232	android/view/View:setVisibility	(I)V
    //   1446: goto -319 -> 1127
    //   1449: astore 8
    //   1451: invokestatic 684	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1454: ifeq -1130 -> 324
    //   1457: ldc_w 1593
    //   1460: iconst_2
    //   1461: aload 8
    //   1463: invokevirtual 737	java/lang/Exception:toString	()Ljava/lang/String;
    //   1466: invokestatic 739	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1469: goto -1145 -> 324
    //   1472: iload_2
    //   1473: iconst_1
    //   1474: iadd
    //   1475: istore_2
    //   1476: goto -1021 -> 455
    //   1479: astore_1
    //   1480: aload_1
    //   1481: invokevirtual 1519	java/lang/Exception:printStackTrace	()V
    //   1484: return
    //   1485: iconst_0
    //   1486: istore_3
    //   1487: goto -1377 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1490	0	this	ChatSettingForTroop
    //   0	1490	1	paramBatchResponse	KQQ.BatchResponse
    //   106	1370	2	i1	int
    //   115	1372	3	i2	int
    //   178	785	4	i3	int
    //   934	43	5	i4	int
    //   411	68	6	l1	long
    //   77	137	8	localObject1	Object
    //   218	13	8	localException1	Exception
    //   273	1167	8	localObject2	Object
    //   1449	13	8	localException2	Exception
    //   68	1302	9	localObject3	Object
    //   19	330	10	localOIDBSSOPkg	tencent.im.oidb.oidb_sso.OIDBSSOPkg
    //   98	62	11	localList	List
    //   131	818	12	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   21	34	153	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   70	87	218	java/lang/Exception
    //   90	100	218	java/lang/Exception
    //   120	133	218	java/lang/Exception
    //   159	167	218	java/lang/Exception
    //   170	180	218	java/lang/Exception
    //   191	211	218	java/lang/Exception
    //   578	598	218	java/lang/Exception
    //   618	642	218	java/lang/Exception
    //   651	717	218	java/lang/Exception
    //   717	879	218	java/lang/Exception
    //   879	953	218	java/lang/Exception
    //   958	967	218	java/lang/Exception
    //   972	981	218	java/lang/Exception
    //   981	1014	218	java/lang/Exception
    //   1014	1043	218	java/lang/Exception
    //   1043	1070	218	java/lang/Exception
    //   1070	1079	218	java/lang/Exception
    //   1084	1127	218	java/lang/Exception
    //   1127	1157	218	java/lang/Exception
    //   1157	1192	218	java/lang/Exception
    //   1192	1273	218	java/lang/Exception
    //   1273	1293	218	java/lang/Exception
    //   1293	1316	218	java/lang/Exception
    //   1316	1320	218	java/lang/Exception
    //   1324	1369	218	java/lang/Exception
    //   1376	1386	218	java/lang/Exception
    //   1389	1399	218	java/lang/Exception
    //   1402	1436	218	java/lang/Exception
    //   1439	1446	218	java/lang/Exception
    //   275	324	1449	java/lang/Exception
    //   360	413	1479	java/lang/Exception
    //   421	430	1479	java/lang/Exception
    //   435	453	1479	java/lang/Exception
    //   460	473	1479	java/lang/Exception
    //   478	509	1479	java/lang/Exception
    //   517	567	1479	java/lang/Exception
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297735));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297736));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297737));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297738));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297739));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298572));
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
    View localView = paramView.findViewById(2131297881);
    paramView = (TextView)paramView.findViewById(2131297882);
    if ((this.al == 2) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean))
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
    TextView localTextView = (TextView)paramView.findViewById(2131297881);
    if (paramInt > 0)
    {
      localTextView.setVisibility(0);
      paramView = Integer.toString(paramInt);
      if (paramInt > 99) {
        paramView = "99+";
      }
      localTextView.setText(paramView);
      localTextView.setBackgroundResource(2130838428);
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      return;
    }
    if (paramBoolean)
    {
      localTextView.setVisibility(0);
      localTextView.setText("");
      localTextView.setBackgroundResource(0);
      localTextView.setCompoundDrawablesWithIntrinsicBounds(2130839371, 0, 0, 0);
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
      paramView = (LinearLayout)paramView.findViewById(2131296566);
    } while (paramView == null);
    paramView.setVisibility(0);
  }
  
  protected void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[7];
        } while ((localObject == null) || (TextUtils.isEmpty(paramString)));
        localObject = (TextView)((View)localObject).findViewById(2131298565);
      } while (localObject == null);
      ((TextView)localObject).setText(paramString);
    } while (((TextView)localObject).isShown());
    ((TextView)localObject).setVisibility(0);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    new afg(this, paramString1, paramString2).start();
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    ReportController.b(this.app, "P_CliOper", "Grp_set", "", paramString1, paramString2, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, paramString3, "", "");
  }
  
  protected void a(List paramList)
  {
    if (paramList == null) {
      return;
    }
    int i1 = getResources().getDimensionPixelOffset(2131493025);
    int i3 = getResources().getDimensionPixelOffset(2131493026);
    int i2 = getResources().getDimensionPixelOffset(2131493031);
    i3 = this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels - i1 - i3 - Utils.a(this, 10.0F) * 2;
    int i4 = getResources().getDimensionPixelOffset(2131493030);
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
        localImageView.setBackgroundDrawable(this.app.b(Long.toString(l1)));
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
      if (this.al == 1)
      {
        localImageView.setBackgroundResource(2130838386);
        localImageView.setContentDescription(super.getString(2131362648));
        localImageView.setOnClickListener(new aft(this));
        label380:
        if (i2 <= 0) {
          break label504;
        }
        if (this.al != 1) {
          break label506;
        }
        paramList = this.jdField_a_of_type_ArrayOfAndroidViewView[3];
        label399:
        if (paramList == null) {
          break label528;
        }
        paramList = (LinearLayout)paramList.findViewById(2131298571);
        if (paramList == null) {
          break;
        }
        paramList.setVisibility(0);
        return;
      }
      if (i1 - 1 < i2) {}
      for (paramList = (oidb_0x899.memberlist)paramList.get(i1 - 1);; paramList = null)
      {
        if ((paramList != null) && (paramList.uint64_member_uin.has()))
        {
          l1 = paramList.uint64_member_uin.get();
          localImageView.setBackgroundDrawable(this.app.b(Long.toString(l1)));
          localImageView.setTag(Long.toString(l1));
          break label380;
        }
        localImageView.setVisibility(4);
        break label380;
        label504:
        break;
        label506:
        if (this.al == 2)
        {
          paramList = this.jdField_a_of_type_ArrayOfAndroidViewView[16];
          break label399;
        }
        paramList = null;
        break label399;
        label528:
        break;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "mTroopInfoData is null!");
      }
    }
    while (this.al != 1) {
      return;
    }
    View localView1 = this.jdField_a_of_type_ArrayOfAndroidViewView[13];
    View localView2 = this.jdField_a_of_type_ArrayOfAndroidViewView[2];
    if ((localView2 == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a())) {}
    for (;;)
    {
      localView1.setBackgroundResource(2130837758);
      localView1 = this.jdField_a_of_type_ArrayOfAndroidViewView[6];
      if (localView1 == null) {
        break;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e()) {
        break label132;
      }
      if ((!localView1.isShown()) || (localView1.getVisibility() == 8)) {
        localView1.setVisibility(0);
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[3].setBackgroundResource(2130837758);
      return;
      localView2.setVisibility(8);
    }
    label132:
    if ((localView1.isShown()) || (localView1.getVisibility() == 0)) {
      localView1.setVisibility(8);
    }
    this.jdField_a_of_type_ArrayOfAndroidViewView[3].setBackgroundResource(2130837758);
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
    Object localObject = ((FriendsManagerImp)this.app.getManager(8)).a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString));
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  protected void b(int paramInt1, int paramInt2, View paramView, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramView, paramString, paramBoolean);
    paramView = (TextView)paramView.findViewById(2131296957);
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
  
  protected void b(View paramView, int paramInt, boolean paramBoolean)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131297881);
    paramView = (TextView)paramView.findViewById(2131297882);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && ((this.al != 2) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean)))
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
    ((BizTroopHandler)this.app.a(19)).f(paramString);
  }
  
  protected String c()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_JavaLangString)) {
      return getString(2131363475);
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
    ThreadManager.a(new afs(this));
    if (this.jdField_i_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837910);
      this.jdField_i_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      this.jdField_i_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131493048));
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
    if (NetworkUtil.e(getActivity()))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_JavaLangString = paramIntent;
      e(16);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, getString(2131362785), 1000);
  }
  
  /* Error */
  protected boolean c()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: invokestatic 684	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +12 -> 17
    //   8: ldc 55
    //   10: iconst_2
    //   11: ldc_w 1941
    //   14: invokestatic 739	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: getfield 281	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   21: ifnonnull +5 -> 26
    //   24: iconst_0
    //   25: ireturn
    //   26: aload_0
    //   27: iconst_0
    //   28: putfield 197	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_Boolean	Z
    //   31: aload_0
    //   32: iconst_0
    //   33: putfield 195	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Boolean	Z
    //   36: aload_0
    //   37: invokevirtual 1945	com/tencent/mobileqq/activity/ChatSettingForTroop:getIntent	()Landroid/content/Intent;
    //   40: invokevirtual 1460	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   43: astore 4
    //   45: aload_0
    //   46: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   49: aload 4
    //   51: ldc_w 892
    //   54: invokevirtual 1947	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   57: putfield 290	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   60: aload_0
    //   61: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   64: aload 4
    //   66: ldc_w 894
    //   69: invokevirtual 1947	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   72: putfield 896	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   75: aload_0
    //   76: aload 4
    //   78: ldc_w 733
    //   81: iconst_1
    //   82: invokevirtual 1950	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   85: putfield 203	com/tencent/mobileqq/activity/ChatSettingForTroop:al	I
    //   88: aload_0
    //   89: aload 4
    //   91: ldc_w 1952
    //   94: invokevirtual 1954	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   97: putfield 371	com/tencent/mobileqq/activity/ChatSettingForTroop:an	I
    //   100: aload_0
    //   101: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   104: getfield 290	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   107: invokestatic 989	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   110: lstore_2
    //   111: lload_2
    //   112: lconst_0
    //   113: lcmp
    //   114: ifle -90 -> 24
    //   117: aload_0
    //   118: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   121: aload 4
    //   123: ldc_w 1956
    //   126: invokevirtual 1954	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   129: putfield 338	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Int	I
    //   132: aload_0
    //   133: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   136: aload 4
    //   138: ldc_w 1958
    //   141: invokevirtual 1954	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   144: putfield 1960	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_b_of_type_Int	I
    //   147: aload_0
    //   148: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   151: aload 4
    //   153: ldc_w 1962
    //   156: invokevirtual 1947	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   159: putfield 373	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   162: aload_0
    //   163: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   166: aload 4
    //   168: ldc_w 1964
    //   171: invokevirtual 1968	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   174: putfield 275	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Boolean	Z
    //   177: aload_0
    //   178: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   181: aload 4
    //   183: ldc_w 1970
    //   186: invokevirtual 1974	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   189: putfield 993	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_b_of_type_Short	S
    //   192: aload_0
    //   193: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   196: aload 4
    //   198: ldc_w 1976
    //   201: invokevirtual 1947	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   204: putfield 364	com/tencent/mobileqq/troopinfo/TroopInfoData:f	Ljava/lang/String;
    //   207: aload_0
    //   208: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   211: aload 4
    //   213: ldc_w 1978
    //   216: invokevirtual 1947	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   219: putfield 1762	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_p_of_type_JavaLangString	Ljava/lang/String;
    //   222: aload_0
    //   223: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   226: aload 4
    //   228: ldc_w 1980
    //   231: invokevirtual 1983	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   234: putfield 991	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Long	J
    //   237: aload_0
    //   238: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   241: aload 4
    //   243: ldc_w 1985
    //   246: invokevirtual 1947	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   249: putfield 1285	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   252: aload_0
    //   253: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   256: aload 4
    //   258: ldc_w 1987
    //   261: invokevirtual 1947	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   264: putfield 997	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   267: aload_0
    //   268: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   271: aload 4
    //   273: ldc_w 1989
    //   276: invokevirtual 1993	android/os/Bundle:getByte	(Ljava/lang/String;)B
    //   279: i2s
    //   280: putfield 366	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Short	S
    //   283: aload_0
    //   284: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   287: aload_0
    //   288: aload_0
    //   289: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   292: getfield 290	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   295: invokestatic 1998	com/tencent/mobileqq/util/TroopSystemMsgUtil:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   298: putfield 381	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_r_of_type_JavaLangString	Ljava/lang/String;
    //   301: aload_0
    //   302: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   305: aload 4
    //   307: ldc_w 2000
    //   310: invokevirtual 1954	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   313: invokestatic 2002	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   316: putfield 1344	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   319: aload_0
    //   320: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   323: aload 4
    //   325: ldc_w 2004
    //   328: invokevirtual 1954	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   331: putfield 1078	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_n_of_type_Int	I
    //   334: aload_0
    //   335: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   338: aload_0
    //   339: aload_0
    //   340: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   343: getfield 290	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   346: invokestatic 2006	com/tencent/mobileqq/util/TroopSystemMsgUtil:c	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   349: putfield 383	com/tencent/mobileqq/troopinfo/TroopInfoData:s	Ljava/lang/String;
    //   352: aload_0
    //   353: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   356: aload 4
    //   358: ldc_w 2008
    //   361: invokevirtual 1983	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   364: putfield 1672	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_b_of_type_Long	J
    //   367: aload_0
    //   368: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   371: aload 4
    //   373: ldc_w 2010
    //   376: invokevirtual 1983	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   379: putfield 1677	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_Long	J
    //   382: aload_0
    //   383: getfield 281	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   386: bipush 8
    //   388: invokevirtual 449	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   391: checkcast 966	com/tencent/mobileqq/model/FriendManager
    //   394: astore 5
    //   396: aload 5
    //   398: ifnull +58 -> 456
    //   401: aload 5
    //   403: aload_0
    //   404: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   407: getfield 290	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   410: invokeinterface 976 2 0
    //   415: astore 5
    //   417: aload 5
    //   419: ifnull +37 -> 456
    //   422: aload_0
    //   423: aload 5
    //   425: putfield 964	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   428: aload_0
    //   429: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   432: iconst_1
    //   433: putfield 275	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Boolean	Z
    //   436: aload_0
    //   437: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   440: aload 5
    //   442: aload_0
    //   443: invokevirtual 1070	com/tencent/mobileqq/activity/ChatSettingForTroop:getResources	()Landroid/content/res/Resources;
    //   446: aload_0
    //   447: getfield 281	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   450: invokevirtual 286	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   453: invokevirtual 2013	com/tencent/mobileqq/troopinfo/TroopInfoData:a	(Lcom/tencent/mobileqq/data/TroopInfo;Landroid/content/res/Resources;Ljava/lang/String;)V
    //   456: aload_0
    //   457: aload 4
    //   459: ldc 108
    //   461: iconst_m1
    //   462: invokevirtual 1950	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   465: putfield 226	com/tencent/mobileqq/activity/ChatSettingForTroop:ap	I
    //   468: iconst_1
    //   469: ireturn
    //   470: astore 4
    //   472: invokestatic 684	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   475: ifeq +14 -> 489
    //   478: ldc 55
    //   480: iconst_2
    //   481: aload 4
    //   483: invokevirtual 737	java/lang/Exception:toString	()Ljava/lang/String;
    //   486: invokestatic 739	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   489: aload_0
    //   490: getfield 281	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   493: bipush 69
    //   495: invokestatic 2018	com/tencent/biz/common/report/BnrReport:a	(Lcom/tencent/common/app/AppInterface;I)V
    //   498: iload_1
    //   499: ireturn
    //   500: astore 4
    //   502: iconst_1
    //   503: istore_1
    //   504: goto -32 -> 472
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	507	0	this	ChatSettingForTroop
    //   1	503	1	bool	boolean
    //   110	2	2	l1	long
    //   43	415	4	localBundle	Bundle
    //   470	12	4	localException1	Exception
    //   500	1	4	localException2	Exception
    //   394	47	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   26	111	470	java/lang/Exception
    //   117	396	500	java/lang/Exception
    //   401	417	500	java/lang/Exception
    //   422	456	500	java/lang/Exception
    //   456	468	500	java/lang/Exception
  }
  
  protected void d()
  {
    Object localObject = (TroopHandler)this.app.a(17);
    if (localObject != null)
    {
      if (this.al != 1) {
        break label70;
      }
      ((TroopHandler)localObject).a(a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString), true);
    }
    for (;;)
    {
      localObject = (BizTroopHandler)this.app.a(19);
      if (localObject != null) {
        ((BizTroopHandler)localObject).c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      }
      return;
      label70:
      ((TroopHandler)localObject).a(a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString), false);
    }
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
    case 13: 
    default: 
    case 5: 
    case 1: 
    case 2: 
      do
      {
        return;
        a(paramInt2, paramIntent);
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
        localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[7];
      } while (localObject == null);
      paramIntent = DBUtils.a().a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.app.a());
      if (paramIntent == null) {
        break;
      }
    }
    for (paramIntent = paramIntent.troopnick;; paramIntent = null)
    {
      localObject = (TextView)((View)localObject).findViewById(2131296957);
      if ((!TextUtils.isEmpty(paramIntent)) && (!((TextView)localObject).getText().equals(paramIntent)))
      {
        ((TextView)localObject).setText(new QQText(paramIntent, 3));
        return;
      }
      if ((!TextUtils.isEmpty(paramIntent)) || (((TextView)localObject).getText().equals(paramIntent))) {
        break;
      }
      ((TextView)localObject).setText(new QQText(this.app.c(), 3));
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
      this.jdField_i_of_type_Boolean = true;
      return;
      f(paramInt2, paramIntent);
      return;
      g(paramInt2, paramIntent);
      return;
      h(paramInt2, paramIntent);
      return;
      paramIntent = paramIntent.getStringExtra("result");
      if (TextUtils.equals(paramIntent, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m)) {
        break;
      }
      if (NetworkUtil.e(BaseApplication.getContext()))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m = paramIntent;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m)) {}
        for (paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m;; paramIntent = getResources().getString(2131362826))
        {
          a(15, paramIntent, false);
          e(32);
          return;
        }
      }
      b(2131362785, 1);
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
    for (;;)
    {
      try
      {
        a();
        this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility = new TroopShareUtility(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
        if (QLog.isColorLevel()) {
          QLog.i("Q.chatopttroop", 2, "onCreate(), time = " + (System.currentTimeMillis() - l1));
        }
        QZoneHelper.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
        if (this.al != 1) {
          break label314;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e())
        {
          a("Grp_Admin_data", "Clk_data", "0");
          BnrReport.a(this.app, 65);
          return true;
        }
      }
      catch (OutOfMemoryError paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.chatopttroop", 2, "initUI got OOM, e:" + paramBundle.getMessage());
        }
        System.gc();
        finish();
        return false;
      }
      catch (InflateException paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.chatopttroop", 2, "init UI got InflateException, e:" + paramBundle.getMessage());
        }
        System.gc();
        finish();
        return false;
      }
      a("Grp_Admin_data", "Clk_data", "1");
      continue;
      label314:
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
        removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
        removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
        removeObserver(this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver);
        removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
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
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
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
        a("Grp_Admin_data", "upload_head", "");
      }
    }
    this.jdField_f_of_type_Boolean = true;
    paramIntent = (AccountManager)getAppRuntime().getManager(0);
    String str = a(this.app);
    if (str == null)
    {
      paramIntent.updateSKey(this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
    }
    TroopUtils.a(str, this.app.a(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter);
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
      TroopNotificationHelper.a(this.app, 0, l2, l1, 0L, "", 0, "OidbSvc.0x852_48", (short)23, false, false);
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
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      addObserver(this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
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
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      removeObserver(this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver);
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
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[12];
    if ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {
      return;
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_n_of_type_Int;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i()) {
      i1 = 0;
    }
    for (;;)
    {
      TextView localTextView = (TextView)((View)localObject).findViewById(2131297877);
      localObject = (ImageView)((View)localObject).findViewById(2131297879);
      localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      ((ImageView)localObject).setImageDrawable(a());
      ((ImageView)localObject).setContentDescription(String.format(getResources().getString(2131363036), new Object[] { Integer.valueOf(i1) }));
      return;
    }
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
      if (!TextUtils.isEmpty(paramIntent)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(paramIntent, this.app.a());
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
    if ((this.al == 2) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)) {
      a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberMax);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter != null)) {
      if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e()) || (this.al != 1)) {
        break label95;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(bool);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a();
      t();
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
    paramIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f);
    paramIntent.putExtra("uintype", 1);
    paramIntent.putExtra("isNeedUpdate", this.jdField_i_of_type_Boolean);
    paramIntent.setFlags(67108864);
    startActivity(paramIntent);
    finish();
  }
  
  public void g()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f()) {
      return;
    }
    SharedPreferences localSharedPreferences = getSharedPreferences("last_update_time" + this.app.a(), 0);
    long l1 = localSharedPreferences.getLong("key_last_update_time" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, 0L);
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "TroopMemberList lastUpdateTime:" + l1);
    }
    if (l1 == 0L)
    {
      TroopHandler localTroopHandler = (TroopHandler)this.app.a(17);
      if (localTroopHandler != null) {
        localTroopHandler.a(true, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_JavaLangString);
      }
      localSharedPreferences.edit().putLong("key_last_update_time" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, System.currentTimeMillis()).commit();
    }
    ThreadManager.a(new aev(this));
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
    new afd(this).start();
  }
  
  public int getPathNodeID()
  {
    return 21;
  }
  
  protected void h()
  {
    Intent localIntent = new Intent(this, TroopMemberCardActivity.class);
    localIntent.putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("troopCode", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("memberUin", this.app.a());
    localIntent.putExtra("fromFlag", 2);
    startActivityForResult(localIntent, 2);
    ReportController.b(this.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_head", 2, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.app.a(), "", "");
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
      paramIntent = (FriendManager)this.app.getManager(8);
      if (paramIntent == null) {}
      for (paramIntent = null;; paramIntent = paramIntent.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString))
      {
        if ((paramIntent != null) && (paramIntent.wMemberNum != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Int))
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(paramIntent.Administrator, paramIntent.wMemberNum, this.app.a(), getResources());
          a(3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_h_of_type_JavaLangString, true);
        }
        View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[7];
        if (localView == null) {
          break;
        }
        TroopMemberInfo localTroopMemberInfo = DBUtils.a().a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.app.a());
        paramIntent = localTextView;
        if (localTroopMemberInfo != null) {
          paramIntent = localTroopMemberInfo.troopnick;
        }
        localTextView = (TextView)localView.findViewById(2131296957);
        if ((TextUtils.isEmpty(paramIntent)) || (localTextView.getText().equals(paramIntent))) {
          break label262;
        }
        localTextView.setText(new QQText(paramIntent, 3));
        return;
      }
    } while ((!TextUtils.isEmpty(paramIntent)) || (localTextView.getText().equals(paramIntent)));
    localTextView.setText(new QQText(this.app.c(), 3));
  }
  
  protected void i()
  {
    Object localObject = new Intent(this, TroopMemberListActivity.class);
    ((Intent)localObject).putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    ((Intent)localObject).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_JavaLangString);
    ((Intent)localObject).putExtra("param_from", 0);
    startActivityForResult((Intent)localObject, 10);
    localObject = "2";
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Boolean) {
        localObject = "0";
      }
      for (;;)
      {
        ReportController.b(this.app, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "0", (String)localObject, "");
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Boolean) {
          localObject = "1";
        }
      }
      return;
    }
    catch (Exception localException) {}
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
          Object localObject = (String)localIterator.next();
          if ((localObject != null) && (AvatarTroopUtil.b((String)localObject)))
          {
            paramInt = Integer.parseInt((String)localObject);
            localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(paramInt);
            if ((localObject != null) && (((AvatarWallAdapter.AvatarInfo)localObject).jdField_b_of_type_JavaLangString != null) && (AvatarTroopUtil.b(((AvatarWallAdapter.AvatarInfo)localObject).jdField_b_of_type_JavaLangString))) {
              localArrayList2.add(Integer.valueOf(Integer.parseInt(((AvatarWallAdapter.AvatarInfo)localObject).jdField_b_of_type_JavaLangString)));
            }
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
        QQToast.a(this, getString(2131363541), 1).b(getTitleBarHeight());
      }
    }
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 15) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 11)) {
      ReportController.b(this.app, "P_CliOper", "Grp_nearby", "", "nearbygrp_data", "Clk_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
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
    ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "add_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
    TroopLocationModifyActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString, 16);
  }
  
  public void k()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[12];
    if ((localView == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {
      return;
    }
    localView = localView.findViewById(2131297880);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString))
    {
      localView.setVisibility(8);
      return;
    }
    localView.setVisibility(0);
    ((TextView)localView.findViewById(2131296936)).setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString);
  }
  
  public void l()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.app.a(17);
    if (localTroopHandler == null) {}
    do
    {
      return;
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
          this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((FriendManager)this.app.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
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
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[2];
    if (localObject != null) {
      a((View)localObject, 0, false);
    }
    new afi(this).start();
    localObject = new Intent();
    ((Intent)localObject).putExtra("troopuin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    if ((this.jdField_k_of_type_JavaLangString != null) && (!"".equals(this.jdField_k_of_type_JavaLangString.trim())))
    {
      ((Intent)localObject).putExtra("request_params", this.jdField_k_of_type_JavaLangString);
      ((Intent)localObject).putExtra("from", "3");
    }
    TroopQQBrowserHelper.a(this, (Intent)localObject, this.app.a());
  }
  
  protected void n()
  {
    if ((this.al == 2) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_Int != 0) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_Int = 0;
        DBUtils.a(this.app.a(), "troop_file_new", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_Int);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_j_of_type_Int <= 0) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
        }
      }
      Object localObject = new Intent();
      ((Intent)localObject).putExtra(TroopProxyActivity.a, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
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
  
  protected void o()
  {
    Intent localIntent = new Intent(this, PublicAccountBrowser.class);
    localIntent.putExtra("url", "http://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3&gc=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    super.startActivity(localIntent);
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
              do
              {
                return;
                paramView = paramView.getTag();
                break;
                if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean)
                {
                  QQToast.a(this, 2131362571, 1).b(getTitleBarHeight());
                  return;
                }
                if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Boolean) {
                  i1 = 0;
                }
                for (;;)
                {
                  paramView = String.format("http://web.qun.qq.com/mannounce/index.html?_wv=1031&_bid=148#gc=%s&role=%d&actionIcon=1", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, Integer.valueOf(i1) });
                  localIntent = new Intent(this, QQBrowserActivity.class);
                  localIntent.putExtra("url", paramView);
                  localIntent.putExtra("webStyle", "noBottomBar");
                  startActivity(localIntent);
                  this.jdField_e_of_type_Boolean = true;
                  ReportController.a(null, "P_CliOper", "Grp_bulletin", "", "Grp_data", "Clk_grpbulletin", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
                  ThreadManager.b(new aew(this));
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
                  QQToast.a(this, 2131362571, 1).b(getTitleBarHeight());
                  return;
                }
                n();
                return;
                m();
                a("Grp_Admin_data", "Clk_forum", "");
                return;
              } while (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null);
              if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.o > this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Int) {
                this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.o = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Int;
              }
              if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Long & 0x800000) != 8388608L) {}
              for (int i1 = 0;; i1 = 1)
              {
                paramView = new Intent(this, PublicAccountBrowser.class);
                paramView.putExtra("hide_operation_bar", true);
                paramView.putExtra("hideRightButton", true);
                paramView.putExtra("isScreenOrientationPortrait", true);
                paramView.putExtra("uin", this.app.a());
                paramView.putExtra("url", "http://qinfo.clt.qq.com/group_level/qlevel.html?_bid=151&groupuin=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString + "&role=1&group_level=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_n_of_type_Int + "&group_mem_num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Int + "&group_active_num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.o + "&show_level=" + i1);
                startActivity(paramView);
                ReportController.b(this.app, "P_CliOper", "Grp_rank", "", "Grp_data", "Clk_grprank", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
                BnrReport.a(this.app, 72);
                return;
              }
              removeObserver(this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver);
              paramView = TroopInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, 3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString);
              TroopInfoActivity.a(getActivity(), paramView, 5);
              if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e()) {
                a("Grp_moredata", "Clk_moredata", "0");
              }
              for (;;)
              {
                BnrReport.a(this.app, 68);
                return;
                a("Grp_moredata", "Clk_moredata", "1");
              }
              z();
              return;
              y();
              return;
              x();
              return;
              b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Boolean);
              return;
              B();
            } while (this.an != 2);
            ReportController.b(this.app, "P_CliOper", "Grp_discuss", "", "discuss_AIO", "Clk_grpaio", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
            return;
            o();
            return;
            paramView = new Intent(this, TroopManageActivity.class);
            paramView.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
            paramView.putExtra("forward_location", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString);
            paramView.putExtra("forward_latitude", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int);
            paramView.putExtra("forward_longitude", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int);
            startActivityForResult(paramView, 10);
            ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "manage_grp", "Clk_managegrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 15) {
              ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
            }
            while (!NetworkUtil.e(this))
            {
              b(2131362912, 0);
              return;
              if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 19) {
                ReportController.b(this.app, "P_CliOper", "Grp_nearby", "", "recom", "Clk_joingrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
              } else if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 10) {
                ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp", 1, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
              } else if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 11) {
                ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp", 2, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
              } else if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 12) {
                ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
              } else if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 18) {
                ReportController.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "Clk_join", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
              } else if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 17) {
                ReportController.b(this.app, "CliOper", "", "", "Grp_recommend", "viewinfor_joingrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
              } else if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 20) {
                ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp", 6, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
              } else if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 21) {
                ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp", 7, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
              }
            }
            paramView = (TroopHandler)this.app.a(17);
          } while (paramView == null);
          try
          {
            long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
            p();
            paramView.a(l1, 8388736);
            return;
          }
          catch (Exception paramView) {}
        } while (!QLog.isColorLevel());
        QLog.i("Q.chatopttroop", 2, paramView.toString());
        return;
      } while (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e());
      a(12, 900, 2131363029, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m, true, 1, true);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean)
      {
        a("Grp_Admin_data", "Clk_brief", "0");
        return;
      }
      a("Grp_Admin_data", "Clk_brief", "1");
      return;
      r();
      return;
      j();
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
      a("Grp_Admin_data", "Clk_share", "");
      return;
      paramView = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(0);
    } while (paramView == null);
    Intent localIntent = new Intent();
    localIntent.setClass(this, TroopAvatarWallPreviewActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", 0);
    ArrayList localArrayList = new ArrayList();
    if (((paramView.jdField_c_of_type_JavaLangString == "AVATAR_URL_STR") || (paramView.jdField_c_of_type_JavaLangString == "SYSTEM_PHOTO")) && (paramView.a == null)) {
      localArrayList.add(paramView.jdField_b_of_type_JavaLangString);
    }
    for (;;)
    {
      localBundle.putBoolean("IS_EDIT", false);
      localBundle.putStringArrayList("seqNum", localArrayList);
      localBundle.putString("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      localBundle.putBoolean("troop_info_is_member", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean);
      localIntent.putExtras(localBundle);
      startActivityForResult(localIntent, 14);
      return;
      localArrayList.add(paramView.a);
    }
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
      try
      {
        localObject = new QQCustomMenu();
        ((QQCustomMenu)localObject).a(2131298988, getString(2131363570));
        this.jdField_a_of_type_ComTencentWidgetMenuPopupDialog = MenuPopupDialog.a(paramView, getString(2131363274), (QQCustomMenu)localObject, new aex(this), new aey(this));
      }
      catch (WindowManager.BadTokenException paramView) {}
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, paramView.getMessage());
      }
    }
  }
  
  public void p()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131363564);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(false);
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
  
  public void q()
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
  
  protected void r()
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
    ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_p_of_type_JavaLangString);
    ((Intent)localObject).putStringArrayListExtra("troop_info_memo", localArrayList);
    startActivity((Intent)localObject);
  }
  
  public void s()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.chatopttroop", 4, "updateTroopInfoToDB");
      }
      ((FriendsManagerImp)this.app.getManager(8)).b(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo);
    }
  }
  
  protected void t()
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[12];
    if ((localObject1 == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {}
    for (;;)
    {
      return;
      TextView localTextView = (TextView)((View)localObject1).findViewById(2131297606);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f;
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = " ";
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Long & 0x800) != 0L)
      {
        localObject1 = null;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Long == 2L) {
          localObject1 = getResources().getDrawable(2130838183);
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
            localObject1 = getResources().getDrawable(2130838246);
          }
        }
      }
    }
  }
  
  public void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    label70:
    label106:
    do
    {
      for (;;)
      {
        return;
        ImageView localImageView = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[12].findViewById(2131297604);
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(0);
        Object localObject3;
        if (localObject1 != null) {
          if (((((AvatarWallAdapter.AvatarInfo)localObject1).jdField_c_of_type_JavaLangString == "AVATAR_URL_STR") || (((AvatarWallAdapter.AvatarInfo)localObject1).jdField_c_of_type_JavaLangString == "SYSTEM_PHOTO")) && (((AvatarWallAdapter.AvatarInfo)localObject1).a == null))
          {
            localObject1 = ((AvatarWallAdapter.AvatarInfo)localObject1).jdField_b_of_type_JavaLangString;
            localObject3 = localObject1;
            if (AvatarTroopUtil.b((String)localObject1))
            {
              if ((localObject1 == null) || (!((String)localObject1).equals("-5"))) {
                break label208;
              }
              localObject1 = AvatarTroopUtil.a((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, 0);
              localObject3 = AvatarTroopUtil.a((String)localObject1);
            }
          }
        }
        Bitmap localBitmap;
        try
        {
          localObject1 = Uri.parse((String)localObject3);
          localObject1 = ((Uri)localObject1).getScheme();
          Object localObject2;
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || ((!((String)localObject1).equals("http")) && (!((String)localObject1).equals("https"))))
          {
            try
            {
              localObject1 = BitmapFactory.decodeFile((String)localObject3);
              if ((localObject1 == null) || (this.app == null)) {
                continue;
              }
              localObject3 = this.app.a((Bitmap)localObject1, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
              if (!((Bitmap)localObject1).isRecycled()) {
                ((Bitmap)localObject1).recycle();
              }
              localImageView.setImageBitmap((Bitmap)localObject3);
              return;
            }
            catch (OutOfMemoryError localOutOfMemoryError1)
            {
              return;
            }
            localObject2 = localOutOfMemoryError1.a;
            break label70;
            localObject2 = AvatarTroopUtil.a((String)localObject2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, 1);
            break label106;
          }
          else
          {
            try
            {
              localObject2 = new URL((String)localObject3);
              localObject2 = URLDrawable.getDrawable((URL)localObject2, URLDrawableHelper.d, null, true);
              if (((URLDrawable)localObject2).getStatus() != 1) {
                break label321;
              }
              try
              {
                localObject2 = ImageUtil.a((Drawable)localObject2);
                if ((localObject2 == null) || (this.app == null)) {
                  continue;
                }
                localObject3 = this.app.a((Bitmap)localObject2, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
                if (!((Bitmap)localObject2).isRecycled()) {
                  ((Bitmap)localObject2).recycle();
                }
                localImageView.setImageBitmap((Bitmap)localObject3);
                return;
              }
              catch (OutOfMemoryError localOutOfMemoryError2)
              {
                return;
              }
              if (!QLog.isColorLevel()) {
                continue;
              }
            }
            catch (MalformedURLException localMalformedURLException) {}
            QLog.i("Q.chatopttroop", 2, localMalformedURLException.toString());
            return;
          }
        }
        catch (NullPointerException localNullPointerException) {}
      }
      localMalformedURLException.setURLDrawableListener(new afp(this, localImageView));
    } while (localMalformedURLException.getStatus() != 1);
    try
    {
      label208:
      localBitmap = ImageUtil.a(localMalformedURLException);
      label321:
      localObject3 = this.app.a(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
      localBitmap.recycle();
      localImageView.setImageBitmap((Bitmap)localObject3);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError3) {}
  }
  
  public void v()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    while (this.jdField_a_of_type_ArrayOfAndroidViewView[12] == null) {
      return;
    }
    TextView localTextView = (TextView)findViewById(2131297878);
    localTextView.setVisibility(0);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == 1)
    {
      localTextView.setText(2131362309);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == 0)
    {
      localTextView.setText(2131362310);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == 2)
    {
      localTextView.setText(2131362311);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == 3)
    {
      localTextView.setText(2131362311);
      return;
    }
    localTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop
 * JD-Core Version:    0.7.0.1
 */