package com.tencent.qqmail.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmail.utilities.ui.QMLoading;
import com.tencent.qqmail.utilities.ui.QMUIKit;

public class QMContentLoadingView
  extends RelativeLayout
{
  private int ID_BUTTOM = 1;
  private QMLoading mLoadingView;
  private Button mReloadButton;
  private TextView mTipsTextView;
  
  public QMContentLoadingView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QMContentLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QMContentLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private QMContentLoadingView setTips(String paramString)
  {
    if (this.mTipsTextView != null) {
      if (paramString != null)
      {
        this.mTipsTextView.setVisibility(0);
        this.mTipsTextView.setText(paramString);
      }
    }
    while (paramString == null)
    {
      return this;
      this.mTipsTextView.setVisibility(8);
      return this;
    }
    this.mTipsTextView = new TextView(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    if (this.mReloadButton == null)
    {
      showButton(true);
      showButton(false);
    }
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(2, this.ID_BUTTOM);
    localLayoutParams.bottomMargin = QMUIKit.dpToPx(10);
    this.mTipsTextView.setGravity(17);
    this.mTipsTextView.setTextSize(2, 18.0F);
    this.mTipsTextView.setTextColor(getResources().getColor(2131165860));
    this.mTipsTextView.setText(paramString);
    addView(this.mTipsTextView, localLayoutParams);
    return this;
  }
  
  private QMContentLoadingView showButton(boolean paramBoolean)
  {
    if (this.mReloadButton != null) {
      if (paramBoolean) {
        this.mReloadButton.setVisibility(0);
      }
    }
    while (!paramBoolean)
    {
      return this;
      this.mReloadButton.setVisibility(4);
      return this;
    }
    this.mReloadButton = QMUIKit.getButton(getContext());
    this.mReloadButton.setId(this.ID_BUTTOM);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    this.mReloadButton.setMinWidth(QMUIKit.dpToPx(120));
    this.mReloadButton.setTextSize(2, 16.0F);
    this.mReloadButton.setTextColor(-16777216);
    this.mReloadButton.setBackgroundResource(2130850477);
    this.mReloadButton.setText(2131718735);
    addView(this.mReloadButton, localLayoutParams);
    return this;
  }
  
  public void clearEvents()
  {
    if (this.mReloadButton != null) {
      this.mReloadButton.setOnClickListener(null);
    }
  }
  
  public void destroy()
  {
    clearEvents();
    this.mReloadButton = null;
    this.mTipsTextView = null;
    this.mLoadingView = null;
    this.mReloadButton = null;
  }
  
  public QMContentLoadingView hide()
  {
    setVisibility(8);
    if (this.mLoadingView != null) {
      this.mLoadingView.stop();
    }
    return this;
  }
  
  public void initStyle()
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    setLayoutParams(localLayoutParams);
    setBackgroundColor(getResources().getColor(2131167681));
  }
  
  public boolean isLoading()
  {
    if ((this.mLoadingView != null) && (this.mLoadingView.getVisibility() == 0)) {
      return this.mLoadingView.isRunning();
    }
    return false;
  }
  
  public QMContentLoadingView setTextView(TextView paramTextView)
  {
    this.mTipsTextView = paramTextView;
    if (this.mTipsTextView != null)
    {
      paramTextView = new RelativeLayout.LayoutParams(-2, -2);
      if (this.mReloadButton == null)
      {
        showButton(true);
        showButton(false);
      }
      paramTextView.addRule(14);
      paramTextView.addRule(2, this.ID_BUTTOM);
      paramTextView.bottomMargin = QMUIKit.dpToPx(10);
      this.mTipsTextView.setGravity(17);
      this.mTipsTextView.setTextSize(2, 18.0F);
      addView(this.mTipsTextView, paramTextView);
    }
    showLoading(false);
    showButton(false);
    setVisibility(0);
    return this;
  }
  
  public QMContentLoadingView showLoading(boolean paramBoolean)
  {
    if (this.mLoadingView != null) {
      if (paramBoolean)
      {
        this.mLoadingView.setVisibility(0);
        this.mLoadingView.start();
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        showButton(false);
        setTips(null);
        setVisibility(0);
      }
      return this;
      this.mLoadingView.setVisibility(8);
      this.mLoadingView.stop();
      continue;
      if (paramBoolean)
      {
        this.mLoadingView = new QMLoading(getContext());
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(13);
        addView(this.mLoadingView, localLayoutParams);
      }
    }
  }
  
  public QMContentLoadingView showTips(int paramInt)
  {
    return showTips(getResources().getString(paramInt));
  }
  
  public QMContentLoadingView showTips(int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    return showTips(getResources().getString(paramInt1), getResources().getString(paramInt2), paramOnClickListener);
  }
  
  public QMContentLoadingView showTips(String paramString)
  {
    setTips(paramString);
    showLoading(false);
    showButton(false);
    setVisibility(0);
    return this;
  }
  
  public QMContentLoadingView showTips(String paramString1, String paramString2, View.OnClickListener paramOnClickListener)
  {
    setTips(paramString1);
    showLoading(false);
    showButton(true);
    this.mReloadButton.setText(paramString2);
    this.mReloadButton.setOnClickListener(paramOnClickListener);
    setVisibility(0);
    return this;
  }
  
  public QMContentLoadingView showTipsReload(int paramInt, View.OnClickListener paramOnClickListener)
  {
    return showTipsReload(getResources().getString(paramInt), paramOnClickListener);
  }
  
  public QMContentLoadingView showTipsReload(String paramString, View.OnClickListener paramOnClickListener)
  {
    setTips(paramString);
    showLoading(false);
    showButton(true);
    this.mReloadButton.setOnClickListener(paramOnClickListener);
    setVisibility(0);
    return this;
  }
  
  public QMContentLoadingView showTipsVerify(int paramInt, View.OnClickListener paramOnClickListener)
  {
    return showTipsVerify(getResources().getString(paramInt), paramOnClickListener);
  }
  
  public QMContentLoadingView showTipsVerify(String paramString, View.OnClickListener paramOnClickListener)
  {
    setTips(paramString);
    showLoading(false);
    showButton(true);
    this.mReloadButton.setText(getResources().getString(2131721564));
    this.mReloadButton.setOnClickListener(paramOnClickListener);
    setVisibility(0);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMContentLoadingView
 * JD-Core Version:    0.7.0.1
 */