package com.tencent.mobileqq.search.fragment;

import amlt;
import amlu;
import ampx;
import amsq;
import amsx;
import amwd;
import amxy;
import amxz;
import amzk;
import android.view.ViewGroup;
import aqdf;
import com.tencent.mobileqq.search.searchengine.OnlineFileSearchEngine;
import com.tencent.widget.ListView;
import java.util.List;

public class OnlineFileSearchFragment
  extends BaseSearchFragment<ampx>
{
  List<ampx> Bt;
  String bIC;
  private int mFromType = 35;
  
  protected boolean DS()
  {
    return false;
  }
  
  protected amlt a()
  {
    return new a(this.a, this.c, this.Bt);
  }
  
  protected amwd a()
  {
    return new OnlineFileSearchEngine(this.d, this.mFromType, true);
  }
  
  public void e(int paramInt, String paramString, List<ampx> paramList)
  {
    this.mFromType = paramInt;
    this.Bt = paramList;
    this.bIC = paramString;
  }
  
  protected String vn()
  {
    return "腾讯文档";
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
      return new amsx(OnlineFileSearchFragment.this.c);
    }
    
    public amxz a(int paramInt, ViewGroup paramViewGroup)
    {
      return new amzk(paramViewGroup, 2131559726);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.OnlineFileSearchFragment
 * JD-Core Version:    0.7.0.1
 */