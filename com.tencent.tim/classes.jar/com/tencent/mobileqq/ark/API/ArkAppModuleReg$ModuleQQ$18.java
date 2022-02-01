package com.tencent.mobileqq.ark.API;

import adnq.c;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import java.util.ArrayList;

public class ArkAppModuleReg$ModuleQQ$18
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$18(adnq.c paramc, int paramInt, ArrayList paramArrayList) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    Intent localIntent = new Intent(localBaseActivity, TroopAvatarWallPreviewActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", this.val$index);
    localBundle.putStringArrayList("seqNum", this.uE);
    localBundle.putBoolean("needBottomBar", false);
    localBundle.putBoolean("IS_EDIT", false);
    localBundle.putBoolean("is_use_path", true);
    localBundle.putBoolean("is_show_action", true);
    localBundle.putBoolean("is_not_show_index", false);
    localBundle.putBoolean("is_index_show_bottom", true);
    localIntent.putExtras(localBundle);
    localBaseActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.18
 * JD-Core Version:    0.7.0.1
 */