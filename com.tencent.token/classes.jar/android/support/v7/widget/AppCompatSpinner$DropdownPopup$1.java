package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;

class AppCompatSpinner$DropdownPopup$1
  implements AdapterView.OnItemClickListener
{
  AppCompatSpinner$DropdownPopup$1(AppCompatSpinner.DropdownPopup paramDropdownPopup, AppCompatSpinner paramAppCompatSpinner) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.this$1.this$0.setSelection(paramInt);
    if (this.this$1.this$0.getOnItemClickListener() != null) {
      this.this$1.this$0.performItemClick(paramView, paramInt, this.this$1.mAdapter.getItemId(paramInt));
    }
    this.this$1.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatSpinner.DropdownPopup.1
 * JD-Core Version:    0.7.0.1
 */