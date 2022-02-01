package com.tencent.mobileqq.util;

import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public final class FaceDecoder$1
  implements Runnable
{
  public FaceDecoder$1(FaceInfo paramFaceInfo, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((this.d.aRY == 1) || (this.d.aRY == 101) || (this.d.aRY == 115)) {
      ((FriendListHandler)this.val$app.getBusinessHandler(1)).a(this.d.uin, this.d.headLevel, this.d.bA);
    }
    do
    {
      return;
      if (this.d.aRY == 11)
      {
        ((FriendListHandler)this.val$app.getBusinessHandler(1)).c(this.d.uin, this.d.bA);
        return;
      }
      if (this.d.aRY == 4)
      {
        ((FriendListHandler)this.val$app.getBusinessHandler(1)).b(this.d.uin, this.d.bA);
        return;
      }
      if (this.d.aRY == 32)
      {
        ((FriendListHandler)this.val$app.getBusinessHandler(1)).a(this.d.uin, this.d.idType, this.d.headLevel, this.d.bA);
        return;
      }
    } while (this.d.aRY != 16);
    ((FriendListHandler)this.val$app.getBusinessHandler(1)).b(this.d.uin, this.d.idType, this.d.headLevel, this.d.bA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.FaceDecoder.1
 * JD-Core Version:    0.7.0.1
 */