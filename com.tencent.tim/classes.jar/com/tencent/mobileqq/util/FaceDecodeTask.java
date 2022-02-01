package com.tencent.mobileqq.util;

import acmq;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import aqdd;
import aqde;
import aqeg;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public abstract class FaceDecodeTask
{
  protected static ArrayList<FaceDecodeTask> CG;
  private static b a;
  protected static FaceDecodeRunnable[] a;
  protected static Thread[] b;
  protected static int cyM = 6;
  public static int dYu = 111;
  protected static Object fr = new Object();
  protected static MqqHandler g;
  protected static Looper mainLooper;
  public static ArrayList<FaceDecodeTask> tQ = new ArrayList(100);
  public FaceInfo a;
  private AppInterface app;
  public Bitmap bitmap;
  public boolean cTE;
  public WeakReference<a> in;
  
  public FaceDecodeTask(AppInterface paramAppInterface, FaceInfo paramFaceInfo, a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo = paramFaceInfo;
    this.in = new WeakReference(parama);
    this.cTE = false;
    this.app = paramAppInterface;
  }
  
  public static b a()
  {
    b localb = new b();
    int i = Runtime.getRuntime().availableProcessors();
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDecodeTask", 2, "processor count:" + i);
    }
    if (i >= 4) {}
    do
    {
      return localb;
      localb.cyQ = (i + 1);
    } while (i > 2);
    localb.priority = 10;
    return localb;
  }
  
  public static FaceDecodeTask a(AppInterface paramAppInterface, FaceInfo paramFaceInfo, a parama)
  {
    if (paramAppInterface == null) {}
    do
    {
      return null;
      if ((paramAppInterface instanceof QQAppInterface)) {
        return new aqde((QQAppInterface)paramAppInterface, paramFaceInfo, parama);
      }
    } while (!(paramAppInterface instanceof NearbyAppInterface));
    return new aqeg((NearbyAppInterface)paramAppInterface, paramFaceInfo, parama);
  }
  
  public static void a(FaceDecodeTask paramFaceDecodeTask)
  {
    if ((paramFaceDecodeTask == null) || (paramFaceDecodeTask.isExpired()))
    {
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder().append("execute, decodeTaskInfo is expired, type=");
        if (paramFaceDecodeTask == null) {
          break label57;
        }
      }
      label57:
      for (paramFaceDecodeTask = paramFaceDecodeTask.getClass().getSimpleName();; paramFaceDecodeTask = "")
      {
        QLog.w("Q.qqhead.FaceDecodeTask", 2, paramFaceDecodeTask);
        return;
      }
    }
    edr();
    synchronized (CG)
    {
      CG.add(paramFaceDecodeTask);
      CG.notify();
      return;
    }
  }
  
  private static void edr()
  {
    if (b == null) {
      for (;;)
      {
        synchronized (fr)
        {
          if (b == null)
          {
            mainLooper = Looper.getMainLooper();
            g = new aqdd(mainLooper);
            String str = BaseApplicationImpl.processName;
            edt();
            if (jdField_a_of_type_ComTencentMobileqqUtilFaceDecodeTask$b.cyQ != -2147483648) {
              cyM = jdField_a_of_type_ComTencentMobileqqUtilFaceDecodeTask$b.cyQ;
            }
            if ((!TextUtils.isEmpty(str)) && (str.equals("com.tencent.tim"))) {
              cyM = 2;
            }
            CG = new ArrayList();
            b = new Thread[cyM];
            jdField_a_of_type_ArrayOfComTencentMobileqqUtilFaceDecodeTask$FaceDecodeRunnable = new FaceDecodeRunnable[cyM];
            int i = 0;
            try
            {
              if (i < b.length)
              {
                jdField_a_of_type_ArrayOfComTencentMobileqqUtilFaceDecodeTask$FaceDecodeRunnable[i] = new FaceDecodeRunnable(null);
                b[i] = ThreadManager.newFreeThread(jdField_a_of_type_ArrayOfComTencentMobileqqUtilFaceDecodeTask$FaceDecodeRunnable[i], "FaceDecodeThread", 5);
                if (acmq.a().abI()) {
                  b[i].setPriority(1);
                }
                if (b[i].getState() != Thread.State.NEW) {
                  break label253;
                }
                b[i].start();
                bool = true;
                if (QLog.isColorLevel()) {
                  QLog.i("Q.qqhead.FaceDecodeTask", 2, "initFaceDecodeThread, thread isStatusNew=" + bool);
                }
                i += 1;
                continue;
              }
            }
            catch (Throwable localThrowable)
            {
              QLog.e("Q.qqhead.FaceDecodeTask", 1, "initFaceDecodeThread", localThrowable);
              return;
            }
          }
          return;
        }
        label253:
        boolean bool = false;
      }
    }
  }
  
  public static void eds()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDecodeTask", 2, "closeFaceDecodeThread");
    }
    for (;;)
    {
      int i;
      synchronized (fr)
      {
        if (tQ != null) {
          tQ.clear();
        }
        if (g != null) {
          g.removeMessages(dYu);
        }
        if (jdField_a_of_type_ArrayOfComTencentMobileqqUtilFaceDecodeTask$FaceDecodeRunnable != null)
        {
          i = 0;
          if (i < jdField_a_of_type_ArrayOfComTencentMobileqqUtilFaceDecodeTask$FaceDecodeRunnable.length)
          {
            if (jdField_a_of_type_ArrayOfComTencentMobileqqUtilFaceDecodeTask$FaceDecodeRunnable[i] != null) {
              jdField_a_of_type_ArrayOfComTencentMobileqqUtilFaceDecodeTask$FaceDecodeRunnable[i].close();
            }
          }
          else
          {
            jdField_a_of_type_ArrayOfComTencentMobileqqUtilFaceDecodeTask$FaceDecodeRunnable = null;
            b = null;
          }
        }
        else
        {
          if (CG != null) {}
          synchronized (CG)
          {
            CG.clear();
            CG.notifyAll();
            CG = null;
            mainLooper = null;
            g = null;
            return;
          }
        }
      }
      i += 1;
    }
  }
  
  private static void edt()
  {
    if (TextUtils.isEmpty(BaseApplicationImpl.processName)) {}
    for (;;)
    {
      return;
      if (BaseApplicationImpl.processName.equals("com.tencent.tim:tool")) {}
      for (jdField_a_of_type_ComTencentMobileqqUtilFaceDecodeTask$b = a(); QLog.isColorLevel(); jdField_a_of_type_ComTencentMobileqqUtilFaceDecodeTask$b = new b())
      {
        QLog.i("Q.qqhead.FaceDecodeTask", 2, "initFaceDecodeThreadInfo, maxThreadCount=" + jdField_a_of_type_ComTencentMobileqqUtilFaceDecodeTask$b.cyQ + ",priority=" + jdField_a_of_type_ComTencentMobileqqUtilFaceDecodeTask$b.priority);
        return;
      }
    }
  }
  
  protected abstract void edq();
  
  protected abstract boolean isExpired();
  
  static class FaceDecodeRunnable
    implements Runnable
  {
    private boolean isRunning = true;
    
    public void close()
    {
      this.isRunning = false;
    }
    
    public void run()
    {
      Object localObject1 = Thread.currentThread();
      ((Thread)localObject1).setName("FaceDecodeThread" + ((Thread)localObject1).getId());
      localObject1 = BaseApplicationImpl.processName;
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals("com.tencent.tim"))) {
        Process.setThreadPriority(-8);
      }
      for (;;)
      {
        localObject1 = null;
        label57:
        if (this.isRunning) {
          synchronized (FaceDecodeTask.CG)
          {
            int i = FaceDecodeTask.CG.size();
            if (i == 0) {}
            try
            {
              FaceDecodeTask.CG.wait();
              localObject3 = localObject1;
            }
            catch (InterruptedException localInterruptedException)
            {
              for (;;)
              {
                Object localObject3;
                Object localObject4 = localObject2;
              }
            }
            localObject1 = localObject3;
            if (localObject3 == null) {
              break label57;
            }
            ((FaceDecodeTask)localObject3).edq();
            localObject1 = localObject3;
            break label57;
            if (FaceDecodeTask.b().priority != -2147483648)
            {
              Process.setThreadPriority(FaceDecodeTask.b().priority);
              continue;
              localObject3 = (FaceDecodeTask)FaceDecodeTask.CG.remove(0);
            }
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(AppInterface paramAppInterface, FaceInfo paramFaceInfo);
    
    public abstract void a(FaceInfo paramFaceInfo, Bitmap paramBitmap);
  }
  
  public static class b
  {
    int cyQ = -2147483648;
    int priority = -2147483648;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.FaceDecodeTask
 * JD-Core Version:    0.7.0.1
 */