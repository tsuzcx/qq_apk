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
    if (paramNetReq == null) {
      return null;
    }
    if ((paramNetReq.j == 0) && ((paramNetReq instanceof HttpNetReq)))
    {
      HttpNetReq localHttpNetReq = (HttpNetReq)paramNetReq;
      OldHttpEngine.OldHttpCommunicatorListner localOldHttpCommunicatorListner = (OldHttpEngine.OldHttpCommunicatorListner)localHttpNetReq.jdField_a_of_type_JavaLangObject;
      if ((localOldHttpCommunicatorListner == null) || (localOldHttpCommunicatorListner.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
        return null;
      }
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
      localHttpMsg.ae = paramNetReq.d;
      localHttpMsg.e = paramNetReq.n;
      localHttpMsg.jdField_d_of_type_Int = paramNetReq.m;
      localHttpMsg.jdField_d_of_type_Boolean = paramNetReq.jdField_b_of_type_Boolean;
      if (paramNetReq.l == 1) {
        localHttpMsg.b = 201;
      }
      for (;;)
      {
        if ((localHttpNetReq.jdField_a_of_type_JavaIoOutputStream != null) || (localHttpNetReq.jdField_b_of_type_JavaLangString != null)) {
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
          if (paramNetReq.l == 2) {
            localHttpMsg.b = 202;
          } else if (paramNetReq.l == 0) {
            localHttpMsg.b = 200;
          }
        }
        catch (Exception paramNetReq)
        {
          for (;;)
          {
            paramNetReq.printStackTrace();
          }
        }
      }
    }
    if (paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener != null)
    {
      paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.a(1, 9302, "not support by HttpOldEngine", null);
      paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener.a(paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileNetResp);
    }
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
        if (paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_d_of_type_Int == 2) {
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
    if (paramNetReq == null) {
      break label4;
    }
    label4:
    while (!OldHttpEngine.OldHttpCommunicatorListner.class.isInstance(paramNetReq.jdField_a_of_type_JavaLangObject)) {
      return;
    }
    Object localObject = (HttpNetReq)paramNetReq;
    int i = paramNetReq.n;
    boolean bool;
    if (((HttpNetReq)localObject).c == 1) {
      bool = true;
    }
    for (;;)
    {
      RichMediaUtil.a(i, bool, paramNetReq.m, paramNetReq.d, "cancelReq", "");
      localObject = (OldHttpEngine.OldHttpCommunicatorListner)paramNetReq.jdField_a_of_type_JavaLangObject;
      if (QLog.isColorLevel())
      {
        QLog.d("OldHttpEngine", 2, "cancelReq ====== listener = " + localObject);
        if (localObject != null) {
          QLog.d("OldHttpEngine", 2, "cancelReq ====== listener.mIsCancelled = " + ((OldHttpEngine.OldHttpCommunicatorListner)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
        }
      }
      if (localObject == null) {
        break;
      }
      ((OldHttpEngine.OldHttpCommunicatorListner)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      HttpMsg localHttpMsg = ((OldHttpEngine.OldHttpCommunicatorListner)localObject).jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
      if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator != null)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(localHttpMsg);
      }
      try
      {
        if ((paramNetReq.jdField_b_of_type_JavaLangString != null) && (((OldHttpEngine.OldHttpCommunicatorListner)localObject).jdField_a_of_type_JavaIoOutputStream != null)) {
          ((OldHttpEngine.OldHttpCommunicatorListner)localObject).jdField_a_of_type_JavaIoOutputStream.close();
        }
        ((OldHttpEngine.OldHttpCommunicatorListner)localObject).a();
        return;
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
    OldHttpEngine.OldHttpCommunicatorListner localOldHttpCommunicatorListner;
    do
    {
      try
      {
        HttpMsg localHttpMsg1 = a(paramNetReq);
        localOldHttpCommunicatorListner = (OldHttpEngine.OldHttpCommunicatorListner)paramNetReq.jdField_a_of_type_JavaLangObject;
        if ((localHttpMsg1 != null) && (localOldHttpCommunicatorListner != null))
        {
          NetResp localNetResp = paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
          localNetResp.g += 1;
          localOldHttpCommunicatorListner.b = 0;
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            a(localHttpMsg1);
            return;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        for (;;)
        {
          System.gc();
          try
          {
            HttpMsg localHttpMsg2 = a(paramNetReq);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.richmedia.OldHttpEngine", 2, "OOM in makeNewHttpMsgFromNetReq", localOutOfMemoryError2);
            }
            Object localObject = null;
          }
        }
        paramNetReq = paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
        paramNetReq.e = 9366;
        paramNetReq.jdField_a_of_type_JavaLangString = "oldengine close";
        paramNetReq.jdField_d_of_type_Int = 1;
        OldHttpEngine.OldHttpCommunicatorListner.a(localOldHttpCommunicatorListner);
        return;
      }
    } while ((localOldHttpCommunicatorListner == null) || (localOldHttpCommunicatorListner.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()));
    paramNetReq = paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
    paramNetReq.e = 9369;
    paramNetReq.jdField_a_of_type_JavaLangString = "Out of memory";
    paramNetReq.jdField_d_of_type_Int = 1;
    OldHttpEngine.OldHttpCommunicatorListner.a(localOldHttpCommunicatorListner);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.OldHttpEngine
 * JD-Core Version:    0.7.0.1
 */