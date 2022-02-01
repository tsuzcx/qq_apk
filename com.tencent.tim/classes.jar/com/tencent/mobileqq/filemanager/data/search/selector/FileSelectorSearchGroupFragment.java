package com.tencent.mobileqq.filemanager.data.search.selector;

import agoe;
import agof;
import agog;
import agoh;
import agok;
import ahda;
import amlt;
import ampx;
import amsq;
import amxy;
import amxz;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.widget.QFileSendBottomView;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.widget.ListView;
import java.util.List;

public class FileSelectorSearchGroupFragment
  extends IphoneTitleBarFragment
{
  private static agog jdField_a_of_type_Agog;
  private ahda jdField_a_of_type_Ahda;
  private a jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchGroupFragment$a;
  private Bundle aZ;
  private ListView b;
  private View mHeaderView;
  
  public static void a(agog paramagog)
  {
    jdField_a_of_type_Agog = paramagog;
  }
  
  private String vn()
  {
    if (jdField_a_of_type_Agog != null) {
      return String.format(getString(2131693693), new Object[] { Integer.valueOf(jdField_a_of_type_Agog.Ey()), jdField_a_of_type_Agog.getKeyword() });
    }
    return "";
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = (RelativeLayout)this.mContentView;
    this.b = ((ListView)paramLayoutInflater.findViewById(2131370527));
    this.b.setOnTouchListener(new agoe(this));
    this.mHeaderView = paramLayoutInflater.findViewById(2131368466);
    paramViewGroup = new QFileSendBottomView(paramLayoutInflater.getContext());
    paramBundle = new RelativeLayout.LayoutParams(-1, -2);
    paramBundle.addRule(12);
    paramLayoutInflater.addView(paramViewGroup, paramBundle);
    this.aZ = getArguments().getBundle("qfile_search_param_ex_params");
    this.jdField_a_of_type_Ahda = ahda.a(getActivity().app, getActivity(), paramViewGroup, this.aZ);
    this.jdField_a_of_type_Ahda.cD(this.aZ);
    this.jdField_a_of_type_Ahda.dmz();
    this.jdField_a_of_type_Ahda.cD(this.aZ);
    paramViewGroup.t(this.b);
  }
  
  public int getContentLayoutId()
  {
    return 2131561049;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    jdField_a_of_type_Agog = null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    setTitle(jdField_a_of_type_Agog.getFileName());
    super.onViewCreated(paramView, paramBundle);
    ((TextView)this.mHeaderView.findViewById(2131368427)).setText(vn());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchGroupFragment$a = new a(jdField_a_of_type_Agog);
    this.b.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchGroupFragment$a);
    this.jdField_a_of_type_Ahda.dko();
  }
  
  public class a
    extends amlt<ampx, amxy>
  {
    public a(agog paramagog)
    {
      try
      {
        this$1 = paramagog.a(FileSelectorSearchGroupFragment.this.getActivity().app, FileSelectorSearchGroupFragment.this.getActivity());
        if ((FileSelectorSearchGroupFragment.this != null) && (!FileSelectorSearchGroupFragment.this.isEmpty())) {
          cS(FileSelectorSearchGroupFragment.this);
        }
        return;
      }
      catch (Exception this$1) {}
    }
    
    public amsq<ampx, amxy> a(int paramInt)
    {
      agoh localagoh = new agoh();
      localagoh.a(new agof(this));
      return localagoh;
    }
    
    public amxz a(int paramInt, ViewGroup paramViewGroup)
    {
      return new agok(paramViewGroup);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchGroupFragment
 * JD-Core Version:    0.7.0.1
 */