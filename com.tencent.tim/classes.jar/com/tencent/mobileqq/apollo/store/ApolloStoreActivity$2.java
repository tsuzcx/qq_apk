package com.tencent.mobileqq.apollo.store;

import abtv;
import android.content.Intent;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;

class ApolloStoreActivity$2
  implements Runnable
{
  ApolloStoreActivity$2(ApolloStoreActivity paramApolloStoreActivity, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void run()
  {
    if (ApolloStoreActivity.a(this.this$0).b().getRender() != null) {
      ApolloRender.selectPhotoFromSystem(this.bGi, this.bGj, this.D);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloStoreActivity.2
 * JD-Core Version:    0.7.0.1
 */