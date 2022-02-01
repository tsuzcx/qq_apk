package com.tencent.mobileqq.filemanager.data.search.troop;

import accd;
import agny;
import agoo;
import agoq;
import agos;
import agou;
import amlt;
import ampx;
import amsq;
import amwd;
import amxy;
import amxz;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.widget.QFileListPullMoreLayout;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import java.util.List;

public class TroopFileSearchFragment
  extends BaseSearchFragment<ampx>
  implements agny, AbsListView.e
{
  private agoo jdField_a_of_type_Agoo;
  private a jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchTroopTroopFileSearchFragment$a;
  private QFileListPullMoreLayout b;
  private int bqx;
  private int cdI;
  protected accd d;
  public int mFromType;
  public long mTroopUin;
  
  public TroopFileSearchFragment()
  {
    this.jdField_d_of_type_Accd = new agoq(this);
  }
  
  private void Jq(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.setVisibility(0);
      this.b.setTextLeftDrawable(2130839651);
      return;
    }
    this.b.setVisibility(8);
    this.b.dmA();
  }
  
  public void Jn(boolean paramBoolean)
  {
    Jq(false);
    super.Jn(paramBoolean);
  }
  
  public void Jp(boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_Agoo.mB(this.keyword)) && (paramBoolean))
    {
      Jq(true);
      return;
    }
    Jq(false);
    super.Jp(paramBoolean);
  }
  
  public amlt a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchTroopTroopFileSearchFragment$a = new a();
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchTroopTroopFileSearchFragment$a;
  }
  
  public amwd a()
  {
    this.jdField_a_of_type_Agoo = new agoo(this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.mTroopUin, this.mFromType, this);
    this.jdField_a_of_type_Agoo.On(1);
    return this.jdField_a_of_type_Agoo;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.GV.findViewById(2131368427).setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(this);
    this.b = new QFileListPullMoreLayout(getActivity());
    this.b.setBackgroundResource(2130838900);
    this.b.setTextColor(getResources().getColor(2131167304));
    this.jdField_a_of_type_ComTencentWidgetListView.addFooterView(this.b);
    this.b.setVisibility(8);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Agoo != null) {
      this.jdField_a_of_type_Agoo.destroy();
    }
    if (this.jdField_d_of_type_Accd != null) {
      this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_d_of_type_Accd);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Agoo != null) {
      this.jdField_a_of_type_Agoo.pause();
    }
    if (this.jdField_d_of_type_Accd != null) {
      this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_d_of_type_Accd);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Agoo != null) {
      this.jdField_a_of_type_Agoo.resume();
    }
    if (this.jdField_d_of_type_Accd != null) {
      this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_d_of_type_Accd);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.cdI = paramInt3;
    this.bqx = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt != 0) || (this.rc == null) || (this.rc.isEmpty()) || (this.bqx != this.cdI - 2) || (this.jdField_a_of_type_Agoo.mB(this.keyword))) {
      return;
    }
    this.jdField_a_of_type_Agoo.Jc(this.keyword);
  }
  
  public String vo()
  {
    return this.keyword;
  }
  
  public class a
    extends amlt<ampx, amxy>
  {
    public a() {}
    
    public amsq<ampx, amxy> a(int paramInt)
    {
      return new agos();
    }
    
    public amxz a(int paramInt, ViewGroup paramViewGroup)
    {
      return new agou(paramViewGroup);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchFragment
 * JD-Core Version:    0.7.0.1
 */