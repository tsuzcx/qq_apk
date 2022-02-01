package com.tencent.moai.downloader.network;

import android.util.Log;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import com.tencent.moai.downloader.GlobalConfig;
import com.tencent.moai.downloader.util.Logger;
import java.io.IOException;
import okio.BufferedSink;

class DefaultHttpClient$1
  extends RequestBody
{
  DefaultHttpClient$1(DefaultHttpClient paramDefaultHttpClient, HttpRequest paramHttpRequest) {}
  
  public MediaType contentType()
  {
    return HttpDefine.CONTENT_TYPE_POST;
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
    throws IOException
  {
    byte[] arrayOfByte = this.val$httpRequest.getRequestParam().getBytes();
    int k = arrayOfByte.length;
    long l = 0L;
    int j = 0;
    for (;;)
    {
      if (j < k) {}
      try
      {
        int i = GlobalConfig.SEND_BUFF_LEN_INTEGER.intValue() + j;
        if (i < k) {}
        for (;;)
        {
          int m = i - j;
          paramBufferedSink.write(arrayOfByte, j, m);
          l = m + l;
          this.val$httpRequest.onPostData(l, k);
          j = i;
          break;
          i = k;
        }
        return;
      }
      catch (Exception localException)
      {
        Logger.e("DefaultHttpClient", Log.getStackTraceString(localException));
        return;
      }
      catch (Error localError)
      {
        Logger.e("DefaultHttpClient", localError.getMessage());
        return;
      }
      finally
      {
        paramBufferedSink.close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.network.DefaultHttpClient.1
 * JD-Core Version:    0.7.0.1
 */