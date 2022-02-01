package com.tencent.token;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public final class zr
  extends Animation
{
  private final float a;
  private final float b;
  private final float c;
  private final float d;
  private final float e;
  private final boolean f;
  private Camera g;
  
  public zr(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
    this.e = 310.0F;
    this.f = paramBoolean;
  }
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = this.a;
    float f2 = this.b;
    float f3 = this.c;
    float f4 = this.d;
    Camera localCamera = this.g;
    paramTransformation = paramTransformation.getMatrix();
    localCamera.save();
    if (this.f) {
      localCamera.translate(0.0F, 0.0F, this.e * paramFloat);
    } else {
      localCamera.translate(0.0F, 0.0F, this.e * (1.0F - paramFloat));
    }
    localCamera.rotateY(f1 + (f2 - f1) * paramFloat);
    localCamera.getMatrix(paramTransformation);
    localCamera.restore();
    paramTransformation.preTranslate(-f3, -f4);
    paramTransformation.postTranslate(f3, f4);
  }
  
  public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.g = new Camera();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.zr
 * JD-Core Version:    0.7.0.1
 */