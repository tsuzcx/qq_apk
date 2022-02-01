package com.tencent.mobileqq.apollo;

import abix;
import abvg;
import aqgz;
import com.tencent.qphone.base.util.QLog;

class ApolloRender$5
  extends IApolloRunnableTask
{
  ApolloRender$5(ApolloRender paramApolloRender, int paramInt1, int paramInt2) {}
  
  public String aV()
  {
    return "addOnCommonScript";
  }
  
  public void run()
  {
    if ((ApolloRender.getRenderViewByThreadId() instanceof abix)) {}
    for (int i = ((abix)ApolloRender.getRenderViewByThreadId()).getInitHeight();; i = 0)
    {
      int j = i;
      if (i == 0) {
        j = (int)aqgz.hL();
      }
      String str = abvg.j(this.val$width, this.val$height, j);
      ApolloRender.access$300(this.this$0).BA(str);
      if (QLog.isColorLevel()) {
        QLog.d("sava_ApolloRender", 2, new Object[] { "addOnCommonScript:", str });
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.5
 * JD-Core Version:    0.7.0.1
 */