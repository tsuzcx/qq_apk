package com.tencent.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.lang.ref.WeakReference;

public class CustomDIOnClickListener
  implements DialogInterface.OnClickListener
{
  private final WeakReference a;
  
  public CustomDIOnClickListener(DialogInterface.OnClickListener paramOnClickListener)
  {
    this.a = new WeakReference(paramOnClickListener);
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DialogInterface.OnClickListener localOnClickListener = (DialogInterface.OnClickListener)this.a.get();
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramDialogInterface, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.CustomDIOnClickListener
 * JD-Core Version:    0.7.0.1
 */