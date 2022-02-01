package com.tencent.token;

import com.tencent.jni.FaceDetector;
import com.tencent.jni.FaceInfo;
import com.tencent.service.DetectType;

public final class ry
  implements Runnable
{
  public long a = 0L;
  private FaceDetector b;
  private sd c;
  private rx d;
  private rz e;
  private DetectType f;
  private long g = 0L;
  
  public ry(rz paramrz, FaceDetector paramFaceDetector, sd paramsd, DetectType paramDetectType)
  {
    this.b = paramFaceDetector;
    this.e = paramrz;
    this.c = paramsd;
    this.f = paramDetectType;
    this.g = System.currentTimeMillis();
  }
  
  public final void run()
  {
    System.gc();
    this.d = new rx();
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
    ((rx)localObject).a = this.b;
    ((rx)localObject).b = this.c;
    ((rx)localObject).c = i;
    localObject = new StringBuilder("任务构建到结束时间: ");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - this.g);
    xv.b(((StringBuilder)localObject).toString());
    this.e.a(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ry
 * JD-Core Version:    0.7.0.1
 */