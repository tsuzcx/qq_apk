package com.tencent.mobileqq.apollo;

import android.view.View;
import com.tencent.qphone.base.util.QLog;

final class ApolloRender$21
  implements Runnable
{
  ApolloRender$21(ApolloRender paramApolloRender, View paramView) {}
  
  public void run()
  {
    this.b.mShowEditWindow = true;
    try
    {
      ApolloRender.setVisiblePopEidtor(this.val$contentView, this.b);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("sava_ApolloRender", 1, "show editor err =" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.21
 * JD-Core Version:    0.7.0.1
 */