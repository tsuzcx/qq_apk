package com.tencent.mobileqq.activity.richmedia.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import anij;
import anij.b;
import anim;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraPreview;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import java.io.File;

public class CameraCover
  extends FrameLayout
{
  private View Ae;
  
  public CameraCover(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CameraCover(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CameraCover(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private Rect a(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    if (!paramRect1.contains(paramRect2)) {
      throw new IllegalArgumentException("CoverRect " + paramRect2 + " is outside ViewRect " + paramRect1);
    }
    Rect localRect = new Rect();
    switch (paramInt % 360)
    {
    default: 
      return localRect;
    case 0: 
      localRect.left = paramRect2.top;
      localRect.top = (paramRect1.width() - paramRect2.right);
      localRect.right = paramRect2.bottom;
      localRect.bottom = (paramRect1.width() - paramRect2.left);
      return localRect;
    case 90: 
      localRect.set(paramRect2);
      return localRect;
    case 180: 
      localRect.left = (paramRect1.height() - paramRect2.bottom);
      localRect.top = paramRect2.left;
      localRect.right = (paramRect1.height() - paramRect2.top);
      localRect.bottom = paramRect2.right;
      return localRect;
    }
    localRect.left = (paramRect1.width() - paramRect2.right);
    localRect.top = (paramRect1.height() - paramRect2.bottom);
    localRect.right = (paramRect1.width() - paramRect2.left);
    localRect.bottom = (paramRect1.height() - paramRect2.top);
    return localRect;
  }
  
  public Rect a(Rect paramRect, int paramInt)
  {
    Rect localRect2 = new Rect(0, 0, getRight() - getLeft(), getBottom() - getTop());
    Rect localRect1 = new Rect(0, 0, this.Ae.getWidth(), this.Ae.getHeight());
    int i = this.Ae.getLeft();
    int j = this.Ae.getTop();
    localRect2.offset(-i, -j);
    anij localanij;
    if (localRect1.equals(localRect2))
    {
      localanij = anij.a();
      localRect2 = a(paramInt, localRect1, localRect2);
      if (localanij.JE() % 180 != 90) {
        break label266;
      }
      paramInt = localRect1.height();
      label129:
      if (paramRect == null) {
        break label275;
      }
    }
    label266:
    label275:
    for (i = paramRect.width();; i = localanij.d().width)
    {
      float f = i / paramInt;
      localRect2.left = ((int)(localRect2.left * f));
      localRect2.top = ((int)(localRect2.top * f));
      localRect2.right = ((int)(localRect2.right * f));
      localRect2.bottom = ((int)(f * localRect2.bottom));
      return localRect2;
      if (localRect1.contains(localRect2)) {
        break;
      }
      if (localRect2.contains(localRect1))
      {
        localRect2.set(localRect1);
        break;
      }
      if (Rect.intersects(localRect1, localRect2))
      {
        localRect2.intersect(localRect1);
        break;
      }
      throw new IllegalArgumentException("Cover and Camera rect must have intersect rect!");
      paramInt = localRect1.width();
      break label129;
    }
  }
  
  public void a(File paramFile, a parama, int paramInt, boolean paramBoolean)
  {
    a(paramFile, parama, paramInt, paramBoolean, 0, -1, -1);
  }
  
  public void a(File paramFile, a parama, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = null;
    if (this.Ae == null) {}
    label97:
    label122:
    for (;;)
    {
      return;
      Rect localRect;
      if ((paramInt3 != -1) && (paramInt4 != -1))
      {
        localRect = new Rect(0, 0, paramInt3, paramInt4);
        if (!CameraPreview.class.isInstance(this.Ae)) {
          break label97;
        }
        localObject = ((CameraPreview)this.Ae).a;
      }
      for (;;)
      {
        if (localObject == null) {
          break label122;
        }
        ((PreviewContext)localObject).mCamera.a(paramFile, localRect, parama, paramInt1, paramBoolean, paramInt2, 0);
        return;
        localRect = a(null, paramInt1);
        break;
        if (CameraTextureView.class.isInstance(this.Ae)) {
          localObject = ((CameraTextureView)this.Ae).a;
        }
      }
    }
  }
  
  public void setCameraView(View paramView)
  {
    this.Ae = paramView;
  }
  
  public static abstract interface a
  {
    public abstract void AE(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.CameraCover
 * JD-Core Version:    0.7.0.1
 */