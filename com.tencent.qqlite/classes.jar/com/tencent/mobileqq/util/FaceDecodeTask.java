package com.tencent.mobileqq.util;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import etu;
import etv;
import java.util.ArrayList;

public class FaceDecodeTask
{
  public static final int a = 1;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static Looper jdField_a_of_type_AndroidOsLooper;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final String jdField_a_of_type_JavaLangString = "Q.qqhead.FaceDecodeTask";
  private static ArrayList jdField_a_of_type_JavaUtilArrayList;
  private static etv[] jdField_a_of_type_ArrayOfEtv;
  public static final int b = 4;
  public static final int c = 11;
  public static final int d = 101;
  private static int e = 111;
  private static int f = 2;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceDecodeTask.DecodeCompletionListener jdField_a_of_type_ComTencentMobileqqUtilFaceDecodeTask$DecodeCompletionListener;
  private FaceInfo jdField_a_of_type_ComTencentMobileqqUtilFaceInfo = null;
  private boolean jdField_a_of_type_Boolean;
  
  public FaceDecodeTask(QQAppInterface paramQQAppInterface, FaceInfo paramFaceInfo, FaceDecodeTask.DecodeCompletionListener paramDecodeCompletionListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo = paramFaceInfo;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecodeTask$DecodeCompletionListener = paramDecodeCompletionListener;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static void a()
  {
    for (;;)
    {
      int i;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_JavaUtilArrayList != null) {
          jdField_a_of_type_JavaUtilArrayList.clear();
        }
        if (jdField_a_of_type_AndroidOsHandler != null) {
          jdField_a_of_type_AndroidOsHandler.removeMessages(e);
        }
        if (jdField_a_of_type_ArrayOfEtv != null)
        {
          i = 0;
          if (i < jdField_a_of_type_ArrayOfEtv.length)
          {
            if (jdField_a_of_type_ArrayOfEtv[i] == null) {
              break label107;
            }
            jdField_a_of_type_ArrayOfEtv[i].a();
            break label107;
          }
        }
        synchronized (jdField_a_of_type_JavaUtilArrayList)
        {
          jdField_a_of_type_JavaUtilArrayList.notifyAll();
          jdField_a_of_type_ArrayOfEtv = null;
          jdField_a_of_type_AndroidOsLooper = null;
          jdField_a_of_type_AndroidOsHandler = null;
          return;
        }
      }
      label107:
      i += 1;
    }
  }
  
  public static void a(FaceDecodeTask paramFaceDecodeTask)
  {
    
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      jdField_a_of_type_JavaUtilArrayList.add(paramFaceDecodeTask);
      jdField_a_of_type_JavaUtilArrayList.notify();
      return;
    }
  }
  
  private static void b()
  {
    if (jdField_a_of_type_ArrayOfEtv == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_ArrayOfEtv == null)
        {
          jdField_a_of_type_AndroidOsLooper = Looper.getMainLooper();
          jdField_a_of_type_AndroidOsHandler = new etu(jdField_a_of_type_AndroidOsLooper);
          jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          jdField_a_of_type_ArrayOfEtv = new etv[f];
          int i = 0;
          while (i < jdField_a_of_type_ArrayOfEtv.length)
          {
            jdField_a_of_type_ArrayOfEtv[i] = new etv(null);
            jdField_a_of_type_ArrayOfEtv[i].start();
            i += 1;
          }
        }
        return;
      }
    }
  }
  
  private static void c(FaceDecodeTask paramFaceDecodeTask)
  {
    byte b1 = 0;
    if ((paramFaceDecodeTask == null) || (paramFaceDecodeTask.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo == null)) {}
    for (;;)
    {
      return;
      FaceInfo localFaceInfo = paramFaceDecodeTask.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo;
      try
      {
        if (localFaceInfo.jdField_a_of_type_Int == 101)
        {
          paramFaceDecodeTask.jdField_a_of_type_AndroidGraphicsBitmap = ((DiscussionHandler)paramFaceDecodeTask.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).a(localFaceInfo.jdField_a_of_type_JavaLangString, false);
          paramFaceDecodeTask.jdField_a_of_type_Boolean = false;
          try
          {
            jdField_a_of_type_AndroidOsHandler.sendMessage(jdField_a_of_type_AndroidOsHandler.obtainMessage(e, paramFaceDecodeTask));
            return;
          }
          catch (Exception paramFaceDecodeTask) {}
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.qqhead.FaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + localFaceInfo.jdField_a_of_type_JavaLangString, paramFaceDecodeTask);
          return;
        }
        if ((localFaceInfo.jdField_a_of_type_Int != 4) || (!paramFaceDecodeTask.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localFaceInfo.jdField_a_of_type_Int, localFaceInfo.jdField_a_of_type_JavaLangString, localFaceInfo.d))) {}
        for (boolean bool = true;; bool = false)
        {
          paramFaceDecodeTask.jdField_a_of_type_Boolean = bool;
          bool = paramFaceDecodeTask.jdField_a_of_type_Boolean;
          if (!bool) {
            break label218;
          }
          try
          {
            jdField_a_of_type_AndroidOsHandler.sendMessage(jdField_a_of_type_AndroidOsHandler.obtainMessage(e, paramFaceDecodeTask));
            return;
          }
          catch (Exception paramFaceDecodeTask) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("Q.qqhead.FaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + localFaceInfo.jdField_a_of_type_JavaLangString, paramFaceDecodeTask);
          return;
        }
        label218:
        if (localFaceInfo.jdField_a_of_type_Int != 101)
        {
          Pair localPair = paramFaceDecodeTask.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localFaceInfo.jdField_a_of_type_Int, localFaceInfo.jdField_a_of_type_JavaLangString, localFaceInfo.d);
          if ((localPair != null) && (((Boolean)localPair.first).booleanValue()))
          {
            localFaceInfo.jdField_b_of_type_Byte = 1;
            FaceDecoder.b(paramFaceDecodeTask.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFaceDecodeTask.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo);
          }
        }
        switch (localFaceInfo.jdField_a_of_type_Byte)
        {
        case 1: 
        case 2: 
          for (;;)
          {
            paramFaceDecodeTask.jdField_a_of_type_AndroidGraphicsBitmap = paramFaceDecodeTask.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localFaceInfo.jdField_a_of_type_Int, localFaceInfo.jdField_a_of_type_JavaLangString, (byte)localFaceInfo.jdField_b_of_type_Int, false, b1, localFaceInfo.d);
            if ((QLog.isColorLevel()) && (paramFaceDecodeTask.jdField_a_of_type_AndroidGraphicsBitmap == null)) {
              QLog.d("Q.qqhead.FaceDecodeTask", 2, "doDecodeBitmap fail. uin=" + localFaceInfo.jdField_a_of_type_JavaLangString);
            }
            try
            {
              jdField_a_of_type_AndroidOsHandler.sendMessage(jdField_a_of_type_AndroidOsHandler.obtainMessage(e, paramFaceDecodeTask));
              return;
            }
            catch (Exception paramFaceDecodeTask) {}
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("Q.qqhead.FaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + localFaceInfo.jdField_a_of_type_JavaLangString, paramFaceDecodeTask);
            return;
            b1 = 2;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqhead.FaceDecodeTask", 2, "doDecodeBitmap exception. uin=" + localFaceInfo.jdField_a_of_type_JavaLangString, localThrowable);
        }
        try
        {
          jdField_a_of_type_AndroidOsHandler.sendMessage(jdField_a_of_type_AndroidOsHandler.obtainMessage(e, paramFaceDecodeTask));
          return;
        }
        catch (Exception paramFaceDecodeTask) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.qqhead.FaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + localFaceInfo.jdField_a_of_type_JavaLangString, paramFaceDecodeTask);
        return;
      }
      finally
      {
        for (;;)
        {
          try
          {
            jdField_a_of_type_AndroidOsHandler.sendMessage(jdField_a_of_type_AndroidOsHandler.obtainMessage(e, paramFaceDecodeTask));
            throw localObject;
          }
          catch (Exception paramFaceDecodeTask)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("Q.qqhead.FaceDecodeTask", 2, "doDecodeBitmap sendMessage exception. uin=" + localFaceInfo.jdField_a_of_type_JavaLangString, paramFaceDecodeTask);
            continue;
          }
          b1 = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.FaceDecodeTask
 * JD-Core Version:    0.7.0.1
 */