package com.tencent.TMG.opengl.texture;

import android.graphics.Bitmap;
import android.opengl.GLUtils;
import com.tencent.TMG.opengl.glrenderer.GLCanvas;
import com.tencent.TMG.opengl.glrenderer.GLId;
import junit.framework.Assert;

public abstract class UploadedTexture
  extends BasicTexture
{
  private static final String TAG = "UploadedTexture";
  private static final int UPLOAD_LIMIT = 100;
  private static int sUploadedCount;
  boolean isBlend = false;
  protected Bitmap mBitmap;
  private boolean mContentValid = true;
  private boolean mIsUploading = false;
  private boolean mOpaque = true;
  private boolean mThrottled = false;
  
  protected UploadedTexture()
  {
    super(null, 0, 0);
  }
  
  private void freeBitmap()
  {
    if (this.mBitmap != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      onFreeBitmap(this.mBitmap);
      this.mBitmap = null;
      return;
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
  
  private void uploadToCanvas(GLCanvas paramGLCanvas)
  {
    boolean bool2 = false;
    Bitmap localBitmap = getBitmap();
    if (localBitmap != null) {
      try
      {
        int i = localBitmap.getWidth();
        int j = localBitmap.getHeight();
        int k = getTextureWidth();
        int m = getTextureHeight();
        boolean bool1 = bool2;
        if (i <= k)
        {
          bool1 = bool2;
          if (j <= m) {
            bool1 = true;
          }
        }
        Assert.assertTrue(bool1);
        paramGLCanvas.setTextureParameters(this);
        if ((i == k) && (j == m)) {
          paramGLCanvas.initializeTexture(this, localBitmap);
        }
        for (;;)
        {
          freeBitmap();
          setAssociatedCanvas(paramGLCanvas);
          this.mState = 1;
          this.mContentValid = true;
          return;
          i = GLUtils.getInternalFormat(localBitmap);
          j = GLUtils.getType(localBitmap);
          paramGLCanvas.initializeTextureSize(this, i, j);
          paramGLCanvas.texSubImage2D(this, 0, 0, localBitmap, i, j);
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
  
  public boolean isContentValid()
  {
    return (isLoaded()) && (this.mContentValid);
  }
  
  public boolean isOpaque()
  {
    return this.mOpaque;
  }
  
  public boolean isUploading()
  {
    return this.mIsUploading;
  }
  
  public boolean onBind(GLCanvas paramGLCanvas)
  {
    if ((getBitmap() != null) && (this.mId == null))
    {
      this.mId = new int[1];
      int j = paramGLCanvas.getGLId().generateTexture();
      int i = 0;
      while (i < 100) {
        if (isExistTextureid(j))
        {
          j = paramGLCanvas.getGLId().generateTexture();
          i += 1;
        }
        else
        {
          this.mId[0] = j;
        }
      }
    }
    updateContent(paramGLCanvas);
    return isContentValid();
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
  
  public void setIsBlend(boolean paramBoolean)
  {
    this.isBlend = paramBoolean;
  }
  
  protected void setIsUploading(boolean paramBoolean)
  {
    this.mIsUploading = paramBoolean;
  }
  
  public void setOpaque(boolean paramBoolean)
  {
    this.mOpaque = paramBoolean;
  }
  
  protected void setThrottled(boolean paramBoolean)
  {
    this.mThrottled = paramBoolean;
  }
  
  public void updateContent(GLCanvas paramGLCanvas)
  {
    if (!isLoaded()) {
      if (this.mThrottled)
      {
        i = sUploadedCount + 1;
        sUploadedCount = i;
        if (i <= 100) {}
      }
    }
    while (this.mContentValid)
    {
      int i;
      return;
      uploadToCanvas(paramGLCanvas);
      return;
    }
    Bitmap localBitmap = getBitmap();
    paramGLCanvas.texSubImage2D(this, 0, 0, localBitmap, GLUtils.getInternalFormat(localBitmap), GLUtils.getType(localBitmap));
    freeBitmap();
    this.mContentValid = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.opengl.texture.UploadedTexture
 * JD-Core Version:    0.7.0.1
 */