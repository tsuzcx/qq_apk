package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class OldHttpEngine
  implements INetEngine
{
  public static final String a = "Q.richmedia.OldHttpEngine";
  HttpCommunicator jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  boolean jdField_a_of_type_Boolean;
  
  public OldHttpEngine(HttpCommunicator paramHttpCommunicator, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.OldHttpEngine", 2, "construct " + this);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator = paramHttpCommunicator;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private HttpMsg a(NetReq paramNetReq)
  {
    if (paramNetReq == null) {}
    do
    {
      return null;
      if ((paramNetReq.j == 0) && ((paramNetReq instanceof HttpNetReq)))
      {
        HttpNetReq localHttpNetReq = (HttpNetReq)paramNetReq;
        OldHttpEngine.OldHttpCommunicatorListner localOldHttpCommunicatorListner = (OldHttpEngine.OldHttpCommunicatorListner)localHttpNetReq.jdField_a_of_type_JavaLangObject;
        HttpMsg localHttpMsg = new HttpMsg(localHttpNetReq.jdField_a_of_type_JavaLangString, localHttpNetReq.jdField_a_of_type_ArrayOfByte, localOldHttpCommunicatorListner);
        if (localHttpNetReq.c == 0) {}
        for (Object localObject = "GET";; localObject = "POST")
        {
          localHttpMsg.c((String)localObject);
          localObject = localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
            localHttpMsg.a((String)localEntry.getKey(), (String)localEntry.getValue());
          }
        }
        localHttpMsg.ad = paramNetReq.c;
        localHttpMsg.e = paramNetReq.o;
        localHttpMsg.d = paramNetReq.n;
        if (paramNetReq.m == 1) {
          localHttpMsg.b = 201;
        }
        for (;;)
        {
          if ((localHttpNetReq.jdField_a_of_type_JavaIoOutputStream != null) || (localHttpNetReq.b != null)) {
            localHttpMsg.a(true);
          }
          localOldHttpCommunicatorListner.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = localHttpMsg;
          try
          {
            paramNetReq = new URL(localHttpMsg.a());
            localObject = localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
            ((NetResp)localObject).jdField_a_of_type_JavaUtilHashMap.put("serverip", paramNetReq.getHost());
            ((NetResp)localObject).jdField_a_of_type_JavaUtilHashMap.put("param_url", localHttpMsg.a());
            return localHttpMsg;
          }
          catch (Exception paramNetReq)
          {
            paramNetReq.printStackTrace();
            return localHttpMsg;
          }
          if (paramNetReq.m == 2) {
            localHttpMsg.b = 202;
          } else if (paramNetReq.m == 0) {
            localHttpMsg.b = 200;
          }
        }
      }
    } while (paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener == null);
    paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.a(1, 9302L, "not support by HttpOldEngine", null);
    paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener.a(paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileNetResp);
    return null;
  }
  
  public static boolean a(int paramInt)
  {
    return RichMediaStrategy.a(paramInt);
  }
  
  public NetResp a(NetReq paramNetReq)
  {
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.OldHttpEngine", 2, "destroy " + this);
      }
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator != null)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator = null;
    }
  }
  
  public void a(NetReq paramNetReq)
  {
    if ((paramNetReq != null) && (paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener != null)) {
      if ((paramNetReq.j == 0) && ((paramNetReq instanceof HttpNetReq)))
      {
        localObject = (HttpNetReq)paramNetReq;
        ((HttpNetReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileNetResp = new NetResp((NetReq)localObject);
        localOldHttpCommunicatorListner = new OldHttpEngine.OldHttpCommunicatorListner(this);
        ((HttpNetReq)localObject).jdField_a_of_type_JavaLangObject = localOldHttpCommunicatorListner;
        localOldHttpCommunicatorListner.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = ((HttpNetReq)localObject);
        localOldHttpCommunicatorListner.jdField_a_of_type_ComTencentMobileqqTransfileNetResp = ((HttpNetReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
        localOldHttpCommunicatorListner.b();
        if (paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.d == 2) {
          break label89;
        }
        OldHttpEngine.OldHttpCommunicatorListner.a(localOldHttpCommunicatorListner);
      }
    }
    label89:
    while (!QLog.isColorLevel())
    {
      OldHttpEngine.OldHttpCommunicatorListner localOldHttpCommunicatorListner;
      return;
      c(paramNetReq);
      return;
    }
    Object localObject = new StringBuilder().append("req:").append(paramNetReq).append(" callback:");
    if (paramNetReq == null) {}
    for (paramNetReq = null;; paramNetReq = paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener)
    {
      QLog.e("Q.richmedia.OldHttpEngine", 2, paramNetReq);
      return;
    }
  }
  
  public void a(HttpMsg paramHttpMsg)
  {
    if ((paramHttpMsg != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator != null)) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(paramHttpMsg);
    }
  }
  
  public void b(NetReq paramNetReq)
  {
    Object localObject;
    int i;
    boolean bool;
    if ((paramNetReq != null) && (paramNetReq.jdField_a_of_type_JavaLangObject != null) && ((paramNetReq.jdField_a_of_type_JavaLangObject instanceof OldHttpEngine.OldHttpCommunicatorListner)))
    {
      localObject = (HttpNetReq)paramNetReq;
      i = paramNetReq.o;
      if (((HttpNetReq)localObject).c != 1) {
        break label140;
      }
      bool = true;
    }
    for (;;)
    {
      RichMediaUtil.a(i, bool, paramNetReq.n, paramNetReq.c, "cancelReq", "");
      localObject = (OldHttpEngine.OldHttpCommunicatorListner)paramNetReq.jdField_a_of_type_JavaLangObject;
      ((OldHttpEngine.OldHttpCommunicatorListner)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      HttpMsg localHttpMsg = ((OldHttpEngine.OldHttpCommunicatorListner)localObject).jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
      if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator != null)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(localHttpMsg);
      }
      try
      {
        if ((paramNetReq.b != null) && (((OldHttpEngine.OldHttpCommunicatorListner)localObject).jdField_a_of_type_JavaIoOutputStream != null)) {
          ((OldHttpEngine.OldHttpCommunicatorListner)localObject).jdField_a_of_type_JavaIoOutputStream.close();
        }
        ((OldHttpEngine.OldHttpCommunicatorListner)localObject).a();
        return;
        label140:
        bool = false;
      }
      catch (IOException paramNetReq)
      {
        for (;;)
        {
          paramNetReq.printStackTrace();
        }
      }
    }
  }
  
  public void c(NetReq paramNetReq)
  {
    HttpMsg localHttpMsg = a(paramNetReq);
    Object localObject;
    if (localHttpMsg != null)
    {
      localObject = paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
      ((NetResp)localObject).i += 1;
      localObject = (OldHttpEngine.OldHttpCommunicatorListner)paramNetReq.jdField_a_of_type_JavaLangObject;
      ((OldHttpEngine.OldHttpCommunicatorListner)localObject).b = 0;
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        a(localHttpMsg);
      }
    }
    else
    {
      return;
    }
    paramNetReq = paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
    paramNetReq.jdField_a_of_type_Long = 9366L;
    paramNetReq.jdField_a_of_type_JavaLangString = "oldengine close";
    paramNetReq.d = 1;
    OldHttpEngine.OldHttpCommunicatorListner.a((OldHttpEngine.OldHttpCommunicatorListner)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.OldHttpEngine
 * JD-Core Version:    0.7.0.1
 */