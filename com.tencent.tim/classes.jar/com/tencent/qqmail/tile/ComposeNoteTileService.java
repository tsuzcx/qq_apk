package com.tencent.qqmail.tile;

import android.content.Intent;
import androidx.annotation.RequiresApi;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.activity.compose.ComposeNoteActivity;
import com.tencent.qqmail.activity.setting.SettingNoteActivity;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.oss.KvHelper;

@RequiresApi(api=24)
public class ComposeNoteTileService
  extends BaseTileService
{
  public static final String TAG = "ComposeNoteTileService";
  
  public void onClick()
  {
    super.onClick();
    boolean bool1 = QMSettingManager.sharedInstance().getNoteDisplay();
    boolean bool2 = AccountManager.shareInstance().getAccountList().hasQQMailAccounts();
    QMLog.log(4, "ComposeNoteTileService", "onClick " + bool1);
    if (!bool2)
    {
      startActivityAndCollapse(AccountTypeListActivity.createIntent(true));
      return;
    }
    if (!bool1)
    {
      startActivityAndCollapse(SettingNoteActivity.createIntent());
      return;
    }
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), ComposeNoteActivity.class);
    localIntent.putExtra("noteCatId", "all");
    startActivityAndCollapse(localIntent);
    KvHelper.eventTileServiceComposenoteOnclick(new double[0]);
  }
  
  public void onStartListening()
  {
    super.onStartListening();
    QMLog.log(4, "ComposeNoteTileService", "onStartListening");
    KvHelper.eventTileServiceComposenoteOnstartlisten(new double[0]);
  }
  
  public void onStopListening()
  {
    super.onStopListening();
    QMLog.log(4, "ComposeNoteTileService", "onStopListening");
    KvHelper.eventTileServiceComposenoteOnstoplisten(new double[0]);
  }
  
  public void onTileAdded()
  {
    super.onTileAdded();
    QMLog.log(4, "ComposeNoteTileService", "onTileAdded");
    KvHelper.eventTileServiceComposenoteOnadd(new double[0]);
  }
  
  public void onTileRemoved()
  {
    super.onTileRemoved();
    QMLog.log(4, "ComposeNoteTileService", "onTileRemoved");
    KvHelper.eventTileServiceComposenoteOnremove(new double[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.tile.ComposeNoteTileService
 * JD-Core Version:    0.7.0.1
 */