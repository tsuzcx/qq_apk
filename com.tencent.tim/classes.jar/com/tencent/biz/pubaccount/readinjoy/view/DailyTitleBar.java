package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import atau.a;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.MalformedURLException;
import java.net.URL;
import kwz;

public class DailyTitleBar
  extends FrameLayout
{
  private final KandianUrlImageView V;
  private final View mj;
  private final View mk;
  private final View ml;
  private final TextView titleView;
  
  public DailyTitleBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
    this.mj = findViewById(2131370961);
    this.mk = findViewById(2131370969);
    this.titleView = ((TextView)findViewById(2131380987));
    this.V = ((KandianUrlImageView)findViewById(2131369929));
    this.ml = findViewById(2131379878);
  }
  
  private void cg(Context paramContext)
  {
    setPadding(getPaddingLeft(), getPaddingTop() + ImmersiveUtils.getStatusBarHeight(paramContext), getPaddingRight(), getPaddingBottom());
  }
  
  private void ch(Context paramContext)
  {
    KandianUrlImageView localKandianUrlImageView = (KandianUrlImageView)findViewById(2131369929);
    Object localObject;
    if (localKandianUrlImageView != null)
    {
      localObject = Aladdin.getConfig(226);
      if (localObject != null)
      {
        int i = ((AladdinConfig)localObject).getIntegerFromString("daily_title_url_switch", 0);
        localObject = ((AladdinConfig)localObject).getString("daily_title_url", "");
        QLog.i("DailyTitleBar", 1, "[initTitleBarImage], urlSwitch = " + i + ", url = " + (String)localObject);
        if ((i != 1) || (TextUtils.isEmpty((CharSequence)localObject))) {}
      }
    }
    try
    {
      kwz.a(localKandianUrlImageView, new URL((String)localObject), paramContext);
      return;
    }
    catch (MalformedURLException paramContext)
    {
      QLog.e("DailyTitleBar", 1, "[initTitleBarImage], e = " + paramContext);
    }
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    View.inflate(paramContext, 2131560346, this);
    paramAttributeSet = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, atau.a.qc, 0, 0);
    for (;;)
    {
      int i;
      try
      {
        String str = paramAttributeSet.getString(3);
        i = paramAttributeSet.getColor(4, -16777216);
        int j = paramAttributeSet.getResourceId(0, 2131167654);
        k = paramAttributeSet.getResourceId(2, 2130843809);
        m = paramAttributeSet.getResourceId(1, 2130844014);
        setBackgroundResource(j);
        localTextView = (TextView)findViewById(2131380987);
        localTextView.setText(str);
        localTextView.setTextColor(i);
        if ((i != -1) && (i != 16777215)) {
          break label175;
        }
        findViewById(2131369929).setVisibility(8);
      }
      finally
      {
        int k;
        int m;
        TextView localTextView;
        paramAttributeSet.recycle();
      }
      localTextView.setVisibility(8);
      findViewById(2131369671).setBackgroundResource(k);
      findViewById(2131369892).setBackgroundResource(m);
      paramAttributeSet.recycle();
      setClickable(true);
      cg(paramContext);
      ch(paramContext);
      return;
      label175:
      if (i != -16777216) {
        if (i != 0) {}
      }
    }
  }
  
  public void setOnLeftButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    if ((this.mj != null) && (paramOnClickListener != null)) {
      this.mj.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setOnRightButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    if ((this.mk != null) && (paramOnClickListener != null)) {
      this.mk.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setOnTitleClickListener(View.OnClickListener paramOnClickListener)
  {
    if ((this.titleView != null) && (paramOnClickListener != null)) {
      this.titleView.setOnClickListener(paramOnClickListener);
    }
    if ((this.V != null) && (paramOnClickListener != null)) {
      this.V.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setTitleText(String paramString)
  {
    if (this.titleView != null) {
      this.titleView.setText(paramString);
    }
  }
  
  public void setTitleTextSize(float paramFloat)
  {
    if (this.titleView != null) {
      this.titleView.setTextSize(2, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.DailyTitleBar
 * JD-Core Version:    0.7.0.1
 */