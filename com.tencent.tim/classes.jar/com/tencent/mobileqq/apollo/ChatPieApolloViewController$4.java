package com.tencent.mobileqq.apollo;

import abhh;
import abin;
import com.tencent.qphone.base.util.QLog;

public class ChatPieApolloViewController$4
  extends IApolloRunnableTask
{
  public ChatPieApolloViewController$4(abin paramabin, ApolloRender paramApolloRender) {}
  
  public String aV()
  {
    return "sBasicScript";
  }
  
  public int getScriptId()
  {
    return 3;
  }
  
  public void run()
  {
    if (this.a.getSavaWrapper() != null) {
      this.a.getSavaWrapper().BA(abhh.bfU);
    }
    QLog.i("sava_ChatPieApolloViewController", 1, "preLoadEngine sBasicScript");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ChatPieApolloViewController.4
 * JD-Core Version:    0.7.0.1
 */