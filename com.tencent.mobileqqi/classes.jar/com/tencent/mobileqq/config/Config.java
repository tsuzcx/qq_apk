package com.tencent.mobileqq.config;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.BaseConf;
import com.tencent.mobileqq.config.struct.PicAndAdConf;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class Config
{
  public static final byte A = 6;
  public static final byte B = 7;
  public static final byte C = 8;
  public static final byte D = 9;
  public static final byte E = 10;
  public static final byte F = 11;
  public static final byte G = 12;
  public static final byte H = 13;
  public static final byte I = 14;
  public static final byte J = 15;
  public static final byte K = 16;
  public static final byte L = 17;
  public static final byte M = 18;
  public static final byte N = 19;
  public static final byte O = 20;
  public static final byte P = 21;
  public static final byte Q = 22;
  public static final byte R = 23;
  public static final byte S = 24;
  public static final byte T = 25;
  public static final byte U = 26;
  public static final byte V = 27;
  public static final byte W = 28;
  public static final byte X = 29;
  public static final byte Y = 30;
  public static final byte Z = 31;
  public static final byte a = 0;
  public static final int a = 1;
  private static QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private static ConfigManager jdField_a_of_type_ComTencentMobileqqConfigConfigManager;
  public static PicAndAdConf a;
  private static HttpCommunicator jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator;
  public static final String a = "flashlogo.png";
  private static ArrayList jdField_a_of_type_JavaUtilArrayList;
  public static final boolean a = true;
  static BaseConf[] jdField_a_of_type_ArrayOfComTencentMobileqqConfigStructBaseConf;
  private static final byte aA = 0;
  private static final byte aB = 5;
  private static final byte aC = 6;
  private static final byte aD = 10;
  public static final byte aa = 32;
  public static final byte ab = 33;
  public static final byte ac = 34;
  public static final byte ad = 35;
  public static final byte ae = 36;
  public static final byte af = 37;
  public static final byte ag = 38;
  public static final byte ah = 39;
  public static final byte ai = 40;
  public static final byte aj = 41;
  public static final byte ak = 42;
  public static final byte al = 43;
  public static final byte am = 44;
  public static final byte an = 45;
  public static final byte ao = 46;
  public static final byte ap = 47;
  public static final byte aq = 48;
  public static final byte ar = 49;
  public static final byte as = 50;
  public static final byte at = 51;
  public static byte au = 3;
  public static byte av = 1;
  public static final byte aw = 3;
  public static final byte ax = 4;
  public static final byte ay = 5;
  public static final byte az = 6;
  public static final byte b = 1;
  public static final int b = 2;
  static PicAndAdConf jdField_b_of_type_ComTencentMobileqqConfigStructPicAndAdConf;
  public static final String b = "birthdayflashlogo.png";
  public static final byte c = 2;
  public static final int c = 3;
  public static final String c = "keywordRemarkConfig.xml";
  public static final byte d = 3;
  public static final int d = 4;
  public static final byte e = 4;
  public static final int e = 5;
  public static final byte f = 5;
  public static final int f = 6;
  public static final byte g = 6;
  public static final int g = 7;
  public static final byte h = 7;
  public static final int h = 1;
  public static final byte i = 0;
  public static final int i = 2;
  public static final byte j = 1;
  public static final int j = 3;
  public static final byte k = 10;
  public static final byte l = 11;
  public static final byte m = 12;
  public static final byte n = 13;
  public static final byte o = 14;
  public static final byte p = 20;
  public static final byte q = 0;
  public static final byte r = 1;
  public static final byte s = 2;
  public static final byte t = 3;
  public static final byte u = 0;
  public static final byte v = 1;
  public static final byte w = 2;
  public static final byte x = 3;
  public static final byte y = 4;
  public static final byte z = 5;
  private boolean jdField_b_of_type_Boolean = true;
  
  public Config(QQAppInterface paramQQAppInterface, String paramString)
  {
    jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator = jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    jdField_a_of_type_ComTencentMobileqqConfigConfigManager = new ConfigManager(paramQQAppInterface.a(), paramString);
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_ComTencentMobileqqConfigStructPicAndAdConf = new PicAndAdConf((short)24, (byte)0);
    jdField_b_of_type_ComTencentMobileqqConfigStructPicAndAdConf = new PicAndAdConf((short)12, (byte)1);
    jdField_a_of_type_ArrayOfComTencentMobileqqConfigStructBaseConf = new BaseConf[] { jdField_a_of_type_ComTencentMobileqqConfigStructPicAndAdConf, jdField_b_of_type_ComTencentMobileqqConfigStructPicAndAdConf };
    jdField_a_of_type_ComTencentMobileqqConfigConfigManager.a();
  }
  
  public static ConfigManager a()
  {
    return jdField_a_of_type_ComTencentMobileqqConfigConfigManager;
  }
  
  public static HttpCommunicator a()
  {
    return jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator;
  }
  
  public static String a()
  {
    String str = null;
    if (jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      str = jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    }
    return str;
  }
  
  public static String a(String paramString1, int paramInt, String paramString2)
  {
    return ConfigManager.a(ConfigManager.a(paramString1, paramInt), paramString2);
  }
  
  public static ArrayList a()
  {
    return jdField_a_of_type_JavaUtilArrayList;
  }
  
  public static void a(ConfigListener paramConfigListener)
  {
    if (jdField_a_of_type_JavaUtilArrayList != null) {
      jdField_a_of_type_JavaUtilArrayList.add(paramConfigListener);
    }
  }
  
  public static String b()
  {
    String str = null;
    if (jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      str = jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
    }
    return str;
  }
  
  public static void b()
  {
    jdField_a_of_type_ComTencentMobileqqConfigConfigManager = null;
    if (jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator != null) {
      jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.b();
    }
    jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator = null;
    jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public static void b(ConfigListener paramConfigListener)
  {
    if (jdField_a_of_type_JavaUtilArrayList != null) {
      jdField_a_of_type_JavaUtilArrayList.remove(paramConfigListener);
    }
  }
  
  public int a(int paramInt)
  {
    return jdField_a_of_type_ArrayOfComTencentMobileqqConfigStructBaseConf[paramInt].b();
  }
  
  public long a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 6) || (paramInt1 > 10)) {
      return 0L;
    }
    return ((PicAndAdConf)jdField_a_of_type_ArrayOfComTencentMobileqqConfigStructBaseConf[paramInt1]).a(paramInt2);
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    return ((PicAndAdConf)jdField_a_of_type_ArrayOfComTencentMobileqqConfigStructBaseConf[paramInt1]).a(paramInt2);
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 6) || (paramInt1 > 10)) {
      return null;
    }
    return ((PicAndAdConf)jdField_a_of_type_ArrayOfComTencentMobileqqConfigStructBaseConf[paramInt1]).a(paramInt2);
  }
  
  public short a(int paramInt1, int paramInt2)
  {
    return ((PicAndAdConf)jdField_a_of_type_ArrayOfComTencentMobileqqConfigStructBaseConf[paramInt1]).a(paramInt2);
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      jdField_a_of_type_ComTencentMobileqqConfigConfigManager.a(new BaseConf[] { jdField_a_of_type_ComTencentMobileqqConfigStructPicAndAdConf, jdField_b_of_type_ComTencentMobileqqConfigStructPicAndAdConf });
      if (QLog.isColorLevel()) {
        QLog.d("ShanPing", 2, "config-start-get--FlashLogo----------");
      }
      return;
    }
    jdField_a_of_type_ComTencentMobileqqConfigConfigManager.d();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 6) || (paramInt1 > 10)) {}
    PicAndAdConf localPicAndAdConf;
    do
    {
      return;
      localPicAndAdConf = (PicAndAdConf)jdField_a_of_type_ArrayOfComTencentMobileqqConfigStructBaseConf[paramInt1];
    } while (localPicAndAdConf == null);
    localPicAndAdConf.b(paramInt2);
  }
  
  public boolean a()
  {
    return jdField_a_of_type_ComTencentMobileqqConfigConfigManager.a();
  }
  
  public boolean a(int paramInt)
  {
    return jdField_a_of_type_ArrayOfComTencentMobileqqConfigStructBaseConf[paramInt].c();
  }
  
  public String b(int paramInt1, int paramInt2)
  {
    return ((PicAndAdConf)jdField_a_of_type_ArrayOfComTencentMobileqqConfigStructBaseConf[paramInt1]).c(paramInt2);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 6) || (paramInt1 > 10)) {
      return;
    }
    ADParser.b(((PicAndAdConf)jdField_a_of_type_ArrayOfComTencentMobileqqConfigStructBaseConf[paramInt1]).c(paramInt2));
  }
  
  public String c(int paramInt1, int paramInt2)
  {
    return ((PicAndAdConf)jdField_a_of_type_ArrayOfComTencentMobileqqConfigStructBaseConf[paramInt1]).b(paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.Config
 * JD-Core Version:    0.7.0.1
 */