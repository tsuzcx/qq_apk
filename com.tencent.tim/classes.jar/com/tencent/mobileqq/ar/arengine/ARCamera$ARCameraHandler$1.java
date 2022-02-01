package com.tencent.mobileqq.ar.arengine;

import adgw;
import adgw.a;

public class ARCamera$ARCameraHandler$1
  implements Runnable
{
  public ARCamera$ARCameraHandler$1(adgw.a parama) {}
  
  public void run()
  {
    adgw localadgw = this.a.this$0;
    int j = adgw.a(this.a.this$0) / 2;
    int k = adgw.b(this.a.this$0) / 2;
    int m = adgw.a(this.a.this$0);
    int n = adgw.b(this.a.this$0);
    if (!adgw.a(this.a.this$0)) {}
    for (int i = adgw.access$500();; i = adgw.a(this.a.this$0) * 3 / 4)
    {
      adgw.a(localadgw, j, k, m, n, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCamera.ARCameraHandler.1
 * JD-Core Version:    0.7.0.1
 */