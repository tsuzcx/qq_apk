package com.tencent.mobileqq.activity;

import alcn;
import android.graphics.Bitmap;
import android.os.Message;
import aqmp;
import auru;
import com.tencent.mobileqq.activity.aio.anim.FriendProfileCardBgDrawable;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;

class FriendProfileCardActivity$46
  implements Runnable
{
  FriendProfileCardActivity$46(FriendProfileCardActivity paramFriendProfileCardActivity, Bitmap paramBitmap) {}
  
  public void run()
  {
    Bitmap localBitmap = this.jdField_do;
    Object localObject = localBitmap;
    if (localBitmap == null) {
      localObject = ((FriendProfileCardBgDrawable)FriendProfileCardActivity.a(this.this$0)).ai();
    }
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      localObject = Bitmap.createScaledBitmap((Bitmap)localObject, (int)(((Bitmap)localObject).getWidth() * 0.125F), (int)(((Bitmap)localObject).getHeight() * 0.125F), true);
      aqmp.fastblur((Bitmap)localObject, 2);
      if ((this.this$0.b != null) && (this.this$0.jdField_a_of_type_Alcn != null) && (this.this$0.jdField_a_of_type_Alcn.e != null))
      {
        localObject = this.this$0.b.obtainMessage(12, localObject);
        this.this$0.jdField_a_of_type_ComTencentMobileqqProfileProfileShoppingPhotoInfo = ProfileShoppingPhotoInfo.getPhotoInfo(this.this$0.app, this.this$0.jdField_a_of_type_Alcn.e.uin);
        this.this$0.b.sendMessage((Message)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.46
 * JD-Core Version:    0.7.0.1
 */