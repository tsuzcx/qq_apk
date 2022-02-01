package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFlowLayout;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kbp;
import kxm;
import lbz;
import lcc;
import lce;
import mko;
import mkp;
import mkq;
import mkr;
import mks;
import mkt;

public class ReadInJoyVideoTagSelectionFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$a;
  private b jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$b;
  private DataSetObserver jdField_b_of_type_AndroidDatabaseDataSetObserver = new mko(this);
  private QQToast jdField_b_of_type_ComTencentMobileqqWidgetQQToast;
  private DataSetObserver jdField_c_of_type_AndroidDatabaseDataSetObserver = new mkp(this);
  private QQToast jdField_c_of_type_ComTencentMobileqqWidgetQQToast;
  private lce g = new mkq(this);
  private View kY;
  private View lb;
  private View lc;
  private TextView qO;
  
  private void aC()
  {
    this.vg.changeBg(true);
    setRightButton(2131691970, this);
    this.rightViewText.setTextColor(-16265040);
    this.rightViewText.setBackgroundResource(0);
    this.leftView.setText(2131690700);
    mkt.a(this);
  }
  
  private void aPC()
  {
    this.kY.setVisibility(0);
  }
  
  private void aPD()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("EXTRA_SELECTION_REACH_MAXIMUM_NUMBER", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$a.isFull());
    PublicFragmentActivity.b.startForResult(getActivity(), localIntent, PublicTransFragmentActivity.class, ReadInJoyVideoSearchTagFragment.class, 1000);
  }
  
  private void aPG()
  {
    Object localObject3 = getActivity().getIntent();
    Object localObject1;
    if (localObject3 != null)
    {
      localObject1 = ((Intent)localObject3).getStringExtra("EXTRA_TOPIC_ID");
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = Long.valueOf((String)localObject1);
        ArrayList localArrayList = ((Intent)localObject3).getParcelableArrayListExtra("EXTRA_SELECTED_TAG_LIST");
        localObject3 = localObject1;
        if (localArrayList != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$a.addAll(localArrayList);
          localObject3 = localObject1;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$a.notifyDataSetChanged();
        lcc.a().b(this.g);
        if (localObject3 == null) {
          break label97;
        }
        lbz.a().et(((Long)localObject3).longValue());
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.d("ReadInJoyVideoTagSelectionFragment", 2, "handleIntent: fail to get topicId");
      }
      Object localObject2 = null;
      continue;
      label97:
      lbz.a().mU(null);
      return;
      localObject3 = null;
    }
  }
  
  private void finishWithResult()
  {
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    int j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$a.getCount();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$a.getItem(i));
      i += 1;
    }
    localIntent.putParcelableArrayListExtra("EXTRA_SELECTED_TAG_LIST", localArrayList);
    getActivity().setResult(-1, localIntent);
    getActivity().finish();
    kbp.a(null, "", "0X80092F2", "0X80092F2", 0, 0, Integer.valueOf(localArrayList.size()).toString(), "", "", kxm.iS(), false);
  }
  
  private void initViews()
  {
    this.kY = this.mContentView.findViewById(2131379228);
    this.kY.setOnClickListener(this);
    this.qO = ((TextView)this.mContentView.findViewById(2131379597));
    this.lb = this.mContentView.findViewById(2131365390);
    this.lc = this.mContentView.findViewById(2131365387);
    ReadInJoyFlowLayout localReadInJoyFlowLayout = (ReadInJoyFlowLayout)this.mContentView.findViewById(2131367333);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$a = new a(getActivity(), 2131560500);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$a.registerDataSetObserver(this.jdField_b_of_type_AndroidDatabaseDataSetObserver);
    localReadInJoyFlowLayout.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$a);
    localReadInJoyFlowLayout.setOnItemClickListener(new mkr(this));
    localReadInJoyFlowLayout = (ReadInJoyFlowLayout)this.mContentView.findViewById(2131367334);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$b = new b(getActivity(), 2131560500);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$b.registerDataSetObserver(this.jdField_c_of_type_AndroidDatabaseDataSetObserver);
    localReadInJoyFlowLayout.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$b);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$b.notifyDataSetChanged();
    localReadInJoyFlowLayout.setOnItemClickListener(new mks(this));
    aPG();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    initViews();
  }
  
  public int getContentLayoutId()
  {
    return 2131560499;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1000) && (paramInt2 == -1))
    {
      paramIntent = (TagInfo)paramIntent.getParcelableExtra("SEARCH_TAG_RESULT");
      if ((paramIntent != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyVideoTagSelectionFragment$a.a(paramIntent)) && (!this.jdField_b_of_type_ComTencentMobileqqWidgetQQToast.isShowing())) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQToast.show();
      }
    }
  }
  
  public boolean onBackEvent()
  {
    finishWithResult();
    return false;
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
      this.kY.setVisibility(8);
      aPD();
      continue;
      finishWithResult();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    lcc.a().c(this.g);
  }
  
  public void onResume()
  {
    super.onResume();
    aC();
    aPC();
  }
  
  public static class a
    extends ReadInJoyVideoTagSelectionFragment.b
  {
    a(@NonNull Context paramContext, int paramInt)
    {
      super(paramInt);
    }
    
    public boolean a(@NonNull TagInfo paramTagInfo)
    {
      int i = getCount();
      super.a(paramTagInfo);
      return i != getCount();
    }
    
    @NonNull
    public View getView(int paramInt, @Nullable View paramView, @NonNull ViewGroup paramViewGroup)
    {
      View localView = super.getView(paramInt, paramView, paramViewGroup);
      localView.setSelected(true);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
    }
    
    public boolean isFull()
    {
      return getCount() == 5;
    }
  }
  
  public static class b
    extends ArrayAdapter<TagInfo>
  {
    final Set<TagInfo> aa = new LinkedHashSet();
    
    b(@NonNull Context paramContext, int paramInt)
    {
      super(paramInt);
    }
    
    public void a(@Nullable TagInfo paramTagInfo)
    {
      if (!this.aa.contains(paramTagInfo))
      {
        this.aa.add(paramTagInfo);
        super.add(paramTagInfo);
      }
    }
    
    public void a(TagInfo... paramVarArgs)
    {
      addAll(Arrays.asList(paramVarArgs));
    }
    
    public void addAll(@NonNull Collection<? extends TagInfo> paramCollection)
    {
      paramCollection = new LinkedHashSet(paramCollection);
      paramCollection.removeAll(this.aa);
      this.aa.addAll(paramCollection);
      super.addAll(paramCollection);
    }
    
    public void b(@Nullable TagInfo paramTagInfo)
    {
      this.aa.remove(paramTagInfo);
      super.remove(paramTagInfo);
    }
    
    public void clear()
    {
      super.clear();
      this.aa.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoTagSelectionFragment
 * JD-Core Version:    0.7.0.1
 */