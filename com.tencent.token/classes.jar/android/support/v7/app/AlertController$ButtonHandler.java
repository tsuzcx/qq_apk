package android.support.v7.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

final class AlertController$ButtonHandler
  extends Handler
{
  private static final int MSG_DISMISS_DIALOG = 1;
  private WeakReference mDialog;
  
  public AlertController$ButtonHandler(DialogInterface paramDialogInterface)
  {
    this.mDialog = new WeakReference(paramDialogInterface);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 0: 
    default: 
      return;
    case -3: 
    case -2: 
    case -1: 
      ((DialogInterface.OnClickListener)paramMessage.obj).onClick((DialogInterface)this.mDialog.get(), paramMessage.what);
      return;
    }
    ((DialogInterface)paramMessage.obj).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AlertController.ButtonHandler
 * JD-Core Version:    0.7.0.1
 */