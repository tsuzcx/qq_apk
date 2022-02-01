package com.tencent.biz.qqstory.takevideo;

import android.os.Handler;
import java.util.List;
import ram;
import rdm;

public class EditVideoPlayer$1
  implements Runnable
{
  public EditVideoPlayer$1(rdm paramrdm, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    List localList = this.this$0.oD;
    if ((localList != null) && (this.val$index < localList.size())) {}
    try
    {
      ((MultiBlockVideoPlayer)this.this$0.a).setCurrentVideoFragment((MultiBlockVideoPlayer.a)localList.get(this.val$index));
      if (this.val$index > this.bqu) {
        this.this$0.mMainHandler.post(new EditVideoPlayer.1.1(this));
      }
      if ((localList != null) && (this.bqu < localList.size())) {
        this.this$0.a((MultiBlockVideoPlayer.a)localList.get(this.bqu));
      }
      return;
    }
    catch (MultiBlockVideoPlayer.MultiOperateException localMultiOperateException)
    {
      for (;;)
      {
        ram.e("Q.qqstory.record.EditVideoPlayer", "setCurrentVideoFragment failed", localMultiOperateException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPlayer.1
 * JD-Core Version:    0.7.0.1
 */