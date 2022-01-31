package com.tencent.service;

import com.tencent.jni.FaceDetector;
import com.tencent.jni.FaceInfo;

public class h
  implements Runnable
{
  public long a = 0L;
  private FaceDetector b;
  private n c;
  private g d;
  private j e;
  private DetectType f;
  private long g = 0L;
  
  public h(j paramj, FaceDetector paramFaceDetector, n paramn, DetectType paramDetectType)
  {
    this.b = paramFaceDetector;
    this.e = paramj;
    this.c = paramn;
    this.f = paramDetectType;
    this.g = System.currentTimeMillis();
  }
  
  public void run()
  {
    System.gc();
    this.d = new g();
    this.d.d = new FaceInfo();
    switch (i.a[this.f.ordinal()])
    {
    default: 
      return;
    }
    for (int i = this.b.FaceRegister(this.d.d, this.c.a, this.c.b, this.c.c, this.c.d, this.c.e);; i = this.b.FaceValidate(this.d.d, this.c.a, this.c.b, this.c.c, this.c.d, this.c.e))
    {
      this.d.a = this.b;
      this.d.b = this.c;
      this.d.c = i;
      com.tencent.token.global.h.b("任务构建到结束时间: " + (System.currentTimeMillis() - this.g));
      this.e.a(this.d);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.h
 * JD-Core Version:    0.7.0.1
 */