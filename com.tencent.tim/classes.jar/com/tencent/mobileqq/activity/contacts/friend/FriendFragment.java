package com.tencent.mobileqq.activity.contacts.friend;

import accc;
import accn;
import acdt;
import acfd;
import acff;
import acfp;
import achq;
import ajdo.a;
import ajol;
import akwl;
import amfh;
import amhj;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import anot;
import anov;
import aqft;
import aqiw;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.b;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import friendlist.GetOnlineInfoResp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.os.MqqHandler;
import yzr.b;
import zam;

public class FriendFragment
  extends ContactsBaseFragment
  implements ajdo.a, Handler.Callback, View.OnClickListener
{
  protected ContactsFPSPinnedHeaderExpandableListView a;
  private final a jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$a = new a(null);
  private final c jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$c = new c(null);
  private final d jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$d = new d(null);
  private final e jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$e = new e(null);
  private boolean aUD = true;
  private boolean aUE;
  private MqqHandler b;
  protected zam b;
  private akwl f = new b(null);
  private View yu;
  
  public FriendFragment()
  {
    this.jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  }
  
  private void aa(long paramLong, boolean paramBoolean)
  {
    int i = 9527;
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "refreshBuddyList, delay=" + paramLong + ", load=" + paramBoolean);
    }
    this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(4);
    if (paramBoolean) {
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(9527);
    }
    while (paramLong == 0L)
    {
      wD(paramBoolean);
      return;
      if (this.jdField_b_of_type_MqqOsMqqHandler.hasMessages(9527)) {
        return;
      }
    }
    MqqHandler localMqqHandler = this.jdField_b_of_type_MqqOsMqqHandler;
    if (paramBoolean) {}
    for (;;)
    {
      localMqqHandler.sendEmptyMessageDelayed(i, paramLong);
      return;
      i = 4;
    }
  }
  
  private void b(Friends paramFriends)
  {
    ExtensionInfo localExtensionInfo = this.mApp.a(paramFriends.uin, false);
    if ((localExtensionInfo != null) && (localExtensionInfo.feedType == 2) && (!TextUtils.isEmpty(localExtensionInfo.feedPhotoUrl))) {
      new anov(this.mApp).a("dc00898").e(paramFriends.uin).c("mystatus_notice").d("contact_notice_clk").report();
    }
  }
  
  private void bLJ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "resetContactsList, mElvGroupingBuddies=" + this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView != null)
    {
      if (this.jdField_b_of_type_Zam != null)
      {
        this.jdField_b_of_type_Zam.destroy();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.resetState();
      }
      this.jdField_b_of_type_Zam = new zam(this.mActivity, this.mApp, this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView, this);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.getFooterViewsCount() <= 0)
      {
        if (this.yu == null)
        {
          this.yu = LayoutInflater.from(getActivity()).inflate(2131559028, this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView, false);
          this.yu.setOnClickListener(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.addFooterView(this.yu);
      }
      if (this.yu != null) {
        this.yu.setVisibility(4);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.setAdapter(this.jdField_b_of_type_Zam);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.setOnScrollListener(this.jdField_b_of_type_Zam);
    }
  }
  
  private void cnz()
  {
    int i = ((acff)this.mApp.getManager(51)).Au();
    if (i <= 0)
    {
      PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.mApp.getManager(11);
      int j = localPhoneContactManagerImp.xy();
      if ((localPhoneContactManagerImp.Ur()) || (j == 8)) {
        i = localPhoneContactManagerImp.o(false).size() + i;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("contacts.fragment.FriendFragment", 2, "refreshUnusualContactsFooter " + i);
      }
      if (i > 0)
      {
        if ((this.yu == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView != null)) {
          anot.a(this.mApp, "CliOper", "", "", "0X8004C4D", "0X8004C4D", 0, 0, "", "", "", "");
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.getFooterViewsCount() <= 0)) {
          if (this.yu == null) {
            if (getActivity() == null) {
              QLog.e("contacts.fragment.FriendFragment", 1, "refreshUnusualContactsFooter getActivity return null");
            }
          }
        }
      }
      while ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.getFooterViewsCount() <= 0))
      {
        do
        {
          return;
          this.yu = LayoutInflater.from(getActivity()).inflate(2131559028, this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView, false);
          this.yu.setOnClickListener(this);
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.addFooterView(this.yu);
        } while (this.yu == null);
        this.yu.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.removeFooterView(this.yu);
      return;
    }
  }
  
  private void fJ(View paramView)
  {
    Object localObject = paramView.getTag(-2);
    paramView = paramView.getTag(-10);
    if ((!(localObject instanceof Integer)) || ((!(paramView instanceof Friends)) && (!(paramView instanceof TroopInfo)) && (!(paramView instanceof DiscussionInfo)))) {
      if (QLog.isDevelopLevel()) {
        QLog.d("contacts.fragment.FriendFragment", 2, "handleRightMenuClick onClick tag is not int");
      }
    }
    do
    {
      int i;
      do
      {
        return;
        if (!aqiw.isNetworkAvailable(this.mActivity))
        {
          QQToast.a(this.mActivity, 1, 2131693404, 1).show();
          return;
        }
        if (!(paramView instanceof Friends)) {
          break;
        }
        i = ((Integer)localObject).intValue();
        paramView = (Friends)paramView;
        localObject = (FriendListHandler)this.mApp.getBusinessHandler(1);
        if (i == zap.fy[1])
        {
          ((FriendListHandler)localObject).b(1, new String[] { paramView.uin }, new boolean[] { true });
          anot.a(this.mApp, "CliOper", "", "", "0X8006A6B", "0X8006A6B", 0, 0, "", "", "", "");
          return;
        }
      } while (i != zap.fy[0]);
      ((FriendListHandler)localObject).b(1, new String[] { paramView.uin }, new boolean[] { false });
      return;
      if ((paramView instanceof TroopInfo))
      {
        paramView = (TroopInfo)paramView;
        ((accc)this.mApp.getBusinessHandler(22)).N(paramView.troopcode, 1);
        new anov(this.mApp).a("dc00899").b("Grp_set").c("Grp_contactlist").d("Clk_unstick").a(new String[] { paramView.troopuin }).report();
        return;
      }
    } while (!(paramView instanceof DiscussionInfo));
    paramView = (DiscussionInfo)paramView;
    ((acdt)this.mApp.getBusinessHandler(6)).ho(Long.valueOf(paramView.uin).longValue());
  }
  
  private void s(ListView paramListView)
  {
    if (paramListView == this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView) {
      if (paramListView.getFirstVisiblePosition() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.setSelection(0);
      }
    }
    while (paramListView.getFirstVisiblePosition() <= 0) {
      return;
    }
    paramListView.setSelection(0);
  }
  
  private void updateQzoneFeeds()
  {
    ThreadManager.getSubThreadHandler().post(new FriendFragment.1(this));
  }
  
  private boolean v(Object paramObject)
  {
    if ((paramObject instanceof Friends))
    {
      paramObject = (Friends)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("Hyim", 2, "onItemClick:" + paramObject.name + paramObject.uin + "--[" + paramObject.detalStatusFlag + "] [" + paramObject.iTermType + "] [" + paramObject.getLastLoginType() + "] [" + paramObject.showLoginClient + "]");
      }
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(paramObject.uin, 1);
      localAllInOne.bJa = 59;
      localAllInOne.bJc = 2;
      ProfileActivity.b(this.mActivity, localAllInOne);
      b(paramObject);
      return true;
    }
    return false;
  }
  
  private void wD(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "<<--doRefreshBuddyList, load=" + paramBoolean);
    }
    cnz();
    if (this.jdField_b_of_type_Zam != null)
    {
      if (paramBoolean) {
        this.jdField_b_of_type_Zam.notifyDataSetChanged();
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_Zam.cnv();
  }
  
  public void Av(boolean paramBoolean)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "doOnResume. tabChange:" + paramBoolean + ",mElvGroupingBuddies=" + this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView + ", mGroupingBuddyListAdapter=" + this.jdField_b_of_type_Zam);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView == null) {
      return;
    }
    if (this.jdField_b_of_type_Zam == null) {
      bLJ();
    }
    bpM();
    aa(500L, true);
    ((FriendListHandler)this.mApp.getBusinessHandler(1)).e(this.mApp.getCurrentAccountUin(), (byte)1);
    if (this.jdField_b_of_type_Zam != null)
    {
      int k = this.jdField_b_of_type_Zam.getGroupCount();
      int j = 0;
      while (i < k)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.isGroupExpanded(i)) {
          j = 1;
        }
        i += 1;
      }
      if (j != 0) {
        updateQzoneFeeds();
      }
    }
    if (!this.jdField_b_of_type_MqqOsMqqHandler.hasMessages(5))
    {
      i = ajol.Gw();
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(5, i * 1000);
    }
    ((acff)this.mApp.getManager(51)).aL(true);
  }
  
  public void Aw(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "doOnPause.");
    }
    if (paramBoolean) {
      bpN();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.AP();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.pause();
    }
    if (this.jdField_b_of_type_Zam != null) {
      this.jdField_b_of_type_Zam.pause();
    }
  }
  
  public void T(boolean paramBoolean, int paramInt) {}
  
  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "getView mElvGroupingBuddies=" + this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView == null) {
      if (paramLayoutInflater != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView = ((ContactsFPSPinnedHeaderExpandableListView)paramLayoutInflater.inflate(2131559059, null));
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.setActTAG("actFPSFriend");
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.setSelector(2131167595);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.setGroupIndicator(null);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.mForContacts = true;
      }
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView;
      paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.getParent();
      if ((paramLayoutInflater != null) && ((paramLayoutInflater instanceof ViewGroup))) {
        ((ViewGroup)paramLayoutInflater).removeView(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView);
      }
    }
  }
  
  public void bMf()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView != null) && (this.jdField_b_of_type_Zam != null))
    {
      int j = this.jdField_b_of_type_Zam.getGroupCount();
      int i = 0;
      while (i < j)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView.collapseGroup(i);
        i += 1;
      }
      s(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendContactsFPSPinnedHeaderExpandableListView);
    }
  }
  
  public void bpM()
  {
    this.mApp.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$c);
    this.mApp.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$a);
    this.mApp.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$d);
    this.mApp.registObserver(this.f);
    amhj localamhj = (amhj)this.mApp.getManager(15);
    if (localamhj != null) {
      localamhj.addListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$e);
    }
    ((PhoneContactManagerImp)this.mApp.getManager(11)).a(this);
  }
  
  public void bpN()
  {
    this.mApp.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$c);
    this.mApp.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$a);
    this.mApp.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$d);
    this.mApp.unRegistObserver(this.f);
    amhj localamhj = (amhj)this.mApp.getManager(15);
    if (localamhj != null) {
      localamhj.removeListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendFriendFragment$e);
    }
    ((PhoneContactManagerImp)this.mApp.getManager(11)).b(this);
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "doOnDestroy.");
    }
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_b_of_type_Zam != null) {
      this.jdField_b_of_type_Zam.destroy();
    }
    bpN();
  }
  
  public void eH(long paramLong) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
      } while (!this.aUD);
      aa(0L, false);
      return true;
      aa(0L, true);
      return true;
    } while (!this.aUD);
    aa(0L, false);
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if (aqft.equalsWithNullCheck("tag_swip_icon_menu_item", paramView.getTag())) {
        fJ(paramView);
      }
      break;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      GroupManagerActivity.bu(this.mActivity);
      anot.a(this.mApp, "CliOper", "", "", "category", "Edit_category", 0, 0, "", "", "", "");
      continue;
      startActivity(new Intent(getActivity(), UncommonlyUsedContactsActivity.class));
      anot.a(this.mApp, "CliOper", "", "", "0X8004C4E", "0X8004C4E", 0, 0, "", "", "", "");
      continue;
      yzr.b localb = (yzr.b)paramView.getTag();
      if ((localb != null) && (localb.item != null)) {
        v(localb.item);
      }
    }
  }
  
  public void refresh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "refresh");
    }
    updateQzoneFeeds();
    if (this.aUD) {
      ((FriendListHandler)this.mApp.getBusinessHandler(1)).by(true, true);
    }
    this.aUE = true;
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "updateBuddyList succeeded");
    }
    anot.a(this.mApp, "CliOper", "", "", "Contacts_tab", "Refresh_contacts", 51, 0, "", "", "", "");
  }
  
  public void resetData()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "resetData");
    }
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    bLJ();
  }
  
  public void sc(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "onBindStateChanged bindState=" + paramInt);
    }
    cnz();
  }
  
  public void sd(int paramInt) {}
  
  public void se(int paramInt) {}
  
  class a
    extends accn
  {
    private a() {}
    
    public void onCardDownload(boolean paramBoolean, Object paramObject)
    {
      if ((paramBoolean) && (FriendFragment.b(FriendFragment.this))) {
        FriendFragment.a(FriendFragment.this, 1400L, true);
      }
    }
    
    public void onGetCalReactiveDays(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("interactive", 2, " contacts onGetCalReactiveDays isAllow= " + paramBoolean2);
        }
        FriendFragment.a(FriendFragment.this, 1400L, false);
      }
    }
  }
  
  class b
    extends akwl
  {
    private b() {}
    
    public void xp(boolean paramBoolean)
    {
      FriendFragment.a(FriendFragment.this);
    }
  }
  
  class c
    extends acfd
  {
    private c() {}
    
    public void onAddGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
    {
      if ((paramBoolean) && (FriendFragment.b(FriendFragment.this))) {
        FriendFragment.a(FriendFragment.this, 1400L, true);
      }
    }
    
    public void onDeleteGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
    {
      if ((paramBoolean) && (FriendFragment.b(FriendFragment.this))) {
        FriendFragment.a(FriendFragment.this, 1400L, true);
      }
    }
    
    public void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
    {
      if ((paramBoolean) && (FriendFragment.b(FriendFragment.this))) {
        FriendFragment.a(FriendFragment.this, 1400L, true);
      }
    }
    
    public void onGroupDataInited()
    {
      FriendFragment.a(FriendFragment.this, 1400L, true);
    }
    
    public void onRenameGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
    {
      if ((paramBoolean) && (FriendFragment.b(FriendFragment.this))) {
        FriendFragment.a(FriendFragment.this, 1400L, true);
      }
    }
    
    public void onResortGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
    {
      if ((paramBoolean) && (FriendFragment.b(FriendFragment.this))) {
        FriendFragment.a(FriendFragment.this, 1400L, true);
      }
    }
    
    public void onSetAsNormalContacts(boolean paramBoolean, List<String> paramList)
    {
      if ((paramBoolean) && (FriendFragment.b(FriendFragment.this))) {
        FriendFragment.a(FriendFragment.this, 1400L, true);
      }
    }
    
    public void onSetAsUncommonlyUsedContacts(boolean paramBoolean, List<String> paramList)
    {
      if ((paramBoolean) && (FriendFragment.b(FriendFragment.this))) {
        FriendFragment.a(FriendFragment.this, 1400L, true);
      }
    }
    
    public void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
    {
      if ((paramBoolean) && (FriendFragment.b(FriendFragment.this))) {
        FriendFragment.a(FriendFragment.this, 1400L, true);
      }
    }
    
    public void onSetSpecialCareSwitch_global(boolean paramBoolean, Object[] paramArrayOfObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("contacts.fragment.FriendFragment", 2, "onSetSpecialCareSwitch_global isSuccess: " + paramBoolean);
      }
      if (FriendFragment.this.b != null) {
        FriendFragment.this.b.notifyDataSetChanged();
      }
      if ((paramBoolean) && (FriendFragment.this.isResumed())) {
        try
        {
          String[] arrayOfString = (String[])paramArrayOfObject[1];
          paramArrayOfObject = (boolean[])paramArrayOfObject[2];
          if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.FriendFragment", 2, new Object[] { "onSetSpecialCareSwitch_global uinArray=%s stateArray=%s", Arrays.toString(arrayOfString), Arrays.toString(paramArrayOfObject) });
          }
          if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0))
          {
            if (paramArrayOfObject[0] != 0)
            {
              QQToast.a(FriendFragment.this.getActivity(), 2, acfp.m(2131706573), 0).show();
              return;
            }
            QQToast.a(FriendFragment.this.getActivity(), 2, acfp.m(2131706574), 0).show();
            return;
          }
        }
        catch (Exception paramArrayOfObject)
        {
          if (QLog.isColorLevel()) {
            QLog.e("contacts.fragment.FriendFragment", 2, "onSetSpecialCareSwitch_global fail!", paramArrayOfObject);
          }
        }
      }
    }
    
    public void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d("contacts.fragment.FriendFragment", 2, "onUpdateAddFriend isSucess= " + paramBoolean1 + ",addSuccess=" + paramBoolean2 + " addDirect=" + paramBoolean3);
      }
      if ((paramBoolean1) && (paramBoolean2) && (paramBoolean3)) {
        FriendFragment.a(FriendFragment.this, 1400L, true);
      }
    }
    
    public void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt)
    {
      if ((paramBoolean) && (FriendFragment.b(FriendFragment.this))) {
        FriendFragment.a(FriendFragment.this, 1400L, true);
      }
    }
    
    public void onUpdateCustomHead(boolean paramBoolean, String paramString)
    {
      if (paramBoolean) {
        FriendFragment.a(FriendFragment.this, 5000L, false);
      }
    }
    
    public void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("contacts.fragment.FriendFragment", 2, "onUpdateDelFriend isSucess= " + paramBoolean);
      }
      if (paramBoolean) {
        FriendFragment.a(FriendFragment.this, 1400L, true);
      }
    }
    
    public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
    {
      if ((paramBoolean) && (FriendFragment.b(FriendFragment.this))) {
        FriendFragment.a(FriendFragment.this, 1400L, true);
      }
    }
    
    public void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
    {
      FriendFragment localFriendFragment = FriendFragment.this;
      boolean bool;
      if ((paramBoolean2) || (!paramBoolean1))
      {
        bool = true;
        FriendFragment.a(localFriendFragment, bool);
        if (QLog.isColorLevel()) {
          QLog.d("contacts.fragment.FriendFragment", 2, "onUpdateFriendList isSucess= " + paramBoolean1 + ",isComplete=" + paramBoolean2);
        }
        paramBoolean2 = FriendFragment.a(FriendFragment.this);
        if (FriendFragment.a(FriendFragment.this))
        {
          if (FriendFragment.b(FriendFragment.this))
          {
            FriendFragment.b(FriendFragment.this, false);
            if (FriendFragment.a(FriendFragment.this) != null) {
              FriendFragment.b(FriendFragment.this).d(FriendFragment.this.xZ(), paramBoolean1, null);
            }
          }
          localFriendFragment = FriendFragment.this;
          if (!FriendFragment.b(FriendFragment.this)) {
            break label189;
          }
        }
      }
      label189:
      for (long l = 0L;; l = 1400L)
      {
        FriendFragment.a(localFriendFragment, l, true);
        if ((!paramBoolean2) && (FriendFragment.b(FriendFragment.this))) {
          FriendFragment.a(FriendFragment.this, 1400L, true);
        }
        return;
        bool = false;
        break;
      }
    }
    
    public void onUpdateGatherFriendList(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      if ((paramBoolean1) && (paramBoolean2) && (paramBoolean3)) {
        FriendFragment.a(FriendFragment.this, 0L, true);
      }
    }
    
    public void onUpdateHotFriendLevel(boolean paramBoolean, ArrayList<String> paramArrayList)
    {
      FriendFragment.a(FriendFragment.this, 1400L, false);
    }
    
    public void onUpdateLastLoginInfo(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean1) {
        FriendFragment.a(FriendFragment.this, 1400L, false);
      }
    }
    
    public void onUpdateMoveGroup(String paramString, byte paramByte1, byte paramByte2)
    {
      if ((paramString != null) && (FriendFragment.b(FriendFragment.this))) {
        FriendFragment.a(FriendFragment.this, 1400L, true);
      }
    }
    
    public void onUpdateOlympicTorchList(boolean paramBoolean)
    {
      if (paramBoolean) {
        FriendFragment.a(FriendFragment.this, 1400L, false);
      }
    }
    
    public void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
    {
      if ((paramBoolean) && (FriendFragment.b(FriendFragment.this))) {
        FriendFragment.a(FriendFragment.this, 1400L, true);
      }
    }
    
    public void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString)
    {
      if ((paramBoolean) && (FriendFragment.b(FriendFragment.this))) {
        FriendFragment.a(FriendFragment.this, 1400L, false);
      }
    }
    
    public void onUpdateSpecialCareList(boolean paramBoolean1, boolean paramBoolean2, List<SpecialCareInfo> paramList)
    {
      if (QLog.isColorLevel()) {
        QLog.d("contacts.fragment.FriendFragment", 2, "onUpdateSpecialCareList isSucess= " + paramBoolean1 + ",isComplete=" + paramBoolean2);
      }
      if ((paramBoolean1) && (FriendFragment.this.b != null)) {
        FriendFragment.this.b.notifyDataSetChanged();
      }
    }
  }
  
  class d
    extends achq
  {
    private d() {}
    
    public void cna()
    {
      if (FriendFragment.b(FriendFragment.this)) {
        FriendFragment.a(FriendFragment.this, 1400L, true);
      }
    }
  }
  
  class e
    implements amfh
  {
    private e() {}
    
    public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
    {
      if ((FriendFragment.b(FriendFragment.this)) && (paramBitmap != null) && (paramInt2 == 200)) {
        FriendFragment.a(FriendFragment.this, 1400L, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.FriendFragment
 * JD-Core Version:    0.7.0.1
 */