package com.tencent.mobileqq.apollo;

import abin;
import com.tencent.qphone.base.util.QLog;

public class ChatPieApolloViewController$3
  extends IApolloRunnableTask
{
  public ChatPieApolloViewController$3(abin paramabin, ApolloRender paramApolloRender, String paramString) {}
  
  public String aV()
  {
    return "cm3d_Script";
  }
  
  public int getScriptId()
  {
    return 2;
  }
  
  public void run()
  {
    if (this.a.getSavaWrapper() != null)
    {
      this.a.getSavaWrapper().BA(this.bgq);
      QLog.i("sava_ChatPieApolloViewController", 1, "preLoadEngine cm3dScript");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ChatPieApolloViewController.3
 * JD-Core Version:    0.7.0.1
 */