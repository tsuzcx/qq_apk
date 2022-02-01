package com.tencent.qqmail.InlineImage.fetcher;

import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import java.util.concurrent.CountDownLatch;

class HttpImageFetcher$1
  implements ImageDownloadListener
{
  HttpImageFetcher$1(HttpImageFetcher paramHttpImageFetcher) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject)
  {
    Log.w("HttpImageFetcher", "onError url " + paramString + " error " + paramObject);
    HttpImageFetcher.access$002(this.this$0, "");
    HttpImageFetcher.access$100(this.this$0).countDown();
  }
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    Log.i("HttpImageFetcher", "onSuccess url " + paramString1 + " storePath " + paramString2);
    HttpImageFetcher.access$002(this.this$0, paramString2);
    HttpImageFetcher.access$100(this.this$0).countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.InlineImage.fetcher.HttpImageFetcher.1
 * JD-Core Version:    0.7.0.1
 */