package com.tencent.mobileqq.mini.network.http;

import com.tencent.plato.mqq.network.ProgressListener;

class MiniappHttpUtil$UploadTask$2
  implements ProgressListener
{
  MiniappHttpUtil$UploadTask$2(MiniappHttpUtil.UploadTask paramUploadTask) {}
  
  public void onProgress(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.this$0.callBack.onProgressUpdate((int)(100.0D * paramLong1 / paramLong2), (int)paramLong1, (int)paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.network.http.MiniappHttpUtil.UploadTask.2
 * JD-Core Version:    0.7.0.1
 */