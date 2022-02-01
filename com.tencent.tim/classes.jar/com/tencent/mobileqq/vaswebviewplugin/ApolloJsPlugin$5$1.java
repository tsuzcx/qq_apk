package com.tencent.mobileqq.vaswebviewplugin;

import abtv;
import abua;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import java.util.ArrayList;
import java.util.Vector;

class ApolloJsPlugin$5$1
  implements Runnable
{
  ApolloJsPlugin$5$1(ApolloJsPlugin.5 param5, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (ApolloJsPlugin.access$200(this.this$1.this$0).contains(this.this$1.val$param.apolloId))
    {
      if (!(this.this$1.val$activity instanceof abua)) {
        break label60;
      }
      ((abua)this.this$1.val$activity).p(this.val$tempList);
    }
    label60:
    while (ApolloJsPlugin.access$300(this.this$1.this$0) == null) {
      return;
    }
    ApolloJsPlugin.access$300(this.this$1.this$0).p(this.val$tempList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin.5.1
 * JD-Core Version:    0.7.0.1
 */