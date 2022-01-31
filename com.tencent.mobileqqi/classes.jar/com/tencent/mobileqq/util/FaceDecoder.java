package com.tencent.mobileqq.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import hag;
import hah;
import java.util.HashMap;
import java.util.LinkedList;

public class FaceDecoder
  implements FaceDecodeTask.DecodeCompletionListener
{
  public static final byte a = 1;
  private static final int jdField_a_of_type_Int = 5;
  private static final long jdField_a_of_type_Long = 300000L;
  private static final String jdField_a_of_type_JavaLangString = "Q.qqhead.FaceDecoder";
  public static final byte b = 11;
  public static final byte c = 4;
  private static final int c = 4;
  public static final byte d = 101;
  public static final byte e = 100;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceDecoder.DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener = null;
  private hag jdField_a_of_type_Hag;
  private hah jdField_a_of_type_Hah;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private boolean jdField_a_of_type_Boolean = false;
  private int b = 0;
  
  public FaceDecoder(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(FaceInfo paramFaceInfo)
  {
    if (paramFaceInfo == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilLinkedList.remove(paramFaceInfo);
      if (paramFaceInfo.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilLinkedList.addLast(paramFaceInfo);
      }
      while ((this.b < 4) && (!this.jdField_a_of_type_Boolean))
      {
        e();
        return;
        this.jdField_a_of_type_JavaUtilLinkedList.addFirst(paramFaceInfo);
      }
    }
  }
  
  private void a(boolean paramBoolean, byte paramByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.FaceDecoder", 2, "onUpdateHead, uin=" + paramString + ", type=" + paramByte + ",isSuccess=" + paramBoolean + ", mPause=" + this.jdField_a_of_type_Boolean);
    }
    String str = FaceInfo.a(paramByte, paramString);
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean))
    {
      Bitmap localBitmap = a(paramByte, paramString);
      if (localBitmap != null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.remove(str);
        if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener.a(this.b + this.jdField_a_of_type_JavaUtilLinkedList.size(), paramByte, paramString, localBitmap);
        }
        return;
      }
      a((FaceInfo)this.jdField_a_of_type_JavaUtilHashMap.get(str));
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.remove(str);
  }
  
  protected static void b(QQAppInterface paramQQAppInterface, FaceInfo paramFaceInfo)
  {
    if (paramFaceInfo.jdField_a_of_type_Int == 1) {
      ((FriendListHandler)paramQQAppInterface.a(1)).a(paramFaceInfo.jdField_a_of_type_JavaLangString, paramFaceInfo.c, paramFaceInfo.jdField_a_of_type_Byte, paramFaceInfo.jdField_b_of_type_Byte, paramFaceInfo.jdField_b_of_type_JavaLangString);
    }
    do
    {
      return;
      if (paramFaceInfo.jdField_a_of_type_Int == 11)
      {
        ((FriendListHandler)paramQQAppInterface.a(1)).b(paramFaceInfo.jdField_a_of_type_JavaLangString, paramFaceInfo.jdField_b_of_type_Byte);
        return;
      }
    } while (paramFaceInfo.jdField_a_of_type_Int != 4);
    ((FriendListHandler)paramQQAppInterface.a(1)).a(paramFaceInfo.jdField_a_of_type_JavaLangString, paramFaceInfo.jdField_b_of_type_Byte);
  }
  
  private void e()
  {
    localObject1 = null;
    do
    {
      try
      {
        FaceInfo localFaceInfo = (FaceInfo)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
        if (localObject1 == null) {
          continue;
        }
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          if ((localFaceInfo.jdField_a_of_type_Int == 101) && (this.jdField_a_of_type_Hag == null))
          {
            this.jdField_a_of_type_Hag = new hag(this, null);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Hag);
          }
          this.b += 1;
          FaceDecodeTask.a(new FaceDecodeTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFaceInfo, this));
          return;
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            localObject1 = localThrowable1;
            Object localObject2 = localThrowable2;
          }
        }
        localThrowable1 = localThrowable1;
      }
      this.b -= 1;
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqhead.FaceDecoder", 2, "runNextTask Exception. faceInfo=" + localObject1, localThrowable1);
  }
  
  public Bitmap a(int paramInt, String paramString)
  {
    byte b1 = 3;
    if (paramInt == 101) {
      b1 = 1;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt, paramString, b1);
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
    {
      d();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, FaceInfo paramFaceInfo)
  {
    this.b -= 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.FaceDecoder", 2, "onDecodeTaskCompletedNeedDownload, uin=" + paramFaceInfo.jdField_a_of_type_JavaLangString + ", iRunningRequests=" + this.b);
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramFaceInfo.a()))
    {
      if (this.jdField_a_of_type_Hah == null)
      {
        this.jdField_a_of_type_Hah = new hah(this, null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Hah);
      }
      b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFaceInfo);
    }
    if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) && (this.b < 4)) {
      e();
    }
  }
  
  public void a(FaceDecoder.DecodeTaskCompletionListener paramDecodeTaskCompletionListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener = paramDecodeTaskCompletionListener;
  }
  
  public void a(FaceInfo paramFaceInfo, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.FaceDecoder", 2, "onDecodeTaskCompleted, uin=" + paramFaceInfo.jdField_a_of_type_JavaLangString + ", iRunningRequests=" + this.b + ", readyRequests=" + this.jdField_a_of_type_JavaUtilLinkedList.size() + ", avatar=" + paramBitmap + ", listener=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener);
    }
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramFaceInfo.a());
    this.b -= 1;
    if ((!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) && (!this.jdField_a_of_type_Boolean)) {
      e();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener != null) && (paramBitmap != null)) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener.a(this.b + this.jdField_a_of_type_JavaUtilLinkedList.size(), paramFaceInfo.jdField_a_of_type_Int, paramFaceInfo.jdField_a_of_type_JavaLangString, paramBitmap);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(Entity paramEntity, boolean paramBoolean)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    String str = null;
    int i = -1;
    if ((paramEntity instanceof Friends))
    {
      str = ((Friends)paramEntity).uin;
      i = 1;
    }
    for (;;)
    {
      if (str != null)
      {
        if (a(i, str) != null) {
          bool2 = true;
        }
        bool1 = bool2;
        if (!bool2) {
          bool1 = a(str, i, paramBoolean);
        }
      }
      return bool1;
      if ((paramEntity instanceof PublicAccountInfo))
      {
        str = String.valueOf(((PublicAccountInfo)paramEntity).uin);
        i = 1;
      }
      else if ((paramEntity instanceof TroopInfo))
      {
        str = ((TroopInfo)paramEntity).troopuin;
        i = 4;
      }
      else if ((paramEntity instanceof DiscussionInfo))
      {
        str = ((DiscussionInfo)paramEntity).uin;
        i = 101;
      }
    }
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramString, paramInt, paramBoolean, (byte)0);
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean, byte paramByte)
  {
    return a(paramString, paramInt, paramBoolean, paramByte, null);
  }
  
  public boolean a(String paramString1, int paramInt, boolean paramBoolean, byte paramByte, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() < 5) || ((paramInt == 100) && ((paramString2 == null) || (TextUtils.isEmpty(paramString2)))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.FaceDecoder", 2, "requestDecodeFace fail. type=" + paramInt + ", uin=" + paramString1 + ", encid=" + paramString2);
      }
      return false;
    }
    String str = FaceInfo.a(paramInt, paramString1);
    FaceInfo localFaceInfo = (FaceInfo)this.jdField_a_of_type_JavaUtilHashMap.get(str);
    long l = SystemClock.uptimeMillis();
    if ((localFaceInfo != null) && (Math.abs(localFaceInfo.jdField_a_of_type_Long - l) < 300000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.FaceDecoder", 2, "requestDecodeFace, uin repeat. uin=" + paramString1);
      }
      if ((localFaceInfo.jdField_a_of_type_Boolean) && (!paramBoolean)) {
        localFaceInfo.jdField_a_of_type_Boolean = false;
      }
      return true;
    }
    int i = 3;
    if (paramInt == 101) {
      i = 1;
    }
    paramString2 = new FaceInfo(paramInt, paramString1, paramBoolean, paramByte, i, paramString2);
    paramString2.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_JavaUtilHashMap.put(str, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.FaceDecoder", 2, "requestDecodeFace. uin=" + paramString1 + ", type=" + paramInt + ", iRunningRequests=" + this.b + ", mPause=" + this.jdField_a_of_type_Boolean);
    }
    a(paramString2);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    while ((this.b < 4) && (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())) {
      e();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.FaceDecoder", 2, "cancelPendingRequests ");
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.FaceDecoder", 2, "destory ");
    }
    c();
    if (this.jdField_a_of_type_Hag != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_Hag);
    }
    if (this.jdField_a_of_type_Hah != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_Hah);
      this.jdField_a_of_type_Hah = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener = null;
    this.b = 0;
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.FaceDecoder
 * JD-Core Version:    0.7.0.1
 */