package com.tencent.qqmail.subscribe;

import android.graphics.Bitmap;
import com.tencent.qqmail.model.mail.watcher.SyncSubscribeThumbWatcher;
import com.tencent.qqmail.utilities.ui.PtrListView;

class SubscribeListFragment$2
  implements SyncSubscribeThumbWatcher
{
  SubscribeListFragment$2(SubscribeListFragment paramSubscribeListFragment) {}
  
  public void onError(int paramInt1, int paramInt2, String paramString, Object paramObject) {}
  
  public void onLoading(int paramInt1, int paramInt2) {}
  
  public void onSuccess(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramString = new SubscribeListFragment.RefreshThumbRunnable(this.this$0, paramInt1, paramInt2, paramBitmap);
    if (!SubscribeListFragment.access$700(this.this$0)) {
      SubscribeListFragment.access$800(this.this$0).post(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.subscribe.SubscribeListFragment.2
 * JD-Core Version:    0.7.0.1
 */