package com.tencent.mobileqq.apollo.store;

import abty;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;

public class ApolloVoiceDIYHelper$1
  implements Runnable
{
  public ApolloVoiceDIYHelper$1(abty paramabty, ApolloTextureView paramApolloTextureView, double paramDouble) {}
  
  public void run()
  {
    ApolloRender localApolloRender = this.h.getRender();
    if ((localApolloRender != null) && (localApolloRender.getSavaWrapper() != null)) {
      localApolloRender.getSavaWrapper().x(this.bX);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloVoiceDIYHelper.1
 * JD-Core Version:    0.7.0.1
 */