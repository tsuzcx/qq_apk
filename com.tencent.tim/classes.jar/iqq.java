import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.qphone.base.util.QLog;

public abstract class iqq
  extends iqk
{
  private static int sUploadedCount;
  boolean isBlend = false;
  protected Bitmap mBitmap;
  private boolean mContentValid = true;
  private boolean mOpaque = true;
  private boolean mThrottled;
  
  protected iqq()
  {
    super(null, 0);
  }
  
  private void c(ipm paramipm)
  {
    Bitmap localBitmap = getBitmap();
    if (localBitmap != null) {
      try
      {
        int i = localBitmap.getWidth();
        int j = localBitmap.getHeight();
        int k = getTextureWidth();
        int m = getTextureHeight();
        if (this.mId == null) {
          this.mId = new int[1];
        }
        this.mId[0] = paramipm.a().generateTexture();
        paramipm.a(this);
        if ((i == k) && (j == m)) {
          paramipm.a(this, localBitmap);
        }
        for (;;)
        {
          freeBitmap();
          a(paramipm);
          this.mState = 1;
          this.mContentValid = true;
          return;
          i = GLUtils.getInternalFormat(localBitmap);
          j = GLUtils.getType(localBitmap);
          paramipm.a(this, i, j);
          paramipm.a(this, 0, 0, localBitmap, i, j);
        }
        this.mState = -1;
      }
      finally
      {
        freeBitmap();
      }
    }
    throw new RuntimeException("Texture load fail, no bitmap");
  }
  
  private void freeBitmap()
  {
    if (this.mBitmap != null)
    {
      onFreeBitmap(this.mBitmap);
      this.mBitmap = null;
    }
  }
  
  private Bitmap getBitmap()
  {
    if (this.mBitmap == null)
    {
      this.mBitmap = onGetBitmap();
      if (this.mBitmap != null)
      {
        int i = this.mBitmap.getWidth();
        int j = this.mBitmap.getHeight();
        if (this.mWidth == -1) {
          setTextureSize(i, j);
        }
      }
    }
    return this.mBitmap;
  }
  
  public static void resetUploadLimit()
  {
    sUploadedCount = 0;
  }
  
  public static boolean uploadLimitReached()
  {
    return sUploadedCount > 100;
  }
  
  public boolean a(ipm paramipm)
  {
    b(paramipm);
    return true;
  }
  
  public iqi[] a(ipm paramipm)
  {
    if (this.isBlend)
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 771);
    }
    return super.a(paramipm);
  }
  
  public void b(ipm paramipm)
  {
    if (!isLoaded()) {
      if (this.mThrottled)
      {
        int i = sUploadedCount + 1;
        sUploadedCount = i;
        if (i <= 100) {}
      }
    }
    do
    {
      for (;;)
      {
        return;
        c(paramipm);
        return;
        if (!this.mContentValid)
        {
          Bitmap localBitmap = getBitmap();
          if (localBitmap != null) {
            try
            {
              if (!localBitmap.isRecycled())
              {
                paramipm.a(this, 0, 0, localBitmap, GLUtils.getInternalFormat(localBitmap), GLUtils.getType(localBitmap));
                freeBitmap();
                this.mContentValid = true;
                return;
              }
            }
            catch (IllegalArgumentException paramipm) {}
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("UploadedTexture", 2, "WL_DEBUG updateContent e = " + paramipm);
  }
  
  public int getSourceHeight()
  {
    if (this.mWidth == -1) {
      getBitmap();
    }
    return this.mHeight;
  }
  
  public int getSourceWidth()
  {
    if (this.mWidth == -1) {
      getBitmap();
    }
    return this.mWidth;
  }
  
  public int getTarget()
  {
    return 3553;
  }
  
  protected void invalidateContent()
  {
    if (this.mBitmap != null) {
      freeBitmap();
    }
    this.mContentValid = false;
    this.mWidth = -1;
    this.mHeight = -1;
  }
  
  public boolean isOpaque()
  {
    return this.mOpaque;
  }
  
  protected abstract void onFreeBitmap(Bitmap paramBitmap);
  
  protected abstract Bitmap onGetBitmap();
  
  public void recycle()
  {
    super.recycle();
    if (this.mBitmap != null) {
      freeBitmap();
    }
  }
  
  public void setOpaque(boolean paramBoolean)
  {
    this.mOpaque = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iqq
 * JD-Core Version:    0.7.0.1
 */