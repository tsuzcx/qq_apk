package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.annotation.Public;

@Public
public class SpecifiedDrawable
  extends DrawableContainer
{
  private SpecificState mState;
  
  @Public
  public SpecifiedDrawable(Drawable paramDrawable)
  {
    this(paramDrawable, -1, -1);
  }
  
  @Public
  public SpecifiedDrawable(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    this.mState = new SpecificState(paramDrawable, this);
    this.mState.mWidth = paramInt1;
    this.mState.mHeight = paramInt2;
    setConstantState(this.mState);
  }
  
  private SpecifiedDrawable(SpecificState paramSpecificState, Resources paramResources)
  {
    this.mState = new SpecificState(paramSpecificState, this, paramResources);
    setConstantState(this.mState);
  }
  
  public int getIntrinsicHeight()
  {
    int i = this.mState.mHeight;
    if (i > 0) {
      return i;
    }
    return super.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    int i = this.mState.mWidth;
    if (i > 0) {
      return i;
    }
    return super.getIntrinsicWidth();
  }
  
  public int getOrginalWidth()
  {
    return super.getIntrinsicWidth();
  }
  
  public int getOriginalHeight()
  {
    return super.getIntrinsicHeight();
  }
  
  @Public
  public void resize(int paramInt1, int paramInt2)
  {
    if ((this.mState.mWidth != paramInt1) || (this.mState.mHeight != paramInt2))
    {
      this.mState.mWidth = paramInt1;
      this.mState.mHeight = paramInt2;
      invalidateSelf();
    }
  }
  
  static class SpecificState
    extends DrawableContainer.ContainerState
  {
    int mHeight;
    int mWidth;
    
    SpecificState(Drawable paramDrawable, DrawableContainer paramDrawableContainer)
    {
      super(paramDrawableContainer);
    }
    
    SpecificState(SpecificState paramSpecificState, DrawableContainer paramDrawableContainer, Resources paramResources)
    {
      super(paramDrawableContainer, paramResources);
      this.mWidth = paramSpecificState.mWidth;
      this.mHeight = paramSpecificState.mHeight;
    }
    
    public Drawable newDrawable()
    {
      return new SpecifiedDrawable(this, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.SpecifiedDrawable
 * JD-Core Version:    0.7.0.1
 */