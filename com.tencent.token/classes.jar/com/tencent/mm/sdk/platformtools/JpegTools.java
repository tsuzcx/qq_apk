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
    Object localObject2 = Integer.toHexString(paramByte & 0xFF);
    Object localObject1 = localObject2;
    if (((String)localObject2).length() == 1)
    {
      localObject1 = new StringBuilder("0");
      ((StringBuilder)localObject1).append((String)localObject2);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(((String)localObject1).toUpperCase());
    return ((StringBuilder)localObject2).toString();
  }
  
  public int getOreiValue()
  {
    int i = this.C;
    if (i != -1)
    {
      if (i != 1)
      {
        if (i != 3)
        {
          if (i != 6)
          {
            if (i != 8) {
              return -1;
            }
            return 270;
          }
          return 90;
        }
        return 180;
      }
      return 0;
    }
    return -1;
  }
  
  public int parserJpeg()
  {
    try
    {
      b1 = this.B.getBuffer().get();
      b2 = this.B.getBuffer().get();
      bool = byte2HexString(b1).equals("FF");
      j = 0;
      if ((!bool) || (!byte2HexString(b2).equals("D8"))) {
        break label946;
      }
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        byte b1;
        byte b2;
        boolean bool;
        int j;
        int k;
        int m;
        int n;
        Object localObject;
        StringBuilder localStringBuilder;
        continue;
        label946:
        int i = 0;
        continue;
        i = 0;
        continue;
        label956:
        i = -1;
        continue;
        label961:
        String str;
        if ((k == 73) && ((char)i == 'I'))
        {
          str = "II";
        }
        else
        {
          str = "";
          continue;
          label989:
          i = 1;
          continue;
          label994:
          m = 0;
          continue;
          label1000:
          k = 1;
          continue;
          label1006:
          i &= 0xFF;
        }
      }
    }
    if (i == 0)
    {
      Log.w("MicroMsg.JpegTools", "this is not jpeg or no exif data!!!");
      return -1;
      do
      {
        b1 = this.B.getBuffer().get();
        b2 = this.B.getBuffer().get();
        this.B.getBuffer().get();
        k = this.B.getBuffer().get();
        if (!byte2HexString(b1).equals("FF")) {
          break label956;
        }
        if ((byte2HexString(b1).equals("FF")) && (byte2HexString(b2).equals("E1")))
        {
          i = (k & 0xFF) - 2;
          break;
        }
        if ((byte2HexString(b1).equals("FF")) && (byte2HexString(b2).equals("D9"))) {
          break label956;
        }
        m = this.B.getOffset();
        this.B.getBuffer().position(m + k - 2);
        k = i + 1;
        i = k;
      } while (k <= 100);
      Log.e("MicroMsg.JpegTools", "error while!");
      break label956;
      if (i < 0)
      {
        Log.w("MicroMsg.JpegTools", "datalen is error ");
        return -1;
      }
      i = this.B.getBuffer().get();
      k = this.B.getBuffer().get();
      m = this.B.getBuffer().get();
      n = this.B.getBuffer().get();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append((char)i);
      ((StringBuilder)localObject).append((char)k);
      ((StringBuilder)localObject).append((char)m);
      ((StringBuilder)localObject).append((char)n);
      if (!((StringBuilder)localObject).toString().equals("Exif"))
      {
        Log.w("MicroMsg.JpegTools", "checkExifTag is error");
        return -1;
      }
      a(2);
      k = this.B.getBuffer().get();
      i = this.B.getBuffer().get();
      k = (char)k;
      if ((k != 77) || ((char)i != 'M')) {
        break label961;
      }
      localObject = "MM";
      if ((!((String)localObject).equals("MM")) && (!((String)localObject).equals("II")))
      {
        localStringBuilder = new StringBuilder("byteOrder  is error ");
        localStringBuilder.append((String)localObject);
        Log.w("MicroMsg.JpegTools", localStringBuilder.toString());
        return -1;
      }
      this.D = ((String)localObject).equals("MM");
      bool = this.D;
      b1 = this.B.getBuffer().get();
      b2 = this.B.getBuffer().get();
      if (((bool) && (byte2HexString(b1).equals("00")) && (byte2HexString(b2).equals("2A"))) || ((byte2HexString(b1).equals("2A")) && (byte2HexString(b2).equals("00")))) {
        break label989;
      }
      localObject = new StringBuilder("checkTiffTag: ");
      ((StringBuilder)localObject).append(byte2HexString(b1));
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(byte2HexString(b2));
      Log.w("MicroMsg.JpegTools", ((StringBuilder)localObject).toString());
      i = 0;
      if (i == 0)
      {
        Log.w("MicroMsg.JpegTools", "checkTiffTag  is error ");
        return -1;
      }
      a(4);
      i = this.B.getBuffer().get();
      k = this.B.getBuffer().get();
      i &= 0xFF;
      if (!this.D) {
        break label994;
      }
      i = k & 0xFF;
      break label994;
      while ((j < i) && (j < 255))
      {
        b1 = this.B.getBuffer().get();
        b2 = this.B.getBuffer().get();
        if ((this.D) && (byte2HexString(b1).equals("01")) && (byte2HexString(b2).equals("12"))) {
          break label1000;
        }
        k = m;
        if (!this.D)
        {
          k = m;
          if (byte2HexString(b1).equals("12"))
          {
            k = m;
            if (byte2HexString(b2).equals("01")) {
              break label1000;
            }
          }
        }
        a(2);
        a(4);
        if (k != 0)
        {
          bool = this.D;
          i = this.B.getBuffer().get();
          j = this.B.getBuffer().get();
          a(2);
          if (!bool) {
            break label1006;
          }
          i = j & 0xFF;
          this.C = i;
          break;
        }
        a(4);
        j += 1;
        m = k;
      }
      localObject = new StringBuilder("orei ");
      ((StringBuilder)localObject).append(this.C);
      Log.d("MicroMsg.JpegTools", ((StringBuilder)localObject).toString());
      return getOreiValue();
      Log.e("MicroMsg.JpegTools", "parser jpeg error");
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.JpegTools
 * JD-Core Version:    0.7.0.1
 */