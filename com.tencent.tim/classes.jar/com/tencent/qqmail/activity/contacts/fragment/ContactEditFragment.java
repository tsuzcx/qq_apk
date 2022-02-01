package com.tencent.qqmail.activity.contacts.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.activity.contacts.view.ContactAddItemView;
import com.tencent.qqmail.activity.contacts.view.ContactBaseItemView.ContactItemType;
import com.tencent.qqmail.activity.contacts.view.ContactCustomItemView;
import com.tencent.qqmail.activity.contacts.view.ContactEditBirthdayItemView;
import com.tencent.qqmail.activity.contacts.view.ContactEditItemView;
import com.tencent.qqmail.activity.contacts.view.ContactHeaderItemView;
import com.tencent.qqmail.activity.contacts.view.ContactTableView;
import com.tencent.qqmail.activity.contacts.watcher.ContactItemViewOperateCallback;
import com.tencent.qqmail.activity.contacts.watcher.ContactPhoneItemWatcher;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.mail.watcher.SyncContactWatcher;
import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.ContactCustom;
import com.tencent.qqmail.model.qmdomain.ContactEmail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.validate.ValidateEmail;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import moai.core.watcher.Watchers;
import moai.fragment.app.FragmentActivity;
import moai.fragment.base.BaseFragment.TransitionConfig;

