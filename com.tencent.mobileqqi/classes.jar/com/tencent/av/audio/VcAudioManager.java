package com.tencent.av.audio;

import android.content.Context;
import com.tencent.av.core.IVcAudioData;

public class VcAudioManager
{
  private AudioMain jdField_a_of_type_ComTencentAvAudioAudioMain;
  private IVcAudioData jdField_a_of_type_ComTencentAvCoreIVcAudioData;
  
  public VcAudioManager(IVcAudioData paramIVcAudioData)
  {
    this.jdField_a_of_type_ComTencentAvCoreIVcAudioData = paramIVcAudioData;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentAvAudioAudioMain != null) {
      return this.jdField_a_of_type_ComTencentAvAudioAudioMain.a();
    }
    return 0;
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreIVcAudioData == null) {
      return -1;
    }
    if (this.jdField_a_of_type_ComTencentAvAudioAudioMain != null) {
      this.jdField_a_of_type_ComTencentAvAudioAudioMain.a(paramInt);
    }
    return 0;
  }
  
  public int a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAudioAudioMain != null) {
      return this.jdField_a_of_type_ComTencentAvAudioAudioMain.b(paramBoolean);
    }
    return -1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvAudioAudioMain != null) {
      this.jdField_a_of_type_ComTencentAvAudioAudioMain.b();
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean, int paramInt)
  {
    boolean bool = true;
    this.jdField_a_of_type_ComTencentAvAudioAudioMain = new AudioMain(paramContext);
    this.jdField_a_of_type_ComTencentAvAudioAudioMain.a(this.jdField_a_of_type_ComTencentAvCoreIVcAudioData);
    paramContext = new int[1];
    int[] arrayOfInt1 = new int[1];
    int[] arrayOfInt2 = new int[1];
    int[] arrayOfInt3 = new int[1];
    paramContext[0] = 0;
    arrayOfInt1[0] = 0;
    if (this.jdField_a_of_type_ComTencentAvCoreIVcAudioData != null) {
      this.jdField_a_of_type_ComTencentAvCoreIVcAudioData.a(arrayOfInt2, paramContext, arrayOfInt1, arrayOfInt3);
    }
    if ((paramContext[0] == 0) || (arrayOfInt1[0] == 0))
    {
      paramContext[0] = 8000;
      arrayOfInt1[0] = 20;
    }
    int i;
    int j;
    if (this.jdField_a_of_type_ComTencentAvAudioAudioMain != null)
    {
      this.jdField_a_of_type_ComTencentAvAudioAudioMain.a(paramContext[0], arrayOfInt1[0], 1, arrayOfInt3[0]);
      i = this.jdField_a_of_type_ComTencentAvAudioAudioMain.a(paramInt);
      j = this.jdField_a_of_type_ComTencentAvAudioAudioMain.b(paramInt);
      this.jdField_a_of_type_ComTencentAvAudioAudioMain.a(paramBoolean);
      paramContext = this.jdField_a_of_type_ComTencentAvAudioAudioMain;
      if (i == 0) {
        break label226;
      }
      paramBoolean = true;
      paramContext.a(paramBoolean);
      paramContext = this.jdField_a_of_type_ComTencentAvAudioAudioMain;
      if (this.jdField_a_of_type_ComTencentAvAudioAudioMain.a()) {
        break label231;
      }
    }
    label226:
    label231:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramContext.a(paramBoolean);
      if (j != 0)
      {
        i = i * 255 / j;
        this.jdField_a_of_type_ComTencentAvAudioAudioMain.a(i, paramInt);
      }
      return;
      paramBoolean = false;
      break;
    }
  }
  
  public int b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAudioAudioMain != null) {
      return this.jdField_a_of_type_ComTencentAvAudioAudioMain.c(paramBoolean);
    }
    return -1;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAvAudioAudioMain != null)
    {
      this.jdField_a_of_type_ComTencentAvAudioAudioMain.c();
      this.jdField_a_of_type_ComTencentAvAudioAudioMain.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.audio.VcAudioManager
 * JD-Core Version:    0.7.0.1
 */