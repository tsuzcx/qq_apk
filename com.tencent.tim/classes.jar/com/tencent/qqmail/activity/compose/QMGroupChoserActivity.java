package com.tencent.qqmail.activity.compose;

import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.mail.watcher.LoadGroupContactListWatcher;
import com.tencent.qqmail.model.qmdomain.MailGroupContact;
import com.tencent.qqmail.model.qmdomain.MailGroupContactList;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import com.tencent.qqmail.utilities.ui.QMLoading;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.Iterator;
import java.util.List;
import moai.core.watcher.Watchers;

public class QMGroupChoserActivity
  extends BaseActivityEx
{
  public static final String ARG_ACCOUNT = "ARG_ACCOUNT";
  public static final String ARG_GROUP_CONTACT_ID = "ARG_GROUP_CONTACT_ID";
  public static final String TAG = "QMGroupChoserActivity";
  private LoadGroupContactListWatcher groupContactListWatcher = new QMGroupChoserActivity.1(this);
  @Nullable
  private Account mAccount;
  private TextView mAccountTextView;
  private QMBottomDialog mDialog;
  private QMBaseView mGroupChoserView;
  private UITableView mLoadingTable;
  private MailGroupContactList mMailGroupContactList;
  private List<QQMailAccount> mQQAccList;
  private QMRadioGroup mRadioGroup;
  
  private void changeAccount()
  {
    if (this.mAccount == null)
    {
      finish();
      return;
    }
    this.mAccountTextView.setText(this.mAccount.getEmail());
  }
  
  private void createAccoutView()
  {
    UITableView localUITableView = new UITableView(this);
    this.mGroupChoserView.addContentView(localUITableView);
    localUITableView.setCaption(2131695185);
    localUITableView.commit();
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this).inflate(2131559049, localUITableView, false);
    this.mAccountTextView = ((TextView)localRelativeLayout.findViewById(2131365129));
    localUITableView.addView(localRelativeLayout);
    if (this.mQQAccList.size() > 1) {
      localRelativeLayout.setOnClickListener(new QMGroupChoserActivity.7(this));
    }
  }
  
  public static Intent createIntent(Account paramAccount)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), QMGroupChoserActivity.class);
    localIntent.putExtra("ARG_ACCOUNT", paramAccount.getId());
    return localIntent;
  }
  
  private void createLoadingView()
  {
    if (this.mLoadingTable == null)
    {
      this.mLoadingTable = new UITableView(this);
      this.mLoadingTable.setCaption(2131719317);
      this.mGroupChoserView.addContentView(this.mLoadingTable);
      LinearLayout localLinearLayout = new LinearLayout(this);
      localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131297602)));
      localLinearLayout.setBackgroundResource(2130841255);
      localLinearLayout.setGravity(17);
      this.mLoadingTable.addView(localLinearLayout);
      QMLoading localQMLoading = new QMLoading(getApplicationContext(), QMLoading.SIZE_MINI);
      localQMLoading.setLayoutParams(new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(2131297975), getResources().getDimensionPixelSize(2131297975)));
      localLinearLayout.addView(localQMLoading);
      return;
    }
    setLoadingShow(true);
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(2131694511);
    localQMTopBar.setButtonLeftNormal(2131691246);
    localQMTopBar.setButtonRightBlue(2131696547);
    localQMTopBar.setButtonLeftOnclickListener(new QMGroupChoserActivity.5(this));
    localQMTopBar.setButtonRightOnclickListener(new QMGroupChoserActivity.6(this));
  }
  
  private void loadGroupContactsFromDb(int paramInt)
  {
    MailGroupContactList localMailGroupContactList = QMContactManager.sharedInstance().getGroupContacts(paramInt);
    if ((localMailGroupContactList == null) || (localMailGroupContactList.getGroupContacts() == null)) {
      return;
    }
    this.mMailGroupContactList = localMailGroupContactList;
    Threads.runOnMainThread(new QMGroupChoserActivity.4(this));
    setLoadingShow(false);
  }
  
  private void loadGroupList()
  {
    createLoadingView();
    if (this.mAccount == null)
    {
      finish();
      return;
    }
    loadGroupContactsFromDb(this.mAccount.getId());
    registerLoadGroupList(true);
    Threads.runInBackground(new QMGroupChoserActivity.3(this));
  }
  
  private void registerLoadGroupList(boolean paramBoolean)
  {
    Watchers.bind(this.groupContactListWatcher, paramBoolean);
  }
  
  private void setLoadingShow(boolean paramBoolean)
  {
    Threads.runOnMainThread(new QMGroupChoserActivity.8(this, paramBoolean));
  }
  
  private void showGroupList()
  {
    if (this.mRadioGroup == null)
    {
      this.mRadioGroup = new QMRadioGroup(this);
      this.mGroupChoserView.addContentView(this.mRadioGroup);
    }
    this.mRadioGroup.clear();
    this.mRadioGroup.setCaption(2131719317);
    Object localObject = this.mMailGroupContactList.getGroupContacts();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      int i = 0;
      while (i < ((List)localObject).size())
      {
        this.mRadioGroup.addItem(i, ((MailGroupContact)((List)localObject).get(i)).getName());
        i += 1;
      }
      this.mRadioGroup.commit();
      this.mRadioGroup.setSelectedItem(0);
      return;
    }
    localObject = new TextView(this);
    ((TextView)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131297602)));
    ((TextView)localObject).setBackgroundResource(2130841255);
    ((TextView)localObject).setGravity(17);
    ((TextView)localObject).setText(getResources().getString(2131693992));
    ((TextView)localObject).setTextSize(2, 14.0F);
    ((TextView)localObject).setTextColor(getResources().getColor(2131165857));
    this.mRadioGroup.addView((View)localObject);
  }
  
  public void initDataSource()
  {
    Object localObject1 = getIntent();
    Object localObject2 = AccountManager.shareInstance().getAccountList();
    int i = ((Intent)localObject1).getIntExtra("ARG_ACCOUNT", 0);
    if (i != 0) {}
    for (this.mAccount = ((AccountList)localObject2).getAccountById(i);; this.mAccount = ((AccountList)localObject2).getDefaultQQAccount())
    {
      localObject1 = ((AccountList)localObject2).getQQAccountList();
      this.mQQAccList = Lists.newArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (QQMailAccount)((Iterator)localObject1).next();
        if (!((QQMailAccount)localObject2).isBizMail()) {
          this.mQQAccList.add(localObject2);
        }
      }
    }
  }
  
  public void initDom()
  {
    initTopBar();
    createAccoutView();
    loadGroupList();
    changeAccount();
  }
  
  public void initUI()
  {
    this.mGroupChoserView = initScrollView(this);
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render() {}
  
  public void returnWithData(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    finish();
  }
  
  protected void showAccountChooseDialog()
  {
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(this);
    Iterator localIterator = this.mQQAccList.iterator();
    while (localIterator.hasNext()) {
      localBottomListSheetBuilder.addItem(((QQMailAccount)localIterator.next()).getEmail());
    }
    localBottomListSheetBuilder.setTitle(2131691497);
    localBottomListSheetBuilder.setOnSheetItemClickListener(new QMGroupChoserActivity.2(this));
    this.mDialog = localBottomListSheetBuilder.build();
    this.mDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMGroupChoserActivity
 * JD-Core Version:    0.7.0.1
 */