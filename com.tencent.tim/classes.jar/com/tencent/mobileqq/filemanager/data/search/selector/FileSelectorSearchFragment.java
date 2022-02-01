package com.tencent.mobileqq.filemanager.data.search.selector;

import agny;
import agod;
import agoh;
import agok;
import ahda;
import amlt;
import ampx;
import amsq;
import amwd;
import amxy;
import amxz;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.widget.QFileSendBottomView;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.List;

public class FileSelectorSearchFragment
  extends BaseSearchFragment<ampx>
  implements agny
{
  private ahda jdField_a_of_type_Ahda;
  private FileSelectorSearchEngine jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine;
  private a jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchFragment$a;
  private Bundle aZ;
  private int cYm;
  
  public void Om(int paramInt)
  {
    this.cYm = paramInt;
  }
  
  public amlt a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchFragment$a = new a();
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchFragment$a;
  }
  
  public amwd a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine = new FileSelectorSearchEngine(this.d, getActivity(), this.cYm);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine.cA(this.aZ);
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine;
  }
  
  public void cA(Bundle paramBundle)
  {
    this.aZ = paramBundle;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.GV.findViewById(2131368427).setVisibility(8);
    paramViewGroup = (RelativeLayout)this.GV.findViewById(2131377207);
    paramBundle = new QFileSendBottomView(paramLayoutInflater.getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12);
    paramViewGroup.addView(paramBundle, localLayoutParams);
    paramBundle.t(this.jdField_a_of_type_ComTencentWidgetListView);
    this.jdField_a_of_type_Ahda = ahda.a(getActivity().app, getActivity(), paramBundle, this.aZ);
    this.jdField_a_of_type_Ahda.cD(this.aZ);
    this.jdField_a_of_type_Ahda.dmz();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Ahda != null) {
      this.jdField_a_of_type_Ahda.dko();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_Ahda.dko();
  }
  
  public String vn()
  {
    String str = "";
    if (this.cYm == 16) {
      str = getActivity().getString(2131693551);
    }
    do
    {
      return str;
      if (this.cYm == 17) {
        return getActivity().getString(2131693533);
      }
      if (this.cYm == 18) {
        return getActivity().getString(2131693508);
      }
    } while (this.cYm != 19);
    return getActivity().getString(2131693613);
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
      agoh localagoh = new agoh();
      localagoh.a(new agod(this));
      return localagoh;
    }
    
    public amxz a(int paramInt, ViewGroup paramViewGroup)
    {
      return new agok(paramViewGroup);
    }
    
    public void aq(List<ampx> paramList, boolean paramBoolean)
    {
      super.aq(paramList, paramBoolean);
      if ((paramList != null) && (paramList.size() > 0))
      {
        ThreadManagerV2.getUIHandlerV2().post(new FileSelectorSearchFragment.FileSelectorSearchAdapter.4(this));
        return;
      }
      ThreadManagerV2.getUIHandlerV2().post(new FileSelectorSearchFragment.FileSelectorSearchAdapter.5(this));
    }
    
    public void cS(List<ampx> paramList)
    {
      super.cS(paramList);
      if ((paramList != null) && (paramList.size() > 0))
      {
        ThreadManagerV2.getUIHandlerV2().post(new FileSelectorSearchFragment.FileSelectorSearchAdapter.2(this));
        return;
      }
      ThreadManagerV2.getUIHandlerV2().post(new FileSelectorSearchFragment.FileSelectorSearchAdapter.3(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment
 * JD-Core Version:    0.7.0.1
 */