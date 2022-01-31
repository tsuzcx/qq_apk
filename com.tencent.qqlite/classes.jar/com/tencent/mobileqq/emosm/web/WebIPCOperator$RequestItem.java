package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;

class WebIPCOperator$RequestItem
{
  Bundle reqbundle;
  int seq;
  Runnable timeoutTask;
  
  public WebIPCOperator$RequestItem(int paramInt, Bundle paramBundle)
  {
    this.seq = paramInt;
    paramBundle.putInt("seq", paramInt);
    this.reqbundle = paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.WebIPCOperator.RequestItem
 * JD-Core Version:    0.7.0.1
 */