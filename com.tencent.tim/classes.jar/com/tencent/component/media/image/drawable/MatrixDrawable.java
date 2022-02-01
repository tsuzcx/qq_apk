package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;

public class MatrixDrawable
  extends DrawableContainer
{
  private final Matrix mMatrix = new Matrix();
  private final MatrixState mState;
  
  public MatrixDrawable(Drawable paramDrawable)
  {
    this(paramDrawable, null);
  }
  
  public MatrixDrawable(Drawable paramDrawable, Matrix paramMatrix)
  {
    this.mState = new MatrixState(paramDrawable, this);
    setConstantState(this.mState);
    setMatrix(paramMatrix);
  }
  
  private MatrixDrawable(MatrixState paramMatrixState, Resources paramResources)
  {
    this.mState = new MatrixState(paramMatrixState, this, paramResources);
    setConstantState(this.mState);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mMatrix.isIdentity())
    {
      super.draw(paramCanvas);
      return;
    }
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    paramCanvas.concat(this.mMatrix);
    super.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  public Matrix getMatrix()
  {
    return this.mMatrix;
  }
  
  public void setMatrix(Matrix paramMatrix)
  {
    Matrix localMatrix = paramMatrix;
    if (paramMatrix != null)
    {
      localMatrix = paramMatrix;
      if (paramMatrix.isIdentity()) {
        localMatrix = null;
      }
    }
    if (((localMatrix == null) && (!this.mMatrix.isIdentity())) || ((localMatrix != null) && (!this.mMatrix.equals(localMatrix))))
    {
      this.mMatrix.set(localMatrix);
      invalidateSelf();
    }
  }
  
  static class MatrixState
    extends DrawableContainer.ContainerState
  {
    MatrixState(Drawable paramDrawable, DrawableContainer paramDrawableContainer)
    {
      super(paramDrawableContainer);
    }
    
    MatrixState(DrawableContainer.ContainerState paramContainerState, DrawableContainer paramDrawableContainer, Resources paramResources)
    {
      super(paramDrawableContainer, paramResources);
    }
    
    public Drawable newDrawable()
    {
      return new MatrixDrawable(this, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.MatrixDrawable
 * JD-Core Version:    0.7.0.1
 */