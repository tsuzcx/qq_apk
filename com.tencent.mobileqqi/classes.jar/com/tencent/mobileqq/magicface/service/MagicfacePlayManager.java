package com.tencent.mobileqq.magicface.service;

import com.tencent.mobileqq.magicface.model.MagicfaceData;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.MagicPlayListener;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.MagicfaceRenderListener;
import com.tencent.mobileqq.magicface.model.MagicfaceFFMepgDecoder;
import com.tencent.mobileqq.magicface.model.MagicfacePlayRes;
import com.tencent.mobileqq.magicface.model.MagicfaceResLoader;

public class MagicfacePlayManager
{
  private MagicfaceData jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData;
  private MagicfaceDecoder.MagicfaceRenderListener jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicfaceRenderListener;
  private MagicfaceDecoder jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder;
  private MagicfaceResLoader jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader;
  private SoundPoolUtil jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil;
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder = new MagicfaceFFMepgDecoder();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicfaceRenderListener);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder.a(paramInt);
    }
  }
  
  public void a(MagicfaceDecoder.MagicPlayListener paramMagicPlayListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder.a(paramMagicPlayListener);
    }
  }
  
  public void a(MagicfaceDecoder.MagicfaceRenderListener paramMagicfaceRenderListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicfaceRenderListener = paramMagicfaceRenderListener;
  }
  
  public void a(MagicfacePlayRes paramMagicfacePlayRes)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData != null) && (paramMagicfacePlayRes.a.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData.a))) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder.a();
      return;
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData = this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader.a(paramMagicfacePlayRes.a, paramMagicfacePlayRes.b);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData.a = paramMagicfacePlayRes.a;
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData.b = paramMagicfacePlayRes.b;
    }
  }
  
  public void a(MagicfaceResLoader paramMagicfaceResLoader)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader = paramMagicfaceResLoader;
  }
  
  public void a(SoundPoolUtil paramSoundPoolUtil)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil = paramSoundPoolUtil;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader.b(paramString));
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader.b(paramString), paramInt);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder.b();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.service.MagicfacePlayManager
 * JD-Core Version:    0.7.0.1
 */