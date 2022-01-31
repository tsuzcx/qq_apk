package com.tencent.mobileqq.transfile;

import java.util.HashMap;

public class NetResp
{
  public static final int a = 0;
  public static final int b = 1;
  public static final String b = "param_rspHeader";
  public static final int c = 2;
  public static final String c = "param_reqHeader";
  public static final String d = "firstserverip";
  public static final String e = "serverip";
  public static final String f = "param_url";
  public static final String g = "netresp_param_reason";
  public static final String h = "qzone_desc";
  public static final String i = "qzone_detail_download_info";
  public long a;
  public NetReq a;
  public String a;
  public HashMap a;
  public byte[] a;
  public long b = 0L;
  public long c = 0L;
  public int d;
  public long d;
  public int e;
  long e;
  public int f;
  long f;
  public int g;
  public long g;
  int h;
  
  public NetResp(NetReq paramNetReq)
  {
    this.jdField_d_of_type_Int = 2;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_g_of_type_Int = 0;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_g_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = paramNetReq;
    this.jdField_f_of_type_Long = System.currentTimeMillis();
  }
  
  public void a()
  {
    this.jdField_d_of_type_Int = 2;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.b = 0L;
    this.c = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_g_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, HashMap paramHashMap)
  {
    this.jdField_d_of_type_Int = paramInt1;
    this.jdField_e_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.putAll(paramHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.NetResp
 * JD-Core Version:    0.7.0.1
 */