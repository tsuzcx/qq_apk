package com.tencent.qqmail.activity.contacts.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.model.contact.cursor.ContactHistoryMailCursor;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.cursor.IMailListCursor;
import com.tencent.qqmail.model.mail.cursor.QMSearchCursor;
import com.tencent.qqmail.model.mail.watcher.SearchMailWatcher;
import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.ContactEmail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import moai.core.watcher.Watchers;
import org.apache.commons.lang3.StringUtils;

public class ContactsHistoryMailListFragment
  extends ContactsBaseFragment
{
  private static final int REQUEST_SELECT_RESULT = 1;
  private static final String TAG = ContactsHistoryMailListFragment.class.getSimpleName();
  private AccountList accounts;
  private ArrayList<String> allContactEmails;
  private SyncPhotoWatcher avatarWatcher = new ContactsHistoryMailListFragment.2(this);
  private MailContact contact;
  private boolean isMoreLoading = false;
  private ContactHistoryMailCursor listCursor;
  private ListView listView;
  private ContactsHistoryMailListAdapter mAdapter;
  private QMContentLoadingView mEmptyView;
  private long[] mMailIds;
  private SearchMailWatcher searchMailWatcher = new ContactsHistoryMailListFragment.1(this);
  private ArrayList<String> selectContactEmails;
  private QMTopBar topBar;
  
  public ContactsHistoryMailListFragment(MailContact paramMailContact)
  {
    super(true);
    this.contact = paramMailContact;
  }
  
  private QMSearchCursor getDataSource()
  {
    return this.listCursor;
  }
  
  private String getTitleName()
  {
    Object localObject2 = this.contact.getName();
    Object localObject1 = localObject2;
    if (StringUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.contact.getAddress();
    }
    int j = 0;
    int i = 0;
    for (;;)
    {
      localObject2 = localObject1;
      if (j < ((String)localObject1).length())
      {
        int k = Character.codePointAt((CharSequence)localObject1, j);
        if ((k < 0) || (k > 255)) {
          break label105;
        }
        i += 1;
      }
      while (i > 8)
      {
        localObject2 = ((String)localObject1).substring(0, j) + "...";
        return localObject2;
        label105:
        i += 2;
      }
      j += 1;
    }
  }
  
  private void initListView()
  {
    this.listView.setOnScrollListener(new ContactsHistoryMailListFragment.6(this));
    this.listView.setOnItemClickListener(new ContactsHistoryMailListFragment.7(this));
  }
  
  private void initTopBar()
  {
    this.topBar = getTopBar();
    String str = getTitleName();
    this.topBar.setTitle(String.format(getString(2131692084), new Object[] { str }));
    this.topBar.setButtonLeftBack();
    this.topBar.getButtonLeft().setOnClickListener(new ContactsHistoryMailListFragment.3(this));
    if ((AccountManager.shareInstance().getAccountList().size() > 1) || (this.allContactEmails.size() > 1))
    {
      this.topBar.setButtonRightNormal(2131719405);
      this.topBar.getButtonRight().setOnClickListener(new ContactsHistoryMailListFragment.4(this));
    }
    this.topBar.setCenterOnclickListener(new ContactsHistoryMailListFragment.5(this));
  }
  
  private void prepareHistoryMailList(Runnable paramRunnable)
  {
    if ((this.selectContactEmails.size() == 0) || (this.accounts.size() == 0))
    {
      this.mEmptyView.showTips(2131692059);
      this.mEmptyView.setVisibility(0);
      this.listView.setVisibility(8);
      return;
    }
    this.listView.setVisibility(0);
    if (this.listCursor != null) {
      this.listCursor.setSearchInfo(this.mMailIds, (ArrayList)this.selectContactEmails.clone(), this.accounts.toArrayList());
    }
    if (this.mAdapter != null)
    {
      this.mAdapter.update(paramRunnable);
      this.mAdapter.notifyDataSetChanged();
      return;
    }
    this.mAdapter = new ContactsHistoryMailListAdapter(getActivity(), 0, getDataSource(), this.listView);
    resetAdapter();
    this.listView.setAdapter(this.mAdapter);
  }
  
  private void prepareListView()
  {
    prepareHistoryMailList(new ContactsHistoryMailListFragment.8(this));
  }
  
  private void renderList()
  {
    if ((this.listCursor == null) || ((this.listCursor.getCount() == 0) && (!this.listCursor.canSearchRemote())))
    {
      showEmptyView();
      return;
    }
    if ((this.listCursor.getCount() == 0) && (this.mAdapter.hasMoreMail()) && (this.listCursor.canSearchRemote()))
    {
      this.isMoreLoading = true;
      this.mAdapter.setMoreLoading(true);
      this.mAdapter.getCursor().loadMore();
      this.mAdapter.notifyDataSetChanged();
      return;
    }
    this.mEmptyView.hide();
    if (getTopBar().getButtonRight() != null) {
      getTopBar().getButtonRight().setVisibility(0);
    }
    this.listView.setVisibility(0);
  }
  
  private void resetAdapter()
  {
    this.isMoreLoading = false;
    if (this.mAdapter != null)
    {
      this.mAdapter.setMoreLoading(false);
      this.mAdapter.setError(false);
      this.mAdapter.resetCursor();
      this.mAdapter.notifyDataSetChanged();
    }
  }
  
  private void setDataSource()
  {
    this.listCursor = QMMailManager.sharedInstance().getContactHistoryMailSearchListCursor();
  }
  
  private void showEmptyView()
  {
    this.mEmptyView.showTips(2131692059);
    this.mEmptyView.setVisibility(0);
    this.listView.setVisibility(8);
    if (getTopBar().getButtonRight() != null) {
      getTopBar().getButtonRight().setVisibility(8);
    }
  }
  
  public void initDataSource()
  {
    this.selectContactEmails = new ArrayList();
    this.allContactEmails = new ArrayList();
    this.accounts = AccountManager.shareInstance().getAccountList();
    Iterator localIterator = this.contact.getEmails().iterator();
    while (localIterator.hasNext())
    {
      ContactEmail localContactEmail = (ContactEmail)localIterator.next();
      this.selectContactEmails.add(localContactEmail.getEmail());
      this.allContactEmails.add(localContactEmail.getEmail());
    }
    this.mMailIds = new long[0];
    setDataSource();
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    this.mEmptyView.showLoading(true);
    initListView();
    initTopBar();
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    paramViewHolder = (FrameLayout)super.initUI(paramViewHolder);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131299664), 0, 0);
    View localView = LayoutInflater.from(getActivity()).inflate(2131559085, paramViewHolder, false);
    localView.setLayoutParams(localLayoutParams);
    localView.setVerticalFadingEdgeEnabled(false);
    this.listView = ((ListView)localView.findViewById(2131368547));
    this.mEmptyView = ((QMContentLoadingView)localView.findViewById(2131370545));
    paramViewHolder.addView(localView);
    return paramViewHolder;
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.searchMailWatcher, paramBoolean);
    QMPrivateProtocolManager.sharedInstance().bindSyncPhotoWatcher(this.avatarWatcher, paramBoolean);
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onFragmentResult(int paramInt1, int paramInt2, HashMap<String, Object> paramHashMap)
  {
    int i = 0;
    ArrayList localArrayList1;
    if ((paramInt1 == 1) && (paramInt2 == -1) && (paramHashMap != null))
    {
      localArrayList1 = (ArrayList)paramHashMap.get("ARG_CHECKED_ACCOUNTS_RESULT");
      paramHashMap = (ArrayList)paramHashMap.get("ARG_CHECKED_EMAILS_RESULT");
      if (this.selectContactEmails.size() == paramHashMap.size())
      {
        paramInt2 = 0;
        paramInt1 = 0;
        while (paramInt2 < this.selectContactEmails.size())
        {
          if (!((String)this.selectContactEmails.get(paramInt2)).equals(paramHashMap.get(paramInt2))) {
            paramInt1 = 1;
          }
          paramInt2 += 1;
        }
      }
      for (;;)
      {
        if (paramInt1 != 0) {
          break label294;
        }
        if (localArrayList1.size() != this.accounts.size()) {
          break;
        }
        for (;;)
        {
          paramInt2 = paramInt1;
          if (i >= localArrayList1.size()) {
            break;
          }
          if (((Integer)localArrayList1.get(i)).equals(Integer.valueOf(this.accounts.get(i).getId()))) {
            break label291;
          }
          paramInt1 = 1;
          i += 1;
        }
        paramInt1 = 1;
      }
    }
    label291:
    label294:
    for (paramInt2 = 1;; paramInt2 = paramInt1)
    {
      if (paramInt2 != 0)
      {
        this.selectContactEmails.clear();
        ArrayList localArrayList2 = new ArrayList();
        Iterator localIterator = AccountManager.shareInstance().getAccountList().iterator();
        while (localIterator.hasNext())
        {
          Account localAccount = (Account)localIterator.next();
          if (localArrayList1.contains(Integer.valueOf(localAccount.getId()))) {
            localArrayList2.add(localAccount);
          }
        }
        this.accounts = new AccountList(localArrayList2);
        this.selectContactEmails.addAll(paramHashMap);
        resetAdapter();
        prepareListView();
      }
      return;
      break;
    }
  }
  
  public void onRelease()
  {
    if (this.mAdapter != null) {
      this.mAdapter.destroy();
    }
    Watchers.bind(this.searchMailWatcher, false);
    QMPrivateProtocolManager.sharedInstance().bindSyncPhotoWatcher(this.avatarWatcher, false);
    this.listCursor.release();
    this.listCursor = null;
    this.mAdapter = null;
    this.listView.setAdapter(null);
    this.mMailIds = null;
  }
  
  public int refreshData()
  {
    prepareHistoryMailList(null);
    return 0;
  }
  
  public void render(int paramInt)
  {
    prepareListView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsHistoryMailListFragment
 * JD-Core Version:    0.7.0.1
 */