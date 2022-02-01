import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

class aaty
  extends aatv
{
  aaul a = null;
  aaul b = null;
  Bitmap bz;
  int mTextureID = -1;
  
  public aaty(long paramLong1, long paramLong2, boolean paramBoolean, String paramString, float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, Typeface paramTypeface)
  {
    super(paramLong1, paramLong2, paramBoolean);
    p(6, paramFloat3);
    p(7, paramFloat4);
    this.a = new aaul(paramString, paramFloat1, paramInt, paramFloat5, paramFloat6, 2, -1.0F, paramTypeface);
    this.b = new aaul(paramString, paramFloat1, -16777216, paramFloat5, paramFloat6, 2, paramFloat2, paramTypeface);
    p(3, this.b.mWidth);
    paramInt = this.b.getLineCount();
    paramFloat1 = this.b.mHeight * 2.0F / paramInt;
    if (paramInt == 1) {
      paramFloat1 = this.b.mHeight;
    }
    p(4, paramFloat1);
    this.bz = a(this.b.mWidth, paramFloat1);
    if (this.bz != null)
    {
      paramString = new Canvas(this.bz);
      this.b.draw(paramString, 0.0F, paramFloat1 - this.b.mHeight);
      this.a.draw(paramString, 0.0F, paramFloat1 - this.b.mHeight);
    }
  }
  
  public void a(RenderBuffer paramRenderBuffer)
  {
    if ((this.mTextureID < 0) && (this.bz != null)) {
      this.mTextureID = GlUtil.createTexture(3553, this.bz);
    }
    if (this.mTextureID >= 0) {
      a(paramRenderBuffer, this.mTextureID, q(3), q(4), null, q(6), q(7));
    }
    if ((this.bz != null) && (Xn()))
    {
      this.bz.recycle();
      this.bz = null;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.bz == null)
    {
      this.b.draw(paramCanvas, q(6), q(7) + q(4) - this.b.mHeight);
      this.a.draw(paramCanvas, q(6), q(7) + q(4) - this.b.mHeight);
      return;
    }
    paramCanvas.drawBitmap(this.bz, q(6), q(7), null);
  }
  
  public void setText(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    float f;
    do
    {
      do
      {
        return;
      } while (paramString.equals(this.a.mText));
      this.a.setText(paramString);
      this.b.setText(paramString);
      int i = this.b.getLineCount();
      f = this.b.mHeight * 2.0F / i;
      if (i == 1) {
        f = this.b.mHeight;
      }
      p(4, f);
      p(3, this.b.mWidth);
      if (this.bz != null)
      {
        this.bz.recycle();
        this.bz = null;
      }
      this.bz = a(this.b.mWidth, f);
    } while (this.bz == null);
    paramString = new Canvas(this.bz);
    this.b.draw(paramString, 0.0F, f - this.b.mHeight);
    this.a.draw(paramString, 0.0F, f - this.b.mHeight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaty
 * JD-Core Version:    0.7.0.1
 */