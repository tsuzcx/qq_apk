package com.tencent.qbar;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import java.io.UnsupportedEncodingException;

public class QbarNative
{
  public static final int a = 0;
  public static boolean a = false;
  public static byte[] a;
  public static int[] a;
  public static final int b = 1;
  public static byte[] b;
  public static final int c = 0;
  public static byte[] c;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  public static final int g = 0;
  public static final int h = 1;
  public static final int i = 2;
  public static final int j = 3;
  public static final int k = 10;
  public static final int l = 0;
  public static final int m = 1;
  public static final int n = 2;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "stlport_shared");
    SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "QrMod");
    jdField_a_of_type_ArrayOfByte = new byte[100];
    b = new byte[3000];
    c = new byte[100];
    jdField_a_of_type_ArrayOfInt = new int[3];
  }
  
  public static native int GetOneResult(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int[] paramArrayOfInt);
  
  public static native String GetVersion();
  
  public static native int Init(int paramInt1, int paramInt2, String paramString1, String paramString2);
  
  public static native int Release();
  
  public static native int ScanImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public static native int SetReaders(int[] paramArrayOfInt, int paramInt);
  
  public static int a(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    i2 = 0;
    try
    {
      int i1 = GetOneResult(jdField_a_of_type_ArrayOfByte, b, c, jdField_a_of_type_ArrayOfInt);
      try
      {
        String str = new String(c, 0, jdField_a_of_type_ArrayOfInt[2], "UTF-8");
        if (str.equals("ANY"))
        {
          paramStringBuilder1.append(new String(jdField_a_of_type_ArrayOfByte, 0, jdField_a_of_type_ArrayOfInt[0], "UTF-8"));
          paramStringBuilder2.append(new String(b, 0, jdField_a_of_type_ArrayOfInt[1], "UTF-8"));
          i2 = i1;
          if (paramStringBuilder2.length() == 0)
          {
            paramStringBuilder1.append(new String(jdField_a_of_type_ArrayOfByte, 0, jdField_a_of_type_ArrayOfInt[0], "ASCII"));
            paramStringBuilder2.append(new String(b, 0, jdField_a_of_type_ArrayOfInt[1], "ASCII"));
            return i1;
          }
        }
        else
        {
          paramStringBuilder1.append(new String(jdField_a_of_type_ArrayOfByte, 0, jdField_a_of_type_ArrayOfInt[0], str));
          paramStringBuilder2.append(new String(b, 0, jdField_a_of_type_ArrayOfInt[1], str));
          return i1;
        }
      }
      catch (UnsupportedEncodingException paramStringBuilder1)
      {
        paramStringBuilder1.printStackTrace();
        return i1;
      }
      return i2;
    }
    catch (UnsatisfiedLinkError paramStringBuilder1) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qbar.QbarNative
 * JD-Core Version:    0.7.0.1
 */