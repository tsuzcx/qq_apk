package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember;

import ampx;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search.HybridSearchFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search.HybridSearchFragment.a;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import lbz;
import mmf.a;
import moo;
import mop;
import moq;
import mor;
import mox;
import moy;
import mpc;
import wja;

public class ReadInJoySelectMemberFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, HybridSearchFragment.a, mmf.a<ObservableArrayList<ResultRecord>>
{
  private EditText T;
  private HybridSearchFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSearchHybridSearchFragment;
  protected mox a;
  private moy jdField_a_of_type_Moy;
  public ObservableArrayList<ResultRecord> b;
  private FollowingListFragment jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFollowingListFragment;
  private FriendListFragment jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFriendListFragment;
  private HorizontalListView e;
  private View lm;
  private View.OnClickListener x = new mor(this);
  
  public ReadInJoySelectMemberFragment()
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList = new ObservableArrayList();
    this.jdField_a_of_type_Mox = new mox();
  }
  
  private static List<String> a(@NonNull ObservableArrayList<ResultRecord> paramObservableArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramObservableArrayList = paramObservableArrayList.iterator();
    while (paramObservableArrayList.hasNext()) {
      localArrayList.add(((ResultRecord)paramObservableArrayList.next()).getUin());
    }
    return localArrayList;
  }
  
  private void aC()
  {
    Resources localResources = getResources();
    if (this.jdField_a_of_type_Mox.pC() == 1)
    {
      setTitle(localResources.getString(2131718501));
      setRightButton(2131718503, this);
    }
    for (;;)
    {
      setRightViewTextDisable(0);
      return;
      setTitle(localResources.getString(2131719427));
      setRightButton(2131719445, this);
    }
  }
  
  private void aH(Bundle paramBundle)
  {
    if (this.mContentView.findViewById(2131367564) != null)
    {
      if (paramBundle != null) {
        return;
      }
      aKY();
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFriendListFragment = new FriendListFragment();
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFriendListFragment.setClickListener(this.x);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFriendListFragment.n(this);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFriendListFragment.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFriendListFragment.a(this.jdField_a_of_type_Mox);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFollowingListFragment = new FollowingListFragment();
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFollowingListFragment.setClickListener(this.x);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFollowingListFragment.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFollowingListFragment.a(this.jdField_a_of_type_Mox);
      getChildFragmentManager().beginTransaction().add(2131367564, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFriendListFragment).commit();
    }
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.addOnListChangedCallback(this);
    aC();
  }
  
  private void aKY()
  {
    Object localObject = getArguments();
    if (localObject != null)
    {
      this.jdField_a_of_type_Mox.sf(((Bundle)localObject).getInt("opentype", 0));
      this.jdField_a_of_type_Mox.sg(((Bundle)localObject).getInt("maxSelect", 10));
      this.jdField_a_of_type_Mox.sh(((Bundle)localObject).getInt("maxCount", 30));
      this.jdField_a_of_type_Mox.setRowKey(((Bundle)localObject).getString("rowkey", ""));
      this.jdField_a_of_type_Mox.nJ(((Bundle)localObject).getString("callback", ""));
      if (((Bundle)localObject).containsKey("filterUins"))
      {
        localObject = ((Bundle)localObject).getString("filterUins", "");
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).length() > 0)) {
          this.jdField_a_of_type_Mox.cP(Arrays.asList(((String)localObject).split(",")));
        }
      }
    }
  }
  
  private void aQP()
  {
    TextView localTextView = (TextView)getRightTextView();
    int j = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.size();
    int i;
    if (j > 4)
    {
      i = 1;
      if (j <= 0) {
        break label152;
      }
      this.lm.setVisibility(8);
      setRightViewTextDisable(1);
      if (this.jdField_a_of_type_Mox.pC() != 1) {
        break label124;
      }
      localTextView.setText(MessageFormat.format(getString(2131718506), new Object[] { Integer.valueOf(j) }));
    }
    for (;;)
    {
      if (i == 0) {
        break label194;
      }
      this.e.getLayoutParams().width = wja.dp2px(200.0F, getResources());
      this.e.requestLayout();
      this.e.smoothScrollToPosition(j - 1);
      return;
      i = 0;
      break;
      label124:
      localTextView.setText(MessageFormat.format(getString(2131719446), new Object[] { Integer.valueOf(j) }));
    }
    label152:
    this.lm.setVisibility(0);
    if (this.jdField_a_of_type_Mox.pC() == 1) {
      localTextView.setText(2131718503);
    }
    for (;;)
    {
      setRightViewTextDisable(0);
      break;
      localTextView.setText(2131719445);
    }
    label194:
    this.e.getLayoutParams().width = -2;
    this.e.requestLayout();
  }
  
  private void aQQ()
  {
    if (getChildFragmentManager().getBackStackEntryCount() > 0) {
      this.T.setText("");
    }
  }
  
  private void initData()
  {
    lbz.a().aJw();
  }
  
  private void initSearchBar()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSearchHybridSearchFragment = HybridSearchFragment.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSearchHybridSearchFragment.a(this);
    this.lm = this.mContentView.findViewById(2131377780);
    this.T = ((EditText)this.mContentView.findViewById(2131377838));
    this.T.setOnKeyListener(new moo(this));
    this.T.addTextChangedListener(new mop(this));
  }
  
  private void initViews()
  {
    initSearchBar();
    aQR();
  }
  
  public void a(ampx paramampx)
  {
    ResultRecord localResultRecord = ResultRecord.a(paramampx.getUin(), paramampx.getTitle().toString());
    if ((paramampx instanceof mpc)) {
      localResultRecord.setType(2);
    }
    for (;;)
    {
      if (!this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.contains(localResultRecord))
      {
        if ((this.jdField_a_of_type_Mox.pC() != 1) || (TextUtils.isEmpty(paramampx.getUin())) || (this.jdField_a_of_type_Mox.bd() == null)) {
          break label194;
        }
        if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.size() < this.jdField_a_of_type_Mox.pD()) {
          break;
        }
        paramampx = getActivity().getResources().getString(2131718508, new Object[] { String.valueOf(this.jdField_a_of_type_Mox.getMaxCount()) });
        QQToast.a(getActivity(), paramampx, 0).show();
      }
      return;
      localResultRecord.setType(1);
    }
    if (this.jdField_a_of_type_Mox.bd().contains(paramampx.getUin()))
    {
      QQToast.a(getActivity(), getActivity().getResources().getString(2131718502), 0).show();
      return;
    }
    label194:
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.add(localResultRecord);
    aQQ();
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2) {}
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void aQN()
  {
    aQO();
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  protected void aQO()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.size() > 0)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("result_set", this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList);
      getActivity().setResult(-1, localIntent);
    }
  }
  
  protected void aQR()
  {
    this.e = ((HorizontalListView)this.mContentView.findViewById(2131377969));
    this.jdField_a_of_type_Moy = new moy(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList);
    this.e.setAdapter(this.jdField_a_of_type_Moy);
    this.e.setOverScrollMode(2);
    this.e.setOnItemClickListener(new moq(this));
  }
  
  public void aQS()
  {
    if ((getActivity() != null) && (this.T != null)) {}
    try
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)getActivity().getSystemService("input_method");
      if (localInputMethodManager.isActive())
      {
        localInputMethodManager.hideSoftInputFromWindow(this.T.getWindowToken(), 2);
        this.T.clearFocus();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList) {}
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSearchHybridSearchFragment.cQ(a(paramObservableArrayList));
    if (paramObservableArrayList.size() > this.jdField_a_of_type_Mox.pD())
    {
      String str = String.format(getString(2131696700), new Object[] { Integer.valueOf(this.jdField_a_of_type_Mox.pD()) });
      if (this.jdField_a_of_type_Mox.pC() == 1) {
        str = getString(2131718508, new Object[] { String.valueOf(this.jdField_a_of_type_Mox.getMaxCount()) });
      }
      paramObservableArrayList.subList(paramInt1, paramInt1 + paramInt2).clear();
      QQToast.a(getActivity(), str, 0).show();
      return;
    }
    aQP();
  }
  
  public void c(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSearchHybridSearchFragment.cQ(a(paramObservableArrayList));
    aQP();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.mContentView == null)
    {
      QLog.e("IphoneTitleBarFragment", 1, "mContentView == null");
      return;
    }
    initViews();
    aH(paramBundle);
    initData();
  }
  
  public int getContentLayoutId()
  {
    return 2131560460;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramActivity.overridePendingTransition(2130772009, 2130772002);
  }
  
  public boolean onBackEvent()
  {
    if (getChildFragmentManager().getBackStackEntryCount() > 0)
    {
      aQS();
      this.T.setText("");
      this.T.clearFocus();
      return true;
    }
    aQO();
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
      aQN();
      continue;
      aQS();
      getChildFragmentManager().beginTransaction().setCustomAnimations(2130772092, 2130772093, 2130772088, 2130772089).hide(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFriendListFragment).add(2131367564, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFollowingListFragment).addToBackStack(FollowingListFragment.class.getName()).commit();
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    getActivity().overridePendingTransition(2130772002, 2130771990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberFragment
 * JD-Core Version:    0.7.0.1
 */