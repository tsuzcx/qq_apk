import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.annotation.CallSuper;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class aexe<DATA, CONFIG extends aext>
{
  private static final AtomicInteger bi = new AtomicInteger();
  protected long WZ;
  protected aexe.a a;
  protected aexj a;
  protected CONFIG a;
  protected aeyo a;
  protected final PriorityQueue<aexe.d> a;
  protected boolean bWS;
  protected boolean bWT;
  private volatile boolean bWU = true;
  protected int cPB;
  protected int cPC;
  protected int cPD = -1;
  private HashMap<String, Object> kf;
  private float mContentHeight = -1.0F;
  private float mContentWidth = -1.0F;
  private DATA mData;
  protected Bitmap mDrawCache;
  protected Canvas mDrawCacheCanvas;
  private volatile boolean mDrawCacheDirty = true;
  protected boolean mDrawCacheEnable;
  protected final int mIndex = bi.incrementAndGet();
  protected boolean mIsPaused;
  protected float mPaintHeight = -1.0F;
  protected float mPaintWidth = -1.0F;
  protected int mPerferredLine;
  protected int mRepeatTime;
  protected long mTime;
  protected int mVisibility;
  protected float vT;
  
  public aexe(aexj paramaexj)
  {
    this.jdField_a_of_type_Aexj = paramaexj;
    this.jdField_a_of_type_JavaUtilPriorityQueue = new PriorityQueue();
    initConfig();
    reset();
  }
  
  private void clear()
  {
    this.jdField_a_of_type_JavaUtilPriorityQueue.clear();
    this.cPB = 0;
    this.cPC = 0;
    this.mPaintWidth = -1.0F;
    this.mPaintHeight = -1.0F;
    this.mVisibility = 0;
    this.mDrawCache = null;
    this.mRepeatTime = 0;
    this.mPerferredLine = 0;
    this.mIsPaused = false;
    this.bWT = false;
    this.bWU = true;
    this.mDrawCacheDirty = true;
    this.mContentWidth = -1.0F;
    this.mContentHeight = -1.0F;
    if (this.kf != null)
    {
      Iterator localIterator = this.kf.values().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject instanceof aexe.b)) {
          ((aexe.b)localObject).recycle();
        }
      }
      this.kf.clear();
      this.kf = null;
    }
  }
  
  private void initConfig()
  {
    try
    {
      this.jdField_a_of_type_Aext = this.jdField_a_of_type_Aexj.a(getType());
      return;
    }
    catch (Exception localException)
    {
      while (!aewr.a().a().isDebug()) {}
      throw new RuntimeException("IDanmakuUIConfig should been provided by IDanmakuUIConfigCreator in DanmakuContext");
    }
  }
  
  public int CK()
  {
    return this.cPB;
  }
  
  public int CL()
  {
    return this.cPC;
  }
  
  public void HA(boolean paramBoolean)
  {
    this.bWS = paramBoolean;
  }
  
  public void Hz(boolean paramBoolean)
  {
    this.bWU = paramBoolean;
  }
  
  public void Mm(int paramInt)
  {
    this.mRepeatTime = paramInt;
  }
  
  public aeyj a(aeyr paramaeyr)
  {
    return new aeyj(-1);
  }
  
  public abstract void a(float paramFloat1, float paramFloat2, long paramLong1, long paramLong2);
  
  public void a(aeyo paramaeyo)
  {
    this.jdField_a_of_type_Aeyo = paramaeyo;
  }
  
  public void aE(float paramFloat)
  {
    this.jdField_a_of_type_Aeyo.setFactor(paramFloat);
  }
  
  public void aF(float paramFloat)
  {
    this.vT = paramFloat;
  }
  
  public boolean aiy()
  {
    return this.bWU;
  }
  
  public boolean aiz()
  {
    return this.bWS;
  }
  
  public final void ap(long paramLong1, long paramLong2)
  {
    if (this.mIsPaused) {
      this.WZ += paramLong1;
    }
    iZ(paramLong2);
    if (!this.jdField_a_of_type_JavaUtilPriorityQueue.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilPriorityQueue.iterator();
      while (localIterator.hasNext())
      {
        aexe.d locald = (aexe.d)localIterator.next();
        locald.Xa -= paramLong1;
        if (locald.Xa <= 0L)
        {
          localIterator.remove();
          locald.a.j(this);
        }
      }
    }
  }
  
  public boolean b(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    boolean bool = true;
    float[] arrayOfFloat = getRectAtTime(paramLong);
    if (arrayOfFloat == null) {
      return false;
    }
    if ((arrayOfFloat[0] <= paramFloat1) && (paramFloat1 <= arrayOfFloat[2] + paramFloat3) && (arrayOfFloat[1] <= paramFloat2) && (paramFloat2 <= arrayOfFloat[3])) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean bX(long paramLong)
  {
    return (this.WZ > 0L) && (paramLong - this.WZ >= this.jdField_a_of_type_Aeyo.value());
  }
  
  public boolean bY(long paramLong)
  {
    return (this.WZ > 0L) && (paramLong - this.WZ < 0L);
  }
  
  public void cXT()
  {
    a(new aeyo(aexj.a().getDuration()));
    cXU();
  }
  
  protected void cXU() {}
  
  public void cXV()
  {
    float f = getLeft();
    if ((!this.bWT) && (f < getScreenWidth()))
    {
      aeyw.i("BaseDanmaku", "onFirstExposure, danmaku = " + toString());
      cXX();
      this.bWT = true;
    }
    if ((this.jdField_a_of_type_Aexe$a != null) && (f <= 0.0F))
    {
      this.jdField_a_of_type_Aexe$a.i(this);
      this.jdField_a_of_type_Aexe$a = null;
    }
  }
  
  @CallSuper
  public void cXW()
  {
    Hz(false);
  }
  
  protected void cXX()
  {
    if (this.jdField_a_of_type_Aexj != null) {
      this.jdField_a_of_type_Aexj.k(this);
    }
  }
  
  public void clearDrawCacheCanvas()
  {
    this.mDrawCacheCanvas.setBitmap(null);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (aexe)paramObject;
      if (this.mData != null) {
        return this.mData.equals(paramObject.mData);
      }
    } while (paramObject.mData == null);
    return false;
  }
  
  public long fA()
  {
    return this.WZ;
  }
  
  public long fz()
  {
    return this.WZ + getDuration();
  }
  
  public abstract float getBottom();
  
  public abstract float[] getCollisionRectAtTime(long paramLong);
  
  public float getContentLeft()
  {
    return getLeft() + aexj.a().getMarginHorizontal();
  }
  
  public float getContentTop()
  {
    return getTop() + getMarginVertical();
  }
  
  public DATA getData()
  {
    return this.mData;
  }
  
  public Bitmap getDrawCache()
  {
    return this.mDrawCache;
  }
  
  public Canvas getDrawCacheCanvas()
  {
    return this.mDrawCacheCanvas;
  }
  
  public long getDuration()
  {
    return this.jdField_a_of_type_Aeyo.value();
  }
  
  public long getIndex()
  {
    return this.mIndex;
  }
  
  public abstract float getLeft();
  
  public int getMarginVertical()
  {
    return aexj.a().getMarginVertical();
  }
  
  public float getPaintHeight()
  {
    return this.mPaintHeight;
  }
  
  public float getPaintWidth()
  {
    return this.mPaintWidth;
  }
  
  public int getPerferredLine(int paramInt)
  {
    if (this.mPerferredLine > paramInt) {
      return paramInt - 1;
    }
    return this.mPerferredLine;
  }
  
  public abstract float[] getRectAtTime(long paramLong);
  
  public int getRepeatTime()
  {
    return this.mRepeatTime;
  }
  
  public abstract float getRight();
  
  public int getScreenHeight()
  {
    return aexj.a().getScreenHeight();
  }
  
  public int getScreenWidth()
  {
    return aexj.a().getScreenWidth();
  }
  
  public abstract float getSpeedX();
  
  public long getTime()
  {
    return this.mTime;
  }
  
  public abstract float getTop();
  
  public abstract int getType();
  
  public int hashCode()
  {
    if (this.mData == null) {
      return 0;
    }
    return this.mData.hashCode();
  }
  
  public int hf(int paramInt)
  {
    if (this.cPD >= paramInt) {
      return paramInt - 1;
    }
    return this.cPD;
  }
  
  public abstract void iZ(long paramLong);
  
  public boolean isClickEnable()
  {
    return aexj.a().isClickEnable();
  }
  
  public boolean isDrawCacheDirty()
  {
    return this.mDrawCacheDirty;
  }
  
  public boolean isDrawCacheEnable()
  {
    return (this.mDrawCacheEnable) && (aexx.isGlobalDrawCacheEnable());
  }
  
  public boolean isMeasured()
  {
    return (this.mPaintWidth >= 0.0F) && (this.mPaintHeight >= 0.0F) && (!aiy());
  }
  
  public boolean isPaused()
  {
    return this.mIsPaused;
  }
  
  public boolean isShown()
  {
    return this.mVisibility == 1;
  }
  
  public boolean isTimeOut(long paramLong)
  {
    if (this.bWS) {}
    while (paramLong - this.mTime < this.jdField_a_of_type_Aeyo.value()) {
      return false;
    }
    return true;
  }
  
  public void ja(long paramLong)
  {
    this.WZ = paramLong;
  }
  
  public void pause()
  {
    this.mIsPaused = true;
  }
  
  public boolean repeat(int paramInt)
  {
    if ((aiz()) || (this.mRepeatTime - paramInt >= 0))
    {
      this.mRepeatTime -= paramInt;
      this.WZ += paramInt;
      return true;
    }
    return false;
  }
  
  @CallSuper
  public void reset()
  {
    aexx localaexx = aexj.a();
    aF(localaexx.aX());
    setDrawCacheEnable(localaexx.isDrawCacheEnable());
    clear();
    cXT();
  }
  
  public void resume()
  {
    this.mIsPaused = false;
  }
  
  public void setContentHeight(float paramFloat)
  {
    this.mContentHeight = paramFloat;
  }
  
  public void setContentWidth(float paramFloat)
  {
    this.mContentWidth = paramFloat;
  }
  
  public void setData(DATA paramDATA)
  {
    if ((aewr.a().a().isDebug()) && (paramDATA == null)) {
      throw new RuntimeException("Danmaku data should been null");
    }
    this.mData = paramDATA;
    setDrawCacheDirty(true);
  }
  
  public void setDrawCache(Bitmap paramBitmap)
  {
    this.mDrawCache = paramBitmap;
  }
  
  public void setDrawCacheCanvas(Canvas paramCanvas)
  {
    this.mDrawCacheCanvas = paramCanvas;
    setDrawCacheDirty(true);
  }
  
  public void setDrawCacheDirty(boolean paramBoolean)
  {
    this.mDrawCacheDirty = paramBoolean;
  }
  
  public void setDrawCacheEnable(boolean paramBoolean)
  {
    this.mDrawCacheEnable = paramBoolean;
  }
  
  public void setPaintHeight(float paramFloat)
  {
    this.mPaintHeight = paramFloat;
  }
  
  public void setPaintWidth(float paramFloat)
  {
    this.mPaintWidth = paramFloat;
  }
  
  public void setTime(long paramLong)
  {
    this.mTime = paramLong;
  }
  
  public void setVisibility(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mVisibility = 1;
      return;
    }
    this.mVisibility = 0;
  }
  
  public String toString()
  {
    return "BaseDanmaku" + this.mIndex + "[left:" + getLeft() + ",top:" + getTop() + ",right:" + getRight() + ",bottom:" + getBottom() + ", time:" + this.mTime + ", mData=" + String.valueOf(this.mData) + ", mType=" + getType() + ", playerTime=" + this.jdField_a_of_type_Aexj.getPlayTime() + "]";
  }
  
  public static abstract interface a
  {
    public abstract void i(aexe paramaexe);
  }
  
  public static abstract interface b
  {
    public abstract void recycle();
  }
  
  public static abstract interface c
  {
    public abstract void j(aexe paramaexe);
  }
  
  public static final class d
    implements Comparable<d>
  {
    public long Xa;
    public final aexe.c a;
    
    public int a(d paramd)
    {
      if (paramd == null) {}
      do
      {
        return 1;
        if (this.Xa > paramd.Xa) {
          return -1;
        }
      } while (this.Xa < paramd.Xa);
      return 0;
    }
    
    public String toString()
    {
      return "mRemainTime:" + this.Xa;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aexe
 * JD-Core Version:    0.7.0.1
 */