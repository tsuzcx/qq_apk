package com.tencent.mobileqq.extendfriend.fragment;

import afyg;

class ExtendFriendBaseFragment$4
  implements Runnable
{
  ExtendFriendBaseFragment$4(ExtendFriendBaseFragment paramExtendFriendBaseFragment) {}
  
  public void run()
  {
    this.this$0.dck();
    if (this.this$0.a != null) {
      this.this$0.a.abandonAudioFocus();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment.4
 * JD-Core Version:    0.7.0.1
 */