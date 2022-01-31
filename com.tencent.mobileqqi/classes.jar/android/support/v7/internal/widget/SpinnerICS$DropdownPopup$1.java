package android.support.v7.internal.widget;

import android.view.View;
import android.widget.ListAdapter;

class SpinnerICS$DropdownPopup$1
  implements AdapterViewICS.OnItemClickListener
{
  SpinnerICS$DropdownPopup$1(SpinnerICS.DropdownPopup paramDropdownPopup, SpinnerICS paramSpinnerICS) {}
  
  public void onItemClick(AdapterViewICS paramAdapterViewICS, View paramView, int paramInt, long paramLong)
  {
    this.this$1.this$0.setSelection(paramInt);
    if (this.this$1.this$0.mOnItemClickListener != null) {
      this.this$1.this$0.performItemClick(paramView, paramInt, SpinnerICS.DropdownPopup.access$100(this.this$1).getItemId(paramInt));
    }
    this.this$1.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.SpinnerICS.DropdownPopup.1
 * JD-Core Version:    0.7.0.1
 */