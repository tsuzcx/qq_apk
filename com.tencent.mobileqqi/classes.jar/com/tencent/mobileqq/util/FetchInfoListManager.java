package com.tencent.mobileqq.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import het;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class FetchInfoListManager
{
  private static final int jdField_a_of_type_Int = 1;
  private static final long jdField_a_of_type_Long = 30000L;
  private static final String jdField_a_of_type_JavaLangString = FetchInfoListManager.class.getSimpleName();
  private static final int jdField_b_of_type_Int = 2;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private FetchInfoListManager.FetchInfoListener jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager$FetchInfoListener;
  private FetchInfoReq jdField_a_of_type_ComTencentMobileqqUtilFetchInfoReq;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList;
  private LinkedList jdField_b_of_type_JavaUtilLinkedList;
  
  public FetchInfoListManager(FetchInfoListManager.FetchInfoListener paramFetchInfoListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager$FetchInfoListener = paramFetchInfoListener;
    this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoReq = new FetchInfoReq();
    this.jdField_a_of_type_AndroidOsHandler = new het(this, Looper.getMainLooper());
  }
  
  private boolean a(FetchInfoReq paramFetchInfoReq)
  {
    return (this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_JavaUtilLinkedList.contains(paramFetchInfoReq));
  }
  
  private void b()
  {
    Object localObject2 = null;
    if ((this.jdField_a_of_type_JavaUtilLinkedList == null) || (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())) {}
    for (;;)
    {
      return;
      try
      {
        if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
        {
          localObject1 = (FetchInfoReq)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
          if (QLog.isColorLevel())
          {
            String str = jdField_a_of_type_JavaLangString;
            if (localObject1 != null)
            {
              localObject2 = ((FetchInfoReq)localObject1).toString();
              QLog.d(str, 2, StringUtil.a(new Object[] { "doFetchInfo()", localObject2 }));
            }
          }
          else
          {
            if ((localObject1 != null) && (!b((FetchInfoReq)localObject1)))
            {
              if (this.b == null) {
                this.b = new LinkedList();
              }
              this.b.add(localObject1);
              localObject2 = Message.obtain();
              ((Message)localObject2).what = 2;
              ((Message)localObject2).obj = localObject1;
              this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject2, 30000L);
              if (this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager$FetchInfoListener != null) {
                this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoListManager$FetchInfoListener.a((FetchInfoReq)localObject1);
              }
            }
            if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
              continue;
            }
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
            return;
          }
        }
      }
      catch (NoSuchElementException localNoSuchElementException)
      {
        for (;;)
        {
          Object localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d(jdField_a_of_type_JavaLangString, 2, localNoSuchElementException.toString());
            localObject1 = localObject2;
            continue;
            localObject2 = "req is null";
            continue;
            localObject1 = null;
          }
        }
      }
    }
  }
  
  private boolean b(FetchInfoReq paramFetchInfoReq)
  {
    return (this.b != null) && (this.b.contains(paramFetchInfoReq));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList != null) {
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
    }
    if (this.b != null) {
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoReq.a(paramInt, paramString1, paramString2, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, StringUtil.a(new Object[] { "addToNeedFetchInfoList()", this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoReq.toString() }));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoReq.a()) {}
    do
    {
      return;
      if ((!a(this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoReq)) && (!b(this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoReq))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, StringUtil.a(new Object[] { "addToNeedFetchInfoList()", this.jdField_a_of_type_ComTencentMobileqqUtilFetchInfoReq.toString(), "已经在队列中了" }));
    return;
    if (this.jdField_a_of_type_JavaUtilLinkedList == null) {
      this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    }
    paramString1 = new FetchInfoReq(paramInt, paramString1, paramString2, paramObject);
    this.jdField_a_of_type_JavaUtilLinkedList.addFirst(paramString1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, Object paramObject)
  {
    FetchInfoReq localFetchInfoReq = new FetchInfoReq();
    localFetchInfoReq.a(paramInt, paramString1, paramString2, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, StringUtil.a(new Object[] { "dealFetchedInfo()", localFetchInfoReq.toString(), Boolean.valueOf(paramBoolean) }));
    }
    if ((paramBoolean) && (this.jdField_a_of_type_JavaUtilLinkedList != null)) {
      this.jdField_a_of_type_JavaUtilLinkedList.remove(localFetchInfoReq);
    }
    if (this.b != null) {
      this.b.remove(localFetchInfoReq);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, localFetchInfoReq);
  }
  
  public boolean a()
  {
    return ((this.jdField_a_of_type_JavaUtilLinkedList == null) || (this.jdField_a_of_type_JavaUtilLinkedList.size() == 0)) && ((this.b == null) || (this.b.size() == 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.FetchInfoListManager
 * JD-Core Version:    0.7.0.1
 */