package com.tencent.mobileqq.vip;

import android.os.Bundle;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class DownloadTask
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 0;
  public static final int f = -1;
  public static final int g = -2;
  public static final int h = -100;
  public static final int i = -101;
  public static final int j = -102;
  public static final int k = -103;
  public static final int l = -104;
  public static final int m = -105;
  public static final int n = -106;
  public static final int o = -107;
  public static final int p = -108;
  public static final int q = -109;
  public static final int r = -110;
  public static final int s = -111;
  public static final int t = -112;
  public static final int u = -113;
  public static final int v = -114;
  public static final int w = -115;
  public static final int x = 1;
  public static final int y = 2;
  public int A = 3;
  public int B;
  public int C;
  public float a;
  public long a;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener;
  public String a;
  public List a;
  public Map a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(2);
  public boolean a;
  public long b;
  public String b;
  private Map jdField_b_of_type_JavaUtilMap;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean b;
  public long c;
  public String c;
  public boolean c;
  public long d;
  public String d;
  public boolean d;
  public long e;
  public String e;
  public boolean e;
  public long f;
  public boolean f;
  public long g;
  public boolean g;
  public long h;
  public boolean h;
  public boolean i = false;
  public boolean j = true;
  public int z = 0;
  
  public DownloadTask(String paramString, File paramFile)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_h_of_type_Long = 0L;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_e_of_type_JavaLangString = "Vip";
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilList.add(paramString);
    this.jdField_a_of_type_JavaUtilMap.put(paramString, paramFile);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.C = 1;
  }
  
  public DownloadTask(List paramList, Map paramMap, String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_h_of_type_Long = 0L;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_e_of_type_JavaLangString = "Vip";
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      if (paramMap == null) {
        break label191;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap = paramMap;
      this.jdField_a_of_type_JavaLangString = paramString;
      this.C = 2;
      return;
      paramList = new ArrayList();
      break;
      label191:
      paramMap = new HashMap();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public Bundle a()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  public DownloadListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener;
  }
  
  public Map a()
  {
    return this.jdField_b_of_type_JavaUtilMap;
  }
  
  public void a()
  {
    this.jdField_d_of_type_Long = 0L;
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    float f1 = 100.0F;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.B = paramInt;
    if (this.jdField_b_of_type_Long <= 0L) {
      f1 = 30.0F;
    }
    for (;;)
    {
      this.jdField_a_of_type_Float = ((f1 + paramInt * 100) / this.jdField_a_of_type_JavaUtilList.size());
      return;
      if (this.jdField_b_of_type_Long >= this.jdField_a_of_type_Long)
      {
        if (paramInt + 1 == this.jdField_a_of_type_JavaUtilList.size())
        {
          a(3);
          this.jdField_a_of_type_Float = 100.0F;
        }
      }
      else {
        f1 = 100.0F * (float)this.jdField_b_of_type_Long / (float)this.jdField_a_of_type_Long;
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(DownloadListener paramDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener = paramDownloadListener;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    for (;;)
    {
      return;
      try
      {
        if (this.jdField_b_of_type_JavaUtilMap == null) {
          this.jdField_b_of_type_JavaUtilMap = new HashMap();
        }
        this.jdField_b_of_type_JavaUtilMap.put(paramString1, paramString2);
      }
      finally {}
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public int b()
  {
    int i1 = 0;
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("id");
    }
    return i1;
  }
  
  public void b(int paramInt)
  {
    this.jdField_f_of_type_Long = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof DownloadTask)) && (((DownloadTask)paramObject).jdField_a_of_type_JavaUtilList.equals(this.jdField_a_of_type_JavaUtilList));
  }
  
  public String toString()
  {
    return " key=" + this.jdField_a_of_type_JavaLangString + ",urlList size=" + this.jdField_a_of_type_JavaUtilList.size() + "|currentUrlIndex=" + this.B + "|errCode=" + this.z + "|status=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger + "|readSize=" + this.jdField_b_of_type_Long + "|maxSize=" + this.jdField_a_of_type_Long + "|percent=" + this.jdField_a_of_type_Float;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vip.DownloadTask
 * JD-Core Version:    0.7.0.1
 */