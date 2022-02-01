package com.tencent.mobileqq.search.fragment;

import amkd;
import amlt;
import ammx;
import ammy;
import amwd;
import android.os.Bundle;
import android.view.View;
import com.tencent.widget.ListView;
import cooperation.qqfav.globalsearch.FunctionSearchEngine;

public class FunctionSearchFragment
  extends BaseSearchFragment
{
  public static FunctionSearchFragment a()
  {
    return new FunctionSearchFragment();
  }
  
  protected int IT()
  {
    return 120;
  }
  
  protected amlt a()
  {
    return new ammy(this, this.a, this.c);
  }
  
  protected amwd a()
  {
    return new FunctionSearchEngine(this.d, -1);
  }
  
  protected void fO(String paramString, int paramInt)
  {
    super.fO(paramString, paramInt);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.a.setOnTouchListener(new ammx(this));
  }
  
  protected String vn()
  {
    return amkd.yY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.FunctionSearchFragment
 * JD-Core Version:    0.7.0.1
 */