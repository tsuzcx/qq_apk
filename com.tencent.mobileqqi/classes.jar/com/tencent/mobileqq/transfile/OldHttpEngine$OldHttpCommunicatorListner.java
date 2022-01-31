package com.tencent.mobileqq.transfile;

import android.os.Environment;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import gnq;
import gnr;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;

public class OldHttpEngine$OldHttpCommunicatorListner
  implements IHttpCommunicatorListener
{
  int jdField_a_of_type_Int = 0;
  public HttpNetReq a;
  public NetResp a;
  public HttpMsg a;
  public OutputStream a;
  String jdField_a_of_type_JavaLangString = null;
  public AtomicBoolean a;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  boolean jdField_b_of_type_Boolean = false;
  int c;
  int d;
  
  public OldHttpEngine$OldHttpCommunicatorListner(OldHttpEngine paramOldHttpEngine)
  {
    this.jdField_c_of_type_Int = 5;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_d_of_type_Long = System.currentTimeMillis();
    NetworkCenter.a().a();
    if (NetworkCenter.a().a() != 0) {
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileOldHttpEngine.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (paramLong != 0L)) {
        ThreadManager.a().schedule(new gnq(this), paramLong);
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      this.jdField_a_of_type_ComTencentMobileqqTransfileOldHttpEngine.c(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileOldHttpEngine.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        ThreadManager.a().schedule(new gnr(this), paramLong);
        return;
      }
    } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
  }
  
  private void c()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_b_of_type_JavaLangString != null) {}
    try
    {
      if (this.jdField_a_of_type_JavaIoOutputStream != null) {
        this.jdField_a_of_type_JavaIoOutputStream.close();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener != null)
      {
        if (QLog.isColorLevel())
        {
          int i = this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.o;
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_c_of_type_Int == 1) {
            RichMediaUtil.a(i, bool, this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.n, this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_c_of_type_JavaLangString, "onOutEngine", "result:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_d_of_type_Int + " errCode:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_Long + " desc:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_JavaLangString);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener.a(this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp);
        }
      }
      else
      {
        a();
        return;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
        continue;
        bool = false;
      }
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = (paramString1 + "." + MD5.toMD5(paramString2) + ".tmp");
    return this.jdField_a_of_type_JavaLangString;
  }
  
  void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    HttpNetReq localHttpNetReq = this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
    if (localHttpNetReq != null) {
      localHttpNetReq.jdField_a_of_type_JavaLangObject = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = null;
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp = null;
    this.jdField_a_of_type_JavaIoOutputStream = null;
  }
  
  public void a(HttpMsg paramHttpMsg) {}
  
  public void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Int = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq != null) {
        try
        {
          if ((paramHttpMsg2.c() == 206) || (paramHttpMsg2.c() == 200))
          {
            paramHttpMsg1 = paramHttpMsg2.a();
            this.jdField_b_of_type_Int += paramHttpMsg1.length;
            if (this.jdField_a_of_type_JavaIoOutputStream != null)
            {
              this.jdField_a_of_type_JavaIoOutputStream.write(paramHttpMsg1);
              this.jdField_a_of_type_JavaIoOutputStream.flush();
              this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.f = ((int)paramHttpMsg2.a());
              this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.g = ((int)paramHttpMsg2.jdField_b_of_type_Long);
              paramHttpMsg2 = this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
              int i = paramHttpMsg2.h;
              paramHttpMsg2.h = (paramHttpMsg1.length + i);
              if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener == null) {
                continue;
              }
              this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener.a(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq, this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.h + this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.k, this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.f);
            }
          }
        }
        catch (IOException paramHttpMsg1)
        {
          paramHttpMsg1.printStackTrace();
          this.jdField_a_of_type_Boolean = true;
          a(paramHttpMsg1, this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp);
          throw new RuntimeException("io exceptionmsg:" + paramHttpMsg1.getMessage());
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.f = ((int)paramHttpMsg2.a());
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.g = ((int)paramHttpMsg2.jdField_b_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_ArrayOfByte = paramHttpMsg2.a();
  }
  
  void a(IOException paramIOException, NetResp paramNetResp)
  {
    paramNetResp = paramIOException.getMessage();
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.a(1, 9301L, paramNetResp + Log.getStackTraceString(paramIOException), null);
    paramIOException = Environment.getExternalStorageState();
    if (paramNetResp.contains("EACCES")) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_Long = 9039L;
    }
    do
    {
      return;
      if ((paramNetResp.contains("ENOSPC")) || (paramNetResp.contains("space")))
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_Long = 9040L;
        return;
      }
      if (paramNetResp.contains("Read-only"))
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_Long = 9039L;
        return;
      }
    } while ("mounted".equals(paramIOException));
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_Long = 9039L;
  }
  
  public void a(String paramString) {}
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return true;
    }
    if (paramInt == 5)
    {
      b(paramHttpMsg2);
      if (!this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.a()) {
        break label446;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.h != this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.g) {
        break label257;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_d_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_JavaLangString = "";
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_b_of_type_JavaLangString == null) {}
    }
    label257:
    label440:
    label446:
    do
    {
      try
      {
        if (FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_b_of_type_JavaLangString)) {
          FileUtils.d(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_b_of_type_JavaLangString);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_b_of_type_JavaLangString == null) {}
      }
      catch (Exception paramHttpMsg2)
      {
        try
        {
          if (this.jdField_a_of_type_JavaIoOutputStream != null) {
            this.jdField_a_of_type_JavaIoOutputStream.close();
          }
          if (!FileUtils.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_b_of_type_JavaLangString))
          {
            if (FileUtils.c(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_b_of_type_JavaLangString)) {
              new File(this.jdField_a_of_type_JavaLangString).delete();
            }
          }
          else
          {
            if (paramHttpMsg1.jdField_e_of_type_Long != 0L) {
              this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_e_of_type_Long = paramHttpMsg1.jdField_e_of_type_Long;
            }
            c();
            return true;
            paramHttpMsg2 = paramHttpMsg2;
            paramHttpMsg2.printStackTrace();
          }
        }
        catch (IOException paramHttpMsg2)
        {
          for (;;)
          {
            paramHttpMsg2.printStackTrace();
            continue;
            this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.a(1, 9301L, "rename file failed", null);
            new File(this.jdField_a_of_type_JavaLangString).delete();
          }
        }
      }
      if (QLog.isColorLevel())
      {
        paramInt = this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.o;
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_c_of_type_Int != 1) {
          break label440;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        RichMediaUtil.a(paramInt, bool, this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.n, this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_c_of_type_JavaLangString, "check", "writtenSize:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.h + " totalBlockLen:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.g);
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.a(1, -9527L, null, null);
        paramHttpMsg2 = BaseTransProcessor.a("Q", -9533L);
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_JavaUtilHashMap.put("netresp_param_reason", paramHttpMsg2);
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_JavaLangString = ("recvSize:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.h + " totalBlockLen:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.g);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_d_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_JavaLangString = "";
    } while (((this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_ArrayOfByte.length == this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.g)) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_ArrayOfByte != null) || (this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.g == 0)));
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.a(1, -9527L, null, null);
    paramHttpMsg2 = BaseTransProcessor.a("Q", -9533L);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_JavaUtilHashMap.put("netresp_param_reason", paramHttpMsg2);
    paramHttpMsg2 = this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
    StringBuilder localStringBuilder = new StringBuilder().append("recvSize:");
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_ArrayOfByte != null) {}
    for (paramInt = this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_ArrayOfByte.length;; paramInt = 0)
    {
      paramHttpMsg2.jdField_a_of_type_JavaLangString = (paramInt + " totalBlockLen:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.g);
      break;
    }
  }
  
  public void b()
  {
    this.jdField_d_of_type_Int = NetworkCenter.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_b_of_type_JavaLangString != null) {}
    for (;;)
    {
      int i;
      try
      {
        this.jdField_a_of_type_JavaLangString = a(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_JavaLangString);
        localObject = new File(this.jdField_a_of_type_JavaLangString);
        if (((File)localObject).exists())
        {
          i = (int)((File)localObject).length();
          if ((i > 0) && (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix != null))
          {
            this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.h = i;
            this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix.a(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq, this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp);
            this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream((File)localObject, true);
            if (QLog.isColorLevel()) {
              QLog.d("Q.richmedia.OldHttpEngine", 2, "append.oring Len:" + i);
            }
          }
        }
      }
      catch (IOException localIOException)
      {
        Object localObject;
        localIOException.printStackTrace();
        this.jdField_b_of_type_Boolean = true;
        a(localIOException, this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp);
        continue;
      }
      try
      {
        localObject = new URL(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_JavaLangString).getHost();
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_JavaUtilHashMap.put("firstserverip", localObject);
        return;
      }
      catch (Exception localException)
      {
        boolean bool;
        label344:
        localException.printStackTrace();
      }
      this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream((File)localObject);
      if (QLog.isColorLevel())
      {
        QLog.d("Q.richmedia.OldHttpEngine", 2, "oring Len:" + i + " trunk");
        continue;
        if (QLog.isColorLevel())
        {
          i = this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.o;
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_c_of_type_Int != 1) {
            break label344;
          }
        }
        for (bool = true;; bool = false)
        {
          RichMediaUtil.a(i, bool, this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.n, this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_c_of_type_JavaLangString, "createtmp", this.jdField_a_of_type_JavaLangString);
          FileUtils.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_a_of_type_JavaLangString);
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_JavaIoOutputStream != null) {
          this.jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_JavaIoOutputStream;
        }
      }
    }
  }
  
  void b(HttpMsg paramHttpMsg)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap2.containsKey("firstserverip")) {
      localHashMap1.put("firstserverip", localHashMap2.get("firstserverip"));
    }
    if (localHashMap2.containsKey("serverip")) {
      localHashMap1.put("serverip", localHashMap2.get("serverip"));
    }
    if (localHashMap2.containsKey("param_url")) {
      localHashMap1.put("param_url", localHashMap2.get("param_url"));
    }
    if (paramHttpMsg.jdField_b_of_type_JavaUtilHashMap.containsKey(HttpMsg.ah)) {
      localHashMap1.put("netresp_param_reason", paramHttpMsg.jdField_b_of_type_JavaUtilHashMap.get(HttpMsg.ah));
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_JavaUtilHashMap.putAll(localHashMap1);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_JavaUtilHashMap.putAll(paramHttpMsg.jdField_b_of_type_JavaUtilHashMap);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_JavaUtilHashMap.put("param_rspHeader", paramHttpMsg.ag);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_JavaUtilHashMap.put("param_reqHeader", paramHttpMsg.af);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_e_of_type_Int = paramHttpMsg.c();
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    HttpNetReq localHttpNetReq;
    NetResp localNetResp;
    do
    {
      return;
      localHttpNetReq = this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
      localNetResp = this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
    } while ((localHttpNetReq == null) || (localNetResp == null));
    b(paramHttpMsg2);
    long l1 = System.currentTimeMillis() - localNetResp.jdField_d_of_type_Long;
    localNetResp.jdField_b_of_type_Long += l1;
    if ((localHttpNetReq.jdField_a_of_type_JavaUtilList != null) && (localHttpNetReq.jdField_a_of_type_JavaUtilList.size() >= 1)) {
      ((ServerAddr)localHttpNetReq.jdField_a_of_type_JavaUtilList.get(0)).b();
    }
    long l2 = NetworkCenter.a().a();
    int j;
    int i;
    label157:
    label246:
    int k;
    label270:
    boolean bool1;
    label315:
    label379:
    boolean bool2;
    if (l2 != 0L)
    {
      j = 1;
      if ((localNetResp.jdField_a_of_type_Long != 9056L) || (l1 >= 2000L)) {
        break label625;
      }
      i = this.jdField_c_of_type_Int;
      this.jdField_c_of_type_Int = (i - 1);
      if (i <= 0) {
        break label625;
      }
      if (this.jdField_a_of_type_Boolean) {
        break label643;
      }
      localNetResp.jdField_a_of_type_Long = paramHttpMsg2.h;
      localNetResp.jdField_a_of_type_JavaLangString = paramHttpMsg2.ae;
      localNetResp.jdField_d_of_type_Int = 1;
      if (j == 0)
      {
        localNetResp.jdField_a_of_type_Long = 9004L;
        localNetResp.jdField_a_of_type_JavaLangString = "no network";
        localNetResp.jdField_d_of_type_Int = 1;
      }
      if ((l2 == this.jdField_d_of_type_Int) || (l2 == 0L) || (this.jdField_d_of_type_Int == 0L)) {
        break label648;
      }
      i = 1;
      if ((!localHttpNetReq.jdField_a_of_type_Boolean) || (i == 0) || (!RichMediaStrategy.a(paramHttpMsg2.h))) {
        break label653;
      }
      i = 1;
      if (i != 0)
      {
        localNetResp.jdField_a_of_type_Long = 9364L;
        localNetResp.jdField_a_of_type_JavaLangString = "netchg";
        if (QLog.isColorLevel())
        {
          k = localHttpNetReq.o;
          if (localHttpNetReq.jdField_c_of_type_Int != 1) {
            break label658;
          }
          bool1 = true;
          RichMediaUtil.a(k, bool1, localHttpNetReq.n, localHttpNetReq.jdField_c_of_type_JavaLangString, "netChg", "originNet:" + this.jdField_d_of_type_Int + " cur:" + l2);
        }
      }
      if (this.jdField_b_of_type_Int <= 0) {
        break label664;
      }
      bool1 = true;
      if ((this.jdField_a_of_type_Boolean) || (i != 0) || (!paramHttpMsg2.d()) || (((localNetResp.jdField_b_of_type_Long >= localHttpNetReq.jdField_b_of_type_Long - 5000L) || (this.jdField_a_of_type_Int > localHttpNetReq.l)) && ((!bool1) || (localNetResp.jdField_b_of_type_Long >= localHttpNetReq.jdField_b_of_type_Long * 3L / 2L - 5000L)))) {
        break label993;
      }
      if (QLog.isColorLevel())
      {
        i = localHttpNetReq.o;
        if (localHttpNetReq.jdField_c_of_type_Int != 1) {
          break label670;
        }
        bool2 = true;
        label482:
        RichMediaUtil.a(i, bool2, localHttpNetReq.n, localHttpNetReq.jdField_c_of_type_JavaLangString, "retry", "tryTime:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.i + " consumeTime:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_b_of_type_Long + " isLastGetData:" + bool1);
      }
      k = 1;
      i = k;
      if (localNetResp.h > 0)
      {
        if (!localHttpNetReq.c()) {
          break label681;
        }
        if (localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix == null) {
          break label676;
        }
        localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix.a(localHttpNetReq, localNetResp);
        this.jdField_a_of_type_JavaIoOutputStream = localHttpNetReq.jdField_a_of_type_JavaIoOutputStream;
        i = k;
      }
    }
    for (;;)
    {
      if (i != 0) {
        break label767;
      }
      c();
      return;
      j = 0;
      break;
      label625:
      if (j == 0) {
        break label157;
      }
      this.jdField_a_of_type_Int += 1;
      break label157;
      label643:
      c();
      return;
      label648:
      i = 0;
      break label246;
      label653:
      i = 0;
      break label270;
      label658:
      bool1 = false;
      break label315;
      label664:
      bool1 = false;
      break label379;
      label670:
      bool2 = false;
      break label482;
      label676:
      i = 0;
      continue;
      label681:
      i = k;
      if (localHttpNetReq.b()) {
        if (localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix != null)
        {
          localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix.a(localHttpNetReq, localNetResp);
          i = k;
        }
        else if (this.jdField_a_of_type_JavaIoOutputStream != null)
        {
          try
          {
            this.jdField_a_of_type_JavaIoOutputStream.close();
            this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_a_of_type_JavaLangString);
            i = 1;
          }
          catch (IOException paramHttpMsg1)
          {
            a(paramHttpMsg1, localNetResp);
          }
        }
        else
        {
          i = 0;
        }
      }
    }
    label767:
    if ((localHttpNetReq.jdField_a_of_type_JavaUtilList != null) && (localHttpNetReq.jdField_a_of_type_JavaUtilList.size() > 1) && (j != 0))
    {
      paramHttpMsg1 = (ServerAddr)localHttpNetReq.jdField_a_of_type_JavaUtilList.remove(0);
      localHttpNetReq.jdField_a_of_type_JavaUtilList.add(paramHttpMsg1);
      paramHttpMsg1 = (ServerAddr)localHttpNetReq.jdField_a_of_type_JavaUtilList.get(0);
      paramHttpMsg2 = "http://" + paramHttpMsg1.jdField_a_of_type_JavaLangString;
      if (paramHttpMsg1.jdField_b_of_type_Int != 80)
      {
        paramHttpMsg1 = paramHttpMsg2 + ":" + paramHttpMsg1.jdField_b_of_type_Int + "/";
        localHttpNetReq.jdField_a_of_type_JavaLangString = RichMediaUtil.a(localHttpNetReq.jdField_a_of_type_JavaLangString, paramHttpMsg1);
      }
    }
    else
    {
      if ((localNetResp.jdField_a_of_type_Long != 9056L) || (l2 == 0L)) {
        break label970;
      }
      l1 = 0L;
    }
    for (;;)
    {
      a(l1);
      return;
      paramHttpMsg1 = paramHttpMsg2 + "/";
      break;
      label970:
      if (l2 != 0L) {
        l1 = 3000L;
      } else {
        l1 = 6000L;
      }
    }
    label993:
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.OldHttpEngine.OldHttpCommunicatorListner
 * JD-Core Version:    0.7.0.1
 */