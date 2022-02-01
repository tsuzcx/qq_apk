package com.tencent.mobileqq.search.fragment;

import amlt;
import amlu;
import ammu;
import ampx;
import amsa;
import amsq;
import amwd;
import amxy;
import amxz;
import amzk;
import android.os.Bundle;
import android.view.ViewGroup;
import aqdf;
import aths;
import aths.a;
import com.tencent.mobileqq.search.searchengine.CloudRecentSearchEngine;
import com.tencent.widget.ListView;
import java.util.List;

public class CloudRecentFileSearchFragment
  extends BaseSearchFragment<ampx>
{
  List<ampx> Bt;
  aths.a a;
  String bIC;
  
  public CloudRecentFileSearchFragment()
  {
    this.jdField_a_of_type_Aths$a = new ammu(this);
  }
  
  protected boolean DS()
  {
    return false;
  }
  
  public void Q(String paramString, List<ampx> paramList)
  {
    this.Bt = paramList;
    this.bIC = paramString;
  }
  
  protected amlt a()
  {
    return new a(this.jdField_a_of_type_ComTencentWidgetListView, this.c, this.Bt);
  }
  
  protected amwd a()
  {
    return new CloudRecentSearchEngine(this.d);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    aths.a().a(this.jdField_a_of_type_Aths$a);
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    aths.a().b(this.jdField_a_of_type_Aths$a);
  }
  
  protected String vn()
  {
    return "最近浏览";
  }
  
  class a
    extends amlu<ampx, amxy>
  {
    public a(aqdf paramaqdf, List<ampx> paramList)
    {
      super(paramList);
      List localList;
      cS(localList);
    }
    
    public amsq<ampx, amxy> a(int paramInt)
    {
      return new amsa(CloudRecentFileSearchFragment.this.c);
    }
    
    public amxz a(int paramInt, ViewGroup paramViewGroup)
    {
      return new amzk(paramViewGroup, 2131558975);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.CloudRecentFileSearchFragment
 * JD-Core Version:    0.7.0.1
 */