package com.tencent.mobileqq.filemanager.data.search;

import agns;
import agnv;
import agnw;
import amlt;
import amlu;
import ampx;
import amsq;
import amxy;
import amxz;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import aqdf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileSearchDetailFragment
  extends ReportV4Fragment
{
  private static agns jdField_a_of_type_Agns;
  TextView Sw;
  amlt jdField_a_of_type_Amlt;
  ListView jdField_a_of_type_ComTencentWidgetListView;
  agns b;
  aqdf c;
  String keyword;
  
  public static FileSearchDetailFragment a(String paramString, agns paramagns)
  {
    jdField_a_of_type_Agns = paramagns;
    paramagns = new FileSearchDetailFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("keyword", paramString);
    paramagns.setArguments(localBundle);
    return paramagns;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = jdField_a_of_type_Agns;
    jdField_a_of_type_Agns = null;
    this.keyword = getArguments().getString("keyword");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559536, paramViewGroup, false);
    this.Sw = ((TextView)paramLayoutInflater.findViewById(2131368427));
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramLayoutInflater.findViewById(2131370527));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.c != null) {
      this.c.destory();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = getString(2131693693);
    this.Sw.setText(String.format(paramView, new Object[] { Integer.valueOf(this.b.Br.size()), this.keyword }));
    this.c = new aqdf(getActivity(), getActivity().app);
    this.jdField_a_of_type_Amlt = new a(this.jdField_a_of_type_ComTencentWidgetListView, this.c, this.b, this.keyword, getActivity().app);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Amlt);
  }
  
  class a
    extends amlu<ampx, amxy>
  {
    public a(ListView paramListView, aqdf paramaqdf, ampx paramampx, String paramString, QQAppInterface paramQQAppInterface)
    {
      super(paramaqdf);
      this$1 = (agns)paramampx;
      if (FileSearchDetailFragment.this.Br.size() > 1)
      {
        paramListView = new ArrayList();
        paramaqdf = FileSearchDetailFragment.this.Br.iterator();
        while (paramaqdf.hasNext())
        {
          paramampx = (FileManagerEntity)paramaqdf.next();
          paramString = new agns();
          paramString.keyword = FileSearchDetailFragment.this.keyword;
          paramString.Br.add(paramampx);
          paramListView.add(paramString);
        }
        cS(paramListView);
      }
    }
    
    public amsq<ampx, amxy> a(int paramInt)
    {
      return new agnv(FileSearchDetailFragment.this.c);
    }
    
    public amxz a(int paramInt, ViewGroup paramViewGroup)
    {
      return new agnw(paramViewGroup);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchDetailFragment
 * JD-Core Version:    0.7.0.1
 */