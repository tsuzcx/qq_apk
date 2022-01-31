package com.tencent.mobileqq.magicface.model;

import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.qphone.base.util.QLog;

public class MagicfaceFFMepgDecoder
  extends MagicfaceDecoder
{
  public static final String a = "MagicfaceDecoder";
  private DecoderUtil jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private int[] jdField_a_of_type_ArrayOfInt;
  private byte[] b = new byte[51200];
  private byte[] c;
  private int jdField_d_of_type_Int;
  private byte[] jdField_d_of_type_ArrayOfByte = null;
  private int jdField_e_of_type_Int = 0;
  private byte[] jdField_e_of_type_ArrayOfByte = new byte[51200];
  private int jdField_f_of_type_Int = -1;
  private byte[] jdField_f_of_type_ArrayOfByte;
  private int g = -1;
  private int h;
  private int i = 0;
  
  public MagicfaceFFMepgDecoder()
  {
    this.jdField_c_of_type_ArrayOfByte = new byte[480000];
  }
  
  private int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    if (paramInt == paramArrayOfByte2.length) {
      return -1;
    }
    int j = paramInt + 1;
    int k = (byte)(paramArrayOfByte2[(paramInt + 4)] & 0xF);
    if ((k != 7) && (k != 8)) {
      k = 1;
    }
    for (;;)
    {
      if (j < paramArrayOfByte2.length - 4) {
        if ((paramArrayOfByte2[j] == 0) && (paramArrayOfByte2[(j + 1)] == 0) && (paramArrayOfByte2[(j + 2)] == 0) && (paramArrayOfByte2[(j + 3)] == 1))
        {
          int m = (byte)(paramArrayOfByte2[(j + 4)] & 0xF);
          if ((m != 7) && (m != 8))
          {
            if (k == 0)
            {
              j += 1;
              k = 1;
            }
          }
          else {
            j += 1;
          }
        }
        else
        {
          j += 1;
          continue;
        }
      }
      k = j;
      if (j == paramArrayOfByte2.length - 4) {
        k = paramArrayOfByte2.length;
      }
      System.arraycopy(paramArrayOfByte2, paramInt, paramArrayOfByte1, 0, k - paramInt);
      return k;
      k = 0;
    }
  }
  
  private int[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int k = 0;
    if (k < this.jdField_a_of_type_ArrayOfInt.length)
    {
      int n = k * 3;
      int m = paramArrayOfByte2[n] & 0xFF;
      int j;
      if (m <= 16) {
        j = 0;
      }
      for (;;)
      {
        this.jdField_a_of_type_ArrayOfInt[k] = (j << 24 & 0xFF000000 | paramArrayOfByte1[(n + 2)] << 16 & 0xFF0000 | paramArrayOfByte1[(n + 1)] << 8 & 0xFF00 | paramArrayOfByte1[n] & 0xFF);
        k += 1;
        break;
        j = m;
        if (m >= 235) {
          j = 255;
        }
      }
    }
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  protected void c()
  {
    super.c();
    this.jdField_e_of_type_Int = 0;
    this.i = 0;
  }
  
  protected void d()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void e()
  {
    do
    {
      do
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil = new DecoderUtil();
          if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.createVideoDecoder() == 0) || (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.createAlphaDecoder() != 0)) {}
          this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData.b;
          localObject2 = this.jdField_a_of_type_ArrayOfByte;
          if (localObject2 == null) {
            return;
          }
        }
        catch (Exception localException)
        {
          Object localObject2;
          int k;
          if (!QLog.isColorLevel()) {
            break label698;
          }
          QLog.d("MagicfaceDecoder", 2, "===MagicfaceDecoder=Exception==" + localException.getMessage());
          return;
        }
        finally
        {
          if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil == null) {
            break label747;
          }
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
        }
        this.jdField_d_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData.jdField_a_of_type_ArrayOfByte;
        localObject2 = this.jdField_d_of_type_ArrayOfByte;
        if (localObject2 != null) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil == null);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
      return;
      do
      {
        this.jdField_e_of_type_Int = j;
        long l2 = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.decodeVideoDecoder(this.b, this.jdField_d_of_type_Int, this.jdField_c_of_type_ArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d("MagicfaceDecoder", 2, "decodeVideoDecoder==usetime=" + (System.currentTimeMillis() - l2) + "==videoFrameLength==" + this.jdField_d_of_type_Int);
        }
        if (this.jdField_f_of_type_Int == -1)
        {
          this.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getWidthVideoDecoder();
          this.g = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getHeightVideoDecoder();
          localObject2 = new byte[this.jdField_f_of_type_Int * this.g * 3];
          System.arraycopy(this.jdField_c_of_type_ArrayOfByte, 0, localObject2, 0, this.jdField_f_of_type_Int * this.g * 3);
          this.jdField_c_of_type_ArrayOfByte = null;
          System.gc();
          this.jdField_c_of_type_ArrayOfByte = new byte[this.jdField_f_of_type_Int * this.g * 3];
          System.arraycopy(localObject2, 0, this.jdField_c_of_type_ArrayOfByte, 0, this.jdField_f_of_type_Int * this.g * 3);
          this.jdField_f_of_type_ArrayOfByte = new byte[this.jdField_f_of_type_Int * this.g * 3];
          this.jdField_a_of_type_ArrayOfInt = new int[this.g * this.jdField_f_of_type_Int];
        }
        int j = a(this.jdField_e_of_type_ArrayOfByte, this.jdField_d_of_type_ArrayOfByte, this.i);
        this.h = (j - this.i);
        this.i = j;
        l2 = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.decodeAlphaDecoder(this.jdField_e_of_type_ArrayOfByte, this.h, this.jdField_f_of_type_ArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d("MagicfaceDecoder", 2, "decodeAlphaDecoder==usetime=" + (System.currentTimeMillis() - l2) + "==alphaFrameLength==" + this.h);
        }
        l2 = System.currentTimeMillis();
        localObject2 = a(this.jdField_c_of_type_ArrayOfByte, this.jdField_f_of_type_ArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d("MagicfaceDecoder", 2, "convertByteToColor==usetime=" + (System.currentTimeMillis() - l2));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicfaceRenderListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicfaceRenderListener.a((int[])localObject2, this.jdField_f_of_type_Int, this.g);
        }
        Object localObject1;
        long l1 = System.currentTimeMillis() - localObject1;
        if (QLog.isColorLevel()) {
          QLog.d("MagicfaceDecoder", 2, "==============frameTime=============" + l1);
        }
        if (l1 < this.jdField_c_of_type_Int) {
          Thread.sleep(this.jdField_c_of_type_Int - l1);
        }
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        l1 = System.currentTimeMillis();
        j = a(this.b, this.jdField_a_of_type_ArrayOfByte, this.jdField_e_of_type_Int);
        this.jdField_d_of_type_Int = (j - this.jdField_e_of_type_Int);
        k = this.jdField_d_of_type_Int;
      } while (k > 0);
    } while (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil == null);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
  }
  
  public void f()
  {
    super.f();
    this.jdField_f_of_type_ArrayOfByte = null;
    this.jdField_c_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_ArrayOfInt = null;
    System.gc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicfaceFFMepgDecoder
 * JD-Core Version:    0.7.0.1
 */