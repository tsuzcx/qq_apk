import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.CharacterStyle;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import java.util.ArrayList;

public class kp
{
  private CharacterStyle b;
  private boolean cs;
  private boolean ct;
  private boolean cu;
  private int hX;
  private int hY;
  private int hZ;
  private int jdField_if;
  private int mCurrentX;
  private ETFont mFont;
  private ArrayList<km> mFragments = new ArrayList(16);
  public boolean mMagicFont;
  private int mMeasuredWidth;
  private int mSpanIndex;
  private String mText;
  
  public kp(CharacterStyle paramCharacterStyle, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.b = paramCharacterStyle;
    this.hX = paramInt2;
    this.hY = paramInt3;
    this.cs = paramBoolean;
    this.mSpanIndex = paramInt1;
  }
  
  public kp(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, boolean paramBoolean)
  {
    this.mText = paramString;
    this.hX = paramInt1;
    this.hY = paramInt2;
    this.mFont = paramETFont;
    this.cu = paramBoolean;
  }
  
  private int a(ETEngine paramETEngine, String paramString)
    throws Exception
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return 0;
    }
    long l = paramETEngine.native_textLayoutLock(paramString, this.mMeasuredWidth, 1073741823, this.mCurrentX, 0, this.mFont);
    int j = paramETEngine.native_textLayoutLineTotal(l);
    if (j < 1)
    {
      paramETEngine.native_textLayoutUnlock(l);
      return 0;
    }
    if (paramETEngine.native_textLayoutHasPreLine(l) == true)
    {
      localObject = new km("");
      ((km)localObject).setLineNumber(this.jdField_if);
      ((km)localObject).setType(0);
      ((km)localObject).a(this);
      this.mFragments.add(localObject);
      this.mCurrentX = 0;
      this.jdField_if += 1;
    }
    Object localObject = new km[j];
    int i = 0;
    while (i < j)
    {
      localObject[i] = new km("");
      i += 1;
    }
    i = 0;
    while (i < j)
    {
      int k = paramETEngine.native_textLayoutLineRangeFrom(l, i);
      int m = paramETEngine.native_textLayoutLineRangeTo(l, i);
      int n = paramETEngine.native_textLayoutLineWidth(l, i);
      int i1 = paramETEngine.native_textLayoutLineHeight(l, i);
      localObject[i].setText(paramString.substring(k, m));
      localObject[i].setWidth(n);
      localObject[i].setHeight(i1);
      localObject[i].setLineNumber(this.jdField_if + i);
      localObject[i].setType(0);
      localObject[i].a(this);
      this.mFragments.add(localObject[i]);
      i += 1;
    }
    if (paramString.substring(paramString.length() - 1).equals("\n"))
    {
      paramString = new km("");
      paramString.setLineNumber(this.jdField_if + j);
      paramString.setType(0);
      paramString.a(this);
      this.mFragments.add(paramString);
      this.mCurrentX = 0;
      i = j + 1;
    }
    for (;;)
    {
      this.jdField_if += i - 1;
      paramETEngine.native_textLayoutUnlock(l);
      return i;
      if (j == 1)
      {
        this.mCurrentX += localObject[0].getWidth();
        i = j;
      }
      else
      {
        this.mCurrentX = localObject[(j - 1)].getWidth();
        i = j;
      }
    }
  }
  
  private void a(CharacterStyle paramCharacterStyle, int paramInt)
  {
    if (paramCharacterStyle == null) {
      return;
    }
    int i;
    if ((paramCharacterStyle instanceof aofk.a)) {
      i = ((aofk.a)paramCharacterStyle).getDrawable().getBounds().width();
    }
    for (;;)
    {
      label26:
      if (this.cs == true) {
        if (this.mCurrentX != 0)
        {
          this.mCurrentX = i;
          this.jdField_if += 1;
        }
      }
      for (;;)
      {
        paramCharacterStyle = new km(paramCharacterStyle, paramInt);
        paramCharacterStyle.setLineNumber(this.jdField_if);
        paramCharacterStyle.a(this);
        this.mFragments.add(paramCharacterStyle);
        if ((this.cs != true) || (this.mCurrentX == 0)) {
          break;
        }
        this.mCurrentX = 0;
        this.jdField_if += 1;
        return;
        if (!(paramCharacterStyle instanceof amfz)) {
          break label196;
        }
        i = ((amfz)paramCharacterStyle).IF();
        break label26;
        if (this.mCurrentX == 0)
        {
          this.mCurrentX = i;
        }
        else if (this.mMeasuredWidth < this.mCurrentX + i)
        {
          this.mCurrentX = i;
          this.jdField_if += 1;
        }
        else
        {
          this.mCurrentX = (i + this.mCurrentX);
        }
      }
      label196:
      i = 0;
    }
  }
  
  private void a(ETEngine paramETEngine, String paramString)
  {
    if (paramString == null) {
      return;
    }
    int i = paramETEngine.sysMeasureText(paramString, this.mFont.getSize(), 0, 0, 0, 0, 0, 0, 0);
    int j = paramETEngine.sysFontHeight(paramString, this.mFont.getSize(), 0, 0, 0, 0, 0, 0, 0);
    if (this.mMeasuredWidth < this.mCurrentX + i)
    {
      this.mCurrentX = i;
      this.jdField_if += 1;
    }
    for (;;)
    {
      paramETEngine = new km(paramString);
      paramETEngine.setWidth(i);
      paramETEngine.setHeight(j);
      paramETEngine.setLineNumber(this.jdField_if);
      paramETEngine.setType(1);
      paramETEngine.a(this);
      this.mFragments.add(paramETEngine);
      return;
      this.mCurrentX += i;
    }
  }
  
  private void b(ETEngine paramETEngine)
    throws Exception
  {
    int k = -1;
    int n = this.mText.length();
    int j = 0;
    if (j < n)
    {
      int m;
      int i;
      if ((Character.isHighSurrogate(this.mText.charAt(j))) && (j + 1 < n) && (Character.isLowSurrogate(this.mText.charAt(j + 1))))
      {
        a(paramETEngine, this.mText.substring(k + 1, j));
        a(paramETEngine, this.mText.substring(j, j + 2));
        m = j + 1;
        i = m;
      }
      for (;;)
      {
        j = m + 1;
        k = i;
        break;
        m = j;
        i = k;
        if (j + 1 == n)
        {
          a(paramETEngine, this.mText.substring(k + 1, n));
          i = n;
          m = j;
        }
      }
    }
  }
  
  private void c(ETEngine paramETEngine)
    throws Exception
  {
    int m = -1;
    int n = this.mText.length();
    int i = 0;
    if (i < n)
    {
      char c = this.mText.charAt(i);
      int k;
      int j;
      if ((Character.isHighSurrogate(c)) && (i + 1 < n) && (Character.isLowSurrogate(this.mText.charAt(i + 1))))
      {
        a(paramETEngine, this.mText.substring(m + 1, i));
        a(paramETEngine, this.mText.substring(i, i + 2));
        k = i + 1;
        j = k;
      }
      for (;;)
      {
        i = k + 1;
        m = j;
        break;
        if (!paramETEngine.native_isPaintableChar(c, this.mFont))
        {
          a(paramETEngine, this.mText.substring(m + 1, i));
          a(paramETEngine, String.valueOf(c));
          j = i;
          k = i;
        }
        else
        {
          k = i;
          j = m;
          if (i + 1 == n)
          {
            a(paramETEngine, this.mText.substring(m + 1, n));
            j = n;
            k = i;
          }
        }
      }
    }
  }
  
  public void R(int paramInt)
  {
    this.hZ = paramInt;
  }
  
  public int a(ETEngine paramETEngine, int paramInt1, int paramInt2, int paramInt3)
    throws Exception
  {
    this.mFragments.clear();
    this.jdField_if = paramInt3;
    this.mMeasuredWidth = paramInt1;
    this.mCurrentX = paramInt2;
    if (this.b != null)
    {
      a(this.b, this.mSpanIndex);
      return this.jdField_if;
    }
    if ((paramETEngine == null) || (this.mText == null)) {
      return this.jdField_if;
    }
    if (ETEngine.getInstance().isEnableCallbackDrawing()) {
      b(paramETEngine);
    }
    for (;;)
    {
      return this.jdField_if;
      c(paramETEngine);
    }
  }
  
  public ETFont a()
  {
    return this.mFont;
  }
  
  public boolean au()
  {
    return this.ct;
  }
  
  public boolean av()
  {
    return this.cu;
  }
  
  public int ax()
  {
    return this.hX;
  }
  
  public int ay()
  {
    return this.hZ;
  }
  
  protected int getCurrentX()
  {
    return this.mCurrentX;
  }
  
  public ArrayList<km> i()
  {
    return this.mFragments;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kp
 * JD-Core Version:    0.7.0.1
 */