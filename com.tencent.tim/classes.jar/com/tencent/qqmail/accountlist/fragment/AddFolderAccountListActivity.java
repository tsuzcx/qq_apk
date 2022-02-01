package com.tencent.qqmail.accountlist.fragment;

import android.content.Intent;
import android.util.Pair;
import android.view.View;
import android.widget.ListView;
import androidx.annotation.NonNull;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.accountlist.QMAccountHelper;
import com.tencent.qqmail.folderlist.FolderDataManager;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.folderlist.model.FolderData;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.Iterator;

public class AddFolderAccountListActivity
  extends BaseActivityEx
{
  private static final int FOLDER_CHOSER_REQUEST_CODE = 1;
  public static final String TAG = "AddFolderAccountListActivity";
  private final ArrayList<Pair<Account, ArrayList<Pair<QMFolder, boolean[]>>>> mAccountFolderData = new ArrayList();
  @NonNull
  private AccountList mAccounts = new AccountList();
  private ListView mList;
  private QMTopBar topBar;
  
  private void addCheckedFolders(ArrayList<Pair<Account, QMFolder>> paramArrayList, ArrayList<FolderData> paramArrayList1)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Pair localPair = (Pair)paramArrayList.next();
      paramArrayList1.add(FolderDataManager.generateUnOrderFolderData(((Account)localPair.first).getId(), ((QMFolder)localPair.second).getId(), ((QMFolder)localPair.second).getName(), 0, 0, true, false));
    }
  }
  
  private void addUncheckFolders(ArrayList<Pair<Account, QMFolder>> paramArrayList, ArrayList<FolderData> paramArrayList1)
  {
    Iterator localIterator1 = QMAccountHelper.readActiveFolderFromDB().iterator();
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        return;
      }
      FolderData localFolderData = (FolderData)localIterator1.next();
      Iterator localIterator2 = paramArrayList.iterator();
      if (localIterator2.hasNext())
      {
        Pair localPair = (Pair)localIterator2.next();
        if ((((Account)localPair.first).getId() != localFolderData.getAccountId()) || (((QMFolder)localPair.second).getId() != localFolderData.getFolderId())) {
          break;
        }
        paramArrayList1.add(localFolderData);
        paramArrayList.remove(localPair);
      }
    }
  }
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), AddFolderAccountListActivity.class);
  }
  
  @NonNull
  private ArrayList<Pair<Account, QMFolder>> getCheckStatusChangedPairs()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.mAccountFolderData.iterator();
    while (localIterator1.hasNext())
    {
      Pair localPair1 = (Pair)localIterator1.next();
      Iterator localIterator2 = ((ArrayList)localPair1.second).iterator();
      while (localIterator2.hasNext())
      {
        Pair localPair2 = (Pair)localIterator2.next();
        if (((boolean[])localPair2.second)[0] != 0) {
          localArrayList.add(new Pair(localPair1.first, localPair2.first));
        }
      }
    }
    return localArrayList;
  }
  
  private void update()
  {
    ArrayList localArrayList1 = getCheckStatusChangedPairs();
    ArrayList localArrayList2 = new ArrayList();
    addUncheckFolders(localArrayList1, localArrayList2);
    addCheckedFolders(localArrayList1, localArrayList2);
    QMAccountHelper.saveActiveFolderToDB(localArrayList2, this.mAccounts);
  }
  
  public void finish()
  {
    update();
    setResult(-1);
    super.finish();
  }
  
  public void initDataSource()
  {
    Object localObject1 = AccountManager.shareInstance().getAccountList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = QMAccountHelper.readActiveFolderFromDB();
    localObject1 = ((AccountList)localObject1).iterator();
    Account localAccount;
    ArrayList localArrayList3;
    label78:
    QMFolder localQMFolder;
    boolean bool;
    if (((Iterator)localObject1).hasNext())
    {
      localAccount = (Account)((Iterator)localObject1).next();
      Object localObject2 = QMFolderManager.sharedInstance().getFoldersByAccountId(localAccount.getId());
      localArrayList3 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localQMFolder = (QMFolder)((Iterator)localObject2).next();
          if ((localQMFolder.getType() != 1) && (localQMFolder.getType() != 15))
          {
            Iterator localIterator = localArrayList2.iterator();
            bool = false;
            label127:
            if (localIterator.hasNext())
            {
              FolderData localFolderData = (FolderData)localIterator.next();
              if (localFolderData.getFolderId() != localQMFolder.getId()) {
                break label238;
              }
              bool = localFolderData.isShouldShow();
            }
          }
        }
      }
    }
    label238:
    for (;;)
    {
      break label127;
      localArrayList3.add(new Pair(localQMFolder, new boolean[] { bool }));
      break label78;
      this.mAccountFolderData.add(new Pair(localAccount, localArrayList3));
      localArrayList1.add(localAccount);
      break;
      this.mAccounts = new AccountList(localArrayList1);
      return;
    }
  }
  
  public void initDom()
  {
    this.topBar = ((QMTopBar)findViewById(2131374722));
    this.topBar.setButtonRightBlue(2131693745);
    this.topBar.setTitle(2131689645);
    this.topBar.getButtonRight().setOnClickListener(new AddFolderAccountListActivity.1(this));
    this.mList = ((ListView)findViewById(2131361915));
    AddFolderAccountListActivity.2 local2 = new AddFolderAccountListActivity.2(this, this, 2131559338, 2131367376, this.mAccounts.toArrayList());
    this.mList.setAdapter(local2);
    this.mList.setOnItemClickListener(new AddFolderAccountListActivity.3(this));
  }
  
  public void initUI()
  {
    setContentView(2131558540);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1)) {
      finish();
    }
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.accountlist.fragment.AddFolderAccountListActivity
 * JD-Core Version:    0.7.0.1
 */