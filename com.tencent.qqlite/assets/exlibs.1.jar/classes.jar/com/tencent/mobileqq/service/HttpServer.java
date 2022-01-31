package com.tencent.mobileqq.service;

import com.dataline.util.DBNetworkUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import ecx;
import edd;
import edj;
import java.io.IOException;
import java.net.InetAddress;

public class HttpServer
{
  public static final String a = "dlFileTransfer.Server";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private edd jdField_a_of_type_Edd = null;
  
  public HttpServer(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Edd != null) {
      return this.jdField_a_of_type_Edd.a();
    }
    return 0;
  }
  
  public String a(long paramLong)
  {
    return edj.a(paramLong);
  }
  
  public InetAddress a()
  {
    if (this.jdField_a_of_type_Edd != null) {
      return this.jdField_a_of_type_Edd.a();
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Edd != null)
    {
      this.jdField_a_of_type_Edd.a();
      this.jdField_a_of_type_Edd = null;
    }
  }
  
  public void a(long paramLong)
  {
    edj.a(paramLong);
  }
  
  public void a(long paramLong, String paramString)
  {
    edj.a(paramLong, paramString);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Edd != null) {
      return this.jdField_a_of_type_Edd.c();
    }
    return false;
  }
  
  public boolean a(String paramString, HttpNotify paramHttpNotify)
  {
    paramHttpNotify = new ecx(paramHttpNotify);
    try
    {
      if (this.jdField_a_of_type_Edd != null)
      {
        if (this.jdField_a_of_type_Edd.c()) {
          return true;
        }
        a();
      }
      if (DBNetworkUtil.a())
      {
        this.jdField_a_of_type_Edd = new edd(paramString, paramHttpNotify, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_Edd.setDaemon(false);
        boolean bool = this.jdField_a_of_type_Edd.b();
        return bool;
      }
    }
    catch (IOException paramString) {}
    return false;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Edd.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.HttpServer
 * JD-Core Version:    0.7.0.1
 */