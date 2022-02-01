package com.tencent.av.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqbn;
import aqmr;
import aqnm;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.beauty.BeautySeekView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import iti;
import java.util.ArrayList;
import java.util.Iterator;
import jct;
import jcu;
import jiu;
import jiw;
import jjc;
import jlf;
import jll;
import wja;

public class QavOperationMenuView
  extends QavMenuBaseView
  implements View.OnClickListener
{
  BeautySeekView jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView = null;
  jct jdField_a_of_type_Jct = null;
  jiw jdField_a_of_type_Jiw = null;
  ViewGroup aF = null;
  private RedTouch d;
  LinearLayout df = null;
  private RedTouch e;
  private RedTouch f;
  private RedTouch g;
  long oK = 0L;
  
  public QavOperationMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QavOperationMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QavOperationMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void a(jiu paramjiu, View paramView)
  {
    paramView.setClickable(paramjiu.isClickable());
    int i;
    TextView localTextView;
    int j;
    int k;
    if (paramjiu.isVisiable())
    {
      i = 0;
      paramView.setVisibility(i);
      if ((paramView instanceof TextView))
      {
        localTextView = (TextView)paramView;
        j = jlf.a(paramView, 2131377192);
        k = jlf.a(paramView, 2131364932);
        String str = paramjiu.hq();
        paramView = jlf.a(paramView, 2131377220);
        if (TextUtils.isEmpty(str)) {
          break label168;
        }
        localTextView.setTag(2131377192, Integer.valueOf(0));
        if (str != paramView)
        {
          localTextView.setTag(2131377220, str);
          paramView = a(localTextView, str);
          paramView.setBounds(0, 0, wja.dp2px(28.0F, localTextView.getResources()), wja.dp2px(28.0F, localTextView.getResources()));
          localTextView.setCompoundDrawables(null, paramView, null, null);
        }
      }
    }
    label168:
    label248:
    for (;;)
    {
      if (!aqmr.isEmpty(paramjiu.getText())) {
        localTextView.setText(paramjiu.getText());
      }
      return;
      i = 8;
      break;
      localTextView.setTag(2131377220, null);
      if (paramjiu.xy()) {}
      for (i = 2131166218;; i = 2131166217)
      {
        if ((paramjiu.mC() == j) && (i == k)) {
          break label248;
        }
        localTextView.setTag(2131377192, Integer.valueOf(paramjiu.mC()));
        localTextView.setTag(2131364932, Integer.valueOf(i));
        AudioHelper.a(getResources(), localTextView, paramjiu.mC(), i, i);
        break;
      }
    }
  }
  
  private void init()
  {
    this.TAG = ("QavOperationMenuView_" + AudioHelper.hG());
    setGravity(80);
    LayoutInflater.from(getContext()).inflate(2131559954, this, true);
    setBackgroundResource(2130843030);
    this.aF = ((ViewGroup)findViewById(2131363361));
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView = ((BeautySeekView)this.aF.findViewById(2131363380));
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.a(getContext().getString(2131697591), "BEAUTY_SKIN", 50, 0);
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.setBeautySeekActionListener(new jcu(this));
    ((ImageView)findViewById(2131363377)).setVisibility(8);
    this.df = ((LinearLayout)findViewById(2131372719));
    if (AudioHelper.jY(0) == 1)
    {
      this.df.setBackgroundColor(536870656);
      setBackgroundColor(2130755583);
    }
  }
  
  public void K(long paramLong, boolean paramBoolean)
  {
    super.K(paramLong, paramBoolean);
    if (paramBoolean)
    {
      mF(this.mApp.ak("BEAUTY_SKIN"));
      refreshUI();
    }
  }
  
  public Drawable a(TextView paramTextView, String paramString)
  {
    int i = wja.dp2px(28.0F, paramTextView.getResources());
    paramTextView = URLDrawable.URLDrawableOptions.obtain();
    paramTextView.mRequestWidth = i;
    paramTextView.mRequestHeight = i;
    paramTextView.mFailedDrawable = null;
    paramTextView.mLoadingDrawable = null;
    paramTextView = URLDrawable.getDrawable(paramString, paramTextView);
    paramTextView.setTag(aqbn.e(i, i));
    paramTextView.setDecodeHandler(aqbn.b);
    if (paramTextView.getStatus() == 1) {
      return paramTextView;
    }
    paramTextView.draw(new Canvas());
    return paramTextView;
  }
  
  View a(int paramInt, jiu paramjiu)
  {
    if ((this.df == null) || (paramInt < 0)) {
      return null;
    }
    if (this.df.getChildCount() <= paramInt)
    {
      paramjiu = a(paramjiu);
      this.df.addView(paramjiu, paramInt);
      return paramjiu;
    }
    View localView = this.df.getChildAt(paramInt);
    jiu localjiu = (jiu)localView.getTag(2131372726);
    if ((localjiu != null) && (localjiu.getId() == paramjiu.getId())) {
      return localView;
    }
    paramjiu = a(paramjiu);
    this.df.addView(paramjiu, paramInt);
    return paramjiu;
  }
  
  View a(jiu paramjiu)
  {
    if (paramjiu == null) {
      return null;
    }
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.weight = 1.0F;
    Button localButton = new Button(getContext());
    localButton.setLayoutParams(localLayoutParams);
    localButton.setSingleLine();
    AudioHelper.a(getResources(), localButton, paramjiu.mC(), 2131166217, 2131166217);
    if (!aqmr.isEmpty(paramjiu.getText())) {
      localButton.setText(paramjiu.getText());
    }
    localButton.setBackgroundDrawable(null);
    localButton.setId(paramjiu.getId());
    localButton.setOnClickListener(this);
    localButton.setTag(2131372726, paramjiu);
    localButton.setTextSize(aqnm.pxTosp(wja.dp2px(12.0F, getResources())));
    localButton.setCompoundDrawablePadding(wja.dp2px(8.0F, getResources()));
    paramjiu.aAn = ((int)Math.max(jll.a(localButton), wja.dp2px(28.0F, getResources())));
    return localButton;
  }
  
  public void a(QavPanel paramQavPanel)
  {
    super.a(paramQavPanel);
    if (this.mApp != null) {
      mF(this.mApp.ak("BEAUTY_SKIN"));
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    long l = SystemClock.elapsedRealtime();
    if (((i & 0xFF) != 2) || (Math.abs(l - this.oK) > 200L))
    {
      this.oK = l;
      EffectSettingUi.a(this.mApp, -1029L);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  void mF(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView != null) {
      this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.mF(paramInt);
    }
  }
  
  @SuppressLint({"ResourceType"})
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131363377)
    {
      if (this.jdField_a_of_type_Jct != null) {
        this.jdField_a_of_type_Jct.y(this, 3);
      }
      if (this.f != null)
      {
        iti.a(this.mApp, this.f, 7);
        this.f = null;
      }
      jjc.au("0X800A566", 0);
      if (i != 2131697529) {
        break label121;
      }
      if (this.d != null)
      {
        iti.a(this.mApp, this.d, 2);
        this.d = null;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Jct == null) {
        break;
      }
      this.jdField_a_of_type_Jct.e(this, paramView);
      break;
      label121:
      if (i == 2131697527)
      {
        if (this.e != null)
        {
          iti.a(this.mApp, this.e, 6);
          this.e = null;
        }
      }
      else if ((i == 2131697532) && (this.g != null))
      {
        iti.a(this.mApp, this.g, 9);
        this.g = null;
      }
    }
  }
  
  @SuppressLint({"ResourceType"})
  public void refreshUI()
  {
    super.refreshUI();
    if (this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView != null)
    {
      if ((this.jdField_a_of_type_Jiw == null) || (!this.jdField_a_of_type_Jiw.xz())) {
        break label123;
      }
      this.aF.setVisibility(0);
      this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView.YX = true;
      localObject1 = (ImageView)this.aF.findViewById(2131363377);
      if ((((ImageView)localObject1).getVisibility() == 0) && (this.f == null)) {
        this.f = iti.a(this.mApp, (View)localObject1, 7);
      }
    }
    for (;;)
    {
      if (this.df != null)
      {
        if ((this.jdField_a_of_type_Jiw != null) && (this.jdField_a_of_type_Jiw.aU().size() != 0)) {
          break;
        }
        this.df.removeAllViewsInLayout();
      }
      return;
      label123:
      this.aF.setVisibility(8);
    }
    Object localObject1 = this.jdField_a_of_type_Jiw.aU().iterator();
    int i = 0;
    int j = 0;
    Object localObject2;
    View localView;
    int i2;
    int k;
    label242:
    int n;
    label256:
    int m;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (jiu)((Iterator)localObject1).next();
      localView = a(j, (jiu)localObject2);
      if (localView != null) {}
    }
    else
    {
      i = this.df.getChildCount();
      if (i > j) {
        this.df.removeViews(j, i - j);
      }
      if (this.jdField_a_of_type_Jiw == null) {
        break label821;
      }
      i = this.jdField_a_of_type_Jiw.mD();
      i2 = this.df.getChildCount();
      if (i > 5) {
        break label636;
      }
      k = 1;
      n = ImmersiveUtils.getScreenWidth();
      if (k == 0) {
        break label641;
      }
      j = n / i;
      localObject1 = this.jdField_a_of_type_Jiw.aV();
      if (k != 0) {
        break label752;
      }
      m = 0;
      j = 0;
      i = 0;
      for (;;)
      {
        if ((m >= ((ArrayList)localObject1).size()) || (i > 5)) {
          break label668;
        }
        localObject2 = (jiu)((ArrayList)localObject1).get(m);
        if (!((jiu)localObject2).isVisiable()) {
          break label832;
        }
        if (i == 5) {
          break;
        }
        j = ((jiu)localObject2).aAn + j;
        label324:
        i += 1;
        label328:
        m += 1;
      }
    }
    if (localView.getId() == 2131697529)
    {
      this.d = iti.a(this.mApp, localView, 2);
      if (this.d != null)
      {
        k = (int)jll.a(getContext(), localView.getPaddingRight());
        m = (int)jll.a(getContext(), localView.getPaddingTop());
        this.d.a(0, k, m, 0).a();
      }
    }
    if (localView.getId() == 2131697527)
    {
      this.e = iti.a(this.mApp, localView, 6);
      if (this.e != null)
      {
        k = (int)jll.a(getContext(), localView.getPaddingRight());
        m = (int)jll.a(getContext(), localView.getPaddingTop());
        this.e.a(0, k, m, 0).a();
      }
    }
    if (localView.getId() == 2131697532)
    {
      this.g = iti.a(this.mApp, localView, 9);
      if (this.g != null)
      {
        k = (int)jll.a(getContext(), localView.getPaddingRight());
        m = (int)jll.a(getContext(), localView.getPaddingTop());
        this.g.a(0, k, m, 0).a();
      }
    }
    a((jiu)localObject2, localView);
    j += 1;
    if ((((jiu)localObject2).isVisiable()) && (AudioHelper.jY(0) == 1)) {
      if (i % 2 == 0)
      {
        localView.setBackgroundColor(-536881408);
        label618:
        i += 1;
      }
    }
    for (;;)
    {
      break;
      localView.setBackgroundColor(-539173668);
      break label618;
      label636:
      k = 0;
      break label242;
      label641:
      j = (int)(n * 1.0F / 5.5F);
      break label256;
      j = ((jiu)localObject2).aAn / 2 + j;
      break label324;
      label668:
      j = (int)((n - j) * 1.0F / 5.5F);
      i = 0;
      m = 0;
      label686:
      if (m < i2)
      {
        localObject2 = this.df.getChildAt(m);
        if (((View)localObject2).getVisibility() == 0)
        {
          n = 1;
          label715:
          if (n == 0) {
            break label829;
          }
          if (k == 0) {
            break label794;
          }
          n = j;
          label727:
          ((View)localObject2).setLayoutParams(new LinearLayout.LayoutParams(n, -2));
        }
      }
      label794:
      label821:
      label829:
      for (;;)
      {
        m += 1;
        break label686;
        label752:
        anot.a(null, "CliOper", "", "", "0X800A342", "0X800A342", 0, 0, "", "", "", "");
        break;
        n = 0;
        break label715;
        int i1 = i + 1;
        n = ((jiu)((ArrayList)localObject1).get(i)).aAn + j;
        i = i1;
        break label727;
        this.df.requestLayout();
        return;
      }
      label832:
      break label328;
    }
  }
  
  public void setQavMenuActionListener(jct paramjct)
  {
    this.jdField_a_of_type_Jct = paramjct;
  }
  
  public void setViewController(jiw paramjiw)
  {
    this.jdField_a_of_type_Jiw = paramjiw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.QavOperationMenuView
 * JD-Core Version:    0.7.0.1
 */