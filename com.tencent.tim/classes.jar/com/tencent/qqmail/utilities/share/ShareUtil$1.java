package com.tencent.qqmail.utilities.share;

import com.tencent.androidqqmail.wxapi.WXEntryActivity.WXShareResultCallback;

final class ShareUtil$1
  implements WXEntryActivity.WXShareResultCallback
{
  ShareUtil$1(ShareUtil.ShareCallback paramShareCallback) {}
  
  public void isSuccess(boolean paramBoolean)
  {
    if (this.val$shareCallback != null) {
      this.val$shareCallback.isSuccess(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.share.ShareUtil.1
 * JD-Core Version:    0.7.0.1
 */