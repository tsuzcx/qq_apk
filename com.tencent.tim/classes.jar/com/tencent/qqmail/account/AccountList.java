package com.tencent.qqmail.account;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.model.mail.QMComposeDataManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.trd.guava.Ints;
import com.tencent.qqmail.utilities.QMMath;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class AccountList
  implements Iterable<Account>
{
  @NonNull
  private final ArrayList<Account> accounts;
  @NonNull
  private final SparseArray<Account> accountsHashMap;
  
  public AccountList()
  {
    this(new ArrayList());
  }
  
  public AccountList(@NonNull ArrayList<Account> paramArrayList)
  {
    this.accounts = paramArrayList;
    this.accountsHashMap = new SparseArray();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Account localAccount = (Account)paramArrayList.next();
      this.accountsHashMap.put(localAccount.getId(), localAccount);
    }
  }
  
  public AccountList(@NonNull Account... paramVarArgs)
  {
    this(toList(paramVarArgs));
  }
  
  private static ArrayList<Account> toList(Account[] paramArrayOfAccount)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfAccount.length);
    int j = paramArrayOfAccount.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfAccount[i]);
      i += 1;
    }
    return localArrayList;
  }
  
  public boolean contains(Account paramAccount)
  {
    return this.accounts.contains(paramAccount);
  }
  
  @NonNull
  public Account get(int paramInt)
  {
    return (Account)this.accounts.get(paramInt);
  }
  
  @Nullable
  public boolean[] getAccountAttr(int paramInt, int[] paramArrayOfInt)
  {
    Account localAccount = getAccountById(paramInt);
    if (localAccount == null) {
      return null;
    }
    boolean[] arrayOfBoolean = new boolean[paramArrayOfInt.length];
    int i = localAccount.getAttr();
    paramInt = 0;
    if (paramInt < paramArrayOfInt.length)
    {
      if ((paramArrayOfInt[paramInt] & i) != 0) {}
      for (int j = 1;; j = 0)
      {
        arrayOfBoolean[paramInt] = j;
        paramInt += 1;
        break;
      }
    }
    return arrayOfBoolean;
  }
  
  @Nullable
  public Account getAccountByEmail(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = this.accounts.iterator();
    while (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      if (paramString.equals(localAccount.getEmail())) {
        return localAccount;
      }
    }
    return null;
  }
  
  @Nullable
  public Account getAccountById(int paramInt)
  {
    return (Account)this.accountsHashMap.get(paramInt);
  }
  
  @NonNull
  public HashMap<String, Account> getAddressMap()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.accounts.iterator();
    if (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      if (localAccount.isQQMail()) {}
      for (String str = localAccount.getUin();; str = localAccount.getEmail())
      {
        localHashMap.put(str, localAccount);
        break;
      }
    }
    return localHashMap;
  }
  
  @NonNull
  public int[] getAllGMailAccountIds()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.accounts.iterator();
    while (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      if (localAccount.isGMail()) {
        localArrayList.add(Integer.valueOf(localAccount.getId()));
      }
    }
    return Ints.toArray(localArrayList);
  }
  
  @Nullable
  public QQMailAccount getDefaultBottleAccount()
  {
    Account localAccount = getAccountById(QMSettingManager.sharedInstance().getDefaultBottleAccountID());
    if ((localAccount instanceof QQMailAccount)) {
      return (QQMailAccount)localAccount;
    }
    return null;
  }
  
  @Nullable
  public QQMailAccount getDefaultFtnAccount()
  {
    Account localAccount = getAccountById(QMSettingManager.sharedInstance().getDefaultFtnAccountID());
    if ((localAccount instanceof QQMailAccount)) {
      return (QQMailAccount)localAccount;
    }
    return null;
  }
  
  @Nullable
  public Account getDefaultMailAccount()
  {
    return getAccountById(QMSettingManager.sharedInstance().getDefaultMailAccountID());
  }
  
  @NonNull
  public String getDefaultNickName()
  {
    Object localObject = "";
    Account localAccount = getDefaultMailAccount();
    String str;
    if (localAccount != null)
    {
      if (localAccount.isQQMail()) {
        break label60;
      }
      str = QMSettingManager.sharedInstance().getAccountNick(localAccount.getId());
      if (str != null)
      {
        localObject = str;
        if (!str.equals("")) {}
      }
      else
      {
        QMPrivateProtocolManager.sharedInstance().syncAccountNick(localAccount.getEmail());
        localObject = "";
      }
    }
    label60:
    do
    {
      return localObject;
      localObject = QMComposeDataManager.sharedInstance().getQMDefaultAlias(localAccount.getId());
      str = QMComposeDataManager.sharedInstance().getQMAliasNickByIndep((String)localObject, localAccount.getId());
      if (str == null) {
        break;
      }
      localObject = str;
    } while (str.length() != 0);
    return "";
  }
  
  @Nullable
  public QQMailAccount getDefaultNoteAccount()
  {
    Account localAccount = getAccountById(QMSettingManager.sharedInstance().getDefaultNoteAccountID());
    if ((localAccount instanceof QQMailAccount)) {
      return (QQMailAccount)localAccount;
    }
    return null;
  }
  
  @Nullable
  public QQMailAccount getDefaultQQAccount()
  {
    Iterator localIterator = this.accounts.iterator();
    while (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      if ((localAccount instanceof QQMailAccount)) {
        return (QQMailAccount)localAccount;
      }
    }
    return null;
  }
  
  @Nullable
  public Account getFirstQQAccount()
  {
    Iterator localIterator = this.accounts.iterator();
    while (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      if (localAccount.isQQMail()) {
        return localAccount;
      }
    }
    return null;
  }
  
  @Nullable
  public QQMailAccount getFirstQQMailAccount()
  {
    Iterator localIterator = this.accounts.iterator();
    while (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      if (((localAccount instanceof QQMailAccount)) && (!localAccount.isBizMail())) {
        return (QQMailAccount)localAccount;
      }
    }
    return null;
  }
  
  @Nullable
  public String getFolderListSyncKey(int paramInt)
  {
    Object localObject = getAccountById(paramInt);
    if (localObject == null) {
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = ((Account)localObject).getFolderListSyncKey();
      if (str == null) {
        break;
      }
      localObject = str;
    } while (!StringUtils.trim(str).equals(""));
    return "0";
  }
  
  @NonNull
  public HashMap<Integer, String> getFolderListSyncKeyMap()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.accounts.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Account)localIterator.next()).getId();
      localHashMap.put(Integer.valueOf(i), getFolderListSyncKey(i));
    }
    return localHashMap;
  }
  
  public String getHashAccountPwd(int paramInt)
  {
    Account localAccount = getAccountById(paramInt);
    if (localAccount == null) {
      return "";
    }
    return String.valueOf(QMMath.hashInt(localAccount.getPwd() + localAccount.getSecondPassword()));
  }
  
  public int getPureQQMailAccountNumber()
  {
    Iterator localIterator = this.accounts.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      if ((!localAccount.isQQMail()) || (localAccount.isBizMail())) {
        break label52;
      }
      i += 1;
    }
    label52:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  @NonNull
  public List<QQMailAccount> getQQAccountList()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.accounts.iterator();
    while (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      if ((localAccount instanceof QQMailAccount)) {
        localArrayList.add((QQMailAccount)localAccount);
      }
    }
    return localArrayList;
  }
  
  @Nullable
  public QQMailAccount getQQMailAccountByUin(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = this.accounts.iterator();
    while (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      if (((localAccount instanceof QQMailAccount)) && (localAccount.getUin().equals(paramString))) {
        return (QQMailAccount)localAccount;
      }
    }
    return null;
  }
  
  public int getQQMailAccountNumber()
  {
    Iterator localIterator = this.accounts.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((Account)localIterator.next()).isQQMail()) {
        break label43;
      }
      i += 1;
    }
    label43:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public boolean hasAccount(int paramInt)
  {
    return this.accountsHashMap.indexOfKey(paramInt) >= 0;
  }
  
  public boolean hasAccounts()
  {
    return !this.accounts.isEmpty();
  }
  
  public boolean hasMultiAccounts()
  {
    return this.accounts.size() > 1;
  }
  
  public boolean hasProtocolAccount()
  {
    Iterator localIterator = this.accounts.iterator();
    while (localIterator.hasNext()) {
      if (!((Account)localIterator.next()).isQQMail()) {
        return true;
      }
    }
    return false;
  }
  
  public boolean hasQQMailAccounts()
  {
    Iterator localIterator = this.accounts.iterator();
    while (localIterator.hasNext()) {
      if (((Account)localIterator.next()).isQQMail()) {
        return true;
      }
    }
    return false;
  }
  
  public boolean hasQQNotBizAccounts()
  {
    Iterator localIterator = this.accounts.iterator();
    while (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      if ((localAccount.isQQMail()) && (!localAccount.isBizMail())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isAccountLocked(int paramInt)
  {
    Account localAccount = getAccountById(paramInt);
    return (localAccount != null) && (localAccount.isLocked());
  }
  
  public boolean isDefaultMailAccount(int paramInt)
  {
    return (getDefaultMailAccount() != null) && (getDefaultMailAccount().getId() == paramInt);
  }
  
  public boolean isEmpty()
  {
    return this.accounts.isEmpty();
  }
  
  public boolean isExistEmail(String paramString)
  {
    Iterator localIterator = this.accounts.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      if ((localAccount.getEmail() == null) || (!localAccount.getEmail().equals(paramString))) {
        break label57;
      }
      bool = true;
    }
    label57:
    for (;;)
    {
      break;
      return bool;
    }
  }
  
  public boolean isExistQQAccount(String paramString)
  {
    Iterator localIterator = this.accounts.iterator();
    while (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      if ((localAccount.isQQMail()) && (localAccount.getUin().equals(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isLoginQQAccount()
  {
    boolean bool = false;
    Iterator localIterator = this.accounts.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((Account)localIterator.next() instanceof QQMailAccount)) {
        break label51;
      }
      i += 1;
    }
    label51:
    for (;;)
    {
      break;
      if (i > 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public boolean isQQMailAccount(int paramInt)
  {
    if (paramInt == 0) {}
    Account localAccount;
    do
    {
      return false;
      localAccount = getAccountById(paramInt);
    } while ((localAccount == null) || (!localAccount.isQQMail()));
    return true;
  }
  
  public boolean isSyncVirtualAccount(String paramString)
  {
    paramString = getAccountByEmail(paramString);
    if (paramString == null) {
      return false;
    }
    return "-1".equals(paramString.getPwd());
  }
  
  public Iterator<Account> iterator()
  {
    return new AccountListIterator(null);
  }
  
  public int size()
  {
    return this.accounts.size();
  }
  
  @NonNull
  public ArrayList<Account> toArrayList()
  {
    return new ArrayList(this.accounts);
  }
  
  public String toString()
  {
    return "hashcode:" + hashCode() + ", " + this.accounts.toString();
  }
  
  class AccountListIterator
    implements Iterator<Account>
  {
    private int index = 0;
    
    private AccountListIterator() {}
    
    public boolean hasNext()
    {
      return this.index < AccountList.this.accounts.size();
    }
    
    public Account next()
    {
      ArrayList localArrayList = AccountList.this.accounts;
      int i = this.index;
      this.index = (i + 1);
      return (Account)localArrayList.get(i);
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.AccountList
 * JD-Core Version:    0.7.0.1
 */