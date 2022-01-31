package android.support.v7.internal.widget;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.ListAdapter;

class SpinnerICS$DialogPopup
  implements DialogInterface.OnClickListener, SpinnerICS.SpinnerPopup
{
  private ListAdapter mListAdapter;
  private AlertDialog mPopup;
  private CharSequence mPrompt;
  
  private SpinnerICS$DialogPopup(SpinnerICS paramSpinnerICS) {}
  
  public void dismiss()
  {
    this.mPopup.dismiss();
    this.mPopup = null;
  }
  
  public CharSequence getHintText()
  {
    return this.mPrompt;
  }
  
  public boolean isShowing()
  {
    if (this.mPopup != null) {
      return this.mPopup.isShowing();
    }
    return false;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$0.setSelection(paramInt);
    if (this.this$0.mOnItemClickListener != null) {
      this.this$0.performItemClick(null, paramInt, this.mListAdapter.getItemId(paramInt));
    }
    dismiss();
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    this.mListAdapter = paramListAdapter;
  }
  
  public void setPromptText(CharSequence paramCharSequence)
  {
    this.mPrompt = paramCharSequence;
  }
  
  public void show()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.this$0.getContext());
    if (this.mPrompt != null) {
      localBuilder.setTitle(this.mPrompt);
    }
    this.mPopup = localBuilder.setSingleChoiceItems(this.mListAdapter, this.this$0.getSelectedItemPosition(), this).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.SpinnerICS.DialogPopup
 * JD-Core Version:    0.7.0.1
 */