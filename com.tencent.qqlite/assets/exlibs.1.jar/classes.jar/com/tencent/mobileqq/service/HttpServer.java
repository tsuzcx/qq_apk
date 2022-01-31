package com.tencent.mobileqq.service;

import com.dataline.util.DBNetworkUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import edd;
import edj;
import edp;
import java.io.IOException;
import java.net.InetAddress;

public class HttpServer
{
  public static final String a = "dlFileTransfer.Server";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private edj jdField_a_of_type_Edj = null;
  
  public HttpServer(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Edj != null) {
      return this.jdField_a_of_type_Edj.a();
    }
    return 0;
  }
  
  public String a(long paramLong)
  {
    return edp.a(paramLong);
  }
  
  public InetAddress a()
  {
    if (this.jdField_a_of_type_Edj != null) {
      return this.jdField_a_of_type_Edj.a();
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Edj != null)
    {
      this.jdField_a_of_type_Edj.a();
      this.jdField_a_of_type_Edj = null;
    }
  }
  
  public void a(long paramLong)
  {
    edp.a(paramLong);
  }
  
  public void a(long paramLong, String paramString)
  {
    edp.a(paramLong, paramString);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Edj != null) {
      return this.jdField_a_of_type_Edj.c();
    }
    return false;
  }
  
  public boolean a(String paramString, HttpNotify paramHttpNotify)
  {
    paramHttpNotify = new edd(paramHttpNotify);
    try
    {
      if (this.jdField_a_of_type_Edj != null)
      {
        if (this.jdField_a_of_type_Edj.c()) {
          return true;
        }
        a();
      }
      if (DBNetworkUtil.a())
      {
        this.jdField_a_of_type_Edj = new edj(paramString, paramHttpNotify, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_Edj.setDaemon(false);
        boolean bool = this.jdField_a_of_type_Edj.b();
        return bool;
      }
    }
    catch (IOException paramString) {}
    return false;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Edj.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.HttpServer
 * JD-Core Version:    0.7.0.1
 */