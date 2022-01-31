package com.tencent.mobileqq.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import haj;
import hak;

public class FaceDrawable
  extends Drawable
  implements FaceDecodeTask.DecodeCompletionListener
{
  public static final int a = 11;
  public static final String a = "param_user_loading_drawable";
  public static final int b = 1;
  public static final String b = "param_user_failure_drawable";
  public static final int c = 4;
  public static final String c = "param_group_loading_drawable";
  public static final int d = 101;
  public static final String d = "param_group_failure_drawable";
  public static final int e = 100;
  public static final String e = "param_discus_loading_drawable";
  private static final int f = 0;
  public static final String f = "param_discus_failure_drawable";
  private static final int jdField_g_of_type_Int = 1;
  private static final String jdField_g_of_type_JavaLangString = "Q.qqhead.FaceDrawable";
  private static final int h = 2;
  private ColorFilter jdField_a_of_type_AndroidGraphicsColorFilter = null;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceInfo jdField_a_of_type_ComTencentMobileqqUtilFaceInfo = null;
  private haj jdField_a_of_type_Haj;
  private hak jdField_a_of_type_Hak;
  private Drawable b = null;
  private Drawable c = null;
  private int i = 0;
  private int j = -1;
  
  private FaceDrawable(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo = new FaceInfo(paramInt1, paramString1, false, (byte)0, paramInt2, paramString2);
    if (paramInt1 == 4)
    {
      this.b = ImageUtil.b();
      this.c = ImageUtil.b();
    }
    for (;;)
    {
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1, paramString1, (byte)paramInt2);
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString1);
      if (paramInt1 == 101)
      {
        this.jdField_a_of_type_Haj = new haj(this, null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Haj);
      }
      if (paramString1 != null) {
        break;
      }
      this.i = 0;
      FaceDecodeTask.a(new FaceDecodeTask(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo, this));
      return;
      if (paramInt1 == 101)
      {
        this.b = ImageUtil.c();
        this.c = ImageUtil.c();
      }
      else
      {
        this.b = ImageUtil.a();
        this.c = ImageUtil.a();
      }
    }
    this.i = 1;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(paramQQAppInterface.a().getResources(), paramString1);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(isVisible(), true);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(getBounds());
  }
  
  public static FaceDrawable a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqhead.FaceDrawable", 2, "getFaceDrawable fail, uin=" + paramString + ", type=" + paramInt);
      }
      return null;
    }
    return new FaceDrawable(paramQQAppInterface, paramInt, paramString, 3, null);
  }
  
  public static FaceDrawable a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.equals("")))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqhead.FaceDrawable", 2, "getFaceDrawable fail, uin=" + paramString1 + ", type=" + paramInt);
      }
      return null;
    }
    return new FaceDrawable(paramQQAppInterface, paramInt, paramString1, 3, null);
  }
  
  private void a(boolean paramBoolean, int paramInt, String paramString, BusinessObserver paramBusinessObserver)
  {
    if ((paramInt != this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int) || (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString.equals(paramString))) {
      return;
    }
    if (paramBusinessObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(paramBusinessObserver);
    }
    if (paramBoolean)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt, paramString, (byte)this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int);
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString);
      if (paramString != null)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo, paramString);
        return;
      }
      try
      {
        FaceDecodeTask.a(new FaceDecodeTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo, this));
        return;
      }
      catch (Throwable paramString)
      {
        return;
      }
    }
    this.i = 2;
    if (this.j != -1) {
      this.c.setAlpha(this.j);
    }
    if (this.jdField_a_of_type_AndroidGraphicsColorFilter != null) {
      this.c.setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
    }
    this.c.setVisible(isVisible(), true);
    this.c.setBounds(getBounds());
    invalidateSelf();
  }
  
  public Bitmap a()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof BitmapDrawable))) {
      return ((BitmapDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap();
    }
    return null;
  }
  
  public Drawable a()
  {
    switch (this.i)
    {
    default: 
      return null;
    case 0: 
      return this.b;
    case 1: 
      return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
    return this.c;
  }
  
  public void a(QQAppInterface paramQQAppInterface, FaceInfo paramFaceInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.FaceDrawable", 2, "onDecodeTaskCompletedNeedDownload, uin=" + paramFaceInfo.jdField_a_of_type_JavaLangString + ", type=" + paramFaceInfo.jdField_a_of_type_Int);
    }
    if ((paramFaceInfo.jdField_a_of_type_Int == 1) || (paramFaceInfo.jdField_a_of_type_Int == 11) || (paramFaceInfo.jdField_a_of_type_Int == 4))
    {
      if (this.jdField_a_of_type_Hak == null)
      {
        this.jdField_a_of_type_Hak = new hak(this, null);
        paramQQAppInterface.a(this.jdField_a_of_type_Hak);
      }
      paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
      if (paramFaceInfo.jdField_a_of_type_Int == 1) {
        paramQQAppInterface.a(paramFaceInfo.jdField_a_of_type_JavaLangString, paramFaceInfo.c, paramFaceInfo.jdField_a_of_type_Byte, paramFaceInfo.jdField_b_of_type_Byte, paramFaceInfo.jdField_b_of_type_JavaLangString);
      }
    }
    while (paramFaceInfo.jdField_a_of_type_Int != 101)
    {
      do
      {
        return;
        if (paramFaceInfo.jdField_a_of_type_Int == 11)
        {
          paramQQAppInterface.b(paramFaceInfo.jdField_a_of_type_JavaLangString, paramFaceInfo.jdField_b_of_type_Byte);
          return;
        }
      } while (paramFaceInfo.jdField_a_of_type_Int != 4);
      paramQQAppInterface.a(paramFaceInfo.jdField_a_of_type_JavaLangString, paramFaceInfo.jdField_b_of_type_Byte);
      return;
    }
    ((DiscussionHandler)paramQQAppInterface.a(6)).a(paramFaceInfo.jdField_a_of_type_JavaLangString, true);
  }
  
  public void a(FaceInfo paramFaceInfo, Bitmap paramBitmap)
  {
    if ((paramFaceInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString.equals(paramFaceInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (paramBitmap == null)
    {
      this.i = 2;
      if (this.j != -1) {
        this.c.setAlpha(this.j);
      }
      if (this.jdField_a_of_type_AndroidGraphicsColorFilter != null) {
        this.c.setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
      }
      this.c.setVisible(isVisible(), true);
      this.c.setBounds(getBounds());
    }
    for (;;)
    {
      invalidateSelf();
      return;
      this.i = 1;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources(), paramBitmap);
      if (this.j != -1) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.j);
      }
      if (this.jdField_a_of_type_AndroidGraphicsColorFilter != null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(isVisible(), true);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(getBounds());
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    switch (this.i)
    {
    default: 
      return;
    case 0: 
      this.b.draw(paramCanvas);
      return;
    case 1: 
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      return;
    }
    this.c.draw(paramCanvas);
  }
  
  public int getIntrinsicHeight()
  {
    switch (this.i)
    {
    default: 
      return 0;
    case 0: 
      return this.b.getIntrinsicHeight();
    case 1: 
      return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    }
    return this.c.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    switch (this.i)
    {
    default: 
      return 0;
    case 0: 
      return this.b.getIntrinsicWidth();
    case 1: 
      return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    }
    return this.c.getIntrinsicWidth();
  }
  
  public int getMinimumHeight()
  {
    switch (this.i)
    {
    default: 
      return 0;
    case 0: 
      return this.b.getMinimumHeight();
    case 1: 
      return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getMinimumHeight();
    }
    return this.c.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    switch (this.i)
    {
    default: 
      return 0;
    case 0: 
      return this.b.getMinimumWidth();
    case 1: 
      return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getMinimumWidth();
    }
    return this.c.getMinimumWidth();
  }
  
  public int getOpacity()
  {
    switch (this.i)
    {
    default: 
      return 0;
    case 0: 
      return this.b.getOpacity();
    case 1: 
      return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getOpacity();
    }
    return this.c.getOpacity();
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    switch (this.i)
    {
    default: 
      return;
    case 0: 
      this.b.setBounds(paramRect);
      return;
    case 1: 
      Bitmap localBitmap = SkinUtils.a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources(), localBitmap);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(paramRect);
      invalidateSelf();
      return;
    }
    this.c.setBounds(paramRect);
  }
  
  public void setAlpha(int paramInt)
  {
    this.j = paramInt;
    switch (this.i)
    {
    default: 
      return;
    case 0: 
      this.b.setAlpha(paramInt);
      return;
    case 1: 
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(paramInt);
      return;
    }
    this.c.setAlpha(paramInt);
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    switch (this.i)
    {
    default: 
      return;
    case 0: 
      this.b.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    case 1: 
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    this.c.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsColorFilter = paramColorFilter;
    switch (this.i)
    {
    default: 
      return;
    case 0: 
      this.b.setColorFilter(paramColorFilter);
      return;
    case 1: 
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(paramColorFilter);
      return;
    }
    this.c.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.FaceDrawable
 * JD-Core Version:    0.7.0.1
 */