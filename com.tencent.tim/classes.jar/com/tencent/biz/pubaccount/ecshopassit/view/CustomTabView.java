package com.tencent.biz.pubaccount.ecshopassit.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqmr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kee;
import kem;
import kem.a;
import keo;
import kep;
import keq;
import rpq;
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp.RedPointInfo;

public class CustomTabView
  extends FrameLayout
{
  private String YN;
  private String YO;
  public int aIo;
  private ImageView hO;
  private ArrayList<Integer> kb = new CustomTabView.1(this);
  private Context mContext;
  private TextView nQ;
  private long rS;
  
  public CustomTabView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.rS = NetConnInfoCenter.getServerTime();
  }
  
  public CustomTabView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    this.rS = NetConnInfoCenter.getServerTime();
  }
  
  private ImageView a(RelativeLayout paramRelativeLayout, kem.a parama)
  {
    ImageView localImageView = new ImageView(this.mContext);
    try
    {
      localImageView.setId(cT(parama.aCj));
      localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      paramRelativeLayout.addView(localImageView);
      paramRelativeLayout = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
      paramRelativeLayout.width = rpq.dip2px(this.mContext, 28.0F);
      paramRelativeLayout.height = rpq.dip2px(this.mContext, 28.0F);
      paramRelativeLayout.addRule(14);
      paramRelativeLayout.topMargin = rpq.dip2px(this.mContext, 4.0F);
      paramRelativeLayout = URLDrawable.URLDrawableOptions.obtain();
      paramRelativeLayout.mRequestHeight = rpq.dip2px(this.mContext, 28.0F);
      paramRelativeLayout.mRequestWidth = rpq.dip2px(this.mContext, 28.0F);
      paramRelativeLayout = URLDrawable.getDrawable(parama.nV, paramRelativeLayout);
      if (paramRelativeLayout != null) {
        localImageView.setImageDrawable(paramRelativeLayout);
      }
      return localImageView;
    }
    catch (Exception paramRelativeLayout)
    {
      QLog.e("EcshopCustomTabView", 1, QLog.getStackTraceString(paramRelativeLayout));
    }
    return localImageView;
  }
  
  private ImageView a(RelativeLayout paramRelativeLayout, kem.a parama, ImageView paramImageView)
  {
    ImageView localImageView = new ImageView(this.mContext);
    localImageView.setId(cU(parama.aCj));
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localImageView.setVisibility(8);
    paramRelativeLayout.addView(localImageView);
    paramRelativeLayout = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
    paramRelativeLayout.width = -2;
    paramRelativeLayout.height = -2;
    paramRelativeLayout.addRule(1, paramImageView.getId());
    paramRelativeLayout.addRule(10);
    paramRelativeLayout.topMargin = rpq.dip2px(this.mContext, 2.0F);
    return localImageView;
  }
  
  private RelativeLayout a(kem.a parama)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    ImageView localImageView = a(localRelativeLayout, parama);
    localRelativeLayout.setOnClickListener(new kep(this, parama, a(localRelativeLayout, parama, localImageView), a(localRelativeLayout, parama, localImageView), localImageView));
    return localRelativeLayout;
  }
  
  private TextView a(RelativeLayout paramRelativeLayout, kem.a parama, ImageView paramImageView)
  {
    TextView localTextView = new TextView(this.mContext);
    localTextView.setTextColor(Color.parseColor(parama.YL));
    localTextView.setTextSize(1, rpq.dip2px(this.mContext, 3.0F));
    localTextView.setText(parama.name);
    paramRelativeLayout.addView(localTextView);
    paramRelativeLayout = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    paramRelativeLayout.width = -2;
    paramRelativeLayout.height = -2;
    paramRelativeLayout.addRule(3, paramImageView.getId());
    paramRelativeLayout.addRule(14);
    paramRelativeLayout.topMargin = rpq.dip2px(this.mContext, 2.0F);
    paramRelativeLayout.bottomMargin = rpq.dip2px(this.mContext, 4.0F);
    return localTextView;
  }
  
  private void a(kem.a parama, TextView paramTextView, ImageView paramImageView)
  {
    this.aIo = parama.aCj;
    paramTextView.setTextColor(Color.parseColor(parama.YM));
    if ((this.nQ != null) && (!aqmr.isEmpty(this.YN))) {
      this.nQ.setTextColor(Color.parseColor(this.YN));
    }
    this.nQ = paramTextView;
    this.YN = parama.YL;
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = rpq.dip2px(this.mContext, 28.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = rpq.dip2px(this.mContext, 28.0F);
    paramTextView = URLDrawable.getDrawable(parama.YK, (URLDrawable.URLDrawableOptions)localObject);
    if (paramTextView != null) {
      paramImageView.setImageDrawable(paramTextView);
    }
    if ((this.hO != null) && (!aqmr.isEmpty(this.YO)))
    {
      localObject = URLDrawable.getDrawable(this.YO, (URLDrawable.URLDrawableOptions)localObject);
      if (paramTextView != null) {
        this.hO.setImageDrawable((Drawable)localObject);
      }
    }
    this.hO = paramImageView;
    this.YO = parama.nV;
  }
  
  private boolean a(kem.a parama)
  {
    if (parama == null) {}
    do
    {
      return false;
      if (AppSetting.bs(parama.minAppVersion) >= 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("EcshopCustomTabView", 2, "current qq version not support this tab item");
    return false;
    if ((parama.pageType == 1) && (!this.kb.contains(Integer.valueOf(parama.aCj))))
    {
      QLog.i("EcshopCustomTabView", 2, "native tab item illegal!");
      return false;
    }
    if ((parama.pageType == 0) && ((aqmr.isEmpty(parama.jumpUrl)) || (!parama.jumpUrl.startsWith("http")) || (!parama.jumpUrl.startsWith("https"))))
    {
      QLog.i("EcshopCustomTabView", 2, "web tab item illegal!");
      return false;
    }
    if ((parama.pageType == 2) && (!MiniAppLauncher.isMiniAppUrl(parama.jumpUrl)))
    {
      QLog.i("EcshopCustomTabView", 2, "miniapp tab item illegal!");
      return false;
    }
    if ((!parama.YL.startsWith("#")) || (!parama.YM.startsWith("#")))
    {
      QLog.i("EcshopCustomTabView", 2, "tab item color hex illegal!");
      return false;
    }
    if ((aqmr.isEmpty(parama.name)) || (parama.name.trim().length() == 0))
    {
      QLog.i("EcshopCustomTabView", 2, "tab item name illegal!");
      return false;
    }
    return true;
  }
  
  private void aBS()
  {
    Object localObject1 = keo.b();
    if (localObject1 == null) {
      QLog.i("EcshopCustomTabView", 2, "[CustomTabView] ecshopConfBean is null");
    }
    kem.a locala;
    RelativeLayout localRelativeLayout;
    do
    {
      return;
      while (!((Iterator)localObject1).hasNext())
      {
        localObject1 = ((kem)localObject1).ka;
        if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty()))
        {
          QLog.i("EcshopCustomTabView", 2, "[CustomTabView] tabConfs is null");
          return;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
      }
      locala = (kem.a)((Iterator)localObject1).next();
      localRelativeLayout = (RelativeLayout)findViewById(locala.aCj);
    } while (localRelativeLayout == null);
    int i = 0;
    label88:
    Object localObject2;
    if (i < localRelativeLayout.getChildCount())
    {
      localObject2 = localRelativeLayout.getChildAt(i);
      if (!(localObject2 instanceof TextView)) {
        break label135;
      }
      ((TextView)localObject2).setTextColor(Color.parseColor(locala.YL));
    }
    for (;;)
    {
      i += 1;
      break label88;
      break;
      label135:
      if ((localObject2 instanceof ImageView))
      {
        localObject2 = (ImageView)localObject2;
        if (((ImageView)localObject2).getId() == cT(locala.aCj))
        {
          Object localObject3 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = rpq.dip2px(this.mContext, 28.0F);
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = rpq.dip2px(this.mContext, 28.0F);
          localObject3 = URLDrawable.getDrawable(locala.nV, (URLDrawable.URLDrawableOptions)localObject3);
          if (localObject3 != null) {
            ((ImageView)localObject2).setImageDrawable((Drawable)localObject3);
          }
        }
      }
    }
  }
  
  private void b(kem.a parama, TextView paramTextView, ImageView paramImageView)
  {
    if (parama == null) {
      return;
    }
    switch (parama.pageType)
    {
    default: 
      return;
    case 0: 
      a(parama, paramTextView, paramImageView);
      kee.d(this.mContext, this.aIo, parama.jumpUrl);
      return;
    case 1: 
      if (parama.aCj == 1)
      {
        a(parama, paramTextView, paramImageView);
        kee.n(this.mContext, "3046055438", "QQ购物");
        return;
      }
      QLog.i("EcshopCustomTabView", 2, "can't match tabId: " + parama.aCj);
      return;
    }
    MiniAppLauncher.startMiniApp(this.mContext, parama.jumpUrl, 1035, new keq(this));
  }
  
  private int cT(int paramInt)
  {
    return paramInt * paramInt + 100;
  }
  
  private int cU(int paramInt)
  {
    return paramInt * paramInt + 200;
  }
  
  public boolean b(kem paramkem)
  {
    if (paramkem == null) {
      return false;
    }
    ArrayList localArrayList = paramkem.ka;
    if ((localArrayList == null) || (localArrayList.size() == 0) || (localArrayList.size() < 2))
    {
      QLog.i("EcshopCustomTabView", 2, "[initView] config is empty!");
      return false;
    }
    LinearLayout localLinearLayout = new LinearLayout(this.mContext);
    for (;;)
    {
      int i;
      try
      {
        localLinearLayout.setBackgroundColor(Color.parseColor(paramkem.YJ));
        localLinearLayout.setOrientation(0);
        addView(localLinearLayout);
        paramkem = (FrameLayout.LayoutParams)localLinearLayout.getLayoutParams();
        if (paramkem == null) {
          break label353;
        }
        paramkem.width = -1;
        paramkem.height = -2;
      }
      catch (Throwable paramkem)
      {
        RelativeLayout localRelativeLayout;
        QLog.e("EcshopCustomTabView", 1, QLog.getStackTraceString(paramkem));
        try
        {
          if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
          {
            localLinearLayout.measure(0, 0);
            paramkem = new View(this.mContext);
            paramkem.setBackgroundColor(1996488704);
            removeView(paramkem);
            addView(paramkem);
            paramkem.getLayoutParams().width = -1;
            paramkem.getLayoutParams().height = localLinearLayout.getMeasuredHeight();
          }
          i = localLinearLayout.getChildCount();
          if (i >= 2)
          {
            localLinearLayout.setWeightSum(i);
            return true;
          }
        }
        catch (Throwable paramkem)
        {
          QLog.e("EcshopCustomTabView", 1, QLog.getStackTraceString(paramkem));
          continue;
        }
        return false;
      }
      if (i < localArrayList.size())
      {
        paramkem = (kem.a)localArrayList.get(i);
        if (a(paramkem))
        {
          kee.S(paramkem.aCj, false);
          kee.a(null, "gouwu.tab.show", paramkem.aCj + "", NetConnInfoCenter.getServerTimeMillis() + "", "");
          localRelativeLayout = a(paramkem);
          localLinearLayout.addView(localRelativeLayout);
          localRelativeLayout.setId(paramkem.aCj);
          paramkem = (LinearLayout.LayoutParams)localRelativeLayout.getLayoutParams();
          if (paramkem != null) {
            paramkem.weight = 1.0F;
          }
        }
      }
      else
      {
        label353:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
  
  public void bK(List<qq_ad.QQAdGetRsp.RedPointInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      label13:
      return;
      break label21;
    }
    else
    {
      paramList = paramList.iterator();
    }
    for (;;)
    {
      label21:
      qq_ad.QQAdGetRsp.RedPointInfo localRedPointInfo;
      if (paramList.hasNext())
      {
        localRedPointInfo = (qq_ad.QQAdGetRsp.RedPointInfo)paramList.next();
        QLog.i("EcshopCustomTabView", 2, "tab_id: " + localRedPointInfo.tab_id.get() + ",red_type: " + localRedPointInfo.red_type.get() + ",red_url: " + localRedPointInfo.red_url.get());
        if ((localRedPointInfo == null) || (!localRedPointInfo.tab_id.has()) || (!localRedPointInfo.task_id.has())) {
          continue;
        }
        kee.a(null, "gouwu.tab.show", localRedPointInfo.tab_id.get() + "", NetConnInfoCenter.getServerTimeMillis() + "", localRedPointInfo.task_id.get() + "");
        if (kee.T(localRedPointInfo.tab_id.get(), localRedPointInfo.task_id.get()))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("EcshopCustomTabView", 2, "tab_id: " + localRedPointInfo.tab_id.get() + " has clicked!!!");
        }
      }
      else
      {
        break label13;
      }
      if ((!localRedPointInfo.begin_time.has()) || (!localRedPointInfo.delay_second.has()) || (!localRedPointInfo.end_time.has())) {
        break;
      }
      long l1 = localRedPointInfo.begin_time.get();
      long l2 = localRedPointInfo.end_time.get();
      long l3 = NetConnInfoCenter.getServerTime();
      QLog.i("EcshopCustomTabView", 2, "startTime: " + l1 + " endTime: " + l2 + " currentTime: " + l3);
      if ((l1 > l3) || (l2 < l3)) {
        break;
      }
      RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(localRedPointInfo.tab_id.get());
      if (localRelativeLayout == null) {
        break;
      }
      int i = 0;
      while (i < localRelativeLayout.getChildCount())
      {
        Object localObject = localRelativeLayout.getChildAt(i);
        if ((localObject instanceof ImageView))
        {
          localObject = (ImageView)localObject;
          if (((ImageView)localObject).getId() == cU(localRedPointInfo.tab_id.get()))
          {
            l1 = NetConnInfoCenter.getServerTime();
            l2 = this.rS;
            ((ImageView)localObject).postDelayed(new CustomTabView.4(this, localRedPointInfo, (ImageView)localObject, localRelativeLayout), Math.abs(localRedPointInfo.delay_second.get() * 1000 - (l1 - l2)));
          }
        }
        i += 1;
      }
    }
  }
  
  public void bT(View paramView)
  {
    if (paramView.getParent() == null) {}
    do
    {
      return;
      if ((paramView instanceof ViewGroup)) {
        ((ViewGroup)paramView).setClipChildren(false);
      }
    } while (!(paramView.getParent() instanceof View));
    bT((View)paramView.getParent());
  }
  
  public void oz(int paramInt)
  {
    aBS();
    this.aIo = paramInt;
    kem.a locala = keo.a(this.aIo);
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(paramInt);
    if (localRelativeLayout != null)
    {
      paramInt = 0;
      if (paramInt < localRelativeLayout.getChildCount())
      {
        Object localObject1 = localRelativeLayout.getChildAt(paramInt);
        if ((localObject1 instanceof TextView))
        {
          localObject1 = (TextView)localObject1;
          ((TextView)localObject1).setTextColor(Color.parseColor(locala.YM));
          this.YN = locala.YL;
          this.nQ = ((TextView)localObject1);
        }
        for (;;)
        {
          paramInt += 1;
          break;
          if ((localObject1 instanceof ImageView))
          {
            localObject1 = (ImageView)localObject1;
            if (((ImageView)localObject1).getId() == cT(this.aIo))
            {
              this.hO = ((ImageView)localObject1);
              this.YO = locala.nV;
              Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = rpq.dip2px(this.mContext, 28.0F);
              ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = rpq.dip2px(this.mContext, 28.0F);
              localObject2 = URLDrawable.getDrawable(locala.YK, (URLDrawable.URLDrawableOptions)localObject2);
              if (localObject2 != null) {
                ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.CustomTabView
 * JD-Core Version:    0.7.0.1
 */