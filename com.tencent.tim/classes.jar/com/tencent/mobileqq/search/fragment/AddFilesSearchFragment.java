package com.tencent.mobileqq.search.fragment;

import amlt;
import amlu;
import ammn;
import ampx;
import amrz;
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
import com.tencent.mobileqq.search.searchengine.AddFilesSearchEngine;
import com.tencent.widget.ListView;
import java.util.List;

public class AddFilesSearchFragment
  extends BaseSearchFragment<ampx>
{
  List<ampx> Bt;
  aths.a a;
  String bIC;
  byte[] cA;
  private int mFromType = 34;
  
  public AddFilesSearchFragment()
  {
    this.jdField_a_of_type_Aths$a = new ammn(this);
  }
  
  protected boolean DS()
  {
    return (this.mFromType != 34) && (this.mFromType != 43);
  }
  
  protected amlt a()
  {
    return new a(this.jdField_a_of_type_ComTencentWidgetListView, this.c, this.Bt);
  }
  
  protected amwd a()
  {
    return new AddFilesSearchEngine(this.d, this.mFromType, this.cA, true);
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, String paramString, List<ampx> paramList)
  {
    this.mFromType = paramInt;
    this.cA = paramArrayOfByte;
    this.Bt = paramList;
    this.bIC = paramString;
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
    return "我添加的文件";
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
      return new amrz(AddFilesSearchFragment.this.c);
    }
    
    public amxz a(int paramInt, ViewGroup paramViewGroup)
    {
      return new amzk(paramViewGroup, 2131558975);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.AddFilesSearchFragment
 * JD-Core Version:    0.7.0.1
 */