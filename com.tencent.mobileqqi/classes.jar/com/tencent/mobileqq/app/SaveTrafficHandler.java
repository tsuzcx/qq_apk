package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fge;
import fgf;
import fgg;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import msf.statsvc.PbSaveTraffic;

public class SaveTrafficHandler
  extends BusinessHandler
{
  static final int jdField_a_of_type_Int = 1;
  static final long jdField_a_of_type_Long = 5000L;
  public static final String a = "StatSvc.InSaveTraffic";
  static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("dd HH:mm:ss");
  static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  static boolean jdField_a_of_type_Boolean = false;
  static final int jdField_b_of_type_Int = 2;
  static final long jdField_b_of_type_Long = 300000L;
  public static final String b = "StatSvc.OutSaveTraffic";
  static boolean jdField_b_of_type_Boolean = false;
  static final String c = "key_savetrafficseq";
  public static boolean c = false;
  static final String jdField_d_of_type_JavaLangString = "_attr_SaveTrafficMode";
  static final String e = "_attr_SaveTrafficSeq";
  static final String f = "_attr_max_retry_count";
  static final String g = "_attr_retry_index";
  private static final String h = "SaveTrafficHandler";
  public Handler a;
  public final ConcurrentHashMap a;
  boolean jdField_d_of_type_Boolean;
  
  static
  {
    b = false;
  }
  
  SaveTrafficHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidOsHandler = new fge(this, Looper.getMainLooper());
    this.d = false;
  }
  
  private void a(int paramInt)
  {
    fgg localfgg = (fgg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
    if (localfgg != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(localfgg);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = ((Integer)paramToServiceMsg.getAttribute("_attr_SaveTrafficSeq")).intValue();
    QLog.w("SaveTrafficHandler", 2, "<---handleTimeout seq " + i + " req:" + paramToServiceMsg + " resp:" + paramFromServiceMsg);
    a(i);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = ((Integer)paramToServiceMsg.getAttribute("_attr_SaveTrafficSeq")).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("SaveTrafficHandler", 2, "<---handleTimeout seq:" + i);
    }
    int j;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(i)))
    {
      boolean bool = ((Boolean)paramToServiceMsg.getAttribute("_attr_SaveTrafficMode")).booleanValue();
      j = ((Integer)paramToServiceMsg.getAttribute("_attr_max_retry_count")).intValue();
      int k = ((Integer)paramToServiceMsg.getAttribute("_attr_retry_index")).intValue();
      if (k < j) {
        a(i, bool, k + 1);
      }
    }
    else
    {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SaveTrafficHandler", 2, "<---handleTimeout seq:" + i + " has reached max count:" + j);
    }
    a(i);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ((Integer)paramToServiceMsg.getAttribute("_attr_SaveTrafficSeq")).intValue();
    boolean bool = ((Boolean)paramToServiceMsg.getAttribute("_attr_SaveTrafficMode")).booleanValue();
    paramToServiceMsg = new PbSaveTraffic();
    try
    {
      paramToServiceMsg = (PbSaveTraffic)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg != null) && (paramToServiceMsg.seq.has()))
      {
        int j = paramToServiceMsg.seq.get();
        if (i != j) {
          QLog.w("SaveTrafficHandler", 2, "<---handleSaveTrafficRes mode:" + bool + " seq not equal: send req:" + i + " recv req:" + j);
        }
        c = bool;
        a(i);
        if (!bool) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(3, false);
        }
      }
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SaveTrafficHandler", 2, "<---handleSaveTrafficRes: exception occurs while parsing the pb bytes.", paramToServiceMsg);
        }
        paramToServiceMsg = null;
      }
    }
  }
  
  public int a()
  {
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
  }
  
  protected Class a()
  {
    return SaveTrafficObserver.class;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SaveTrafficHandler", 2, "enter disable...");
    }
    this.d = false;
    jdField_a_of_type_Boolean = false;
    b = false;
    c = false;
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.d)
    {
      localObject = (fgg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
      if (localObject != null) {
        break label78;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SaveTrafficHandler", 2, "--->sendSaveTrafficReq cannot find in queue, return. seq:" + paramInt1 + " mode:" + paramBoolean + " retryIndex:" + paramInt2);
      }
    }
    return;
    label78:
    if (paramInt2 == 0)
    {
      new fgf(this, "SaveTrafficPrefThread", paramInt1).start();
      ((fgg)localObject).b = true;
    }
    int i;
    if (paramBoolean)
    {
      i = 1;
      if (QLog.isColorLevel()) {
        QLog.d("SaveTrafficHandler", 2, "--->sendSaveTrafficReq seq:" + paramInt1 + " mode:" + paramBoolean + " retryIndex:" + paramInt2);
      }
      if (!paramBoolean) {
        break label275;
      }
    }
    label275:
    for (Object localObject = "StatSvc.InSaveTraffic";; localObject = "StatSvc.OutSaveTraffic")
    {
      localObject = a((String)localObject);
      ((ToServiceMsg)localObject).addAttribute("_attr_SaveTrafficSeq", Integer.valueOf(paramInt1));
      ((ToServiceMsg)localObject).addAttribute("_attr_SaveTrafficMode", Boolean.valueOf(paramBoolean));
      ((ToServiceMsg)localObject).addAttribute("_attr_max_retry_count", Integer.valueOf(i));
      ((ToServiceMsg)localObject).addAttribute("_attr_retry_index", Integer.valueOf(paramInt2));
      PbSaveTraffic localPbSaveTraffic = new PbSaveTraffic();
      localPbSaveTraffic.seq.set(paramInt1);
      ((ToServiceMsg)localObject).putWupBuffer(localPbSaveTraffic.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(150000L);
      b((ToServiceMsg)localObject);
      return;
      i = 10000;
      break;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg == null) {}
    do
    {
      int i;
      do
      {
        String str;
        do
        {
          return;
          str = paramToServiceMsg.getServiceCmd();
        } while ((str == null) || (str.length() == 0) || ((!"StatSvc.InSaveTraffic".equalsIgnoreCase(str)) && (!"StatSvc.OutSaveTraffic".equalsIgnoreCase(str))));
        i = ((Integer)paramToServiceMsg.getAttribute("_attr_SaveTrafficSeq")).intValue();
        if (QLog.isColorLevel()) {
          QLog.d("SaveTrafficHandler", 2, "<---SaveTrafficHandler onReceive seq " + i + " req:" + paramToServiceMsg + " resp:" + paramFromServiceMsg + " " + paramObject);
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(i))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SaveTrafficHandler", 2, "<---SaveTrafficHandler onReceive unexpected seq " + i);
      return;
      if (!paramFromServiceMsg.isSuccess()) {
        break;
      }
      try
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("SaveTrafficHandler", 2, "handleSaveTrafficRes exception ! ", paramToServiceMsg);
    return;
    if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))
    {
      b(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.d)
    {
      jdField_a_of_type_Boolean = b;
      b = paramBoolean;
      if (!b) {
        break label48;
      }
      if (!jdField_a_of_type_Boolean)
      {
        localMessage = Message.obtain();
        localMessage.what = 1;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      }
    }
    label48:
    while (!jdField_a_of_type_Boolean) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void b()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("SaveTrafficHandler", 2, "enter enable...");
    }
    this.d = true;
    jdField_a_of_type_Boolean = false;
    b = false;
    c = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getInt("key_savetrafficseq", 0);
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(i);
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (QLog.isColorLevel()) {
          QLog.d("SaveTrafficHandler", 2, "init, remove not started seq:" + localEntry.getKey());
        }
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks((Runnable)localEntry.getValue());
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SaveTrafficHandler
 * JD-Core Version:    0.7.0.1
 */