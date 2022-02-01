package com.tencent.weseevideo.editor.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.tavsticker.core.ITAVStickerEventListener;
import com.tencent.tavsticker.core.TAVStickerEditView;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerLayerItem;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.model.TAVStickerOperationMode;
import com.tencent.tavsticker.model.TAVStickerTextItem;
import com.tencent.tavsticker.utils.ViewUtils;
import com.tencent.weseevideo.editor.sticker.StickerDrawingOperationMask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class WsStickerEditView
  extends TAVStickerEditView
{
  String ADJUST_TIME_TEXT = "调整时长";
  int CLICK_DURATION = 200;
  float DEFAULT_BORDER_STROKE_WIDTH = ViewUtils.dip2px(1.5F);
  float OPERATION_BUTTON_SCALE = 0.5F;
  float STICKER_CORNER_RADIUS = ViewUtils.dip2px(3.0F);
  private final String TAG = WsStickerEditView.class.getSimpleName();
  int TOUCH_SLOP = 16;
  private RectF adjustTimeBtnRect = new RectF();
  private Bitmap bmpAdjustTimeRange;
  private Bitmap bmpDelete;
  private Bitmap bmpEdit;
  private Bitmap bmpZoom;
  private Paint borderPaint = new Paint();
  private Paint btnPaint = new Paint();
  private int btnTextColor = Color.parseColor("#1E1E22");
  private Paint btnTextPaint = new Paint();
  private int clickPadding = ViewUtils.dip2px(5.0F);
  private RectF deleteBtnRect = new RectF();
  private int drawMask = 63;
  private RectF editBtnRect = new RectF();
  boolean isStickerSelected = false;
  private boolean isStickerTouching = false;
  private OnBtnTouchListener onBtnTouchListener = null;
  private TAVStickerOperationMode operationMode = TAVStickerOperationMode.OP_NONE;
  private RectF stickerBorderRect = new RectF();
  private OnStickerEditButtonClickListener stickerEditButtonClickListener = null;
  private StickerEditViewIconConfig stickerEditViewIconConfig;
  private Matrix stickerMatrix = new Matrix();
  private RectF zoomBtnRect = new RectF();
  
  public WsStickerEditView(Context paramContext, TAVSticker paramTAVSticker, StickerEditViewIconConfig paramStickerEditViewIconConfig)
  {
    super(paramContext, paramTAVSticker);
    this.stickerEditViewIconConfig = paramStickerEditViewIconConfig;
    init();
  }
  
  private void drawAdjustTimeBtn(Canvas paramCanvas)
  {
    paramCanvas.save();
    Object localObject = this.vertexPoints;
    if ((localObject != null) && (localObject.length >= 4))
    {
      float f1 = localObject[3].x;
      float f2 = localObject[3].y;
      paramCanvas.rotate(getSticker().getRotate(), f1, f2);
      paramCanvas.scale(this.OPERATION_BUTTON_SCALE, this.OPERATION_BUTTON_SCALE, f1, f2);
      localObject = new Rect(0, 0, this.bmpAdjustTimeRange.getWidth(), this.bmpAdjustTimeRange.getHeight());
      this.adjustTimeBtnRect = new RectF(f1 - this.bmpAdjustTimeRange.getWidth(), f2 - this.bmpAdjustTimeRange.getHeight(), f1 + this.bmpAdjustTimeRange.getWidth(), f2 + this.bmpAdjustTimeRange.getHeight());
      paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
      paramCanvas.drawBitmap(this.bmpAdjustTimeRange, (Rect)localObject, this.adjustTimeBtnRect, null);
    }
    paramCanvas.getMatrix().mapRect(this.adjustTimeBtnRect);
    paramCanvas.restore();
  }
  
  private void drawBorder(Canvas paramCanvas)
  {
    PointF[] arrayOfPointF = getOriginalVertexPoints();
    if (arrayOfPointF == null) {}
    while ((arrayOfPointF == null) || (arrayOfPointF.length < 4)) {
      return;
    }
    paramCanvas.save();
    this.stickerMatrix.reset();
    this.stickerMatrix.postTranslate(this.centerX - this.originalCenterX, this.centerY - this.originalCenterY);
    this.stickerMatrix.postRotate(getSticker().getRotate(), this.centerX, this.centerY);
    this.stickerMatrix.postScale(getSticker().getScale(), getSticker().getScale(), this.centerX, this.centerY);
    paramCanvas.concat(this.stickerMatrix);
    this.stickerBorderRect.set(arrayOfPointF[0].x, arrayOfPointF[0].y, arrayOfPointF[2].x, arrayOfPointF[3].y);
    updateBorderPaint();
    paramCanvas.drawRoundRect(this.stickerBorderRect, this.STICKER_CORNER_RADIUS, this.STICKER_CORNER_RADIUS, this.borderPaint);
    paramCanvas.restore();
  }
  
  private void drawDeleteBtn(Canvas paramCanvas)
  {
    paramCanvas.save();
    Object localObject = this.vertexPoints;
    if ((localObject != null) && (localObject.length >= 4))
    {
      float f1 = localObject[1].x;
      float f2 = localObject[1].y;
      paramCanvas.rotate(getSticker().getRotate(), f1, f2);
      paramCanvas.scale(this.OPERATION_BUTTON_SCALE, this.OPERATION_BUTTON_SCALE, f1, f2);
      localObject = new Rect(0, 0, this.bmpDelete.getWidth(), this.bmpDelete.getHeight());
      this.deleteBtnRect = new RectF(f1 - this.bmpDelete.getWidth(), f2 - this.bmpDelete.getHeight(), f1 + this.bmpDelete.getWidth(), f2 + this.bmpDelete.getHeight());
      paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
      paramCanvas.drawBitmap(this.bmpDelete, (Rect)localObject, this.deleteBtnRect, null);
    }
    paramCanvas.getMatrix().mapRect(this.deleteBtnRect);
    paramCanvas.restore();
  }
  
  private void drawEditBtn(Canvas paramCanvas)
  {
    paramCanvas.save();
    Object localObject = this.vertexPoints;
    if ((localObject != null) && (localObject.length >= 4))
    {
      float f1 = localObject[0].x;
      float f2 = localObject[0].y;
      paramCanvas.rotate(getSticker().getRotate(), f1, f2);
      paramCanvas.scale(this.OPERATION_BUTTON_SCALE, this.OPERATION_BUTTON_SCALE, f1, f2);
      localObject = new Rect(0, 0, this.bmpEdit.getWidth(), this.bmpEdit.getHeight());
      this.editBtnRect = new RectF(f1 - this.bmpEdit.getWidth(), f2 - this.bmpEdit.getHeight(), f1 + this.bmpEdit.getWidth(), f2 + this.bmpEdit.getHeight());
      paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
      paramCanvas.drawBitmap(this.bmpEdit, (Rect)localObject, this.editBtnRect, null);
    }
    paramCanvas.getMatrix().mapRect(this.editBtnRect);
    paramCanvas.restore();
  }
  
  private void drawZoomBtn(Canvas paramCanvas)
  {
    paramCanvas.save();
    Object localObject = this.vertexPoints;
    if ((localObject != null) && (localObject.length >= 4))
    {
      float f1 = localObject[2].x;
      float f2 = localObject[2].y;
      paramCanvas.rotate(getSticker().getRotate(), f1, f2);
      paramCanvas.scale(this.OPERATION_BUTTON_SCALE, this.OPERATION_BUTTON_SCALE, f1, f2);
      localObject = new Rect(0, 0, this.bmpZoom.getWidth(), this.bmpZoom.getHeight());
      this.zoomBtnRect = new RectF(f1 - this.bmpZoom.getWidth(), f2 - this.bmpZoom.getHeight(), f1 + this.bmpZoom.getWidth(), f2 + this.bmpZoom.getHeight());
      setSingleZoomRotateRect(this.zoomBtnRect);
      paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
      paramCanvas.drawBitmap(this.bmpZoom, (Rect)localObject, this.zoomBtnRect, null);
    }
    paramCanvas.getMatrix().mapRect(this.zoomBtnRect);
    paramCanvas.restore();
  }
  
  private void init()
  {
    if ((this.stickerEditViewIconConfig != null) && (this.stickerEditViewIconConfig.getDeleteIconResId() != -1)) {
      this.bmpDelete = BitmapFactory.decodeResource(getResources(), this.stickerEditViewIconConfig.getDeleteIconResId());
    }
    if ((this.stickerEditViewIconConfig != null) && (this.stickerEditViewIconConfig.getZoomIconResId() != -1)) {
      this.bmpZoom = BitmapFactory.decodeResource(getResources(), this.stickerEditViewIconConfig.getZoomIconResId());
    }
    if ((this.stickerEditViewIconConfig != null) && (this.stickerEditViewIconConfig.getEditIconResId() != -1)) {
      this.bmpEdit = BitmapFactory.decodeResource(getResources(), this.stickerEditViewIconConfig.getEditIconResId());
    }
    if ((this.stickerEditViewIconConfig != null) && (this.stickerEditViewIconConfig.getAdjustTimeRangeIconResId() != -1)) {
      this.bmpAdjustTimeRange = BitmapFactory.decodeResource(getResources(), this.stickerEditViewIconConfig.getAdjustTimeRangeIconResId());
    }
    this.btnPaint.setAntiAlias(true);
    this.btnPaint.setColor(-1);
    this.btnPaint.setStrokeWidth(1.0F);
    this.borderPaint.setAntiAlias(true);
    this.borderPaint.setColor(-1);
    this.borderPaint.setStrokeWidth(this.DEFAULT_BORDER_STROKE_WIDTH);
    this.borderPaint.setStyle(Paint.Style.STROKE);
    this.borderPaint.setShadowLayer(0.5F, 0.5F, 0.5F, -7829368);
    this.btnTextPaint.setAntiAlias(true);
    this.btnTextPaint.setColor(this.btnTextColor);
    this.btnTextPaint.setTextSize(ViewUtils.dip2px(24.0F));
    this.btnTextPaint.setTextAlign(Paint.Align.CENTER);
    this.btnTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
    this.onBtnTouchListener = new OnBtnTouchListener(null);
    addOnTouchListener(this.onBtnTouchListener);
    initStickerEventListener();
    if (getSticker().getMode() == TAVStickerMode.ACTIVE) {
      this.isStickerSelected = true;
    }
  }
  
  private void initStickerEventListener()
  {
    super.setOnStickerEventListener(new WsStickerEditView.1(this));
  }
  
  private boolean isTouchAdjustTimeBtn(int paramInt1, int paramInt2)
  {
    return (this.adjustTimeBtnRect.left < this.adjustTimeBtnRect.right) && (this.adjustTimeBtnRect.top < this.adjustTimeBtnRect.bottom) && (paramInt1 >= this.adjustTimeBtnRect.left - this.clickPadding) && (paramInt1 < this.adjustTimeBtnRect.right + this.clickPadding) && (paramInt2 >= this.adjustTimeBtnRect.top - this.clickPadding) && (paramInt2 < this.adjustTimeBtnRect.bottom + this.clickPadding);
  }
  
  private boolean isTouchDeleteBtn(int paramInt1, int paramInt2)
  {
    return this.deleteBtnRect.contains(paramInt1, paramInt2);
  }
  
  private boolean isTouchEditBtn(float paramFloat1, float paramFloat2)
  {
    return this.editBtnRect.contains(paramFloat1, paramFloat2);
  }
  
  private void updateBorderPaint()
  {
    float f = getSticker().getScale();
    if (0.0F != f) {
      this.borderPaint.setStrokeWidth(this.DEFAULT_BORDER_STROKE_WIDTH / f);
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (TAVStickerOperationMode.OP_NONE != this.operationMode) {}
    do
    {
      do
      {
        return;
      } while ((paramCanvas == null) || (!this.isStickerSelected));
      if (StickerDrawingOperationMask.isDrawBorder(this.drawMask)) {
        drawBorder(paramCanvas);
      }
      if ((StickerDrawingOperationMask.isDrawLeftTop(this.drawMask)) && (BitmapUtil.isValidBitmap(this.bmpDelete))) {
        drawDeleteBtn(paramCanvas);
      }
      if ((StickerDrawingOperationMask.isDrawRightBottom(this.drawMask)) && (BitmapUtil.isValidBitmap(this.bmpZoom))) {
        drawZoomBtn(paramCanvas);
      }
      if ((StickerDrawingOperationMask.isDrawLeftBottom(this.drawMask)) && (BitmapUtil.isValidBitmap(this.bmpAdjustTimeRange))) {
        drawAdjustTimeBtn(paramCanvas);
      }
    } while ((!StickerDrawingOperationMask.isDrawRightTop(this.drawMask)) || (!BitmapUtil.isValidBitmap(this.bmpEdit)));
    drawEditBtn(paramCanvas);
  }
  
  public boolean isDrawGuideLine()
  {
    return StickerDrawingOperationMask.isDrawGuideLine(this.drawMask);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.operationMode = TAVStickerOperationMode.OP_NONE;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.isStickerSelected = false;
    this.operationMode = TAVStickerOperationMode.OP_NONE;
  }
  
  @NotNull
  public PointF positionInterceptor(float paramFloat1, float paramFloat2)
  {
    PointF localPointF = new PointF(paramFloat1, paramFloat2);
    if (Math.abs(this.stickerWidth / 2.0F + paramFloat1 - getWidth() / 2.0F) < WsStickerContentView.DRAG_ADSORPTION_THRESHOLD) {
      localPointF.x = (getWidth() / 2.0F - this.stickerWidth / 2.0F);
    }
    if (Math.abs(this.stickerHeight / 2.0F + paramFloat2 - getHeight() / 2.0F) < WsStickerContentView.DRAG_ADSORPTION_THRESHOLD) {
      localPointF.y = (getHeight() / 2.0F - this.stickerHeight / 2.0F);
    }
    return localPointF;
  }
  
  public float rotateInterceptor(float paramFloat)
  {
    float f;
    if (Math.abs(paramFloat - 0.0F) < 2.0F) {
      f = 0.0F;
    }
    do
    {
      return f;
      if (Math.abs(paramFloat - 45.0F) <= 2.0F) {
        return 45.0F;
      }
      if (Math.abs(paramFloat - 90.0F) <= 2.0F) {
        return 90.0F;
      }
      if (Math.abs(paramFloat - 135.0F) <= 2.0F) {
        return 135.0F;
      }
      if (Math.abs(paramFloat - 180.0F) <= 2.0F) {
        return 180.0F;
      }
      if (Math.abs(paramFloat - 225.0F) <= 2.0F) {
        return 225.0F;
      }
      if (Math.abs(paramFloat - 270.0F) <= 2.0F) {
        return 270.0F;
      }
      if (Math.abs(paramFloat - 315.0F) <= 2.0F) {
        return 315.0F;
      }
      f = paramFloat;
    } while (Math.abs(paramFloat - 360.0F) > 2.0F);
    return 0.0F;
  }
  
  public void setDrawingOperationMask(int paramInt)
  {
    this.drawMask = paramInt;
    postInvalidate();
  }
  
  public void setOnStickerEditButtonClickListener(OnStickerEditButtonClickListener paramOnStickerEditButtonClickListener)
  {
    this.stickerEditButtonClickListener = paramOnStickerEditButtonClickListener;
  }
  
  public void setOnStickerEventListener(ITAVStickerEventListener paramITAVStickerEventListener) {}
  
  class OnBtnTouchListener
    implements View.OnTouchListener
  {
    private Point downPoint = new Point();
    private boolean isClickAdjustTime = false;
    private boolean isClickDelete = false;
    private boolean isClickEdit = false;
    
    private OnBtnTouchListener() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if ((!WsStickerEditView.this.getSticker().isEditable()) || (!WsStickerEditView.this.isStickerSelected)) {}
      do
      {
        do
        {
          int i;
          int j;
          do
          {
            do
            {
              return false;
              i = (int)paramMotionEvent.getX();
              j = (int)paramMotionEvent.getY();
            } while ((WsStickerEditView.this.isStickerTouching) || (TAVStickerMode.ACTIVE != WsStickerEditView.this.getMode()));
            switch (paramMotionEvent.getAction())
            {
            default: 
              return false;
            case 0: 
              this.isClickAdjustTime = false;
              this.isClickDelete = false;
              this.downPoint.set(i, j);
              if ((WsStickerEditView.this.isTouchAdjustTimeBtn(i, j)) && (StickerDrawingOperationMask.isDrawLeftBottom(WsStickerEditView.this.drawMask)))
              {
                this.isClickAdjustTime = true;
                return true;
              }
              if ((WsStickerEditView.this.isTouchDeleteBtn(i, j)) && (StickerDrawingOperationMask.isDrawLeftTop(WsStickerEditView.this.drawMask)))
              {
                this.isClickDelete = true;
                return true;
              }
              break;
            }
          } while ((!WsStickerEditView.this.isTouchEditBtn(paramMotionEvent.getX(), paramMotionEvent.getY())) || (!StickerDrawingOperationMask.isDrawRightTop(WsStickerEditView.this.drawMask)));
          this.isClickEdit = true;
          return true;
          if ((Math.abs(i - this.downPoint.x) > WsStickerEditView.this.TOUCH_SLOP) || (Math.abs(j - this.downPoint.y) > WsStickerEditView.this.TOUCH_SLOP))
          {
            this.isClickAdjustTime = false;
            this.isClickDelete = false;
            this.isClickEdit = false;
            return false;
          }
          return true;
        } while (Math.abs(paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime()) >= WsStickerEditView.this.CLICK_DURATION);
        if (this.isClickAdjustTime)
        {
          if (WsStickerEditView.this.stickerEditButtonClickListener != null) {
            WsStickerEditView.this.stickerEditButtonClickListener.onAdjustTimeClick(WsStickerEditView.this.getSticker());
          }
          return true;
        }
        if (this.isClickDelete)
        {
          if (WsStickerEditView.this.stickerEditButtonClickListener != null) {
            WsStickerEditView.this.stickerEditButtonClickListener.onDeleteClick(WsStickerEditView.this.getSticker());
          }
          return true;
        }
      } while (!this.isClickEdit);
      paramView = new ArrayList();
      if (WsStickerEditView.this.getSticker().getStickerTextItems() != null)
      {
        paramMotionEvent = WsStickerEditView.this.getSticker().getStickerTextItems().iterator();
        while (paramMotionEvent.hasNext())
        {
          TAVStickerTextItem localTAVStickerTextItem = (TAVStickerTextItem)paramMotionEvent.next();
          if (localTAVStickerTextItem.getLayerType() == 3) {
            paramView.add(localTAVStickerTextItem);
          }
        }
      }
      if (WsStickerEditView.this.stickerEditButtonClickListener != null) {
        WsStickerEditView.this.stickerEditButtonClickListener.onEditClick(WsStickerEditView.this.getSticker(), paramView);
      }
      return true;
    }
  }
  
  public static abstract interface OnStickerEditButtonClickListener
  {
    public abstract void onAdjustTimeClick(TAVSticker paramTAVSticker);
    
    public abstract void onDeleteClick(TAVSticker paramTAVSticker);
    
    public abstract void onEditClick(TAVSticker paramTAVSticker, List<TAVStickerLayerItem> paramList);
    
    public abstract void onStickerClick(TAVSticker paramTAVSticker);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.view.WsStickerEditView
 * JD-Core Version:    0.7.0.1
 */