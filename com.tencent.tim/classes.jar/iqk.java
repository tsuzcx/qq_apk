import android.graphics.Rect;
import android.opengl.GLES20;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class iqk
{
  private static WeakHashMap<iqk, Object> sAllTextures = new WeakHashMap();
  private static ThreadLocal<Class<iqk>> sInFinalizer = new ThreadLocal();
  protected ipm a;
  protected int arV;
  protected int mHeight = -1;
  protected int[] mId;
  protected int mLeft;
  protected int mState;
  protected int mTextureHeight;
  protected int mTextureWidth;
  protected int mTop;
  protected int mWidth = -1;
  protected int viewHeight;
  protected int viewWidth;
  
  protected iqk()
  {
    this(null, 0);
  }
  
  protected iqk(ipm arg1, int paramInt)
  {
    a(???);
    this.mState = paramInt;
    this.arV = 0;
    synchronized (sAllTextures)
    {
      sAllTextures.put(this, null);
      return;
    }
  }
  
  private void freeResource()
  {
    ipm localipm = this.a;
    if ((localipm != null) && (this.mId != null))
    {
      localipm.a(this);
      this.mId = null;
    }
    this.mState = 0;
    a(null);
  }
  
  public static boolean inFinalizer()
  {
    return sInFinalizer.get() != null;
  }
  
  public static void invalidateAllTextures()
  {
    synchronized (sAllTextures)
    {
      Iterator localIterator = sAllTextures.keySet().iterator();
      if (localIterator.hasNext())
      {
        iqk localiqk = (iqk)localIterator.next();
        localiqk.mState = 0;
        localiqk.a(null);
      }
    }
  }
  
  public static void yieldAllTextures()
  {
    synchronized (sAllTextures)
    {
      Iterator localIterator = sAllTextures.keySet().iterator();
      if (localIterator.hasNext()) {
        ((iqk)localIterator.next()).yield();
      }
    }
  }
  
  protected TextureProgram a()
  {
    return iqg.a(this.arV);
  }
  
  protected void a(ipm paramipm)
  {
    this.a = paramipm;
  }
  
  public void a(ipm paramipm, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramipm.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public abstract boolean a(ipm paramipm);
  
  public int[] a(ipm paramipm)
  {
    return this.mId;
  }
  
  public iqi[] a(ipm paramipm)
  {
    int i = 0;
    TextureProgram localTextureProgram = a();
    GLES20.glUseProgram(localTextureProgram.getId());
    irc.lx();
    if ((!isOpaque()) || (paramipm.getAlpha() < 0.95F)) {}
    for (boolean bool = true;; bool = false)
    {
      ipn.enableBlending(bool);
      if (!a(paramipm)) {
        break;
      }
      int[] arrayOfInt = getId();
      while (i < arrayOfInt.length)
      {
        GLES20.glActiveTexture(33984 + i);
        irc.lx();
        GLES20.glBindTexture(getTarget(), arrayOfInt[i]);
        irc.lx();
        GLES20.glUniform1i(localTextureProgram.a()[(i + 4)].handle, i);
        irc.lx();
        i += 1;
      }
    }
    GLES20.glUniform1f(localTextureProgram.a()[2].handle, paramipm.getAlpha());
    irc.lx();
    return localTextureProgram.a();
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      sInFinalizer.set(iqk.class);
      recycle();
      sInFinalizer.set(null);
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int[] getId()
  {
    return this.mId;
  }
  
  public Rect getSourceBounds()
  {
    return new Rect(this.mLeft, this.mTop, this.mLeft + this.mWidth, this.mTop + this.mHeight);
  }
  
  public int getSourceHeight()
  {
    return this.mHeight;
  }
  
  public int getSourceWidth()
  {
    return this.mWidth;
  }
  
  public abstract int getTarget();
  
  public int getTextureHeight()
  {
    return this.mTextureHeight;
  }
  
  public int getTextureWidth()
  {
    return this.mTextureWidth;
  }
  
  public int getViewHeight()
  {
    return this.viewHeight;
  }
  
  public int getViewWidth()
  {
    return this.viewWidth;
  }
  
  public void i(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mLeft = paramInt1;
    this.mTop = paramInt2;
    this.mWidth = paramInt3;
    this.mHeight = paramInt4;
  }
  
  public boolean isFlippedVertically()
  {
    return false;
  }
  
  public boolean isLoaded()
  {
    return this.mState == 1;
  }
  
  public abstract boolean isOpaque();
  
  public void lr(int paramInt)
  {
    this.viewWidth = paramInt;
  }
  
  public int ls()
  {
    return 0;
  }
  
  public int lt()
  {
    return 0;
  }
  
  public void recycle()
  {
    freeResource();
  }
  
  public void setSourceSize(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  public void setTextureSize(int paramInt1, int paramInt2)
  {
    this.mTextureWidth = paramInt1;
    this.mTextureHeight = paramInt2;
    if (((this.mTextureWidth > 4096) || (this.mTextureHeight > 4096)) && (QLog.isColorLevel())) {
      QLog.w("BasicTexture", 2, String.format("texture is too large: %d x %d", new Object[] { Integer.valueOf(this.mTextureWidth), Integer.valueOf(this.mTextureHeight) }), new Exception());
    }
    if (this.mWidth == -1)
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
    }
  }
  
  public void setViewHeight(int paramInt)
  {
    this.viewHeight = paramInt;
  }
  
  public byte[] y()
  {
    return null;
  }
  
  public void yield()
  {
    freeResource();
  }
  
  public byte[] z()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iqk
 * JD-Core Version:    0.7.0.1
 */