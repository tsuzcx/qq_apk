package com.tencent.mobileqq.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.config.struct.BaseConf;
import com.tencent.mobileqq.config.struct.PicAndAdConf;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import fmm;
import fmn;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ConfigParser
{
  private static final byte jdField_a_of_type_Byte = 2;
  private static final int jdField_a_of_type_Int = 11;
  private static final String jdField_a_of_type_JavaLangString = "E1D84CC825147ECD";
  public static final short a = 1;
  private static final byte jdField_b_of_type_Byte = 3;
  private static final int jdField_b_of_type_Int = 27;
  public static final short b = 2;
  private static final int c = 1;
  public static final short c = 3;
  private static final int d = 1;
  public static final short d = 4;
  private static final int e = 3;
  public static final short e = 5;
  private static final int f = 32;
  public static final short f = 6;
  public static final short g = 7;
  public static final short h = 8;
  public static final short i = 9;
  public static final short j = 24;
  public static final short k = 11;
  public static final short l = 12;
  public static final short m = 14;
  public static final short n = 18;
  public static final short o = 20;
  private static final short p = 768;
  private static final short q = 1;
  
  public static HashMap a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      a(localHashMap, DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>" + paramString).getBytes())).getDocumentElement().getChildNodes());
      return localHashMap;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static void a(int paramInt, byte[] paramArrayOfByte, String paramString)
  {
    paramArrayOfByte = new Cryptor().decrypt(paramArrayOfByte, a());
    switch (paramInt)
    {
    case 3: 
    default: 
    case 4: 
      do
      {
        return;
        paramString = Config.a();
      } while (paramString == null);
      a(paramString.a, paramArrayOfByte);
      return;
    case 24: 
      Config.a.b();
      Config.a.a(false);
      a(Config.a, paramArrayOfByte, paramString);
      return;
    }
    Config.b.b();
    Config.b.a(false);
    a(Config.b, paramArrayOfByte);
  }
  
  private static void a(PicAndAdConf paramPicAndAdConf, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShanPing", 2, "config-huibao--decode---confighParse--buildItem_FlashLogo = ");
    }
    paramPicAndAdConf.jdField_a_of_type_Long = PkgTools.a(paramArrayOfByte, 0);
    paramPicAndAdConf.b = (PkgTools.a(paramArrayOfByte, 4) * 1000L);
    paramPicAndAdConf.c = (PkgTools.a(paramArrayOfByte, 8) * 1000L);
    int i3 = paramArrayOfByte[12];
    int i1 = 0;
    int i4;
    int i5;
    for (int i2 = 13; i1 < i3; i2 = i5 + i4)
    {
      long l1 = PkgTools.a(paramArrayOfByte, i2);
      i4 = i2 + 4;
      i2 = paramArrayOfByte[i4];
      i5 = i4 + 1 + 1;
      i4 = PkgTools.a(paramArrayOfByte, i5);
      i5 += 2;
      String str1 = PkgTools.a(paramArrayOfByte, i5, i4);
      i5 += i4;
      i4 = PkgTools.a(paramArrayOfByte, i5);
      i5 += 2;
      String str2 = PkgTools.a(paramArrayOfByte, i5, i4);
      if (i2 == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShanPing", 2, "flashlogo desc= " + str1 + " src addr = " + str2);
        }
        str2 = paramPicAndAdConf.a(str1, (byte)3);
        paramPicAndAdConf.a_(str2);
        paramPicAndAdConf.a(paramPicAndAdConf.a(l1, str1, str2, null, ""));
      }
      i1 += 1;
    }
  }
  
  private static void a(PicAndAdConf paramPicAndAdConf, byte[] paramArrayOfByte, String paramString)
  {
    paramPicAndAdConf.jdField_a_of_type_Long = PkgTools.a(paramArrayOfByte, 0);
    paramPicAndAdConf.b = (PkgTools.a(paramArrayOfByte, 4) * 1000L);
    paramPicAndAdConf.c = (PkgTools.a(paramArrayOfByte, 8) * 1000L);
    int i3 = paramArrayOfByte[12];
    if (i3 > 0)
    {
      paramPicAndAdConf.c();
      BaseApplication.getContext().getSharedPreferences("mobileQQi", 0).edit().putBoolean("push_banner_display" + paramString, true).commit();
    }
    int i1 = 0;
    int i5;
    int i6;
    for (int i2 = 13; i1 < i3; i2 = i5 + i6)
    {
      long l1 = PkgTools.a(paramArrayOfByte, i2);
      int i4 = i2 + 4;
      i2 = paramArrayOfByte[i4];
      i4 = i4 + 1 + 1;
      long l2 = PkgTools.a(paramArrayOfByte, i4);
      i5 = i4 + 4;
      i4 = PkgTools.a(paramArrayOfByte, i5);
      i6 = i5 + 2;
      i5 = PkgTools.a(paramArrayOfByte, i6);
      i6 += 2;
      paramString = PkgTools.a(paramArrayOfByte, i6, i5);
      i6 += i5;
      i5 = PkgTools.a(paramArrayOfByte, i6);
      i6 += 2;
      String str2 = PkgTools.a(paramArrayOfByte, i6, i5);
      i6 += i5;
      i5 = PkgTools.a(paramArrayOfByte, i6);
      i6 += 2;
      String str1 = PkgTools.a(paramArrayOfByte, i6, i5);
      if (i2 == 1)
      {
        str2 = paramPicAndAdConf.a(str2, (byte)3);
        if (!a(String.valueOf(l1))) {
          paramPicAndAdConf.a_(str2);
        }
        paramPicAndAdConf.a(paramPicAndAdConf.a(l1, paramString, str2, str1, BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/ADPic/" + l1, "" + l2, (short)i4));
      }
      i1 += 1;
    }
  }
  
  private static void a(fmm paramfmm, byte[] paramArrayOfByte)
  {
    int i1 = PkgTools.a(paramArrayOfByte, 0);
    paramfmm.jdField_a_of_type_JavaLangString = PkgTools.a(paramArrayOfByte, 2, i1);
    i1 += 2;
    paramfmm.jdField_a_of_type_Byte = paramArrayOfByte[i1];
    i1 += 1;
    paramfmm.jdField_b_of_type_Byte = paramArrayOfByte[i1];
    int i2 = i1 + 1;
    i1 = PkgTools.a(paramArrayOfByte, i2);
    i2 += 2;
    paramfmm.jdField_b_of_type_JavaLangString = PkgTools.a(paramArrayOfByte, i2, i1);
  }
  
  private static void a(fmn paramfmn) {}
  
  private static void a(fmn paramfmn, String paramString)
  {
    int i3 = 2;
    int i4 = 0;
    int i5 = PkgTools.a(paramfmn.jdField_a_of_type_ArrayOfByte, 0);
    int i1 = i4;
    int i2 = i3;
    if (QLog.isColorLevel())
    {
      QLog.d("ShanPing", 2, "config-huibao--decode---confighParse--itemNum = " + i5);
      i2 = i3;
      i1 = i4;
    }
    while (i1 < i5)
    {
      i3 = PkgTools.a(paramfmn.jdField_a_of_type_ArrayOfByte, i2);
      i4 = i2 + 2;
      i2 = PkgTools.a(paramfmn.jdField_a_of_type_ArrayOfByte, i4);
      i4 += 2;
      byte[] arrayOfByte = new byte[i2];
      PkgTools.b(paramfmn.jdField_a_of_type_ArrayOfByte, i4, arrayOfByte, i2);
      i2 = i4 + i2;
      a(i3, arrayOfByte, paramString);
      i1 += 1;
    }
    paramfmn = Config.a();
    if (paramfmn != null) {
      paramfmn.c();
    }
  }
  
  private static void a(HashMap paramHashMap, NodeList paramNodeList)
  {
    if ((paramNodeList == null) || (paramNodeList.getLength() == 0)) {
      return;
    }
    int i1 = 0;
    label16:
    Node localNode;
    if (i1 < paramNodeList.getLength())
    {
      localNode = paramNodeList.item(i1);
      if (!(localNode instanceof Element)) {
        break label67;
      }
      if (localNode.hasChildNodes()) {
        a(paramHashMap, localNode.getChildNodes());
      }
    }
    for (;;)
    {
      i1 += 1;
      break label16;
      break;
      label67:
      if (localNode.getParentNode() != null) {
        paramHashMap.put(localNode.getParentNode().getNodeName(), localNode.getNodeValue());
      }
    }
  }
  
  private static void a(byte[] paramArrayOfByte, fmn paramfmn)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 11)) {}
    for (;;)
    {
      return;
      if (paramArrayOfByte[0] == 2)
      {
        paramfmn.b = PkgTools.a(paramArrayOfByte, 1);
        paramfmn.jdField_a_of_type_Short = PkgTools.a(paramArrayOfByte, 3);
        paramfmn.jdField_a_of_type_Long = (PkgTools.a(paramArrayOfByte, 5) * 1000L);
        paramfmn.jdField_a_of_type_Byte = paramArrayOfByte[9];
        int i1 = paramArrayOfByte.length - 10 - 1;
        if (paramfmn.jdField_a_of_type_Byte == 0)
        {
          paramfmn.jdField_a_of_type_ArrayOfByte = new byte[i1];
          PkgTools.b(paramArrayOfByte, 10, paramfmn.jdField_a_of_type_ArrayOfByte, i1);
        }
        while (paramArrayOfByte.length != i1 + 10 + 1)
        {
          return;
          paramfmn.jdField_a_of_type_JavaLangString = PkgTools.a(paramArrayOfByte, 10, i1);
        }
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    return new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/ADPic/" + paramString).exists();
  }
  
  public static boolean a(byte[] paramArrayOfByte, fmn paramfmn, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    do
    {
      do
      {
        return false;
        a(paramArrayOfByte, paramfmn);
      } while (paramfmn.b != 768);
      if (paramfmn.jdField_a_of_type_Byte != 0)
      {
        a(paramfmn);
        return false;
      }
    } while ((paramfmn.jdField_a_of_type_ArrayOfByte == null) || (paramfmn.jdField_a_of_type_ArrayOfByte.length == 0));
    a(paramfmn, paramString);
    return true;
  }
  
  private static byte[] a()
  {
    String str = MD5.toMD5(Config.a() + AppSetting.a() + "E1D84CC825147ECD").substring(0, 16);
    try
    {
      byte[] arrayOfByte = str.getBytes("ISO8859_1");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return str.getBytes();
  }
  
  public static byte[] a(BaseConf[] paramArrayOfBaseConf)
  {
    int i1 = 0;
    short s = (short)(paramArrayOfBaseConf.length + 1);
    byte[] arrayOfByte = new byte[s * 6 + 2 + 27];
    arrayOfByte[0] = 2;
    PkgTools.a(arrayOfByte, 1, (short)768);
    PkgTools.a(arrayOfByte, 3, (short)1);
    PkgTools.a(arrayOfByte, 5, Long.valueOf(Config.a()).longValue());
    PkgTools.a(arrayOfByte, 9, AppSetting.a().getBytes(), 16);
    arrayOfByte[25] = 3;
    PkgTools.a(arrayOfByte, 26, s);
    int i2 = 28;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("Make Packager:");
    while (i1 < s - 1)
    {
      PkgTools.a(arrayOfByte, i2, paramArrayOfBaseConf[i1].a());
      i2 += 2;
      PkgTools.a(arrayOfByte, i2, paramArrayOfBaseConf[i1].jdField_a_of_type_Long);
      i2 += 4;
      localStringBuffer.append(paramArrayOfBaseConf[i1].a() + "-" + paramArrayOfBaseConf[i1].jdField_a_of_type_Long + ",");
      i1 += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, localStringBuffer.toString());
    }
    PkgTools.a(arrayOfByte, i2, (short)4);
    i1 = i2 + 2;
    PkgTools.a(arrayOfByte, i1, 0L);
    i1 += 4;
    arrayOfByte[i1] = 3;
    paramArrayOfBaseConf = arrayOfByte;
    if (i1 + 1 != arrayOfByte.length) {
      paramArrayOfBaseConf = null;
    }
    return paramArrayOfBaseConf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.ConfigParser
 * JD-Core Version:    0.7.0.1
 */