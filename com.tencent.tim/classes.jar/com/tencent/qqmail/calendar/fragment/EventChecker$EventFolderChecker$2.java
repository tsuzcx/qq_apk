package com.tencent.qqmail.calendar.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class EventChecker$EventFolderChecker$2
  implements DialogInterface.OnCancelListener
{
  EventChecker$EventFolderChecker$2(EventChecker.EventFolderChecker paramEventFolderChecker, EventChecker.EventCheckerListener paramEventCheckerListener) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.val$listener.onCheckError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.EventChecker.EventFolderChecker.2
 * JD-Core Version:    0.7.0.1
 */