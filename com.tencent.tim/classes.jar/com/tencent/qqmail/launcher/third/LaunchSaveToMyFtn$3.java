package com.tencent.qqmail.launcher.third;

import com.tencent.qqmail.ftn.Ftn.StoreFileOutput;
import com.tencent.qqmail.ftn.callback.SaveFtnFileCallback;
import com.tencent.qqmail.utilities.thread.Threads;

final class LaunchSaveToMyFtn$3
  implements SaveFtnFileCallback
{
  public void onError(int paramInt)
  {
    Threads.runInBackground(new LaunchSaveToMyFtn.3.2(this, paramInt), 500L);
  }
  
  public void onSuccess(StoreFileOutput paramStoreFileOutput)
  {
    Threads.runInBackground(new LaunchSaveToMyFtn.3.1(this, paramStoreFileOutput), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.launcher.third.LaunchSaveToMyFtn.3
 * JD-Core Version:    0.7.0.1
 */