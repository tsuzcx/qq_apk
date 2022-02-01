package com.tencent.mobileqq.activity;

import acbo;
import accd;
import acfd;
import acfp;
import achq;
import acnd;
import ahgg.a;
import ahgq;
import ahix;
import amsf.a;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqdf;
import aqha;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.ResultRecord.a;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import uyb;
import uyb.a;
import uye;
import uyf;
import uyg;
import uyh;
import uyi;
import uyj;
import uyk;
import uyl;
import wja;

public class ForwardTroopListFragment
  extends PublicBaseFragment
{
  private TextView Dn;
  private TextView Do;
  private TextView Dp;
  private Dialog N;
  private ahgq jdField_a_of_type_Ahgq;
  private aqdf jdField_a_of_type_Aqdf;
  protected a a;
  protected b a;
  protected c a;
  private SelectedAndSearchBar.b jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar$b = new uyj(this);
  private SelectedAndSearchBar jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar;
  protected SwipPinnedHeaderExpandableListView a;
  private FrameLayout aS;
  private acbo jdField_b_of_type_Acbo = new uyh(this);
  protected accd b;
  private amsf.a jdField_b_of_type_Amsf$a = new uyk(this);
  private ContactSearchFragment jdField_b_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment;
  private uyb.a jdField_b_of_type_Uyb$a = new uyi(this);
  public uyb b;
  private Map<String, ResultRecord> hi = new LinkedHashMap();
  private TextView hk;
  private QQAppInterface mApp;
  private Context mContext;
  private InputMethodManager mImm;
  private View mRootView;
  
  public ForwardTroopListFragment()
  {
    this.jdField_b_of_type_Accd = new uyg(this);
  }
  
  private boolean E(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return this.hi.containsKey(R(paramString, paramInt));
  }
  
  private String R(String paramString, int paramInt)
  {
    return paramInt + "_" + paramString;
  }
  
  private boolean a(ResultRecord paramResultRecord)
  {
    if (paramResultRecord == null) {
      return false;
    }
    String str = R(paramResultRecord.uin, paramResultRecord.lk());
    ResultRecord localResultRecord = (ResultRecord)this.hi.get(str);
    if (localResultRecord != null)
    {
      localResultRecord.MO = SystemClock.elapsedRealtime();
      paramResultRecord = new ArrayList(this.hi.values());
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.X(paramResultRecord, false);
      return false;
    }
    if (this.hi.size() == 9)
    {
      bNV();
      return false;
    }
    paramResultRecord = ResultRecord.a(paramResultRecord);
    paramResultRecord.MO = SystemClock.elapsedRealtime();
    this.hi.put(str, paramResultRecord);
    bNR();
    paramResultRecord = new ArrayList(this.hi.values());
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.X(paramResultRecord, true);
    return true;
  }
  
  private void aC()
  {
    this.Dn = ((TextView)this.mRootView.findViewById(2131369612));
    this.hk = ((TextView)this.mRootView.findViewById(2131369581));
    this.Do = ((TextView)this.mRootView.findViewById(2131369579));
    this.Dp = ((TextView)this.mRootView.findViewById(2131369627));
    this.mRootView.findViewById(2131369579).setVisibility(8);
    this.Do.setVisibility(0);
    this.Do.setText("");
    this.Dp.setText(acfp.m(2131706555));
    this.hk.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Dn.getLayoutParams();
    localLayoutParams.height = wja.dp2px(29.0F, getResources());
    if (Build.VERSION.SDK_INT <= 18) {
      localLayoutParams.width = wja.dp2px(75.0F, getResources());
    }
    localLayoutParams.rightMargin = wja.dp2px(10.0F, getResources());
    this.Dn.setLayoutParams(localLayoutParams);
    this.Dn.setPadding(wja.dp2px(7.0F, getResources()), 0, wja.dp2px(7.0F, getResources()), 0);
    this.Dn.setBackgroundResource(2130846112);
    this.Dn.setTextSize(1, 14.0F);
    this.Dn.setVisibility(0);
    bNR();
    this.Do.setOnClickListener(new uye(this));
    this.Dn.setOnClickListener(new uyf(this));
    this.Dn.setMaxWidth(wja.dp2px(260.0F, getResources()));
    if (AppSetting.enableTalkBack)
    {
      this.Dp.setContentDescription(this.Dp.getText());
      this.Dn.setContentDescription(this.Dn.getText());
      this.Do.setContentDescription(acfp.m(2131706558));
    }
  }
  
  private void bNR()
  {
    if (this.hi.isEmpty())
    {
      this.Dn.setText(acfp.m(2131706561));
      this.Dn.setClickable(false);
      this.Dn.setTextColor(855836698);
    }
    for (;;)
    {
      if (AppSetting.enableTalkBack) {
        this.Dn.setContentDescription(this.Dn.getText());
      }
      if (QLog.isColorLevel()) {
        QLog.i("contacts.fragment.TroopFragment", 2, "rightBtn width: " + this.Dn.getMeasuredWidth());
      }
      return;
      this.Dn.setText(String.format(acfp.m(2131706551), new Object[] { Integer.valueOf(this.hi.size()) }));
      this.Dn.setClickable(true);
      this.Dn.setTextColor(getResources().getColor(2131167311));
    }
  }
  
  private void bNT()
  {
    this.mImm = ((InputMethodManager)this.mContext.getSystemService("input_method"));
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar = ((SelectedAndSearchBar)this.mRootView.findViewById(2131377961));
    this.jdField_a_of_type_Aqdf = new aqdf(this.mApp);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(null, this.jdField_a_of_type_Aqdf, this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar$b);
  }
  
  private void bNU()
  {
    this.mImm.hideSoftInputFromWindow(getActivity().getWindow().peekDecorView().getWindowToken(), 0);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.bVl();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.bVm();
    this.aS.setVisibility(8);
  }
  
  private void bNV()
  {
    if (this.N == null) {
      this.N = aqha.a(getActivity(), getActivity().getResources().getString(2131701227), 0, 2131696701, null, new uyl(this));
    }
    if (!getActivity().isFinishing()) {
      this.N.show();
    }
  }
  
  private void bNW()
  {
    if (this.hi.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("contacts.fragment.TroopFragment", 2, "forward2MultiTargets map is empty !");
      }
      return;
    }
    if (this.jdField_a_of_type_Ahgq == null) {
      this.jdField_a_of_type_Ahgq = ahix.a(getActivity().getIntent(), this.mApp, getActivity());
    }
    ArrayList localArrayList = new ArrayList(this.hi.values());
    Collections.sort(localArrayList, new ResultRecord.a());
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("forward_multi_target", localArrayList);
    this.jdField_a_of_type_Ahgq.H(ahgg.a.R.intValue(), localBundle);
    this.jdField_a_of_type_Ahgq.cph();
  }
  
  private void bpM()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$a == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$a = new a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$c == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$c = new c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$b == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$b = new b();
    }
    this.mApp.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$a);
    this.mApp.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$c);
    this.mApp.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$b);
    this.mApp.addObserver(this.jdField_b_of_type_Accd);
    this.mApp.addObserver(this.jdField_b_of_type_Acbo);
  }
  
  private void bpN()
  {
    this.mApp.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$a);
    this.mApp.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$c);
    this.mApp.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$b);
    this.mApp.removeObserver(this.jdField_b_of_type_Accd);
    this.mApp.removeObserver(this.jdField_b_of_type_Acbo);
  }
  
  private void cl(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = R(paramString, paramInt);
    this.hi.remove(paramString);
    bNR();
    paramString = new ArrayList(this.hi.values());
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.X(paramString, true);
  }
  
  private void eJ(View paramView)
  {
    paramView = ((ForwardRecentItemView)paramView).b;
    if (E(paramView.uin, paramView.lk())) {
      cl(paramView.uin, paramView.lk());
    }
    for (;;)
    {
      this.jdField_b_of_type_Uyb.notifyDataSetChanged();
      return;
      a(paramView);
    }
  }
  
  private void fQ(List<ResultRecord> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((ResultRecord)paramList.next());
      }
    }
  }
  
  private void initData()
  {
    fQ(getArguments().getParcelableArrayList("selected_target_list"));
  }
  
  private void initView()
  {
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView = ((SwipPinnedHeaderExpandableListView)this.mRootView.findViewById(2131370584));
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setSelector(2131167595);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setGroupIndicator(null);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setPadding(0, 0, 0, wja.dp2px(54.0F, getResources()));
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setClipToPadding(false);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setScrollBarStyle(33554432);
    this.aS = ((FrameLayout)this.mRootView.findViewById(2131377207));
    bNT();
    aC();
  }
  
  private void resetAdapter()
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView != null)
    {
      if (this.jdField_b_of_type_Uyb != null) {
        this.jdField_b_of_type_Uyb.destroy();
      }
      this.jdField_b_of_type_Uyb = new uyb(getActivity(), this.mApp, this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView, this.jdField_b_of_type_Uyb$a);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setAdapter(this.jdField_b_of_type_Uyb);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setOnGroupClickListener(this.jdField_b_of_type_Uyb);
    }
  }
  
  public void bOm()
  {
    if (this.jdField_b_of_type_Uyb != null) {
      this.jdField_b_of_type_Uyb.notifyDataSetChanged();
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771991, 2130771990);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (this.aS.getVisibility() != 8)
    {
      bNU();
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.QG()) {
      bNU();
    }
    return super.onBackEvent();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mApp = getActivity().app;
    this.mContext = getActivity();
    this.mRootView = paramLayoutInflater.inflate(2131559347, null);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.mRootView.setFitsSystemWindows(true);
      this.mRootView.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    initView();
    initData();
    paramLayoutInflater = this.mRootView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "doOnDestroy");
    }
    if (this.jdField_b_of_type_Uyb != null) {
      this.jdField_b_of_type_Uyb.destroy();
    }
    this.jdField_a_of_type_Aqdf.destory();
    bpN();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_Ahgq != null) {
      this.jdField_a_of_type_Ahgq.onDestroy();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    bpN();
  }
  
  public void onResume()
  {
    super.onResume();
    bpM();
    if (this.jdField_b_of_type_Uyb == null) {
      resetAdapter();
    }
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.postDelayed(new ForwardTroopListFragment.3(this), 200L);
  }
  
  public class a
    extends acfd
  {
    protected a() {}
    
    public void onGetGenralSettings(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean1) {
        ForwardTroopListFragment.this.bOm();
      }
    }
    
    public void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap)
    {
      ForwardTroopListFragment.this.bOm();
    }
    
    public void onUpdateTroopHead(boolean paramBoolean, String paramString)
    {
      if (paramBoolean) {
        ForwardTroopListFragment.this.bOm();
      }
    }
  }
  
  public class b
    extends achq
  {
    protected b() {}
    
    public void aoF()
    {
      ForwardTroopListFragment.this.bOm();
    }
  }
  
  public class c
    extends acnd
  {
    protected c() {}
    
    public void H(boolean paramBoolean, String paramString)
    {
      if (paramBoolean) {
        ForwardTroopListFragment.this.bOm();
      }
    }
    
    public void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
    {
      if (paramBoolean) {
        ForwardTroopListFragment.this.bOm();
      }
    }
    
    public void d(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList)
    {
      if (paramBoolean) {
        ForwardTroopListFragment.this.bOm();
      }
    }
    
    public void di(String paramString1, String paramString2)
    {
      if (ForwardTroopListFragment.this.b != null) {
        ForwardTroopListFragment.this.b.cnv();
      }
    }
    
    public void jc(boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("contacts.fragment.TroopFragment", 2, "onUpdateTroopList " + paramBoolean);
      }
      if (paramBoolean) {
        ThreadManager.getUIHandler().postDelayed(new ForwardTroopListFragment.MyTroopObserver.1(this), 500L);
      }
    }
    
    public void q(int paramInt1, int paramInt2, String paramString)
    {
      if (paramInt1 == 6) {
        if (paramInt2 == 0) {
          ForwardTroopListFragment.this.bOm();
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
        ForwardTroopListFragment.this.bOm();
        return;
      } while ((paramInt1 != 9) || (paramInt2 != 0));
      ForwardTroopListFragment.this.bOm();
    }
    
    public void xj(boolean paramBoolean)
    {
      if (paramBoolean) {
        ForwardTroopListFragment.this.bOm();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardTroopListFragment
 * JD-Core Version:    0.7.0.1
 */