package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.common.galleryactivity.AbstractImageAdapter;
import xtp;

public class AIOImageListScene$7
  implements Runnable
{
  public AIOImageListScene$7(xtp paramxtp) {}
  
  public void run()
  {
    if ((this.this$0.b != null) && (!((AIOPhotoListAdapter)this.this$0.b).ay(false))) {
      this.this$0.b.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageListScene.7
 * JD-Core Version:    0.7.0.1
 */