package com.tencent.qqmail.qmui.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import java.lang.annotation.Annotation;

public class QMUIDialogAction
{
  public static final int ACTION_PROP_NEGATIVE = 2;
  public static final int ACTION_PROP_NEUTRAL = 1;
  public static final int ACTION_PROP_POSITIVE = 0;
  public static final int ACTION_TYPE_BLOCK = 1;
  public static final int ACTION_TYPE_NORMAL = 0;
  private int mActionProp;
  private int mActionType;
  private Button mButton;
  private Context mContext;
  private int mIconRes;
  private ActionListener mOnClickListener;
  private String mStr;
  
  public QMUIDialogAction(Context paramContext, int paramInt1, int paramInt2, @Type int paramInt3, @Prop int paramInt4, ActionListener paramActionListener)
  {
    this.mContext = paramContext;
    this.mIconRes = paramInt1;
    this.mStr = this.mContext.getResources().getString(paramInt2);
    this.mActionType = paramInt3;
    this.mActionProp = paramInt4;
    this.mOnClickListener = paramActionListener;
  }
  
  public QMUIDialogAction(Context paramContext, int paramInt1, int paramInt2, @Type int paramInt3, ActionListener paramActionListener)
  {
    this(paramContext, paramInt1, paramInt2, paramInt3, 1, paramActionListener);
  }
  
  public QMUIDialogAction(Context paramContext, int paramInt1, int paramInt2, ActionListener paramActionListener)
  {
    this(paramContext, paramInt1, paramInt2, 0, paramActionListener);
  }
  
  public QMUIDialogAction(Context paramContext, int paramInt, ActionListener paramActionListener)
  {
    this(paramContext, 0, paramInt, 0, paramActionListener);
  }
  
  public QMUIDialogAction(Context paramContext, int paramInt1, String paramString, @Type int paramInt2, @Prop int paramInt3, ActionListener paramActionListener)
  {
    this.mContext = paramContext;
    this.mIconRes = paramInt1;
    this.mStr = paramString;
    this.mActionType = paramInt2;
    this.mActionProp = paramInt3;
    this.mOnClickListener = paramActionListener;
  }
  
  public QMUIDialogAction(Context paramContext, int paramInt1, String paramString, @Type int paramInt2, ActionListener paramActionListener)
  {
    this(paramContext, paramInt1, paramString, paramInt2, 1, paramActionListener);
  }
  
  public QMUIDialogAction(Context paramContext, int paramInt, String paramString, ActionListener paramActionListener)
  {
    this(paramContext, paramInt, paramString, 0, paramActionListener);
  }
  
  public QMUIDialogAction(Context paramContext, String paramString, ActionListener paramActionListener)
  {
    this(paramContext, 0, paramString, 0, paramActionListener);
  }
  
  public static Button generateSpanActionButton(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    Button localButton = new Button(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, paramContext.getResources().getDimensionPixelSize(2131298521));
    if (paramBoolean) {
      localLayoutParams.leftMargin = paramContext.getResources().getDimensionPixelSize(2131298522);
    }
    localButton.setLayoutParams(localLayoutParams);
    localButton.setMinHeight(paramContext.getResources().getDimensionPixelSize(2131298521));
    localButton.setMinWidth(paramContext.getResources().getDimensionPixelSize(2131298523));
    localButton.setMinimumWidth(paramContext.getResources().getDimensionPixelSize(2131298523));
    localButton.setMinimumHeight(paramContext.getResources().getDimensionPixelSize(2131298521));
    localButton.setText(paramString);
    if (paramInt != 0)
    {
      paramString = paramContext.getResources().getDrawable(paramInt);
      if (paramString != null)
      {
        paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
        localButton.setCompoundDrawables(paramString, null, null, null);
        localButton.setCompoundDrawablePadding(paramContext.getResources().getDimensionPixelSize(2131298528));
      }
    }
    localButton.setGravity(17);
    localButton.setPadding(paramContext.getResources().getDimensionPixelSize(2131298524), 0, paramContext.getResources().getDimensionPixelSize(2131298524), 0);
    localButton.setClickable(true);
    localButton.setTextSize(0, paramContext.getResources().getDimensionPixelSize(2131298525));
    localButton.setTextColor(paramContext.getResources().getColorStateList(2131166589));
    localButton.setBackgroundResource(2130845586);
    return localButton;
  }
  
  public View generateActionView(Context paramContext, QMUIDialog paramQMUIDialog, int paramInt, boolean paramBoolean)
  {
    this.mButton = null;
    if (this.mActionType == 1)
    {
      paramContext = new BlockActionView(paramContext, this.mStr, this.mIconRes);
      this.mButton = paramContext.getButton();
      if (this.mOnClickListener != null) {
        paramContext.setOnClickListener(new QMUIDialogAction.1(this, paramQMUIDialog, paramInt));
      }
      return paramContext;
    }
    this.mButton = generateSpanActionButton(paramContext, this.mStr, this.mIconRes, paramBoolean);
    if (this.mActionProp == 2) {
      this.mButton.setTextColor(paramContext.getResources().getColorStateList(2131166590));
    }
    for (;;)
    {
      this.mButton.setOnClickListener(new QMUIDialogAction.2(this, paramQMUIDialog, paramInt));
      return this.mButton;
      this.mButton.setTextColor(paramContext.getResources().getColorStateList(2131166589));
    }
  }
  
  public int getActionProp()
  {
    return this.mActionProp;
  }
  
  public Button getButton()
  {
    return this.mButton;
  }
  
  public void setOnClickListener(ActionListener paramActionListener)
  {
    this.mOnClickListener = paramActionListener;
  }
  
  public static abstract interface ActionListener
  {
    public abstract void onClick(QMUIDialog paramQMUIDialog, int paramInt);
  }
  
  public static class BlockActionView
    extends FrameLayout
  {
    private Button mButton;
    
    public BlockActionView(Context paramContext, String paramString, int paramInt)
    {
      super();
      init(paramString, paramInt);
    }
    
    private void init(String paramString, int paramInt)
    {
      setLayoutParams(new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(2131298520)));
      setBackgroundResource(2130845611);
      setPadding(getContext().getResources().getDimensionPixelSize(2131298544), 0, getContext().getResources().getDimensionPixelSize(2131298544), 0);
      this.mButton = new Button(getContext());
      this.mButton.setBackgroundResource(0);
      this.mButton.setPadding(0, 0, 0, 0);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -1);
      localLayoutParams.gravity = 5;
      this.mButton.setLayoutParams(localLayoutParams);
      this.mButton.setGravity(21);
      this.mButton.setText(paramString);
      if (paramInt != 0)
      {
        paramString = getContext().getResources().getDrawable(paramInt);
        if (paramString != null)
        {
          paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
          this.mButton.setCompoundDrawables(paramString, null, null, null);
          this.mButton.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(2131298528));
        }
      }
      this.mButton.setMinHeight(0);
      this.mButton.setMinWidth(0);
      this.mButton.setMinimumWidth(0);
      this.mButton.setMinimumHeight(0);
      this.mButton.setClickable(false);
      this.mButton.setDuplicateParentStateEnabled(true);
      this.mButton.setTextSize(0, getContext().getResources().getDimensionPixelSize(2131298525));
      this.mButton.setTextColor(getContext().getResources().getColorStateList(2131166589));
      addView(this.mButton);
    }
    
    public Button getButton()
    {
      return this.mButton;
    }
  }
  
  public static @interface Prop {}
  
  public static @interface Type {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.dialog.QMUIDialogAction
 * JD-Core Version:    0.7.0.1
 */