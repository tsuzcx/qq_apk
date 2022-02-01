package com.tencent.mobileqq.pic;

import android.util.SparseArray;

final class JpegError
{
  public static final int EBITMAP_NATIVE_ERR = 1;
  public static final int EFILEOPEN = 6;
  public static final int EINVALIDPARAM = 4;
  public static final int EJPEGINNER = 7;
  public static final int ENOTSUPPORT = 3;
  public static final int EOK = 0;
  public static final int ESIZEERR = 51;
  public static final int ESOLINKERR = 52;
  public static final int ESOLOADERR = 50;
  public static final int ESTATUS_ERR = 2;
  public static final int EUNKNOWNCOLORSPACE = 5;
  private static final SparseArray<String> map = new SparseArray(5);
  
  static
  {
    map.put(1, "EBITMAP_NATIVE_ERR");
    map.put(2, "ESTATUS_ERR:Close has been called,when you compress Bitmap.");
    map.put(3, "ENOTSUPPORT");
    map.put(4, "EINVALIDPARAM:Invalid Parameters.");
    map.put(5, "EUNKNOWNCOLORSPACE:unknown color space.");
    map.put(6, "EFILEOPEN:Open file failed.");
    map.put(7, "EJPEGINNER:JPEG library inner error.");
    map.put(50, "ESOLOADERR:So load error.");
    map.put(51, "ESIZEERR:Size error.");
    map.put(52, "ESOLINKERR:So Link error.");
  }
  
  public static void throwException(int paramInt)
  {
    int i = 0xFFFF & paramInt;
    throw new RuntimeException("JpegError: errcode=" + i + " Subcode=" + (paramInt >>> 16) + " Msg=" + (String)map.get(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.JpegError
 * JD-Core Version:    0.7.0.1
 */