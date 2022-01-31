package com.tencent.mobileqq.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

public abstract class DrawableContainer
  extends Drawable
  implements Drawable.Callback
{
  private DrawableContainer.ContainerState jdField_a_of_type_ComTencentMobileqqWidgetDrawableContainer$ContainerState;
  private boolean jdField_a_of_type_Boolean;
  
  public Drawable a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetDrawableContainer$ContainerState.a;
  }
  
  public void a(DrawableContainer.ContainerState paramContainerState)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetDrawableContainer$ContainerState = paramContainerState;
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetDrawableContainer$ContainerState.a.draw(paramCanvas);
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.jdField_a_of_type_ComTencentMobileqqWidgetDrawableContainer$ContainerState.c | this.jdField_a_of_type_ComTencentMobileqqWidgetDrawableContainer$ContainerState.a.getChangingConfigurations();
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetDrawableContainer$ContainerState.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetDrawableContainer$ContainerState.c = getChangingConfigurations();
      return this.jdField_a_of_type_ComTencentMobileqqWidgetDrawableContainer$ContainerState;
    }
    return null;
  }
  
  public int getIntrinsicHeight()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetDrawableContainer$ContainerState.a.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetDrawableContainer$ContainerState.a.getIntrinsicWidth();
  }
  
  public int getOpacity()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetDrawableContainer$ContainerState.a.getOpacity();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetDrawableContainer$ContainerState.a.getPadding(paramRect);
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }
  
  public boolean isStateful()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetDrawableContainer$ContainerState.a.isStateful();
  }
  
  public Drawable mutate()
  {
    if ((!this.jdField_a_of_type_Boolean) && (super.mutate() == this))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetDrawableContainer$ContainerState.a.mutate();
      this.jdField_a_of_type_Boolean = true;
    }
    return this;
  }
  
  public void onBoundsChange(Rect paramRect)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetDrawableContainer$ContainerState.a.setBounds(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetDrawableContainer$ContainerState.a.setLevel(paramInt);
    invalidateSelf();
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqWidgetDrawableContainer$ContainerState.a.setState(paramArrayOfInt);
    onBoundsChange(getBounds());
    return bool;
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetDrawableContainer$ContainerState.a.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetDrawableContainer$ContainerState.a.setColorFilter(paramColorFilter);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetDrawableContainer$ContainerState.a.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DrawableContainer
 * JD-Core Version:    0.7.0.1
 */