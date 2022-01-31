package com.etrump.mixlayout;

import fe;

public class ETFont
{
  private float jdField_a_of_type_Float;
  public int a;
  private fe jdField_a_of_type_Fe;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private final float jdField_c_of_type_Float = 4.0F;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  
  public ETFont(int paramInt, String paramString, float paramFloat)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    a(paramFloat);
    this.jdField_b_of_type_Int = -16777216;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.d = false;
    this.jdField_a_of_type_Fe = new fe(-16777216, 0.0F, 0.0F);
  }
  
  public static boolean a(ETFont paramETFont)
  {
    if (paramETFont == null) {}
    ETEngine localETEngine;
    do
    {
      return false;
      localETEngine = ETEngine.a();
    } while ((localETEngine == null) || (!localETEngine.a(paramETFont.jdField_a_of_type_Int)));
    localETEngine.b(paramETFont.jdField_a_of_type_Float);
    localETEngine.a(paramETFont.jdField_b_of_type_Int);
    int j = ET_FontStyle.ET_Regular.getValue();
    int i = j;
    if (paramETFont.a()) {
      i = j | ET_FontStyle.ET_Bold.getValue();
    }
    j = i;
    if (paramETFont.b()) {
      j = i | ET_FontStyle.ET_Italic.getValue();
    }
    i = j;
    if (paramETFont.c()) {
      i = j | ET_FontStyle.ET_Underline.getValue();
    }
    if (paramETFont.d())
    {
      j = i | ET_FontStyle.ET_Shadow.getValue();
      localETEngine.a(paramETFont.jdField_a_of_type_Fe.jdField_a_of_type_Int, paramETFont.jdField_a_of_type_Fe.jdField_a_of_type_Float, paramETFont.jdField_a_of_type_Fe.jdField_b_of_type_Float);
    }
    for (;;)
    {
      localETEngine.b(j);
      return true;
      j = i;
      if (paramETFont.e())
      {
        j = i | ET_FontStyle.ET_Crochet.getValue();
        i = paramETFont.jdField_c_of_type_Int;
        float f = paramETFont.jdField_b_of_type_Float;
        localETEngine.d(i);
        localETEngine.c((int)f);
      }
    }
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat >= 4.0F) {
      this.jdField_a_of_type_Float = paramFloat;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, float paramFloat, int paramInt)
  {
    this.e = paramBoolean;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_b_of_type_Float = paramFloat;
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.d = paramBoolean;
    if ((this.d) && (this.jdField_a_of_type_Fe != null))
    {
      this.jdField_a_of_type_Fe.jdField_a_of_type_Int = paramInt1;
      this.jdField_a_of_type_Fe.jdField_a_of_type_Float = paramInt2;
      this.jdField_a_of_type_Fe.jdField_b_of_type_Float = paramInt3;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public boolean e()
  {
    return this.e;
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (ETFont)paramObject;
    return (this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (this.jdField_b_of_type_Int == paramObject.jdField_b_of_type_Int) && (this.jdField_a_of_type_Float == paramObject.jdField_a_of_type_Float);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETFont
 * JD-Core Version:    0.7.0.1
 */