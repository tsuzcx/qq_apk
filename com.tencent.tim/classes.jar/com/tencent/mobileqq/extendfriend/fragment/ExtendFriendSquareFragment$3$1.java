package com.tencent.mobileqq.extendfriend.fragment;

import afvy;
import afwe;
import com.tencent.qphone.base.util.QLog;

public class ExtendFriendSquareFragment$3$1
  implements Runnable
{
  public ExtendFriendSquareFragment$3$1(afvy paramafvy) {}
  
  public void run()
  {
    try
    {
      this.a.this$0.a.bx(0, true);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ExtendFriendSquareFragment", 1, "onScrolled fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment.3.1
 * JD-Core Version:    0.7.0.1
 */