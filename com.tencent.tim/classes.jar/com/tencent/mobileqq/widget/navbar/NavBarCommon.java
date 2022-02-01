package com.tencent.mobileqq.widget.navbar;

import acfp;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqcl;
import aqgz;
import aqnm;
import arkn;
import com.tencent.common.config.AppSetting;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import wja;

public class NavBarCommon
  extends RelativeLayout
  implements View.OnClickListener
{
  private static final int CUSTOM_VIEW_MARGIN = 24;
  private Drawable ad;
  private View animView;
  private TextView bottomTitle;
  private TextView centerView;
  private TextView leftView;
  private TextView leftViewNotBack;
  private arkn listener;
  private ImageView mLeftBackIcon;
  private TextView mLeftBackText;
  private RelativeLayout mLoadingParent;
  private ImageView mLoadingView;
  private boolean mNotShowLeftText = true;
  private Drawable[] mOldDrawables;
  private int mOldPadding;
  protected boolean mUseOptimizMode;
  private ImageView rightViewImg;
  private ImageView rightViewImg1;
  private TextView rightViewText;
  private TextView rightViewText2;
  private RelativeLayout titleContainer;
  private TextView topTitle;
  
  public NavBarCommon(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public NavBarCommon(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public NavBarCommon(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    View.inflate(paramContext, 2131559122, this);
    setBackgroundResource(2130851105);
    this.leftView = ((TextView)findViewById(2131369579));
    this.mLeftBackText = ((TextView)findViewById(2131380514));
    this.mLeftBackIcon = ((ImageView)findViewById(2131369967));
    this.leftViewNotBack = ((TextView)findViewById(2131369581));
    this.centerView = ((TextView)findViewById(2131369627));
    this.titleContainer = ((RelativeLayout)findViewById(2131379823));
    this.topTitle = ((TextView)findViewById(2131379865));
    this.bottomTitle = ((TextView)findViewById(2131379802));
    this.rightViewText = ((TextView)findViewById(2131369612));
    this.rightViewImg1 = ((ImageView)findViewById(2131369600));
    this.rightViewText2 = ((TextView)findViewById(2131369613));
    this.rightViewImg = ((ImageView)findViewById(2131369594));
    if (AppSetting.enableTalkBack)
    {
      aqcl.changeAccessibilityForView(this.leftView, Button.class.getName());
      if (this.mLeftBackText != null) {
        aqcl.changeAccessibilityForView(this.mLeftBackText, Button.class.getName());
      }
      if (this.mLeftBackIcon != null) {
        aqcl.changeAccessibilityForView(this.mLeftBackIcon, Button.class.getName());
      }
    }
  }
  
  public static void setLayerType(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.setLayerType(0, null);
  }
  
  public void changeBg(boolean paramBoolean)
  {
    ColorStateList localColorStateList;
    TextView localTextView;
    if (paramBoolean)
    {
      i = 2131167654;
      setBackgroundResource(i);
      localColorStateList = getResources().getColorStateList(2131167299);
      this.leftView.setTextColor(localColorStateList);
      localTextView = this.leftView;
      if (!paramBoolean) {
        break label96;
      }
    }
    label96:
    for (int i = 2130840658;; i = 2130851758)
    {
      localTextView.setBackgroundResource(i);
      this.leftViewNotBack.setTextColor(localColorStateList);
      this.mLeftBackText.setTextColor(localColorStateList);
      this.centerView.setTextColor(localColorStateList);
      this.rightViewText.setTextColor(localColorStateList);
      this.rightViewText2.setTextColor(localColorStateList);
      return;
      i = 2130851105;
      break;
    }
  }
  
  public void hideLeft()
  {
    this.leftView.setVisibility(8);
    this.mLeftBackText.setVisibility(8);
    this.mLeftBackIcon.setVisibility(8);
    this.leftViewNotBack.setVisibility(8);
  }
  
  public void hideLeftText()
  {
    aqnm.setVisible(this.leftViewNotBack, 8);
  }
  
  public boolean isTitleProgressShowing()
  {
    if ((this.mUseOptimizMode) && (this.mLoadingParent != null))
    {
      if ((this.mLoadingView == null) || (this.mLoadingView.getVisibility() == 8)) {}
    }
    else {
      while (this.ad != null) {
        return true;
      }
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (this.listener == null) {}
    label165:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = 0;
      switch (paramView.getId())
      {
      }
      for (;;)
      {
        if (i == 0) {
          break label165;
        }
        this.listener.onItemSelect(paramView, i);
        break;
        i = 1;
        continue;
        i = 2;
        continue;
        i = 4;
        continue;
        i = 3;
        continue;
        i = 5;
        continue;
        i = 7;
        continue;
        i = 8;
      }
    }
  }
  
  public void setCustomView(View paramView)
  {
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, wja.dp2px(29.0F, getResources()));
    this.centerView.setVisibility(8);
    localLayoutParams1.addRule(13, -1);
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.titleContainer.getLayoutParams();
    int i = wja.dp2px(24.0F, getResources());
    localLayoutParams2.leftMargin = i;
    localLayoutParams2.rightMargin = i;
    this.titleContainer.setLayoutParams(localLayoutParams2);
    this.titleContainer.addView(paramView, localLayoutParams1);
    this.titleContainer.setVisibility(0);
  }
  
  public void setLeftBackVisible(int paramInt)
  {
    aqnm.setVisible(this.leftView, paramInt);
  }
  
  public void setLeftButton(int paramInt)
  {
    this.leftView.setVisibility(8);
    this.leftViewNotBack = ((TextView)findViewById(2131369581));
    setLayerType(this.leftViewNotBack);
    this.leftViewNotBack.setVisibility(0);
    this.leftViewNotBack.setText(paramInt);
  }
  
  public void setLeftButton(String paramString)
  {
    this.leftView.setVisibility(8);
    this.leftViewNotBack = ((TextView)findViewById(2131369581));
    setLayerType(this.leftViewNotBack);
    this.leftViewNotBack.setVisibility(0);
    this.leftViewNotBack.setText(paramString);
  }
  
  public void setLeftViewName(int paramInt)
  {
    Object localObject2;
    TextView localTextView;
    Object localObject1;
    if (this.leftView != null)
    {
      if (this.leftViewNotBack != null) {
        this.leftViewNotBack.setVisibility(8);
      }
      localObject2 = getContext().getString(paramInt);
      localTextView = this.leftView;
      localObject1 = localObject2;
      if ("".equals(localObject2)) {
        localObject1 = getContext().getString(2131691039);
      }
      if (!this.mNotShowLeftText) {
        break label144;
      }
      localTextView.setText("  ");
    }
    for (;;)
    {
      localTextView.setVisibility(0);
      if (AppSetting.enableTalkBack)
      {
        localObject2 = localObject1;
        if (!((String)localObject1).contains(getContext().getString(2131691039))) {
          localObject2 = getContext().getString(2131691039) + (String)localObject1;
        }
        this.leftView.setContentDescription((CharSequence)localObject2);
      }
      return;
      label144:
      localTextView.setText((CharSequence)localObject1);
    }
  }
  
  public void setLeftViewName(Bundle paramBundle)
  {
    if ((this.leftView != null) && (paramBundle != null))
    {
      if (this.leftViewNotBack != null) {
        this.leftViewNotBack.setVisibility(8);
      }
      try
      {
        TextView localTextView = this.leftView;
        Object localObject = paramBundle.getString("leftViewText");
        int i = paramBundle.getInt("individuation_url_type");
        paramBundle = (Bundle)localObject;
        if (i >= 40300)
        {
          paramBundle = (Bundle)localObject;
          if (i <= 40313)
          {
            paramBundle = (Bundle)localObject;
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              paramBundle = (Bundle)localObject;
              if (((String)localObject).contains(acfp.m(2131708634))) {
                paramBundle = getContext().getString(2131691039);
              }
            }
          }
        }
        localObject = paramBundle;
        if (paramBundle == null) {
          localObject = getContext().getString(2131691039);
        }
        if (this.mNotShowLeftText) {
          localTextView.setText("  ");
        }
        for (;;)
        {
          localTextView.setVisibility(0);
          if (!AppSetting.enableTalkBack) {
            break;
          }
          paramBundle = (Bundle)localObject;
          if (!((String)localObject).contains(getContext().getString(2131691039))) {
            paramBundle = getContext().getString(2131691039) + (String)localObject;
          }
          this.leftView.setContentDescription(paramBundle);
          return;
          localTextView.setText((CharSequence)localObject);
        }
        return;
      }
      catch (Exception paramBundle) {}
    }
  }
  
  public void setNotShowLeftText(boolean paramBoolean)
  {
    this.mNotShowLeftText = paramBoolean;
  }
  
  public void setOnItemSelectListener(arkn paramarkn)
  {
    this.listener = paramarkn;
    this.leftView.setOnClickListener(this);
    if (this.mLeftBackText != null) {
      this.mLeftBackText.setOnClickListener(this);
    }
    if (this.mLeftBackIcon != null) {
      this.mLeftBackIcon.setOnClickListener(this);
    }
    if (this.leftViewNotBack != null) {
      this.leftViewNotBack.setOnClickListener(this);
    }
    this.rightViewText.setOnClickListener(this);
    this.rightViewImg1.setOnClickListener(this);
    this.rightViewText2.setOnClickListener(this);
    this.rightViewImg.setOnClickListener(this);
    this.centerView.setOnClickListener(this);
    this.titleContainer.setOnClickListener(this);
  }
  
  public void setRightButton(int paramInt)
  {
    this.rightViewText.setVisibility(0);
    this.rightViewImg1.setVisibility(8);
    this.rightViewText.setText(paramInt);
    this.rightViewText.setEnabled(true);
    if (AppSetting.enableTalkBack) {
      this.rightViewText.setContentDescription(this.rightViewText.getText() + acfp.m(2131708635));
    }
  }
  
  public void setRightButton(String paramString)
  {
    this.rightViewText.setVisibility(0);
    this.rightViewImg1.setVisibility(8);
    this.rightViewText.setText(paramString);
    this.rightViewText.setEnabled(true);
    if (AppSetting.enableTalkBack) {
      this.rightViewText.setContentDescription(this.rightViewText.getText() + acfp.m(2131708633));
    }
  }
  
  public void setRightButton2(int paramInt)
  {
    this.rightViewText2.setVisibility(0);
    this.rightViewImg.setVisibility(8);
    this.rightViewText2.setText(paramInt);
    this.rightViewText2.setEnabled(true);
    if (AppSetting.enableTalkBack) {
      this.rightViewText.setContentDescription(this.rightViewText.getText() + acfp.m(2131708636));
    }
  }
  
  public void setRightImage(Drawable paramDrawable)
  {
    this.rightViewImg1.setVisibility(0);
    this.rightViewText.setVisibility(8);
    this.rightViewImg1.setImageDrawable(paramDrawable);
  }
  
  public void setRightImage2(Drawable paramDrawable)
  {
    this.rightViewImg.setImageDrawable(paramDrawable);
    this.rightViewImg.setVisibility(0);
    this.rightViewText2.setVisibility(8);
  }
  
  public void setRightImage2Desc(String paramString)
  {
    this.rightViewImg.setContentDescription(paramString);
  }
  
  public void setRightImageDesc(String paramString)
  {
    this.rightViewImg1.setContentDescription(paramString);
  }
  
  public void setRightViewTextVisible(int paramInt)
  {
    aqnm.setVisible(this.rightViewText, paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (this.centerView != null)
    {
      this.centerView.setText(paramCharSequence);
      this.centerView.setVisibility(0);
    }
    if (this.titleContainer != null) {
      this.titleContainer.setVisibility(8);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, CharSequence paramCharSequence4)
  {
    if (this.centerView.getVisibility() != 8) {
      this.centerView.setVisibility(8);
    }
    if (this.titleContainer.getVisibility() != 0) {
      this.titleContainer.setVisibility(0);
    }
    if (!TextUtils.equals(paramCharSequence1, this.topTitle.getText()))
    {
      this.topTitle.setText(paramCharSequence1);
      this.topTitle.setContentDescription(paramCharSequence2);
    }
    if (!TextUtils.equals(paramCharSequence3, this.bottomTitle.getText()))
    {
      this.bottomTitle.setText(paramCharSequence3);
      this.bottomTitle.setContentDescription(paramCharSequence4);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence, String paramString)
  {
    if (this.centerView != null)
    {
      if (this.centerView.getVisibility() != 0) {
        this.centerView.setVisibility(0);
      }
      if (!TextUtils.equals(paramCharSequence, this.centerView.getText())) {
        this.centerView.setText(paramCharSequence);
      }
      if ((!TextUtils.equals(paramString, this.centerView.getContentDescription())) && (AppSetting.enableTalkBack)) {
        this.centerView.setContentDescription(paramString);
      }
    }
    if ((this.titleContainer != null) && (this.titleContainer.getVisibility() != 8)) {
      this.titleContainer.setVisibility(8);
    }
  }
  
  public void setTitleColor(int paramInt)
  {
    if (this.centerView != null)
    {
      this.centerView.setTextColor(paramInt);
      this.centerView.setVisibility(0);
    }
  }
  
  public void showLeftText()
  {
    aqnm.setVisible(this.leftViewNotBack, 0);
  }
  
  public boolean startTitleProgress()
  {
    if (this.centerView == null) {
      return false;
    }
    Object localObject1;
    if (this.mUseOptimizMode)
    {
      localObject1 = (RelativeLayout)findViewById(2131379823);
      if (this.centerView.getVisibility() == 0)
      {
        localObject1 = this.centerView;
        localObject2 = this.centerView.getParent();
        if ((this.mLoadingParent != null) && (this.mLoadingParent != localObject2))
        {
          if ((this.mLoadingView != null) && (this.mLoadingView.getParent() == this.mLoadingParent))
          {
            this.mLoadingParent.removeView(this.mLoadingView);
            this.mLoadingView = null;
          }
          this.mLoadingParent = null;
        }
        if ((this.mLoadingParent == null) && ((localObject2 instanceof RelativeLayout))) {
          this.mLoadingParent = ((RelativeLayout)localObject2);
        }
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (this.mLoadingView != null)
          {
            int i = ((View)localObject1).getId();
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mLoadingView.getLayoutParams();
            localObject2 = localObject1;
            if (localLayoutParams.getRules()[0] != i)
            {
              localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject2).rightMargin = 0;
              ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
              ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
              localLayoutParams.addRule(0, i);
              this.mLoadingView.setLayoutParams(localLayoutParams);
            }
          }
        }
      }
    }
    for (Object localObject2 = localObject1;; localObject2 = null)
    {
      if ((this.mUseOptimizMode) && (this.mLoadingParent != null))
      {
        if ((this.mLoadingView != null) && (this.mLoadingView.getVisibility() == 0)) {
          break label520;
        }
        if (this.mLoadingView == null)
        {
          localObject1 = (RelativeLayout.LayoutParams)((View)localObject2).getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = 0;
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = 0;
          ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.mLoadingView = new ImageView(getContext());
          this.mLoadingView.setId(2131370796);
          localObject1 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, ((View)localObject2).getId());
          ((RelativeLayout.LayoutParams)localObject1).addRule(15);
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = ((int)(7.0F * aqgz.getDesity()));
          this.mLoadingParent.addView(this.mLoadingView, (ViewGroup.LayoutParams)localObject1);
          localObject1 = getResources().getDrawable(2130839655);
          this.mLoadingView.setImageDrawable((Drawable)localObject1);
          if ((localObject1 instanceof Animatable)) {
            ((Animatable)localObject1).start();
          }
        }
        if (this.mLoadingView.getVisibility() != 0) {
          this.mLoadingView.setVisibility(0);
        }
        return true;
        if ((localObject1 == null) || (((RelativeLayout)localObject1).getVisibility() != 0)) {
          break label522;
        }
        localObject2 = ((RelativeLayout)localObject1).getParent();
        break;
      }
      if (this.ad == null)
      {
        this.ad = getResources().getDrawable(2130839655);
        this.mOldDrawables = this.centerView.getCompoundDrawables();
        this.mOldPadding = this.centerView.getCompoundDrawablePadding();
        this.centerView.setCompoundDrawablePadding(10);
        this.centerView.setCompoundDrawablesWithIntrinsicBounds(this.ad, this.mOldDrawables[1], this.mOldDrawables[2], this.mOldDrawables[3]);
        ((Animatable)this.ad).start();
        return true;
      }
      label520:
      return false;
      label522:
      localObject2 = null;
      localObject1 = null;
      break;
    }
  }
  
  public boolean stopTitleProgress()
  {
    if ((this.mUseOptimizMode) && (this.mLoadingParent != null))
    {
      if ((this.mLoadingView != null) && (this.mLoadingView.getVisibility() != 8))
      {
        this.mLoadingView.setVisibility(8);
        return true;
      }
    }
    else if (this.ad != null)
    {
      ((Animatable)this.ad).stop();
      this.ad = null;
      this.centerView.setCompoundDrawablePadding(this.mOldPadding);
      this.centerView.setCompoundDrawablesWithIntrinsicBounds(this.mOldDrawables[0], this.mOldDrawables[1], this.mOldDrawables[2], this.mOldDrawables[3]);
      return true;
    }
    return false;
  }
  
  public void toggleAnim(boolean paramBoolean, Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.animView == null)
    {
      if (!paramBoolean) {
        return;
      }
      this.animView = new View(getContext());
      this.animView.setBackgroundResource(2130851105);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      addView(this.animView, 0, localLayoutParams);
    }
    if (paramBoolean)
    {
      this.animView.animate().alpha(1.0F).setDuration(300L).setInterpolator(new AccelerateInterpolator()).setListener(paramAnimatorListener);
      return;
    }
    this.animView.animate().alpha(0.0F).setDuration(300L).setInterpolator(new AccelerateInterpolator()).setListener(paramAnimatorListener);
  }
  
  public void updateRedDot(int paramInt, boolean paramBoolean)
  {
    View localView;
    switch (paramInt)
    {
    default: 
      localView = null;
      if (localView != null) {
        if (!paramBoolean) {
          break label94;
        }
      }
      break;
    }
    label94:
    for (paramInt = 0;; paramInt = 8)
    {
      localView.setVisibility(paramInt);
      return;
      localView = findViewById(2131369593);
      break;
      localView = findViewById(2131369598);
      break;
      localView = findViewById(2131369614);
      break;
      localView = findViewById(2131369615);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.navbar.NavBarCommon
 * JD-Core Version:    0.7.0.1
 */