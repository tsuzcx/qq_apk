package com.tencent.mobileqq.troop.activity;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.persistence.EntityManager;

public class TroopAvatarWallPreviewActivity$2
  implements Runnable
{
  TroopAvatarWallPreviewActivity$2(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.this$0.app == null) {
      return;
    }
    EntityManager localEntityManager = this.this$0.app.a().createEntityManager();
    Setting localSetting = (Setting)localEntityManager.find(Setting.class, "troop_" + this.this$0.mTroopUin);
    localEntityManager.close();
    this.this$0.runOnUiThread(new TroopAvatarWallPreviewActivity.2.1(this, localSetting));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.2
 * JD-Core Version:    0.7.0.1
 */