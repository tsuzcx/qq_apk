package com.tencent.qqmail.utilities.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmail.utilities.keyboardhelper.KeyBoardHelper;
import com.tencent.qqmail.view.QMTopBar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

public class QMEditDialog
  extends ReportDialog
{
  private final int mAnimationDuration = 200;
  private View mContentView;
  private boolean mIsAnimating = false;
  private Animation.AnimationListener mUpAnimationListener;
  
  public QMEditDialog(Context paramContext)
  {
    super(paramContext, 2131755266);
  }
  
  private void animateDown()
  {
    if (this.mContentView == null) {
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(200L);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new QMEditDialog.1(this));
    this.mContentView.startAnimation(localAnimationSet);
  }
  
  private void animateUp()
  {
    if (this.mContentView == null) {
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(200L);
    localAnimationSet.setFillAfter(true);
    if (this.mUpAnimationListener != null) {
      localAnimationSet.setAnimationListener(this.mUpAnimationListener);
    }
    this.mContentView.startAnimation(localAnimationSet);
  }
  
  public void dismiss()
  {
    if (this.mIsAnimating) {
      return;
    }
    KeyBoardHelper.hideKeyBoard(this.mContentView);
    animateDown();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().getDecorView().setPadding(0, 0, 0, 0);
    paramBundle = getWindow().getAttributes();
    paramBundle.height = -2;
    paramBundle.gravity = 81;
    if (QMUIKit.getScreenWidth() < QMUIKit.getScreenHeight()) {}
    for (int i = QMUIKit.getScreenWidth();; i = QMUIKit.getScreenHeight())
    {
      paramBundle.width = i;
      getWindow().setAttributes(paramBundle);
      setCanceledOnTouchOutside(false);
      return;
    }
  }
  
  public void setContentView(int paramInt)
  {
    this.mContentView = LayoutInflater.from(getContext()).inflate(paramInt, null);
    super.setContentView(this.mContentView);
  }
  
  public void setContentView(View paramView)
  {
    this.mContentView = paramView;
    super.setContentView(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.mContentView = paramView;
    super.setContentView(paramView, paramLayoutParams);
  }
  
  public void setUpAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    this.mUpAnimationListener = paramAnimationListener;
  }
  
  public void show()
  {
    super.show();
    animateUp();
  }
  
  public static class EditBuilder
  {
    private int mAnchorHeight = 0;
    private View mAnchorView;
    protected Context mContext;
    private Map<String, String> mData = new HashMap();
    private QMEditDialog mDialog;
    private LinearLayout mDialogLayout;
    private Map<String, String> mHint = new HashMap();
    protected LayoutInflater mInflater;
    private Map<String, Integer> mMaxLength = new HashMap();
    private LinearLayout mRootView;
    private int mScreenHeight = 0;
    private int mScrollHeight = 0;
    private ScrollView mScrollerView;
    private QMTopBar mTopBar;
    private String mTopBarLeftBtnName;
    private DialogInterface.OnClickListener mTopBarLeftListener;
    private String mTopBarRightBtnName;
    private DialogInterface.OnClickListener mTopBarRightListener;
    private int rRight;
    
    public EditBuilder(Context paramContext)
    {
      this.mContext = paramContext;
      this.mInflater = LayoutInflater.from(this.mContext);
    }
    
    private void bindEvent()
    {
      this.mAnchorView.setOnClickListener(new QMEditDialog.EditBuilder.4(this));
      this.mRootView.getViewTreeObserver().addOnGlobalLayoutListener(new QMEditDialog.EditBuilder.5(this));
    }
    
    private View buildContent()
    {
      LinearLayout localLinearLayout = new LinearLayout(this.mContext);
      localLinearLayout.setOrientation(1);
      Iterator localIterator = this.mData.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(2131297190));
        localLinearLayout.addView(buildInputItem(str, (String)this.mData.get(str), (String)this.mHint.get(str), (Integer)this.mMaxLength.get(str)), localLayoutParams);
      }
      return localLinearLayout;
    }
    
    private LinearLayout buildInputItem(String paramString1, String paramString2, String paramString3, Integer paramInteger)
    {
      LinearLayout localLinearLayout = new LinearLayout(this.mContext);
      localLinearLayout.setGravity(16);
      localLinearLayout.setOrientation(0);
      localLinearLayout.setBackgroundResource(2130841308);
      localLinearLayout.setPadding(this.mContext.getResources().getDimensionPixelSize(2131297191), 0, this.mContext.getResources().getDimensionPixelSize(2131297191), 0);
      Object localObject = new TextView(this.mContext);
      ((TextView)localObject).setText(paramString1 + ": ");
      ((TextView)localObject).setTextColor(this.mContext.getResources().getColor(2131165776));
      ((TextView)localObject).setTextSize(0, this.mContext.getResources().getDimensionPixelSize(2131297192));
      ((TextView)localObject).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      localLinearLayout.addView((View)localObject);
      localObject = new EditText(this.mContext);
      ((EditText)localObject).setText(paramString2);
      if (paramString3 != null) {
        ((EditText)localObject).setHint(paramString3);
      }
      if ((paramInteger != null) && (paramInteger.intValue() > 0)) {
        ((EditText)localObject).setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInteger.intValue()) });
      }
      ((EditText)localObject).setSelection(paramString2.length());
      ((EditText)localObject).setTextSize(0, this.mContext.getResources().getDimensionPixelSize(2131297192));
      ((EditText)localObject).setTextColor(this.mContext.getResources().getColor(2131165381));
      ((EditText)localObject).setBackgroundResource(0);
      ((EditText)localObject).setTag(paramString1);
      paramString2 = new LinearLayout.LayoutParams(0, -2);
      paramString2.gravity = 16;
      paramString2.weight = 1.0F;
      ((EditText)localObject).setGravity(16);
      ((EditText)localObject).setPadding(0, 0, 0, 0);
      ((EditText)localObject).setLayoutParams(paramString2);
      ((EditText)localObject).addTextChangedListener(new QMEditDialog.EditBuilder.1(this, paramString1));
      localLinearLayout.addView((View)localObject);
      return localLinearLayout;
    }
    
    public EditBuilder addItem(String paramString)
    {
      return addItem(paramString, "", null, null);
    }
    
    public EditBuilder addItem(String paramString1, String paramString2, String paramString3, Integer paramInteger)
    {
      this.mData.put(paramString1, paramString2);
      this.mHint.put(paramString1, paramString3);
      this.mMaxLength.put(paramString1, paramInteger);
      return this;
    }
    
    public QMEditDialog build()
    {
      this.mDialog = new QMEditDialog(this.mContext);
      this.mRootView = ((LinearLayout)this.mInflater.inflate(2131559275, null));
      this.mDialogLayout = ((LinearLayout)this.mRootView.findViewById(2131365821));
      this.mAnchorView = this.mRootView.findViewById(2131362705);
      this.mTopBar = ((QMTopBar)this.mDialogLayout.findViewById(2131380043));
      if (StringUtils.isNotEmpty(this.mTopBarLeftBtnName))
      {
        this.mTopBar.setButtonLeftNormal(this.mTopBarLeftBtnName);
        if (this.mTopBarLeftListener != null) {
          this.mTopBar.getButtonLeft().setOnClickListener(new QMEditDialog.EditBuilder.2(this));
        }
      }
      if (StringUtils.isNotEmpty(this.mTopBarRightBtnName))
      {
        this.mTopBar.setButtonRightBlue(this.mTopBarRightBtnName);
        if (this.mTopBarRightListener != null) {
          this.mTopBar.getButtonRight().setOnClickListener(new QMEditDialog.EditBuilder.3(this));
        }
      }
      this.mScrollerView = new ScrollView(this.mContext);
      this.mScrollerView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      this.mScrollerView.addView(buildContent(), new FrameLayout.LayoutParams(-1, -2));
      this.mDialogLayout.addView(this.mScrollerView);
      bindEvent();
      this.mDialog.setContentView(this.mRootView, new ViewGroup.LayoutParams(-1, -2));
      return this.mDialog;
    }
    
    public Map<String, String> getData()
    {
      return this.mData;
    }
    
    public EditBuilder setTopbarLeftListener(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
    {
      return setTopbarLeftListener(this.mContext.getResources().getString(paramInt), paramOnClickListener);
    }
    
    public EditBuilder setTopbarLeftListener(String paramString, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.mTopBarLeftBtnName = paramString;
      this.mTopBarLeftListener = paramOnClickListener;
      return this;
    }
    
    public EditBuilder setTopbarRightListener(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
    {
      return setTopbarRightListener(this.mContext.getResources().getString(paramInt), paramOnClickListener);
    }
    
    public EditBuilder setTopbarRightListener(String paramString, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.mTopBarRightBtnName = paramString;
      this.mTopBarRightListener = paramOnClickListener;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMEditDialog
 * JD-Core Version:    0.7.0.1
 */