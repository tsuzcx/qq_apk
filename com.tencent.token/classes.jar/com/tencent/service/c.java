package com.tencent.service;

import com.tencent.jni.FaceDetector;
import com.tencent.jni.FaceInfo;
import com.tencent.token.global.g;

public class c
  implements Runnable
{
  public long a = 0L;
  private FaceDetector b;
  private h c;
  private b d;
  private d e;
  private DetectType f;
  private long g = 0L;
  
  public c(d paramd, FaceDetector paramFaceDetector, h paramh, DetectType paramDetectType)
  {
    this.b = paramFaceDetector;
    this.e = paramd;
    this.c = paramh;
    this.f = paramDetectType;
    this.g = System.currentTimeMillis();
  }
  
  public void run()
  {
    System.gc();
    this.d = new b();
    this.d.d = new FaceInfo();
    int i;
    switch (1.a[this.f.ordinal()])
    {
    default: 
      return;
    case 2: 
      i = this.b.FaceValidate(this.d.d, this.c.a, this.c.b, this.c.c, this.c.d, this.c.e);
      break;
    case 1: 
      i = this.b.FaceRegister(this.d.d, this.c.a, this.c.b, this.c.c, this.c.d, this.c.e);
    }
    Object localObject = this.d;
    ((b)localObject).a = this.b;
    ((b)localObject).b = this.c;
    ((b)localObject).c = i;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("任务构建到结束时间: ");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - this.g);
    g.b(((StringBuilder)localObject).toString());
    this.e.a(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.c
 * JD-Core Version:    0.7.0.1
 */