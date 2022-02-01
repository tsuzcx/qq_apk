package com.tencent.ttpic.openapi.util.youtu;

import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.log.LogUtils;

class VideoPreviewFaceOutlineDetector$2
  implements Runnable
{
  VideoPreviewFaceOutlineDetector$2(VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    BenchUtil.benchStart("only faceDetect");
    long l1 = 0L;
    if (BenchUtil.ENABLE_PERFORMANCE_RECORD) {
      l1 = System.currentTimeMillis();
    }
    if (this.this$0.doFaceDetect(this.val$rgba, this.val$w, this.val$h)) {
      VideoPreviewFaceOutlineDetector.access$002(this.this$0, this.val$phoneRotation);
    }
    if (BenchUtil.ENABLE_PERFORMANCE_RECORD)
    {
      long l2 = System.currentTimeMillis();
      LogUtils.e("PERFORMANCE_RECORD", "人脸追踪耗时： " + (l2 - l1) + " ms.");
    }
    BenchUtil.benchEnd("only faceDetect");
    VideoPreviewFaceOutlineDetector.access$102(this.this$0, false);
    VideoPreviewFaceOutlineDetector.access$202(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector.2
 * JD-Core Version:    0.7.0.1
 */