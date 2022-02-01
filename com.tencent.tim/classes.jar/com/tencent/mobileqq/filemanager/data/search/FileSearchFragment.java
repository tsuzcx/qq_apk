package com.tencent.mobileqq.filemanager.data.search;

import agns;
import agnv;
import agnw;
import agnx;
import amlt;
import amlu;
import ampx;
import amsq;
import amwd;
import amxy;
import amxz;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import aqdf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileSearchFragment
  extends BaseSearchFragment<ampx>
{
  public List<ampx> Bt;
  public String bIC;
  protected boolean cez = true;
  int mFromType = -1;
  
  public void Jo(boolean paramBoolean)
  {
    this.cez = paramBoolean;
  }
  
  public amlt a()
  {
    return new a(this.a, this.c, this.Bt, this.bIC, this.d);
  }
  
  public amwd a()
  {
    return new FileManagerSearchEngine(this.d, this.mFromType);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = (TextView)this.GV.findViewById(2131368427);
    if (!this.cez) {
      paramViewGroup.setVisibility(8);
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      paramViewGroup.setVisibility(0);
    }
  }
  
  public String vn()
  {
    return agnx.bID;
  }
  
  class a
    extends amlu<ampx, amxy>
  {
    public a(aqdf paramaqdf, List<ampx> paramList, String paramString, QQAppInterface paramQQAppInterface)
    {
      super(paramList);
      if (paramString == null) {
        return;
      }
      if (paramString.size() == 1)
      {
        this$1 = (agns)paramString.get(0);
        if (FileSearchFragment.this.Br.size() > 1)
        {
          paramaqdf = new ArrayList();
          paramList = FileSearchFragment.this.Br.iterator();
          while (paramList.hasNext())
          {
            paramString = (FileManagerEntity)paramList.next();
            paramQQAppInterface = new agns();
            paramQQAppInterface.keyword = FileSearchFragment.this.keyword;
            paramQQAppInterface.Br.add(paramString);
            paramaqdf.add(paramQQAppInterface);
          }
          cS(paramaqdf);
          return;
        }
      }
      cS(paramString);
    }
    
    public amsq<ampx, amxy> a(int paramInt)
    {
      return new agnv(FileSearchFragment.a(FileSearchFragment.this));
    }
    
    public amxz a(int paramInt, ViewGroup paramViewGroup)
    {
      return new agnw(paramViewGroup);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchFragment
 * JD-Core Version:    0.7.0.1
 */