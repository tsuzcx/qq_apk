package com.tencent.mobileqq.richmediabrowser;

import amcg;
import amcn;
import amcv;
import amdj;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

public class AIOGalleryActivity$2$3
  implements Runnable
{
  public AIOGalleryActivity$2$3(amcg paramamcg, AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (AIOGalleryActivity.a(this.jdField_a_of_type_Amcg.a) != null))
    {
      amcn localamcn = AIOGalleryActivity.a(this.jdField_a_of_type_Amcg.a).b;
      try
      {
        AIOBrowserBaseData[] arrayOfAIOBrowserBaseData = amdj.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaData);
        if (arrayOfAIOBrowserBaseData == null)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("IAIOImageProviderCallBack", 4, "galleryBaseDatas is null");
          return;
        }
        if (localamcn.a(arrayOfAIOBrowserBaseData, this.bWJ))
        {
          AIOGalleryActivity.a(this.jdField_a_of_type_Amcg.a).a(arrayOfAIOBrowserBaseData, this.bWJ);
          return;
        }
      }
      catch (Exception localException)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("IAIOImageProviderCallBack", 4, "notifyImageListChanged exception = " + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity.2.3
 * JD-Core Version:    0.7.0.1
 */