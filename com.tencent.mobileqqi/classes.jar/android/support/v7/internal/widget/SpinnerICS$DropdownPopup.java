package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SpinnerAdapter;

class SpinnerICS$DropdownPopup
  extends ListPopupWindow
  implements SpinnerICS.SpinnerPopup
{
  private ListAdapter mAdapter;
  private CharSequence mHintText;
  
  public SpinnerICS$DropdownPopup(SpinnerICS paramSpinnerICS, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setAnchorView(paramSpinnerICS);
    setModal(true);
    setPromptPosition(0);
    setOnItemClickListener(new AdapterViewICS.OnItemClickListenerWrapper(paramSpinnerICS, new SpinnerICS.DropdownPopup.1(this, paramSpinnerICS)));
  }
  
  public CharSequence getHintText()
  {
    return this.mHintText;
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
    int j = this.this$0.getPaddingLeft();
    int i;
    if (this.this$0.mDropDownWidth == -2)
    {
      i = this.this$0.getWidth();
      int k = this.this$0.getPaddingRight();
      setContentWidth(Math.max(this.this$0.measureContentWidth((SpinnerAdapter)this.mAdapter, getBackground()), i - j - k));
    }
    for (;;)
    {
      Drawable localDrawable = getBackground();
      i = 0;
      if (localDrawable != null)
      {
        localDrawable.getPadding(SpinnerICS.access$200(this.this$0));
        i = -SpinnerICS.access$200(this.this$0).left;
      }
      setHorizontalOffset(i + j);
      setInputMethodMode(2);
      super.show();
      getListView().setChoiceMode(1);
      setSelection(this.this$0.getSelectedItemPosition());
      return;
      if (this.this$0.mDropDownWidth == -1) {
        setContentWidth(this.this$0.getWidth() - j - this.this$0.getPaddingRight());
      } else {
        setContentWidth(this.this$0.mDropDownWidth);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.SpinnerICS.DropdownPopup
 * JD-Core Version:    0.7.0.1
 */