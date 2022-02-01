package com.tencent.biz.qqcircle.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.widgets.QCirclePersonInfoAndStatusWidget;
import com.tencent.biz.qqcircle.widgets.QCirclePersonalBottomView;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.widget.immersive.SystemBarCompact;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import ovd;
import ovg;
import paf;
import pec;
import rxj;
import rxk;
import rxq;

public abstract class QCirclePersonalBaseBottomFragment
  extends BasePartFragment
{
  protected ovg a;
  protected pec a;
  protected rxj a;
  private FeedCloudMeta.StUser c;
  protected String mUin;
  
  private List<rxq> by()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Ovg = new ovg(new Bundle());
    this.jdField_a_of_type_Ovg.re(HI());
    if (((a() instanceof QCirclePersonalDetailFragment)) && (((QCirclePersonalDetailFragment)a()).a() != null) && (((QCirclePersonalDetailFragment)a()).a().a() != null) && (((QCirclePersonalDetailFragment)a()).a().a().a() != null))
    {
      int j = ((QCirclePersonalDetailFragment)a()).a().a().a().getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = ((QCirclePersonalDetailFragment)a()).a().a().a().getChildAt(i);
        if ((localView instanceof QCirclePersonalBottomView)) {
          this.jdField_a_of_type_Ovg.setInteractor(((QCirclePersonalBottomView)localView).getInteractor());
        }
        i += 1;
      }
    }
    this.jdField_a_of_type_Ovg.setOnLoadDataDelegate(new paf(this));
    localArrayList.add(this.jdField_a_of_type_Ovg);
    return localArrayList;
  }
  
  public boolean HI()
  {
    return true;
  }
  
  protected void Ie()
  {
    Object localObject = getActivity().getIntent();
    if ((localObject != null) && (((Intent)localObject).hasExtra("key_bundle_common_init_bean")))
    {
      localObject = (QCircleInitBean)((Intent)localObject).getSerializableExtra("key_bundle_common_init_bean");
      if ((((QCircleInitBean)localObject).getUser() != null) && (!TextUtils.isEmpty(((QCircleInitBean)localObject).getUser().id.get())))
      {
        this.mUin = ((QCircleInitBean)localObject).getUser().id.get();
        this.c = ((QCircleInitBean)localObject).getUser();
      }
    }
  }
  
  public BasePartFragment a()
  {
    if ((getActivity() != null) && ((getActivity() instanceof PublicFragmentActivity)) && (getActivity().getSupportFragmentManager().getFragments() != null) && (getActivity().getSupportFragmentManager().getFragments().size() > 0) && ((getActivity().getSupportFragmentManager().getFragments().get(0) instanceof BasePartFragment))) {
      return (BasePartFragment)getActivity().getSupportFragmentManager().getFragments().get(0);
    }
    return null;
  }
  
  public void bhT()
  {
    if (this.jdField_a_of_type_Ovg != null) {
      this.jdField_a_of_type_Ovg.bhT();
    }
  }
  
  protected void biU()
  {
    this.jdField_a_of_type_Rxj.a().a().setNestedScrollingEnabled(true);
    this.jdField_a_of_type_Rxj.a().setEnableRefresh(false);
    this.jdField_a_of_type_Rxj.a().setEnableLoadMore(true);
    this.jdField_a_of_type_Rxj.a().setParentFragment(this);
  }
  
  protected void biV()
  {
    try
    {
      if (((a() instanceof QCirclePersonalDetailFragment)) && (((QCirclePersonalDetailFragment)a()).a() != null) && (((QCirclePersonalDetailFragment)a()).a().a() != null) && (((QCirclePersonalDetailFragment)a()).a().a().a() != null))
      {
        int j = ((QCirclePersonalDetailFragment)a()).a().a().a().getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = ((QCirclePersonalDetailFragment)a()).a().a().a().getChildAt(i);
          if ((localView instanceof QCirclePersonInfoAndStatusWidget)) {
            ThreadManager.getUIHandler().post(new QCirclePersonalBaseBottomFragment.2(this, localView));
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 0, "adjustEmptyViewHeight()  e.getMessage : " + localException.getMessage());
      localException.printStackTrace();
    }
  }
  
  public List<rxk> bw()
  {
    Ie();
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Rxj = new rxj(2131365507, by(), 3, 1);
    localArrayList.add(this.jdField_a_of_type_Rxj);
    return localArrayList;
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = getActivity().mSystemBarComp;
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater.init();
      paramLayoutInflater.setStatusBarVisible(2, 0);
    }
    biU();
    initChildView();
    this.jdField_a_of_type_Ovg.bhS();
    biV();
  }
  
  public int getContentLayoutId()
  {
    return 2131560926;
  }
  
  public int getStatusBarColor()
  {
    return ovd.rY();
  }
  
  protected abstract void initChildView();
  
  public abstract void loadMore();
  
  public void onPageSelected(int paramInt)
  {
    if (this.jdField_a_of_type_Ovg != null) {
      this.jdField_a_of_type_Ovg.onPageSelected(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCirclePersonalBaseBottomFragment
 * JD-Core Version:    0.7.0.1
 */