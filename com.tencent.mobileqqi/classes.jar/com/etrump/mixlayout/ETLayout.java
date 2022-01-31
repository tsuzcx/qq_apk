package com.etrump.mixlayout;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import com.tencent.mobileqq.text.QQText.EmotcationSpan;
import com.tencent.mobileqq.text.QQText.LinkSpan;
import fk;
import fl;
import java.util.ArrayList;
import java.util.Arrays;

public class ETLayout
{
  private int jdField_a_of_type_Int = 0;
  public long a;
  public Bitmap a;
  private ETEngine jdField_a_of_type_ComEtrumpMixlayoutETEngine = ETEngine.a();
  private ETFont jdField_a_of_type_ComEtrumpMixlayoutETFont;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(16);
  private boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt;
  private ETTextLine[] jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine;
  private int jdField_b_of_type_Int;
  private ETFont jdField_b_of_type_ComEtrumpMixlayoutETFont = new ETFont(0, "", 24.0F);
  private int c;
  private int d;
  private int e;
  
  ETLayout()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  private static CharSequence a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int j = 0;
    if (paramCharSequence == null) {
      return new String("");
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    paramInt1 = paramInt2;
    if (paramInt2 > paramCharSequence.length()) {
      paramInt1 = paramCharSequence.length();
    }
    paramInt2 = paramInt1 - i;
    if (paramInt2 <= 0) {
      return new String("");
    }
    char[] arrayOfChar = new char[paramInt2];
    paramInt1 = j;
    while (paramInt1 < paramInt2)
    {
      arrayOfChar[paramInt1] = paramCharSequence.charAt(paramInt1 + i);
      paramInt1 += 1;
    }
    return String.valueOf(arrayOfChar);
  }
  
  private final void a(Bitmap paramBitmap)
  {
    int k;
    int i;
    int j;
    if ((paramBitmap != null) && (this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine != null))
    {
      k = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine.length;
      i = 0;
      j = 0;
    }
    for (;;)
    {
      if (i < k)
      {
        this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i].a(paramBitmap, 0, j);
        j += this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i].a();
        if (j < paramBitmap.getHeight()) {}
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void a(QQText.EmotcationSpan paramEmotcationSpan, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramEmotcationSpan = new ETParagraph(paramEmotcationSpan, paramInt1, paramInt2, paramBoolean);
    paramEmotcationSpan.a(this.e);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramEmotcationSpan);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, boolean paramBoolean)
  {
    paramString = new ETParagraph(paramString, paramInt1, paramInt2, paramETFont, paramBoolean);
    paramString.a(this.e);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
  }
  
