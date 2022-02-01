package com.tencent.mobileqq.magicface.model;

import aixz;
import aiyc.b;
import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.qphone.base.util.QLog;

public class MagicFaceSuperBigDecoder$1
  implements Runnable
{
  public MagicFaceSuperBigDecoder$1(aixz paramaixz) {}
  
  public void run()
  {
    long l2;
    label665:
    int i;
    label692:
    long l1;
    for (;;)
    {
      long l3;
      Object localObject;
      try
      {
        if (!QLog.isColorLevel()) {
          break label692;
        }
        QLog.d("MagicFaceSuperBigDecoder", 2, "func mDecoder.run begins, isStartDecodr:" + this.this$0.cmH);
      }
      catch (Exception localException)
      {
        int j;
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MagicFaceSuperBigDecoder", 2, "func mDecoder.run ends, error is catched.msg:" + localException.getMessage());
        return;
        this.this$0.dgL = j;
        this.this$0.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.decodeAlphaDecoderReturnYUV(this.this$0.eJ, this.this$0.dgK, this.this$0.eK);
        if (this.this$0.dgM != -1) {
          continue;
        }
        this.this$0.dgM = this.this$0.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getWidthAlphaDecoder();
        this.this$0.dgN = this.this$0.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getHeightAlphaDecoder();
        if (this.this$0.jdField_a_of_type_Aiyc$b == null) {
          continue;
        }
        this.this$0.jdField_a_of_type_Aiyc$b.a(this.this$0.eI, this.this$0.eK, this.this$0.videoWidth, this.this$0.videoHeight, 0.0F);
        l3 = System.currentTimeMillis() - l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MagicFaceSuperBigDecoder", 2, "func mDecoder.run, 【useFrameTime】 " + l3);
        if (l3 >= this.this$0.dgI) {
          break label665;
        }
        if (localObject <= 0L) {
          continue;
        }
        l2 = this.this$0.dgI - l3;
        if (l2 <= localObject) {
          break label711;
        }
        Thread.sleep(l2 - localObject);
        break label700;
        Thread.sleep(this.this$0.dgI - l3);
        l2 = localObject;
        break label703;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        return;
      }
      if (!this.this$0.cmH) {
        break;
      }
      l2 = System.currentTimeMillis();
      j = this.this$0.h(this.this$0.eG, this.this$0.bqG);
      this.this$0.dgJ = (j - this.this$0.bqG);
      if (this.this$0.dgJ <= 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MagicFaceSuperBigDecoder", 2, "func mDecoder.run ends, 【condition】 frame len <= 0, videoFrameLength:" + this.this$0.dgJ);
        return;
      }
      this.this$0.b(this.this$0.dgJ, this.this$0.bqG, this.this$0.eG);
      this.this$0.bqG = j;
      this.this$0.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.decodeVideoDecoderReturnYUV(this.this$0.eH, this.this$0.dgJ, this.this$0.eI);
      if (this.this$0.videoWidth == -1)
      {
        this.this$0.videoWidth = this.this$0.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getWidthVideoDecoder();
        this.this$0.videoHeight = this.this$0.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.getHeightVideoDecoder();
      }
      j = this.this$0.h(this.this$0.eF, this.this$0.dgL);
      this.this$0.dgK = (j - this.this$0.dgL);
      this.this$0.c(this.this$0.dgK, this.this$0.dgL, this.this$0.eF);
      if (this.this$0.dgK <= 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MagicFaceSuperBigDecoder", 2, "func mDecoder.run ends, 【condition】 frame len <= 0, alphaFrameLength:" + this.this$0.dgK);
        return;
      }
      l2 = localObject;
      if (i != 0) {
        break label703;
      }
      i = this.this$0.dgI;
      l2 = localObject + (l3 - i);
      break label703;
      l1 = 0L;
      i = 1;
    }
    return;
    for (;;)
    {
      label700:
      l2 = l1;
      label703:
      i = 0;
      l1 = l2;
      break;
      label711:
      l1 -= l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicFaceSuperBigDecoder.1
 * JD-Core Version:    0.7.0.1
 */