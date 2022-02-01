package com.tencent.qqmail.activity.vipcontacts;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.fragment.base.QMBaseFragment;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.mail.watcher.LoadContactListWatcher;
import com.tencent.qqmail.model.qmdomain.ContactGroup;
import com.tencent.qqmail.utilities.uitableview.UITableExpandView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import moai.core.watcher.Watchers;
import moai.fragment.app.FragmentManager;
import moai.fragment.base.BaseFragment.TransitionConfig;
import moai.fragment.base.BaseFragmentActivity;

public class VIPContactsOtherFragment
  extends QMBaseFragment
{
  public static final int REQUEST_CODE_LIST = 500;
  public static final String TAG = "ContactsOtherFragment";
  private ArrayList<Account> accounts;
  private QMBaseView baseView;
  private TextView btnAdd;
  private UITableView.ClickListener domainClickListener = new VIPContactsOtherFragment.4(this);
  private UITableView domainContactTableView;
  private ArrayList<ContactGroup> domainGroups;
  private UITableView historyContactTableView;
  private UITableView.ClickListener historyTableClickListener = new VIPContactsOtherFragment.3(this);
  private LoadContactListWatcher loadContactListWatcher = new VIPContactsOtherFragment.1(this);
  private UITableView mobileContactTableView;
  private UITableView.ClickListener mobileTableClickListener = new VIPContactsOtherFragment.2(this);
  private HashMap<Integer, ArrayList<ContactGroup>> qqGroups;
  private QMTopBar topBar;
  
  public VIPContactsOtherFragment()
  {
    super(false);
  }
  
  private void backToIndexFragment()
  {
    getBaseFragmentActivity().getSupportFragmentManager().popBackStack("VIPContactsIndexFragment", 0);
    overridePendingTransition(2130772430, 2130772402);
  }
  
  private void initTopBar()
  {
    this.topBar.setTitle(2131695178);
    this.topBar.setButtonLeftBack();
    this.topBar.getButtonLeft().setOnClickListener(new VIPContactsOtherFragment.5(this));
    this.topBar.setButtonRightBlue(2131689701);
    this.topBar.getButtonRight().setEnabled(false);
    this.topBar.getButtonRight().setOnClickListener(new VIPContactsOtherFragment.6(this));
    this.btnAdd = ((TextView)this.topBar.getButtonRight());
  }
  
  private void refreshAddNumber()
  {
    int i = VIPContactsAdapter.getSelectContacts().size();
    if (i > 0)
    {
      this.btnAdd.setEnabled(true);
      this.btnAdd.setText(getString(2131689701) + "(" + i + ")");
      return;
    }
    this.btnAdd.setEnabled(false);
    this.btnAdd.setText(getString(2131689701));
  }
  
  private void renderDomainTable()
  {
    if (this.domainGroups.size() > 0)
    {
      this.domainContactTableView = new UITableView(getActivity());
      Iterator localIterator = this.domainGroups.iterator();
      while (localIterator.hasNext())
      {
        ContactGroup localContactGroup = (ContactGroup)localIterator.next();
        this.domainContactTableView.addItem(localContactGroup.getName() + "(" + localContactGroup.getCount() + ")");
      }
      this.domainContactTableView.setCaption(2131692031);
      this.domainContactTableView.setClickListener(this.domainClickListener);
      this.domainContactTableView.commit();
      this.baseView.addContentView(this.domainContactTableView);
    }
  }
  
  private void renderHistoryTable()
  {
    if (this.accounts.size() > 0)
    {
      this.historyContactTableView = new UITableView(getActivity());
      Iterator localIterator = this.accounts.iterator();
      while (localIterator.hasNext())
      {
        Account localAccount = (Account)localIterator.next();
        this.historyContactTableView.addItem(localAccount.getEmail());
      }
      this.historyContactTableView.setCaption(getString(2131692083));
      this.historyContactTableView.setClickListener(this.historyTableClickListener);
      this.historyContactTableView.commit();
      this.baseView.addContentView(this.historyContactTableView);
    }
  }
  
  private void renderMobileTable()
  {
    this.mobileContactTableView = new UITableView(getActivity());
    this.mobileContactTableView.addItem(2131692054);
    this.mobileContactTableView.setClickListener(this.mobileTableClickListener);
    this.mobileContactTableView.commit();
    this.baseView.addContentView(this.mobileContactTableView);
  }
  
  private void renderQQGroupTable()
  {
    if (this.qqGroups.size() > 0)
    {
      Iterator localIterator1 = this.qqGroups.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Object localObject = (Map.Entry)localIterator1.next();
        Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(((Integer)((Map.Entry)localObject).getKey()).intValue());
        localObject = (ArrayList)((Map.Entry)localObject).getValue();
        UITableExpandView localUITableExpandView = new UITableExpandView(getActivity());
        Iterator localIterator2 = ((ArrayList)localObject).iterator();
        while (localIterator2.hasNext())
        {
          ContactGroup localContactGroup = (ContactGroup)localIterator2.next();
          localUITableExpandView.addItem(localContactGroup.getName() + "(" + localContactGroup.getCount() + ")");
        }
        localUITableExpandView.setCaption(String.format(getString(2131692068), new Object[] { localAccount.getName() }));
        localUITableExpandView.setClickListener(new VIPContactsOtherFragment.7(this, (ArrayList)localObject));
        localUITableExpandView.commit();
        this.baseView.addContentView(localUITableExpandView);
      }
    }
  }
  
  public QMTopBar getTopBar()
  {
    return null;
  }
  
  public void initDataSource()
  {
    Object localObject = QMContactManager.sharedInstance().getCheckedAccountArray();
    this.accounts = new ArrayList();
    int j = localObject.length;
    int i = 0;
    Account localAccount;
    while (i < j)
    {
      int k = localObject[i];
      localAccount = AccountManager.shareInstance().getAccountList().getAccountById(k);
      if (localAccount != null) {
        this.accounts.add(localAccount);
      }
      i += 1;
    }
    this.qqGroups = new HashMap();
    this.domainGroups = new ArrayList();
    localObject = this.accounts.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localAccount = (Account)((Iterator)localObject).next();
      if (localAccount.isQQMail())
      {
        ArrayList localArrayList = QMContactManager.sharedInstance().getContactGroupByAccountAndGGID(localAccount.getId(), 1);
        if ((localArrayList != null) && (localArrayList.size() != 0)) {
          this.qqGroups.put(Integer.valueOf(localAccount.getId()), localArrayList);
        }
        this.domainGroups.addAll(QMContactManager.sharedInstance().getContactGroupByAccountAndGGID(localAccount.getId(), 2));
      }
    }
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initTopBar();
    renderMobileTable();
    renderHistoryTable();
    renderQQGroupTable();
    renderDomainTable();
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.baseView = new QMBaseView(getActivity());
    this.baseView.initScrollView();
    this.baseView.setBackgroundColor(getResources().getColor(2131167681));
    this.topBar = this.baseView.getTopBar();
    return this.baseView;
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.loadContactListWatcher, paramBoolean);
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public BaseFragment.TransitionConfig onFetchTransaction()
  {
    return SLIDE_TRANSITION_CONFIG;
  }
  
  public BaseFragment.TransitionConfig onFetchTransitionConfig()
  {
    return SLIDE_TRANSITION_CONFIG;
  }
  
  public void onRelease() {}
  
  public int refreshData()
  {
    return 0;
  }
  
  public void render(int paramInt)
  {
    refreshAddNumber();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsOtherFragment
 * JD-Core Version:    0.7.0.1
 */