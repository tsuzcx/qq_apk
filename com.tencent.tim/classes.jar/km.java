import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.CharacterStyle;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;

public class km
{
  private kp a;
  private CharacterStyle b;
  private int hO = -1;
  private int hP;
  private int hR = -1;
  private int hS;
  private int hT;
  private int mHeight;
  private String mText;
  private int mType;
  private int mWidth;
  
  public km(CharacterStyle paramCharacterStyle, int paramInt)
  {
    this.b = paramCharacterStyle;
    if ((paramCharacterStyle instanceof aofk.a))
    {
      paramCharacterStyle = ((aofk.a)paramCharacterStyle).getDrawable().getBounds();
      this.mWidth = paramCharacterStyle.width();
      this.mHeight = paramCharacterStyle.height();
    }
    for (;;)
    {
      this.hO = paramInt;
      this.mType = 2;
      return;
      if ((paramCharacterStyle instanceof amfz))
      {
        paramCharacterStyle = (amfz)paramCharacterStyle;
        this.mWidth = paramCharacterStyle.IF();
        this.mHeight = paramCharacterStyle.getHeight();
      }
    }
  }
  
  public km(String paramString)
  {
    this.mText = paramString;
    this.hP = -1;
    this.mType = 0;
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint)
  {
    if ((this.b instanceof aofk.a))
    {
      localObject = (aofk.a)this.b;
      paramInt2 += ((aofk.a)localObject).getDrawable().getBounds().height();
      ((aofk.a)localObject).draw(paramCanvas, null, 0, 0, paramInt1, 0, paramInt2, paramInt2, paramPaint);
    }
    while (!(this.b instanceof amfz)) {
      return;
    }
    paramPaint.setTextSize(getFontSize());
    Object localObject = (amfz)this.b;
    int i = ((amfz)localObject).getHeight();
    ((amfz)localObject).cCu = false;
    ((amfz)localObject).draw(paramCanvas, null, 0, 0, paramInt1, 0, paramInt2, paramInt2 + i, paramPaint);
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, ETFont paramETFont, int paramInt1, int paramInt2)
  {
    Paint localPaint = paramPaint;
    if (paramPaint == null) {
      localPaint = new Paint();
    }
    localPaint.reset();
    localPaint.setColor(paramETFont.getColor());
    localPaint.setAntiAlias(true);
    localPaint.setDither(true);
    localPaint.setTextSize(paramETFont.getSize());
    int i = (int)localPaint.getFontMetrics().ascent;
    paramCanvas.drawText(this.mText, paramInt1, paramInt2 - i, localPaint);
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, ETFont paramETFont, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramPaint == null) {
      paramPaint = new Paint();
    }
    for (;;)
    {
      paramPaint.reset();
      paramPaint.setColor(paramETFont.getColor());
      paramPaint.setStrokeWidth(paramETFont.getSize() / 12);
      paramInt2 = paramInt2 + paramInt3 - 3;
      paramInt3 = this.mWidth;
      paramCanvas.drawLine(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2, paramPaint);
      return;
    }
  }
  
  private void a(ETEngine paramETEngine)
  {
    ETFont localETFont = this.a.a();
    if ((localETFont == null) || (paramETEngine == null))
    {
      this.hR = 0;
      return;
    }
    if ((this.mText == null) || (this.mText.length() == 0))
    {
      this.hR = 0;
      return;
    }
    Paint.FontMetrics localFontMetrics = new Paint.FontMetrics();
    paramETEngine.native_getFontMetrics(localFontMetrics, localETFont);
    this.hR = ((int)Math.abs(localFontMetrics.descent));
  }
  
  public void P(int paramInt)
  {
    if (this.mType == 0)
    {
      this.hS = paramInt;
      this.hT = (this.mText.length() + paramInt);
      return;
    }
    this.hS = 0;
    this.hT = 0;
  }
  
  public String R()
  {
    if (this.mType == 0) {
      return this.mText;
    }
    return null;
  }
  
  public String T()
  {
    if (1 == this.mType) {
      return this.mText;
    }
    return null;
  }
  
  public int a(ETEngine paramETEngine)
  {
    if (this.hR < 0) {
      a(paramETEngine);
    }
    return this.hR;
  }
  
  public CharacterStyle a()
  {
    return this.b;
  }
  
  public aofk.a a()
  {
    if ((this.b instanceof aofk.a)) {
      return (aofk.a)this.b;
    }
    return null;
  }
  
  public kp a()
  {
    return this.a;
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    Paint localPaint;
    if ((paramCanvas != null) && (this.a != null))
    {
      localPaint = new Paint();
      if (this.a.au() == true)
      {
        localPaint.setColor(this.a.ay());
        localPaint.setStyle(Paint.Style.FILL);
        paramCanvas.drawRect(new Rect(paramInt1, paramInt2, this.mWidth + paramInt1, paramInt2 + paramInt3), localPaint);
      }
      if (this.b == null) {
        break label101;
      }
      a(paramCanvas, paramInt1, paramInt2 + paramInt3 - this.mHeight, localPaint);
    }
    label101:
    ETFont localETFont;
    do
    {
      do
      {
        return;
        localETFont = this.a.a();
      } while (localETFont == null);
      if (this.a.av() == true) {
        a(paramCanvas, localPaint, localETFont, paramInt1, paramInt2, paramInt3);
      }
    } while ((this.mText == null) || (this.mType != 1));
    a(paramCanvas, localPaint, localETFont, paramInt1, paramInt2);
  }
  
  public void a(ETEngine paramETEngine, Bitmap paramBitmap, ETDecoration paramETDecoration, int paramInt1, int paramInt2)
  {
    if ((paramETEngine == null) || (paramBitmap == null) || (this.a == null)) {}
    ETFont localETFont;
    do
    {
      do
      {
        return;
      } while ((this.mText == null) || (this.mText.length() == 0) || (this.mType != 0));
      localETFont = this.a.a();
      if (paramETDecoration == null)
      {
        paramETEngine.native_drawText(this.mText, paramBitmap, paramInt1, paramInt2, localETFont);
        return;
      }
    } while (1 != paramETDecoration.getDecorationType());
    paramETDecoration.drawFrameText(this.hS, this.hT, paramBitmap, paramInt1, paramInt2, localETFont);
  }
  
  public void a(kp paramkp)
  {
    this.a = paramkp;
  }
  
  public kr[] a(ETEngine paramETEngine, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = 0;
    if ((2 == this.mType) || (1 == this.mType))
    {
      paramETEngine = new Rect(paramInt1, paramInt2, this.mWidth + paramInt1, paramInt2 + paramInt3);
      localObject1 = new kr();
      ((kr)localObject1).text = this.mText;
      ((kr)localObject1).f = paramETEngine;
      ((kr)localObject1).lineIndex = paramInt4;
      paramETEngine = new kr[1];
      paramETEngine[0] = localObject1;
      return paramETEngine;
    }
    Object localObject1 = this.a.a();
    Object localObject2 = new Paint();
    ((Paint)localObject2).setTextSize(((ETFont)localObject1).getSize());
    int k = this.mText.length();
    int[] arrayOfInt = new int[k];
    paramETEngine.native_getTextWidths(this.mText, (ETFont)localObject1, (Paint)localObject2, arrayOfInt);
    localObject1 = new kr[k];
    int i = paramInt1;
    paramInt1 = j;
    for (;;)
    {
      paramETEngine = (ETEngine)localObject1;
      if (paramInt1 >= k) {
        break;
      }
      j = arrayOfInt[paramInt1] + i;
      paramETEngine = new Rect(i, paramInt2, j, paramInt2 + paramInt3);
      localObject2 = new kr();
      ((kr)localObject2).lineIndex = paramInt4;
      ((kr)localObject2).text = String.valueOf(this.mText.charAt(paramInt1));
      ((kr)localObject2).f = paramETEngine;
      localObject1[paramInt1] = localObject2;
      paramInt1 += 1;
      i = j;
    }
  }
  
  public void b(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    Paint localPaint;
    if ((paramCanvas != null) && (this.a != null))
    {
      localPaint = new Paint();
      if (this.b == null) {
        break label28;
      }
    }
    label28:
    ETFont localETFont;
    do
    {
      return;
      localETFont = this.a.a();
    } while ((localETFont == null) || (this.a.av() != true));
    a(paramCanvas, localPaint, localETFont, paramInt1, paramInt2, paramInt3);
  }
  
  public int getFontSize()
  {
    ETFont localETFont = this.a.a();
    if (localETFont != null) {
      return localETFont.getSize();
    }
    return 16;
  }
  
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public int getLineNumber()
  {
    return this.hP;
  }
  
  public int getSpanIndex()
  {
    return this.hO;
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
  
  public void setHeight(int paramInt)
  {
    this.mHeight = paramInt;
  }
  
  public void setLineNumber(int paramInt)
  {
    this.hP = paramInt;
  }
  
  public void setText(String paramString)
  {
    this.mText = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public void setWidth(int paramInt)
  {
    this.mWidth = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     km
 * JD-Core Version:    0.7.0.1
 */