package com.tencent.biz.richframework.part.list.base;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import rxj;
import rxk;
import rxn;
import rxq;
import ryi;
import ryk;
import ryl;

public class PublicListFragment
  extends BasePartFragment
{
  protected rxj a;
  protected ryl a;
  protected String aDv;
  public ryi b;
  
  protected void Ie()
  {
    Intent localIntent = getActivity().getIntent();
    if ((localIntent != null) && (localIntent.hasExtra("base_list_block_class"))) {
      try
      {
        this.aDv = localIntent.getStringExtra("base_list_block_class");
        this.b = a(this.aDv);
        if (this.b == null)
        {
          QLog.d("PublicListFragment", 1, "init adapter failed blockName:" + this.aDv);
          getActivity().finish();
        }
        if (localIntent.hasExtra("base_list_init_data")) {
          this.b.setDatas((ArrayList)localIntent.getSerializableExtra("base_list_init_data"));
        }
        if (localIntent.hasExtra("base_list_init_bean")) {
          this.b.setInitBean(localIntent.getSerializableExtra("base_list_init_bean"));
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.e("PublicListFragment", 1, "initIntentData error" + localException.getMessage());
        getActivity().finish();
        return;
      }
    }
    QLog.e("PublicListFragment", 1, "intent can't be null");
    getActivity().finish();
  }
  
  public ryi a(String paramString)
  {
    if (this.b == null) {}
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        this.b = ((ryi)Class.forName(paramString).getConstructor(new Class[] { Bundle.class }).newInstance(new Object[] { getActivity().getIntent().getExtras() }));
      }
      return this.b;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("PublicListFragment", 1, "initAdapterError" + paramString.getMessage());
        QLog.e("PublicListFragment", 1, paramString.getMessage());
      }
    }
  }
  
  protected void biU()
  {
    this.jdField_a_of_type_Rxj.a().setEnableRefresh(true);
    this.jdField_a_of_type_Rxj.a().setEnableLoadMore(true);
    this.jdField_a_of_type_Rxj.a().setParentFragment(this);
    this.jdField_a_of_type_Rxj.a().getBlockMerger().yf(3);
    this.jdField_a_of_type_Rxj.a().a().setBackgroundColor(getResources().getColor(2131166508));
    this.jdField_a_of_type_Rxj.a().a().addOnScrollListener(new ryk(this));
  }
  
  public List<rxk> bw()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Ryl = new ryl(this.b);
    this.jdField_a_of_type_Rxj = new rxj(2131365507, cm(), 3, 1);
    localArrayList.add(this.jdField_a_of_type_Ryl);
    localArrayList.add(this.jdField_a_of_type_Rxj);
    return localArrayList;
  }
  
  protected List<rxq> cm()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.b);
    return localArrayList;
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    biU();
  }
  
  public BlockContainer getBlockContainer()
  {
    if (this.jdField_a_of_type_Rxj != null) {
      return this.jdField_a_of_type_Rxj.a();
    }
    return null;
  }
  
  public int getContentLayoutId()
  {
    if ((this.b != null) && (this.b.getContentLayoutId() != 0)) {
      return this.b.getContentLayoutId();
    }
    return 2131560876;
  }
  
  public int getStatusBarColor()
  {
    if (this.b != null) {
      return this.b.getStatusBarColor();
    }
    return 0;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    Ie();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.part.list.base.PublicListFragment
 * JD-Core Version:    0.7.0.1
 */