package com.facebook.stetho.inspector.elements.android;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewOverlay;

abstract class ViewHighlightOverlays
{
  static ViewHighlightOverlays newInstance()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return new ViewHighlightOverlaysJellybeanMR2();
    }
    return new NoOpViewHighlightOverlays(null);
  }
  
  abstract void highlightView(View paramView, int paramInt);
  
  abstract void removeHighlight(View paramView);
  
  static class NoOpViewHighlightOverlays
    extends ViewHighlightOverlays
  {
    void highlightView(View paramView, int paramInt) {}
    
    void removeHighlight(View paramView) {}
  }
  
  @TargetApi(18)
  static class ViewHighlightOverlaysJellybeanMR2
    extends ViewHighlightOverlays
  {
    private static final int MARGIN_OVERLAY_COLOR = -1426797922;
    private static final int PADDING_OVERLAY_COLOR = -1430332746;
    private final HighlightDrawable[] mHighlightDrawables = { this.mMainHighlightDrawable, new PaddingTopHighlightDrawable(), new PaddingBottomHighlightDrawable(), new PaddingRightHighlightDrawable(), new PaddingLeftHighlightDrawable(), new MarginTopHighlightDrawable(), new MarginBottomHighlightDrawable(), new MarginRightHighlightDrawable(), new MarginLeftHighlightDrawable() };
    private final MainHighlightDrawable mMainHighlightDrawable = new MainHighlightDrawable();
    
    void highlightView(View paramView, int paramInt)
    {
      this.mMainHighlightDrawable.setColor(paramInt);
      int i = this.mHighlightDrawables.length;
      paramInt = 0;
      while (paramInt < i)
      {
        HighlightDrawable localHighlightDrawable = this.mHighlightDrawables[paramInt];
        localHighlightDrawable.highlightView(paramView);
        paramView.getOverlay().add(localHighlightDrawable);
        paramInt += 1;
      }
    }
    
    void removeHighlight(View paramView)
    {
      HighlightDrawable[] arrayOfHighlightDrawable = this.mHighlightDrawables;
      int j = arrayOfHighlightDrawable.length;
      int i = 0;
      while (i < j)
      {
        HighlightDrawable localHighlightDrawable = arrayOfHighlightDrawable[i];
        paramView.getOverlay().remove(localHighlightDrawable);
        i += 1;
      }
    }
    
    static abstract class HighlightDrawable
      extends ColorDrawable
    {
      protected final Rect mMargins = new Rect();
      protected final Rect mPaddings = new Rect();
      
      public HighlightDrawable() {}
      
      HighlightDrawable(int paramInt)
      {
        super();
      }
      
      void highlightView(View paramView)
      {
        Object localObject = paramView.getLayoutParams();
        if ((localObject instanceof ViewGroup.MarginLayoutParams))
        {
          localObject = (ViewGroup.MarginLayoutParams)localObject;
          this.mMargins.left = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
          this.mMargins.top = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
          this.mMargins.right = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
        }
        for (this.mMargins.bottom = ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;; this.mMargins.bottom = 0)
        {
          this.mPaddings.left = paramView.getPaddingLeft();
          this.mPaddings.top = paramView.getPaddingTop();
          this.mPaddings.right = paramView.getPaddingRight();
          this.mPaddings.bottom = paramView.getPaddingBottom();
          return;
          this.mMargins.left = 0;
          this.mMargins.top = 0;
          this.mMargins.right = 0;
        }
      }
    }
    
    static class MainHighlightDrawable
      extends ViewHighlightOverlays.ViewHighlightOverlaysJellybeanMR2.HighlightDrawable
    {
      public void draw(Canvas paramCanvas)
      {
        Rect localRect = paramCanvas.getClipBounds();
        localRect.inset(-(this.mMargins.right + this.mMargins.left), -(this.mMargins.top + this.mMargins.bottom));
        paramCanvas.clipRect(localRect, Region.Op.REPLACE);
        super.draw(paramCanvas);
      }
      
      void highlightView(View paramView)
      {
        super.highlightView(paramView);
        setBounds(0, 0, paramView.getWidth(), paramView.getHeight());
      }
    }
    
    static class MarginBottomHighlightDrawable
      extends ViewHighlightOverlays.ViewHighlightOverlaysJellybeanMR2.HighlightDrawable
    {
      MarginBottomHighlightDrawable()
      {
        super();
      }
      
      public void draw(Canvas paramCanvas)
      {
        paramCanvas.translate(0.0F, this.mMargins.bottom + this.mMargins.top);
        super.draw(paramCanvas);
      }
      
      void highlightView(View paramView)
      {
        super.highlightView(paramView);
        setBounds(0, paramView.getHeight() - this.mMargins.bottom, paramView.getWidth(), paramView.getHeight());
      }
    }
    
    static class MarginLeftHighlightDrawable
      extends ViewHighlightOverlays.ViewHighlightOverlaysJellybeanMR2.HighlightDrawable
    {
      MarginLeftHighlightDrawable()
      {
        super();
      }
      
      public void draw(Canvas paramCanvas)
      {
        paramCanvas.translate(-(this.mMargins.left + this.mMargins.right), 0.0F);
        super.draw(paramCanvas);
      }
      
      void highlightView(View paramView)
      {
        super.highlightView(paramView);
        setBounds(0, 0, this.mMargins.left, paramView.getHeight() + this.mMargins.top + this.mMargins.bottom);
      }
    }
    
    static class MarginRightHighlightDrawable
      extends ViewHighlightOverlays.ViewHighlightOverlaysJellybeanMR2.HighlightDrawable
    {
      MarginRightHighlightDrawable()
      {
        super();
      }
      
      public void draw(Canvas paramCanvas)
      {
        paramCanvas.translate(this.mMargins.right, -(this.mMargins.top + this.mMargins.bottom));
        super.draw(paramCanvas);
      }
      
      void highlightView(View paramView)
      {
        super.highlightView(paramView);
        setBounds(paramView.getWidth() - this.mMargins.right, 0, paramView.getWidth(), paramView.getHeight() + this.mMargins.top + this.mMargins.bottom);
      }
    }
    
    static class MarginTopHighlightDrawable
      extends ViewHighlightOverlays.ViewHighlightOverlaysJellybeanMR2.HighlightDrawable
    {
      MarginTopHighlightDrawable()
      {
        super();
      }
      
      public void draw(Canvas paramCanvas)
      {
        paramCanvas.translate(0.0F, -this.mMargins.top);
        super.draw(paramCanvas);
      }
      
      void highlightView(View paramView)
      {
        super.highlightView(paramView);
        setBounds(0, 0, paramView.getWidth(), this.mMargins.top);
      }
    }
    
    static class PaddingBottomHighlightDrawable
      extends ViewHighlightOverlays.ViewHighlightOverlaysJellybeanMR2.HighlightDrawable
    {
      PaddingBottomHighlightDrawable()
      {
        super();
      }
      
      void highlightView(View paramView)
      {
        super.highlightView(paramView);
        setBounds(this.mPaddings.left, paramView.getHeight() - this.mPaddings.bottom, paramView.getWidth() - this.mPaddings.right, paramView.getHeight());
      }
    }
    
    static class PaddingLeftHighlightDrawable
      extends ViewHighlightOverlays.ViewHighlightOverlaysJellybeanMR2.HighlightDrawable
    {
      PaddingLeftHighlightDrawable()
      {
        super();
      }
      
      void highlightView(View paramView)
      {
        super.highlightView(paramView);
        setBounds(0, 0, this.mPaddings.left, paramView.getHeight());
      }
    }
    
    static class PaddingRightHighlightDrawable
      extends ViewHighlightOverlays.ViewHighlightOverlaysJellybeanMR2.HighlightDrawable
    {
      PaddingRightHighlightDrawable()
      {
        super();
      }
      
      void highlightView(View paramView)
      {
        super.highlightView(paramView);
        setBounds(paramView.getWidth() - this.mPaddings.right, 0, paramView.getWidth(), paramView.getHeight());
      }
    }
    
    static class PaddingTopHighlightDrawable
      extends ViewHighlightOverlays.ViewHighlightOverlaysJellybeanMR2.HighlightDrawable
    {
      PaddingTopHighlightDrawable()
      {
        super();
      }
      
      void highlightView(View paramView)
      {
        super.highlightView(paramView);
        setBounds(this.mPaddings.left, 0, paramView.getWidth() - this.mPaddings.right, this.mPaddings.top);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.android.ViewHighlightOverlays
 * JD-Core Version:    0.7.0.1
 */