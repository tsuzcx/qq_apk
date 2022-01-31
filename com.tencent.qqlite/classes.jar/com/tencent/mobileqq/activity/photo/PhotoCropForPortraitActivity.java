package com.tencent.mobileqq.activity.photo;

import cit;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;

public class PhotoCropForPortraitActivity
  extends PhotoCropActivity
{
  void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ExtensionInfo localExtensionInfo = ((FriendsManagerImp)this.app.getManager(8)).a(this.app.a());
    if ((localExtensionInfo != null) && (localExtensionInfo.isPendantValid())) {
      this.a = new cit(this, paramInt1, paramInt2);
    }
    super.a(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity
 * JD-Core Version:    0.7.0.1
 */