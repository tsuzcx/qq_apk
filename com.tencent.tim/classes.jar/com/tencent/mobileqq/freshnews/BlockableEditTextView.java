package com.tencent.mobileqq.freshnews;

import ahpd;
import ahpe;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.widget.EditText;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;

public class BlockableEditTextView
  extends EditText
{
  private boolean chP;
  private int das = 0;
  int mEnd = -1;
  int mStart = -1;
  
  public BlockableEditTextView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public BlockableEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public BlockableEditTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private boolean anR()
  {
    int i = getSelectionStart();
    int j = getSelectionEnd();
    if (getEditableText() == null) {
      return false;
    }
    a[] arrayOfa = (a[])getEditableText().getSpans(i, j, a.class);
    if ((arrayOfa != null) && (arrayOfa.length > 0) && ((arrayOfa[0] instanceof a)))
    {
      i = getEditableText().getSpanEnd(arrayOfa[0]);
      j = getEditableText().getSpanStart(arrayOfa[0]);
      if ((j >= 0) && (i > j)) {
        return false;
      }
    }
    return true;
  }
  
  private void init()
  {
    setEditableFactory(TroopBarPublishUtils.a);
    if (Build.VERSION.SDK_INT >= 11) {
      setCustomSelectionActionModeCallback(new ahpd(this));
    }
    addTextChangedListener(new ahpe(this));
  }
  
  protected void onCreateContextMenu(ContextMenu paramContextMenu)
  {
    if ((anR()) || (Build.VERSION.SDK_INT >= 11)) {
      super.onCreateContextMenu(paramContextMenu);
    }
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    super.onSelectionChanged(paramInt1, paramInt2);
    if (getEditableText() == null) {}
    int i;
    int j;
    do
    {
      do
      {
        do
        {
          a[] arrayOfa;
          do
          {
            return;
            arrayOfa = (a[])getEditableText().getSpans(paramInt1, paramInt2, a.class);
          } while ((arrayOfa == null) || (arrayOfa.length <= 0));
          i = getEditableText().getSpanEnd(arrayOfa[0]);
          j = getEditableText().getSpanStart(arrayOfa[0]);
        } while ((i <= j) || (j < 0));
        if ((paramInt1 == j) && (paramInt2 == j) && (this.chP))
        {
          setSelection(i);
          return;
        }
      } while ((this.das <= 0) || ((paramInt1 >= i) && (paramInt2 >= i)) || ((paramInt1 <= j) && (paramInt2 <= j)));
      if ((paramInt1 <= j) && (paramInt2 <= i))
      {
        setSelection(paramInt1, j);
        return;
      }
      if ((paramInt1 >= j) && (paramInt2 <= i))
      {
        setSelection(j);
        return;
      }
      if ((paramInt1 >= j) && (paramInt2 >= i))
      {
        setSelection(i, paramInt2);
        return;
      }
    } while ((paramInt1 > j) || (paramInt2 < i));
    setSelection(paramInt1, j);
  }
  
  public void setBlockFront(boolean paramBoolean)
  {
    this.chP = paramBoolean;
  }
  
  public void setEditStatus(int paramInt)
  {
    this.das = paramInt;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.freshnews.BlockableEditTextView
 * JD-Core Version:    0.7.0.1
 */