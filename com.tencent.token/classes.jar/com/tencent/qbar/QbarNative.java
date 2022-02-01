package com.tencent.qbar;

import android.graphics.Point;
import java.io.UnsupportedEncodingException;

public class QbarNative
{
  public static final int ALL_BARCODE = 10;
  public static final int AZTEC = 1;
  public static final int CODABAR = 2;
  public static final int CODE_128 = 5;
  public static final int CODE_39 = 3;
  public static final int CODE_93 = 4;
  public static final int DATA_MATRIX = 6;
  public static final int EAN_13 = 8;
  public static final int EAN_8 = 7;
  public static final int FAST = 0;
  public static final int GRAY = 0;
  public static final int H = 3;
  public static final int ITF = 9;
  public static final int L = 0;
  public static final int M = 1;
  public static final int MAXICODE = 10;
  public static final int NORMAL = 1;
  public static final int ONED_BARCODE = 0;
  public static final int PDF_417 = 11;
  public static final int PRODUCT_BARCODE = 3;
  public static final int Q = 2;
  public static final int QRCODE = 2;
  public static final int QR_CODE = 0;
  public static final int RGB = 1;
  public static final int RGBA = 2;
  public static final int RSS_14 = 12;
  public static final int RSS_EXPANDED = 13;
  public static final int SCAN_FILE = 1;
  public static final int SCAN_VIDEO = 0;
  public static final int SEARCH_MULTI = 1;
  public static final int SEARCH_ONE = 0;
  public static final int TRYHARDER = 2;
  public static final int TWOD_BARCODE = 1;
  public static final int UPC_A = 14;
  public static final int UPC_E = 15;
  public static final int UPC_EAN_EXTENSION = 16;
  public static QbarArea area = new QbarArea();
  public static byte[] charset = new byte[100];
  public static byte[] data;
  public static int height;
  public static int pointNum;
  public static int[] sizeArr = new int[4];
  public static byte[] type;
  public static int typeID;
  public static int width;
  public static int x;
  public static int y;
  
  static
  {
    System.loadLibrary("stlport_shared");
    System.loadLibrary("QrMod");
    type = new byte[100];
    data = new byte[3000];
  }
  
  public static native int Encode(byte[] paramArrayOfByte, int[] paramArrayOfInt, String paramString1, int paramInt1, int paramInt2, String paramString2);
  
  public static int GetOneResult(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    int i = GetOneResult(type, data, charset, sizeArr);
    try
    {
      String str = new String(charset, 0, sizeArr[2], "UTF-8");
      if (str.equals("ANY"))
      {
        paramStringBuilder1.append(new String(type, 0, sizeArr[0], "UTF-8"));
        paramStringBuilder2.append(new String(data, 0, sizeArr[1], "UTF-8"));
        if (paramStringBuilder2.length() == 0)
        {
          paramStringBuilder1.append(new String(type, 0, sizeArr[0], "ASCII"));
          paramStringBuilder2.append(new String(data, 0, sizeArr[1], "ASCII"));
          return i;
        }
      }
      else
      {
        paramStringBuilder1.append(new String(type, 0, sizeArr[0], str));
        paramStringBuilder2.append(new String(data, 0, sizeArr[1], str));
        return i;
      }
    }
    catch (UnsupportedEncodingException paramStringBuilder1)
    {
      paramStringBuilder1.printStackTrace();
    }
    return i;
  }
  
  public static int GetOneResult(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, Point[] paramArrayOfPoint)
  {
    int i = GetResults(type, data, charset, paramArrayOfPoint, sizeArr, area);
    typeID = area.typeID;
    x = area.x;
    y = area.y;
    width = area.width;
    height = area.height;
    pointNum = sizeArr[3];
    try
    {
      paramArrayOfPoint = new String(charset, 0, sizeArr[2], "UTF-8");
      if (paramArrayOfPoint.equals("ANY"))
      {
        paramStringBuilder1.append(new String(type, 0, sizeArr[0], "UTF-8"));
        paramStringBuilder2.append(new String(data, 0, sizeArr[1], "UTF-8"));
        if (paramStringBuilder2.length() == 0)
        {
          paramStringBuilder1.append(new String(type, 0, sizeArr[0], "ASCII"));
          paramStringBuilder2.append(new String(data, 0, sizeArr[1], "ASCII"));
          return i;
        }
      }
      else
      {
        paramStringBuilder1.append(new String(type, 0, sizeArr[0], paramArrayOfPoint));
        paramStringBuilder2.append(new String(data, 0, sizeArr[1], paramArrayOfPoint));
        return i;
      }
    }
    catch (UnsupportedEncodingException paramStringBuilder1)
    {
      paramStringBuilder1.printStackTrace();
    }
    return i;
  }
  
  private static native int GetOneResult(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int[] paramArrayOfInt);
  
  private static native int GetResults(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, Point[] paramArrayOfPoint, int[] paramArrayOfInt, QbarArea paramQbarArea);
  
  public static native String GetVersion();
  
  public static native int Init(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2);
  
  public static native int Release();
  
  public static native int ScanImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public static native int SetReaders(int[] paramArrayOfInt, int paramInt);
  
  private static class QbarArea
  {
    public int height = 0;
    public int typeID = 0;
    public int width = 0;
    public int x = 0;
    public int y = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qbar.QbarNative
 * JD-Core Version:    0.7.0.1
 */