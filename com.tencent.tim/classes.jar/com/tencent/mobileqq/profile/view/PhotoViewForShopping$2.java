package com.tencent.mobileqq.profile.view;

import alcn;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;

class PhotoViewForShopping$2
  implements Runnable
{
  PhotoViewForShopping$2(PhotoViewForShopping paramPhotoViewForShopping, alcn paramalcn) {}
  
  public void run()
  {
    if ((this.b != null) && (this.b.e != null))
    {
      ProfileShoppingPhotoInfo localProfileShoppingPhotoInfo = ProfileShoppingPhotoInfo.getPhotoInfo(this.this$0.app, this.b.e.uin);
      if ((localProfileShoppingPhotoInfo != null) && (PhotoViewForShopping.a(this.this$0) != null))
      {
        Message localMessage = Message.obtain();
        localMessage.what = 200;
        localMessage.obj = localProfileShoppingPhotoInfo;
        PhotoViewForShopping.a(this.this$0).sendMessage(localMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.PhotoViewForShopping.2
 * JD-Core Version:    0.7.0.1
 */