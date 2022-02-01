package com.tencent.moai.downloader.network;

import android.util.Log;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import com.tencent.moai.downloader.GlobalConfig;
import com.tencent.moai.downloader.util.Logger;
import com.tencent.moai.downloader.util.StringUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import okio.BufferedSink;

class DefaultHttpClient$2
  extends RequestBody
{
  DefaultHttpClient$2(DefaultHttpClient paramDefaultHttpClient, HttpRequest paramHttpRequest) {}
  
  public MediaType contentType()
  {
    return HttpDefine.CONTENT_TYPE_MULTIPART;
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
    throws IOException
  {
    long l2 = DefaultHttpClient.access$000(this.this$0, this.val$httpRequest.getRequestParam(), this.val$httpRequest.getRequestFile());
    for (;;)
    {
      try
      {
        Object localObject3 = this.val$httpRequest.getRequestParam();
        Object localObject5;
        if (localObject3 != null)
        {
          StringBuffer localStringBuffer = new StringBuffer();
          localObject3 = StringUtil.parseParams((String)localObject3, true).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            localObject5 = (HttpParam)((Iterator)localObject3).next();
            localStringBuffer.append("-----------7d4a6d158c9\r\n");
            localStringBuffer.append("Content-Disposition: form-data; name=\"" + ((HttpParam)localObject5).getKey() + "\"\r\n\r\n");
            localStringBuffer.append(((HttpParam)localObject5).getValue() + "\r\n");
            continue;
          }
        }
        Object localObject1;
        HttpFileEntity localHttpFileEntity;
        String str;
        long l3;
        int i;
        long l1 = 0L;
      }
      catch (Exception localException)
      {
        Logger.e("DefaultHttpClient", Log.getStackTraceString(localException));
        return;
        localObject1 = localException.toString().getBytes();
        paramBufferedSink.write((byte[])localObject1);
        l1 = localObject1.length + 0L;
        this.val$httpRequest.onPostData(l1, l2);
        localObject5 = this.val$httpRequest.getRequestFile().iterator();
        if (((Iterator)localObject5).hasNext())
        {
          localHttpFileEntity = (HttpFileEntity)((Iterator)localObject5).next();
          localObject1 = localHttpFileEntity.getFile().getName();
          str = localHttpFileEntity.getContentType();
          localObject3 = "-----------7d4a6d158c9\r\nContent-Disposition: form-data; name=\"" + (String)localObject1 + "\"; filename=\"" + (String)localObject1 + "\"\r\n";
          localObject1 = localObject3;
          if (!str.equals("")) {
            localObject1 = (String)localObject3 + "Content-Type: " + str + "\r\n";
          }
          localObject1 = (String)localObject1 + "\r\n";
          paramBufferedSink.write(((String)localObject1).getBytes());
          l3 = ((String)localObject1).getBytes().length;
          localObject1 = new FileInputStream(localHttpFileEntity.getFile());
          try
          {
            localObject3 = new byte[GlobalConfig.SEND_BUFF_LEN_INTEGER.intValue()];
            l1 += l3;
            i = ((InputStream)localObject1).read((byte[])localObject3, 0, GlobalConfig.SEND_BUFF_LEN_INTEGER.intValue());
            if (i > 0)
            {
              paramBufferedSink.write((byte[])localObject3, 0, i);
              l1 += i;
            }
            else
            {
              paramBufferedSink.write("\r\n".getBytes());
              ((InputStream)localObject1).close();
            }
          }
          finally
          {
            ((InputStream)localObject1).close();
          }
        }
      }
      catch (Error localError)
      {
        Logger.e("DefaultHttpClient", localError.getMessage());
        return;
        paramBufferedSink.write("-----------7d4a6d158c9--\r\n".getBytes());
        l3 = "-----------7d4a6d158c9--\r\n".length();
        this.val$httpRequest.onPostData(l3 + l1, l2);
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
 * Qualified Name:     com.tencent.moai.downloader.network.DefaultHttpClient.2
 * JD-Core Version:    0.7.0.1
 */