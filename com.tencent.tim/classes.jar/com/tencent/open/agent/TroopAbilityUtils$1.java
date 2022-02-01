package com.tencent.open.agent;

import acfp;
import android.app.Activity;
import artc;
import swe;

public final class TroopAbilityUtils$1
  implements Runnable
{
  public TroopAbilityUtils$1(Activity paramActivity, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    swe localswe = new swe(this.val$activity);
    artc localartc = new artc(this);
    String str = acfp.m(2131715486);
    localswe.tV(this.val$title);
    localswe.c(str, localartc);
    localswe.a(localartc);
    localswe.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.TroopAbilityUtils.1
 * JD-Core Version:    0.7.0.1
 */