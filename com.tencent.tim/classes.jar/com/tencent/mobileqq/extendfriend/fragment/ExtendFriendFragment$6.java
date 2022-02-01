package com.tencent.mobileqq.extendfriend.fragment;

import android.os.Handler;
import avsn;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;

class ExtendFriendFragment$6
  implements Runnable
{
  ExtendFriendFragment$6(ExtendFriendFragment paramExtendFriendFragment) {}
  
  public void run()
  {
    if (avsn.aLy()) {
      ExtendFriendFragment.bc(avsn.c(this.this$0.getActivity(), ExtendFriendFragment.a(this.this$0)));
    }
    QzoneHandlerThreadFactory.getMainHandler().post(new ExtendFriendFragment.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment.6
 * JD-Core Version:    0.7.0.1
 */