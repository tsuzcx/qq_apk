package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SpinnerAdapter;

class AppCompatSpinner$DropdownPopup
  extends ListPopupWindow
{
  ListAdapter mAdapter;
  private CharSequence mHintText;
  private final Rect mVisibleRect = new Rect();
  
  public AppCompatSpinner$DropdownPopup(AppCompatSpinner paramAppCompatSpinner, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setAnchorView(paramAppCompatSpinner);
    setModal(true);
    setPromptPosition(0);
    setOnItemClickListener(new AppCompatSpinner.DropdownPopup.1(this, paramAppCompatSpinner));
  }
  
  void computeContentWidth()
  {
    Object localObject = getBackground();
    int i;
    int m;
    int n;
    int i1;
    int j;
    if (localObject != null)
    {
      ((Drawable)localObject).getPadding(AppCompatSpinner.access$100(this.this$0));
      if (ViewUtils.isLayoutRtl(this.this$0))
      {
        i = AppCompatSpinner.access$100(this.this$0).right;
        m = this.this$0.getPaddingLeft();
        n = this.this$0.getPaddingRight();
        i1 = this.this$0.getWidth();
        if (AppCompatSpinner.access$200(this.this$0) != -2) {
          break label240;
        }
        j = this.this$0.compatMeasureContentWidth((SpinnerAdapter)this.mAdapter, getBackground());
        int k = this.this$0.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.access$100(this.this$0).left - AppCompatSpinner.access$100(this.this$0).right;
        if (j <= k) {
          break label288;
        }
        j = k;
      }
    }
    label288:
    for (;;)
    {
      setContentWidth(Math.max(j, i1 - m - n));
      label165:
      if (ViewUtils.isLayoutRtl(this.this$0)) {
        i = i1 - n - getWidth() + i;
      }
      for (;;)
      {
        setHorizontalOffset(i);
        return;
        i = -AppCompatSpinner.access$100(this.this$0).left;
        break;
        localObject = AppCompatSpinner.access$100(this.this$0);
        AppCompatSpinner.access$100(this.this$0).right = 0;
        ((Rect)localObject).left = 0;
        i = 0;
        break;
        label240:
        if (AppCompatSpinner.access$200(this.this$0) == -1)
        {
          setContentWidth(i1 - m - n);
          break label165;
        }
        setContentWidth(AppCompatSpinner.access$200(this.this$0));
        break label165;
        i += m;
      }
    }
  }
  
  public CharSequence getHintText()
  {
    return this.mHintText;
  }
  
  boolean isVisibleToUser(View paramView)
  {
    return (ViewCompat.isAttachedToWindow(paramView)) && (paramView.getGlobalVisibleRect(this.mVisibleRect));
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    this.mAdapter = paramListAdapter;
  }
  
  public void setPromptText(CharSequence paramCharSequence)
  {
    this.mHintText = paramCharSequence;
  }
  
  public void show()
  {
    boolean bool = isShowing();
    computeContentWidth();
    setInputMethodMode(2);
    super.show();
    getListView().setChoiceMode(1);
    setSelection(this.this$0.getSelectedItemPosition());
    if (bool) {}
    ViewTreeObserver localViewTreeObserver;
    do
    {
      return;
      localViewTreeObserver = this.this$0.getViewTreeObserver();
    } while (localViewTreeObserver == null);
    AppCompatSpinner.DropdownPopup.2 local2 = new AppCompatSpinner.DropdownPopup.2(this);
    localViewTreeObserver.addOnGlobalLayoutListener(local2);
    setOnDismissListener(new AppCompatSpinner.DropdownPopup.3(this, local2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatSpinner.DropdownPopup
 * JD-Core Version:    0.7.0.1
 */