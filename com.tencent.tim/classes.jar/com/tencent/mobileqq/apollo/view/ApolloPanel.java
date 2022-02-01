package com.tencent.mobileqq.apollo.view;

import abhe;
import abhh;
import abhh.c;
import abhh.d;
import abhh.e;
import abhs;
import abhs.a;
import abkf;
import abtn;
import abxi;
import abxk;
import abyz;
import abza;
import abzc;
import abzg;
import abzq;
import abzy;
import acad;
import acae;
import acah;
import acai;
import acaj;
import acak;
import acal;
import acam;
import acan;
import acao;
import acap;
import acaq;
import acar;
import acas;
import acat;
import acau;
import acav;
import acaw;
import acay;
import acaz;
import acba;
import acbf;
import acbf.a;
import acbg;
import acfp;
import ahbj;
import altq;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqgz;
import aqha;
import aqiw;
import aqiz;
import aqju;
import aqmq;
import aqqi;
import aqrb;
import aquy;
import ascd;
import asce.a;
import aurf;
import auvw;
import auvw.a;
import auvw.b;
import avqy;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.data.ApolloActionPackageData;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ApolloKapuEntranceTips;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.HorizontalListView;
import cooperation.wadl.ipc.WadlResult;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import wja;
import xxh;

public class ApolloPanel
  extends RelativeLayout
  implements abza, Handler.Callback, ViewPager.OnPageChangeListener, View.OnClickListener, AdapterView.OnItemClickListener
{
  private static final String DOWNLOAD_PATH = abxi.bim + "/cmshow.apk";
  private static final String bkn = DOWNLOAD_PATH + ".temp";
  public static int cuh;
  RedTouch H;
  public TextView Qq;
  public TextView Qr;
  private abhh.c jdField_a_of_type_Abhh$c = new acav(this);
  private abhh.e jdField_a_of_type_Abhh$e;
  public abhs.a a;
  abyz jdField_a_of_type_Abyz = new acah(this);
  public acae a;
  acbf jdField_a_of_type_Acbf;
  private KapuPkgStateReceiver jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$KapuPkgStateReceiver;
  public a a;
  private d jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$d = new acat(this);
  ApolloPanelAdapter jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter;
  private ApolloPanelGuideView jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView;
  URLImageView aR;
  private URLImageView aS;
  private URLImageView aT;
  aqju ah = null;
  private abhs jdField_b_of_type_Abhs;
  private d jdField_b_of_type_ComTencentMobileqqApolloViewApolloPanel$d = new acau(this);
  EmoticonPagerRadioGroup jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup;
  QQViewPager jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager;
  private int bEw = -1;
  private int bEy = -1;
  private boolean bGA;
  private boolean bGB;
  private boolean bGC;
  private boolean bGD;
  private boolean bGE;
  private boolean bGF;
  private boolean bGG = true;
  private boolean bGH;
  private boolean bGI;
  private boolean bGJ;
  private volatile boolean bGz;
  private int bTJ = -1;
  private boolean biP;
  private FrameLayout bs;
  private FrameLayout bt;
  abzq jdField_c_of_type_Abzq;
  private d jdField_c_of_type_ComTencentMobileqqApolloViewApolloPanel$d = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$d;
  int cui = 0;
  private int cuj = -1;
  private int cuk = -1;
  int cul = 0;
  public int cum = 1;
  private int cun = -1;
  AtomicBoolean cy = new AtomicBoolean(false);
  public auvw d;
  private DrawerPushItem d;
  private StateListDrawable jdField_e_of_type_AndroidGraphicsDrawableStateListDrawable;
  private Deque<c> jdField_e_of_type_JavaUtilDeque;
  private Drawable ex;
  private Runnable fH = new ApolloPanel.24(this);
  public SessionInfo g;
  LinearLayout il;
  public LinearLayout im;
  private RelativeLayout jA;
  RelativeLayout jx;
  RelativeLayout jy;
  public RelativeLayout jz;
  private DiniFlyAnimationView m;
  public BaseChatPie mBaseChatPie;
  private boolean mIsDownloading;
  private boolean mIsVisible;
  ImageView mLoadingView;
  private final MqqHandler q = new aurf(Looper.getMainLooper(), this, true);
  HorizontalListView r;
  private BusinessInfoCheckUpdate.AppInfo s;
  public DialogInterface.OnClickListener w = new acai(this);
  public List<acbg> wW = new CopyOnWriteArrayList();
  List<Integer> wX = new ArrayList();
  public List<Integer> wY = new ArrayList();
  private ImageView yb;
  
  public ApolloPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Abhs$a = new acaj(this);
  }
  
  public ApolloPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Abhs$a = new acaj(this);
  }
  
  private int Ag()
  {
    if (this.mBaseChatPie != null) {
      return ApolloGameUtil.x(this.mBaseChatPie.app);
    }
    return 0;
  }
  
  private void Dl(String paramString)
  {
    if ((this.mBaseChatPie == null) || (this.mBaseChatPie.app == null)) {
      return;
    }
    this.mBaseChatPie.app.getApp().getSharedPreferences("apollo_sp" + this.mBaseChatPie.app.getCurrentUin(), 0).edit().putInt(paramString, 1).apply();
  }
  
  private void Iv(int paramInt)
  {
    if ((this.mBaseChatPie == null) || (this.mBaseChatPie.app == null)) {
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqApolloViewApolloPanel$d.Iv(paramInt);
  }
  
  private void Iy(int paramInt)
  {
    if ((this.mBaseChatPie == null) || (this.mBaseChatPie.app == null)) {
      return;
    }
    int j = Ag();
    int i = j;
    if (paramInt != 0)
    {
      i = j;
      if (paramInt != j) {
        i = paramInt;
      }
    }
    paramInt = i;
    if (i == 2)
    {
      paramInt = i;
      if (!ZD()) {
        paramInt = 1;
      }
    }
    Iz(paramInt);
  }
  
  private void Iz(int paramInt)
  {
    if ((this.cum != paramInt) && (QLog.isColorLevel())) {
      QLog.d("ApolloPanel", 2, new Object[] { "setCurrentPanelType targetPanelType=", Integer.valueOf(paramInt) });
    }
    this.cum = paramInt;
    if (this.cum == 2)
    {
      this.jdField_c_of_type_ComTencentMobileqqApolloViewApolloPanel$d = this.jdField_b_of_type_ComTencentMobileqqApolloViewApolloPanel$d;
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqApolloViewApolloPanel$d = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$d;
  }
  
  private boolean ZD()
  {
    if (this.mBaseChatPie != null) {
      return abhh.R(this.mBaseChatPie.app);
    }
    return false;
  }
  
  private Drawable a(ApolloActionData paramApolloActionData)
  {
    Object localObject5 = null;
    Object localObject4;
    if (paramApolloActionData == null) {
      localObject4 = null;
    }
    label100:
    do
    {
      Resources localResources;
      do
      {
        return localObject4;
        localResources = super.getResources();
        try
        {
          localObject1 = localResources.getDrawable(2130838097);
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            Drawable localDrawable;
            String str;
            localObject1 = null;
            QLog.e("ApolloPanel", 1, "[getNewActionStaticDrawable] exception=", localException1);
            Object localObject2 = null;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          for (;;)
          {
            Object localObject1 = null;
            QLog.e("ApolloPanel", 1, "[getNewActionStaticDrawable] error=", localOutOfMemoryError1);
            Object localObject3 = null;
          }
        }
        for (;;)
        {
          try
          {
            localDrawable = localResources.getDrawable(2130844558);
            localObject4 = localObject1;
            if (paramApolloActionData.status == 0) {
              break;
            }
            str = Integer.toString(1);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            break label228;
          }
          catch (Exception localException2)
          {
            break label209;
          }
          try
          {
            localObject4 = new URL("apollo_pic", null, paramApolloActionData.actionId + "_" + paramApolloActionData.actionName);
            localObject5 = localObject4;
          }
          catch (MalformedURLException localMalformedURLException)
          {
            QLog.e("ApolloPanel", 1, new Object[] { "[getNewActionStaticDrawable] get url exception=", null });
            break label100;
          }
        }
        localObject4 = localObject1;
      } while (localObject5 == null);
      localObject4 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = wja.dp2px(90.0F, localResources);
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight;
      ((URLDrawable.URLDrawableOptions)localObject4).mPlayGifImage = false;
      localObject1 = URLDrawable.getDrawable(localObject5, (URLDrawable.URLDrawableOptions)localObject4);
      localObject4 = localObject1;
    } while (((URLDrawable)localObject1).getStatus() == 1);
    ((URLDrawable)localObject1).setTag(paramApolloActionData);
    ((URLDrawable)localObject1).addHeader("apollo_uin", this.mBaseChatPie.app.getCurrentUin());
    ((URLDrawable)localObject1).addHeader("apollo_tasks", str);
    return localObject1;
  }
  
  private void a(View paramView, int paramInt1, String paramString, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if ((this.mBaseChatPie == null) || (this.mBaseChatPie.app == null) || (paramView == null) || (paramString == null)) {}
    do
    {
      do
      {
        return;
        if (this.jdField_d_of_type_Auvw != null)
        {
          if (this.jdField_e_of_type_JavaUtilDeque == null) {
            this.jdField_e_of_type_JavaUtilDeque = new LinkedList();
          }
          this.jdField_e_of_type_JavaUtilDeque.addLast(new c(paramView, paramInt1, paramString, paramInt2, paramOnClickListener));
          return;
        }
        paramString = auvw.a(this.mBaseChatPie.mActivity).b(paramInt2).a(paramString).a(16.0F).a(-1);
        paramString.c(paramInt1);
        paramString = new auvw.b(paramString).b(Color.argb(255, 0, 0, 0)).a(5).a();
      } while (paramString == null);
      this.jdField_d_of_type_Auvw = paramString.a();
    } while (this.jdField_d_of_type_Auvw == null);
    this.jdField_d_of_type_Auvw.setAlignMode(82);
    this.jdField_d_of_type_Auvw.abr(2);
    this.jdField_d_of_type_Auvw.jb(paramView);
    this.jdField_d_of_type_Auvw.setOnClickListener(paramOnClickListener);
    this.jdField_d_of_type_Auvw.setOnDismissListener(new acay(this));
  }
  
  private void a(ApolloActionData paramApolloActionData, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[realshowNewActionFloatView] actionInfo=", paramApolloActionData, ", btnType=", Integer.valueOf(paramInt1), ", extraWordingType=", Integer.valueOf(paramInt2), ", pkgId=", Integer.valueOf(paramInt3), ", extra=", paramBundle });
    }
    if ((this.mBaseChatPie == null) || (this.mBaseChatPie.app == null) || (paramApolloActionData == null)) {
      return;
    }
    Object localObject3 = this.mBaseChatPie.app.getApp().getSharedPreferences("apollo_sp" + this.mBaseChatPie.app.getCurrentUin(), 0);
    Object localObject4 = String.format("key_new_action_info_%s", new Object[] { String.valueOf(paramInt3) });
    Object localObject5 = ((SharedPreferences)localObject3).getString((String)localObject4, "");
    int i = 0;
    paramInt3 = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    String str = String.format("{\"operateObjectID\":%d}", new Object[] { Integer.valueOf(paramApolloActionData.actionId) });
    if (!TextUtils.isEmpty((CharSequence)localObject5))
    {
      paramInt3 = i;
      localObject1 = localObject2;
      try
      {
        localObject5 = new JSONObject((String)localObject5);
        paramInt3 = i;
        localObject1 = localObject2;
        i = ((JSONObject)localObject5).getInt("adId");
        paramInt3 = i;
        localObject1 = localObject2;
        localObject2 = ((JSONObject)localObject5).getString("traceInfo");
        paramInt3 = i;
        localObject1 = localObject2;
        abhh.g(101, String.valueOf(i), (String)localObject2, str);
        paramInt3 = i;
        localObject1 = localObject2;
        ((SharedPreferences)localObject3).edit().remove((String)localObject4).commit();
        localObject1 = localObject2;
        paramInt3 = i;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          label339:
          QLog.e("ApolloPanel", 1, "realshowNewActionFloatView Exception:", localThrowable);
        }
      }
      this.jA = ((RelativeLayout)LayoutInflater.from(super.getContext()).inflate(2131558720, null));
      this.jA.setId(2131362811);
      ((ImageView)this.jA.findViewById(2131368994)).setOnClickListener(this);
      localObject4 = super.getResources();
      localObject3 = (ImageView)this.jA.findViewById(2131368982);
      localObject2 = new acad(this.mBaseChatPie.app.getCurrentUin());
      ((acad)localObject2).c = paramApolloActionData;
      ((ImageView)localObject3).setImageDrawable(a(paramApolloActionData));
      ((TextView)this.jA.findViewById(2131381061)).setText(paramApolloActionData.actionName);
      ((TextView)this.jA.findViewById(2131381060)).setText(paramApolloActionData.description);
      ((Button)this.jA.findViewById(2131363940)).setOnClickListener(new acal(this, paramApolloActionData, paramInt3, localObject1, str));
      localObject3 = (Button)this.jA.findViewById(2131363765);
      i = super.getHeight() - this.r.getHeight();
      if (i < wja.dp2px(213.0F, (Resources)localObject4))
      {
        localObject5 = (LinearLayout)this.jA.findViewById(2131365337);
        i = i - (int)((Resources)localObject4).getDimension(2131296524) - (int)((Resources)localObject4).getDimension(2131296525);
        ((RelativeLayout.LayoutParams)((LinearLayout)localObject5).getLayoutParams()).bottomMargin = ((int)(i * 0.1D));
        ((RelativeLayout.LayoutParams)((RelativeLayout)this.jA.findViewById(2131365332)).getLayoutParams()).bottomMargin = ((int)(i * 0.2D));
      }
      localObject4 = (ImageView)this.jA.findViewById(2131368716);
      localObject5 = (TextView)this.jA.findViewById(2131381082);
      ((TextView)localObject5).setMaxLines(1);
      switch (paramInt2)
      {
      case 24: 
      case 26: 
      default: 
        label736:
        switch (paramInt1)
        {
        }
        break;
      }
    }
    for (;;)
    {
      paramBundle = new RelativeLayout.LayoutParams(-1, -1);
      paramBundle.addRule(2, 2131362825);
      addView(this.jA, paramBundle);
      paramBundle = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
      paramBundle.setDuration(500L);
      paramBundle.setRepeatCount(0);
      paramBundle.setInterpolator(new AccelerateDecelerateInterpolator());
      this.jA.startAnimation(paramBundle);
      this.bGG = false;
      if (this.g == null) {
        break;
      }
      VipUtils.a(this.mBaseChatPie.app, "cmshow", "Apollo", "action_flame_view", ApolloUtil.gi(this.g.cZ), 0, new String[] { String.valueOf(paramApolloActionData.actionId) });
      return;
      QLog.e("ApolloPanel", 1, "realshowNewActionFloatView no tianshu action data");
      break label339;
      ((ImageView)localObject4).setVisibility(8);
      ((TextView)localObject5).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject5).setText(acfp.m(2131702621));
      break label736;
      ((ImageView)localObject4).setVisibility(8);
      ((TextView)localObject5).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject5).setText(acfp.m(2131702611));
      break label736;
      ((ImageView)localObject4).setVisibility(0);
      ((ImageView)localObject4).setImageResource(2130838640);
      ((TextView)localObject5).setTextColor(Color.parseColor("#FFFF8444"));
      ((TextView)localObject5).setText(paramApolloActionData.extraWording);
      break label736;
      ((ImageView)localObject4).setVisibility(0);
      ((ImageView)localObject4).setImageResource(2130838641);
      ((TextView)localObject5).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject5).setText(acfp.m(2131702613));
      localObject4 = (TextView)this.jA.findViewById(2131381070);
      ((TextView)localObject4).setVisibility(0);
      ((TextView)localObject4).setText(String.valueOf(paramApolloActionData.currencyNum));
      break label736;
      ((ImageView)localObject4).setVisibility(0);
      ((ImageView)localObject4).setImageResource(2130838642);
      ((TextView)localObject5).setVisibility(0);
      ((TextView)localObject5).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject5).setText(acfp.m(2131702622));
      break label736;
      ((ImageView)localObject4).setVisibility(0);
      ((ImageView)localObject4).setImageResource(2130838663);
      ((TextView)localObject5).setVisibility(0);
      ((TextView)localObject5).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject5).setText(super.getResources().getString(2131690342));
      break label736;
      ((ImageView)localObject4).setVisibility(0);
      ((ImageView)localObject4).setImageResource(2130838663);
      ((TextView)localObject5).setVisibility(0);
      ((TextView)localObject5).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject5).setText(super.getResources().getString(2131690342));
      break label736;
      ((ImageView)localObject4).setVisibility(0);
      ((ImageView)localObject4).setImageResource(2130838661);
      ((TextView)localObject5).setVisibility(0);
      ((TextView)localObject5).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject5).setMaxLines(2);
      ((TextView)localObject5).setText(super.getResources().getString(2131690374));
      break label736;
      ((Button)localObject3).setText(acfp.m(2131702616));
      ((Button)localObject3).setOnClickListener(new acam(this, localThrowable, paramApolloActionData, paramInt3, localObject1, str));
      continue;
      ((Button)localObject3).setText(acfp.m(2131702626));
      ((Button)localObject3).setOnClickListener(new acan(this, paramBundle, paramApolloActionData, paramInt3, localObject1, str));
      continue;
      ((Button)localObject3).setText(acfp.m(2131702615));
      ((Button)localObject3).setOnClickListener(new acao(this, paramApolloActionData, paramBundle, paramInt3, localObject1, str));
      continue;
      ((Button)localObject3).setText(super.getResources().getString(2131690336));
      ((Button)localObject3).setOnClickListener(new acap(this, paramApolloActionData, paramInt3, localObject1, str));
      continue;
      ((Button)localObject3).setText(super.getResources().getString(2131690376));
      ((Button)localObject3).setOnClickListener(new acaq(this, paramApolloActionData, paramInt3, localObject1, str));
    }
  }
  
  private abkf b()
  {
    if ((this.mBaseChatPie == null) || (this.mBaseChatPie.app == null)) {
      return null;
    }
    abhe localabhe = (abhe)this.mBaseChatPie.app.getManager(211);
    abkf localabkf = localabhe.a();
    if (localabkf.gameId != -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, new Object[] { "[checkJumpToGameTab] checkGameTab jumpGameId:", Integer.valueOf(localabkf.gameId), ",from:", Integer.valueOf(localabkf.from), ", mIsGettingUserInfo=", Boolean.valueOf(this.bGz) });
      }
      if (!this.bGz) {
        localabhe.gA(-1, -1);
      }
      return localabkf;
    }
    return null;
  }
  
  private void b(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    ThreadManager.getUIHandler().post(new ApolloPanel.35(this, paramAppInfo, paramString));
  }
  
  private void c(List<acbg> paramList, List<ApolloActionPackage> paramList1, boolean paramBoolean)
  {
    if ((this.mBaseChatPie == null) || (this.mBaseChatPie.app == null) || (paramList == null) || (paramList1 == null)) {
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqApolloViewApolloPanel$d.d(paramList, paramList1, paramBoolean);
  }
  
  private void cGF()
  {
    this.il.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(8);
  }
  
  private void cGH()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "[hideNewActionFloatView]");
    }
    if ((this.jA != null) && (this.jA.getParent() != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "[hideNewActionFloatView] remove");
      }
      super.removeView(this.jA);
      this.jA = null;
    }
    View localView = super.findViewById(2131362811);
    if (localView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "[hideNewActionFloatView] remove by id");
      }
      super.removeView(localView);
    }
  }
  
  private void cGI()
  {
    this.q.removeMessages(2);
    this.q.sendEmptyMessageDelayed(2, 500L);
  }
  
  private void cGJ()
  {
    ThreadManager.getUIHandler().post(new ApolloPanel.36(this));
  }
  
  private void cGK()
  {
    if (getVisibility() == 0)
    {
      if (!this.jdField_a_of_type_Abhh$e.Ym()) {
        break label45;
      }
      QLog.d("ApolloPanel", 2, "showGuidePageFor3D for json");
      this.bGI = true;
      this.jdField_a_of_type_Abhh$e.DD(false);
      cGL();
    }
    label45:
    while (!this.jdField_a_of_type_Abhh$e.Yl()) {
      return;
    }
    QLog.d("ApolloPanel", 2, "showGuidePageFor3D for action");
    this.bGI = true;
    this.jdField_a_of_type_Abhh$e.DC(false);
    cGL();
  }
  
  private void cGM()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.getParent() == this))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "[hideGuidePageFor3D] remove");
      }
      super.removeView(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView = null;
    }
  }
  
  /* Error */
  private void cGO()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 329
    //   5: iconst_1
    //   6: iconst_2
    //   7: anewarray 331	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: ldc_w 1044
    //   15: aastore
    //   16: dup
    //   17: iconst_1
    //   18: aload_0
    //   19: getfield 1046	com/tencent/mobileqq/apollo/view/ApolloPanel:bGE	Z
    //   22: invokestatic 934	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   25: aastore
    //   26: invokestatic 342	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   29: aload_0
    //   30: getfield 1046	com/tencent/mobileqq/apollo/view/ApolloPanel:bGE	Z
    //   33: istore_1
    //   34: iload_1
    //   35: ifeq +6 -> 41
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: aload_0
    //   42: invokespecial 663	android/widget/RelativeLayout:getContext	()Landroid/content/Context;
    //   45: astore_2
    //   46: aload_0
    //   47: aload_2
    //   48: invokestatic 1050	com/tencent/mobileqq/apollo/utils/ApolloUtil:ba	(Landroid/content/Context;)Z
    //   51: putfield 1052	com/tencent/mobileqq/apollo/view/ApolloPanel:bGF	Z
    //   54: aload_0
    //   55: iconst_1
    //   56: putfield 1046	com/tencent/mobileqq/apollo/view/ApolloPanel:bGE	Z
    //   59: aload_0
    //   60: new 16	com/tencent/mobileqq/apollo/view/ApolloPanel$KapuPkgStateReceiver
    //   63: dup
    //   64: aload_0
    //   65: invokespecial 1053	com/tencent/mobileqq/apollo/view/ApolloPanel$KapuPkgStateReceiver:<init>	(Lcom/tencent/mobileqq/apollo/view/ApolloPanel;)V
    //   68: putfield 1055	com/tencent/mobileqq/apollo/view/ApolloPanel:jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$KapuPkgStateReceiver	Lcom/tencent/mobileqq/apollo/view/ApolloPanel$KapuPkgStateReceiver;
    //   71: new 1057	android/content/IntentFilter
    //   74: dup
    //   75: invokespecial 1058	android/content/IntentFilter:<init>	()V
    //   78: astore_3
    //   79: aload_3
    //   80: ldc_w 1060
    //   83: invokevirtual 1063	android/content/IntentFilter:addDataScheme	(Ljava/lang/String;)V
    //   86: aload_3
    //   87: ldc_w 1065
    //   90: invokevirtual 1068	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   93: aload_3
    //   94: ldc_w 1070
    //   97: invokevirtual 1068	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   100: aload_2
    //   101: aload_0
    //   102: getfield 1055	com/tencent/mobileqq/apollo/view/ApolloPanel:jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$KapuPkgStateReceiver	Lcom/tencent/mobileqq/apollo/view/ApolloPanel$KapuPkgStateReceiver;
    //   105: aload_3
    //   106: invokevirtual 1076	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   109: pop
    //   110: goto -72 -> 38
    //   113: astore_2
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_2
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	ApolloPanel
    //   33	2	1	bool	boolean
    //   45	56	2	localContext	Context
    //   113	4	2	localObject	Object
    //   78	28	3	localIntentFilter	android.content.IntentFilter
    // Exception table:
    //   from	to	target	type
    //   2	34	113	finally
    //   41	110	113	finally
  }
  
  private void cGP()
  {
    try
    {
      if ((this.bGE) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$KapuPkgStateReceiver != null))
      {
        super.getContext().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$KapuPkgStateReceiver);
        this.bGE = false;
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$KapuPkgStateReceiver = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int f(List<acbg> paramList, int paramInt)
  {
    if ((paramList == null) || (paramInt >= paramList.size())) {
      throw new IllegalArgumentException("packageBinderList is null or tabIndex is out");
    }
    int j = 0;
    int i = 0;
    if (j < paramInt)
    {
      acbg localacbg = (acbg)paramList.get(j);
      if (localacbg == null) {
        break label73;
      }
      i = localacbg.Ad() + i;
    }
    label73:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  private void gO(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Acae = new acae(this.mBaseChatPie.mContext, this.mBaseChatPie.app, this.g);
    this.jdField_a_of_type_Acae.setPanelType(paramInt2);
    this.jdField_a_of_type_Acae.a(this);
    if (paramInt1 == 0) {
      this.jdField_a_of_type_Acae.Eo(true);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter != null) && (this.wW != null) && (this.il != null) && (this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "func showApolloPanel begins. Thread id = " + Thread.currentThread().getId());
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.notifyDataSetChanged();
      this.wW.clear();
      this.wW.add(this.jdField_a_of_type_Acae);
      cGF();
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.iA(this.wW);
    }
  }
  
  private void gP(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[showNewActionFloatView] actionId=", Integer.valueOf(paramInt1), ", pkgId=", Integer.valueOf(paramInt2) });
    }
    cGH();
    if ((this.mBaseChatPie == null) || (this.mBaseChatPie.app == null)) {
      QLog.w("ApolloPanel", 1, "[showNewActionFloatView] app null, abort");
    }
    ApolloActionData localApolloActionData;
    do
    {
      return;
      Object localObject = (abxk)this.mBaseChatPie.app.getManager(155);
      localApolloActionData = ((abxk)localObject).a(paramInt1);
      if (localApolloActionData == null)
      {
        QLog.w("ApolloPanel", 1, "[showNewActionFloatView] no action info, abort");
        return;
      }
      boolean bool2 = ((abxk)localObject).hY(paramInt1);
      if ((((abxk)localObject).hZ(paramInt1)) || (localApolloActionData.feeType == 1)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, new Object[] { "[showNewActionFloatView] isObtained=", Boolean.valueOf(bool2), ", isFree=", Boolean.valueOf(bool1), ", feeType=", Integer.valueOf(localApolloActionData.feeType) });
        }
        if (!bool1) {
          break;
        }
        a(localApolloActionData, 0, 20, paramInt2, null);
        return;
      }
      if (localApolloActionData.feeType == 6)
      {
        this.mBaseChatPie.app.addObserver(new acak(this, localApolloActionData, paramInt2));
        ((aqrb)this.mBaseChatPie.app.getBusinessHandler(71)).a(localApolloActionData.actionId, null, null, 0, 0.0F, 0, "newActionFloatView");
        return;
      }
      if (localApolloActionData.feeType == 2)
      {
        if (localApolloActionData.currencyType == 1)
        {
          if (bool2)
          {
            a(localApolloActionData, 0, 23, paramInt2, null);
            return;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putInt("pkgId", paramInt2);
          a(localApolloActionData, 2, 23, paramInt2, (Bundle)localObject);
          return;
        }
        QLog.w("ApolloPanel", 1, "[showNewActionFloatView] currency type not gold, abort");
        return;
      }
      if (localApolloActionData.feeType == 9)
      {
        if (((abhh)this.mBaseChatPie.app.getManager(153)).jm(this.mBaseChatPie.app.getCurrentUin()))
        {
          a(localApolloActionData, 0, 28, paramInt2, null);
          return;
        }
        a(localApolloActionData, 4, 27, paramInt2, null);
        return;
      }
      if (localApolloActionData.feeType == 10)
      {
        if (ApolloUtil.ba(super.getContext()))
        {
          a(localApolloActionData, 0, 20, paramInt2, null);
          return;
        }
        if ((abhh.d.bCU) && (ZD()) && (!TextUtils.isEmpty(abhh.d.bgc)))
        {
          a(localApolloActionData, 5, 29, paramInt2, null);
          return;
        }
        QLog.w("ApolloPanel", 1, "[showNewActionFloatView] 3d entrance not show");
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloPanel", 2, new Object[] { "[showNewActionFloatView] not support yet, feeType=", Integer.valueOf(localApolloActionData.feeType) });
  }
  
  private void initData()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "[initData]");
    }
    cGD();
  }
  
  private boolean jQ(String paramString)
  {
    boolean bool = true;
    if ((this.mBaseChatPie == null) || (this.mBaseChatPie.app == null)) {
      bool = false;
    }
    while (this.mBaseChatPie.app.getApp().getSharedPreferences("apollo_sp" + this.mBaseChatPie.app.getCurrentUin(), 0).getInt(paramString, 0) == 1) {
      return bool;
    }
    return false;
  }
  
  public int Ae()
  {
    return this.bEy;
  }
  
  public void Ae(int paramInt)
  {
    this.bEy = paramInt;
    if (paramInt == 7) {
      cGE();
    }
    do
    {
      return;
      if (paramInt == 0)
      {
        gO(paramInt, 1);
        return;
      }
      if (paramInt == 1)
      {
        if (!ahbj.isFileExists(ApolloUtil.bkb))
        {
          gO(paramInt, 3);
          ((abhh)this.mBaseChatPie.app.getManager(153)).a(this.jdField_a_of_type_Abyz);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.iA(this.wW);
        Dk(this.mBaseChatPie.app.getCurrentUin());
        return;
      }
    } while (paramInt != 2);
    gO(paramInt, 1);
  }
  
  public int Af()
  {
    if (this.wW.size() == 0) {
      return -1;
    }
    if ((this.wW.size() > cuh) && ((this.wW.get(cuh) instanceof abzq)))
    {
      ApolloGameData localApolloGameData = ((abzq)this.wW.get(cuh)).b();
      if (localApolloGameData != null) {
        return localApolloGameData.gameId;
      }
    }
    return -1;
  }
  
  public void Dj(String paramString)
  {
    g(paramString, false, false);
  }
  
  public void Dk(String paramString)
  {
    Iy(0);
    by(paramString, false);
  }
  
  public void Iw(int paramInt)
  {
    int i = bv(paramInt);
    if ((this.wW != null) && (this.wW.size() > i))
    {
      int j = ((acbg)this.wW.get(i)).Ad();
      if (((acbg)this.wW.get(i)).mBinderType == 100) {
        this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(8);
      }
      do
      {
        return;
        if ((j <= 1) || (((acbg)this.wW.get(i)).mBinderType == 100)) {
          break;
        }
        this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.MF(j);
        this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(0);
        this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.onPageSelected(gr(paramInt));
      } while (!QLog.isColorLevel());
      QLog.d("ApolloPanel", 2, "mRadioGroup is visible count = " + j);
      return;
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(4);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(4);
  }
  
  public void Ix(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[checkPackageDownload] index=", Integer.valueOf(paramInt) });
    }
    if (this.jdField_a_of_type_Acbf == null) {}
    int i;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_Acbf.getPackageList();
      } while ((localObject == null) || (((List)localObject).size() <= paramInt));
      localObject = (ApolloActionPackage)((List)localObject).get(paramInt);
      paramInt = ((ApolloActionPackage)localObject).packageId;
      i = ((ApolloActionPackage)localObject).type;
    } while ((this.wY == null) || (this.wY.contains(Integer.valueOf(paramInt))) || (this.mBaseChatPie == null) || (this.mBaseChatPie.app == null));
    Object localObject = (abhh)this.mBaseChatPie.app.getManager(153);
    if (i == 2) {
      ((abhh)localObject).bi(paramInt, true);
    }
    for (;;)
    {
      this.wY.add(Integer.valueOf(paramInt));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloPanel", 2, new Object[] { "[checkPackageDownload] packageId=", Integer.valueOf(paramInt) });
      return;
      if ((i != 100) && (((abhh)localObject).cd(this.mBaseChatPie.app.getCurrentUin()) == 1)) {
        ((abhh)localObject).bi(paramInt, false);
      }
    }
  }
  
  public int a(BaseChatPie paramBaseChatPie, abzy paramabzy, ApolloActionData paramApolloActionData)
  {
    int j;
    if ((paramBaseChatPie == null) || (paramBaseChatPie.app == null))
    {
      j = 0;
      return j;
    }
    abxk localabxk = (abxk)paramBaseChatPie.app.getManager(155);
    paramBaseChatPie = (abhh)paramBaseChatPie.app.getManager(153);
    boolean bool = localabxk.hY(paramApolloActionData.actionId);
    int i;
    if ((paramApolloActionData.hasSound) || (paramabzy.cre > 0)) {
      i = 1;
    }
    for (;;)
    {
      if (localabxk.hZ(paramApolloActionData.actionId))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, new Object[] { "data actionId:", Integer.valueOf(paramApolloActionData.actionId), "typeValue:", Integer.valueOf(i) });
        }
        return i | 0x2;
        if (paramApolloActionData.actionType == 8) {
          i = 1024;
        }
      }
      else
      {
        j = i;
        if (paramApolloActionData.feeType == 6)
        {
          if (bool)
          {
            j = 16;
            j = i | j;
          }
        }
        else
        {
          int k = j;
          if (paramApolloActionData.feeType == 2)
          {
            if (!bool) {
              break label267;
            }
            i = 4;
            label204:
            k = j | i;
          }
          i = k;
          if (paramApolloActionData.feeType == 9) {
            i = k | 0x2000;
          }
          j = i;
          if (paramApolloActionData.feeType != 7) {
            break;
          }
          if (!bool) {
            break label275;
          }
        }
        label267:
        label275:
        for (j = 8;; j = 512)
        {
          return i | j;
          j = 64;
          break;
          i = 128;
          break label204;
        }
      }
      i = 0;
    }
  }
  
  public acbg a(int paramInt)
  {
    if (this.mBaseChatPie == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "getViewBinder type=" + paramInt);
    }
    return this.jdField_c_of_type_ComTencentMobileqqApolloViewApolloPanel$d.a(paramInt);
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mBaseChatPie = paramBaseChatPie;
    this.g = paramSessionInfo;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[initPanel] jumpPkdId=", Integer.valueOf(paramInt1), ", jumpActionId=", Integer.valueOf(paramInt2) });
    }
    paramBaseChatPie = (abhh)this.mBaseChatPie.app.getManager(153);
    if (paramBaseChatPie.cd(this.mBaseChatPie.app.getCurrentUin()) == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "[initPanel] apollo status open, remember jump info");
      }
      this.cuj = paramInt1;
      this.bEw = paramInt2;
    }
    this.bEy = paramInt3;
    paramBaseChatPie.a(this.jdField_a_of_type_Abhh$c);
    this.jdField_a_of_type_Abhh$e = paramBaseChatPie.a();
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)super.findViewById(2131363208));
    this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)super.findViewById(2131363193));
    this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setViewPager(this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager);
    this.aR = ((URLImageView)super.findViewById(2131363910));
    this.jx = ((RelativeLayout)super.findViewById(2131365334));
    this.jy = ((RelativeLayout)super.findViewById(2131365333));
    this.aS = ((URLImageView)super.findViewById(2131363886));
    this.aS.setOnClickListener(this);
    this.aT = ((URLImageView)super.findViewById(2131363775));
    this.bs = ((FrameLayout)this.aT.getParent());
    this.bt = ((FrameLayout)super.findViewById(2131363880));
    this.yb = ((ImageView)super.findViewById(2131362777));
    this.m = ((DiniFlyAnimationView)super.findViewById(2131362824));
    this.jdField_e_of_type_AndroidGraphicsDrawableStateListDrawable = new StateListDrawable();
    paramSessionInfo = this.jdField_e_of_type_AndroidGraphicsDrawableStateListDrawable;
    Drawable localDrawable = super.getContext().getResources().getDrawable(2130838684);
    paramSessionInfo.addState(new int[] { 16842919 }, localDrawable);
    paramSessionInfo = this.jdField_e_of_type_AndroidGraphicsDrawableStateListDrawable;
    localDrawable = super.getContext().getResources().getDrawable(2130838683);
    paramSessionInfo.addState(new int[] { -16842919 }, localDrawable);
    this.ex = new ColorDrawable(0);
    this.aR.setOnClickListener(this);
    this.il = ((LinearLayout)super.findViewById(2131362825));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter = new ApolloPanelAdapter(BaseApplicationImpl.getContext());
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.setCallback(this.mBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.setSessionInfo(this.g);
    this.r = ((HorizontalListView)super.findViewById(2131379132));
    this.jdField_a_of_type_Acbf = new acbf(super.getContext());
    this.r.setAdapter(this.jdField_a_of_type_Acbf);
    this.r.setOnItemClickListener(this);
    super.findViewById(2131379127).setBackgroundColor(super.getContext().getResources().getColor(2131165783));
    this.mLoadingView = ((ImageView)super.findViewById(2131370820));
    this.mLoadingView.setVisibility(8);
    this.jz = ((RelativeLayout)findViewById(2131362819));
    this.im = ((LinearLayout)findViewById(2131362818));
    this.im.setOnClickListener(this);
    this.Qq = ((TextView)findViewById(2131362817));
    this.Qr = ((TextView)findViewById(2131362768));
    this.jdField_b_of_type_Abhs = paramBaseChatPie.a();
    if (this.jdField_b_of_type_Abhs != null) {
      this.Qr.setText(String.valueOf(this.jdField_b_of_type_Abhs.aR.get()));
    }
    if ((this.mBaseChatPie != null) && (this.mBaseChatPie.app != null))
    {
      this.H = new RedTouch(super.getContext(), this.jx).a(5).a();
      this.s = ((altq)this.mBaseChatPie.app.getManager(36)).getAppInfoByPath(String.valueOf("103100.103200.103250"));
      paramBaseChatPie = (WebProcessManager)this.mBaseChatPie.app.getManager(13);
      if (paramBaseChatPie != null) {
        paramBaseChatPie.Yc(100);
      }
      avqy.eT(this.mBaseChatPie.app);
      paramBaseChatPie = BaseApplicationImpl.getContext().getSharedPreferences(this.mBaseChatPie.app.getCurrentAccountUin(), 0);
      if ((paramBaseChatPie.getBoolean("chat_tool_apollo_" + this.mBaseChatPie.app.getCurrentAccountUin(), false)) && (this.bEy != 7))
      {
        paramBaseChatPie.edit().putBoolean("chat_tool_apollo_" + this.mBaseChatPie.app.getCurrentAccountUin(), false).commit();
        paramBaseChatPie = this.mBaseChatPie.app.getHandler(ChatActivity.class);
        if (paramBaseChatPie != null) {
          paramBaseChatPie.obtainMessage(51).sendToTarget();
        }
      }
      if (abhh.bCz)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, "[initPanel] getUserApolloInfo");
        }
        this.bGz = true;
        ((aqrb)this.mBaseChatPie.app.getBusinessHandler(71)).ag(this.mBaseChatPie.app.getCurrentUin(), 8650880, "Open Panel");
        abhh.bCz = false;
      }
      if (this.jdField_b_of_type_Abhs != null) {
        this.jdField_b_of_type_Abhs.b(null);
      }
      paramBaseChatPie = (HotChatManager)this.mBaseChatPie.app.getManager(60);
      if ((paramBaseChatPie == null) || (!paramBaseChatPie.kj(this.mBaseChatPie.a().aTl))) {
        break label1110;
      }
    }
    label1110:
    for (boolean bool = true;; bool = false)
    {
      this.biP = bool;
      ((RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.getLayoutParams()).bottomMargin = ((int)(10.0F * super.getResources().getDisplayMetrics().density));
      setBackgroundColor(super.getResources().getColor(2131165785));
      initData();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "init panel done");
      }
      return;
    }
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString, boolean paramBoolean)
  {
    ThreadManager.post(new ApolloPanel.34(this, paramAppInfo, paramBoolean, paramString), 5, null, true);
  }
  
  protected void aKc()
  {
    Object localObject;
    if ((this.mBaseChatPie != null) && (this.jdField_a_of_type_Acbf != null))
    {
      i = bv(cuh);
      localObject = this.jdField_a_of_type_Acbf.getPackageList();
      if ((localObject != null) && (((List)localObject).size() > 0) && (i >= 0) && (i < ((List)localObject).size()))
      {
        localObject = (ApolloActionPackage)((List)localObject).get(i);
        if (localObject == null) {
          break label150;
        }
      }
    }
    label150:
    for (int i = ((ApolloActionPackage)localObject).packageId;; i = 0)
    {
      VipUtils.a(this.mBaseChatPie.app, "cmshow", "Apollo", "tabexposure", this.g.aTl, ApolloUtil.gi(this.g.cZ), i, new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
    }
  }
  
  public void bYN()
  {
    MqqHandler localMqqHandler;
    if ((this.mBaseChatPie != null) && (this.mBaseChatPie.app != null))
    {
      localMqqHandler = this.mBaseChatPie.app.getHandler(ChatActivity.class);
      if (localMqqHandler != null) {}
    }
    else
    {
      return;
    }
    localMqqHandler.post(new ApolloPanel.22(this));
  }
  
  public int bv(int paramInt)
  {
    int n = 0;
    int k = n;
    int i;
    int j;
    if (this.wW != null)
    {
      k = n;
      if (paramInt > 0)
      {
        i = 0;
        j = 0;
      }
    }
    for (;;)
    {
      k = n;
      if (i < this.wW.size())
      {
        j += ((acbg)this.wW.get(i)).Ad();
        if (paramInt < j) {
          k = i;
        }
      }
      else
      {
        return k;
      }
      i += 1;
    }
  }
  
  public void by(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] refreshByGetUserAction=", Boolean.valueOf(paramBoolean) });
    }
    if ((this.mBaseChatPie == null) || (this.mBaseChatPie.app == null)) {
      QLog.e("ApolloPanel", 1, "[initPanelData] mBaseChatPie or mBaseChatPie.app is null");
    }
    ArrayList localArrayList2;
    abxk localabxk;
    List localList;
    do
    {
      do
      {
        return;
        new ArrayList();
        localArrayList2 = new ArrayList();
        localabxk = (abxk)this.mBaseChatPie.app.getManager(155);
      } while (localabxk == null);
      localList = localabxk.a(this.g);
      if (localList != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloPanel", 2, "packageList is null.");
    return;
    if (this.wY != null) {
      this.wY.clear();
    }
    ArrayList localArrayList1 = new ArrayList();
    if (this.mBaseChatPie != null) {}
    label533:
    label558:
    label2365:
    for (boolean bool = ApolloUtil.c(this.mBaseChatPie.app, super.getContext());; bool = false)
    {
      QLog.d("ApolloPanel", 1, new Object[] { "[initPanelData] showKapuUnlockAction=", Boolean.valueOf(bool) });
      int i1 = 0;
      int i = 0;
      int j = -1;
      label212:
      ApolloActionPackage localApolloActionPackage;
      if (i1 < localList.size())
      {
        localApolloActionPackage = (ApolloActionPackage)localList.get(i1);
        if (localApolloActionPackage == null) {
          break label2375;
        }
        if (localApolloActionPackage.packageId != 4) {}
      }
      label1087:
      label2368:
      label2375:
      for (;;)
      {
        i1 += 1;
        break label212;
        if (this.jdField_c_of_type_ComTencentMobileqqApolloViewApolloPanel$d.in(localApolloActionPackage.packageId))
        {
          String str = aqgz.getQQVersion();
          if ((!TextUtils.isEmpty(localApolloActionPackage.startVersion)) && (!TextUtils.isEmpty(localApolloActionPackage.endVersion)) && ((!aqqi.bV(localApolloActionPackage.startVersion, str)) || (!aqqi.bV(str, localApolloActionPackage.endVersion))))
          {
            QLog.w("ApolloPanel", 1, "version not correct packageId=" + localApolloActionPackage.packageId);
          }
          else
          {
            long l2 = System.currentTimeMillis();
            acbg localacbg = a(localApolloActionPackage.type);
            if (localacbg != null)
            {
              localacbg.cud = localApolloActionPackage.packageId;
              Object localObject3 = null;
              ArrayList localArrayList3 = new ArrayList();
              Object localObject1;
              Object localObject2;
              Object localObject4;
              int k;
              long l1;
              ApolloActionData localApolloActionData;
              if (localApolloActionPackage.type == 2)
              {
                localObject1 = localabxk.e();
                localObject2 = (List)((Pair)localObject1).first;
                localObject3 = (List)((Pair)localObject1).second;
                if ((localObject2 != null) && (((List)localObject2).size() > 0))
                {
                  localacbg.setPanelType(5);
                  localObject1 = new abzy();
                  ((abzy)localObject1).mType = 2;
                  localObject4 = new ApolloActionData();
                  ((ApolloActionData)localObject4).actionName = super.getResources().getString(2131690325);
                  ((abzy)localObject1).c = ((ApolloActionData)localObject4);
                  localArrayList3.add(localObject1);
                  localObject1 = null;
                  k = i;
                  l1 = System.currentTimeMillis();
                  localObject4 = new StringBuilder();
                  if (localObject3 == null) {
                    break label2368;
                  }
                  i = j;
                  j = 0;
                  if (j >= ((List)localObject3).size()) {
                    break label1440;
                  }
                  if (this.g == null) {
                    break;
                  }
                  localApolloActionData = (ApolloActionData)((List)localObject3).get(j);
                  if (localApolloActionData != null) {
                    break label868;
                  }
                }
              }
              for (;;)
              {
                label596:
                j += 1;
                break label558;
                localacbg.setPanelType(4);
                break;
                if (localApolloActionPackage.type == 100)
                {
                  localObject1 = localabxk.cN();
                  if ((localObject1 != null) && (((List)localObject1).size() > 0))
                  {
                    k = i;
                    if ((localacbg instanceof abzq))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("ApolloPanel", 2, new Object[] { "set panel game list, size=", Integer.valueOf(((List)localObject1).size()) });
                      }
                      ((abzq)localacbg).iv((List)localObject1);
                      localacbg.setPanelType(100);
                      k = i + localacbg.Ad();
                      localArrayList1.add(localacbg);
                      localArrayList2.add(localList.get(i1));
                    }
                  }
                  for (;;)
                  {
                    localObject1 = null;
                    localObject2 = null;
                    break;
                    QLog.i("ApolloPanel", 1, "load game info fail cause games == null");
                    k = i;
                  }
                }
                localObject3 = localabxk.N(localApolloActionPackage.packageId);
                localObject1 = localabxk.O(localApolloActionPackage.packageId);
                localacbg.setPanelType(0);
                if (localApolloActionPackage.packageId == 6)
                {
                  localacbg.setPanelType(9);
                  localabxk.a(this.mBaseChatPie, (List)localObject3);
                  localObject2 = null;
                  k = i;
                  break label533;
                }
                if (localApolloActionPackage.packageId == 7) {
                  localabxk.a(this.mBaseChatPie, (List)localObject3);
                }
                localObject2 = null;
                k = i;
                break label533;
                label868:
                if (!localApolloActionData.verifyVersion(str))
                {
                  ((StringBuilder)localObject4).append(",version ").append(localApolloActionData.actionId);
                }
                else
                {
                  if (this.g.cZ == 0)
                  {
                    if (localApolloActionData.sessionType == 2) {
                      ((StringBuilder)localObject4).append(",special C2C ").append(localApolloActionData.actionId);
                    }
                  }
                  else if (((this.g.cZ == 1) || (this.g.cZ == 3000)) && (localApolloActionData.sessionType == 1))
                  {
                    ((StringBuilder)localObject4).append(",special ").append(localApolloActionData.actionId);
                    continue;
                  }
                  if (((ApolloActionData)((List)localObject3).get(j)).isShow == 0)
                  {
                    ((StringBuilder)localObject4).append(",hide ").append(localApolloActionData.actionId);
                  }
                  else
                  {
                    if ((!ApolloActionPackage.is3DPackage(localApolloActionPackage.packageId)) || (localApolloActionData.feeType != 10)) {
                      break label1087;
                    }
                    if (this.cum == 2) {
                      this.bGD = true;
                    }
                    if (bool) {
                      break label1087;
                    }
                    ((StringBuilder)localObject4).append(",kapu unlock ").append(localApolloActionData.actionId);
                  }
                }
              }
              abzy localabzy = localacbg.a(paramString);
              localabzy.c = localApolloActionData;
              localabzy.cud = localApolloActionPackage.packageId;
              if (localApolloActionPackage.type == 2) {
                if ((localObject2 != null) && (((List)localObject2).size() > j))
                {
                  localabzy.bkj = ((ApolloFavActionData)((List)localObject2).get(j)).text;
                  localabzy.cue = ((ApolloFavActionData)((List)localObject2).get(j)).textType;
                  localabzy.cre = ((ApolloFavActionData)((List)localObject2).get(j)).audioId;
                  localabzy.sC = ((ApolloFavActionData)((List)localObject2).get(j)).audioStartTime;
                  localabzy.cuf = ((ApolloFavActionData)((List)localObject2).get(j)).playOriginalAudio;
                }
              }
              for (localabzy.iconType = a(this.mBaseChatPie, localabzy, localabzy.c);; localabzy.iconType = a(this.mBaseChatPie, localabzy, localabzy.c))
              {
                do
                {
                  localArrayList3.add(localabzy);
                  if ((i != -1) || (this.bEw != localApolloActionData.actionId)) {
                    break label2365;
                  }
                  if (this.cuj == -1)
                  {
                    this.cuj = localApolloActionPackage.packageId;
                    if (QLog.isColorLevel()) {
                      QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] jump action match but no jump pkg, use ", Integer.valueOf(this.cuj) });
                    }
                  }
                  if (this.cuj != localApolloActionPackage.packageId) {
                    break label2365;
                  }
                  i = localArrayList3.size() - 1;
                  break;
                } while ((localObject1 == null) || (((List)localObject1).size() <= j));
                localabzy.bkj = ((ApolloActionPackageData)((List)localObject1).get(j)).text;
                localabzy.cue = ((ApolloActionPackageData)((List)localObject1).get(j)).textType;
              }
              if (0 != 0) {
                throw new NullPointerException();
              }
              int n = k;
              j = i;
              if (localArrayList3.size() > 0)
              {
                localacbg.ix(localArrayList3);
                if (this.cuj == localApolloActionPackage.packageId)
                {
                  if (i == -1) {
                    break label1691;
                  }
                  localacbg.IC(i);
                  cuh = localacbg.gq(i) + k;
                  label1511:
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] init sCurrentIndex with jump info, sCurrentIndex=", Integer.valueOf(cuh), ", jumpActionIndex=", Integer.valueOf(i) });
                  }
                }
                localArrayList1.add(localacbg);
                localArrayList2.add(localList.get(i1));
                n = k + localacbg.Ad();
                j = i;
              }
              for (;;)
              {
                if (QLog.isColorLevel())
                {
                  i = localApolloActionPackage.packageId;
                  if (localObject3 != null) {
                    break label1699;
                  }
                }
                for (localObject1 = null;; localObject1 = Integer.valueOf(((List)localObject3).size()))
                {
                  QLog.d("ApolloPanel", 2, new Object[] { "Tab add package:", Integer.valueOf(i), ",actionPackageDatas size:", localObject1, ",findTime:", Long.valueOf(l1 - l2), ",remove actions ", ((StringBuilder)localObject4).toString() });
                  i = n;
                  break;
                  cuh = k;
                  break label1511;
                }
                if (this.bGD) {
                  cGO();
                }
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] mIsJsonUpdatedByJumpAction=", Boolean.valueOf(this.bGA) });
                }
                if ((this.bEw == -1) && (this.cuj == -1)) {
                  c(localArrayList1, localArrayList2, paramBoolean);
                }
                if ((this.bEw != -1) && (j == -1) && (!this.bGA))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloPanel", 2, "[initPanelData] no jump action found, try to update json");
                  }
                  if (this.mLoadingView != null) {
                    this.mLoadingView.post(new ApolloPanel.3(this));
                  }
                  this.bGA = true;
                  if ((this.mBaseChatPie != null) && (this.mBaseChatPie.app != null)) {
                    ((abhh)this.mBaseChatPie.app.getManager(153)).Hd(1);
                  }
                }
                while ((localArrayList1 != null) && (localArrayList1.size() > 0) && (this.mBaseChatPie != null) && (this.mBaseChatPie.app != null))
                {
                  paramString = this.mBaseChatPie.app.getApp().getSharedPreferences("apollo_sp" + this.mBaseChatPie.app.getCurrentUin(), 0);
                  l1 = NetConnInfoCenter.getServerTime();
                  l2 = ApolloGameUtil.g(this.mBaseChatPie.app);
                  localObject1 = new ArrayList();
                  localObject2 = localArrayList2.iterator();
                  while (((Iterator)localObject2).hasNext())
                  {
                    localObject3 = (ApolloActionPackage)((Iterator)localObject2).next();
                    if ((((ApolloActionPackage)localObject3).isUpdate) && (((ApolloActionPackage)localObject3).packageId != 100))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("ApolloPanel", 2, "[initPanelData] delete red dot after 24h:" + ((List)localObject1).size());
                      }
                      if (NetConnInfoCenter.getServerTimeMillis() - paramString.getLong("action_red_tab_update_" + ((ApolloActionPackage)localObject3).packageId, 0L) > ((ApolloActionPackage)localObject3).redInterval)
                      {
                        ((ApolloActionPackage)localObject3).isUpdate = false;
                        ((List)localObject1).add(localObject3);
                      }
                    }
                    if ((((ApolloActionPackage)localObject3).isUpdate) && (((ApolloActionPackage)localObject3).packageId == 100) && (l1 - l2 > 604800000L))
                    {
                      ((ApolloActionPackage)localObject3).isUpdate = false;
                      ((List)localObject1).add(localObject3);
                    }
                  }
                  if (!this.bGz)
                  {
                    this.cuj = -1;
                    this.bEw = -1;
                  }
                }
                break;
                if (!((List)localObject1).isEmpty())
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloPanel", 2, "[initPanelData] delete red dot after 24h:" + ((List)localObject1).size());
                  }
                  ThreadManager.post(new ApolloPanel.4(this, (List)localObject1), 5, null, true);
                }
                iy(localArrayList2);
                iz(localArrayList1);
                this.jdField_c_of_type_ComTencentMobileqqApolloViewApolloPanel$d.updateView();
                a(this.s, "103100.103200.103250", paramBoolean);
                if (Looper.myLooper() == Looper.getMainLooper()) {
                  try
                  {
                    aKc();
                    return;
                  }
                  catch (Throwable paramString)
                  {
                    QLog.e("ApolloPanel", 1, "[reportTabExposure] failed, excetion1=", paramString);
                    return;
                  }
                }
                if ((this.mBaseChatPie == null) || (this.mBaseChatPie.mActivity == null)) {
                  break;
                }
                this.mBaseChatPie.mActivity.runOnUiThread(new ApolloPanel.5(this));
                return;
                break label596;
                n = k;
              }
            }
          }
        }
      }
    }
  }
  
  public void cGC()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[switch2RedTab] visibility=", Integer.valueOf(super.getVisibility()) });
    }
    if (super.getVisibility() == 0) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "[switch2RedTab] visible now, abort");
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Acbf != null)
      {
        List localList = this.jdField_a_of_type_Acbf.getPackageList();
        if ((localList == null) || (localList.isEmpty())) {
          break;
        }
        int j = localList.size();
        int i = 0;
        while (i < j)
        {
          ApolloActionPackage localApolloActionPackage = (ApolloActionPackage)localList.get(i);
          if ((localApolloActionPackage != null) && (localApolloActionPackage.isUpdate) && (NetConnInfoCenter.getServerTimeMillis() >= localApolloActionPackage.redStartTime))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloPanel", 2, new Object[] { "[switch2RedTab] packageId=", Integer.valueOf(localApolloActionPackage.packageId) });
            }
            yW(i);
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  public void cGD()
  {
    if ((this.mBaseChatPie == null) || (this.mBaseChatPie.app == null))
    {
      QLog.e("ApolloPanel", 1, "[initData] mBaseChatPie or mBaseChatPie.app is null");
      return;
    }
    abhh localabhh = (abhh)this.mBaseChatPie.app.getManager(153);
    localabhh.a(this.jdField_a_of_type_Abyz);
    if (this.jdField_b_of_type_Abhs != null) {
      this.jdField_b_of_type_Abhs.a(this.jdField_a_of_type_Abhs$a);
    }
    int j = localabhh.cd(this.mBaseChatPie.app.getCurrentUin());
    if (this.g != null) {
      if (this.g.cZ == 1036)
      {
        i = 1;
        if ((!this.biP) && (this.bEy != 7) && (i == 0)) {
          break label147;
        }
      }
    }
    label147:
    for (int i = 7;; i = j)
    {
      Ae(i);
      return;
      i = 0;
      break;
      i = 0;
      break;
    }
  }
  
  public void cGE()
  {
    Object localObject;
    if ((this.mBaseChatPie != null) && (this.mBaseChatPie.app != null))
    {
      localObject = (abxk)this.mBaseChatPie.app.getManager(155);
      if (this.g.cZ != 1036) {
        break label137;
      }
      localObject = ((xxh)this.mBaseChatPie).cN();
      this.jdField_c_of_type_Abzq = new abzq(this.mBaseChatPie.mContext, this.mBaseChatPie.app, this.g, this.mBaseChatPie);
      this.jdField_c_of_type_Abzq.iv((List)localObject);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label145;
      }
      this.jdField_c_of_type_Abzq.setPanelType(100);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new ApolloPanel.11(this));
      return;
      label137:
      localObject = ((abxk)localObject).cN();
      break;
      label145:
      this.jdField_c_of_type_Abzq.setPanelType(8);
    }
  }
  
  public void cGG()
  {
    if (this.ah != null)
    {
      this.ah.dismiss();
      this.ah = null;
    }
  }
  
  public void cGL()
  {
    if ((this.mBaseChatPie == null) || (this.mBaseChatPie.app == null)) {
      QLog.e("ApolloPanel", 1, "[showGuidePageFor3D] mBaseChatPie or mBaseChatPie.app is null");
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((!abhh.d.bCU) || (this.cum == 2) || (!ZD()))
          {
            cGM();
            return;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView != null);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, "[showGuidePageFor3D]");
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView = ((ApolloPanelGuideView)LayoutInflater.from(super.getContext()).inflate(2131558718, null));
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.setCallback(this.mBaseChatPie);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.setSessionInfo(this.g);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.setClickCallback(new acaw(this));
        addView(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView, -1, -1);
        localObject2 = (abxk)this.mBaseChatPie.app.getManager(155);
      } while (localObject2 == null);
      Object localObject1 = new ArrayList();
      Object localObject2 = ((abxk)localObject2).N(400);
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        int i = 0;
        while (i < ((List)localObject2).size())
        {
          abzc localabzc = new abzc(this.mBaseChatPie.app.getCurrentUin());
          localabzc.c = ((ApolloActionData)((List)localObject2).get(i));
          ((List)localObject1).add(localabzc);
          i += 1;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.setActions((List)localObject1);
      localObject1 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
      ((TranslateAnimation)localObject1).setDuration(500L);
      ((TranslateAnimation)localObject1).setRepeatCount(0);
      ((TranslateAnimation)localObject1).setInterpolator(new AccelerateDecelerateInterpolator());
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.startAnimation((Animation)localObject1);
    } while (this.bGJ);
    this.bGJ = true;
    ((abhh)this.mBaseChatPie.app.getManager(153)).cBV();
  }
  
  public void cGN()
  {
    if ((this.mBaseChatPie == null) || (this.mBaseChatPie.app == null)) {
      return;
    }
    ((aqrb)this.mBaseChatPie.app.getBusinessHandler(71)).XQ(4);
  }
  
  public void cGk()
  {
    Object localObject1;
    List localList;
    if ((this.mBaseChatPie != null) && (this.mBaseChatPie.app != null))
    {
      localObject1 = (abxk)this.mBaseChatPie.app.getManager(155);
      if (!(this.mBaseChatPie instanceof xxh)) {
        break label114;
      }
      localList = ((xxh)this.mBaseChatPie).cN();
      if ((localList != null) && (localList.size() > 0))
      {
        localObject1 = null;
        localObject2 = null;
        if (this.jdField_c_of_type_Abzq == null) {
          break label123;
        }
        localObject2 = this.jdField_c_of_type_Abzq;
      }
    }
    label114:
    label123:
    int j;
    int i;
    do
    {
      do
      {
        if (localObject2 != null) {
          ThreadManager.getUIHandler().post(new ApolloPanel.12(this, (abzq)localObject2, localList));
        }
        return;
        localList = ((abxk)localObject1).cN();
        break;
      } while (this.wW == null);
      j = this.wW.size();
      i = 0;
      localObject2 = localObject1;
    } while (i >= j);
    Object localObject2 = (acbg)this.wW.get(i);
    if ((localObject2 != null) && (((acbg)localObject2).mBinderType == 100) && ((localObject2 instanceof abzq))) {
      localObject1 = (abzq)localObject2;
    }
    for (;;)
    {
      i += 1;
      break;
    }
  }
  
  public void cGv()
  {
    if ((this.mBaseChatPie != null) && (this.mBaseChatPie.mActivity != null))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("extra_key_url_append", "&showDialog=1&type=role");
      ApolloUtil.a(this.mBaseChatPie.mActivity, localIntent, "aio", abxi.bju, null);
    }
  }
  
  public void cGw()
  {
    if ((this.mBaseChatPie != null) && (this.mBaseChatPie.app != null))
    {
      abhh localabhh = (abhh)this.mBaseChatPie.app.getManager(153);
      if (localabhh != null)
      {
        localabhh.a(this.jdField_a_of_type_Abyz);
        int i = 0;
        if (!ahbj.isFileExists(ApolloUtil.bkb)) {
          i = 1;
        }
        localabhh.Hd(i);
      }
    }
  }
  
  public void cGx()
  {
    if (this.mBaseChatPie == null) {}
    QQAppInterface localQQAppInterface;
    SessionInfo localSessionInfo;
    do
    {
      return;
      localQQAppInterface = this.mBaseChatPie.app;
      localSessionInfo = this.mBaseChatPie.sessionInfo;
    } while ((localQQAppInterface == null) || (localSessionInfo == null));
    int i = ((abhh)localQQAppInterface.getManager(153)).cd(localQQAppInterface.getCurrentUin());
    String str = localSessionInfo.aTl;
    if (i == 0) {}
    for (i = 0;; i = 1)
    {
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "state_open_clk", str, i, 0, new String[] { String.valueOf(ApolloUtil.gi(localSessionInfo.cZ)), "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      aqmq.track("apollo_panel_open", null);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "dispatchdraw is called");
      }
      return;
    }
    catch (StackOverflowError paramCanvas)
    {
      QLog.e("ApolloPanel", 1, "dispatchDraw, StackOverflowError, stack:" + MsfSdkUtils.getStackTraceString(paramCanvas));
    }
  }
  
  protected void dispatchVisibilityChanged(View paramView, int paramInt)
  {
    super.dispatchVisibilityChanged(paramView, paramInt);
    if ((paramInt != 0) && (this.jdField_d_of_type_Auvw != null) && (this.jdField_d_of_type_Auvw.isShowing())) {
      this.jdField_d_of_type_Auvw.dismiss();
    }
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mIsVisible = bool;
      return;
    }
  }
  
  public void g(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[initBinderData] froceRefresh=", Boolean.valueOf(paramBoolean1), ", refreshByGetUserAction=", Boolean.valueOf(paramBoolean2) });
    }
    if (this.bEy == 7)
    {
      cGE();
      return;
    }
    ThreadManager.post(new ApolloPanel.2(this, paramBoolean1, paramString, paramBoolean2), 5, null, true);
  }
  
  public int gr(int paramInt)
  {
    int n = 0;
    int k = n;
    int i;
    int j;
    if (this.wW != null)
    {
      k = n;
      if (paramInt > 0)
      {
        i = 0;
        j = 0;
      }
    }
    for (;;)
    {
      k = n;
      if (i < this.wW.size())
      {
        j += ((acbg)this.wW.get(i)).Ad();
        if (paramInt < j) {
          k = ((acbg)this.wW.get(i)).Ad() - (j - paramInt);
        }
      }
      else
      {
        return k;
      }
      i += 1;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return false;
        int i = paramMessage.getData().getInt("pkgId");
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, new Object[] { "[handleMessage] MSG_SHOW_NEW_ACTION_FLOAT_VIEW, actionId=", Integer.valueOf(paramMessage.arg1), ", pkgId=", Integer.valueOf(i) });
        }
        gP(paramMessage.arg1, i);
        return false;
      } while ((this.mBaseChatPie == null) || (this.mBaseChatPie.app == null) || (!this.mIsVisible) || (this.jdField_d_of_type_ComTencentMobileqqDrawerPushItem == null) || (TextUtils.isEmpty(this.jdField_d_of_type_ComTencentMobileqqDrawerPushItem.content)) || (this.jdField_d_of_type_ComTencentMobileqqDrawerPushItem.life_Time <= 0) || (this.jdField_d_of_type_ComTencentMobileqqDrawerPushItem.show_sum >= this.jdField_d_of_type_ComTencentMobileqqDrawerPushItem.show_counts));
      a(this.jx, 49, this.jdField_d_of_type_ComTencentMobileqqDrawerPushItem.content, this.jdField_d_of_type_ComTencentMobileqqDrawerPushItem.life_Time, null);
      paramMessage = this.jdField_d_of_type_ComTencentMobileqqDrawerPushItem;
      paramMessage.show_sum += 1;
      ((abhh)this.mBaseChatPie.app.getManager(153)).b(this.jdField_d_of_type_ComTencentMobileqqDrawerPushItem);
      return false;
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$a == null);
    a.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$a);
    return false;
  }
  
  public void iy(List<ApolloActionPackage> paramList)
  {
    if ((this.mBaseChatPie != null) && (this.mBaseChatPie.mActivity != null)) {
      this.mBaseChatPie.mActivity.runOnUiThread(new ApolloPanel.8(this, paramList));
    }
  }
  
  public void iz(List<acbg> paramList)
  {
    if ((this.mBaseChatPie != null) && (this.mBaseChatPie.mActivity != null)) {
      this.mBaseChatPie.mActivity.runOnUiThread(new ApolloPanel.9(this, paramList));
    }
  }
  
  public void l(ApolloActionData paramApolloActionData)
  {
    long l1 = System.currentTimeMillis();
    if (paramApolloActionData == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "updateItemStatus action= " + paramApolloActionData.actionId + " action name =" + paramApolloActionData.actionName);
      }
      if ((this.wW != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager != null) && (this.mBaseChatPie != null) && (this.mBaseChatPie.app != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloPanel", 2, "something=null ");
    return;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.getChildCount()) {
          continue;
        }
        localViewGroup = (ViewGroup)this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.getChildAt(i);
        if (!(localViewGroup instanceof ApolloLinearLayout)) {
          break label384;
        }
        if (((ApolloLinearLayout)localViewGroup).a(paramApolloActionData) != null) {
          break label391;
        }
      }
      catch (Exception paramApolloActionData)
      {
        ViewGroup localViewGroup;
        LinearLayout localLinearLayout;
        int k;
        ApolloLinearLayout.a locala;
        abzy localabzy;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ApolloPanel", 2, "updateItemStatus error:" + paramApolloActionData.toString());
        l2 = System.currentTimeMillis();
      }
      if (j < localViewGroup.getChildCount())
      {
        localLinearLayout = (LinearLayout)localViewGroup.getChildAt(j);
        k = 0;
        if (k < localLinearLayout.getChildCount())
        {
          locala = (ApolloLinearLayout.a)localLinearLayout.getChildAt(k).getTag();
          if (locala != null)
          {
            localabzy = locala.d;
            if ((localabzy != null) && (localabzy.c != null) && (localabzy.c.actionId == paramApolloActionData.actionId))
            {
              if ((this.mBaseChatPie == null) || (this.mBaseChatPie.app == null)) {
                break;
              }
              this.mBaseChatPie.app.getHandler(ChatActivity.class).post(new ApolloPanel.20(this, locala));
            }
          }
          k += 1;
          continue;
        }
        j += 1;
        continue;
        long l2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloPanel", 2, "updateItemStatus cost time = " + (l2 - l1));
        return;
      }
      label384:
      i += 1;
      continue;
      label391:
      int j = 0;
    }
  }
  
  public void m(ApolloActionData paramApolloActionData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[showKapuLockActionView] action=", paramApolloActionData });
    }
    if ((this.mBaseChatPie == null) || (this.mBaseChatPie.app == null) || (paramApolloActionData == null)) {}
    do
    {
      return;
      this.jA = ((RelativeLayout)LayoutInflater.from(super.getContext()).inflate(2131558720, null));
      this.jA.setId(2131362811);
      this.jA.findViewById(2131368743).setVisibility(4);
      ((ImageView)this.jA.findViewById(2131368994)).setOnClickListener(this);
      Object localObject2 = super.getResources();
      Object localObject1 = (ImageView)this.jA.findViewById(2131368982);
      new acad(this.mBaseChatPie.app.getCurrentUin()).c = paramApolloActionData;
      ((ImageView)localObject1).setImageDrawable(a(paramApolloActionData));
      ((TextView)this.jA.findViewById(2131381061)).setText(paramApolloActionData.actionName);
      ((TextView)this.jA.findViewById(2131381060)).setText(paramApolloActionData.description);
      ((Button)this.jA.findViewById(2131363940)).setOnClickListener(new acar(this, paramApolloActionData));
      localObject1 = (Button)this.jA.findViewById(2131363765);
      int i = super.getHeight() - this.r.getHeight();
      if (i < wja.dp2px(213.0F, (Resources)localObject2))
      {
        localObject3 = (LinearLayout)this.jA.findViewById(2131365337);
        i = i - (int)((Resources)localObject2).getDimension(2131296524) - (int)((Resources)localObject2).getDimension(2131296525);
        ((RelativeLayout.LayoutParams)((LinearLayout)localObject3).getLayoutParams()).bottomMargin = ((int)(i * 0.1D));
        ((RelativeLayout.LayoutParams)((RelativeLayout)this.jA.findViewById(2131365332)).getLayoutParams()).bottomMargin = ((int)(i * 0.2D));
      }
      localObject2 = (ImageView)this.jA.findViewById(2131368716);
      Object localObject3 = (TextView)this.jA.findViewById(2131381082);
      ((ImageView)localObject2).setVisibility(0);
      ((ImageView)localObject2).setImageResource(2130838661);
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setMaxLines(2);
      ((TextView)localObject3).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject3).setText(super.getResources().getString(2131690374));
      ((Button)localObject1).setText(super.getResources().getString(2131690376));
      ((Button)localObject1).setOnClickListener(new acas(this, paramApolloActionData));
      localObject1 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject1).addRule(2, 2131362825);
      addView(this.jA, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
      ((TranslateAnimation)localObject1).setDuration(500L);
      ((TranslateAnimation)localObject1).setRepeatCount(0);
      ((TranslateAnimation)localObject1).setInterpolator(new AccelerateDecelerateInterpolator());
      this.jA.startAnimation((Animation)localObject1);
    } while (this.g == null);
    VipUtils.a(this.mBaseChatPie.app, "cmshow", "Apollo", "clkunlocked", ApolloUtil.gi(this.g.cZ), 0, new String[] { String.valueOf(paramApolloActionData.actionId) });
  }
  
  public void notifyDataChange()
  {
    MqqHandler localMqqHandler;
    if ((this.mBaseChatPie != null) && (this.mBaseChatPie.app != null))
    {
      localMqqHandler = this.mBaseChatPie.app.getHandler(ChatActivity.class);
      if (localMqqHandler != null) {}
    }
    else
    {
      return;
    }
    localMqqHandler.post(new ApolloPanel.10(this));
  }
  
  public void onChangeUserApolloStatus(boolean paramBoolean, Object paramObject)
  {
    if ((this.mBaseChatPie == null) || (this.mBaseChatPie.app == null)) {}
    do
    {
      Pair localPair;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (this.jdField_a_of_type_Acae != null) {
                this.jdField_a_of_type_Acae.cGB();
              }
            } while (!paramBoolean);
            if (QLog.isColorLevel()) {
              QLog.d("ApolloPanel", 2, "actionpanel onOpen response");
            }
          } while (paramObject == null);
          localPair = (Pair)paramObject;
          paramObject = (String)((Pair)paramObject).first;
        } while ((TextUtils.isEmpty(paramObject)) || (!paramObject.equals(this.mBaseChatPie.app.getCurrentUin())));
        if (2 == ((Integer)localPair.second).intValue())
        {
          this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(8);
          cuh = 0;
          this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(cuh);
          cGD();
          return;
        }
      } while (1 != ((Integer)localPair.second).intValue());
      ((abhh)this.mBaseChatPie.app.getManager(153)).o(false, "panel open apollo", 1);
    } while (this.jdField_a_of_type_Acae == null);
    this.jdField_a_of_type_Acae.setPanelType(0);
    g(this.mBaseChatPie.app.getCurrentAccountUin(), true, false);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "click tab shop");
      }
      if ((this.mBaseChatPie != null) && (this.mBaseChatPie.app != null))
      {
        Object localObject = (abhh)this.mBaseChatPie.app.getManager(153);
        if ((this.bGC) && (this.jdField_d_of_type_ComTencentMobileqqDrawerPushItem != null))
        {
          ((abhh)localObject).a(this.jdField_d_of_type_ComTencentMobileqqDrawerPushItem, this.mBaseChatPie.app, this.mBaseChatPie.mContext, "aio_shop");
          ((abhh)localObject).a(this.jdField_d_of_type_ComTencentMobileqqDrawerPushItem);
          ((altq)this.mBaseChatPie.app.getManager(36)).OS(String.valueOf("103100.103200.103250"));
          this.H.dGB();
          this.bGC = false;
          cGJ();
          VipUtils.a(this.mBaseChatPie.app, "cmshow", "Apollo", "house_new_click", ApolloUtil.gi(this.mBaseChatPie.getCurType()), 0, new String[] { this.jdField_d_of_type_ComTencentMobileqqDrawerPushItem.msg_id });
          VipUtils.a(this.mBaseChatPie.app, "cmshow", "Apollo", "house_click", ApolloUtil.gi(this.mBaseChatPie.getCurType()), 0, new String[0]);
        }
        else
        {
          if (abhh.R(this.mBaseChatPie.app)) {}
          for (localObject = abxi.bju;; localObject = abxi.bjv)
          {
            ApolloUtil.a(this.mBaseChatPie.mActivity, null, "aio", (String)localObject, null);
            break;
          }
          if (this.mBaseChatPie != null)
          {
            VipUtils.a(this.mBaseChatPie.app, "cmshow", "Apollo", "clickslavenumber", 0, 0, new String[0]);
            ApolloUtil.a(this.mBaseChatPie.mActivity, null, "aio", abxi.bjv, null, 14003);
            continue;
            cGH();
            continue;
            cGL();
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.wW != null)
    {
      int i = 0;
      while (i < this.wW.size())
      {
        ((acbg)this.wW.get(i)).onDestroy();
        i += 1;
      }
    }
    if ((this.mBaseChatPie != null) && (this.mBaseChatPie.app != null))
    {
      abhh localabhh = (abhh)this.mBaseChatPie.app.getManager(153);
      if (localabhh != null)
      {
        localabhh.b(this.jdField_a_of_type_Abyz);
        localabhh.removeAllListener();
        if (this.jdField_b_of_type_Abhs != null) {
          this.jdField_b_of_type_Abhs.cBZ();
        }
      }
    }
    cGG();
    ThreadManager.getUIHandler().removeCallbacks(this.fH);
    this.q.removeMessages(1);
    this.q.removeMessages(2);
    cGH();
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager = null;
    this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter = null;
    this.jdField_a_of_type_Acae = null;
    this.jdField_a_of_type_Abyz = null;
    if (this.wW != null)
    {
      this.wW.clear();
      this.wW = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$a.onDestroy();
    }
    this.jdField_d_of_type_Auvw = null;
    this.jdField_e_of_type_JavaUtilDeque = null;
    cGP();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0) {
      super.getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, new Object[] { "ApolloPanel event " + paramMotionEvent.toString(), " 是否拦截：", Boolean.valueOf(super.onInterceptTouchEvent(paramMotionEvent)) });
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i == 1) || (i == 3)) {
        super.getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.bGB = true;
    yW(paramInt);
    this.bGB = false;
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public void onOpen()
  {
    if ((this.mBaseChatPie != null) && (this.mBaseChatPie.app != null))
    {
      ((aqrb)this.mBaseChatPie.app.getBusinessHandler(71)).dX(1, "actionPanel");
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "actionpanel onOpen");
      }
      this.bEy = -1;
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "onPageScrollStateChange state=" + paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "onPageScrolled i=" + paramInt1 + ",il=" + paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "pager position = " + paramInt);
    }
    int n = bv(paramInt);
    if ((this.wX.contains(Integer.valueOf(paramInt - 1))) || (this.wX.contains(Integer.valueOf(paramInt))) || (this.bGH))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "change tab index = " + paramInt);
      }
      setTabSelect(n);
      Iw(paramInt);
      this.cul = 0;
    }
    int i;
    int j;
    label413:
    Object localObject2;
    if (paramInt < cuh)
    {
      i = 1;
      cuh = paramInt;
      Iv(paramInt);
      this.cui = paramInt;
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.onPageSelected(gr(paramInt));
      if ((this.cy.get()) && (paramInt == 0) && (this.mBaseChatPie != null) && (this.g != null)) {
        VipUtils.a(this.mBaseChatPie.app, "cmshow", "Apollo", "recent_show", ApolloUtil.gi(this.g.cZ), 0, new String[0]);
      }
      j = Af();
      if ((j != -1) && (this.mBaseChatPie != null) && (this.mBaseChatPie.a() != null)) {
        VipUtils.a(this.mBaseChatPie.getApp(), "cmshow", "Apollo", "game_show", ApolloUtil.gi(this.mBaseChatPie.a().cZ), 0, new String[] { Integer.toString(j) });
      }
      if (this.mBaseChatPie == null) {
        return;
      }
      int k = 0;
      j = k;
      if (this.jdField_a_of_type_Acbf != null)
      {
        localObject1 = this.jdField_a_of_type_Acbf.getPackageList();
        j = k;
        if (localObject1 != null)
        {
          j = k;
          if (((List)localObject1).size() > 0)
          {
            j = k;
            if (n >= 0)
            {
              j = k;
              if (n < ((List)localObject1).size())
              {
                localObject1 = (ApolloActionPackage)((List)localObject1).get(n);
                j = k;
                if (localObject1 != null) {
                  j = ((ApolloActionPackage)localObject1).packageId;
                }
              }
            }
          }
        }
      }
      if (j != 6) {
        break label745;
      }
      this.jz.setVisibility(0);
      Object localObject1 = "";
      if (this.g != null) {
        localObject1 = this.g.aTl;
      }
      Object localObject3 = this.mBaseChatPie.app;
      k = ApolloUtil.gi(this.g.cZ);
      if (i == 0) {
        break label757;
      }
      localObject2 = "0";
      label464:
      VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "slide", (String)localObject1, k, j, new String[] { localObject2, "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      if ((this.wW == null) || (this.wW.size() <= 0)) {
        return;
      }
      localObject2 = null;
      localObject3 = this.wW.iterator();
      j = 0;
      label552:
      localObject1 = localObject2;
      if (((Iterator)localObject3).hasNext())
      {
        acbg localacbg = (acbg)((Iterator)localObject3).next();
        i = j;
        if (localacbg == null) {
          break label765;
        }
        i = j;
        if (!(localacbg instanceof acbg)) {
          break label765;
        }
        k = localacbg.Ad();
        j += k;
        i = j;
        if (paramInt + 1 > j) {
          break label765;
        }
        if (!(localacbg instanceof acae))
        {
          localObject1 = localObject2;
          if (!(localacbg instanceof abzg)) {}
        }
        else
        {
          localObject1 = localacbg.o(k - (j - paramInt));
        }
      }
      if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
        return;
      }
      localObject2 = new StringBuilder();
      i = ((ArrayList)localObject1).size();
      paramInt = 0;
      label679:
      if (paramInt >= i) {
        break label782;
      }
      localObject3 = (abzy)((ArrayList)localObject1).get(paramInt);
      if (((abzy)localObject3).c == null) {
        break label770;
      }
      ((StringBuilder)localObject2).append(((abzy)localObject3).c.actionId);
    }
    for (;;)
    {
      if (paramInt != i - 1) {
        ((StringBuilder)localObject2).append("-");
      }
      paramInt += 1;
      break label679;
      i = 0;
      break;
      label745:
      this.jz.setVisibility(8);
      break label413;
      label757:
      localObject2 = "1";
      break label464;
      label765:
      j = i;
      break label552;
      label770:
      ((StringBuilder)localObject2).append("0");
    }
    label782:
    VipUtils.a(this.mBaseChatPie.app, "cmshow", "Apollo", "actionexposure", this.g.aTl, ApolloUtil.gi(this.g.cZ), 0, new String[] { ((StringBuilder)localObject2).toString(), "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
  }
  
  public void onQueryUserApolloAction(boolean paramBoolean, Object paramObject)
  {
    boolean bool1 = true;
    if ((this.mBaseChatPie == null) || (this.mBaseChatPie.app == null)) {}
    boolean bool2;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, new Object[] { "[onQueryUserApolloAction] result=", Boolean.valueOf(paramBoolean), ", mIsGettingUserInfo=", Boolean.valueOf(this.bGz) });
      }
      if ((this.bGz) && (!paramBoolean))
      {
        this.cuj = -1;
        this.bEw = -1;
      }
      bool2 = this.bGz;
      this.bGz = false;
    } while (!paramBoolean);
    if (paramObject != null)
    {
      paramObject = (Bundle)paramObject;
      int i = paramObject.getInt("jumpPkdId", -1);
      int j = paramObject.getInt("jumpActionId", -1);
      if ((i != -1) && (j != -1))
      {
        this.cuj = i;
        this.bEw = j;
      }
    }
    if ((bool2) && (paramBoolean)) {}
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      g(this.mBaseChatPie.app.getCurrentUin(), false, paramBoolean);
      return;
    }
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if ((paramInt == 0) && (this.cum == 2) && (this.cun != -1) && (this.cun != paramInt)) {
      this.jdField_c_of_type_ComTencentMobileqqApolloViewApolloPanel$d.updateView();
    }
    this.cun = paramInt;
    if ((paramInt != 0) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView != null)) {
      cGM();
    }
    cGK();
  }
  
  public void s(int paramInt, View paramView)
  {
    if ((this.jdField_a_of_type_Acbf != null) && (this.mBaseChatPie != null) && (this.mBaseChatPie.app != null))
    {
      Object localObject = this.jdField_a_of_type_Acbf.getPackageList();
      if (((List)localObject).size() > paramInt)
      {
        localObject = (ApolloActionPackage)((List)localObject).get(paramInt);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, new Object[] { "[checkRedTab] packageId=", Integer.valueOf(((ApolloActionPackage)localObject).packageId), ", tabIndex= ", Integer.valueOf(paramInt), ", isUpdate=", Boolean.valueOf(((ApolloActionPackage)localObject).isUpdate), ", mIsGettingUserInfo=", Boolean.valueOf(this.bGz) });
        }
        if ((((ApolloActionPackage)localObject).isUpdate) && (NetConnInfoCenter.getServerTimeMillis() >= ((ApolloActionPackage)localObject).redStartTime))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, "clear tab red packageId=" + ((ApolloActionPackage)localObject).packageId + " tabIndex = " + paramInt);
          }
          ((acbf.a)paramView.getTag()).yc.setVisibility(4);
          ((ApolloActionPackage)localObject).isUpdate = false;
          paramInt = ((ApolloActionPackage)localObject).redFlowId;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, new Object[] { "[checkRedTab] pkg=", Integer.valueOf(((ApolloActionPackage)localObject).packageId), ", new action id=", Integer.valueOf(paramInt) });
          }
          ThreadManager.post(new ApolloPanel.21(this, (ApolloActionPackage)localObject), 5, null, true);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, new Object[] { "[checkRedTab] mShouldShowActionFloatView=", Boolean.valueOf(this.bGG), ", mIsTriggeredByClick=", Boolean.valueOf(this.bGB) });
          }
          this.q.removeMessages(1);
          if ((this.bGG) && (paramInt != 0))
          {
            paramView = this.q.obtainMessage(1);
            paramView.arg1 = paramInt;
            paramView.getData().putInt("pkgId", ((ApolloActionPackage)localObject).packageId);
            this.q.sendMessageDelayed(paramView, 800L);
          }
        }
      }
    }
  }
  
  public void setTabSelect(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[setTabSelect] newIndex=", Integer.valueOf(paramInt), ", mLastTabIndex=", Integer.valueOf(this.bTJ) });
    }
    int i;
    if (this.r != null)
    {
      Object localObject = this.r.getChild(this.bTJ);
      if (localObject != null) {
        ((View)localObject).setSelected(false);
      }
      if ((this.bTJ == -1) || (this.bTJ != paramInt)) {
        cGH();
      }
      localObject = this.r.getChild(paramInt);
      i = this.bTJ;
      this.bTJ = paramInt;
      if (localObject == null) {
        break label417;
      }
      ((View)localObject).setSelected(true);
      this.jdField_a_of_type_Acbf.IB(paramInt);
      if ((!this.bGI) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView == null) && (!this.jdField_a_of_type_Abhh$e.Yl()) && (!this.jdField_a_of_type_Abhh$e.Ym())) {
        s(paramInt, (View)localObject);
      }
      if ((this.mBaseChatPie != null) && (this.jdField_a_of_type_Acbf != null) && (this.jdField_a_of_type_Acbf.getPackageList() != null) && (this.jdField_a_of_type_Acbf.getPackageList().size() > paramInt) && (this.g != null))
      {
        localObject = (ApolloActionPackage)this.jdField_a_of_type_Acbf.getPackageList().get(paramInt);
        if ((((ApolloActionPackage)localObject).packageId == 100) && (i != paramInt)) {
          ApolloGameUtil.b(this.mBaseChatPie.app, this.g, 1);
        }
        QQAppInterface localQQAppInterface = this.mBaseChatPie.app;
        String str = this.g.aTl;
        int j = ((ApolloActionPackage)localObject).packageId;
        StringBuilder localStringBuilder = new StringBuilder().append("");
        if (!((ApolloActionPackage)localObject).isUpdate) {
          break label412;
        }
        i = 1;
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "clk_tab", str, j, 0, new String[] { i, "" + ApolloUtil.gi(this.g.cZ), "", String.valueOf(System.currentTimeMillis() / 1000L) });
      }
    }
    for (;;)
    {
      Ix(paramInt);
      return;
      label412:
      i = 0;
      break;
      label417:
      this.jdField_a_of_type_Acbf.IB(paramInt);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[setVisibility] visibility=", Integer.valueOf(paramInt) });
    }
    if (paramInt == 8)
    {
      this.q.removeMessages(1);
      cGH();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 1, "[setVisibility] gone, set mShouldShowActionFloatView true");
      }
      this.bGG = true;
    }
  }
  
  void yW(int paramInt)
  {
    if ((this.wW != null) && (this.wW.size() > paramInt) && (this.r != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "onClick tab postion=" + paramInt);
      }
      setTabSelect(paramInt);
      int i = 0;
      int j = 0;
      while (i < paramInt)
      {
        j += ((acbg)this.wW.get(i)).Ad();
        i += 1;
      }
      for (;;)
      {
        try
        {
          this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(j, false);
          Iw(j);
          Object localObject = this.jdField_a_of_type_Acbf.getPackageList();
          if (localObject == null) {
            break;
          }
          if (((List)localObject).isEmpty()) {
            return;
          }
          localObject = (ApolloActionPackage)((List)localObject).get(paramInt);
          if (this.mBaseChatPie.sessionInfo.cZ == 3000)
          {
            paramInt = 2;
            VipUtils.a(null, "cmshow", "Apollo", "clciktabreddot", paramInt, 0, new String[] { String.valueOf(((ApolloActionPackage)localObject).packageId) });
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("ApolloPanel", 2, "setCurrentItem exception e=" + localThrowable.toString());
          return;
        }
        paramInt = this.mBaseChatPie.sessionInfo.cZ;
      }
    }
  }
  
  public class KapuPkgStateReceiver
    extends BroadcastReceiver
  {
    public KapuPkgStateReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      Object localObject = paramIntent.getDataString();
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
      do
      {
        do
        {
          do
          {
            return;
            paramContext = "";
            localObject = ((String)localObject).split(":");
            if (localObject.length == 2) {
              paramContext = localObject[1];
            }
          } while (!ApolloUtil.rw().equals(paramContext));
          paramContext = paramIntent.getAction();
          QLog.d("ApolloPanel", 1, new Object[] { "kapu package state changed=", paramContext });
          if (!"android.intent.action.PACKAGE_REMOVED".equals(paramContext)) {
            break;
          }
        } while (!ApolloPanel.f(ApolloPanel.this));
        ApolloPanel.d(ApolloPanel.this, false);
        QLog.d("ApolloPanel", 1, "kapu remove, refresh");
        ApolloPanel.this.Dk(ApolloPanel.this.mBaseChatPie.app.getCurrentUin());
        return;
      } while ((!"android.intent.action.PACKAGE_ADDED".equals(paramContext)) || (ApolloPanel.f(ApolloPanel.this)));
      ApolloPanel.d(ApolloPanel.this, true);
      QLog.d("ApolloPanel", 1, "kapu installed, refresh");
      ApolloPanel.this.Dk(ApolloPanel.this.mBaseChatPie.app.getCurrentUin());
    }
  }
  
  public class a
    extends aquy
    implements View.OnClickListener, asce.a
  {
    private Intent U;
    private ascd jdField_a_of_type_Ascd = new ascd();
    private ApolloKapuEntranceTips jdField_a_of_type_ComTencentMobileqqDataApolloKapuEntranceTips;
    private volatile boolean bGM;
    private volatile boolean btf;
    private ApolloLottieAnim c;
    private int cus;
    private int mActionId;
    private float mProgress;
    private volatile int mStatus = 0;
    
    public a()
    {
      this.jdField_a_of_type_Ascd.a(this);
      this.c = new ApolloLottieAnim(ApolloPanel.this.mBaseChatPie.app, ApolloPanel.this.mBaseChatPie.a());
      this.c.a(ApolloPanel.a(ApolloPanel.this), abhh.d.bgd, abxi.biw + "kapu/apollo_kapu_progress_lottie.zip", false);
    }
    
    private JSONObject X()
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("appId", abhh.d.sAppId);
        localJSONObject.put("iconUrl", abhh.d.sIconUrl);
        localJSONObject.put("apkUrl", abhh.d.bgc);
        localJSONObject.put("packageName", abhh.d.WX);
        localJSONObject.put("versionCode", abhh.d.sVersionCode);
        localJSONObject.put("apkSign", abhh.d.bgf);
        localJSONObject.put("appName", abhh.d.sAppName);
        localJSONObject.put("sourceId", "biz_src_zf_lmx");
        return localJSONObject;
      }
      catch (Exception localException)
      {
        QLog.e("CmshowAppController", 1, localException, new Object[0]);
      }
      return null;
    }
    
    private boolean ZE()
    {
      boolean bool = true;
      Object localObject = abhh.d.bgc;
      if ((ApolloPanel.this.mBaseChatPie == null) || (ApolloPanel.this.mBaseChatPie.app == null) || (TextUtils.isEmpty((CharSequence)localObject))) {
        bool = false;
      }
      do
      {
        return bool;
        localObject = X();
      } while (localObject == null);
      ApolloPanel.c(ApolloPanel.this, true);
      if (this.bGM)
      {
        this.jdField_a_of_type_Ascd.d((JSONObject)localObject, 2);
        return true;
      }
      this.btf = true;
      return true;
    }
    
    private void aC(float paramFloat)
    {
      ApolloPanel.a(ApolloPanel.this).post(new ApolloPanel.CmshowAppController.3(this, paramFloat));
    }
    
    private Drawable aI()
    {
      Object localObject = abhh.d.sIconUrl;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mFailedDrawable = ApolloPanel.this.getResources().getDrawable(2130838557);
      localURLDrawableOptions.mLoadingDrawable = ApolloPanel.this.getResources().getDrawable(2130838557);
      localObject = abtn.a("" + ((String)localObject).hashCode(), localURLDrawableOptions, (String)localObject, false);
      if (localObject != null) {
        ((URLDrawable)localObject).startDownload();
      }
      return localObject;
    }
    
    private void cGR()
    {
      if (QLog.isColorLevel()) {
        QLog.d("CmshowAppController", 2, "checkEntranceTips");
      }
      this.jdField_a_of_type_ComTencentMobileqqDataApolloKapuEntranceTips = null;
      if ((ApolloPanel.this.mBaseChatPie == null) || (ApolloPanel.this.mBaseChatPie.app == null)) {}
      for (;;)
      {
        return;
        abxk localabxk = (abxk)ApolloPanel.this.mBaseChatPie.app.getManager(155);
        ApolloKapuEntranceTips localApolloKapuEntranceTips;
        if (this.mStatus == 3) {
          localApolloKapuEntranceTips = localabxk.a(true);
        }
        while (localApolloKapuEntranceTips != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("CmshowAppController", 2, new Object[] { "checkEntranceTips, tips=", localApolloKapuEntranceTips });
          }
          if (localApolloKapuEntranceTips.duration > 0L) {}
          for (int i = (int)(localApolloKapuEntranceTips.duration / 1000L);; i = 5)
          {
            ApolloPanel.a(ApolloPanel.this, ApolloPanel.a(ApolloPanel.this), 49, localApolloKapuEntranceTips.text, i, this);
            localApolloKapuEntranceTips.shownCount += 1;
            localabxk.a(localApolloKapuEntranceTips);
            abhh.t(101, String.valueOf(localApolloKapuEntranceTips.adId), localApolloKapuEntranceTips.traceInfo);
            this.jdField_a_of_type_ComTencentMobileqqDataApolloKapuEntranceTips = localApolloKapuEntranceTips;
            return;
            if ((this.mStatus != 0) && (this.mStatus != 2)) {
              break label215;
            }
            localApolloKapuEntranceTips = localabxk.a(false);
            break;
          }
          label215:
          localApolloKapuEntranceTips = null;
        }
      }
    }
    
    private void jz()
    {
      this.jdField_a_of_type_Ascd.d(X(), 5);
    }
    
    private void updateUI()
    {
      if (ApolloPanel.b(ApolloPanel.this).getBackground() == null) {
        ApolloPanel.b(ApolloPanel.this).setBackgroundDrawable(aI());
      }
      if (this.mStatus == 1)
      {
        aC(this.mProgress);
        return;
      }
      ApolloPanel.a(ApolloPanel.this).endAnimation();
      ApolloPanel.a(ApolloPanel.this).setVisibility(8);
    }
    
    public void IA(int paramInt)
    {
      QLog.d("CmshowAppController", 1, new Object[] { "download, downloadSrc=", Integer.valueOf(paramInt), ", mStatus=", Integer.valueOf(this.mStatus) });
      this.cus = paramInt;
      if (this.mStatus == 1) {}
      Context localContext;
      do
      {
        return;
        localContext = ApolloPanel.this.getContext();
        if (!aqiw.isNetworkAvailable(localContext))
        {
          QQToast.a(localContext, 1, localContext.getString(2131696743), 0).show(0);
          return;
        }
        if (!aqiw.isWifiConnected(ApolloPanel.this.getContext())) {
          break;
        }
        QQToast.a(localContext, localContext.getString(2131690378), 0).show(0);
      } while (!ZE());
      this.mStatus = 1;
      updateUI();
      ApolloPanel.this.cGN();
      return;
      acaz localacaz = new acaz(this);
      acba localacba = new acba(this, localContext);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("即将消耗");
      localStringBuilder.append(abhh.d.bge);
      localStringBuilder.append("流量下载厘米秀APP，当前为非WIFI网络，是否继续下载？");
      aqha.a(localContext, 230, acfp.m(2131702618), localStringBuilder.toString(), acfp.m(2131702614), acfp.m(2131702612), localacba, localacaz).show();
    }
    
    public void a(int paramInt, WadlResult paramWadlResult)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CmshowAppController", 2, new Object[] { "onTaskStatusChanged localStatus:", Integer.valueOf(paramInt), ",wadlResult:", paramWadlResult });
      }
      switch (paramInt)
      {
      default: 
      case 4: 
      case -2: 
        do
        {
          do
          {
            do
            {
              return;
              ApolloPanel.c(ApolloPanel.this, false);
            } while (this.mStatus == 2);
            this.mStatus = 2;
            ApolloPanel.a(ApolloPanel.this).post(new ApolloPanel.CmshowAppController.4(this));
            if (this.cus == 1)
            {
              abhh.g(103, String.valueOf(abhh.d.coN), abhh.d.sTraceInfo, "{\"returnValue\":0}");
              return;
            }
          } while ((this.cus != 3) || (ApolloPanel.this.g == null));
          VipUtils.a(ApolloPanel.this.mBaseChatPie.app, "cmshow", "Apollo", "unlockeddownloadsuccess", ApolloUtil.gi(ApolloPanel.this.g.cZ), 0, new String[] { String.valueOf(this.mActionId) });
          return;
          ApolloPanel.c(ApolloPanel.this, false);
          this.mStatus = 0;
          ThreadManager.getUIHandler().post(new ApolloPanel.CmshowAppController.5(this));
        } while (this.cus != 1);
        abhh.g(103, String.valueOf(abhh.d.coN), abhh.d.sTraceInfo, "{\"returnValue\":1}");
        return;
      }
      this.mProgress = (paramWadlResult.progress / 100.0F);
      aC(this.mProgress);
    }
    
    void cGQ()
    {
      refresh();
      if (ApolloPanel.a(ApolloPanel.this) != null)
      {
        ApolloPanel.a(ApolloPanel.this).removeMessages(3);
        ApolloPanel.a(ApolloPanel.this).sendEmptyMessageDelayed(3, 1000L);
      }
    }
    
    void checkStatus()
    {
      if (aqiz.isAppInstalled(ApolloPanel.this.getContext(), abhh.d.WX))
      {
        this.mStatus = 3;
        this.U = ApolloPanel.this.getContext().getPackageManager().getLaunchIntentForPackage(abhh.d.WX);
        if (this.U != null) {
          this.U.putExtra("big_brother_source_key", "biz_src_zf_lmx");
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CmshowAppController", 2, new Object[] { "checkStatus mStatus:", Integer.valueOf(this.mStatus) });
        }
        if (this.mStatus == 0) {}
        return;
        if (ApolloPanel.e(ApolloPanel.this))
        {
          this.mStatus = 1;
        }
        else
        {
          this.mStatus = 0;
          this.bGM = false;
          this.jdField_a_of_type_Ascd.XG(abhh.d.sAppId);
        }
      }
    }
    
    public void dx(ArrayList<WadlResult> paramArrayList)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CmshowAppController", 2, new Object[] { "onTaskQuery resInfos:", paramArrayList, ",mIsNeedDownload:", Boolean.valueOf(this.btf) });
      }
      this.bGM = true;
      if (this.jdField_a_of_type_Ascd.a(abhh.d.sAppId, abhh.d.bgc, abhh.d.sVersionCode, paramArrayList))
      {
        this.mStatus = 0;
        if (this.btf)
        {
          ZE();
          this.mStatus = 1;
          this.btf = false;
        }
      }
      do
      {
        return;
        if (this.mStatus == 1) {
          jz();
        }
        this.mStatus = 2;
      } while (!QLog.isColorLevel());
      QLog.d("CmshowAppController", 2, new Object[] { "onTaskQuery find apk already download, mStatus:", Integer.valueOf(this.mStatus) });
    }
    
    public void gQ(int paramInt1, int paramInt2)
    {
      this.mActionId = paramInt2;
      IA(paramInt1);
    }
    
    public void onClick(View paramView)
    {
      for (;;)
      {
        try
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataApolloKapuEntranceTips != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqDataApolloKapuEntranceTips.isClick = true;
            if ((ApolloPanel.this.mBaseChatPie != null) && (ApolloPanel.this.mBaseChatPie.app != null)) {
              ((abxk)ApolloPanel.this.mBaseChatPie.app.getManager(155)).a(this.jdField_a_of_type_ComTencentMobileqqDataApolloKapuEntranceTips);
            }
            if (paramView.getId() != 2131363776) {
              abhh.t(102, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataApolloKapuEntranceTips.adId), this.jdField_a_of_type_ComTencentMobileqqDataApolloKapuEntranceTips.traceInfo);
            }
          }
          if ((ApolloPanel.this.d != null) && (ApolloPanel.this.d.isShowing())) {
            ApolloPanel.this.d.dismiss();
          }
          switch (this.mStatus)
          {
          }
        }
        catch (Exception localException)
        {
          QLog.e("CmshowAppController", 2, localException, new Object[0]);
          if (this.mStatus != 3) {
            continue;
          }
          QQToast.a(ApolloPanel.this.getContext(), 1, acfp.m(2131702627), 0).show(0);
          refresh();
          continue;
          jz();
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqDataApolloKapuEntranceTips == null) {
            continue;
          }
          boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataApolloKapuEntranceTips.activityUrl);
          if (bool) {
            continue;
          }
          try
          {
            this.U = new Intent("android.intent.action.VIEW");
            this.U.putExtra("big_brother_source_key", "biz_src_zf_lmx");
            Object localObject = new JSONObject();
            ((JSONObject)localObject).put("url", this.jdField_a_of_type_ComTencentMobileqqDataApolloKapuEntranceTips.activityUrl);
            localObject = Uri.parse(String.format("cmshowidol://ui_openPage?pageName=webBrowser&data=%s", new Object[] { URLEncoder.encode(((JSONObject)localObject).toString(), "UTF-8") }));
            this.U.setData((Uri)localObject);
            QLog.d("CmshowAppController", 1, new Object[] { "open kapu with url=", this.jdField_a_of_type_ComTencentMobileqqDataApolloKapuEntranceTips.activityUrl });
            if (this.U != null)
            {
              ApolloPanel.this.getContext().startActivity(this.U);
              abhh.t(102, String.valueOf(abhh.d.coN), abhh.d.sTraceInfo);
            }
          }
          catch (Throwable localThrowable)
          {
            QLog.e("CmshowAppController", 1, "parse kapu activity uri failed, e", localThrowable);
            continue;
            refresh();
            continue;
          }
          int i = this.mStatus;
          if (i != 2) {
            continue;
          }
          i = 2;
          continue;
          i = 1;
          continue;
          QQToast.a(ApolloPanel.this.getContext(), 1, acfp.m(2131702619), 0).show(0);
          continue;
          continue;
        }
        if (this.mStatus != 3) {
          continue;
        }
        i = 0;
        VipUtils.a(ApolloPanel.this.mBaseChatPie.app, "cmshow", "Apollo", "aio_clickkapoo", ApolloUtil.gi(ApolloPanel.this.mBaseChatPie.getCurType()), i, new String[0]);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        IA(1);
      }
    }
    
    public void onDestroy()
    {
      this.c.destroy();
      this.jdField_a_of_type_Ascd.destroy();
    }
    
    void refresh()
    {
      checkStatus();
      updateUI();
    }
  }
  
  public static class b
  {
    public int actionId;
    public String actionName;
    public String gameExtendJson;
    public int gameId;
    public int gameMode;
    public String gameName;
    public int gameStatus;
    public int msgType = 3;
    public long roomId;
    
    public void init()
    {
      this.gameId = 0;
      this.roomId = 0L;
      this.gameMode = 0;
      this.gameName = "";
      this.actionName = "";
      this.gameExtendJson = "";
      this.msgType = 3;
    }
    
    public void print()
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("gameId:").append(this.gameId).append(",roomId:").append(this.roomId).append(",actionId:").append(this.actionId).append(",gameName:").append(this.gameName).append(",wording:").append(",imgType:");
        QLog.d("ApolloPanel", 2, localStringBuilder.toString());
      }
    }
  }
  
  public static class c
  {
    public int cut;
    public WeakReference<View.OnClickListener> gb;
    public int mPosition;
    public String mText;
    public View mView;
    
    c(View paramView, int paramInt1, String paramString, int paramInt2, View.OnClickListener paramOnClickListener)
    {
      this.mView = paramView;
      this.mPosition = paramInt1;
      this.mText = paramString;
      this.cut = paramInt2;
      if (paramOnClickListener != null) {
        this.gb = new WeakReference(paramOnClickListener);
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void Iv(int paramInt);
    
    public abstract acbg a(int paramInt);
    
    public abstract void d(List<acbg> paramList, List<ApolloActionPackage> paramList1, boolean paramBoolean);
    
    public abstract boolean in(int paramInt);
    
    public abstract void updateView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel
 * JD-Core Version:    0.7.0.1
 */