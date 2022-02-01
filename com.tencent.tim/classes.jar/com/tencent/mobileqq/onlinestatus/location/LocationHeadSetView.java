package com.tencent.mobileqq.onlinestatus.location;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import auvj;
import ayxa;

public class LocationHeadSetView
  extends LinearLayout
{
  private final Context context;
  private View lj;
  private TextView mTitleTextView;
  private View rootView;
  private TextView xt;
  
  public LocationHeadSetView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    initViews();
    due();
    dud();
  }
  
  private void dud()
  {
    this.lj = $(2131377546);
    if (auvj.isNightMode())
    {
      this.lj.setBackgroundColor(Color.parseColor("#CC000000"));
      return;
    }
    this.lj.setBackgroundColor(Color.parseColor("#7F000000"));
  }
  
  private void due()
  {
    if ((this.context instanceof Activity))
    {
      ayxa.initLiuHaiProperty((Activity)this.context);
      if (ayxa.sHasNotch)
      {
        View localView = $(2131372480);
        ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
        localLayoutParams.height = ayxa.sNotchHeight;
        localView.setLayoutParams(localLayoutParams);
        localView.setVisibility(0);
      }
    }
  }
  
  private void initViews()
  {
    this.rootView = inflate(getContext(), 2131559470, this);
    this.xt = ((TextView)$(2131369579));
    this.mTitleTextView = ((TextView)$(2131379562));
  }
  
  protected final <T extends View> T $(int paramInt)
  {
    return this.rootView.findViewById(paramInt);
  }
  
  public void setHeadSetClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.xt != null) {
      this.xt.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setImmersiveHeight(int paramInt)
  {
    this.lj.setPadding(0, paramInt, 0, 0);
  }
  
  public void setTitleText(String paramString)
  {
    this.mTitleTextView.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.location.LocationHeadSetView
 * JD-Core Version:    0.7.0.1
 */