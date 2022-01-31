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
import erv;
import erw;

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
  public static final int f = 32;
  public static final String f = "param_discus_failure_drawable";
  private static final int jdField_g_of_type_Int = 0;
  private static final String jdField_g_of_type_JavaLangString = "Q.qqhead.FaceDrawable";
  private static final int h = 1;
  private static final int i = 2;
  private ColorFilter jdField_a_of_type_AndroidGraphicsColorFilter = null;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceInfo jdField_a_of_type_ComTencentMobileqqUtilFaceInfo = null;
  private erv jdField_a_of_type_Erv;
  private erw jdField_a_of_type_Erw;
  private Drawable b = null;
  private Drawable c = null;
  private int j = 0;
  private int k = -1;
  
  private FaceDrawable(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString1, byte paramByte, int paramInt3, String paramString2, boolean paramBoolean, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    byte b1 = 200;
    paramByte = b1;
    if (paramInt1 == 32)
    {
      if (paramInt2 == 3000) {
        paramByte = 200;
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo = new FaceInfo(paramInt1, paramString1, false, (byte)0, paramInt3, paramString2, paramBoolean, paramInt2, paramByte);
      if ((paramDrawable1 != null) && (paramDrawable2 != null))
      {
        this.b = paramDrawable1;
        this.c = paramDrawable2;
      }
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1, paramString1, (byte)paramInt3, paramByte);
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString1);
      if (paramInt1 == 101)
      {
        this.jdField_a_of_type_Erv = new erv(this, null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Erv);
      }
      if (paramString1 != null) {
        break label296;
      }
      if (paramInt1 != 4) {
        break label256;
      }
      this.b = ImageUtil.c();
      this.c = ImageUtil.c();
    }
    for (;;)
    {
      this.j = 0;
      FaceDecodeTask.a(new FaceDecodeTask(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo, this));
      return;
      if (paramInt2 == 3001)
      {
        paramByte = 202;
        break;
      }
      paramByte = b1;
      if (paramInt2 != 3002) {
        break;
      }
      paramByte = 204;
      break;
      label256:
      if (paramInt1 == 101)
      {
        this.b = ImageUtil.d();
        this.c = ImageUtil.d();
      }
      else
      {
        this.b = ImageUtil.b();
        this.c = ImageUtil.b();
      }
    }
    label296:
    this.j = 1;
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
    return new FaceDrawable(paramQQAppInterface, paramInt, 3000, paramString, (byte)0, 3, null, false, null, null);
  }
  
  public static FaceDrawable a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqhead.FaceDrawable", 2, "getFaceDrawable fail, uin=" + paramString + ", type=" + paramInt1);
      }
      return null;
    }
    return new FaceDrawable(paramQQAppInterface, paramInt1, 3000, paramString, (byte)0, paramInt2, null, false, null, null);
  }
  
  public static FaceDrawable a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqhead.FaceDrawable", 2, "getFaceDrawable fail, uin=" + paramString + ", type=" + paramInt1);
      }
      return null;
    }
    return new FaceDrawable(paramQQAppInterface, paramInt1, 3000, paramString, (byte)0, paramInt2, null, false, paramDrawable1, paramDrawable2);
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
    return new FaceDrawable(paramQQAppInterface, paramInt, 3000, paramString1, (byte)0, 3, null, false, null, null);
  }
  
  public static FaceDrawable a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqhead.FaceDrawable", 2, "getFaceDrawable fail, uinOrOpenid=" + paramString);
      }
      return null;
    }
    return new FaceDrawable(paramQQAppInterface, 32, paramInt, paramString, (byte)1, 3, null, paramBoolean, null, null);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return "http://q.qlogo.cn/qqapp/" + paramString2 + "/" + paramString1 + "/100";
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
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt, paramString, (byte)this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.d);
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
    this.j = 2;
    if (this.k != -1) {
      this.c.setAlpha(this.k);
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
    switch (this.j)
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
    if ((paramFaceInfo.jdField_a_of_type_Int == 1) || (paramFaceInfo.jdField_a_of_type_Int == 11) || (paramFaceInfo.jdField_a_of_type_Int == 4) || (paramFaceInfo.jdField_a_of_type_Int == 32))
    {
      if (this.jdField_a_of_type_Erw == null)
      {
        this.jdField_a_of_type_Erw = new erw(this, null);
        paramQQAppInterface.a(this.jdField_a_of_type_Erw);
      }
      paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
      if (paramFaceInfo.jdField_a_of_type_Int == 1) {
        paramQQAppInterface.a(paramFaceInfo.jdField_a_of_type_JavaLangString, paramFaceInfo.jdField_c_of_type_Byte, paramFaceInfo.jdField_a_of_type_Byte, paramFaceInfo.jdField_b_of_type_Byte, paramFaceInfo.jdField_b_of_type_JavaLangString);
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
        if (paramFaceInfo.jdField_a_of_type_Int == 4)
        {
          paramQQAppInterface.a(paramFaceInfo.jdField_a_of_type_JavaLangString, paramFaceInfo.jdField_b_of_type_Byte);
          return;
        }
      } while (paramFaceInfo.jdField_a_of_type_Int != 32);
      paramQQAppInterface.a(paramFaceInfo.jdField_a_of_type_JavaLangString, paramFaceInfo.jdField_c_of_type_Int, paramFaceInfo.jdField_a_of_type_Byte, paramFaceInfo.jdField_b_of_type_Byte);
      return;
    }
    ((DiscussionHandler)paramQQAppInterface.a(6)).a(paramFaceInfo.jdField_a_of_type_JavaLangString, true);
  }
  
  public void a(FaceInfo paramFaceInfo, Bitmap paramBitmap)
  {
    if ((paramFaceInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int != paramFaceInfo.jdField_a_of_type_Int) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.d != paramFaceInfo.d) || (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString.equals(paramFaceInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (paramBitmap == null)
    {
      this.j = 2;
      if (this.k != -1) {
        this.c.setAlpha(this.k);
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
      this.j = 1;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources(), paramBitmap);
      if (this.k != -1) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.k);
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
    switch (this.j)
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
    switch (this.j)
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
    switch (this.j)
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
    switch (this.j)
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
    switch (this.j)
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
    switch (this.j)
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
    switch (this.j)
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
    this.k = paramInt;
    switch (this.j)
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
    switch (this.j)
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
    switch (this.j)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.FaceDrawable
 * JD-Core Version:    0.7.0.1
 */