package com.tencent.biz.common.offline;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import jpk;

class BidDownloader$4
  implements Runnable
{
  BidDownloader$4(BidDownloader paramBidDownloader) {}
  
  public void run()
  {
    int i = BidDownloader.a.m(BidDownloader.mContext, this.this$0.url);
    if (QLog.isColorLevel()) {
      QLog.i(BidDownloader.TAG, 2, "state = " + i);
    }
    if (i != 2) {
      this.this$0.mUiHandler.sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.common.offline.BidDownloader.4
 * JD-Core Version:    0.7.0.1
 */