package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.MenuItemCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cme;
import cmf;
import cmg;
import cmh;
import cmi;
import cmj;
import cmk;
import cml;
import cmm;
import cmn;
import cmo;
import cmp;
import cmq;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.adapter.ForwardRecentListAdapter;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ContactFacade;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForwardRecentActivity
  extends IphoneTitleBarActivity
  implements AdapterView.OnItemClickListener
{
  protected static final int a = 50001;
  static final String jdField_a_of_type_JavaLangString = "ForwardRecentActivity";
  public static final int b = 10;
  public static final String b = "com.tencent.intent.QQI_FORWARD";
  public static final int c = 11;
  public static final String c = "-1010";
  public static final int d = 20000;
  public static final String d = "k_qzone";
  public static final int e = 20001;
  public static final String e = "k_dataline";
  public static final String f = "k_cancel_button";
  public static final String g = "k_favorites";
  private static final int jdField_h_of_type_Int = 0;
  public static final String h = "k_send";
  protected static final String i = "forward_type";
  protected static final String j = "forward_thumb";
  protected static final String k = "forward_text";
  protected static final String l = "key_jump_from_qzone_feed";
  protected static final String m = "key_jump_from_qzone_feed_left_title";
  public static final String p = "com.tencent.intent.QQI_FORWARD";
  public static final String r = "public_account";
  public static final String s = "web_share";
  public static final String t = "struct_msg_from_h5";
  public static final String u = "struct_favorite";
  protected long a;
  public Dialog a;
  public Uri a;
  public Bundle a;
  public Handler a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new cml(this);
  View jdField_a_of_type_AndroidViewView;
  public LinearLayout a;
  public RelativeLayout a;
  protected OpenIdObserver a;
  private ForwardOperations jdField_a_of_type_ComTencentMobileqqActivityForwardOperations;
  private ForwardRecentListAdapter jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter;
  private AutomatorObserver jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver = new cmg(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new cmq(this);
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new cmf(this);
  protected QQCustomDialog a;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List jdField_a_of_type_JavaUtilList;
  public boolean a;
  View b;
  protected boolean b;
  View c;
  public boolean c;
  View jdField_d_of_type_AndroidViewView;
  boolean jdField_d_of_type_Boolean = false;
  View jdField_e_of_type_AndroidViewView;
  boolean jdField_e_of_type_Boolean = false;
  public int f;
  View jdField_f_of_type_AndroidViewView;
  boolean jdField_f_of_type_Boolean = false;
  int jdField_g_of_type_Int;
  private View jdField_g_of_type_AndroidViewView;
  boolean jdField_g_of_type_Boolean = false;
  private boolean jdField_h_of_type_Boolean;
  private boolean i;
  private boolean j = true;
  private boolean k = true;
  private boolean l = true;
  private boolean m = false;
  String jdField_n_of_type_JavaLangString;
  private boolean jdField_n_of_type_Boolean;
  String jdField_o_of_type_JavaLangString;
  private boolean jdField_o_of_type_Boolean = false;
  String q;
  public String v;
  protected String w;
  
  public ForwardRecentActivity()
  {
    this.jdField_c_of_type_Boolean = false;
    this.n = true;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver = new cmi(this);
  }
  
  private List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    RecentUser localRecentUser;
    if (this.jdField_f_of_type_Int == 1001)
    {
      if (this.jdField_g_of_type_Int == 13)
      {
        localObject = (FriendsManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localRecentUser = (RecentUser)paramList.next();
          if ((localRecentUser != null) && (localRecentUser.type == 0) && (!Utils.a(localRecentUser.uin)) && (!Utils.b(localRecentUser.uin)) && (localObject != null) && (((FriendsManagerImp)localObject).b(localRecentUser.uin))) {
            localArrayList.add(localRecentUser);
          }
        }
      }
      if (("public_account".equals(this.q)) || ("web_share".equals(this.q)) || ("struct_msg_from_h5".equals(this.q)) || ("struct_favorite".equals(this.q)))
      {
        localObject = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localRecentUser = (RecentUser)paramList.next();
          if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && (localRecentUser.type != 1000) && (localRecentUser.type != 1020) && (localRecentUser.type != 1008) && (localRecentUser.type != 1005) && (localRecentUser.type != 1004) && (localRecentUser.type != 1009) && (localRecentUser.type != 1021) && (localRecentUser.type != 1001) && (localRecentUser.type != 1022) && (localRecentUser.type != 7100) && ((localRecentUser.type != 1) || (!((FriendManager)localObject).f(localRecentUser.uin)))) {
            localArrayList.add(localRecentUser);
          }
        }
      }
    }
    else if (this.jdField_f_of_type_Int == 0)
    {
      localObject = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (localObject != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localRecentUser = (RecentUser)paramList.next();
          if (this.jdField_f_of_type_Boolean)
          {
            if ((localRecentUser.type == 1) || ((localRecentUser.type == 0) && (this.jdField_d_of_type_Boolean))) {
              localArrayList.add(localRecentUser);
            }
          }
          else if (this.jdField_g_of_type_Boolean)
          {
            if ((localRecentUser.type == 0) || (localRecentUser.type == 1) || (localRecentUser.type == 3000)) {
              localArrayList.add(localRecentUser);
            }
          }
          else if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && ((localRecentUser.type == 0) || (localRecentUser.type == 3000) || ((localRecentUser.type == 1) && (this.jdField_e_of_type_Boolean) && (!((FriendManager)localObject).f(localRecentUser.uin))))) {
            localArrayList.add(localRecentUser);
          }
        }
      }
    }
    else
    {
      if (this.jdField_f_of_type_Int == -1)
      {
        localObject = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localRecentUser = (RecentUser)paramList.next();
          if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && (localRecentUser.type != 1008) && (localRecentUser.type != 1021) && ((localRecentUser.type != 1) || (!((FriendManager)localObject).f(localRecentUser.uin)))) {
            localArrayList.add(localRecentUser);
          }
        }
      }
      if ((this.jdField_f_of_type_Int == 1) || (this.jdField_f_of_type_Int == 12))
      {
        localObject = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        paramList = paramList.iterator();
      }
      while (paramList.hasNext())
      {
        localRecentUser = (RecentUser)paramList.next();
        if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && (localRecentUser.type != 1003) && (localRecentUser.type != 1008) && (localRecentUser.type != 1021) && ((localRecentUser.type != 1) || (!((FriendManager)localObject).f(localRecentUser.uin))))
        {
          localArrayList.add(localRecentUser);
          continue;
          if (this.jdField_f_of_type_Int == 13)
          {
            localObject = (FriendsManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
            paramList = paramList.iterator();
            while (paramList.hasNext())
            {
              localRecentUser = (RecentUser)paramList.next();
              if ((localRecentUser.type == 0) && (!Utils.a(localRecentUser.uin)) && (!Utils.b(localRecentUser.uin)))
              {
                if ((localObject != null) && (((FriendsManagerImp)localObject).b(localRecentUser.uin))) {
                  localArrayList.add(localRecentUser);
                }
              }
              else if ((localRecentUser.type == 1006) || (localRecentUser.type == 1004)) {
                localArrayList.add(localRecentUser);
              }
            }
          }
          if ((this.jdField_f_of_type_Int == -2) || (this.jdField_f_of_type_Int == 11))
          {
            localObject = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
            paramList = paramList.iterator();
          }
          while (paramList.hasNext())
          {
            localRecentUser = (RecentUser)paramList.next();
            if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && (localRecentUser.type != 1000) && (localRecentUser.type != 1020) && (localRecentUser.type != 1008) && (localRecentUser.type != 1005) && (localRecentUser.type != 1004) && (localRecentUser.type != 1009) && (localRecentUser.type != 1021) && (localRecentUser.type != 1001) && (localRecentUser.type != 1022) && (localRecentUser.type != 7100) && ((localRecentUser.type != 1) || (!((FriendManager)localObject).f(localRecentUser.uin))))
            {
              localArrayList.add(localRecentUser);
              continue;
              localObject = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
              paramList = paramList.iterator();
              while (paramList.hasNext())
              {
                localRecentUser = (RecentUser)paramList.next();
                if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && (localRecentUser.type != 1000) && (localRecentUser.type != 1020) && (localRecentUser.type != 1008) && (localRecentUser.type != 1005) && (localRecentUser.type != 1006) && (localRecentUser.type != 1004) && (localRecentUser.type != 1009) && (localRecentUser.type != 1021) && (localRecentUser.type != 1001) && (localRecentUser.type != 1022) && (localRecentUser.type != 7100) && ((localRecentUser.type != 1) || (!((FriendManager)localObject).f(localRecentUser.uin)))) {
                  localArrayList.add(localRecentUser);
                }
              }
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      return;
    }
    Contacts.a += 1;
    this.jdField_a_of_type_AndroidAppDialog = new cmm(this, this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    paramInt = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -paramInt);
    localTranslateAnimation1.setDuration(200L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -paramInt, 0.0F);
    localTranslateAnimation2.setDuration(200L);
    localTranslateAnimation1.setAnimationListener(new cmn(this));
    localTranslateAnimation2.setAnimationListener(new cmo(this, paramInt));
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new cmp(this, paramInt, localTranslateAnimation2));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation1);
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004049", "0X8004049", 0, 0, "", "", "", "");
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramActivity, ForwardRecentActivity.class);
    localIntent.putExtra("forward_type", paramInt2).putExtra("forward_text", paramString1).putExtra("forward_thumb", paramString2).putExtra("k_qzone", paramBoolean1).putExtra("k_send", paramBoolean2);
    if (paramInt2 == 1) {
      localIntent.putExtra("forward_extra", paramString2);
    }
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    paramActivity.startActivityForResult(localIntent, paramInt1);
  }
  
  private void a(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131231116));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131231373));
    findViewById(2131231455).setVisibility(8);
    findViewById(2131231456).setVisibility(8);
    findViewById(2131231460).setVisibility(8);
    ((TextView)findViewById(2131231375)).setText(getString(2131559074));
    setTitle(2131559074);
    paramTextView = (TextView)findViewById(2131231379);
    paramTextView.setVisibility(0);
    paramTextView.setText(2131561746);
    paramTextView.setContentDescription("取消按钮");
    paramTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131231198));
    paramTextView = LayoutInflater.from(a());
    Object localObject = paramTextView.inflate(2130903944, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    ((View)localObject).findViewById(2131233085).setVisibility(8);
    localObject = (EditText)((View)localObject).findViewById(2131233086);
    ((EditText)localObject).setFocusable(false);
    ((EditText)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    ((EditText)localObject).setCursorVisible(false);
    this.jdField_g_of_type_AndroidViewView = paramTextView.inflate(2130903237, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_g_of_type_AndroidViewView);
    paramTextView = paramTextView.inflate(2130903140, null);
    ((TextView)paramTextView.findViewById(2131231385)).setText(2131562725);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(paramTextView);
    this.jdField_a_of_type_AndroidViewView = this.jdField_g_of_type_AndroidViewView.findViewById(2131231713);
    this.jdField_b_of_type_AndroidViewView = this.jdField_g_of_type_AndroidViewView.findViewById(2131231717);
    this.jdField_c_of_type_AndroidViewView = this.jdField_g_of_type_AndroidViewView.findViewById(2131231719);
    this.jdField_d_of_type_AndroidViewView = this.jdField_g_of_type_AndroidViewView.findViewById(2131231711);
    this.jdField_e_of_type_AndroidViewView = this.jdField_g_of_type_AndroidViewView.findViewById(2131231715);
    this.jdField_f_of_type_AndroidViewView = this.jdField_g_of_type_AndroidViewView.findViewById(2131231721);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void d()
  {
    if ((!this.n) && (!this.j) && (!this.k))
    {
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_g_of_type_AndroidViewView.setVisibility(0);
    if (this.n) {}
    for (int i2 = 1;; i2 = 0)
    {
      int i1 = i2;
      if (this.j) {
        i1 = i2 + 1;
      }
      i2 = i1;
      if (this.k) {
        i2 = i1 + 1;
      }
      i1 = i2;
      if (this.h)
      {
        i1 = i2 + 1;
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      }
      LinearLayout.LayoutParams localLayoutParams;
      if (i1 == 5)
      {
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
        localLayoutParams.weight = 0.0F;
        localLayoutParams.width = AIOUtils.a(72.0F, getResources());
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        localLayoutParams.weight = 0.0F;
        localLayoutParams.width = AIOUtils.a(72.0F, getResources());
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        localLayoutParams.weight = 0.0F;
        localLayoutParams.width = AIOUtils.a(72.0F, getResources());
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
        localLayoutParams.weight = 0.0F;
        localLayoutParams.width = AIOUtils.a(72.0F, getResources());
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_f_of_type_AndroidViewView.getLayoutParams();
        localLayoutParams.weight = 0.0F;
        localLayoutParams.width = AIOUtils.a(72.0F, getResources());
        if (this.n) {
          break label434;
        }
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        label266:
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        if (this.j) {
          break label445;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      for (;;)
      {
        if (this.k) {
          break label456;
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        return;
        if (i1 > 4) {
          break;
        }
        i1 = getResources().getDisplayMetrics().widthPixels / 4;
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
        localLayoutParams.weight = 0.0F;
        localLayoutParams.width = i1;
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        localLayoutParams.weight = 0.0F;
        localLayoutParams.width = i1;
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        localLayoutParams.weight = 0.0F;
        localLayoutParams.width = i1;
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
        localLayoutParams.weight = 0.0F;
        localLayoutParams.width = i1;
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_f_of_type_AndroidViewView.getLayoutParams();
        localLayoutParams.weight = 0.0F;
        localLayoutParams.width = i1;
        break;
        label434:
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        break label266;
        label445:
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      label456:
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      return;
    }
  }
  
  private void e()
  {
    View localView = getLayoutInflater().inflate(2130903929, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    ((ImageView)localView.findViewById(2131230940)).setBackgroundResource(2130838590);
    TextView localTextView = (TextView)localView.findViewById(16908308);
    localTextView.setText(getString(2131559075));
    localTextView.setContentDescription("我的电脑");
    localView.setOnClickListener(new cmj(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.a(localView);
  }
  
  private void f()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e())
    {
      this.jdField_a_of_type_JavaUtilList = a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a());
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter == null)
      {
        cmk localcmk = new cmk(this);
        this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter = new ForwardRecentListAdapter(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, null, 2130903929, this.jdField_a_of_type_JavaUtilList, localcmk, null);
        this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter.a(false);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private void g()
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.a = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    String str2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e();
    String str1 = str2;
    if (StringUtil.b(str2)) {
      str1 = ContactUtils.g(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    localUserInfo.b = str1;
    localUserInfo.c = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
    QZoneHelper.a(this, localUserInfo, this.jdField_o_of_type_JavaLangString, getResources().getString(2131559076), null, 20000);
  }
  
  public void a()
  {
    StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", "multi_account", "push_login_window", 0, 1, 0);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131560539);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131560595);
    cmh localcmh = new cmh(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131561746, localcmh);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131560540, localcmh);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramInt -= this.jdField_a_of_type_ComTencentWidgetXListView.k();
    if (paramInt < 0) {}
    do
    {
      return;
      paramAdapterView = (TextView)paramView.findViewById(16908308);
    } while (paramAdapterView == null);
    if (paramAdapterView.getText() != null) {}
    for (paramAdapterView = paramAdapterView.getText().toString();; paramAdapterView = null)
    {
      paramView = (RecentUser)this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter.getItem(paramInt);
      if (paramView == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a(paramView.uin, paramView.type, paramView.troopUin, paramAdapterView);
      if (this.jdField_f_of_type_Int != 13) {
        break;
      }
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Tc_msg_cate", 0, 0, "2", "", "", "");
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations != null) && (!isFinishing()))
    {
      if (!paramBoolean) {
        break label65;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a(0, "", "");
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_d_of_type_Boolean)) {
        ForwardOperations.a(this, true, "shareToQQ", this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_Long);
      }
      return;
      label65:
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a(-1, "未知错误!", "未知错误!");
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    while ((paramInt2 != 1) || (20000 != paramInt1))
    {
      return;
      if (getIntent().getExtras().getBoolean("jump_to_mobileqq_share", false)) {
        setResult(10, paramIntent);
      }
      for (;;)
      {
        finish();
        return;
        setResult(-1, paramIntent);
      }
      setResult(-1, paramIntent);
      finish();
      return;
    }
    finish();
  }
  
  public void doOnBackPressed()
  {
    if ((!isFinishing()) && (this.jdField_f_of_type_Int == 11))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_d_of_type_Boolean) {
        ForwardOperations.a(this, false, "shareToQQ", this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_Long);
      }
      com.tencent.mobileqq.app.PhoneContactManagerImp.jdField_c_of_type_Boolean = false;
    }
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    setTheme(2131624539);
    super.doOnCreate(paramBundle);
    if (BaseActivity.a(getIntent()))
    {
      finish();
      return true;
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
    f(2130903239);
    TextView localTextView = (TextView)findViewById(2131231375);
    a(localTextView);
    Object localObject1 = getIntent();
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations = new ForwardOperations(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (Intent)localObject1);
    if (isFinishing()) {
      return false;
    }
    this.jdField_a_of_type_AndroidOsBundle = ((Intent)localObject1).getExtras();
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    this.jdField_a_of_type_AndroidNetUri = ((Intent)localObject1).getData();
    this.jdField_f_of_type_Int = ((Intent)localObject1).getIntExtra("forward_type", -1);
    this.jdField_g_of_type_Int = ((Intent)localObject1).getIntExtra("req_type", 2147483647);
    this.jdField_o_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("forward_thumb");
    this.q = this.jdField_a_of_type_AndroidOsBundle.getString("pluginName");
    Object localObject2 = ((Intent)localObject1).getParcelableExtra("fileinfo");
    paramBundle = null;
    if ((localObject2 instanceof ForwardFileInfo)) {
      paramBundle = (ForwardFileInfo)localObject2;
    }
    boolean bool;
    if (paramBundle != null)
    {
      i1 = paramBundle.c();
      if (!TextUtils.isEmpty(paramBundle.a()))
      {
        bool = true;
        this.jdField_d_of_type_Boolean = bool;
        if (i1 != 2) {
          break label1125;
        }
        bool = true;
        label270:
        this.jdField_g_of_type_Boolean = bool;
        if ((!this.jdField_d_of_type_Boolean) || (i1 != 3)) {
          break label1131;
        }
        bool = true;
        label291:
        this.jdField_e_of_type_Boolean = bool;
        label297:
        if (this.jdField_f_of_type_Int != 0) {
          break label1167;
        }
        this.k = true;
        this.l = false;
        this.m = false;
        this.jdField_o_of_type_Boolean = true;
        if (!this.jdField_e_of_type_Boolean) {
          this.j = false;
        }
        if ((paramBundle != null) && ((paramBundle.a() == 10006) || (paramBundle.a() == 10003))) {
          this.j = true;
        }
        label365:
        if ((paramBundle != null) && (paramBundle.a() == 10006))
        {
          this.jdField_f_of_type_Boolean = true;
          this.k = false;
          this.jdField_o_of_type_Boolean = true;
          this.j = true;
          if (!this.jdField_d_of_type_Boolean) {
            break label1209;
          }
          this.n = true;
        }
        label411:
        if ((this.jdField_f_of_type_Int != 1001) && (this.jdField_f_of_type_Int != 9) && (this.jdField_f_of_type_Int != -3) && (this.jdField_f_of_type_Int != 14)) {
          break label1217;
        }
        this.m = false;
        this.l = false;
        label458:
        if ((this.jdField_f_of_type_Int == 1001) && (this.jdField_g_of_type_Int == 13))
        {
          this.k = false;
          this.j = false;
          this.l = false;
        }
        if (this.jdField_f_of_type_Int == 14) {
          ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_send_nonaio", 0, 0, "", "", "", ((Intent)localObject1).getIntExtra("FORWARD_EMOPGK_ID", -1) + "");
        }
        localObject2 = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        paramBundle = (ContactFacade)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
        if ((localObject2 != null) && (paramBundle != null))
        {
          int i2 = 0;
          ArrayList localArrayList = paramBundle.a("-1004");
          i1 = i2;
          if (localArrayList != null)
          {
            i1 = i2;
            if (localArrayList.size() > 0) {
              i1 = 1;
            }
          }
          if (i1 == 0) {
            this.k = false;
          }
          i2 = 0;
          localArrayList = paramBundle.a("-1003");
          i1 = i2;
          if (localArrayList != null)
          {
            i1 = i2;
            if (localArrayList.size() > 0) {
              i1 = 1;
            }
          }
          if (i1 == 0) {
            this.j = false;
          }
          localObject2 = ((FriendManager)localObject2).c();
          if (localObject2 == null) {
            break label1398;
          }
          localObject2 = ((ArrayList)localObject2).iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localArrayList = paramBundle.a(String.valueOf(((Groups)((Iterator)localObject2).next()).group_id));
          } while ((localArrayList == null) || (localArrayList.size() <= 0));
        }
      }
    }
    label802:
    label993:
    label1125:
    label1131:
    label1398:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0) {
        this.n = false;
      }
      this.h = ((Intent)localObject1).getBooleanExtra("k_qzone", false);
      if (("com.tencent.intent.QQI_FORWARD".equals(((Intent)localObject1).getAction())) || ((this.h) && (((Intent)localObject1).getBooleanExtra("k_send", true))))
      {
        bool = true;
        this.jdField_a_of_type_Boolean = bool;
        this.i = ((Intent)localObject1).getBooleanExtra("k_dataline", true);
        if (((this.i) && ((this.jdField_f_of_type_Int == -1) || (this.jdField_f_of_type_Int == 1) || (this.jdField_f_of_type_Int == 12) || (this.jdField_f_of_type_Int == 0))) || (this.jdField_f_of_type_Int == 11)) {
          e();
        }
        if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {
          finish();
        }
        f();
        this.v = ((Intent)localObject1).getStringExtra("open_id");
        this.w = ((Intent)localObject1).getStringExtra("share_uin");
        this.jdField_a_of_type_Long = ((Intent)localObject1).getLongExtra("req_share_id", 0L);
        paramBundle = String.valueOf(this.jdField_a_of_type_Long);
        this.jdField_b_of_type_Boolean = "login".equals(((Intent)localObject1).getStringExtra("jfrom"));
        i1 = 0;
        if (this.jdField_b_of_type_Boolean) {
          break label1370;
        }
        if ((TextUtils.isEmpty(this.w)) || (this.w.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))) {
          break label1245;
        }
        a();
        if ((i1 != 0) && (this.jdField_a_of_type_Boolean) && (this.jdField_f_of_type_Int == 11)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a("-1010", -1, "", getString(2131560461));
        }
        if (this.jdField_f_of_type_Int == 11)
        {
          localTextView.setText(2131562844);
          i1 = this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.b();
          if (this.jdField_g_of_type_Int != 5) {
            break label1375;
          }
          Util.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, null, "connect_sharepic", "pageview", this.jdField_a_of_type_Long, i1, "");
        }
      }
      for (;;)
      {
        StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "sha_pageview", 1, "", "", paramBundle);
        d();
        return true;
        bool = false;
        break;
        bool = false;
        break label270;
        bool = false;
        break label291;
        if (!getIntent().getBooleanExtra("isFromShare", false)) {
          break label297;
        }
        this.jdField_d_of_type_Boolean = true;
        this.jdField_e_of_type_Boolean = this.jdField_d_of_type_Boolean;
        break label297;
        if (this.jdField_f_of_type_Int != 13) {
          break label365;
        }
        localTextView.setText(getResources().getString(2131559073));
        this.j = false;
        this.k = false;
        this.m = false;
        break label365;
        this.n = false;
        break label411;
        if (this.jdField_f_of_type_Int != 11) {
          break label458;
        }
        this.m = false;
        this.l = false;
        break label458;
        bool = false;
        break label802;
        if (!TextUtils.isEmpty(this.v))
        {
          localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBundle);
          if (localObject1 == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a(2131560596);
            this.jdField_a_of_type_AndroidOsHandler = new Handler();
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new cme(this), 3000L);
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramBundle);
            break label993;
          }
          if (!this.v.equals(((OpenID)localObject1).openID))
          {
            a();
            break label993;
          }
          i1 = 1;
          break label993;
        }
        i1 = 1;
        break label993;
        i1 = 1;
        break label993;
        Util.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, null, "pageview", this.jdField_a_of_type_Long, i1, "");
      }
    }
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    super.doOnDestroy();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130968589, 2130968590);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      a(10);
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    paramMenu.clear();
    MenuItem localMenuItem = paramMenu.add(0, 0, 0, getString(2131562830));
    localMenuItem.setIcon(2130839698);
    MenuItemCompat.setShowAsAction(localMenuItem, 1);
    return super.onPrepareOptionsMenu(paramMenu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity
 * JD-Core Version:    0.7.0.1
 */