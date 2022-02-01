package com.tencent.mobileqq.matchchat;

import aajb;
import aajg;
import acbn;
import acfd;
import afcp;
import afsg;
import afsi;
import afsr;
import afwz;
import aine;
import aizt;
import aizu;
import aizv;
import aizw;
import aizx;
import aizy;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqdj;
import aqgv;
import aqgw;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.SwipListView.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import top;

public class MatchChatMsgListFragment
  extends IphoneTitleBarFragment
  implements aajb, afcp, Handler.Callback, View.OnClickListener, DragFrameLayout.c, AbsListView.e, SwipListView.a, Observer
{
  private List<Long> CO = new ArrayList();
  public long VX;
  final Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new aizx(this);
  TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  public DragFrameLayout a;
  boolean aey = true;
  private afsi jdField_b_of_type_Afsi;
  FPSSwipListView jdField_b_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  public boolean bTI = false;
  public boolean bTJ = false;
  String bwL = "";
  private afsr c = new aizu(this);
  int cMA = -1;
  int cMB;
  private boolean cbc;
  private Object eb = new Object();
  public aajg f;
  private DialogInterface.OnDismissListener g = new aizt(this);
  private View hY;
  Map<String, RecentBaseData> jP;
  MqqHandler k;
  public QQAppInterface mApp;
  public BaseActivity mContext;
  private View mEntryView;
  public View mFooterView;
  public boolean mHasMore = false;
  LinearLayout mHeaderView;
  int mScrollState = 0;
  MqqHandler mUIHandler;
  final acfd n = new aizw(this);
  List<MessageRecord> yS;
  public List<RecentBaseData> yT;
  
  private List<MessageRecord> aB(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new ArrayList(paramList);
    HashSet localHashSet = new HashSet();
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      if (localHashSet.contains(top.e((MessageRecord)paramList.get(i)))) {
        localArrayList.add(paramList.get(i));
      }
      for (;;)
      {
        i -= 1;
        break;
        localHashSet.add(top.e((MessageRecord)paramList.get(i)));
      }
    }
    paramList.removeAll(localArrayList);
    Collections.reverse(paramList);
    return paramList;
  }
  
  private void aC()
  {
    setTitle(this.mContext.getString(2131701319));
    setRightButton(2131701323, new aizv(this));
  }
  
  public static void ap(Context paramContext, int paramInt)
  {
    paramContext.startActivity(aizy.e(paramContext));
  }
  
  private void av(String paramString, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(this.mContext, ChatActivity.class);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt1);
    String str2 = aqgv.G(this.mApp, paramString);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = aqgv.b(this.mApp, paramString, false);
    }
    localIntent.putExtra("uinname", str1);
    localIntent.putExtra("entrance", paramInt2);
    startActivity(localIntent);
  }
  
  private TopGestureLayout b()
  {
    ViewGroup localViewGroup = (ViewGroup)this.mContext.getWindow().getDecorView();
    View localView = localViewGroup.getChildAt(0);
    Object localObject = localViewGroup;
    if (localView != null)
    {
      localObject = localViewGroup;
      if ((localView instanceof DragFrameLayout)) {
        localObject = (ViewGroup)localView;
      }
    }
    localObject = ((ViewGroup)localObject).getChildAt(0);
    if ((localObject instanceof TopGestureLayout)) {
      return (TopGestureLayout)localObject;
    }
    return null;
  }
  
  private void b(LayoutInflater paramLayoutInflater)
  {
    if (paramLayoutInflater == null) {
      return;
    }
    Resources localResources = this.mContext.getResources();
    this.mEntryView = paramLayoutInflater.inflate(2131561332, this.mHeaderView, false);
    if ((LinearLayout.LayoutParams)this.mEntryView.getLayoutParams() == null)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, localResources.getDimensionPixelSize(2131299267));
      localLayoutParams.bottomMargin = localResources.getDimensionPixelSize(2131298718);
      this.mHeaderView.addView(this.mEntryView, localLayoutParams);
    }
    for (;;)
    {
      this.mEntryView.setOnClickListener(this);
      this.hY = paramLayoutInflater.inflate(2131561335, this.mHeaderView, false);
      if ((LinearLayout.LayoutParams)this.hY.getLayoutParams() != null) {
        break;
      }
      paramLayoutInflater = new LinearLayout.LayoutParams(-1, localResources.getDimensionPixelSize(2131298719));
      this.mHeaderView.addView(this.hY, paramLayoutInflater);
      return;
      this.mHeaderView.addView(this.mEntryView);
    }
    this.mHeaderView.addView(this.hY);
  }
  
  private void cZ(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    boolean bool;
    String str;
    int i;
    do
    {
      return;
      bool = paramBundle.getBoolean("key_matchchat_from_notification", false);
      str = paramBundle.getString("key_matchchat_from_notification_uin", "");
      i = paramBundle.getInt("key_matchchat_from_notification_type", 1044);
    } while ((!bool) || (TextUtils.isEmpty(str)));
    av(str, i, 21);
  }
  
  private void cZ(ArrayList<Long> paramArrayList)
  {
    this.CO.clear();
    if (paramArrayList != null) {
      this.CO.addAll(paramArrayList);
    }
    if (this.k != null)
    {
      this.k.removeMessages(2);
      this.k.sendEmptyMessage(2);
    }
  }
  
  private void dc(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      ImageView localImageView = (ImageView)paramView.findViewById(2131368698);
      Object localObject = this.mApp.getCurrentAccountUin();
      Drawable localDrawable = aqdj.g(1, 1);
      localObject = aqdj.a(this.mApp, 1, (String)localObject, 1, localDrawable, localDrawable, null);
      if (localImageView != null) {
        localImageView.setImageDrawable((Drawable)localObject);
      }
      paramView = (TextView)paramView.findViewById(16908308);
    } while (paramView == null);
    paramView.setText(this.mApp.getCurrentNickname());
  }
  
  private void kz(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        try
        {
          localArrayList.add(Long.valueOf(localMessageRecord.senderuin));
        }
        catch (Exception localException) {}
      }
    }
    if (!localArrayList.isEmpty())
    {
      paramList = (afsg)this.mApp.getBusinessHandler(127);
      if (paramList != null) {
        paramList.kz(localArrayList);
      }
    }
  }
  
  public void L(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  public boolean Pr()
  {
    return (this.mScrollState != 0) && (this.mScrollState != 1);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramRecentBaseData.qx())) {
      av(paramRecentBaseData.qx(), paramRecentBaseData.ng(), 21);
    }
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if ((paramRecentBaseData instanceof RecentMatchChatListItem)) {
      aizy.a(this.mApp, (RecentMatchChatListItem)paramRecentBaseData, true);
    }
    cWP();
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2) {}
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.getMode() == -1)
    {
      cWP();
      ((afsg)this.mApp.getBusinessHandler(127)).bXV();
    }
  }
  
  protected List<RecentBaseData> aV(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0)) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      boolean bool1;
      if (localMessageRecord != null) {
        bool1 = false;
      }
      try
      {
        long l = Long.valueOf(localMessageRecord.senderuin).longValue();
        boolean bool2 = this.CO.contains(Long.valueOf(l));
        bool1 = bool2;
      }
      catch (Exception localException)
      {
        label89:
        RecentMatchChatListItem localRecentMatchChatListItem;
        break label89;
      }
      localRecentMatchChatListItem = new RecentMatchChatListItem(localMessageRecord);
      localRecentMatchChatListItem.mExtendFriendOnline = bool1;
      localRecentMatchChatListItem.c(this.mApp, this.mContext);
      localArrayList.add(localRecentMatchChatListItem);
      this.jdField_b_of_type_Afsi.a(localMessageRecord.frienduin, true);
    }
    return localArrayList;
  }
  
  public void cWP()
  {
    if (this.k != null)
    {
      this.k.removeMessages(0);
      this.k.sendEmptyMessage(0);
    }
  }
  
  public void cWQ() {}
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.aey = ThemeUtil.isDefaultOrDIYTheme(false);
    this.jdField_b_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)this.mContentView.findViewById(2131370573));
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setBackgroundResource(2130838901);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.b(this.mContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
      this.mHeaderView = new LinearLayout(this.mContext);
      this.mHeaderView.setOrientation(1);
      this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      this.jdField_b_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView(this.mHeaderView, 0);
      this.mFooterView = paramLayoutInflater.inflate(2131559027, null);
      this.mFooterView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addFooterView(this.mFooterView);
      this.jdField_b_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setRightIconMenuListener(this);
      this.jdField_b_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
      this.f = new aajg(this.mContext, this.mApp, this.jdField_b_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this, 13);
      this.f.setDragHost(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      this.jdField_b_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.f);
      this.f.FX(20);
      this.k = new aqgw(ThreadManager.getSubThreadLooper(), this);
      this.mUIHandler = new aqgw(this.mContext.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
      this.jP = new ConcurrentHashMap();
      this.yT = new ArrayList();
      this.mApp.addObserver(this.n, true);
      this.mApp.b().addObserver(this);
      if (QLog.isColorLevel()) {
        this.VX = System.currentTimeMillis();
      }
      aC();
      b(paramLayoutInflater);
      dc(this.mEntryView);
      paramLayoutInflater = (afsg)this.mApp.getBusinessHandler(127);
      if (paramLayoutInflater != null) {
        paramLayoutInflater.Il(false);
      }
      return;
    }
    catch (Throwable paramViewGroup)
    {
      for (;;)
      {
        QLog.e("MatchChatMsgListFragment", 1, paramViewGroup, new Object[0]);
      }
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131561333;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    LinkedList localLinkedList = null;
    int i = 50;
    long l;
    int j;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      l = System.currentTimeMillis();
      this.yS = this.mApp.b().b(this.bwL, this.cMA, null);
      if (this.yS == null) {
        this.yS = new ArrayList();
      }
      jM(this.yS);
      if (QLog.isDevelopLevel()) {
        QLog.d("MatchChatMsgListFragment", 4, String.format(Locale.getDefault(), "MSG_REFRESH_LIST_GLOBAL cloneMsgBoxList cost: %s ", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
      }
      kz(this.yS);
      if (this.yS == null)
      {
        i = 0;
        if (i > 50) {
          break label317;
        }
        j = i;
        label155:
        if ((this.cMB <= j) || (this.cMB > i)) {
          break label590;
        }
        j = this.cMB;
      }
      break;
    }
    label187:
    label317:
    label331:
    label590:
    for (;;)
    {
      if (j > 50)
      {
        this.mHasMore = true;
        if (QLog.isColorLevel()) {
          QLog.d("MatchChatMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_REFRESH_LIST_GLOBAL totalCount: %s, loadCount: %s, curItemCount: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.cMB) }));
        }
        localLinkedList = new LinkedList();
        paramMessage = localLinkedList;
        if (this.yS != null)
        {
          paramMessage = localLinkedList;
          if (i > 0) {
            paramMessage = this.yS.subList(0, j);
          }
        }
        paramMessage = aV(paramMessage);
        if (paramMessage == null) {
          break label331;
        }
      }
      for (i = paramMessage.size();; i = 0)
      {
        this.cMB = i;
        jL(paramMessage);
        return false;
        i = this.yS.size();
        break;
        j = 50;
        break label155;
        this.mHasMore = false;
        break label187;
      }
      l = System.currentTimeMillis();
      if ((this.cMB > 0) && (this.yS != null))
      {
        int m = this.cMB;
        int i1 = this.yS.size();
        j = i1 - this.cMB;
        if (j <= 0) {
          break;
        }
        if (j <= 50) {
          break label520;
        }
        this.mHasMore = true;
        if (QLog.isColorLevel()) {
          QLog.d("MatchChatMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_LOAD_NEXT_PAGE totalCount: %s, loadCount: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(i) }));
        }
        paramMessage = aV(this.yS.subList(0, m - 1 + 1 + i));
        if (paramMessage == null) {
          break label530;
        }
      }
      for (i = paramMessage.size();; i = 0)
      {
        this.cMB = i;
        jL(paramMessage);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MatchChatMsgListFragment", 2, String.format(Locale.getDefault(), "MSG_LOAD_NEXT_PAGE cost: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
        return false;
        this.mHasMore = false;
        i = j;
        break label395;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MatchChatMsgListFragment", 2, "handleMessage MSG_RELOAD_CURRENT_LIST");
      }
      if (this.yS == null) {}
      for (paramMessage = localLinkedList;; paramMessage = this.yS.subList(0, this.cMB))
      {
        jL(aV(paramMessage));
        return false;
      }
    }
  }
  
  protected void jL(List<RecentBaseData> paramList)
  {
    if (this.mUIHandler != null) {}
    synchronized (this.eb)
    {
      this.yT.clear();
      if (paramList != null) {
        this.yT.addAll(paramList);
      }
      paramList = new Message();
      paramList.what = 0;
      this.mUIHandler.removeMessages(0);
      this.mUIHandler.sendMessage(paramList);
      this.bTJ = false;
      return;
    }
  }
  
  protected void jM(List<MessageRecord> paramList)
  {
    this.yS = aB(paramList);
  }
  
  public boolean nj(String paramString)
  {
    try
    {
      Iterator localIterator = this.yT.iterator();
      while (localIterator.hasNext())
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
        if (localRecentBaseData != null)
        {
          boolean bool = TextUtils.equals(localRecentBaseData.qx(), paramString);
          if (bool) {
            return true;
          }
        }
      }
    }
    catch (Throwable paramString)
    {
      return false;
    }
    return false;
  }
  
  public boolean onBackEvent()
  {
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.mApp.getCurrentAccountUin(), 0);
      ProfileActivity.b(getActivity(), localAllInOne, 1031);
      anot.a(this.mApp, "dc00898", "", "", "0X800A697", "0X800A697", 0, 0, "", "", "", "");
    }
  }
  
  public void onClick(View paramView, Object paramObject) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mContext = getActivity();
    this.mApp = ((QQAppInterface)this.mContext.getAppInterface());
    this.mApp.addObserver(this.c);
    this.jdField_b_of_type_Afsi = ((afsi)this.mApp.getManager(264));
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.cMA = paramBundle.getInt("uintype", -1);
      this.bwL = paramBundle.getString("uin", "");
    }
    if (!top.x(this.bwL, this.cMA))
    {
      this.cMA = 1044;
      this.bwL = acbn.blR;
    }
    cZ(paramBundle);
    if (QLog.isDevelopLevel()) {
      QLog.i("MatchChatMsgListFragment", 4, String.format(Locale.getDefault(), "onCreate [type: %s, uin: %s]", new Object[] { Integer.valueOf(this.cMA), this.bwL }));
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.k.removeCallbacksAndMessages(null);
    this.mUIHandler.removeCallbacksAndMessages(null);
    if (this.mApp != null)
    {
      this.mApp.removeObserver(this.n);
      this.mApp.removeObserver(this.c);
      if (this.mApp.b() != null) {
        this.mApp.b().deleteObserver(this);
      }
    }
    if (this.f != null) {
      this.f.onDestory();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    cWP();
    this.mScrollState = 0;
  }
  
  public void onRightIconMenuHide(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(true);
    }
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(false);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {
      return;
    }
    if (paramAbsListView.getCount() - 1 == paramAbsListView.getLastVisiblePosition()) {}
    for (int i = 1;; i = 0)
    {
      if ((paramInt == 0) || (paramInt == 1)) {
        this.f.Cq(false);
      }
      for (;;)
      {
        this.mScrollState = paramInt;
        if ((paramInt == 0) && (this.bTJ) && (this.k != null))
        {
          this.k.removeMessages(0);
          this.k.sendEmptyMessage(0);
        }
        if ((i == 0) || (this.k == null)) {
          break;
        }
        this.k.sendEmptyMessage(1);
        return;
        this.f.Cq(true);
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptScrollRLFlag(false);
    }
    if (!this.cbc) {
      this.cbc = afwz.a(this.mContext, this.mApp, this.g);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    ((afsg)this.mApp.getBusinessHandler(127)).bXV();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord)) {
      if (aine.aD((MessageRecord)paramObject)) {}
    }
    while (!(paramObject instanceof RecentUser))
    {
      return;
      cWP();
      return;
    }
    cWP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatMsgListFragment
 * JD-Core Version:    0.7.0.1
 */