import android.graphics.Canvas;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

class aatm
  extends aatv
{
  private static int cjY = 50;
  private aats a;
  private aats b;
  private int mCurPos;
  private String mWording;
  private float rC;
  
  public aatm(long paramLong1, long paramLong2, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, String paramString, float paramFloat4, int paramInt, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, Typeface paramTypeface)
  {
    super(paramLong1, paramLong2, paramBoolean);
    p(8, paramFloat1);
    p(9, paramFloat2);
    p(6, paramFloat5);
    this.rC = paramFloat5;
    p(5, g(paramFloat3, paramFloat2 * paramFloat1));
    this.mWording = paramString;
    this.mCurPos = 0;
    this.a = new aats(ci(this.mCurPos), paramFloat4, paramInt, paramFloat7, paramFloat9, paramTypeface);
    this.b = new aats(ci(this.mCurPos + cjY), paramFloat4, paramInt, paramFloat7, paramFloat9, paramTypeface);
    p(3, this.a.b.mWidth);
    p(4, this.a.b.mHeight);
    p(7, (paramFloat8 - this.a.b.mHeight) / 2.0F + paramFloat6);
  }
  
  private void a(Canvas paramCanvas, RenderBuffer paramRenderBuffer)
  {
    if ((paramCanvas == null) && (paramRenderBuffer == null)) {}
    float f;
    for (;;)
    {
      return;
      if (this.a != null)
      {
        f = q(6) + this.a.b.mWidth;
        if (f >= 0.0F)
        {
          if (paramCanvas == null) {
            break label102;
          }
          this.a.draw(paramCanvas, q(6), q(7));
        }
        while ((f - this.rC <= 0.0F) && (this.b != null))
        {
          if (paramCanvas == null) {
            break label125;
          }
          this.b.draw(paramCanvas, f, q(7));
          return;
          label102:
          this.a.a(paramRenderBuffer, q(6), q(7));
        }
      }
    }
    label125:
    this.b.a(paramRenderBuffer, f, q(7));
  }
  
  private String ci(int paramInt)
  {
    Object localObject;
    if (TextUtils.isEmpty(this.mWording))
    {
      localObject = "";
      return localObject;
    }
    if (this.mWording.length() <= paramInt) {
      return "";
    }
    if (this.mWording.length() > cjY + paramInt) {}
    for (String str = this.mWording.substring(paramInt, cjY + paramInt);; str = this.mWording.substring(paramInt, this.mWording.length()))
    {
      localObject = str;
      if (str != null) {
        break;
      }
      return "";
    }
  }
  
  private void cyw()
  {
    if ((this.a != null) && (this.b != null) && (this.b.bfJ))
    {
      Object localObject = this.a;
      this.a = this.b;
      this.b = ((aats)localObject);
      p(3, this.a.b.mWidth);
      p(6, q(6) + ((aats)localObject).a.mWidth);
      if (((aats)localObject).a.mText != null)
      {
        int i = this.mCurPos;
        this.mCurPos = (((aats)localObject).a.mText.length() + i);
      }
      localObject = ci(this.mCurPos + cjY);
      this.b.setText((String)localObject);
    }
  }
  
  private float g(float paramFloat1, float paramFloat2)
  {
    return paramFloat1 * paramFloat2;
  }
  
  public void a(RenderBuffer paramRenderBuffer)
  {
    a(null, paramRenderBuffer);
  }
  
  public void cbf()
  {
    if (this.a != null)
    {
      this.a.unInit();
      this.a = null;
    }
    if (this.b != null)
    {
      this.b.unInit();
      this.b = null;
    }
  }
  
  public void cyv()
  {
    super.cyv();
    if ((this.a != null) && (q(6) + this.a.b.mWidth <= 0.0F)) {
      cyw();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    a(paramCanvas, null);
  }
  
  public void reset()
  {
    this.mCurPos = 0;
    setText(this.mWording);
    p(6, this.rC);
  }
  
  public void setText(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while (paramString.equals(this.mWording));
      this.mWording = paramString;
      paramString = ci(this.mCurPos);
      if (this.a != null)
      {
        this.a.setText(paramString);
        p(3, this.a.b.mWidth);
        p(4, this.a.b.mHeight);
      }
      paramString = ci(this.mCurPos + cjY);
      if (this.b != null) {
        this.b.setText(paramString);
      }
    } while ((this.a == null) || (q(6) + this.a.b.mWidth >= 0.0F));
    cyw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aatm
 * JD-Core Version:    0.7.0.1
 */