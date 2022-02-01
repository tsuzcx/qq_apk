package com.tencent.qqmail.model.mail;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.alias.AliasItem;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.qmdomain.ComposeData;
import com.tencent.qqmail.model.qmdomain.ComposeData.ComposeDataSender;
import com.tencent.qqmail.trd.guava.Maps;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.CGIManager;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class QMComposeDataManager
{
  public static final String ACCOUNT_CONTACT_INFO_HASH_PREFIX = "account_contact_info_hash";
  public static final String MSG_LOAD_COMPOSEDATA_FAIL = "loadcomposedatafail";
  public static final String MSG_LOAD_COMPOSEDATA_SUCC = "loadcomposedatasucc";
  public static final int TIME_INTERVAL = 60000;
  private static QMComposeDataManager _instance = new QMComposeDataManager();
  private static HashMap<Integer, ArrayList<String>> composeEmailCountCache = ;
  
  public static QMComposeDataManager sharedInstance()
  {
    return _instance;
  }
  
  public List<ComposeData> getAllComposeData()
  {
    Object localObject1 = AccountManager.shareInstance().getAccountList();
    ArrayList localArrayList = new ArrayList();
    if (localObject1 != null)
    {
      localObject1 = ((AccountList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Account)((Iterator)localObject1).next();
        if (((Account)localObject2).isQQMail())
        {
          localObject2 = getComposeData(((Account)localObject2).getId());
          if (localObject2 != null) {
            localArrayList.add(localObject2);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public ArrayList<String> getAllComposeDataCache()
  {
    int[] arrayOfInt = QMContactManager.sharedInstance().getCheckedAccountArray();
    ArrayList localArrayList = new ArrayList();
    int k = arrayOfInt.length;
    int i = 0;
    if (i < k)
    {
      int m = arrayOfInt[i];
      Account localAccount;
      Object localObject2;
      Object localObject1;
      if (m != 0)
      {
        localAccount = AccountManager.shareInstance().getAccountList().getAccountById(m);
        if (localAccount != null)
        {
          if (!localAccount.isQQMail()) {
            break label198;
          }
          localObject2 = (ArrayList)composeEmailCountCache.get(Integer.valueOf(m));
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new ArrayList();
            localObject2 = getComposeData(m);
            if (localObject2 != null) {
              break label138;
            }
            ((ArrayList)localObject1).add(localAccount.getEmail());
          }
          label123:
          localArrayList.addAll((Collection)localObject1);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label138:
        localObject2 = ((ComposeData)localObject2).getItems();
        int j = 0;
        while (j < ((ArrayList)localObject2).size())
        {
          ((ArrayList)localObject1).add(((ComposeData.ComposeDataSender)((ArrayList)localObject2).get(j)).getAlias());
          j += 1;
        }
        composeEmailCountCache.put(Integer.valueOf(m), localArrayList);
        break label123;
        label198:
        localArrayList.add(localAccount.getEmail());
      }
    }
    return localArrayList;
  }
  
  public ComposeData getComposeData(int paramInt)
  {
    Object localObject = QMSettingManager.sharedInstance().getComposeData(paramInt);
    if (StringUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    localObject = (JSONObject)JSONReader.parse((String)localObject);
    if ((localObject != null) && (StringUtils.equals((String)((JSONObject)localObject).get("class"), "ComposeData")))
    {
      ComposeData localComposeData = new ComposeData();
      localComposeData.parseWithDictionary((JSONObject)localObject);
      localComposeData.setAccountId(paramInt);
      return localComposeData;
    }
    return null;
  }
  
  public String[] getQMAlias(int paramInt)
  {
    Object localObject = getComposeData(paramInt);
    if (localObject == null) {
      return null;
    }
    localObject = ((ComposeData)localObject).getItems();
    String[] arrayOfString = new String[((ArrayList)localObject).size()];
    paramInt = 0;
    while (paramInt < ((ArrayList)localObject).size())
    {
      arrayOfString[paramInt] = ((ComposeData.ComposeDataSender)((ArrayList)localObject).get(paramInt)).getAlias();
      paramInt += 1;
    }
    return arrayOfString;
  }
  
  public boolean getQMAliasIndep(String paramString, int paramInt)
  {
    Object localObject = getComposeData(paramInt);
    if (localObject == null) {
      return false;
    }
    localObject = ((ComposeData)localObject).getItems().iterator();
    while (((Iterator)localObject).hasNext())
    {
      ComposeData.ComposeDataSender localComposeDataSender = (ComposeData.ComposeDataSender)((Iterator)localObject).next();
      if (localComposeDataSender.getAlias().equals(paramString)) {
        return localComposeDataSender.getSignvalid().equals("1");
      }
    }
    return false;
  }
  
  public AliasItem[] getQMAliasItems(int paramInt)
  {
    Object localObject = getComposeData(paramInt);
    if (localObject == null) {
      return null;
    }
    localObject = ((ComposeData)localObject).getItems();
    AliasItem[] arrayOfAliasItem = new AliasItem[((ArrayList)localObject).size()];
    int i = 0;
    while (i < ((ArrayList)localObject).size())
    {
      arrayOfAliasItem[i] = new AliasItem();
      arrayOfAliasItem[i].initByComposeData((ComposeData.ComposeDataSender)((ArrayList)localObject).get(i), paramInt);
      i += 1;
    }
    return arrayOfAliasItem;
  }
  
  public String getQMAliasNick(String paramString, int paramInt)
  {
    Object localObject = getComposeData(paramInt);
    if (localObject == null) {
      return null;
    }
    localObject = ((ComposeData)localObject).getItems().iterator();
    while (((Iterator)localObject).hasNext())
    {
      ComposeData.ComposeDataSender localComposeDataSender = (ComposeData.ComposeDataSender)((Iterator)localObject).next();
      if (localComposeDataSender.getAlias().equals(paramString)) {
        return localComposeDataSender.getNick();
      }
    }
    return "";
  }
  
  public String getQMAliasNickByIndep(String paramString, int paramInt)
  {
    ComposeData localComposeData = getComposeData(paramInt);
    if (localComposeData == null) {
      return null;
    }
    Iterator localIterator = localComposeData.getItems().iterator();
    while (localIterator.hasNext())
    {
      ComposeData.ComposeDataSender localComposeDataSender = (ComposeData.ComposeDataSender)localIterator.next();
      if (localComposeDataSender.getAlias().equals(paramString))
      {
        if (localComposeDataSender.getSignvalid().equals("1")) {
          return localComposeDataSender.getNick();
        }
        return localComposeData.getDefaultNick();
      }
    }
    return "";
  }
  
  public String getQMDefaultAlias(int paramInt)
  {
    ComposeData localComposeData = getComposeData(paramInt);
    if (localComposeData == null) {
      return null;
    }
    return localComposeData.getDefaultName();
  }
  
  public String getQMDefaultNick(int paramInt)
  {
    ComposeData localComposeData = getComposeData(paramInt);
    if (localComposeData == null) {
      return null;
    }
    return localComposeData.getDefaultNick();
  }
  
  public void loadComposeData(int paramInt)
  {
    ComposeData localComposeData = getComposeData(paramInt);
    if (localComposeData != null)
    {
      long l2 = new Date().getTime();
      if (localComposeData.getDatetime() != null) {}
      for (long l1 = localComposeData.getDatetime().getTime(); l2 - l1 < 60000L; l1 = 0L)
      {
        QMNotification.postNotification("loadcomposedatasucc", localComposeData);
        return;
      }
    }
    localComposeData = new ComposeData();
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new QMComposeDataManager.4(this, localComposeData, paramInt));
    localQMCallback.setOnError(new QMComposeDataManager.5(this));
    localQMCallback.setOnComplete(new QMComposeDataManager.6(this));
    CGIManager.httpGet(paramInt, "getcomposedata", "&t=compose_data_json&fun=compose", localQMCallback);
  }
  
  public void loadComposeDataThroughNetwork(int paramInt, ICallBack paramICallBack1, ICallBack paramICallBack2)
  {
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new QMComposeDataManager.1(this, paramInt, paramICallBack1, paramICallBack2));
    localQMCallback.setOnError(new QMComposeDataManager.2(this, paramICallBack2));
    localQMCallback.setOnComplete(new QMComposeDataManager.3(this));
    CGIManager.httpGet(paramInt, "getcomposedata", "&t=compose_data_json&fun=compose", localQMCallback);
  }
  
  protected void saveComposeData(int paramInt, ComposeData paramComposeData)
  {
    QMSettingManager.sharedInstance().setComposeData(paramInt, paramComposeData.toString());
    QMContactManager.sharedInstance().updateNickNameCacheByComposeData(paramComposeData);
  }
  
  public void setQMAliasIndep(int paramInt, String paramString, boolean paramBoolean)
  {
    ComposeData localComposeData = getComposeData(paramInt);
    if (localComposeData == null) {
      return;
    }
    Object localObject = localComposeData.getItems();
    int i = 0;
    for (;;)
    {
      if (i < ((ArrayList)localObject).size())
      {
        if (!((ComposeData.ComposeDataSender)((ArrayList)localObject).get(i)).getAlias().equals(paramString)) {
          break label96;
        }
        localObject = (ComposeData.ComposeDataSender)localComposeData.getItems().get(i);
        if (!paramBoolean) {
          break label89;
        }
      }
      label89:
      for (paramString = "1";; paramString = "0")
      {
        ((ComposeData.ComposeDataSender)localObject).setSignvalid(paramString);
        saveComposeData(paramInt, localComposeData);
        return;
      }
      label96:
      i += 1;
    }
  }
  
  public void setQMAliasNick(int paramInt, String paramString1, String paramString2)
  {
    ComposeData localComposeData = getComposeData(paramInt);
    if (localComposeData == null) {
      return;
    }
    ArrayList localArrayList = localComposeData.getItems();
    int i = 0;
    for (;;)
    {
      if (i < localArrayList.size())
      {
        if (((ComposeData.ComposeDataSender)localArrayList.get(i)).getAlias().equals(paramString1)) {
          ((ComposeData.ComposeDataSender)localComposeData.getItems().get(i)).setNick(paramString2);
        }
      }
      else
      {
        saveComposeData(paramInt, localComposeData);
        return;
      }
      i += 1;
    }
  }
  
  public void setQMDefaultAlias(int paramInt, String paramString)
  {
    ComposeData localComposeData = getComposeData(paramInt);
    if (localComposeData == null) {
      return;
    }
    localComposeData.setDefaultName(paramString);
    saveComposeData(paramInt, localComposeData);
  }
  
  public void setQMDefaultNick(int paramInt, String paramString)
  {
    ComposeData localComposeData = getComposeData(paramInt);
    if (localComposeData == null) {
      return;
    }
    localComposeData.setDefaultNick(paramString);
    saveComposeData(paramInt, localComposeData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMComposeDataManager
 * JD-Core Version:    0.7.0.1
 */