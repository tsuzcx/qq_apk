import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.CallSuper;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.util.Log;
import com.tencent.lottieNew.model.content.Mask;
import com.tencent.lottieNew.model.layer.Layer;
import com.tencent.lottieNew.model.layer.Layer.MatteType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class twe
  implements tsq, ttg.a
{
  final Layer jdField_a_of_type_ComTencentLottieNewModelLayerLayer;
  final trz jdField_a_of_type_Trz;
  @Nullable
  private ttm jdField_a_of_type_Ttm;
  private final List<ttg<?, ?>> animations = new ArrayList();
  final ttw jdField_b_of_type_Ttw;
  @Nullable
  private twe jdField_b_of_type_Twe;
  private final Paint bm = new Paint(1);
  final Matrix boundsMatrix = new Matrix();
  @Nullable
  private twe c;
  private final Paint clearPaint = new Paint();
  private final Paint contentPaint = new Paint(1);
  private final String drawTraceName;
  private final RectF maskBoundsRect = new RectF();
  private final Matrix matrix = new Matrix();
  private final RectF matteBoundsRect = new RectF();
  private final Paint mattePaint = new Paint(1);
  private List<twe> parentLayers;
  private final Path path = new Path();
  private final RectF rect = new RectF();
  private final RectF tempMaskBoundsRect = new RectF();
  private boolean visible = true;
  
  twe(trz paramtrz, Layer paramLayer)
  {
    this.jdField_a_of_type_Trz = paramtrz;
    this.jdField_a_of_type_ComTencentLottieNewModelLayerLayer = paramLayer;
    this.drawTraceName = (paramLayer.getName() + "#draw");
    this.clearPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.bm.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    if (paramLayer.a() == Layer.MatteType.Invert) {
      this.mattePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }
    for (;;)
    {
      this.jdField_b_of_type_Ttw = paramLayer.b().a();
      this.jdField_b_of_type_Ttw.a(this);
      this.jdField_b_of_type_Ttw.a(this);
      if ((paramLayer.getMasks() == null) || (paramLayer.getMasks().isEmpty())) {
        break label416;
      }
      this.jdField_a_of_type_Ttm = new ttm(paramLayer.getMasks());
      paramtrz = this.jdField_a_of_type_Ttm.getMaskAnimations().iterator();
      while (paramtrz.hasNext())
      {
        paramLayer = (ttg)paramtrz.next();
        a(paramLayer);
        paramLayer.b(this);
      }
      this.mattePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }
    paramtrz = this.jdField_a_of_type_Ttm.getOpacityAnimations().iterator();
    while (paramtrz.hasNext())
    {
      paramLayer = (ttg)paramtrz.next();
      a(paramLayer);
      paramLayer.b(this);
    }
    label416:
    setupInOutAnimations();
  }
  
  @Nullable
  static twe a(Layer paramLayer, trz paramtrz, trx paramtrx)
  {
    switch (twg.fh[paramLayer.a().ordinal()])
    {
    default: 
      Log.w("LOTTIE", "Unknown layer type " + paramLayer.a());
      return null;
    case 1: 
      return new twm(paramtrz, paramLayer);
    case 2: 
      return new twh(paramtrz, paramLayer, paramtrx.getPrecomps(paramLayer.getRefId()), paramtrx);
    case 3: 
      return new twn(paramtrz, paramLayer);
    case 4: 
      return new twj(paramtrz, paramLayer, paramtrx.aE());
    case 5: 
      return new twl(paramtrz, paramLayer);
    }
    return new two(paramtrz, paramLayer);
  }
  
  @SuppressLint({"WrongConstant"})
  private void applyMasks(Canvas paramCanvas, Matrix paramMatrix)
  {
    trt.beginSection("Layer#drawMask");
    trt.beginSection("Layer#saveLayer");
    paramCanvas.saveLayer(this.rect, this.bm);
    trt.endSection("Layer#saveLayer");
    clearCanvas(paramCanvas);
    int j = this.jdField_a_of_type_Ttm.getMasks().size();
    int i = 0;
    if (i < j)
    {
      Object localObject = (Mask)this.jdField_a_of_type_Ttm.getMasks().get(i);
      Path localPath = (Path)((ttg)this.jdField_a_of_type_Ttm.getMaskAnimations().get(i)).getValue();
      this.path.set(localPath);
      this.path.transform(paramMatrix);
      switch (twg.fi[localObject.a().ordinal()])
      {
      default: 
        this.path.setFillType(Path.FillType.WINDING);
      }
      for (;;)
      {
        localObject = (ttg)this.jdField_a_of_type_Ttm.getOpacityAnimations().get(i);
        int k = this.contentPaint.getAlpha();
        this.contentPaint.setAlpha((int)(((Integer)((ttg)localObject).getValue()).intValue() * 2.55F));
        paramCanvas.drawPath(this.path, this.contentPaint);
        this.contentPaint.setAlpha(k);
        i += 1;
        break;
        this.path.setFillType(Path.FillType.INVERSE_WINDING);
      }
    }
    trt.beginSection("Layer#restoreLayer");
    paramCanvas.restore();
    trt.endSection("Layer#restoreLayer");
    trt.endSection("Layer#drawMask");
  }
  
  private void buildParentLayerListIfNeeded()
  {
    if (this.parentLayers != null) {}
    for (;;)
    {
      return;
      if (this.c == null)
      {
        this.parentLayers = Collections.emptyList();
        return;
      }
      this.parentLayers = new ArrayList();
      for (twe localtwe = this.c; localtwe != null; localtwe = localtwe.c) {
        this.parentLayers.add(localtwe);
      }
    }
  }
  
  private void clearCanvas(Canvas paramCanvas)
  {
    trt.beginSection("Layer#clearLayer");
    paramCanvas.drawRect(this.rect.left - 1.0F, this.rect.top - 1.0F, this.rect.right + 1.0F, 1.0F + this.rect.bottom, this.clearPaint);
    trt.endSection("Layer#clearLayer");
  }
  
  private void intersectBoundsWithMask(RectF paramRectF, Matrix paramMatrix)
  {
    this.maskBoundsRect.set(0.0F, 0.0F, 0.0F, 0.0F);
    if (!hasMasksOnThisLayer()) {
      return;
    }
    int j = this.jdField_a_of_type_Ttm.getMasks().size();
    int i = 0;
    if (i < j)
    {
      Mask localMask = (Mask)this.jdField_a_of_type_Ttm.getMasks().get(i);
      Path localPath = (Path)((ttg)this.jdField_a_of_type_Ttm.getMaskAnimations().get(i)).getValue();
      this.path.set(localPath);
      this.path.transform(paramMatrix);
      switch (twg.fi[localMask.a().ordinal()])
      {
      }
      this.path.computeBounds(this.tempMaskBoundsRect, false);
      if (i == 0) {
        this.maskBoundsRect.set(this.tempMaskBoundsRect);
      }
      for (;;)
      {
        i += 1;
        break;
        this.maskBoundsRect.set(Math.min(this.maskBoundsRect.left, this.tempMaskBoundsRect.left), Math.min(this.maskBoundsRect.top, this.tempMaskBoundsRect.top), Math.max(this.maskBoundsRect.right, this.tempMaskBoundsRect.right), Math.max(this.maskBoundsRect.bottom, this.tempMaskBoundsRect.bottom));
      }
    }
    paramRectF.set(Math.max(paramRectF.left, this.maskBoundsRect.left), Math.max(paramRectF.top, this.maskBoundsRect.top), Math.min(paramRectF.right, this.maskBoundsRect.right), Math.min(paramRectF.bottom, this.maskBoundsRect.bottom));
  }
  
  private void intersectBoundsWithMatte(RectF paramRectF, Matrix paramMatrix)
  {
    if (!hasMatteOnThisLayer()) {}
    while (this.jdField_a_of_type_ComTencentLottieNewModelLayerLayer.a() == Layer.MatteType.Invert) {
      return;
    }
    this.jdField_b_of_type_Twe.a(this.matteBoundsRect, paramMatrix);
    paramRectF.set(Math.max(paramRectF.left, this.matteBoundsRect.left), Math.max(paramRectF.top, this.matteBoundsRect.top), Math.min(paramRectF.right, this.matteBoundsRect.right), Math.min(paramRectF.bottom, this.matteBoundsRect.bottom));
  }
  
  private void invalidateSelf()
  {
    this.jdField_a_of_type_Trz.invalidateSelf();
  }
  
  private void recordRenderTime(float paramFloat)
  {
    this.jdField_a_of_type_Trz.a().a().recordRenderTime(this.jdField_a_of_type_ComTencentLottieNewModelLayerLayer.getName(), paramFloat);
  }
  
  private void setVisible(boolean paramBoolean)
  {
    if (paramBoolean != this.visible)
    {
      this.visible = paramBoolean;
      invalidateSelf();
    }
  }
  
  private void setupInOutAnimations()
  {
    if (!this.jdField_a_of_type_ComTencentLottieNewModelLayerLayer.getInOutKeyframes().isEmpty())
    {
      tti localtti = new tti(this.jdField_a_of_type_ComTencentLottieNewModelLayerLayer.getInOutKeyframes());
      localtti.setIsDiscrete();
      localtti.b(new twf(this, localtti));
      if (((Float)localtti.getValue()).floatValue() == 1.0F) {}
      for (boolean bool = true;; bool = false)
      {
        setVisible(bool);
        a(localtti);
        return;
      }
    }
    setVisible(true);
  }
  
  Layer a()
  {
    return this.jdField_a_of_type_ComTencentLottieNewModelLayerLayer;
  }
  
  @CallSuper
  public void a(RectF paramRectF, Matrix paramMatrix)
  {
    this.boundsMatrix.set(paramMatrix);
    this.boundsMatrix.preConcat(this.jdField_b_of_type_Ttw.getMatrix());
  }
  
  public void a(ttg<?, ?> paramttg)
  {
    if (!(paramttg instanceof ttu)) {
      this.animations.add(paramttg);
    }
  }
  
  public void b(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter) {}
  
  void b(@Nullable twe paramtwe)
  {
    this.jdField_b_of_type_Twe = paramtwe;
  }
  
  void c(@Nullable twe paramtwe)
  {
    this.c = paramtwe;
  }
  
  @SuppressLint({"WrongConstant"})
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    trt.beginSection(this.drawTraceName);
    if (!this.visible)
    {
      trt.endSection(this.drawTraceName);
      return;
    }
    buildParentLayerListIfNeeded();
    trt.beginSection("Layer#parentMatrix");
    this.matrix.reset();
    this.matrix.set(paramMatrix);
    int i = this.parentLayers.size() - 1;
    while (i >= 0)
    {
      this.matrix.preConcat(((twe)this.parentLayers.get(i)).jdField_b_of_type_Ttw.getMatrix());
      i -= 1;
    }
    trt.endSection("Layer#parentMatrix");
    float f = paramInt / 255.0F;
    paramInt = (int)(((Integer)this.jdField_b_of_type_Ttw.d().getValue()).intValue() * f / 100.0F * 255.0F);
    if ((!hasMatteOnThisLayer()) && (!hasMasksOnThisLayer()))
    {
      this.matrix.preConcat(this.jdField_b_of_type_Ttw.getMatrix());
      trt.beginSection("Layer#drawLayer");
      drawLayer(paramCanvas, this.matrix, paramInt);
      trt.endSection("Layer#drawLayer");
      recordRenderTime(trt.endSection(this.drawTraceName));
      return;
    }
    trt.beginSection("Layer#computeBounds");
    this.rect.set(0.0F, 0.0F, 0.0F, 0.0F);
    a(this.rect, this.matrix);
    intersectBoundsWithMatte(this.rect, this.matrix);
    this.matrix.preConcat(this.jdField_b_of_type_Ttw.getMatrix());
    intersectBoundsWithMask(this.rect, this.matrix);
    this.rect.set(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight());
    trt.endSection("Layer#computeBounds");
    trt.beginSection("Layer#saveLayer");
    paramCanvas.saveLayer(this.rect, this.contentPaint);
    trt.endSection("Layer#saveLayer");
    clearCanvas(paramCanvas);
    trt.beginSection("Layer#drawLayer");
    drawLayer(paramCanvas, this.matrix, paramInt);
    trt.endSection("Layer#drawLayer");
    if (hasMasksOnThisLayer()) {
      applyMasks(paramCanvas, this.matrix);
    }
    if (hasMatteOnThisLayer())
    {
      trt.beginSection("Layer#drawMatte");
      trt.beginSection("Layer#saveLayer");
      paramCanvas.saveLayer(this.rect, this.mattePaint);
      trt.endSection("Layer#saveLayer");
      clearCanvas(paramCanvas);
      this.jdField_b_of_type_Twe.draw(paramCanvas, paramMatrix, paramInt);
      trt.beginSection("Layer#restoreLayer");
      paramCanvas.restore();
      trt.endSection("Layer#restoreLayer");
      trt.endSection("Layer#drawMatte");
    }
    trt.beginSection("Layer#restoreLayer");
    paramCanvas.restore();
    trt.endSection("Layer#restoreLayer");
    recordRenderTime(trt.endSection(this.drawTraceName));
  }
  
  abstract void drawLayer(Canvas paramCanvas, Matrix paramMatrix, int paramInt);
  
  public String getName()
  {
    return this.jdField_a_of_type_ComTencentLottieNewModelLayerLayer.getName();
  }
  
  boolean hasMasksOnThisLayer()
  {
    return (this.jdField_a_of_type_Ttm != null) && (!this.jdField_a_of_type_Ttm.getMaskAnimations().isEmpty());
  }
  
  boolean hasMatteOnThisLayer()
  {
    return this.jdField_b_of_type_Twe != null;
  }
  
  public void onValueChanged()
  {
    invalidateSelf();
  }
  
  public void setContents(List<tso> paramList1, List<tso> paramList2) {}
  
  void setProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    float f = paramFloat;
    if (this.jdField_a_of_type_ComTencentLottieNewModelLayerLayer.getTimeStretch() != 0.0F) {
      f = paramFloat / this.jdField_a_of_type_ComTencentLottieNewModelLayerLayer.getTimeStretch();
    }
    if (this.jdField_b_of_type_Twe != null) {
      this.jdField_b_of_type_Twe.setProgress(f);
    }
    int i = 0;
    while (i < this.animations.size())
    {
      ((ttg)this.animations.get(i)).setProgress(f);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     twe
 * JD-Core Version:    0.7.0.1
 */