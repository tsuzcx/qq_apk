package com.tencent.token.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.token.ag;
import com.tencent.token.as;
import com.tencent.token.global.e;

public class SMSReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    e.a("action=" + paramIntent.getAction() + ", result code=" + getResultCode());
    if ("com.tencent.token.sms.SEND".equals(paramIntent.getAction())) {}
    switch (getResultCode())
    {
    default: 
      ag.c().a.e();
      return;
    }
    ag.c().a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.SMSReceiver
 * JD-Core Version:    0.7.0.1
 */