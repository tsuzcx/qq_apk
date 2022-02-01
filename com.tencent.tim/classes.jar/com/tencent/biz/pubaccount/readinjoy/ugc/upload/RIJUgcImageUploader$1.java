package com.tencent.biz.pubaccount.readinjoy.ugc.upload;

import com.tencent.mobileqq.app.ThreadManagerV2;
import mqo;
import mqp;
import mqw;

public class RIJUgcImageUploader$1
  implements Runnable
{
  public RIJUgcImageUploader$1(mqo parammqo) {}
  
  public void run()
  {
    mqo.a(this.this$0, new mqw(mqo.a(this.this$0), mqo.a(this.this$0), new mqp(this)));
    ThreadManagerV2.excute(new RIJUgcImageUploader.1.2(this), 128, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.upload.RIJUgcImageUploader.1
 * JD-Core Version:    0.7.0.1
 */