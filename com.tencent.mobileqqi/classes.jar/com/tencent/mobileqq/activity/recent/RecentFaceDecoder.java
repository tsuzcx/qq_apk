package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class RecentFaceDecoder
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceDecoder.DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener;
  public FaceDecoder a;
  private boolean jdField_a_of_type_Boolean;
  
  public RecentFaceDecoder(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public RecentFaceDecoder(QQAppInterface paramQQAppInterface, FaceDecoder.DecodeTaskCompletionListener paramDecodeTaskCompletionListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(BaseApplication.getContext(), paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramDecodeTaskCompletionListener);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener = paramDecodeTaskCompletionListener;
  }
  
  public static Pair a(int paramInt, String paramString)
  {
    int k = -2147483648;
    int m = 2130838029;
    int i = m;
    int j = k;
    switch (paramInt)
    {
    default: 
      i = -2147483648;
      j = k;
    }
    for (;;)
    {
      return Pair.create(Integer.valueOf(j), Integer.valueOf(i));
      i = m;
      j = k;
      if (!String.valueOf(AppConstants.U).equals(paramString))
      {
        i = m;
        j = k;
        if (!String.valueOf(AppConstants.W).equals(paramString)) {
          if (String.valueOf(AppConstants.V).equals(paramString))
          {
            i = 2130838025;
            j = k;
          }
          else if (String.valueOf(AppConstants.N).equals(paramString))
          {
            i = 2130838031;
            j = k;
          }
          else if (AppConstants.S.equals(paramString))
          {
            i = 2130838093;
            j = k;
          }
          else
          {
            j = 1;
            i = -2147483648;
            continue;
            j = 102;
            i = 2130838590;
            continue;
            j = 11;
            i = -2147483648;
            continue;
            j = 101;
            i = -2147483648;
            continue;
            j = 4;
            i = -2147483648;
            continue;
            i = 2130838023;
            j = k;
            continue;
            i = 2130838030;
            j = k;
            continue;
            i = 2130838028;
            j = k;
            continue;
            i = 2130838024;
            j = k;
            continue;
            i = 2130838027;
            j = k;
          }
        }
      }
    }
  }
  
  public Drawable a(int paramInt, String paramString)
  {
    return a(paramInt, paramString, true);
  }
  
  public Drawable a(int paramInt, String paramString, boolean paramBoolean)
  {
    Pair localPair = a(paramInt, paramString);
    paramInt = ((Integer)localPair.first).intValue();
    int i = ((Integer)localPair.second).intValue();
    if (paramInt != -2147483648) {
      return a(paramString, paramInt);
    }
    if ((i != -2147483648) && (paramBoolean)) {
      return BaseApplication.getContext().getResources().getDrawable(i);
    }
    return null;
  }
  
  public Drawable a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt, paramString, false);
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder == null) {}
    for (Object localObject = null;; localObject = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramInt, paramString))
    {
      if ((QLog.isDevelopLevel()) && (paramInt == 101)) {
        QLog.i("Q.recent", 4, "requestDecodeFace| [" + paramString + "," + paramInt + "," + localObject + "], isPausing=" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a());
      }
      if (localObject != null) {
        break;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, paramInt, true, (byte)2);
      }
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return ImageUtil.a();
      }
    }
    return ImageUtil.b();
    return ImageUtil.c();
    return ImageUtil.a();
    return ImageUtil.d();
    return new BitmapDrawable(BaseApplication.getContext().getResources(), (Bitmap)localObject);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentFaceDecoder
 * JD-Core Version:    0.7.0.1
 */