package com.tencent.qqmail.activity.contacts.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.activity.media.QMMediaBottom;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.media.QMAlbumManager.QMMediaIntentType;
import com.tencent.qqmail.model.qmdomain.ContactCustom;
import com.tencent.qqmail.model.qmdomain.ContactEmail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import moai.fragment.base.BaseFragment.TransitionConfig;

public class ContactsMergeFragment
  extends ContactsBaseFragment
{
  public static final int CHOOSE_NAME_POSITION = 1000;
  public static final String CHOOSE_NAME_POSITION_KEY = "CHOOSE_NAME_POSITION_KEY";
  public static final String ITEM_INDEX_IN_MERGE_BY_EMAIL = "ITEM_INDEX_IN_MERGE_BY_EMAIL";
  public static final String TAG = ContactsMergeFragment.class.getSimpleName();
  private int checkCnt = 0;
  private int itemSize = 0;
  private QMContentLoadingView loadingView;
  private QMMediaBottom mMergeButton;
  private ListView mMergeListView;
  private MegeByNameData megeByNameData;
  private ContactsMergeAdapter mergeAdaptor;
  private MegeByEmailData mergeByEmailData;
  private SortByAccountIdComparator sortByAccountIdComparator = new SortByAccountIdComparator(null);
  private SortByPMLogicComparator sortByPMLogicComparator = new SortByPMLogicComparator(null);
  
  protected ContactsMergeFragment()
  {
    super(false);
  }
  
  private void changeMergeButtonTextByCheckCnt()
  {
    updateMergeButton(this.checkCnt);
  }
  
  private void checkMergeButtonEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.checkCnt += 1;
      if (this.checkCnt <= 0) {
        break label60;
      }
      changeMergeButtonTextByCheckCnt();
    }
    for (;;)
    {
      if (this.checkCnt != this.itemSize) {
        break label67;
      }
      getTopBar().setButtonRightNormal(2131719470);
      return;
      this.checkCnt -= 1;
      break;
      label60:
      resetMergeButton();
    }
    label67:
    getTopBar().setButtonRightNormal(2131719469);
  }
  
  private void deleteDffentAccountHasOneChildeAccount(Map<String, List<MailContact>> paramMap)
  {
    if (paramMap == null) {}
    for (;;)
    {
      return;
      HashSet localHashSet = new HashSet();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (isDffentAccountHasOneChildeAccount((List)paramMap.get(str))) {
          localHashSet.add(str);
        }
      }
      paramMap = paramMap.keySet().iterator();
      while (paramMap.hasNext()) {
        if (localHashSet.contains((String)paramMap.next())) {
          paramMap.remove();
        }
      }
    }
  }
  
  private Map<String, Set<ContactEmail>> generateItemEmailsMap(Map<String, List<MailContact>> paramMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = paramMap.keySet().iterator();
    String str;
    Object localObject;
    if (localIterator1.hasNext())
    {
      str = (String)localIterator1.next();
      localObject = (Set)localHashMap.get(str);
      if (localObject != null) {
        break label169;
      }
      localObject = new HashSet();
      localHashMap.put(str, localObject);
    }
    label169:
    for (;;)
    {
      Iterator localIterator2 = ((List)paramMap.get(str)).iterator();
      while (localIterator2.hasNext())
      {
        MailContact localMailContact = (MailContact)localIterator2.next();
        if (localMailContact == null) {
          QMLog.log(5, TAG, "illegal state: null contact in email:" + str);
        } else {
          ((Set)localObject).addAll(localMailContact.getEmails());
        }
      }
      break;
      return localHashMap;
    }
  }
  
  private Map<String, Set<ContactCustom>> generateItemPhonesMap(Map<String, List<MailContact>> paramMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = paramMap.keySet().iterator();
    String str;
    Object localObject1;
    if (localIterator1.hasNext())
    {
      str = (String)localIterator1.next();
      localObject1 = (Set)localHashMap.get(str);
      if (localObject1 != null) {
        break label207;
      }
      localObject1 = new HashSet();
      localHashMap.put(str, localObject1);
    }
    label207:
    for (;;)
    {
      Iterator localIterator2 = ((List)paramMap.get(str)).iterator();
      for (;;)
      {
        if (localIterator2.hasNext())
        {
          localObject2 = (MailContact)localIterator2.next();
          if (localObject2 == null) {
            QMLog.log(5, TAG, "illegal state: null contact in item:" + str);
          }
        }
        else
        {
          break;
        }
        Object localObject2 = ((MailContact)localObject2).getCustoms().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ContactCustom localContactCustom = (ContactCustom)((Iterator)localObject2).next();
          if (localContactCustom.getType() == 1) {
            ((Set)localObject1).add(localContactCustom);
          }
        }
      }
      return localHashMap;
    }
  }
  
  private List<MailContact> getContactsByIndexInMergeByEmailGroup(int paramInt)
  {
    Object localObject = this.mergeByEmailData.emailList;
    if ((localObject == null) || (paramInt >= ((List)localObject).size())) {
      return new ArrayList();
    }
    localObject = (String)((List)localObject).get(paramInt);
    return (List)this.mergeByEmailData.emalContactsMap.get(localObject);
  }
  
  private boolean hasBirthDayCustom(MailContact paramMailContact)
  {
    if ((paramMailContact == null) || (paramMailContact.getCustoms() == null)) {
      return false;
    }
    paramMailContact = paramMailContact.getCustoms().iterator();
    while (paramMailContact.hasNext())
    {
      ContactCustom localContactCustom = (ContactCustom)paramMailContact.next();
      if ((localContactCustom != null) && (localContactCustom.getType() == 3)) {
        return true;
      }
    }
    return false;
  }
  
  private void initListView()
  {
    this.mergeAdaptor = new ContactsMergeAdapter(this.megeByNameData, this.mergeByEmailData);
    this.mMergeListView.setAdapter(this.mergeAdaptor);
    this.mergeAdaptor.setOnItemClickListener(new ContactsMergeFragment.2(this));
  }
  
  private void initMergeButton(View paramView)
  {
    this.mMergeButton = ((QMMediaBottom)paramView.findViewById(2131365301));
    this.mMergeButton.init(getActivity());
    updateMergeButton(0);
    this.mMergeButton.addButton.setOnClickListener(new ContactsMergeFragment.1(this));
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(2131692052);
    localQMTopBar.setButtonLeftNormal(2131692014);
    localQMTopBar.setButtonRightNormal(2131719469);
    if (noMergeData())
    {
      localQMTopBar.getButtonRight().setEnabled(false);
      ((TextView)localQMTopBar.getButtonRight()).setTextColor(getResources().getColor(2131165860));
    }
    localQMTopBar.setButtonLeftOnclickListener(new ContactsMergeFragment.3(this));
    localQMTopBar.setButtonRightOnclickListener(new ContactsMergeFragment.4(this, localQMTopBar));
    localQMTopBar.setCenterOnclickListener(new ContactsMergeFragment.5(this));
    localQMTopBar.setButtonLeftOnclickListener(new ContactsMergeFragment.6(this));
  }
  
  private boolean isDffentAccountHasOneChildeAccount(List<MailContact> paramList)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramList == null) || (paramList.size() == 0))
    {
      bool1 = false;
      return bool1;
    }
    Collections.sort(paramList, this.sortByAccountIdComparator);
    int j = ((MailContact)paramList.get(0)).getAccountId();
    int i = 1;
    while (i < paramList.size()) {
      if (((MailContact)paramList.get(i)).getAccountId() != j)
      {
        j = ((MailContact)paramList.get(i)).getAccountId();
        i += 1;
      }
      else
      {
        return false;
      }
    }
    paramList = paramList.iterator();
    do
    {
      bool1 = bool2;
      if (!paramList.hasNext()) {
        break;
      }
    } while (((MailContact)paramList.next()).getHashType() == -1);
    return false;
  }
  
  private void linkTwoContact(MailContact paramMailContact1, MailContact paramMailContact2)
  {
    if ((paramMailContact1 == null) || (paramMailContact2 == null)) {
      return;
    }
    paramMailContact2.setAddress(paramMailContact1.getAddress());
    paramMailContact2.setPinyin(paramMailContact1.getPinyin());
    paramMailContact2.setFullPinyin(paramMailContact1.getFullPinyin());
    paramMailContact2.setNick(paramMailContact1.getNick());
    paramMailContact2.setName(paramMailContact1.getName());
    paramMailContact2.setMark(paramMailContact1.getMark());
    paramMailContact2.setEmails(paramMailContact1.getEmails());
    paramMailContact2.setCustoms(paramMailContact1.getCustoms());
    paramMailContact2.setHash(MailContact.generateHash(paramMailContact2));
    QMContactManager.sharedInstance().syncBirthdayCalendarEvent(paramMailContact2);
    QMContactManager.sharedInstance().syncContact(paramMailContact2, paramMailContact2);
  }
  
  private void mergeByEmail()
  {
    boolean[] arrayOfBoolean = this.mergeByEmailData.checkArray;
    if (arrayOfBoolean == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < arrayOfBoolean.length)
      {
        if (arrayOfBoolean[i] != 0)
        {
          List localList = getContactsByIndexInMergeByEmailGroup(i);
          if ((localList != null) && (this.mergeByEmailData.positionChooseName != null))
          {
            MailContact localMailContact = (MailContact)localList.get(this.mergeByEmailData.positionChooseName[i]);
            mergeParentContactInfoForMergeByEmail(i, localMailContact, localList);
            if (localMailContact != null) {
              mergeOneItem(localList, localMailContact);
            }
          }
        }
        i += 1;
      }
    }
  }
  
  private void mergeByName()
  {
    boolean[] arrayOfBoolean = this.megeByNameData.checkArray;
    if (arrayOfBoolean == null) {
      return;
    }
    int i = 0;
    label15:
    Object localObject;
    if (i < arrayOfBoolean.length) {
      if ((arrayOfBoolean[i] != 0) && (this.megeByNameData.nameList != null))
      {
        localObject = (String)this.megeByNameData.nameList.get(i);
        if (localObject != null) {
          break label65;
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label15;
      break;
      label65:
      localObject = (List)this.megeByNameData.nameContactsMap.get(localObject);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        MailContact localMailContact = (MailContact)((List)localObject).get(0);
        mergeParentContactInfoForMergeByName(localMailContact, (List)localObject);
        mergeOneItem((List)localObject, localMailContact);
      }
    }
  }
  
  private void mergeContact()
  {
    long l1 = System.currentTimeMillis();
    mergeByName();
    mergeByEmail();
    long l2 = System.currentTimeMillis();
    QMLog.log(4, TAG, "mergeContact startTime : " + l1 + " endTime : " + l2 + " totalTime: " + (l2 - l1));
    DataCollector.logEvent("Event_Contact_Merge");
    if (isAttachedToActivity()) {
      new QMTips(getActivity()).showSuccess(getString(2131692053));
    }
  }
  
  private void mergeOneItem(List<MailContact> paramList, MailContact paramMailContact)
  {
    if ((paramList == null) || (paramMailContact == null) || (paramList.size() == 0)) {
      return;
    }
    Collections.sort(paramList, this.sortByAccountIdComparator);
    int j = paramMailContact.getAccountId();
    long l = paramMailContact.getId();
    paramList = paramList.iterator();
    int i = j;
    label48:
    MailContact localMailContact;
    if (paramList.hasNext())
    {
      localMailContact = (MailContact)paramList.next();
      if (localMailContact.getAccountId() != j) {
        break label100;
      }
      if (localMailContact.getId() == l) {
        break label136;
      }
      QMContactManager.sharedInstance().deleteContact(localMailContact);
    }
    label136:
    for (;;)
    {
      break label48;
      break;
      label100:
      if (i != localMailContact.getAccountId())
      {
        i = localMailContact.getAccountId();
        linkTwoContact(paramMailContact, localMailContact.clone());
      }
      else
      {
        QMContactManager.sharedInstance().deleteContact(localMailContact);
      }
    }
  }
  
  private void mergeParentContactInfo(MailContact paramMailContact, List<MailContact> paramList)
  {
    boolean bool = hasBirthDayCustom(paramMailContact);
    long l = paramMailContact.getId();
    Object localObject1;
    Object localObject2;
    if (!bool)
    {
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MailContact)((Iterator)localObject1).next();
        if ((((MailContact)localObject2).getId() != l) && (AccountManager.shareInstance().getAccountList().isDefaultMailAccount(((MailContact)localObject2).getAccountId())) && (hasBirthDayCustom((MailContact)localObject2))) {
          l = ((MailContact)localObject2).getId();
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((bool) || (i != 0)) {}
      Object localObject3;
      for (i = 1; i != 0; i = 0)
      {
        localObject1 = paramList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MailContact)((Iterator)localObject1).next();
          if (((MailContact)localObject2).getId() != l)
          {
            localObject2 = ((MailContact)localObject2).getCustoms().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (ContactCustom)((Iterator)localObject2).next();
              if (((ContactCustom)localObject3).getType() == 3) {
                ((ContactCustom)localObject3).setType(0);
              }
            }
          }
        }
      }
      localObject2 = new HashSet();
      localObject1 = new HashSet();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject3 = (MailContact)paramList.next();
        ((Set)localObject2).addAll(((MailContact)localObject3).getCustoms());
        localObject3 = ((MailContact)localObject3).getMark();
        if ((localObject3 != null) && (!TextUtils.isEmpty(((String)localObject3).trim()))) {
          ((Set)localObject1).add(localObject3);
        }
      }
      paramMailContact.setCustoms(new ArrayList((Collection)localObject2));
      paramList = new StringBuilder();
      localObject2 = ((Set)localObject1).iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramList.append((String)((Iterator)localObject2).next()).append(';');
      }
      if (((Set)localObject1).size() > 0) {
        paramList.deleteCharAt(paramList.length() - 1);
      }
      paramMailContact.setMark(paramList.toString());
      paramMailContact.setHash(MailContact.generateHash(paramMailContact));
      return;
    }
  }
  
  private void mergeParentContactInfoForMergeByEmail(int paramInt, MailContact paramMailContact, List<MailContact> paramList)
  {
    if ((paramMailContact == null) || (paramInt < 0) || (paramInt >= this.mergeByEmailData.emailList.size())) {
      return;
    }
    Object localObject = (String)this.mergeByEmailData.emailList.get(paramInt);
    localObject = (Set)this.mergeByEmailData.emailToEmailsMap.get(localObject);
    if (localObject != null) {
      paramMailContact.setEmails(new ArrayList((Collection)localObject));
    }
    mergeParentContactInfo(paramMailContact, paramList);
    QMContactManager.sharedInstance().syncBirthdayCalendarEvent(paramMailContact);
    QMContactManager.sharedInstance().syncContact(paramMailContact, paramMailContact);
  }
  
  private void mergeParentContactInfoForMergeByName(MailContact paramMailContact, List<MailContact> paramList)
  {
    if (paramMailContact == null) {
      return;
    }
    Object localObject = paramMailContact.getName();
    localObject = (Set)this.megeByNameData.nameEmailsMap.get(localObject);
    if (localObject != null) {
      paramMailContact.setEmails(new ArrayList((Collection)localObject));
    }
    mergeParentContactInfo(paramMailContact, paramList);
    QMContactManager.sharedInstance().syncBirthdayCalendarEvent(paramMailContact);
    QMContactManager.sharedInstance().syncContact(paramMailContact, paramMailContact);
  }
  
  private boolean noMergeData()
  {
    return (this.mergeByEmailData.getMergeByEmailGroupSize() == 0) && (this.megeByNameData.getMergeByNameGroupSize() == 0);
  }
  
  private void resetMergeButton()
  {
    updateMergeButton(0);
  }
  
  private void selectAllOrCanel(boolean paramBoolean)
  {
    int j = 0;
    boolean[] arrayOfBoolean = this.mergeByEmailData.checkArray;
    int i;
    if (arrayOfBoolean != null)
    {
      i = 0;
      while (i < arrayOfBoolean.length)
      {
        arrayOfBoolean[i] = paramBoolean;
        i += 1;
      }
    }
    arrayOfBoolean = this.megeByNameData.checkArray;
    if (arrayOfBoolean != null)
    {
      i = j;
      while (i < arrayOfBoolean.length)
      {
        arrayOfBoolean[i] = paramBoolean;
        i += 1;
      }
    }
  }
  
  private void updateMergeButton(int paramInt)
  {
    this.mMergeButton.updateAddButton(QMAlbumManager.QMMediaIntentType.QMMediaIntentType_Merge, paramInt);
  }
  
  public void initDataSource()
  {
    long l1 = System.currentTimeMillis();
    this.mergeByEmailData = new MegeByEmailData();
    this.megeByNameData = new MegeByNameData();
    long l2 = System.currentTimeMillis();
    QMLog.log(4, TAG, "mergeContact initMergeData startTime : " + l1 + " endTime : " + l2 + " totalTime: " + (l2 - l1));
    this.itemSize = (this.mergeByEmailData.getMergeByEmailGroupSize() + this.megeByNameData.getMergeByNameGroupSize());
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    this.loadingView = ((QMContentLoadingView)paramView.findViewById(2131365305));
    this.mMergeListView = ((ListView)paramView.findViewById(2131365309));
    if (noMergeData())
    {
      this.mMergeListView.setVisibility(8);
      this.loadingView.showTips(2131692062);
    }
    for (;;)
    {
      initMergeButton(paramView);
      initTopBar();
      DataCollector.logEvent("Event_Enter_Merge_Contact_List");
      return;
      initListView();
    }
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    startTrace();
    paramViewHolder = (FrameLayout)super.initUI(paramViewHolder);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1, 48);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131299664), 0, 0);
    View localView = View.inflate(getActivity(), 2131559100, null);
    localView.setLayoutParams(localLayoutParams);
    localView.setVerticalFadingEdgeEnabled(false);
    paramViewHolder.addView(localView);
    paramViewHolder.setBackgroundColor(getResources().getColor(2131167684));
    return paramViewHolder;
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public BaseFragment.TransitionConfig onFetchTransaction()
  {
    return SCALE_TRANSITION_CONFIG;
  }
  
  public BaseFragment.TransitionConfig onFetchTransitionConfig()
  {
    return SCALE_TRANSITION_CONFIG;
  }
  
  public void onFragmentResult(int paramInt1, int paramInt2, HashMap<String, Object> paramHashMap)
  {
    if ((paramInt2 == -1) && (paramInt1 == 1000) && (paramHashMap != null) && (this.mergeByEmailData.positionChooseName != null))
    {
      int i = ((Integer)paramHashMap.get("CHOOSE_NAME_POSITION_KEY")).intValue();
      int j = ((Integer)paramHashMap.get("ITEM_INDEX_IN_MERGE_BY_EMAIL")).intValue();
      this.mergeByEmailData.positionChooseName[j] = i;
      this.mergeAdaptor.notifyDataSetChanged();
    }
    super.onFragmentResult(paramInt1, paramInt2, paramHashMap);
  }
  
  public void onRelease() {}
  
  public int refreshData()
  {
    return 0;
  }
  
  public void render(int paramInt)
  {
    endTrace(TAG);
  }
  
  class DefaulstAccountFirstComparator
    implements Comparator
  {
    private DefaulstAccountFirstComparator() {}
    
    public int compare(Object paramObject1, Object paramObject2)
    {
      if (paramObject2 == null) {}
      boolean bool2;
      do
      {
        boolean bool1;
        do
        {
          return 1;
          if (paramObject1 == null) {
            return -1;
          }
          paramObject1 = (MailContact)paramObject1;
          paramObject2 = (MailContact)paramObject2;
          bool1 = AccountManager.shareInstance().getAccountList().isDefaultMailAccount(paramObject1.getAccountId());
          bool2 = AccountManager.shareInstance().getAccountList().isDefaultMailAccount(paramObject2.getAccountId());
        } while ((bool1) && (bool2));
        if (bool1) {
          return -1;
        }
      } while (!bool2);
      return 1;
    }
  }
  
  public class MegeByEmailData
  {
    public boolean[] checkArray;
    public List<String> emailList;
    public Map<String, Set<ContactCustom>> emailPhonesMap;
    public Map<String, Set<ContactEmail>> emailToEmailsMap;
    public Map<String, List<MailContact>> emalContactsMap = new HashMap();
    public int[] positionChooseName;
    
    public MegeByEmailData()
    {
      createMapForMergeByEmail();
    }
    
    private void createMapForMergeByEmail()
    {
      Object localObject2 = QMContactManager.sharedInstance().getEmailsNeededByMerge();
      if ((localObject2 == null) || (((Set)localObject2).size() == 0)) {
        return;
      }
      Object localObject1 = new HashMap();
      localObject2 = ((Set)localObject2).iterator();
      Object localObject4;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject4 = QMContactManager.sharedInstance().getEmailContactIdsMap((String)localObject3);
        if ((localObject4 != null) && (((Set)localObject4).size() > 0)) {
          ((Map)localObject1).put(localObject3, localObject4);
        }
      }
      Object localObject3 = ((Map)localObject1).keySet().iterator();
      localObject2 = new HashSet();
      Object localObject5;
      Object localObject6;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        localObject5 = (Set)((Map)localObject1).get(localObject4);
        localObject6 = ((Map)localObject1).keySet().iterator();
        while ((!((Set)localObject2).contains(localObject4)) && (((Iterator)localObject6).hasNext()))
        {
          String str = (String)((Iterator)localObject6).next();
          if ((!((Set)localObject2).contains(str)) && (!str.equals(localObject4)))
          {
            Set localSet = (Set)((Map)localObject1).get(str);
            if (!Collections.disjoint((Collection)localObject5, localSet))
            {
              ((Set)localObject5).removeAll(localSet);
              ((Set)localObject5).addAll(localSet);
              ((Set)localObject2).add(str);
            }
          }
        }
      }
      localObject3 = ((Map)localObject1).keySet().iterator();
      while (((Iterator)localObject3).hasNext()) {
        if (((Set)localObject2).contains((String)((Iterator)localObject3).next())) {
          ((Iterator)localObject3).remove();
        }
      }
      localObject2 = ((Map)localObject1).keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject5 = (Set)((Map)localObject1).get(localObject3);
        localObject4 = new ArrayList();
        localObject5 = ((Set)localObject5).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (Long)((Iterator)localObject5).next();
          localObject6 = QMContactManager.sharedInstance().getContactById(((Long)localObject6).longValue());
          if (localObject6 != null) {
            ((List)localObject4).add(localObject6);
          }
        }
        if (((List)localObject4).size() > 0) {
          this.emalContactsMap.put(localObject3, localObject4);
        }
      }
      ContactsMergeFragment.this.deleteDffentAccountHasOneChildeAccount(this.emalContactsMap);
      this.emailList = new ArrayList(this.emalContactsMap.keySet());
      this.positionChooseName = new int[this.emailList.size()];
      this.checkArray = new boolean[this.emailList.size()];
      localObject1 = this.emalContactsMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        Collections.sort((List)this.emalContactsMap.get(localObject2), ContactsMergeFragment.this.sortByPMLogicComparator);
      }
      this.emailToEmailsMap = ContactsMergeFragment.this.generateItemEmailsMap(this.emalContactsMap);
      this.emailPhonesMap = new HashMap();
    }
    
    public int getMergeByEmailGroupSize()
    {
      if (this.emailList == null) {
        return 0;
      }
      return this.emailList.size();
    }
  }
  
  public class MegeByNameData
  {
    public boolean[] checkArray;
    private boolean isNoMergeByNameData = false;
    public Map<String, List<MailContact>> nameContactsMap = new HashMap();
    public Map<String, Set<ContactEmail>> nameEmailsMap;
    public List<String> nameList;
    public Map<String, Set<ContactCustom>> namePhonesMap;
    
    public MegeByNameData()
    {
      createMapForMergeByName();
    }
    
    private void createMapForMergeByName()
    {
      List localList = QMContactManager.sharedInstance().getSameNameContactList();
      if ((localList == null) || (localList.size() == 0)) {}
      for (;;)
      {
        return;
        int i = 0;
        Object localObject2;
        while (i < localList.size())
        {
          MailContact localMailContact = (MailContact)localList.get(i);
          String str = localMailContact.getName();
          localObject2 = (List)this.nameContactsMap.get(str);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new ArrayList();
            this.nameContactsMap.put(str, localObject1);
          }
          ((List)localObject1).add(localMailContact);
          i += 1;
        }
        ContactsMergeFragment.this.deleteDffentAccountHasOneChildeAccount(this.nameContactsMap);
        this.nameEmailsMap = ContactsMergeFragment.this.generateItemEmailsMap(this.nameContactsMap);
        this.namePhonesMap = ContactsMergeFragment.this.generateItemPhonesMap(this.nameContactsMap);
        this.nameList = new ArrayList(this.nameEmailsMap.keySet());
        this.checkArray = new boolean[this.nameList.size()];
        Object localObject1 = this.nameList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          Collections.sort((List)this.nameContactsMap.get(localObject2), new ContactsMergeFragment.DefaulstAccountFirstComparator(ContactsMergeFragment.this, null));
        }
      }
    }
    
    public int getMergeByNameGroupSize()
    {
      if (this.nameList == null) {
        return 0;
      }
      return this.nameList.size();
    }
  }
  
  class SortByAccountIdComparator
    implements Comparator
  {
    private SortByAccountIdComparator() {}
    
    public int compare(Object paramObject1, Object paramObject2)
    {
      if (paramObject2 == null) {}
      do
      {
        return 1;
        if (paramObject1 == null) {
          return -1;
        }
        paramObject1 = (MailContact)paramObject1;
        paramObject2 = (MailContact)paramObject2;
      } while (paramObject1.getAccountId() > paramObject2.getAccountId());
      if (paramObject1.getAccountId() < paramObject2.getAccountId()) {
        return -1;
      }
      return 0;
    }
  }
  
  class SortByPMLogicComparator
    implements Comparator
  {
    private static final char LETTER_HEAD = '@';
    private static final char LETTER_TAIL = '[';
    
    private SortByPMLogicComparator() {}
    
    private int DefaulstAccountFirst(MailContact paramMailContact1, MailContact paramMailContact2)
    {
      boolean bool1 = AccountManager.shareInstance().getAccountList().isDefaultMailAccount(paramMailContact1.getAccountId());
      boolean bool2 = AccountManager.shareInstance().getAccountList().isDefaultMailAccount(paramMailContact2.getAccountId());
      if ((bool1) && (bool2)) {
        return sortByPingyin(paramMailContact1, paramMailContact2);
      }
      if (bool1) {
        return -1;
      }
      if (bool2) {
        return 1;
      }
      return sortByPingyin(paramMailContact1, paramMailContact2);
    }
    
    private int compareName(String paramString1, String paramString2)
    {
      if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
        return 1;
      }
      return paramString1.compareTo(paramString2);
    }
    
    private boolean isLetter(char paramChar)
    {
      return (paramChar > '@') && (paramChar < '[');
    }
    
    private int sortByPingyin(MailContact paramMailContact1, MailContact paramMailContact2)
    {
      String str1 = paramMailContact1.getPinyin();
      String str2 = paramMailContact2.getPinyin();
      paramMailContact1 = paramMailContact1.getName();
      paramMailContact2 = paramMailContact2.getName();
      if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2))) {
        return compareName(paramMailContact1, paramMailContact2);
      }
      if (TextUtils.isEmpty(str1)) {
        return 1;
      }
      if (TextUtils.isEmpty(str2)) {
        return -1;
      }
      return compareName(paramMailContact1, paramMailContact2);
    }
    
    public int compare(Object paramObject1, Object paramObject2)
    {
      if (paramObject2 == null) {}
      String str1;
      String str2;
      do
      {
        return 1;
        if (paramObject1 == null) {
          return -1;
        }
        paramObject1 = (MailContact)paramObject1;
        paramObject2 = (MailContact)paramObject2;
        str1 = paramObject1.getName();
        str2 = paramObject2.getName();
        if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2))) {
          return DefaulstAccountFirst(paramObject1, paramObject2);
        }
      } while (TextUtils.isEmpty(str1));
      if (TextUtils.isEmpty(str2)) {
        return -1;
      }
      return DefaulstAccountFirst(paramObject1, paramObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsMergeFragment
 * JD-Core Version:    0.7.0.1
 */