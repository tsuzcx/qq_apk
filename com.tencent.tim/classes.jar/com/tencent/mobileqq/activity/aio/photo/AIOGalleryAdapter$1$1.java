package com.tencent.mobileqq.activity.aio.photo;

import android.text.TextUtils;
import xsf;

public class AIOGalleryAdapter$1$1
  implements Runnable
{
  public AIOGalleryAdapter$1$1(xsf paramxsf, String paramString) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.aWd))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.updateView(this.a.val$position, this.aWd, null, this.a.c, false);
      if (AIOGalleryAdapter.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter) != null) {
        AIOGalleryAdapter.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData, this.a.c.isOriginalImage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */