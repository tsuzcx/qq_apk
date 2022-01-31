package com.tencent.jni;

public class Face
{
  static final int Register = 1;
  static final int Vaildation = 2;
  private boolean detectflag;
  private long facedetector = 0L;
  int[] framedata;
  
  static
  {
    System.loadLibrary("FaceAlgClinetOld");
  }
  
  public static byte[] EncodeData(Face.ImgData[] paramArrayOfImgData)
  {
    int k = paramArrayOfImgData.length;
    int j = k * 4 + 4;
    int i = 0;
    while (i < k)
    {
      j += paramArrayOfImgData[i].img_data.length;
      i += 1;
    }
    byte[] arrayOfByte = new byte[j];
    System.arraycopy(intToByteArray(k), 0, arrayOfByte, 0, 4);
    i = 0;
    while (i < k)
    {
      System.arraycopy(intToByteArray(paramArrayOfImgData[i].img_data.length), 0, arrayOfByte, i * 4 + 4, 4);
      i += 1;
    }
    j = k * 4 + 4;
    i = 0;
    while (i < k)
    {
      int m = paramArrayOfImgData[i].img_data.length;
      System.arraycopy(paramArrayOfImgData[i].img_data, 0, arrayOfByte, j, m);
      j += m;
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static Boolean IsSupportNeon()
  {
    if (1 == NativeIsSupportNeon()) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  private static native long NativeDestroy(long paramLong);
  
  private static native byte[] NativeFaceDetect(long paramLong, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt2, float[] paramArrayOfFloat, int paramInt4);
  
  private static native int NativeFaceLightDetect(long paramLong, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt2, float[] paramArrayOfFloat);
  
  private static native byte[] NativeGetFaceImg();
  
  private static native int[] NativeGetFacePos();
  
  private static native long NativeInitial(String paramString1, String paramString2);
  
  private static native long NativeInitialMode(String paramString1, String paramString2, int paramInt);
  
  private static native int NativeIsSupportNeon();
  
  private static native long NativeTest();
  
  private void decodeYUV420RGB(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    int i3 = 0;
    int j;
    int k;
    int i4;
    int m;
    int n;
    if (i3 < paramInt2)
    {
      j = paramInt1 * paramInt2 + (i3 >> 1) * paramInt1;
      k = 0;
      i4 = 0;
      m = 0;
      if (i4 < paramInt1)
      {
        n = (paramArrayOfByte[i] & 0xFF) - 16;
        if (n >= 0) {
          break label340;
        }
        n = 0;
      }
    }
    label173:
    label181:
    label340:
    for (;;)
    {
      if ((i4 & 0x1) == 0)
      {
        m = j + 1;
        k = paramArrayOfByte[j];
        j = paramArrayOfByte[m];
        k = (k & 0xFF) - 128;
        j = (j & 0xFF) - 128;
        m += 1;
      }
      for (;;)
      {
        n *= 1192;
        int i1 = n + k * 1634;
        int i2 = n - k * 833 - j * 400;
        int i5 = n + j * 2066;
        if (i1 < 0)
        {
          n = 0;
          if (i2 >= 0) {
            break label271;
          }
          i1 = 0;
          if (i5 >= 0) {
            break label289;
          }
          i2 = 0;
        }
        for (;;)
        {
          paramArrayOfInt[i] = (i2 >> 10 & 0xFF | i1 >> 2 & 0xFF00 | n << 6 & 0xFF0000 | 0xFF000000);
          i4 += 1;
          n = m;
          i += 1;
          m = k;
          k = j;
          j = n;
          break;
          n = i1;
          if (i1 <= 262143) {
            break label173;
          }
          n = 262143;
          break label173;
          i1 = i2;
          if (i2 <= 262143) {
            break label181;
          }
          i1 = 262143;
          break label181;
          i2 = i5;
          if (i5 > 262143) {
            i2 = 262143;
          }
        }
        i3 += 1;
        break;
        return;
        i1 = k;
        i2 = j;
        k = m;
        j = i1;
        m = i2;
      }
    }
  }
  
  public static byte[] intToByteArray(int paramInt)
  {
    return new byte[] { (byte)(paramInt >> 24 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt & 0xFF) };
  }
  
  public long Destroy()
  {
    NativeDestroy(this.facedetector);
    this.facedetector = 0L;
    return 0L;
  }
  
  public Face.ImgData FaceDetect_register(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt, float[] paramArrayOfFloat)
  {
    Face.ImgData localImgData = new Face.ImgData(this);
    if (this.framedata == null) {
      this.framedata = new int[paramInt1 * paramInt2];
    }
    decodeYUV420RGB(this.framedata, paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte = NativeFaceDetect(this.facedetector, this.framedata, paramInt1, paramInt2, paramInt3, paramArrayOfInt, paramArrayOfFloat, 1);
    localImgData.img_width = paramInt1;
    localImgData.img_height = paramInt2;
    paramArrayOfInt = NativeGetFacePos();
    localImgData.face_pos = new int[4];
    localImgData.face_pos[0] = paramArrayOfInt[0];
    localImgData.face_pos[1] = paramArrayOfInt[1];
    localImgData.face_pos[2] = paramArrayOfInt[2];
    localImgData.face_pos[3] = paramArrayOfInt[3];
    localImgData.isdark_flag = paramArrayOfInt[4];
    if (paramArrayOfByte.length > 0)
    {
      localImgData.img_data = NativeGetFaceImg();
      return localImgData;
    }
    localImgData.img_data = new byte[0];
    return localImgData;
  }
  
  public Face.ImgData FaceDetect_validate(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt, float[] paramArrayOfFloat)
  {
    Face.ImgData localImgData = new Face.ImgData(this);
    if (this.framedata == null) {
      this.framedata = new int[paramInt1 * paramInt2];
    }
    decodeYUV420RGB(this.framedata, paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte = NativeFaceDetect(this.facedetector, this.framedata, paramInt1, paramInt2, paramInt3, paramArrayOfInt, paramArrayOfFloat, 0);
    localImgData.img_width = paramInt1;
    localImgData.img_height = paramInt2;
    paramArrayOfInt = NativeGetFacePos();
    localImgData.face_pos = new int[4];
    localImgData.face_pos[0] = paramArrayOfInt[0];
    localImgData.face_pos[1] = paramArrayOfInt[1];
    localImgData.face_pos[2] = paramArrayOfInt[2];
    localImgData.face_pos[3] = paramArrayOfInt[3];
    localImgData.isdark_flag = paramArrayOfInt[4];
    if (paramArrayOfByte.length > 0)
    {
      localImgData.img_data = NativeGetFaceImg();
      return localImgData;
    }
    localImgData.img_data = new byte[0];
    return localImgData;
  }
  
  public Face.ERROR_CODE FaceLightDetect(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt, float[] paramArrayOfFloat)
  {
    if (paramArrayOfByte.length < paramInt1 * paramInt2 * 3) {
      return Face.ERROR_CODE.BAD_PARAM;
    }
    if (this.framedata == null) {
      this.framedata = new int[paramInt1 * paramInt2];
    }
    decodeYUV420RGB(this.framedata, paramArrayOfByte, paramInt1, paramInt2);
    paramInt1 = NativeFaceLightDetect(this.facedetector, this.framedata, paramInt1, paramInt2, paramInt3, paramArrayOfInt, paramArrayOfFloat);
    if (paramInt1 == 0) {
      return Face.ERROR_CODE.NO_ERROR;
    }
    if (paramInt1 == -1) {
      return Face.ERROR_CODE.NO_LIGHT;
    }
    if (paramInt1 == -2) {
      return Face.ERROR_CODE.NO_FACE;
    }
    if (paramInt1 == -3) {
      return Face.ERROR_CODE.BAD_PARAM;
    }
    return Face.ERROR_CODE.UNKNOW;
  }
  
  public long Initial(String paramString1, String paramString2)
  {
    Destroy();
    this.facedetector = NativeInitial(paramString1, paramString2);
    this.detectflag = false;
    return 0L;
  }
  
  public long Initial(String paramString1, String paramString2, Face.ALG_MODE paramALG_MODE)
  {
    Destroy();
    if (Face.ALG_MODE.V1 == paramALG_MODE) {}
    for (this.facedetector = NativeInitialMode(paramString1, paramString2, 0);; this.facedetector = NativeInitialMode(paramString1, paramString2, 1))
    {
      this.detectflag = false;
      return 0L;
    }
  }
  
  public long Test()
  {
    return NativeTest();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.jni.Face
 * JD-Core Version:    0.7.0.1
 */