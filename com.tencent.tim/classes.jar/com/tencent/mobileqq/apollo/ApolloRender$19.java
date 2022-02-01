package com.tencent.mobileqq.apollo;

import android.view.View;
import android.widget.PopupWindow;

final class ApolloRender$19
  implements Runnable
{
  ApolloRender$19(ApolloRender paramApolloRender, View paramView, int paramInt) {}
  
  public void run()
  {
    if ((this.b == null) || (this.b.mEditWindow == null) || (this.val$view == null)) {
      return;
    }
    this.b.mEditWindow.showAtLocation(this.val$view.getRootView(), 0, 0, this.coU);
    this.b.mEditWindow.update(0, this.coU, this.b.mEditWindow.getWidth(), this.b.mEditWindow.getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.19
 * JD-Core Version:    0.7.0.1
 */