package com.tencent.mobileqq.extendfriend.wiget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import anot;
import aqdj;
import aqhu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;
import java.util.List;
import jll;
import wja;

public class ExtendFriendBottomBarView
  extends FrameLayout
{
  private QQBlurView a;
  private int cVk;
  boolean cbI;
  boolean cbJ;
  boolean cbK;
  private RelativeLayout kg;
  private RelativeLayout kh;
  private QQAppInterface mApp;
  private ArrayList<ImageView> ww;
  
  public ExtendFriendBottomBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExtendFriendBottomBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExtendFriendBottomBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflate(paramContext, 2131561316, this);
    initViews();
  }
  
  private void bIh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBottomBarView", 2, "hideBottomBar ");
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.kg, "translationY", new float[] { 0.0F, this.cVk });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.start();
    if (this.cbK)
    {
      localObjectAnimator = ObjectAnimator.ofFloat(this.a, "translationY", new float[] { 0.0F, this.cVk });
      localObjectAnimator.setDuration(500L);
      localObjectAnimator.start();
    }
  }
  
  private void initViews()
  {
    this.cVk = wja.dp2px(66.0F, getResources());
    this.kg = ((RelativeLayout)findViewById(2131363632));
    this.kg.setOnTouchListener(jll.a);
    this.kg.setTranslationY(this.cVk);
    this.a = ((QQBlurView)findViewById(2131363636));
    this.a.setTranslationY(this.cVk);
    this.ww = new ArrayList();
    this.kh = ((RelativeLayout)findViewById(2131368415));
    int i = 0;
    while (i < this.kh.getChildCount())
    {
      localObject = (ImageView)this.kh.getChildAt(i);
      ((ImageView)localObject).setVisibility(8);
      this.ww.add(localObject);
      i += 1;
    }
    ImageView localImageView = (ImageView)findViewById(2131362983);
    Object localObject = localImageView.getDrawable();
    if ((localObject instanceof SkinnableBitmapDrawable)) {}
    for (localObject = ((SkinnableBitmapDrawable)localObject).mutate2();; localObject = ((Drawable)localObject).mutate())
    {
      ((Drawable)localObject).setColorFilter(-16578534, PorterDuff.Mode.SRC_ATOP);
      localImageView.setImageDrawable((Drawable)localObject);
      return;
    }
  }
  
  private void showBottomBar()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBottomBarView", 2, "showBottomBar ");
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.kg, "translationY", new float[] { this.cVk, 0.0F });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.start();
    if (this.cbK)
    {
      localObjectAnimator = ObjectAnimator.ofFloat(this.a, "translationY", new float[] { this.cVk, 0.0F });
      localObjectAnimator.setDuration(500L);
      localObjectAnimator.start();
    }
    anot.a(this.mApp, "dc00898", "", "", "0X8009E2E", "0X8009E2E", 0, 0, "", "", "", "");
  }
  
  public void IJ(boolean paramBoolean)
  {
    if (!this.cbJ)
    {
      this.cbJ = true;
      this.cbI = paramBoolean;
      if (!this.cbI) {
        showBottomBar();
      }
    }
    do
    {
      return;
      if ((!this.cbI) && (paramBoolean)) {
        bIh();
      }
      if ((this.cbI) && (!paramBoolean)) {
        showBottomBar();
      }
    } while (this.cbI == paramBoolean);
    this.cbI = paramBoolean;
  }
  
  public void b(QQAppInterface paramQQAppInterface, View paramView)
  {
    this.mApp = paramQQAppInterface;
    if (paramView != null) {
      gC(paramView);
    }
  }
  
  void gC(View paramView)
  {
    if (!this.cbK) {
      if (Build.VERSION.SDK_INT < 24) {
        break label115;
      }
    }
    label115:
    for (boolean bool = true;; bool = false)
    {
      this.a.setVisibility(0);
      this.a.iD(paramView);
      this.a.iE(this.a);
      this.a.YJ(-1);
      this.a.setEnableBlur(bool);
      this.a.YI(0);
      this.a.bg(8.0F);
      this.a.YK(8);
      this.a.setDisableBlurDrawableRes(2130852004);
      this.a.onCreate();
      this.a.onResume();
      this.cbK = true;
      return;
    }
  }
  
  public void kC(List<String> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBottomBarView", 2, String.format("updateUinList uinList=%s", new Object[] { paramList }));
    }
    if (paramList != null)
    {
      int j = paramList.size();
      if (j > 0)
      {
        int k = this.ww.size();
        int i = 0;
        if (i < k)
        {
          ImageView localImageView = (ImageView)this.ww.get(i);
          String str;
          if (i < j)
          {
            str = (String)paramList.get(i);
            label87:
            if (TextUtils.isEmpty(str)) {
              break label140;
            }
            Drawable localDrawable = aqhu.c(true);
            localImageView.setImageDrawable(aqdj.a(this.mApp, 1, str, 4, localDrawable, localDrawable));
            localImageView.setVisibility(0);
          }
          for (;;)
          {
            i += 1;
            break;
            str = null;
            break label87;
            label140:
            localImageView.setVisibility(8);
          }
        }
        this.kh.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.kh.setVisibility(8);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.kg != null) {
      this.kg.setOnClickListener(paramOnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendBottomBarView
 * JD-Core Version:    0.7.0.1
 */