package com.tencent.mobileqq.activity.aio;

import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.C2CPttUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.mobileqq.transfile.LbsTransfileProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import dvp;
import dvq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.Manager;

public class FileTransferManager
  implements Manager
{
  public static final String a = "FileTransferManager";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new dvp(this, Looper.getMainLooper());
  private final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public FileTransferManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { LbsTransfileProcessor.class, BuddyTransfileProcessor.class, C2CPicUploadProcessor.class, C2CPttDownloadProcessor.class, C2CPttUploadProcessor.class, GroupPicUploadProcessor.class, GroupPttDownloadProcessor.class, ForwardImageProcessor.class });
    a(paramQQAppInterface);
  }
  
  public static FileTransferManager a(QQAppInterface paramQQAppInterface)
  {
    return (FileTransferManager)paramQQAppInterface.getManager(20);
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
  }
  
  public void a(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTransferManager", 2, "handleMessage" + ((FileMsg)paramMessage.obj).c + " status " + paramMessage.what + "retCode " + paramMessage.arg1);
    }
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject = (dvq)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      View localView = ((dvq)localObject).a();
      localObject = ((dvq)localObject).a();
      if ((localView != null) && (localObject != null)) {
        ((FileTransferManager.Callback)localObject).a(localView, (FileMsg)paramMessage.obj, paramMessage.what, paramMessage.arg1);
      }
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        i -= 1;
      }
    }
  }
  
  public void a(View paramView, FileTransferManager.Callback paramCallback)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      dvq localdvq = (dvq)localIterator.next();
      if (localdvq.a() == paramView)
      {
        localdvq.b = new WeakReference(paramCallback);
        return;
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new dvq(this, paramView, paramCallback));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void onDestroy()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.FileTransferManager
 * JD-Core Version:    0.7.0.1
 */