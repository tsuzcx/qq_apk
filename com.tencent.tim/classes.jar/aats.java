import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

class aats
{
  public aaul a;
  public aaul b;
  public boolean bfJ;
  public Bitmap bz;
  public int mTextureID = -1;
  
  public aats(String paramString, float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, Typeface paramTypeface)
  {
    this.a = new aaul(paramString, paramFloat1, paramInt, paramFloat2, -1.0F, 1, -1.0F, paramTypeface);
    this.b = new aaul(paramString, paramFloat1, -1, paramFloat2, -1.0F, 1, paramFloat3, paramTypeface);
    if (!TextUtils.isEmpty(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      this.bfJ = bool;
      AT(paramString);
      return;
    }
  }
  
  private void AT(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.bz = null;
      if (this.mTextureID != -1)
      {
        GlUtil.deleteTexture(this.mTextureID);
        this.mTextureID = -1;
      }
    }
    do
    {
      return;
      if (this.bz != null) {
        this.bz.recycle();
      }
      if (this.mTextureID != -1)
      {
        GlUtil.deleteTexture(this.mTextureID);
        this.mTextureID = -1;
      }
      this.bz = aatv.a(this.b.mWidth + 5.0F, this.b.mHeight);
    } while (this.bz == null);
    paramString = new Canvas(this.bz);
    this.b.draw(paramString, 0.0F, 0.0F);
    this.a.draw(paramString, 0.0F, 0.0F);
  }
  
  private boolean aj(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 == null)) {}
    do
    {
      return true;
      if ((paramString1 == null) || (paramString2 == null)) {
        return false;
      }
    } while (paramString1.equals(paramString2));
    return false;
  }
  
  public void a(RenderBuffer paramRenderBuffer, float paramFloat1, float paramFloat2)
  {
    if ((paramRenderBuffer == null) || (!this.bfJ)) {}
    do
    {
      return;
      if ((this.mTextureID < 0) && (this.bz != null)) {
        this.mTextureID = GlUtil.createTexture(3553, this.bz);
      }
    } while (this.mTextureID < 0);
    aatv.a(paramRenderBuffer, this.mTextureID, this.b.mWidth, this.b.mHeight, null, paramFloat1, paramFloat2);
  }
  
  public void draw(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    if (!this.bfJ) {
      return;
    }
    if (this.bz == null)
    {
      this.b.draw(paramCanvas, paramFloat1, paramFloat2);
      this.a.draw(paramCanvas, paramFloat1, paramFloat2);
      return;
    }
    paramCanvas.drawBitmap(this.bz, paramFloat1, paramFloat2, null);
  }
  
  public void setText(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      this.bfJ = bool;
      if (!aj(paramString, this.a.mText))
      {
        this.a.setText(paramString);
        this.b.setText(paramString);
        AT(paramString);
      }
      return;
    }
  }
  
  public void unInit()
  {
    if (this.mTextureID != -1)
    {
      GlUtil.deleteTexture(this.mTextureID);
      this.mTextureID = -1;
    }
    if (this.bz != null)
    {
      this.bz.recycle();
      this.bz = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aats
 * JD-Core Version:    0.7.0.1
 */