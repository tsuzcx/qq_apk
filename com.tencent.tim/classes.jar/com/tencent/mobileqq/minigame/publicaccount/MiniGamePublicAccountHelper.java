package com.tencent.mobileqq.minigame.publicaccount;

import acbn;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import common.config.service.QzoneConfig;

public class MiniGamePublicAccountHelper
{
  public static void launchMiniGamePublicAccount(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("startTime", SystemClock.elapsedRealtime());
    PublicFragmentActivityForTool.startForResult((Activity)paramContext, localIntent, MiniGamePublicAccountWebFragment.class, 10000);
  }
  
  public static boolean shouldOpenWebFragment(String paramString)
  {
    boolean bool = true;
    if (!TextUtils.equals(acbn.blT, paramString)) {
      return false;
    }
    if (QzoneConfig.getInstance().getConfig("qqtriton", "MiniGamePublicAccountEnableWeb", 0) == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountHelper
 * JD-Core Version:    0.7.0.1
 */