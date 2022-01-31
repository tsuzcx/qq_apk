package com.tencent.token.ui;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.token.fe;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.PullToRefreshListView;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
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
  private zc mAdapter;
  private int mCurrType = 0;
  private PullToRefreshListView mListView;
  private List mLogs;
  
  private void addData(BufferedReader paramBufferedReader)
  {
    if (paramBufferedReader == null) {
      return;
    }
    yz localyz = ((zf)this.mLogs.get(this.mCurrType)).a;
    try
    {
      ArrayList localArrayList = new ArrayList();
      for (Object localObject1 = paramBufferedReader.readLine(); localObject1 != null; localObject1 = paramBufferedReader.readLine()) {
        localArrayList.add(highlightLog((String)localObject1));
      }
      localyz.a(localArrayList);
      updateData(localyz);
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
      h.c(localIOException.getMessage());
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
    new za(this, null).execute(new Void[0]);
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
    this.mAdapter = new zc(this, null);
    this.mListView.setAdapter(this.mAdapter);
    this.mListView.setRefreshTime(System.currentTimeMillis());
    this.mListView.setOnRefreshListener(new yy(this));
  }
  
  private void initLog()
  {
    if (this.mLogs == null)
    {
      this.mLogs = new ArrayList();
      zf localzf = new zf(this);
      localzf.a = new yz(1024, true);
      localzf.b = -1;
      this.mLogs.add(localzf);
    }
  }
  
  private void initUI()
  {
    setContentView(2130968761);
    this.mListView = ((PullToRefreshListView)findViewById(2131559265));
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
    zf localzf;
    BufferedReader localBufferedReader;
    do
    {
      do
      {
        return;
        localzf = (zf)this.mLogs.get(this.mCurrType);
      } while (localzf.b + 1 >= 2);
      localBufferedReader = fe.b(localzf.b + 1);
    } while (localBufferedReader == null);
    addData(localBufferedReader);
    localzf.b += 1;
  }
  
  private void showlog(int paramInt)
  {
    if ((paramInt < 0) || (this.mLogs == null)) {}
    yz localyz;
    do
    {
      return;
      this.mCurrType = paramInt;
      localyz = ((zf)this.mLogs.get(this.mCurrType)).a;
      updateData(localyz);
      this.mListView.setSelection(this.mAdapter.getCount() - 1);
    } while (localyz.a() > 0);
    loadMoreLogs();
  }
  
  private void updateData(yz paramyz)
  {
    this.mAdapter.a(paramyz);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ShowLogActivity
 * JD-Core Version:    0.7.0.1
 */