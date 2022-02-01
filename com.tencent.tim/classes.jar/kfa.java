import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.DailyDynamicHeaderViewController.11;
import com.tencent.biz.pubaccount.readinjoy.DailyDynamicHeaderViewController.9;
import com.tencent.biz.pubaccount.readinjoy.view.DailyTitleBar;
import com.tencent.biz.pubaccount.readinjoy.view.DailyTitleBarSwitcher;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDailyPullToZoomHeaderXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

public class kfa
{
  private final aczc.b jdField_a_of_type_Aczc$b = new kfh(this, "readinjoy_weather");
  private DailyTitleBarSwitcher jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBarSwitcher;
  private int aIr = -1;
  private ViewGroup aL;
  private final lce b = new kfi(this);
  private final View.OnClickListener cg = new kfb(this);
  private final View.OnClickListener ch = new kfd(this);
  private final View.OnClickListener ci = new kfe(this);
  private final View.OnClickListener cj = new kff(this);
  private View.OnClickListener ck;
  private ImageView hS;
  private int mCurrentState = -1;
  private View mRootView;
  private final VafContext mVafContext;
  
  public kfa(@NonNull VafContext paramVafContext)
  {
    this.mVafContext = paramVafContext;
  }
  
  private void K(JSONObject paramJSONObject)
  {
    if (this.mRootView == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBarSwitcher == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBarSwitcher = ((DailyTitleBarSwitcher)this.mRootView.findViewById(2131365576));
      }
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBarSwitcher == null) || (paramJSONObject == null));
    String str = paramJSONObject.optString("weather_summary_title");
    paramJSONObject = paramJSONObject.optString("weather_jump_url");
    if (!TextUtils.isEmpty(str))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBarSwitcher.setBackgroundViewTitle(str, 12.0F);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBarSwitcher.setOnTitleClickWeatherListener(new kfc(this, paramJSONObject));
      return;
    }
    QLog.i("DailyHeaderViewController", 1, "bindDataForTitleBar, no data.");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBarSwitcher.setBackgroundViewTitle("", 12.0F);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBarSwitcher.setOnTitleClickWeatherListener(null);
  }
  
  private void L(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    lZ(paramJSONObject.optString("background_url"));
    K(paramJSONObject);
    this.hS.requestLayout();
  }
  
  private static Container a(VafContext paramVafContext, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        Object localObject = paramJSONObject.optString("style_ID", "null");
        QLog.i("DailyHeaderViewController", 1, "[inflateProteusView] " + (String)localObject);
        localObject = npi.a("daily_dynamic_header", true);
        if (localObject != null)
        {
          paramJSONObject = ((npi)localObject).getTemplateBean(paramJSONObject);
          if (paramJSONObject != null)
          {
            paramVafContext = paramVafContext.getViewFactory().inflate(paramVafContext, paramJSONObject);
            kvx.bindDynamicValueWithoutRecursion(paramVafContext, null, paramJSONObject);
            paramVafContext.setTag(paramJSONObject);
            return paramVafContext;
          }
          QLog.e("DailyHeaderViewController", 1, "[inflateProteusView] template bean is null");
          return null;
        }
      }
      catch (Exception paramVafContext)
      {
        QLog.e("DailyHeaderViewController", 1, "[inflateProteusView] ", paramVafContext);
        return null;
      }
      paramJSONObject = null;
    }
  }
  
  private Container a(JSONObject paramJSONObject, View.OnClickListener paramOnClickListener)
  {
    if ((this.aIr == -1) || (this.aIr == 0))
    {
      Container localContainer = a(this.mVafContext, paramJSONObject);
      if (localContainer != null)
      {
        Drawable localDrawable = this.mRootView.getContext().getResources().getDrawable(2130844009);
        a(this.mRootView, localContainer, localDrawable, paramJSONObject);
        this.aL.setOnClickListener(paramOnClickListener);
        return localContainer;
      }
      oA(0);
    }
    for (;;)
    {
      return null;
      aBW();
      paramJSONObject = a(this.mVafContext, paramJSONObject);
      if (paramJSONObject != null)
      {
        this.aL.setOnClickListener(paramOnClickListener);
        a(this.aL, paramJSONObject);
        this.hS.setImageResource(2130844009);
        return paramJSONObject;
      }
      oA(0);
    }
  }
  
  private static URLDrawable.URLDrawableOptions a(Context paramContext)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    paramContext = paramContext.getResources().getDrawable(2130844009);
    localURLDrawableOptions.mLoadingDrawable = paramContext;
    localURLDrawableOptions.mFailedDrawable = paramContext;
    return localURLDrawableOptions;
  }
  
  private void a(@NonNull View paramView, @NonNull Container paramContainer, @NonNull Drawable paramDrawable, JSONObject paramJSONObject)
  {
    QLog.i("DailyHeaderViewController", 1, "[setupDynamicHeader] ");
    ((DailyTitleBar)paramView.findViewById(2131372474)).setVisibility(8);
    DailyTitleBarSwitcher localDailyTitleBarSwitcher = (DailyTitleBarSwitcher)paramView.findViewById(2131365576);
    localDailyTitleBarSwitcher.setVisibility(0);
    localDailyTitleBarSwitcher.setOnLeftButtonClickListener(this.cg);
    localDailyTitleBarSwitcher.setOnRightButtonClickListener(this.ch);
    localDailyTitleBarSwitcher.setOnTitleClickListener(this.ck);
    ReadInJoyDailyPullToZoomHeaderXListView localReadInJoyDailyPullToZoomHeaderXListView = (ReadInJoyDailyPullToZoomHeaderXListView)paramView.findViewById(2131379011);
    this.aL = ((ViewGroup)LayoutInflater.from(paramView.getContext()).inflate(2131560342, localReadInJoyDailyPullToZoomHeaderXListView, false));
    this.hS = ((ImageView)this.aL.findViewById(2131363240));
    key.E(paramDrawable);
    key.h(this.hS);
    this.hS.setImageDrawable(paramDrawable);
    a(this.aL, paramContainer);
    localReadInJoyDailyPullToZoomHeaderXListView.c(localDailyTitleBarSwitcher.getOnScrollListener());
    localReadInJoyDailyPullToZoomHeaderXListView.addHeaderView(this.aL);
    localReadInJoyDailyPullToZoomHeaderXListView.setHeaderImage(this.hS);
    K(paramJSONObject);
  }
  
  private static void a(ViewGroup paramViewGroup, Container paramContainer)
  {
    Layout.Params localParams = paramContainer.getVirtualView().getComLayoutParams();
    paramViewGroup.addView(paramContainer, new ViewGroup.LayoutParams(localParams.mLayoutWidth, localParams.mLayoutHeight));
  }
  
  private static void a(Container paramContainer, String paramString, JSONObject paramJSONObject)
  {
    if (paramContainer == null)
    {
      QLog.e("DailyHeaderViewController", 1, "[setupListeners] container is null");
      return;
    }
    ViewFactory.findClickableViewListener(paramContainer.getVirtualView(), new kfk(paramString, paramJSONObject));
  }
  
  private void a(@NonNull BaseActivity paramBaseActivity, @NonNull Runnable paramRunnable)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (paramBaseActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        paramBaseActivity.requestPermissions(new kfj(this, paramRunnable), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        return;
      }
      paramRunnable.run();
      return;
    }
    paramRunnable.run();
  }
  
  private static boolean a(Container paramContainer, JSONObject paramJSONObject)
  {
    Object localObject = paramContainer.getTag();
    if ((localObject instanceof TemplateBean))
    {
      localObject = (TemplateBean)localObject;
      try
      {
        npi localnpi = npi.a("daily_dynamic_header", true);
        if (localnpi != null) {}
        for (paramJSONObject = localnpi.getTemplateBean(paramJSONObject); (paramJSONObject != null) && (TextUtils.equals(paramJSONObject.getStyleName(), ((TemplateBean)localObject).getStyleName())) && (((TemplateBean)localObject).getId() == paramJSONObject.getId()); paramJSONObject = null)
        {
          QLog.i("DailyHeaderViewController", 1, "[bindDataForProteusHeader] template match, bind data");
          kvx.bindDynamicValueWithoutRecursion(paramContainer, (TemplateBean)localObject, paramJSONObject);
          return true;
        }
        return false;
      }
      catch (Exception paramContainer)
      {
        QLog.e("DailyHeaderViewController", 1, "[handleStateDynamic] ", paramContainer);
      }
    }
  }
  
  private void aBT()
  {
    QLog.i("DailyHeaderViewController", 1, "[handleStateNormal] ");
    DailyTitleBar localDailyTitleBar = (DailyTitleBar)this.mRootView.findViewById(2131372474);
    localDailyTitleBar.setVisibility(0);
    ImmersiveUtils.setStatusTextColor(true, ((Activity)this.mRootView.getContext()).getWindow());
    localDailyTitleBar.setOnLeftButtonClickListener(this.cg);
    localDailyTitleBar.setOnRightButtonClickListener(this.ch);
    localDailyTitleBar.setOnTitleClickListener(this.ck);
    this.mRootView.findViewById(2131365576).setVisibility(8);
    if (this.aL != null)
    {
      ((ReadInJoyDailyPullToZoomHeaderXListView)this.mRootView.findViewById(2131379011)).removeHeaderView(this.aL);
      this.aL = null;
      this.hS = null;
    }
  }
  
  private void aBU()
  {
    JSONObject localJSONObject = lbz.a().C();
    Object localObject;
    if ((this.aIr != -1) && (this.aIr != 0) && (this.aL != null))
    {
      if (a((Container)this.aL.getChildAt(1), localJSONObject))
      {
        QLog.i("DailyHeaderViewController", 1, "[onDailyDynamicHeaderDataUpdated] template match, bind data");
        L(localJSONObject);
        return;
      }
      QLog.i("DailyHeaderViewController", 1, "[onDailyDynamicHeaderDataUpdated] template mismatch, re-inflate");
      aBW();
      localObject = b(this.mVafContext, localJSONObject);
      if (localObject != null)
      {
        QLog.i("DailyHeaderViewController", 1, "[handleStateDynamic] successfully inflate dynamic header, update.");
        a(this.aL, (Container)localObject);
        L(localJSONObject);
        return;
      }
      QLog.e("DailyHeaderViewController", 1, "[onDailyDynamicHeaderDataUpdated] fail to inflate dynamic header");
      oA(0);
      return;
    }
    Container localContainer = b(this.mVafContext, localJSONObject);
    if (localContainer != null)
    {
      localObject = localJSONObject.optString("background_url");
      try
      {
        localObject = URLDrawable.getDrawable((String)localObject, a(this.mRootView.getContext()));
        a(this.mRootView, localContainer, (Drawable)localObject, localJSONObject);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Drawable localDrawable = this.mRootView.getContext().getResources().getDrawable(2131167145);
        }
      }
    }
    oA(0);
  }
  
  private void aBV()
  {
    QLog.i("DailyHeaderViewController", 1, "[handleLoading] ");
    Object localObject = new JSONObject();
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).putOpt("style_ID", "ReadInJoyDailyDynamicWeatherHeaderError");
        switch (this.aIr)
        {
        case 2: 
          throw new IllegalStateException("illegal state " + this.aIr);
        }
      }
      catch (Exception localException)
      {
        oA(0);
        localObject = a((JSONObject)localObject, null);
        if (localObject != null)
        {
          localObject = ((Container)localObject).getVirtualView().findViewBaseByName("id_refresh_icon").getNativeView();
          Animation localAnimation = AnimationUtils.loadAnimation(((View)localObject).getContext(), 2130772257);
          localAnimation.setFillAfter(true);
          ((View)localObject).startAnimation(localAnimation);
        }
        this.mRootView.postDelayed(new DailyDynamicHeaderViewController.11(this), 1000L);
        return;
      }
    }
  }
  
  private void aBW()
  {
    if (this.aL != null) {
      while (this.aL.getChildAt(1) != null) {
        this.aL.removeViewAt(1);
      }
    }
  }
  
  private static Container b(VafContext paramVafContext, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    String str = paramJSONObject.optString("style_ID", "null");
    paramVafContext = a(paramVafContext, paramJSONObject);
    a(paramVafContext, str, paramJSONObject);
    g(str, paramJSONObject);
    return paramVafContext;
  }
  
  private void bX(View paramView)
  {
    if ((Build.VERSION.SDK_INT >= 23) && (((BaseActivity)paramView.getContext()).checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0))
    {
      QLog.i("DailyHeaderViewController", 1, "[setupHeaders] location permission not granted");
      oA(3);
      return;
    }
    oA(((Integer)awit.f("sp_key_daily_dynamic_header_state", Integer.valueOf(0))).intValue());
  }
  
  private static String ei(String paramString)
  {
    if (TextUtils.equals(paramString, "ReadInJoyDailyDynamicWeatherHeader")) {
      return "1";
    }
    if (TextUtils.equals(paramString, "ReadInJoyDailyDynamicFestivalHeader")) {
      return "2";
    }
    if (TextUtils.equals(paramString, "ReadInJoyDailyDynamicVideoTopicHeader")) {
      return "3";
    }
    return null;
  }
  
  private static void g(String paramString, JSONObject paramJSONObject)
  {
    QLog.i("DailyHeaderViewController", 1, "[reportHeaderExposure] " + paramString);
    kxm.b localb = new kxm.b();
    localb.b("model_type", ei(paramString));
    localb.b("topic_id", paramJSONObject.optString("topic_id", ""));
    kbp.a(null, "CliOper", "", "", "0X8009D12", "0X8009D12", 0, 0, "", "", "", localb.build(), false);
  }
  
  private static void h(String paramString, JSONObject paramJSONObject)
  {
    QLog.i("DailyHeaderViewController", 1, "[reportHeaderClick] " + paramString);
    kxm.b localb = new kxm.b();
    localb.b("model_type", ei(paramString));
    localb.b("topic_id", paramJSONObject.optString("topic_id", ""));
    kbp.a(null, "CliOper", "", "", "0X8009D13", "0X8009D13", 0, 0, "", "", "", localb.build(), false);
  }
  
  private void handleError(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.putOpt("style_ID", "ReadInJoyDailyDynamicWeatherHeaderError");
        switch (paramInt)
        {
        case 2: 
          throw new IllegalStateException("illegal state " + paramInt);
        }
      }
      catch (Exception localException)
      {
        oA(0);
        return;
      }
      View.OnClickListener localOnClickListener = this.ci;
      for (;;)
      {
        a(localJSONObject, localOnClickListener);
        return;
        localOnClickListener = this.cj;
        continue;
        localOnClickListener = this.ci;
      }
    }
  }
  
  private void lN(boolean paramBoolean)
  {
    QLog.i("DailyHeaderViewController", 1, "[requestForUpdate] ");
    long l1 = ((Long)awit.f("sp_key_daily_dynamic_header_last_refresh_time", Long.valueOf(0L))).longValue();
    long l2 = System.currentTimeMillis();
    long l3 = Aladdin.getConfig(157).getIntegerFromString("refresh_debounce_interval", 5);
    if ((l2 - l1 > 60000L * l3) || (paramBoolean)) {
      ThreadManagerV2.getUIHandlerV2().post(new DailyDynamicHeaderViewController.9(this));
    }
    do
    {
      return;
      QLog.i("DailyHeaderViewController", 1, "[requestForUpdate] too frequent, less than " + l3 + " minutes, skip.");
    } while (!QLog.isColorLevel());
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    QLog.d("DailyHeaderViewController", 2, "[requestForUpdate] last refresh: " + localSimpleDateFormat.format(new Date(l1)));
    QLog.d("DailyHeaderViewController", 2, "[requestForUpdate] current time: " + localSimpleDateFormat.format(new Date(l2)));
  }
  
  private void lZ(String paramString)
  {
    this.hS = ((ImageView)this.aL.findViewById(2131363240));
    try
    {
      paramString = URLDrawable.getDrawable(paramString, a(this.hS.getContext()));
      key.E(paramString);
      key.h(this.hS);
      this.hS.setImageDrawable(paramString);
      return;
    }
    catch (Exception paramString)
    {
      this.hS.setImageResource(2131167145);
      QLog.e("DailyHeaderViewController", 1, "[onDailyDynamicHeaderDataUpdated] ", paramString);
    }
  }
  
  private void oA(int paramInt)
  {
    QLog.i("DailyHeaderViewController", 1, "[moveToState] from: " + this.mCurrentState + " to " + paramInt);
    this.aIr = this.mCurrentState;
    this.mCurrentState = paramInt;
    awit.H("sp_key_daily_dynamic_header_state", Integer.valueOf(this.mCurrentState));
    if (this.aL != null) {
      this.aL.setOnClickListener(null);
    }
    switch (paramInt)
    {
    default: 
      throw new IllegalStateException("invalid state " + paramInt);
    case 0: 
      aBT();
      return;
    case 1: 
      aBU();
      return;
    case 2: 
    case 3: 
    case 4: 
      handleError(paramInt);
      return;
    }
    aBV();
  }
  
  public void bW(View paramView)
  {
    this.mRootView = paramView;
    boolean bool = kys.Bl();
    QLog.i("DailyHeaderViewController", 1, "[onCreateView] enable_dynamic_header=" + bool);
    if (bool)
    {
      bX(paramView);
      lcc.a().b(this.b);
      lN(false);
      return;
    }
    oA(0);
  }
  
  public void onDestroyView()
  {
    aczc.b(this.jdField_a_of_type_Aczc$b);
    lcc.a().c(this.b);
  }
  
  public void setOnTitleClickListener(View.OnClickListener paramOnClickListener)
  {
    this.ck = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kfa
 * JD-Core Version:    0.7.0.1
 */