package com.tencent.av.utils.download;

import com.tencent.qphone.base.util.QLog;
import jlq;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;

public class BaseDownloadAsyncTask$1
  implements Runnable
{
  public BaseDownloadAsyncTask$1(jlq paramjlq, HttpClient paramHttpClient) {}
  
  public void run()
  {
    QLog.i(jlq.a(this.this$0), 1, "getConnectionManager().shutdown()");
    this.c.getConnectionManager().shutdown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.utils.download.BaseDownloadAsyncTask.1
 * JD-Core Version:    0.7.0.1
 */