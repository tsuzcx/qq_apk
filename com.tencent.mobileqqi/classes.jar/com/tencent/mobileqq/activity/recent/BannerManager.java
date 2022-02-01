package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper.NewApkInfo;
import com.tencent.mobileqq.config.Config;
import com.tencent.mobileqq.config.ConfigManager;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.PicAndAdConf;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.redtouch.VipBannerInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.struct.PushBanner;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.widget.ADView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import env;
import enw;
import enx;
import eny;
import enz;
import eoa;
import eob;
import eod;
import eoe;
import eof;
import eog;
import eoh;
import eoi;
import eoj;
import eok;
import eol;
import eom;
import java.util.Calendar;
import java.util.List;
import mqq.app.AppRuntime;

public class BannerManager
  implements Handler.Callback
{
  public static final int B = 0;
  public static final int C = 1;
  public static final int D = 4;
  public static final int E = 6;
  public static final int F = 7;
  public static final int G = 8;
  public static final int H = 9;
  private static final int I = 101;
  public static final int a = 1;
  public static final String a = "0X8004028";
  public static final boolean a = true;
  public static final int b = 1;
  public static final String b = "0X8004029";
  public static final int c = 1;
  public static final String c = "Q.recent.banner";
  public static final int d = 2;
  public static final int e = 3;
  private static final boolean e = false;
  public static final int f = 4;
  public static final int g = 5;
  private static final String g = "0X80040AA";
  public static final int h = 6;
  public static final int i = 7;
  public static final int j = 8;
  public static final int k = 9;
  public static final int l = 10;
  public static final int m = 11;
  public static final int n = 12;
  public static final int o = 13;
  public static final int p = 14;
  public static final int q = 15;
  public static final int r = 15;
  public static final int s = 16;
  public static final int t = 16;
  public static final int u = 16;
  public static final int v = 17;
  public static final int w = 17;
  public static final int x = 17;
  public static final int y = 17;
  public static final int z = 3;
  public int A;
  private Handler jdField_a_of_type_AndroidOsHandler = new CustomHandler(this);
  private RecentCallHelper jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private int[] jdField_a_of_type_ArrayOfInt;
  private Banner[] jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner = new Banner[18];
  public boolean b;
  private int[] b;
  private boolean c = true;
  public String d;
  private boolean d;
  public String e;
  private String jdField_f_of_type_JavaLangString = "";
  private boolean jdField_f_of_type_Boolean = true;
  
  public BannerManager(BaseActivity paramBaseActivity, XListView paramXListView, RecentCallHelper paramRecentCallHelper)
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper = paramRecentCallHelper;
  }
  
  private View a()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130903950, null);
    ((TextView)localView.findViewById(2131234415)).setText(this.jdField_d_of_type_JavaLangString);
    localView.setOnClickListener(new eof(this));
    localView.findViewById(2131234414).setVisibility(8);
    return localView;
  }
  
  private void a(View paramView)
  {
    paramView.findViewById(2131231162).setVisibility(0);
    ((TextView)paramView.findViewById(2131231163)).setText(2131561867);
  }
  
  private void a(View paramView, Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.arg1 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "updateNetNeedSignOn return, msg == null || msg.arg1==HIDE");
      }
      return;
    }
    if ((paramMessage != null) && ((paramMessage.obj instanceof String))) {}
    for (paramMessage = String.valueOf(paramMessage.obj);; paramMessage = "http://qq.com")
    {
      paramView = paramView.findViewById(2131231162);
      if (paramView.getVisibility() != 0) {
        paramView.setVisibility(0);
      }
      paramView.setOnClickListener(new env(this, paramMessage));
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b, "CliOper", "", "", "0X8004028", "0X8004028", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private void a(Banner paramBanner)
  {
    if ((paramBanner == null) || (paramBanner.jdField_a_of_type_AndroidViewView != null)) {}
    for (;;)
    {
      return;
      switch (paramBanner.d)
      {
      }
      while (QLog.isDevelopLevel())
      {
        QLog.d("Q.recent.banner", 4, "initBannerView | banner = " + paramBanner);
        return;
        paramBanner.jdField_a_of_type_AndroidViewView = b();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = d();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = f();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = g();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = c();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = b();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = e();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = i();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = h();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = h();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = l();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = j();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = n();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = m();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = a();
        continue;
        paramBanner.jdField_a_of_type_AndroidViewView = k();
      }
    }
  }
  
  private void a(Banner paramBanner, Message paramMessage)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.recent.banner", 4, "updateBanner| banner = " + paramBanner + ", msg = " + paramMessage);
    }
    if ((paramBanner == null) || (paramBanner.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    switch (paramBanner.d)
    {
    case 17: 
    case 12: 
    default: 
      return;
    case 1: 
      b(paramBanner.jdField_a_of_type_AndroidViewView);
      return;
    case 2: 
      c(paramBanner.jdField_a_of_type_AndroidViewView);
      return;
    case 4: 
      c(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
      return;
    case 5: 
      a(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
      return;
    case 6: 
      a(paramBanner.jdField_a_of_type_AndroidViewView);
      return;
    case 15: 
      d(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
      return;
    case 7: 
      paramBanner.jdField_a_of_type_AndroidViewView.findViewById(2131232012).setVisibility(0);
      return;
    case 9: 
      paramBanner.jdField_a_of_type_AndroidViewView.findViewById(2131234642).setVisibility(0);
      return;
    case 8: 
      paramBanner.jdField_a_of_type_AndroidViewView.findViewById(2131234642).setVisibility(0);
      return;
    case 11: 
      d(paramBanner.jdField_a_of_type_AndroidViewView);
      return;
    case 10: 
      e(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
      return;
    case 13: 
      paramBanner.jdField_a_of_type_AndroidViewView.findViewById(2131234414).setVisibility(0);
      return;
    case 16: 
      e(paramBanner.jdField_a_of_type_AndroidViewView);
      return;
    case 14: 
      f(paramBanner.jdField_a_of_type_AndroidViewView);
      return;
    }
    b(paramBanner.jdField_a_of_type_AndroidViewView, paramMessage);
  }
  
  private void a(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length < 3)) {}
    for (;;)
    {
      return;
      if ((paramArrayOfInt[1] >= 16) && (paramArrayOfInt[0] >= 1)) {
        switch (paramArrayOfInt[0])
        {
        }
      }
      while ((paramArrayOfInt[2] >= 17) && (paramArrayOfInt[0] >= 1))
      {
        switch (paramArrayOfInt[0])
        {
        case 9: 
        case 10: 
        case 12: 
        case 13: 
        default: 
          return;
        }
        paramArrayOfInt[0] = 0;
        return;
        paramArrayOfInt[0] = 0;
      }
    }
  }
  
  private boolean a(int paramInt, View paramView)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b.a());
    PushBanner localPushBanner = new PushBanner(((Config)localObject1).a(0, paramInt), ((Config)localObject1).c(0, paramInt), ((Config)localObject1).a(0, paramInt));
    String str = ((Config)localObject1).b(0, paramInt);
    localPushBanner.l = str;
    boolean bool = localPushBanner.a(((Config)localObject1).b(0, paramInt));
    if ((localPushBanner.c != null) && (localPushBanner.c.contains("|")) && (!a(Long.parseLong(localPushBanner.c.substring(0, localPushBanner.c.indexOf("|"))), Long.parseLong(localPushBanner.c.substring(localPushBanner.c.indexOf("|") + 1))))) {}
    label482:
    for (;;)
    {
      return false;
      if ((bool) && (!"".equals(localPushBanner.j)))
      {
        localPushBanner.a = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localPushBanner.j);
        if (localPushBanner.a == null) {}
        for (int i1 = 0;; i1 = 1)
        {
          if (i1 == 0) {
            break label482;
          }
          Object localObject2 = ((Config)localObject1).a(0, paramInt);
          if (QLog.isDevelopLevel()) {
            QLog.i("PUSH BANNER", 4, "addPushBanner, bannerPic = " + localObject2);
          }
          if (localObject2 == null) {
            break;
          }
          localObject1 = (FrameLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2130903327, null);
          ImageView localImageView = (ImageView)((FrameLayout)localObject1).findViewById(2131232090);
          localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
          localImageView.setImageBitmap((Bitmap)localObject2);
          DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics();
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localImageView.getLayoutParams();
          i1 = ((Bitmap)localObject2).getHeight() * Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) / ((Bitmap)localObject2).getWidth();
          localLayoutParams.height = Math.max((int)(30.0F * localDisplayMetrics.density), Math.min(Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) * 68 / 320, i1));
          localImageView.setLayoutParams(localLayoutParams);
          localObject2 = (ImageView)((FrameLayout)localObject1).findViewById(2131232091);
          ((ImageView)localObject2).setTag(localPushBanner);
          ((ImageView)localObject2).setContentDescription("图片推广位");
          ((ImageView)localObject2).setOnClickListener(new eoe(this, paramView, paramInt, (FrameLayout)localObject1, str));
          ((FrameLayout)localObject1).setTag(localPushBanner);
          ((ADView)paramView.findViewById(2131232087)).a((View)localObject1, paramInt);
          return true;
        }
      }
    }
  }
  
  static boolean a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramLong2 == 0L)) {}
    long l1;
    do
    {
      return false;
      l1 = System.currentTimeMillis();
    } while ((l1 < paramLong1) || (l1 > paramLong2));
    return true;
  }
  
  private boolean a(View paramView)
  {
    int i4 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b.a()).a(0);
    if (i4 > 0)
    {
      ((ADView)paramView.findViewById(2131232087)).a();
      int i1 = 0;
      int i3;
      for (int i2 = 0; i1 < i4; i2 = i3)
      {
        i3 = i2;
        if (a(i1, paramView)) {
          i3 = i2 + 1;
        }
        i1 += 1;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent.banner", 4, "loadPushBanner, addnum = " + i2);
      }
      if (i2 > 0)
      {
        h();
        return true;
      }
    }
    return false;
  }
  
  private View b()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130903292, null);
    ((TextView)localView.findViewById(2131231163)).setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562476));
    localView.setOnClickListener(new eog(this));
    localView.findViewById(2131231162).setVisibility(8);
    return localView;
  }
  
  private void b(View paramView)
  {
    paramView.findViewById(2131231162).setVisibility(0);
    ((TextView)paramView.findViewById(2131231163)).setText(2131562476);
    if (a(7))
    {
      a(7, 0);
      this.e = null;
    }
  }
  
  private void b(View paramView, Message paramMessage)
  {
    paramMessage = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b.getManager(36);
    if (paramMessage != null) {}
    for (int i1 = paramMessage.a();; i1 = 0)
    {
      if (i1 == 0) {}
      do
      {
        return;
        paramView.findViewById(2131232885).setVisibility(0);
        ((TextView)paramView.findViewById(2131232886)).setText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131563266), new Object[] { Integer.valueOf(i1) }));
      } while (i1 > 0);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
      return;
    }
  }
  
  private boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getConfiguration().orientation == 1;
  }
  
  private View c()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130903292, null);
    ((TextView)localView.findViewById(2131231163)).setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562440));
    localView.findViewById(2131231162).setVisibility(8);
    return localView;
  }
  
  private void c(View paramView)
  {
    paramView.findViewById(2131231162).setVisibility(0);
  }
  
  private void c(View paramView, Message paramMessage)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131232803);
    if (paramMessage != null)
    {
      if (paramMessage.arg1 != 1) {
        break label42;
      }
      localTextView.setText(2131558533);
    }
    for (;;)
    {
      paramView.findViewById(2131232802).setVisibility(0);
      return;
      label42:
      if (paramMessage.arg2 == 2) {
        localTextView.setText(2131558532);
      }
    }
  }
  
  private boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("mobileQQi", 0).getBoolean("push_banner_display" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b.getAccount(), true);
  }
  
  private View d()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130903547, null);
    ((TextView)localView.findViewById(2131232886)).setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131563266));
    localView.setOnClickListener(new eoh(this));
    localView.findViewById(2131232885).setVisibility(8);
    return localView;
  }
  
  private void d(View paramView)
  {
    paramView.findViewById(2131231445).setVisibility(0);
    if (this.c)
    {
      TroopAssistantManager.a().i(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b, "P_CliOper", "Grp_msg", "", "Msglist", "exp_setmsg", 0, 0, "", "", "", "");
    }
    this.c = false;
    this.jdField_d_of_type_Boolean = true;
  }
  
  private void d(View paramView, Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.what == 8)) {
      if ((paramMessage.obj instanceof VipBannerInfo))
      {
        paramMessage = (VipBannerInfo)paramMessage.obj;
        localObject = paramMessage.b;
        ((TextView)paramView.findViewById(2131233445)).setText((CharSequence)localObject);
        localObject = (Button)paramView.findViewById(2131233446);
        localAppInfo = paramMessage.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
        localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b.getManager(34);
        if ((paramMessage.jdField_a_of_type_JavaLangString != null) && (localAppInfo != null) && (localRedTouchManager != null))
        {
          ((Button)localObject).setOnClickListener(new eok(this, paramMessage, localRedTouchManager, localAppInfo));
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(9, paramMessage.jdField_a_of_type_Long);
          localRedTouchManager.a(localAppInfo, paramMessage.jdField_a_of_type_JavaLangString);
          paramView.setVisibility(0);
        }
      }
    }
    while (paramView.getVisibility() != 8)
    {
      Object localObject;
      BusinessInfoCheckUpdate.AppInfo localAppInfo;
      RedTouchManager localRedTouchManager;
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
    VipBannerInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  private View e()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130903694, null);
    localView.setVisibility(8);
    return localView;
  }
  
  private void e(View paramView)
  {
    if (QQPlayerService.a())
    {
      paramView.findViewById(2131231943).setVisibility(0);
      paramView = (TextView)paramView.findViewById(2131231945);
      SongInfo localSongInfo = QQPlayerService.a();
      if (localSongInfo != null)
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562619);
        paramView.setText(Html.fromHtml(str + " " + localSongInfo.b));
      }
      return;
    }
    paramView.findViewById(2131231943).setVisibility(8);
  }
  
  private void e(View paramView, Message paramMessage)
  {
    paramView.findViewById(2131234642).setVisibility(0);
    TextView localTextView = (TextView)paramView.findViewById(2131232619);
    if (paramMessage != null)
    {
      if (!ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b))
      {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext().getString(2131558997);
        UpgradeDetailWrapper localUpgradeDetailWrapper = UpgradeController.a().a();
        paramView = paramMessage;
        if (localUpgradeDetailWrapper != null)
        {
          paramView = paramMessage;
          if (localUpgradeDetailWrapper.a != null)
          {
            paramView = paramMessage;
            if (localUpgradeDetailWrapper.a.jdField_a_of_type_JavaLangString != null) {
              paramView = localUpgradeDetailWrapper.a.jdField_a_of_type_JavaLangString + " ";
            }
          }
        }
        localTextView.setText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext().getString(2131558998), new Object[] { paramView }));
      }
    }
    else {
      return;
    }
    localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext().getString(2131558999));
  }
  
  private View f()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130903553, null);
    ((TextView)localView.findViewById(2131231163)).setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131563345));
    localView.setOnClickListener(new eoi(this));
    localView.findViewById(2131231162).setVisibility(8);
    return localView;
  }
  
  private void f(View paramView)
  {
    paramView.findViewById(2131232086).setVisibility(0);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131232085);
    paramView = (ADView)paramView.findViewById(2131232087);
    if (b())
    {
      localRelativeLayout.setPadding(0, 0, 0, 0);
      paramView.b();
      return;
    }
    localRelativeLayout.setPadding(0, -1, 0, 0);
  }
  
  private View g()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130903527, null);
    localView.findViewById(2131232803).setOnClickListener(new eoj(this));
    localView.findViewById(2131232802).setVisibility(8);
    return localView;
  }
  
  private View h()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130904044, null);
    TextView localTextView = (TextView)localView.findViewById(2131232619);
    localTextView.setOnClickListener(new eol(this));
    localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131562462));
    ((ImageView)localView.findViewById(2131234643)).setOnClickListener(new eom(this));
    localView.findViewById(2131234642).setVisibility(8);
    return localView;
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    long l1 = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, 1);
    localCalendar.set(11, 0);
    localCalendar.clear(12);
    localCalendar.clear(13);
    localCalendar.clear(14);
    l1 = localCalendar.getTimeInMillis() - (l1 - 10L) + 300000L;
    if (QLog.isColorLevel()) {
      QLog.d("PushBanner", 2, "Check banner delay: " + l1);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, l1);
  }
  
  private View i()
  {
    View localView1 = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130903299, null);
    View localView2 = localView1.findViewById(2131232013);
    View localView3 = localView1.findViewById(2131232014);
    enw localenw = new enw(this);
    localView2.setOnClickListener(localenw);
    localView3.setOnClickListener(localenw);
    localView1.findViewById(2131232012).setVisibility(8);
    return localView1;
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ArrayOfInt == null) {}
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < 3)
      {
        Banner localBanner = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[this.jdField_a_of_type_ArrayOfInt[i1]];
        if ((localBanner != null) && (localBanner.jdField_a_of_type_AndroidViewView != null) && (localBanner.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentWidgetXListView.a(localBanner.jdField_a_of_type_AndroidViewView);
          localBanner.jdField_a_of_type_Boolean = false;
          if (!localBanner.a()) {
            localBanner.jdField_a_of_type_AndroidViewView = null;
          }
        }
        i1 += 1;
      }
    }
  }
  
  private View j()
  {
    View localView1 = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130903157, null);
    View localView2 = localView1.findViewById(2131231445);
    localView1.setOnClickListener(new enx(this));
    localView2.setVisibility(8);
    return localView1;
  }
  
  private View k()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130903287, null);
    localView.setOnClickListener(new eny(this));
    localView.findViewById(2131231943).setVisibility(8);
    return localView;
  }
  
  private View l()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130904044, null);
    TextView localTextView = (TextView)localView.findViewById(2131232619);
    localTextView.setOnClickListener(new enz(this));
    localTextView.setText("");
    localTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131561496));
    ((ImageView)localView.findViewById(2131234643)).setOnClickListener(new eoa(this));
    localView.findViewById(2131234642).setVisibility(8);
    return localView;
  }
  
  private View m()
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130903156, null);
    localView.setOnClickListener(new eob(this));
    return localView;
  }
  
  private View n()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2130903326, null);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    localView.findViewById(2131232086).setVisibility(8);
    ((LinearLayout)localView.findViewById(2131232088)).setOnClickListener(new eod(this));
    return localView;
  }
  
  public int a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner.length) {
        localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[paramInt];
      }
    }
    if (localObject1 == null) {
      return 0;
    }
    return ((Banner)localObject1).e;
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b.d())
      {
        a(2, 2);
        a(null);
      }
    }
    else {
      return;
    }
    a(2, 0);
    a(null);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 1) && (paramInt1 <= 17))
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[paramInt1] == null) {
        break label31;
      }
      this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[paramInt1].e = paramInt2;
    }
    label31:
    while ((this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[paramInt1] != null) || (!Banner.a(paramInt2))) {
      return;
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[paramInt1] = new Banner(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    localMessage.obj = paramObject;
    if (paramLong > 0L)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(Message paramMessage)
  {
    int i2 = 1;
    int i5 = 0;
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.recent.banner", 4, "refreshBanner");
    }
    if (this.jdField_b_of_type_ArrayOfInt == null) {
      this.jdField_b_of_type_ArrayOfInt = new int[3];
    }
    int i1 = 0;
    while (i1 < 3)
    {
      this.jdField_b_of_type_ArrayOfInt[i1] = 0;
      i1 += 1;
    }
    if (this.jdField_a_of_type_ArrayOfInt == null) {
      this.jdField_a_of_type_ArrayOfInt = new int[3];
    }
    i1 = 1;
    if (i1 <= 15)
    {
      if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[i1] != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[i1].a())) {
        this.jdField_b_of_type_ArrayOfInt[0] = i1;
      }
    }
    else
    {
      i1 = 16;
      label108:
      if (i1 <= 16)
      {
        if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[i1] == null) || (!this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[i1].a())) {
          break label253;
        }
        this.jdField_b_of_type_ArrayOfInt[1] = i1;
      }
      i1 = 17;
    }
    int i3;
    int i4;
    for (;;)
    {
      if (i1 <= 17)
      {
        if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[i1] != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[i1].a())) {
          this.jdField_b_of_type_ArrayOfInt[2] = i1;
        }
      }
      else
      {
        a(this.jdField_b_of_type_ArrayOfInt);
        i1 = 0;
        i3 = 0;
        i4 = 0;
        while (i1 < 3)
        {
          i4 += this.jdField_b_of_type_ArrayOfInt[i1];
          i3 += this.jdField_a_of_type_ArrayOfInt[i1];
          if (this.jdField_b_of_type_ArrayOfInt[i1] != this.jdField_a_of_type_ArrayOfInt[i1]) {
            i2 = 0;
          }
          i1 += 1;
        }
        i1 += 1;
        break;
        label253:
        i1 += 1;
        break label108;
      }
      i1 += 1;
    }
    if ((i4 == 0) && (i3 == 0)) {
      return;
    }
    if ((i4 == 0) && (i3 != 0))
    {
      i();
      return;
    }
    i1 = i5;
    if (i2 == 0)
    {
      i();
      i2 = 0;
      for (;;)
      {
        i1 = i5;
        if (i2 >= 3) {
          break;
        }
        this.jdField_a_of_type_ArrayOfInt[i2] = this.jdField_b_of_type_ArrayOfInt[i2];
        i2 += 1;
      }
    }
    label333:
    Banner localBanner;
    if (i1 < 3)
    {
      localBanner = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[this.jdField_a_of_type_ArrayOfInt[i1]];
      if (localBanner != null) {
        break label363;
      }
    }
    for (;;)
    {
      i1 += 1;
      break label333;
      break;
      label363:
      a(localBanner);
      try
      {
        if ((localBanner.jdField_a_of_type_AndroidViewView != null) && (!localBanner.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentWidgetXListView.a(localBanner.jdField_a_of_type_AndroidViewView);
          localBanner.jdField_a_of_type_Boolean = true;
        }
        a(localBanner, paramMessage);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.recent.banner", 4, "initBanner|" + localException.toString());
          }
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if ((a(11)) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramString)) && (this.jdField_f_of_type_JavaLangString.equals(paramString)))
    {
      this.jdField_f_of_type_JavaLangString = "";
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
    }
  }
  
  public boolean a()
  {
    boolean bool = true;
    if (this.jdField_b_of_type_Boolean) {}
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent.banner", 4, "isNeedShowPushBanner, isNeedShow = " + bool);
      }
      return bool;
      if (c())
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[14] == null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[14] = new Banner(14, 0);
        }
        a(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[14]);
        View localView = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[14].jdField_a_of_type_AndroidViewView;
        if (localView != null) {}
        for (bool = a(localView);; bool = false)
        {
          if (bool)
          {
            localView.findViewById(2131232086).setVisibility(0);
            this.jdField_b_of_type_Boolean = true;
          }
          break;
        }
      }
      bool = false;
    }
  }
  
  public boolean a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner.length) {
        localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[paramInt];
      }
    }
    return (localObject1 != null) && (((Banner)localObject1).a());
  }
  
  public void b()
  {
    if (a(7))
    {
      a(7, 0);
      this.e = null;
      a(null);
    }
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[14];
    ViewGroup localViewGroup;
    int i2;
    int i1;
    if ((localObject != null) && (((Banner)localObject).jdField_a_of_type_AndroidViewView != null))
    {
      localObject = (ADView)((Banner)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131232087);
      localViewGroup = ((ADView)localObject).a(0);
      if (localViewGroup != null)
      {
        i2 = localViewGroup.getChildCount();
        i1 = 0;
        i2 -= 1;
        if (i2 >= 0)
        {
          View localView = localViewGroup.getChildAt(i2);
          PushBanner localPushBanner = (PushBanner)localView.getTag();
          String str = localPushBanner.c;
          int i3 = str.indexOf("|");
          if (a(Long.parseLong(str.substring(0, i3)), Long.parseLong(str.substring(i3 + 1)))) {
            break label295;
          }
          ((ADView)localObject).a(0, i2, localView);
          Config.a.b(localPushBanner.l);
          i1 = 1;
        }
      }
    }
    label295:
    for (;;)
    {
      i2 -= 1;
      break;
      if (i1 != 0)
      {
        if (localViewGroup.getChildCount() == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("mobileQQi", 0).edit().putBoolean("push_banner_display" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime().getAccount(), false).commit();
          ((ADView)localObject).a();
          a(14, 0);
          a(null);
          this.jdField_b_of_type_Boolean = false;
        }
        for (;;)
        {
          localObject = new ConfigManager(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), ConfigServlet.jdField_d_of_type_JavaLangString);
          if (localObject != null)
          {
            ((ConfigManager)localObject).b();
            ((ConfigManager)localObject).c();
          }
          return;
          h();
        }
      }
      h();
      return;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    a(8, 0);
    a(10, 0);
    Object localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityRecentBanner[14];
    if ((localObject != null) && (((Banner)localObject).jdField_a_of_type_AndroidViewView != null))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)((Banner)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131232085);
      localObject = (ADView)((Banner)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131232087);
      if (localObject != null)
      {
        ((ADView)localObject).c();
        ((ADView)localObject).a();
      }
      if (localRelativeLayout != null) {
        localRelativeLayout.setPadding(0, -1, 0, 0);
      }
    }
    this.jdField_b_of_type_Boolean = false;
    b();
    a(11, 0);
    this.c = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_f_of_type_JavaLangString = "";
    a(12, 0);
    a(15, 0);
    a();
    f();
    a(null);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "checkIsShowTroopTip");
    }
    QQAppInterface localQQAppInterface;
    FriendManager localFriendManager;
    List localList;
    int i1;
    label81:
    int i2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b;
      if ((localQQAppInterface != null) && ((TroopAssistantManager.a().e(localQQAppInterface)) || (this.jdField_d_of_type_Boolean)))
      {
        localFriendManager = (FriendManager)localQQAppInterface.getManager(8);
        localList = localQQAppInterface.a().a().a();
        if (localList != null) {
          break label130;
        }
        i1 = 0;
        i2 = 0;
        label83:
        if (i2 >= i1) {
          break label148;
        }
        if (((RecentUser)localList.get(i2)).type != 5000) {
          break label141;
        }
        if (this.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        }
      }
    }
    label130:
    label141:
    label148:
    do
    {
      return;
      localQQAppInterface = null;
      break;
      i1 = localList.size();
      break label81;
      i2 += 1;
      break label83;
      i2 = 0;
      if (i2 < i1)
      {
        RecentUser localRecentUser = (RecentUser)localList.get(i2);
        if (localRecentUser.type != 1) {}
        do
        {
          do
          {
            i2 += 1;
            break;
          } while ((TextUtils.isEmpty(localRecentUser.uin)) || (localFriendManager.f(localRecentUser.uin)) || (TroopAssistantManager.a().b(localQQAppInterface, localRecentUser.uin)) || (TroopAssistantManager.a().a(localQQAppInterface, localRecentUser.uin) != 1));
          if (localQQAppInterface.a().a(localRecentUser.uin, localRecentUser.type) > 99)
          {
            if ((this.jdField_d_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && (this.jdField_f_of_type_JavaLangString.equals(localRecentUser.uin))) {
              break;
            }
            this.jdField_f_of_type_JavaLangString = localRecentUser.uin;
            if ((!this.c) || (!TroopAssistantManager.a().e(localQQAppInterface))) {
              break;
            }
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
            return;
          }
        } while ((TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) || (!this.jdField_f_of_type_JavaLangString.equals(localRecentUser.uin)));
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        return;
      }
    } while ((!this.jdField_d_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void f()
  {
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      QCallFacade localQCallFacade = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b.getManager(36);
      if (localQCallFacade != null)
      {
        i1 = localQCallFacade.a();
        if (i1 <= 0) {
          break label92;
        }
        if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(6)) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(6, 0L);
        }
      }
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.recent.banner", 4, "checkShowMissedCall。 count=" + i1);
      }
      return;
      label92:
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, 0L);
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, 0L);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      a(11, 2);
      a(paramMessage);
      continue;
      a(11, 0);
      this.jdField_f_of_type_JavaLangString = "";
      a(paramMessage);
      continue;
      a(12, 0);
      a(paramMessage);
      continue;
      a(3, 2);
      a(paramMessage);
      continue;
      a(3, 0);
      a(paramMessage);
      continue;
      a(15, 2);
      a(paramMessage);
      continue;
      a(15, 0);
      a(paramMessage);
      continue;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("PushBanner", 2, "checkAndClosePushBanner");
        }
        c();
      }
      catch (Exception paramMessage) {}
      if (QLog.isColorLevel()) {
        QLog.d("PushBanner", 2, "checkAndClosePushBanner Exception:", paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.BannerManager
 * JD-Core Version:    0.7.0.1
 */