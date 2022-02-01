package com.tencent.qqmail.InlineImage.fetcher;

import com.tencent.qqmail.model.mail.loader.ProtocolInlineImgCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.concurrent.CountDownLatch;

class CidImageFetcher$1
  implements ProtocolInlineImgCallback
{
  CidImageFetcher$1(CidImageFetcher paramCidImageFetcher, String paramString) {}
  
  public void onError(Object paramObject)
  {
    QMLog.log(5, "CidImageFetch", "onError url " + this.val$url + " error " + paramObject);
    CidImageFetcher.access$002(this.this$0, "");
    CidImageFetcher.access$100(this.this$0).countDown();
  }
  
  public boolean onProgress(long paramLong1, long paramLong2)
  {
    return false;
  }
  
  public void onSuccess(String paramString)
  {
    QMLog.log(4, "CidImageFetch", "onSuccess url " + this.val$url + " storePath " + paramString);
    CidImageFetcher.access$002(this.this$0, paramString);
    CidImageFetcher.access$100(this.this$0).countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.InlineImage.fetcher.CidImageFetcher.1
 * JD-Core Version:    0.7.0.1
 */