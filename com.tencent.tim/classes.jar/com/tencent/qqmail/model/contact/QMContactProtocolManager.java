package com.tencent.qqmail.model.contact;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.qmdomain.ContactCustom;
import com.tencent.qqmail.model.qmdomain.ContactEmail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import com.tencent.qqmail.protobuf.ByteString;
import com.tencent.qqmail.protocol.CloudProtocolHelper;
import com.tencent.qqmail.protocol.CloudProtocolInfo;
import com.tencent.qqmail.protocol.CloudProtocolService;
import com.tencent.qqmail.protocol.UMA.ContactCreateInfo;
import com.tencent.qqmail.protocol.UMA.ContactDelInfo;
import com.tencent.qqmail.protocol.UMA.ContactSyncKeyDomain;
import com.tencent.qqmail.protocol.UMA.Contacts;
import com.tencent.qqmail.protocol.UMA.ContactsCustomInfo;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class QMContactProtocolManager
{
  private static final String TAG = "QMContactProtocolManager";
  private QMMailSQLiteHelper sqliteHelper;
  
  public QMContactProtocolManager(QMMailSQLiteHelper paramQMMailSQLiteHelper)
  {
    this.sqliteHelper = paramQMMailSQLiteHelper;
  }
  
  private ArrayList<MailContact> filterIllegalCidContact(ArrayList<MailContact> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        MailContact localMailContact = (MailContact)paramArrayList.next();
        if ((localMailContact.getCid() != null) && (!localMailContact.getCid().equals("0"))) {
          localArrayList.add(localMailContact);
        }
      }
    }
    return localArrayList;
  }
  
  private boolean isContainContact(ArrayList<MailContact> paramArrayList, MailContact paramMailContact)
  {
    if (paramMailContact != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        MailContact localMailContact = (MailContact)paramArrayList.next();
        if ((localMailContact.getCid() != null) && (paramMailContact.getCid() != null) && (localMailContact.getAccountId() == paramMailContact.getAccountId()) && (localMailContact.getCid().equals(paramMailContact.getCid()))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private Contacts transformMailContactToProtocolContact(MailContact paramMailContact)
  {
    Contacts localContacts = new Contacts();
    int i;
    label73:
    label99:
    Object localObject2;
    if (StringExtention.isNullOrEmpty(paramMailContact.getCid()))
    {
      i = 0;
      localContacts.cid = i;
      localContacts.tid = 0;
      localContacts.contact_type = MailContact.ContactType.ProtocolContact.ordinal();
      localContacts.isvip = paramMailContact.isVip();
      if (paramMailContact.getName() != null) {
        break label240;
      }
      localObject1 = new ByteString("".getBytes());
      localContacts.name = ((ByteString)localObject1);
      if (paramMailContact.getNick() != null) {
        break label258;
      }
      localObject1 = new ByteString("".getBytes());
      localContacts.nick = ((ByteString)localObject1);
      localObject2 = localContacts.mark;
      if (paramMailContact.getMark() != null) {
        break label276;
      }
      localObject1 = new ByteString("".getBytes());
      label132:
      ((LinkedList)localObject2).add(localObject1);
      if (paramMailContact.getPinyin() != null) {
        break label294;
      }
    }
    label258:
    label276:
    label294:
    for (Object localObject1 = new ByteString("".getBytes());; localObject1 = new ByteString(paramMailContact.getPinyin().getBytes()))
    {
      localContacts.pinyin = ((ByteString)localObject1);
      localContacts.isdel = 0;
      localObject1 = paramMailContact.getEmails().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = new ByteString(((ContactEmail)((Iterator)localObject1).next()).getEmail().getBytes());
        localContacts.email_address.add(localObject2);
      }
      i = Integer.valueOf(paramMailContact.getCid()).intValue();
      break;
      label240:
      localObject1 = new ByteString(paramMailContact.getName().getBytes());
      break label73;
      localObject1 = new ByteString(paramMailContact.getNick().getBytes());
      break label99;
      localObject1 = new ByteString(paramMailContact.getMark().getBytes());
      break label132;
    }
    paramMailContact = paramMailContact.getCustoms().iterator();
    while (paramMailContact.hasNext())
    {
      localObject1 = (ContactCustom)paramMailContact.next();
      switch (((ContactCustom)localObject1).getType())
      {
      default: 
        break;
      case 0: 
      case 4: 
        localObject2 = new ContactsCustomInfo();
        ((ContactsCustomInfo)localObject2).custom_info_value = new ByteString(((ContactCustom)localObject1).getValue().getBytes());
        ((ContactsCustomInfo)localObject2).custom_info_name = new ByteString(((ContactCustom)localObject1).getKey().getBytes());
        localContacts.custom_infos.add(localObject2);
        break;
      case 2: 
        localContacts.address.add(new ByteString(((ContactCustom)localObject1).getValue().getBytes()));
        break;
      case 1: 
        localContacts.phone_number.add(new ByteString(((ContactCustom)localObject1).getValue().getBytes()));
        break;
      case 3: 
        localContacts.birthday.add(new ByteString(((ContactCustom)localObject1).getValue().getBytes()));
        break;
      case 5: 
        if (((ContactCustom)localObject1).getKey().equals(ContactCustom.QQ_KEY)) {
          localContacts.qq.add(new ByteString(((ContactCustom)localObject1).getValue().getBytes()));
        }
        if (((ContactCustom)localObject1).getKey().equals(ContactCustom.WECHAT_KEY)) {
          localContacts.wechat.add(new ByteString(((ContactCustom)localObject1).getValue().getBytes()));
        }
        break;
      }
    }
    return localContacts;
  }
  
  public void addContact(int paramInt, ArrayList<MailContact> paramArrayList)
  {
    Object localObject1 = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    if (localObject1 == null)
    {
      QMLog.log(6, "QMContactProtocolManager", "add contact account null");
      return;
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      QMLog.log(6, "QMContactProtocolManager", "add contact contact null");
      return;
    }
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(6, "QMContactProtocolManager", "add contact info null");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = paramArrayList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      localArrayList.add(Long.valueOf(((MailContact)((Iterator)localObject2).next()).getId()));
    }
    localCloudProtocolInfo.contact_create_req_ = new ContactCreateInfo();
    localCloudProtocolInfo.contact_create_req_.account_address = ((Account)localObject1).getEmail();
    localCloudProtocolInfo.contact_create_req_.contact_list = new LinkedList();
    localObject1 = paramArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MailContact)((Iterator)localObject1).next();
      localCloudProtocolInfo.contact_create_req_.contact_list.add(transformMailContactToProtocolContact((MailContact)localObject2));
    }
    CloudProtocolService.ContactCreateNewContact(localCloudProtocolInfo, new QMContactProtocolManager.2(this, paramInt, paramArrayList, localArrayList));
  }
  
  public void delContact(int paramInt, ArrayList<Long> paramArrayList, ArrayList<Integer> paramArrayList1)
  {
    Object localObject = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    if (localObject == null)
    {
      QMLog.log(6, "QMContactProtocolManager", "delete contact account null");
      return;
    }
    if ((paramArrayList == null) || (paramArrayList1 == null) || (paramArrayList.size() == 0) || (paramArrayList1.size() == 0))
    {
      QMLog.log(6, "QMContactProtocolManager", "delete contact id null");
      return;
    }
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(6, "QMContactProtocolManager", "delete contact info null");
      return;
    }
    localCloudProtocolInfo.contact_del_req_ = new ContactDelInfo();
    localCloudProtocolInfo.contact_del_req_.account_address = ((Account)localObject).getEmail();
    localCloudProtocolInfo.contact_del_req_.cid = new LinkedList();
    paramArrayList1 = paramArrayList1.iterator();
    while (paramArrayList1.hasNext())
    {
      localObject = (Integer)paramArrayList1.next();
      localCloudProtocolInfo.contact_del_req_.cid.add(localObject);
    }
    CloudProtocolService.ContactDelContactList(localCloudProtocolInfo, new QMContactProtocolManager.4(this, paramInt, paramArrayList));
  }
  
  public void editContact(int paramInt, ArrayList<MailContact> paramArrayList)
  {
    Object localObject = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    if (localObject == null)
    {
      QMLog.log(6, "QMContactProtocolManager", "edit contact account null");
      return;
    }
    paramArrayList = filterIllegalCidContact(paramArrayList);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      QMLog.log(6, "QMContactProtocolManager", "edit contact contact null");
      return;
    }
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(6, "QMContactProtocolManager", "edit contact info null");
      return;
    }
    localCloudProtocolInfo.contact_modify_req_ = new ContactCreateInfo();
    localCloudProtocolInfo.contact_modify_req_.account_address = ((Account)localObject).getEmail();
    localCloudProtocolInfo.contact_modify_req_.contact_list = new LinkedList();
    localObject = paramArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      MailContact localMailContact = (MailContact)((Iterator)localObject).next();
      localCloudProtocolInfo.contact_modify_req_.contact_list.add(transformMailContactToProtocolContact(localMailContact));
    }
    CloudProtocolService.ContactModifyContactInfo(localCloudProtocolInfo, new QMContactProtocolManager.3(this, paramInt, paramArrayList));
  }
  
  public void loadContacts(int paramInt)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    if (localAccount == null)
    {
      QMLog.log(6, "QMContactProtocolManager", "syncContactList account null");
      return;
    }
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(6, "QMContactProtocolManager", "syncContactList info null");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    ContactSyncKeyDomain localContactSyncKeyDomain = new ContactSyncKeyDomain();
    localContactSyncKeyDomain.account_addresses = localAccount.getEmail();
    localContactSyncKeyDomain.sync_key = QMSettingManager.sharedInstance().getContactSyncKey(paramInt, MailContact.ContactType.ProtocolContact);
    localArrayList.add(localContactSyncKeyDomain);
    localCloudProtocolInfo.contact_sync_list_req_ = ((ContactSyncKeyDomain[])localArrayList.toArray(new ContactSyncKeyDomain[localArrayList.size()]));
    CloudProtocolService.ContactSyncContactList(localCloudProtocolInfo, new QMContactProtocolManager.1(this, localAccount, paramInt));
  }
  
  public void searchExchangeGlobalAddressList(int paramInt, String paramString)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    QMMailManager.sharedInstance().searchExchangeAdress(localAccount, paramString);
  }
  
  public MailContact transformProtocolContactToMailContact(int paramInt, Contacts paramContacts)
  {
    MailContact localMailContact = new MailContact();
    localMailContact.setCid(String.valueOf(paramContacts.cid));
    localMailContact.setAccountId(paramInt);
    if (paramContacts.pinyin == null)
    {
      localObject1 = "";
      localMailContact.setPinyin((String)localObject1);
      if (paramContacts.nick != null) {
        break label198;
      }
      localObject1 = "";
      label53:
      localMailContact.setNick((String)localObject1);
      if (paramContacts.name != null) {
        break label216;
      }
      localObject1 = "";
      label69:
      localMailContact.setName((String)localObject1);
      if ((paramContacts.mark != null) && (paramContacts.mark.size() != 0)) {
        break label234;
      }
    }
    Object localObject2;
    label198:
    label216:
    label234:
    for (Object localObject1 = "";; localObject1 = new String(((ByteString)paramContacts.mark.get(0)).getBytes()))
    {
      localMailContact.setMark((String)localObject1);
      localMailContact.setIsVip(paramContacts.isvip);
      localMailContact.setType(MailContact.ContactType.ProtocolContact);
      localObject1 = new ArrayList();
      if (paramContacts.email_address == null) {
        break label259;
      }
      localObject2 = paramContacts.email_address.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add(new ContactEmail(((ByteString)((Iterator)localObject2).next()).toString()));
      }
      localObject1 = new String(paramContacts.pinyin.getBytes());
      break;
      localObject1 = new String(paramContacts.nick.getBytes());
      break label53;
      localObject1 = new String(paramContacts.name.getBytes());
      break label69;
    }
    label259:
    localMailContact.setEmails((ArrayList)localObject1);
    if (((ArrayList)localObject1).size() > 0) {
      localMailContact.setAddress(((ContactEmail)((ArrayList)localObject1).get(0)).getEmail());
    }
    localObject1 = new ArrayList();
    Object localObject3;
    ContactCustom localContactCustom;
    if (paramContacts.custom_infos != null)
    {
      localObject2 = paramContacts.custom_infos.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ContactsCustomInfo)((Iterator)localObject2).next();
        localContactCustom = new ContactCustom();
        localContactCustom.setValue(((ContactsCustomInfo)localObject3).custom_info_value.toString());
        localContactCustom.setKey(((ContactsCustomInfo)localObject3).custom_info_name.toString());
        localContactCustom.setType(0);
        ((ArrayList)localObject1).add(localContactCustom);
      }
    }
    if (paramContacts.address != null)
    {
      localObject2 = paramContacts.address.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ByteString)((Iterator)localObject2).next();
        localContactCustom = new ContactCustom();
        localContactCustom.setKey(ContactCustom.ADDRESS_KEY);
        localContactCustom.setValue(((ByteString)localObject3).toString());
        localContactCustom.setType(2);
        ((ArrayList)localObject1).add(localContactCustom);
      }
    }
    if (paramContacts.phone_number != null)
    {
      localObject2 = paramContacts.phone_number.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ByteString)((Iterator)localObject2).next();
        localContactCustom = new ContactCustom();
        localContactCustom.setKey(ContactCustom.TEL_KEY);
        localContactCustom.setValue(((ByteString)localObject3).toString());
        localContactCustom.setType(1);
        ((ArrayList)localObject1).add(localContactCustom);
      }
    }
    if (paramContacts.birthday != null)
    {
      localObject2 = paramContacts.birthday.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ByteString)((Iterator)localObject2).next();
        localContactCustom = new ContactCustom();
        localContactCustom.setKey(ContactCustom.BIRTHDAY_KEY);
        localContactCustom.setValue(((ByteString)localObject3).toString());
        localContactCustom.setType(3);
        ((ArrayList)localObject1).add(localContactCustom);
      }
    }
    if (paramContacts.qq != null)
    {
      localObject2 = paramContacts.qq.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ByteString)((Iterator)localObject2).next();
        localContactCustom = new ContactCustom();
        localContactCustom.setKey(ContactCustom.QQ_KEY);
        localContactCustom.setValue(((ByteString)localObject3).toString());
        localContactCustom.setType(5);
        ((ArrayList)localObject1).add(localContactCustom);
      }
    }
    if (paramContacts.wechat != null)
    {
      paramContacts = paramContacts.wechat.iterator();
      while (paramContacts.hasNext())
      {
        localObject2 = (ByteString)paramContacts.next();
        localObject3 = new ContactCustom();
        ((ContactCustom)localObject3).setKey(ContactCustom.WECHAT_KEY);
        ((ContactCustom)localObject3).setValue(((ByteString)localObject2).toString());
        ((ContactCustom)localObject3).setType(5);
        ((ArrayList)localObject1).add(localObject3);
      }
    }
    localMailContact.setCustoms((ArrayList)localObject1);
    localMailContact.setHash(MailContact.generateHash(localMailContact));
    localMailContact.setHashType(0);
    localMailContact.setOfflineType(0);
    localMailContact.setId(MailContact.generateId(localMailContact));
    return localMailContact;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.QMContactProtocolManager
 * JD-Core Version:    0.7.0.1
 */