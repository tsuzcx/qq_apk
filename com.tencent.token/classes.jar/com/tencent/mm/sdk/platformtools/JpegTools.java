package com.tencent.mm.sdk.platformtools;

import java.nio.ByteBuffer;

public class JpegTools
{
  public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
  public static final int ORIENTATION_FLIP_VERTICAL = 4;
  public static final int ORIENTATION_NORMAL = 1;
  public static final int ORIENTATION_ROTATE_180 = 3;
  public static final int ORIENTATION_ROTATE_270 = 8;
  public static final int ORIENTATION_ROTATE_90 = 6;
  public static final int ORIENTATION_TRANSPOSE = 5;
  public static final int ORIENTATION_TRANSVERSE = 7;
  public static final int ORIENTATION_UNDEFINED = 0;
  public static final String TAG = "MicroMsg.JpegTools";
  private MBuf B = null;
  private int C = -1;
  private boolean D = true;
  
  public JpegTools(byte[] paramArrayOfByte)
  {
    this.B.setBuffer(paramArrayOfByte);
  }
  
  private void a(int paramInt)
  {
    int i = this.B.getBuffer().position();
    this.B.getBuffer().position(i + paramInt);
  }
  
  public static String byte2HexString(byte paramByte)
  {
    String str2 = Integer.toHexString(paramByte & 0xFF);
    String str1 = str2;
    if (str2.length() == 1) {
      str1 = "0" + str2;
    }
    return "" + str1.toUpperCase();
  }
  
  public int getOreiValue()
  {
    if (this.C != -1) {}
    switch (this.C)
    {
    case 2: 
    case 4: 
    case 5: 
    case 7: 
    default: 
      return -1;
    case 6: 
      return 90;
    case 3: 
      return 180;
    case 8: 
      return 270;
    }
    return 0;
  }
  
  public int parserJpeg()
  {
    int k = 0;
    try
    {
      b1 = this.B.getBuffer().get();
      b2 = this.B.getBuffer().get();
      if ((!byte2HexString(b1).equals("FF")) || (!byte2HexString(b2).equals("D8"))) {
        break label892;
      }
      i = 1;
      if (i != 0) {
        break label897;
      }
      Log.w("MicroMsg.JpegTools", "this is not jpeg or no exif data!!!");
      return -1;
    }
    catch (Exception localException)
    {
      byte b1;
      byte b2;
      label64:
      int n;
      String str1;
      boolean bool;
      Log.e("MicroMsg.JpegTools", "parser jpeg error");
      return -1;
    }
    b1 = this.B.getBuffer().get();
    b2 = this.B.getBuffer().get();
    this.B.getBuffer().get();
    int j = this.B.getBuffer().get();
    if (!byte2HexString(b1).equals("FF")) {
      i = -1;
    }
    for (;;)
    {
      if (i >= 0) {
        break label255;
      }
      Log.w("MicroMsg.JpegTools", "datalen is error ");
      return -1;
      if ((byte2HexString(b1).equals("FF")) && (byte2HexString(b2).equals("E1")))
      {
        i = (j & 0xFF) - 2;
      }
      else if ((byte2HexString(b1).equals("FF")) && (byte2HexString(b2).equals("D9")))
      {
        i = -1;
      }
      else
      {
        m = this.B.getOffset();
        this.B.getBuffer().position(m + j - 2);
        j = i + 1;
        i = j;
        if (j <= 100) {
          break;
        }
        Log.e("MicroMsg.JpegTools", "error while!");
        i = -1;
      }
    }
    label255:
    int i = this.B.getBuffer().get();
    j = this.B.getBuffer().get();
    int m = this.B.getBuffer().get();
    n = this.B.getBuffer().get();
    if (((char)i + (char)j + (char)m + (char)n).equals("Exif"))
    {
      i = 1;
      label345:
      if (i == 0)
      {
        Log.w("MicroMsg.JpegTools", "checkExifTag is error");
        return -1;
      }
      a(2);
      i = this.B.getBuffer().get();
      j = this.B.getBuffer().get();
      if (((char)i != 'M') || ((char)j != 'M')) {
        break label907;
      }
      str1 = "MM";
      label405:
      if ((!str1.equals("MM")) && (!str1.equals("II")))
      {
        Log.w("MicroMsg.JpegTools", "byteOrder  is error " + str1);
        return -1;
      }
      this.D = str1.equals("MM");
      bool = this.D;
      b1 = this.B.getBuffer().get();
      b2 = this.B.getBuffer().get();
      if ((bool) && (byte2HexString(b1).equals("00")) && (byte2HexString(b2).equals("2A"))) {
        i = 1;
      }
      while (i == 0)
      {
        Log.w("MicroMsg.JpegTools", "checkTiffTag  is error ");
        return -1;
        if ((byte2HexString(b1).equals("2A")) && (byte2HexString(b2).equals("00")))
        {
          i = 1;
        }
        else
        {
          Log.w("MicroMsg.JpegTools", "checkTiffTag: " + byte2HexString(b1) + " " + byte2HexString(b2));
          i = 0;
        }
      }
      a(4);
      j = this.B.getBuffer().get();
      i = this.B.getBuffer().get();
      j &= 0xFF;
      if (!this.D) {
        break label936;
      }
      j = i & 0xFF;
      break label936;
      label655:
      if ((m < j) && (m < 255))
      {
        b1 = this.B.getBuffer().get();
        b2 = this.B.getBuffer().get();
        if ((!this.D) || (!byte2HexString(b1).equals("01")) || (!byte2HexString(b2).equals("12"))) {
          break label819;
        }
        i = 1;
        label725:
        a(2);
        a(4);
        if (i == 0) {
          break label864;
        }
        bool = this.D;
        i = this.B.getBuffer().get();
        j = this.B.getBuffer().get();
        a(2);
        if (!bool) {
          break label942;
        }
        i = j & 0xFF;
      }
    }
    for (;;)
    {
      this.C = i;
      Log.d("MicroMsg.JpegTools", "orei " + this.C);
      return getOreiValue();
      label819:
      i = k;
      if (this.D) {
        break label725;
      }
      i = k;
      if (!byte2HexString(b1).equals("12")) {
        break label725;
      }
      i = k;
      if (!byte2HexString(b2).equals("01")) {
        break label725;
      }
      i = 1;
      break label725;
      label864:
      a(4);
      m += 1;
      k = i;
      break label655;
      label892:
      i = 0;
      break;
      label897:
      i = 0;
      break label64;
      i = 0;
      break label345;
      label907:
      if (((char)i == 'I') && ((char)j == 'I'))
      {
        str2 = "II";
        break label405;
      }
      String str2 = "";
      break label405;
      label936:
      m = 0;
      break label655;
      label942:
      i &= 0xFF;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.JpegTools
 * JD-Core Version:    0.7.0.1
 */