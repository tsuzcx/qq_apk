package com.tencent.qqmail.accountlist.fragment;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.activity.compose.ComposeNoteActivity;
import com.tencent.qqmail.activity.setting.SettingAboutActivity;
import com.tencent.qqmail.activity.setting.feedback.SettingFeedbackSceneActivity;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.pushconfig.QMPushConfigUtil;
import com.tencent.qqmail.utilities.ui.QMListPopupWindow;
import com.tencent.qqmail.view.FolderLockDialog;
import moai.oss.KvHelper;
import org.apache.commons.lang3.StringUtils;

class AccountListFragment$25
  extends QMListPopupWindow
{
  AccountListFragment$25(AccountListFragment paramAccountListFragment, Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
  }
  
  public void onListItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((TextView)paramView.findViewById(2131373496)).getText().toString();
    if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131691909)))
    {
      AccountListFragment.access$2400(this.this$0);
      KvHelper.eventHomePageCompose(new double[0]);
    }
    do
    {
      do
      {
        return;
      } while (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131696515)));
      if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131691913)))
      {
        if (FolderLockDialog.isFolderLock(-4))
        {
          if (AccountListFragment.access$2500(this.this$0) != null) {
            AccountListFragment.access$2500(this.this$0).dismissTips();
          }
          paramAdapterView = AccountManager.shareInstance().getAccountList().getDefaultNoteAccount();
          if ((paramAdapterView != null) && (this.this$0.getActivity() != null))
          {
            AccountListFragment.access$2502(this.this$0, new FolderLockDialog(this.this$0.getActivity(), -4, paramAdapterView.getId(), this.this$0.mUnlockFolderPwd));
            AccountListFragment.access$2500(this.this$0).createDialog(1);
            AccountListFragment.access$2500(this.this$0).showDialog();
            this.this$0.mIsGoingToComposeNote = true;
          }
        }
        for (;;)
        {
          KvHelper.eventHomePageNote(new double[0]);
          return;
          paramAdapterView = ComposeNoteActivity.createIntentFromAccountList();
          this.this$0.startActivity(paramAdapterView);
        }
      }
      if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131720003)))
      {
        if (!QMSettingManager.sharedInstance().getAppTopBarGuideUpgradedAccount()) {
          QMSettingManager.sharedInstance().setAppTopBarGuideUpgradedAccount();
        }
        AccountListFragment.access$2600(this.this$0);
        return;
      }
      if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131691897)))
      {
        if (AccountListFragment.access$2700(this.this$0) == null) {
          AccountListFragment.access$2702(this.this$0, SettingFeedbackSceneActivity.parseFeedbackAssets());
        }
        paramAdapterView = SettingFeedbackSceneActivity.createIntent(AccountListFragment.access$2700(this.this$0));
        this.this$0.startActivity(paramAdapterView);
        return;
      }
    } while (!StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131719882)));
    QMPushConfigUtil.setBetaPopWindowItem(false);
    DataCollector.logEvent("Event_Topbar_Popwindow_Beta_Click");
    paramAdapterView = SettingAboutActivity.createIntentForBeta();
    this.this$0.startActivity(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AccountListFragment.25
 * JD-Core Version:    0.7.0.1
 */