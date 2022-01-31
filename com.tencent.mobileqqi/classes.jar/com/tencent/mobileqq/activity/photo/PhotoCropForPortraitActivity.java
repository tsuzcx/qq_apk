package com.tencent.mobileqq.activity.photo;

import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import erh;

public class PhotoCropForPortraitActivity
  extends PhotoCropActivity
{
  void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ExtensionInfo localExtensionInfo = ((FriendsManagerImp)this.b.getManager(8)).a(this.b.a());
    if ((localExtensionInfo != null) && (localExtensionInfo.isPendantValid())) {
      this.a = new erh(this, paramInt1, paramInt2, localExtensionInfo);
    }
    super.a(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity
 * JD-Core Version:    0.7.0.1
 */