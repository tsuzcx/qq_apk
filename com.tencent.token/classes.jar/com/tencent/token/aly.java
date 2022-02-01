package com.tencent.token;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

public class aly<T>
{
  private static final Interpolator f = new LinearInterpolator();
  public final T a;
  public final T b;
  final Interpolator c;
  public final float d;
  public Float e;
  private final ass g;
  private float h;
  private float i;
  
  final float a()
  {
    if (this.h == 1.4E-45F) {
      this.h = ((this.d - (float)this.g.h) / this.g.b());
    }
    return this.h;
  }
  
  final boolean a(float paramFloat)
  {
    return (paramFloat >= a()) && (paramFloat <= b());
  }
  
  final float b()
  {
    if (this.i == 1.4E-45F)
    {
      float f1;
      if (this.e == null) {
        f1 = 1.0F;
      } else {
        f1 = a() + (this.e.floatValue() - this.d) / this.g.b();
      }
      this.i = f1;
    }
    return this.i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Keyframe{startValue=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", endValue=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", startFrame=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", endFrame=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", interpolator=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aly
 * JD-Core Version:    0.7.0.1
 */