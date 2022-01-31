package com.etrump.mixlayout;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.text.QQText.EmotcationSpan;
import java.util.ArrayList;

public class ETParagraph
{
  private int jdField_a_of_type_Int;
  private ETEngine jdField_a_of_type_ComEtrumpMixlayoutETEngine = ETEngine.a();
  private ETFont jdField_a_of_type_ComEtrumpMixlayoutETFont;
  private QQText.EmotcationSpan jdField_a_of_type_ComTencentMobileqqTextQQText$EmotcationSpan;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(16);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  private int e;
  private int f;
  
  public ETParagraph(QQText.EmotcationSpan paramEmotcationSpan, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqTextQQText$EmotcationSpan = paramEmotcationSpan;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public ETParagraph(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont = paramETFont;
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  private int a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return 0;
    }
    int j = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.a(paramString, this.e, 16777215, this.f, 0);
    int k = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.b(j);
    if (k < 1)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.e(j);
      return 0;
    }
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.a(j) == true)
    {
      localObject = new ETFragment("");
      ((ETFragment)localObject).c(this.d);
      ((ETFragment)localObject).d(0);
      ((ETFragment)localObject).a(this);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      this.f = 0;
      this.d += 1;
    }
    Object localObject = new ETFragment[k];
    int i = 0;
    while (i < k)
    {
      localObject[i] = new ETFragment("");
      i += 1;
    }
    i = 0;
    while (i < k)
    {
      EtrumpLayoutLine localEtrumpLayoutLine = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.a(j, i);
      if (localEtrumpLayoutLine != null)
      {
        localObject[i].a(paramString.substring(localEtrumpLayoutLine.jdField_c_of_type_Int, localEtrumpLayoutLine.d));
        localObject[i].a(localEtrumpLayoutLine.jdField_a_of_type_Int);
        localObject[i].b(localEtrumpLayoutLine.jdField_b_of_type_Int);
        localObject[i].c(this.d + i);
        localObject[i].d(0);
        localObject[i].a(this);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject[i]);
      }
      i += 1;
    }
    if (k == 1) {}
    for (this.f += localObject[0].a();; this.f = localObject[(k - 1)].a())
    {
      this.d += k - 1;
      this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.e(j);
      return k;
    }
  }
  
  private void a(QQText.EmotcationSpan paramEmotcationSpan)
  {
    if (paramEmotcationSpan == null) {
      return;
    }
    Rect localRect = paramEmotcationSpan.a().getBounds();
    if (this.jdField_a_of_type_Boolean == true) {
      if (this.f != 0)
      {
        this.f = localRect.width();
        this.d += 1;
      }
    }
    for (;;)
    {
      paramEmotcationSpan = new ETFragment(paramEmotcationSpan);
      paramEmotcationSpan.c(this.d);
      paramEmotcationSpan.a(this);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramEmotcationSpan);
      if ((this.jdField_a_of_type_Boolean != true) || (this.f == 0)) {
        break;
      }
      this.f = 0;
      this.d += 1;
      return;
      if (this.f == 0)
      {
        this.f = localRect.width();
      }
      else if (this.e < localRect.width() + this.f)
      {
        this.f = localRect.width();
        this.d += 1;
      }
      else
      {
        int i = this.f;
        this.f = (localRect.width() + i);
      }
    }
  }
  
  private void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    Rect localRect = ETType.a(paramString, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.a());
    if (this.e < localRect.width() + this.f)
    {
      this.f = localRect.width();
      this.d += 1;
    }
    for (;;)
    {
      paramString = new ETFragment(paramString);
      paramString.a(localRect.width());
      paramString.b(localRect.height());
      paramString.c(this.d);
      paramString.d(1);
      paramString.a(this);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
      return;
      this.f += localRect.width();
    }
  }
  
  protected int a()
  {
    return this.f;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.d = paramInt3;
    this.e = paramInt1;
    this.f = paramInt2;
    if (this.jdField_a_of_type_ComTencentMobileqqTextQQText$EmotcationSpan != null)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqTextQQText$EmotcationSpan);
      return this.d;
    }
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETEngine == null) || (this.jdField_a_of_type_JavaLangString == null)) {
      return this.d;
    }
    if (!ETFont.a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont)) {
      return this.d;
    }
    int i = -1;
    int j = this.jdField_a_of_type_JavaLangString.length();
    paramInt1 = 0;
    if (paramInt1 < j)
    {
      char c1 = this.jdField_a_of_type_JavaLangString.charAt(paramInt1);
      if ((Character.isHighSurrogate(c1)) && (paramInt1 + 1 < j) && (Character.isLowSurrogate(this.jdField_a_of_type_JavaLangString.charAt(paramInt1 + 1))))
      {
        a(this.jdField_a_of_type_JavaLangString.substring(i + 1, paramInt1));
        a(this.jdField_a_of_type_JavaLangString.substring(paramInt1, paramInt1 + 2));
        paramInt3 = paramInt1 + 1;
        paramInt2 = paramInt3;
      }
      for (;;)
      {
        paramInt1 = paramInt3 + 1;
        i = paramInt2;
        break;
        if (!this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.a(c1))
        {
          a(this.jdField_a_of_type_JavaLangString.substring(i + 1, paramInt1));
          a(String.valueOf(c1));
          paramInt2 = paramInt1;
          paramInt3 = paramInt1;
        }
        else
        {
          paramInt3 = paramInt1;
          paramInt2 = i;
          if (paramInt1 + 1 == j)
          {
            a(this.jdField_a_of_type_JavaLangString.substring(i + 1, j));
            paramInt2 = j;
            paramInt3 = paramInt1;
          }
        }
      }
    }
    return this.d;
  }
  
  public ETFont a()
  {
    return this.jdField_a_of_type_ComEtrumpMixlayoutETFont;
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(ETFont paramETFont)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont = paramETFont;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int d()
  {
    return this.jdField_c_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETParagraph
 * JD-Core Version:    0.7.0.1
 */