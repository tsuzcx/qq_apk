package com.tencent.mobileqq.activity;

import aes;
import aet;
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
import afg;
import afh;
import afi;
import afj;
import afk;
import afm;
import afn;
import afq;
import afr;
import afs;
import aft;
import afu;
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
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.InflateException;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.BadTokenException;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.report.BnrReport;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
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
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.MenuPopupDialog;
import com.tencent.widget.XListView;
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
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new afm(this);
  protected View a;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
  protected LinearLayout a;
  public TextView a;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new afc(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new afa(this);
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new aey(this);
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
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new afd(this);
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
  TroopObserver jdField_b_of_type_ComTencentMobileqqAppTroopObserver = new aez(this);
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
    this.jdField_a_of_type_AndroidOsHandler = new aex(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileObserver = new afh(this);
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
        startActivity(AddFriendLogicActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short, i1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.s, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_JavaLangString, b_()));
        return;
      }
      startActivityForResult(AddFriendLogicActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short, i1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.s, null, b_()), 11);
      return;
    }
    b(2131363368, 1);
  }
  
  private void D()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(2131363580, 5);
    if (this.al == 1) {
      localActionSheet.a(2131363427, 3);
    }
    localActionSheet.d(2131362794);
    localActionSheet.a(new afi(this, localActionSheet));
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
    LinearLayout localLinearLayout = (LinearLayout)localView1.findViewById(2131297090);
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
          localLinearLayout.addView(View.inflate(this, 2130903374, null), this.jdField_b_of_type_AndroidWidgetLinearLayout$LayoutParams);
          View localView2 = View.inflate(this, 2130903372, null);
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
          ((URLDrawable)localObject3).setURLDrawableListener(new afj(this, localImageView, (URLDrawable)localObject3));
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
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new afk(this, localView1), 300L);
        localView1.setContentDescription(getString(2131362570));
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
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new aes(this, paramInt), 0L);
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
    localIntent.putExtra("param_title", paramActivity.getString(2131362498));
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
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131363516, 1500);
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
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_n_of_type_JavaLangString = getString(2131363090);
      return;
    case 2: 
    case 4: 
    case 5: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short = 2;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_n_of_type_JavaLangString = getString(2131363091);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short = 3;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_n_of_type_JavaLangString = getString(2131363092);
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
      ((Intent)localObject1).putExtra("leftViewText", 2131363665);
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
      localObject2 = getString(2131363428);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f == null) {}
      for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString;; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f + "(" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString + ")")
      {
        localObject1 = String.format(getString(2131363424), new Object[] { localObject1 });
        localObject1 = DialogUtil.a(this, 230).setTitle((String)localObject2).setMessage((CharSequence)localObject1);
        ((QQCustomDialog)localObject1).setPositiveButton(getString(2131363042), new afs(this, (QQCustomDialog)localObject1));
        ((QQCustomDialog)localObject1).setPositiveButtonContentDescription(getString(2131361813));
        ((QQCustomDialog)localObject1).setNegativeButton(getString(2131362794), new aft(this, (QQCustomDialog)localObject1));
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
      localActionSheet.a(getString(2131363857, new Object[] { str }));
      int i1 = DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.app);
      localActionSheet.b(getString(2131363858, new Object[] { StringUtil.a(BaseApplication.getContext(), i1) }));
      localActionSheet.a(getString(2131362532), false);
      localActionSheet.a(getString(2131362533), false);
      localActionSheet.a(getString(2131362534), false);
      i1 = this.app.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      switch (i1)
      {
      }
      for (;;)
      {
        localActionSheet.d(2131362794);
        localActionSheet.a(new afu(this, i1, localActionSheet));
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
      return getResources().getDrawable(2130838368);
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_n_of_type_Int;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i()) {
      i1 = 0;
    }
    switch (i1)
    {
    default: 
      return getResources().getDrawable(2130838368);
    case 0: 
      return getResources().getDrawable(2130838368);
    case 1: 
      return getResources().getDrawable(2130838369);
    case 2: 
      return getResources().getDrawable(2130838370);
    case 3: 
      return getResources().getDrawable(2130838371);
    case 4: 
      return getResources().getDrawable(2130838372);
    }
    return getResources().getDrawable(2130838373);
  }
  
  /* Error */
  @android.annotation.SuppressLint({"NewApi"})
  protected void a()
  {
    // Byte code:
    //   0: invokestatic 667	java/lang/System:currentTimeMillis	()J
    //   3: lstore 4
    //   5: aload_0
    //   6: ldc_w 1093
    //   9: aconst_null
    //   10: invokestatic 512	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   13: astore 8
    //   15: aload_0
    //   16: aload 8
    //   18: ldc_w 1094
    //   21: invokevirtual 475	android/view/View:findViewById	(I)Landroid/view/View;
    //   24: checkcast 1096	com/tencent/widget/XListView
    //   27: putfield 1098	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   30: aload_0
    //   31: aload 8
    //   33: ldc_w 1099
    //   36: invokevirtual 475	android/view/View:findViewById	(I)Landroid/view/View;
    //   39: checkcast 1101	android/widget/EditText
    //   42: putfield 1103	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetEditText	Landroid/widget/EditText;
    //   45: aload_0
    //   46: getfield 1098	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   49: iconst_0
    //   50: invokevirtual 1106	com/tencent/widget/XListView:setVerticalScrollBarEnabled	(Z)V
    //   53: aload_0
    //   54: getfield 1098	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   57: aconst_null
    //   58: invokevirtual 1109	com/tencent/widget/XListView:setDivider	(Landroid/graphics/drawable/Drawable;)V
    //   61: aload_0
    //   62: bipush 19
    //   64: anewarray 471	android/view/View
    //   67: putfield 468	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   70: aload_0
    //   71: new 477	android/widget/LinearLayout
    //   74: dup
    //   75: aload_0
    //   76: invokespecial 1112	android/widget/LinearLayout:<init>	(Landroid/content/Context;)V
    //   79: putfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   82: new 1116	com/tencent/widget/AbsListView$LayoutParams
    //   85: dup
    //   86: iconst_m1
    //   87: bipush 254
    //   89: invokespecial 1118	com/tencent/widget/AbsListView$LayoutParams:<init>	(II)V
    //   92: astore 7
    //   94: aload_0
    //   95: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   98: aload 7
    //   100: invokevirtual 1119	android/widget/LinearLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   103: aload_0
    //   104: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   107: iconst_1
    //   108: invokevirtual 1122	android/widget/LinearLayout:setOrientation	(I)V
    //   111: new 1124	com/tencent/widget/XSimpleListAdapter
    //   114: dup
    //   115: aload_0
    //   116: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   119: invokespecial 1127	com/tencent/widget/XSimpleListAdapter:<init>	(Landroid/view/View;)V
    //   122: astore 7
    //   124: aload_0
    //   125: getfield 1098	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   128: aload 7
    //   130: invokevirtual 1131	com/tencent/widget/XListView:setAdapter	(Landroid/widget/ListAdapter;)V
    //   133: aload_0
    //   134: getfield 1098	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   137: ldc_w 1132
    //   140: invokevirtual 1135	com/tencent/widget/XListView:setBackgroundResource	(I)V
    //   143: aload_0
    //   144: getfield 203	com/tencent/mobileqq/activity/ChatSettingForTroop:al	I
    //   147: iconst_2
    //   148: if_icmpne +41 -> 189
    //   151: aload_0
    //   152: getfield 1098	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   155: invokevirtual 1138	com/tencent/widget/XListView:getPaddingLeft	()I
    //   158: istore_1
    //   159: aload_0
    //   160: getfield 1098	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   163: invokevirtual 1138	com/tencent/widget/XListView:getPaddingLeft	()I
    //   166: istore_2
    //   167: aload_0
    //   168: invokevirtual 1070	com/tencent/mobileqq/activity/ChatSettingForTroop:getResources	()Landroid/content/res/Resources;
    //   171: ldc_w 1139
    //   174: invokevirtual 1143	android/content/res/Resources:getDimensionPixelOffset	(I)I
    //   177: istore_3
    //   178: aload_0
    //   179: getfield 1098	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   182: iload_1
    //   183: iconst_0
    //   184: iload_2
    //   185: iload_3
    //   186: invokevirtual 1147	com/tencent/widget/XListView:setPadding	(IIII)V
    //   189: aload_0
    //   190: aload 8
    //   192: invokevirtual 1150	com/tencent/mobileqq/activity/ChatSettingForTroop:setContentView	(Landroid/view/View;)V
    //   195: aload_0
    //   196: aload_0
    //   197: ldc_w 1151
    //   200: invokevirtual 636	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   203: invokevirtual 1153	com/tencent/mobileqq/activity/ChatSettingForTroop:setTitle	(Ljava/lang/CharSequence;)V
    //   206: aload_0
    //   207: ldc_w 1154
    //   210: invokevirtual 1157	com/tencent/mobileqq/activity/ChatSettingForTroop:setLeftViewName	(I)V
    //   213: aload_0
    //   214: getfield 1159	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidUtilDisplayMetrics	Landroid/util/DisplayMetrics;
    //   217: getfield 1164	android/util/DisplayMetrics:widthPixels	I
    //   220: istore_1
    //   221: iload_1
    //   222: aload_0
    //   223: invokevirtual 1070	com/tencent/mobileqq/activity/ChatSettingForTroop:getResources	()Landroid/content/res/Resources;
    //   226: ldc_w 1165
    //   229: invokevirtual 1168	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   232: isub
    //   233: iconst_4
    //   234: idiv
    //   235: istore_2
    //   236: aload_0
    //   237: ldc_w 1169
    //   240: aconst_null
    //   241: invokestatic 512	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   244: astore 7
    //   246: aload_0
    //   247: aload 7
    //   249: ldc_w 1170
    //   252: invokevirtual 475	android/view/View:findViewById	(I)Landroid/view/View;
    //   255: checkcast 1172	com/tencent/mobileqq/troop/widget/AvatarWallView
    //   258: putfield 1174	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView	Lcom/tencent/mobileqq/troop/widget/AvatarWallView;
    //   261: aload_0
    //   262: getfield 1174	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView	Lcom/tencent/mobileqq/troop/widget/AvatarWallView;
    //   265: iload_2
    //   266: invokevirtual 1177	com/tencent/mobileqq/troop/widget/AvatarWallView:setColumnWidth	(I)V
    //   269: aload_0
    //   270: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   273: invokevirtual 1179	com/tencent/mobileqq/troopinfo/TroopInfoData:e	()Z
    //   276: ifeq +2593 -> 2869
    //   279: aload_0
    //   280: getfield 203	com/tencent/mobileqq/activity/ChatSettingForTroop:al	I
    //   283: iconst_1
    //   284: if_icmpne +2585 -> 2869
    //   287: iconst_1
    //   288: istore 6
    //   290: aload_0
    //   291: new 1181	com/tencent/mobileqq/troop/widget/AvatarWallAdapter
    //   294: dup
    //   295: new 1183	mqq/util/WeakReference
    //   298: dup
    //   299: aload_0
    //   300: invokespecial 1185	mqq/util/WeakReference:<init>	(Ljava/lang/Object;)V
    //   303: aload_0
    //   304: getfield 281	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   307: aload_0
    //   308: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   311: getfield 290	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   314: aload_0
    //   315: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   318: getfield 275	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Boolean	Z
    //   321: aload_0
    //   322: getfield 238	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   325: iload 6
    //   327: ldc_w 1187
    //   330: invokespecial 1190	com/tencent/mobileqq/troop/widget/AvatarWallAdapter:<init>	(Lmqq/util/WeakReference;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;ZLandroid/os/Handler;ZLjava/lang/String;)V
    //   333: putfield 1192	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter	Lcom/tencent/mobileqq/troop/widget/AvatarWallAdapter;
    //   336: aload_0
    //   337: getfield 1174	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView	Lcom/tencent/mobileqq/troop/widget/AvatarWallView;
    //   340: aload_0
    //   341: getfield 1192	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter	Lcom/tencent/mobileqq/troop/widget/AvatarWallAdapter;
    //   344: invokevirtual 1193	com/tencent/mobileqq/troop/widget/AvatarWallView:setAdapter	(Landroid/widget/ListAdapter;)V
    //   347: aload_0
    //   348: getfield 1174	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView	Lcom/tencent/mobileqq/troop/widget/AvatarWallView;
    //   351: iconst_4
    //   352: invokevirtual 1196	com/tencent/mobileqq/troop/widget/AvatarWallView:setNumColumns	(I)V
    //   355: aload_0
    //   356: getfield 1192	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter	Lcom/tencent/mobileqq/troop/widget/AvatarWallAdapter;
    //   359: iload_2
    //   360: invokevirtual 1197	com/tencent/mobileqq/troop/widget/AvatarWallAdapter:a	(I)V
    //   363: aload_0
    //   364: getfield 1192	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter	Lcom/tencent/mobileqq/troop/widget/AvatarWallAdapter;
    //   367: aload_0
    //   368: getfield 1174	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView	Lcom/tencent/mobileqq/troop/widget/AvatarWallView;
    //   371: invokevirtual 1200	com/tencent/mobileqq/troop/widget/AvatarWallAdapter:a	(Lcom/tencent/widget/GridView;)V
    //   374: aload_0
    //   375: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   378: aload 7
    //   380: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   383: new 486	android/widget/ImageView
    //   386: dup
    //   387: aload_0
    //   388: invokespecial 1203	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   391: astore 7
    //   393: aload 7
    //   395: ldc_w 1204
    //   398: invokevirtual 1205	android/widget/ImageView:setBackgroundResource	(I)V
    //   401: new 1207	android/widget/LinearLayout$LayoutParams
    //   404: dup
    //   405: iconst_m1
    //   406: iconst_2
    //   407: invokespecial 1208	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   410: astore 9
    //   412: aload 9
    //   414: aload_0
    //   415: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   418: f2i
    //   419: bipush 14
    //   421: imul
    //   422: iconst_0
    //   423: aload_0
    //   424: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   427: f2i
    //   428: bipush 14
    //   430: imul
    //   431: iconst_0
    //   432: invokevirtual 1213	android/widget/LinearLayout$LayoutParams:setMargins	(IIII)V
    //   435: aload 7
    //   437: aload 9
    //   439: invokevirtual 552	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   442: aload_0
    //   443: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   446: aload 7
    //   448: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   451: aload_0
    //   452: ldc_w 1214
    //   455: aconst_null
    //   456: invokestatic 512	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   459: astore 7
    //   461: aload_0
    //   462: aload 7
    //   464: ldc_w 1215
    //   467: invokevirtual 475	android/view/View:findViewById	(I)Landroid/view/View;
    //   470: checkcast 529	android/widget/TextView
    //   473: putfield 1217	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   476: aload_0
    //   477: getfield 1217	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   480: iconst_1
    //   481: invokevirtual 1218	android/widget/TextView:setFocusable	(Z)V
    //   484: aload_0
    //   485: getfield 1217	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   488: iconst_1
    //   489: invokevirtual 1221	android/widget/TextView:setFocusableInTouchMode	(Z)V
    //   492: aload_0
    //   493: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   496: aload 7
    //   498: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   501: iload 6
    //   503: ifne +2372 -> 2875
    //   506: aload 7
    //   508: bipush 8
    //   510: invokevirtual 1224	android/view/View:setVisibility	(I)V
    //   513: aload_0
    //   514: aload 7
    //   516: putfield 1226	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   519: aload_0
    //   520: ldc_w 1227
    //   523: aconst_null
    //   524: invokestatic 512	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   527: astore 7
    //   529: aload_0
    //   530: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   533: aload 7
    //   535: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   538: aload_0
    //   539: getfield 468	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   542: bipush 12
    //   544: aload 7
    //   546: aastore
    //   547: aload 7
    //   549: ldc_w 1228
    //   552: invokevirtual 475	android/view/View:findViewById	(I)Landroid/view/View;
    //   555: checkcast 486	android/widget/ImageView
    //   558: astore 10
    //   560: aload 7
    //   562: ldc_w 1229
    //   565: invokevirtual 475	android/view/View:findViewById	(I)Landroid/view/View;
    //   568: checkcast 529	android/widget/TextView
    //   571: astore 11
    //   573: aload 7
    //   575: ldc_w 1230
    //   578: invokevirtual 475	android/view/View:findViewById	(I)Landroid/view/View;
    //   581: checkcast 529	android/widget/TextView
    //   584: astore 12
    //   586: aload 7
    //   588: ldc_w 1231
    //   591: invokevirtual 475	android/view/View:findViewById	(I)Landroid/view/View;
    //   594: checkcast 486	android/widget/ImageView
    //   597: astore 13
    //   599: aload 7
    //   601: ldc_w 1232
    //   604: invokevirtual 475	android/view/View:findViewById	(I)Landroid/view/View;
    //   607: astore 9
    //   609: aload_0
    //   610: getfield 281	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   613: iconst_4
    //   614: aload_0
    //   615: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   618: getfield 290	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   621: iconst_3
    //   622: iconst_0
    //   623: invokevirtual 1235	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;BI)Ljava/lang/String;
    //   626: astore 14
    //   628: aload_0
    //   629: getfield 281	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   632: aload 14
    //   634: invokevirtual 1238	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   637: astore 14
    //   639: aload 14
    //   641: ifnull +15 -> 656
    //   644: aload 10
    //   646: aload 14
    //   648: invokevirtual 1242	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   651: aload_0
    //   652: iconst_1
    //   653: putfield 222	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_g_of_type_Boolean	Z
    //   656: aload 10
    //   658: bipush 26
    //   660: invokestatic 861	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   663: invokevirtual 1243	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   666: aload 10
    //   668: aload_0
    //   669: invokevirtual 1244	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   672: aload 10
    //   674: aload_0
    //   675: ldc_w 1245
    //   678: invokespecial 1246	com/tencent/mobileqq/app/IphoneTitleBarActivity:getString	(I)Ljava/lang/String;
    //   681: invokevirtual 1247	android/widget/ImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   684: aload 12
    //   686: iconst_4
    //   687: invokestatic 861	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   690: invokevirtual 1248	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   693: aload 12
    //   695: aload_0
    //   696: invokevirtual 1252	android/widget/TextView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   699: aload 11
    //   701: iconst_4
    //   702: invokestatic 861	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   705: invokevirtual 1248	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   708: aload 11
    //   710: aload_0
    //   711: invokevirtual 1252	android/widget/TextView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   714: aload 11
    //   716: aload_0
    //   717: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   720: getfield 364	com/tencent/mobileqq/troopinfo/TroopInfoData:f	Ljava/lang/String;
    //   723: invokevirtual 536	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   726: aload 12
    //   728: aload_0
    //   729: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   732: getfield 290	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   735: invokevirtual 536	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   738: aload 13
    //   740: aload_0
    //   741: invokevirtual 1254	com/tencent/mobileqq/activity/ChatSettingForTroop:a	()Landroid/graphics/drawable/Drawable;
    //   744: invokevirtual 576	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   747: aload 13
    //   749: iconst_4
    //   750: invokestatic 861	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   753: invokevirtual 1243	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   756: aload 13
    //   758: aload_0
    //   759: invokevirtual 1244	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   762: aload 13
    //   764: aload_0
    //   765: invokevirtual 1070	com/tencent/mobileqq/activity/ChatSettingForTroop:getResources	()Landroid/content/res/Resources;
    //   768: ldc_w 1255
    //   771: invokevirtual 1256	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   774: iconst_1
    //   775: anewarray 911	java/lang/Object
    //   778: dup
    //   779: iconst_0
    //   780: iconst_0
    //   781: invokestatic 861	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   784: aastore
    //   785: invokestatic 915	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   788: invokevirtual 1247	android/widget/ImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   791: aload 9
    //   793: bipush 11
    //   795: invokestatic 861	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   798: invokevirtual 583	android/view/View:setTag	(Ljava/lang/Object;)V
    //   801: aload 9
    //   803: aload_0
    //   804: invokevirtual 587	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   807: aload 9
    //   809: ldc_w 1257
    //   812: invokevirtual 475	android/view/View:findViewById	(I)Landroid/view/View;
    //   815: checkcast 529	android/widget/TextView
    //   818: astore 10
    //   820: aload_0
    //   821: invokevirtual 1070	com/tencent/mobileqq/activity/ChatSettingForTroop:getResources	()Landroid/content/res/Resources;
    //   824: ldc_w 1258
    //   827: invokevirtual 1076	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   830: astore 11
    //   832: aload 11
    //   834: iconst_0
    //   835: iconst_0
    //   836: aload 11
    //   838: invokevirtual 1263	android/graphics/drawable/Drawable:getMinimumWidth	()I
    //   841: aload 11
    //   843: invokevirtual 1266	android/graphics/drawable/Drawable:getMinimumHeight	()I
    //   846: invokevirtual 1269	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   849: aload 10
    //   851: aload 11
    //   853: aconst_null
    //   854: aconst_null
    //   855: aconst_null
    //   856: invokevirtual 1273	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   859: aload 10
    //   861: bipush 10
    //   863: invokevirtual 1276	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   866: aload_0
    //   867: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   870: getfield 1277	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   873: invokestatic 379	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   876: ifeq +2070 -> 2946
    //   879: aload 9
    //   881: bipush 8
    //   883: invokevirtual 1224	android/view/View:setVisibility	(I)V
    //   886: aload 7
    //   888: ldc_w 1278
    //   891: invokevirtual 1279	android/view/View:setBackgroundResource	(I)V
    //   894: new 486	android/widget/ImageView
    //   897: dup
    //   898: aload_0
    //   899: invokespecial 1203	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   902: astore 7
    //   904: aload 7
    //   906: ldc_w 1204
    //   909: invokevirtual 1205	android/widget/ImageView:setBackgroundResource	(I)V
    //   912: new 1207	android/widget/LinearLayout$LayoutParams
    //   915: dup
    //   916: iconst_m1
    //   917: iconst_2
    //   918: invokespecial 1208	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   921: astore 9
    //   923: aload 9
    //   925: aload_0
    //   926: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   929: f2i
    //   930: bipush 14
    //   932: imul
    //   933: iconst_0
    //   934: aload_0
    //   935: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   938: f2i
    //   939: bipush 14
    //   941: imul
    //   942: iconst_0
    //   943: invokevirtual 1213	android/widget/LinearLayout$LayoutParams:setMargins	(IIII)V
    //   946: aload 7
    //   948: aload 9
    //   950: invokevirtual 552	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   953: aload_0
    //   954: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   957: aload 7
    //   959: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   962: aload_0
    //   963: invokevirtual 1281	com/tencent/mobileqq/activity/ChatSettingForTroop:t	()V
    //   966: aload_0
    //   967: iload_1
    //   968: aload_0
    //   969: invokevirtual 1070	com/tencent/mobileqq/activity/ChatSettingForTroop:getResources	()Landroid/content/res/Resources;
    //   972: ldc_w 1165
    //   975: invokevirtual 1168	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   978: isub
    //   979: aload_0
    //   980: fconst_1
    //   981: invokestatic 1286	com/tencent/biz/pubaccount/util/PublicAccountUtil:a	(Landroid/content/Context;F)I
    //   984: iconst_3
    //   985: imul
    //   986: isub
    //   987: iconst_4
    //   988: idiv
    //   989: putfield 1288	com/tencent/mobileqq/activity/ChatSettingForTroop:ao	I
    //   992: aload_0
    //   993: ldc_w 1289
    //   996: aconst_null
    //   997: invokestatic 512	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   1000: astore 7
    //   1002: aload 7
    //   1004: ldc_w 1278
    //   1007: invokevirtual 1279	android/view/View:setBackgroundResource	(I)V
    //   1010: aload_0
    //   1011: getfield 468	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   1014: bipush 13
    //   1016: aload 7
    //   1018: aastore
    //   1019: aload 7
    //   1021: ldc_w 1290
    //   1024: invokevirtual 475	android/view/View:findViewById	(I)Landroid/view/View;
    //   1027: checkcast 1292	com/tencent/mobileqq/profile/view/ReboundHorizontalScrollView
    //   1030: astore 9
    //   1032: getstatic 1297	android/os/Build$VERSION:SDK_INT	I
    //   1035: bipush 9
    //   1037: if_icmplt +9 -> 1046
    //   1040: aload 9
    //   1042: iconst_2
    //   1043: invokevirtual 1300	com/tencent/mobileqq/profile/view/ReboundHorizontalScrollView:setOverScrollMode	(I)V
    //   1046: aload_0
    //   1047: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1050: aload 7
    //   1052: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   1055: aload_0
    //   1056: new 1207	android/widget/LinearLayout$LayoutParams
    //   1059: dup
    //   1060: aload_0
    //   1061: getfield 1288	com/tencent/mobileqq/activity/ChatSettingForTroop:ao	I
    //   1064: aload_0
    //   1065: ldc_w 1301
    //   1068: invokestatic 1286	com/tencent/biz/pubaccount/util/PublicAccountUtil:a	(Landroid/content/Context;F)I
    //   1071: invokespecial 1208	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   1074: putfield 589	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams	Landroid/widget/LinearLayout$LayoutParams;
    //   1077: aload_0
    //   1078: getfield 589	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams	Landroid/widget/LinearLayout$LayoutParams;
    //   1081: bipush 17
    //   1083: putfield 1304	android/widget/LinearLayout$LayoutParams:gravity	I
    //   1086: aload_0
    //   1087: getfield 589	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams	Landroid/widget/LinearLayout$LayoutParams;
    //   1090: fconst_1
    //   1091: putfield 1307	android/widget/LinearLayout$LayoutParams:weight	F
    //   1094: aload 7
    //   1096: ldc_w 469
    //   1099: invokevirtual 475	android/view/View:findViewById	(I)Landroid/view/View;
    //   1102: checkcast 477	android/widget/LinearLayout
    //   1105: astore 7
    //   1107: aload_0
    //   1108: ldc_w 519
    //   1111: aconst_null
    //   1112: invokestatic 512	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   1115: astore 9
    //   1117: aload 9
    //   1119: iconst_1
    //   1120: invokevirtual 523	android/view/View:setFocusable	(Z)V
    //   1123: aload 9
    //   1125: iconst_1
    //   1126: invokevirtual 526	android/view/View:setClickable	(Z)V
    //   1129: aload 7
    //   1131: bipush 16
    //   1133: invokevirtual 1310	android/widget/LinearLayout:setGravity	(I)V
    //   1136: aload 9
    //   1138: ldc_w 527
    //   1141: invokevirtual 475	android/view/View:findViewById	(I)Landroid/view/View;
    //   1144: checkcast 529	android/widget/TextView
    //   1147: astore 10
    //   1149: aload 9
    //   1151: ldc_w 484
    //   1154: invokevirtual 475	android/view/View:findViewById	(I)Landroid/view/View;
    //   1157: checkcast 486	android/widget/ImageView
    //   1160: astore 11
    //   1162: aload 10
    //   1164: ldc_w 1311
    //   1167: invokevirtual 1313	android/widget/TextView:setText	(I)V
    //   1170: aload 11
    //   1172: ldc_w 1314
    //   1175: invokevirtual 1317	android/widget/ImageView:setImageResource	(I)V
    //   1178: aload 9
    //   1180: iconst_0
    //   1181: invokestatic 861	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1184: invokevirtual 583	android/view/View:setTag	(Ljava/lang/Object;)V
    //   1187: aload 9
    //   1189: aload_0
    //   1190: invokevirtual 587	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1193: aload_0
    //   1194: getfield 468	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   1197: iconst_0
    //   1198: aload 9
    //   1200: aastore
    //   1201: aload 7
    //   1203: aload 9
    //   1205: aload_0
    //   1206: getfield 589	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams	Landroid/widget/LinearLayout$LayoutParams;
    //   1209: invokevirtual 518	android/widget/LinearLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1212: aload_0
    //   1213: new 1207	android/widget/LinearLayout$LayoutParams
    //   1216: dup
    //   1217: aload_0
    //   1218: fconst_1
    //   1219: invokestatic 1286	com/tencent/biz/pubaccount/util/PublicAccountUtil:a	(Landroid/content/Context;F)I
    //   1222: aload_0
    //   1223: ldc_w 1318
    //   1226: invokestatic 1286	com/tencent/biz/pubaccount/util/PublicAccountUtil:a	(Landroid/content/Context;F)I
    //   1229: invokespecial 1208	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   1232: putfield 514	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_AndroidWidgetLinearLayout$LayoutParams	Landroid/widget/LinearLayout$LayoutParams;
    //   1235: aload_0
    //   1236: getfield 589	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams	Landroid/widget/LinearLayout$LayoutParams;
    //   1239: bipush 16
    //   1241: putfield 1304	android/widget/LinearLayout$LayoutParams:gravity	I
    //   1244: aload 7
    //   1246: aload_0
    //   1247: ldc_w 508
    //   1250: aconst_null
    //   1251: invokestatic 512	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   1254: aload_0
    //   1255: getfield 514	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_AndroidWidgetLinearLayout$LayoutParams	Landroid/widget/LinearLayout$LayoutParams;
    //   1258: invokevirtual 518	android/widget/LinearLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1261: aload_0
    //   1262: ldc_w 519
    //   1265: aconst_null
    //   1266: invokestatic 512	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   1269: astore 9
    //   1271: aload 9
    //   1273: iconst_1
    //   1274: invokevirtual 523	android/view/View:setFocusable	(Z)V
    //   1277: aload 9
    //   1279: iconst_1
    //   1280: invokevirtual 526	android/view/View:setClickable	(Z)V
    //   1283: aload 9
    //   1285: ldc_w 527
    //   1288: invokevirtual 475	android/view/View:findViewById	(I)Landroid/view/View;
    //   1291: checkcast 529	android/widget/TextView
    //   1294: astore 10
    //   1296: aload 9
    //   1298: ldc_w 484
    //   1301: invokevirtual 475	android/view/View:findViewById	(I)Landroid/view/View;
    //   1304: checkcast 486	android/widget/ImageView
    //   1307: astore 11
    //   1309: aload 10
    //   1311: ldc_w 1319
    //   1314: invokevirtual 1313	android/widget/TextView:setText	(I)V
    //   1317: aload 11
    //   1319: ldc_w 1320
    //   1322: invokevirtual 1317	android/widget/ImageView:setImageResource	(I)V
    //   1325: aload 9
    //   1327: iconst_1
    //   1328: invokestatic 861	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1331: invokevirtual 583	android/view/View:setTag	(Ljava/lang/Object;)V
    //   1334: aload 9
    //   1336: aload_0
    //   1337: invokevirtual 587	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1340: aload_0
    //   1341: getfield 468	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   1344: iconst_1
    //   1345: aload 9
    //   1347: aastore
    //   1348: aload 7
    //   1350: aload 9
    //   1352: aload_0
    //   1353: getfield 589	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams	Landroid/widget/LinearLayout$LayoutParams;
    //   1356: invokevirtual 518	android/widget/LinearLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1359: new 486	android/widget/ImageView
    //   1362: dup
    //   1363: aload_0
    //   1364: invokespecial 1203	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   1367: astore 7
    //   1369: aload 7
    //   1371: ldc_w 1204
    //   1374: invokevirtual 1205	android/widget/ImageView:setBackgroundResource	(I)V
    //   1377: new 1207	android/widget/LinearLayout$LayoutParams
    //   1380: dup
    //   1381: iconst_m1
    //   1382: iconst_2
    //   1383: invokespecial 1208	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   1386: astore 9
    //   1388: aload 9
    //   1390: aload_0
    //   1391: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   1394: f2i
    //   1395: bipush 14
    //   1397: imul
    //   1398: iconst_0
    //   1399: aload_0
    //   1400: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   1403: f2i
    //   1404: bipush 14
    //   1406: imul
    //   1407: iconst_0
    //   1408: invokevirtual 1213	android/widget/LinearLayout$LayoutParams:setMargins	(IIII)V
    //   1411: aload 7
    //   1413: aload 9
    //   1415: invokevirtual 552	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1418: aload_0
    //   1419: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1422: aload 7
    //   1424: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   1427: aload_0
    //   1428: getfield 203	com/tencent/mobileqq/activity/ChatSettingForTroop:al	I
    //   1431: iconst_1
    //   1432: if_icmpne +119 -> 1551
    //   1435: aload_0
    //   1436: ldc_w 1321
    //   1439: aconst_null
    //   1440: invokestatic 512	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   1443: astore 7
    //   1445: aload_0
    //   1446: getfield 468	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   1449: iconst_2
    //   1450: aload 7
    //   1452: aastore
    //   1453: aload_0
    //   1454: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1457: aload 7
    //   1459: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   1462: aload_0
    //   1463: iconst_2
    //   1464: iconst_2
    //   1465: aload 7
    //   1467: aload_0
    //   1468: ldc_w 1322
    //   1471: invokevirtual 636	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   1474: ldc_w 594
    //   1477: iconst_1
    //   1478: iconst_0
    //   1479: iconst_0
    //   1480: invokevirtual 1325	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(IILandroid/view/View;Ljava/lang/String;Ljava/lang/CharSequence;ZIZ)V
    //   1483: new 486	android/widget/ImageView
    //   1486: dup
    //   1487: aload_0
    //   1488: invokespecial 1203	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   1491: astore 7
    //   1493: aload 7
    //   1495: ldc_w 1204
    //   1498: invokevirtual 1205	android/widget/ImageView:setBackgroundResource	(I)V
    //   1501: new 1207	android/widget/LinearLayout$LayoutParams
    //   1504: dup
    //   1505: iconst_m1
    //   1506: iconst_2
    //   1507: invokespecial 1208	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   1510: astore 9
    //   1512: aload 9
    //   1514: aload_0
    //   1515: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   1518: f2i
    //   1519: bipush 14
    //   1521: imul
    //   1522: iconst_0
    //   1523: aload_0
    //   1524: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   1527: f2i
    //   1528: bipush 14
    //   1530: imul
    //   1531: iconst_0
    //   1532: invokevirtual 1213	android/widget/LinearLayout$LayoutParams:setMargins	(IIII)V
    //   1535: aload 7
    //   1537: aload 9
    //   1539: invokevirtual 552	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1542: aload_0
    //   1543: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1546: aload 7
    //   1548: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   1551: aload_0
    //   1552: getfield 203	com/tencent/mobileqq/activity/ChatSettingForTroop:al	I
    //   1555: iconst_1
    //   1556: if_icmpne +1484 -> 3040
    //   1559: aload_0
    //   1560: ldc_w 1326
    //   1563: aconst_null
    //   1564: invokestatic 512	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   1567: astore 7
    //   1569: aload_0
    //   1570: getfield 468	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   1573: bipush 7
    //   1575: aload 7
    //   1577: aastore
    //   1578: aload_0
    //   1579: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1582: aload 7
    //   1584: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   1587: aload_0
    //   1588: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1591: getfield 1327	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1594: invokestatic 379	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1597: ifeq +1370 -> 2967
    //   1600: aload_0
    //   1601: bipush 7
    //   1603: iconst_2
    //   1604: aload 7
    //   1606: aload_0
    //   1607: ldc_w 1328
    //   1610: invokevirtual 636	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   1613: aload_0
    //   1614: getfield 281	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1617: invokevirtual 1330	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   1620: iconst_1
    //   1621: invokevirtual 1333	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(IILandroid/view/View;Ljava/lang/String;Ljava/lang/CharSequence;Z)V
    //   1624: new 486	android/widget/ImageView
    //   1627: dup
    //   1628: aload_0
    //   1629: invokespecial 1203	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   1632: astore 7
    //   1634: aload 7
    //   1636: ldc_w 1204
    //   1639: invokevirtual 1205	android/widget/ImageView:setBackgroundResource	(I)V
    //   1642: new 1207	android/widget/LinearLayout$LayoutParams
    //   1645: dup
    //   1646: iconst_m1
    //   1647: iconst_2
    //   1648: invokespecial 1208	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   1651: astore 9
    //   1653: aload 9
    //   1655: aload_0
    //   1656: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   1659: f2i
    //   1660: bipush 14
    //   1662: imul
    //   1663: iconst_0
    //   1664: aload_0
    //   1665: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   1668: f2i
    //   1669: bipush 14
    //   1671: imul
    //   1672: iconst_0
    //   1673: invokevirtual 1213	android/widget/LinearLayout$LayoutParams:setMargins	(IIII)V
    //   1676: aload 7
    //   1678: aload 9
    //   1680: invokevirtual 552	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1683: aload_0
    //   1684: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1687: aload 7
    //   1689: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   1692: aload_0
    //   1693: ldc_w 1334
    //   1696: aconst_null
    //   1697: invokestatic 512	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   1700: astore 7
    //   1702: aload_0
    //   1703: getfield 468	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   1706: iconst_3
    //   1707: aload 7
    //   1709: aastore
    //   1710: aload_0
    //   1711: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1714: aload 7
    //   1716: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   1719: new 486	android/widget/ImageView
    //   1722: dup
    //   1723: aload_0
    //   1724: invokespecial 1203	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   1727: astore 9
    //   1729: aload 9
    //   1731: ldc_w 1204
    //   1734: invokevirtual 1205	android/widget/ImageView:setBackgroundResource	(I)V
    //   1737: new 1207	android/widget/LinearLayout$LayoutParams
    //   1740: dup
    //   1741: iconst_m1
    //   1742: iconst_2
    //   1743: invokespecial 1208	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   1746: astore 10
    //   1748: aload 10
    //   1750: aload_0
    //   1751: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   1754: f2i
    //   1755: bipush 14
    //   1757: imul
    //   1758: iconst_0
    //   1759: aload_0
    //   1760: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   1763: f2i
    //   1764: bipush 14
    //   1766: imul
    //   1767: iconst_0
    //   1768: invokevirtual 1213	android/widget/LinearLayout$LayoutParams:setMargins	(IIII)V
    //   1771: aload 9
    //   1773: aload 10
    //   1775: invokevirtual 552	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1778: aload_0
    //   1779: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1782: aload 9
    //   1784: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   1787: aload_0
    //   1788: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1791: invokevirtual 1179	com/tencent/mobileqq/troopinfo/TroopInfoData:e	()Z
    //   1794: ifeq +1200 -> 2994
    //   1797: aload_0
    //   1798: iconst_3
    //   1799: iconst_2
    //   1800: aload 7
    //   1802: aload_0
    //   1803: ldc_w 1335
    //   1806: invokevirtual 636	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   1809: aload_0
    //   1810: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1813: getfield 1336	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   1816: iconst_1
    //   1817: invokevirtual 1333	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(IILandroid/view/View;Ljava/lang/String;Ljava/lang/CharSequence;Z)V
    //   1820: aload_0
    //   1821: aload 7
    //   1823: invokevirtual 1338	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Landroid/view/View;)V
    //   1826: aload_0
    //   1827: ldc_w 1339
    //   1830: aconst_null
    //   1831: invokestatic 512	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   1834: astore 7
    //   1836: aload_0
    //   1837: bipush 6
    //   1839: iconst_2
    //   1840: aload 7
    //   1842: ldc_w 1340
    //   1845: invokevirtual 475	android/view/View:findViewById	(I)Landroid/view/View;
    //   1848: checkcast 1342	com/tencent/mobileqq/widget/FormSimpleItem
    //   1851: aload_0
    //   1852: ldc_w 1343
    //   1855: invokevirtual 636	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   1858: ldc_w 594
    //   1861: iconst_1
    //   1862: invokevirtual 1346	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(IILcom/tencent/mobileqq/widget/FormSimpleItem;Ljava/lang/String;Ljava/lang/CharSequence;Z)V
    //   1865: aload_0
    //   1866: getfield 468	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   1869: bipush 6
    //   1871: aload 7
    //   1873: aastore
    //   1874: aload_0
    //   1875: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1878: aload 7
    //   1880: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   1883: aload_0
    //   1884: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1887: invokevirtual 1179	com/tencent/mobileqq/troopinfo/TroopInfoData:e	()Z
    //   1890: ifeq +1130 -> 3020
    //   1893: aload 7
    //   1895: iconst_0
    //   1896: invokevirtual 1224	android/view/View:setVisibility	(I)V
    //   1899: new 486	android/widget/ImageView
    //   1902: dup
    //   1903: aload_0
    //   1904: invokespecial 1203	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   1907: astore 7
    //   1909: aload 7
    //   1911: ldc_w 1204
    //   1914: invokevirtual 1205	android/widget/ImageView:setBackgroundResource	(I)V
    //   1917: new 1207	android/widget/LinearLayout$LayoutParams
    //   1920: dup
    //   1921: iconst_m1
    //   1922: iconst_2
    //   1923: invokespecial 1208	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   1926: astore 9
    //   1928: aload 9
    //   1930: aload_0
    //   1931: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   1934: f2i
    //   1935: bipush 14
    //   1937: imul
    //   1938: iconst_0
    //   1939: aload_0
    //   1940: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   1943: f2i
    //   1944: bipush 14
    //   1946: imul
    //   1947: iconst_0
    //   1948: invokevirtual 1213	android/widget/LinearLayout$LayoutParams:setMargins	(IIII)V
    //   1951: aload 7
    //   1953: aload 9
    //   1955: invokevirtual 552	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1958: aload_0
    //   1959: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1962: aload 7
    //   1964: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   1967: new 1342	com/tencent/mobileqq/widget/FormSimpleItem
    //   1970: dup
    //   1971: aload_0
    //   1972: invokespecial 1347	com/tencent/mobileqq/widget/FormSimpleItem:<init>	(Landroid/content/Context;)V
    //   1975: astore 7
    //   1977: aload_0
    //   1978: bipush 17
    //   1980: iconst_2
    //   1981: aload 7
    //   1983: aload_0
    //   1984: ldc_w 1348
    //   1987: invokevirtual 636	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   1990: ldc_w 594
    //   1993: iconst_1
    //   1994: invokevirtual 1346	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(IILcom/tencent/mobileqq/widget/FormSimpleItem;Ljava/lang/String;Ljava/lang/CharSequence;Z)V
    //   1997: aload_0
    //   1998: getfield 468	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   2001: bipush 17
    //   2003: aload 7
    //   2005: aastore
    //   2006: aload_0
    //   2007: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   2010: aload 7
    //   2012: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   2015: new 486	android/widget/ImageView
    //   2018: dup
    //   2019: aload_0
    //   2020: invokespecial 1203	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   2023: astore 7
    //   2025: aload 7
    //   2027: ldc_w 1204
    //   2030: invokevirtual 1205	android/widget/ImageView:setBackgroundResource	(I)V
    //   2033: new 1207	android/widget/LinearLayout$LayoutParams
    //   2036: dup
    //   2037: iconst_m1
    //   2038: iconst_2
    //   2039: invokespecial 1208	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   2042: astore 9
    //   2044: aload 9
    //   2046: aload_0
    //   2047: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   2050: f2i
    //   2051: bipush 14
    //   2053: imul
    //   2054: iconst_0
    //   2055: aload_0
    //   2056: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   2059: f2i
    //   2060: bipush 14
    //   2062: imul
    //   2063: iconst_0
    //   2064: invokevirtual 1213	android/widget/LinearLayout$LayoutParams:setMargins	(IIII)V
    //   2067: aload 7
    //   2069: aload 9
    //   2071: invokevirtual 552	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   2074: aload_0
    //   2075: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   2078: aload 7
    //   2080: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   2083: new 1342	com/tencent/mobileqq/widget/FormSimpleItem
    //   2086: dup
    //   2087: aload_0
    //   2088: invokespecial 1347	com/tencent/mobileqq/widget/FormSimpleItem:<init>	(Landroid/content/Context;)V
    //   2091: astore 7
    //   2093: aload_0
    //   2094: bipush 21
    //   2096: iconst_2
    //   2097: aload 7
    //   2099: aload_0
    //   2100: ldc_w 1349
    //   2103: invokevirtual 636	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   2106: ldc_w 594
    //   2109: iconst_1
    //   2110: invokevirtual 1346	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(IILcom/tencent/mobileqq/widget/FormSimpleItem;Ljava/lang/String;Ljava/lang/CharSequence;Z)V
    //   2113: aload_0
    //   2114: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   2117: aload 7
    //   2119: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   2122: new 486	android/widget/ImageView
    //   2125: dup
    //   2126: aload_0
    //   2127: invokespecial 1203	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   2130: astore 7
    //   2132: aload 7
    //   2134: ldc_w 1204
    //   2137: invokevirtual 1205	android/widget/ImageView:setBackgroundResource	(I)V
    //   2140: new 1207	android/widget/LinearLayout$LayoutParams
    //   2143: dup
    //   2144: iconst_m1
    //   2145: iconst_2
    //   2146: invokespecial 1208	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   2149: astore 9
    //   2151: aload 9
    //   2153: aload_0
    //   2154: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   2157: f2i
    //   2158: bipush 14
    //   2160: imul
    //   2161: iconst_0
    //   2162: aload_0
    //   2163: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   2166: f2i
    //   2167: bipush 14
    //   2169: imul
    //   2170: iconst_0
    //   2171: invokevirtual 1213	android/widget/LinearLayout$LayoutParams:setMargins	(IIII)V
    //   2174: aload 7
    //   2176: aload 9
    //   2178: invokevirtual 552	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   2181: aload_0
    //   2182: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   2185: aload 7
    //   2187: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   2190: new 1342	com/tencent/mobileqq/widget/FormSimpleItem
    //   2193: dup
    //   2194: aload_0
    //   2195: invokespecial 1347	com/tencent/mobileqq/widget/FormSimpleItem:<init>	(Landroid/content/Context;)V
    //   2198: astore 7
    //   2200: aload_0
    //   2201: bipush 20
    //   2203: iconst_2
    //   2204: aload 7
    //   2206: aload_0
    //   2207: ldc_w 1350
    //   2210: invokevirtual 636	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   2213: ldc_w 594
    //   2216: iconst_1
    //   2217: invokevirtual 1346	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(IILcom/tencent/mobileqq/widget/FormSimpleItem;Ljava/lang/String;Ljava/lang/CharSequence;Z)V
    //   2220: aload_0
    //   2221: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   2224: aload 7
    //   2226: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   2229: new 486	android/widget/ImageView
    //   2232: dup
    //   2233: aload_0
    //   2234: invokespecial 1203	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   2237: astore 7
    //   2239: aload 7
    //   2241: ldc_w 1204
    //   2244: invokevirtual 1205	android/widget/ImageView:setBackgroundResource	(I)V
    //   2247: new 1207	android/widget/LinearLayout$LayoutParams
    //   2250: dup
    //   2251: iconst_m1
    //   2252: iconst_2
    //   2253: invokespecial 1208	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   2256: astore 9
    //   2258: aload 9
    //   2260: aload_0
    //   2261: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   2264: f2i
    //   2265: bipush 14
    //   2267: imul
    //   2268: iconst_0
    //   2269: aload_0
    //   2270: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   2273: f2i
    //   2274: bipush 14
    //   2276: imul
    //   2277: iconst_0
    //   2278: invokevirtual 1213	android/widget/LinearLayout$LayoutParams:setMargins	(IIII)V
    //   2281: aload 7
    //   2283: aload 9
    //   2285: invokevirtual 552	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   2288: aload_0
    //   2289: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   2292: aload 7
    //   2294: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   2297: aload_0
    //   2298: ldc_w 1339
    //   2301: aconst_null
    //   2302: invokestatic 512	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   2305: astore 7
    //   2307: aload_0
    //   2308: bipush 8
    //   2310: iconst_2
    //   2311: aload 7
    //   2313: ldc_w 1340
    //   2316: invokevirtual 475	android/view/View:findViewById	(I)Landroid/view/View;
    //   2319: checkcast 1342	com/tencent/mobileqq/widget/FormSimpleItem
    //   2322: aload_0
    //   2323: ldc_w 1351
    //   2326: invokevirtual 636	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   2329: ldc_w 594
    //   2332: iconst_1
    //   2333: invokevirtual 1346	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(IILcom/tencent/mobileqq/widget/FormSimpleItem;Ljava/lang/String;Ljava/lang/CharSequence;Z)V
    //   2336: aload_0
    //   2337: getfield 468	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   2340: bipush 8
    //   2342: aload 7
    //   2344: aastore
    //   2345: aload_0
    //   2346: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   2349: aload 7
    //   2351: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   2354: aload_0
    //   2355: ldc_w 1352
    //   2358: aconst_null
    //   2359: invokestatic 512	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   2362: astore 7
    //   2364: aload_0
    //   2365: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   2368: aload 7
    //   2370: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   2373: aload_0
    //   2374: ldc_w 1353
    //   2377: aconst_null
    //   2378: invokestatic 512	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   2381: astore 7
    //   2383: aload_0
    //   2384: getfield 468	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   2387: bipush 15
    //   2389: aload 7
    //   2391: aastore
    //   2392: aload_0
    //   2393: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   2396: aload 7
    //   2398: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   2401: aload_0
    //   2402: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   2405: getfield 997	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   2408: invokestatic 379	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2411: ifne +619 -> 3030
    //   2414: new 486	android/widget/ImageView
    //   2417: dup
    //   2418: aload_0
    //   2419: invokespecial 1203	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   2422: astore 9
    //   2424: aload 9
    //   2426: ldc_w 1204
    //   2429: invokevirtual 1205	android/widget/ImageView:setBackgroundResource	(I)V
    //   2432: new 1207	android/widget/LinearLayout$LayoutParams
    //   2435: dup
    //   2436: iconst_m1
    //   2437: iconst_2
    //   2438: invokespecial 1208	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   2441: astore 10
    //   2443: aload 10
    //   2445: aload_0
    //   2446: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   2449: f2i
    //   2450: bipush 14
    //   2452: imul
    //   2453: iconst_0
    //   2454: aload_0
    //   2455: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   2458: f2i
    //   2459: bipush 14
    //   2461: imul
    //   2462: iconst_0
    //   2463: invokevirtual 1213	android/widget/LinearLayout$LayoutParams:setMargins	(IIII)V
    //   2466: aload 9
    //   2468: aload 10
    //   2470: invokevirtual 552	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   2473: aload_0
    //   2474: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   2477: aload 9
    //   2479: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   2482: aload_0
    //   2483: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   2486: getfield 997	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   2489: astore 9
    //   2491: aload_0
    //   2492: bipush 15
    //   2494: iconst_0
    //   2495: aload 7
    //   2497: aload_0
    //   2498: ldc_w 1354
    //   2501: invokevirtual 636	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   2504: aload 9
    //   2506: iconst_0
    //   2507: invokevirtual 1356	com/tencent/mobileqq/activity/ChatSettingForTroop:b	(IILandroid/view/View;Ljava/lang/String;Ljava/lang/CharSequence;Z)V
    //   2510: new 486	android/widget/ImageView
    //   2513: dup
    //   2514: aload_0
    //   2515: invokespecial 1203	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   2518: astore 7
    //   2520: aload 7
    //   2522: ldc_w 1204
    //   2525: invokevirtual 1205	android/widget/ImageView:setBackgroundResource	(I)V
    //   2528: new 1207	android/widget/LinearLayout$LayoutParams
    //   2531: dup
    //   2532: iconst_m1
    //   2533: iconst_2
    //   2534: invokespecial 1208	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   2537: astore 9
    //   2539: aload 9
    //   2541: aload_0
    //   2542: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   2545: f2i
    //   2546: bipush 14
    //   2548: imul
    //   2549: iconst_0
    //   2550: aload_0
    //   2551: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   2554: f2i
    //   2555: bipush 14
    //   2557: imul
    //   2558: iconst_0
    //   2559: invokevirtual 1213	android/widget/LinearLayout$LayoutParams:setMargins	(IIII)V
    //   2562: aload 7
    //   2564: aload 9
    //   2566: invokevirtual 552	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   2569: aload_0
    //   2570: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   2573: aload 7
    //   2575: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   2578: aload_0
    //   2579: ldc_w 1352
    //   2582: aconst_null
    //   2583: invokestatic 512	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   2586: astore 7
    //   2588: aload_0
    //   2589: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   2592: aload 7
    //   2594: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   2597: invokestatic 684	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2600: ifeq +34 -> 2634
    //   2603: ldc 55
    //   2605: iconst_2
    //   2606: new 314	java/lang/StringBuilder
    //   2609: dup
    //   2610: invokespecial 315	java/lang/StringBuilder:<init>	()V
    //   2613: ldc_w 1358
    //   2616: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2619: invokestatic 667	java/lang/System:currentTimeMillis	()J
    //   2622: lload 4
    //   2624: lsub
    //   2625: invokevirtual 592	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2628: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2631: invokestatic 739	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2634: aload_0
    //   2635: getfield 1360	com/tencent/mobileqq/activity/ChatSettingForTroop:p	Landroid/widget/ImageView;
    //   2638: iconst_0
    //   2639: invokevirtual 1361	android/widget/ImageView:setVisibility	(I)V
    //   2642: aload_0
    //   2643: getfield 1360	com/tencent/mobileqq/activity/ChatSettingForTroop:p	Landroid/widget/ImageView;
    //   2646: ldc_w 1362
    //   2649: invokevirtual 1317	android/widget/ImageView:setImageResource	(I)V
    //   2652: aload_0
    //   2653: getfield 1360	com/tencent/mobileqq/activity/ChatSettingForTroop:p	Landroid/widget/ImageView;
    //   2656: aload_0
    //   2657: ldc_w 1363
    //   2660: invokevirtual 636	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   2663: invokevirtual 1247	android/widget/ImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   2666: aload_0
    //   2667: getfield 1360	com/tencent/mobileqq/activity/ChatSettingForTroop:p	Landroid/widget/ImageView;
    //   2670: new 1365	afo
    //   2673: dup
    //   2674: aload_0
    //   2675: invokespecial 1366	afo:<init>	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;)V
    //   2678: invokevirtual 1244	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2681: aload_0
    //   2682: aload 8
    //   2684: ldc_w 1367
    //   2687: invokevirtual 475	android/view/View:findViewById	(I)Landroid/view/View;
    //   2690: putfield 1369	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   2693: aload_0
    //   2694: getfield 203	com/tencent/mobileqq/activity/ChatSettingForTroop:al	I
    //   2697: iconst_2
    //   2698: if_icmpne +87 -> 2785
    //   2701: aload_0
    //   2702: getfield 1369	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   2705: ldc_w 1370
    //   2708: invokevirtual 475	android/view/View:findViewById	(I)Landroid/view/View;
    //   2711: checkcast 486	android/widget/ImageView
    //   2714: astore 7
    //   2716: aload_0
    //   2717: getfield 1369	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   2720: ldc_w 1371
    //   2723: invokevirtual 475	android/view/View:findViewById	(I)Landroid/view/View;
    //   2726: checkcast 529	android/widget/TextView
    //   2729: astore 8
    //   2731: aload_0
    //   2732: getfield 1369	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   2735: iconst_0
    //   2736: invokevirtual 1224	android/view/View:setVisibility	(I)V
    //   2739: aload_0
    //   2740: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   2743: getfield 275	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Boolean	Z
    //   2746: ifeq +740 -> 3486
    //   2749: aload 7
    //   2751: ldc_w 1372
    //   2754: invokevirtual 1317	android/widget/ImageView:setImageResource	(I)V
    //   2757: aload 8
    //   2759: ldc_w 1373
    //   2762: invokevirtual 1313	android/widget/TextView:setText	(I)V
    //   2765: aload_0
    //   2766: getfield 1369	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   2769: bipush 24
    //   2771: invokestatic 861	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2774: invokevirtual 583	android/view/View:setTag	(Ljava/lang/Object;)V
    //   2777: aload_0
    //   2778: getfield 1369	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   2781: aload_0
    //   2782: invokevirtual 587	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2785: aload_0
    //   2786: iconst_0
    //   2787: invokevirtual 1375	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Z)V
    //   2790: aload_0
    //   2791: getfield 1098	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   2794: invokevirtual 1379	com/tencent/widget/XListView:getViewTreeObserver	()Landroid/view/ViewTreeObserver;
    //   2797: new 1381	afp
    //   2800: dup
    //   2801: aload_0
    //   2802: invokespecial 1382	afp:<init>	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;)V
    //   2805: invokevirtual 1388	android/view/ViewTreeObserver:addOnGlobalLayoutListener	(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    //   2808: return
    //   2809: astore 7
    //   2811: aload_0
    //   2812: invokevirtual 351	com/tencent/mobileqq/activity/ChatSettingForTroop:finish	()V
    //   2815: aload 7
    //   2817: invokevirtual 1391	java/lang/OutOfMemoryError:printStackTrace	()V
    //   2820: return
    //   2821: astore 7
    //   2823: invokestatic 684	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2826: ifeq +14 -> 2840
    //   2829: ldc 55
    //   2831: iconst_2
    //   2832: aload 7
    //   2834: invokevirtual 1394	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   2837: invokestatic 689	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2840: aload_0
    //   2841: invokevirtual 351	com/tencent/mobileqq/activity/ChatSettingForTroop:finish	()V
    //   2844: return
    //   2845: astore 7
    //   2847: invokestatic 684	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2850: ifeq +14 -> 2864
    //   2853: ldc 55
    //   2855: iconst_2
    //   2856: aload 7
    //   2858: invokevirtual 1395	android/view/InflateException:getMessage	()Ljava/lang/String;
    //   2861: invokestatic 689	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2864: aload_0
    //   2865: invokevirtual 351	com/tencent/mobileqq/activity/ChatSettingForTroop:finish	()V
    //   2868: return
    //   2869: iconst_0
    //   2870: istore 6
    //   2872: goto -2582 -> 290
    //   2875: new 486	android/widget/ImageView
    //   2878: dup
    //   2879: aload_0
    //   2880: invokespecial 1203	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   2883: astore 9
    //   2885: aload 9
    //   2887: ldc_w 1204
    //   2890: invokevirtual 1205	android/widget/ImageView:setBackgroundResource	(I)V
    //   2893: new 1207	android/widget/LinearLayout$LayoutParams
    //   2896: dup
    //   2897: iconst_m1
    //   2898: iconst_2
    //   2899: invokespecial 1208	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   2902: astore 10
    //   2904: aload 10
    //   2906: aload_0
    //   2907: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   2910: f2i
    //   2911: bipush 14
    //   2913: imul
    //   2914: iconst_0
    //   2915: aload_0
    //   2916: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   2919: f2i
    //   2920: bipush 14
    //   2922: imul
    //   2923: iconst_0
    //   2924: invokevirtual 1213	android/widget/LinearLayout$LayoutParams:setMargins	(IIII)V
    //   2927: aload 9
    //   2929: aload 10
    //   2931: invokevirtual 552	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   2934: aload_0
    //   2935: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   2938: aload 9
    //   2940: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   2943: goto -2430 -> 513
    //   2946: aload 9
    //   2948: iconst_0
    //   2949: invokevirtual 1224	android/view/View:setVisibility	(I)V
    //   2952: aload 10
    //   2954: aload_0
    //   2955: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   2958: getfield 1277	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   2961: invokevirtual 536	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2964: goto -2078 -> 886
    //   2967: aload_0
    //   2968: bipush 7
    //   2970: iconst_2
    //   2971: aload 7
    //   2973: aload_0
    //   2974: ldc_w 1328
    //   2977: invokevirtual 636	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   2980: aload_0
    //   2981: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   2984: getfield 1327	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   2987: iconst_1
    //   2988: invokevirtual 1333	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(IILandroid/view/View;Ljava/lang/String;Ljava/lang/CharSequence;Z)V
    //   2991: goto -1367 -> 1624
    //   2994: aload_0
    //   2995: iconst_3
    //   2996: iconst_2
    //   2997: aload 7
    //   2999: aload_0
    //   3000: ldc_w 1335
    //   3003: invokevirtual 636	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   3006: aload_0
    //   3007: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   3010: getfield 1336	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   3013: iconst_1
    //   3014: invokevirtual 1333	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(IILandroid/view/View;Ljava/lang/String;Ljava/lang/CharSequence;Z)V
    //   3017: goto -1197 -> 1820
    //   3020: aload 7
    //   3022: bipush 8
    //   3024: invokevirtual 1224	android/view/View:setVisibility	(I)V
    //   3027: goto -1060 -> 1967
    //   3030: aload 7
    //   3032: bipush 8
    //   3034: invokevirtual 1224	android/view/View:setVisibility	(I)V
    //   3037: goto -459 -> 2578
    //   3040: aload_0
    //   3041: getfield 203	com/tencent/mobileqq/activity/ChatSettingForTroop:al	I
    //   3044: iconst_2
    //   3045: if_icmpne -467 -> 2578
    //   3048: aload_0
    //   3049: ldc_w 1334
    //   3052: aconst_null
    //   3053: invokestatic 512	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   3056: astore 7
    //   3058: aload_0
    //   3059: getfield 468	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   3062: bipush 16
    //   3064: aload 7
    //   3066: aastore
    //   3067: aload_0
    //   3068: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   3071: aload 7
    //   3073: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   3076: aload_0
    //   3077: bipush 16
    //   3079: iconst_1
    //   3080: aload 7
    //   3082: aload_0
    //   3083: ldc_w 1396
    //   3086: invokevirtual 636	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   3089: aload_0
    //   3090: ldc_w 1397
    //   3093: invokevirtual 636	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   3096: iconst_1
    //   3097: invokevirtual 1333	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(IILandroid/view/View;Ljava/lang/String;Ljava/lang/CharSequence;Z)V
    //   3100: aload_0
    //   3101: aload 7
    //   3103: invokevirtual 1338	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Landroid/view/View;)V
    //   3106: new 486	android/widget/ImageView
    //   3109: dup
    //   3110: aload_0
    //   3111: invokespecial 1203	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   3114: astore 7
    //   3116: aload 7
    //   3118: ldc_w 1204
    //   3121: invokevirtual 1205	android/widget/ImageView:setBackgroundResource	(I)V
    //   3124: new 1207	android/widget/LinearLayout$LayoutParams
    //   3127: dup
    //   3128: iconst_m1
    //   3129: iconst_2
    //   3130: invokespecial 1208	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   3133: astore 9
    //   3135: aload 9
    //   3137: aload_0
    //   3138: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   3141: f2i
    //   3142: bipush 14
    //   3144: imul
    //   3145: iconst_0
    //   3146: aload_0
    //   3147: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   3150: f2i
    //   3151: bipush 14
    //   3153: imul
    //   3154: iconst_0
    //   3155: invokevirtual 1213	android/widget/LinearLayout$LayoutParams:setMargins	(IIII)V
    //   3158: aload 7
    //   3160: aload 9
    //   3162: invokevirtual 552	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   3165: aload_0
    //   3166: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   3169: aload 7
    //   3171: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   3174: aload_0
    //   3175: ldc_w 1398
    //   3178: aconst_null
    //   3179: invokestatic 512	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   3182: astore 9
    //   3184: aload_0
    //   3185: getfield 468	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   3188: bipush 18
    //   3190: aload 9
    //   3192: aastore
    //   3193: aload_0
    //   3194: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   3197: aload 9
    //   3199: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   3202: new 486	android/widget/ImageView
    //   3205: dup
    //   3206: aload_0
    //   3207: invokespecial 1203	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   3210: astore 7
    //   3212: aload 7
    //   3214: ldc_w 1204
    //   3217: invokevirtual 1205	android/widget/ImageView:setBackgroundResource	(I)V
    //   3220: new 1207	android/widget/LinearLayout$LayoutParams
    //   3223: dup
    //   3224: iconst_m1
    //   3225: iconst_2
    //   3226: invokespecial 1208	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   3229: astore 10
    //   3231: aload 10
    //   3233: aload_0
    //   3234: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   3237: f2i
    //   3238: bipush 14
    //   3240: imul
    //   3241: iconst_0
    //   3242: aload_0
    //   3243: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   3246: f2i
    //   3247: bipush 14
    //   3249: imul
    //   3250: iconst_0
    //   3251: invokevirtual 1213	android/widget/LinearLayout$LayoutParams:setMargins	(IIII)V
    //   3254: aload 7
    //   3256: aload 10
    //   3258: invokevirtual 552	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   3261: aload_0
    //   3262: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   3265: aload 7
    //   3267: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   3270: ldc_w 594
    //   3273: astore 7
    //   3275: aload_0
    //   3276: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   3279: getfield 1336	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   3282: ifnull +12 -> 3294
    //   3285: aload_0
    //   3286: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   3289: getfield 1336	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   3292: astore 7
    //   3294: aload_0
    //   3295: bipush 18
    //   3297: iconst_3
    //   3298: aload 9
    //   3300: aload_0
    //   3301: ldc_w 1335
    //   3304: invokevirtual 636	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   3307: aload 7
    //   3309: iconst_1
    //   3310: invokevirtual 1333	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(IILandroid/view/View;Ljava/lang/String;Ljava/lang/CharSequence;Z)V
    //   3313: aload_0
    //   3314: invokevirtual 1400	com/tencent/mobileqq/activity/ChatSettingForTroop:f	()V
    //   3317: aload_0
    //   3318: ldc_w 1352
    //   3321: aconst_null
    //   3322: invokestatic 512	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   3325: astore 7
    //   3327: aload_0
    //   3328: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   3331: aload 7
    //   3333: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   3336: aload_0
    //   3337: ldc_w 1353
    //   3340: aconst_null
    //   3341: invokestatic 512	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   3344: astore 7
    //   3346: aload_0
    //   3347: getfield 468	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   3350: bipush 15
    //   3352: aload 7
    //   3354: aastore
    //   3355: aload_0
    //   3356: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   3359: aload 7
    //   3361: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   3364: aload_0
    //   3365: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   3368: getfield 997	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   3371: invokestatic 379	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3374: ifne +102 -> 3476
    //   3377: aload_0
    //   3378: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   3381: getfield 997	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   3384: astore 9
    //   3386: aload_0
    //   3387: bipush 15
    //   3389: iconst_0
    //   3390: aload 7
    //   3392: aload_0
    //   3393: ldc_w 1354
    //   3396: invokevirtual 636	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   3399: aload 9
    //   3401: iconst_0
    //   3402: invokevirtual 1356	com/tencent/mobileqq/activity/ChatSettingForTroop:b	(IILandroid/view/View;Ljava/lang/String;Ljava/lang/CharSequence;Z)V
    //   3405: new 486	android/widget/ImageView
    //   3408: dup
    //   3409: aload_0
    //   3410: invokespecial 1203	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   3413: astore 7
    //   3415: aload 7
    //   3417: ldc_w 1204
    //   3420: invokevirtual 1205	android/widget/ImageView:setBackgroundResource	(I)V
    //   3423: new 1207	android/widget/LinearLayout$LayoutParams
    //   3426: dup
    //   3427: iconst_m1
    //   3428: iconst_2
    //   3429: invokespecial 1208	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   3432: astore 9
    //   3434: aload 9
    //   3436: aload_0
    //   3437: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   3440: f2i
    //   3441: bipush 14
    //   3443: imul
    //   3444: iconst_0
    //   3445: aload_0
    //   3446: getfield 1210	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Float	F
    //   3449: f2i
    //   3450: bipush 14
    //   3452: imul
    //   3453: iconst_0
    //   3454: invokevirtual 1213	android/widget/LinearLayout$LayoutParams:setMargins	(IIII)V
    //   3457: aload 7
    //   3459: aload 9
    //   3461: invokevirtual 552	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   3464: aload_0
    //   3465: getfield 1114	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   3468: aload 7
    //   3470: invokevirtual 1202	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   3473: goto -895 -> 2578
    //   3476: aload 7
    //   3478: bipush 8
    //   3480: invokevirtual 1224	android/view/View:setVisibility	(I)V
    //   3483: goto -905 -> 2578
    //   3486: aload_0
    //   3487: getfield 371	com/tencent/mobileqq/activity/ChatSettingForTroop:an	I
    //   3490: iconst_2
    //   3491: if_icmpne +43 -> 3534
    //   3494: aload_0
    //   3495: getfield 281	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3498: ldc_w 606
    //   3501: ldc_w 1402
    //   3504: ldc_w 594
    //   3507: ldc_w 1404
    //   3510: ldc_w 1406
    //   3513: iconst_0
    //   3514: iconst_0
    //   3515: aload_0
    //   3516: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   3519: getfield 290	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3522: ldc_w 594
    //   3525: ldc_w 594
    //   3528: ldc_w 594
    //   3531: invokestatic 617	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3534: aload 7
    //   3536: ldc_w 1407
    //   3539: invokevirtual 1317	android/widget/ImageView:setImageResource	(I)V
    //   3542: aload 8
    //   3544: ldc_w 1408
    //   3547: invokevirtual 1313	android/widget/TextView:setText	(I)V
    //   3550: aload_0
    //   3551: getfield 1369	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   3554: bipush 25
    //   3556: invokestatic 861	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3559: invokevirtual 583	android/view/View:setTag	(Ljava/lang/Object;)V
    //   3562: aload_0
    //   3563: getfield 1369	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   3566: aload_0
    //   3567: invokevirtual 587	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   3570: goto -785 -> 2785
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3573	0	this	ChatSettingForTroop
    //   158	821	1	i1	int
    //   166	194	2	i2	int
    //   177	9	3	i3	int
    //   3	2620	4	l1	long
    //   288	2583	6	bool	boolean
    //   92	2658	7	localObject1	Object
    //   2809	7	7	localOutOfMemoryError1	OutOfMemoryError
    //   2821	12	7	localOutOfMemoryError2	OutOfMemoryError
    //   2845	186	7	localInflateException	InflateException
    //   3056	479	7	localObject2	Object
    //   13	3530	8	localObject3	Object
    //   410	3050	9	localObject4	Object
    //   558	2699	10	localObject5	Object
    //   571	747	11	localObject6	Object
    //   584	143	12	localTextView	TextView
    //   597	166	13	localImageView	ImageView
    //   626	21	14	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   5	15	2809	java/lang/OutOfMemoryError
    //   236	246	2821	java/lang/OutOfMemoryError
    //   236	246	2845	android/view/InflateException
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[18];
    if (localObject == null) {}
    String str;
    do
    {
      return;
      str = String.format(getString(2131363640), new Object[] { Integer.valueOf(paramInt1) });
      localObject = (TextView)((View)localObject).findViewById(2131296953);
    } while (localObject == null);
    ((TextView)localObject).setText(str);
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramView, paramString, paramBoolean);
    paramString = (TextView)paramView.findViewById(2131296953);
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
    paramString = (TextView)paramView.findViewById(2131296953);
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
      paramView.setBackgroundResource(2130837754);
      TextView localTextView = (TextView)paramView.findViewById(2131296932);
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
    paramView = paramView.findViewById(2131297744);
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
        localTextView = (TextView)localView.findViewById(2131296953);
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
    //   5: getfield 1519	KQQ/BatchResponse:result	I
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: new 1521	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   15: dup
    //   16: invokespecial 1522	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   19: astore 10
    //   21: aload 10
    //   23: aload_1
    //   24: getfield 1525	KQQ/BatchResponse:buffer	[B
    //   27: checkcast 1526	[B
    //   30: invokevirtual 1530	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   33: pop
    //   34: aload_1
    //   35: getfield 1533	KQQ/BatchResponse:seq	I
    //   38: ifne +200 -> 238
    //   41: aload 10
    //   43: ifnull +195 -> 238
    //   46: aload 10
    //   48: getfield 1537	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   51: invokevirtual 1542	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   54: ifeq +184 -> 238
    //   57: aload 10
    //   59: getfield 1537	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   62: invokevirtual 1545	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   65: invokevirtual 1551	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   68: astore 9
    //   70: new 1553	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   73: dup
    //   74: invokespecial 1554	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   77: astore 8
    //   79: aload 8
    //   81: aload 9
    //   83: invokevirtual 1555	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   86: pop
    //   87: aconst_null
    //   88: astore 9
    //   90: aload 8
    //   92: getfield 1559	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   95: invokevirtual 1563	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   98: astore 11
    //   100: aload 11
    //   102: ifnonnull +57 -> 159
    //   105: iconst_0
    //   106: istore_2
    //   107: goto +1369 -> 1476
    //   110: aload 9
    //   112: ifnonnull +126 -> 238
    //   115: iload_3
    //   116: iload_2
    //   117: if_icmpge +121 -> 238
    //   120: aload 11
    //   122: iload_3
    //   123: invokeinterface 1498 2 0
    //   128: checkcast 1565	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
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
    //   155: invokevirtual 1566	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   158: return
    //   159: aload 11
    //   161: invokeinterface 483 1 0
    //   166: istore_2
    //   167: goto +1309 -> 1476
    //   170: aload 12
    //   172: getfield 1570	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   175: invokevirtual 1574	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
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
    //   200: ldc_w 1575
    //   203: iconst_1
    //   204: invokestatic 1580	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   207: invokevirtual 1583	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   210: pop
    //   211: aload 9
    //   213: astore 8
    //   215: goto -73 -> 142
    //   218: astore 8
    //   220: invokestatic 684	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +15 -> 238
    //   226: ldc_w 1585
    //   229: iconst_2
    //   230: aload 8
    //   232: invokevirtual 737	java/lang/Exception:toString	()Ljava/lang/String;
    //   235: invokestatic 739	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   238: aload_1
    //   239: getfield 1533	KQQ/BatchResponse:seq	I
    //   242: iconst_1
    //   243: if_icmpne +81 -> 324
    //   246: aload 10
    //   248: ifnull +76 -> 324
    //   251: aload 10
    //   253: getfield 1537	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   256: invokevirtual 1542	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   259: ifeq +65 -> 324
    //   262: aload 10
    //   264: getfield 1537	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   267: invokevirtual 1545	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   270: invokevirtual 1551	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   273: astore 8
    //   275: new 1587	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody
    //   278: dup
    //   279: invokespecial 1588	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:<init>	()V
    //   282: astore 9
    //   284: aload 9
    //   286: aload 8
    //   288: invokevirtual 1589	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   291: pop
    //   292: aload 9
    //   294: getfield 1592	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   297: ifnull +27 -> 324
    //   300: aload_0
    //   301: aload 9
    //   303: getfield 1592	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   306: invokevirtual 1563	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   309: invokevirtual 1595	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Ljava/util/List;)V
    //   312: aload_0
    //   313: aload 9
    //   315: getfield 1592	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   318: invokevirtual 1563	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   321: putfield 1597	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   324: aload_1
    //   325: getfield 1533	KQQ/BatchResponse:seq	I
    //   328: iconst_2
    //   329: if_icmpne -318 -> 11
    //   332: aload 10
    //   334: ifnull -323 -> 11
    //   337: aload 10
    //   339: getfield 1537	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   342: invokevirtual 1542	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   345: ifeq -334 -> 11
    //   348: aload 10
    //   350: getfield 1537	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   353: invokevirtual 1545	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   356: invokevirtual 1551	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   359: astore_1
    //   360: new 1599	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody
    //   363: dup
    //   364: invokespecial 1600	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:<init>	()V
    //   367: astore 8
    //   369: aload 8
    //   371: aload_1
    //   372: invokevirtual 1601	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   375: pop
    //   376: aload 8
    //   378: getfield 1604	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   381: invokevirtual 1563	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   384: astore_1
    //   385: aload 8
    //   387: getfield 1607	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_member_level_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   390: invokevirtual 1563	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   393: astore 9
    //   395: aload 8
    //   397: getfield 1610	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   400: invokevirtual 1574	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   403: istore_2
    //   404: aload_0
    //   405: getfield 281	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   408: invokevirtual 1613	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
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
    //   463: invokeinterface 1498 2 0
    //   468: checkcast 1615	tencent/im/oidb/cmd0x787/oidb_0x787$MemberLevelInfo
    //   471: astore 8
    //   473: aload 8
    //   475: ifnull +988 -> 1463
    //   478: lload 6
    //   480: aload 8
    //   482: getfield 1619	tencent/im/oidb/cmd0x787/oidb_0x787$MemberLevelInfo:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   485: invokevirtual 1623	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   488: lcmp
    //   489: ifne +974 -> 1463
    //   492: aload 8
    //   494: getfield 1626	tencent/im/oidb/cmd0x787/oidb_0x787$MemberLevelInfo:uint32_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   497: invokevirtual 1574	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
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
    //   519: invokeinterface 1498 2 0
    //   524: checkcast 1628	tencent/im/oidb/cmd0x787/oidb_0x787$LevelName
    //   527: astore 8
    //   529: aload 8
    //   531: getfield 1629	tencent/im/oidb/cmd0x787/oidb_0x787$LevelName:uint32_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   534: invokevirtual 1574	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   537: iload_3
    //   538: if_icmpne +29 -> 567
    //   541: aload 8
    //   543: getfield 1632	tencent/im/oidb/cmd0x787/oidb_0x787$LevelName:str_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   546: invokevirtual 1542	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   549: ifeq +18 -> 567
    //   552: aload_0
    //   553: aload 8
    //   555: getfield 1632	tencent/im/oidb/cmd0x787/oidb_0x787$LevelName:str_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   558: invokevirtual 1545	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   561: invokevirtual 1635	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   564: invokevirtual 1637	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Ljava/lang/String;)V
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
    //   587: ldc_w 1638
    //   590: iconst_1
    //   591: invokestatic 1580	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   594: invokevirtual 1583	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
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
    //   620: getfield 1642	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   623: invokevirtual 1645	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   626: ifeq -484 -> 142
    //   629: aload 12
    //   631: getfield 1642	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   634: invokevirtual 1648	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   637: checkcast 1644	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   640: astore 9
    //   642: aload 9
    //   644: astore 8
    //   646: aload 9
    //   648: ifnull -506 -> 142
    //   651: aload_0
    //   652: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   655: ifnull +528 -> 1183
    //   658: aload_0
    //   659: getfield 468	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   662: bipush 12
    //   664: aaload
    //   665: astore 8
    //   667: aload 9
    //   669: getfield 1651	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   672: invokevirtual 1542	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   675: ifeq +42 -> 717
    //   678: aload_0
    //   679: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   682: aload 9
    //   684: getfield 1651	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   687: invokevirtual 1545	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   690: invokevirtual 1635	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   693: putfield 364	com/tencent/mobileqq/troopinfo/TroopInfoData:f	Ljava/lang/String;
    //   696: aload 8
    //   698: ldc_w 1229
    //   701: invokevirtual 475	android/view/View:findViewById	(I)Landroid/view/View;
    //   704: checkcast 529	android/widget/TextView
    //   707: aload_0
    //   708: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   711: getfield 364	com/tencent/mobileqq/troopinfo/TroopInfoData:f	Ljava/lang/String;
    //   714: invokevirtual 536	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   717: aload_0
    //   718: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   721: aload 9
    //   723: getfield 1654	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_grade	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   726: invokevirtual 1574	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   729: putfield 1078	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_n_of_type_Int	I
    //   732: aload_0
    //   733: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   736: aload 9
    //   738: getfield 1657	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_active_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   741: invokevirtual 1574	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   744: putfield 1659	com/tencent/mobileqq/troopinfo/TroopInfoData:o	I
    //   747: aload_0
    //   748: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   751: aload 9
    //   753: getfield 1662	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flag_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   756: invokevirtual 1574	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   759: i2l
    //   760: putfield 1664	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_b_of_type_Long	J
    //   763: aload_0
    //   764: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   767: aload 9
    //   769: getfield 1667	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_certification_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   772: invokevirtual 1574	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   775: i2l
    //   776: putfield 1669	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_Long	J
    //   779: aload_0
    //   780: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   783: aload 9
    //   785: getfield 1672	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_class_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   788: invokevirtual 1574	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   791: i2l
    //   792: putfield 991	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Long	J
    //   795: aload_0
    //   796: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   799: aload 9
    //   801: getfield 1675	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   804: invokevirtual 1574	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   807: putfield 1677	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_Int	I
    //   810: aload_0
    //   811: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   814: aload 9
    //   816: getfield 1680	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_type_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   819: invokevirtual 1574	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   822: putfield 1682	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_r_of_type_Int	I
    //   825: aload_0
    //   826: invokevirtual 1684	com/tencent/mobileqq/activity/ChatSettingForTroop:v	()V
    //   829: aload 9
    //   831: getfield 1687	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_class_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   834: invokevirtual 1542	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   837: ifeq +42 -> 879
    //   840: aload_0
    //   841: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   844: aload 9
    //   846: getfield 1687	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_class_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   849: invokevirtual 1545	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   852: invokevirtual 1635	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   855: putfield 1689	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   858: aload_0
    //   859: getfield 964	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   862: ifnull +17 -> 879
    //   865: aload_0
    //   866: getfield 964	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   869: aload_0
    //   870: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   873: getfield 1689	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   876: putfield 1692	com/tencent/mobileqq/data/TroopInfo:mGroupClassExtText	Ljava/lang/String;
    //   879: aload 9
    //   881: getfield 1696	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:group_geo_info	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo;
    //   884: invokevirtual 1699	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   887: checkcast 1698	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo
    //   890: astore 8
    //   892: aload 8
    //   894: getfield 1702	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo:bytes_geocontent	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   897: invokevirtual 1545	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   900: invokevirtual 1635	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   903: astore 12
    //   905: aload 8
    //   907: getfield 1706	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo:int64_latitude	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   910: invokevirtual 1709	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   913: l2i
    //   914: istore 4
    //   916: aload 8
    //   918: getfield 1712	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo:int64_longitude	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   921: invokevirtual 1709	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   924: l2i
    //   925: istore 5
    //   927: aload 12
    //   929: invokestatic 379	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   932: ifne +12 -> 944
    //   935: aload_0
    //   936: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   939: aload 12
    //   941: putfield 1277	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   944: iload 4
    //   946: ifeq +12 -> 958
    //   949: aload_0
    //   950: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   953: iload 4
    //   955: putfield 1462	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_d_of_type_Int	I
    //   958: iload 5
    //   960: ifeq +12 -> 972
    //   963: aload_0
    //   964: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   967: iload 5
    //   969: putfield 1466	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_e_of_type_Int	I
    //   972: aload_0
    //   973: invokevirtual 1477	com/tencent/mobileqq/activity/ChatSettingForTroop:k	()V
    //   976: aload 9
    //   978: getfield 1715	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_finger_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   981: invokevirtual 1542	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   984: ifeq +383 -> 1367
    //   987: aload_0
    //   988: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   991: aload 9
    //   993: getfield 1715	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_finger_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   996: invokevirtual 1545	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   999: invokevirtual 1635	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1002: putfield 1716	com/tencent/mobileqq/troopinfo/TroopInfoData:l	Ljava/lang/String;
    //   1005: aload 9
    //   1007: getfield 1719	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_rich_finger_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1010: invokevirtual 1542	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1013: ifeq +367 -> 1380
    //   1016: aload_0
    //   1017: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1020: aload 9
    //   1022: getfield 1719	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_rich_finger_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1025: invokevirtual 1545	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1028: invokevirtual 1635	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1031: putfield 997	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   1034: aload_0
    //   1035: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1038: getfield 997	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   1041: invokestatic 379	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1044: ifeq +349 -> 1393
    //   1047: aload_0
    //   1048: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1051: aload_0
    //   1052: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1055: getfield 1716	com/tencent/mobileqq/troopinfo/TroopInfoData:l	Ljava/lang/String;
    //   1058: putfield 997	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   1061: aload_0
    //   1062: getfield 468	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   1065: bipush 15
    //   1067: aaload
    //   1068: astore 8
    //   1070: aload 8
    //   1072: ifnull +46 -> 1118
    //   1075: aload_0
    //   1076: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1079: getfield 997	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   1082: invokestatic 379	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1085: ifne +345 -> 1430
    //   1088: aload 8
    //   1090: iconst_0
    //   1091: invokevirtual 1224	android/view/View:setVisibility	(I)V
    //   1094: aload_0
    //   1095: bipush 15
    //   1097: iconst_0
    //   1098: aload 8
    //   1100: aload_0
    //   1101: ldc_w 1354
    //   1104: invokevirtual 636	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   1107: aload_0
    //   1108: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1111: getfield 997	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   1114: iconst_0
    //   1115: invokevirtual 1356	com/tencent/mobileqq/activity/ChatSettingForTroop:b	(IILandroid/view/View;Ljava/lang/String;Ljava/lang/CharSequence;Z)V
    //   1118: aload_0
    //   1119: invokevirtual 1721	com/tencent/mobileqq/activity/ChatSettingForTroop:e	()V
    //   1122: aload 9
    //   1124: getfield 1662	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flag_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1127: invokevirtual 1722	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1130: ifeq +18 -> 1148
    //   1133: aload_0
    //   1134: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1137: aload 9
    //   1139: getfield 1662	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flag_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1142: invokevirtual 1574	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1145: putfield 1724	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_p_of_type_Int	I
    //   1148: aload_0
    //   1149: getfield 964	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1152: ifnull +31 -> 1183
    //   1155: aload_0
    //   1156: getfield 964	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1159: aload_0
    //   1160: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1163: getfield 1716	com/tencent/mobileqq/troopinfo/TroopInfoData:l	Ljava/lang/String;
    //   1166: putfield 1727	com/tencent/mobileqq/data/TroopInfo:fingertroopmemo	Ljava/lang/String;
    //   1169: aload_0
    //   1170: getfield 964	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1173: aload_0
    //   1174: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1177: getfield 997	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   1180: putfield 1730	com/tencent/mobileqq/data/TroopInfo:mRichFingerMemo	Ljava/lang/String;
    //   1183: aload 9
    //   1185: getfield 1733	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_max_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1188: invokevirtual 1722	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1191: ifeq +93 -> 1284
    //   1194: aload 9
    //   1196: getfield 1733	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_max_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1199: invokevirtual 1574	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1202: ifle +82 -> 1284
    //   1205: aload 9
    //   1207: getfield 1675	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1210: invokevirtual 1722	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1213: ifeq +71 -> 1284
    //   1216: aload 9
    //   1218: getfield 1675	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1221: invokevirtual 1574	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1224: ifle +60 -> 1284
    //   1227: aload_0
    //   1228: getfield 964	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1231: ifnull +33 -> 1264
    //   1234: aload_0
    //   1235: getfield 964	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1238: aload 9
    //   1240: getfield 1733	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_max_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1243: invokevirtual 1574	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1246: putfield 1736	com/tencent/mobileqq/data/TroopInfo:wMemberMax	I
    //   1249: aload_0
    //   1250: getfield 964	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1253: aload 9
    //   1255: getfield 1675	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1258: invokevirtual 1574	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1261: putfield 1739	com/tencent/mobileqq/data/TroopInfo:wMemberNum	I
    //   1264: aload_0
    //   1265: aload 9
    //   1267: getfield 1675	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1270: invokevirtual 1574	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1273: aload 9
    //   1275: getfield 1733	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_max_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1278: invokevirtual 1574	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1281: invokevirtual 1740	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(II)V
    //   1284: aload_0
    //   1285: getfield 964	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1288: ifnull +19 -> 1307
    //   1291: aload_0
    //   1292: getfield 964	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1295: aload 9
    //   1297: getfield 1662	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flag_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1300: invokevirtual 1574	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1303: i2l
    //   1304: putfield 1743	com/tencent/mobileqq/data/TroopInfo:dwGroupFlagExt	J
    //   1307: aload_0
    //   1308: invokevirtual 1281	com/tencent/mobileqq/activity/ChatSettingForTroop:t	()V
    //   1311: aload 9
    //   1313: astore 8
    //   1315: aload 9
    //   1317: getfield 1746	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint64_group_owner	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1320: invokevirtual 1747	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   1323: ifeq -1181 -> 142
    //   1326: aload_0
    //   1327: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1330: new 314	java/lang/StringBuilder
    //   1333: dup
    //   1334: invokespecial 315	java/lang/StringBuilder:<init>	()V
    //   1337: ldc_w 594
    //   1340: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1343: aload 9
    //   1345: getfield 1746	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint64_group_owner	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1348: invokevirtual 1623	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1351: invokevirtual 592	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1354: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1357: putfield 1749	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_p_of_type_JavaLangString	Ljava/lang/String;
    //   1360: aload 9
    //   1362: astore 8
    //   1364: goto -1222 -> 142
    //   1367: aload_0
    //   1368: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1371: ldc_w 594
    //   1374: putfield 1716	com/tencent/mobileqq/troopinfo/TroopInfoData:l	Ljava/lang/String;
    //   1377: goto -372 -> 1005
    //   1380: aload_0
    //   1381: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1384: ldc_w 594
    //   1387: putfield 997	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   1390: goto -356 -> 1034
    //   1393: aload_0
    //   1394: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1397: aload_0
    //   1398: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1401: getfield 997	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   1404: invokestatic 1753	com/tencent/biz/common/util/HttpUtil:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1407: putfield 997	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   1410: aload_0
    //   1411: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1414: aload_0
    //   1415: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1418: getfield 997	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   1421: invokestatic 1755	com/tencent/biz/common/util/HttpUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1424: putfield 997	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   1427: goto -366 -> 1061
    //   1430: aload 8
    //   1432: bipush 8
    //   1434: invokevirtual 1224	android/view/View:setVisibility	(I)V
    //   1437: goto -319 -> 1118
    //   1440: astore 8
    //   1442: invokestatic 684	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1445: ifeq -1121 -> 324
    //   1448: ldc_w 1585
    //   1451: iconst_2
    //   1452: aload 8
    //   1454: invokevirtual 737	java/lang/Exception:toString	()Ljava/lang/String;
    //   1457: invokestatic 739	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1460: goto -1136 -> 324
    //   1463: iload_2
    //   1464: iconst_1
    //   1465: iadd
    //   1466: istore_2
    //   1467: goto -1012 -> 455
    //   1470: astore_1
    //   1471: aload_1
    //   1472: invokevirtual 1511	java/lang/Exception:printStackTrace	()V
    //   1475: return
    //   1476: iconst_0
    //   1477: istore_3
    //   1478: goto -1368 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1481	0	this	ChatSettingForTroop
    //   0	1481	1	paramBatchResponse	KQQ.BatchResponse
    //   106	1361	2	i1	int
    //   115	1363	3	i2	int
    //   178	776	4	i3	int
    //   925	43	5	i4	int
    //   411	68	6	l1	long
    //   77	137	8	localObject1	Object
    //   218	13	8	localException1	Exception
    //   273	1158	8	localObject2	Object
    //   1440	13	8	localException2	Exception
    //   68	1293	9	localObject3	Object
    //   19	330	10	localOIDBSSOPkg	tencent.im.oidb.oidb_sso.OIDBSSOPkg
    //   98	62	11	localList	List
    //   131	809	12	localObject4	Object
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
    //   879	944	218	java/lang/Exception
    //   949	958	218	java/lang/Exception
    //   963	972	218	java/lang/Exception
    //   972	1005	218	java/lang/Exception
    //   1005	1034	218	java/lang/Exception
    //   1034	1061	218	java/lang/Exception
    //   1061	1070	218	java/lang/Exception
    //   1075	1118	218	java/lang/Exception
    //   1118	1148	218	java/lang/Exception
    //   1148	1183	218	java/lang/Exception
    //   1183	1264	218	java/lang/Exception
    //   1264	1284	218	java/lang/Exception
    //   1284	1307	218	java/lang/Exception
    //   1307	1311	218	java/lang/Exception
    //   1315	1360	218	java/lang/Exception
    //   1367	1377	218	java/lang/Exception
    //   1380	1390	218	java/lang/Exception
    //   1393	1427	218	java/lang/Exception
    //   1430	1437	218	java/lang/Exception
    //   275	324	1440	java/lang/Exception
    //   360	413	1470	java/lang/Exception
    //   421	430	1470	java/lang/Exception
    //   435	453	1470	java/lang/Exception
    //   460	473	1470	java/lang/Exception
    //   478	509	1470	java/lang/Exception
    //   517	567	1470	java/lang/Exception
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297731));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297732));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297733));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297734));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297735));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298528));
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
    View localView = paramView.findViewById(2131297867);
    paramView = (TextView)paramView.findViewById(2131297868);
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
    TextView localTextView = (TextView)paramView.findViewById(2131297867);
    if (paramInt > 0)
    {
      localTextView.setVisibility(0);
      paramView = Integer.toString(paramInt);
      if (paramInt > 99) {
        paramView = "99+";
      }
      localTextView.setText(paramView);
      localTextView.setBackgroundResource(2130838440);
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      return;
    }
    if (paramBoolean)
    {
      localTextView.setVisibility(0);
      localTextView.setText("");
      localTextView.setBackgroundResource(0);
      localTextView.setCompoundDrawablesWithIntrinsicBounds(2130839336, 0, 0, 0);
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
        localObject = (TextView)((View)localObject).findViewById(2131298520);
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
    new afe(this, paramString1, paramString2).start();
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
    int i1 = getResources().getDimensionPixelOffset(2131493020);
    int i3 = getResources().getDimensionPixelOffset(2131493021);
    int i2 = getResources().getDimensionPixelOffset(2131493026);
    i3 = this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels - i1 - i3 - Utils.a(this, 10.0F) * 2;
    int i4 = getResources().getDimensionPixelOffset(2131493025);
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
        localImageView.setBackgroundResource(2130838374);
        localImageView.setContentDescription(super.getString(2131362656));
        localImageView.setOnClickListener(new afr(this));
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
        paramList = (LinearLayout)paramList.findViewById(2131298527);
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
      localView1.setBackgroundResource(2130837754);
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
      this.jdField_a_of_type_ArrayOfAndroidViewView[3].setBackgroundResource(2130837754);
      return;
      localView2.setVisibility(8);
    }
    label132:
    if ((localView1.isShown()) || (localView1.getVisibility() == 0)) {
      localView1.setVisibility(8);
    }
    this.jdField_a_of_type_ArrayOfAndroidViewView[3].setBackgroundResource(2130837754);
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
    paramView = (TextView)paramView.findViewById(2131296953);
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
    ImageView localImageView = (ImageView)paramView.findViewById(2131297867);
    paramView = (TextView)paramView.findViewById(2131297868);
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
      return getString(2131363476);
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
    ThreadManager.a(new afq(this));
    if (this.jdField_i_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837906);
      this.jdField_i_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      this.jdField_i_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131493043));
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, getString(2131362790), 1000);
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
    //   11: ldc_w 1928
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
    //   37: invokevirtual 1932	com/tencent/mobileqq/activity/ChatSettingForTroop:getIntent	()Landroid/content/Intent;
    //   40: invokevirtual 1452	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   43: astore 4
    //   45: aload_0
    //   46: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   49: aload 4
    //   51: ldc_w 892
    //   54: invokevirtual 1934	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   57: putfield 290	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   60: aload_0
    //   61: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   64: aload 4
    //   66: ldc_w 894
    //   69: invokevirtual 1934	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   72: putfield 896	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   75: aload_0
    //   76: aload 4
    //   78: ldc_w 733
    //   81: iconst_1
    //   82: invokevirtual 1937	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   85: putfield 203	com/tencent/mobileqq/activity/ChatSettingForTroop:al	I
    //   88: aload_0
    //   89: aload 4
    //   91: ldc_w 1939
    //   94: invokevirtual 1941	android/os/Bundle:getInt	(Ljava/lang/String;)I
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
    //   123: ldc_w 1943
    //   126: invokevirtual 1941	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   129: putfield 338	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Int	I
    //   132: aload_0
    //   133: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   136: aload 4
    //   138: ldc_w 1945
    //   141: invokevirtual 1941	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   144: putfield 1947	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_b_of_type_Int	I
    //   147: aload_0
    //   148: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   151: aload 4
    //   153: ldc_w 1949
    //   156: invokevirtual 1934	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   159: putfield 373	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   162: aload_0
    //   163: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   166: aload 4
    //   168: ldc_w 1951
    //   171: invokevirtual 1955	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   174: putfield 275	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Boolean	Z
    //   177: aload_0
    //   178: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   181: aload 4
    //   183: ldc_w 1957
    //   186: invokevirtual 1961	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   189: putfield 993	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_b_of_type_Short	S
    //   192: aload_0
    //   193: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   196: aload 4
    //   198: ldc_w 1963
    //   201: invokevirtual 1934	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   204: putfield 364	com/tencent/mobileqq/troopinfo/TroopInfoData:f	Ljava/lang/String;
    //   207: aload_0
    //   208: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   211: aload 4
    //   213: ldc_w 1965
    //   216: invokevirtual 1934	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   219: putfield 1749	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_p_of_type_JavaLangString	Ljava/lang/String;
    //   222: aload_0
    //   223: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   226: aload 4
    //   228: ldc_w 1967
    //   231: invokevirtual 1970	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   234: putfield 991	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Long	J
    //   237: aload_0
    //   238: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   241: aload 4
    //   243: ldc_w 1972
    //   246: invokevirtual 1934	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   249: putfield 1277	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   252: aload_0
    //   253: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   256: aload 4
    //   258: ldc_w 1974
    //   261: invokevirtual 1934	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   264: putfield 997	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   267: aload_0
    //   268: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   271: aload 4
    //   273: ldc_w 1976
    //   276: invokevirtual 1980	android/os/Bundle:getByte	(Ljava/lang/String;)B
    //   279: i2s
    //   280: putfield 366	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Short	S
    //   283: aload_0
    //   284: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   287: aload_0
    //   288: aload_0
    //   289: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   292: getfield 290	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   295: invokestatic 1985	com/tencent/mobileqq/util/TroopSystemMsgUtil:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   298: putfield 381	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_r_of_type_JavaLangString	Ljava/lang/String;
    //   301: aload_0
    //   302: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   305: aload 4
    //   307: ldc_w 1987
    //   310: invokevirtual 1941	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   313: invokestatic 1989	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   316: putfield 1336	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   319: aload_0
    //   320: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   323: aload 4
    //   325: ldc_w 1991
    //   328: invokevirtual 1941	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   331: putfield 1078	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_n_of_type_Int	I
    //   334: aload_0
    //   335: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   338: aload_0
    //   339: aload_0
    //   340: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   343: getfield 290	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   346: invokestatic 1993	com/tencent/mobileqq/util/TroopSystemMsgUtil:c	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   349: putfield 383	com/tencent/mobileqq/troopinfo/TroopInfoData:s	Ljava/lang/String;
    //   352: aload_0
    //   353: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   356: aload 4
    //   358: ldc_w 1995
    //   361: invokevirtual 1970	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   364: putfield 1664	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_b_of_type_Long	J
    //   367: aload_0
    //   368: getfield 193	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   371: aload 4
    //   373: ldc_w 1997
    //   376: invokevirtual 1970	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   379: putfield 1669	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_Long	J
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
    //   453: invokevirtual 2000	com/tencent/mobileqq/troopinfo/TroopInfoData:a	(Lcom/tencent/mobileqq/data/TroopInfo;Landroid/content/res/Resources;Ljava/lang/String;)V
    //   456: aload_0
    //   457: aload 4
    //   459: ldc 108
    //   461: iconst_m1
    //   462: invokevirtual 1937	android/os/Bundle:getInt	(Ljava/lang/String;I)I
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
    //   495: invokestatic 2005	com/tencent/biz/common/report/BnrReport:a	(Lcom/tencent/common/app/AppInterface;I)V
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
      localObject = (TextView)((View)localObject).findViewById(2131296953);
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
        for (paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m;; paramIntent = getResources().getString(2131362830))
        {
          a(15, paramIntent, false);
          e(32);
          return;
        }
      }
      b(2131362790, 1);
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
      TextView localTextView = (TextView)((View)localObject).findViewById(2131297863);
      localObject = (ImageView)((View)localObject).findViewById(2131297865);
      localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      ((ImageView)localObject).setImageDrawable(a());
      ((ImageView)localObject).setContentDescription(String.format(getResources().getString(2131363040), new Object[] { Integer.valueOf(i1) }));
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
    ThreadManager.a(new aet(this));
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
    new afb(this).start();
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
        localTextView = (TextView)localView.findViewById(2131296953);
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
        QQToast.a(this, getString(2131363535), 1).b(getTitleBarHeight());
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
    localView = localView.findViewById(2131297866);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString))
    {
      localView.setVisibility(8);
      return;
    }
    localView.setVisibility(0);
    ((TextView)localView.findViewById(2131296932)).setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString);
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
    new afg(this).start();
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
                  QQToast.a(this, 2131362567, 1).b(getTitleBarHeight());
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
                  ThreadManager.b(new aeu(this));
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
                  QQToast.a(this, 2131362567, 1).b(getTitleBarHeight());
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
              b(2131362916, 0);
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
      a(12, 900, 2131363033, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m, true, 1, true);
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
        ((QQCustomMenu)localObject).a(2131298937, getString(2131363564));
        this.jdField_a_of_type_ComTencentWidgetMenuPopupDialog = MenuPopupDialog.a(paramView, getString(2131363277), (QQCustomMenu)localObject, new aev(this), new aew(this));
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
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131363558);
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
      TextView localTextView = (TextView)((View)localObject1).findViewById(2131297602);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f;
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = " ";
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Long & 0x800) != 0L)
      {
        localObject1 = null;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Long == 2L) {
          localObject1 = getResources().getDrawable(2130838177);
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
            localObject1 = getResources().getDrawable(2130838238);
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
        ImageView localImageView = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[12].findViewById(2131297600);
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
      localMalformedURLException.setURLDrawableListener(new afn(this, localImageView));
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
    TextView localTextView = (TextView)findViewById(2131297864);
    localTextView.setVisibility(0);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == 1)
    {
      localTextView.setText(2131362306);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == 0)
    {
      localTextView.setText(2131362307);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == 2)
    {
      localTextView.setText(2131362308);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == 3)
    {
      localTextView.setText(2131362308);
      return;
    }
    localTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop
 * JD-Core Version:    0.7.0.1
 */