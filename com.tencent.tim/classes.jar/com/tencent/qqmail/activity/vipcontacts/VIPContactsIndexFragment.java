package com.tencent.qqmail.activity.vipcontacts;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.fragment.base.QMBaseFragment;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.maillist.fragment.MailListFragment;
import com.tencent.qqmail.maillist.fragment.MailListFragment.NullFolderException;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.watcher.LoadContactListWatcher;
import com.tencent.qqmail.model.mail.watcher.LoadVipContactListWatcher;
import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.model.mail.watcher.VipContactWatcher;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.Iterator;
import moai.core.watcher.Watchers;
import moai.fragment.base.BaseFragment.TransitionConfig;
import moai.fragment.base.SaveArgumentField;

public class VIPContactsIndexFragment
  extends QMBaseFragment
{
  public static final String TAG = "VIPContactsIndexFragment";
  @SaveArgumentField
  private int accountId;
  private VIPContactsIndexAdapter adapter;
  private Button addVipContactsBtn;
  private boolean hasSyncVipList;
  @SaveArgumentField
  private boolean isFromMailList;
  private ListView listView;
  private LoadContactListWatcher loadContactListWatcher = new VIPContactsIndexFragment.2(this);
  private QMContentLoadingView loadingView;
  private LinearLayout noneVipContactView;
  private AdapterView.OnItemClickListener onContactItemClick = new VIPContactsIndexFragment.6(this);
  private AdapterView.OnItemLongClickListener onContactItemLongClick = new VIPContactsIndexFragment.5(this);
  private SyncPhotoWatcher syncPhotoWatcher = new VIPContactsIndexFragment.4(this);
  private QMTopBar topbar;
  private LoadVipContactListWatcher vipContactListWatcher = new VIPContactsIndexFragment.3(this);
  private VipContactWatcher vipContactWatcher = new VIPContactsIndexFragment.1(this);
  private ArrayList<MailContact> vipLists;
  
  public VIPContactsIndexFragment(int paramInt, boolean paramBoolean)
  {
    super(true);
    this.accountId = paramInt;
    this.isFromMailList = paramBoolean;
  }
  
  private void backToPreviousActivity()
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.accountId);
    if ((localAccount != null) && (localAccount.isQQMail())) {
      QMMailManager.sharedInstance().sync(this.accountId);
    }
    if (this.isFromMailList)
    {
      popBackStack();
      if ((this.vipLists != null) && (this.vipLists.size() == 0)) {
        popBackStack();
      }
      overridePendingTransition(2130772423, 2130772402);
      return;
    }
    if ((this.vipLists != null) && (this.vipLists.size() > 0)) {
      popBackStack();
    }
    try
    {
      startFragment(new MailListFragment(0, -3));
      for (;;)
      {
        label111:
        overridePendingTransition(2130772422, 2130772419);
        return;
        popBackStack();
      }
    }
    catch (MailListFragment.NullFolderException localNullFolderException)
    {
      break label111;
    }
  }
  
  private void gotoAddVipContacts()
  {
    startFragment(new VIPContactsFragment());
  }
  
  private void initTopBar()
  {
    this.topbar = ((QMTopBar)findViewById(2131374722));
    if (this.isFromMailList) {
      this.topbar.setButtonLeftIcon(2130841088);
    }
    for (;;)
    {
      this.topbar.setTitle(getString(2131695181));
      this.topbar.setCenterOnclickListener(new VIPContactsIndexFragment.7(this));
      this.topbar.getButtonLeft().setOnClickListener(new VIPContactsIndexFragment.8(this));
      return;
      this.topbar.setButtonLeftBack();
    }
  }
  
  private void initView()
  {
    this.listView = ((ListView)findViewById(2131382012));
    this.loadingView = ((QMContentLoadingView)findViewById(2131370545));
    this.noneVipContactView = ((LinearLayout)findViewById(2131372452));
    this.addVipContactsBtn = ((Button)findViewById(2131362245));
    View localView = new View(this.listView.getContext());
    localView.setMinimumHeight(getResources().getDimensionPixelSize(2131297598));
    this.listView.addHeaderView(localView);
    this.addVipContactsBtn.setOnClickListener(new VIPContactsIndexFragment.9(this));
  }
  
  private void loadVipContact()
  {
    Iterator localIterator = AccountManager.shareInstance().getAccountList().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Account)localIterator.next();
      if (((Account)localObject).isQQMail())
      {
        QMContactManager.sharedInstance().loadQQVipContacts(((Account)localObject).getId());
      }
      else
      {
        QMContactManager localQMContactManager = QMContactManager.sharedInstance();
        int i = ((Account)localObject).getId();
        localObject = MailContact.ContactType.ProtocolContact;
        localQMContactManager.loadAccountContactsByType(new int[] { i }, new MailContact.ContactType[] { localObject });
      }
    }
  }
  
  private void showListView()
  {
    this.loadingView.hide();
    this.noneVipContactView.setVisibility(8);
    this.listView.setVisibility(0);
    this.adapter.setVipContacts(this.vipLists);
    this.adapter.notifyDataSetChanged();
  }
  
  private void showLoadingView()
  {
    this.noneVipContactView.setVisibility(8);
    this.listView.setVisibility(8);
    this.loadingView.showLoading(true);
  }
  
  private void showNoneVipContactView()
  {
    this.loadingView.hide();
    this.listView.setVisibility(8);
    this.noneVipContactView.setVisibility(0);
  }
  
  public QMTopBar getTopBar()
  {
    return null;
  }
  
  public void initDataSource()
  {
    this.vipLists = new ArrayList();
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initTopBar();
    initView();
    showLoadingView();
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    return LayoutInflater.from(getActivity()).inflate(2131563320, null, false);
  }
  
  public void onBackPressed()
  {
    backToPreviousActivity();
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.vipContactWatcher, paramBoolean);
    Watchers.bind(this.loadContactListWatcher, paramBoolean);
    Watchers.bind(this.vipContactListWatcher, paramBoolean);
    Watchers.bind(this.syncPhotoWatcher, paramBoolean);
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return !this.isFromMailList;
  }
  
  public BaseFragment.TransitionConfig onFetchTransaction()
  {
    if (this.isFromMailList) {
      return SCALE_TRANSITION_CONFIG;
    }
    return SLIDE_TRANSITION_CONFIG;
  }
  
  public void onRelease()
  {
    if (this.vipLists != null)
    {
      this.vipLists.clear();
      this.vipLists = null;
    }
    this.adapter = null;
    this.listView.setAdapter(null);
  }
  
  public int refreshData()
  {
    this.vipLists = QMContactManager.sharedInstance().getVipLists();
    if (this.adapter == null)
    {
      this.adapter = new VIPContactsIndexAdapter(getActivity(), this.vipLists);
      this.listView.setAdapter(this.adapter);
      this.listView.setOnItemClickListener(this.onContactItemClick);
      this.listView.setOnItemLongClickListener(this.onContactItemLongClick);
    }
    if (!this.hasSyncVipList) {
      loadVipContact();
    }
    return 0;
  }
  
  public void render(int paramInt)
  {
    if (this.vipLists.size() > 0)
    {
      showListView();
      return;
    }
    if (this.hasSyncVipList)
    {
      showNoneVipContactView();
      return;
    }
    showLoadingView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsIndexFragment
 * JD-Core Version:    0.7.0.1
 */