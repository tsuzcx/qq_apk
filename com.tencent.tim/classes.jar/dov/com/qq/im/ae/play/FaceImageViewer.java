package dov.com.qq.im.ae.play;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
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

public class FaceImageViewer
  extends ImageView
  implements View.OnClickListener, View.OnTouchListener
{
  private static final String TAG = FaceImageViewer.class.getSimpleName();
  private float Ar;
  private final int DRAG = 1;
  private float Ed;
  private float Ee;
  private float Ef;
  private float Eg;
  private float Eh = 0.0F;
  private float Ei;
  private final int NONE = 0;
  private final int ZOOM = 2;
  private a a;
  private long aBT;
  private long actionDownTime;
  private NodeItem b = new NodeItem();
  private float bu;
  private float currentX;
  private float currentY;
  private boolean duN;
  private boolean duP;
  private boolean duQ;
  private boolean duR;
  private boolean duS;
  private boolean duT = true;
  private int eET;
  private final int eFa = 100;
  private final int eFb = 300;
  private final int eFc = 5;
  private int eFd;
  private int eFe;
  private LayerDrawable f;
  private Drawable hf;
  private boolean isFirstDraw = true;
  private Activity mActivity;
  private int mode = 0;
  private float[] values = new float[9];
  private Matrix x = new Matrix();
  private Matrix y = new Matrix();
  
  public FaceImageViewer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FaceImageViewer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setScaleType(ImageView.ScaleType.MATRIX);
    this.mActivity = ((Activity)paramContext);
    setOnClickListener(this);
    eKw();
    this.f = ((LayerDrawable)getResources().getDrawable(2130837833));
    this.hf = this.f.findDrawableByLayerId(2131368904);
  }
  
  private void aj(MotionEvent paramMotionEvent)
  {
    switch (this.mode)
    {
    }
    float f1;
    float f2;
    do
    {
      return;
      f1 = this.currentX;
      f2 = this.Ed;
      f3 = this.currentY;
      f4 = this.Ar;
      ImagePositonManager.setMovePosition(getDrawable(), this.x, f1 - f2, f3 - f4, getWidth(), getHeight());
      setImageMatrix(this.x);
      eKt();
      this.Ed = this.currentX;
      this.Ar = this.currentY;
      return;
      f1 = (paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F;
      f2 = (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F;
      f3 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
      f4 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
      f4 = (float)Math.sqrt(f3 * f3 + f4 * f4);
      if (this.Ei == 0.0F)
      {
        this.Ei = f4;
        return;
      }
    } while (Math.abs(f4 - this.Ei) < 1.0F);
    float f3 = f4 / this.Ei;
    this.Ei = f4;
    float f4 = d(paramMotionEvent);
    float f5 = this.Eh;
    this.Eh = d(paramMotionEvent);
    f(f3, f1, f2, f4 - f5);
  }
  
  private void bU(Canvas paramCanvas)
  {
    if (!this.duN) {
      return;
    }
    this.f.setBounds(0, 0, getWidth(), getHeight());
    this.f.draw(paramCanvas);
  }
  
  private float d(MotionEvent paramMotionEvent)
  {
    double d = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
    return (float)Math.toDegrees(Math.atan2(paramMotionEvent.getY(0) - paramMotionEvent.getY(1), d));
  }
  
  private void eKt()
  {
    this.b.matrix.set(this.x);
  }
  
  private void f(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.x.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    ImagePositonManager.setShowPosition(getDrawable(), this.x, getWidth(), getHeight());
    this.x.postRotate(paramFloat4, getWidth() / 2, getHeight() / 2);
    setImageMatrix(this.x);
    eKt();
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
    Bitmap localBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
    draw(new Canvas(localBitmap));
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.b.cropBitmap = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight());
      localBitmap.recycle();
    }
    if (this.a != null) {
      this.a.a(this.b);
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
  
  public void g(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.y.reset();
    this.x.set(this.y);
    this.x.postTranslate(paramFloat3, paramFloat4);
    this.x.postScale(paramFloat1, paramFloat1, getWidth() / 2, getHeight() / 2);
    this.x.postRotate(paramFloat2, getWidth() / 2, getHeight() / 2);
    setImageMatrix(this.x);
    eKt();
    this.b.once = false;
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
      this.x.postTranslate(paramInt1 / 2 - j / 2, paramInt2 / 2 - i / 2);
      this.x.postScale(f1, f1, paramInt1 / 2, paramInt2 / 2);
      setImageMatrix(this.x);
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
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return true;
      this.actionDownTime = System.currentTimeMillis();
      this.Ee = paramMotionEvent.getRawX();
      this.bu = paramMotionEvent.getRawY();
      this.duT = true;
      this.duP = false;
      this.eFd = 0;
      this.Ei = 0.0F;
      this.mode = 1;
      return true;
      this.duT = false;
      this.Eh = d(paramMotionEvent);
      this.duP = true;
      this.mode = 2;
      return true;
      this.mode = 0;
      return true;
      aj(paramMotionEvent);
      this.eFd += 1;
      return true;
      long l1 = System.currentTimeMillis();
      long l2 = this.actionDownTime;
      if (this.eFd > 5) {
        this.duP = true;
      }
      if (this.duP) {
        this.aBT = (l1 + 300L);
      }
      for (;;)
      {
        this.Ef = paramMotionEvent.getRawX();
        this.Eg = paramMotionEvent.getRawY();
        this.eFe = 0;
        if ((Math.abs(this.Ef - this.Ee) <= 10.0F) && (Math.abs(this.bu - this.Eg) <= 10.0F)) {
          break label406;
        }
        if (this.a == null) {
          break;
        }
        this.a.a(this.b);
        return true;
        if (l1 <= this.aBT) {
          this.duT = false;
        }
      }
      label406:
      if ((this.duT) && (l1 - l2 < 100L)) {
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
    return true;
  }
  
  public void setCenterViewWidth(int paramInt)
  {
    this.eET = paramInt;
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
 * Qualified Name:     dov.com.qq.im.ae.play.FaceImageViewer
 * JD-Core Version:    0.7.0.1
 */