package com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import ram;
import rfs;
import rfz;
import rgf;
import rgh;
import rgj;
import rhy;
import rib;
import riw;

public class DoodleView
  extends View
{
  public EditVideoParams a;
  public DoodleLayout a;
  private rfs jdField_a_of_type_Rfs;
  private rgf jdField_a_of_type_Rgf;
  public rgj a;
  private Paint bd;
  private Bitmap cH;
  private Canvas g;
  private Map<String, rgf> gh;
  public boolean isEnable = true;
  public int mBitmapHeight;
  public int mBitmapWidth;
  private int mHeight;
  private int mWidth;
  private List<rgf> oO;
  
  public DoodleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private boolean Lx()
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (this.mBitmapWidth > 0)
    {
      bool1 = bool3;
      if (this.mBitmapHeight > 0) {
        bool1 = bool2;
      }
    }
    try
    {
      this.cH = Bitmap.createBitmap(this.mBitmapWidth, this.mBitmapHeight, Bitmap.Config.ARGB_8888);
      bool1 = bool2;
      this.g = new Canvas(this.cH);
      bool1 = true;
      bool2 = true;
      ram.d("DoodleView", "create Doodle bitmap, width:" + this.mBitmapWidth + ",height:" + this.mBitmapHeight);
      bool1 = bool2;
      return bool1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      ram.e("DoodleView", "create doodle bitmap failed: %s", localOutOfMemoryError);
    }
    return bool1;
  }
  
  private boolean Ly()
  {
    return (this.cH != null) && (!this.cH.isRecycled());
  }
  
  private void buA()
  {
    long l = SystemClock.uptimeMillis();
    Object localObject = (rfz)this.gh.get("LineLayer");
    if ((localObject != null) && (((rfz)localObject).a.Lt()) && (((rfz)localObject).a.cG == null)) {
      ((rfz)localObject).a.xu(this.cH.getWidth());
    }
    this.g.drawPaint(this.bd);
    Canvas localCanvas = new Canvas(this.cH);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.La()) && (localObject != null)) {
      ((rfz)localObject).ap(localCanvas);
    }
    localObject = this.gh.entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((rgf)((Map.Entry)((Iterator)localObject).next()).getValue()).ao(localCanvas);
    }
    ram.d("DoodleView", "drawLayerInDoodleBitmap cost time:" + (SystemClock.uptimeMillis() - l));
  }
  
  private void bux()
  {
    this.oO.add(this.jdField_a_of_type_Rfs);
    this.jdField_a_of_type_Rgj.a.a(this.oO, this);
    Object localObject = this.oO.iterator();
    while (((Iterator)localObject).hasNext())
    {
      rgf localrgf = (rgf)((Iterator)localObject).next();
      this.gh.put(localrgf.getTag(), localrgf);
    }
    ram.d("DoodleView", "DoodleView hold layers:" + this.gh.toString());
    this.jdField_a_of_type_Rgf = this.jdField_a_of_type_Rfs;
    if (this.oO.size() > 1) {}
    for (localObject = (rgf)this.oO.get(1);; localObject = null)
    {
      if ((localObject != null) && ((((rgf)localObject).getWidth() != this.mWidth) || (((rgf)localObject).getHeight() != this.mHeight))) {
        onSizeChanged(this.mWidth, this.mHeight, ((rgf)localObject).getWidth(), ((rgf)localObject).getHeight());
      }
      super.requestLayout();
      return;
    }
  }
  
  public boolean Lw()
  {
    return this.jdField_a_of_type_Rgf == this.jdField_a_of_type_Rfs;
  }
  
  public Bitmap U()
  {
    if (!Lx())
    {
      ram.e("DoodleView", "create doodle bitmap failed.");
      return null;
    }
    buA();
    return this.cH;
  }
  
  public rgf a()
  {
    return this.jdField_a_of_type_Rgf;
  }
  
  public rgf a(MotionEvent paramMotionEvent)
  {
    int i = this.oO.size() - 1;
    while (i >= 0)
    {
      rgf localrgf = (rgf)this.oO.get(i);
      if (localrgf.I(paramMotionEvent)) {
        return localrgf;
      }
      i -= 1;
    }
    return this.jdField_a_of_type_Rfs;
  }
  
  public <LAYER extends rgf> LAYER a(String paramString)
  {
    paramString = (rgf)this.gh.get(paramString);
    if (paramString == null) {
      throw new IllegalArgumentException("this layer is not exist in DoodleView.");
    }
    return paramString;
  }
  
  public rgf b(MotionEvent paramMotionEvent)
  {
    int i = this.oO.size() - 1;
    while (i >= 0)
    {
      rgf localrgf = (rgf)this.oO.get(i);
      if (localrgf.J(paramMotionEvent)) {
        return localrgf;
      }
      i -= 1;
    }
    return this.jdField_a_of_type_Rfs;
  }
  
  public void b(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
    Object localObject = (rfz)this.gh.get("LineLayer");
    if (localObject != null)
    {
      localObject = (rib)((rfz)localObject).a.b(103);
      if (localObject != null)
      {
        if (!paramEditVideoParams.La()) {
          break label55;
        }
        ((rib)localObject).setMode(104);
      }
    }
    return;
    label55:
    if ((paramEditVideoParams.a instanceof EditTakeVideoSource))
    {
      ((rib)localObject).setMode(105);
      return;
    }
    ((rib)localObject).setMode(103);
  }
  
  public void buk()
  {
    rfz localrfz = (rfz)this.gh.get("LineLayer");
    if ((localrfz != null) && (localrfz.a.Lt()) && (this.mBitmapWidth > 0)) {
      localrfz.a.xt(this.mBitmapWidth);
    }
  }
  
  public void buy()
  {
    setActiveLayer(this.jdField_a_of_type_Rfs);
  }
  
  public void buz()
  {
    if (this.oO != null)
    {
      Iterator localIterator = this.oO.iterator();
      while (localIterator.hasNext()) {
        ((rgf)localIterator.next()).clear();
      }
      if (this.g != null) {
        this.g.drawPaint(this.bd);
      }
    }
    super.invalidate();
  }
  
  public int getBitmapHeight()
  {
    return this.mBitmapHeight;
  }
  
  public int getBitmapWidth()
  {
    return this.mBitmapWidth;
  }
  
  protected void init()
  {
    this.bd = new Paint();
    this.bd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.oO = new ArrayList();
    this.gh = new LinkedHashMap();
    this.jdField_a_of_type_Rfs = new rfs(this);
    this.jdField_a_of_type_Rgf = this.jdField_a_of_type_Rfs;
  }
  
  public boolean isEmpty()
  {
    Iterator localIterator = this.oO.iterator();
    while (localIterator.hasNext()) {
      if (!((rgf)localIterator.next()).isEmpty()) {
        return false;
      }
    }
    return true;
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.oO.iterator();
    while (localIterator.hasNext()) {
      ((rgf)localIterator.next()).onDestroy();
    }
    recycleBitmap();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.isEnable) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.La()))
      {
        localIterator = this.gh.entrySet().iterator();
        while (localIterator.hasNext())
        {
          rgf localrgf = (rgf)((Map.Entry)localIterator.next()).getValue();
          if ((localrgf instanceof rfz)) {
            ((rfz)localrgf).a.aq(paramCanvas);
          }
        }
      }
      Iterator localIterator = this.gh.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((rgf)((Map.Entry)localIterator.next()).getValue()).draw(paramCanvas);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    if ((j != -2147483648) || (k == -2147483648)) {
      paramInt1 = i * 3 / 2;
    }
    setMeasuredDimension(i, paramInt1);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return;
    }
    if (this.jdField_a_of_type_Rgj != null)
    {
      ram.d("DoodleView", "DoodleViewWidth:" + paramInt1 + ",DoodleViewHeight:" + paramInt2 + ",MaxWidth:" + this.jdField_a_of_type_Rgj.bre + ",MaxHeight:" + this.jdField_a_of_type_Rgj.brf);
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      if (this.jdField_a_of_type_Rgj.bre == 0)
      {
        paramInt3 = this.mWidth;
        label108:
        if (this.jdField_a_of_type_Rgj.brf != 0) {
          break label227;
        }
      }
      label227:
      for (paramInt4 = this.mHeight;; paramInt4 = this.jdField_a_of_type_Rgj.brf)
      {
        float f = riw.a(this.mWidth, this.mHeight, paramInt3, paramInt4);
        this.mBitmapWidth = ((int)(this.mWidth * f));
        this.mBitmapHeight = ((int)(this.mHeight * f));
        Iterator localIterator = this.oO.iterator();
        while (localIterator.hasNext())
        {
          rgf localrgf = (rgf)localIterator.next();
          localrgf.ae(f);
          localrgf.setSize(paramInt1, paramInt2);
        }
        break;
        paramInt3 = this.jdField_a_of_type_Rgj.bre;
        break label108;
      }
    }
    this.mBitmapWidth = 0;
    this.mBitmapHeight = 0;
    ram.e("DoodleView", "DoodleConfig is null.");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Rgf == this.jdField_a_of_type_Rfs) && (paramMotionEvent.getAction() == 0))
    {
      this.jdField_a_of_type_Rgf = a(paramMotionEvent);
      this.jdField_a_of_type_Rgf.tJ(true);
      ram.d("DoodleView", this.jdField_a_of_type_Rgf.toString() + " hold the TouchEvent.");
    }
    return this.jdField_a_of_type_Rgf.M(paramMotionEvent);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (isShown()) {
      super.invalidate();
    }
  }
  
  public void recycleBitmap()
  {
    ram.d("DoodleView", "recycle bitmap.");
    if (Ly())
    {
      this.cH.recycle();
      this.cH = null;
      this.g = null;
    }
  }
  
  public void setActiveLayer(rgf paramrgf)
  {
    rgf localrgf = this.jdField_a_of_type_Rgf;
    this.jdField_a_of_type_Rgf = paramrgf;
    if (localrgf == this.jdField_a_of_type_Rgf) {
      return;
    }
    localrgf.onPause();
    this.jdField_a_of_type_Rgf.onResume();
  }
  
  public void setDoodleConfig(rgj paramrgj)
  {
    ram.d("DoodleView", "init DoodleConfig: " + paramrgj.toString());
    this.jdField_a_of_type_Rgj = paramrgj;
    this.oO.clear();
    this.gh.clear();
    bux();
  }
  
  public void setDoodleLayout(DoodleLayout paramDoodleLayout)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = paramDoodleLayout;
  }
  
  public void setEnableVisible(boolean paramBoolean)
  {
    this.isEnable = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView
 * JD-Core Version:    0.7.0.1
 */