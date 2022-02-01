import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

class aatq
{
  public aatp a;
  private aatr a;
  public boolean bfJ;
  public Bitmap bz;
  public int mTextureID = -1;
  public float rL;
  
  public aatq(String paramString, aatr paramaatr, Typeface paramTypeface)
  {
    this.jdField_a_of_type_Aatr = paramaatr;
    this.jdField_a_of_type_Aatp = new aatp(paramString, this.jdField_a_of_type_Aatr.eZ, this.jdField_a_of_type_Aatr.rJ, this.jdField_a_of_type_Aatr.rO, this.jdField_a_of_type_Aatr.rP, 0.0F, (this.jdField_a_of_type_Aatr.rM - this.jdField_a_of_type_Aatr.rJ) / 2.0F, paramTypeface);
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
      return;
    }
    if (this.bz != null) {
      this.bz.recycle();
    }
    if (this.mTextureID != -1)
    {
      GlUtil.deleteTexture(this.mTextureID);
      this.mTextureID = -1;
    }
    this.bz = aatv.a(this.jdField_a_of_type_Aatp.mWidth, this.jdField_a_of_type_Aatr.rM);
    if (this.bz != null)
    {
      paramString = new Canvas(this.bz);
      this.jdField_a_of_type_Aatp.am = 0.0F;
      this.jdField_a_of_type_Aatp.draw(paramString);
    }
    for (;;)
    {
      this.mTextureID = -1;
      return;
      QLog.d("BeanItemWrapper", 2, "createcache error:" + this.jdField_a_of_type_Aatp.mWidth + "-" + this.jdField_a_of_type_Aatr.rM);
    }
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
  
  public void a(RenderBuffer paramRenderBuffer, RectF paramRectF, float paramFloat1, float paramFloat2)
  {
    if ((paramRenderBuffer == null) || (!this.bfJ)) {}
    do
    {
      return;
      if ((this.mTextureID < 0) && (this.bz != null)) {
        this.mTextureID = GlUtil.createTexture(3553, this.bz);
      }
    } while (this.mTextureID < 0);
    aatv.a(paramRenderBuffer, this.mTextureID, this.jdField_a_of_type_Aatp.mWidth, this.jdField_a_of_type_Aatr.rM, paramRectF, paramFloat1, paramFloat2);
  }
  
  public void draw(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    if (!this.bfJ) {
      return;
    }
    if (this.bz == null)
    {
      this.jdField_a_of_type_Aatp.am = paramFloat1;
      paramFloat1 = this.jdField_a_of_type_Aatp.an;
      aatp localaatp = this.jdField_a_of_type_Aatp;
      localaatp.an += paramFloat2;
      this.jdField_a_of_type_Aatp.draw(paramCanvas);
      this.jdField_a_of_type_Aatp.an = paramFloat1;
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
      if (!aj(paramString, this.jdField_a_of_type_Aatp.mText))
      {
        this.jdField_a_of_type_Aatp.setText(paramString);
        AT(paramString);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aatq
 * JD-Core Version:    0.7.0.1
 */