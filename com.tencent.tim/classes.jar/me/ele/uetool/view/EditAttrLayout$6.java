package me.ele.uetool.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import me.ele.uetool.base.Element;

class EditAttrLayout$6
  implements DialogInterface.OnDismissListener
{
  EditAttrLayout$6(EditAttrLayout paramEditAttrLayout) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (EditAttrLayout.access$300(this.this$0) != null)
    {
      EditAttrLayout.access$300(this.this$0).reset();
      this.this$0.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.view.EditAttrLayout.6
 * JD-Core Version:    0.7.0.1
 */