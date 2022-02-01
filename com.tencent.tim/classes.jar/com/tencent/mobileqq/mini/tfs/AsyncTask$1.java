package com.tencent.mobileqq.mini.tfs;

import com.tencent.qphone.base.util.QLog;

class AsyncTask$1
  implements Runnable
{
  AsyncTask$1(AsyncTask paramAsyncTask) {}
  
  public void run()
  {
    QLog.i("miniapp-start", 1, "Task executeAsync : " + this.this$0.getName());
    this.this$0.executeAsync();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.AsyncTask.1
 * JD-Core Version:    0.7.0.1
 */