package com.tencent.qqmail.activity.contacts.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqmail.activity.contacts.view.ContactBaseItemView.ContactItemType;
import com.tencent.qqmail.activity.contacts.view.ContactDetailItemContainerView;
import com.tencent.qqmail.activity.contacts.view.ContactDetailItemSingleView;
import com.tencent.qqmail.activity.contacts.view.ContactDetailItemView;
import com.tencent.qqmail.activity.contacts.view.ContactHeaderItemView;
import com.tencent.qqmail.activity.contacts.view.ContactTableView;
import com.tencent.qqmail.activity.contacts.watcher.ContactItemViewOperateCallback;
import com.tencent.qqmail.calendar.data.QMSchedule;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.mail.watcher.SyncContactWatcher;
import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.model.mail.watcher.VipContactWatcher;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.ContactCustom;
import com.tencent.qqmail.model.qmdomain.ContactEmail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import com.tencent.qqmail.namelist.model.NameListContact.NameListContactType;
import com.tencent.qqmail.namelist.watcher.DeleteNameListWatcher;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import moai.core.watcher.Watchers;
import org.apache.commons.lang3.StringUtils;

public class ContactDetailFragment
  extends ContactsBaseFragment
{
  public static final int REQUEST_CODE_EDIT = 100;
  public static final String TAG = ContactDetailFragment.class.getSimpleName();
  private int accountId;
  private Button addContactBtn;
  private String address;
  private MailContact contact;
  private TextView contactAddedTip;
  private long contactId;
  private ContactTableView contactTableView;
  private LinearLayout container;
  private ContactTableView customTableView;
  private DeleteNameListWatcher deleteNameListWatcher = new ContactDetailFragment.5(this);
  private ContactItemViewOperateCallback detailItemClickCallBack = new ContactDetailFragment.1(this);
  private Button goHistoryMailBtn;
  private ContactHeaderItemView headerView;
  private ContactTableView infoTableView;
  private View mLayout;
  private String name;
  private Button nameListRemoveBtn;
  private int nameListType;
  private MailContact sameContact;
  private QMSchedule schedule;
  private ArrayList<String> selectedEMails;
  private Button setVipBtn;
  private boolean shouldHighlineEmail;
  private SyncContactWatcher syncContactWatcher = new ContactDetailFragment.2(this);
  private SyncPhotoWatcher syncPhotoWatcher = new ContactDetailFragment.4(this);
  private QMTopBar topBar;
  private VipContactWatcher vipContactWatcher = new ContactDetailFragment.3(this);
  private LinearLayout wrapper;
  
  public ContactDetailFragment(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    super(false);
    this.contactId = paramLong;
    this.accountId = paramInt;
    this.address = paramString1;
    this.name = paramString2;
  }
  
  public ContactDetailFragment(long paramLong, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    this(paramLong, paramInt, paramString1, paramString2);
    this.shouldHighlineEmail = paramBoolean;
  }
  
  public ContactDetailFragment(long paramLong, int paramInt1, String paramString1, String paramString2, boolean paramBoolean, int paramInt2, ArrayList<String> paramArrayList)
  {
    this(paramLong, paramInt1, paramString1, paramString2, paramBoolean);
    this.from = paramInt2;
    this.selectedEMails = paramArrayList;
  }
  
  public ContactDetailFragment(long paramLong, int paramInt1, String paramString1, String paramString2, boolean paramBoolean, int paramInt2, ArrayList<String> paramArrayList, int paramInt3)
  {
    this(paramLong, paramInt1, paramString1, paramString2, paramBoolean, paramInt2, paramArrayList);
    this.nameListType = paramInt3;
  }
  
  private void bindButtonListener()
  {
    this.goHistoryMailBtn.setOnClickListener(new ContactDetailFragment.9(this));
    this.setVipBtn.setOnClickListener(new ContactDetailFragment.10(this));
    this.addContactBtn.setOnClickListener(new ContactDetailFragment.11(this));
    this.nameListRemoveBtn.setOnClickListener(new ContactDetailFragment.12(this));
  }
  
  private void initTopBar()
  {
    this.topBar = getTopBar();
    this.topBar.setButtonLeftBack();
    this.topBar.getButtonLeft().setOnClickListener(new ContactDetailFragment.6(this));
    this.topBar.setButtonRightIcon(2130841091);
    this.topBar.getButtonRight().setContentDescription(getString(2131720817));
  }
  
  private void refreshButton()
  {
    if (this.from == 4)
    {
      this.addContactBtn.setVisibility(8);
      this.contactAddedTip.setVisibility(8);
      this.setVipBtn.setVisibility(8);
      this.goHistoryMailBtn.setVisibility(0);
      this.nameListRemoveBtn.setVisibility(0);
      if (this.nameListType == NameListContact.NameListContactType.BLACK.ordinal())
      {
        this.nameListRemoveBtn.setText(2131718783);
        return;
      }
      this.nameListRemoveBtn.setText(2131718784);
      return;
    }
    if (QMContactManager.sharedInstance().isStranger(this.contact))
    {
      if (this.sameContact != null)
      {
        this.addContactBtn.setVisibility(0);
        this.addContactBtn.setEnabled(false);
        this.contactAddedTip.setVisibility(0);
      }
      for (;;)
      {
        this.setVipBtn.setVisibility(8);
        if ((this.from != 3) && (this.contact.getEmails().size() != 0)) {
          break;
        }
        this.goHistoryMailBtn.setVisibility(8);
        return;
        this.addContactBtn.setVisibility(0);
        this.addContactBtn.setEnabled(true);
        this.contactAddedTip.setVisibility(8);
      }
      this.goHistoryMailBtn.setVisibility(0);
      return;
    }
    this.addContactBtn.setVisibility(8);
    this.contactAddedTip.setVisibility(8);
    if (this.contact.getEmails().size() > 0)
    {
      this.setVipBtn.setVisibility(0);
      if (this.contact.isVip()) {
        this.setVipBtn.setText(2131692026);
      }
      for (;;)
      {
        this.goHistoryMailBtn.setVisibility(0);
        return;
        this.setVipBtn.setText(2131692027);
      }
    }
    this.goHistoryMailBtn.setVisibility(8);
    this.setVipBtn.setVisibility(8);
  }
  
  private void refreshContactTableView()
  {
    this.contactTableView = new ContactTableView(getActivity());
    this.headerView = new ContactHeaderItemView(getActivity());
    this.headerView.setEditModel(false);
    ContactDetailItemContainerView localContactDetailItemContainerView;
    label178:
    ContactEmail localContactEmail;
    ContactDetailItemView localContactDetailItemView;
    if ((this.contact.getType() == MailContact.ContactType.QQFriendContact) && (!StringExtention.isNullOrEmpty(this.contact.getMark())))
    {
      this.headerView.setNameText(this.contact.getMark());
      this.headerView.setVipSign(this.contact.isVip());
      this.headerView.setAvatarViewEmail(this.contact.getName(), this.contact.getAddress());
      this.headerView.setNodeValueOperateCallback(this.detailItemClickCallBack);
      this.contactTableView.addView(this.headerView);
      localObject = this.contact.getEmails();
      if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
        break label356;
      }
      localContactDetailItemContainerView = new ContactDetailItemContainerView(getActivity());
      localContactDetailItemContainerView.setLabel(2131692036);
      Iterator localIterator = ((ArrayList)localObject).iterator();
      if (!localIterator.hasNext()) {
        break label348;
      }
      localContactEmail = (ContactEmail)localIterator.next();
      localContactDetailItemView = new ContactDetailItemView(getActivity());
      if ((!this.shouldHighlineEmail) || (!this.address.equals(localContactEmail.getEmail())) || (((ArrayList)localObject).size() <= 1)) {
        break label334;
      }
      localContactDetailItemView.setContent(localContactEmail.getEmail(), true);
    }
    for (;;)
    {
      localContactDetailItemView.setLinkContent(true);
      localContactDetailItemView.setNodeValueOperateCallback(this.detailItemClickCallBack);
      localContactDetailItemView.setItemType(ContactBaseItemView.ContactItemType.TYPE_EMAIL);
      localContactDetailItemContainerView.addContentNode(localContactDetailItemView);
      break label178;
      if (!StringUtils.isEmpty(this.contact.getName()))
      {
        this.headerView.setNameText(this.contact.getName());
        break;
      }
      this.headerView.setNameText(getResources().getString(2131692061));
      break;
      label334:
      localContactDetailItemView.setContent(localContactEmail.getEmail(), false);
    }
    label348:
    this.contactTableView.addView(localContactDetailItemContainerView);
    label356:
    Object localObject = new ContactDetailItemSingleView(getActivity());
    if (!StringExtention.isNullOrEmpty(this.contact.getMark()))
    {
      if (this.contact.getType() != MailContact.ContactType.QQFriendContact) {
        break label451;
      }
      ((ContactDetailItemSingleView)localObject).setLabel(getString(2131692069));
      ((ContactDetailItemSingleView)localObject).setContent(this.contact.getName());
    }
    for (;;)
    {
      ((ContactDetailItemSingleView)localObject).setNodeValueOperateCallback(this.detailItemClickCallBack);
      ((ContactDetailItemSingleView)localObject).setItemType(ContactBaseItemView.ContactItemType.TYPE_MARK);
      this.contactTableView.addView((View)localObject);
      this.wrapper.addView(this.contactTableView);
      return;
      label451:
      ((ContactDetailItemSingleView)localObject).setLabel(getString(2131692046));
      ((ContactDetailItemSingleView)localObject).setContent(this.contact.getMark());
    }
  }
  
  private void refreshCustomTableView()
  {
    Object localObject1 = this.contact.getCustoms();
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      this.customTableView = new ContactTableView(getActivity());
      Object localObject2 = new ContactDetailItemContainerView(getActivity());
      ((ContactDetailItemContainerView)localObject2).setLabel(ContactCustom.ORG_KEY);
      Object localObject3 = ((ArrayList)localObject1).iterator();
      Object localObject4;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (ContactCustom)((Iterator)localObject3).next();
        if (((ContactCustom)localObject4).getType() == 4)
        {
          ContactDetailItemView localContactDetailItemView = new ContactDetailItemView(getActivity());
          localContactDetailItemView.setContent(((ContactCustom)localObject4).getValue());
          localContactDetailItemView.setItemType(ContactBaseItemView.ContactItemType.TYPE_CUSTOM);
          localContactDetailItemView.setNodeValueOperateCallback(this.detailItemClickCallBack);
          ((ContactDetailItemContainerView)localObject2).addContentNode(localContactDetailItemView);
        }
      }
      if (((ContactDetailItemContainerView)localObject2).getContentNodeCount() > 0) {
        this.customTableView.addView((View)localObject2);
      }
      localObject2 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ContactCustom)((Iterator)localObject2).next();
        if (((ContactCustom)localObject3).getType() == 5)
        {
          localObject4 = new ContactDetailItemSingleView(getActivity());
          ((ContactDetailItemSingleView)localObject4).setLabel(((ContactCustom)localObject3).getKey());
          ((ContactDetailItemSingleView)localObject4).setContent(((ContactCustom)localObject3).getValue());
          ((ContactDetailItemSingleView)localObject4).setItemType(ContactBaseItemView.ContactItemType.TYPE_CUSTOM);
          ((ContactDetailItemSingleView)localObject4).setNodeValueOperateCallback(this.detailItemClickCallBack);
          this.customTableView.addView((View)localObject4);
        }
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ContactCustom)((Iterator)localObject1).next();
        if (((ContactCustom)localObject2).getType() == 0)
        {
          localObject3 = new ContactDetailItemSingleView(getActivity());
          ((ContactDetailItemSingleView)localObject3).setLabel(((ContactCustom)localObject2).getKey());
          ((ContactDetailItemSingleView)localObject3).setContent(((ContactCustom)localObject2).getValue());
          ((ContactDetailItemSingleView)localObject3).setItemType(ContactBaseItemView.ContactItemType.TYPE_CUSTOM);
          ((ContactDetailItemSingleView)localObject3).setNodeValueOperateCallback(this.detailItemClickCallBack);
          this.customTableView.addView((View)localObject3);
        }
      }
      if (this.customTableView.getChildCount() > 0) {
        this.wrapper.addView(this.customTableView);
      }
    }
  }
  
  private void refreshInfoTableView()
  {
    Object localObject1 = this.contact.getCustoms();
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      this.infoTableView = new ContactTableView(getActivity());
      Object localObject2 = new ContactDetailItemContainerView(getActivity());
      ((ContactDetailItemContainerView)localObject2).setLabel(ContactCustom.TEL_KEY);
      Object localObject3 = ((ArrayList)localObject1).iterator();
      ContactCustom localContactCustom;
      ContactDetailItemView localContactDetailItemView;
      while (((Iterator)localObject3).hasNext())
      {
        localContactCustom = (ContactCustom)((Iterator)localObject3).next();
        if (localContactCustom.getType() == 1)
        {
          localContactDetailItemView = new ContactDetailItemView(getActivity());
          localContactDetailItemView.setItemType(ContactBaseItemView.ContactItemType.TYPE_TEL);
          localContactDetailItemView.setContent(localContactCustom.getValue());
          localContactDetailItemView.setLinkContent(true);
          localContactDetailItemView.setNodeValueOperateCallback(this.detailItemClickCallBack);
          ((ContactDetailItemContainerView)localObject2).addContentNode(localContactDetailItemView);
        }
      }
      if (((ContactDetailItemContainerView)localObject2).getContentNodeCount() > 0) {
        this.infoTableView.addView((View)localObject2);
      }
      localObject2 = new ContactDetailItemContainerView(getActivity());
      ((ContactDetailItemContainerView)localObject2).setLabel(ContactCustom.ADDRESS_KEY);
      localObject3 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localContactCustom = (ContactCustom)((Iterator)localObject3).next();
        if (localContactCustom.getType() == 2)
        {
          localContactDetailItemView = new ContactDetailItemView(getActivity());
          localContactDetailItemView.setContent(localContactCustom.getValue());
          localContactDetailItemView.setItemType(ContactBaseItemView.ContactItemType.TYPE_ADDRESS);
          localContactDetailItemView.setNodeValueOperateCallback(this.detailItemClickCallBack);
          ((ContactDetailItemContainerView)localObject2).addContentNode(localContactDetailItemView);
        }
      }
      if (((ContactDetailItemContainerView)localObject2).getContentNodeCount() > 0) {
        this.infoTableView.addView((View)localObject2);
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ContactCustom)((Iterator)localObject1).next();
        if (((ContactCustom)localObject2).getType() == 3)
        {
          localObject3 = new ContactDetailItemSingleView(getActivity());
          ((ContactDetailItemSingleView)localObject3).setLabel(((ContactCustom)localObject2).getKey());
          ((ContactDetailItemSingleView)localObject3).setContent(((ContactCustom)localObject2).getValue());
          if (this.schedule != null) {}
          for (boolean bool = true;; bool = false)
          {
            ((ContactDetailItemSingleView)localObject3).setLinkContent(bool);
            ((ContactDetailItemSingleView)localObject3).setNodeValueOperateCallback(this.detailItemClickCallBack);
            ((ContactDetailItemSingleView)localObject3).setItemType(ContactBaseItemView.ContactItemType.TYPE_BIRTHDAY);
            this.infoTableView.addView((View)localObject3);
            break;
          }
        }
      }
      if (this.infoTableView.getChildCount() > 0) {
        this.wrapper.addView(this.infoTableView);
      }
    }
  }
  
  private void refreshTopBar()
  {
    if (this.from == 4)
    {
      if (this.nameListType == NameListContact.NameListContactType.BLACK.ordinal()) {
        this.topBar.setTitle(2131690878);
      }
      for (;;)
      {
        this.topBar.getButtonRight().setVisibility(8);
        return;
        this.topBar.setTitle(2131721876);
      }
    }
    if (QMContactManager.sharedInstance().isStranger(this.contact))
    {
      if (this.contact.getType() == MailContact.ContactType.HistoryContact)
      {
        this.topBar.setButtonRightIconView(2130840803);
        this.topBar.getButtonRight().setVisibility(0);
        this.topBar.getButtonRight().setOnClickListener(new ContactDetailFragment.7(this));
        return;
      }
      this.topBar.getButtonRight().setVisibility(8);
      return;
    }
    this.topBar.setButtonRightIconView(2130841091);
    this.topBar.getButtonRight().setVisibility(0);
    this.topBar.getButtonRight().setOnClickListener(new ContactDetailFragment.8(this));
  }
  
  public void initDataSource() {}
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initTopBar();
    bindButtonListener();
    DataCollector.logEvent("Event_Contact_Go_Profile");
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    paramViewHolder = (FrameLayout)super.initUI(paramViewHolder);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1, 48);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131299664), 0, 0);
    this.mLayout = View.inflate(getActivity(), 2131559083, null);
    this.mLayout.setLayoutParams(localLayoutParams);
    this.mLayout.setVerticalFadingEdgeEnabled(false);
    this.container = ((LinearLayout)this.mLayout.findViewById(2131365322));
    this.wrapper = ((LinearLayout)this.mLayout.findViewById(2131365265));
    this.goHistoryMailBtn = ((Button)this.mLayout.findViewById(2131365263));
    this.setVipBtn = ((Button)this.mLayout.findViewById(2131365264));
    this.addContactBtn = ((Button)this.mLayout.findViewById(2131365262));
    this.contactAddedTip = ((TextView)this.mLayout.findViewById(2131365240));
    this.nameListRemoveBtn = ((Button)this.mLayout.findViewById(2131363560));
    paramViewHolder.addView(this.mLayout);
    return paramViewHolder;
  }
  
  public void onBackPressed()
  {
    overridePendingTransition(2130772421, 2130772420);
    super.onBackPressed();
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.syncContactWatcher, paramBoolean);
    Watchers.bind(this.vipContactWatcher, paramBoolean);
    Watchers.bind(this.deleteNameListWatcher, paramBoolean);
    QMPrivateProtocolManager.sharedInstance().bindSyncPhotoWatcher(this.syncPhotoWatcher, paramBoolean);
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onFragmentResult(int paramInt1, int paramInt2, HashMap<String, Object> paramHashMap)
  {
    if ((paramInt2 == -1) && (paramInt1 == 100))
    {
      if ((paramHashMap == null) || (paramHashMap.get("edit_delete_flag") == null)) {
        break label47;
      }
      Log.i(TAG, "onFragmentResult EDIT_DELETE_FLAG");
      popBackStack();
    }
    for (;;)
    {
      super.onFragmentResult(paramInt1, paramInt2, paramHashMap);
      return;
      label47:
      if ((paramHashMap != null) && (paramHashMap.get("edit_new_id") != null)) {
        this.contactId = ((Long)paramHashMap.get("edit_new_id")).longValue();
      }
      refreshData();
      render(0);
    }
  }
  
  public void onRelease() {}
  
  public int refreshData()
  {
    this.contact = QMContactManager.sharedInstance().getContactById(this.contactId);
    if (this.contact == null) {
      this.contact = QMContactManager.sharedInstance().getContactByAccountAndEmailAndName(this.accountId, this.address, this.name);
    }
    if ((this.contactId != 0L) && (this.contact == null)) {
      popBackStack();
    }
    if ((this.contact == null) || (this.contact.getOfflineType() == 3))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new ContactEmail(this.address));
      this.contact = new MailContact();
      this.contact.setName(this.name);
      this.contact.setNick(this.name);
      this.contact.setEmails(localArrayList);
      this.contact.setAddress(this.address);
      this.contact.setAccountId(this.accountId);
      this.contactId = 0L;
    }
    for (;;)
    {
      this.sameContact = QMContactManager.sharedInstance().getSameEmailContactWhenSync(this.contact, this.contact.getId());
      return 0;
      this.contactId = this.contact.getId();
      this.schedule = QMCalendarManager.getInstance().getScheduleByCid(this.contactId);
    }
  }
  
  public void render(int paramInt)
  {
    this.wrapper.removeAllViews();
    refreshTopBar();
    refreshContactTableView();
    refreshInfoTableView();
    refreshCustomTableView();
    refreshButton();
    endTrace(TAG);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactDetailFragment
 * JD-Core Version:    0.7.0.1
 */