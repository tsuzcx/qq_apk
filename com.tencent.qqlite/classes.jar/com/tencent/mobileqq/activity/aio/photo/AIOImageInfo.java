package com.tencent.mobileqq.activity.aio.photo;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.GalleryImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class AIOImageInfo
  extends GalleryImage
{
  static long jdField_a_of_type_Long = 0L;
  static long jdField_b_of_type_Long = 0L;
  static long jdField_c_of_type_Long = 0L;
  static long d = 0L;
  public static final int g = -2;
  public int a;
  public AIOImageData a;
  boolean jdField_a_of_type_Boolean = true;
  public int b;
  public Rect b;
  boolean jdField_b_of_type_Boolean;
  Rect jdField_c_of_type_AndroidGraphicsRect;
  private boolean jdField_c_of_type_Boolean = false;
  public int h;
  
  public AIOImageInfo(AIOImageData paramAIOImageData)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -2;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData = paramAIOImageData;
  }
  
  @Deprecated
  public static URLDrawable a(PicUiInterface paramPicUiInterface)
  {
    return URLDrawableHelper.b(paramPicUiInterface, 131075);
  }
  
  private void a(boolean paramBoolean, MessageForPic paramMessageForPic)
  {
    int i = 1;
    HashMap localHashMap;
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      localHashMap = new HashMap();
      if (paramMessageForPic.isSendFromLocal()) {
        paramBoolean = true;
      }
      if (paramMessageForPic.size <= 1048576L) {
        break label252;
      }
      if (i == 0) {
        break label280;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_REPORT", 2, "reportHasBigWhenPicPreview size overLimit skip,hasBig" + paramBoolean + "pic.size:" + paramMessageForPic.size + ",uniseq:" + paramMessageForPic.uniseq);
      }
      if (!paramBoolean) {
        break label257;
      }
      localHashMap.put("param_oversize_av", "1");
      localHashMap.put("param_oversize_dw", "0");
      label126:
      localHashMap.put("param_available", "0");
      localHashMap.put("param_download", "0");
    }
    for (;;)
    {
      i = PicPreDownloadUtils.a();
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_REPORT", 2, "reportHasBigWhenPicPreview hasBig:" + paramBoolean + ",netWorkType:" + i + ",uniseq:" + paramMessageForPic.uniseq);
      }
      localHashMap.put("param_sessionType", String.valueOf(paramMessageForPic.istroop));
      localHashMap.put("param_networkType", String.valueOf(i));
      StatisticCollector.a(BaseApplication.getContext()).a(paramMessageForPic.selfuin, "actBrowserBigPic", false, 0L, 0L, localHashMap, "");
      return;
      label252:
      i = 0;
      break;
      label257:
      localHashMap.put("param_oversize_av", "0");
      localHashMap.put("param_oversize_dw", "1");
      break label126;
      label280:
      if (paramBoolean)
      {
        localHashMap.put("param_available", "1");
        localHashMap.put("param_download", "0");
        localHashMap.put("param_oversize", "0");
      }
      else
      {
        localHashMap.put("param_available", "0");
        localHashMap.put("param_download", "1");
        localHashMap.put("param_oversize", "0");
      }
    }
  }
  
  @Deprecated
  public static URLDrawable b(PicUiInterface paramPicUiInterface)
  {
    return URLDrawableHelper.b(paramPicUiInterface, 1);
  }
  
  public int a()
  {
    return this.h;
  }
  
  public Rect a()
  {
    return this.jdField_c_of_type_AndroidGraphicsRect;
  }
  
  public Rect b()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean)) {
      return this.jdField_b_of_type_AndroidGraphicsRect;
    }
    return super.b();
  }
  
  public int c()
  {
    return 0;
  }
  
  public Drawable c()
  {
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(2);
        if ((localObject1 == null) || (BaseApplicationImpl.a.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(2)) == null)) {
          continue;
        }
        if (ImageUtil.c(((File)localObject1).getAbsolutePath()) != 0) {
          return null;
        }
        localObject1 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(2), URLDrawableHelper.d, URLDrawableHelper.d);
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        Rect localRect;
        if (!QLog.isColorLevel()) {
          break label162;
        }
        QLog.e("AIOImageInfo", 2, "getAnimationBitmap " + localThrowable.toString());
        return null;
        Object localObject2 = null;
        continue;
      }
      localRect = b();
      if ((localObject1 == null) || (localRect == null)) {
        break label162;
      }
      this.h = a(localRect, (Drawable)localObject1);
      return localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(1) == null) {
        continue;
      }
      localObject1 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.a(1), URLDrawableHelper.d, URLDrawableHelper.d);
      ((URLDrawable)localObject1).downloadImediatly();
    }
    label162:
    return null;
  }
  
  public int d()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageInfo
 * JD-Core Version:    0.7.0.1
 */