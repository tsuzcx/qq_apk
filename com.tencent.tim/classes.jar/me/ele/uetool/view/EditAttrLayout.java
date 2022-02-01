package me.ele.uetool.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.ele.uetool.UETool;
import me.ele.uetool.base.DimenUtil;
import me.ele.uetool.base.Element;
import me.ele.uetool.dialog.AttrsDialog;
import me.ele.uetool.dialog.MultipleAttrsDialog;
import me.ele.uetool.util.ChangePool;

public class EditAttrLayout
  extends CollectViewsLayout
{
  private Paint areaPaint = new EditAttrLayout.2(this);
  private Context context;
  private GestureDetector detector;
  private AttrsDialog dialog;
  private List<Element> elementList = new ArrayList(16);
  GestureDetector.OnGestureListener gestureListener = new EditAttrLayout.1(this);
  private float lastX;
  private float lastY;
  private final int lineBorderDistance = DimenUtil.dip2px(5.0F);
  private IMode mode = new ShowMode();
  private final int moveUnit = DimenUtil.dip2px(1.0F);
  private OnDragListener onDragListener;
  private Element targetElement;
  
  public EditAttrLayout(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    this.detector = new GestureDetector(paramContext, this.gestureListener);
  }
  
  public EditAttrLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public EditAttrLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void findSimilarView(Element paramElement)
  {
    int i = this.elements.size() - 1;
    if (i >= 0) {
      if (isSimilar(paramElement, (Element)this.elements.get(i)))
      {
        Object localObject = ((Element)this.elements.get(i)).getView();
        if (!(localObject instanceof ViewGroup)) {
          break label143;
        }
        localObject = (ViewGroup)localObject;
        j = 0;
        label72:
        if (j >= ((ViewGroup)localObject).getChildCount()) {
          break label143;
        }
        if (!this.elementList.contains(((ViewGroup)localObject).getChildAt(j))) {
          break label112;
        }
      }
    }
    label143:
    for (int j = 1;; j = 0)
    {
      if (j != 0) {}
      for (;;)
      {
        i -= 1;
        break;
        label112:
        j += 1;
        break label72;
        this.elementList.add(this.elements.get(i));
      }
      return;
    }
  }
  
  public void clickAndShow(Element paramElement)
  {
    if (paramElement != null)
    {
      ChangePool.getInstance().addToPool(paramElement);
      this.elementList.clear();
      findSimilarView(paramElement);
      this.targetElement = paramElement;
      invalidate();
      if (this.dialog == null)
      {
        this.dialog = new AttrsDialog(getContext());
        AttrsDialog.setRefresh(new EditAttrLayout.3(this));
        this.dialog.setAttrDialogCallback(new EditAttrLayout.4(this));
        this.dialog.setTouchCallback(new EditAttrLayout.5(this));
        this.dialog.setOnDismissListener(new EditAttrLayout.6(this));
      }
      this.dialog.show(this.targetElement);
    }
  }
  
  public void dismissAttrsDialog()
  {
    if (this.dialog != null) {
      this.dialog.dismiss();
    }
  }
  
  public void findByViewAndShowDialog(View paramView)
  {
    clickAndShow(getTargetElementByView(paramView));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.targetElement = null;
    dismissAttrsDialog();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.targetElement != null)
    {
      this.targetElement.reset();
      paramCanvas.drawRect(this.targetElement.getRect(), this.areaPaint);
      this.mode.onDraw(paramCanvas);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((this.mode instanceof ShowMode)) || ((this.mode instanceof MultipleChosenMode))) {
      this.detector.onTouchEvent(paramMotionEvent);
    }
    for (;;)
    {
      return true;
      switch (paramMotionEvent.getAction())
      {
      default: 
        break;
      case 0: 
        this.lastX = paramMotionEvent.getX();
        this.lastY = paramMotionEvent.getY();
        break;
      case 1: 
        this.mode.triggerActionUp(paramMotionEvent);
        break;
      case 2: 
        this.mode.triggerActionMove(paramMotionEvent);
      }
    }
  }
  
  public void setOnDragListener(OnDragListener paramOnDragListener)
  {
    this.onDragListener = paramOnDragListener;
  }
  
  public static abstract interface IMode
  {
    public abstract void onDraw(Canvas paramCanvas);
    
    public abstract void triggerActionLong(MotionEvent paramMotionEvent);
    
    public abstract void triggerActionMove(MotionEvent paramMotionEvent);
    
    public abstract void triggerActionUp(MotionEvent paramMotionEvent);
  }
  
  class MoveMode
    implements EditAttrLayout.IMode
  {
    private static final int NOT_ADSORP = -1;
    private float DetachThreshold = 20.0F;
    private float Threshold = 10.0F;
    private List<Integer> adsorpPointX;
    private List<Integer> adsorpPointY;
    private float adsorpX = -1.0F;
    private int adsorpXPoint = -1;
    private float adsorpY = -1.0F;
    private int adsorpYPoint = -1;
    private ViewParent originParent;
    
    MoveMode()
    {
      init();
    }
    
    private void init()
    {
      this.adsorpPointX = new ArrayList(64);
      this.adsorpPointY = new ArrayList(64);
      Iterator localIterator = EditAttrLayout.this.elements.iterator();
      while (localIterator.hasNext())
      {
        Rect localRect = ((Element)localIterator.next()).getRect();
        this.adsorpPointX.add(Integer.valueOf(localRect.left));
        this.adsorpPointX.add(Integer.valueOf(localRect.right));
        this.adsorpPointX.add(Integer.valueOf(localRect.centerX()));
        this.adsorpPointY.add(Integer.valueOf(localRect.top));
        this.adsorpPointY.add(Integer.valueOf(localRect.bottom));
        this.adsorpPointY.add(Integer.valueOf(localRect.centerY()));
      }
      Collections.sort(this.adsorpPointX);
      Collections.sort(this.adsorpPointY);
    }
    
    public void getXY()
    {
      BaseLineView localBaseLineView = UETool.getInstance().getBaseLineView();
      if (localBaseLineView != null)
      {
        this.adsorpX = localBaseLineView.getLastX();
        this.adsorpY = localBaseLineView.getLastY();
        return;
      }
      this.adsorpY = -1.0F;
      this.adsorpX = -1.0F;
    }
    
    public void onDraw(Canvas paramCanvas)
    {
      getXY();
      Rect localRect1 = EditAttrLayout.this.targetElement.getRect();
      Rect localRect2 = EditAttrLayout.this.targetElement.getOriginRect();
      paramCanvas.drawRect(localRect2, EditAttrLayout.this.dashLinePaint);
      Object localObject = EditAttrLayout.this.targetElement.getParentElement();
      if (localObject != null)
      {
        localObject = ((Element)localObject).getRect();
        int i = localRect1.left + localRect1.width() / 2;
        int j = localRect1.top + localRect1.height() / 2;
        EditAttrLayout.this.drawLineWithText(paramCanvas, localRect1.left, j, ((Rect)localObject).left, j, DimenUtil.dip2px(2.0F));
        EditAttrLayout.this.drawLineWithText(paramCanvas, i, localRect1.top, i, ((Rect)localObject).top, DimenUtil.dip2px(2.0F));
        EditAttrLayout.this.drawLineWithText(paramCanvas, localRect1.right, j, ((Rect)localObject).right, j, DimenUtil.dip2px(2.0F));
        EditAttrLayout.this.drawLineWithText(paramCanvas, i, localRect1.bottom, i, ((Rect)localObject).bottom, DimenUtil.dip2px(2.0F));
      }
      if (EditAttrLayout.this.onDragListener != null) {
        EditAttrLayout.this.onDragListener.showOffset("Offset:\nx -> " + DimenUtil.px2dip(localRect1.left - localRect2.left, true) + " y -> " + DimenUtil.px2dip(localRect1.top - localRect2.top, true));
      }
    }
    
    public void triggerActionLong(MotionEvent paramMotionEvent) {}
    
    public void triggerActionMove(MotionEvent paramMotionEvent)
    {
      int j = 1;
      View localView;
      float f3;
      float f4;
      int k;
      int i;
      float f2;
      if (EditAttrLayout.this.targetElement != null)
      {
        localView = EditAttrLayout.this.targetElement.getView();
        int[] arrayOfInt = new int[2];
        f3 = paramMotionEvent.getX() - EditAttrLayout.this.lastX;
        f4 = paramMotionEvent.getY() - EditAttrLayout.this.lastY;
        if (UETool.getInstance().getBaseLineView() == null) {
          break label446;
        }
        localView.getLocationOnScreen(arrayOfInt);
        int m = arrayOfInt[0];
        k = arrayOfInt[1];
        if (Build.VERSION.SDK_INT > 19) {
          break label439;
        }
        i = k - DimenUtil.getStatusBarHeight();
        int n = localView.getWidth() + m;
        k += localView.getHeight();
        if ((Math.abs(this.adsorpY - i) > this.Threshold) || (Math.abs(f4) >= this.DetachThreshold)) {
          break label433;
        }
        f2 = this.adsorpY - i;
        label163:
        float f1 = f2;
        if (Math.abs(this.adsorpY - k) <= this.Threshold)
        {
          f1 = f2;
          if (Math.abs(f2) < this.DetachThreshold) {
            f1 = this.adsorpY - k;
          }
        }
        if ((Math.abs(this.adsorpX - m) > this.Threshold) || (Math.abs(f3) >= this.DetachThreshold)) {
          break label427;
        }
        f2 = this.adsorpX - m;
        label248:
        f4 = f1;
        f3 = f2;
        if (Math.abs(this.adsorpX - n) <= this.Threshold)
        {
          f4 = f1;
          f3 = f2;
          if (Math.abs(f2) < this.DetachThreshold)
          {
            f3 = this.adsorpX - n;
            f4 = f1;
          }
        }
      }
      label427:
      label433:
      label439:
      label446:
      for (;;)
      {
        if (Math.abs(f3) >= EditAttrLayout.this.moveUnit)
        {
          localView.setTranslationX(f3 + localView.getTranslationX());
          EditAttrLayout.access$002(EditAttrLayout.this, paramMotionEvent.getX());
        }
        for (i = 1;; i = 0)
        {
          if (Math.abs(f4) >= EditAttrLayout.this.moveUnit)
          {
            localView.setTranslationY(f4 + localView.getTranslationY());
            EditAttrLayout.access$102(EditAttrLayout.this, paramMotionEvent.getY());
            i = j;
          }
          for (;;)
          {
            if (i != 0)
            {
              EditAttrLayout.this.targetElement.reset();
              EditAttrLayout.this.invalidate();
            }
            return;
          }
        }
        f2 = f3;
        break label248;
        f2 = f4;
        break label163;
        i = k;
        break;
      }
    }
    
    public void triggerActionUp(MotionEvent paramMotionEvent) {}
  }
  
  class MultipleChosenMode
    implements EditAttrLayout.IMode
  {
    MultipleChosenMode() {}
    
    public void onDraw(Canvas paramCanvas)
    {
      Rect localRect = EditAttrLayout.this.targetElement.getRect();
      if (EditAttrLayout.this.elementList != null)
      {
        localObject = EditAttrLayout.this.elementList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          Element localElement = (Element)((Iterator)localObject).next();
          paramCanvas.drawRect(localElement.getRect(), EditAttrLayout.this.dashLinePaint);
          paramCanvas.drawRect(localElement.getRect(), EditAttrLayout.this.areaPaint);
        }
      }
      EditAttrLayout.this.drawLineWithText(paramCanvas, localRect.left, localRect.top - EditAttrLayout.this.lineBorderDistance, localRect.right, localRect.top - EditAttrLayout.this.lineBorderDistance);
      Object localObject = EditAttrLayout.this;
      int i = localRect.right;
      int j = EditAttrLayout.this.lineBorderDistance;
      int k = localRect.top;
      int m = localRect.right;
      ((EditAttrLayout)localObject).drawLineWithText(paramCanvas, j + i, k, EditAttrLayout.this.lineBorderDistance + m, localRect.bottom);
    }
    
    public void triggerActionLong(MotionEvent paramMotionEvent)
    {
      paramMotionEvent = EditAttrLayout.this.getTargetSimilarElement(EditAttrLayout.this.targetElement, paramMotionEvent.getX(), paramMotionEvent.getY());
      MultipleAttrsDialog localMultipleAttrsDialog = new MultipleAttrsDialog(EditAttrLayout.this.getContext());
      MultipleAttrsDialog.setRefresh(new EditAttrLayout.MultipleChosenMode.1(this));
      localMultipleAttrsDialog.setCallBack(new EditAttrLayout.MultipleChosenMode.2(this, localMultipleAttrsDialog));
      localMultipleAttrsDialog.show(paramMotionEvent, EditAttrLayout.this.elementList);
    }
    
    public void triggerActionMove(MotionEvent paramMotionEvent) {}
    
    public void triggerActionUp(MotionEvent paramMotionEvent)
    {
      paramMotionEvent = EditAttrLayout.this.getTargetSimilarElement(EditAttrLayout.this.targetElement, paramMotionEvent.getX(), paramMotionEvent.getY());
      if (paramMotionEvent != null)
      {
        if (!EditAttrLayout.this.elementList.contains(paramMotionEvent)) {
          break label65;
        }
        EditAttrLayout.this.elementList.remove(paramMotionEvent);
      }
      for (;;)
      {
        EditAttrLayout.this.invalidate();
        return;
        label65:
        EditAttrLayout.this.elementList.add(paramMotionEvent);
      }
    }
  }
  
  public static abstract interface OnDragListener
  {
    public abstract void showOffset(String paramString);
  }
  
  class ShowMode
    implements EditAttrLayout.IMode
  {
    ShowMode() {}
    
    public void onDraw(Canvas paramCanvas)
    {
      Rect localRect = EditAttrLayout.this.targetElement.getRect();
      if ((EditAttrLayout.this.targetElement.getView() instanceof TextView))
      {
        localObject = (TextView)EditAttrLayout.this.targetElement.getView();
        if (((TextView)localObject).getLineCount() <= 1)
        {
          Paint.FontMetrics localFontMetrics = ((TextView)localObject).getPaint().getFontMetrics();
          float f3 = localRect.top + (((TextView)localObject).getHeight() - (localFontMetrics.bottom - localFontMetrics.top)) / 2.0F;
          float f4 = localRect.bottom - (((TextView)localObject).getHeight() - (localFontMetrics.bottom - localFontMetrics.top)) / 2.0F;
          float f1 = localRect.left + ((TextView)localObject).getTotalPaddingLeft();
          float f2 = localRect.right - ((TextView)localObject).getTotalPaddingRight();
          paramCanvas.drawLine(f1, f3, f2, f3, EditAttrLayout.this.textPaint);
          paramCanvas.drawLine(f1, f4, f2, f4, EditAttrLayout.this.textPaint);
          paramCanvas.drawLine(f1, f4, f1, f3, EditAttrLayout.this.textPaint);
          paramCanvas.drawLine(f2, f4, f2, f3, EditAttrLayout.this.textPaint);
          f3 = localRect.top;
          f3 = (((TextView)localObject).getHeight() - localFontMetrics.bottom - localFontMetrics.top) / 2.0F + f3;
          paramCanvas.drawLine(f1, f3, f2, f3, EditAttrLayout.this.textPaint);
          f3 = localRect.top;
          f4 = (((TextView)localObject).getHeight() - localFontMetrics.bottom - localFontMetrics.top) / 2.0F;
          f3 = localFontMetrics.ascent * 3.0F / 4.0F + (f3 + f4);
          paramCanvas.drawLine(f1, f3, f2, f3, EditAttrLayout.this.textPaint);
        }
      }
      if (EditAttrLayout.this.elementList != null)
      {
        localObject = EditAttrLayout.this.elementList.iterator();
        while (((Iterator)localObject).hasNext()) {
          paramCanvas.drawRect(((Element)((Iterator)localObject).next()).getRect(), EditAttrLayout.this.dashLinePaint);
        }
      }
      EditAttrLayout.this.drawLineWithText(paramCanvas, localRect.left, localRect.top - EditAttrLayout.this.lineBorderDistance, localRect.right, localRect.top - EditAttrLayout.this.lineBorderDistance);
      Object localObject = EditAttrLayout.this;
      int i = localRect.right;
      int j = EditAttrLayout.this.lineBorderDistance;
      int k = localRect.top;
      int m = localRect.right;
      ((EditAttrLayout)localObject).drawLineWithText(paramCanvas, j + i, k, EditAttrLayout.this.lineBorderDistance + m, localRect.bottom);
    }
    
    public void triggerActionLong(MotionEvent paramMotionEvent) {}
    
    public void triggerActionMove(MotionEvent paramMotionEvent) {}
    
    public void triggerActionUp(MotionEvent paramMotionEvent)
    {
      paramMotionEvent = EditAttrLayout.this.getTargetElement(paramMotionEvent.getX(), paramMotionEvent.getY());
      EditAttrLayout.this.clickAndShow(paramMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.view.EditAttrLayout
 * JD-Core Version:    0.7.0.1
 */