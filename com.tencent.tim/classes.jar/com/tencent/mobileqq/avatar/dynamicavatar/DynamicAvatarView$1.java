package com.tencent.mobileqq.avatar.dynamicavatar;

import aqcy;

class DynamicAvatarView$1
  implements Runnable
{
  DynamicAvatarView$1(DynamicAvatarView paramDynamicAvatarView) {}
  
  public void run()
  {
    if (this.this$0.b != null) {
      this.this$0.setImageDrawable(this.this$0.b.getCurrDrawable());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView.1
 * JD-Core Version:    0.7.0.1
 */