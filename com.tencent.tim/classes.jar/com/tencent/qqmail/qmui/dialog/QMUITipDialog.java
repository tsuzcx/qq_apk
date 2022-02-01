package com.tencent.qqmail.qmui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.core.content.ContextCompat;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmail.utilities.ui.QMLoading;
import com.tencent.qqmail.utilities.ui.QMUIKit;

public class QMUITipDialog
  extends ReportDialog
{
  public QMUITipDialog(Context paramContext)
  {
    this(paramContext, 2131755491);
  }
  
  public QMUITipDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    setCanceledOnTouchOutside(false);
    setCancelable(false);
  }
  
  private void initDialogWidth()
  {
    Window localWindow = getWindow();
    if (localWindow != null)
    {
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.width = -1;
      localWindow.setAttributes(localLayoutParams);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initDialogWidth();
  }
  
  public static class Builder
  {
    private static final int SHOW_FAILED_ICON = 3;
    private static final int SHOW_INFO_ICON = 4;
    private static final int SHOW_LOADING = 1;
    private static final int SHOW_NOTHING = 0;
    private static final int SHOW_SUCCESS_ICON = 2;
    private Context mContext;
    private int mCurrentShowIcon = 0;
    private CharSequence mTipWord;
    
    public Builder(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public QMUITipDialog create()
    {
      QMUITipDialog localQMUITipDialog = new QMUITipDialog(this.mContext);
      localQMUITipDialog.setContentView(2131561149);
      ViewGroup localViewGroup = (ViewGroup)localQMUITipDialog.findViewById(2131365372);
      switch (this.mCurrentShowIcon)
      {
      default: 
      case 1: 
        for (;;)
        {
          if ((this.mTipWord != null) && (this.mTipWord.length() > 0))
          {
            localObject = new TextView(this.mContext);
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
            if (this.mCurrentShowIcon != 0) {
              localLayoutParams.setMargins(0, QMUIKit.dpToPx(12), 0, 0);
            }
            ((TextView)localObject).setLayoutParams(localLayoutParams);
            ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
            ((TextView)localObject).setGravity(17);
            ((TextView)localObject).setMaxLines(2);
            ((TextView)localObject).setTextColor(ContextCompat.getColor(this.mContext, 2131166586));
            ((TextView)localObject).setTextSize(2, 14.0F);
            ((TextView)localObject).setText(this.mTipWord);
            localViewGroup.addView((View)localObject);
          }
          return localQMUITipDialog;
          localObject = new QMLoading(this.mContext, QMLoading.SIZE_MINI, 1);
          ((QMLoading)localObject).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
          localViewGroup.addView((View)localObject);
        }
      }
      Object localObject = new ImageView(this.mContext);
      ((ImageView)localObject).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      if (this.mCurrentShowIcon == 2) {
        ((ImageView)localObject).setImageDrawable(this.mContext.getResources().getDrawable(2130841015));
      }
      for (;;)
      {
        localViewGroup.addView((View)localObject);
        break;
        if (this.mCurrentShowIcon == 3) {
          ((ImageView)localObject).setImageDrawable(this.mContext.getResources().getDrawable(2130841016));
        } else {
          ((ImageView)localObject).setImageDrawable(this.mContext.getResources().getDrawable(2130841017));
        }
      }
    }
    
    public Builder setTipWord(CharSequence paramCharSequence)
    {
      this.mTipWord = paramCharSequence;
      return this;
    }
    
    public Builder showFailedIcon()
    {
      this.mCurrentShowIcon = 3;
      return this;
    }
    
    public Builder showInfoIcon()
    {
      this.mCurrentShowIcon = 4;
      return this;
    }
    
    public Builder showLoadingView()
    {
      this.mCurrentShowIcon = 1;
      return this;
    }
    
    public Builder showSucceedIcon()
    {
      this.mCurrentShowIcon = 2;
      return this;
    }
  }
  
  public static class CustomBuilder
  {
    private int mContentLayoutId;
    private Context mContext;
    
    public CustomBuilder(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public QMUITipDialog create()
    {
      QMUITipDialog localQMUITipDialog = new QMUITipDialog(this.mContext);
      localQMUITipDialog.setContentView(2131561149);
      ViewGroup localViewGroup = (ViewGroup)localQMUITipDialog.findViewById(2131365372);
      LayoutInflater.from(this.mContext).inflate(this.mContentLayoutId, localViewGroup, true);
      return localQMUITipDialog;
    }
    
    public CustomBuilder setContent(@LayoutRes int paramInt)
    {
      this.mContentLayoutId = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.dialog.QMUITipDialog
 * JD-Core Version:    0.7.0.1
 */