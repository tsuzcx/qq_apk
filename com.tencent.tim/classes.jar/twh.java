import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.os.Build.VERSION;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.tencent.lottieNew.model.layer.Layer;
import java.util.ArrayList;
import java.util.List;

public class twh
  extends twe
{
  @Nullable
  private final ttg<Float, Float> E;
  private final Rect aS = new Rect();
  @Nullable
  private Boolean hasMasks;
  @Nullable
  private Boolean hasMatte;
  private final List<twe> layers = new ArrayList();
  private final RectF newClipRect = new RectF();
  private final RectF rect = new RectF();
  
  public twh(trz paramtrz, Layer paramLayer, List<Layer> paramList, trx paramtrx)
  {
    super(paramtrz, paramLayer);
    paramLayer = paramLayer.q();
    aure localaure;
    label114:
    Layer localLayer;
    twe localtwe;
    if (paramLayer != null)
    {
      this.E = paramLayer.g();
      a(this.E);
      this.E.b(this);
      localaure = new aure(paramtrx.getLayers().size());
      i = paramList.size() - 1;
      paramLayer = null;
      if (i < 0) {
        break label249;
      }
      localLayer = (Layer)paramList.get(i);
      localtwe = twe.a(localLayer, paramtrz, paramtrx);
      if (localtwe != null) {
        break label164;
      }
    }
    for (;;)
    {
      i -= 1;
      break label114;
      this.E = null;
      break;
      label164:
      localaure.put(localtwe.a().getId(), localtwe);
      if (paramLayer != null)
      {
        paramLayer.b(localtwe);
        paramLayer = null;
      }
      else
      {
        this.layers.add(0, localtwe);
        switch (twi.fj[localLayer.a().ordinal()])
        {
        default: 
          break;
        case 1: 
        case 2: 
          paramLayer = localtwe;
        }
      }
    }
    label249:
    int i = 0;
    while (i < localaure.size())
    {
      paramtrz = (twe)localaure.get(localaure.keyAt(i));
      paramLayer = (twe)localaure.get(paramtrz.a().getParentId());
      if (paramLayer != null) {
        paramtrz.c(paramLayer);
      }
      i += 1;
    }
  }
  
  public void a(RectF paramRectF, Matrix paramMatrix)
  {
    super.a(paramRectF, paramMatrix);
    this.rect.set(0.0F, 0.0F, 0.0F, 0.0F);
    int i = this.layers.size() - 1;
    if (i >= 0)
    {
      ((twe)this.layers.get(i)).a(this.rect, this.boundsMatrix);
      if (paramRectF.isEmpty()) {
        paramRectF.set(this.rect);
      }
      for (;;)
      {
        i -= 1;
        break;
        paramRectF.set(Math.min(paramRectF.left, this.rect.left), Math.min(paramRectF.top, this.rect.top), Math.max(paramRectF.right, this.rect.right), Math.max(paramRectF.bottom, this.rect.bottom));
      }
    }
  }
  
  public void b(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter)
  {
    int i = 0;
    if (i < this.layers.size())
    {
      twe localtwe = (twe)this.layers.get(i);
      String str = localtwe.a().getName();
      if (paramString1 == null) {
        localtwe.b(null, null, paramColorFilter);
      }
      for (;;)
      {
        i += 1;
        break;
        if (str.equals(paramString1)) {
          localtwe.b(paramString1, paramString2, paramColorFilter);
        }
      }
    }
  }
  
  void drawLayer(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    trt.beginSection("CompositionLayer#draw");
    paramCanvas.getClipBounds(this.aS);
    this.newClipRect.set(0.0F, 0.0F, this.jdField_a_of_type_ComTencentLottieNewModelLayerLayer.getPreCompWidth(), this.jdField_a_of_type_ComTencentLottieNewModelLayerLayer.getPreCompHeight());
    paramMatrix.mapRect(this.newClipRect);
    int i = this.layers.size() - 1;
    while (i >= 0)
    {
      boolean bool = true;
      if (!this.newClipRect.isEmpty()) {
        bool = paramCanvas.clipRect(this.newClipRect);
      }
      if (bool) {
        ((twe)this.layers.get(i)).draw(paramCanvas, paramMatrix, paramInt);
      }
      i -= 1;
    }
    if (!this.aS.isEmpty())
    {
      if (Build.VERSION.SDK_INT < 26) {
        break label157;
      }
      paramCanvas.clipRect(this.aS);
    }
    for (;;)
    {
      trt.endSection("CompositionLayer#draw");
      return;
      label157:
      paramCanvas.clipRect(this.aS, Region.Op.REPLACE);
    }
  }
  
  public boolean hasMasks()
  {
    if (this.hasMasks == null)
    {
      int i = this.layers.size() - 1;
      while (i >= 0)
      {
        twe localtwe = (twe)this.layers.get(i);
        if ((localtwe instanceof twm))
        {
          if (localtwe.hasMasksOnThisLayer())
          {
            this.hasMasks = Boolean.valueOf(true);
            return true;
          }
        }
        else if (((localtwe instanceof twh)) && (((twh)localtwe).hasMasks()))
        {
          this.hasMasks = Boolean.valueOf(true);
          return true;
        }
        i -= 1;
      }
      this.hasMasks = Boolean.valueOf(false);
    }
    return this.hasMasks.booleanValue();
  }
  
  public boolean hasMatte()
  {
    if (this.hasMatte == null)
    {
      if (hasMatteOnThisLayer())
      {
        this.hasMatte = Boolean.valueOf(true);
        return true;
      }
      int i = this.layers.size() - 1;
      while (i >= 0)
      {
        if (((twe)this.layers.get(i)).hasMatteOnThisLayer())
        {
          this.hasMatte = Boolean.valueOf(true);
          return true;
        }
        i -= 1;
      }
      this.hasMatte = Boolean.valueOf(false);
    }
    return this.hasMatte.booleanValue();
  }
  
  public void setProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    super.setProgress(paramFloat);
    if (this.E != null)
    {
      long l = this.jdField_a_of_type_Trz.a().getDuration();
      paramFloat = (float)(((Float)this.E.getValue()).floatValue() * 1000.0F) / (float)l;
    }
    float f = paramFloat;
    if (this.jdField_a_of_type_ComTencentLottieNewModelLayerLayer.getTimeStretch() != 0.0F) {
      f = paramFloat / this.jdField_a_of_type_ComTencentLottieNewModelLayerLayer.getTimeStretch();
    }
    paramFloat = this.jdField_a_of_type_ComTencentLottieNewModelLayerLayer.getStartProgress();
    int i = this.layers.size() - 1;
    while (i >= 0)
    {
      ((twe)this.layers.get(i)).setProgress(f - paramFloat);
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     twh
 * JD-Core Version:    0.7.0.1
 */