public class ContactEditFragment
  extends ContactsBaseFragment
{
  public static final String EDIT_DELETE_FLAG = "edit_delete_flag";
  public static final String EDIT_NEW_ID = "edit_new_id";
  public static final String TAG = "ContactEditFragment";
  private ContactTableView contactTableView;
  private ContactTableView customTableView;
  private Button deleteButton;
  private ContactItemViewOperateCallback detailItemClickCallBack = new ContactEditFragment.1(this);
  private EditType editType;
  private ContactHeaderItemView headerView;
  private ContactTableView infoTableView;
  private MailContact modifiedContact;
  private MailContact originContact;
  private SyncContactWatcher syncContactWatcher = new ContactEditFragment.2(this);
  private SyncPhotoWatcher syncPhotoWatcher = new ContactEditFragment.3(this);
  private String targetAddress;
  private QMTopBar topBar;
  private LinearLayout wrapper;
  
  public ContactEditFragment()
  {
    super(false);
    this.editType = EditType.CREATE_CONTACT;
    this.originContact = new MailContact();
    this.modifiedContact = new MailContact();
    this.originContact = QMContactManager.sharedInstance().checkContacts(this.originContact);
    this.modifiedContact = QMContactManager.sharedInstance().checkContacts(this.modifiedContact);
  }
  
  public ContactEditFragment(MailContact paramMailContact1, MailContact paramMailContact2, boolean paramBoolean, int paramInt)
  {
    super(false);
    if (paramBoolean) {}
    for (EditType localEditType = EditType.CREATE_CONTACT;; localEditType = EditType.MODIFY_CONTACT)
    {
      this.editType = localEditType;
      this.originContact = paramMailContact1.clone();
      this.modifiedContact = paramMailContact2.clone();
      this.from = paramInt;
      return;
    }
  }
  
  public ContactEditFragment(MailContact paramMailContact1, MailContact paramMailContact2, boolean paramBoolean, int paramInt, String paramString)
  {
    this(paramMailContact1, paramMailContact2, paramBoolean, paramInt);
    this.targetAddress = paramString;
  }
  
  private MailContact collectContact()
  {
    MailContact localMailContact = this.modifiedContact.clone();
    Object localObject2 = this.modifiedContact;
    if (this.headerView == null)
    {
      localObject1 = "";
      ((MailContact)localObject2).setName((String)localObject1);
      localObject2 = this.modifiedContact;
      if (this.headerView != null) {
        break label227;
      }
    }
    int i;
    Object localObject3;
    String str;
    label227:
    for (Object localObject1 = "";; localObject1 = this.headerView.getNameText().trim())
    {
      ((MailContact)localObject2).setNick((String)localObject1);
      localObject1 = this.originContact.getEmails();
      localObject2 = new ArrayList();
      if (this.contactTableView == null) {
        break label316;
      }
      i = 0;
      for (;;)
      {
        if (i >= this.contactTableView.getChildCount()) {
          break label316;
        }
        localObject3 = this.contactTableView.getChildAt(i);
        if ((localObject3 instanceof ContactEditItemView))
        {
          localObject3 = (ContactEditItemView)localObject3;
          str = ((ContactEditItemView)localObject3).getNodeInputText().trim();
          if ((!str.equals("")) && (((ContactEditItemView)localObject3).getItemType() == ContactBaseItemView.ContactItemType.TYPE_EMAIL))
          {
            if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0)) {
              break;
            }
            ((ArrayList)localObject2).add(new ContactEmail(str));
          }
          if (((ContactEditItemView)localObject3).getItemType() == ContactBaseItemView.ContactItemType.TYPE_MARK) {
            this.modifiedContact.setMark(((ContactEditItemView)localObject3).getNodeInputText().trim());
          }
        }
        i += 1;
      }
      localObject1 = this.headerView.getNameText().trim();
      break;
    }
    Iterator localIterator = ((ArrayList)localObject1).iterator();
    int k;
    int j;
    while (localIterator.hasNext())
    {
      ContactEmail localContactEmail = (ContactEmail)localIterator.next();
      if (localContactEmail.getEmail().equals(str))
      {
        k = localContactEmail.getFreq();
        j = localContactEmail.getFreqUpdateTime();
      }
    }
    for (;;)
    {
      ((ArrayList)localObject2).add(new ContactEmail(str, k, j));
      break;
      label316:
      if (((ArrayList)localObject2).size() > 0)
      {
        this.modifiedContact.setAddress(((ContactEmail)((ArrayList)localObject2).get(0)).getEmail());
        this.modifiedContact.setEmails((ArrayList)localObject2);
        localObject1 = new ArrayList();
        if (this.infoTableView == null) {
          break label606;
        }
        i = 0;
        label370:
        if (i >= this.infoTableView.getChildCount()) {
          break label606;
        }
        localObject2 = this.infoTableView.getChildAt(i);
        if ((localObject2 instanceof ContactEditItemView))
        {
          localObject3 = (ContactEditItemView)localObject2;
          localObject2 = ((ContactEditItemView)localObject3).getNodeInputText().trim();
          if (!((String)localObject2).equals(""))
          {
            if (((ContactEditItemView)localObject3).getItemType() != ContactBaseItemView.ContactItemType.TYPE_TEL) {
              break label502;
            }
            localObject3 = new ContactCustom();
            ((ContactCustom)localObject3).setType(1);
            ((ContactCustom)localObject3).setKey(ContactCustom.TEL_KEY);
            ((ContactCustom)localObject3).setValue(((String)localObject2).replaceAll(ContactPhoneItemWatcher.PHONE_LINK_CHAR, ""));
            ((ArrayList)localObject1).add(localObject3);
          }
        }
      }
      for (;;)
      {
        i += 1;
        break label370;
        this.modifiedContact.setAddress("");
        break;
        label502:
        if (((ContactEditItemView)localObject3).getItemType() == ContactBaseItemView.ContactItemType.TYPE_ADDRESS)
        {
          localObject3 = new ContactCustom();
          ((ContactCustom)localObject3).setType(2);
          ((ContactCustom)localObject3).setKey(ContactCustom.ADDRESS_KEY);
          ((ContactCustom)localObject3).setValue((String)localObject2);
          ((ArrayList)localObject1).add(localObject3);
        }
        else if (((ContactEditItemView)localObject3).getItemType() == ContactBaseItemView.ContactItemType.TYPE_BIRTHDAY)
        {
          localObject3 = new ContactCustom();
          ((ContactCustom)localObject3).setType(3);
          ((ContactCustom)localObject3).setKey(ContactCustom.BIRTHDAY_KEY);
          ((ContactCustom)localObject3).setValue((String)localObject2);
          ((ArrayList)localObject1).add(localObject3);
        }
      }
      label606:
      if (this.customTableView != null)
      {
        i = 0;
        while (i < this.customTableView.getChildCount())
        {
          localObject2 = this.customTableView.getChildAt(i);
          if ((localObject2 instanceof ContactCustomItemView))
          {
            localObject2 = (ContactCustomItemView)localObject2;
            if ((!((ContactCustomItemView)localObject2).getCustomKeyInputText().trim().equals("")) && (!((ContactCustomItemView)localObject2).getCustomValueInputText().trim().equals("")) && (((ContactCustomItemView)localObject2).getItemType() == ContactBaseItemView.ContactItemType.TYPE_CUSTOM))
            {
              localObject3 = new ContactCustom();
              ((ContactCustom)localObject3).setType(0);
              ((ContactCustom)localObject3).setKey(((ContactCustomItemView)localObject2).getCustomKeyInputText());
              ((ContactCustom)localObject3).setValue(((ContactCustomItemView)localObject2).getCustomValueInputText());
              ((ArrayList)localObject1).add(localObject3);
            }
          }
          i += 1;
        }
      }
      this.modifiedContact.setCustoms((ArrayList)localObject1);
      this.modifiedContact = QMContactManager.sharedInstance().checkContacts(this.modifiedContact);
      return localMailContact;
      j = 0;
      k = 0;
    }
  }
  
  private void initTopBar()
  {
    this.topBar = getTopBar();
    this.topBar.setButtonRightBlue(2131718919);
    this.topBar.getButtonRight().setOnClickListener(new ContactEditFragment.5(this));
    this.topBar.setButtonLeftNormal(2131691246);
    this.topBar.getButtonLeft().setOnClickListener(new ContactEditFragment.6(this));
  }
  
  private boolean isEmailValidate()
  {
    int i = 0;
    while (i < this.contactTableView.getChildCount())
    {
      Object localObject = this.contactTableView.getChildAt(i);
      if ((localObject instanceof ContactEditItemView))
      {
        localObject = (ContactEditItemView)localObject;
        String str = ((ContactEditItemView)localObject).getNodeInputText().trim();
        if ((!str.equals("")) && (((ContactEditItemView)localObject).getItemType() == ContactBaseItemView.ContactItemType.TYPE_EMAIL) && (!ValidateEmail.isEmailValidate(str))) {
          return false;
        }
      }
      i += 1;
    }
    return true;
  }
  
  private boolean isEmptyContact(MailContact paramMailContact)
  {
    return (paramMailContact == null) || (MailContact.generateHash(new MailContact()) == paramMailContact.getHash());
  }
  
  private boolean isEmptyData()
  {
    if ((this.headerView != null) && (!this.headerView.getNameText().trim().equals(""))) {
      return false;
    }
    int i;
    Object localObject;
    if (this.contactTableView != null)
    {
      i = 0;
      for (;;)
      {
        if (i >= this.contactTableView.getChildCount()) {
          break label88;
        }
        localObject = this.contactTableView.getChildAt(i);
        if (((localObject instanceof ContactEditItemView)) && (!((ContactEditItemView)localObject).getNodeInputText().trim().equals(""))) {
          break;
        }
        i += 1;
      }
    }
    label88:
    if (this.infoTableView != null)
    {
      i = 0;
      for (;;)
      {
        if (i >= this.infoTableView.getChildCount()) {
          break label149;
        }
        localObject = this.infoTableView.getChildAt(i);
        if (((localObject instanceof ContactEditItemView)) && (!((ContactEditItemView)localObject).getNodeInputText().trim().equals(""))) {
          break;
        }
        i += 1;
      }
    }
    label149:
    if (this.customTableView != null)
    {
      i = 0;
      for (;;)
      {
        if (i >= this.customTableView.getChildCount()) {
          break label227;
        }
        localObject = this.customTableView.getChildAt(i);
        if ((localObject instanceof ContactCustomItemView))
        {
          localObject = (ContactCustomItemView)localObject;
          if ((!((ContactCustomItemView)localObject).getCustomKeyInputText().trim().equals("")) && (!((ContactCustomItemView)localObject).getCustomValueInputText().trim().equals(""))) {
            break;
          }
        }
        i += 1;
      }
    }
    label227:
    return true;
  }
  
  private void onCancelEdit()
  {
    if (!collectContact().equals(this.modifiedContact))
    {
      ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131696424)).setMessage(2131692015).addAction(2131692032, new ContactEditFragment.8(this))).addAction(2131692016, new ContactEditFragment.7(this))).create().show();
      return;
    }
    popBackStack();
  }
  
  private void onDeleteContact()
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131696424)).setMessage(2131692024).addAction(2131691246, new ContactEditFragment.10(this))).addAction(0, 2131692023, 2, new ContactEditFragment.9(this))).create().show();
  }
  
  private void onMergeSameContact(MailContact paramMailContact)
  {
    String str2 = paramMailContact.getNick();
    if (str2 != null)
    {
      str1 = str2;
      if (!str2.isEmpty()) {}
    }
    else
    {
      str1 = getString(2131692061);
    }
    String str1 = String.format(getString(2131692035), new Object[] { str1 });
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131696424)).setMessage(str1).addAction(2131691246, new ContactEditFragment.12(this))).addAction(2131692034, new ContactEditFragment.11(this, paramMailContact))).create().show();
  }
  
  private void onSaveEdit()
  {
    if (!isEmailValidate()) {
      Toast.makeText(QMApplicationContext.sharedInstance(), getString(2131692043), 0).show();
    }
    do
    {
      return;
      collectContact();
      if (((this.editType == EditType.MODIFY_CONTACT) && (!this.originContact.equals(this.modifiedContact))) || ((this.editType == EditType.CREATE_CONTACT) && (!isEmptyContact(this.modifiedContact))))
      {
        Object localObject = null;
        if (!this.modifiedContact.getEmails().isEmpty()) {
          localObject = QMContactManager.sharedInstance().getSameEmailContactWhenSync(this.modifiedContact, this.originContact.getId());
        }
        if (localObject != null) {
          onMergeSameContact((MailContact)localObject);
        }
        while (this.editType == EditType.MODIFY_CONTACT)
        {
          DataCollector.logEvent("Event_Contact_Edit_Save");
          return;
          QMContactManager.sharedInstance().syncBirthdayCalendarEvent(this.modifiedContact);
          QMContactManager.sharedInstance().syncContact(this.originContact, this.modifiedContact);
          if (this.targetAddress != null)
          {
            String str = this.modifiedContact.getAddress();
            Iterator localIterator = this.modifiedContact.getEmails().iterator();
            do
            {
              localObject = str;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject = (ContactEmail)localIterator.next();
            } while (!((ContactEmail)localObject).getEmail().equals(this.targetAddress));
            localObject = ((ContactEmail)localObject).getEmail();
            QMContactManager.sharedInstance().postEditEmailNotification(this.originContact.getAddress(), (String)localObject, this.originContact.getName(), this.modifiedContact.getName(), this.modifiedContact.getMark(), this.modifiedContact.getId());
          }
          localObject = new HashMap();
          ((HashMap)localObject).put("edit_new_id", Long.valueOf(this.modifiedContact.getId()));
          setFragmentResult(-1, (HashMap)localObject);
          if (this.from == 1) {
            backToContactDetail();
          } else {
            popBackStack();
          }
        }
        DataCollector.logEvent("Event_Contact_Create_Save");
        return;
      }
    } while (getBaseFragmentActivity() == null);
    popBackStack();
  }
  
  private void refreshButton()
  {
    if ((this.editType == EditType.MODIFY_CONTACT) && (this.from != 1))
    {
      this.deleteButton.setVisibility(0);
      return;
    }
    this.deleteButton.setVisibility(8);
  }
  
  private void refreshContactTableView()
  {
    this.contactTableView = new ContactTableView(getActivity());
    this.headerView = new ContactHeaderItemView(getActivity());
    this.headerView.setEditModel(true);
    this.headerView.setNameText(this.modifiedContact.getName());
    this.headerView.setVipSign(this.modifiedContact.isVip());
    this.headerView.setNodeValueOperateCallback(this.detailItemClickCallBack);
    this.headerView.setAvatarViewEmail(this.modifiedContact.getName(), this.modifiedContact.getAddress());
    if (isEmptyContact(this.modifiedContact))
    {
      this.headerView.getNameEditText().requestFocus();
      showKeyBoard();
    }
    this.contactTableView.addView(this.headerView);
    Object localObject1 = this.modifiedContact.getEmails();
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ContactEmail)((Iterator)localObject1).next();
        if (!StringExtention.isNullOrEmpty(((ContactEmail)localObject2).getEmail()))
        {
          ContactEditItemView localContactEditItemView = new ContactEditItemView(getActivity());
          localContactEditItemView.setItemType(ContactBaseItemView.ContactItemType.TYPE_EMAIL);
          localContactEditItemView.setNodeLabel(2131692036);
          localContactEditItemView.setNodeInputText(((ContactEmail)localObject2).getEmail());
          localContactEditItemView.setNodeValueOperateCallback(this.detailItemClickCallBack);
          this.contactTableView.addView(localContactEditItemView);
        }
      }
    }
    localObject1 = new ContactAddItemView(getActivity());
    ((ContactAddItemView)localObject1).setItemType(ContactBaseItemView.ContactItemType.TYPE_EMAIL);
    ((ContactAddItemView)localObject1).setNodeValueOperateCallback(this.detailItemClickCallBack);
    ((ContactAddItemView)localObject1).setText(2131692037);
    this.contactTableView.addView((View)localObject1);
    localObject1 = this.modifiedContact.getMark();
    Object localObject2 = new ContactEditItemView(getActivity());
    ((ContactEditItemView)localObject2).setItemType(ContactBaseItemView.ContactItemType.TYPE_MARK);
    ((ContactEditItemView)localObject2).setNodeLabel(2131692046);
    ((ContactEditItemView)localObject2).setNodeInputText((String)localObject1);
    ((ContactEditItemView)localObject2).setNodeValueOperateCallback(this.detailItemClickCallBack);
    ((ContactEditItemView)localObject2).toggleIconDelete(false);
    this.contactTableView.addView((View)localObject2);
    this.wrapper.addView(this.contactTableView);
  }
  
  private void refreshCustomTableView()
  {
    Object localObject1 = this.modifiedContact.getCustoms();
    this.customTableView = new ContactTableView(getActivity());
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      Object localObject2 = ((ArrayList)localObject1).iterator();
      Object localObject3;
      ContactCustomItemView localContactCustomItemView;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ContactCustom)((Iterator)localObject2).next();
        if (((ContactCustom)localObject3).getType() == 4)
        {
          localContactCustomItemView = new ContactCustomItemView(getActivity());
          localContactCustomItemView.setItemType(ContactBaseItemView.ContactItemType.TYPE_CUSTOM);
          localContactCustomItemView.setCustomKeyInputText(((ContactCustom)localObject3).getKey());
          localContactCustomItemView.setNodeValueOperateCallback(this.detailItemClickCallBack);
          localContactCustomItemView.setCustomValueInputText(((ContactCustom)localObject3).getValue());
          this.customTableView.addView(localContactCustomItemView);
        }
      }
      localObject2 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ContactCustom)((Iterator)localObject2).next();
        if (((ContactCustom)localObject3).getType() == 5)
        {
          localContactCustomItemView = new ContactCustomItemView(getActivity());
          localContactCustomItemView.setItemType(ContactBaseItemView.ContactItemType.TYPE_CUSTOM);
          localContactCustomItemView.setCustomKeyInputText(((ContactCustom)localObject3).getKey());
          localContactCustomItemView.setNodeValueOperateCallback(this.detailItemClickCallBack);
          localContactCustomItemView.setCustomValueInputText(((ContactCustom)localObject3).getValue());
          this.customTableView.addView(localContactCustomItemView);
        }
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ContactCustom)((Iterator)localObject1).next();
        if (((ContactCustom)localObject2).getType() == 0)
        {
          localObject3 = new ContactCustomItemView(getActivity());
          ((ContactCustomItemView)localObject3).setItemType(ContactBaseItemView.ContactItemType.TYPE_CUSTOM);
          ((ContactCustomItemView)localObject3).setCustomKeyInputText(((ContactCustom)localObject2).getKey());
          ((ContactCustomItemView)localObject3).setNodeValueOperateCallback(this.detailItemClickCallBack);
          ((ContactCustomItemView)localObject3).setCustomValueInputText(((ContactCustom)localObject2).getValue());
          this.customTableView.addView((View)localObject3);
        }
      }
    }
    localObject1 = new ContactAddItemView(getActivity());
    ((ContactAddItemView)localObject1).setItemType(ContactBaseItemView.ContactItemType.TYPE_CUSTOM);
    ((ContactAddItemView)localObject1).setText(2131692019);
    ((ContactAddItemView)localObject1).setNodeValueOperateCallback(this.detailItemClickCallBack);
    this.customTableView.addView((View)localObject1);
    this.wrapper.addView(this.customTableView);
  }
  
  private void refreshInfoTableView()
  {
    Object localObject1 = this.modifiedContact.getCustoms();
    this.infoTableView = new ContactTableView(getActivity());
    ContactCustom localContactCustom;
    ContactEditItemView localContactEditItemView;
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      localObject2 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localContactCustom = (ContactCustom)((Iterator)localObject2).next();
        if (localContactCustom.getType() == 1)
        {
          localContactEditItemView = new ContactEditItemView(getActivity());
          localContactEditItemView.setItemType(ContactBaseItemView.ContactItemType.TYPE_TEL);
          localContactEditItemView.setNodeLabel(localContactCustom.getKey());
          localContactEditItemView.setNodeValueOperateCallback(this.detailItemClickCallBack);
          localContactEditItemView.setNodeInputText(localContactCustom.getValue());
          this.infoTableView.addView(localContactEditItemView);
        }
      }
    }
    Object localObject2 = new ContactAddItemView(getActivity());
    ((ContactAddItemView)localObject2).setItemType(ContactBaseItemView.ContactItemType.TYPE_TEL);
    ((ContactAddItemView)localObject2).setNodeValueOperateCallback(this.detailItemClickCallBack);
    ((ContactAddItemView)localObject2).setText(2131692087);
    this.infoTableView.addView((View)localObject2);
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      localObject2 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localContactCustom = (ContactCustom)((Iterator)localObject2).next();
        if (localContactCustom.getType() == 2)
        {
          localContactEditItemView = new ContactEditItemView(getActivity());
          localContactEditItemView.setItemType(ContactBaseItemView.ContactItemType.TYPE_ADDRESS);
          localContactEditItemView.setNodeLabel(localContactCustom.getKey());
          localContactEditItemView.setNodeValueOperateCallback(this.detailItemClickCallBack);
          localContactEditItemView.setNodeInputText(localContactCustom.getValue());
          this.infoTableView.addView(localContactEditItemView);
        }
      }
    }
    localObject2 = new ContactAddItemView(getActivity());
    ((ContactAddItemView)localObject2).setItemType(ContactBaseItemView.ContactItemType.TYPE_ADDRESS);
    ((ContactAddItemView)localObject2).setNodeValueOperateCallback(this.detailItemClickCallBack);
    ((ContactAddItemView)localObject2).setText(2131692010);
    this.infoTableView.addView((View)localObject2);
    if (localObject1 != null)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (ContactCustom)((Iterator)localObject1).next();
      } while (((ContactCustom)localObject2).getType() != 3);
    }
    for (localObject1 = ((ContactCustom)localObject2).getValue();; localObject1 = "")
    {
      localObject2 = new ContactEditBirthdayItemView(getActivity());
      ((ContactEditBirthdayItemView)localObject2).setItemType(ContactBaseItemView.ContactItemType.TYPE_BIRTHDAY);
      ((ContactEditBirthdayItemView)localObject2).setNodeLabel(2131692011);
      ((ContactEditBirthdayItemView)localObject2).setNodeInputText((String)localObject1);
      ((ContactEditBirthdayItemView)localObject2).setNodeValueOperateCallback(this.detailItemClickCallBack);
      ((ContactEditBirthdayItemView)localObject2).toggleIconDelete(false);
      this.infoTableView.addView((View)localObject2);
      this.wrapper.addView(this.infoTableView);
      return;
    }
  }
  
  private void refreshTopbar()
  {
    if (isEmptyData())
    {
      this.topBar.getButtonRight().setEnabled(false);
      return;
    }
    this.topBar.getButtonRight().setEnabled(true);
  }
  
  public void initDataSource() {}
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initTopBar();
    refreshContactTableView();
    refreshInfoTableView();
    refreshCustomTableView();
    refreshButton();
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    getActivity().getWindow().setSoftInputMode(16);
    paramViewHolder = (FrameLayout)super.initUI(paramViewHolder);
    paramViewHolder.setFocusable(true);
    paramViewHolder.setFocusableInTouchMode(true);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1, 48);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131299664), 0, 0);
    View localView = View.inflate(getActivity(), 2131559084, null);
    localView.setLayoutParams(localLayoutParams);
    this.wrapper = ((LinearLayout)localView.findViewById(2131365267));
    this.deleteButton = ((Button)localView.findViewById(2131365266));
    this.deleteButton.setOnClickListener(new ContactEditFragment.4(this));
    paramViewHolder.addView(localView);
    return paramViewHolder;
  }
  
  public void onBackPressed()
  {
    onCancelEdit();
  }
  
  public void onBackground()
  {
    hideKeyBoard();
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.syncContactWatcher, paramBoolean);
    QMPrivateProtocolManager.sharedInstance().bindSyncPhotoWatcher(this.syncPhotoWatcher, paramBoolean);
  }
  
  public BaseFragment.TransitionConfig onFetchTransaction()
  {
    return SCALE_TRANSITION_CONFIG;
  }
  
  public void onRelease() {}
  
  public int refreshData()
  {
    return 0;
  }
  
  public void render(int paramInt)
  {
    refreshTopbar();
    endTrace("ContactEditFragment");
  }
  
  public static enum EditType
  {
    CREATE_CONTACT,  MODIFY_CONTACT;
    
    private EditType() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactEditFragment
 * JD-Core Version:    0.7.0.1
 */