package com.tencent.mobileqq.service;

import com.dataline.util.DBNetworkUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import eei;
import eeo;
import eeu;
import java.io.IOException;
import java.net.InetAddress;

public class HttpServer
{
  public static final String a = "dlFileTransfer.Server";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private eeo jdField_a_of_type_Eeo = null;
  
  public HttpServer(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Eeo != null) {
      return this.jdField_a_of_type_Eeo.a();
    }
    return 0;
  }
  
  public String a(long paramLong)
  {
    return eeu.a(paramLong);
  }
  
  public InetAddress a()
  {
    if (this.jdField_a_of_type_Eeo != null) {
      return this.jdField_a_of_type_Eeo.a();
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Eeo != null)
    {
      this.jdField_a_of_type_Eeo.a();
      this.jdField_a_of_type_Eeo = null;
    }
  }
  
  public void a(long paramLong)
  {
    eeu.a(paramLong);
  }
  
  public void a(long paramLong, String paramString)
  {
    eeu.a(paramLong, paramString);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Eeo != null) {
      return this.jdField_a_of_type_Eeo.c();
    }
    return false;
  }
  
  public boolean a(String paramString, HttpNotify paramHttpNotify)
  {
    paramHttpNotify = new eei(paramHttpNotify);
    try
    {
      if (this.jdField_a_of_type_Eeo != null)
      {
        if (this.jdField_a_of_type_Eeo.c()) {
          return true;
        }
        a();
      }
      if (DBNetworkUtil.a())
      {
        this.jdField_a_of_type_Eeo = new eeo(paramString, paramHttpNotify, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_Eeo.setDaemon(false);
        boolean bool = this.jdField_a_of_type_Eeo.b();
        return bool;
      }
    }
    catch (IOException paramString) {}
    return false;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Eeo.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.HttpServer
 * JD-Core Version:    0.7.0.1
 */