import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController.3;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController.9;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.os.MqqHandler;

public class oac
{
  ImageButton R = null;
  private nzt jdField_a_of_type_Nzt = new oad(this);
  nzu jdField_a_of_type_Nzu;
  int aji = 0;
  public boolean avU = true;
  int bdA = 0;
  private int bdy;
  public int bdz = 0;
  nzx c;
  private acje d = new oae(this);
  HorizontalListView f;
  public QQAppInterface mApp;
  public WeakReference<Activity> mContext;
  public View nn;
  ViewStub s = null;
  
  public oac(Activity paramActivity, QQAppInterface paramQQAppInterface, nzu paramnzu)
  {
    this.mContext = new WeakReference(paramActivity);
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_Nzu = paramnzu;
    this.bdy = ((int)paramActivity.getResources().getDimension(2131298404));
    registerObserver();
    ThreadManager.getSubThreadHandler().post(new SubscriptRecommendController.3(this));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences(str, 0).edit();
    localEditor.putBoolean("is_show_subscribe_red_point" + str, true);
    localEditor.putBoolean("is_show_subscribe_folder_red_dot" + str, true);
    localEditor.putInt("pa_subscribe_config_show" + str, paramInt);
    localEditor.putString("pa_subscribe_config_msg" + str, paramString);
    localEditor.commit();
    paramString = oan.a();
    paramString.f(paramQQAppInterface, false);
    paramString.g(paramQQAppInterface, true);
    paramString.h(paramQQAppInterface, true);
    paramString.i(paramQQAppInterface, true);
    paramString.an(paramQQAppInterface);
  }
  
  public static boolean a(AppInterface paramAppInterface, boolean paramBoolean, String paramString)
  {
    paramAppInterface = paramAppInterface.getApp().getSharedPreferences(paramAppInterface.getCurrentAccountUin(), 4).edit();
    paramAppInterface.putBoolean("subscript_full_recommend", paramBoolean);
    paramAppInterface.putString("subscirpt_full_recommend_url", paramString);
    return paramAppInterface.commit();
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putBoolean("subscript_inner_recommend", paramBoolean);
    paramQQAppInterface.commit();
  }
  
  private void bcS()
  {
    if ((this.nn == null) || (this.s == null) || (this.mContext == null) || (this.mContext.get() == null)) {}
    while (this.nn.getVisibility() != 0) {
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation((Context)this.mContext.get(), 2130772258);
    localAnimation.setFillAfter(true);
    localAnimation.setAnimationListener(new oaj(this));
    uu(0);
    this.nn.startAnimation(localAnimation);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, int paramInt)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    localEditor.putInt("subscribe_version" + paramQQAppInterface.getCurrentAccountUin(), paramInt);
    localEditor.commit();
  }
  
  public static void c(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    localEditor.putBoolean("is_show_subscribe_red_point" + paramQQAppInterface.getCurrentAccountUin(), paramBoolean);
    localEditor.commit();
  }
  
