package com.tencent.mobileqq.activity.aio.photo;

import sxn;
import xse;
import xsk;
import xto;

public class AIOGalleryActivity$AIOGalleryManager$1$3
  implements Runnable
{
  public AIOGalleryActivity$AIOGalleryManager$1$3(xse paramxse, AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt) {}
  
  public void run()
  {
    xto localxto;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData != null)
    {
      localxto = (xto)AIOGalleryActivity.a.a(this.jdField_a_of_type_Xse.a);
      if (!localxto.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData, this.bWJ)) {
        break label92;
      }
      if (AIOGalleryActivity.a.e(this.jdField_a_of_type_Xse.a) != null) {
        ((xsk)AIOGalleryActivity.a.f(this.jdField_a_of_type_Xse.a)).notifyImageModelDataChanged();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Xse.a.b != null) {
        this.jdField_a_of_type_Xse.a.b.notifyDataSetChanged();
      }
      return;
      label92:
      if ((this.jdField_a_of_type_Xse.a.b != null) && (this.jdField_a_of_type_Xse.a.a() == this.jdField_a_of_type_Xse.a.b))
      {
        localxto.SL();
        if (AIOGalleryActivity.a.g(this.jdField_a_of_type_Xse.a) != null) {
          ((xsk)AIOGalleryActivity.a.h(this.jdField_a_of_type_Xse.a)).notifyImageModelDataChanged();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity.AIOGalleryManager.1.3
 * JD-Core Version:    0.7.0.1
 */