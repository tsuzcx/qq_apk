package com.tencent.mobileqq.search.fragment;

import amlt;
import amlu;
import ammc;
import ampx;
import amru;
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
import com.tencent.mobileqq.search.searchengine.AIOTransferSearchEngine;
import com.tencent.widget.ListView;
import java.util.List;

public class AIOTransferFileSearchFragment
  extends BaseSearchFragment<ampx>
{
  List<ampx> Bt;
  aths.a a;
  String bIC;
  int mFromType = 31;
  
  public AIOTransferFileSearchFragment()
  {
    this.jdField_a_of_type_Aths$a = new ammc(this);
  }
  
  public AIOTransferFileSearchFragment(int paramInt)
  {
    this.jdField_a_of_type_Aths$a = new ammc(this);
    this.mFromType = paramInt;
  }
  
  protected boolean DS()
  {
    return this.mFromType != 31;
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
    return new AIOTransferSearchEngine(this.d, this.mFromType, true);
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
    String str = "收发文件";
    if (this.mFromType == 32) {
      str = "收到的文件";
    }
    while (this.mFromType != 33) {
      return str;
    }
    return "发送的文件";
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
      return new amru(AIOTransferFileSearchFragment.this.c);
    }
    
    public amxz a(int paramInt, ViewGroup paramViewGroup)
    {
      return new amzk(paramViewGroup, 2131558975);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.AIOTransferFileSearchFragment
 * JD-Core Version:    0.7.0.1
 */