package com.tencent.biz.common.offline;

import java.util.HashMap;
import jpk;

class BidDownloader$2
  implements Runnable
{
  BidDownloader$2(BidDownloader paramBidDownloader) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Accept-Encoding", "gzip");
    BidDownloader.a.a(BidDownloader.mContext, this.this$0.url, this.this$0.mBusinessId, this.this$0.TM, this.this$0.b, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.common.offline.BidDownloader.2
 * JD-Core Version:    0.7.0.1
 */