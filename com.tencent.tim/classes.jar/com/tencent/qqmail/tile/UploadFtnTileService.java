package com.tencent.qqmail.tile;

import androidx.annotation.RequiresApi;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.activity.setting.SettingFtnActivity;
import com.tencent.qqmail.ftn.activity.FtnListActivity;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.oss.KvHelper;

@RequiresApi(api=24)
public class UploadFtnTileService
  extends BaseTileService
{
  public static final String TAG = "UploadFtnTileService";
  
  public void onClick()
  {
    super.onClick();
    QMLog.log(4, "UploadFtnTileService", "onClick");
    boolean bool = QMSettingManager.sharedInstance().getFtnDisplay();
    if (!AccountManager.shareInstance().getAccountList().hasQQMailAccounts())
    {
      startActivityAndCollapse(AccountTypeListActivity.createIntent(true));
      return;
    }
    if (!bool)
    {
      startActivityAndCollapse(SettingFtnActivity.createIntent());
      return;
    }
    startActivityAndCollapse(FtnListActivity.createIntentWithUpload());
    KvHelper.eventTileServiceFtnOnclick(new double[0]);
  }
  
  public void onStartListening()
  {
    super.onStartListening();
    QMLog.log(4, "UploadFtnTileService", "onStartListening");
    KvHelper.eventTileServiceFtnOnstartlisten(new double[0]);
  }
  
  public void onStopListening()
  {
    super.onStopListening();
    QMLog.log(4, "UploadFtnTileService", "onStopListening");
    KvHelper.eventTileServiceFtnOnstoplisten(new double[0]);
  }
  
  public void onTileAdded()
  {
    super.onTileAdded();
    QMLog.log(4, "UploadFtnTileService", "onTileAdded");
    KvHelper.eventTileServiceFtnOnadd(new double[0]);
  }
  
  public void onTileRemoved()
  {
    super.onTileRemoved();
    QMLog.log(4, "UploadFtnTileService", "onTileRemoved");
    KvHelper.eventTileServiceFtnOnremove(new double[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.tile.UploadFtnTileService
 * JD-Core Version:    0.7.0.1
 */