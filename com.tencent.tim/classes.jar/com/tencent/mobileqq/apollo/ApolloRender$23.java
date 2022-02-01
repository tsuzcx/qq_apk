package com.tencent.mobileqq.apollo;

import android.widget.PopupWindow;

final class ApolloRender$23
  implements Runnable
{
  ApolloRender$23(ApolloRender paramApolloRender) {}
  
  public void run()
  {
    if (this.b.mShowEditWindow)
    {
      this.b.mEditWindow.dismiss();
      this.b.mShowEditWindow = false;
      ApolloRender.sIsKeyBoardDissmiss = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.23
 * JD-Core Version:    0.7.0.1
 */