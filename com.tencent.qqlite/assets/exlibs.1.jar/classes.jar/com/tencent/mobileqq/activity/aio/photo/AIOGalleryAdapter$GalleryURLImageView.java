package com.tencent.mobileqq.activity.aio.photo;

import android.annotation.TargetApi;
import android.content.Context;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.image.URLDrawable;
import java.net.URL;

public class AIOGalleryAdapter$GalleryURLImageView
  extends AbstractImageAdapter.URLImageView2
{
  int jdField_a_of_type_Int;
  AIOImageInfo jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo;
  boolean b = false;
  
  public AIOGalleryAdapter$GalleryURLImageView(AIOGalleryAdapter paramAIOGalleryAdapter, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(this.jdField_a_of_type_Int, false);
  }
  
  @TargetApi(11)
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable.getURL().getRef() != null)
    {
      this.jdField_a_of_type_Boolean = true;
      super.onLoadSuccessed(paramURLDrawable);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(this.jdField_a_of_type_Int, true);
      return;
    }
    super.onLoadSuccessed(paramURLDrawable);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(this.jdField_a_of_type_Int, true);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo.b == -2) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo.b = paramURLDrawable.getExifOrientation();
    }
    AIOGalleryAdapter.a(this, paramURLDrawable, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter.GalleryURLImageView
 * JD-Core Version:    0.7.0.1
 */