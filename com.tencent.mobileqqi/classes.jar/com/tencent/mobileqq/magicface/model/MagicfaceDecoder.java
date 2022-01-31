package com.tencent.mobileqq.magicface.model;

import gak;

public abstract class MagicfaceDecoder
{
  public static final int a = 480;
  protected MagicfaceData a;
  public MagicfaceDecoder.MagicPlayListener a;
  MagicfaceDecoder.MagicfaceRenderListener a;
  public volatile boolean a;
  public int b = 8;
  public int c = 1000 / this.b;
  
  public MagicfaceDecoder()
  {
    d();
  }
  
  public void a()
  {
    c();
    if (!this.jdField_a_of_type_Boolean) {
      new Thread(new gak(this)).start();
    }
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
    this.c = (1000 / paramInt);
  }
  
  public void a(MagicfaceData paramMagicfaceData)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData = paramMagicfaceData;
  }
  
  public void a(MagicfaceDecoder.MagicPlayListener paramMagicPlayListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicPlayListener = paramMagicPlayListener;
  }
  
  public void a(MagicfaceDecoder.MagicfaceRenderListener paramMagicfaceRenderListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicfaceRenderListener = paramMagicfaceRenderListener;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void c() {}
  
  protected void d()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public abstract void e();
  
  public void f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicfaceDecoder
 * JD-Core Version:    0.7.0.1
 */