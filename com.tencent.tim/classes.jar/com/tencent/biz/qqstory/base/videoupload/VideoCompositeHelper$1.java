package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.biz.qqstory.database.PublishVideoEntry;
import pog;
import pog.e;
import ram;

public class VideoCompositeHelper$1
  implements Runnable
{
  public VideoCompositeHelper$1(pog parampog, PublishVideoEntry paramPublishVideoEntry, String paramString, boolean paramBoolean1, boolean paramBoolean2, pog.e parame) {}
  
  public void run()
  {
    try
    {
      ram.w(pog.TAG, "composite thread try get lock");
      try
      {
        ram.i(pog.TAG, "composite thread get lock and start doComposite");
        this.this$0.b(this.c, this.val$outPath, this.aAX, this.val$isLoopAudio, this.a);
        return;
      }
      finally {}
      return;
    }
    catch (Exception localException)
    {
      ram.e(pog.TAG, "do composite exception", localException);
      this.a.g(942012, localException.getMessage(), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.1
 * JD-Core Version:    0.7.0.1
 */