import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

public class ayyt
  extends GPUBaseFilter
{
  private String cYk;
  private String coverUrl;
  private int mHeight;
  private float[] mMvpMatrix = new float[16];
  private int mPKCoverTextureID = -1;
  private int mPKTitleTextureID = -1;
  private RenderBuffer mRenderFBO;
  private TextureRender mTextureRender;
  private int mWidth;
  
  public ayyt(String paramString1, String paramString2)
  {
    this.coverUrl = paramString1;
    this.cYk = paramString2;
  }
  
  private int drawPKFrame(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mRenderFBO.bind();
    int i = GLES20.glCheckFramebufferStatus(36160);
    if (i != 36053)
    {
      SLog.e("GPUPKFilter", "fbo is not ready plz fix it error:" + i);
      return paramInt1;
    }
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16384);
    if (paramInt3 >= 0)
    {
      Matrix.setIdentityM(this.mMvpMatrix, 0);
      Matrix.translateM(this.mMvpMatrix, 0, 0.0F, 0.5F, 0.0F);
      Matrix.scaleM(this.mMvpMatrix, 0, 1.0F, 0.25F, 1.0F);
      this.mTextureRender.drawTexture(3553, paramInt3, null, this.mMvpMatrix);
    }
    if (paramInt2 >= 0)
    {
      Matrix.setIdentityM(this.mMvpMatrix, 0);
      Matrix.translateM(this.mMvpMatrix, 0, 0.5F, -0.24F, 0.0F);
      Matrix.scaleM(this.mMvpMatrix, 0, 0.5F, 0.5F, 1.0F);
      this.mTextureRender.drawTexture(3553, paramInt2, null, this.mMvpMatrix);
    }
    if (paramInt1 >= 0)
    {
      Matrix.setIdentityM(this.mMvpMatrix, 0);
      Matrix.translateM(this.mMvpMatrix, 0, -0.5F, -0.24F, 0.0F);
      Matrix.scaleM(this.mMvpMatrix, 0, 0.5F, 0.5F, 1.0F);
      this.mTextureRender.drawTexture(3553, paramInt1, null, this.mMvpMatrix);
    }
    this.mRenderFBO.unbind();
    return this.mRenderFBO.getTexId();
  }
  
  public void destroy()
  {
    super.destroy();
  }
  
  public void drawTexture(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    super.drawTexture(drawPKFrame(paramInt, this.mPKCoverTextureID, this.mPKTitleTextureID), paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    SLog.d("GPUPKFilter", "init");
    if (this.mTextureRender == null) {
      this.mTextureRender = new TextureRender();
    }
    if (this.mWidth > 720)
    {
      this.mHeight = (this.mHeight * 720 / this.mWidth);
      this.mWidth = 720;
    }
    if ((this.mWidth == 0) || (this.mHeight == 0))
    {
      this.mWidth = 720;
      this.mHeight = 1280;
    }
    if (this.mRenderFBO == null) {
      this.mRenderFBO = new RenderBuffer(this.mWidth, this.mHeight, 33984);
    }
    if ((this.mPKCoverTextureID < 0) && (FileUtil.fileExistsAndNotEmpty(this.coverUrl))) {}
    try
    {
      localBitmap = BitmapFactory.decodeFile(this.coverUrl);
      this.mPKCoverTextureID = GlUtil.createTexture(3553, localBitmap);
      localBitmap.recycle();
      if (this.mPKCoverTextureID < 0) {
        SLog.e("GPUPKFilter", "create the pk cover texture failed");
      }
      if ((this.mPKTitleTextureID >= 0) || (!FileUtil.fileExistsAndNotEmpty(this.cYk))) {}
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeFile(this.cYk);
        this.mPKTitleTextureID = GlUtil.createTexture(3553, localBitmap);
        localBitmap.recycle();
        if (this.mPKTitleTextureID < 0) {
          SLog.e("GPUPKFilter", "create the pk title texture failed");
        }
        return;
        localOutOfMemoryError1 = localOutOfMemoryError1;
        SLog.e("GPUPKFilter", "create the pk cover texture out of memory:" + localOutOfMemoryError1);
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        for (;;)
        {
          SLog.e("GPUPKFilter", "create the pk title texture out of memory:" + localOutOfMemoryError2);
        }
      }
    }
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    super.onOutputSizeChanged(paramInt1, paramInt2);
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayyt
 * JD-Core Version:    0.7.0.1
 */