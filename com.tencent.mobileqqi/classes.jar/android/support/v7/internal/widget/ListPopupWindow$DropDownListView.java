package android.support.v7.internal.widget;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;

class ListPopupWindow$DropDownListView
  extends ListView
{
  public static final int INVALID_POSITION = -1;
  static final int NO_POSITION = -1;
  private static final String TAG = "ListPopupWindow.DropDownListView";
  private boolean mHijackFocus;
  private boolean mListSelectionHidden;
  
  public ListPopupWindow$DropDownListView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null, 2130772001);
    this.mHijackFocus = paramBoolean;
    setCacheColorHint(0);
  }
  
  private int lookForSelectablePosition(int paramInt, boolean paramBoolean)
  {
    ListAdapter localListAdapter = getAdapter();
    int i;
    if ((localListAdapter == null) || (isInTouchMode())) {
      i = -1;
    }
    int j;
    label130:
    do
    {
      do
      {
        return i;
        j = localListAdapter.getCount();
        if (getAdapter().areAllItemsEnabled()) {
          break label130;
        }
        if (paramBoolean)
        {
          i = Math.max(0, paramInt);
          for (;;)
          {
            paramInt = i;
            if (i >= j) {
              break;
            }
            paramInt = i;
            if (localListAdapter.isEnabled(i)) {
              break;
            }
            i += 1;
          }
        }
        i = Math.min(paramInt, j - 1);
        for (;;)
        {
          paramInt = i;
          if (i < 0) {
            break;
          }
          paramInt = i;
          if (localListAdapter.isEnabled(i)) {
            break;
          }
          i -= 1;
        }
        if (paramInt < 0) {
          break;
        }
        i = paramInt;
      } while (paramInt < j);
      return -1;
      if (paramInt < 0) {
        break;
      }
      i = paramInt;
    } while (paramInt < j);
    return -1;
  }
  
  public boolean hasFocus()
  {
    return (this.mHijackFocus) || (super.hasFocus());
  }
  
  public boolean hasWindowFocus()
  {
    return (this.mHijackFocus) || (super.hasWindowFocus());
  }
  
  public boolean isFocused()
  {
    return (this.mHijackFocus) || (super.isFocused());
  }
  
  public boolean isInTouchMode()
  {
    return ((this.mHijackFocus) && (this.mListSelectionHidden)) || (super.isInTouchMode());
  }
  
  final int measureHeightOfChildrenCompat(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramInt2 = getListPaddingTop();
    int i = getListPaddingBottom();
    getListPaddingLeft();
    getListPaddingRight();
    paramInt3 = getDividerHeight();
    Object localObject = getDivider();
    ListAdapter localListAdapter = getAdapter();
    if (localListAdapter == null)
    {
      paramInt1 = paramInt2 + i;
      return paramInt1;
    }
    paramInt2 = i + paramInt2;
    label64:
    int j;
    label85:
    int m;
    if ((paramInt3 > 0) && (localObject != null))
    {
      j = 0;
      localObject = null;
      int k = 0;
      int n = localListAdapter.getCount();
      i = 0;
      if (i >= n) {
        break label283;
      }
      m = localListAdapter.getItemViewType(i);
      if (m == k) {
        break label285;
      }
      localObject = null;
      k = m;
      label117:
      localObject = localListAdapter.getView(i, (View)localObject, this);
      ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
      if ((localLayoutParams == null) || (localLayoutParams.height <= 0)) {
        break label237;
      }
      m = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
      label163:
      ((View)localObject).measure(paramInt1, m);
      if (i <= 0) {
        break label288;
      }
      paramInt2 += paramInt3;
    }
    label283:
    label285:
    label288:
    for (;;)
    {
      paramInt2 += ((View)localObject).getMeasuredHeight();
      if (paramInt2 >= paramInt4)
      {
        paramInt1 = paramInt4;
        if (paramInt5 < 0) {
          break;
        }
        paramInt1 = paramInt4;
        if (i <= paramInt5) {
          break;
        }
        paramInt1 = paramInt4;
        if (j <= 0) {
          break;
        }
        paramInt1 = paramInt4;
        if (paramInt2 == paramInt4) {
          break;
        }
        return j;
        paramInt3 = 0;
        break label64;
        label237:
        m = View.MeasureSpec.makeMeasureSpec(0, 0);
        break label163;
      }
      m = j;
      if (paramInt5 >= 0)
      {
        m = j;
        if (i >= paramInt5) {
          m = paramInt2;
        }
      }
      i += 1;
      j = m;
      break label85;
      return paramInt2;
      break label117;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.ListPopupWindow.DropDownListView
 * JD-Core Version:    0.7.0.1
 */