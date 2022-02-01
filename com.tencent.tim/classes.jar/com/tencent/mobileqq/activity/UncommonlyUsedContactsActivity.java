package com.tencent.mobileqq.activity;

import abeg;
import abeg.a;
import accn;
import acdb;
import acfd;
import acff;
import acfp;
import akwl;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqha;
import aqju;
import arie;
import ausj;
import auss;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import wfa;
import wfb;
import wfc;
import wfd;
import wfe;
import wff;

public class UncommonlyUsedContactsActivity
  extends BaseActivity
  implements View.OnClickListener, AbsListView.e
{
  private TextView Bi;
  TextView GT = null;
  akwl a;
  public a a;
  int bMG;
  acfd c = new wfd(this);
  accn cardObserver = new wfc(this);
  InputMethodManager d = null;
  private SlideDetectListView e;
  private TextView mRightBtn;
  RelativeLayout mRootView;
  private TextView mTitle;
  View mTitleBar;
  public ArrayList<c> pU = new ArrayList();
  
  public UncommonlyUsedContactsActivity()
  {
    this.jdField_a_of_type_Akwl = new wfb(this);
  }
  
  private void BR(int paramInt)
  {
    if (paramInt == 0) {
      this.GT.setVisibility(4);
    }
    do
    {
      return;
      paramInt -= 1;
      this.GT.setVisibility(0);
      if ((paramInt == 0) && (this.e.getChildAt(0) != null) && (this.e.getChildAt(0).getBottom() == this.bMG))
      {
        this.GT.setVisibility(4);
        return;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$a.getItem(paramInt);
    } while (!(localObject1 instanceof c));
    Object localObject1 = ((c)localObject1).groupName;
    Object localObject2;
    if (paramInt + 1 < this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$a.getCount())
    {
      if (((c)this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$a.getItem(paramInt + 1)).itemType != 0) {
        break label217;
      }
      localObject2 = this.e.getChildAt(0);
      if (localObject2 != null)
      {
        paramInt = ((View)localObject2).getBottom();
        localObject2 = (RelativeLayout.LayoutParams)this.GT.getLayoutParams();
        if (paramInt >= this.bMG) {
          break label209;
        }
        ((RelativeLayout.LayoutParams)localObject2).topMargin = (paramInt - this.bMG);
        this.GT.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.GT.requestLayout();
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label258;
      }
      this.GT.setVisibility(0);
      this.GT.setText((CharSequence)localObject1);
      return;
      label209:
      ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
      break;
      label217:
      localObject2 = (RelativeLayout.LayoutParams)this.GT.getLayoutParams();
      if (((RelativeLayout.LayoutParams)localObject2).topMargin != 0)
      {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
        this.GT.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.GT.requestLayout();
      }
    }
    label258:
    this.GT.setVisibility(4);
  }
  
  private void aC()
  {
    this.mTitleBar = findViewById(2131379791);
    this.mTitle = ((TextView)findViewById(2131369627));
    this.mTitle.setText(getString(2131701248));
    this.Bi = ((TextView)findViewById(2131369579));
    this.mRightBtn = ((TextView)findViewById(2131369612));
    this.Bi.setOnClickListener(this);
    this.mRightBtn.setVisibility(0);
    this.mRightBtn.setText(2131719875);
    if (AppSetting.enableTalkBack)
    {
      this.mTitle.setContentDescription(getString(2131701248));
      this.mRightBtn.setContentDescription(getString(2131719875) + acfp.m(2131716223));
      this.Bi.setContentDescription(getString(2131691039) + acfp.m(2131716218));
    }
    this.mRightBtn.setOnClickListener(this);
  }
  
  @TargetApi(14)
  private void bXB()
  {
    super.setContentView(2131561285);
    getWindow().setBackgroundDrawable(null);
    ie();
    aC();
    this.mRootView = ((RelativeLayout)findViewById(2131377546));
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      this.mRootView.setFitsSystemWindows(true);
      this.mRootView.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.bMG = getResources().getDimensionPixelSize(2131299688);
    this.GT = ((TextView)findViewById(2131380396));
    this.e = ((SlideDetectListView)findViewById(2131382384));
    LayoutInflater.from(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$a = new a(this, this.app, this.e, 1, true);
    this.e.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$a);
    this.e.setOnScrollGroupFloatingListener(this);
  }
  
  private void ie()
  {
    Object localObject4 = (acff)this.app.getManager(51);
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1;
    ArrayList localArrayList2;
    if (localObject4 != null)
    {
      ConcurrentHashMap localConcurrentHashMap = ((acff)localObject4).p();
      localObject1 = localConcurrentHashMap.keySet();
      if ((localObject1 != null) && (((Set)localObject1).size() > 0))
      {
        Iterator localIterator = ((Set)localObject1).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localArrayList2 = (ArrayList)localConcurrentHashMap.get((String)localIterator.next());
          localObject1 = "";
        } while ((localArrayList2 == null) || (localArrayList2.size() <= 0));
      }
    }
    label507:
    for (;;)
    {
      try
      {
        Collections.sort(localArrayList2, acdb.K);
        i = 0;
        if (i >= localArrayList2.size()) {
          break;
        }
        localFriends = (Friends)localArrayList2.get(i);
        Object localObject2 = localObject1;
        if (i == 0)
        {
          Object localObject5 = ((acff)localObject4).co();
          localObject2 = localObject1;
          if (localObject5 != null)
          {
            localObject2 = localObject1;
            if (((List)localObject5).size() > 0)
            {
              localObject5 = ((List)localObject5).iterator();
              localObject2 = localObject1;
              if (((Iterator)localObject5).hasNext())
              {
                localObject2 = (Groups)((Iterator)localObject5).next();
                if (((Groups)localObject2).group_id != localFriends.groupid) {
                  break label507;
                }
                localObject1 = ((Groups)localObject2).group_name + "(" + localArrayList2.size() + ")";
                continue;
              }
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Friends localFriends;
        QLog.d("qqBaseActivity", 1, "", localThrowable);
        continue;
        localObject1 = new c(0, null);
        ((c)localObject1).setGroupName(localThrowable);
        localArrayList1.add(localObject1);
        localObject1 = new c(1, localFriends);
        ((c)localObject1).setGroupName(localThrowable);
        localArrayList1.add(localObject1);
        i += 1;
        localObject1 = localThrowable;
        continue;
      }
      localObject1 = (PhoneContactManagerImp)this.app.getManager(11);
      int i = ((PhoneContactManagerImp)localObject1).xy();
      if ((((PhoneContactManagerImp)localObject1).Ur()) || (i == 8))
      {
        Object localObject3 = ((PhoneContactManagerImp)localObject1).o(true);
        if (((List)localObject3).size() > 0)
        {
          localObject1 = getString(2131696819) + "(" + ((List)localObject3).size() + ")";
          localObject4 = new c(0, null);
          ((c)localObject4).setGroupName((String)localObject1);
          localArrayList1.add(localObject4);
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = new c(1, (PhoneContact)((Iterator)localObject3).next());
            ((c)localObject4).setGroupName((String)localObject1);
            localArrayList1.add(localObject4);
          }
        }
      }
      this.pU = localArrayList1;
      return;
    }
  }
  
  void a(c paramc)
  {
    if (paramc.b == null) {
      return;
    }
    ausj localausj = (ausj)auss.a(this, null);
    localausj.addButton(getString(2131719495), 0);
    localausj.addButton(getString(2131701238), 0);
    if ((paramc.b instanceof Friends))
    {
      localausj.addButton(getString(2131701243), 0);
      localausj.addButton(getString(2131701230), 3);
    }
    for (;;)
    {
      localausj.a(new wfa(this, paramc, localausj));
      localausj.addCancelButton(2131721058);
      localausj.show();
      return;
      if (!(paramc.b instanceof PhoneContact)) {
        break;
      }
      localausj.addButton(getString(2131701244), 0);
    }
  }
  
  public void cf(int paramInt1, int paramInt2)
  {
    new arie(getActivity()).V(paramInt1, this.mTitleBar.getHeight(), 0, paramInt2);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      return;
    } while (paramIntent == null);
    paramIntent = new ProfileActivity.AllInOne(paramIntent.getStringExtra("contactSearchResultUin"), 1);
    paramIntent.bJa = 60;
    ProfileActivity.b(getActivity(), paramIntent);
    anot.a(this.app, "CliOper", "", "", "0X8004C58", "0X8004C58", 3, 0, "", "", "", "");
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    bXB();
    addObserver(this.c);
    addObserver(this.cardObserver);
    this.app.registObserver(this.jdField_a_of_type_Akwl);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.c);
    removeObserver(this.cardObserver);
    this.app.unRegistObserver(this.jdField_a_of_type_Akwl);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$a.destroy();
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    getWindow().setSoftInputMode(16);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130772000, 2130772001);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      localObject = (b)paramView.getTag();
    }
    try
    {
      localObject = (c)this.pU.get(((b)localObject).pos);
      if (localObject == null) {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          startActivity(new Intent(this, SettingUncommUsedContactsActivity.class));
          anot.a(this.app, "CliOper", "", "", "0X8004C55", "0X8004C55", 0, 0, "", "", "", "");
          continue;
          finish();
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        c localc = null;
        continue;
        a(localc);
        anot.a(this.app, "CliOper", "", "", "0X8004C50", "0X8004C50", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$a != null) {
      BR(paramInt1);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void vT(String paramString)
  {
    aqha.a(getActivity(), 230).setTitle(getString(2131692515)).setMessage(getString(2131690835)).setPositiveButton(2131693962, new wff(this, paramString)).setNegativeButton(2131691040, new wfe(this)).show();
  }
  
  public class a
    extends abeg
  {
    public a(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean)
    {
      super(paramQQAppInterface, paramXListView, paramInt, paramBoolean);
    }
    
    public int getCount()
    {
      return UncommonlyUsedContactsActivity.this.pU.size();
    }
    
    public Object getItem(int paramInt)
    {
      if ((UncommonlyUsedContactsActivity.this.pU != null) && (paramInt >= 0) && (paramInt < UncommonlyUsedContactsActivity.this.pU.size())) {
        return UncommonlyUsedContactsActivity.this.pU.get(paramInt);
      }
      return null;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject1 = (UncommonlyUsedContactsActivity.c)getItem(paramInt);
      UncommonlyUsedContactsActivity.b localb;
      View localView;
      if ((paramView != null) && (paramView.getTag() != null))
      {
        localb = (UncommonlyUsedContactsActivity.b)paramView.getTag();
        localView = paramView;
      }
      Object localObject2;
      for (;;)
      {
        paramView = (TextView)localView.findViewById(2131378049);
        localObject2 = localView.findViewById(2131377096);
        if (((UncommonlyUsedContactsActivity.c)localObject1).itemType != 0) {
          break;
        }
        ((View)localObject2).setVisibility(8);
        paramView.setVisibility(0);
        paramView.setText(((UncommonlyUsedContactsActivity.c)localObject1).groupName);
        if (AppSetting.enableTalkBack)
        {
          paramView.setFocusable(true);
          paramView.setContentDescription(((UncommonlyUsedContactsActivity.c)localObject1).groupName);
        }
        localb.itemType = 0;
        localb.uin = "";
        localb.pos = paramInt;
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localView = UncommonlyUsedContactsActivity.this.getLayoutInflater().inflate(2131561280, null);
        localb = new UncommonlyUsedContactsActivity.b(UncommonlyUsedContactsActivity.this, null);
        localb.pQ = ((ImageView)localView.findViewById(2131368698));
        localb.nameTv = ((TextView)localView.findViewById(16908308));
        localb.GU = ((TextView)localView.findViewById(2131368128));
        localb.GV = ((TextView)localView.findViewById(2131367941));
        localb.GW = ((TextView)localView.findViewById(2131377882));
        localb.rz = ((ImageView)localView.findViewById(2131364587));
        localb.rz.setVisibility(8);
        localView.setTag(localb);
      }
      ((View)localObject2).setVisibility(0);
      paramView.setVisibility(8);
      label373:
      int i;
      if ((((UncommonlyUsedContactsActivity.c)localObject1).b instanceof Friends))
      {
        localObject1 = (Friends)((UncommonlyUsedContactsActivity.c)localObject1).b;
        localb.uin = ((Friends)localObject1).uin;
        label513:
        label540:
        if (!TextUtils.isEmpty(((Friends)localObject1).remark))
        {
          localb.nameTv.setText(((Friends)localObject1).remark);
          localb.GU.setText(null);
          if (AppSetting.enableTalkBack) {
            localb.nameTv.setContentDescription(((Friends)localObject1).remark);
          }
          if (TextUtils.equals(acfp.m(2131716216), ((Friends)localObject1).recommReason)) {
            ((Friends)localObject1).recommReason = acfp.m(2131716220);
          }
          localb.GW.setText(((Friends)localObject1).recommReason);
          if (((Friends)localObject1).age == 0) {
            break label846;
          }
          localb.GV.setText(String.valueOf(((Friends)localObject1).age));
          label436:
          switch (((Friends)localObject1).gender)
          {
          default: 
            localb.GV.setBackgroundResource(2130846773);
            i = 0;
            label477:
            localb.GV.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
            if ((((Friends)localObject1).age == 0) && (i == 0))
            {
              localb.GV.setVisibility(8);
              if (AppSetting.enableTalkBack)
              {
                localObject2 = localb.GV;
                if (i != 0) {
                  break label904;
                }
                paramView = String.valueOf(((Friends)localObject1).age);
                ((TextView)localObject2).setContentDescription(paramView);
                localb.GW.setContentDescription(((Friends)localObject1).recommReason);
              }
              localb.pQ.setImageBitmap(a(1, ((Friends)localObject1).uin));
            }
            break;
          }
        }
      }
      for (;;)
      {
        localb.pos = paramInt;
        localb.itemType = 1;
        localView.setOnClickListener(UncommonlyUsedContactsActivity.this);
        break;
        if (!TextUtils.isEmpty(((Friends)localObject1).smartRemark))
        {
          if (!TextUtils.isEmpty(((Friends)localObject1).name))
          {
            localb.nameTv.setText(((Friends)localObject1).name);
            label636:
            localb.GU.setText("(" + ((Friends)localObject1).smartRemark + ")");
            if (!AppSetting.enableTalkBack) {
              break label373;
            }
            localObject2 = localb.nameTv;
            if (!TextUtils.isEmpty(((Friends)localObject1).name)) {
              break label740;
            }
          }
          label740:
          for (paramView = ((Friends)localObject1).uin;; paramView = ((Friends)localObject1).name)
          {
            ((TextView)localObject2).setContentDescription(paramView);
            localb.GU.setContentDescription(((Friends)localObject1).smartRemark);
            break;
            localb.nameTv.setText(((Friends)localObject1).uin);
            break label636;
          }
        }
        if (!TextUtils.isEmpty(((Friends)localObject1).name))
        {
          localb.nameTv.setText(((Friends)localObject1).name);
          label773:
          localb.GU.setText(null);
          if (!AppSetting.enableTalkBack) {
            break label373;
          }
          localObject2 = localb.nameTv;
          if (!TextUtils.isEmpty(((Friends)localObject1).name)) {
            break label837;
          }
        }
        label837:
        for (paramView = ((Friends)localObject1).uin;; paramView = ((Friends)localObject1).name)
        {
          ((TextView)localObject2).setContentDescription(paramView);
          break;
          localb.nameTv.setText(((Friends)localObject1).uin);
          break label773;
        }
        label846:
        localb.GV.setText(null);
        break label436;
        i = 2130841206;
        localb.GV.setBackgroundResource(2130846773);
        break label477;
        i = 2130841201;
        localb.GV.setBackgroundResource(2130846771);
        break label477;
        localb.GV.setVisibility(0);
        break label513;
        label904:
        if (((Friends)localObject1).gender == 1)
        {
          paramView = acfp.m(2131716217) + ((Friends)localObject1).age;
          break label540;
        }
        paramView = acfp.m(2131716222) + ((Friends)localObject1).age;
        break label540;
        if ((((UncommonlyUsedContactsActivity.c)localObject1).b instanceof PhoneContact))
        {
          paramView = (PhoneContact)((UncommonlyUsedContactsActivity.c)localObject1).b;
          localb.uin = paramView.mobileCode;
          localb.type = 11;
          localb.nameTv.setText(paramView.name);
          localb.GU.setText(null);
          localb.GW.setText(acfp.m(2131716221));
          if (AppSetting.enableTalkBack)
          {
            localb.nameTv.setContentDescription(paramView.name);
            localb.GW.setContentDescription(acfp.m(2131716219));
          }
          localb.GV.setVisibility(8);
          localb.pQ.setImageBitmap(a(localb.uin, 11, (byte)0));
        }
      }
    }
  }
  
  class b
    extends abeg.a
  {
    TextView GU;
    TextView GV;
    TextView GW;
    int itemType;
    TextView nameTv;
    int pos;
    ImageView rz;
    
    private b() {}
  }
  
  public class c
  {
    public Entity b;
    public String groupName;
    public int itemType;
    
    public c(int paramInt, Entity paramEntity)
    {
      this.itemType = paramInt;
      this.b = paramEntity;
    }
    
    public void setGroupName(String paramString)
    {
      this.groupName = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity
 * JD-Core Version:    0.7.0.1
 */