package com.tencent.mobileqq.ar.arengine;

import android.util.Log;

public class ARFacePreviewResample
{
  private boolean bNj;
  private int cFs;
  private int cGl;
  private int cGm;
  private byte[] dn;
  private int mPreviewHeight;
  private int mPreviewWidth;
  
  private void aX(byte[] paramArrayOfByte)
  {
    long l = System.currentTimeMillis();
    nativeScaleYUVImage2(this.dn, this.cGl, this.cGm, paramArrayOfByte, this.mPreviewWidth, this.mPreviewHeight);
    Log.d("ARFacePreviewResample", String.format("doResample time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
  }
  
  private native int nativeScaleYUVImage2(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4);
  
  public int BM()
  {
    return this.cGl;
  }
  
  public int BN()
  {
    return this.cGm;
  }
  
  public byte[] V()
  {
    if (this.bNj) {
      return this.dn;
    }
    return null;
  }
  
  public void init(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mPreviewWidth = paramInt1;
    this.mPreviewHeight = paramInt2;
    this.cFs = paramInt3;
    if (this.mPreviewHeight > 480)
    {
      this.cGm = (this.mPreviewHeight / 2 / 4 * 4);
      this.cGl = ((this.mPreviewWidth * this.cGm / this.mPreviewHeight + 3) / 4 * 4);
    }
    for (this.bNj = true;; this.bNj = false)
    {
      if (this.bNj) {
        this.dn = new byte[this.cGl * this.cGm * 3 >> 1];
      }
      return;
      this.cGm = this.mPreviewHeight;
      this.cGl = this.mPreviewWidth;
    }
  }
  
  public boolean k(byte[] paramArrayOfByte)
  {
    if (this.bNj)
    {
      aX(paramArrayOfByte);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARFacePreviewResample
 * JD-Core Version:    0.7.0.1
 */