package com.tencent.biz.qqstory.takevideo.publish;

import aniu;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import java.util.concurrent.atomic.AtomicBoolean;
import ram;
import rkv;

public class GenerateVideoManifestSegment$1
  implements Runnable
{
  public GenerateVideoManifestSegment$1(rkv paramrkv, RMVideoStateMgr paramRMVideoStateMgr) {}
  
  public void run()
  {
    try
    {
      ram.b("Q.qqstory.publish.edit.GenerateVideoManifestSegment", "Async, mVideoFileDir:%s, before call AVideoCodec.recordSubmit()", this.b.bdG);
      aniu.a().a().recordSubmit();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      ram.e("Q.qqstory.publish.edit.GenerateVideoManifestSegment", "Async, mVideoFileDir:%s, call AVideoCodec.recordSubmit() error = %s", new Object[] { this.b.bdG, localUnsatisfiedLinkError });
      synchronized (this.b.cb)
      {
        this.b.cb.set(true);
        this.b.cb.notifyAll();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.publish.GenerateVideoManifestSegment.1
 * JD-Core Version:    0.7.0.1
 */