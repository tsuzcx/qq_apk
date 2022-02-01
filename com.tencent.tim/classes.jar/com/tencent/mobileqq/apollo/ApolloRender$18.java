package com.tencent.mobileqq.apollo;

import android.widget.EditText;
import android.widget.RelativeLayout;
import aqgz;

final class ApolloRender$18
  implements Runnable
{
  ApolloRender$18(ApolloRender paramApolloRender, RelativeLayout paramRelativeLayout) {}
  
  public void run()
  {
    if (this.b == null) {
      return;
    }
    int i = (int)(this.val$layout.getMeasuredWidth() - 80.0F * aqgz.density);
    this.b.mEditorPop.setWidth(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.18
 * JD-Core Version:    0.7.0.1
 */