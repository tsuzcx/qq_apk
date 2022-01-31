package com.tencent.mobileqq.activity.contact;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatForEnterpriseActivity;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.adapter.CircleSearchResultAdapter;
import com.tencent.mobileqq.adapter.ContactsSearchResultAdapter;
import com.tencent.mobileqq.adapter.VoipContactsSearchResultAdapter;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.ContactFacade;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.search.ContactSearchableFriend;
import com.tencent.mobileqq.search.ContactSearchablePublicAccount;
import com.tencent.mobileqq.search.ContactSearchableSearchHistory;
import com.tencent.mobileqq.search.ContactSearchableTroop;
import com.tencent.mobileqq.search.ContactsSearchableCircleBuddy;
import com.tencent.mobileqq.search.ContactsSearchablePhoneContact;
import com.tencent.mobileqq.search.ContactsSearchableRecentUser;
import com.tencent.mobileqq.search.ConversationSearchAdapter;
import com.tencent.mobileqq.search.ConversationSearchAdapter.SearchResultCallBack;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.SearchAdapterInterface;
import com.tencent.mobileqq.search.SearchableDiscussionMember;
import com.tencent.mobileqq.search.SearchableTroopMember;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import edh;
import edi;
import edj;
import edk;
import edl;
import edm;
import edn;
import edo;
import edp;
import edq;
import edr;
import eds;
import edt;
import edu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class SearchResultDialog
  extends Dialog
  implements Handler.Callback, ConversationSearchAdapter.SearchResultCallBack
{
  private static final int jdField_a_of_type_Int = 555;
  public static final String a = "search_keyword";
  private static final int jdField_b_of_type_Int = 556;
  public static final String b = "circle_contacts_search_count";
  private static final int jdField_c_of_type_Int = 1;
  private static final int jdField_d_of_type_Int = 2;
  private static final int e = 3;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ForwardOperations jdField_a_of_type_ComTencentMobileqqActivityForwardOperations;
  private ContactsSearchResultAdapter jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter;
  private CircleManager jdField_a_of_type_ComTencentMobileqqAppCircleManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SearchAdapterInterface jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List jdField_a_of_type_JavaUtilList;
  private AdapterView.OnItemClickListener jdField_b_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new edm(this);
  private XListView jdField_b_of_type_ComTencentWidgetXListView;
  private String jdField_c_of_type_JavaLangString;
  private String jdField_d_of_type_JavaLangString;
  private int f;
  
  public SearchResultDialog(Context paramContext, int paramInt1, QQAppInterface paramQQAppInterface, int paramInt2)
  {
    super(paramContext, paramInt1);
    this.c = null;
    this.d = null;
    a(paramContext, paramQQAppInterface, paramInt2);
  }
  
  public SearchResultDialog(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    super(paramContext, 2131624528);
    this.c = null;
    this.d = null;
    a(paramContext, paramQQAppInterface, paramInt);
  }
  
  public SearchResultDialog(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, ForwardOperations paramForwardOperations)
  {
    this(paramContext, paramQQAppInterface, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations = paramForwardOperations;
  }
  
  public SearchResultDialog(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this(paramContext, paramQQAppInterface, paramInt);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString("search_keyword" + paramQQAppInterface.a(), "");
  }
  
  public static List a(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (PhoneContactManager)paramQQAppInterface.getManager(10);
    if (localObject != null)
    {
      localObject = ((PhoneContactManager)localObject).b();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localArrayList.add(new ContactsSearchablePhoneContact(paramContext, paramQQAppInterface, (PhoneContact)((Iterator)localObject).next(), paramLong));
        }
      }
    }
    return localArrayList;
  }
  
  public static List a(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt, String paramString, boolean paramBoolean, ArrayList paramArrayList)
  {
    Object localObject = ((DiscussionManager)paramQQAppInterface.getManager(48)).a(paramString);
    paramString = new ArrayList();
    if (localObject != null)
    {
      if ((paramInt == 0) || (paramInt == 3)) {}
      for (long l = 131072L;; l = 65536L)
      {
        String str = paramQQAppInterface.a();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)((Iterator)localObject).next();
          if ((localDiscussionMemberInfo != null) && ((!paramBoolean) || (!localDiscussionMemberInfo.memberUin.equals(str))) && ((paramArrayList == null) || (!paramArrayList.contains(localDiscussionMemberInfo.memberUin)))) {
            paramString.add(new SearchableDiscussionMember(paramContext, paramQQAppInterface, localDiscussionMemberInfo, l, paramLong));
          }
        }
      }
    }
    return paramString;
  }
  
  public static List a(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt, ArrayList paramArrayList)
  {
    DiscussionManager localDiscussionManager = (DiscussionManager)paramQQAppInterface.getManager(48);
    FriendManager localFriendManager = (FriendManager)paramQQAppInterface.getManager(8);
    Object localObject1 = (ContactFacade)paramQQAppInterface.getManager(49);
    ArrayList localArrayList = new ArrayList();
    if ((localFriendManager != null) && (localDiscussionManager != null) && (localObject1 != null))
    {
      Object localObject2 = ((ContactFacade)localObject1).a("-1004");
      if (localObject2 != null)
      {
        if ((paramInt == 0) || (paramInt == 3)) {}
        for (long l = 131072L;; l = 65536L)
        {
          localObject1 = paramQQAppInterface.a();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (DiscussionInfo)((Iterator)localObject2).next();
            if ((localObject3 != null) && (((DiscussionInfo)localObject3).uin != null) && (((DiscussionInfo)localObject3).uin.length() > 0))
            {
              localObject3 = localDiscussionManager.a(((DiscussionInfo)localObject3).uin);
              if (localObject3 != null)
              {
                localObject3 = ((List)localObject3).iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)((Iterator)localObject3).next();
                  if ((localDiscussionMemberInfo != null) && (localDiscussionMemberInfo.memberUin != null) && (!localDiscussionMemberInfo.memberUin.equals(localObject1)))
                  {
                    Friends localFriends = localFriendManager.a(localDiscussionMemberInfo.memberUin);
                    if (((localFriends == null) || (!localFriends.isFriend())) && (!a(localArrayList, localDiscussionMemberInfo)) && ((paramArrayList == null) || (!paramArrayList.contains(localDiscussionMemberInfo.memberUin)))) {
                      localArrayList.add(new SearchableDiscussionMember(paramContext, paramQQAppInterface, localDiscussionMemberInfo, l, paramLong));
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static List a(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt, List paramList, boolean paramBoolean, ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      if ((paramInt == 0) || (paramInt == 3)) {}
      for (long l = 131072L;; l = 65536L)
      {
        String str = paramQQAppInterface.a();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramList.next();
          if ((localTroopMemberInfo != null) && (!localTroopMemberInfo.memberuin.equals("0")) && ((!paramBoolean) || (!localTroopMemberInfo.memberuin.equals(str))) && ((paramArrayList == null) || (!paramArrayList.contains(localTroopMemberInfo.memberuin)))) {
            localArrayList.add(new SearchableTroopMember(paramContext, paramQQAppInterface, localTroopMemberInfo, l, paramLong));
          }
        }
      }
    }
    return localArrayList;
  }
  
  @SuppressLint({"UseSparseArrays"})
  public static List a(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt, boolean paramBoolean, ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (FriendManager)paramQQAppInterface.getManager(8);
    ContactFacade localContactFacade = (ContactFacade)paramQQAppInterface.getManager(49);
    if ((localObject1 != null) && (localContactFacade != null))
    {
      Object localObject2 = ((FriendManager)localObject1).a();
      localObject1 = paramQQAppInterface.a();
      if (localObject2 != null)
      {
        if ((paramInt == 0) || (paramInt == 3)) {}
        for (long l = 131072L;; l = 65536L)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Groups localGroups = (Groups)((Iterator)localObject2).next();
            if (localGroups.group_id != -1006)
            {
              Object localObject3 = localContactFacade.a(String.valueOf(localGroups.group_id));
              if (localObject3 != null)
              {
                localObject3 = ((List)localObject3).iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  Friends localFriends = (Friends)((Iterator)localObject3).next();
                  if (((!paramBoolean) || (!localFriends.uin.equals(localObject1))) && ((paramArrayList == null) || (!paramArrayList.contains(localFriends.uin)))) {
                    localArrayList.add(new ContactSearchableFriend(paramContext, paramQQAppInterface, localFriends, localGroups.group_name, l, paramLong));
                  }
                }
              }
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  private void a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (TextView)findViewById(2131231403);
    paramQQAppInterface.setCompoundDrawables(null, null, null, null);
    paramQQAppInterface.setText(2131562494);
    this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter((BaseAdapter)this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface);
    this.jdField_b_of_type_ComTencentWidgetXListView.setOnTouchListener(new edl(this, paramContext));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putString("search_keyword" + paramQQAppInterface.a(), paramString);
    localEditor.commit();
  }
  
  private static boolean a(List paramList, DiscussionMemberInfo paramDiscussionMemberInfo)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((DiscussionMemberInfo)((IContactSearchable)paramList.next()).a()).memberUin.equals(paramDiscussionMemberInfo.memberUin)) {
        return true;
      }
    }
    return false;
  }
  
  private List b()
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (SearchHistoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    if (localObject1 == null) {
      return localArrayList;
    }
    localObject1 = ((SearchHistoryManager)localObject1).a().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (SearchHistory)((Iterator)localObject1).next();
      localObject2 = new ContactSearchableSearchHistory(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (SearchHistory)localObject2);
      if (!(localObject2 instanceof ContactSearchablePublicAccount)) {
        localArrayList.add(localObject2);
      }
    }
    if (QLog.isColorLevel())
    {
      long l2 = System.currentTimeMillis();
      QLog.d("SearchResultDialog", 2, "initSearchHistoryData() time cost = " + (l2 - l1));
    }
    return localArrayList;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131233087));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new edi(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
  }
  
  private void c()
  {
    ((ImageButton)findViewById(2131233088)).setOnClickListener(new edj(this));
  }
  
  public static List d(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    DiscussionManager localDiscussionManager = (DiscussionManager)paramQQAppInterface.getManager(48);
    Object localObject1 = ((ContactFacade)paramQQAppInterface.getManager(49)).a("-1004");
    ArrayList localArrayList = new ArrayList();
    if (localObject1 != null)
    {
      if ((paramInt == 0) || (paramInt == 3)) {}
      for (long l = 131072L;; l = 65536L)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (DiscussionInfo)((Iterator)localObject1).next();
          if ((localObject2 != null) && (((DiscussionInfo)localObject2).uin != null) && (((DiscussionInfo)localObject2).uin.length() > 0))
          {
            localObject2 = localDiscussionManager.a(((DiscussionInfo)localObject2).uin);
            if (localObject2 != null)
            {
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)((Iterator)localObject2).next();
                if ((localDiscussionMemberInfo != null) && (!a(localArrayList, localDiscussionMemberInfo))) {
                  localArrayList.add(new SearchableDiscussionMember(paramContext, paramQQAppInterface, localDiscussionMemberInfo, l, paramLong));
                }
              }
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  private void d()
  {
    Button localButton = (Button)findViewById(2131233086);
    localButton.setVisibility(0);
    localButton.setOnClickListener(new edk(this));
  }
  
  private void e()
  {
    if (getContext().getResources().getConfiguration().orientation == 2) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(556, 0L);
    }
  }
  
  private void f()
  {
    if (isShowing())
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
      this.jdField_a_of_type_AndroidWidgetEditText.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      localMotionEvent = MotionEvent.obtain(l, l, 1, 0.0F, 0.0F, 0);
      this.jdField_a_of_type_AndroidWidgetEditText.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
    }
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 999;
    case 0: 
      return 0;
    case 1006: 
      return 1;
    case 3000: 
      return 2;
    case 1: 
      return 3;
    case 1004: 
      return 4;
    case 3: 
      return 6;
    }
    return 7;
  }
  
  public List a()
  {
    long l1 = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqAppCircleManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppCircleManager = ((CircleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33));
    }
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppCircleManager != null) {
      localArrayList1 = this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a();
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("SearchResultDialog", 2, "getCircleContacts() time cost = " + (l2 - l1));
      }
      return localArrayList1;
      localArrayList1 = localArrayList2;
      if (QLog.isColorLevel())
      {
        QLog.d("SearchResultDialog", 2, "getCircleContacts(), mApp.getManager return null");
        localArrayList1 = localArrayList2;
      }
    }
  }
  
  public List a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramQQAppInterface.a().a().a();
    int i = 0;
    RecentUser localRecentUser;
    int j;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        localRecentUser = (RecentUser)((Iterator)localObject).next();
        j = i + 1;
        if (99 > i) {
          break label73;
        }
      }
    }
    return localArrayList;
    label73:
    long l = 0L;
    switch (localRecentUser.type)
    {
    }
    for (;;)
    {
      localArrayList.add(new ContactsSearchableRecentUser(paramContext, paramQQAppInterface, localRecentUser, l));
      i = j;
      break;
      l = 47244640256L;
      continue;
      l = 12884901888L;
      continue;
      i = j;
      break;
      l = 30064771072L;
      continue;
      l = 21474836480L;
    }
  }
  
  @SuppressLint({"UseSparseArrays"})
  public List a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    if ((FriendManager)paramQQAppInterface.getManager(8) == null) {
      return localArrayList;
    }
    localArrayList.addAll(a(paramContext, paramQQAppInterface, 42949672960L, paramInt, false, null));
    localArrayList.addAll(a(paramContext, paramQQAppInterface, 34359738368L, paramInt, null));
    localArrayList.addAll(a());
    localArrayList.addAll(c(paramContext, paramQQAppInterface, 25769803776L, paramInt));
    localArrayList.addAll(b(paramContext, paramQQAppInterface, 17179869184L, paramInt));
    if (QLog.isColorLevel())
    {
      long l2 = System.currentTimeMillis();
      QLog.d("SearchResultDialog", 2, "initSearchData() time cost = " + (l2 - l1));
    }
    return localArrayList;
  }
  
  public List a(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    Object localObject = (FriendManager)paramQQAppInterface.getManager(8);
    ContactFacade localContactFacade = (ContactFacade)paramQQAppInterface.getManager(49);
    paramContext = new ArrayList();
    if ((localObject != null) && (localContactFacade != null))
    {
      if ((paramInt == 0) || (paramInt == 3)) {}
      for (long l = 131072L;; l = 65536L)
      {
        localObject = localContactFacade.a(String.valueOf(-1006));
        if (localObject == null) {
          break;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramContext.add(new ContactSearchablePublicAccount(paramQQAppInterface, (PublicAccountInfo)((Iterator)localObject).next(), paramQQAppInterface.getApplication().getString(2131562981), l, paramLong));
        }
      }
    }
    return paramContext;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    }
  }
  
  public void a(int paramInt)
  {
    findViewById(2131231401).setVisibility(0);
    if (1 == paramInt) {
      if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface.getCount() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131562951);
        if (ContactsSearchableCircleBuddy.a) {
          switch (this.f)
          {
          default: 
            paramInt = 0;
          }
        }
      }
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Network_circle", "Search_circle_exp", paramInt, 0, "", "", "", "");
      ContactsSearchableCircleBuddy.a = false;
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      if (paramInt != 0) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(BaseApplication.getContext().getResources().getString(2131558945));
      break;
      paramInt = 83;
      continue;
      paramInt = 81;
      continue;
      paramInt = 59;
    }
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.f = paramInt;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this);
    requestWindowFeature(1);
    getWindow().setSoftInputMode(36);
    getWindow().setBackgroundDrawable(new ColorDrawable());
    setContentView(2130903147);
    Object localObject = getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).x = 0;
    ((WindowManager.LayoutParams)localObject).y = 0;
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject).gravity = 51;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231403));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131231404));
    localObject = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903140, null);
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter = new ContactsSearchResultAdapter(paramQQAppInterface, paramContext, this.jdField_a_of_type_ComTencentWidgetXListView, null, new edh(this), true, new edn(this, (View)localObject));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new edo(this, paramContext));
    this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131231402));
    ContactsSearchableCircleBuddy.b = false;
    ContactsSearchableCircleBuddy.a = false;
    if (4 == paramInt) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface = new ConversationSearchAdapter(paramContext, paramQQAppInterface, this.jdField_b_of_type_ComTencentWidgetXListView, new edp(this), false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface.a(this);
      if ((paramInt == 0) || (4 == paramInt))
      {
        this.jdField_a_of_type_JavaUtilList = b();
        Message localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
        localMessage.what = 2;
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(localMessage);
      }
      new Thread(new edt(this)).start();
      b();
      c();
      d();
      a(paramContext, paramQQAppInterface);
      if ((paramInt == 0) || (4 == paramInt))
      {
        this.d = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (!TextUtils.isEmpty(this.d))
        {
          findViewById(2131231401).setVisibility(0);
          paramContext = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903148, null);
          paramContext.setOnClickListener(new edu(this, paramInt));
          ((TextView)paramContext.findViewById(2131231406)).setText(this.d);
          this.jdField_a_of_type_ComTencentWidgetXListView.a(paramContext);
          if (this.jdField_a_of_type_JavaUtilList.size() > 0)
          {
            ((TextView)((View)localObject).findViewById(2131231386)).setText(BaseApplication.getContext().getResources().getString(2131558944));
            this.jdField_a_of_type_ComTencentWidgetXListView.a((View)localObject);
          }
          this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter);
        }
      }
      return;
      if ((13 == paramInt) || (14 == paramInt))
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface = new CircleSearchResultAdapter(paramQQAppInterface, paramContext, this.jdField_b_of_type_ComTencentWidgetXListView, new edq(this));
        ((EditText)findViewById(2131233087)).setHint(2131562831);
      }
      else if ((15 == paramInt) || (16 == paramInt))
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface = new VoipContactsSearchResultAdapter(paramQQAppInterface, paramContext, this.jdField_b_of_type_ComTencentWidgetXListView, null, new edr(this), false);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface = new ContactsSearchResultAdapter(paramQQAppInterface, paramContext, this.jdField_b_of_type_ComTencentWidgetXListView, null, new eds(this), false, null);
      }
    }
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    a(paramContext, paramQQAppInterface, paramString1, paramInt, paramString2, null);
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Intent localIntent;
    Object localObject;
    if (paramInt == 1008)
    {
      localIntent = new Intent(paramContext, PublicAccountManager.a(paramString1, paramQQAppInterface));
      localIntent.putExtra("uin", paramString1);
      if ((paramInt != 1) && (paramInt != 1004)) {
        break label202;
      }
      localObject = paramString2;
      if (paramString3 != null)
      {
        localIntent.putExtra("troop_uin", paramString3);
        localObject = paramString2;
      }
    }
    for (;;)
    {
      localIntent.putExtra("uintype", paramInt);
      localIntent.putExtra("uinname", (String)localObject);
      localIntent.putExtra("aio_msg_source", 1);
      paramContext.startActivity(localIntent);
      dismiss();
      paramContext = paramString3;
      if (paramString3 == null) {
        paramContext = "";
      }
      a((String)localObject, paramString1, paramContext, paramInt);
      int i = b(this.f);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Search", "Search_into_AIO", i, 0, String.valueOf(a(paramInt)), String.valueOf(i), "", "");
      return;
      localIntent = new Intent(paramContext, ChatActivity.class);
      break;
      label202:
      localObject = paramString2;
      if (paramInt == 0)
      {
        paramQQAppInterface = (FriendManager)paramQQAppInterface.getManager(8);
        localObject = paramString2;
        if (paramQQAppInterface != null)
        {
          Friends localFriends = paramQQAppInterface.c(String.valueOf(paramString1));
          localObject = paramString2;
          if (localFriends != null)
          {
            paramQQAppInterface = ContactUtils.a(localFriends);
            localIntent.putExtra("cSpecialFlag", localFriends.cSpecialFlag);
            localObject = paramQQAppInterface;
            if (localFriends.cSpecialFlag == 1)
            {
              localIntent.setClass(paramContext, ChatForEnterpriseActivity.class);
              localObject = paramQQAppInterface;
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (paramString1.equals(""))
    {
      if (TextUtils.isEmpty(this.d))
      {
        findViewById(2131231401).setVisibility(8);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface.a();
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView.getVisibility() == 0) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface.a(paramString1, paramString2);
    this.c = paramString2;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    SearchHistory localSearchHistory = new SearchHistory();
    localSearchHistory.type = paramInt;
    localSearchHistory.uin = paramString2;
    localSearchHistory.troopUin = paramString3;
    localSearchHistory.displayName = paramString1;
    paramString1 = (SearchHistoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    if (paramString1 == null) {
      return;
    }
    paramString1.a(localSearchHistory);
  }
  
  public void a(List paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface.a(paramList);
    }
  }
  
  public int b(int paramInt)
  {
    switch (paramInt)
    {
    case 12: 
    case 13: 
    case 14: 
    default: 
      return 999;
    case 0: 
      return 11;
    case 4: 
      return 0;
    case 2: 
      return 13;
    case 7: 
      return 8;
    case 8: 
      return 9;
    case 9: 
    case 11: 
    case 15: 
      return 10;
    case 10: 
      return 6;
    case 6: 
      return 7;
    case 5: 
    case 16: 
      return 14;
    case 3: 
      return 15;
    }
    return 12;
  }
  
  public List b(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    Object localObject = (ContactFacade)paramQQAppInterface.getManager(49);
    ArrayList localArrayList = new ArrayList();
    if (localObject != null)
    {
      localObject = ((ContactFacade)localObject).a("-1003");
      if (localObject != null)
      {
        if (paramInt == 1) {}
        for (long l = 131072L;; l = 0L)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            localArrayList.add(new ContactSearchableTroop(paramContext, paramQQAppInterface, (TroopInfo)((Iterator)localObject).next(), l, paramLong));
          }
        }
      }
    }
    return localArrayList;
  }
  
  /* Error */
  public List c(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: new 138	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 139	java/util/ArrayList:<init>	()V
    //   7: astore 10
    //   9: aload_2
    //   10: bipush 49
    //   12: invokevirtual 143	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   15: checkcast 208	com/tencent/mobileqq/app/ContactFacade
    //   18: astore 8
    //   20: aload 8
    //   22: ifnull +289 -> 311
    //   25: aload 8
    //   27: ldc 210
    //   29: invokevirtual 211	com/tencent/mobileqq/app/ContactFacade:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   32: astore 12
    //   34: aload 12
    //   36: ifnull +275 -> 311
    //   39: iload 5
    //   41: iconst_2
    //   42: if_icmpne +217 -> 259
    //   45: ldc2_w 182
    //   48: lstore 6
    //   50: new 838	java/util/HashMap
    //   53: dup
    //   54: invokespecial 839	java/util/HashMap:<init>	()V
    //   57: astore 11
    //   59: aconst_null
    //   60: astore 9
    //   62: aload_2
    //   63: invokevirtual 842	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   66: new 112	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   73: ldc_w 844
    //   76: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: new 185	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   82: dup
    //   83: invokespecial 845	com/tencent/mobileqq/data/DiscussionMemberInfo:<init>	()V
    //   86: invokevirtual 848	com/tencent/mobileqq/data/DiscussionMemberInfo:getTableName	()Ljava/lang/String;
    //   89: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc_w 850
    //   95: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: aconst_null
    //   102: invokevirtual 855	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   105: astore 8
    //   107: aload 8
    //   109: astore 9
    //   111: aload 8
    //   113: invokeinterface 860 1 0
    //   118: ifeq +160 -> 278
    //   121: aload 8
    //   123: astore 9
    //   125: aload 11
    //   127: aload 8
    //   129: iconst_0
    //   130: invokeinterface 861 2 0
    //   135: aload 8
    //   137: iconst_1
    //   138: invokeinterface 864 2 0
    //   143: invokestatic 869	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   146: invokevirtual 873	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   149: pop
    //   150: goto -43 -> 107
    //   153: astore 8
    //   155: aload 9
    //   157: ifnull +10 -> 167
    //   160: aload 9
    //   162: invokeinterface 876 1 0
    //   167: aload 12
    //   169: invokeinterface 154 1 0
    //   174: astore 9
    //   176: aload 9
    //   178: invokeinterface 160 1 0
    //   183: ifeq +128 -> 311
    //   186: aload 9
    //   188: invokeinterface 166 1 0
    //   193: checkcast 213	com/tencent/mobileqq/persistence/Entity
    //   196: checkcast 215	com/tencent/mobileqq/data/DiscussionInfo
    //   199: astore 12
    //   201: aload 11
    //   203: aload 12
    //   205: getfield 218	com/tencent/mobileqq/data/DiscussionInfo:uin	Ljava/lang/String;
    //   208: invokevirtual 880	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   211: checkcast 866	java/lang/Integer
    //   214: astore 8
    //   216: aload 8
    //   218: ifnonnull +100 -> 318
    //   221: iconst_0
    //   222: invokestatic 869	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: astore 8
    //   227: aload 10
    //   229: new 882	com/tencent/mobileqq/search/ContactSearchableDiscussion
    //   232: dup
    //   233: aload_1
    //   234: aload_2
    //   235: aload 12
    //   237: aload 8
    //   239: invokevirtual 885	java/lang/Integer:intValue	()I
    //   242: lload 6
    //   244: lload_3
    //   245: iload 5
    //   247: invokespecial 888	com/tencent/mobileqq/search/ContactSearchableDiscussion:<init>	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/DiscussionInfo;IJJI)V
    //   250: invokeinterface 175 2 0
    //   255: pop
    //   256: goto -80 -> 176
    //   259: iload 5
    //   261: ifne +11 -> 272
    //   264: ldc2_w 202
    //   267: lstore 6
    //   269: goto -219 -> 50
    //   272: lconst_0
    //   273: lstore 6
    //   275: goto -225 -> 50
    //   278: aload 8
    //   280: ifnull -113 -> 167
    //   283: aload 8
    //   285: invokeinterface 876 1 0
    //   290: goto -123 -> 167
    //   293: astore_1
    //   294: aconst_null
    //   295: astore 8
    //   297: aload 8
    //   299: ifnull +10 -> 309
    //   302: aload 8
    //   304: invokeinterface 876 1 0
    //   309: aload_1
    //   310: athrow
    //   311: aload 10
    //   313: areturn
    //   314: astore_1
    //   315: goto -18 -> 297
    //   318: goto -91 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	this	SearchResultDialog
    //   0	321	1	paramContext	Context
    //   0	321	2	paramQQAppInterface	QQAppInterface
    //   0	321	3	paramLong	long
    //   0	321	5	paramInt	int
    //   48	226	6	l	long
    //   18	118	8	localObject1	Object
    //   153	1	8	localException	Exception
    //   214	89	8	localInteger	java.lang.Integer
    //   60	127	9	localObject2	Object
    //   7	305	10	localArrayList	ArrayList
    //   57	145	11	localHashMap	java.util.HashMap
    //   32	204	12	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   62	107	153	java/lang/Exception
    //   111	121	153	java/lang/Exception
    //   125	150	153	java/lang/Exception
    //   62	107	293	finally
    //   111	121	314	finally
    //   125	150	314	finally
  }
  
  public void dismiss()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(555);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(556);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.d();
    }
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (555 == paramMessage.what) {
      e();
    }
    do
    {
      do
      {
        return true;
        if (556 == paramMessage.what)
        {
          f();
          return true;
        }
        if (1 == paramMessage.what)
        {
          a((List)paramMessage.obj);
          return true;
        }
      } while (2 != paramMessage.what);
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.b(this.jdField_a_of_type_JavaUtilList);
      }
    } while (!QLog.isColorLevel());
    QLog.d("SearchResultDialog", 2, "load history data finish");
    return true;
  }
  
  public void show()
  {
    super.show();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(555);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(556);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.SearchResultDialog
 * JD-Core Version:    0.7.0.1
 */