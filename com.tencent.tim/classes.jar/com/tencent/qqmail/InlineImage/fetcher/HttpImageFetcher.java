package com.tencent.qqmail.InlineImage.fetcher;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.marcos.CommonMatch;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.CGIManager;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringEscapeUtils;

public class HttpImageFetcher
  extends BaseFetcher
{
  private static final long LOCK_TIMEOUT = 20L;
  private static final String TAG = "HttpImageFetcher";
  private int accountId;
  private CountDownLatch countDownLatch;
  private String downloadPath = "";
  
  public HttpImageFetcher(int paramInt)
  {
    this.accountId = paramInt;
  }
  
  private boolean isImage(String paramString)
  {
    boolean bool = true;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    if ((localOptions.outWidth <= 0) || (localOptions.outHeight <= 0)) {
      bool = false;
    }
    return bool;
  }
  
  protected void fetchFromNetwork(String paramString)
  {
    QMLog.log(4, "HttpImageFetcher", "fetchFromNetwork url " + paramString);
    Object localObject2 = StringEscapeUtils.unescapeHtml4(paramString);
    Object localObject1 = localObject2;
    if (CommonMatch.QQMAIL_CGI_PATTERN.matcher((CharSequence)localObject2).find()) {
      localObject1 = CGIManager.removeSid((String)localObject2);
    }
    this.countDownLatch = new CountDownLatch(1);
    localObject2 = new DownloadInfo();
    ((DownloadInfo)localObject2).setAccountId(this.accountId);
    ((DownloadInfo)localObject2).setUrl((String)localObject1);
    ((DownloadInfo)localObject2).setImageDownloadListener(new HttpImageFetcher.1(this));
    ImageDownloadManager.shareInstance().fetchImage((DownloadInfo)localObject2);
    try
    {
      bool = this.countDownLatch.await(20L, TimeUnit.SECONDS);
      Log.i("HttpImageFetcher", "Finish loading http image path downloadPath " + this.downloadPath + " reachLatch = " + bool);
      if (TextUtils.isEmpty(this.downloadPath)) {
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
        QMLog.log(4, "HttpImageFetcher", "InterruptedException " + localInterruptedException.getStackTrace());
      }
      boolean bool = isImage(this.downloadPath);
      QMLog.log(4, "HttpImageFetcher", "isImage " + bool + " url " + paramString);
      if (bool)
      {
        byte[] arrayOfByte = BitmapResizer.readResizedBitmap(this.downloadPath);
        if (arrayOfByte != null) {}
        for (this.inputStream = new ByteArrayInputStream(arrayOfByte);; this.inputStream = null)
        {
          InlineImagePathHelper.put(paramString, this.downloadPath);
          return;
        }
      }
      try
      {
        this.inputStream = new FileInputStream(this.downloadPath);
        return;
      }
      catch (FileNotFoundException paramString)
      {
        paramString.printStackTrace();
        this.inputStream = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.InlineImage.fetcher.HttpImageFetcher
 * JD-Core Version:    0.7.0.1
 */