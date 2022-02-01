package com.tencent.biz.subscribe.widget;

import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.BaseApplication;
import rze;

public class StatusView
  extends BaseWidgetView
{
  private String asL;
  private String asM = getResources().getString(2131703530);
  private int biP = 18;
  private int biQ = -16777216;
  private LinearLayout fm;
  private View mRoot;
  private ImageView mn;
  private ImageView mo;
  private TextView wH;
  private TextView zQ;
  private TextView zR;
  private TextView zS;
  
  public StatusView(Context paramContext)
  {
    super(paramContext);
  }
  
  public StatusView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
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
  
  public TextView E()
  {
    return this.wH;
  }
  
  public void P(Object paramObject) {}
  
  public void bkU()
  {
    if ((this.wH != null) && (this.wH.getVisibility() == 8)) {
      this.wH.setVisibility(0);
    }
    if ((this.mn != null) && (this.mn.getVisibility() == 8)) {
      this.mn.setVisibility(0);
    }
    setVisible(true);
  }
  
  public void bkV()
  {
    setVisible(false);
  }
  
  public void byP()
  {
    setHintImageFilePath(rze.no() + "/certified_account_feed_error.png");
    if (!NetworkUtils.isNetworkAvailable(BaseApplication.getContext()))
    {
      i = 1;
      if (i == 0) {
        break label57;
      }
    }
    label57:
    for (int i = 2131696270;; i = 2131720624)
    {
      qH(acfp.m(i));
      return;
      i = 0;
      break;
    }
  }
  
  public void d(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    setHintImageFilePath(rze.no() + "/certified_account_feeds_empty.png");
    x(acfp.m(2131720645), 13, getResources().getColor(2131167482));
    if (this.fm != null)
    {
      this.fm.setVisibility(0);
      this.zR.setOnClickListener(paramOnClickListener1);
      this.zS.setOnClickListener(paramOnClickListener2);
    }
  }
  
  public void e(Context paramContext, View paramView)
  {
    this.mRoot = paramView.findViewById(2131377472);
    this.mn = ((ImageView)paramView.findViewById(2131369736));
    this.mo = ((ImageView)paramView.findViewById(2131369802));
    this.wH = ((TextView)paramView.findViewById(2131380684));
    this.zQ = ((TextView)paramView.findViewById(2131380836));
    this.zR = ((TextView)paramView.findViewById(2131380956));
    this.zS = ((TextView)paramView.findViewById(2131380856));
    this.fm = ((LinearLayout)paramView.findViewById(2131370714));
    setHintImageFilePath(rze.no() + "/certified_account_feed_error.png");
    setBackgroundColor(-1);
  }
  
  public int getLayoutId()
  {
    return 2131558839;
  }
  
  public void hideLoadingView()
  {
    this.mo.setVisibility(8);
    setVisible(false);
  }
  
  public ImageView n()
  {
    return this.mo;
  }
  
  public ImageView o()
  {
    return this.mn;
  }
  
  public void qH(String paramString)
  {
    x(paramString, this.biP, this.biQ);
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
  
  public void r(View.OnClickListener paramOnClickListener)
  {
    setHintImageFilePath(rze.no() + "/certified_account_feeds_empty.png");
    x(acfp.m(2131720642), 13, getResources().getColor(2131167482));
    if (this.zQ != null)
    {
      this.zQ.setVisibility(0);
      this.zQ.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setHintImageFilePath(String paramString)
  {
    if (this.mn != null) {}
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130852004);
      localURLDrawableOptions.mFailedDrawable = getResources().getDrawable(2130852004);
      this.mn.setImageDrawable(URLDrawable.getFileDrawable(paramString, localURLDrawableOptions));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setTextHint(String paramString)
  {
    setTextHint(paramString, this.biP, this.biQ);
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
  
  public void x(String paramString, int paramInt1, int paramInt2)
  {
    setTextHint(paramString, paramInt1, paramInt2);
    bkU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.StatusView
 * JD-Core Version:    0.7.0.1
 */