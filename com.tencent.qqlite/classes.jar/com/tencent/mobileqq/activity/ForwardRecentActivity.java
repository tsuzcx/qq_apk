package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anj;
import ank;
import anl;
import anm;
import ann;
import ano;
import anp;
import anq;
import anr;
import ans;
import ant;
import anu;
import anv;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.adapter.ForwardRecentListAdapter;
import com.tencent.mobileqq.app.AutomatorObserver;
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
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.open.agent.report.ReportCenter;
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
  public static final String b = "com.tencent.intent.QQLite_FORWARD";
  public static final int c = 11;
  public static final String c = "-1010";
  public static final int d = 20000;
  public static final String d = "k_qzone";
  public static final int e = 20001;
  public static final String e = "k_dataline";
  public static final String f = "k_cancel_button";
  public static final String g = "k_favorites";
  public static final String h = "k_send";
  public static final String i = "acceptType";
  protected static final String j = "forward_type";
  protected static final String k = "forward_thumb";
  protected static final String l = "forward_text";
  protected static final String m = "key_jump_from_qzone_feed";
  protected static final String n = "key_jump_from_qzone_feed_left_title";
  public static final String q = "com.tencent.intent.QQLite_FORWARD";
  public static final String s = "public_account";
  public static final String t = "web_share";
  public static final String u = "struct_msg_from_h5";
  public static final String v = "struct_favorite";
  protected long a;
  public Dialog a;
  public Uri a;
  public Bundle a;
  public Handler a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new anq(this);
  View jdField_a_of_type_AndroidViewView;
  public LinearLayout a;
  public RelativeLayout a;
  protected OpenIdObserver a;
  private ForwardOperations jdField_a_of_type_ComTencentMobileqqActivityForwardOperations;
  private ForwardRecentListAdapter jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter;
  private AutomatorObserver jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver = new anl(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new anv(this);
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new ank(this);
  protected QQCustomDialog a;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  View b;
  public boolean b;
  View c;
  protected boolean c;
  View d;
  public boolean d;
  View jdField_e_of_type_AndroidViewView;
  boolean jdField_e_of_type_Boolean = false;
  public int f;
  private View jdField_f_of_type_AndroidViewView;
  boolean jdField_f_of_type_Boolean = false;
  int jdField_g_of_type_Int;
  boolean jdField_g_of_type_Boolean = false;
  boolean h = false;
  private boolean i;
  private boolean j;
  private boolean k = true;
  private boolean l = true;
  private boolean m = true;
  private boolean n = true;
  String jdField_o_of_type_JavaLangString;
  private boolean jdField_o_of_type_Boolean;
  String p;
  String r;
  public String w;
  protected String x;
  
  public ForwardRecentActivity()
  {
    this.jdField_d_of_type_Boolean = false;
    this.o = true;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver = new ann(this);
  }
  
  private List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if ((this.jdField_f_of_type_Int == 1001) || (this.jdField_f_of_type_Int == -4))
    {
      if (this.jdField_g_of_type_Int == 13)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (RecentUser)paramList.next();
          if ((localObject != null) && (((RecentUser)localObject).type == 0) && (!Utils.a(((RecentUser)localObject).uin)) && (!Utils.b(((RecentUser)localObject).uin)) && (((RecentUser)localObject).type != 7000) && (a(((RecentUser)localObject).uin))) {
            localArrayList.add(localObject);
          }
        }
      }
      if (("public_account".equals(this.r)) || ("web_share".equals(this.r)) || ("struct_msg_from_h5".equals(this.r)) || ("struct_favorite".equals(this.r))) {
        paramList = paramList.iterator();
      }
    }
    else
    {
      while (paramList.hasNext())
      {
        localObject = (RecentUser)paramList.next();
        if ((localObject != null) && (!Utils.a(((RecentUser)localObject).uin)) && (((RecentUser)localObject).type != 1000) && (((RecentUser)localObject).type != 1020) && (((RecentUser)localObject).type != 1005) && (((RecentUser)localObject).type != 1004) && (((RecentUser)localObject).type != 1009) && (((RecentUser)localObject).type != 1001) && (((RecentUser)localObject).type != 1022) && (((RecentUser)localObject).type != 1024) && (((RecentUser)localObject).type != 1025) && ((((RecentUser)localObject).type != 1) || (!a(((RecentUser)localObject).uin))) && (((RecentUser)localObject).type != 7000))
        {
          localArrayList.add(localObject);
          continue;
          if (this.jdField_f_of_type_Int == 0)
          {
            paramList = paramList.iterator();
            while (paramList.hasNext())
            {
              localObject = (RecentUser)paramList.next();
              if ((localObject != null) && (((RecentUser)localObject).type != 7000)) {
                if (this.jdField_g_of_type_Boolean)
                {
                  if ((((RecentUser)localObject).type == 1) || (((((RecentUser)localObject).type == 0) || (((RecentUser)localObject).type == 3000)) && (this.jdField_e_of_type_Boolean))) {
                    localArrayList.add(localObject);
                  }
                }
                else if (this.h)
                {
                  if ((((RecentUser)localObject).type == 0) || (((RecentUser)localObject).type == 1) || (((RecentUser)localObject).type == 3000) || (((RecentUser)localObject).type == 1006) || (((RecentUser)localObject).type == 1004) || (((RecentUser)localObject).type == 1000) || (((RecentUser)localObject).type == 1001)) {
                    localArrayList.add(localObject);
                  }
                }
                else if ((localObject != null) && (!Utils.a(((RecentUser)localObject).uin)) && ((((RecentUser)localObject).type == 0) || (((RecentUser)localObject).type == 3000) || ((((RecentUser)localObject).type == 1) && (this.l) && (!a(((RecentUser)localObject).uin))) || (-1L != FileManagerUtil.a(((RecentUser)localObject).type)))) {
                  localArrayList.add(localObject);
                }
              }
            }
          }
          if (this.jdField_f_of_type_Int == -1)
          {
            paramList = paramList.iterator();
            while (paramList.hasNext())
            {
              localObject = (RecentUser)paramList.next();
              if ((localObject != null) && (!Utils.a(((RecentUser)localObject).uin)) && (((RecentUser)localObject).type != 7000) && ((((RecentUser)localObject).type != 1) || (!a(((RecentUser)localObject).uin)))) {
                localArrayList.add(localObject);
              }
            }
          }
          if ((this.jdField_f_of_type_Int == 1) || (this.jdField_f_of_type_Int == 12)) {
            paramList = paramList.iterator();
          }
          while (paramList.hasNext())
          {
            localObject = (RecentUser)paramList.next();
            if ((localObject != null) && (!Utils.a(((RecentUser)localObject).uin)) && (((RecentUser)localObject).type != 1003) && (((RecentUser)localObject).type != 1025) && (((RecentUser)localObject).type != 1024) && ((((RecentUser)localObject).type != 1) || (!a(((RecentUser)localObject).uin))) && (((RecentUser)localObject).type != 7000))
            {
              localArrayList.add(localObject);
              continue;
              if (this.jdField_f_of_type_Int == 15)
              {
                localObject = (FriendsManagerImp)this.app.getManager(8);
                paramList = paramList.iterator();
                while (paramList.hasNext())
                {
                  RecentUser localRecentUser = (RecentUser)paramList.next();
                  if ((localRecentUser != null) && (localRecentUser.type != 7000)) {
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
              }
              if ((this.jdField_f_of_type_Int == -2) || (this.jdField_f_of_type_Int == 11)) {
                paramList = paramList.iterator();
              }
              while (paramList.hasNext())
              {
                localObject = (RecentUser)paramList.next();
                if ((localObject != null) && (!Utils.a(((RecentUser)localObject).uin)) && (((RecentUser)localObject).type != 1000) && (((RecentUser)localObject).type != 1020) && (((RecentUser)localObject).type != 1005) && (((RecentUser)localObject).type != 1004) && (((RecentUser)localObject).type != 1009) && (((RecentUser)localObject).type != 1001) && (((RecentUser)localObject).type != 1022) && (((RecentUser)localObject).type != 7000) && (((RecentUser)localObject).type != 1025) && (((RecentUser)localObject).type != 1024) && ((((RecentUser)localObject).type != 1) || (!a(((RecentUser)localObject).uin))))
                {
                  localArrayList.add(localObject);
                  continue;
                  if (this.jdField_f_of_type_Int == 16)
                  {
                    paramList = paramList.iterator();
                    while (paramList.hasNext())
                    {
                      localObject = (RecentUser)paramList.next();
                      if ((localObject != null) && (!Utils.a(((RecentUser)localObject).uin)) && (((((RecentUser)localObject).type == 0) && (this.o)) || ((((RecentUser)localObject).type == 1) && (!a(((RecentUser)localObject).uin)) && (this.l)) || ((((RecentUser)localObject).type == 3000) && (this.m)))) {
                        localArrayList.add(localObject);
                      }
                    }
                  }
                  paramList = paramList.iterator();
                  while (paramList.hasNext())
                  {
                    localObject = (RecentUser)paramList.next();
                    if ((localObject != null) && (!Utils.a(((RecentUser)localObject).uin)) && (((RecentUser)localObject).type != 1000) && (((RecentUser)localObject).type != 1020) && (((RecentUser)localObject).type != 1005) && (((RecentUser)localObject).type != 1006) && (((RecentUser)localObject).type != 1004) && (((RecentUser)localObject).type != 1009) && (((RecentUser)localObject).type != 1001) && (((RecentUser)localObject).type != 1022) && (((RecentUser)localObject).type != 7000) && (((RecentUser)localObject).type != 1025) && (((RecentUser)localObject).type != 1024) && ((((RecentUser)localObject).type != 1) || (!a(((RecentUser)localObject).uin)))) {
                      localArrayList.add(localObject);
                    }
                  }
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
    this.jdField_a_of_type_AndroidAppDialog = new anr(this, this, this.app, paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    paramInt = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -paramInt);
    localTranslateAnimation1.setDuration(200L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -paramInt, 0.0F);
    localTranslateAnimation2.setDuration(200L);
    localTranslateAnimation1.setAnimationListener(new ans(this));
    localTranslateAnimation2.setAnimationListener(new ant(this, paramInt));
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new anu(this, paramInt, localTranslateAnimation2));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation1);
    ReportController.b(this.app, "CliOper", "", "", "0X8004049", "0X8004049", 0, 0, "", "", "", "");
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
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296564));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297141));
    c();
    setTitle("发送到");
    paramTextView = (ImageView)findViewById(2131296902);
    paramTextView.setImageResource(2130838043);
    paramTextView.setVisibility(0);
    paramTextView.setContentDescription("搜索");
    paramTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131296662));
    paramTextView = LayoutInflater.from(getActivity());
    this.jdField_f_of_type_AndroidViewView = paramTextView.inflate(2130903202, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_f_of_type_AndroidViewView);
    paramTextView = paramTextView.inflate(2130903118, null);
    ((TextView)paramTextView.findViewById(2131296841)).setText(2131362951);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(paramTextView);
    this.jdField_a_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131296856);
    this.jdField_b_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131296860);
    this.jdField_c_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131296862);
    this.jdField_d_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131297137);
    this.jdField_e_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131297139);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void c()
  {
    if ((!this.o) && (!this.k) && (!this.l) && (!this.m))
    {
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_f_of_type_AndroidViewView.setVisibility(0);
    if (this.o) {}
    for (int i2 = 1;; i2 = 0)
    {
      int i1 = i2;
      if (this.k) {
        i1 = i2 + 1;
      }
      i2 = i1;
      if (this.l) {
        i2 = i1 + 1;
      }
      i1 = i2;
      if (this.m) {
        i1 = i2 + 1;
      }
      i2 = i1;
      if (this.i)
      {
        i2 = i1 + 1;
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      }
      LinearLayout.LayoutParams localLayoutParams;
      if (i2 == 5)
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
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams();
        localLayoutParams.weight = 0.0F;
        localLayoutParams.width = AIOUtils.a(72.0F, getResources());
        if (this.o) {
          break label461;
        }
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        label286:
        if (this.k) {
          break label472;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        label302:
        if (this.l) {
          break label483;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      for (;;)
      {
        if (this.m) {
          break label494;
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        return;
        if (i2 > 4) {
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
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams();
        localLayoutParams.weight = 0.0F;
        localLayoutParams.width = i1;
        break;
        label461:
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        break label286;
        label472:
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        break label302;
        label483:
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      label494:
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      return;
    }
  }
  
  private void d()
  {
    View localView = getLayoutInflater().inflate(2130903590, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    ((ImageView)localView.findViewById(2131296453)).setBackgroundResource(2130838504);
    TextView localTextView = (TextView)localView.findViewById(16908308);
    localTextView.setText("我的电脑");
    localTextView.setContentDescription("我的电脑");
    localView.setOnClickListener(new ano(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.a(localView);
  }
  
  private void e()
  {
    if (this.app.e())
    {
      this.jdField_a_of_type_JavaUtilList = a(this.app.a().a().b());
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter == null)
      {
        anp localanp = new anp(this);
        this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter = new ForwardRecentListAdapter(this, this.app, null, 2130903590, this.jdField_a_of_type_JavaUtilList, localanp, null);
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
  
  private void f()
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.a = this.app.a();
    String str2 = this.app.c();
    String str1 = str2;
    if (StringUtil.b(str2)) {
      str1 = ContactUtils.g(this.app, this.app.a());
    }
    localUserInfo.b = str1;
    localUserInfo.c = this.app.getSid();
    QZoneHelper.a(this, localUserInfo, this.p, "写说说", null, 20000);
  }
  
  public void a()
  {
    StatisticCollector.a(BaseApplication.getContext()).a(this.app, this.app.getAccount(), "", "multi_account", "push_login_window", 0, 1, 0);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131362444);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131362487);
    anm localanm = new anm(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131362794, localanm);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131362445, localanm);
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
  
  public boolean a(String paramString)
  {
    FriendManager localFriendManager = (FriendManager)this.app.getManager(8);
    return (localFriendManager != null) && (localFriendManager.f(paramString));
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
    setTheme(2131624275);
    super.doOnCreate(paramBundle);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
    setContentViewNoTitle(2130903204);
    a((TextView)findViewById(2131296891));
    int i1;
    boolean bool1;
    label262:
    label291:
    label297:
    int i2;
    try
    {
      localIntent = getIntent();
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations = new ForwardOperations(this, this.app, localIntent);
      if (isFinishing()) {
        return false;
      }
      this.jdField_a_of_type_AndroidOsBundle = localIntent.getExtras();
      if (this.jdField_a_of_type_AndroidOsBundle == null) {
        this.jdField_a_of_type_AndroidOsBundle = new Bundle();
      }
      this.jdField_a_of_type_AndroidNetUri = localIntent.getData();
      this.jdField_f_of_type_Int = localIntent.getIntExtra("forward_type", -1);
      this.jdField_g_of_type_Int = localIntent.getIntExtra("req_type", 2147483647);
      this.p = localIntent.getStringExtra("forward_thumb");
      this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("fromWebXman", false);
      this.r = this.jdField_a_of_type_AndroidOsBundle.getString("pluginName");
      paramBundle = localIntent.getParcelableExtra("fileinfo");
      if (!(paramBundle instanceof ForwardFileInfo)) {
        break label1860;
      }
      paramBundle = (ForwardFileInfo)paramBundle;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Intent localIntent;
        Object localObject1;
        label398:
        Object localObject2;
        ArrayList localArrayList;
        label826:
        finish();
        break;
        if (this.jdField_f_of_type_Int == 15)
        {
          localObject2 = localIntent.getStringExtra("choose_friend_title");
          bool1 = localIntent.getBooleanExtra("choose_friend_is_qqfriends", true);
          bool2 = localIntent.getBooleanExtra("choose_friend_is_contacts", false);
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = "选择好友";
          }
          setTitle((CharSequence)localObject1);
          this.l = false;
          this.m = false;
          this.k = bool2;
          this.o = bool1;
        }
        else if ((this.jdField_f_of_type_Int == 1001) || (this.jdField_f_of_type_Int == -4) || (this.jdField_f_of_type_Int == 9) || (this.jdField_f_of_type_Int == -3) || (this.jdField_f_of_type_Int == 14))
        {
          this.n = false;
          this.k = false;
        }
        else if (this.jdField_f_of_type_Int == 11)
        {
          this.n = false;
        }
        else if (this.jdField_f_of_type_Int == 16)
        {
          i1 = localIntent.getIntExtra("acceptType", 13);
          if ((i1 & 0x1) == 0) {
            this.o = false;
          }
          if ((i1 & 0x4) == 0) {
            this.l = false;
          }
          if ((i1 & 0x8) == 0) {
            this.m = false;
          }
          this.k = false;
          this.n = false;
          continue;
          this.m = false;
          continue;
          this.o = false;
          continue;
          i1 = i2;
          if (i3 < paramBundle.size())
          {
            localObject1 = ForwardOperations.a(this, (Uri)paramBundle.get(i3));
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals("/")))
            {
              i1 = 1;
              break label1914;
              if (paramBundle == null)
              {
                localObject1 = getIntent().getStringExtra("forward_filepath");
                paramBundle = (Bundle)localObject1;
                if (localObject1 != null) {}
              }
              for (paramBundle = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");; paramBundle = paramBundle.a())
              {
                if ((TextUtils.isEmpty(paramBundle)) || (paramBundle.equals("/"))) {
                  break label1595;
                }
                i1 = 1;
                break;
              }
              if (getIntent().getBooleanExtra("isFromShare", false))
              {
                i1 = 1;
                this.jdField_f_of_type_Boolean = true;
                continue;
                if (this.j) {
                  if ((this.jdField_f_of_type_Int == -1) || (this.jdField_f_of_type_Int == 1) || (this.jdField_f_of_type_Int == 12))
                  {
                    d();
                  }
                  else if ((this.jdField_f_of_type_Int == 0) && (i1 != 0))
                  {
                    d();
                    continue;
                    if (TextUtils.isEmpty(this.w)) {
                      break label1930;
                    }
                    paramBundle = this.app.a().a((String)localObject1);
                    if (paramBundle == null)
                    {
                      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a(2131362488);
                      this.jdField_a_of_type_AndroidOsHandler = new Handler();
                      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new anj(this), 3000L);
                      this.app.a(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
                      this.app.a().e((String)localObject1);
                    }
                    else
                    {
                      if (this.w.equals(paramBundle.openID)) {
                        break label1925;
                      }
                      a();
                      continue;
                      Util.a(this.app, null, "pageview", this.jdField_a_of_type_Long, i1, "");
                      continue;
                      if (this.jdField_g_of_type_Int == 2) {
                        paramBundle = "3";
                      } else if (this.jdField_g_of_type_Int == 5) {
                        paramBundle = "2";
                      } else {
                        paramBundle = "4";
                      }
                    }
                  }
                }
              }
            }
            else
            {
              i1 = i2;
              break label1914;
              i1 = 0;
              continue;
              paramBundle = null;
              continue;
              bool1 = true;
              continue;
              bool1 = true;
            }
          }
        }
      }
    }
    if (paramBundle != null)
    {
      i1 = paramBundle.c();
      localObject1 = paramBundle.a();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label1879;
      }
      bool1 = true;
      this.jdField_e_of_type_Boolean = bool1;
      if (i1 != 2) {
        break label1885;
      }
      bool1 = true;
      this.h = bool1;
      if (!this.jdField_e_of_type_Boolean) {
        break label1891;
      }
      if (i1 == 3) {
        break label1865;
      }
      if (!FileUtils.a((String)localObject1)) {
        break label1891;
      }
      break label1865;
      this.jdField_f_of_type_Boolean = bool1;
      if (this.jdField_f_of_type_Int != 0) {
        break label1233;
      }
      this.m = true;
      this.k = false;
      this.n = false;
      if (!this.jdField_f_of_type_Boolean) {
        this.l = false;
      }
      if ((paramBundle != null) && ((paramBundle.a() == 10006) || (paramBundle.a() == 10003))) {
        this.l = true;
      }
      if ((paramBundle != null) && (paramBundle.a() == 10006))
      {
        this.jdField_g_of_type_Boolean = true;
        if ((!this.jdField_e_of_type_Boolean) || (!FileUtils.a(paramBundle.a()))) {
          break label1897;
        }
        i1 = 1;
        if (i1 == 0) {
          break label1464;
        }
        this.m = true;
        this.k = false;
        this.l = true;
        if (!this.jdField_e_of_type_Boolean) {
          break label1472;
        }
        this.o = true;
      }
      if (((this.jdField_f_of_type_Int == 1001) || (this.jdField_f_of_type_Int == -4)) && (this.jdField_g_of_type_Int == 13))
      {
        this.m = false;
        this.k = false;
        this.l = false;
        this.n = false;
      }
      if (this.jdField_f_of_type_Int == 14) {
        ReportController.b(this.app, "CliOper", "", "", "ep_mall", "Clk_send_nonaio", 0, 0, "", "", "", localIntent.getIntExtra("FORWARD_EMOPGK_ID", -1) + "");
      }
      localObject1 = (PhoneContactManager)this.app.getManager(10);
      if ((localObject1 != null) && (!((PhoneContactManager)localObject1).g())) {
        this.k = false;
      }
      localObject2 = (FriendManager)this.app.getManager(8);
      localObject1 = (ContactFacade)this.app.getManager(46);
      if ((localObject2 != null) && (localObject1 != null))
      {
        i2 = 0;
        localArrayList = ((ContactFacade)localObject1).a("-1004");
        i1 = i2;
        if (localArrayList != null)
        {
          i1 = i2;
          if (localArrayList.size() > 0) {
            i1 = 1;
          }
        }
        if (i1 == 0) {
          this.m = false;
        }
        i2 = 0;
        localArrayList = ((ContactFacade)localObject1).a("-1003");
        i1 = i2;
        if (localArrayList != null)
        {
          i1 = i2;
          if (localArrayList.size() > 0) {
            i1 = 1;
          }
        }
        if (i1 == 0) {
          this.l = false;
        }
        localObject2 = ((FriendManager)localObject2).c();
        if (localObject2 == null) {
          break label1855;
        }
        localObject2 = ((ArrayList)localObject2).iterator();
      }
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localArrayList = ((ContactFacade)localObject1).a(String.valueOf(((Groups)((Iterator)localObject2).next()).group_id));
          if ((localArrayList != null) && (localArrayList.size() > 0))
          {
            i1 = 1;
            if (i1 == 0) {
              this.o = false;
            }
            this.i = localIntent.getBooleanExtra("k_qzone", false);
            if ("com.tencent.intent.QQLite_FORWARD".equals(localIntent.getAction())) {
              break label1871;
            }
            if ((!this.i) || (!localIntent.getBooleanExtra("k_send", true))) {
              break label1902;
            }
            break label1871;
            this.jdField_b_of_type_Boolean = bool1;
            i2 = 0;
            i1 = 0;
            if (localIntent.getBooleanExtra("sendMultiple", false))
            {
              paramBundle = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
              if (this.jdField_f_of_type_Int != 12) {
                break label1908;
              }
              i1 = 1;
              this.j = localIntent.getBooleanExtra("k_dataline", true);
              if (this.jdField_f_of_type_Int != 11) {
                break label1619;
              }
              d();
              if (this.app.a() == null) {
                finish();
              }
              e();
              this.w = localIntent.getStringExtra("open_id");
              this.x = localIntent.getStringExtra("share_uin");
              this.jdField_a_of_type_Long = localIntent.getLongExtra("req_share_id", 0L);
              localObject1 = String.valueOf(this.jdField_a_of_type_Long);
              this.jdField_c_of_type_Boolean = "login".equals(localIntent.getStringExtra("jfrom"));
              i1 = 0;
              if (this.jdField_c_of_type_Boolean) {
                break label1935;
              }
              if ((TextUtils.isEmpty(this.x)) || (this.x.equals(this.app.getAccount()))) {
                break label1676;
              }
              a();
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((i1 != 0) && (this.jdField_b_of_type_Boolean) && (this.jdField_f_of_type_Int == 11)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a("-1010", -1, "", getString(2131362372));
      }
      if (this.jdField_f_of_type_Int == 11)
      {
        setTitle(2131363968);
        i1 = this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.b();
        if (this.jdField_g_of_type_Int == 5)
        {
          Util.a(this.app, null, "connect_sharepic", "pageview", this.jdField_a_of_type_Long, i1, "");
          StatisticCollector.a(BaseApplication.getContext()).a(this.app, "sha_pageview", 1, "", "", (String)localObject1);
          if (this.jdField_g_of_type_Int != 1) {
            break label1813;
          }
          paramBundle = "1";
          ReportCenter.a().a(this.app.getAccount(), this.w, (String)localObject1, "10", "11", "0", paramBundle, "0", "0", false);
        }
      }
      else
      {
        c();
        break label1877;
        if (!getIntent().getBooleanExtra("isFromShare", false)) {
          break label297;
        }
        this.jdField_e_of_type_Boolean = true;
        this.jdField_f_of_type_Boolean = this.jdField_e_of_type_Boolean;
        break label297;
      }
      for (;;)
      {
        label1233:
        boolean bool2;
        label1464:
        label1472:
        label1619:
        label1877:
        return true;
        label1595:
        label1855:
        label1860:
        label1865:
        label1871:
        label1879:
        bool1 = false;
        label1676:
        label1813:
        break;
        label1885:
        bool1 = false;
        break label262;
        label1891:
        bool1 = false;
        break label291;
        label1897:
        i1 = 0;
        break label398;
        label1902:
        bool1 = false;
        break label826;
        label1908:
        int i3 = 0;
        continue;
        label1914:
        i3 += 1;
        i2 = i1;
      }
      label1925:
      i1 = 1;
      continue;
      label1930:
      i1 = 1;
      continue;
      label1935:
      i1 = 1;
    }
  }
  
  protected void doOnDestroy()
  {
    this.app.c(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    super.doOnDestroy();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130968583, 2130968584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity
 * JD-Core Version:    0.7.0.1
 */