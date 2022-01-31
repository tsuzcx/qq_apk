package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.ProxyIpManager;
import mqq.manager.ProxyIpManager.ProxyIp;

public class HttpUrlProcessor
{
  private static final String jdField_a_of_type_JavaLangString = "HttpUrlProcessor";
  private Iterator jdField_a_of_type_JavaUtilIterator;
  private List jdField_a_of_type_JavaUtilList;
  private ProxyIpManager.ProxyIp jdField_a_of_type_MqqManagerProxyIpManager$ProxyIp;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private Iterator jdField_b_of_type_JavaUtilIterator;
  private List jdField_b_of_type_JavaUtilList;
  
  public HttpUrlProcessor(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = "http://".length();
    Object localObject;
    if (!paramString.startsWith("http://"))
    {
      localObject = null;
      paramString = str;
    }
    for (;;)
    {
      if ((localObject != null) && (paramString != null))
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList(1);
        this.jdField_a_of_type_JavaUtilList.add(localObject);
        this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        this.jdField_b_of_type_JavaLangString = paramString;
      }
      a(paramQQAppInterface);
      return;
      int j = paramString.indexOf("/", i);
      if (-1 == j)
      {
        localObject = null;
        paramString = str;
      }
      else
      {
        int k = paramString.indexOf("&bHost=");
        if (-1 == k) {
          localObject = null;
        }
        for (;;)
        {
          if (localObject != null) {
            break label232;
          }
          localObject = paramString.substring(i, j);
          paramString = paramString.substring(j);
          break;
          int m = paramString.indexOf("&bPort=", k);
          if (-1 == m)
          {
            localObject = null;
          }
          else
          {
            localObject = paramString.substring("&bHost=".length() + k, m);
            str = paramString.substring(m + "&bPort=".length());
            localObject = (String)localObject + ":" + str;
          }
        }
        label232:
        paramString = paramString.substring(j, k);
      }
    }
  }
  
  public HttpUrlProcessor(QQAppInterface paramQQAppInterface, List paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_b_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    a(paramQQAppInterface);
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_JavaUtilList = ((ProxyIpManager)paramQQAppInterface.getManager(3)).getProxyIp(5);
    if (this.jdField_b_of_type_JavaUtilList == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("HttpUrlProcessor", 4, "HttpUrlProcessor: getProxyIp return null, so new empty ProxyList");
      }
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    a();
  }
  
  public String a()
  {
    String str1 = null;
    String str2;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      str2 = str1;
      if (QLog.isDevelopLevel())
      {
        QLog.d("HttpUrlProcessor", 4, "getNextUrl: no host, so return null");
        str2 = str1;
      }
      return str2;
    }
    if (!this.jdField_a_of_type_JavaUtilIterator.hasNext())
    {
      if (this.jdField_b_of_type_JavaUtilIterator.hasNext())
      {
        this.jdField_a_of_type_MqqManagerProxyIpManager$ProxyIp = ((ProxyIpManager.ProxyIp)this.jdField_b_of_type_JavaUtilIterator.next());
        this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      }
    }
    else
    {
      label94:
      str1 = (String)this.jdField_a_of_type_JavaUtilIterator.next();
      if (!this.jdField_a_of_type_Boolean) {
        break label295;
      }
      int i = str1.indexOf(":");
      if (i <= 0) {
        break label287;
      }
      str2 = str1.substring(0, i);
      str1 = str1.substring(i + 1);
    }
    label140:
    label287:
    label295:
    for (str1 = "http://" + this.jdField_a_of_type_MqqManagerProxyIpManager$ProxyIp.ip + ":" + this.jdField_a_of_type_MqqManagerProxyIpManager$ProxyIp.port + this.jdField_b_of_type_JavaLangString + "&bHost=" + str2 + "&bPort=" + str1;; str1 = "http://" + str1 + this.jdField_b_of_type_JavaLangString)
    {
      str2 = str1;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("HttpUrlProcessor", 4, "getNextUrl: url:" + str1);
      return str1;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        break label94;
      }
      str2 = str1;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("HttpUrlProcessor", 4, "getNextUrl: no proxy no host, so return null");
      return null;
      str2 = str1;
      str1 = "80";
      break label140;
    }
  }
  
  public void a()
  {
    this.jdField_b_of_type_JavaUtilIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    if (this.jdField_b_of_type_JavaUtilIterator.hasNext()) {
      this.jdField_a_of_type_MqqManagerProxyIpManager$ProxyIp = ((ProxyIpManager.ProxyIp)this.jdField_b_of_type_JavaUtilIterator.next());
    }
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.HttpUrlProcessor
 * JD-Core Version:    0.7.0.1
 */