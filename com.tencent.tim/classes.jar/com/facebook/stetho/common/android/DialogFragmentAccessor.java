package com.facebook.stetho.common.android;

import android.app.Dialog;

public abstract interface DialogFragmentAccessor<DIALOG_FRAGMENT, FRAGMENT, FRAGMENT_MANAGER>
  extends FragmentAccessor<FRAGMENT, FRAGMENT_MANAGER>
{
  public abstract Dialog getDialog(DIALOG_FRAGMENT paramDIALOG_FRAGMENT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.common.android.DialogFragmentAccessor
 * JD-Core Version:    0.7.0.1
 */