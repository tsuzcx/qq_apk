package com.tencent.mobileqq.apollo;

import com.tencent.qphone.base.util.QLog;

class ApolloRender$1
  extends IApolloRunnableTask
{
  ApolloRender$1(ApolloRender paramApolloRender) {}
  
  public String aV()
  {
    return "dispose_preLoad";
  }
  
  public int getScriptId()
  {
    return 4;
  }
  
  public void run()
  {
    this.this$0.onDestroy();
    ApolloRender.access$002(this.this$0, true);
    QLog.i("sava_ApolloRender", 1, "queueDestroy disposeDirector");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.1
 * JD-Core Version:    0.7.0.1
 */