package com.tencent.service;

import com.tencent.jni.FaceDetector;
import com.tencent.jni.FaceInfo;
import com.tencent.token.global.e;

public final class b
  implements Runnable
{
  public long a = 0L;
  private FaceDetector b;
  private h c;
  private a d;
  private d e;
  private DetectType f;
  private long g = 0L;
  
  public b(d paramd, FaceDetector paramFaceDetector, h paramh, DetectType paramDetectType)
  {
    this.b = paramFaceDetector;
    this.e = paramd;
    this.c = paramh;
    this.f = paramDetectType;
    this.g = System.currentTimeMillis();
  }
  
  public final void run()
  {
    System.gc();
    this.d = new a();
    this.d.d = new FaceInfo();
    switch (c.a[this.f.ordinal()])
    {
    default: 
      return;
    }
    for (int i = this.b.FaceRegister(this.d.d, this.c.a, this.c.b, this.c.c, this.c.d, this.c.e, this.c.f);; i = this.b.FaceValidate(this.d.d, this.c.a, this.c.b, this.c.c, this.c.d, this.c.e, this.c.f))
    {
      this.d.a = this.b;
      this.d.b = this.c;
      this.d.c = i;
      e.b("任务构建到结束时间: " + (System.currentTimeMillis() - this.g));
      this.e.a(this.d);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.b
 * JD-Core Version:    0.7.0.1
 */