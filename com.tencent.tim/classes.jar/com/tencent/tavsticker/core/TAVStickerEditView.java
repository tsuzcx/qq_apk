package com.tencent.tavsticker.core;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerEditViewEventType;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.model.TAVStickerMoveLimit;
import com.tencent.tavsticker.model.TAVStickerOperationMode;
import com.tencent.tavsticker.utils.RectUtil;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGLayer;
import org.libpag.PAGText;
import org.libpag.PAGView;

public class TAVStickerEditView
  extends FrameLayout
  implements ITAVStickerRenderer
{
  public static final String TAG = TAVStickerEditView.class.getSimpleName();
  private Paint borderPaint = null;
  protected float centerX = 0.0F;
  protected float centerY = 0.0F;
  private Region clipRegion = new Region();
  private Context context = null;
  private PointF convertPoint = new PointF();
  private float correctedOriginalCenterX = 0.0F;
  private float correctedOriginalCenterY = 0.0F;
  private boolean isDrawMovieLimitRect = false;
  private boolean isFirstDraw = true;
  private boolean isNeedInitLocation = true;
  private boolean isShowDefaultBorder = true;
  protected int mEventType = 15;
  private TavStickerTouchListener mStickerTouchListener = null;
  private List<View.OnTouchListener> mTouchListeners = new ArrayList();
  private TAVStickerMode mode = TAVStickerMode.DEFAULT;
  private int moveRegionHeight = 0;
  private int moveRegionWidth = 0;
  private int moveStartOffsetX = 0;
  private int moveStartOffsetY = 0;
  private Paint movieRectPaint = null;
  protected float originalCenterX = 0.0F;
  protected float originalCenterY = 0.0F;
  private PointF[] originalVertexPoints = { new PointF(), new PointF(), new PointF(), new PointF() };
  private PAGView pagView = null;
  private Path path = new Path();
  private float positionX = 0.0F;
  private float positionY = 0.0F;
  private RectF rectF = new RectF();
  private Region region = new Region();
  private float rotate = 0.0F;
  private float scale = 1.0F;
  private float scaleMax = 0.0F;
  private float scaleMin = 0.0F;
  private RectF singleZoomRotateRect = null;
  private TAVSticker sticker = null;
  private int stickerContainerHeight = 0;
  private int stickerContainerWidth = 0;
  private ITAVStickerEventListener stickerEventListener = null;
  protected int stickerHeight = 0;
  protected Rect stickerMoveLimitRect = null;
  protected int stickerWidth = 0;
  protected PointF[] vertexPoints = { new PointF(), new PointF(), new PointF(), new PointF() };
  
  public TAVStickerEditView(@NonNull Context paramContext, @NonNull TAVSticker paramTAVSticker)
  {
    super(paramContext);
    if ((paramContext == null) || (paramTAVSticker == null)) {
      throw new IllegalArgumentException("<init> can not initialization TAVStickerEditView, parameter 'context' and 'sticker' must not is null!");
    }
    this.context = paramContext;
    this.sticker = paramTAVSticker;
    init();
  }
  
  private void adjustLocation(TAVStickerOperationMode paramTAVStickerOperationMode)
  {
    float f2 = 0.5F;
    updateVertexPoints();
    this.centerX = TAVStickerUtil.getMiddlePoint(this.vertexPoints[0], this.vertexPoints[2]).x;
    this.centerY = TAVStickerUtil.getMiddlePoint(this.vertexPoints[0], this.vertexPoints[2]).y;
    handleMoveLimit();
    if (this.stickerContainerWidth != 0) {}
    for (float f1 = this.centerX / this.stickerContainerWidth;; f1 = 0.5F)
    {
      if (this.stickerContainerHeight != 0) {
        f2 = this.centerY / this.stickerContainerHeight;
      }
      this.sticker.setCenterX(f1).setCenterY(f2).setScale(this.scale).setRotate(this.rotate);
      if (this.stickerEventListener != null) {
        this.stickerEventListener.onDataChanged(this.sticker, paramTAVStickerOperationMode, this.centerX, this.centerY, this.scale, this.rotate);
      }
      return;
    }
  }
  
  private PointF convertCoordinate(float paramFloat1, float paramFloat2)
  {
    if (this.convertPoint == null) {
      this.convertPoint = new PointF();
    }
    int i = getWidth();
    int j = getHeight();
    float f3 = i / 2.0F;
    float f1 = j / 2.0F;
    float f4 = this.correctedOriginalCenterX;
    float f2 = this.correctedOriginalCenterY;
    paramFloat1 = f3 - f4 + paramFloat1;
    paramFloat2 = f1 - f2 + paramFloat2;
    if ((i > 0) && (j > 0) && (this.pagView != null))
    {
      f3 = this.centerX;
      f4 = this.originalCenterX;
      f1 = this.centerY;
      f2 = this.originalCenterY;
      paramFloat1 = (paramFloat1 - (f3 - f4)) / i;
      f3 = this.pagView.getWidth();
      paramFloat2 = (paramFloat2 - (f1 - f2)) / j;
      f1 = this.pagView.getHeight();
      this.convertPoint.set(paramFloat1 * f3, paramFloat2 * f1);
      return this.convertPoint;
    }
    this.convertPoint.set(paramFloat1, paramFloat2);
    return this.convertPoint;
  }
  
  private float getPositionX()
  {
    if (this.pagView != null) {
      return this.pagView.getTranslationX();
    }
    return 0.0F;
  }
  
  private float getPositionY()
  {
    if (this.pagView != null) {
      return this.pagView.getTranslationY();
    }
    return 0.0F;
  }
  
  private void handleMoveLimit()
  {
    float f3 = this.centerX;
    float f5 = this.centerY;
    float f7;
    float f8;
    float f9;
    float f10;
    float f2;
    if (TAVStickerMoveLimit.LIMIT_VERTEX == this.sticker.getStickerMoveLimit())
    {
      f7 = TAVStickerUtil.getMinXBy4Point(this.vertexPoints[0], this.vertexPoints[1], this.vertexPoints[2], this.vertexPoints[3]);
      f8 = TAVStickerUtil.getMaxXBy4Point(this.vertexPoints[0], this.vertexPoints[1], this.vertexPoints[2], this.vertexPoints[3]);
      f9 = TAVStickerUtil.getMinYBy4Point(this.vertexPoints[0], this.vertexPoints[1], this.vertexPoints[2], this.vertexPoints[3]);
      f10 = TAVStickerUtil.getMaxYBy4Point(this.vertexPoints[0], this.vertexPoints[1], this.vertexPoints[2], this.vertexPoints[3]);
      if (f7 >= this.moveStartOffsetX) {
        break label706;
      }
      f2 = this.moveStartOffsetX - f7;
      f3 += f2;
    }
    for (;;)
    {
      float f1 = f3;
      if (f8 > this.moveRegionWidth + this.moveStartOffsetX)
      {
        f2 = this.moveRegionWidth + this.moveStartOffsetX - f8;
        f1 = f3 + f2;
      }
      float f4;
      if (f9 < this.moveStartOffsetY)
      {
        f4 = this.moveStartOffsetY - f9;
        f5 += f4;
      }
      for (;;)
      {
        f3 = f5;
        if (f10 > this.moveRegionHeight + this.moveStartOffsetY)
        {
          f4 = this.moveRegionHeight + this.moveStartOffsetY - f10;
          f3 = f5 + f4;
        }
        float f6 = f1;
        f5 = f2;
        if (f7 < this.moveStartOffsetX)
        {
          f6 = f1;
          f5 = f2;
          if (f8 > this.moveRegionWidth + this.moveStartOffsetX)
          {
            f6 = f1 + 0.0F;
            f5 = 0.0F;
          }
        }
        f7 = f6;
        f8 = f5;
        f1 = f3;
        f2 = f4;
        if (f9 < this.moveStartOffsetY)
        {
          f7 = f6;
          f8 = f5;
          f1 = f3;
          f2 = f4;
          if (f10 > this.moveRegionHeight + this.moveStartOffsetY)
          {
            f1 = f3 + 0.0F;
            f2 = 0.0F;
            f8 = f5;
            f7 = f6;
          }
        }
        this.centerX = f7;
        this.centerY = f1;
        if ((Math.abs(f8) > 0.0F) || (Math.abs(f2) > 0.0F))
        {
          setPosition(getPositionX() + f8, getPositionY() + f2);
          updateVertexPoints();
        }
        return;
        if (f3 < this.moveStartOffsetX)
        {
          f2 = this.moveStartOffsetX - f3;
          f3 = this.moveStartOffsetX + 0;
        }
        for (;;)
        {
          f1 = f3;
          if (f3 > this.moveRegionWidth + this.moveStartOffsetX)
          {
            f2 = this.moveRegionWidth + this.moveStartOffsetX - f3;
            f1 = this.moveRegionWidth + this.moveStartOffsetX;
          }
          if (f5 < this.moveStartOffsetY)
          {
            f4 = this.moveStartOffsetY - f5;
            f5 = this.moveStartOffsetY + 0;
          }
          for (;;)
          {
            f3 = f5;
            if (f5 > this.moveRegionHeight + this.moveStartOffsetY)
            {
              f4 = this.moveRegionHeight + this.moveStartOffsetY - f5;
              f3 = this.moveRegionHeight + this.moveStartOffsetY;
            }
            f6 = f1;
            f5 = f2;
            if (f1 < this.moveStartOffsetX)
            {
              f6 = f1;
              f5 = f2;
              if (f1 > this.moveRegionWidth + this.moveStartOffsetX)
              {
                f6 = f1 + 0.0F;
                f5 = 0.0F;
              }
            }
            f7 = f6;
            f8 = f5;
            f1 = f3;
            f2 = f4;
            if (f3 >= this.moveStartOffsetY) {
              break;
            }
            f7 = f6;
            f8 = f5;
            f1 = f3;
            f2 = f4;
            if (f3 <= this.moveRegionHeight + this.moveStartOffsetY) {
              break;
            }
            f1 = f3 + 0.0F;
            f2 = 0.0F;
            f7 = f6;
            f8 = f5;
            break;
            f4 = 0.0F;
          }
          f2 = 0.0F;
        }
        f4 = 0.0F;
      }
      label706:
      f2 = 0.0F;
    }
  }
  
  private void init()
  {
    initStickerData();
    initPaint();
    initPagView();
    if (getLayoutParams() == null) {
      setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }
    setWillNotDraw(false);
    this.sticker.registerRenderer(this);
    this.mStickerTouchListener = new TavStickerTouchListener(null);
    addOnTouchListener(this.mStickerTouchListener);
  }
  
  private void initLocationData()
  {
    this.vertexPoints[0].set(this.positionX, this.positionY);
    this.vertexPoints[1].set(this.positionX + this.stickerWidth, this.positionY);
    this.vertexPoints[2].set(this.positionX + this.stickerWidth, this.positionY + this.stickerHeight);
    this.vertexPoints[3].set(this.positionX, this.positionY + this.stickerHeight);
    this.originalVertexPoints[0] = this.vertexPoints[0];
    this.originalVertexPoints[1] = this.vertexPoints[1];
    this.originalVertexPoints[2] = this.vertexPoints[2];
    this.originalVertexPoints[3] = this.vertexPoints[3];
    this.centerX = TAVStickerUtil.getMiddlePoint(this.vertexPoints[0], this.vertexPoints[2]).x;
    this.centerY = TAVStickerUtil.getMiddlePoint(this.vertexPoints[0], this.vertexPoints[2]).y;
    this.originalCenterX = this.centerX;
    this.originalCenterY = this.centerY;
  }
  
  private void initMoveRectPaint()
  {
    this.movieRectPaint = new Paint();
    this.movieRectPaint.setAntiAlias(true);
    this.movieRectPaint.setStrokeWidth(this.sticker.getStrokeWidth());
    this.movieRectPaint.setColor(-65536);
    this.movieRectPaint.setStyle(Paint.Style.STROKE);
  }
  
  private void initPagView()
  {
    this.pagView = new PAGView(this.context);
    addView(this.pagView);
    PAGFile localPAGFile = this.sticker.getPagFile();
    if (localPAGFile != null)
    {
      TLog.d(TAG, "initPagView -> pagFile.width() : " + localPAGFile.width() + ", pagFile.height() : " + localPAGFile.height());
      this.pagView.setFile(localPAGFile);
    }
    if (this.sticker.isAutoPlay()) {
      play(0);
    }
  }
  
  private void initPaint()
  {
    this.borderPaint = new Paint();
    this.borderPaint.setAntiAlias(true);
    this.borderPaint.setStrokeWidth(this.sticker.getStrokeWidth());
    this.borderPaint.setColor(this.sticker.getStrokeColor());
  }
  
  private void initScaleData()
  {
    this.scaleMax = this.sticker.getMaxScale();
    if ((this.scaleMax < 0.0F) && (this.sticker.getWidth() > 0) && (this.sticker.getHeight() > 0)) {
      this.scaleMax = (1.0F * Math.max(this.moveRegionWidth, this.moveRegionHeight) / Math.min(this.sticker.getWidth(), this.sticker.getHeight()));
    }
    if (TAVStickerMoveLimit.LIMIT_VERTEX == this.sticker.getStickerMoveLimit())
    {
      float f1 = Math.min(this.moveRegionWidth, this.moveRegionHeight);
      float f2 = TAVStickerUtil.getDistance(this.vertexPoints[0], this.vertexPoints[2]);
      if (f2 > 0.0F) {
        this.scaleMax = Math.min(f1 / f2, this.scaleMax);
      }
    }
    this.scaleMin = this.sticker.getMinScale();
    if (this.scaleMin < 0.0F) {
      this.scaleMin = 0.0F;
    }
    if ((this.scaleMin > 0.0F) && (this.scaleMax > 0.0F))
    {
      if (this.scale < this.scaleMin) {
        this.scale = this.scaleMin;
      }
      if (this.scale > this.scaleMax) {
        this.scale = this.scaleMax;
      }
    }
  }
  
  private void initStickerData()
  {
    this.isShowDefaultBorder = this.sticker.isShowDefaultBorder();
    this.scale = this.sticker.getScale();
    if (this.scale <= 0.0F)
    {
      this.scale = 1.0F;
      this.sticker.setScale(this.scale);
    }
    this.rotate = this.sticker.getRotate();
  }
  
  private boolean isTouchInStickerEditView(int paramInt1, int paramInt2)
  {
    this.path.reset();
    this.path.moveTo(this.vertexPoints[0].x, this.vertexPoints[0].y);
    this.path.lineTo(this.vertexPoints[1].x, this.vertexPoints[1].y);
    this.path.lineTo(this.vertexPoints[2].x, this.vertexPoints[2].y);
    this.path.lineTo(this.vertexPoints[3].x, this.vertexPoints[3].y);
    this.path.lineTo(this.vertexPoints[0].x, this.vertexPoints[0].y);
    this.path.computeBounds(this.rectF, true);
    this.clipRegion.set((int)this.rectF.left, (int)this.rectF.top, (int)this.rectF.right, (int)this.rectF.bottom);
    this.region.setPath(this.path, this.clipRegion);
    boolean bool = this.region.contains(paramInt1, paramInt2);
    TLog.d(TAG, "isTouchInStickerEditView -> contains : " + bool);
    return bool;
  }
  
  private void setPosition(float paramFloat1, float paramFloat2)
  {
    if (this.pagView != null)
    {
      this.pagView.setTranslationX(paramFloat1);
      this.pagView.setTranslationY(paramFloat2);
    }
  }
  
  private void setRotate(float paramFloat)
  {
    if (this.pagView != null) {
      this.pagView.setRotation(paramFloat);
    }
    this.rotate = paramFloat;
  }
  
  private void setScale(float paramFloat)
  {
    if (this.pagView != null)
    {
      this.pagView.setScaleX(paramFloat);
      this.pagView.setScaleY(paramFloat);
    }
    this.scale = paramFloat;
  }
  
  private void updateVertexPoints()
  {
    PointF[] arrayOfPointF = TAVStickerUtil.computeRectanglePoints(this.pagView.getMatrix(), this.stickerWidth, this.stickerHeight);
    this.vertexPoints[0] = arrayOfPointF[0];
    this.vertexPoints[1] = arrayOfPointF[1];
    this.vertexPoints[2] = arrayOfPointF[2];
    this.vertexPoints[3] = arrayOfPointF[3];
  }
  
  public void addOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    if (paramOnTouchListener == null) {
      return;
    }
    this.mTouchListeners.add(paramOnTouchListener);
  }
  
  public long duration()
  {
    if (this.pagView != null) {
      return this.pagView.duration() / 1000L;
    }
    return 0L;
  }
  
  public boolean flush()
  {
    if (this.pagView != null) {
      return this.pagView.flush();
    }
    return false;
  }
  
  public boolean flush(boolean paramBoolean)
  {
    if (this.pagView != null) {
      return this.pagView.flush(paramBoolean);
    }
    return false;
  }
  
  public TAVStickerMode getMode()
  {
    return this.mode;
  }
  
  public PointF[] getOriginalVertexPoints()
  {
    return this.originalVertexPoints;
  }
  
  public double getProgress()
  {
    if (this.pagView != null) {
      return this.pagView.getProgress();
    }
    return 0.0D;
  }
  
  public TAVSticker getSticker()
  {
    return this.sticker;
  }
  
  public void getUnderPointLayerItems(int paramInt1, int paramInt2, ITAVTouchStickerLayerListener paramITAVTouchStickerLayerListener)
  {
    if (paramITAVTouchStickerLayerListener != null)
    {
      if ((isTouchInStickerEditView(paramInt1, paramInt2)) && (this.pagView != null))
      {
        ArrayList localArrayList = new ArrayList();
        Object localObject1 = convertCoordinate(paramInt1, paramInt2);
        localObject1 = this.pagView.getLayersUnderPoint(((PointF)localObject1).x, ((PointF)localObject1).y);
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          paramInt2 = localObject1.length;
          paramInt1 = 0;
          if (paramInt1 < paramInt2)
          {
            Object localObject2 = localObject1[paramInt1];
            int i;
            if (localObject2 != null)
            {
              if (3 != ((PAGLayer)localObject2).layerType()) {
                break label138;
              }
              i = ((PAGLayer)localObject2).editableIndex();
              localObject2 = this.sticker.getTavStickerTextItem(i);
              if (localObject2 != null) {
                localArrayList.add(localObject2);
              }
            }
            for (;;)
            {
              paramInt1 += 1;
              break;
              label138:
              if (5 == ((PAGLayer)localObject2).layerType())
              {
                i = ((PAGLayer)localObject2).editableIndex();
                localObject2 = this.sticker.getTavStickerImageItem(i);
                if (localObject2 != null) {
                  localArrayList.add(localObject2);
                }
              }
            }
          }
          paramITAVTouchStickerLayerListener.onTouchSticker(this.sticker, localArrayList);
        }
      }
    }
    else {
      return;
    }
    paramITAVTouchStickerLayerListener.onTouchSticker(this.sticker, null);
  }
  
  boolean handleTouchEvent(View paramView, MotionEvent paramMotionEvent)
  {
    int i = this.mTouchListeners.size() - 1;
    while (i >= 0)
    {
      View.OnTouchListener localOnTouchListener = (View.OnTouchListener)this.mTouchListeners.get(i);
      if ((localOnTouchListener != null) && (localOnTouchListener.onTouch(paramView, paramMotionEvent))) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  void initLocation(int paramInt1, int paramInt2)
  {
    this.isNeedInitLocation = false;
    this.stickerContainerWidth = paramInt1;
    this.stickerContainerHeight = paramInt2;
    updateStickerMoveRect();
    Object localObject = TAVStickerUtil.getStickerRect(this.sticker, paramInt1, paramInt2, 1.0F);
    if (localObject != null)
    {
      this.stickerWidth = ((int)RectUtil.getRectWidth((RectF)localObject));
      this.stickerHeight = ((int)RectUtil.getRectHeight((RectF)localObject));
      this.positionX = ((int)((RectF)localObject).left);
      this.positionY = ((int)((RectF)localObject).top);
    }
    if (this.pagView != null)
    {
      localObject = this.pagView.getLayoutParams();
      if (localObject != null)
      {
        ((ViewGroup.LayoutParams)localObject).width = this.stickerWidth;
        ((ViewGroup.LayoutParams)localObject).height = this.stickerHeight;
        this.pagView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    initLocationData();
    initScaleData();
    setPosition(this.positionX, this.positionY);
    setScale(this.scale);
    setRotate(this.rotate);
    updateVertexPoints();
  }
  
  boolean isNeedInitLocation()
  {
    return this.isNeedInitLocation;
  }
  
  public boolean isPlaying()
  {
    if (this.pagView != null) {
      return this.pagView.isPlaying();
    }
    return false;
  }
  
  public float maxFrameRate()
  {
    if (this.pagView != null) {
      this.pagView.maxFrameRate();
    }
    return 0.0F;
  }
  
  void needInitLocation()
  {
    this.isNeedInitLocation = true;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.isFirstDraw)
    {
      this.isFirstDraw = false;
      adjustLocation(TAVStickerOperationMode.OP_NONE);
      this.correctedOriginalCenterX = this.centerX;
      this.correctedOriginalCenterY = this.centerY;
    }
    if ((this.isShowDefaultBorder) && (TAVStickerMode.ACTIVE == this.mode))
    {
      paramCanvas.drawLine(this.vertexPoints[0].x, this.vertexPoints[0].y, this.vertexPoints[1].x, this.vertexPoints[1].y, this.borderPaint);
      paramCanvas.drawLine(this.vertexPoints[1].x, this.vertexPoints[1].y, this.vertexPoints[2].x, this.vertexPoints[2].y, this.borderPaint);
      paramCanvas.drawLine(this.vertexPoints[2].x, this.vertexPoints[2].y, this.vertexPoints[3].x, this.vertexPoints[3].y, this.borderPaint);
      paramCanvas.drawLine(this.vertexPoints[3].x, this.vertexPoints[3].y, this.vertexPoints[0].x, this.vertexPoints[0].y, this.borderPaint);
    }
    if ((this.isDrawMovieLimitRect) && (RectUtil.rectIsValid(this.stickerMoveLimitRect)))
    {
      if (this.movieRectPaint == null) {
        initMoveRectPaint();
      }
      paramCanvas.drawRect(this.stickerMoveLimitRect, this.movieRectPaint);
    }
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
  }
  
  public void play(int paramInt)
  {
    TLog.d(TAG, "play -> repeatCount : " + paramInt);
    if (this.pagView != null)
    {
      this.pagView.setRepeatCount(paramInt);
      if (!this.pagView.isPlaying()) {
        this.pagView.play();
      }
    }
  }
  
  @NonNull
  protected PointF positionInterceptor(float paramFloat1, float paramFloat2)
  {
    return new PointF(paramFloat1, paramFloat2);
  }
  
  public void removeOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    if (paramOnTouchListener == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = new ArrayList(this.mTouchListeners).iterator();
      while (localIterator.hasNext())
      {
        View.OnTouchListener localOnTouchListener = (View.OnTouchListener)localIterator.next();
        if ((localOnTouchListener != null) && (localOnTouchListener == paramOnTouchListener)) {
          this.mTouchListeners.remove(paramOnTouchListener);
        }
      }
    }
  }
  
  @FloatRange(from=0.0D, to=360.0D)
  protected float rotateInterceptor(float paramFloat)
  {
    return paramFloat;
  }
  
  protected float scaleInterceptor(float paramFloat)
  {
    return paramFloat;
  }
  
  public void setDrawMovieLimitRect(boolean paramBoolean)
  {
    this.isDrawMovieLimitRect = paramBoolean;
    postInvalidate();
  }
  
  public void setEventType(int paramInt)
  {
    this.mEventType = paramInt;
  }
  
  public void setImageData(int paramInt, PAGImage paramPAGImage)
  {
    if (this.pagView != null) {
      this.pagView.replaceImage(paramInt, paramPAGImage);
    }
  }
  
  public void setMaxFrameRate(float paramFloat)
  {
    if (this.pagView != null) {
      this.pagView.setMaxFrameRate(paramFloat);
    }
  }
  
  public void setMode(TAVStickerMode paramTAVStickerMode)
  {
    this.mode = paramTAVStickerMode;
    postInvalidate();
  }
  
  public void setOnStickerEventListener(ITAVStickerEventListener paramITAVStickerEventListener)
  {
    this.stickerEventListener = paramITAVStickerEventListener;
  }
  
  @Deprecated
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    addOnTouchListener(paramOnTouchListener);
  }
  
  public void setProgress(double paramDouble)
  {
    if (this.pagView != null) {
      this.pagView.setProgress(paramDouble);
    }
  }
  
  public void setSingleZoomRotateRect(RectF paramRectF)
  {
    this.singleZoomRotateRect = paramRectF;
  }
  
  public void setTextData(int paramInt, PAGText paramPAGText)
  {
    if (this.pagView != null) {
      this.pagView.setTextData(paramInt, paramPAGText);
    }
  }
  
  public void stop()
  {
    if (this.pagView != null) {
      this.pagView.stop();
    }
  }
  
  public void updateStickerMoveRect()
  {
    this.stickerMoveLimitRect = RectUtil.getStickerMoveLimitRect(this.sticker.getMoveRect(), this.stickerContainerWidth, this.stickerContainerHeight);
    if (RectUtil.rectIsValid(this.stickerMoveLimitRect))
    {
      this.moveStartOffsetX = this.stickerMoveLimitRect.left;
      this.moveStartOffsetY = this.stickerMoveLimitRect.top;
      this.moveRegionWidth = RectUtil.getRectWidth(this.stickerMoveLimitRect);
      this.moveRegionHeight = RectUtil.getRectHeight(this.stickerMoveLimitRect);
      return;
    }
    this.moveStartOffsetX = 0;
    this.moveStartOffsetY = 0;
    this.moveRegionWidth = this.stickerContainerWidth;
    this.moveRegionHeight = this.stickerContainerHeight;
  }
  
  class TavStickerTouchListener
    implements View.OnTouchListener
  {
    private static final int CLICK_DURATION = 200;
    private static final int SINGLE_POINT = 1;
    private static final int TOUCH_SLOP = 16;
    private static final int TWO_POINT = 2;
    private int actionIndex = 0;
    private PointF centerPoint = new PointF();
    private PointF downPoint = new PointF();
    private boolean isClickSticker = false;
    private boolean isTouchInSingleZoomRotateRect = false;
    private boolean isTouchInStickerRect = false;
    private float lastDownRotate = 0.0F;
    private float lastDownScale = 1.0F;
    private TAVStickerOperationMode operationMode = TAVStickerOperationMode.OP_NONE;
    private float twoPointDownDistance = 0.0F;
    private float twoPointDownRotate = 0.0F;
    
    private TavStickerTouchListener() {}
    
    private boolean checkClickInterval(MotionEvent paramMotionEvent)
    {
      return paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime() < 200L;
    }
    
    private void handleActionDown(MotionEvent paramMotionEvent)
    {
      if (TAVStickerEditView.this.stickerEventListener != null) {
        TAVStickerEditView.this.stickerEventListener.onTouchBegin(TAVStickerEditView.this.sticker, paramMotionEvent);
      }
      this.downPoint.set(paramMotionEvent.getX(), paramMotionEvent.getY());
      TAVStickerEditView.access$402(TAVStickerEditView.this, TAVStickerEditView.this.getPositionX());
      TAVStickerEditView.access$602(TAVStickerEditView.this, TAVStickerEditView.this.getPositionY());
      this.lastDownRotate = TAVStickerEditView.this.rotate;
      this.lastDownScale = TAVStickerEditView.this.scale;
      this.isClickSticker = true;
      if (this.isTouchInSingleZoomRotateRect)
      {
        this.operationMode = TAVStickerOperationMode.OP_SINGLE_ZOOM_ROTATE;
        this.centerPoint = TAVStickerUtil.getMiddlePoint(TAVStickerEditView.this.vertexPoints[0], TAVStickerEditView.this.vertexPoints[2]);
        this.twoPointDownRotate = TAVStickerUtil.getRotation(this.centerPoint, this.downPoint);
        this.twoPointDownDistance = TAVStickerUtil.getDistance(this.centerPoint, this.downPoint);
      }
    }
    
    private void handleActionMove(MotionEvent paramMotionEvent)
    {
      float f2 = paramMotionEvent.getX();
      float f1 = paramMotionEvent.getY();
      if (2 == paramMotionEvent.getPointerCount()) {
        if (TAVStickerEditViewEventType.isHandleDoubleZoomRotate(TAVStickerEditView.this.mEventType))
        {
          TLog.d(TAVStickerEditView.TAG, "双指缩放旋转");
          this.operationMode = TAVStickerOperationMode.OP_DOUBLE_ZOOM_ROTATE;
          onHandleScaleAndRotate(paramMotionEvent.getX(1) - paramMotionEvent.getX(0), paramMotionEvent.getY(1) - paramMotionEvent.getY(0));
        }
      }
      for (;;)
      {
        if (this.operationMode != TAVStickerOperationMode.OP_NONE) {
          TAVStickerEditView.this.adjustLocation(this.operationMode);
        }
        return;
        if (1 == paramMotionEvent.getPointerCount())
        {
          if ((Math.abs(f2 - this.downPoint.x) > 16.0F) || (Math.abs(f1 - this.downPoint.y) > 16.0F)) {
            this.isClickSticker = false;
          }
          if (this.operationMode == TAVStickerOperationMode.OP_SINGLE_ZOOM_ROTATE)
          {
            if (TAVStickerEditViewEventType.isHandleSingleZoomRotate(TAVStickerEditView.this.mEventType))
            {
              TLog.d(TAVStickerEditView.TAG, "单指缩放旋转");
              onHandleScaleAndRotate(this.centerPoint.x - paramMotionEvent.getX(), this.centerPoint.y - paramMotionEvent.getY());
            }
          }
          else if (TAVStickerEditViewEventType.isHandleDrag(TAVStickerEditView.this.mEventType))
          {
            TLog.d(TAVStickerEditView.TAG, "单指移动");
            if (!this.isClickSticker) {
              this.operationMode = TAVStickerOperationMode.OP_DRAG;
            }
            f2 = f2 + TAVStickerEditView.this.positionX - this.downPoint.x;
            f1 = f1 + TAVStickerEditView.this.positionY - this.downPoint.y;
            paramMotionEvent = TAVStickerEditView.this.positionInterceptor(f2, f1);
            TLog.d(TAVStickerEditView.TAG, "handleActionMove -> curPositionX : " + f2 + ", realX : " + paramMotionEvent.x + ", curPositionY : " + f1 + ", realY : " + paramMotionEvent.y);
            TAVStickerEditView.this.setPosition(paramMotionEvent.x, paramMotionEvent.y);
          }
        }
      }
    }
    
    private void handleActionPointerDown(MotionEvent paramMotionEvent)
    {
      this.operationMode = TAVStickerOperationMode.OP_NONE;
      this.centerPoint = TAVStickerUtil.getMiddlePoint(TAVStickerEditView.this.vertexPoints[0], TAVStickerEditView.this.vertexPoints[2]);
      this.twoPointDownRotate = TAVStickerUtil.getRotation(paramMotionEvent);
      this.twoPointDownDistance = TAVStickerUtil.getDistance(new PointF(paramMotionEvent.getX(this.actionIndex), paramMotionEvent.getY(this.actionIndex)), this.downPoint);
    }
    
    private void handleActionPointerUp(MotionEvent paramMotionEvent)
    {
      this.operationMode = TAVStickerOperationMode.OP_NONE;
      TAVStickerEditView.access$402(TAVStickerEditView.this, TAVStickerEditView.this.getPositionX());
      TAVStickerEditView.access$602(TAVStickerEditView.this, TAVStickerEditView.this.getPositionY());
      this.lastDownRotate = TAVStickerEditView.this.rotate;
      this.lastDownScale = TAVStickerEditView.this.scale;
      if (paramMotionEvent.getPointerId(this.actionIndex) == 0) {
        this.downPoint.set(paramMotionEvent.getX(1), paramMotionEvent.getY(1));
      }
      while (1 != paramMotionEvent.getPointerId(this.actionIndex)) {
        return;
      }
      this.downPoint.set(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
    }
    
    private void handleActionUp(MotionEvent paramMotionEvent)
    {
      this.operationMode = TAVStickerOperationMode.OP_NONE;
      if ((TAVStickerEditView.this.stickerEventListener != null) && (checkClickInterval(paramMotionEvent)) && (this.isClickSticker) && (TAVStickerEditViewEventType.isHandleClick(TAVStickerEditView.this.mEventType))) {
        TAVStickerEditView.this.stickerEventListener.onStickerClick(TAVStickerEditView.this.sticker, paramMotionEvent);
      }
      if (TAVStickerEditView.this.stickerEventListener != null) {
        TAVStickerEditView.this.stickerEventListener.onTouchEnd(TAVStickerEditView.this.sticker, paramMotionEvent);
      }
    }
    
    private float handleScaleLimit(float paramFloat)
    {
      float f = paramFloat;
      if (TAVStickerEditView.this.scaleMin > 0.0F)
      {
        f = paramFloat;
        if (paramFloat < TAVStickerEditView.this.scaleMin) {
          f = TAVStickerEditView.this.scaleMin;
        }
      }
      paramFloat = f;
      if (TAVStickerEditView.this.scaleMax > 0.0F)
      {
        paramFloat = f;
        if (f > TAVStickerEditView.this.scaleMax) {
          paramFloat = TAVStickerEditView.this.scaleMax;
        }
      }
      return paramFloat;
    }
    
    private boolean isTouchInSticker(MotionEvent paramMotionEvent)
    {
      boolean bool2 = false;
      if ((paramMotionEvent.getAction() & 0xFF) == 0)
      {
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        this.isTouchInStickerRect = TAVStickerUtil.inQuadrangle(TAVStickerEditView.this.vertexPoints[0], TAVStickerEditView.this.vertexPoints[1], TAVStickerEditView.this.vertexPoints[2], TAVStickerEditView.this.vertexPoints[3], new PointF(f1, f2));
        if ((TAVStickerEditView.this.singleZoomRotateRect == null) || (!TAVStickerEditView.this.singleZoomRotateRect.contains(f1, f2))) {
          break label134;
        }
      }
      label134:
      for (boolean bool1 = true;; bool1 = false)
      {
        this.isTouchInSingleZoomRotateRect = bool1;
        if (!this.isTouchInStickerRect)
        {
          bool1 = bool2;
          if (!this.isTouchInSingleZoomRotateRect) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
    }
    
    private void onHandleScaleAndRotate(float paramFloat1, float paramFloat2)
    {
      this.isClickSticker = false;
      float f2 = TAVStickerUtil.getRotation(paramFloat1, paramFloat2) - this.twoPointDownRotate + this.lastDownRotate;
      float f1;
      if (f2 < 0.0F) {
        f1 = f2 + 360.0F;
      }
      for (;;)
      {
        f2 = TAVStickerEditView.this.rotateInterceptor(f1);
        TLog.d(TAVStickerEditView.TAG, "onHandleScaleAndRotate -> rotation : " + f1 + ", displayRotation : " + f2);
        TAVStickerEditView.this.setRotate(f2);
        if (this.twoPointDownDistance > 0.0F)
        {
          paramFloat1 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
          paramFloat2 = this.lastDownScale;
          paramFloat1 = handleScaleLimit(paramFloat1 / this.twoPointDownDistance * paramFloat2);
          paramFloat2 = TAVStickerEditView.this.scaleInterceptor(paramFloat1);
          TLog.d(TAVStickerEditView.TAG, "onHandleScaleAndRotate -> curScale : " + paramFloat1 + ", displayScale : " + paramFloat2);
          TAVStickerEditView.this.setScale(paramFloat2);
        }
        return;
        f1 = f2;
        if (f2 > 360.0F) {
          f1 = f2 - 360.0F;
        }
      }
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      this.actionIndex = paramMotionEvent.getActionIndex();
      if ((!TAVStickerEditView.this.sticker.isEditable()) || (TAVStickerEditView.this.mEventType == 0)) {
        return false;
      }
      if (isTouchInSticker(paramMotionEvent))
      {
        TAVStickerEditView.this.bringToFront();
        TAVStickerEditView.this.setMode(TAVStickerMode.ACTIVE);
        switch (paramMotionEvent.getAction() & 0xFF)
        {
        }
        for (;;)
        {
          return true;
          handleActionDown(paramMotionEvent);
          continue;
          handleActionPointerDown(paramMotionEvent);
          continue;
          handleActionMove(paramMotionEvent);
          continue;
          handleActionPointerUp(paramMotionEvent);
          continue;
          handleActionUp(paramMotionEvent);
        }
      }
      TLog.d(TAVStickerEditView.TAG, "onTouch -> not touch in sticker rect.");
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerEditView
 * JD-Core Version:    0.7.0.1
 */