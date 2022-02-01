package com.tencent.qqmail.activity.readmail;

import android.graphics.Bitmap;
import com.tencent.androidqqmail.wxapi.WXEntryActivity;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.utilities.log.QMLog;

class ReadMailFragment$152
  implements ImageDownloadListener
{
  ReadMailFragment$152(ReadMailFragment paramReadMailFragment, WXMediaMessage paramWXMediaMessage) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject)
  {
    QMLog.log(6, "ReadMailFragment", "sharedMailToWx image data is null, " + paramObject.toString());
  }
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    if (paramBitmap != null) {
      this.val$msg.thumbData = WXEntryActivity.bmpToByteArray(paramBitmap, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.152
 * JD-Core Version:    0.7.0.1
 */