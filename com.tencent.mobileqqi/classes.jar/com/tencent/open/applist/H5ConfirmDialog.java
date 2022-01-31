package com.tencent.open.applist;

import android.app.Dialog;
import android.content.Context;
import android.widget.Button;
import android.widget.CheckBox;
import hpg;
import hph;

public class H5ConfirmDialog
{
  protected Button cancel_btn;
  protected Button confirm_btn;
  protected Context context;
  public CheckBox createIcon_cb;
  protected Dialog dialog;
  public H5ConfirmDialog.Dialogcallback dialogcallback;
  
  public H5ConfirmDialog(Context paramContext)
  {
    this.context = paramContext;
    this.dialog = new Dialog(this.context, 2131624152);
    this.dialog.setContentView(2130903327);
    this.confirm_btn = ((Button)this.dialog.findViewById(2131232100));
    this.cancel_btn = ((Button)this.dialog.findViewById(2131232099));
    this.createIcon_cb = ((CheckBox)this.dialog.findViewById(2131232098));
    this.confirm_btn.setOnClickListener(new hpg(this));
    this.cancel_btn.setOnClickListener(new hph(this));
  }
  
  public void dismiss()
  {
    this.dialog.dismiss();
  }
  
  public boolean isShowing()
  {
    return this.dialog.isShowing();
  }
  
  public void setDialogCallback(H5ConfirmDialog.Dialogcallback paramDialogcallback)
  {
    this.dialogcallback = paramDialogcallback;
  }
  
  public void show()
  {
    this.dialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.applist.H5ConfirmDialog
 * JD-Core Version:    0.7.0.1
 */