package com.tencent.qqmail.qmui.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import java.util.List;

public class QMUIDialogBlockBuilder
  extends QMUIDialogBuilder<QMUIDialogBlockBuilder>
{
  private CharSequence mContent;
  private Context mContext;
  
  public QMUIDialogBlockBuilder(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public QMUIDialogBlockBuilder addAction(int paramInt1, int paramInt2, @QMUIDialogAction.Prop int paramInt3, QMUIDialogAction.ActionListener paramActionListener)
  {
    return (QMUIDialogBlockBuilder)addAction(paramInt1, this.mContext.getResources().getString(paramInt2), paramInt3, 1, paramActionListener);
  }
  
  public QMUIDialogBlockBuilder addAction(int paramInt1, int paramInt2, QMUIDialogAction.ActionListener paramActionListener)
  {
    return addAction(paramInt1, paramInt2, 1, paramActionListener);
  }
  
  public QMUIDialogBlockBuilder addAction(int paramInt, QMUIDialogAction.ActionListener paramActionListener)
  {
    return addAction(0, paramInt, paramActionListener);
  }
  
  public QMUIDialogBlockBuilder addAction(int paramInt1, String paramString, @QMUIDialogAction.Prop int paramInt2, QMUIDialogAction.ActionListener paramActionListener)
  {
    return (QMUIDialogBlockBuilder)addAction(paramInt1, paramString, paramInt2, 1, paramActionListener);
  }
  
  public QMUIDialogBlockBuilder addAction(int paramInt, String paramString, QMUIDialogAction.ActionListener paramActionListener)
  {
    return addAction(paramInt, paramString, 1, paramActionListener);
  }
  
  public QMUIDialogBlockBuilder addAction(String paramString, QMUIDialogAction.ActionListener paramActionListener)
  {
    return addAction(0, paramString, paramActionListener);
  }
  
  protected void onCreateContent(QMUIDialog paramQMUIDialog, ViewGroup paramViewGroup)
  {
    paramQMUIDialog = new TextView(this.mContext);
    paramQMUIDialog.setTextColor(this.mContext.getResources().getColor(2131166577));
    paramQMUIDialog.setText(this.mContent);
    paramQMUIDialog.setTextSize(14.0F);
    paramQMUIDialog.setLineSpacing(QMUIKit.dpToPx(2), 1.0F);
    int j = this.mContext.getResources().getDimensionPixelSize(2131298544);
    if (hasTitle()) {}
    for (int i = this.mContext.getResources().getDimensionPixelSize(2131298538);; i = this.mContext.getResources().getDimensionPixelSize(2131298540))
    {
      paramQMUIDialog.setPadding(j, i, this.mContext.getResources().getDimensionPixelSize(2131298544), this.mContext.getResources().getDimensionPixelSize(2131298536));
      paramViewGroup.addView(paramQMUIDialog);
      return;
    }
  }
  
  protected void onCreateHandlerBar(QMUIDialog paramQMUIDialog, ViewGroup paramViewGroup)
  {
    if (this.mActions.size() > 0)
    {
      LinearLayout localLinearLayout = new LinearLayout(this.mContext);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      localLinearLayout.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(2131298529));
      int i = 0;
      while (i < this.mActions.size())
      {
        localLinearLayout.addView(((QMUIDialogAction)this.mActions.get(i)).generateActionView(this.mContext, paramQMUIDialog, i, true));
        i += 1;
      }
      paramViewGroup.addView(localLinearLayout);
    }
  }
  
  public QMUIDialogBlockBuilder setContent(int paramInt)
  {
    this.mContent = this.mContext.getResources().getString(paramInt);
    return this;
  }
  
  public QMUIDialogBlockBuilder setContent(CharSequence paramCharSequence)
  {
    this.mContent = paramCharSequence;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.dialog.QMUIDialogBlockBuilder
 * JD-Core Version:    0.7.0.1
 */