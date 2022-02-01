package com.tencent.mobileqq.apollo.sdk;

import abix;
import absc;
import abse;
import abwh;
import abyy;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRenderDriver;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;
import com.tencent.qphone.base.util.QLog;

public class CmShowSpriteAioScript$1
  extends IApolloRunnableTask
{
  public CmShowSpriteAioScript$1(absc paramabsc, String paramString, abix paramabix, int paramInt, boolean paramBoolean) {}
  
  public boolean Yq()
  {
    return this.bEP;
  }
  
  public String aV()
  {
    if ((!TextUtils.isEmpty(this.val$script)) && (this.val$script.length() > 10)) {
      return "execScriptInRenderThread " + this.val$script.substring(0, 10);
    }
    return "execScriptInRenderThread " + this.val$script;
  }
  
  public int getScriptId()
  {
    if (this.cqR != 0) {
      return this.cqR;
    }
    return super.getScriptId();
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CmShow_SpriteAioScript", 1, "TraceReport exe Js:" + this.val$script.length());
    }
    if (this.val$script.startsWith("initSprite")) {
      abwh.a(this.this$0.a.zM(), 350, 0, new Object[] { "enter exeInitSprite" });
    }
    if ((this.a != null) && (this.a.getWorker() != null) && (this.a.getWorker().a != null)) {
      this.a.getWorker().a.BA(this.val$script);
    }
    if (QLog.isColorLevel())
    {
      if (!this.val$script.contains("CMShowDefActionName")) {
        break label152;
      }
      abyy.Dg("exeCmshow0");
    }
    label152:
    while (!this.val$script.contains("commonInit")) {
      return;
    }
    abyy.Dg("exeCommon");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowSpriteAioScript.1
 * JD-Core Version:    0.7.0.1
 */