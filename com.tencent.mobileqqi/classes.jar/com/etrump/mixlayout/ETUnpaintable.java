package com.etrump.mixlayout;

public class ETUnpaintable
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  private int c;
  private int d;
  private int e;
  
  public ETUnpaintable(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      this.d = paramInt1;
      if (paramInt2 <= 0) {
        break label43;
      }
    }
    for (;;)
    {
      this.e = paramInt2;
      this.jdField_a_of_type_JavaLangString = null;
      this.b = 0;
      this.c = 0;
      return;
      paramInt1 = 0;
      break;
      label43:
      paramInt2 = 0;
    }
  }
  
  int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  int b()
  {
    return this.b;
  }
  
  void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  int c()
  {
    return this.c;
  }
  
  void c(int paramInt)
  {
    this.c = paramInt;
  }
  
  int d()
  {
    return this.d;
  }
  
  void d(int paramInt)
  {
    this.d = paramInt;
  }
  
  int e()
  {
    return this.e;
  }
  
  void e(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETUnpaintable
 * JD-Core Version:    0.7.0.1
 */