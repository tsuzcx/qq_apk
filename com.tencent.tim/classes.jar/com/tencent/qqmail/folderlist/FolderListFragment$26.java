package com.tencent.qqmail.folderlist;

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
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.pushconfig.QMPushConfigUtil;
import com.tencent.qqmail.utilities.ui.QMListPopupWindow;
import com.tencent.qqmail.view.FolderLockDialog;
import moai.fragment.app.FragmentActivity;
import moai.oss.KvHelper;
import org.apache.commons.lang3.StringUtils;

class FolderListFragment$26
  extends QMListPopupWindow
{
  FolderListFragment$26(FolderListFragment paramFolderListFragment, Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
  }
  
  public void onListItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.this$0.getActivity() == null) || (this.this$0.getActivity().isFinishing())) {}
    do
    {
      return;
      paramAdapterView = ((TextView)paramView.findViewById(2131373496)).getText().toString();
      if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131691909)))
      {
        this.this$0.gotoCompose();
        KvHelper.eventHomePageCompose(new double[0]);
        return;
      }
      if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131696515)))
      {
        FolderListFragment.access$5100(this.this$0);
        return;
      }
      if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131691913)))
      {
        if (FolderLockDialog.isFolderLock(-4))
        {
          if (FolderListFragment.access$100(this.this$0) != null) {
            FolderListFragment.access$100(this.this$0).dismissTips();
          }
          paramAdapterView = AccountManager.shareInstance().getAccountList().getDefaultNoteAccount();
          if ((paramAdapterView != null) && (this.this$0.getActivity() != null) && (!this.this$0.isRemoving()))
          {
            FolderListFragment.access$102(this.this$0, new FolderLockDialog(this.this$0.getActivity(), -4, paramAdapterView.getId(), FolderListFragment.access$300(this.this$0)));
            FolderListFragment.access$100(this.this$0).createDialog(1);
            FolderListFragment.access$100(this.this$0).showDialog();
            FolderListFragment.access$402(this.this$0, true);
          }
        }
        for (;;)
        {
          KvHelper.eventHomePageNote(new double[0]);
          return;
          paramAdapterView = ComposeNoteActivity.createIntentFromFolderList();
          this.this$0.startActivity(paramAdapterView);
        }
      }
      if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131720003)))
      {
        FolderListFragment.access$5200(this.this$0);
        return;
      }
      if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131691897)))
      {
        if (FolderListFragment.access$5300(this.this$0) == null) {
          FolderListFragment.access$5302(this.this$0, SettingFeedbackSceneActivity.parseFeedbackAssets());
        }
        paramAdapterView = SettingFeedbackSceneActivity.createIntent(FolderListFragment.access$5300(this.this$0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderListFragment.26
 * JD-Core Version:    0.7.0.1
 */