package com.tencent.qqmail.maillist.fragment;

import android.os.Bundle;
import android.view.View;
import com.tencent.qqmail.fragment.base.MailFragment;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.maillist.adapter.QMMailRecallAdapter;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.watcher.RecallMailWatcher;
import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailRecall;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import moai.core.watcher.Watchers;
import moai.fragment.base.BaseFragment.TransitionConfig;

public class MailRecallListFragment
  extends MailFragment
{
  public static final int FROM_QUERY = 1;
  public static final int FROM_RECALL = 2;
  private static final String TAG = "MailRecallListFragment";
  private QMMailRecallAdapter adapter;
  private SyncPhotoWatcher avatarWatcher = new MailRecallListFragment.1(this);
  private int from;
  private QMBaseView mBaseView;
  private QMContentLoadingView mErrorView;
  private ItemScrollListView mListView;
  private QMTopBar mTopBar;
  private Mail mail;
  private ArrayList<MailContact> mailContacts;
  private long mailId;
  private ArrayList<MailRecall> mailRecalls;
  private RecallMailWatcher recallMailWatcher = new MailRecallListFragment.2(this);
  private long taskId;
  
  public MailRecallListFragment(long paramLong, int paramInt)
  {
    super(true);
    this.mailId = paramLong;
    this.from = paramInt;
  }
  
  private void doRefresh()
  {
    this.mail = QMMailManager.sharedInstance().readMail(this.mailId, false);
    if (this.mail != null)
    {
      MailInformation localMailInformation = this.mail.getInformation();
      if (localMailInformation != null) {
        this.mailContacts = localMailInformation.getToAndCCAndBCCList();
      }
    }
    this.mailRecalls = QMMailManager.sharedInstance().getMailRecallByMailId(this.mailId);
  }
  
  private void doRenderError()
  {
    this.mListView.setVisibility(8);
    this.mErrorView.showTips(2131718614, 2131718622, new MailRecallListFragment.6(this));
  }
  
  private void doRenderList(int paramInt)
  {
    this.mErrorView.hide();
    this.mListView.setVisibility(0);
    this.mListView.setEnablePullToRefresh(false);
    if (this.adapter == null) {
      this.adapter = new QMMailRecallAdapter(getActivity());
    }
    this.adapter.setMail(this.mail);
    this.adapter.setMailContactList(this.mailContacts);
    this.adapter.setMailRecallList(this.mailRecalls);
    this.adapter.setState(paramInt);
    this.mListView.setAdapter(this.adapter);
    this.adapter.notifyDataSetChanged();
  }
  
  private void doRenderQueryErrorView()
  {
    this.mListView.setVisibility(8);
    this.mErrorView.showTips(2131717248, 2131717249, new MailRecallListFragment.5(this));
  }
  
  private void initTopBar()
  {
    this.mTopBar = getTopBar();
    this.mTopBar.setTitle(2131717250);
    this.mTopBar.setButtonLeftIcon(2130841088);
    this.mTopBar.getButtonLeft().setOnClickListener(new MailRecallListFragment.4(this));
  }
  
  private void request()
  {
    if (!this.mail.getStatus().isRecall()) {
      QMMailManager.sharedInstance().recallMail(this.mail.getInformation().getAccountId(), this.mail.getInformation().getId());
    }
    while ((this.mailRecalls != null) && (this.mailRecalls.size() != 0)) {
      return;
    }
    QMMailManager.sharedInstance().queryRecallMail(this.mail.getInformation().getAccountId(), this.mail.getInformation().getId(), 0L);
  }
  
  private void retryQueryRecall()
  {
    Threads.runInBackground(new MailRecallListFragment.3(this), 3000L);
  }
  
  public void initDataSource() {}
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initTopBar();
  }
  
  public QMBaseView initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.mBaseView = super.initUI(paramViewHolder);
    this.mListView = this.mBaseView.addItemScrollListView(false);
    this.mErrorView = this.mBaseView.addListEmptyView();
    return this.mBaseView;
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    QMPrivateProtocolManager.sharedInstance().bindSyncPhotoWatcher(this.avatarWatcher, paramBoolean);
    Watchers.bind(this.recallMailWatcher, paramBoolean);
  }
  
  public BaseFragment.TransitionConfig onFetchTransaction()
  {
    return SCALE_TRANSITION_CONFIG;
  }
  
  public void onRelease() {}
  
  public int refreshData()
  {
    doRefresh();
    request();
    return 0;
  }
  
  public void render(int paramInt)
  {
    paramInt = 0;
    if (this.mail == null) {
      return;
    }
    if (!this.mail.getStatus().isRecall())
    {
      doRenderList(0);
      return;
    }
    if ((this.mailRecalls == null) || (this.mailRecalls.size() == 0))
    {
      if (this.from == 2) {}
      for (;;)
      {
        doRenderList(paramInt);
        return;
        paramInt = 1;
      }
    }
    doRenderList(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailRecallListFragment
 * JD-Core Version:    0.7.0.1
 */