  private final void a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int k;
    int i;
    int j;
    if ((paramArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine != null))
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.a(paramArrayOfInt, paramInt1 * paramInt2, (byte)0);
      k = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine.length;
      i = 0;
      j = 0;
    }
    for (;;)
    {
      if (i < k)
      {
        this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i].a(paramArrayOfInt, paramInt1, paramInt2, 32, 0, j);
        j += this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i].a();
        if (j < paramInt2) {}
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine != null) {
      this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine = null;
    }
    int m = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    int j = 0;
    int k = 0;
    Object localObject;
    while (i < m)
    {
      localObject = (ETParagraph)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      k = ((ETParagraph)localObject).a(paramInt, j, k);
      j = ((ETParagraph)localObject).a();
      i += 1;
    }
    j = k + 1;
    this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine = new ETTextLine[j];
    paramInt = 0;
    while (paramInt < j)
    {
      this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[paramInt] = new ETTextLine();
      paramInt += 1;
    }
    paramInt = 0;
    while (paramInt < m)
    {
      localObject = ((ETParagraph)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a();
      i = 0;
      while (i < ((ArrayList)localObject).size())
      {
        ETFragment localETFragment = (ETFragment)((ArrayList)localObject).get(i);
        k = localETFragment.c();
        if ((k >= 0) && (k < j)) {
          this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[k].a(localETFragment);
        }
        i += 1;
      }
      paramInt += 1;
    }
    paramInt = 0;
    i = 0;
    while (paramInt < j)
    {
      localObject = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[paramInt];
      ((ETTextLine)localObject).a(0, i);
      i += ((ETTextLine)localObject).a();
      paramInt += 1;
    }
  }
  
  private final void b(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    int k = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine.length;
    int j = 0;
    int i = paramInt2;
    paramInt2 = j;
    while (paramInt2 < k)
    {
      this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[paramInt2].a(paramCanvas, paramInt1, i);
      i += this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[paramInt2].a();
      paramInt2 += 1;
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if ((this.jdField_a_of_type_JavaLangCharSequence != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null))
    {
      if ((this.jdField_a_of_type_JavaLangCharSequence instanceof Spanned)) {
        d();
      }
    }
    else {
      return;
    }
    a(this.jdField_a_of_type_JavaLangCharSequence.toString(), 0, this.jdField_a_of_type_JavaLangCharSequence.length(), this.jdField_a_of_type_ComEtrumpMixlayoutETFont, false);
  }
  
  private void d()
  {
    Spanned localSpanned = (Spanned)this.jdField_a_of_type_JavaLangCharSequence;
    CharacterStyle[] arrayOfCharacterStyle = (CharacterStyle[])localSpanned.getSpans(0, localSpanned.length(), CharacterStyle.class);
    fl[] arrayOffl = new fl[arrayOfCharacterStyle.length];
    if ((arrayOffl == null) || (arrayOffl.length == 0))
    {
      a(this.jdField_a_of_type_JavaLangCharSequence.toString(), 0, this.jdField_a_of_type_JavaLangCharSequence.length(), this.jdField_a_of_type_ComEtrumpMixlayoutETFont, false);
      return;
    }
    int i = 0;
    while (i < arrayOfCharacterStyle.length)
    {
      arrayOffl[i] = new fl();
      arrayOffl[i].jdField_a_of_type_Int = localSpanned.getSpanStart(arrayOfCharacterStyle[i]);
      arrayOffl[i].jdField_b_of_type_Int = localSpanned.getSpanEnd(arrayOfCharacterStyle[i]);
      arrayOffl[i].jdField_a_of_type_AndroidTextStyleCharacterStyle = arrayOfCharacterStyle[i];
      i += 1;
    }
    Arrays.sort(arrayOffl, new fk());
    int j = 0;
    i = 0;
    label169:
    int m;
    int k;
    if (j < arrayOfCharacterStyle.length)
    {
      m = arrayOffl[j].jdField_a_of_type_Int;
      k = arrayOffl[j].jdField_b_of_type_Int;
      if (m - i > 0) {
        a(a(this.jdField_a_of_type_JavaLangCharSequence, i, m).toString(), i, m, this.jdField_a_of_type_ComEtrumpMixlayoutETFont, false);
      }
      if (k - m > 0)
      {
        if (!(arrayOffl[j].jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof QQText.LinkSpan)) {
          break label346;
        }
        a(a(this.jdField_a_of_type_JavaLangCharSequence, m, k).toString(), m, k, this.jdField_b_of_type_ComEtrumpMixlayoutETFont, true);
      }
    }
    for (;;)
    {
      if ((j == arrayOfCharacterStyle.length - 1) && (k < this.jdField_a_of_type_JavaLangCharSequence.length())) {
        a(a(this.jdField_a_of_type_JavaLangCharSequence, k, this.jdField_a_of_type_JavaLangCharSequence.length()).toString(), k, this.jdField_a_of_type_JavaLangCharSequence.length(), this.jdField_a_of_type_ComEtrumpMixlayoutETFont, false);
      }
      j += 1;
      i = k;
      break label169;
      break;
      label346:
      if ((arrayOffl[j].jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof QQText.EmotcationSpan)) {
        a((QQText.EmotcationSpan)arrayOffl[j].jdField_a_of_type_AndroidTextStyleCharacterStyle, m, k, false);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int i = 0;
    Rect localRect = new Rect(0, 0, 0, 0);
    int j = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine.length;
    if (i < j)
    {
      localRect.left = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i].c();
      localRect.top = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i].d();
      localRect.right = (localRect.left + this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i].b());
      localRect.bottom = (localRect.top + this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i].a());
      if (!localRect.contains(paramInt1, paramInt2)) {}
      ETFragment localETFragment;
      do
      {
        i += 1;
        break;
        localETFragment = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i].a(paramInt1);
      } while (localETFragment == null);
      return localETFragment.a().b();
    }
    return -1;
  }
  
  public Rect a()
  {
    return new Rect(0, 0, this.c, this.d);
  }
  
  public Rect a(int paramInt1, CharSequence paramCharSequence, ETFont paramETFont, int paramInt2)
  {
    Rect localRect = new Rect(0, 0, 0, 0);
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont = paramETFont;
    if ((this.jdField_b_of_type_ComEtrumpMixlayoutETFont != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null))
    {
      this.jdField_b_of_type_ComEtrumpMixlayoutETFont.jdField_a_of_type_Int = paramETFont.jdField_a_of_type_Int;
      this.jdField_b_of_type_ComEtrumpMixlayoutETFont.a(paramETFont.a());
      this.jdField_b_of_type_ComEtrumpMixlayoutETFont.a(paramETFont.a());
      this.jdField_b_of_type_ComEtrumpMixlayoutETFont.a(paramInt2);
    }
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine == null) {
      return localRect;
    }
    c();
    b(paramInt1);
    if (this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine == null) {
      return localRect;
    }
    int k = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine.length;
    paramInt2 = 0;
    int i = 0;
    paramInt1 = 0;
    int m;
    if (paramInt2 < k)
    {
      int j = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[paramInt2].b();
      m = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[paramInt2].a();
      if (j <= paramInt1) {
        break label363;
      }
      paramInt1 = j;
    }
    label301:
    label363:
    for (;;)
    {
      i += m;
      paramInt2 += 1;
      break;
      this.c = paramInt1;
      this.d = i;
      if ((this.c > 0) && (this.d > 0))
      {
        paramInt1 = this.c * this.d;
        if (this.jdField_a_of_type_Boolean != true) {
          break label301;
        }
        if ((this.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_a_of_type_ArrayOfInt.length < paramInt1)) {
          this.jdField_a_of_type_ArrayOfInt = new int[paramInt1];
        }
        ETEngine.a().a(false);
        ETEngine.a().b(false);
        a(this.jdField_a_of_type_ArrayOfInt, this.c, this.d);
      }
      for (;;)
      {
        localRect.right = this.c;
        localRect.bottom = this.d;
        return localRect;
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
          this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.c, this.d, Bitmap.Config.ARGB_8888);
        ETEngine.a().a(true);
        ETEngine.a().b(true);
        a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Int += 1;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    paramInt2 = 0;
    if (paramInt2 < i)
    {
      ETParagraph localETParagraph = (ETParagraph)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt2);
      if ((paramInt1 >= localETParagraph.b()) && (paramInt1 < localETParagraph.c())) {
        localETParagraph.a(paramBoolean);
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        localETParagraph.a(false);
      }
    }
  }
  
  public final void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (paramCanvas == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(paramInt1, paramInt2);
    if (this.jdField_a_of_type_Boolean == true) {
      if (this.jdField_a_of_type_ArrayOfInt != null) {
        paramCanvas.drawBitmap(this.jdField_a_of_type_ArrayOfInt, 0, this.c, 0, 0, this.c, this.d, true, null);
      }
    }
    for (;;)
    {
      paramCanvas.restore();
      b(paramCanvas, paramInt1, paramInt2);
      return;
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, null);
      }
    }
  }
  
  public boolean a(long paramLong, ETFont paramETFont)
  {
    return (this.jdField_a_of_type_Long == paramLong) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.equals(paramETFont));
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Int > 0) {
      this.jdField_a_of_type_Int -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETLayout
 * JD-Core Version:    0.7.0.1
 */