package android.support.v7.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.widget.ListView;

public class AlertController$RecycleListView
  extends ListView
{
  private final int mPaddingBottomNoButtons;
  private final int mPaddingTopNoTitle;
  
  public AlertController$RecycleListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AlertController$RecycleListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RecycleListView);
    this.mPaddingBottomNoButtons = paramContext.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
    this.mPaddingTopNoTitle = paramContext.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
  }
  
  public void setHasDecor(boolean paramBoolean1, boolean paramBoolean2)
  {
    int k;
    int i;
    int m;
    if ((!paramBoolean2) || (!paramBoolean1))
    {
      k = getPaddingLeft();
      if (!paramBoolean1) {
        break label51;
      }
      i = getPaddingTop();
      m = getPaddingRight();
      if (!paramBoolean2) {
        break label59;
      }
    }
    label51:
    label59:
    for (int j = getPaddingBottom();; j = this.mPaddingBottomNoButtons)
    {
      setPadding(k, i, m, j);
      return;
      i = this.mPaddingTopNoTitle;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AlertController.RecycleListView
 * JD-Core Version:    0.7.0.1
 */