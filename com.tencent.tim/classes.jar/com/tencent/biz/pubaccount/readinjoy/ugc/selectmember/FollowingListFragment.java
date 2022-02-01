package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import aqbn;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import lbz;
import lcc;
import lce;
import mhg;
import mmf.a;
import moj;
import mox;

public class FollowingListFragment
  extends Fragment
  implements AdapterView.c, mmf.a<ObservableArrayList<ResultRecord>>
{
  private ObservableArrayList<ResultRecord> jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList;
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFollowingListFragment$a;
  private lce jdField_a_of_type_Lce = new moj(this);
  private mox jdField_a_of_type_Mox;
  private View.OnClickListener clickListener;
  private List<HashMap<String, Object>> js = new ArrayList();
  
  private void bL(List<mhg> paramList)
  {
    this.js.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      mhg localmhg = (mhg)paramList.next();
      HashMap localHashMap = new HashMap();
      String str = localmhg.getUin().toString();
      localHashMap.put("key_uin", str);
      localHashMap.put("key_name", localmhg.getNickName());
      localHashMap.put("key_head_url", localmhg.hh());
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.contains(ResultRecord.a(str, localmhg.getNickName())))) {
        localHashMap.put("key_checked", Boolean.valueOf(true));
      }
      this.js.add(localHashMap);
    }
  }
  
  private void initAdapter()
  {
    bL(lbz.a().aE());
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "key_checked";
    arrayOfString[1] = "key_head_url";
    arrayOfString[2] = "key_name";
    int[] arrayOfInt = new int[3];
    int[] tmp35_34 = arrayOfInt;
    tmp35_34[0] = 2131364587;
    int[] tmp40_35 = tmp35_34;
    tmp40_35[1] = 2131368698;
    int[] tmp45_40 = tmp40_35;
    tmp45_40[2] = 2131372190;
    tmp45_40;
    if ((this.jdField_a_of_type_Mox != null) && (this.jdField_a_of_type_Mox.pC() == 1))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFollowingListFragment$a = new b(getActivity(), this.js, 2131560459, arrayOfString, arrayOfInt);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFollowingListFragment$a = new a(getActivity(), this.js, 2131560459, arrayOfString, arrayOfInt);
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList = paramObservableArrayList;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.addOnListChangedCallback(this);
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2) {}
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(mox parammox)
  {
    this.jdField_a_of_type_Mox = parammox;
  }
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList) {}
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFollowingListFragment$a != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFollowingListFragment$a.notifyDataSetChanged();
    }
  }
  
  public void c(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFollowingListFragment$a != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFollowingListFragment$a.notifyDataSetChanged();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560458, paramViewGroup, false);
    paramViewGroup = (ListView)paramLayoutInflater.findViewById(2131370587);
    initAdapter();
    paramViewGroup.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFollowingListFragment$a);
    paramViewGroup.setOnItemClickListener(this);
    paramViewGroup.setSelector(2131167595);
    paramViewGroup.setOverScrollMode(0);
    lcc.a().b(this.jdField_a_of_type_Lce);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    lcc.a().c(this.jdField_a_of_type_Lce);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool = true;
    Object localObject = (CheckBox)paramView.findViewById(2131364587);
    if (((CheckBox)localObject).isEnabled()) {
      if (!((CheckBox)localObject).isChecked())
      {
        paramAdapterView = Boolean.valueOf(bool);
        ((CheckBox)localObject).setChecked(paramAdapterView.booleanValue());
        localObject = (Map)this.js.get(paramInt);
        ((Map)localObject).put("key_checked", paramAdapterView);
        localObject = ResultRecord.a((String)((Map)localObject).get("key_uin"), (String)((Map)localObject).get("key_name"), 2);
        if (!paramAdapterView.booleanValue()) {
          break label142;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.add(localObject);
      }
    }
    for (;;)
    {
      if (this.clickListener != null) {
        this.clickListener.onClick(paramView);
      }
      return;
      bool = false;
      break;
      label142:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.remove(localObject);
      continue;
      if ((this.jdField_a_of_type_Mox != null) && (this.jdField_a_of_type_Mox.pC() == 1))
      {
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.size() >= this.jdField_a_of_type_Mox.pD()))
        {
          paramAdapterView = getActivity().getResources().getString(2131718508, new Object[] { String.valueOf(this.jdField_a_of_type_Mox.getMaxCount()) });
          QQToast.a(getActivity(), paramAdapterView, 0).show();
          return;
        }
        QQToast.a(getActivity(), getActivity().getResources().getString(2131718502), 0).show();
      }
    }
  }
  
  public void setClickListener(View.OnClickListener paramOnClickListener)
  {
    this.clickListener = paramOnClickListener;
  }
  
  public class a
    extends SimpleAdapter
  {
    public a(List<? extends Map<String, ?>> paramList, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
    {
      super(paramInt, paramArrayOfString, paramArrayOfInt, arrayOfInt);
    }
    
    protected void a(View paramView, ResultRecord paramResultRecord) {}
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject = (Map)getItem(paramInt);
      ResultRecord localResultRecord = ResultRecord.a((String)((Map)localObject).get("key_uin"), (String)((Map)localObject).get("key_name"));
      if (FollowingListFragment.a(FollowingListFragment.this).contains(localResultRecord)) {
        ((Map)localObject).put("key_checked", Boolean.valueOf(true));
      }
      for (;;)
      {
        localObject = super.getView(paramInt, paramView, paramViewGroup);
        a((View)localObject, localResultRecord);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject;
        ((Map)localObject).put("key_checked", Boolean.valueOf(false));
      }
    }
    
    public void setViewImage(ImageView paramImageView, String paramString)
    {
      super.setViewImage(paramImageView, paramString);
      if (paramImageView.getId() == 2131368698) {}
      try
      {
        Object localObject = FollowingListFragment.this.getResources().getDrawable(2130840645);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        localObject = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        ((URLDrawable)localObject).setTag(aqbn.e(140, 140));
        ((URLDrawable)localObject).setDecodeHandler(aqbn.o);
        paramImageView.setImageDrawable((Drawable)localObject);
        return;
      }
      catch (Exception paramImageView)
      {
        QLog.e("FollowingListFragment", 2, "setViewImage: " + paramString, paramImageView);
      }
    }
  }
  
  class b
    extends FollowingListFragment.a
  {
    public b(List<? extends Map<String, ?>> paramList, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
    {
      super(paramList, paramInt, paramArrayOfString, paramArrayOfInt, arrayOfInt);
    }
    
    protected void a(View paramView, ResultRecord paramResultRecord)
    {
      if ((paramView == null) || (FollowingListFragment.a(FollowingListFragment.this) == null) || (FollowingListFragment.a(FollowingListFragment.this).bd() == null) || (FollowingListFragment.a(FollowingListFragment.this).bd().isEmpty())) {
        return;
      }
      paramView = (CheckBox)paramView.findViewById(2131364587);
      paramView.setBackgroundResource(2130850256);
      if (FollowingListFragment.a(FollowingListFragment.this).bd().contains(paramResultRecord.getUin()))
      {
        paramView.setEnabled(false);
        return;
      }
      paramView.setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.FollowingListFragment
 * JD-Core Version:    0.7.0.1
 */