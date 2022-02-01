package com.tencent.mobileqq.activity.contacts.alphabet;

import accn;
import acfd;
import acff;
import acfp;
import achq;
import ajdo.a;
import ajol;
import amfh;
import amhj;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import anot;
import aqft;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.b;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.os.MqqHandler;
import yyy;
import yzr.b;

public class AlphabetFriendFragment
  extends ContactsBaseFragment
  implements ajdo.a, Handler.Callback, View.OnClickListener, IndexBar.a
{
  private final a jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$a = new a(null);
  private final b jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$b = new b(null);
  private final c jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$c = new c(null);
  private final d jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$d = new d(null);
  protected IndexBarTipsLayout a;
  private yyy jdField_a_of_type_Yyy;
  private boolean aUD = true;
  private boolean aUE;
  private String aZQ = "";
  protected IndexBar b;
  private MqqHandler b;
  private boolean bpN = true;
  protected PinnedDividerListView c;
  private Runnable jdField_do = new AlphabetFriendFragment.1(this);
  private View mFooterView;
  protected View mRootView;
  private Vibrator mVibrator;
  
  public AlphabetFriendFragment()
  {
    this.jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  }
  
  private void aa(long paramLong, boolean paramBoolean)
  {
    int i = 9527;
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "refreshBuddyList, delay=" + paramLong + ", load=" + paramBoolean);
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
  
  private void cmZ()
  {
    if ((this.c != null) && (this.c.getFooterViewsCount() <= 0))
    {
      if (this.mFooterView != null) {
        break label61;
      }
      if (getActivity() == null) {
        QLog.e("contacts.fragment.AlphabetFriendFragment", 1, "refreshUnusualContactsFooter getActivity return null");
      }
    }
    else
    {
      return;
    }
    this.mFooterView = LayoutInflater.from(getActivity()).inflate(2131559026, this.c, false);
    label61:
    this.c.addFooterView(this.mFooterView);
  }
  
  private boolean v(Object paramObject)
  {
    if ((paramObject instanceof Friends))
    {
      paramObject = (Friends)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("Hyim", 2, "onItemClick:" + paramObject.name + paramObject.uin + "--[" + paramObject.detalStatusFlag + "] [" + paramObject.iTermType + "] [" + paramObject.getLastLoginType() + "] [" + paramObject.showLoginClient + "]");
      }
      paramObject = new ProfileActivity.AllInOne(paramObject.uin, 1);
      paramObject.bJa = 59;
      paramObject.bJc = 2;
      ProfileActivity.b(this.mActivity, paramObject);
      return true;
    }
    return false;
  }
  
  private void wD(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "<<--doRefreshBuddyList, load=" + paramBoolean + ", mIsTabSelected=" + this.mk + ",needTabRefresh =" + this.bpN);
    }
    if (!this.mk)
    {
      if (QLog.isColorLevel()) {
        QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "<<--doRefreshBuddyList, return mIsTabSelected =" + this.mk);
      }
      this.bpN = true;
    }
    while (this.jdField_a_of_type_Yyy == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Yyy.ie();
      return;
    }
    this.jdField_a_of_type_Yyy.notifyDataSetChanged();
  }
  
  public void Av(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "doOnResume. tabChange:" + paramBoolean + ",mListView=" + this.c + ", mAdapter=" + this.jdField_a_of_type_Yyy + ", needTabRefresh=" + this.bpN);
    }
    if (this.c == null) {
      return;
    }
    if (this.jdField_a_of_type_Yyy == null)
    {
      this.jdField_a_of_type_Yyy = new yyy(getActivity(), this.mApp, this.c, this.jdField_b_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar, this);
      cmZ();
      this.jdField_a_of_type_Yyy.setFooterView(this.mFooterView);
      this.c.setAdapter(this.jdField_a_of_type_Yyy);
    }
    if (this.bpN)
    {
      aa(300L, true);
      this.bpN = false;
    }
    ((FriendListHandler)this.mApp.getBusinessHandler(1)).e(this.mApp.getCurrentAccountUin(), (byte)1);
    if (!this.jdField_b_of_type_MqqOsMqqHandler.hasMessages(5))
    {
      int i = ajol.Gw();
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(5, i * 1000);
    }
    ((acff)this.mApp.getManager(51)).aL(true);
    anot.a(null, "dc00898", "", "", "0X800A1F7", "0X800A1F7", 0, 0, "", "", "", "");
  }
  
  public void Aw(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "doOnPause.");
    }
  }
  
  public void Bf(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.aZQ = "";
    }
    IndexBarTipsLayout localIndexBarTipsLayout;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBarTipsLayout != null)
    {
      localIndexBarTipsLayout = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBarTipsLayout;
      if (!paramBoolean) {
        break label34;
      }
    }
    label34:
    for (int i = 0;; i = 4)
    {
      localIndexBarTipsLayout.setVisibility(i);
      return;
    }
  }
  
  public void T(boolean paramBoolean, int paramInt) {}
  
  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "getView ");
    }
    if (this.mRootView == null)
    {
      this.mRootView = paramLayoutInflater.inflate(2131559058, null, false);
      this.c = ((PinnedDividerListView)this.mRootView.findViewById(2131362694));
      this.c.mForContacts = true;
      this.jdField_b_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar = ((IndexBar)this.mRootView.findViewById(2131369142));
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBarTipsLayout = ((IndexBarTipsLayout)this.mRootView.findViewById(2131369143));
      this.jdField_b_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar.setOnIndexBarTouchListener(this);
    }
    for (;;)
    {
      return this.mRootView;
      paramLayoutInflater = this.mRootView.getParent();
      if ((paramLayoutInflater instanceof ViewGroup)) {
        ((ViewGroup)paramLayoutInflater).removeView(this.mRootView);
      }
    }
  }
  
  public void b(String paramString, int paramInt, float paramFloat)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsBaseFragment$b != null) && (paramInt == 0)) {
      this.jdField_b_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsBaseFragment$b.ckJ();
    }
    anot.a(null, "dc00898", "", "", "0X800A1F8", "0X800A1F8", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBarTipsLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBarTipsLayout.setText(paramString, paramFloat);
    }
    if (!this.aZQ.equals(paramString))
    {
      this.aZQ = paramString;
      if (!"★".equals(paramString)) {
        break label126;
      }
      this.c.setSelection(0);
    }
    for (;;)
    {
      if (this.jdField_do != null)
      {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_do);
        ThreadManager.getSubThreadHandler().post(this.jdField_do);
      }
      return;
      label126:
      paramInt = this.jdField_a_of_type_Yyy.m(paramString);
      if (paramInt != -1) {
        this.c.setSelection(paramInt + this.c.getHeaderViewsCount());
      }
    }
  }
  
  public void bMf() {}
  
  public void bpM()
  {
    this.mApp.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$b);
    this.mApp.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$a);
    this.mApp.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$c);
    amhj localamhj = (amhj)this.mApp.getManager(15);
    if (localamhj != null) {
      localamhj.addListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$d);
    }
    ((PhoneContactManagerImp)this.mApp.getManager(11)).a(this);
  }
  
  public void bpN()
  {
    this.mApp.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$b);
    this.mApp.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$a);
    this.mApp.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$c);
    amhj localamhj = (amhj)this.mApp.getManager(15);
    if (localamhj != null) {
      localamhj.removeListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendFragment$d);
    }
    ((PhoneContactManagerImp)this.mApp.getManager(11)).b(this);
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "doOnDestroy.");
    }
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    bpN();
    if (this.jdField_a_of_type_Yyy != null) {
      this.jdField_a_of_type_Yyy.destroy();
    }
  }
  
  public View e()
  {
    return this.c;
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
    paramView.getId();
    if (aqft.equalsWithNullCheck("tag_swip_icon_menu_item", paramView.getTag())) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      yzr.b localb = (yzr.b)paramView.getTag();
      if ((localb != null) && (localb.item != null)) {
        v(localb.item);
      }
    }
  }
  
  public void refresh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "refresh");
    }
    if (this.aUD) {
      ((FriendListHandler)this.mApp.getBusinessHandler(1)).by(true, true);
    }
    this.aUE = true;
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "updateBuddyList succeeded");
    }
  }
  
  public void resetData()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "resetData");
    }
    if (this.jdField_b_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar.setLetters(null);
    }
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Yyy != null)
    {
      this.jdField_a_of_type_Yyy.clear();
      this.jdField_a_of_type_Yyy.cmX();
      this.jdField_a_of_type_Yyy.destroy();
      if (this.c != null)
      {
        this.jdField_a_of_type_Yyy = new yyy(getActivity(), this.mApp, this.c, this.jdField_b_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar, this);
        cmZ();
        this.jdField_a_of_type_Yyy.setFooterView(this.mFooterView);
        this.c.setAdapter(this.jdField_a_of_type_Yyy);
      }
    }
  }
  
  public void sc(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "onBindStateChanged bindState=" + paramInt);
    }
  }
  
  public void sd(int paramInt) {}
  
  public void se(int paramInt) {}
  
  class a
    extends accn
  {
    private a() {}
    
    public void onCardDownload(boolean paramBoolean, Object paramObject)
    {
      if ((paramBoolean) && (AlphabetFriendFragment.b(AlphabetFriendFragment.this))) {
        AlphabetFriendFragment.a(AlphabetFriendFragment.this, 1400L, true);
      }
    }
    
    public void onGetCalReactiveDays(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("interactive", 2, " contacts onGetCalReactiveDays isAllow= " + paramBoolean2);
        }
        AlphabetFriendFragment.a(AlphabetFriendFragment.this, 1400L, false);
      }
    }
  }
  
  class b
    extends acfd
  {
    private b() {}
    
    public void onAddGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
    {
      if ((paramBoolean) && (AlphabetFriendFragment.b(AlphabetFriendFragment.this))) {
        AlphabetFriendFragment.a(AlphabetFriendFragment.this, 1400L, true);
      }
    }
    
    public void onDeleteGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
    {
      if ((paramBoolean) && (AlphabetFriendFragment.b(AlphabetFriendFragment.this))) {
        AlphabetFriendFragment.a(AlphabetFriendFragment.this, 1400L, true);
      }
    }
    
    public void onGroupDataInited()
    {
      AlphabetFriendFragment.a(AlphabetFriendFragment.this, 1400L, true);
    }
    
    public void onRenameGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
    {
      if ((paramBoolean) && (AlphabetFriendFragment.b(AlphabetFriendFragment.this))) {
        AlphabetFriendFragment.a(AlphabetFriendFragment.this, 1400L, true);
      }
    }
    
    public void onResortGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
    {
      if ((paramBoolean) && (AlphabetFriendFragment.b(AlphabetFriendFragment.this))) {
        AlphabetFriendFragment.a(AlphabetFriendFragment.this, 1400L, true);
      }
    }
    
    public void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
    {
      if ((paramBoolean) && (AlphabetFriendFragment.b(AlphabetFriendFragment.this))) {
        AlphabetFriendFragment.a(AlphabetFriendFragment.this, 1400L, true);
      }
    }
    
    public void onSetSpecialCareSwitch_global(boolean paramBoolean, Object[] paramArrayOfObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "onSetSpecialCareSwitch_global isSuccess: " + paramBoolean);
      }
      if ((AlphabetFriendFragment.this.mk) && (AlphabetFriendFragment.a(AlphabetFriendFragment.this) != null)) {
        AlphabetFriendFragment.a(AlphabetFriendFragment.this).ie();
      }
      if ((paramBoolean) && (AlphabetFriendFragment.this.isResumed())) {
        try
        {
          String[] arrayOfString = (String[])paramArrayOfObject[1];
          paramArrayOfObject = (boolean[])paramArrayOfObject[2];
          if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.AlphabetFriendFragment", 2, new Object[] { "onSetSpecialCareSwitch_global uinArray=%s stateArray=%s", Arrays.toString(arrayOfString), Arrays.toString(paramArrayOfObject) });
          }
          if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0))
          {
            if (paramArrayOfObject[0] != 0)
            {
              QQToast.a(AlphabetFriendFragment.this.getActivity(), 2, acfp.m(2131702375), 0).show();
              return;
            }
            QQToast.a(AlphabetFriendFragment.this.getActivity(), 2, acfp.m(2131702376), 0).show();
            return;
          }
        }
        catch (Exception paramArrayOfObject)
        {
          if (QLog.isColorLevel()) {
            QLog.e("contacts.fragment.AlphabetFriendFragment", 2, "onSetSpecialCareSwitch_global fail!", paramArrayOfObject);
          }
        }
      }
    }
    
    public void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "onUpdateAddFriend isSucess= " + paramBoolean1 + ",addSuccess=" + paramBoolean2 + " addDirect=" + paramBoolean3);
      }
      if ((paramBoolean1) && (paramBoolean2) && (paramBoolean3)) {
        AlphabetFriendFragment.a(AlphabetFriendFragment.this, 1400L, true);
      }
    }
    
    public void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt)
    {
      if ((paramBoolean) && (AlphabetFriendFragment.b(AlphabetFriendFragment.this))) {
        AlphabetFriendFragment.a(AlphabetFriendFragment.this, 1400L, true);
      }
    }
    
    public void onUpdateCustomHead(boolean paramBoolean, String paramString)
    {
      if (paramBoolean) {
        AlphabetFriendFragment.a(AlphabetFriendFragment.this, 5000L, false);
      }
    }
    
    public void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "onUpdateDelFriend isSucess= " + paramBoolean);
      }
      if (paramBoolean) {
        AlphabetFriendFragment.a(AlphabetFriendFragment.this, 1400L, true);
      }
    }
    
    public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
    {
      if ((paramBoolean) && (AlphabetFriendFragment.b(AlphabetFriendFragment.this))) {
        AlphabetFriendFragment.a(AlphabetFriendFragment.this, 1400L, true);
      }
    }
    
    public void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
    {
      AlphabetFriendFragment localAlphabetFriendFragment = AlphabetFriendFragment.this;
      boolean bool;
      if ((paramBoolean2) || (!paramBoolean1))
      {
        bool = true;
        AlphabetFriendFragment.a(localAlphabetFriendFragment, bool);
        if (QLog.isColorLevel()) {
          QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "onUpdateFriendList isSucess= " + paramBoolean1 + ",isComplete=" + paramBoolean2);
        }
        paramBoolean2 = AlphabetFriendFragment.a(AlphabetFriendFragment.this);
        if (AlphabetFriendFragment.a(AlphabetFriendFragment.this))
        {
          if (AlphabetFriendFragment.b(AlphabetFriendFragment.this))
          {
            AlphabetFriendFragment.b(AlphabetFriendFragment.this, false);
            if (AlphabetFriendFragment.a(AlphabetFriendFragment.this) != null) {
              AlphabetFriendFragment.b(AlphabetFriendFragment.this).d(AlphabetFriendFragment.this.xZ(), paramBoolean1, null);
            }
          }
          localAlphabetFriendFragment = AlphabetFriendFragment.this;
          if (!AlphabetFriendFragment.b(AlphabetFriendFragment.this)) {
            break label189;
          }
        }
      }
      label189:
      for (long l = 0L;; l = 1400L)
      {
        AlphabetFriendFragment.a(localAlphabetFriendFragment, l, true);
        if ((!paramBoolean2) && (AlphabetFriendFragment.b(AlphabetFriendFragment.this))) {
          AlphabetFriendFragment.a(AlphabetFriendFragment.this, 1400L, true);
        }
        return;
        bool = false;
        break;
      }
    }
    
    public void onUpdateGatherFriendList(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      if ((paramBoolean1) && (paramBoolean2) && (paramBoolean3)) {
        AlphabetFriendFragment.a(AlphabetFriendFragment.this, 0L, true);
      }
    }
    
    public void onUpdateHotFriendLevel(boolean paramBoolean, ArrayList<String> paramArrayList)
    {
      AlphabetFriendFragment.a(AlphabetFriendFragment.this, 1400L, false);
    }
    
    public void onUpdateLastLoginInfo(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean1) {
        AlphabetFriendFragment.a(AlphabetFriendFragment.this, 1400L, false);
      }
    }
    
    public void onUpdateMoveGroup(String paramString, byte paramByte1, byte paramByte2)
    {
      if ((paramString != null) && (AlphabetFriendFragment.b(AlphabetFriendFragment.this))) {
        AlphabetFriendFragment.a(AlphabetFriendFragment.this, 1400L, true);
      }
    }
    
    public void onUpdateOlympicTorchList(boolean paramBoolean)
    {
      if (paramBoolean) {
        AlphabetFriendFragment.a(AlphabetFriendFragment.this, 1400L, false);
      }
    }
    
    public void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
    {
      if ((paramBoolean) && (AlphabetFriendFragment.b(AlphabetFriendFragment.this))) {
        AlphabetFriendFragment.a(AlphabetFriendFragment.this, 1400L, true);
      }
    }
    
    public void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString)
    {
      if ((paramBoolean) && (AlphabetFriendFragment.b(AlphabetFriendFragment.this))) {
        AlphabetFriendFragment.a(AlphabetFriendFragment.this, 1400L, false);
      }
    }
    
    public void onUpdateSpecialCareList(boolean paramBoolean1, boolean paramBoolean2, List<SpecialCareInfo> paramList)
    {
      if (QLog.isColorLevel()) {
        QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "onUpdateSpecialCareList isSucess= " + paramBoolean1 + ",isComplete=" + paramBoolean2);
      }
      if ((AlphabetFriendFragment.this.mk) && (paramBoolean1) && (AlphabetFriendFragment.a(AlphabetFriendFragment.this) != null))
      {
        AlphabetFriendFragment.a(AlphabetFriendFragment.this).ie();
        AlphabetFriendFragment.a(AlphabetFriendFragment.this, 0L, true);
      }
    }
  }
  
  class c
    extends achq
  {
    private c() {}
    
    public void cna()
    {
      if (AlphabetFriendFragment.b(AlphabetFriendFragment.this)) {
        AlphabetFriendFragment.a(AlphabetFriendFragment.this, 1400L, true);
      }
    }
  }
  
  class d
    implements amfh
  {
    private d() {}
    
    public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
    {
      if ((AlphabetFriendFragment.b(AlphabetFriendFragment.this)) && (paramBitmap != null) && (paramInt2 == 200)) {
        AlphabetFriendFragment.a(AlphabetFriendFragment.this, 1400L, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendFragment
 * JD-Core Version:    0.7.0.1
 */