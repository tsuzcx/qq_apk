package com.tencent.qqmail.tile;

import androidx.annotation.RequiresApi;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.oss.KvHelper;

@RequiresApi(api=24)
public class ComposeMailTileService
  extends BaseTileService
{
  public static final String TAG = "ComposeMailTileService";
  
  public void onClick()
  {
    super.onClick();
    QMLog.log(4, "ComposeMailTileService", "onClick");
    if (!AccountManager.shareInstance().getAccountList().hasAccounts())
    {
      startActivityAndCollapse(AccountTypeListActivity.createIntent(true));
      return;
    }
    startActivityAndCollapse(ComposeMailActivity.createIntetnFromThirdParty());
    KvHelper.eventTileServiceComposemailOnclick(new double[0]);
  }
  
  public void onStartListening()
  {
    super.onStartListening();
    QMLog.log(4, "ComposeMailTileService", "onStartListening");
    KvHelper.eventTileServiceComposemailOnstartlisten(new double[0]);
  }
  
  public void onStopListening()
  {
    super.onStopListening();
    QMLog.log(4, "ComposeMailTileService", "onStopListening");
    KvHelper.eventTileServiceComposemailOnstoplisten(new double[0]);
  }
  
  public void onTileAdded()
  {
    super.onTileAdded();
    QMLog.log(4, "ComposeMailTileService", "onTileAdded");
    KvHelper.eventTileServiceComposemailOnadd(new double[0]);
  }
  
  public void onTileRemoved()
  {
    super.onTileRemoved();
    QMLog.log(4, "ComposeMailTileService", "onTileRemoved");
    KvHelper.eventTileServiceComposemailOnremove(new double[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.tile.ComposeMailTileService
 * JD-Core Version:    0.7.0.1
 */