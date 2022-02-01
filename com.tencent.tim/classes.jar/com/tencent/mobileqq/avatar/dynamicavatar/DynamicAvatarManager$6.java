package com.tencent.mobileqq.avatar.dynamicavatar;

import advr;
import aqcy;
import com.tencent.mobileqq.data.DynamicAvatar;

public class DynamicAvatarManager$6
  implements Runnable
{
  public DynamicAvatarManager$6(advr paramadvr, aqcy paramaqcy, long paramLong) {}
  
  public void run()
  {
    DynamicAvatar localDynamicAvatar = this.this$0.a(this.a.dYs, this.a.mId);
    if (localDynamicAvatar != null)
    {
      localDynamicAvatar.playTimeStamp = this.val$now;
      this.this$0.a(localDynamicAvatar);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.6
 * JD-Core Version:    0.7.0.1
 */