package com.tencent.token.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.token.dx;
import com.tencent.token.global.g;
import com.tencent.token.ui.base.PullToRefreshListView;
import com.tencent.token.ui.base.PullToRefreshListView.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ShowLogActivity
  extends BaseActivity
{
  private static final int CAPACITY = 1024;
  private static final int MAX_LOG_PAGECOUNT = 2;
  private static final int MENU_CLEARLOG = 3;
  private static final int MENU_MERGELOG = 6;
  private static final int MENU_SCREENMODE = 5;
  private static final int MENU_SCREENSHOT = 2;
  private static final int MENU_SENDLOG = 4;
  private static final int MENU_SWITCH = 1;
  ForegroundColorSpan ColorD = new ForegroundColorSpan(-16776961);
  ForegroundColorSpan ColorE = new ForegroundColorSpan(-65536);
  ForegroundColorSpan ColorI = new ForegroundColorSpan(-12483328);
  ForegroundColorSpan ColorV = new ForegroundColorSpan(-16777216);
  ForegroundColorSpan ColorW = new ForegroundColorSpan(-32945);
  private boolean Landscape_Mode = false;
  private c mAdapter;
  private int mCurrType = 0;
  private PullToRefreshListView mListView;
  private List<d> mLogs;
  
  private void addData(BufferedReader paramBufferedReader)
  {
    if (paramBufferedReader == null) {
      return;
    }
    a locala = ((d)this.mLogs.get(this.mCurrType)).a;
    try
    {
      ArrayList localArrayList = new ArrayList();
      for (Object localObject1 = paramBufferedReader.readLine(); localObject1 != null; localObject1 = paramBufferedReader.readLine()) {
        localArrayList.add(highlightLog((String)localObject1));
      }
      locala.a(localArrayList);
      updateData(locala);
      localObject1 = this.mListView;
      if (localArrayList.size() - 3 > 0) {}
      for (int i = localArrayList.size() - 3;; i = 0)
      {
        ((PullToRefreshListView)localObject1).setSelection(i);
        try
        {
          paramBufferedReader.close();
          return;
        }
        catch (IOException paramBufferedReader)
        {
          return;
        }
      }
      try
      {
        paramBufferedReader.close();
        throw localObject2;
      }
      catch (IOException paramBufferedReader)
      {
        break label142;
      }
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      g.c(localIOException.getMessage());
      try
      {
        paramBufferedReader.close();
        return;
      }
      catch (IOException paramBufferedReader) {}
    }
    finally {}
  }
  
  private void clearLog()
  {
    new b(null).execute(new Void[0]);
  }
  
  private SpannableString highlightLog(String paramString)
  {
    SpannableString localSpannableString = new SpannableString(paramString);
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      return localSpannableString;
      str = paramString.substring(0, 1);
      if (str.equals("V"))
      {
        localSpannableString.setSpan(this.ColorV, 0, paramString.length(), 33);
        return localSpannableString;
      }
      if (str.equals("D"))
      {
        localSpannableString.setSpan(this.ColorD, 0, paramString.length(), 33);
        return localSpannableString;
      }
      if (str.equals("I"))
      {
        localSpannableString.setSpan(this.ColorI, 0, paramString.length(), 33);
        return localSpannableString;
      }
      if (str.equals("W"))
      {
        localSpannableString.setSpan(this.ColorW, 0, paramString.length(), 33);
        return localSpannableString;
      }
    } while (!str.equals("E"));
    localSpannableString.setSpan(this.ColorE, 0, paramString.length(), 33);
    return localSpannableString;
  }
  
  private void initData()
  {
    this.mAdapter = new c(null);
    this.mListView.setAdapter(this.mAdapter);
    this.mListView.setRefreshTime(System.currentTimeMillis());
    this.mListView.setOnRefreshListener(new PullToRefreshListView.a()
    {
      public void onRefresh()
      {
        ShowLogActivity.this.loadMoreLogs();
      }
    });
  }
  
  private void initLog()
  {
    if (this.mLogs == null)
    {
      this.mLogs = new ArrayList();
      d locald = new d();
      locald.a = new a(1024, true);
      locald.b = -1;
      this.mLogs.add(locald);
    }
  }
  
  private void initUI()
  {
    setContentView(2130968761);
    this.mListView = ((PullToRefreshListView)findViewById(2131559266));
    View localView = LayoutInflater.from(this).inflate(2130968698, this.mListView, false);
    localView.setVisibility(8);
    this.mListView.addFooterView(localView);
    localView = LayoutInflater.from(this).inflate(2130968695, this.mListView, false);
    localView.setVisibility(8);
    this.mListView.addFooterView(localView);
    localView = LayoutInflater.from(this).inflate(2130968694, this.mListView, false);
    localView.setVisibility(8);
    this.mListView.addFooterView(localView);
    this.mListView.setScrollingCacheEnabled(true);
    this.mListView.a(2131231171);
  }
  
  private void loadMoreLogs()
  {
    if ((this.mCurrType < 0) || (this.mLogs == null) || (this.mCurrType >= this.mLogs.size())) {}
    d locald;
    BufferedReader localBufferedReader;
    do
    {
      do
      {
        return;
        locald = (d)this.mLogs.get(this.mCurrType);
      } while (locald.b + 1 >= 2);
      localBufferedReader = dx.b(locald.b + 1);
    } while (localBufferedReader == null);
    addData(localBufferedReader);
    locald.b += 1;
  }
  
  private void showlog(int paramInt)
  {
    if ((paramInt < 0) || (this.mLogs == null)) {}
    a locala;
    do
    {
      return;
      this.mCurrType = paramInt;
      locala = ((d)this.mLogs.get(this.mCurrType)).a;
      updateData(locala);
      this.mListView.setSelection(this.mAdapter.getCount() - 1);
    } while (locala.a() > 0);
    loadMoreLogs();
  }
  
  private void updateData(a parama)
  {
    this.mAdapter.a(parama);
    this.mListView.b();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initUI();
    initData();
    initLog();
    showlog(0);
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  private static class a
  {
    private final List<CharSequence> a = new LinkedList();
    private final boolean b;
    
    public a(int paramInt, boolean paramBoolean)
    {
      if ((paramInt >= 0) && (paramInt > 1073741824)) {}
      this.b = paramBoolean;
    }
    
    public int a()
    {
      return this.a.size();
    }
    
    public Collection<CharSequence> a(Collection<CharSequence> paramCollection)
    {
      Object localObject = paramCollection;
      if (paramCollection == null) {}
      try
      {
        localObject = new ArrayList();
        ((Collection)localObject).clear();
        ((Collection)localObject).addAll(this.a);
        return localObject;
      }
      finally {}
    }
    
    public void a(List<CharSequence> paramList)
    {
      if (paramList != null) {}
      for (;;)
      {
        try
        {
          int i = paramList.size();
          if (i == 0) {
            return;
          }
          if (this.b)
          {
            i = 0;
            this.a.addAll(i, paramList);
          }
          else
          {
            i = this.a.size();
          }
        }
        finally {}
      }
    }
    
    public void b()
    {
      try
      {
        this.a.clear();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
  
  private class b
    extends AsyncTask<Void, Void, Void>
  {
    private b() {}
    
    protected Void a(Void... paramVarArgs)
    {
      dx.h();
      paramVarArgs = ShowLogActivity.this.mLogs.iterator();
      while (paramVarArgs.hasNext())
      {
        ShowLogActivity.d locald = (ShowLogActivity.d)paramVarArgs.next();
        locald.a.b();
        locald.b = -1;
      }
      return null;
    }
    
    protected void a(Void paramVoid)
    {
      ShowLogActivity.this.updateData(null);
      ShowLogActivity.this.dismissDialog();
    }
    
    protected void onPreExecute()
    {
      ShowLogActivity.this.showProDialog(ShowLogActivity.this, 2131231424, new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          ShowLogActivity.this.dismissDialog();
        }
      });
    }
  }
  
  private class c
    extends BaseAdapter
  {
    private List<CharSequence> b = new ArrayList();
    
    private c() {}
    
    public CharSequence a(int paramInt)
    {
      return (CharSequence)this.b.get(paramInt);
    }
    
    public void a(ShowLogActivity.a parama)
    {
      this.b.clear();
      if (parama != null) {
        parama.a(this.b);
      }
      notifyDataSetChanged();
    }
    
    public int getCount()
    {
      return this.b.size();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = ShowLogActivity.this.getLayoutInflater().inflate(2130968762, null);
        paramViewGroup = new a(null);
        paramViewGroup.a = ((TextView)paramView.findViewById(2131559267));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        CharSequence localCharSequence = a(paramInt);
        paramViewGroup = paramViewGroup.a;
        paramViewGroup.setText(localCharSequence);
        paramViewGroup.setOnLongClickListener(new View.OnLongClickListener()
        {
          public boolean onLongClick(View paramAnonymousView)
          {
            return true;
          }
        });
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
    }
    
    private class a
    {
      TextView a;
      
      private a() {}
    }
  }
  
  public class d
  {
    public ShowLogActivity.a a;
    public int b;
    
    public d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ShowLogActivity
 * JD-Core Version:    0.7.0.1
 */