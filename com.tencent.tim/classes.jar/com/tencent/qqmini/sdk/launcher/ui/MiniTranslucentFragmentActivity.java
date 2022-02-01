package com.tencent.qqmini.sdk.launcher.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;

public class MiniTranslucentFragmentActivity
  extends MiniFragmentActivity
{
  public static void start(Context paramContext, Intent paramIntent, Class<? extends MiniBaseFragment> paramClass)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramContext, MiniTranslucentFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", paramClass.getName());
    paramContext.startActivity(localIntent);
  }
  
  public static void startForResult(Activity paramActivity, Intent paramIntent, Class<? extends MiniBaseFragment> paramClass, int paramInt)
  {
    MiniFragmentActivity.Launcher.startForResult(paramActivity, paramIntent, MiniTranslucentFragmentActivity.class, paramClass, paramInt);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    getWindow().addFlags(67108864);
    DisplayUtil.setActivityTransparent(this);
    setRequestedOrientation(1);
    super.onCreate(paramBundle);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.ui.MiniTranslucentFragmentActivity
 * JD-Core Version:    0.7.0.1
 */