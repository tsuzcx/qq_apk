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
  long c = 0L;
  public int d;
  long d;
  public int e;
  public long e;
  public int f = 0;
  public int g = 0;
  public int h = 0;
  public int i = 0;
  int j;
  
  public NetResp(NetReq paramNetReq)
  {
    this.jdField_d_of_type_Int = 2;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_e_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = paramNetReq;
    this.jdField_d_of_type_Long = System.currentTimeMillis();
  }
  
  public void a()
  {
    this.jdField_d_of_type_Int = 2;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_e_of_type_Int = 0;
    this.f = 0;
    this.g = 0;
    this.h = 0;
    this.b = 0L;
    this.i = 0;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(int paramInt, long paramLong, String paramString, HashMap paramHashMap)
  {
    this.jdField_d_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.putAll(paramHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.NetResp
 * JD-Core Version:    0.7.0.1
 */