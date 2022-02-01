package com.tencent.mobileqq.avatar.dynamicavatar;

import advr;
import angj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

public class DynamicAvatarManager$1
  implements Runnable
{
  public DynamicAvatarManager$1(advr paramadvr) {}
  
  public void run()
  {
    if ((!VideoEnvironment.r(advr.a(this.this$0))) && ((advr.a(this.this$0) instanceof QQAppInterface))) {
      angj.g((QQAppInterface)advr.a(this.this$0), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.1
 * JD-Core Version:    0.7.0.1
 */