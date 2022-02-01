package com.tencent.mobileqq.ark.API;

import adnq.c;
import android.content.Intent;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;

public class ArkAppModuleReg$ModuleQQ$21
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$21(adnq.c paramc, int paramInt, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    String str = ArkEnvironmentManager.getInstance().getAppResPath(this.this$0.mAppName);
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    Intent localIntent = new Intent(localBaseActivity, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", this.cIV);
    localIntent.putExtra("enter_from", 3);
    localIntent.putExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", true);
    localIntent.putExtra("key_ark_app_res_path", str);
    localIntent.putExtra("key_should_compress", this.val$compress);
    localIntent.putExtra("key_ark_app_engine_res_dir", this.buK);
    localIntent.putExtra("FROM_ARK_CHOOSE_IMAGE", true);
    localIntent.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
    localBaseActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.21
 * JD-Core Version:    0.7.0.1
 */