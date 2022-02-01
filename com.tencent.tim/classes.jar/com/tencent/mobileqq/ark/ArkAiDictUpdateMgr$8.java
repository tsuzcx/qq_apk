package com.tencent.mobileqq.ark;

import adpq;
import adpq.b;
import adpq.d;
import adpz;
import adqb;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class ArkAiDictUpdateMgr$8
  implements Runnable
{
  public ArkAiDictUpdateMgr$8(adpq paramadpq, String paramString, adpq.d paramd, adpq.b paramb) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)adpq.a(this.this$0).get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.r("ArkApp.Dict.Update", "downloadDictFile, qq app interface is null, return from task");
      return;
    }
    ((ArkAppCenter)localQQAppInterface.getManager(121)).a().a(this.val$url, 0L, new adpz(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.8
 * JD-Core Version:    0.7.0.1
 */