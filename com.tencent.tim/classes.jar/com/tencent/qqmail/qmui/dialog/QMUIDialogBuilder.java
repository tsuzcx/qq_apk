package com.tencent.qqmail.qmui.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class QMUIDialogBuilder<T extends QMUIDialogBuilder>
{
  public LinearLayout mActionContainer;
  protected List<QMUIDialogAction> mActions = new ArrayList();
  public View mAnchorBottomView;
  protected View mAnchorTopView;
  protected Context mContext;
  public QMUIDialog mDialog;
  public int mDialogMarginVertical;
  protected LinearLayout mDialogWrapper;
  protected LayoutInflater mInflater;
  protected QMUIDialogAction mLeftAction;
  protected LinearLayout mRootView;
  protected String mTitle;
  public TextView mTitleView;
  
  public QMUIDialogBuilder(Context paramContext)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.mDialogMarginVertical = this.mContext.getResources().getDimensionPixelSize(2131298543);
  }
  
  protected T addAction(int paramInt1, int paramInt2, @QMUIDialogAction.Prop int paramInt3, @QMUIDialogAction.Type int paramInt4, QMUIDialogAction.ActionListener paramActionListener)
  {
    return addAction(paramInt1, this.mContext.getResources().getString(paramInt2), paramInt3, paramInt4, paramActionListener);
  }
  
  public T addAction(int paramInt1, int paramInt2, @QMUIDialogAction.Prop int paramInt3, QMUIDialogAction.ActionListener paramActionListener)
  {
    return addAction(paramInt1, this.mContext.getResources().getString(paramInt2), paramInt3, paramActionListener);
  }
  
  public T addAction(int paramInt1, int paramInt2, QMUIDialogAction.ActionListener paramActionListener)
  {
    return addAction(paramInt1, paramInt2, 1, paramActionListener);
  }
  
  public T addAction(int paramInt, QMUIDialogAction.ActionListener paramActionListener)
  {
    return addAction(0, paramInt, paramActionListener);
  }
  
  protected T addAction(int paramInt1, String paramString, @QMUIDialogAction.Prop int paramInt2, @QMUIDialogAction.Type int paramInt3, QMUIDialogAction.ActionListener paramActionListener)
  {
    paramString = new QMUIDialogAction(this.mContext, paramInt1, paramString, paramInt3, paramInt2, paramActionListener);
    this.mActions.add(paramString);
    return this;
  }
  
  public T addAction(int paramInt1, String paramString, @QMUIDialogAction.Prop int paramInt2, QMUIDialogAction.ActionListener paramActionListener)
  {
    return addAction(paramInt1, paramString, paramInt2, 0, paramActionListener);
  }
  
  public T addAction(int paramInt, String paramString, QMUIDialogAction.ActionListener paramActionListener)
  {
    return addAction(paramInt, paramString, 1, paramActionListener);
  }
  
  public T addAction(@Nullable QMUIDialogAction paramQMUIDialogAction)
  {
    if (paramQMUIDialogAction != null) {
      this.mActions.add(paramQMUIDialogAction);
    }
    return this;
  }
  
  public T addAction(String paramString, QMUIDialogAction.ActionListener paramActionListener)
  {
    return addAction(0, paramString, paramActionListener);
  }
  
  public QMUIDialog create()
  {
    this.mDialog = new QMUIDialog(this.mContext);
    this.mRootView = ((LinearLayout)this.mInflater.inflate(2131561147, null));
    this.mDialogWrapper = ((LinearLayout)this.mRootView.findViewById(2131365821));
    this.mAnchorTopView = this.mRootView.findViewById(2131362708);
    this.mAnchorBottomView = this.mRootView.findViewById(2131362706);
    onCreateTitle(this.mDialog, this.mDialogWrapper);
    onCreateContent(this.mDialog, this.mDialogWrapper);
    onCreateHandlerBar(this.mDialog, this.mDialogWrapper);
    this.mDialog.addContentView(this.mRootView, new ViewGroup.LayoutParams(-1, -2));
    onAfter(this.mDialog, this.mRootView);
    return this.mDialog;
  }
  
  public View getAnchorBottomView()
  {
    return this.mAnchorBottomView;
  }
  
  public View getAnchorTopView()
  {
    return this.mAnchorTopView;
  }
  
  public List<QMUIDialogAction> getPositiveAction()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mActions.iterator();
    while (localIterator.hasNext())
    {
      QMUIDialogAction localQMUIDialogAction = (QMUIDialogAction)localIterator.next();
      if (localQMUIDialogAction.getActionProp() == 0) {
        localArrayList.add(localQMUIDialogAction);
      }
    }
    return localArrayList;
  }
  
  public TextView getTitleView()
  {
    return this.mTitleView;
  }
  
  protected boolean hasTitle()
  {
    return (this.mTitle != null) && (this.mTitle.length() != 0);
  }
  
  protected void onAfter(QMUIDialog paramQMUIDialog, LinearLayout paramLinearLayout)
  {
    paramQMUIDialog = new QMUIDialogBuilder.1(this);
    this.mAnchorBottomView.setOnClickListener(paramQMUIDialog);
    this.mAnchorTopView.setOnClickListener(paramQMUIDialog);
  }
  
  protected abstract void onCreateContent(QMUIDialog paramQMUIDialog, ViewGroup paramViewGroup);
  
  protected void onCreateHandlerBar(QMUIDialog paramQMUIDialog, ViewGroup paramViewGroup)
  {
    int j = this.mActions.size();
    if ((j > 0) || (this.mLeftAction != null))
    {
      this.mActionContainer = new LinearLayout(this.mContext);
      this.mActionContainer.setOrientation(0);
      this.mActionContainer.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      this.mActionContainer.setPadding(this.mContext.getResources().getDimensionPixelSize(2131298527), 0, this.mContext.getResources().getDimensionPixelSize(2131298527), this.mContext.getResources().getDimensionPixelSize(2131298526));
      if (this.mLeftAction != null) {
        this.mActionContainer.addView(this.mLeftAction.generateActionView(this.mContext, this.mDialog, 0, false));
      }
      paramQMUIDialog = new View(this.mContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, 0);
      localLayoutParams.weight = 1.0F;
      paramQMUIDialog.setLayoutParams(localLayoutParams);
      this.mActionContainer.addView(paramQMUIDialog);
      int i = 0;
      while (i < j)
      {
        paramQMUIDialog = (QMUIDialogAction)this.mActions.get(i);
        this.mActionContainer.addView(paramQMUIDialog.generateActionView(this.mContext, this.mDialog, i, true));
        i += 1;
      }
      paramViewGroup.addView(this.mActionContainer);
    }
  }
  
  protected void onCreateTitle(QMUIDialog paramQMUIDialog, ViewGroup paramViewGroup)
  {
    if (hasTitle())
    {
      this.mTitleView = new TextView(this.mContext);
      this.mTitleView.setSingleLine(true);
      this.mTitleView.setEllipsize(TextUtils.TruncateAt.END);
      this.mTitleView.setText(this.mTitle);
      this.mTitleView.setTextColor(this.mContext.getResources().getColor(2131166572));
      this.mTitleView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(2131298547));
      this.mTitleView.setPadding(this.mContext.getResources().getDimensionPixelSize(2131298544), this.mContext.getResources().getDimensionPixelSize(2131298546), this.mContext.getResources().getDimensionPixelSize(2131298544), 0);
      paramQMUIDialog = new LinearLayout.LayoutParams(-1, -2);
      this.mTitleView.setLayoutParams(paramQMUIDialog);
      paramViewGroup.addView(this.mTitleView);
    }
  }
  
  public QMUIDialogAction setLeftAction(int paramInt1, String paramString, @QMUIDialogAction.Prop int paramInt2, QMUIDialogAction.ActionListener paramActionListener)
  {
    this.mLeftAction = new QMUIDialogAction(this.mContext, paramInt1, paramString, 0, paramInt2, paramActionListener);
    return this.mLeftAction;
  }
  
  public QMUIDialogAction setLeftAction(int paramInt, String paramString, QMUIDialogAction.ActionListener paramActionListener)
  {
    return setLeftAction(paramInt, paramString, 1, paramActionListener);
  }
  
  public QMUIDialogAction setLeftAction(String paramString, QMUIDialogAction.ActionListener paramActionListener)
  {
    return setLeftAction(0, paramString, paramActionListener);
  }
  
  public T setTitle(int paramInt)
  {
    return setTitle(this.mContext.getResources().getString(paramInt));
  }
  
  public T setTitle(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      this.mTitle = (paramString + this.mContext.getString(2131700545));
    }
    return this;
  }
  
  public QMUIDialog show()
  {
    QMUIDialog localQMUIDialog = create();
    localQMUIDialog.show();
    return localQMUIDialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.dialog.QMUIDialogBuilder
 * JD-Core Version:    0.7.0.1
 */