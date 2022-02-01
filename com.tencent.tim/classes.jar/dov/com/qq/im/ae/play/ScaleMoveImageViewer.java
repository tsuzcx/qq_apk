package dov.com.qq.im.ae.play;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import axim;
import axja;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.videoshelf.ImagePositonManager;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import java.lang.reflect.Field;

public class ScaleMoveImageViewer
  extends ImageView
  implements View.OnClickListener, View.OnTouchListener
{
  private static final String TAG = ScaleMoveImageViewer.class.getSimpleName();
  private float Ar;
  private float Ed;
  private float Ee;
  private float Ef;
  private float Eg;
  private float Ei;
  private float Ej;
  private Matrix P = new Matrix();
  private a a;
  private NodeItem b = new NodeItem();
  private float bu;
  private float currentX;
  private float currentY;
  private boolean duN;
  private boolean duQ;
  private boolean duR;
  private boolean duS;
  private boolean duT = true;
  private int eFe;
  private LayerDrawable f;
  private Drawable hf;
  private Drawable hg;
  private Activity mActivity;
  private float[] values = new float[9];
  private Matrix x = new Matrix();
  private Matrix y = new Matrix();
  
  public ScaleMoveImageViewer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScaleMoveImageViewer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setScaleType(ImageView.ScaleType.MATRIX);
    this.mActivity = ((Activity)paramContext);
    setOnClickListener(this);
    eKw();
    this.f = ((LayerDrawable)getResources().getDrawable(2130837833));
    this.hf = this.f.findDrawableByLayerId(2131368904);
    this.hg = getResources().getDrawable(2130837904);
  }
  
  private void bU(Canvas paramCanvas)
  {
    if (!this.duN) {
      return;
    }
    this.f.setBounds(0, 0, getWidth(), getHeight());
    this.f.draw(paramCanvas);
  }
  
  private void bV(Canvas paramCanvas)
  {
    if (this.hg != null)
    {
      this.hg.setBounds(0, getHeight() / 2, getWidth(), getHeight());
      this.hg.draw(paramCanvas);
    }
  }
  
  private void eKt()
  {
    this.b.matrix.set(this.x);
  }
  
  private float getScale()
  {
    this.x.getValues(this.values);
    return Math.min(this.values[0], this.values[4]);
  }
  
  private void p(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = getScale();
    if (((f1 > 4.0F) && (paramFloat1 < 1.0F)) || ((f1 < 0.2F) && (paramFloat1 > 1.0F)) || ((paramFloat1 < 4.0F) && (paramFloat1 > 0.2F))) {
      this.x.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    }
    if (getScale() < this.Ej) {
      this.x.set(this.P);
    }
    ImagePositonManager.setShowPosition(getDrawable(), this.x, getWidth(), getHeight());
    setImageMatrix(this.x);
    eKt();
    this.P.set(this.x);
  }
  
  public NodeItem a()
  {
    return this.b;
  }
  
  public boolean aOF()
  {
    return this.duQ;
  }
  
  public void eKs()
  {
    if ((this.b.bitmap != null) && (!this.b.bitmap.isRecycled())) {
      this.b.bitmap.recycle();
    }
    if ((this.b.cropBitmap != null) && (!this.b.cropBitmap.isRecycled())) {
      this.b.cropBitmap.recycle();
    }
    setImageBitmap(null);
  }
  
  public void eKu()
  {
    this.b.matrix.getValues(this.values);
    int i = (int)((int)(0 - this.values[2]) / this.values[0]);
    int j = (int)((int)(0 - this.values[5]) / this.values[4]);
    int k = (int)(getWidth() / this.values[0]);
    int m = (int)(getHeight() / this.values[4]);
    if ((k <= 0) || (m <= 0) || (i < 0) || (j < 0))
    {
      if ((this.b.cropBitmap != null) && (!this.b.cropBitmap.isRecycled())) {
        this.b.cropBitmap.recycle();
      }
      if (this.b.bitmap != null) {
        this.b.cropBitmap = Bitmap.createBitmap(this.b.bitmap, 0, 0, this.b.bitmap.getWidth() - 1, this.b.bitmap.getHeight() - 1);
      }
      if (this.a != null) {
        this.a.a(this.b);
      }
    }
    for (;;)
    {
      return;
      if ((this.b.cropBitmap != null) && (!this.b.cropBitmap.isRecycled()) && (this.b.bitmap != this.b.cropBitmap)) {
        this.b.cropBitmap.recycle();
      }
      if ((this.b.bitmap != null) && (!this.b.bitmap.isRecycled())) {}
      try
      {
        this.b.cropBitmap = Bitmap.createBitmap(this.b.bitmap, i, j, k, m);
        if (this.a == null) {
          continue;
        }
        this.a.a(this.b);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          this.b.cropBitmap = this.b.bitmap;
        }
      }
    }
  }
  
  public void eKv()
  {
    this.duR = true;
  }
  
  public void eKw()
  {
    this.duR = false;
  }
  
  public int getNodeGroupID()
  {
    return this.b.nodeGroupID;
  }
  
  public int getNodeID()
  {
    return this.b.nodeID;
  }
  
  public void lv(int paramInt1, int paramInt2)
  {
    this.y.reset();
    this.x.set(this.y);
    this.b.once = false;
    int k = 720;
    int m = 1280;
    Drawable localDrawable = getDrawable();
    int j;
    int i;
    if (localDrawable != null)
    {
      j = localDrawable.getIntrinsicWidth();
      i = localDrawable.getIntrinsicHeight();
    }
    for (;;)
    {
      float f1 = Math.max(paramInt1 * 1.0F / j, paramInt2 * 1.0F / i);
      this.Ej = f1;
      this.x.postTranslate(paramInt1 / 2 - j / 2, paramInt2 / 2 - i / 2);
      this.x.postScale(f1, f1, paramInt1 / 2, paramInt2 / 2);
      setImageMatrix(this.x);
      this.P.set(this.x);
      eKt();
      return;
      i = m;
      j = k;
      if (this.b != null)
      {
        i = m;
        j = k;
        if (this.b.bitmap != null)
        {
          j = this.b.bitmap.getWidth();
          i = this.b.bitmap.getHeight();
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.duR) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      eKv();
      axim.a().eKG();
      axja.z(this.mActivity, this.b.nodeID);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.b.once) {
      lv(getWidth(), getHeight());
    }
    for (;;)
    {
      try
      {
        super.onDraw(paramCanvas);
        bU(paramCanvas);
        bV(paramCanvas);
        return;
      }
      catch (Throwable paramCanvas) {}
      this.x.set(this.b.matrix);
      setImageMatrix(this.x);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.currentX = 0.0F;
    this.currentY = 0.0F;
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < j)
    {
      this.currentX += paramMotionEvent.getX();
      this.currentY += paramMotionEvent.getY();
      i += 1;
    }
    this.currentX /= j;
    this.currentY /= j;
    if (j != this.eFe)
    {
      this.Ed = this.currentX;
      this.Ar = this.currentY;
      this.eFe = j;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.Ee = paramMotionEvent.getRawX();
      this.bu = paramMotionEvent.getRawY();
      this.duT = true;
      this.Ei = 0.0F;
      return true;
      this.duT = false;
      return true;
      float f1 = this.currentX;
      float f2 = this.Ed;
      float f3 = this.currentY;
      float f4 = this.Ar;
      ImagePositonManager.setMovePosition(getDrawable(), this.x, f1 - f2, f3 - f4, getWidth(), getHeight());
      setImageMatrix(this.x);
      eKt();
      this.Ed = this.currentX;
      this.Ar = this.currentY;
      if (paramMotionEvent.getPointerCount() == 2)
      {
        f1 = (paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F;
        f2 = (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F;
        f3 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
        f4 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
        f3 = (float)Math.sqrt(f3 * f3 + f4 * f4);
        if (this.Ei == 0.0F)
        {
          this.Ei = f3;
          return true;
        }
        if (Math.abs(f3 - this.Ei) >= 10.0F)
        {
          f4 = f3 / this.Ei;
          this.Ei = f3;
          p(f4, f1, f2);
          return true;
          this.Ef = paramMotionEvent.getRawX();
          this.Eg = paramMotionEvent.getRawY();
          this.eFe = 0;
          if ((Math.abs(this.Ef - this.Ee) > 10.0F) || (Math.abs(this.bu - this.Eg) > 10.0F))
          {
            if (this.a != null)
            {
              this.a.a(this.b);
              return true;
            }
          }
          else if (this.duT) {
            try
            {
              paramMotionEvent = View.class.getDeclaredField("mListenerInfo");
              paramMotionEvent.setAccessible(true);
              paramMotionEvent = paramMotionEvent.get(paramView);
              Field localField = paramMotionEvent.getClass().getDeclaredField("mOnClickListener");
              localField.setAccessible(true);
              paramMotionEvent = localField.get(paramMotionEvent);
              if ((paramMotionEvent != null) && ((paramMotionEvent instanceof View.OnClickListener)))
              {
                ((View.OnClickListener)paramMotionEvent).onClick(paramView);
                return true;
              }
            }
            catch (Exception paramView)
            {
              paramView.printStackTrace();
            }
          }
        }
      }
    }
    return true;
  }
  
  public void setImageSelected(boolean paramBoolean)
  {
    this.duQ = paramBoolean;
  }
  
  public void setMovable(boolean paramBoolean)
  {
    this.duS = paramBoolean;
    if (this.duS)
    {
      setOnTouchListener(this);
      return;
    }
    setOnTouchListener(null);
  }
  
  public void setNodeBitmap(Bitmap paramBitmap)
  {
    this.b.bitmap = paramBitmap;
    this.b.once = true;
    if (this.a != null) {
      this.a.a(this.b);
    }
  }
  
  public void setNodeInfo(NodeItem paramNodeItem)
  {
    this.b.nodeID = paramNodeItem.nodeID;
    this.b.nodeGroupID = paramNodeItem.nodeGroupID;
    this.b.once = paramNodeItem.once;
    this.b.matrix.set(paramNodeItem.matrix);
    this.b.bitmap = paramNodeItem.bitmap;
    this.b.maskRect = paramNodeItem.maskRect;
    this.b.zIndex = paramNodeItem.zIndex;
    this.b.type = paramNodeItem.type;
  }
  
  public void setOnSaveScrollInfoListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(NodeItem paramNodeItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.ScaleMoveImageViewer
 * JD-Core Version:    0.7.0.1
 */