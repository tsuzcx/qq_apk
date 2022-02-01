package com.tencent.mobileqq.mediafocus;

import ajap;
import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;

public class MediaFocusController$1
  implements Runnable
{
  MediaFocusController$1(MediaFocusController paramMediaFocusController, MediaFocusStackItem paramMediaFocusStackItem, int paramInt) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Bundle localBundle = new Bundle();
    localBundle.putString("processName", this.a.getProcessName());
    localBundle.putParcelable("focusItem", this.a);
    QIPCClientHelper.getInstance().callServer("MediaFocusModuleServer", "actionCheckItemExist", localBundle, new ajap(this, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mediafocus.MediaFocusController.1
 * JD-Core Version:    0.7.0.1
 */