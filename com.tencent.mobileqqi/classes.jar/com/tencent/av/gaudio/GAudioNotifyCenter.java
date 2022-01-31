package com.tencent.av.gaudio;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import bhl;
import bhm;
import bhn;
import bho;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Observable;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class GAudioNotifyCenter
  extends Observable
{
  protected static final String a = "GAudioNotifyCenter";
  public static final int c = 10002;
  public static final int d = 10003;
  public static final int e = 10004;
  public static final int f = 10005;
  public static final int g = 10006;
  public static final int h = 10007;
  public static final int i = 10008;
  public static final int j = 10009;
  public static final int k = 10010;
  public int a;
  public long a;
  public Handler a;
  public PhoneStatusMonitor a;
  public QQAppInterface a;
  Runnable jdField_a_of_type_JavaLangRunnable;
  ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  public long b;
  String jdField_b_of_type_JavaLangString = null;
  boolean jdField_b_of_type_Boolean = false;
  public String c;
  boolean c;
  String d;
  public boolean d;
  public boolean e = true;
  
  public GAudioNotifyCenter(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_b_of_type_Long = 0L;
    if (paramQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      this.jdField_b_of_type_JavaLangString = paramQQAppInterface.a();
      paramQQAppInterface = Looper.getMainLooper();
      if (Thread.currentThread() == paramQQAppInterface.getThread()) {
        break label160;
      }
    }
    label160:
    for (this.jdField_a_of_type_AndroidOsHandler = new bhm(this, paramQQAppInterface);; this.jdField_a_of_type_AndroidOsHandler = new bhm(this))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new bhl(this));
      return;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.jdField_a_of_type_Boolean)
    {
      l1 = l2;
      if (this.jdField_a_of_type_Long != 0L) {
        l1 = this.jdField_a_of_type_Long;
      }
    }
    return l1;
  }
  
  public long a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
      return ((bhn)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong))).jdField_a_of_type_Long;
    }
    return 0L;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioNotifyCenter", 2, "clearMultiRoomInfos");
    }
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    try
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2 });
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    try
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_d_of_type_JavaLangString = paramString2;
  }
  
  public void a(long paramLong)
  {
    long l;
    int m;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue();
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
        break label142;
      }
      localObject1 = (bhn)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      localObject2 = ((bhn)localObject1).jdField_a_of_type_JavaUtilVector;
      if ((localObject2 == null) || (((Vector)localObject2).size() <= 0)) {
        break label113;
      }
      int n = ((Vector)localObject2).size();
      m = 0;
      if (m >= n) {
        break label113;
      }
      if (l != ((Long)((Vector)localObject2).elementAt(m)).longValue()) {
        break label106;
      }
    }
    label106:
    label113:
    while (localObject2 == null)
    {
      return;
      m += 1;
      break;
    }
    ((Vector)localObject2).add(Long.valueOf(l));
    ((bhn)localObject1).jdField_a_of_type_Long += 1L;
    return;
    label142:
    Object localObject1 = new Vector();
    ((Vector)localObject1).add(Long.valueOf(l));
    Object localObject2 = new bhn(this);
    ((bhn)localObject2).jdField_a_of_type_Long = 1L;
    ((bhn)localObject2).jdField_a_of_type_JavaUtilVector = ((Vector)localObject1);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), localObject2);
  }
  
  public void a(long paramLong, long[] paramArrayOfLong)
  {
    int m = 0;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
    }
    Vector localVector = new Vector();
    int i1 = paramArrayOfLong.length;
    int n = 0;
    while (m < i1)
    {
      localVector.add(Long.valueOf(paramArrayOfLong[m]));
      n += 1;
      m += 1;
    }
    paramArrayOfLong = new bhn(this);
    paramArrayOfLong.jdField_a_of_type_Long = n;
    paramArrayOfLong.jdField_a_of_type_JavaUtilVector = localVector;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), paramArrayOfLong);
  }
  
  public void a(long paramLong1, long[] paramArrayOfLong, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("shanezhai", 2, "setMultiRoomMember :" + paramLong1 + "Num:" + paramLong2);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong1));
    }
    if ((paramLong2 == 0L) || (paramArrayOfLong == null)) {
      return;
    }
    Vector localVector = new Vector();
    int n = paramArrayOfLong.length;
    int m = 0;
    while (m < n)
    {
      localVector.add(Long.valueOf(paramArrayOfLong[m]));
      m += 1;
    }
    paramArrayOfLong = new bhn(this);
    paramArrayOfLong.jdField_a_of_type_Long = paramLong2;
    paramArrayOfLong.jdField_a_of_type_JavaUtilVector = localVector;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), paramArrayOfLong);
  }
  
  public void a(Long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("shanezhai", 2, "setChating discussId is:" + paramLong + "isChatting" + paramBoolean);
    }
    this.jdField_a_of_type_Long = paramLong.longValue();
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (!paramBoolean)
    {
      this.jdField_b_of_type_Long = 0L;
      if ((this.jdField_a_of_type_JavaLangRunnable != null) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor != null) {
      return this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor.a();
    }
    return false;
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_Long == paramLong) {
      return this.jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long b(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong)))
    {
      Vector localVector = ((bhn)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong))).jdField_a_of_type_JavaUtilVector;
      if ((localVector != null) && (localVector.size() > 0)) {
        return ((Long)localVector.get(0)).longValue();
      }
    }
    return 0L;
  }
  
  public String b()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void b(long paramLong)
  {
    int m = 0;
    long l;
    Vector localVector;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      l = Long.valueOf(str).longValue();
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong)))
      {
        Object localObject = (bhn)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
        localVector = ((bhn)localObject).jdField_a_of_type_JavaUtilVector;
        ((bhn)localObject).jdField_a_of_type_Long -= 1L;
        if (QLog.isColorLevel()) {
          QLog.d("shanezhai", 2, "onSelfLeaveRoom");
        }
        if (((bhn)localObject).jdField_a_of_type_Long != 0L) {
          break label140;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
        localObject = Long.toString(paramLong);
        VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3000, 14, false, (String)localObject, str, false, null, false);
      }
    }
    for (;;)
    {
      return;
      label140:
      if ((localVector != null) && (localVector.size() > 0))
      {
        int n = localVector.size();
        while (m < n)
        {
          if (l == ((Long)localVector.elementAt(m)).longValue())
          {
            localVector.remove(m);
            return;
          }
          m += 1;
        }
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_Long = 0L;
      }
      if (this.jdField_a_of_type_JavaLangRunnable == null) {
        this.jdField_a_of_type_JavaLangRunnable = new bho(this);
      }
    }
    while ((this.jdField_a_of_type_JavaLangRunnable == null) || (this.jdField_a_of_type_AndroidOsHandler == null)) {
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidOsHandler != null) {
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
        }
        return;
        if (this.jdField_a_of_type_AndroidOsHandler != null) {
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        }
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public String c()
  {
    return UITools.a(this.jdField_b_of_type_Long);
  }
  
  public void c(boolean paramBoolean)
  {
    if ((this.jdField_c_of_type_Boolean != paramBoolean) && (!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        long l = ((Long)localIterator.next()).longValue();
        a(l, null, 0L);
        a(21, l, 0L);
        localIterator.remove();
      }
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    int m = Build.VERSION.SDK_INT;
    if ((m < 9) || (!VcSystemInfo.b()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GAudioNotifyCenter", 2, "device not surpport, SDK Version: " + m);
      }
      return false;
    }
    return true;
  }
  
  public void d(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.gaudio.GAudioNotifyCenter
 * JD-Core Version:    0.7.0.1
 */