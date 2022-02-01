package com.tencent.qqmail.folderlist;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.accountlist.fragment.AccountListFragment;
import com.tencent.qqmail.activity.contacts.ContactsFragmentActivity;
import com.tencent.qqmail.animation.ListViewRemoveItemAnimator;
import com.tencent.qqmail.bottle.controller.BottleListController;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.bottle.fragment.BottleFragmentActivity;
import com.tencent.qqmail.calendar.fragment.CalendarFragmentActivity;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.card.QMCardManager;
import com.tencent.qqmail.card.fragment.CardFragmentActivity;
import com.tencent.qqmail.folderlist.adapter.QMFolderListAdapter;
import com.tencent.qqmail.folderlist.model.IListFolder;
import com.tencent.qqmail.fragment.base.MailFragment;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.activity.FtnListActivity;
import com.tencent.qqmail.ftn.model.FtnExpireInfo;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.note.NoteListActivity;
import com.tencent.qqmail.permission.RxPermissions;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.view.PopularizeUIHelper;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView.OnRightViewClickListener;
import com.tencent.qqmail.view.FolderLockDialog;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.Arrays;
import moai.fragment.app.FragmentActivity;
import rx.Observable;

public class AppFolderListFragment
  extends MailFragment
{
  public static final String FROM_CALENDAR_SHORTCUT_APP_FOLDER_AND_CALENDAR_IN_APP_FOLDER = "fromCalendarShortcutAppFolderAndCalendarInAppFolder";
  public static final String FROM_NOTE_SHORTCUT_APP_FOLDER_AND_NOTE_IN_APP_FOLDER = "fromNoteShortcutAppFolderAndNoteInAppFolder";
  public static final String TAG = "AppFolderListFragment";
  private boolean isFromCalendarShortcut = false;
  private boolean isFromNoteShortcut = false;
  private FolderLockDialog lockDialog;
  private QMFolderListAdapter mAdapter;
  private ArrayList<IListFolder> mFolderData;
  private boolean mIsFtnUnreadSync = false;
  private ItemScrollListView mListView;
  private QMMailManager mMailMan = null;
  protected QMUnlockFolderPwdWatcher mUnlockFolderPwd = new AppFolderListFragment.3(this);
  
  public AppFolderListFragment()
  {
    super(false);
  }
  
  private void refreshAppFolderData()
  {
    runOnMainThread(new AppFolderListFragment.4(this));
    FtnManager localFtnManager = FtnManager.sharedInstance();
    if ((!this.mIsFtnUnreadSync) && (localFtnManager != null))
    {
      QMLog.log(4, "AppFolderListFragment", "Ftn unread folder render try to read exp unread async");
      localFtnManager.asyncFtnExpireTime();
      this.mIsFtnUnreadSync = true;
    }
  }
  
  public void initDataSource()
  {
    this.mMailMan = QMMailManager.sharedInstance();
    Object localObject = BottleManager.getInstance();
    if (localObject != null)
    {
      localObject = ((BottleManager)localObject).getBottleListController();
      if (localObject != null) {
        FolderDataManager.sharedInstance().setInnerBottleUnreadCount(((BottleListController)localObject).getBottleUnreadCount());
      }
    }
    localObject = FtnManager.sharedInstance();
    if (localObject != null) {
      FolderDataManager.sharedInstance().setInnerFtnUnreadCount(((FtnManager)localObject).getFtnExpUnreadCount());
    }
    this.isFromNoteShortcut = getActivity().getIntent().getBooleanExtra("fromNoteShortcutAppFolderAndNoteInAppFolder", false);
    this.isFromCalendarShortcut = getActivity().getIntent().getBooleanExtra("fromCalendarShortcutAppFolderAndCalendarInAppFolder", false);
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    paramBundle = getTopBar();
    paramViewHolder = getString(2131693944);
    ArrayList localArrayList = FolderDataManager.getHomeAppIdList();
    paramView = paramViewHolder;
    if (localArrayList != null)
    {
      paramView = paramViewHolder;
      if (localArrayList.size() > 0)
      {
        localArrayList.remove(Integer.valueOf(-20));
        paramView = paramViewHolder;
        if (localArrayList.size() > 0) {
          paramView = getString(2131693943);
        }
      }
    }
    paramBundle.setTitle(paramView);
    paramBundle.setButtonLeftBack();
    this.mAdapter = new QMFolderListAdapter(getActivity(), 0, new ArrayList());
    this.mListView.setAdapter(this.mAdapter);
    this.mListView.setOnItemClickListener(new FolderListItemListener(null));
    this.mListView.setOnRightViewClickListener(new FolderOnRightViewClickListener(null));
    this.mListView.setDataCollectCallback(new AppFolderListFragment.1(this));
    if (FolderDataManager.sharedInstance().isEnterAppFolderFragmentFirst()) {
      FolderDataManager.sharedInstance().setIsEnterAppFolderFragmentFirst(false);
    }
  }
  
  public QMBaseView initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    paramViewHolder = super.initUI(paramViewHolder);
    paramViewHolder.setBackgroundColor(getResources().getColor(2131165969));
    this.mListView = paramViewHolder.addItemScrollListView(false);
    this.mListView.setBackgroundColor(getResources().getColor(2131167595));
    return paramViewHolder;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = false;
    if ((paramInt1 == 9) && (paramIntent != null) && (this.mAdapter != null))
    {
      boolean bool3 = paramIntent.getBooleanExtra("arg_ftn_unread_isupdate", false);
      FtnExpireInfo localFtnExpireInfo = (FtnExpireInfo)paramIntent.getSerializableExtra("arg_ftn_unread_info");
      paramIntent = paramIntent.getStringExtra("from");
      if (localFtnExpireInfo != null)
      {
        FtnManager localFtnManager = FtnManager.sharedInstance();
        if (localFtnManager != null)
        {
          boolean bool1 = bool2;
          if (!StringExtention.isNullOrEmpty(paramIntent))
          {
            bool1 = bool2;
            if (paramIntent.equalsIgnoreCase("ftn")) {
              bool1 = true;
            }
          }
          localFtnManager.setIsFromFtn(bool1);
          localFtnManager.setFtnExpUnreadUpdate(bool3);
          localFtnManager.setFtnExpireInfo(localFtnExpireInfo);
        }
        runOnMainThread(new AppFolderListFragment.2(this));
      }
    }
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return this.mListView.isFold();
  }
  
  public Object onLastFragmentFinish()
  {
    if ((this.isFromNoteShortcut) || (this.isFromCalendarShortcut))
    {
      getActivity().getIntent().putExtra("fromNoteShortcutAppFolderAndNoteInAppFolder", false);
      getActivity().getIntent().putExtra("fromCalendarShortcutAppFolderAndCalendarInAppFolder", false);
      AccountList localAccountList = AccountManager.shareInstance().getAccountList();
      if (localAccountList != null)
      {
        if (localAccountList.size() > 1) {
          return new AccountListFragment();
        }
        if (localAccountList.size() == 1) {
          return new FolderListFragment(localAccountList.get(0).getId());
        }
      }
    }
    return super.onLastFragmentFinish();
  }
  
  public void onRelease() {}
  
  public int refreshData()
  {
    return 0;
  }
  
  public void render(int paramInt)
  {
    refreshAppFolderData();
  }
  
  final class FolderListItemListener
    implements AdapterView.OnItemClickListener
  {
    private FolderListItemListener() {}
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      Object localObject = (IListFolder)AppFolderListFragment.this.mListView.getAdapter().getItem(paramInt);
      if (localObject == null) {}
      for (;;)
      {
        EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        return;
        if (((IListFolder)localObject).getData() == null)
        {
          QMLog.log(6, "AppFolderListFragment", "onItemClick null pos: " + paramInt);
        }
        else
        {
          int i = ((QMFolder)((IListFolder)localObject).getData()).getId();
          int j = ((QMFolder)((IListFolder)localObject).getData()).getType();
          if (i == -18)
          {
            QMCalendarManager.logEvent("Event_Click_Calendar");
            if (QMCalendarManager.getInstance().isShowSystemCalendar())
            {
              RxPermissions.getInstance(AppFolderListFragment.this.getActivity()).request(new String[] { "android.permission.WRITE_CALENDAR" }).subscribe(new AppFolderListFragment.FolderListItemListener.1(this));
            }
            else
            {
              localObject = CalendarFragmentActivity.createIntent();
              AppFolderListFragment.this.startActivity((Intent)localObject);
            }
          }
          else if (-4 == i)
          {
            if (FolderLockDialog.isFolderLock(i))
            {
              if (AppFolderListFragment.this.lockDialog != null) {
                AppFolderListFragment.this.lockDialog.dismissTips();
              }
              localObject = AccountManager.shareInstance().getAccountList().getDefaultNoteAccount();
              if ((localObject != null) && (AppFolderListFragment.this.getActivity() != null))
              {
                AppFolderListFragment.access$102(AppFolderListFragment.this, new FolderLockDialog(AppFolderListFragment.this.getActivity(), i, ((QQMailAccount)localObject).getId(), AppFolderListFragment.this.mUnlockFolderPwd));
                AppFolderListFragment.this.lockDialog.createDialog(1);
                AppFolderListFragment.this.lockDialog.showDialog();
              }
            }
            else
            {
              DataCollector.logEvent("Event_Click_Note_Box");
              localObject = NoteListActivity.createIntent();
              AppFolderListFragment.this.startActivity((Intent)localObject);
            }
          }
          else if (-5 == i)
          {
            DataCollector.logEvent("Event_Click_Ftn_Box");
            localObject = FtnListActivity.createIntent();
            AppFolderListFragment.this.startActivityForResult((Intent)localObject, 9);
          }
          else if (i == -16)
          {
            localObject = BottleFragmentActivity.createIntent();
            AppFolderListFragment.this.startActivity((Intent)localObject);
          }
          else if (i == -22)
          {
            localObject = ContactsFragmentActivity.createContactsListIntent();
            AppFolderListFragment.this.startActivity((Intent)localObject);
          }
          else if (i == -23)
          {
            localObject = CardFragmentActivity.createIntentToGallery(QMCardManager.shareInstance().getJumpCardDefaulType(), false);
            AppFolderListFragment.this.startActivity((Intent)localObject);
            DataCollector.logEvent("Event_Card_Click_Card_Item");
          }
          else if (j == 130)
          {
            localObject = PopularizeManager.sharedInstance().getPopularizeById(i);
            if ((localObject != null) && (((Popularize)localObject).getOpenUrl() != null)) {
              PopularizeUIHelper.handleActionAndGotoLink(AppFolderListFragment.this.getActivity(), (Popularize)localObject);
            } else {
              QMLog.log(6, "AppFolderListFragment", "folderList getPopularizeItemData null");
            }
          }
        }
      }
    }
  }
  
  class FolderOnRightViewClickListener
    implements ItemScrollListView.OnRightViewClickListener
  {
    private FolderOnRightViewClickListener() {}
    
    public void onRightViewClick(View paramView, int paramInt)
    {
      if ((paramView != null) && (paramView.getId() == 2131377335))
      {
        paramView = AppFolderListFragment.this.mAdapter.getItem(paramInt);
        int i = ((QMFolder)paramView.getData()).getId();
        if (QMFolderManager.isAppFolder((QMFolder)paramView.getData()))
        {
          Log.v("AppFolderListFragment", "show app folder to home:" + i);
          QMLog.log(4, "AppFolderListFragment", "show app folder to home:" + i);
          ListViewRemoveItemAnimator.animateRemoval(AppFolderListFragment.this.mListView, Arrays.asList(new Integer[] { Integer.valueOf(paramInt) }), new AppFolderListFragment.FolderOnRightViewClickListener.1(this, paramView, i));
          switch (i)
          {
          }
        }
      }
      for (;;)
      {
        if (((QMFolder)paramView.getData()).getType() == 130) {
          DataCollector.logEvent("Event_Popularize_Click_Home");
        }
        return;
        DataCollector.logEvent("Event_Addressbook_Click_Home");
        continue;
        DataCollector.logEvent("Event_Bottle_Click_Home");
        continue;
        DataCollector.logEvent("Event_Calendar_Click_Home");
        continue;
        DataCollector.logEvent("Event_Ftn_Click_Home");
        continue;
        DataCollector.logEvent("Event_Note_Click_Home");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.AppFolderListFragment
 * JD-Core Version:    0.7.0.1
 */