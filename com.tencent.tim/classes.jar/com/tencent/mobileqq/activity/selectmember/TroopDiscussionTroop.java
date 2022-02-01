package com.tencent.mobileqq.activity.selectmember;

import aaym;
import aaym.a;
import aayp;
import acbo;
import acfd;
import achq;
import acnd;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import anot;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;
import java.util.ArrayList;
import java.util.Map;
import mqq.os.MqqHandler;
import wja;

public class TroopDiscussionTroop
  extends TroopDiscussionBaseV
  implements View.OnClickListener, AbsListView.e
{
  TextView GT = null;
  private a jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$a;
  private b jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$b;
  private c jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$c;
  private aaym jdField_b_of_type_Aaym;
  private acbo jdField_b_of_type_Acbo = new aayp(this);
  private SwipPinnedHeaderExpandableListView jdField_b_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView;
  int bMG = getResources().getDimensionPixelSize(2131299688);
  
  public TroopDiscussionTroop(SelectMemberActivity paramSelectMemberActivity)
  {
    super(paramSelectMemberActivity);
  }
  
  private void bpM()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$a == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$a = new a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$c == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$c = new c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$b == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$b = new b();
    }
    this.e.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$a);
    this.e.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$c);
    this.e.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$b);
    this.e.addObserver(this.jdField_b_of_type_Acbo);
  }
  
  private void bpN()
  {
    this.e.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$a);
    this.e.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$c);
    this.e.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionTroop$b);
    this.e.removeObserver(this.jdField_b_of_type_Acbo);
  }
  
  void bOm()
  {
    if (this.jdField_b_of_type_Aaym != null) {
      this.jdField_b_of_type_Aaym.notifyDataSetChanged();
    }
  }
  
  public void be(Bundle paramBundle)
  {
    bpM();
    this.jdField_b_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.postDelayed(new TroopDiscussionTroop.1(this), 200L);
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = (aaym.a)paramView.getTag();
    Object localObject2;
    if ((localObject1 != null) && (((aaym.a)localObject1).g != null))
    {
      localObject2 = ((aaym.a)localObject1).g;
      if (((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity instanceof SelectMemberActivity)) && (!((TroopInfo)localObject2).isAllowCreateDiscuss()) && (!((TroopInfo)localObject2).isTroopOwner(this.e.getCurrentAccountUin())) && (!((TroopInfo)localObject2).isTroopAdmin(this.e.getCurrentAccountUin()))) {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.aRJ)) {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, 0, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131699835), 0).show(getResources().getDimensionPixelSize(2131299627));
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, 0, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131699837), 0).show(getResources().getDimensionPixelSize(2131299627));
      continue;
      Bundle localBundle = new Bundle();
      localBundle.putString("group_uin", ((TroopInfo)localObject2).troopuin);
      localBundle.putString("group_name", ((TroopInfo)localObject2).getTroopName());
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.k(6, localBundle);
      int i;
      switch (((aaym.a)localObject1).itemType)
      {
      case 2: 
      case 4: 
      case 6: 
      default: 
        i = 0;
      }
      for (;;)
      {
        anot.a(this.e, "P_CliOper", "Grp_contacts", "", "choose_grp", "create_discuss", 0, 0, ((TroopInfo)localObject2).troopuin + "", String.valueOf(i), "", "");
        break;
        i = 0;
        continue;
        i = 1;
        continue;
        i = 2;
        continue;
        i = 3;
      }
      if ((localObject1 != null) && (((aaym.a)localObject1).c != null))
      {
        localObject1 = ((aaym.a)localObject1).c;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("group_uin", ((DiscussionInfo)localObject1).uin);
        ((Bundle)localObject2).putString("group_name", ((DiscussionInfo)localObject1).discussionName);
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.k(7, (Bundle)localObject2);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    setContentView(2131560612);
    this.jdField_b_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView = ((SwipPinnedHeaderExpandableListView)findViewById(2131382384));
    this.GT = ((TextView)findViewById(2131380396));
    this.jdField_b_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setSelector(2131167595);
    this.jdField_b_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
    this.jdField_b_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setGroupIndicator(null);
    this.jdField_b_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setDivider(null);
    this.jdField_b_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setPadding(0, 0, 0, wja.dp2px(54.0F, getResources()));
    this.jdField_b_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setChildDivider(null);
    this.jdField_b_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setClipToPadding(false);
    this.jdField_b_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setScrollBarStyle(33554432);
    this.jdField_b_of_type_Aaym = new aaym(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.e, this.jdField_b_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView, this);
    this.jdField_b_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setAdapter(this.jdField_b_of_type_Aaym);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("TroopDiscussionTroop", 2, "doOnDestroy");
    }
    if (this.jdField_b_of_type_Aaym != null) {
      this.jdField_b_of_type_Aaym.destroy();
    }
    bpN();
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public class a
    extends acfd
  {
    protected a() {}
    
    public void onGetGenralSettings(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean1) {
        TroopDiscussionTroop.this.bOm();
      }
    }
    
    public void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap)
    {
      TroopDiscussionTroop.this.bOm();
    }
    
    public void onUpdateTroopHead(boolean paramBoolean, String paramString)
    {
      if (paramBoolean) {
        TroopDiscussionTroop.this.bOm();
      }
    }
  }
  
  public class b
    extends achq
  {
    protected b() {}
    
    public void aoF()
    {
      TroopDiscussionTroop.this.bOm();
    }
  }
  
  public class c
    extends acnd
  {
    protected c() {}
    
    public void H(boolean paramBoolean, String paramString)
    {
      if (paramBoolean) {
        TroopDiscussionTroop.this.bOm();
      }
    }
    
    public void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
    {
      if (paramBoolean) {
        TroopDiscussionTroop.this.bOm();
      }
    }
    
    public void d(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList)
    {
      if (paramBoolean) {
        TroopDiscussionTroop.this.bOm();
      }
    }
    
    public void di(String paramString1, String paramString2)
    {
      if (TroopDiscussionTroop.a(TroopDiscussionTroop.this) != null) {
        TroopDiscussionTroop.a(TroopDiscussionTroop.this).cnv();
      }
    }
    
    public void jc(boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopDiscussionTroop", 2, "onUpdateTroopList " + paramBoolean);
      }
      if (paramBoolean) {
        ThreadManager.getUIHandler().postDelayed(new TroopDiscussionTroop.MyTroopObserver.1(this), 500L);
      }
    }
    
    public void q(int paramInt1, int paramInt2, String paramString)
    {
      if (paramInt1 == 6) {
        if (paramInt2 == 0) {
          TroopDiscussionTroop.this.bOm();
        }
      }
      do
      {
        do
        {
          return;
          if (paramInt1 != 2) {
            break;
          }
        } while (paramInt2 != 0);
        TroopDiscussionTroop.this.bOm();
        return;
      } while ((paramInt1 != 9) || (paramInt2 != 0));
      TroopDiscussionTroop.this.bOm();
    }
    
    public void xj(boolean paramBoolean)
    {
      if (paramBoolean) {
        TroopDiscussionTroop.this.bOm();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopDiscussionTroop
 * JD-Core Version:    0.7.0.1
 */