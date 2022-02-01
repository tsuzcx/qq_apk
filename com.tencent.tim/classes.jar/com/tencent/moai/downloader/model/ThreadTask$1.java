package com.tencent.moai.downloader.model;

import com.tencent.moai.downloader.delegate.HandleErrorDelegate;
import com.tencent.moai.downloader.exception.ThreadTaskError;
import com.tencent.moai.downloader.file.DownloadFileUtil;
import com.tencent.moai.downloader.listener.ThreadTaskListener;
import com.tencent.moai.downloader.network.HttpError;
import com.tencent.moai.downloader.network.HttpListener;
import com.tencent.moai.downloader.network.HttpRequest;
import com.tencent.moai.downloader.network.HttpResponse;
import com.tencent.moai.downloader.util.Logger;
import com.tencent.moai.downloader.util.StringUtil;
import java.util.List;
import java.util.Map;

class ThreadTask$1
  implements HttpListener
{
  ThreadTask$1(ThreadTask paramThreadTask) {}
  
  public void onAbort(HttpRequest paramHttpRequest, HttpError paramHttpError) {}
  
  public void onComplete(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, HttpError paramHttpError)
  {
    DownloadFileUtil.closeOutPutStream(this.this$0.getOutputStream());
  }
  
  public void onFail(HttpRequest paramHttpRequest, HttpError paramHttpError, HttpResponse paramHttpResponse)
  {
    ThreadTask.access$800(this.this$0).setStatus(5);
    if (ThreadTask.access$1300(this.this$0) != null) {
      ThreadTask.access$1300(this.this$0).handleResponse(paramHttpRequest, paramHttpResponse);
    }
    ThreadTask.access$300(this.this$0).onFail(ThreadTask.access$200(this.this$0), ThreadTask.access$900(this.this$0), ThreadTask.access$1000(this.this$0), new ThreadTaskError(paramHttpError.getErrorCode(), paramHttpError.getMessage()));
  }
  
  public void onPostData(HttpRequest paramHttpRequest, long paramLong1, long paramLong2) {}
  
  public void onPrepare(HttpRequest paramHttpRequest) {}
  
  public void onReceiveData(HttpRequest paramHttpRequest, byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    DownloadFileUtil.writeTmpFile(this.this$0.getOutputStream(), paramArrayOfByte, (int)paramLong1);
    ThreadTask.access$702(this.this$0, ThreadTask.access$700(this.this$0) + paramLong1);
    ThreadTask.access$800(this.this$0).setStatus(2);
    ThreadTask.access$300(this.this$0).onProgress(ThreadTask.access$200(this.this$0), ThreadTask.access$900(this.this$0), ThreadTask.access$1000(this.this$0), ThreadTask.access$700(this.this$0), ThreadTask.access$1100(this.this$0) - ThreadTask.access$1200(this.this$0));
  }
  
  public boolean onReceiveHeader(HttpRequest paramHttpRequest, Map<String, List<String>> paramMap)
  {
    boolean bool = ThreadTask.access$000(this.this$0, paramMap);
    long l1 = ThreadTask.access$100(this.this$0, paramMap);
    ThreadTask.access$300(this.this$0).onReceiveHeader(ThreadTask.access$200(this.this$0), bool, l1);
    if ((ThreadTask.access$400(this.this$0)) && (StringUtil.isNullOrEmpty(ThreadTask.access$500(this.this$0, paramMap))) && (!bool))
    {
      Logger.e("ThreadTask", "check header error. contentLength:" + l1);
      return false;
    }
    if (this.this$0.isSingleTaskDownload())
    {
      long l2 = DownloadFileUtil.getFileSize(ThreadTask.access$600(this.this$0));
      Logger.i("ThreadTask", "AcceptRange:" + bool + ", contentLength:" + l1 + ", downloadSize:" + l2);
      this.this$0.setAcceptRange(bool);
      this.this$0.setEnd(l1);
      if (!bool) {
        break label239;
      }
      this.this$0.setStart(l2);
      this.this$0.setDownloadSize(l2);
      paramHttpRequest = this.this$0;
      paramMap = ThreadTask.access$600(this.this$0);
      if (ThreadTask.access$700(this.this$0) <= 0L) {
        break label258;
      }
    }
    label258:
    for (bool = true;; bool = false)
    {
      paramHttpRequest.setOutputStream(DownloadFileUtil.getOutputStream(paramMap, bool));
      return true;
      label239:
      this.this$0.setStart(0L);
      this.this$0.setDownloadSize(0L);
      break;
    }
  }
  
  public void onSuccess(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse)
  {
    ThreadTask.access$800(this.this$0).setStatus(4);
    ThreadTask.access$300(this.this$0).onSuccess(ThreadTask.access$200(this.this$0), ThreadTask.access$900(this.this$0), ThreadTask.access$1000(this.this$0), ThreadTask.access$600(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.model.ThreadTask.1
 * JD-Core Version:    0.7.0.1
 */