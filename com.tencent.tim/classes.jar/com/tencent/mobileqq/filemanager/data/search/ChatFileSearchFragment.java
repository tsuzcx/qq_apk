package com.tencent.mobileqq.filemanager.data.search;

import acfp;
import agnp;
import agnr;
import agnv;
import amlt;
import amlu;
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
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqdf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatFileSearchFragment
  extends FileSearchFragment
{
  public int cYj;
  Runnable gv = new ChatFileSearchFragment.1(this);
  public int mFileType;
  public List<Integer> mTypes;
  public String mUin;
  
  public boolean DS()
  {
    return false;
  }
  
  public void Jn(boolean paramBoolean)
  {
    if (this.cYj == 2)
    {
      if (paramBoolean)
      {
        this.ko.setVisibility(0);
        this.Hc.setVisibility(8);
        this.Ha.setVisibility(8);
        Jp(false);
        return;
      }
      this.ko.setVisibility(8);
      return;
    }
    super.Jn(paramBoolean);
  }
  
  public amlt a()
  {
    return new a(this.a, this.c, this.Bt, this.bIC, this.d);
  }
  
  public amwd a()
  {
    ChatFileManagerSearchEngine localChatFileManagerSearchEngine = new ChatFileManagerSearchEngine(this.d, this.mFromType);
    if (this.cYj == 1)
    {
      localBundle = new Bundle();
      localBundle.putString("qfile_search_param_uin", this.mUin);
      localChatFileManagerSearchEngine.G(3, localBundle);
    }
    while (this.cYj != 2) {
      return localChatFileManagerSearchEngine;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("qfile_search_param_uin", this.mUin);
    localBundle.putInt("qfile_search_param_type", this.mFileType);
    localBundle.putIntegerArrayList("qfile_search_param_others", (ArrayList)this.mTypes);
    localChatFileManagerSearchEngine.G(4, localBundle);
    return localChatFileManagerSearchEngine;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.cYj == 2)
    {
      ThreadManager.executeOnFileThread(this.gv);
      this.ko.removeAllViewsInLayout();
      paramViewGroup = new TextView(getActivity());
      paramViewGroup.setText(acfp.m(2131703602));
      paramViewGroup.setSingleLine(true);
      paramViewGroup.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      paramViewGroup.setTextSize(1, 15.0F);
      paramViewGroup.setTextColor(getResources().getColor(2131167385));
      this.ko.addView(paramViewGroup);
    }
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  class a
    extends amlu<ampx, amxy>
  {
    a(aqdf paramaqdf, List<ampx> paramList, String paramString, QQAppInterface paramQQAppInterface)
    {
      super(paramList);
      if (paramString == null) {
        return;
      }
      if (paramString.size() == 1)
      {
        this$1 = (agnp)paramString.get(0);
        if (ChatFileSearchFragment.this.Br.size() > 1)
        {
          paramaqdf = new ArrayList();
          paramList = ChatFileSearchFragment.this.Br.iterator();
          while (paramList.hasNext())
          {
            paramString = (FileManagerEntity)paramList.next();
            paramQQAppInterface = new agnp();
            paramQQAppInterface.keyword = ChatFileSearchFragment.this.keyword;
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
      return new agnv(ChatFileSearchFragment.a(ChatFileSearchFragment.this));
    }
    
    public amxz a(int paramInt, ViewGroup paramViewGroup)
    {
      return new agnr(paramViewGroup);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.ChatFileSearchFragment
 * JD-Core Version:    0.7.0.1
 */