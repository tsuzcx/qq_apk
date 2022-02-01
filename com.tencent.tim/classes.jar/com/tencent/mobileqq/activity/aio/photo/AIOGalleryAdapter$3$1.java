package com.tencent.mobileqq.activity.aio.photo;

import android.text.TextUtils;
import xsh;

public class AIOGalleryAdapter$3$1
  implements Runnable
{
  public AIOGalleryAdapter$3$1(xsh paramxsh, String paramString) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.aWd))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.onLoadFinish(this.a.val$position, true);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.updateView(this.a.val$position, this.aWd, null, this.a.c, false);
      if (AIOGalleryAdapter.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter) != null) {
        AIOGalleryAdapter.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData, this.a.c.isOriginalImage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter.3.1
 * JD-Core Version:    0.7.0.1
 */