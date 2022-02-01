package com.tencent.qqmail.activity.contacts;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.contacts.fragment.ContactDetailFragment;
import com.tencent.qqmail.activity.contacts.fragment.ContactEditFragment;
import com.tencent.qqmail.activity.contacts.fragment.ContactsHistoryMailListFragment;
import com.tencent.qqmail.activity.contacts.fragment.ContactsListFragment;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.qmdomain.ContactCustom;
import com.tencent.qqmail.model.qmdomain.ContactEmail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import com.tencent.qqmail.utilities.StatusBarUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import moai.fragment.app.Fragment;
import moai.fragment.app.FragmentManager;
import moai.fragment.app.FragmentTransaction;
import moai.fragment.base.BaseFragmentActivity;

public class ContactsFragmentActivity
  extends BaseFragmentActivity
{
  private static final String ARG_COMPOSE_SELECTED_EMAILS = "arg_compose_selected_emails";
  private static final String ARG_DETAIL_ACCOUNT_ID = "arg_detail_account_id";
  private static final String ARG_DETAIL_ADDRESS = "arg_detail_address";
  private static final String ARG_DETAIL_ADDRESSES = "arg_detail_addresses";
  private static final String ARG_DETAIL_ALTBIRTHDAY = "arg_detail_altbirthday";
  private static final String ARG_DETAIL_ANIVERSARY = "arg_detail_aniversary";
  private static final String ARG_DETAIL_BIRTHDAY = "arg_detail_birthday";
  private static final String ARG_DETAIL_CONTACT_ID = "arg_detail_contact_id";
  private static final String ARG_DETAIL_EMAILS = "arg_detail_emails";
  private static final String ARG_DETAIL_MARK = "arg_detail_mark";
  private static final String ARG_DETAIL_NAME = "arg_detail_name";
  private static final String ARG_DETAIL_NICKNAME = "arg_detail_nickname";
  private static final String ARG_DETAIL_ORG = "arg_detail_org";
  private static final String ARG_DETAIL_PHONES = "arg_detail_phones";
  private static final String ARG_DETAIL_QQ = "arg_detail_qq";
  private static final String ARG_DETAIL_SKYPE = "arg_detail_skype";
  private static final String ARG_DETAIL_TITLE = "arg_detail_title";
  private static final String ARG_DETAIL_TWITTERS = "arg_detail_twitters";
  private static final String ARG_DETAIL_URLS = "arg_detail_urls";
  private static final String ARG_DETAIL_WEIBOS = "arg_detail_weibos";
  private static final String ARG_EDIT_MODE = "arg_edit_mode";
  private static final String ARG_FROM = "arg_from_where";
  private static final String ARG_GO_TO_PLACE = "arg_go_to_place";
  private static final String ARG_NAME_LIST_IS_RECENT_SENDER = "arg_name_list_is_recent_sender";
  private static final String ARG_NAME_LIST_TYPE = "arg_name_list_type";
  public static final String RESULT_SELECT_CONTACT_EMAILS = "result_select_contact_emails";
  public static final String RESULT_SELECT_CONTACT_IDS = "result_select_contact_ids";
  private static final int VALUE_GO_TO_BLACK_WHITE_CHOOSE_LIST = 6;
  private static final int VALUE_GO_TO_CONTACT_CREATE = 3;
  private static final int VALUE_GO_TO_CONTACT_DETAIL = 0;
  private static final int VALUE_GO_TO_CONTACT_EDIT_FROM_QRCODE = 2;
  private static final int VALUE_GO_TO_CONTACT_LIST = 1;
  private static final int VALUE_GO_TO_HISTORY_LIST = 5;
  private static final int VALUE_GO_TO_UPDATE_LIST = 4;
  
  private void addCustom(ArrayList<ContactCustom> paramArrayList, Object paramObject, int paramInt, String paramString)
  {
    int j = 0;
    if ((paramObject instanceof String)) {
      paramArrayList.add(newContactCustom(paramInt, paramString, String.valueOf(paramObject), 0));
    }
    for (;;)
    {
      return;
      if ((paramObject instanceof String[]))
      {
        paramObject = (String[])paramObject;
        int k = paramObject.length;
        int i = 0;
        while (j < k)
        {
          paramArrayList.add(newContactCustom(paramInt, paramString, paramObject[j], i));
          j += 1;
          i += 1;
        }
      }
    }
  }
  
  public static Intent createContactCreateIntent(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), ContactsFragmentActivity.class);
    localIntent.putExtra("arg_go_to_place", 3);
    Account localAccount = AccountManager.shareInstance().getAccountList().getDefaultMailAccount();
    if (localAccount == null) {
      throw new IllegalStateException("name: " + paramString1 + ", address: " + paramString2);
    }
    localIntent.putExtra("arg_detail_account_id", localAccount.getId());
    localIntent.putExtra("arg_detail_name", paramString1);
    localIntent.putExtra("arg_detail_address", paramString2);
    return localIntent;
  }
  
  public static Intent createContactDetailIntent(long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), ContactsFragmentActivity.class);
    localIntent.putExtra("arg_go_to_place", 0);
    localIntent.putExtra("arg_detail_contact_id", paramLong);
    localIntent.putExtra("arg_detail_account_id", paramInt1);
    localIntent.putExtra("arg_detail_address", paramString1);
    localIntent.putExtra("arg_detail_name", paramString2);
    localIntent.putExtra("arg_from_where", paramInt2);
    return localIntent;
  }
  
  public static Intent createContactDetailIntent(long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    paramString1 = createContactDetailIntent(paramLong, paramInt1, paramString1, paramString2, paramInt2);
    paramString1.putExtra("arg_name_list_type", paramInt3);
    return paramString1;
  }
  
  public static Intent createContactDetailIntent(long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2, ArrayList<String> paramArrayList)
  {
    paramString1 = createContactDetailIntent(paramLong, paramInt1, paramString1, paramString2, paramInt2);
    paramString1.putStringArrayListExtra("arg_compose_selected_emails", paramArrayList);
    return paramString1;
  }
  
  public static Intent createContactEditIntentFromQrcode(Map<String, Object> paramMap)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), ContactsFragmentActivity.class);
    localIntent.putExtra("animationType", 2);
    localIntent.putExtra("arg_go_to_place", 2);
    Account localAccount = AccountManager.shareInstance().getAccountList().getDefaultMailAccount();
    if (localAccount == null) {
      throw new IllegalStateException();
    }
    localIntent.putExtra("arg_detail_account_id", localAccount.getId());
    return createVcard(localIntent, paramMap);
  }
  
  public static Intent createContactsListIntent()
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), ContactsFragmentActivity.class);
    localIntent.putExtra("arg_go_to_place", 1);
    return localIntent;
  }
  
  public static Intent createIntentToBlackWhiteNameListChoose(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), ContactsFragmentActivity.class);
    localIntent.putExtra("arg_go_to_place", 6);
    localIntent.putExtra("arg_detail_account_id", paramInt1);
    localIntent.putExtra("arg_name_list_type", paramInt2);
    localIntent.putExtra("arg_name_list_is_recent_sender", paramBoolean);
    return localIntent;
  }
  
  public static Intent createIntentToSelectContact()
  {
    Intent localIntent = createContactsListIntent();
    localIntent.putExtra("arg_edit_mode", true);
    return localIntent;
  }
  
  private MailContact createMailContactFromVcard()
  {
    MailContact localMailContact = new MailContact();
    localMailContact.setAccountId(getIntent().getIntExtra("arg_detail_account_id", 0));
    Object localObject = AccountManager.shareInstance().getAccountList().getAccountById(localMailContact.getAccountId());
    if ((localObject != null) && (((Account)localObject).isQQMail())) {
      localMailContact.setType(MailContact.ContactType.ProtocolContact);
    }
    for (;;)
    {
      localMailContact.setName(getIntent().getStringExtra("arg_detail_name"));
      localMailContact.setNick(localMailContact.getName());
      localObject = getIntent().getStringArrayExtra("arg_detail_mark");
      if ((localObject != null) && (localObject.length > 0)) {
        localMailContact.setMark(localObject[0]);
      }
      localObject = new ArrayList();
      arrayOfString1 = getIntent().getStringArrayExtra("arg_detail_emails");
      if ((arrayOfString1 == null) || (arrayOfString1.length <= 0)) {
        break label192;
      }
      int j = arrayOfString1.length;
      int i = 0;
      while (i < j)
      {
        ((ArrayList)localObject).add(new ContactEmail(arrayOfString1[i]));
        i += 1;
      }
      localMailContact.setType(MailContact.ContactType.NormalContact);
    }
    localMailContact.setAddress(arrayOfString1[0]);
    label192:
    localMailContact.setEmails((ArrayList)localObject);
    localObject = getIntent().getStringExtra("arg_detail_title");
    String[] arrayOfString1 = getIntent().getStringArrayExtra("arg_detail_nickname");
    String[] arrayOfString2 = getIntent().getStringArrayExtra("arg_detail_phones");
    String[] arrayOfString3 = getIntent().getStringArrayExtra("arg_detail_org");
    String[] arrayOfString4 = getIntent().getStringArrayExtra("arg_detail_addresses");
    String[] arrayOfString5 = getIntent().getStringArrayExtra("arg_detail_urls");
    String[] arrayOfString6 = getIntent().getStringArrayExtra("arg_detail_qq");
    String[] arrayOfString7 = getIntent().getStringArrayExtra("arg_detail_weibos");
    String[] arrayOfString8 = getIntent().getStringArrayExtra("arg_detail_twitters");
    String[] arrayOfString9 = getIntent().getStringArrayExtra("arg_detail_skype");
    String str1 = getIntent().getStringExtra("arg_detail_birthday");
    String str2 = getIntent().getStringExtra("arg_detail_altbirthday");
    String[] arrayOfString10 = getIntent().getStringArrayExtra("arg_detail_aniversary");
    ArrayList localArrayList = new ArrayList();
    addCustom(localArrayList, localObject, 0, getString(2131721660));
    addCustom(localArrayList, arrayOfString1, 0, getString(2131721656));
    addCustom(localArrayList, arrayOfString2, 1, null);
    addCustom(localArrayList, arrayOfString3, 0, getString(2131721657));
    addCustom(localArrayList, arrayOfString4, 2, null);
    addCustom(localArrayList, arrayOfString5, 0, getString(2131721662));
    addCustom(localArrayList, arrayOfString6, 0, getString(2131721658));
    addCustom(localArrayList, arrayOfString7, 0, getString(2131721663));
    addCustom(localArrayList, arrayOfString8, 0, getString(2131721661));
    addCustom(localArrayList, arrayOfString9, 0, getString(2131721659));
    addCustom(localArrayList, str1, 3, null);
    addCustom(localArrayList, str2, 0, getString(2131721654));
    addCustom(localArrayList, arrayOfString10, 0, getString(2131721655));
    localMailContact.setCustoms(localArrayList);
    return localMailContact;
  }
  
  public static Intent createUpdateListIntent(int paramInt, String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), ContactsFragmentActivity.class);
    localIntent.putExtra("arg_go_to_place", 4);
    localIntent.putExtra("arg_detail_account_id", paramInt);
    localIntent.putExtra("arg_detail_address", paramString);
    return localIntent;
  }
  
  private static Intent createVcard(Intent paramIntent, Map<String, Object> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramMap.get(str);
      if (localObject != null)
      {
        label192:
        int i;
        switch (str.hashCode())
        {
        default: 
          i = -1;
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            break;
          case 0: 
            paramIntent.putExtra("arg_detail_name", String.valueOf(localObject));
            break;
            if (!str.equals("name")) {
              break label192;
            }
            i = 0;
            continue;
            if (!str.equals("nickname")) {
              break label192;
            }
            i = 1;
            continue;
            if (!str.equals("title")) {
              break label192;
            }
            i = 2;
            continue;
            if (!str.equals("org")) {
              break label192;
            }
            i = 3;
            continue;
            if (!str.equals("email")) {
              break label192;
            }
            i = 4;
            continue;
            if (!str.equals("tel")) {
              break label192;
            }
            i = 5;
            continue;
            if (!str.equals("addr")) {
              break label192;
            }
            i = 6;
            continue;
            if (!str.equals("weibo")) {
              break label192;
            }
            i = 7;
            continue;
            if (!str.equals("twitter")) {
              break label192;
            }
            i = 8;
            continue;
            if (!str.equals("url")) {
              break label192;
            }
            i = 9;
            continue;
            if (!str.equals("note")) {
              break label192;
            }
            i = 10;
            continue;
            if (!str.equals("birthday")) {
              break label192;
            }
            i = 11;
            continue;
            if (!str.equals("altBirthday")) {
              break label192;
            }
            i = 12;
            continue;
            if (!str.equals("qq")) {
              break label192;
            }
            i = 13;
            continue;
            if (!str.equals("skype")) {
              break label192;
            }
            i = 14;
            continue;
            if (!str.equals("ani")) {
              break label192;
            }
            i = 15;
          }
        }
        paramIntent.putExtra("arg_detail_nickname", (String[])((List)localObject).toArray(new String[0]));
        continue;
        paramIntent.putExtra("arg_detail_title", String.valueOf(localObject));
        continue;
        paramIntent.putExtra("arg_detail_org", (String[])((List)localObject).toArray(new String[0]));
        continue;
        paramIntent.putExtra("arg_detail_emails", (String[])((List)localObject).toArray(new String[0]));
        continue;
        paramIntent.putExtra("arg_detail_phones", (String[])((List)localObject).toArray(new String[0]));
        continue;
        paramIntent.putExtra("arg_detail_addresses", (String[])((List)localObject).toArray(new String[0]));
        continue;
        paramIntent.putExtra("arg_detail_weibos", (String[])((List)localObject).toArray(new String[0]));
        continue;
        paramIntent.putExtra("arg_detail_twitters", (String[])((List)localObject).toArray(new String[0]));
        continue;
        paramIntent.putExtra("arg_detail_urls", (String[])((List)localObject).toArray(new String[0]));
        continue;
        paramIntent.putExtra("arg_detail_mark", (String[])((List)localObject).toArray(new String[0]));
        continue;
        paramIntent.putExtra("arg_detail_birthday", String.valueOf(localObject));
        continue;
        paramIntent.putExtra("arg_detail_altbirthday", String.valueOf(localObject));
        continue;
        paramIntent.putExtra("arg_detail_qq", (String[])((List)localObject).toArray(new String[0]));
        continue;
        paramIntent.putExtra("arg_detail_skype", (String[])((List)localObject).toArray(new String[0]));
        continue;
        paramIntent.putExtra("arg_detail_aniversary", (String[])((List)localObject).toArray(new String[0]));
      }
    }
    return paramIntent;
  }
  
  private void initializeFragment()
  {
    int i = getIntent().getIntExtra("arg_go_to_place", 0);
    boolean bool = getIntent().getBooleanExtra("arg_edit_mode", false);
    Object localObject = null;
    switch (i)
    {
    }
    for (;;)
    {
      if (localObject != null) {
        getSupportFragmentManager().beginTransaction().add(2131367566, (Fragment)localObject, localObject.getClass().getSimpleName()).commit();
      }
      return;
      localObject = new ContactsListFragment(bool);
      continue;
      i = getIntent().getIntExtra("arg_detail_account_id", 0);
      localObject = getIntent().getStringExtra("arg_detail_address");
      String str = getIntent().getStringExtra("arg_detail_name");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new ContactEmail((String)localObject));
      MailContact localMailContact = new MailContact();
      localMailContact.setAccountId(i);
      localMailContact.setName(str);
      localMailContact.setNick(str);
      localMailContact.setAddress((String)localObject);
      localMailContact.setEmails(localArrayList);
      localObject = QMContactManager.sharedInstance().checkContacts(localMailContact);
      localObject = new ContactEditFragment((MailContact)localObject, (MailContact)localObject, true, 2);
      continue;
      long l = getIntent().getLongExtra("arg_detail_contact_id", 0L);
      i = getIntent().getIntExtra("arg_detail_account_id", 0);
      int j = getIntent().getIntExtra("arg_name_list_type", 0);
      localObject = new ContactDetailFragment(l, i, getIntent().getStringExtra("arg_detail_address"), getIntent().getStringExtra("arg_detail_name"), true, getIntent().getIntExtra("arg_from_where", 0), getIntent().getStringArrayListExtra("arg_compose_selected_emails"), j);
      continue;
      localObject = createMailContactFromVcard();
      localObject = QMContactManager.sharedInstance().checkContacts((MailContact)localObject);
      localObject = new ContactEditFragment((MailContact)localObject, (MailContact)localObject, true, 2);
      continue;
      localObject = new MailContact();
      str = getIntent().getStringExtra("arg_detail_address");
      i = getIntent().getIntExtra("arg_detail_account_id", 0);
      localArrayList = new ArrayList();
      localArrayList.add(new ContactEmail(str));
      ((MailContact)localObject).setName("");
      ((MailContact)localObject).setNick("");
      ((MailContact)localObject).setEmails(localArrayList);
      ((MailContact)localObject).setAddress(str);
      ((MailContact)localObject).setAccountId(i);
      localObject = new ContactsListFragment((MailContact)localObject);
      continue;
      i = getIntent().getIntExtra("arg_detail_account_id", 0);
      localObject = getIntent().getStringExtra("arg_detail_address");
      localObject = new ContactsHistoryMailListFragment(QMContactManager.sharedInstance().getContactByAccountAndEmail(i, (String)localObject));
      continue;
      i = getIntent().getIntExtra("arg_detail_account_id", 0);
      j = getIntent().getIntExtra("arg_name_list_type", 0);
      localObject = new ContactsListFragment(5, i, getIntent().getBooleanExtra("arg_name_list_is_recent_sender", false), j);
    }
  }
  
  private ContactCustom newContactCustom(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    ContactCustom localContactCustom = new ContactCustom();
    localContactCustom.setType(paramInt1);
    if (paramString1 != null) {
      localContactCustom.setKey(paramString1);
    }
    localContactCustom.setValue(paramString2);
    return localContactCustom;
  }
  
  public int getContextViewId()
  {
    return 2131367566;
  }
  
  public int getHistorySize()
  {
    return QMActivityManager.shareInstance().getActivitySize();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(null);
    initializeFragment();
    StatusBarUtil.immerseWhite(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.ContactsFragmentActivity
 * JD-Core Version:    0.7.0.1
 */