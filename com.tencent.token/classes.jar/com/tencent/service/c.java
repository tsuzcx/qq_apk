package com.tencent.service;

import com.tencent.jni.FaceDetector;
import com.tencent.jni.FaceInfo;
import com.tencent.token.global.g;

public class c
  implements Runnable
{
  public long a = 0L;
  private FaceDetector b;
  private f c;
  private b d;
  private d e;
  private DetectType f;
  private long g = 0L;
  
  public c(d paramd, FaceDetector paramFaceDetector, f paramf, DetectType paramDetectType)
  {
    this.b = paramFaceDetector;
    this.e = paramd;
    this.c = paramf;
    this.f = paramDetectType;
    this.g = System.currentTimeMillis();
  }
  
  public void run()
  {
    System.gc();
    this.d = new b();
    this.d.d = new FaceInfo();
    switch (1.a[this.f.ordinal()])
    {
    default: 
      return;
    }
    for (int i = this.b.FaceRegister(this.d.d, this.c.a, this.c.b, this.c.c, this.c.d, this.c.e);; i = this.b.FaceValidate(this.d.d, this.c.a, this.c.b, this.c.c, this.c.d, this.c.e))
    {
      this.d.a = this.b;
      this.d.b = this.c;
      this.d.c = i;
      g.b("任务构建到结束时间: " + (System.currentTimeMillis() - this.g));
      this.e.a(this.d);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.c
 * JD-Core Version:    0.7.0.1
 */