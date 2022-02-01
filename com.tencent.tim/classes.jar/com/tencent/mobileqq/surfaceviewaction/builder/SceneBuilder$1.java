package com.tencent.mobileqq.surfaceviewaction.builder;

import android.os.Handler;
import android.os.Looper;
import anxz;
import anyk;
import anyk.f;

public class SceneBuilder$1
  implements Runnable
{
  public SceneBuilder$1(anyk paramanyk, anxz paramanxz, anyk.f paramf) {}
  
  public void run()
  {
    String str = anyk.access$100(anyk.a(this.this$0) + "/scene.json");
    new Handler(Looper.getMainLooper()).post(new SceneBuilder.1.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.1
 * JD-Core Version:    0.7.0.1
 */