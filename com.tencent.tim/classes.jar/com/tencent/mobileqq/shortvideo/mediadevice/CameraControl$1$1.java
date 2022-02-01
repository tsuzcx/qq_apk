package com.tencent.mobileqq.shortvideo.mediadevice;

import android.hardware.Camera.Size;
import anij;
import anij.c;
import anij.d;
import anik;

public class CameraControl$1$1
  implements Runnable
{
  public CameraControl$1$1(anik paramanik, byte[] paramArrayOfByte, Camera.Size paramSize) {}
  
  public void run()
  {
    anij.c localc = new anij.c(this.a.jdField_b_of_type_Anij, null);
    localc.fA = this.bt;
    localc.aM = this.a.val$file;
    localc.cD = this.a.cE;
    localc.a = this.a.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover$a;
    localc.mOrientation = this.a.byD;
    localc.mCameraId = this.a.jdField_b_of_type_Anij.dGP;
    localc.mQuality = 100;
    localc.mMirror = this.a.cAO;
    localc.dGS = this.a.dGR;
    localc.c = this.b;
    new anij.d(this.a.jdField_b_of_type_Anij, localc).execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraControl.1.1
 * JD-Core Version:    0.7.0.1
 */