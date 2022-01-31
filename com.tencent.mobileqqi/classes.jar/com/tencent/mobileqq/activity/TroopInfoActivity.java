package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.biz.common.report.BnrReport;
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
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.mobileqq.troop.widget.AvatarWallView;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.TroopSystemMsgUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import dpi;
import dpj;
import dpk;
import dpl;
import dpm;
import dpn;
import dpo;
import dpp;
import dpq;
import dpr;
import dps;
import dpt;
import dpu;
import dpv;
import dpw;
import dpx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.util.WeakReference;

public class TroopInfoActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final int A = 5;
  public static final int B = 7;
  public static final int C = 11;
  public static final int D = 8;
  public static final int E = 9;
  public static final int F = 14;
  public static final int G = 15;
  public static final int H = 16;
  protected static final int I = 0;
  protected static final int J = 1;
  protected static final int K = 2;
  protected static final int L = 3;
  protected static final int M = 4;
  protected static final int N = 5;
  protected static final int O = 6;
  protected static final int P = 7;
  protected static final int Q = 8;
  protected static final int R = 9;
  protected static final int S = 10;
  protected static final int T = 10;
  protected static final int U = 11;
  protected static final int V = 12;
  protected static final int W = 13;
  protected static final int X = 14;
  public static final int Y = 0;
  public static final int Z = 1;
  public static final int a = 1;
  public static final String a = "Q.troopinfo";
  public static final int aa = 2;
  public static final int ab = 1;
  public static final int ac = 0;
  public static final int ad = 2;
  public static final int ae = 3;
  protected static final int ag = 1;
  protected static final int ah = 2;
  protected static final int ai = 3;
  protected static final int aj = 4;
  protected static final int ak = 5;
  protected static final int al = 6;
  protected static final int am = 7;
  protected static final int an = 8;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 8;
  public static final int i = 9;
  public static final int j = 10;
  public static final int k = 11;
  public static final int l = 12;
  public static final int m = 13;
  public static final int n = 0;
  public static final int o = 116;
  public static final int p = 3001;
  public static final int q = 3002;
  public static final int r = 3003;
  public static final int s = 3004;
  public static final int t = 3005;
  public static final int u = 3006;
  public static final int v = 3022;
  public static final int w = 3023;
  public static final int x = 3008;
  public static final int y = 3017;
  public static final int z = 6;
  public Dialog a;
  private DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new dpo(this);
  public Handler a;
  protected View a;
  protected LinearLayout a;
  public TextView a;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new dpk(this);
  public FriendListHandler a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new dpj(this);
  public TroopHandler a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new dpl(this);
  public TroopInfo a;
  public AvatarWallAdapter a;
  public TroopInfoData a;
  private QQCustomDialogWtihInput jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  public ArrayList a;
  public List a;
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new dpt(this);
  protected boolean a;
  public View[] a;
  public String[] a;
  public int af = -1;
  private DialogInterface.OnClickListener b;
  public View b;
  protected String b;
  public boolean b;
  public String c;
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
    this.jdField_a_of_type_AndroidOsHandler = new dpx(this);
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new dpp(this);
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short != 3)
    {
      Intent localIntent = new Intent(a(), AddFriendLogicActivity.class);
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("name", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f);
      localIntent.putExtra("group_option", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short);
      localIntent.putExtra("type", 1);
      localIntent.putExtra("param_last_activity_name", a_());
      localIntent.putExtra("stat_option", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a());
      localIntent.putExtra("join_group_question", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.r);
      localIntent.putExtra("join_group_answer", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.s);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_JavaLangString))
      {
        localIntent.putExtra("param_return_addr", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_JavaLangString);
        startActivity(localIntent);
        return;
      }
      startActivityForResult(localIntent, 8);
      return;
    }
    a(2131563078, 1);
  }
  
  private void D()
  {
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    int i1;
    if (String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p).equals(localObject)) {
      i1 = 0;
    }
    for (;;)
    {
      localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p, i1);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p)) {
        ((ProfileActivity.AllInOne)localObject).g = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_q_of_type_JavaLangString;
      }
      if (i1 == 21)
      {
        ((ProfileActivity.AllInOne)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString;
        ((ProfileActivity.AllInOne)localObject).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_JavaLangString;
      }
      ProfileActivity.a(a(), (ProfileActivity.AllInOne)localObject);
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p))
      {
        if (((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p))
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
  
  private void E()
  {
    new dpm(this).start();
  }
  
  private void F()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "updateTroopOwnerName");
    }
    new dpn(this).start();
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
    int i1 = 1;
    int i2 = 0;
    if (paramTroopInfoData == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = Long.toString(paramTroopInfoData.jdField_a_of_type_Long);
    localObject = GroupCatalogTool.a(paramContext).a(paramContext, (String)localObject);
    if (!TextUtils.isEmpty(paramTroopInfoData.j)) {
      paramContext = paramTroopInfoData.j;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramContext)) {
        localStringBuffer.append(paramContext + " | ");
      }
      for (;;)
      {
        if ((paramTroopInfoData.jdField_a_of_type_JavaUtilList != null) && (paramTroopInfoData.jdField_a_of_type_JavaUtilList.size() > 0))
        {
          int i3 = paramTroopInfoData.jdField_a_of_type_JavaUtilList.size();
          for (;;)
          {
            if (i2 < i3)
            {
              if ((i1 == 0) || (!((String)paramTroopInfoData.jdField_a_of_type_JavaUtilList.get(i2)).equals(paramContext))) {
                localStringBuffer.append((String)paramTroopInfoData.jdField_a_of_type_JavaUtilList.get(i2) + " | ");
              }
              i2 += 1;
              continue;
              if ((localObject == null) || (TextUtils.isEmpty(((GroupCatalogBean)localObject).jdField_a_of_type_JavaLangString))) {
                break label314;
              }
              if (((GroupCatalogBean)localObject).jdField_a_of_type_JavaLangString.equals(paramContext.getResources().getString(2131559141)))
              {
                paramContext = "";
                break;
              }
              if (((GroupCatalogBean)localObject).jdField_a_of_type_Int == 1)
              {
                if (((GroupCatalogBean)localObject).jdField_a_of_type_JavaUtilArrayList != null) {
                  break label314;
                }
                paramContext = ((GroupCatalogBean)localObject).jdField_a_of_type_JavaLangString;
                break;
              }
              paramContext = ((GroupCatalogBean)localObject).jdField_a_of_type_JavaLangString;
              break;
            }
          }
        }
        if (localStringBuffer.length() > 0) {
          localStringBuffer.delete(localStringBuffer.length() - " | ".length(), localStringBuffer.length());
        }
        return localStringBuffer.toString();
        i1 = 0;
      }
      label314:
      paramContext = "";
    }
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
  
  private void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null)
    {
      localObject = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (localObject != null) {
        break label121;
      }
    }
    label121:
    for (Object localObject = null;; localObject = ((FriendManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString))
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
          E();
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
  
  private void i(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "saveTroopInfo| nModifyFlag = " + paramInt);
    }
    if ((paramInt & 0x3F) > 0) {}
    try
    {
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
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
  
  private void w()
  {
    switch (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int)
    {
    case 8: 
    case 10: 
    case 11: 
    case 12: 
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
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f);
    startActivity(localIntent);
  }
  
  public void a(int paramInt)
  {
    String str = getString(paramInt);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(str);
    localQQCustomDialog.setMessage(null);
    localQQCustomDialog.setPositiveButton(getString(2131561573), new dpq(this, localQQCustomDialog));
    localQQCustomDialog.setPositiveButtonContentDescription(getString(2131561573));
    localQQCustomDialog.setNegativeButton(getString(2131562172), new dpr(this));
    localQQCustomDialog.setNegativeButtonContentDescription(getString(2131562172));
    localQQCustomDialog.show();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, d(), 0, paramInt2);
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
        TextView localTextView1 = (TextView)paramView.findViewById(2131230941);
        localTextView2 = (TextView)paramView.findViewById(2131231507);
        localView = paramView.findViewById(2131232623);
        paramView = paramString1;
        if (paramString1 == null) {
          paramView = "";
        }
        localTextView1.setText(paramView);
        if (6 == paramInt1) {
          if (TextUtils.isEmpty(paramString2))
          {
            localTextView2.setVisibility(8);
            label120:
            if (!paramBoolean) {
              break label229;
            }
          }
        }
        break;
      }
    }
    label229:
    for (paramInt1 = 0;; paramInt1 = 8)
    {
      localView.setVisibility(paramInt1);
      localView.setVisibility(8);
      return;
      paramView.setTag(null);
      paramView.setOnClickListener(null);
      break;
      paramView.setBackgroundResource(2130837877);
      break label48;
      paramView.setBackgroundResource(2130837882);
      break label48;
      paramView.setBackgroundResource(2130837881);
      break label48;
      paramView.setBackgroundResource(2130837879);
      break label48;
      localTextView2.setVisibility(0);
      localTextView2.setText(new QQText(paramString2, 11));
      break label120;
      localTextView2.setText(paramString2);
      break label120;
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
          a("Grp_moredata", "del_head", "");
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
        localTextView = (TextView)localView1.findViewById(2131231507);
        localView2 = localView1.findViewById(2131232623);
        if (paramInt != 6) {
          break label178;
        }
        if (!TextUtils.isEmpty(paramString)) {
          break label154;
        }
        localTextView.setVisibility(8);
        if (!paramBoolean) {
          break label187;
        }
        localView1.setTag(Integer.valueOf(paramInt));
        localView1.setOnClickListener(this);
        localView2.setVisibility(0);
      }
      for (;;)
      {
        localView2.setVisibility(8);
        return;
        label154:
        localTextView.setVisibility(0);
        localTextView.setText(new QQText(paramString, 11));
        break;
        label178:
        localTextView.setText(paramString);
        break;
        label187:
        localView1.setTag(null);
        localView1.setOnClickListener(null);
        localView2.setVisibility(8);
      }
    }
  }
  
  protected void a(String paramString)
  {
    n();
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this, d());
    localQQProgressDialog.a(paramString);
    localQQProgressDialog.setCancelable(false);
    localQQProgressDialog.setOnDismissListener(new dpv(this));
    this.jdField_a_of_type_AndroidAppDialog = localQQProgressDialog;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void a(String paramString, CharSequence paramCharSequence)
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[1];
    if (localView != null)
    {
      ((FormSimpleItem)localView.findViewById(2131233221)).setRightText(paramString);
      ((TextView)localView.findViewById(2131233222)).setText(paramCharSequence);
    }
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", paramString1, paramString2, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, paramString3, "", "");
  }
  
  public void b(int paramInt)
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233216);
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131233217);
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    case 10: 
      localImageView.setVisibility(8);
      localTextView.setText(2131562799);
      this.jdField_a_of_type_AndroidViewView.setTag(Integer.valueOf(10));
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    case 11: 
      localImageView.setVisibility(8);
      localTextView.setText(2131562801);
      this.jdField_a_of_type_AndroidViewView.setTag(Integer.valueOf(11));
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    localImageView.setVisibility(0);
    localImageView.setImageResource(2130838354);
    localTextView.setText(2131562262);
    this.jdField_a_of_type_AndroidViewView.setTag(Integer.valueOf(12));
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f = paramString;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e()) && ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Long & 0x800) == 0L)) {}
    for (boolean bool = true;; bool = false)
    {
      a(3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, bool);
      return;
    }
  }
  
  public void c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(getString(2131560399), getString(2131560403));
      b(10);
      return;
    case 0: 
      a(getString(2131560400), getString(2131560404));
      b(10);
      return;
    case 2: 
      a(getString(2131560401), getString(2131560405));
      b(11);
      return;
    }
    a(getString(2131560402), getString(2131560405));
    b(11);
  }
  
  protected boolean c()
  {
    bool2 = false;
    boolean bool1 = false;
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "checkParams");
    }
    do
    {
      try
      {
        Object localObject = getIntent().getExtras();
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString = ((Bundle)localObject).getString("troop_uin");
        long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
        if (l1 > 0L) {}
        bool1 = bool2;
      }
      catch (Exception localException1)
      {
        try
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
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.r = TroopSystemMsgUtil.b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.s = TroopSystemMsgUtil.c(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Long = ((Bundle)localObject).getLong("TROOP_INFO_FLAG_EXT");
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_JavaUtilList = TroopInfo.getTags(((Bundle)localObject).getString("TROOP_INFO_TAGS_EXT"));
          localObject = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
          if (localObject != null)
          {
            localObject = ((FriendManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
            if (localObject != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
              this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean = true;
              this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a((TroopInfo)localObject, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
            }
          }
          bool1 = true;
          return bool1;
        }
        catch (Exception localException2)
        {
          bool2 = true;
          continue;
        }
        localException1 = localException1;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.troopinfo", 2, localException1.toString());
    return bool2;
  }
  
  protected void d()
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
  
  /* Error */
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +49 -> 55
    //   9: ldc 55
    //   11: iconst_2
    //   12: new 427	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 428	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 954
    //   22: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: iload_1
    //   26: invokevirtual 558	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: ldc_w 956
    //   32: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: iload_2
    //   36: invokevirtual 558	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: ldc_w 958
    //   42: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_3
    //   46: invokevirtual 961	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 335	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: iconst_m1
    //   56: iload_2
    //   57: if_icmpne +67 -> 124
    //   60: iload_1
    //   61: tableswitch	default:+63 -> 124, 5:+202->263, 6:+286->347, 7:+64->125, 8:+403->464, 9:+448->509, 10:+63->124, 11:+318->379, 12:+63->124, 13:+63->124, 14:+548->609, 15:+555->616, 16:+129->190
    //   125: aload_3
    //   126: ifnull -2 -> 124
    //   129: aload_3
    //   130: invokevirtual 882	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   133: ifnull -9 -> 124
    //   136: aload_3
    //   137: invokevirtual 882	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   140: astore_3
    //   141: aload_0
    //   142: getfield 136	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   145: aload_3
    //   146: ldc_w 963
    //   149: invokevirtual 885	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   152: putfield 902	com/tencent/mobileqq/troopinfo/TroopInfoData:k	Ljava/lang/String;
    //   155: aload_0
    //   156: getfield 136	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   159: aload_3
    //   160: ldc_w 965
    //   163: iconst_0
    //   164: invokevirtual 904	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   167: putfield 906	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_d_of_type_Int	I
    //   170: aload_0
    //   171: getfield 136	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   174: aload_3
    //   175: ldc_w 967
    //   178: iconst_0
    //   179: invokevirtual 904	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   182: putfield 908	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_e_of_type_Int	I
    //   185: aload_0
    //   186: invokevirtual 969	com/tencent/mobileqq/activity/TroopInfoActivity:r	()V
    //   189: return
    //   190: aload_3
    //   191: ifnull -67 -> 124
    //   194: aload_3
    //   195: invokevirtual 882	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   198: ifnull -74 -> 124
    //   201: aload_3
    //   202: invokevirtual 882	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   205: astore_3
    //   206: aload_0
    //   207: getfield 136	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   210: getfield 902	com/tencent/mobileqq/troopinfo/TroopInfoData:k	Ljava/lang/String;
    //   213: aload_3
    //   214: ldc_w 963
    //   217: invokevirtual 885	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   220: invokestatic 974	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   223: ifne +7 -> 230
    //   226: aload_0
    //   227: invokevirtual 976	com/tencent/mobileqq/activity/TroopInfoActivity:p	()V
    //   230: aload_0
    //   231: getfield 136	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   234: aload_3
    //   235: ldc_w 978
    //   238: invokevirtual 885	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   241: putfield 980	com/tencent/mobileqq/troopinfo/TroopInfoData:v	Ljava/lang/String;
    //   244: aload_0
    //   245: getfield 136	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   248: aload_3
    //   249: ldc_w 963
    //   252: invokevirtual 885	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   255: putfield 902	com/tencent/mobileqq/troopinfo/TroopInfoData:k	Ljava/lang/String;
    //   258: aload_0
    //   259: invokevirtual 969	com/tencent/mobileqq/activity/TroopInfoActivity:r	()V
    //   262: return
    //   263: aload_3
    //   264: ldc_w 982
    //   267: invokevirtual 985	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   270: astore_3
    //   271: aload_3
    //   272: aload_0
    //   273: getfield 136	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   276: getfield 545	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   279: invokestatic 988	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   282: ifne -158 -> 124
    //   285: aload_0
    //   286: invokevirtual 976	com/tencent/mobileqq/activity/TroopInfoActivity:p	()V
    //   289: aload_0
    //   290: getfield 136	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   293: aload_3
    //   294: putfield 545	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   297: aload_0
    //   298: getfield 136	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   301: getfield 545	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   304: invokestatic 257	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   307: ifne +26 -> 333
    //   310: aload_0
    //   311: getfield 136	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   314: getfield 545	com/tencent/mobileqq/troopinfo/TroopInfoData:m	Ljava/lang/String;
    //   317: astore_3
    //   318: aload_0
    //   319: bipush 6
    //   321: aload_3
    //   322: aload_0
    //   323: getfield 136	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   326: invokevirtual 547	com/tencent/mobileqq/troopinfo/TroopInfoData:e	()Z
    //   329: invokevirtual 550	com/tencent/mobileqq/activity/TroopInfoActivity:a	(ILjava/lang/String;Z)V
    //   332: return
    //   333: aload_0
    //   334: invokevirtual 989	com/tencent/mobileqq/activity/TroopInfoActivity:getResources	()Landroid/content/res/Resources;
    //   337: ldc_w 990
    //   340: invokevirtual 467	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   343: astore_3
    //   344: goto -26 -> 318
    //   347: aload_3
    //   348: ldc_w 982
    //   351: invokevirtual 985	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   354: astore_3
    //   355: aload_3
    //   356: aload_0
    //   357: getfield 136	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   360: getfield 220	com/tencent/mobileqq/troopinfo/TroopInfoData:f	Ljava/lang/String;
    //   363: invokestatic 974	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   366: ifne -242 -> 124
    //   369: aload_0
    //   370: invokevirtual 976	com/tencent/mobileqq/activity/TroopInfoActivity:p	()V
    //   373: aload_0
    //   374: aload_3
    //   375: invokevirtual 537	com/tencent/mobileqq/activity/TroopInfoActivity:b	(Ljava/lang/String;)V
    //   378: return
    //   379: ldc2_w 991
    //   382: lstore 7
    //   384: aload_3
    //   385: ldc_w 994
    //   388: invokevirtual 985	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   391: invokestatic 562	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   394: lstore 5
    //   396: aload_0
    //   397: getfield 136	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   400: getfield 409	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Long	J
    //   403: lload 5
    //   405: lcmp
    //   406: ifeq -282 -> 124
    //   409: lload 5
    //   411: ldc2_w 991
    //   414: lcmp
    //   415: ifeq -291 -> 124
    //   418: aload_0
    //   419: invokevirtual 976	com/tencent/mobileqq/activity/TroopInfoActivity:p	()V
    //   422: aload_0
    //   423: getfield 136	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   426: lload 5
    //   428: putfield 409	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Long	J
    //   431: aload_0
    //   432: invokespecial 525	com/tencent/mobileqq/activity/TroopInfoActivity:E	()V
    //   435: return
    //   436: astore_3
    //   437: lload 7
    //   439: lstore 5
    //   441: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   444: ifeq -48 -> 396
    //   447: ldc 55
    //   449: iconst_2
    //   450: aload_3
    //   451: invokevirtual 510	java/lang/Exception:toString	()Ljava/lang/String;
    //   454: invokestatic 335	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   457: lload 7
    //   459: lstore 5
    //   461: goto -65 -> 396
    //   464: aload_0
    //   465: getfield 136	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   468: getfield 583	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Int	I
    //   471: iconst_2
    //   472: if_icmpeq +27 -> 499
    //   475: aload_0
    //   476: getfield 136	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   479: getfield 583	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Int	I
    //   482: bipush 6
    //   484: if_icmpeq +15 -> 499
    //   487: aload_0
    //   488: getfield 136	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   491: getfield 583	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Int	I
    //   494: bipush 7
    //   496: if_icmpne -372 -> 124
    //   499: aload_0
    //   500: iconst_m1
    //   501: invokevirtual 996	com/tencent/mobileqq/activity/TroopInfoActivity:setResult	(I)V
    //   504: aload_0
    //   505: invokevirtual 593	com/tencent/mobileqq/activity/TroopInfoActivity:finish	()V
    //   508: return
    //   509: aload_3
    //   510: ldc_w 998
    //   513: invokevirtual 985	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   516: astore 9
    //   518: new 146	java/util/ArrayList
    //   521: dup
    //   522: invokespecial 147	java/util/ArrayList:<init>	()V
    //   525: astore_3
    //   526: aload 9
    //   528: ifnull +58 -> 586
    //   531: new 1000	org/json/JSONArray
    //   534: dup
    //   535: invokespecial 1001	org/json/JSONArray:<init>	()V
    //   538: pop
    //   539: new 1000	org/json/JSONArray
    //   542: dup
    //   543: aload 9
    //   545: invokespecial 1003	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   548: astore 9
    //   550: iload 4
    //   552: istore_1
    //   553: aload 9
    //   555: invokevirtual 1004	org/json/JSONArray:length	()I
    //   558: istore_2
    //   559: iload_1
    //   560: iload_2
    //   561: if_icmpge +25 -> 586
    //   564: aload_3
    //   565: aload 9
    //   567: iload_1
    //   568: invokevirtual 1005	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   571: invokeinterface 582 2 0
    //   576: pop
    //   577: iload_1
    //   578: iconst_1
    //   579: iadd
    //   580: istore_1
    //   581: goto -28 -> 553
    //   584: astore 9
    //   586: aload_0
    //   587: invokevirtual 976	com/tencent/mobileqq/activity/TroopInfoActivity:p	()V
    //   590: aload_0
    //   591: getfield 136	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   594: aload_3
    //   595: putfield 441	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   598: aload_0
    //   599: getfield 167	com/tencent/mobileqq/activity/TroopInfoActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   602: bipush 6
    //   604: invokevirtual 1011	android/os/Handler:sendEmptyMessage	(I)Z
    //   607: pop
    //   608: return
    //   609: aload_0
    //   610: iload_2
    //   611: aload_3
    //   612: invokevirtual 1013	com/tencent/mobileqq/activity/TroopInfoActivity:a	(ILandroid/content/Intent;)V
    //   615: return
    //   616: getstatic 1016	com/tencent/mobileqq/troop/widget/AvatarWallAdapter:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   619: ifnull -495 -> 124
    //   622: aload_0
    //   623: getstatic 1016	com/tencent/mobileqq/troop/widget/AvatarWallAdapter:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   626: invokestatic 1021	com/tencent/mobileqq/utils/ImageUtil:c	(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    //   629: astore_3
    //   630: aload_0
    //   631: invokestatic 1026	com/tencent/mobileqq/util/ProfileCardUtil:a	(Landroid/app/Activity;)I
    //   634: istore_1
    //   635: new 199	android/content/Intent
    //   638: dup
    //   639: invokespecial 584	android/content/Intent:<init>	()V
    //   642: aload_0
    //   643: ldc 2
    //   645: invokevirtual 1031	java/lang/Class:getName	()Ljava/lang/String;
    //   648: iload_1
    //   649: iload_1
    //   650: sipush 640
    //   653: sipush 640
    //   656: aload_3
    //   657: invokestatic 1033	com/tencent/mobileqq/util/ProfileCardUtil:b	()Ljava/lang/String;
    //   660: invokestatic 1038	com/tencent/mobileqq/activity/photo/PhotoUtils:a	(Landroid/content/Intent;Landroid/app/Activity;Ljava/lang/String;IIIILjava/lang/String;Ljava/lang/String;)V
    //   663: return
    //   664: astore 10
    //   666: goto -89 -> 577
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	669	0	this	TroopInfoActivity
    //   0	669	1	paramInt1	int
    //   0	669	2	paramInt2	int
    //   0	669	3	paramIntent	Intent
    //   1	550	4	i1	int
    //   394	66	5	l1	long
    //   382	76	7	l2	long
    //   516	50	9	localObject	Object
    //   584	1	9	localJSONException1	org.json.JSONException
    //   664	1	10	localJSONException2	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   384	396	436	java/lang/Exception
    //   539	550	584	org/json/JSONException
    //   553	559	584	org/json/JSONException
    //   564	577	664	org/json/JSONException
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    long l1 = 0L;
    if (QLog.isColorLevel()) {
      l1 = System.currentTimeMillis();
    }
    this.g = getIntent().getExtras().getBoolean("returnMsgList", false);
    if (!c())
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "onCreate, illegal param, troopuin = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      }
      finish();
    }
    e();
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "onCreate(), time = " + (System.currentTimeMillis() - l1));
    }
    BnrReport.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, 78);
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "edit", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    this.jdField_c_of_type_Boolean = true;
    long l1 = 0L;
    if (QLog.isColorLevel()) {
      l1 = System.currentTimeMillis();
    }
    GroupCatalogTool.a(getApplicationContext()).a();
    b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
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
      }
    }
    this.e = true;
    paramIntent = (AccountManager)getAppRuntime().getManager(0);
    String str = TroopBarUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    if (str == null) {
      paramIntent.updateSKey(this.jdField_a_of_type_MqqObserverAccountObserver);
    }
    for (;;)
    {
      a("Grp_moredata", "upload_head", "");
      return;
      TroopUtils.a(str, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter);
    }
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
    d();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  protected void e()
  {
    long l1 = System.currentTimeMillis();
    View localView = View.inflate(this, 2130903638, null);
    Object localObject1 = (ListView)localView.findViewById(2131233215);
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(getResources().getString(2131559138));
    ((ArrayList)localObject2).add(getResources().getString(2131559139));
    ((ListView)localObject1).setAdapter(new ArrayAdapter(this, 17367046, (List)localObject2));
    localObject1 = (XListView)localView.findViewById(2131231313);
    ((XListView)localObject1).setVerticalScrollBarEnabled(false);
    ((XListView)localObject1).setDivider(null);
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[10];
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
    localObject2 = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    ((XListView)localObject1).setAdapter(new XSimpleListAdapter(this.jdField_a_of_type_AndroidWidgetLinearLayout));
    ((XListView)localObject1).setBackgroundResource(2130837729);
    setContentView(localView);
    localObject2 = getIntent().getExtras().getString("troop_info_title");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = getString(2131562004);
    }
    setTitle((CharSequence)localObject1);
    localObject1 = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
    int i1 = (((DisplayMetrics)localObject1).widthPixels - getResources().getDimensionPixelSize(2131427556)) / 4;
    localObject1 = View.inflate(this, 2130903363, null);
    localObject2 = (AvatarWallView)((View)localObject1).findViewById(2131230904);
    ((AvatarWallView)localObject2).setColumnWidth(i1);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter = new AvatarWallAdapter(new WeakReference(this), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean, this.jdField_a_of_type_AndroidOsHandler, bool, "Grp_moredata");
    ((AvatarWallView)localObject2).setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(i1);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a((GridView)localObject2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    ((View)localObject1).setVisibility(8);
    localObject1 = View.inflate(this, 2130903365, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131230976));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    if (!bool) {
      ((View)localObject1).setVisibility(8);
    }
    ((View)localObject1).setVisibility(8);
    this.jdField_b_of_type_AndroidViewView = ((View)localObject1);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Long & 0x800) != 0L)
    {
      localObject1 = View.inflate(this, 2130903641, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[7] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      a(7, 0, (View)localObject1, getString(2131562201), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.t, false);
      localObject1 = View.inflate(this, 2130903648, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    }
    localObject1 = View.inflate(this, 2130903648, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    localObject1 = View.inflate(this, 2130903641, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[3] = localObject1;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e()) && ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Long & 0x800) == 0L))
    {
      bool = true;
      a(3, 2, (View)localObject1, getString(2131562431), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, bool);
      localObject1 = View.inflate(this, 2130903641, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[4] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      a(4, 2, (View)localObject1, getString(2131561780), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e());
      ((View)localObject1).setVisibility(8);
      localObject1 = View.inflate(this, 2130903642, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[8] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      localObject2 = (TextView)((View)localObject1).findViewById(2131231507);
      ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject2).setSingleLine(true);
      localObject2 = a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
      a(8, 2, (View)localObject1, getString(2131562189), (String)localObject2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e());
      LinearLayout localLinearLayout = (LinearLayout)((View)localObject1).findViewById(2131231118);
      if (localLinearLayout != null)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label1117;
        }
        i1 = 8;
        label828:
        localLinearLayout.setVisibility(i1);
      }
      ((View)localObject1).setVisibility(8);
      localObject1 = View.inflate(this, 2130903641, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[5] = localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      a(5, 2, (View)localObject1, getString(2131562190), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e());
      r();
      localObject2 = View.inflate(this, 2130903643, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[6] = localObject2;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m)) {
        break label1122;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m;
      label951:
      a(6, 3, (View)localObject2, getString(2131562235), (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e());
      localObject1 = new LinearLayout.LayoutParams(-1, (int)(60.0F * this.jdField_c_of_type_Float));
      localObject2 = View.inflate(this, 2130903648, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131232180);
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean) {
        break label1146;
      }
      if (!f()) {
        break label1137;
      }
      b(11);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.k.setOnClickListener(new dpi(this));
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "initUI: time = " + (System.currentTimeMillis() - l1));
      }
      return;
      bool = false;
      break;
      label1117:
      i1 = 0;
      break label828;
      label1122:
      localObject1 = getResources().getString(2131562503);
      break label951;
      label1137:
      b(10);
      continue;
      label1146:
      b(12);
    }
  }
  
  public void f()
  {
    String str1 = getString(2131562188);
    String str2 = getString(2131561775);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(str2);
    localQQCustomDialog.setMessage(str1);
    localQQCustomDialog.setPositiveButton(getString(2131562172), new dps(this, localQQCustomDialog));
    localQQCustomDialog.setNegativeButton(null, null);
    localQQCustomDialog.show();
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_ArrayOfAndroidViewView[9] == null) {
      return this.d;
    }
    return ((Switch)this.jdField_a_of_type_ArrayOfAndroidViewView[9].findViewById(2131232380)).isChecked();
  }
  
  public void finish()
  {
    n();
    i();
    setResult(-1, getIntent());
    if (this.g) {
      s();
    }
    super.finish();
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ArrayOfAndroidViewView[9] == null) {
      return;
    }
    Switch localSwitch = (Switch)this.jdField_a_of_type_ArrayOfAndroidViewView[9].findViewById(2131232380);
    localSwitch.setOnCheckedChangeListener(null);
    localSwitch.setChecked(this.d);
    localSwitch.setOnCheckedChangeListener(this);
    if (this.d) {}
    for (int i1 = 2131560423;; i1 = 2131560424)
    {
      localSwitch.setContentDescription(getString(i1));
      return;
    }
  }
  
  public void h()
  {
    if (!this.f)
    {
      finish();
      return;
    }
    a(2131561571);
  }
  
  public void i()
  {
    Intent localIntent = getIntent();
    localIntent.putExtra("location", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k);
    localIntent.putExtra("lat", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int);
    localIntent.putExtra("lon", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int);
    localIntent.putExtra("name", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f);
    localIntent.putExtra("class", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long);
    localIntent.putExtra("intro", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m);
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "init(), isInitialized = " + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(19));
    a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    new dpu(this).start();
  }
  
  protected void k()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_JavaUtilList;
    Intent localIntent = new Intent(this, TroopTagViewActivity.class);
    localIntent.putExtra("troopuin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("isAdmin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e());
    Object localObject1 = Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long);
    Object localObject3 = GroupCatalogTool.a(this).a(this, (String)localObject1);
    localObject1 = "";
    int i1;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.j))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.j;
      i1 = 1;
    }
    for (;;)
    {
      if (i1 != 0) {
        localIntent.putExtra("subclass", (String)localObject1);
      }
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject1 = new StringBuffer();
        localObject2 = ((List)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            ((StringBuffer)localObject1).append((String)localObject3 + "\n");
            continue;
            if ((localObject3 == null) || (TextUtils.isEmpty(((GroupCatalogBean)localObject3).jdField_a_of_type_JavaLangString))) {
              break label340;
            }
            if (((GroupCatalogBean)localObject3).jdField_a_of_type_JavaLangString.equals(getResources().getString(2131559140)))
            {
              i1 = 0;
              break;
            }
            if (((GroupCatalogBean)localObject3).jdField_a_of_type_Int == 1)
            {
              if (((GroupCatalogBean)localObject3).jdField_a_of_type_JavaUtilArrayList != null) {
                break label340;
              }
              localObject1 = ((GroupCatalogBean)localObject3).jdField_a_of_type_JavaLangString;
              i1 = 1;
              break;
            }
            localObject1 = ((GroupCatalogBean)localObject3).jdField_a_of_type_JavaLangString;
            i1 = 1;
            break;
          }
        }
        ((StringBuffer)localObject1).deleteCharAt(((StringBuffer)localObject1).length() - 1);
        localIntent.putExtra("tags", ((StringBuffer)localObject1).toString());
      }
      localIntent.putExtra("act_type", 1);
      localIntent.putExtra("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      localIntent.putExtra("modifyToSrv", 0);
      startActivityForResult(localIntent, 9);
      return;
      label340:
      i1 = 0;
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e())
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_data", "add_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
      TroopLocationModifyActivity.b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k, 16);
    }
  }
  
  public void m()
  {
    if (!this.f)
    {
      finish();
      return;
    }
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "modify", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
    BizTroopHandler localBizTroopHandler = (BizTroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(21);
    if ((localBizTroopHandler == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null))
    {
      finish();
      return;
    }
    long l4;
    try
    {
      l4 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_q_of_type_Int == -1)
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
          i2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_q_of_type_Int;
        }
      }
      a(getString(2131562401));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_q_of_type_Int == 2)
      {
        i2 = 3;
        if (i2 == -1) {
          break;
        }
        if ((this.af != 2) && (this.af != 3) && (i2 == 3)) {
          ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "set_local", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
        }
        if (((this.af == 2) || (this.af == 3)) && (i2 != 3)) {
          ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "un_local", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
        }
        localBizTroopHandler.a(l4, i2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_JavaUtilList, i1, l2, l1, str, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m);
        return;
      }
      l1 = 0L;
      l2 = 0L;
    }
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  public void o()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(2131560398);
    this.jdField_a_of_type_ArrayOfJavaLangString = getResources().getStringArray(2131689496);
    localActionSheet.d(this.jdField_a_of_type_ArrayOfJavaLangString[3]);
    int i1 = -1;
    int i2;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_q_of_type_Int == 1)
    {
      i1 = 0;
      i2 = 0;
      label60:
      if (i2 >= 3) {
        break label133;
      }
      if (i1 != i2) {
        break label154;
      }
    }
    label133:
    label154:
    for (boolean bool = true;; bool = false)
    {
      localActionSheet.a(this.jdField_a_of_type_ArrayOfJavaLangString[i2], bool);
      i2 += 1;
      break label60;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_q_of_type_Int == 0)
      {
        i1 = 1;
        break;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_q_of_type_Int != 2) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_q_of_type_Int != 3)) {
        break;
      }
      i1 = 2;
      break;
      localActionSheet.a(new dpw(this, localActionSheet));
      localActionSheet.show();
      return;
    }
  }
  
  public void onBackPressed()
  {
    h();
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
    case 9: 
    default: 
    case 3: 
    case 1: 
    case 4: 
    case 8: 
    case 5: 
    case 6: 
    case 10: 
    case 11: 
    case 12: 
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput = DialogUtil.a(this, 2131562431, null, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
          return;
          o();
          return;
          paramView = new Intent(a(), TroopClassChoiceActivity.class);
          paramView.putExtra("troopGroupClassExt", Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long));
          startActivityForResult(paramView, 11);
          return;
          k();
          return;
          l();
          return;
          a(5, 900, 2131562235, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m, true, 1, true);
          a("Grp_moredata", "Clk_brief", "");
          return;
          m();
          return;
          paramView = a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
          if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m)) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long == -1L) || (TextUtils.isEmpty(paramView)))
          {
            f();
            return;
          }
          m();
          return;
          if (!NetworkUtil.e(this))
          {
            a(2131562451, 0);
            return;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler == null);
        try
        {
          long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
          u();
          this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(l1, 8388736);
          return;
        }
        catch (Exception paramView) {}
      } while (!QLog.isColorLevel());
      QLog.i("Q.troopinfo", 2, paramView.toString());
      return;
    }
    D();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  public void p()
  {
    this.f = true;
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_q_of_type_Int == 1) {
      c(1);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_q_of_type_Int == 0)
      {
        c(0);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_q_of_type_Int == 2)
      {
        c(2);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_q_of_type_Int != 3);
    c(3);
  }
  
  public void r()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k)) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int != 0)) {
      a(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k, true);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ArrayOfAndroidViewView[5] != null) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[5].setVisibility(8);
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e())
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k)) {
          a(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k, true);
        } else {
          a(5, "", true);
        }
      }
      else if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k)) {
        a(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k, false);
      } else if (this.jdField_a_of_type_ArrayOfAndroidViewView[5] != null) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[5].setVisibility(8);
      }
    }
  }
  
  public void s()
  {
    Intent localIntent = new Intent(this, SplashActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("tab_index", 0);
    startActivity(localIntent);
  }
  
  public void t()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter != null))
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(bool);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a();
    }
  }
  
  public void u()
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
      QLog.i("Q.troopinfo", 2, localException.toString());
    }
  }
  
  public void v()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity
 * JD-Core Version:    0.7.0.1
 */