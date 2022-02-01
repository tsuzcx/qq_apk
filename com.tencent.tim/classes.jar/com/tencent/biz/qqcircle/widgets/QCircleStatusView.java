package com.tencent.biz.qqcircle.widgets;

import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.immersive.ImmersiveUtils;
import oug;

public class QCircleStatusView
  extends StatusView
{
  private String asL;
  private String asM = getResources().getString(2131703530);
  private int biP = 16;
  private int biQ = Color.parseColor("#03081A");
  private LinearLayout mRootView;
  private ImageView mn;
  private ImageView mo;
  private TextView wH;
  private TextView wI;
  
  public QCircleStatusView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleStatusView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void bkW()
  {
    if (Build.VERSION.SDK_INT < 16) {
      this.mRootView.setBackgroundDrawable(null);
    }
    for (;;)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
      localMarginLayoutParams.topMargin = (-ImmersiveUtils.dpToPx(30.0F));
      setLayoutParams(localMarginLayoutParams);
      return;
      this.mRootView.setBackground(null);
    }
  }
  
  private void setVisible(boolean paramBoolean)
  {
    if ((!paramBoolean) && (getVisibility() == 0)) {
      setVisibility(8);
    }
    if ((paramBoolean) && (getVisibility() == 8)) {
      setVisibility(0);
    }
  }
  
  public void P(Object paramObject) {}
  
  public void bkU()
  {
    if (this.wH != null) {
      this.wH.setVisibility(0);
    }
    if (this.mn != null) {
      this.mn.setVisibility(0);
    }
    setVisible(true);
  }
  
  public void bkV()
  {
    setVisible(false);
  }
  
  public void bkX()
  {
    setHintImageFilePath(oug.arz + "qcircle_feed_empty.png");
    qH(acfp.m(2131700083));
    if (this.wI != null) {
      this.wI.setVisibility(8);
    }
    bkW();
  }
  
  public void e(Context paramContext, View paramView)
  {
    this.mRootView = ((LinearLayout)paramView.findViewById(2131377472));
    this.mn = ((ImageView)paramView.findViewById(2131369736));
    this.mo = ((ImageView)paramView.findViewById(2131369802));
    this.wH = ((TextView)paramView.findViewById(2131380684));
    this.wI = ((TextView)paramView.findViewById(2131380604));
    setHintImageFilePath(oug.arz + "qcircle_feed_error.png");
  }
  
  public int getLayoutId()
  {
    return 2131560893;
  }
  
  public void qH(String paramString)
  {
    x(paramString, this.biP, this.biQ);
  }
  
  public void qI(String paramString)
  {
    setHintImageFilePath(oug.arz + "qcircle_feed_error.png");
    int i;
    if (!NetworkUtils.isNetworkAvailable(BaseApplication.getContext()))
    {
      i = 1;
      if (!TextUtils.isEmpty(paramString)) {
        break label93;
      }
      paramString = acfp.m(2131720624);
    }
    label93:
    for (;;)
    {
      if (i != 0) {
        paramString = acfp.m(2131696270);
      }
      for (;;)
      {
        qH(paramString);
        if (this.wI != null) {
          this.wI.setVisibility(8);
        }
        bkW();
        return;
        i = 0;
        break;
      }
    }
  }
  
  public void qJ(String paramString)
  {
    if (this.mo != null)
    {
      this.mo.setVisibility(0);
      if (paramString.equals(this.asL)) {}
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130852004);
      localURLDrawableOptions.mFailedDrawable = getResources().getDrawable(2130852004);
      this.mo.setImageDrawable(URLDrawable.getFileDrawable(paramString, localURLDrawableOptions));
      this.asL = paramString;
      setVisible(true);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void setHintImageFilePath(String paramString)
  {
    if (this.mn != null) {}
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      ColorDrawable localColorDrawable = new ColorDrawable(getResources().getColor(2131166508));
      localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
      localURLDrawableOptions.mFailedDrawable = localColorDrawable;
      this.mn.setImageDrawable(URLDrawable.getFileDrawable(paramString, localURLDrawableOptions));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setTextHint(String paramString, float paramFloat, int paramInt)
  {
    String str = paramString;
    if (paramString == null) {
      str = this.asM;
    }
    if (this.wH != null)
    {
      this.wH.setText(str);
      this.wH.setTextSize(paramFloat);
      this.wH.setTextColor(paramInt);
    }
  }
  
  public void showEmptyView(String paramString)
  {
    setHintImageFilePath(oug.arz + "qcircle_feed_empty.png");
    qH(paramString);
  }
  
  public void showErrorView(String paramString)
  {
    setHintImageFilePath(oug.arz + "qcircle_feed_error.png");
    int i;
    if (!NetworkUtils.isNetworkAvailable(BaseApplication.getContext()))
    {
      i = 1;
      if (!TextUtils.isEmpty(paramString)) {
        break label73;
      }
      paramString = acfp.m(2131720624);
    }
    label73:
    for (;;)
    {
      if (i != 0) {
        paramString = acfp.m(2131696270);
      }
      for (;;)
      {
        qH(paramString);
        return;
        i = 0;
        break;
      }
    }
  }
  
  public void x(String paramString, int paramInt1, int paramInt2)
  {
    setTextHint(paramString, paramInt1, paramInt2);
    bkU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleStatusView
 * JD-Core Version:    0.7.0.1
 */