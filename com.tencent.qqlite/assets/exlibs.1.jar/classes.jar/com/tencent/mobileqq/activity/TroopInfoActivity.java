package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import bmv;
import bmw;
import bmx;
import bmy;
import bna;
import bnb;
import bnc;
import bnd;
import bnf;
import bng;
import bnh;
import bni;
import bnj;
import bnk;
import bnl;
import com.tencent.biz.common.report.BnrReport;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.mobileqq.troop.widget.AvatarWallView;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.TroopSystemMsgUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.GridView;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;
import mqq.manager.WtloginManager;
import mqq.observer.AccountObserver;
import mqq.util.WeakReference;
import oicq.wlogin_sdk.request.Ticket;

public class TroopInfoActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final int A = 16;
  public static final int B = 3004;
  public static final int C = 3005;
  public static final int D = 3006;
  public static final int E = 3022;
  public static final int F = 3023;
  public static final int G = 17;
  public static final int H = 3017;
  public static final int I = 6;
  public static final int J = 5;
  public static final int K = 7;
  public static final int L = 11;
  public static final int M = 8;
  public static final int N = 14;
  public static final int O = 15;
  public static final int P = 16;
  protected static final int Q = 0;
  protected static final int R = 1;
  protected static final int S = 2;
  protected static final int T = 3;
  protected static final int U = 4;
  protected static final int V = 5;
  protected static final int W = 6;
  protected static final int X = 7;
  protected static final int Y = 9;
  protected static final int Z = 10;
  public static final int a = 1;
  public static final String a = "Q.troopinfo";
  public static final int aA = 25;
  public static final int aB = 24;
  public static final int aC = 26;
  public static final int aD = 13;
  public static final int aE = 15;
  public static final int aF = 1;
  public static final int aG = 2;
  public static final int aH = 0;
  public static final int aI = 1;
  public static final int aJ = 2;
  public static final int aK = 1;
  public static final int aL = 0;
  public static final int aM = 2;
  public static final int aN = 3;
  protected static final int aP = 1;
  protected static final int aQ = 2;
  protected static final int aR = 3;
  protected static final int aS = 4;
  protected static final int aT = 5;
  protected static final int aU = 7;
  protected static final int aV = 8;
  protected static final int aa = 10;
  protected static final int ab = 11;
  protected static final int ac = 12;
  protected static final int ad = 13;
  protected static final int ae = 14;
  public static final int af = 1;
  public static final int ag = 2;
  public static final int ah = 3;
  public static final int ai = 4;
  public static final int aj = 5;
  public static final int ak = 6;
  public static final int al = 7;
  public static final int am = 8;
  public static final int an = 9;
  public static final int ao = 10;
  public static final int ap = 11;
  public static final int aq = 12;
  public static final int ar = 14;
  public static final int as = 16;
  public static final int at = 17;
  public static final int au = 18;
  public static final int av = 19;
  public static final int aw = 21;
  public static final int ax = 22;
  public static final int ay = 23;
  public static final int az = 24;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 8;
  public static final int h = 9;
  public static final int i = 10;
  public static final int j = 11;
  public static final int k = 12;
  public static final int l = 13;
  public static final int m = 14;
  public static final int n = 15;
  public static final int o = 16;
  public static final int p = 17;
  public static final int q = 18;
  public static final int r = 19;
  public static final int s = 20;
  public static final int t = 21;
  public static final int u = 22;
  public static final int v = 23;
  public static final int w = 0;
  public static final int x = 116;
  public static final int y = 3001;
  public static final int z = 3002;
  public long a;
  public Dialog a;
  public Handler a;
  protected View a;
  protected LinearLayout a;
  public TextView a;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new bmy(this);
  public FriendListHandler a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new bmx(this);
  public TroopHandler a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new bna(this);
  public TroopInfo a;
  public AvatarWallAdapter a;
  public TroopInfoData a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  public ArrayList a;
  public List a;
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new bni(this);
  protected boolean a;
  protected View[] a;
  public String[] a;
  public int aO = -1;
  public long b;
  public View b;
  protected String b;
  public boolean b;
  public boolean c;
  public boolean d = false;
  protected boolean e = false;
  public boolean f = false;
  public boolean g = false;
  
  public TroopInfoActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidOsHandler = new bmw(this);
  }
  
  public static Bundle a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte paramByte, long paramLong1, short paramShort, String paramString6, String paramString7, boolean paramBoolean, String paramString8, long paramLong2, long paramLong3, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troop_uin", paramString1);
    localBundle.putInt("troop_info_from", paramInt1);
    localBundle.putInt("troop_info_from_ex", paramInt2);
    localBundle.putString("troop_code", paramString2);
    localBundle.putString("troop_info_name", paramString3);
    localBundle.putString("troop_info_owner", paramString4);
    localBundle.putString("troop_info_admi", paramString5);
    localBundle.putByte("troop_info_opt", paramByte);
    localBundle.putLong("troop_info_classext", paramLong1);
    localBundle.putShort("troop_info_faceid", paramShort);
    localBundle.putString("troop_info_fingermemo", paramString6);
    localBundle.putString("troop_info_loca", paramString7);
    localBundle.putBoolean("troop_info_is_member", paramBoolean);
    localBundle.putString("param_return_addr", paramString8);
    localBundle.putLong("TROOP_INFO_FLAG_EXT", paramLong2);
    localBundle.putLong("TROOP_INFO_AUTH_TYPE", paramLong3);
    return localBundle;
  }
  
  public static Bundle a(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troop_uin", paramString);
    localBundle.putInt("troop_info_from", paramInt);
    return localBundle;
  }
  
  public static Bundle a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troop_uin", paramString1);
    localBundle.putInt("troop_info_from", paramInt1);
    if (!TextUtils.isEmpty(paramString2)) {
      localBundle.putString("troop_info_loca", paramString2);
    }
    localBundle.putInt("troop_info_lat", paramInt2);
    localBundle.putInt("troop_info_lon", paramInt3);
    return localBundle;
  }
  
  public static String a(Context paramContext, TroopInfoData paramTroopInfoData)
  {
    if (paramTroopInfoData == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    String str = Long.toString(paramTroopInfoData.jdField_a_of_type_Long);
    GroupCatalogBean localGroupCatalogBean = GroupCatalogTool.a(paramContext).a(paramContext, str);
    str = "";
    if (!TextUtils.isEmpty(paramTroopInfoData.j)) {
      paramContext = paramTroopInfoData.j;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramContext)) {
        localStringBuffer.append(paramContext + " | ");
      }
      if (localStringBuffer.length() > 0) {
        localStringBuffer.delete(localStringBuffer.length() - " | ".length(), localStringBuffer.length());
      }
      return localStringBuffer.toString();
      paramContext = str;
      if (localGroupCatalogBean != null)
      {
        paramContext = str;
        if (!TextUtils.isEmpty(localGroupCatalogBean.jdField_a_of_type_JavaLangString))
        {
          paramContext = str;
          if (!localGroupCatalogBean.jdField_a_of_type_JavaLangString.equals("其他")) {
            if (localGroupCatalogBean.jdField_a_of_type_Int == 1)
            {
              paramContext = str;
              if (localGroupCatalogBean.jdField_a_of_type_JavaUtilArrayList == null) {
                paramContext = localGroupCatalogBean.jdField_a_of_type_JavaLangString;
              }
            }
            else
            {
              paramContext = localGroupCatalogBean.jdField_a_of_type_JavaLangString;
            }
          }
        }
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
          QLog.d("Q.troopinfo", 2, "local skey available");
        }
        return new String(paramAppInterface._sig);
      }
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean1, int paramInt4, boolean paramBoolean2)
  {
    Intent localIntent = new Intent(this, EditActivity.class);
    localIntent.putExtra("title", paramInt3);
    localIntent.putExtra("limit", paramInt2);
    localIntent.putExtra("current", paramString);
    localIntent.putExtra("canPostNull", paramBoolean1);
    localIntent.putExtra("multiLine", paramBoolean2);
    localIntent.putExtra("support_emotion", paramInt4);
    startActivityForResult(localIntent, paramInt1);
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if (paramActivity != null) {}
    try
    {
      Intent localIntent = new Intent(paramActivity, TroopInfoActivity.class);
      localIntent.putExtras(paramBundle);
      paramActivity.startActivityForResult(localIntent, paramInt);
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopinfo", 2, paramActivity.toString());
    }
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = new Intent(paramContext, TroopInfoActivity.class);
      localIntent.putExtras(paramBundle);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopinfo", 2, paramContext.toString());
    }
  }
  
  private void e(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null)
    {
      localObject = (FriendManager)this.app.getManager(8);
      if (localObject != null) {
        break label121;
      }
    }
    label121:
    for (Object localObject = null;; localObject = ((FriendManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        if ((paramInt & 0x4) > 0) {
          b(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname);
        }
        if ((paramInt & 0x2) > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt;
          x();
        }
        if ((paramInt & 0x20) > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.fingertroopmemo;
          a(6, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.fingertroopmemo, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e());
        }
      }
      return;
    }
  }
  
  private void f(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "saveTroopInfo| nModifyFlag = " + paramInt);
    }
    if ((paramInt & 0x3F) > 0) {}
    try
    {
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c);
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(l1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Short, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m, paramInt);
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(paramInt));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopinfo", 2, localException.toString());
    }
  }
  
  private void t()
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
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f);
    startActivity(localIntent);
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short != 3)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_JavaLangString))
      {
        startActivity(AddFriendLogicActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.s, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_JavaLangString, b_()));
        return;
      }
      startActivityForResult(AddFriendLogicActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.s, null, b_()), 8);
      return;
    }
    a(2131363379, 1);
  }
  
  private void v()
  {
    Object localObject = this.app.a();
    int i1;
    if (String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p).equals(localObject)) {
      i1 = 0;
    }
    for (;;)
    {
      localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p, i1);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p)) {
        ((ProfileActivity.AllInOne)localObject).h = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.q;
      }
      if (i1 == 21)
      {
        ((ProfileActivity.AllInOne)localObject).c = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c;
        ((ProfileActivity.AllInOne)localObject).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_JavaLangString;
      }
      ProfileActivity.b(getActivity(), (ProfileActivity.AllInOne)localObject);
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p))
      {
        if (((FriendManager)this.app.getManager(8)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p))
        {
          i1 = 1;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean)
        {
          i1 = 21;
          continue;
        }
      }
      i1 = 19;
    }
  }
  
  private void x()
  {
    new bnb(this).start();
  }
  
  private void y()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "updateTroopOwnerName");
    }
    new bnc(this).start();
  }
  
  public void a(int paramInt)
  {
    String str = getString(paramInt);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(str);
    localQQCustomDialog.setMessage(null);
    localQQCustomDialog.setPositiveButton(getString(2131363890), new bnf(this, localQQCustomDialog));
    localQQCustomDialog.setPositiveButtonContentDescription(getString(2131363890));
    localQQCustomDialog.setNegativeButton(getString(2131363889), new bng(this));
    localQQCustomDialog.setNegativeButtonContentDescription(getString(2131363889));
    localQQCustomDialog.show();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString1, String paramString2, boolean paramBoolean)
  {
    label48:
    TextView localTextView2;
    View localView;
    if (paramBoolean)
    {
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this);
      switch (paramInt2)
      {
      default: 
        TextView localTextView1 = (TextView)paramView.findViewById(2131296934);
        localTextView2 = (TextView)paramView.findViewById(2131296953);
        localView = paramView.findViewById(2131297748);
        paramView = paramString1;
        if (paramString1 == null) {
          paramView = "";
        }
        localTextView1.setText(paramView);
        if (6 == paramInt1)
        {
          localTextView2.setEditableFactory(QQTextBuilder.a);
          localTextView2.setMovementMethod(LinkMovementMethod.getInstance());
          if (TextUtils.isEmpty(paramString2))
          {
            localTextView2.setVisibility(8);
            label136:
            if (!paramBoolean) {
              break label238;
            }
          }
        }
        break;
      }
    }
    label238:
    for (paramInt1 = 0;; paramInt1 = 8)
    {
      localView.setVisibility(paramInt1);
      return;
      paramView.setTag(null);
      paramView.setOnClickListener(null);
      break;
      paramView.setBackgroundResource(2130837942);
      break label48;
      paramView.setBackgroundResource(2130837945);
      break label48;
      paramView.setBackgroundResource(2130837945);
      break label48;
      paramView.setBackgroundResource(2130837944);
      break label48;
      localTextView2.setVisibility(0);
      localTextView2.setText(new QQText(paramString2, 11));
      break label136;
      localTextView2.setText(paramString2);
      break label136;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, String[] paramArrayOfString, boolean paramBoolean, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "initClrTextItemView(), tag = " + paramInt1 + ", info = " + paramArrayOfString + ", bShowArrow = " + paramBoolean);
    }
    TextView localTextView = (TextView)paramView.findViewById(2131296934);
    paramArrayOfString = paramString;
    if (paramString == null) {
      paramArrayOfString = "";
    }
    localTextView.setText(paramArrayOfString);
    paramString = paramView.findViewById(2131297748);
    if (paramBoolean)
    {
      paramInt3 = 0;
      label104:
      paramString.setVisibility(paramInt3);
      if (!paramBoolean) {
        break label168;
      }
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this);
    }
    for (;;)
    {
      switch (paramInt2)
      {
      default: 
        return;
        paramInt3 = 8;
        break label104;
        label168:
        paramView.setTag(null);
        paramView.setOnClickListener(null);
      }
    }
    paramView.setBackgroundResource(2130837942);
    return;
    paramView.setBackgroundResource(2130837945);
    return;
    paramView.setBackgroundResource(2130837945);
    return;
    paramView.setBackgroundResource(2130837944);
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
          a("Grp_moredata", "del_head", "");
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, 2, localArrayList2);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(localArrayList1);
      }
      paramInt = paramIntent.getIntExtra("default_avator_index", -1);
      if (paramInt != -1)
      {
        if ((paramInt > 0) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.getCount())) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.c(paramInt);
        }
        QQToast.a(this, getString(2131363546), 1).b(getTitleBarHeight());
      }
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "updateDefaultItemView(), tag = " + paramInt + ", info = " + paramString + ", bShowArrow = " + paramBoolean);
    }
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ArrayOfAndroidViewView.length)) {}
    for (View localView1 = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt];; localView1 = null)
    {
      TextView localTextView;
      View localView2;
      if (localView1 != null)
      {
        localTextView = (TextView)localView1.findViewById(2131296953);
        localView2 = localView1.findViewById(2131297748);
        if (paramInt != 6) {
          break label204;
        }
        if (!TextUtils.isEmpty(paramString)) {
          break label169;
        }
        localTextView.setVisibility(8);
        if (!paramString.equals(getString(2131362837))) {
          break label193;
        }
        localTextView.setTextColor(-3355444);
      }
      for (;;)
      {
        if (!paramBoolean) {
          break label213;
        }
        localView1.setTag(Integer.valueOf(paramInt));
        localView1.setOnClickListener(this);
        localView2.setVisibility(0);
        return;
        label169:
        localTextView.setVisibility(0);
        localTextView.setText(new QQText(paramString, 11));
        break;
        label193:
        localTextView.setTextColor(-8355712);
        continue;
        label204:
        localTextView.setText(paramString);
      }
      label213:
      localView1.setTag(null);
      localView1.setOnClickListener(null);
      localView2.setVisibility(8);
      return;
    }
  }
  
  protected void a(int paramInt1, ArrayList paramArrayList, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "updateClrTextItemView(), tag = " + paramInt1 + ", info = " + paramArrayList + ", bShowArrow = " + paramBoolean1);
    }
    if ((paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_ArrayOfAndroidViewView.length)) {}
    for (View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt1];; localView = null)
    {
      LinearLayout localLinearLayout;
      if (localView != null)
      {
        localLinearLayout = (LinearLayout)localView.findViewById(2131298546);
        localLinearLayout.removeAllViews();
        if (paramArrayList != null) {}
      }
      else
      {
        return;
      }
      int i1 = 0;
      if ((i1 < paramArrayList.size()) && (i1 < 3))
      {
        TextView localTextView = new TextView(this);
        localTextView.setId(2131296409);
        if (paramInt2 == 1) {
          localTextView.setBackgroundResource(2130838452);
        }
        for (;;)
        {
          localTextView.setTextSize(2, 15.0F);
          if (paramBoolean2) {
            localTextView.setMaxWidth(AIOUtils.a(77.0F, getResources()));
          }
          localTextView.setSingleLine();
          localTextView.setTextColor(-1);
          localTextView.setPadding(AIOUtils.a(6.0F, getResources()), AIOUtils.a(2.0F, getResources()), AIOUtils.a(8.0F, getResources()), AIOUtils.a(2.0F, getResources()));
          localTextView.setGravity(17);
          localTextView.setText((CharSequence)paramArrayList.get(i1));
          localTextView.setEllipsize(TextUtils.TruncateAt.END);
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
          localLayoutParams.leftMargin = AIOUtils.a(5.0F, getResources());
          localLinearLayout.addView(localTextView, localLayoutParams);
          i1 += 1;
          break;
          if (paramInt2 == 2) {
            localTextView.setBackgroundResource(2130838451);
          } else {
            localTextView.setBackgroundResource(2130838451);
          }
        }
      }
      paramArrayList = localView.findViewById(2131297748);
      if (paramBoolean1)
      {
        localView.setTag(Integer.valueOf(paramInt1));
        localView.setOnClickListener(this);
        paramArrayList.setVisibility(0);
        return;
      }
      localView.setTag(null);
      localView.setOnClickListener(null);
      paramArrayList.setVisibility(8);
      return;
    }
  }
  
  protected void a(String paramString)
  {
    k();
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    localQQProgressDialog.a(paramString);
    localQQProgressDialog.setCancelable(false);
    localQQProgressDialog.setOnDismissListener(new bnk(this));
    this.jdField_a_of_type_AndroidAppDialog = localQQProgressDialog;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void a(String paramString, CharSequence paramCharSequence)
  {
    paramCharSequence = new ArrayList();
    paramCharSequence.add(paramString);
    a(1, paramCharSequence, true, 1, false);
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    ReportController.b(this.app, "P_CliOper", "Grp_set", "", paramString1, paramString2, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, paramString3, "", "");
  }
  
  public void b(int paramInt)
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298543);
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298544);
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    case 10: 
      localImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.j.setVisibility(0);
      this.j.setEnabled(true);
      this.j.setText(2131363885);
      this.j.setTag(Integer.valueOf(10));
      return;
    case 11: 
      localImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.j.setVisibility(0);
      this.j.setEnabled(true);
      this.j.setText(2131363885);
      this.j.setTag(Integer.valueOf(11));
      return;
    }
    localImageView.setVisibility(0);
    localImageView.setImageResource(2130838255);
    localTextView.setText(2131362814);
    this.jdField_a_of_type_AndroidViewView.setTag(Integer.valueOf(12));
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  protected void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f = paramString;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e()) && ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Long & 0x800) == 0L)) {}
    for (boolean bool = true;; bool = false)
    {
      a(3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, bool);
      return;
    }
  }
  
  protected void c()
  {
    Object localObject = ((FriendsManagerImp)this.app.getManager(8)).a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c));
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
            for (localAvatarInfo.c = "SYSTEM_PHOTO";; localAvatarInfo.c = "AVATAR_URL_STR")
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
      ((AvatarWallAdapter.AvatarInfo)localObject).c = "SYSTEM_PHOTO";
      localArrayList.add(localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(localArrayList, 23, 0);
  }
  
  public void c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(getString(2131362307), getString(2131362311));
      b(10);
      return;
    case 0: 
      a(getString(2131362308), getString(2131362312));
      b(10);
      return;
    case 2: 
      a(getString(2131362309), getString(2131362313));
      b(11);
      return;
    }
    a(getString(2131362310), getString(2131362313));
    b(11);
  }
  
  protected boolean c()
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "checkParams");
    }
    try
    {
      Object localObject = getIntent().getExtras();
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c = ((Bundle)localObject).getString("troop_uin");
      if (Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c) > 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int = ((Bundle)localObject).getInt("troop_info_from");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Int = ((Bundle)localObject).getInt("troop_info_from_ex");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_JavaLangString = ((Bundle)localObject).getString("param_return_addr");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean = ((Bundle)localObject).getBoolean("troop_info_is_member");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Short = ((Bundle)localObject).getShort("troop_info_faceid");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f = ((Bundle)localObject).getString("troop_info_name");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p = ((Bundle)localObject).getString("troop_info_owner");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long = ((Bundle)localObject).getLong("troop_info_classext");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k = ((Bundle)localObject).getString("troop_info_loca");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int = ((Bundle)localObject).getInt("troop_info_lat", 0);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int = ((Bundle)localObject).getInt("troop_info_lon", 0);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m = ((Bundle)localObject).getString("troop_info_fingermemo");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short = ((short)((Bundle)localObject).getByte("troop_info_opt"));
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_JavaLangString = TroopSystemMsgUtil.b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.s = TroopSystemMsgUtil.c(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Long = ((Bundle)localObject).getLong("TROOP_INFO_FLAG_EXT");
        localObject = (FriendManager)this.app.getManager(8);
        if (localObject != null)
        {
          localObject = ((FriendManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c);
          if (localObject != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a((TroopInfo)localObject, this.app.a());
            return true;
          }
          if (QLog.isColorLevel()) {
            QLog.e("Q.troopinfo", 2, "can't find troop info of :" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c);
          }
        }
      }
      bool = false;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.i("Q.troopinfo", 2, localException.toString());
        return false;
      }
    }
    return bool;
  }
  
  protected void d()
  {
    long l1 = System.currentTimeMillis();
    View localView = View.inflate(this, 2130903560, null);
    Object localObject1 = (ListView)localView.findViewById(2131298542);
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add("");
    ((ArrayList)localObject2).add("");
    ((ListView)localObject1).setAdapter(new ArrayAdapter(this, 17367046, (List)localObject2));
    localObject1 = (XListView)localView.findViewById(2131296780);
    ((XListView)localObject1).setVerticalScrollBarEnabled(false);
    ((XListView)localObject1).setDivider(null);
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[10];
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
    localObject2 = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    ((XListView)localObject1).setAdapter(new XSimpleListAdapter(this.jdField_a_of_type_AndroidWidgetLinearLayout));
    ((XListView)localObject1).setBackgroundResource(2130837660);
    setContentView(localView);
    localObject2 = getIntent().getExtras().getString("troop_info_title");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = getString(2131363117);
    }
    setTitle((CharSequence)localObject1);
    localObject1 = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
    int i1 = (((DisplayMetrics)localObject1).widthPixels - getResources().getDimensionPixelSize(2131493043)) / 4;
    localObject1 = View.inflate(this, 2130903296, null);
    localObject2 = (AvatarWallView)((View)localObject1).findViewById(2131296990);
    ((AvatarWallView)localObject2).setColumnWidth(i1);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter = new AvatarWallAdapter(new WeakReference(this), this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean, this.jdField_a_of_type_AndroidOsHandler, bool, "Grp_moredata");
    ((AvatarWallView)localObject2).setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter);
    ((AvatarWallView)localObject2).setNumColumns(4);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(i1);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a((GridView)localObject2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    localObject1 = View.inflate(this, 2130903298, null);
    ((View)localObject1).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131296989));
    this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setFocusableInTouchMode(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    if (!bool) {
      ((View)localObject1).setVisibility(8);
    }
    this.jdField_b_of_type_AndroidViewView = ((View)localObject1);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Long & 0x800) != 0L)
    {
      localObject1 = View.inflate(this, 2130903563, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[7] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      a(7, 0, (View)localObject1, getString(2131363047), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.t, false);
      localObject1 = View.inflate(this, 2130903571, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    }
    localObject1 = View.inflate(this, 2130903563, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[3] = localObject1;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e()) && ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Long & 0x800) == 0L))
    {
      bool = true;
      a(3, 1, (View)localObject1, getString(2131363412), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, bool);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e())
      {
        localObject1 = View.inflate(this, 2130903562, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[1] = localObject1;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
        a(1, 2, (View)localObject1, getString(2131362305), null, true, 1);
      }
      localObject1 = View.inflate(this, 2130903563, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[5] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      a(5, 2, (View)localObject1, getString(2131363808), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e());
      o();
      localObject1 = View.inflate(this, 2130903563, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[4] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      a(4, 2, (View)localObject1, getString(2131363099), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e());
      localObject1 = View.inflate(this, 2130903571, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      localObject2 = View.inflate(this, 2130903568, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[6] = localObject2;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m)) {
        break label1052;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m;
      label867:
      a(6, 3, (View)localObject2, getString(2131363043), (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e());
      localObject1 = new LinearLayout.LayoutParams(-1, (int)(60.0F * this.jdField_c_of_type_Float));
      localObject2 = View.inflate(this, 2130903571, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131297530);
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean) {
        break label1076;
      }
      if (!f()) {
        break label1067;
      }
      b(11);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      n();
      this.h.setOnClickListener(new bmv(this));
      this.j.setOnClickListener(new bnd(this));
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "initUI: time = " + (System.currentTimeMillis() - l1));
      }
      return;
      bool = false;
      break;
      label1052:
      localObject1 = getResources().getString(2131362837);
      break label867;
      label1067:
      b(10);
      continue;
      label1076:
      b(12);
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent);
    }
    if (-1 == paramInt2) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      do
      {
        for (;;)
        {
          return;
          if ((paramIntent != null) && (paramIntent.getExtras() != null))
          {
            paramIntent = paramIntent.getExtras();
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k = paramIntent.getString("location");
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int = paramIntent.getInt("lat", 0);
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int = paramIntent.getInt("lon", 0);
            o();
            return;
            if ((paramIntent != null) && (paramIntent.getExtras() != null))
            {
              paramIntent = paramIntent.getExtras();
              if (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k, paramIntent.getString("location"))) {
                m();
              }
              this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.v = paramIntent.getString("locationOriginal");
              this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k = paramIntent.getString("location");
              o();
              return;
              paramIntent = paramIntent.getStringExtra("result");
              if (!TextUtils.equals(paramIntent, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m))
              {
                m();
                this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m = paramIntent;
                if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m)) {}
                for (paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m;; paramIntent = getResources().getString(2131362837))
                {
                  a(6, paramIntent, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e());
                  return;
                }
                paramIntent = paramIntent.getStringExtra("result");
                if (!Utils.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f))
                {
                  m();
                  b(paramIntent);
                  return;
                  long l2 = 9223372036854775807L;
                  try
                  {
                    l1 = Long.parseLong(paramIntent.getStringExtra("id"));
                    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long != l1) && (l1 != 9223372036854775807L))
                    {
                      m();
                      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long = l1;
                      x();
                      return;
                    }
                  }
                  catch (Exception paramIntent)
                  {
                    for (;;)
                    {
                      long l1 = l2;
                      if (QLog.isColorLevel())
                      {
                        QLog.i("Q.troopinfo", 2, paramIntent.toString());
                        l1 = l2;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int != 6) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int != 15) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int != 10) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int != 11) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int != 19));
      setResult(-1);
      finish();
      return;
      a(paramInt2, paramIntent);
      return;
    } while (AvatarWallAdapter.jdField_a_of_type_AndroidNetUri == null);
    paramIntent = ImageUtil.c(this, AvatarWallAdapter.jdField_a_of_type_AndroidNetUri);
    paramInt1 = ProfileCardUtil.a(this);
    PhotoUtils.a(new Intent(), this, TroopInfoActivity.class.getName(), paramInt1, paramInt1, 640, 640, paramIntent, ProfileCardUtil.b());
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {}
    for (long l1 = System.currentTimeMillis();; l1 = 0L)
    {
      this.g = getIntent().getExtras().getBoolean("returnMsgList", false);
      if (!c())
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopinfo", 2, "onCreate, illegal param, troopuin = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c);
        }
        finish();
        return true;
      }
      d();
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      paramBundle = (BizTroopHandler)this.app.a(19);
      if (paramBundle != null) {
        paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "onCreate(), time = " + (System.currentTimeMillis() - l1));
      }
      BnrReport.a(this.app, 78);
      ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "edit", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, "", "", "");
      return true;
    }
  }
  
  public void doOnDestroy()
  {
    this.jdField_c_of_type_Boolean = true;
    long l1 = 0L;
    if (QLog.isColorLevel()) {
      l1 = System.currentTimeMillis();
    }
    GroupCatalogTool.a(getApplicationContext()).a();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.c();
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "onDestroy(), time = " + (System.currentTimeMillis() - l1));
    }
    super.doOnDestroy();
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
        a("Grp_moredata", "upload_head", "");
      }
    }
    this.e = true;
    paramIntent = (AccountManager)getAppRuntime().getManager(0);
    String str = a(this.app);
    if (str == null)
    {
      paramIntent.updateSKey(this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
    }
    TroopUtils.a(str, this.app.a(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.e)
    {
      this.e = false;
      return;
    }
    TroopAvatarManger.jdField_a_of_type_Int = 0;
    c();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  public void e()
  {
    String str1 = getString(2131363892);
    String str2 = getString(2131363893);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(str2);
    localQQCustomDialog.setMessage(str1);
    localQQCustomDialog.setPositiveButton(getString(2131363889), new bnh(this, localQQCustomDialog));
    localQQCustomDialog.setNegativeButton(null, null);
    localQQCustomDialog.show();
  }
  
  public void f()
  {
    if (!this.f)
    {
      finish();
      return;
    }
    a(2131363891);
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_ArrayOfAndroidViewView[9] == null) {
      return this.d;
    }
    return ((Switch)this.jdField_a_of_type_ArrayOfAndroidViewView[9].findViewById(2131297665)).isChecked();
  }
  
  public void finish()
  {
    k();
    g();
    setResult(-1, getIntent());
    if (this.g) {
      p();
    }
    super.finish();
  }
  
  public void g()
  {
    Intent localIntent = getIntent();
    localIntent.putExtra("location", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k);
    localIntent.putExtra("lat", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int);
    localIntent.putExtra("lon", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int);
    localIntent.putExtra("name", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f);
    localIntent.putExtra("class", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long);
    localIntent.putExtra("intro", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m);
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "init(), isInitialized = " + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.app.a(17));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    new bnj(this).start();
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e())
    {
      ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "add_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, "", "", "");
      TroopLocationModifyActivity.b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k, 16);
    }
  }
  
  public void j()
  {
    if (!this.f)
    {
      finish();
      return;
    }
    ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, "", "", "");
    BizTroopHandler localBizTroopHandler = (BizTroopHandler)this.app.a(19);
    if ((localBizTroopHandler == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null))
    {
      finish();
      return;
    }
    long l4;
    try
    {
      l4 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == -1)
      {
        finish();
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      finish();
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.v;
    int i2 = 0;
    long l2 = 0L;
    String str = "";
    long l1;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      l1 = l2;
    }
    for (int i1 = i2;; i1 = 0)
    {
      try
      {
        localObject = ((String)localObject).split("\\|");
        l1 = l2;
        i1 = i2;
        i2 = Integer.valueOf(localObject[0]).intValue();
        l1 = l2;
        i1 = i2;
        l2 = (Float.valueOf(localObject[1]).floatValue() * 1000000.0F);
        l1 = l2;
        i1 = i2;
        l3 = (Float.valueOf(localObject[2]).floatValue() * 1000000.0F);
        str = localObject[3];
        l1 = l3;
        i1 = i2;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        for (;;)
        {
          long l3 = 0L;
          l2 = l1;
          l1 = l3;
          continue;
          i2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int;
        }
      }
      a(getString(2131363886));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == 2)
      {
        i2 = 3;
        if (i2 == -1) {
          break;
        }
        if ((this.aO != 2) && (this.aO != 3) && (i2 == 3)) {
          ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "set_local", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, "", "", "");
        }
        if (((this.aO == 2) || (this.aO == 3)) && (i2 != 3)) {
          ReportController.b(this.app, "P_CliOper", "Grp_create", "", "edit_data", "un_local", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, "", "", "");
        }
        localBizTroopHandler.a(l4, i2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long, new ArrayList(), i1, l2, l1, str, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m);
        return;
      }
      l1 = 0L;
      l2 = 0L;
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  public void l()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null, 2131624120);
    localActionSheet.a(2131362306);
    this.jdField_a_of_type_ArrayOfJavaLangString = getResources().getStringArray(2131230727);
    localActionSheet.d(this.jdField_a_of_type_ArrayOfJavaLangString[3]);
    int i1 = -1;
    int i2;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == 1)
    {
      i1 = 0;
      i2 = 0;
      label63:
      if (i2 >= 3) {
        break label136;
      }
      if (i1 != i2) {
        break label157;
      }
    }
    label136:
    label157:
    for (boolean bool = true;; bool = false)
    {
      localActionSheet.a(this.jdField_a_of_type_ArrayOfJavaLangString[i2], bool);
      i2 += 1;
      break label63;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == 0)
      {
        i1 = 1;
        break;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int != 2) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int != 3)) {
        break;
      }
      i1 = 2;
      break;
      localActionSheet.a(new bnl(this, localActionSheet));
      localActionSheet.show();
      return;
    }
  }
  
  public void m()
  {
    this.f = true;
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == 1) {
      c(1);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == 0)
      {
        c(0);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == 2)
      {
        c(2);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int != 3);
    c(3);
  }
  
  public void o()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k)) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int != 0)) {
      a(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k, true);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e())
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k))
        {
          a(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k, true);
          return;
        }
        a(5, "", true);
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k))
      {
        a(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k, false);
        return;
      }
    } while (this.jdField_a_of_type_ArrayOfAndroidViewView[5] == null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[5].setVisibility(8);
  }
  
  public void onBackPressed()
  {
    f();
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
    if (paramBoolean)
    {
      b(11);
      return;
    }
    b(10);
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof Integer)) {}
    switch (((Integer)paramView).intValue())
    {
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    default: 
    case 3: 
    case 1: 
    case 4: 
    case 5: 
    case 6: 
    case 12: 
      do
      {
        do
        {
          return;
          a(6, 30, 2131363412, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, false, 0, false);
          return;
          l();
          return;
          paramView = new Intent(getActivity(), TroopClassChoiceActivity.class);
          paramView.putExtra("troopGroupClassExt", Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long));
          startActivityForResult(paramView, 11);
          return;
          i();
          return;
          a(5, 900, 2131363043, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m, true, 1, true);
          a("Grp_moredata", "Clk_brief", "");
          return;
          if (!NetworkUtil.e(this))
          {
            a(2131362923, 0);
            return;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler == null);
        try
        {
          long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c);
          r();
          this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(l1, 8388736);
          return;
        }
        catch (Exception paramView) {}
      } while (!QLog.isColorLevel());
      QLog.i("Q.troopinfo", 2, paramView.toString());
      return;
    }
    v();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  public void p()
  {
    Intent localIntent = new Intent(this, SplashActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("tab_index", 0);
    startActivity(localIntent);
  }
  
  public void q()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter != null))
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(bool);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a();
    }
  }
  
  public void r()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131363569);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopinfo", 2, localException.toString());
    }
  }
  
  public void s()
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
      QLog.i("Q.troopinfo", 2, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity
 * JD-Core Version:    0.7.0.1
 */