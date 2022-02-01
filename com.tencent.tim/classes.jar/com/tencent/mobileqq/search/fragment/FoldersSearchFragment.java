package com.tencent.mobileqq.search.fragment;

import amlt;
import amlu;
import ampx;
import amsn;
import amsq;
import amwd;
import amxy;
import amxz;
import amzk;
import android.view.ViewGroup;
import aqdf;
import com.tencent.mobileqq.search.searchengine.FolderSearchEngine;
import com.tencent.widget.ListView;
import java.util.List;

public class FoldersSearchFragment
  extends BaseSearchFragment<ampx>
{
  List<ampx> Bt;
  String bIC;
  
  public void Q(String paramString, List<ampx> paramList)
  {
    this.Bt = paramList;
    this.bIC = paramString;
  }
  
  protected amlt a()
  {
    return new a(this.a, this.c, this.Bt);
  }
  
  protected amwd a()
  {
    return new FolderSearchEngine(this.d, 44);
  }
  
  protected String vn()
  {
    return "文件夹";
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
      return new amsn(FoldersSearchFragment.this.c);
    }
    
    public amxz a(int paramInt, ViewGroup paramViewGroup)
    {
      return new amzk(paramViewGroup, 2131559337);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.FoldersSearchFragment
 * JD-Core Version:    0.7.0.1
 */