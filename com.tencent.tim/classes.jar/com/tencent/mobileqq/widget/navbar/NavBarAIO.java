package com.tencent.mobileqq.widget.navbar;

import ajns;
import ajoe;
import ajoh;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import arkn;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.CommonImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Field;
import jof;
import wja;

public class NavBarAIO
  extends RelativeLayout
  implements View.OnClickListener
{
  private TextView Cr;
  private TextView Ct;
  private ImageView FO;
  private ImageView FP;
  private ImageView FQ;
  private ImageView FR;
  private ImageView FS;
  private ImageView FT;
  private ImageView FU;
  private View JK;
  private TextView act;
  private TextView acu;
  private TextView acv;
  private TextView acw;
  private boolean aey;
  private LinearLayout lC;
  private arkn listener;
  private RelativeLayout mA;
  private RelativeLayout mB;
  private float mDensity;
  private TextView mTitleText;
  private RelativeLayout mz;
  private ImageView pp;
  private ImageView pq;
  private ImageView ps;
  private TextView tU;
  private LinearLayout titleLayout;
  
  public NavBarAIO(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public NavBarAIO(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public NavBarAIO(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private int MW()
  {
    int i = -2147483647;
    int m = getChildCount();
    int j = 0;
    if (j < m)
    {
      View localView = getChildAt(j);
      if (localView.getVisibility() == 8) {
        break label143;
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      int k = a(localLayoutParams, "mLeft");
      int n = a(localLayoutParams, "mRight");
      int i1 = getMeasuredWidth() / 2;
      if ((k >= i1) || (n >= i1)) {
        break label143;
      }
      k = Math.max(i, n);
      i = k;
      if (QLog.isColorLevel())
      {
        QLog.d("NavBarAIO", 2, "getLeftRegionWidth() called left max = " + k + " left child " + localView);
        i = k;
      }
    }
    label143:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  private int MX()
  {
    int i = getMeasuredWidth() / 2;
    int m = getChildCount();
    int j = 0;
    if (j < m)
    {
      View localView = getChildAt(j);
      if (localView.getVisibility() == 8) {
        break label151;
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      int k = a(localLayoutParams, "mLeft");
      int n = a(localLayoutParams, "mRight");
      int i1 = getMeasuredWidth() / 2;
      if ((k <= i1) || (n <= i1)) {
        break label151;
      }
      k = Math.min(i, getMeasuredWidth() - k);
      i = k;
      if (QLog.isColorLevel())
      {
        QLog.d("NavBarAIO", 2, "getRightRegionWidth() called right max = " + k + " right child " + localView);
        i = k;
      }
    }
    label151:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  private static int a(RelativeLayout.LayoutParams paramLayoutParams, String paramString)
  {
    try
    {
      paramString = paramLayoutParams.getClass().getDeclaredField(paramString);
      paramString.setAccessible(true);
      int i = paramString.getInt(paramLayoutParams);
      return i;
    }
    catch (NoSuchFieldException paramLayoutParams)
    {
      paramLayoutParams.printStackTrace();
      return 0;
    }
    catch (IllegalAccessException paramLayoutParams)
    {
      paramLayoutParams.printStackTrace();
    }
    return 0;
  }
  
  private static void a(RelativeLayout.LayoutParams paramLayoutParams, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NavBarAIO", 2, "setRelativeLayoutLayoutParamsDimension() called with: lp = [" + paramLayoutParams + "], l = [" + paramInt1 + "], t = [" + paramInt2 + "], r = [" + paramInt3 + "], b = [" + paramInt4 + "]");
    }
    a(paramLayoutParams, "mLeft", paramInt1);
    a(paramLayoutParams, "mTop", paramInt2);
    a(paramLayoutParams, "mRight", paramInt3);
    a(paramLayoutParams, "mBottom", paramInt4);
  }
  
  private static void a(RelativeLayout.LayoutParams paramLayoutParams, String paramString, int paramInt)
  {
    try
    {
      paramString = paramLayoutParams.getClass().getDeclaredField(paramString);
      paramString.setAccessible(true);
      paramString.set(paramLayoutParams, Integer.valueOf(paramInt));
      return;
    }
    catch (NoSuchFieldException paramLayoutParams)
    {
      paramLayoutParams.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramLayoutParams)
    {
      paramLayoutParams.printStackTrace();
    }
  }
  
  private void ejE()
  {
    int j = 8;
    float f2 = 6.0F;
    Object localObject = this.Cr;
    int i;
    label52:
    label117:
    double d;
    if (!this.aey)
    {
      i = 0;
      ((TextView)localObject).setVisibility(i);
      ejF();
      localObject = this.pq;
      if (this.aey) {
        break label339;
      }
      i = j;
      ((ImageView)localObject).setVisibility(i);
      localObject = (RelativeLayout.LayoutParams)this.mA.getLayoutParams();
      i = wja.dp2px(46.0F, getResources());
      j = wja.dp2px(41.0F, getResources());
      if ((!this.aey) && (this.acw.getVisibility() != 0)) {
        break label345;
      }
      ((RelativeLayout.LayoutParams)localObject).width = i;
      this.mA.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.mA;
      if (this.aey) {
        break label355;
      }
      d = 4.0D;
      label143:
      ((RelativeLayout)localObject).setPadding((int)(d * this.mDensity + 0.5D), 0, 0, 0);
      localObject = (RelativeLayout.LayoutParams)this.pp.getLayoutParams();
      if (this.aey) {
        break label362;
      }
      f1 = 0.0F;
      label184:
      ((RelativeLayout.LayoutParams)localObject).rightMargin = wja.dp2px(f1, getResources());
      this.pp.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)this.mB.getLayoutParams();
      if (this.aey) {
        break label369;
      }
      f1 = 41.0F;
      label228:
      ((RelativeLayout.LayoutParams)localObject).width = wja.dp2px(f1, getResources());
      this.mB.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.mB;
      if (this.aey) {
        break label376;
      }
    }
    label339:
    label345:
    label355:
    label362:
    label369:
    label376:
    for (float f1 = 8.0F;; f1 = 6.0F)
    {
      ((RelativeLayout)localObject).setPadding(wja.dp2px(f1, getResources()), 0, 0, 0);
      localObject = (RelativeLayout.LayoutParams)this.ps.getLayoutParams();
      f1 = f2;
      if (!this.aey) {
        f1 = 4.0F;
      }
      ((RelativeLayout.LayoutParams)localObject).rightMargin = wja.dp2px(f1, getResources());
      this.ps.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      i = 8;
      break;
      i = 0;
      break label52;
      ((RelativeLayout.LayoutParams)localObject).width = j;
      break label117;
      d = 2.5D;
      break label143;
      f1 = 12.5F;
      break label184;
      f1 = 36.0F;
      break label228;
    }
  }
  
  private void ejG()
  {
    iG(this);
  }
  
  private static void iG(View paramView)
  {
    if ((paramView.getVisibility() == 4) && (QLog.isColorLevel())) {
      QLog.d("NavBarAIO", 2, "printInvisibleView() called with: view = [" + paramView + "]");
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        iG(paramView.getChildAt(i));
        i += 1;
      }
    }
  }
  
  private void init(Context paramContext)
  {
    View.inflate(paramContext, 2131559120, this);
    setBackgroundResource(2130851105);
    this.mDensity = paramContext.getResources().getDisplayMetrics().density;
    this.aey = ThemeUtil.isDefaultOrDIYTheme(false);
    this.Cr = ((TextView)findViewById(2131369579));
    this.tU = ((TextView)findViewById(2131369619));
    this.lC = ((LinearLayout)findViewById(2131370393));
    this.pq = ((ImageView)findViewById(2131369967));
    this.act = ((TextView)findViewById(2131380514));
    this.titleLayout = ((LinearLayout)findViewById(2131379823));
    this.FO = ((ImageView)findViewById(2131366180));
    if (AppSetting.enableTalkBack) {
      this.FO.setContentDescription(paramContext.getResources().getString(2131696997));
    }
    this.FP = ((ImageView)findViewById(2131379813));
    this.FQ = ((ImageView)findViewById(2131379814));
    this.FR = ((ImageView)findViewById(2131379815));
    this.Ct = ((TextView)findViewById(2131365958));
    this.mTitleText = ((TextView)findViewById(2131379769));
    this.acu = ((TextView)findViewById(2131379857));
    this.mz = ((RelativeLayout)findViewById(2131369637));
    this.mA = ((RelativeLayout)findViewById(2131377372));
    this.mB = ((RelativeLayout)findViewById(2131377369));
    this.JK = findViewById(2131378923);
    this.acv = ((TextView)findViewById(2131380531));
    this.acw = ((TextView)findViewById(2131380530));
    this.ps = ((ImageView)findViewById(2131369588));
    this.pp = ((ImageView)findViewById(2131369594));
    this.FU = ((ImageView)findViewById(2131377002));
    this.FT = ((ImageView)findViewById(2131377003));
  }
  
  public void TV(boolean paramBoolean)
  {
    if (this.FO != null) {
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (int i = 2130851169;; i = 2130851168)
    {
      Drawable localDrawable = getResources().getDrawable(i);
      this.FO.setImageDrawable(localDrawable);
      return;
    }
  }
  
  public void TW(boolean paramBoolean)
  {
    ImageView localImageView = this.FU;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void TX(boolean paramBoolean)
  {
    int i;
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      i = wja.dp2px(6.0F, getResources());
      localLayoutParams = new RelativeLayout.LayoutParams(i, i);
      if (!paramBoolean) {
        break label83;
      }
      localLayoutParams.addRule(7, 2131369588);
      localLayoutParams.addRule(6, 2131369588);
      i = -wja.dp2px(3.0F, getResources());
      localLayoutParams.rightMargin = i;
      localLayoutParams.leftMargin = i;
    }
    for (;;)
    {
      this.FU.setLayoutParams(localLayoutParams);
      return;
      i = -2;
      break;
      label83:
      localLayoutParams.addRule(11);
      localLayoutParams.rightMargin = wja.dp2px(4.0F, getResources());
      localLayoutParams.topMargin = wja.dp2px(8.0F, getResources());
    }
  }
  
  public void YW(int paramInt) {}
  
  @Deprecated
  public void bIL() {}
  
  public void bN(boolean paramBoolean, int paramInt)
  {
    if (paramInt == 0)
    {
      setEarIconVisible(paramBoolean);
      return;
    }
    if ((paramInt == 1) || (paramInt == 3000))
    {
      setEarIconVisible(paramBoolean);
      return;
    }
    setEarIconVisible(false);
  }
  
  public void e(SessionInfo paramSessionInfo)
  {
    Object localObject = paramSessionInfo.aTl;
    if (!this.aey)
    {
      paramSessionInfo = getResources().getColorStateList(2131167301);
      if (!jof.a().dd((String)localObject))
      {
        this.Ct.setTextColor(paramSessionInfo);
        this.mTitleText.setTextColor(paramSessionInfo);
        this.acu.setTextColor(paramSessionInfo);
        this.tU.setTextColor(paramSessionInfo);
      }
      localObject = (GradientDrawable)this.tU.getBackground();
      if (localObject != null)
      {
        if (Build.VERSION.SDK_INT >= 21)
        {
          ((GradientDrawable)localObject).setColor(paramSessionInfo);
          ((GradientDrawable)localObject).setAlpha(46);
        }
      }
      else {
        this.act.setVisibility(8);
      }
    }
    for (;;)
    {
      ejE();
      return;
      ((GradientDrawable)localObject).setColor(paramSessionInfo.getDefaultColor());
      break;
      if (!jof.a().dd((String)localObject))
      {
        paramSessionInfo = getResources().getColorStateList(2131167302);
        this.Ct.setTextColor(paramSessionInfo);
        this.mTitleText.setTextColor(paramSessionInfo);
        this.acu.setTextColor(paramSessionInfo);
      }
      if (!TextUtils.isEmpty(this.act.getText())) {
        this.act.setVisibility(0);
      } else {
        this.act.setVisibility(8);
      }
    }
  }
  
  public void ejC()
  {
    if (this.FS != null) {}
    while (this.FR == null) {
      return;
    }
    this.FS = new CommonImageView(getContext());
    this.FS.setId(2131379816);
    Object localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).leftMargin = wja.dp2px(5.0F, getResources());
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.FS.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.FS.setVisibility(8);
    localObject = (ViewGroup)this.FR.getParent();
    int i = ((ViewGroup)localObject).indexOfChild(this.FR);
    ((ViewGroup)localObject).addView(this.FS, i + 1);
  }
  
  @Deprecated
  public void ejD() {}
  
  public void ejF()
  {
    if (this.aey)
    {
      this.tU.setVisibility(8);
      return;
    }
    if (TextUtils.isEmpty(this.tU.getText()))
    {
      this.tU.setVisibility(8);
      return;
    }
    if (!TextUtils.isEmpty(this.Cr.getText()))
    {
      this.tU.setVisibility(8);
      return;
    }
    this.tU.setVisibility(0);
  }
  
  public void kD(int paramInt1, int paramInt2)
  {
    if (this.aey) {}
    for (;;)
    {
      YW(paramInt2);
      return;
      paramInt2 = paramInt1;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      if ((i != 0) && (this.listener != null)) {
        this.listener.onItemSelect(paramView, i);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 1;
      continue;
      i = 3;
      continue;
      i = 2;
      continue;
      i = 5;
      continue;
      i = 4;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    ejG();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.titleLayout.getLayoutParams();
    localLayoutParams.bottomMargin = 0;
    localLayoutParams.rightMargin = 0;
    localLayoutParams.topMargin = 0;
    localLayoutParams.leftMargin = 0;
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = MW();
    int i = MX();
    paramInt2 = getMeasuredWidth() - paramInt1 - i;
    if (QLog.isColorLevel()) {
      QLog.d("NavBarAIO", 2, "onMeasure() called with: leftRegionWidth = [" + paramInt1 + "], rightRegionWidth = [" + i + "] middleRegionWidth = [" + paramInt2 + "]");
    }
    localLayoutParams.leftMargin = paramInt1;
    localLayoutParams.rightMargin = i;
    localLayoutParams.topMargin = (((int)getResources().getDimension(2131299627) - this.titleLayout.getMeasuredHeight() - this.JK.getMeasuredHeight()) / 2);
    i = localLayoutParams.topMargin + this.titleLayout.getMeasuredHeight();
    this.titleLayout.measure(View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    a(localLayoutParams, paramInt1, localLayoutParams.topMargin, paramInt2 + paramInt1, i);
    localLayoutParams = (RelativeLayout.LayoutParams)this.JK.getLayoutParams();
    a(localLayoutParams, "mTop", i);
    a(localLayoutParams, "mBottom", i + this.JK.getMeasuredHeight());
  }
  
  public void onPostThemeChanged()
  {
    this.aey = ThemeUtil.isDefaultOrDIYTheme(false);
    if (!this.aey)
    {
      setBackgroundResource(2130851105);
      return;
    }
    setBackgroundResource(2130851106);
  }
  
  public void setEarIconVisible(boolean paramBoolean)
  {
    ImageView localImageView = this.FO;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void setIsDefaultTheme(boolean paramBoolean)
  {
    this.aey = paramBoolean;
  }
  
  public void setLeftContentDescription(String paramString)
  {
    this.lC.setContentDescription(paramString);
    this.Cr.setContentDescription(paramString);
  }
  
  public void setOnSelectListener(arkn paramarkn)
  {
    this.listener = paramarkn;
    this.Cr.setOnClickListener(this);
    this.lC.setOnClickListener(this);
    this.acv.setOnClickListener(this);
    this.acw.setOnClickListener(this);
    this.ps.setOnClickListener(this);
    this.pp.setOnClickListener(this);
  }
  
  public void setRight1(String paramString)
  {
    this.acw.setText(paramString);
    this.acw.setContentDescription(paramString);
    this.acw.setVisibility(0);
    this.pp.setVisibility(8);
    wja.i(this.acw, wja.dp2px(7.0F, getResources()), wja.dp2px(7.0F, getResources()), wja.dp2px(4.0F, getResources()), wja.dp2px(8.0F, getResources()));
  }
  
  public void setRight1Icon(int paramInt)
  {
    this.pp.setVisibility(0);
    this.pp.setImageResource(paramInt);
    this.acw.setVisibility(8);
    wja.i(this.pp, wja.dp2px(7.0F, getResources()), wja.dp2px(7.0F, getResources()), wja.dp2px(4.0F, getResources()), wja.dp2px(8.0F, getResources()));
  }
  
  public void setRight1Icon(int paramInt1, int paramInt2)
  {
    if (this.aey) {}
    for (;;)
    {
      setRight1Icon(paramInt2);
      return;
      paramInt2 = paramInt1;
    }
  }
  
  public void setRight1Icon(Drawable paramDrawable)
  {
    this.pp.setVisibility(0);
    this.pp.setImageDrawable(paramDrawable);
    this.acw.setVisibility(8);
    wja.i(this.pp, wja.dp2px(7.0F, getResources()), wja.dp2px(7.0F, getResources()), wja.dp2px(4.0F, getResources()), wja.dp2px(8.0F, getResources()));
  }
  
  public void setRight2(String paramString)
  {
    this.acv.setText(paramString);
    this.acv.setContentDescription(paramString);
    this.acv.setVisibility(0);
    this.ps.setVisibility(8);
    wja.i(this.acv, wja.dp2px(7.0F, getResources()), wja.dp2px(7.0F, getResources()), wja.dp2px(8.0F, getResources()), wja.dp2px(4.0F, getResources()));
  }
  
  public void setRight2Icon(int paramInt) {}
  
  public void setRight2Icon(int paramInt1, int paramInt2) {}
  
  public void setRightIcon1Desc(String paramString)
  {
    this.pp.setContentDescription(paramString);
  }
  
  public void setRightIcon2Desc(String paramString)
  {
    this.ps.setContentDescription(paramString);
  }
  
  public void setRightRootVisibility(int paramInt)
  {
    if (this.mz != null) {
      this.mz.setVisibility(paramInt);
    }
  }
  
  public void setRightToStr(String paramString, View.OnClickListener paramOnClickListener)
  {
    setRight1(paramString);
    this.pp.setBackgroundDrawable(null);
    this.pp.setImageDrawable(null);
    this.acw.setSingleLine();
    this.acw.setTextSize(1, 17.0F);
    this.acw.setTextColor(getResources().getColor(2131167301));
    this.acw.setOnClickListener(paramOnClickListener);
    this.mB.setVisibility(8);
    this.FT.setVisibility(8);
    if (QLog.isDevelopLevel()) {
      QLog.d("NavBarAIO", 4, "fight_Text is setRightToStr and rw =  " + this.mz.getMeasuredWidth());
    }
  }
  
  public void setTitleIcon(int paramInt)
  {
    this.FP.setImageResource(paramInt);
  }
  
  public void setTitleIconLeft(int paramInt)
  {
    setTitleIconLeft(paramInt, 0);
  }
  
  public void setTitleIconLeft(int paramInt1, int paramInt2)
  {
    int k = 1;
    int i;
    int j;
    if (this.FP.getVisibility() == 0)
    {
      i = 1;
      if (paramInt1 == 0) {
        break label108;
      }
      j = 1;
      label22:
      if (i == j) {
        break label114;
      }
      i = 1;
      label30:
      if (i == 0)
      {
        if (this.FQ.getVisibility() != 0) {
          break label119;
        }
        i = 1;
        label46:
        if (paramInt2 == 0) {
          break label124;
        }
        j = k;
        label54:
        if (i == j) {}
      }
      this.FP.setImageResource(paramInt1);
      if (paramInt1 != 0) {
        break label130;
      }
      this.FP.setVisibility(8);
    }
    for (;;)
    {
      this.FQ.setImageResource(paramInt2);
      if (paramInt2 != 0) {
        break label200;
      }
      this.FQ.setVisibility(8);
      return;
      i = 0;
      break;
      label108:
      j = 0;
      break label22;
      label114:
      i = 0;
      break label30;
      label119:
      i = 0;
      break label46;
      label124:
      j = 0;
      break label54;
      label130:
      this.FP.setVisibility(0);
      wja.i(this.FP, (int)(this.mDensity * 5.0F + 0.5F), (int)(this.mDensity * 5.0F + 0.5F), (int)(this.mDensity * 5.0F + 0.5F), (int)(this.mDensity * 5.0F + 0.5F));
    }
    label200:
    this.FQ.setVisibility(0);
    wja.i(this.FQ, (int)(this.mDensity * 5.0F + 0.5F), (int)(this.mDensity * 5.0F + 0.5F), (int)(this.mDensity * 5.0F + 0.5F), (int)(this.mDensity * 5.0F + 0.5F));
  }
  
  public void setTitleIconLeftForMutualMark(ajoh paramajoh1, ajoh paramajoh2)
  {
    ImageView[] arrayOfImageView = new ImageView[2];
    arrayOfImageView[0] = this.FP;
    arrayOfImageView[1] = this.FQ;
    int i = 0;
    if (i < arrayOfImageView.length)
    {
      ajoh localajoh = new ajoh[] { paramajoh1, paramajoh2 }[i];
      ImageView localImageView = arrayOfImageView[i];
      int j = localImageView.getVisibility();
      ajns localajns;
      if ((localajoh != null) && (localajoh.ark())) {
        if (!TextUtils.isEmpty(localajoh.icon_static_url))
        {
          localajns = new ajns(getContext(), localajoh.icon_static_url);
          label102:
          if (TextUtils.isEmpty(localajoh.bRP)) {
            break label250;
          }
          ajoe.a(getResources(), localImageView, localajoh.bRP, localajns);
          localImageView.setAlpha(localajoh.bg());
          localImageView.setContentDescription(localajoh.name);
          localImageView.setVisibility(0);
          wja.i(localImageView, (int)(this.mDensity * 5.0F + 0.5F), (int)(this.mDensity * 5.0F + 0.5F), (int)(this.mDensity * 5.0F + 0.5F), (int)(this.mDensity * 5.0F + 0.5F));
        }
      }
      for (;;)
      {
        if (j != localImageView.getVisibility()) {}
        i += 1;
        break;
        localajns = new ajns(getContext(), localajoh.iconResId);
        break label102;
        label250:
        localImageView.setImageDrawable(null);
        ViewGroup.LayoutParams localLayoutParams = localImageView.getLayoutParams();
        if (localajns.getIntrinsicWidth() > 0) {}
        for (localLayoutParams.width = localajns.getIntrinsicWidth();; localLayoutParams.width = -2)
        {
          localImageView.setLayoutParams(localLayoutParams);
          localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
          localImageView.setImageDrawable(localajns);
          break;
        }
        localImageView.setVisibility(8);
      }
    }
  }
  
  public void setTitleIconRight(String paramString, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.navbar.NavBarAIO
 * JD-Core Version:    0.7.0.1
 */