  public static int d(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("subscribe_version" + paramQQAppInterface.getCurrentAccountUin(), 0);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, int paramInt)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    localEditor.putInt("subscript_full_recommend_version" + paramQQAppInterface.getCurrentAccountUin(), paramInt);
    localEditor.commit();
  }
  
  public static void d(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    localEditor.putBoolean("is_show_subscribe_folder_red_dot" + paramQQAppInterface.getCurrentAccountUin(), paramBoolean);
    localEditor.commit();
  }
  
  public static int e(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("subscript_full_recommend_version" + paramQQAppInterface.getCurrentAccountUin(), -1);
  }
  
  public static void e(QQAppInterface paramQQAppInterface, int paramInt)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    localEditor.putInt("subscript_inner_recommend_version" + paramQQAppInterface.getCurrentAccountUin(), paramInt);
    localEditor.commit();
  }
  
  public static void e(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putBoolean("subscribe_discovery_btn", paramBoolean);
    paramQQAppInterface.commit();
  }
  
  public static int f(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("subscript_inner_recommend_version" + paramQQAppInterface.getCurrentAccountUin(), -1);
  }
  
  public static String f(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getString("subscirpt_full_recommend_url", "");
  }
  
  public static String g(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getString("pa_subscribe_config_msg" + paramQQAppInterface.getCurrentAccountUin(), "");
  }
  
  public static boolean j(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    boolean bool1 = bool2;
    if (paramQQAppInterface.getBoolean("subscript_inner_recommend", false))
    {
      bool1 = bool2;
      if (!paramQQAppInterface.getBoolean("subscript_full_recommend", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean k(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("subscript_full_recommend", false);
  }
  
  public static boolean l(QQAppInterface paramQQAppInterface)
  {
    return (paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("is_show_subscribe_red_point" + paramQQAppInterface.getCurrentAccountUin(), true)) && (o(paramQQAppInterface));
  }
  
  public static boolean m(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("pa_subscribe_config_show" + paramQQAppInterface.getCurrentAccountUin(), 1) != 0;
  }
  
  public static boolean n(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("is_show_subscribe_folder_red_dot" + paramQQAppInterface.getCurrentAccountUin(), true);
  }
  
  public static boolean o(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("subscribe_discovery_btn", true);
  }
  
  private void registerObserver()
  {
    if (this.mApp != null)
    {
      this.mApp.addObserver(this.jdField_a_of_type_Nzt);
      this.mApp.addObserver(this.d);
    }
  }
  
  private void unRegisterObserver()
  {
    if (this.mApp != null)
    {
      this.mApp.removeObserver(this.d);
      this.mApp.removeObserver(this.jdField_a_of_type_Nzt);
    }
  }
  
  public void bcO()
  {
    this.bdz = 1;
    if ((this.mContext == null) || (this.mContext.get() == null)) {
      return;
    }
    if (this.s == null) {
      if ((this.mContext != null) && (this.mContext.get() != null))
      {
        this.s = ((ViewStub)((Activity)this.mContext.get()).findViewById(2131377751));
        if (this.s != null)
        {
          this.s.setOnInflateListener(new oaf(this));
          this.nn = this.s.inflate();
          bcP();
          update();
        }
      }
    }
    for (;;)
    {
      anot.a(this.mApp, "CliOper", "", "", "0X8006431", "0X8006431", 0, 0, "", "", "", "");
      return;
      bcR();
      uu(this.bdy);
    }
  }
  
  @TargetApi(9)
  public void bcP()
  {
    boolean bool = ThemeUtil.isInNightMode(this.mApp);
    Object localObject1 = ((Activity)this.mContext.get()).getResources();
    if (bool)
    {
      i = 2131166345;
      i = ((Resources)localObject1).getColor(i);
      this.nn.setBackgroundColor(i);
      this.nn.setOnClickListener(new oag(this));
      Object localObject2 = (ImageView)this.nn.findViewById(2131378977);
      if (localObject2 != null)
      {
        if (!ThemeUtil.isInNightMode(this.mApp)) {
          break label263;
        }
        i = 2131167483;
        label93:
        ((ImageView)localObject2).setBackgroundResource(i);
      }
      localObject2 = (TextView)this.nn.findViewById(2131379769);
      if (!bool) {
        break label270;
      }
      i = ((Resources)localObject1).getColor(2131166334);
      label126:
      ((TextView)localObject2).setTextColor(i);
      if (this.f == null)
      {
        this.f = ((HorizontalListView)this.nn.findViewById(2131377746));
        this.f.setDividerWidth((int)((Resources)localObject1).getDimension(2131298405));
        this.f.setAdapter(this.c);
        if (Build.VERSION.SDK_INT >= 9) {
          this.f.setOverScrollMode(2);
        }
      }
      if (this.R == null)
      {
        this.R = ((ImageButton)this.nn.findViewById(2131364677));
        localObject1 = this.R;
        if (bool) {
          break label281;
        }
      }
    }
    label263:
    label270:
    label281:
    for (int i = 2130844039;; i = 2130844041)
    {
      ((ImageButton)localObject1).setImageResource(i);
      this.R.setOnClickListener(new oah(this));
      return;
      i = 2131166335;
      break;
      i = 2131166633;
      break label93;
      i = ((Resources)localObject1).getColor(2131166333);
      break label126;
    }
  }
  
  public void bcQ()
  {
    if (eO())
    {
      localObject = (Activity)this.mContext.get();
      if (localObject != null) {}
    }
    else
    {
      return;
    }
    int i = aqcx.dip2px((Context)localObject, 100.0F);
    Object localObject = (ImageView)((Activity)localObject).findViewById(2131373775);
    this.bdA = ((ImageView)localObject).getHeight();
    this.aji = ((ImageView)localObject).getWidth();
    ((ImageView)localObject).setLayoutParams(new LinearLayout.LayoutParams(i, i));
  }
  
  void bcR()
  {
    if ((this.nn == null) || (this.s == null) || (this.mContext == null) || (this.mContext.get() == null)) {}
    while (this.nn.getVisibility() == 0) {
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation((Context)this.mContext.get(), 2130772259);
    localAnimation.setFillAfter(true);
    localAnimation.setAnimationListener(new oai(this));
    this.s.setVisibility(0);
    this.nn.setVisibility(0);
    this.nn.startAnimation(localAnimation);
  }
  
  public void destory()
  {
    unRegisterObserver();
    if (this.c != null) {
      this.c.destory();
    }
  }
  
  public void dq(View paramView)
  {
    this.bdz = 3;
    this.nn = paramView;
    this.nn.setVisibility(0);
  }
  
  public boolean eO()
  {
    Activity localActivity = (Activity)this.mContext.get();
    if (localActivity == null) {
      return false;
    }
    View localView = localActivity.findViewById(2131366417);
    WindowManager localWindowManager = (WindowManager)localActivity.getSystemService("window");
    int i = localWindowManager.getDefaultDisplay().getWidth();
    int j = localWindowManager.getDefaultDisplay().getHeight();
    int k = (int)localActivity.getResources().getDimension(2131299627);
    int m = (int)localActivity.getResources().getDimension(2131299633);
    int n = this.bdy;
    int i1 = localView.getHeight();
    int i2 = localView.getWidth();
    int i3 = ImmersiveUtils.getStatusBarHeight(localActivity);
    if ((i < i2) || (j - (k + m + n) - i3 < i1)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void oW(String paramString)
  {
    if (this.mApp != null) {
      ((nzs)this.mApp.getBusinessHandler(64)).oV(paramString);
    }
  }
  
  public void reload()
  {
    ThreadManager.getSubThreadHandler().post(new SubscriptRecommendController.9(this));
  }
  
  void setData(List<nzw> paramList)
  {
    if ((this.mContext == null) || (this.mContext.get() == null)) {
      return;
    }
    if (this.c == null) {
      this.c = new nzx((Activity)this.mContext.get(), this.mApp, this.jdField_a_of_type_Nzu);
    }
    this.c.clear();
    this.c.add(paramList);
  }
  
  public void showEmptyView()
  {
    bcQ();
  }
  
  public void update()
  {
    if (this.c != null) {
      this.c.notifyDataSetChanged();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("SubscriptRecommendController", 2, "scriptRecommendAdapter is null");
  }
  
  void uu(int paramInt)
  {
    if ((this.mContext == null) || (this.mContext.get() == null)) {}
    View localView;
    do
    {
      return;
      localView = ((Activity)this.mContext.get()).findViewById(2131370527);
    } while (localView == null);
    localView.setPadding(0, 0, 0, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oac
 * JD-Core Version:    0.7.0.1
 */