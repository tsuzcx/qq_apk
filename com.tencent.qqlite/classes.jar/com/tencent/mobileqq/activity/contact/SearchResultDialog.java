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
import cbd;
import cbe;
import cbf;
import cbg;
import cbh;
import cbi;
import cbj;
import cbk;
import cbl;
import cbm;
import cbn;
import cbo;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.adapter.CircleSearchResultAdapter;
import com.tencent.mobileqq.adapter.ContactsSearchResultAdapter;
import com.tencent.mobileqq.app.ContactFacade;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.search.ContactSearchableFriend;
import com.tencent.mobileqq.search.ContactSearchableSearchHistory;
import com.tencent.mobileqq.search.ContactSearchableTroop;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SearchResultDialog
  extends Dialog
  implements Handler.Callback, ConversationSearchAdapter.SearchResultCallBack
{
  private static final int jdField_a_of_type_Int = 555;
  public static final String a = "SearchResultDialog";
  private static final int jdField_b_of_type_Int = 556;
  public static final String b = "search_keyword";
  private static final int c = 1;
  public static final String c = "circle_contacts_search_count";
  private static final int jdField_d_of_type_Int = 2;
  long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ForwardOperations jdField_a_of_type_ComTencentMobileqqActivityForwardOperations;
  private ContactsSearchResultAdapter jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SearchAdapterInterface jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List jdField_a_of_type_JavaUtilList;
  private Map jdField_a_of_type_JavaUtilMap;
  private AdapterView.OnItemClickListener jdField_b_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new cbg(this);
  private XListView jdField_b_of_type_ComTencentWidgetXListView;
  private List jdField_b_of_type_JavaUtilList;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString = null;
  
  public SearchResultDialog(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    super(paramContext);
    this.d = null;
    if (QLog.isColorLevel()) {
      QLog.d("SearchResultDialog", 2, "SearchResultDialog() from = " + paramInt);
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_e_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this);
    requestWindowFeature(1);
    getWindow().setSoftInputMode(36);
    getWindow().setBackgroundDrawable(new ColorDrawable());
    setContentView(2130903123);
    Object localObject = getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).x = 0;
    ((WindowManager.LayoutParams)localObject).y = 0;
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject).gravity = 51;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296867));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131296868));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter = new ContactsSearchResultAdapter(paramQQAppInterface, paramContext, this.jdField_a_of_type_ComTencentWidgetXListView, null, new cbd(this), false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new cbh(this, paramContext));
    this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131296866));
    if (4 == paramInt) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface = new ConversationSearchAdapter(paramContext, paramQQAppInterface, this.jdField_b_of_type_ComTencentWidgetXListView, new cbi(this), false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface.a(this);
      if ((paramInt == 0) || (4 == paramInt))
      {
        this.jdField_b_of_type_JavaUtilList = b();
        localObject = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
        ((Message)localObject).what = 2;
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)localObject);
      }
      new Thread(new cbl(this)).start();
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298408));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new cbm(this));
      b();
      c();
      a(paramContext, paramQQAppInterface);
      if ((paramInt == 0) || (4 == paramInt))
      {
        this.jdField_e_of_type_JavaLangString = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
        {
          findViewById(2131296865).setVisibility(0);
          paramContext = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903124, null);
          paramContext.setOnClickListener(new cbn(this, paramInt));
          ((TextView)paramContext.findViewById(2131296870)).setText(this.jdField_e_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentWidgetXListView.a(paramContext);
          if (this.jdField_b_of_type_JavaUtilList.size() > 0)
          {
            paramContext = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903118, null);
            ((TextView)paramContext.findViewById(2131296841)).setText("你可能想找");
            this.jdField_a_of_type_ComTencentWidgetXListView.a(paramContext);
          }
          this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter);
        }
      }
      return;
      if ((13 == paramInt) || (14 == paramInt))
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface = new CircleSearchResultAdapter(paramQQAppInterface, paramContext, this.jdField_b_of_type_ComTencentWidgetXListView, new cbj(this));
        ((EditText)findViewById(2131297957)).setHint(2131362957);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface = new ContactsSearchResultAdapter(paramQQAppInterface, paramContext, this.jdField_b_of_type_ComTencentWidgetXListView, null, new cbk(this), false);
      }
    }
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
    long l = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject = (PhoneContactManager)paramQQAppInterface.getManager(10);
    if (localObject != null)
    {
      localObject = (List)((PhoneContactManager)localObject).b().get(0);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localArrayList.add(new ContactsSearchablePhoneContact(paramContext, paramQQAppInterface, (PhoneContact)((Iterator)localObject).next(), paramLong));
        }
      }
    }
    paramLong = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("SearchResultDialog", 2, "getPhoneContacts() time cost = " + (paramLong - l) + " , size = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  public static List a(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt, String paramString, boolean paramBoolean, ArrayList paramArrayList)
  {
    Object localObject = ((DiscussionManager)paramQQAppInterface.getManager(45)).a(paramString);
    paramString = new ArrayList();
    if (localObject != null)
    {
      if ((paramInt == 0) || (paramInt == 3)) {}
      for (;;)
      {
        String str = paramQQAppInterface.a();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)((Iterator)localObject).next();
          if ((localDiscussionMemberInfo != null) && ((!paramBoolean) || (!localDiscussionMemberInfo.memberUin.equals(str))) && ((paramArrayList == null) || (!paramArrayList.contains(localDiscussionMemberInfo.memberUin)))) {
            paramString.add(new SearchableDiscussionMember(paramContext, paramQQAppInterface, localDiscussionMemberInfo, 0L, paramLong));
          }
        }
      }
    }
    return paramString;
  }
  
  @Deprecated
  public static List a(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt, ArrayList paramArrayList)
  {
    return a(paramContext, paramQQAppInterface, paramLong, paramInt, paramArrayList, (List)a(paramQQAppInterface)[1]);
  }
  
  public static List a(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt, ArrayList paramArrayList, List paramList)
  {
    long l = System.currentTimeMillis();
    FriendManager localFriendManager = (FriendManager)paramQQAppInterface.getManager(8);
    ArrayList localArrayList = new ArrayList();
    if (localFriendManager != null)
    {
      if ((paramInt == 0) || (paramInt == 3)) {}
      for (;;)
      {
        String str = paramQQAppInterface.a();
        if (paramList == null) {
          break;
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Iterator localIterator = ((ArrayList)paramList.next()).iterator();
          while (localIterator.hasNext())
          {
            DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)localIterator.next();
            if ((localDiscussionMemberInfo != null) && (localDiscussionMemberInfo.memberUin != null) && (!localDiscussionMemberInfo.memberUin.equals(str)))
            {
              Friends localFriends = localFriendManager.a(localDiscussionMemberInfo.memberUin);
              if (((localFriends == null) || (!localFriends.isFriend())) && (!a(localArrayList, localDiscussionMemberInfo)) && ((paramArrayList == null) || (!paramArrayList.contains(localDiscussionMemberInfo.memberUin)))) {
                localArrayList.add(new SearchableDiscussionMember(paramContext, paramQQAppInterface, localDiscussionMemberInfo, 0L, paramLong));
              }
            }
          }
        }
      }
    }
    paramLong = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("SearchResultDialog", 2, "getAllDiscussionMembersExcludeFriends() time cost = " + (paramLong - l) + " , size = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  public static List a(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt, List paramList, boolean paramBoolean, ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      if ((paramInt == 0) || (paramInt == 3)) {}
      for (;;)
      {
        String str = paramQQAppInterface.a();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramList.next();
          if ((localTroopMemberInfo != null) && (!localTroopMemberInfo.memberuin.equals("0")) && ((!paramBoolean) || (!localTroopMemberInfo.memberuin.equals(str))) && ((paramArrayList == null) || (!paramArrayList.contains(localTroopMemberInfo.memberuin)))) {
            localArrayList.add(new SearchableTroopMember(paramContext, paramQQAppInterface, localTroopMemberInfo, 0L, paramLong));
          }
        }
      }
    }
    return localArrayList;
  }
  
  @SuppressLint({"UseSparseArrays"})
  public static List a(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt, boolean paramBoolean, ArrayList paramArrayList)
  {
    long l = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (FriendManager)paramQQAppInterface.getManager(8);
    ContactFacade localContactFacade = (ContactFacade)paramQQAppInterface.getManager(46);
    Object localObject2 = (FriendsManager)paramQQAppInterface.getManager(43);
    if ((localObject1 != null) && (localContactFacade != null) && (localObject2 != null))
    {
      localObject2 = ((FriendManager)localObject1).a();
      localObject1 = paramQQAppInterface.a();
      if (localObject2 != null)
      {
        if ((paramInt == 0) || (paramInt == 3)) {}
        for (;;)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Groups localGroups = (Groups)((Iterator)localObject2).next();
            Object localObject3 = localContactFacade.a(String.valueOf(localGroups.group_id));
            if (localObject3 != null)
            {
              localObject3 = ((List)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                Friends localFriends = (Friends)((Iterator)localObject3).next();
                if (((!paramBoolean) || (!localFriends.uin.equals(localObject1))) && ((paramArrayList == null) || (!paramArrayList.contains(localFriends.uin)))) {
                  localArrayList.add(new ContactSearchableFriend(paramContext, paramQQAppInterface, localFriends, localGroups.group_name, 0L, paramLong));
                }
              }
            }
          }
        }
      }
    }
    paramLong = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("SearchResultDialog", 2, "getFriends() time cost = " + (paramLong - l) + " , size = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  private void a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (TextView)findViewById(2131296867);
    paramQQAppInterface.setCompoundDrawables(null, null, null, null);
    paramQQAppInterface.setText(2131363155);
    this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter((BaseAdapter)this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface);
    this.jdField_b_of_type_ComTencentWidgetXListView.setOnTouchListener(new cbf(this, paramContext));
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
  
  public static Object[] a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = null;
    DiscussionManager localDiscussionManager = (DiscussionManager)paramQQAppInterface.getManager(45);
    paramQQAppInterface = (ContactFacade)paramQQAppInterface.getManager(46);
    if ((localDiscussionManager != null) && (paramQQAppInterface != null))
    {
      paramQQAppInterface = paramQQAppInterface.a("-1004");
      String[] arrayOfString = new String[paramQQAppInterface.size()];
      paramQQAppInterface = paramQQAppInterface.iterator();
      int i = 0;
      while (paramQQAppInterface.hasNext())
      {
        localObject = (DiscussionInfo)paramQQAppInterface.next();
        if ((localObject == null) || (((DiscussionInfo)localObject).uin == null) || (((DiscussionInfo)localObject).uin.length() <= 0)) {
          break label185;
        }
        arrayOfString[i] = ((DiscussionInfo)localObject).uin;
        i += 1;
      }
      paramQQAppInterface = localDiscussionManager.a(arrayOfString);
      localObject = new ArrayList();
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        ((List)localObject).add((ArrayList)paramQQAppInterface.get(arrayOfString[i]));
        i += 1;
      }
    }
    for (;;)
    {
      return new Object[] { paramQQAppInterface, localObject };
      label185:
      break;
      paramQQAppInterface = null;
    }
  }
  
  private List b()
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject = (SearchHistoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((SearchHistoryManager)localObject).a().iterator();
    while (((Iterator)localObject).hasNext())
    {
      SearchHistory localSearchHistory = (SearchHistory)((Iterator)localObject).next();
      localArrayList.add(new ContactSearchableSearchHistory(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSearchHistory));
    }
    if (QLog.isColorLevel())
    {
      long l2 = System.currentTimeMillis();
      QLog.d("SearchResultDialog", 2, "initSearchHistoryData() time cost = " + (l2 - l1) + " , size = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  public static List b(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt, boolean paramBoolean, ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = (FriendsManager)paramQQAppInterface.getManager(43);
    Object localObject1 = (ContactFacade)paramQQAppInterface.getManager(46);
    if ((localObject2 != null) && (localObject1 != null))
    {
      Object localObject3 = ((FriendsManager)localObject2).a();
      localObject1 = paramQQAppInterface.a();
      if (localObject3 != null)
      {
        if ((paramInt == 0) || (paramInt == 3)) {}
        for (;;)
        {
          localObject2 = ((FriendsManager)localObject2).b();
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            Groups localGroups = (Groups)((Iterator)localObject3).next();
            Object localObject4 = (List)((ConcurrentHashMap)localObject2).get(String.valueOf(localGroups.group_id));
            if (localObject4 != null)
            {
              localObject4 = ((List)localObject4).iterator();
              while (((Iterator)localObject4).hasNext())
              {
                Friends localFriends = (Friends)((Iterator)localObject4).next();
                if (((!paramBoolean) || (!localFriends.uin.equals(localObject1))) && ((paramArrayList == null) || (!paramArrayList.contains(localFriends.uin))) && (localFriends.gathtertype == 1)) {
                  localArrayList.add(new ContactSearchableFriend(paramContext, paramQQAppInterface, localFriends, localGroups.group_name, 0L, paramLong));
                }
              }
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131297957));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new cbo(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
  }
  
  public static List c(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    DiscussionManager localDiscussionManager = (DiscussionManager)paramQQAppInterface.getManager(45);
    Object localObject1 = ((ContactFacade)paramQQAppInterface.getManager(46)).a("-1004");
    ArrayList localArrayList = new ArrayList();
    if (localObject1 != null)
    {
      if ((paramInt == 0) || (paramInt == 3)) {}
      for (;;)
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
                  localArrayList.add(new SearchableDiscussionMember(paramContext, paramQQAppInterface, localDiscussionMemberInfo, 0L, paramLong));
                }
              }
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  private void c()
  {
    ((ImageButton)findViewById(2131297950)).setOnClickListener(new cbe(this));
  }
  
  private void d()
  {
    if (getContext().getResources().getConfiguration().orientation == 2) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(556, 0L);
    }
  }
  
  private void e()
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
  
  private void f()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap == null)
      {
        Object[] arrayOfObject = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_JavaUtilMap = ((Map)arrayOfObject[0]);
        this.jdField_a_of_type_JavaUtilList = ((List)arrayOfObject[1]);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
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
    }
    return 6;
  }
  
  public List a()
  {
    f();
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  protected List a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    long l2 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramQQAppInterface.a().a().b();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject).next();
        l1 = 0L;
        switch (localRecentUser.type)
        {
        }
        for (;;)
        {
          localArrayList.add(new ContactsSearchableRecentUser(paramContext, paramQQAppInterface, localRecentUser, l1, a()));
          break;
          l1 = 38654705664L;
          continue;
          l1 = 12884901888L;
          continue;
          l1 = 21474836480L;
          continue;
          l1 = 21474836480L;
        }
      }
    }
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("SearchResultDialog", 2, "getRecentUsers() time cost = " + (l1 - l2) + " , size = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  @SuppressLint({"UseSparseArrays"})
  public List a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    if ((FriendManager)paramQQAppInterface.getManager(8) == null) {
      return localArrayList1;
    }
    ExecutorService localExecutorService = Executors.newFixedThreadPool(5);
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(localExecutorService.submit(new SearchResultDialog.CallableForSearchData(this, paramContext, paramQQAppInterface, 34359738368L, paramInt)));
    localArrayList2.add(localExecutorService.submit(new SearchResultDialog.CallableForSearchData(this, paramContext, paramQQAppInterface, 30064771072L, paramInt)));
    localArrayList2.add(localExecutorService.submit(new SearchResultDialog.CallableForSearchData(this, paramContext, paramQQAppInterface, 25769803776L, paramInt)));
    localArrayList2.add(localExecutorService.submit(new SearchResultDialog.CallableForSearchData(this, paramContext, paramQQAppInterface, 17179869184L, paramInt)));
    paramInt = 0;
    try
    {
      while (paramInt < localArrayList2.size())
      {
        paramContext = (List)((Future)localArrayList2.get(paramInt)).get();
        localArrayList1.addAll(paramContext);
        paramContext.clear();
        paramInt += 1;
      }
      localArrayList2.clear();
      localExecutorService.shutdown();
    }
    catch (InterruptedException paramContext)
    {
      for (;;)
      {
        long l2;
        paramContext.printStackTrace();
      }
    }
    catch (ExecutionException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    if (QLog.isColorLevel())
    {
      l2 = System.currentTimeMillis();
      QLog.d("SearchResultDialog", 2, "initSearchData() time cost = " + (l2 - l1) + " , size = " + localArrayList1.size());
    }
    return localArrayList1;
  }
  
  protected List a(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    long l = System.currentTimeMillis();
    Object localObject = (ContactFacade)paramQQAppInterface.getManager(46);
    ArrayList localArrayList = new ArrayList();
    if (localObject != null)
    {
      localObject = ((ContactFacade)localObject).a("-1003");
      if (localObject != null)
      {
        if (paramInt == 1) {}
        for (;;)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            localArrayList.add(new ContactSearchableTroop(paramContext, paramQQAppInterface, (TroopInfo)((Iterator)localObject).next(), 0L, paramLong));
          }
        }
      }
    }
    paramLong = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("SearchResultDialog", 2, "getTroops() time cost = " + (paramLong - l) + " , size = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  public Map a()
  {
    f();
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    }
  }
  
  public void a(int paramInt)
  {
    findViewById(2131296865).setVisibility(0);
    if (1 == paramInt) {
      if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface.getCount() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131363154);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("SearchResultDialog", 2, "searchFinish() search finish state = " + paramInt);
        QLog.d("SearchResultDialog", 2, "searchFinish() search finish keyword = " + this.d);
        QLog.d("SearchResultDialog", 2, "refreshSearchResultList() search finish time = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
      }
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      continue;
      if (paramInt == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText("搜索中...");
      }
    }
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    a(paramContext, paramQQAppInterface, paramString1, paramInt, paramString2, null);
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(paramContext, ChatActivity.class);
    localIntent.putExtra("uin", paramString1);
    String str;
    if ((paramInt == 1) || (paramInt == 1004))
    {
      str = paramString2;
      if (paramString3 != null)
      {
        localIntent.putExtra("troop_uin", paramString3);
        str = paramString2;
      }
    }
    for (;;)
    {
      localIntent.putExtra("uintype", paramInt);
      localIntent.putExtra("uinname", str);
      localIntent.putExtra("aio_msg_source", 1);
      paramContext.startActivity(localIntent);
      dismiss();
      paramContext = paramString3;
      if (paramString3 == null) {
        paramContext = "";
      }
      a(str, paramString1, paramContext, paramInt);
      int i = b(this.jdField_e_of_type_Int);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Search", "Search_into_AIO", i, 0, String.valueOf(a(paramInt)), String.valueOf(i), "", "");
      return;
      str = paramString2;
      if (paramInt == 0)
      {
        Object localObject = (FriendManager)paramQQAppInterface.getManager(8);
        str = paramString2;
        if (localObject != null)
        {
          localObject = ((FriendManager)localObject).c(String.valueOf(paramString1));
          str = paramString2;
          if (localObject != null)
          {
            paramString2 = ContactUtils.a((Friends)localObject);
            localIntent.putExtra("cSpecialFlag", ((Friends)localObject).cSpecialFlag);
            if (((Friends)localObject).cSpecialFlag == 1)
            {
              localIntent.setClass(paramContext, ChatActivity.class);
              localIntent.putExtra("chat_subType", 1);
            }
            str = paramString2;
            if (((Friends)localObject).gathtertype == 1)
            {
              ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004C58", "0X8004C58", 2, 0, "", "", "", "");
              str = paramString2;
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchResultDialog", 2, "refreshSearchResultList() search start keyword = " + paramString1);
    }
    if (paramString1.equals(""))
    {
      if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        findViewById(2131296865).setVisibility(8);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface.a();
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface.b();
        return;
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      }
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView.getVisibility() == 0) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface.a(paramString1, paramString2);
    this.d = paramString2;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    SearchHistory localSearchHistory = new SearchHistory();
    localSearchHistory.type = paramInt;
    localSearchHistory.uin = paramString2;
    localSearchHistory.troopUin = paramString3;
    localSearchHistory.displayName = paramString1;
    paramString1 = (SearchHistoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47);
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
      return 10;
    case 10: 
      return 6;
    case 6: 
      return 7;
    case 5: 
      return 14;
    case 3: 
      return 15;
    }
    return 12;
  }
  
  /* Error */
  protected List b(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 370	java/lang/System:currentTimeMillis	()J
    //   3: lstore 6
    //   5: new 872	java/util/HashSet
    //   8: dup
    //   9: invokespecial 873	java/util/HashSet:<init>	()V
    //   12: astore 10
    //   14: iconst_4
    //   15: iload 5
    //   17: if_icmpne +68 -> 85
    //   20: aload_2
    //   21: invokevirtual 661	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   24: invokevirtual 666	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;
    //   27: invokevirtual 669	com/tencent/mobileqq/app/proxy/RecentUserProxy:b	()Ljava/util/List;
    //   30: astore 8
    //   32: aload 8
    //   34: ifnull +44 -> 78
    //   37: aload 8
    //   39: invokeinterface 388 1 0
    //   44: astore 9
    //   46: aload 9
    //   48: invokeinterface 393 1 0
    //   53: ifeq +25 -> 78
    //   56: aload 10
    //   58: aload 9
    //   60: invokeinterface 399 1 0
    //   65: checkcast 671	com/tencent/mobileqq/data/RecentUser
    //   68: getfield 874	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   71: invokevirtual 875	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   74: pop
    //   75: goto -29 -> 46
    //   78: aload 8
    //   80: invokeinterface 731 1 0
    //   85: new 372	java/util/ArrayList
    //   88: dup
    //   89: invokespecial 373	java/util/ArrayList:<init>	()V
    //   92: astore 11
    //   94: aload_2
    //   95: bipush 46
    //   97: invokevirtual 377	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   100: checkcast 483	com/tencent/mobileqq/app/ContactFacade
    //   103: astore 8
    //   105: aload 8
    //   107: ifnull +328 -> 435
    //   110: aload 8
    //   112: ldc_w 546
    //   115: invokevirtual 500	com/tencent/mobileqq/app/ContactFacade:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   118: astore 13
    //   120: aload 13
    //   122: ifnull +313 -> 435
    //   125: iload 5
    //   127: iconst_2
    //   128: if_icmpne +263 -> 391
    //   131: new 877	java/util/HashMap
    //   134: dup
    //   135: invokespecial 878	java/util/HashMap:<init>	()V
    //   138: astore 12
    //   140: aconst_null
    //   141: astore 9
    //   143: aload_2
    //   144: invokevirtual 881	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   147: new 64	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 883
    //   157: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: new 423	com/tencent/mobileqq/data/DiscussionMemberInfo
    //   163: dup
    //   164: invokespecial 884	com/tencent/mobileqq/data/DiscussionMemberInfo:<init>	()V
    //   167: invokevirtual 887	com/tencent/mobileqq/data/DiscussionMemberInfo:getTableName	()Ljava/lang/String;
    //   170: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: ldc_w 889
    //   176: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: aconst_null
    //   183: invokevirtual 894	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   186: astore 8
    //   188: aload 8
    //   190: astore 9
    //   192: aload 8
    //   194: invokeinterface 899 1 0
    //   199: ifeq +203 -> 402
    //   202: aload 8
    //   204: astore 9
    //   206: aload 12
    //   208: aload 8
    //   210: iconst_0
    //   211: invokeinterface 901 2 0
    //   216: aload 8
    //   218: iconst_1
    //   219: invokeinterface 904 2 0
    //   224: invokestatic 909	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   227: invokevirtual 913	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   230: pop
    //   231: goto -43 -> 188
    //   234: astore 8
    //   236: aload 9
    //   238: ifnull +10 -> 248
    //   241: aload 9
    //   243: invokeinterface 916 1 0
    //   248: aload 13
    //   250: invokeinterface 388 1 0
    //   255: astore 13
    //   257: aload 13
    //   259: invokeinterface 393 1 0
    //   264: ifeq +171 -> 435
    //   267: aload 13
    //   269: invokeinterface 399 1 0
    //   274: checkcast 490	com/tencent/mobileqq/persistence/Entity
    //   277: checkcast 548	com/tencent/mobileqq/data/DiscussionInfo
    //   280: astore 14
    //   282: iconst_4
    //   283: iload 5
    //   285: if_icmpne +16 -> 301
    //   288: aload 10
    //   290: aload 14
    //   292: getfield 549	com/tencent/mobileqq/data/DiscussionInfo:uin	Ljava/lang/String;
    //   295: invokevirtual 917	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   298: ifne -41 -> 257
    //   301: aload 12
    //   303: aload 14
    //   305: getfield 549	com/tencent/mobileqq/data/DiscussionInfo:uin	Ljava/lang/String;
    //   308: invokevirtual 918	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   311: checkcast 906	java/lang/Integer
    //   314: astore 8
    //   316: aload 8
    //   318: ifnonnull +179 -> 497
    //   321: iconst_0
    //   322: invokestatic 909	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   325: astore 8
    //   327: aconst_null
    //   328: astore 9
    //   330: aload_0
    //   331: invokevirtual 679	com/tencent/mobileqq/activity/contact/SearchResultDialog:a	()Ljava/util/Map;
    //   334: astore 15
    //   336: aload 15
    //   338: ifnull +20 -> 358
    //   341: aload 15
    //   343: aload 14
    //   345: getfield 549	com/tencent/mobileqq/data/DiscussionInfo:uin	Ljava/lang/String;
    //   348: invokeinterface 560 2 0
    //   353: checkcast 287	java/util/List
    //   356: astore 9
    //   358: aload 11
    //   360: new 920	com/tencent/mobileqq/search/ContactSearchableDiscussion
    //   363: dup
    //   364: aload_1
    //   365: aload_2
    //   366: aload 14
    //   368: aload 8
    //   370: invokevirtual 923	java/lang/Integer:intValue	()I
    //   373: lconst_0
    //   374: lload_3
    //   375: iload 5
    //   377: aload 9
    //   379: invokespecial 926	com/tencent/mobileqq/search/ContactSearchableDiscussion:<init>	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/DiscussionInfo;IJJILjava/util/List;)V
    //   382: invokeinterface 408 2 0
    //   387: pop
    //   388: goto -131 -> 257
    //   391: iload 5
    //   393: ifne +6 -> 399
    //   396: goto -265 -> 131
    //   399: goto -268 -> 131
    //   402: aload 8
    //   404: ifnull -156 -> 248
    //   407: aload 8
    //   409: invokeinterface 916 1 0
    //   414: goto -166 -> 248
    //   417: astore_1
    //   418: aconst_null
    //   419: astore 8
    //   421: aload 8
    //   423: ifnull +10 -> 433
    //   426: aload 8
    //   428: invokeinterface 916 1 0
    //   433: aload_1
    //   434: athrow
    //   435: invokestatic 370	java/lang/System:currentTimeMillis	()J
    //   438: lstore_3
    //   439: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   442: ifeq +48 -> 490
    //   445: ldc 14
    //   447: iconst_2
    //   448: new 64	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   455: ldc_w 928
    //   458: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: lload_3
    //   462: lload 6
    //   464: lsub
    //   465: invokevirtual 413	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   468: ldc_w 415
    //   471: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: aload 11
    //   476: invokeinterface 291 1 0
    //   481: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   484: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   487: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   490: aload 11
    //   492: areturn
    //   493: astore_1
    //   494: goto -73 -> 421
    //   497: goto -170 -> 327
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	500	0	this	SearchResultDialog
    //   0	500	1	paramContext	Context
    //   0	500	2	paramQQAppInterface	QQAppInterface
    //   0	500	3	paramLong	long
    //   0	500	5	paramInt	int
    //   3	460	6	l	long
    //   30	187	8	localObject1	Object
    //   234	1	8	localException	Exception
    //   314	113	8	localInteger	java.lang.Integer
    //   44	334	9	localObject2	Object
    //   12	277	10	localHashSet	java.util.HashSet
    //   92	399	11	localArrayList	ArrayList
    //   138	164	12	localHashMap	java.util.HashMap
    //   118	150	13	localObject3	Object
    //   280	87	14	localDiscussionInfo	DiscussionInfo
    //   334	8	15	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   143	188	234	java/lang/Exception
    //   192	202	234	java/lang/Exception
    //   206	231	234	java/lang/Exception
    //   143	188	417	finally
    //   192	202	493	finally
    //   206	231	493	finally
  }
  
  public void dismiss()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchResultDialog", 2, "dismiss() this = " + this);
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(555);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(556);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchAdapterInterface.e();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.e();
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
      d();
    }
    do
    {
      do
      {
        return true;
        if (556 == paramMessage.what)
        {
          e();
          return true;
        }
        if (1 == paramMessage.what)
        {
          a((List)paramMessage.obj);
          return true;
        }
      } while (2 != paramMessage.what);
      if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.b(this.jdField_b_of_type_JavaUtilList);
      }
    } while (!QLog.isColorLevel());
    QLog.d("SearchResultDialog", 2, "load history data finish");
    return true;
  }
  
  public void show()
  {
    super.show();
    if (QLog.isColorLevel()) {
      QLog.d("SearchResultDialog", 2, "show() this = " + this);
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(555);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(556);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.SearchResultDialog
 * JD-Core Version:    0.7.0.1
 */